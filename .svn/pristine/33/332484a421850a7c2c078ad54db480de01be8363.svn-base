package kr.or.ddit.graduation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.college.vo.CollegeVO;
import kr.or.ddit.graduation.vo.GraduationVO;

@Mapper
public interface GraduationDAO {

	/**
	 * 학생이 속한 단과의 졸업이수조건종류와 그에대한 최소요구치를 가져옴
	 * @param stCd
	 * @return
	 */
	public List<GraduationVO> selectGraduationStudentList(String stCd);
	/**
	 * 학생이 속한 단과와 학과를 가져옴
	 * @param stCd
	 * @return
	 */
	public GraduationVO selectGraduationStudentBelong(String stCd);
	/**
	 * 모든 졸업이수조건의 종류를 가져옴
	 * @return
	 */
	public List<GraduationVO> selectGraduationTypeList();
	/**
	 * 모든 단대종류를 가져옴
	 * @return
	 */
	public List<CollegeVO> selectCollegeTypeList();
	/**
	 * 모든 졸업이수조건종류에 대한 최소요구치를 가져옴
	 * @return
	 */
	public List<GraduationVO> selectGraduationConditionList();
	/**
	 * 졸업요건의 종류와 최소조건 생성 시 중복확인을 위함
	 * @param geGradCondType
	 * @param colgeCd
	 * @return
	 */
	public GraduationVO selectGraduation(GraduationVO graduation);
	/**
	 * 졸업조건 수정
	 * @param graduation
	 * @return
	 */
	public int updateGraduation(GraduationVO graduation);
	/**
	 * 졸업조건 등록
	 * @param graduation
	 * @return
	 */
	public int insertGraduation(GraduationVO graduation);
	/**
	 * 졸업조건 삭제
	 * @param graduation
	 * @return
	 */
	public int deleteGraduation(String geGradCondType);
	/**
	 * 졸업요건 수정에서 단과선택시 단과에 대한 졸업요건 가져옴
	 * @param colgeCd
	 * @return
	 */
	public List<GraduationVO> selectGraduationCond(String colgeCd);
	/**
	 * 학생 졸업상태로 변경
	 * @param stCd
	 * @return
	 */
	public int graduateStudent(String stCd);
}
