package kr.or.ddit.academicBusinessPlan.service;

import java.util.List;

import kr.or.ddit.academicBusinessPlan.vo.ABPVO;
import kr.or.ddit.common.vo.PaginationInfo;

public interface ABPService {
	
//- retrieve -
	
	public List<ABPVO> retrieveABPList(PaginationInfo<ABPVO> paging); //페이징처리된 ABPVO를 retrieveABPList 객체에 List<ABPVO> 타입으로 담는다.
	
	public ABPVO retrieveABP(String buPlSn); // String buPlSn 학술사업계획순번을 매개변수로 받아 ABPVO타입의 retrieveABP에 담는다.
	
//- create -
	
	public boolean createABP(ABPVO aBPVO); // ABPVO의 aBPVO를 매개변수로 받아 boolean타입 0 -> false 1이상 ->true defalut값 false로 반환하는 createABP를 선언
	
//- modify -	

	public boolean modifyABP(ABPVO aBPVO); // ABPVO의 aBPVO를 매개변수로 받아 boolean타입 0 -> false 1이상 ->true defalut값 false로 반환하는 modifyABP를 선언
	
//- remove -
	
	public boolean removeABP(ABPVO aBPVO); // ABPVO의 aBPVO를 매개변수로 받아 boolean타입 0 -> false 1이상 ->true defalut값 false로 반환하는 removeABP를 선언
	
//- TotalRecordCount -
	
	public long getTotalRecordCount(PaginationInfo<ABPVO> paging); // 페이징처리된 ABPVO를 반환하는 paging 객체를 매개변수로 하는 long타입의 getTotalRecordCount를 선언.
	
}

/*
리스트(List)란?
리스트(List)란 저장된 요소들의 순서가 있고 데이터에 중복이 가능하고 인덱스(index) 번호에 의해서 정렬됩니다. 
(배열과 비슷한 동작을 합니다.)

리스트(List)의 특징
리스트(List)는 컬렉션(Collection) 인터페이스 중 하나이다.
리스트(List)는 두 개의 종류로 나눠진다.
ArrayList -> 배열로 이루어진 리스트(List)
LinkedList
리스트(List)는 크기 조절이 가능하다.
리스트(List)는 초기 크기를 지정하지 않아도 된다.
리스트(List)에 삭제는 공간을 지우는 것이다.
리스트(List)에 주요 기능
삽입: List.add(값);
중간 삽입: List.add(index, value); : index: 중간에 넣을 인덱스(배열 인덱스), value: 중간에 넣을 값. (중간에 값을 넣을 경우 중간에 넣은 값 이후에 값들은 한 칸씩 밀리게 됩니다.
치환: List.set(index, value); : 중간 삽입과 비슷하게 index는 치환할 값 자리에 인덱스이고 value는 치환할 자리에 값이다.
삭제: List.remove(index); : 인덱스 위치에 있는 값을 삭제한다.
전체 삭제: List.clear(); 모든 요소를 삭제
출력: List.get(index) : 인덱스 위치에 있는 값을 출력
사이즈: List.size() : 리스트에 크기를 알 수 있다.
*/