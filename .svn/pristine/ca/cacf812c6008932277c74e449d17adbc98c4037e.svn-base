package kr.or.ddit.college.service;

import java.util.List;

import kr.or.ddit.college.vo.CollegeVO;
import kr.or.ddit.serviceresult.ServiceResult;


public interface CollegeService {

	/**
	 * 단대 관리 Business Logic Layer
	 *
	 */
	/**
	 * 단대 등록
	 * 
	 * @param college
	 * @return OK, FAIL
	 */
	public ServiceResult createCollege(CollegeVO college);

	/**
	 * 단대 상세 조회
	 * 
	 * @param collegeCd
	 * @return
	 * @throws PKNotFoundException 해당 단대가 없는 경우.
	 */
	public CollegeVO retrieveCollege(String collegeCd);

	/**
	 * 단대 목록 조회
	 * 
	 * @return
	 */
	public List<CollegeVO> retrieveCollegeList();

	/**
	 * 단대 수정
	 * 
	 * @param college
	 * @return OK, FAIL
	 */
	public ServiceResult modifyCollege(CollegeVO college);

	/**
	 * 단대 삭제?
	 * 
	 * @param collegeCd
	 * @return
	 */
	public ServiceResult removeCollege(String collegeCd);

}
