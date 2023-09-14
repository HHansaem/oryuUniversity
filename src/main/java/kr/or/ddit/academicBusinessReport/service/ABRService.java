package kr.or.ddit.academicBusinessReport.service;

import java.util.List;

import kr.or.ddit.academicBusinessReport.vo.ABRVO;
import kr.or.ddit.common.vo.PaginationInfo;

public interface ABRService {
/*
 * ----------------------------------조회-------------------------------------------------
 */
	// 리스트목록을 조회, 페이징!
	public List<ABRVO> retrieveABRList(PaginationInfo<ABRVO> paging);
	
	//buReSn을 통한 단일조회!
	public ABRVO retrieveABR(String buReSn); //사업보고서순번을 받아 조회
	
/*
 * ----------------------------------등록, 수정, 삭제-------------------------------------------------
*/
	//등록하는데 사용! boolean 값!
	public boolean createABR(ABRVO aBRVO);
	
	//수정하는데 사용! boolean 값!
	public boolean modifyABR(ABRVO aBRVO);
	
	//삭제하는데 사용! boolean 값!
	public boolean removeABR(ABRVO aBRVO);
	
/*
 * ----------------------------------전체페이지,페이징-------------------------------------------------
*/
	public long getTotalRecordCount(PaginationInfo<ABRVO> paging);
	
}



/*
2. Service 설명 
사용자의 요청(request)에 대해 어떤 처리를 할지 결정하는 파트입니다. 즉, Controller가 받은 요청에 대해 알맞는 정보를 
가공해서 다시 Controller에게 데이터를 넘기는 것을 의미합니다.
주의할 점은 실제 비즈니스 로직은 Service에서 수행하지 않습니다. API에서 발생하는 트랙잭션과 Domain의 순서 보장의 
역할을 갖고 있으며, 실제 로직은 Domain 패키지에서 수행됩니다.
@Service
Service의 역할을 수행한다고 명시해주는 어노테이션.
*/