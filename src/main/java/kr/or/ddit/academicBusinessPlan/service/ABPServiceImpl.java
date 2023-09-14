package kr.or.ddit.academicBusinessPlan.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.academicBusinessPlan.dao.ABPDAO;
import kr.or.ddit.academicBusinessPlan.vo.ABPVO;
import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.common.vo.PaginationInfo;

@Service //Bean에 Service객체로 등록해주는 어노테이션
public class ABPServiceImpl implements ABPService {
	
//- @Inject - : @Inject는 @Autowired와 유사하게 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입한다.
	
	@Inject //aBPDAO와 타입이 일치하는 객체를 자동으로 주입!
	private ABPDAO aBPDAO; 
	
	@Inject // AtchFileService와 타입이 일치하는 객체를 자동으로 주입!
	private AtchFileService atchService;
	
//- @Value - : properties를 읽어들임. ("#{properties이름.key값}")
	
	@Value("#{appInfo.CommonAtchPath}")
	private Resource atchPath;	//파일을 IO하는 Resource interface

//- AtchFileGroup -
	
	private void processAtchFileGroup(ABPVO aBPVO) {
		MultipartFile[] aBPFiles = aBPVO.getABPFiles(); // ABPVO의 MultipartFile [] aBPFiles를 MultipartFile[] aBPFiles에 넣는다.
		if(aBPFiles==null) return; // aBPFiles의 값이 null이면 리턴.
		List<AtchFileDetailVO> detailList = new ArrayList<>(); //List 인터페이스를 상속받아 사용되고, Class이다. 특징으로는 ArrayList는 객체가 추가되어 용량을 초과하면 자동으로 부족한 크기만큼 용량이 늘어난다. 
		//AtchFileDetailVO를 타입으로 갖는 List를 detailList로 선언하고 ArrayList를 생성하여 넣어줌.
		for(MultipartFile aBPFile : aBPFiles) { //향상된 for문 배열처럼 여러 원소로 이루어진 집합의 모든 원소에 대해 특정 작업을 반복하기 위해 사용자주 사용되는 상황 1.ArrayList 원소 출력 2.배열 원소 출력
		// for(한단계아래 자료형 변수명 : 기준 배열명){문장-실행코드}이다. 즉  aBPFiles(배열) 안의 MultipartFile타입의 aBPFile의 데이터를 {}안의 실행문으로 끝까지 실행해라.
			if(aBPFile.isEmpty()) continue; //aBPFile이 비어있다면 continue;
			detailList.add( new AtchFileDetailVO(aBPFile)); //aBPFile이 비어있지 않다면 detailList에 aBPFile값을 가진 AtchFileDetailVO 생성
		}
		if(detailList.size()>0) { //detailList의 size가 0보다 클경우 aBPFile이 있는경우
			AtchFileVO fileGroup = new AtchFileVO(); //AtchFileVO()값을 AtchFileVO 타입의 fileGroup에 넣음.
			fileGroup.setDetailList(detailList); //fileGroup에는 DetailList값을 set함.
			try {
			    // atchService를 이용하여 첨부 파일 그룹을 생성하고, 생성된 첨부 파일 그룹의 ID를 저장합니다.
			    int atchFileId = atchService.createAtchFileGroup(fileGroup, atchPath);

			    // 생성된 첨부 파일 그룹의 ID를 ABPVO 객체에 설정합니다.
			    aBPVO.setAtchFileId(atchFileId);
			} catch (IOException e) {
			    // 예외가 발생하면, IOException을 래핑한 RuntimeException 예외를 발생시킵니다.
			    throw new RuntimeException(e);
				// 입출력(IO) 동작 중 예외가 발생할 수 있습니다.
				// 이 예외는 주로 파일 처리나 네트워크 동작과 관련이 있을 수 있습니다.
				// 예를 들어, 파일을 읽거나 쓸 때 파일이 존재하지 않거나 권한 문제가 발생하면 IOException이 발생할 수 있습니다.
				// 또는 네트워크 연결 중 문제가 발생하면 IOException이 발생할 수 있습니다.
				// 이러한 경우에는 RuntimeException으로 감싸서 처리하여 호출자에게 예외를 전달합니다.
			}

		}
	}
	
//- retrieve -
	
