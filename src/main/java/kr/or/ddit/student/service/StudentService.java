package kr.or.ddit.student.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.vo.StudentVO;

public interface StudentService {

	/**
	 *  학생등록
	 */
	public ServiceResult createStudent(StudentVO student);
	
	/**
	 *  학생상세조회
	 */
	public StudentVO retrieveStudent(String stCd);
	/**
	 *  학생리스트조회
	 */
	public List<StudentVO> retrieveStudentList(PaginationInfo<StudentVO> paging);
	/**
	 *  학생리스트조회(ASC)
	 */
	public List<StudentVO> retrieveStudentListAsc(PaginationInfo<StudentVO> paging);
	/**
	 *  학생정보수정
	 */
	public ServiceResult modifyStudent(StudentVO student);
	
	/**
	 *  학생 탈퇴상태로 변경
	 */
	public ServiceResult removeStudent(String stCd);
	
	/**
	 * 취업자 미취업자 검색
	 * @param paging
	 * @return
	 */
	public List<StudentVO> retrieveRatioList(PaginationInfo paging);
	/**
	 * 여러 학생 한번에 등록
	 * @param students
	 * @return
	 */
	public ServiceResult createStudents(List<StudentVO> students);
	
	/**
	 * 학생 취업현황 업데이트
	 * @param studentVO
	 * @return
	 */
	public int modifyStatus(StudentVO studentVO);
	
	/**
	 * 학생 취업현황 업데이트
	 * @param studentVO
	 * @return
	 */
	public int modifyStatusFile(List<StudentVO> studentList);
	
	/**
	 * 취업현황 차트 만들기
	 * @param student
	 * @return
	 */
	public List<StudentVO> retrieveChartList(StudentVO student);
	
}
