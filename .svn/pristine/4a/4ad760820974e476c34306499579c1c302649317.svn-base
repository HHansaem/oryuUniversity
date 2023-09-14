package kr.or.ddit.academicBusinessReport.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.academicBusinessReport.dao.ABRDAO;
import kr.or.ddit.academicBusinessReport.vo.ABRVO;
import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.common.vo.PaginationInfo;

@Service
public class ABRServeiceImpl implements ABRService {

//-의존성 주입 -
	@Inject //의존성주입 ABRDAO
	private ABRDAO aBRDAO;
	
	@Inject //의존성주입 AtchFileService
	private AtchFileService atchService;
	
//-Value properties 연결 -
	@Value("{appInfo.commonAtchPath}") //appInfo.Properties에 있는 commonAtchPath Key의 Value값을 넣는다.
	private Resource atchPath;
	
//-파일첨부 구현체-------------------------------------------------------------------------------------
	
	private void processAtchFileGroup(ABRVO aBRVO) { //ABRVO를 매개변수로 받은 processAtchFileGroup
		MultipartFile[] aBRFiles = aBRVO.getABRFiles();
		if(aBRFiles == null) return ;
		List<AtchFileDetailVO> detailList = new ArrayList<>();
		for(MultipartFile aBRFile : aBRFiles) {
			if(aBRFile.isEmpty())
				continue;
			detailList.add(new AtchFileDetailVO(aBRFile));
		}
		if (detailList.size() >0) {
			AtchFileVO fileGroup = new AtchFileVO();
			fileGroup.setDetailList(detailList);
			try {
				int atchFileId = atchService.createAtchFileGroup(fileGroup, atchPath);
				aBRVO.setAtchFileId(atchFileId);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
//-조회구현체------------------------------------------------------------------------------------------------
	
	@Override // ABR 리스트 목록 조회
	public List<ABRVO> retrieveABRList(PaginationInfo<ABRVO> paging) {
		long totalRecord = aBRDAO.selectTotalRecord(paging); // 
		
		paging.setTotalRecord(totalRecord);
		
		return aBRDAO.selectABRList(paging);
	}

	@Override //ABR 단건 조회
	public ABRVO retrieveABR(String buReSn) {
		
		return aBRDAO.selectABR(buReSn);
	}
	
//-ABR생성 구현체------------------------------------------------------------------------------------------------
	
	@Override
	public boolean createABR(ABRVO aBRVO) {
		processAtchFileGroup(aBRVO);
		boolean result;
		int cnt = aBRDAO.insertABR(aBRVO);
		if (cnt > 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
//-ABR수정 구현체--------------------------------------------------------------------------------------
	
	@Override
	public boolean modifyABR(ABRVO aBRVO) {
		processAtchFileGroup(aBRVO);
		boolean result;
		int cnt = aBRDAO.updateABR(aBRVO);
		if (cnt > 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
//-ABR삭제 구현체--------------------------------------------------------------------------------------
	
	@Override
	public boolean removeABR(ABRVO aBRVO) {
		boolean result;
		int cnt = aBRDAO.deleteABR(aBRVO);
		if (cnt > 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
//-ABR페이징구현체--------------------------------------------------------------------------------------
	
	@Override
	public long getTotalRecordCount(PaginationInfo<ABRVO> paging) {
		
		return aBRDAO.selectTotalRecord(paging);
	}

}

/* -----------------------------------------------------------------------------------------
 * Service 는 인터페이스 ServiceImple은 구현체다. 이 둘을 나눔/분리함으로써 구현체를 독립적으로 확장할 수 있으며
 * 구현체 클래스를 변경하거나 확장을 해도 클라이언트의 코드에 영향을 주지 않도록 하기 위함이다.
 * OCP원칙 다형성의 원칙을 가장 잘 실현해주는 설계 방식이다.
 * OCP (Open Closed Principle)
 * 개방, 폐쇄 원칙이라고 하며 '소프트웨어 개체(클래스, 모듈, 함수 등)는 확장에 대해 열려 있어야 하고, 
 * 수정에 대해서는 닫혀 있어야 한다.'는 프로그래밍 원칙입니다.
 * -----------------------------------------------------------------------------------------
 * 의존성이란
 * 어떤 객체가 생성되기 위해 다른 객체가 꼭 필요한 상태를 의미합니다.
 * 의존성은 new 연산자를 통해 발생합니다. 의존성이 높아지면 결합도 또한 높아집니다. 
 * 결합도가 높으면 해당 클래스를 수정할 경우 참조하고 있는 다른 클래스도 함께 이해해야합니다.  
 * 왜냐하면 무작정 수정했다가는 사이드 이펙트가 발생할 수 있기 때문입니다.
 * 그리고 결합도가 높은 클래스는 재사용하기 힘듭니다. 
 * -----------------------------------------------------------------------------------------
*/ 