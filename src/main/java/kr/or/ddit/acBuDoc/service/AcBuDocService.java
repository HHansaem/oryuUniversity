package kr.or.ddit.acBuDoc.service;

import java.util.List;

import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.acBuDoc.vo.DocumentSummaryVO;
import kr.or.ddit.common.vo.PaginationInfo;

public interface AcBuDocService {
	
//--- retrieve ---
	
	public List<AcBuDocVO> retrieveAcBuDocList(PaginationInfo<AcBuDocVO> paging);
	
	public AcBuDocVO retrieveAcBuDoc(String buDocCd);
	
//--- create ---
	
	public boolean createAcBuDoc(AcBuDocVO acBuDocVO);
	
//--- modify ---
	
	public boolean modifyAcBuDoc(AcBuDocVO acBuDocVO);
	
//--- remove ---
	
	public boolean removeAcBuDoc(AcBuDocVO acBuDocVO);
	
//--- totalRecordCount ---
	
	public long getTotalRecordCount(PaginationInfo<AcBuDocVO> paging);
	
// documentSummaries 데이터를 조회하는 메서드 추가

    public List<DocumentSummaryVO> getDocumentSummaries();
    
    public List<DocumentSummaryVO> getRank();
    
// selectAcBuDocEvNmList의 데이터를 조회하는 메서드
    
    public List<AcBuDocVO> retrieveAcBuDocEvNmList(PaginationInfo<AcBuDocVO> paging);
	
    public AcBuDocVO retrieveBuDocEvNm(String buDocEvNm);
}
