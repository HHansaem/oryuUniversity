package kr.or.ddit.acBuDoc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.acBuDoc.dao.AcBuDocDAO;
import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.acBuDoc.vo.DocumentSummaryVO;
import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.common.vo.PaginationInfo;

@Service
public class AcBuDocServiceImpl implements AcBuDocService{

//--- inject ---
	@Inject
	private AcBuDocDAO acBuDocDAO;
	
	@Inject
	private AtchFileService atchService;
	
//--- value ---	
	
	@Value("#{appInfo.CommonAtchPath}")
	private Resource atchPath;

// processAtchFileGroup ---
	
	private void processAtchFileGroup(AcBuDocVO acBuDocVO) {
		MultipartFile[] acBuDocFiles = acBuDocVO.getAcBuDocFiles(); 
		if(acBuDocFiles==null) return;
		List<AtchFileDetailVO> detailList = new ArrayList<>(); 
		for(MultipartFile acBuDocFile : acBuDocFiles) {
			if(acBuDocFile.isEmpty()) continue; 
			detailList.add( new AtchFileDetailVO(acBuDocFile)); 
		}
		if(detailList.size()>0) { 
			AtchFileVO fileGroup = new AtchFileVO();
			fileGroup.setDetailList(detailList); 
			try {
			    int atchFileId = atchService.createAtchFileGroup(fileGroup, atchPath);
			    acBuDocVO.setAtchFileId(atchFileId);
			} catch (IOException e) {
			    throw new RuntimeException(e);
			}
		}
	}
	
//--- override ---
	
//--- retrieve ---
	@Override
	public List<AcBuDocVO> retrieveAcBuDocList(PaginationInfo<AcBuDocVO> paging) {
		long totalRecord = acBuDocDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return acBuDocDAO.selectAcBuDocList(paging);
	}

	@Override
	public AcBuDocVO retrieveAcBuDoc(String buDocCd) {
		return acBuDocDAO.selectAcBuDoc(buDocCd);
	}
	
//--- create ---

	@Override
	public boolean createAcBuDoc(AcBuDocVO acBuDocVO) {
		processAtchFileGroup(acBuDocVO);
		boolean result;
		int cnt = acBuDocDAO.insertAcBuDoc(acBuDocVO);
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    return result;
	}

//--- modify ---
	
	@Override
	public boolean modifyAcBuDoc(AcBuDocVO acBuDocVO) {
	    processAtchFileGroup(acBuDocVO);
	    boolean result;
	    int cnt = acBuDocDAO.updateAcBuDoc(acBuDocVO);
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    return result;
	}

//--- remove ---
	
	@Override
	public boolean removeAcBuDoc(AcBuDocVO acBuDocVO) {
	    boolean result;
	    int cnt = acBuDocDAO.deleteAcBuDoc(acBuDocVO);
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    return result;
	}

//--- getTotalRecordCount ---
	
	@Override
	public long getTotalRecordCount(PaginationInfo<AcBuDocVO> paging) {
	    return acBuDocDAO.selectTotalRecord(paging);
	}
//--- DocumentSummaries() ---
/*
	@Override
	public List<DocumentSummaryVO> getDocumentSummaries(DocumentSummaryVO documentSummaryVO) {
	    // documentSummaries 데이터를 조회하고 처리하는 로직을 구현하세요.
	    List<AcBuDocVO> acBuDocList = acBuDocDAO.selectDocumentSummaries(documentSummaryVO);

	    List<DocumentSummaryVO> documentSummaries = new ArrayList<>();
	    // 데이터를 가공하여 documentSummaries 목록을 채우세요
	    for (AcBuDocVO acBuDoc : acBuDocList) {
	        DocumentSummaryVO documentSummary = new DocumentSummaryVO(acBuDoc.getYear(), acBuDoc.getTotalDocuments());
	        // 필요한 데이터를 acBuDoc에서 documentSummary로 매핑하세요
	        // 예시: documentSummary.setTitle(acBuDoc.getBuDocNm());
	        // 필요한 추가 필드를 채우세요
	        documentSummaries.add(documentSummary);
	    }
	    return documentSummaries;
	}
*/

	@Override
	public List<DocumentSummaryVO> getDocumentSummaries() {
		return acBuDocDAO.selectDocumentSummaries();
	}

	@Override
	public List<DocumentSummaryVO> getRank() {
		return acBuDocDAO.selectRank();
	}

	@Override
	public List<AcBuDocVO> retrieveAcBuDocEvNmList(PaginationInfo<AcBuDocVO> paging) {
		return acBuDocDAO.selectAcBuDocEvNmList(paging);
	}

	@Override
	public AcBuDocVO retrieveBuDocEvNm(String buDocEvNm) {
		return acBuDocDAO.selectAcBuDocEvNm(buDocEvNm);
	}

}
