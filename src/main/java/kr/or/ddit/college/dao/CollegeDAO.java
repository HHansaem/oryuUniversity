package kr.or.ddit.college.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.college.vo.CollegeVO;

@Mapper
public interface CollegeDAO {

	/**
	 * 단대 등록
	 */
	public int insertCollege(CollegeVO college);
	
	/**
	 *  단대 상세 조회
	 */
//	public CollegeVO selectCollege(String colgeCd) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	/**
	 * 단대 목록조회
	 * @return
	 */
	public List<CollegeVO> selectCollegeList();
		// TODO Auto-generated method stub

	
	/**
	 *  단대 수정
	 */
	public int updateCollege(CollegeVO college);
	
	/**
	 *  단대 삭제
	 */
	public int deleteCollege(String colgeCd);
	
}
