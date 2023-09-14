package kr.or.ddit.academicBusinessReport.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.academicBusinessReport.vo.ABRVO;
import kr.or.ddit.common.vo.PaginationInfo;

@Mapper //mapper가 DAO와 mybatis.xml로 나뉘어 있음.  0ㅅ0 예에~
public interface ABRDAO { 
	
	
//- paging -
	/**
	 * 총 개수 조회. Pagination 적용.
	 * @param paging
	 * @return 
	 */
	public long selectTotalRecord(PaginationInfo<ABRVO> paging);

//- List select ABRVO -
	/**
	 * ABR 리스트 조회 pagination 적용
	 * @param paging
	 * @return
	 */
	public List<ABRVO> selectABRList(PaginationInfo<ABRVO> paging);
	
//- select ABRVO -	
	/**
	 * ABR단일건 조회 buReSn - 학술 사업 보고서 순번으로 조회.
	 * @param buReSn
	 * @return
	 */
	public ABRVO selectABR(String buReSn);
	
//- insert ABRVO -
	/**
	 * 
	 * @param aBRVO
	 * @return
	 */
	public int insertABR(ABRVO aBRVO);
	
//- update ABRVO	
	/**
	 * 
	 * @param aBRVO
	 * @return
	 */
	public int updateABR(ABRVO aBRVO);
	
// - update ABRVO-
	/**
	 * 
	 * @param aBRVO
	 * @return
	 */
	public int deleteABR(ABRVO aBRVO);
	
	
}

/*
 * pagingnation처리의 두가지 경우.
 * simpleCondition (직접입력검색용)
 * detailCondition (셀렉트검색용)
 */


/*

3. DAO
 Data Access Object의 약자로 DB의 data에 접근하기 위한 객체입니다. 
 일반적으로 DB에 접근하는 코드는 SQL이기 때문에 Java에서 SQL을 사용하려면 Connection을 생성하고,
  직접 쿼리문을 작성하여 Connection을 닫는 과정이 필요합니다.
 그러나 이는 번거롭고 코드의 가독성을 떨어뜨리기 때문에, 어플리케이션에서 사용할 DB로직을 객체 하나에 메서드로 구현하고,
  이를 호출하여 사용하도록 만든 것을 DAO라고 합니다.
 DAO는 오버헤드를 줄일 수 있다는 장점이 있습니다. 실제 WA(웹 어플리케이션)에 다수의 사용자가 접속하여 DB I/O이벤트가 
 많이 발생할 경우, Connection이 많이 생기며 반응속도가 느려집니다. 하지만 DAO는 오직 1개의 Connection으로 
 다수의 요청을 모두 수행하기 때문에 WA의 안정된 운영을 보장합니다.
*/