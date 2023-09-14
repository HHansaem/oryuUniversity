package kr.or.ddit.researchJournal.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.researchJournal.dao.ResearchJournalDAO;
import kr.or.ddit.researchJournal.vo.ResearchJournalVO;
import kr.or.ddit.serviceresult.ServiceResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResearchJournalServiceImpl implements ResearchJournalService {

	@Inject
	private ResearchJournalDAO researchJournalDAO;
	
	@Inject
	private AtchFileService atchService;
	
	@Value("#{appInfo.CommonAtchPath}")
	private Resource rjPath;
	
	public void init() {
		log.info("researchJournalSaveRes 파일 저장 경로 : {}", rjPath);
	}
	
	private void processResearchJournalFileGroup(ResearchJournalVO researchJournal) {
		MultipartFile[] rjFiles = researchJournal.getRjFiles();
		if(rjFiles == null) return;
		List<AtchFileDetailVO> detailList = new ArrayList<>();
		for(MultipartFile rjFile : rjFiles) {
			if(rjFile.isEmpty()) continue;
			detailList.add(new AtchFileDetailVO(rjFile));
		}
		if(detailList.size()>0) {
			AtchFileVO fileGroup = new AtchFileVO();
			fileGroup.setDetailList(detailList);
			try {
				int atchFileId = atchService.createAtchFileGroup(fileGroup, rjPath);
				researchJournal.setAtchFileId(atchFileId);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
	}

		
		
	@Override
	public ServiceResult createResearchJournal(ResearchJournalVO researchJournal) {
		ServiceResult result = null;
		int cnt = researchJournalDAO.insertResearchJournal(researchJournal);
		if(cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}
	

	@Override
	public ResearchJournalVO retrieveResearchJournal(int rjsn) {
		ResearchJournalVO researchJournal = researchJournalDAO.selectResearchJournal(rjsn);
		return researchJournal;
		
	}

	@Override
	public List<ResearchJournalVO> retrieveResearchJournalList(PaginationInfo<ResearchJournalVO> paging) {
		long totalRecord = researchJournalDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return researchJournalDAO.selectResearchJournalList(paging);
		
	}

	@Override
	public ServiceResult modifyResearchJournal(ResearchJournalVO researchJournal) {
		ServiceResult result = null;
		int cnt = researchJournalDAO.updateResearchJournal(researchJournal);
		if(cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ServiceResult removeResearchJournal(String rjSn) {
		ServiceResult result = null;
		int cnt = researchJournalDAO.deleteResarchJournal(rjSn);
		
		result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;

	}
}