	@Override
	public List<ABPVO> retrieveABPList(PaginationInfo<ABPVO> paging) {
	    // ABPDAO를 이용하여 총 레코드 수를 조회합니다.
	    long totalRecord = aBPDAO.selectTotalRecord(paging);
	    
	    // 조회한 총 레코드 수를 PaginationInfo 객체에 설정합니다.
	    paging.setTotalRecord(totalRecord);
	    
	    // PaginationInfo 객체를 기반으로 ABP 목록을 조회하여 반환합니다.
	    return aBPDAO.selectABPList(paging);
	}


	@Override
	public ABPVO retrieveABP(String buPlSn) {
	    // 주어진 buPlSn을 이용하여 ABP정보를 조회하여 반환합니다.
	    return aBPDAO.selectABP(buPlSn);
	}

//- create -

	@Override
	public boolean createABP(ABPVO aBPVO) {
	    // 첨부 파일 그룹 처리를 수행합니다.
	    processAtchFileGroup(aBPVO);
	    
	    // 결과 값을 저장할 변수 선언
	    boolean result;
	    
	    // ABPVO를 데이터베이스에 삽입하고 삽입된 행 수를 반환합니다.
	    int cnt = aBPDAO.insertABP(aBPVO);
	    
	    // 삽입된 행 수가 0보다 크면 결과를 true로 설정하고, 그렇지 않으면 false로 설정합니다.
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    
	    // 결과 값을 반환합니다.
	    return result;
	}

//- modify -
	
	@Override
	public boolean modifyABP(ABPVO aBPVO) {
	    // 첨부 파일 그룹 처리를 수행합니다.
	    processAtchFileGroup(aBPVO);
	    
	    // 결과 값을 저장할 변수 선언
	    boolean result;
	    
	    // ABPVO를 수정하고 수정된 행 수를 반환합니다.
	    int cnt = aBPDAO.updateABP(aBPVO);
	    
	    // 수정된 행 수가 0보다 크면 결과를 true로 설정하고, 그렇지 않으면 false로 설정합니다.
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    
	    // 결과 값을 반환합니다.
	    return result;
	}

//- remove-
	
	@Override
	public boolean removeABP(ABPVO aBPVO) {
	    // 결과 값을 저장할 변수 선언
	    boolean result;
	    
	    // ABPVO를 삭제하고 삭제된 행 수를 반환합니다.
	    int cnt = aBPDAO.deleteABP(aBPVO);
	    
	    // 삭제된 행 수가 0보다 크면 결과를 true로 설정하고, 그렇지 않으면 false로 설정합니다.
	    if (cnt > 0) {
	        result = true;
	    } else {
	        result = false;
	    }
	    
	    // 결과 값을 반환합니다.
	    return result;
	}
	
//- getTotalRecordCount -
	
	@Override
	public long getTotalRecordCount(PaginationInfo<ABPVO> paging) {
	    // 주어진 페이징 정보를 이용하여 전체 레코드 수를 조회하여 반환합니다.
	    return aBPDAO.selectTotalRecord(paging);
	}


}

/*

	컨테이너의 구조 및 빈
	*컨테이너 구조
	-루트 컨테이너 : 모든 어플리케이션에서 사용 (BEAN, ViewResolverBEAN, ControllerBEAN)
	-서블릿 컨테이너 : 각 서블릿이 사용 (WAS , DispatherServlet)
	-개발자용 컨테이너 : 개발자가 임의로 생성해서 사용 (Heap Memory Develop Container)
 
 */
