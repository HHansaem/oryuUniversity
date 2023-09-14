package kr.or.ddit.research.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.research.dao.ResearchDAO;
import kr.or.ddit.research.vo.ResearchVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Service
public class ResearchServiceImpl implements ResearchService {
	
	//--- inject ---
	
	@Inject
	private ResearchDAO researchDAO;
	
	@Inject
	private AtchFileService atchService;

	//--- value ---
	
	@Value("#{appInfo.CommonAtchPath}")
	private Resource atchPath;

	//--- processAtchFileGroup ---
	
	private void processAtchFileGroup(ResearchVO researchVO) {
		MultipartFile[] reseFiles = researchVO.getReseFiles(); 
		if(reseFiles==null) return;
		List<AtchFileDetailVO> detailList = new ArrayList<>(); 
		for(MultipartFile reseFile : reseFiles) {
			if(reseFile.isEmpty()) continue; 
			detailList.add( new AtchFileDetailVO(reseFile)); 
		}
		if(detailList.size()>0) { 
			AtchFileVO fileGroup = new AtchFileVO();
			fileGroup.setDetailList(detailList); 
			try {
			    int atchFileId = atchService.createAtchFileGroup(fileGroup, atchPath);
			    researchVO.setAtchFileId(atchFileId);
			} catch (IOException e) {
			    throw new RuntimeException(e);
			}
		}
	}
	
	
	@Override
	public ResearchVO retrieveResearch(String reseCd) {
		return researchDAO.selectResearch(reseCd);
	}

	@Override
	public List<ResearchVO> retrieveResearchList(PaginationInfo<ResearchVO> paging) {
		long totalRecord = researchDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return researchDAO.selectResearchList(paging);
	}

	@Override
	public boolean createResearch(ResearchVO researchVO) {
		processAtchFileGroup(researchVO);
		boolean result;
		int cnt = researchDAO.insertResearch(researchVO);
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    return result;
	}


	@Override
	public boolean modifyResearch(ResearchVO researchVO) {
	    processAtchFileGroup(researchVO);
	    boolean result;
	    int cnt = researchDAO.updateResearch(researchVO);
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    return result;
	}
	@Override
	public boolean removeResearch(ResearchVO researchVO) {
	    boolean result;
	    int cnt = researchDAO.deleteResearch(researchVO);
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    return result;
	}

	@Override
	public long getTotalRecordCount(PaginationInfo<ResearchVO> paging) {
	    return researchDAO.selectTotalRecord(paging);
	}
}
