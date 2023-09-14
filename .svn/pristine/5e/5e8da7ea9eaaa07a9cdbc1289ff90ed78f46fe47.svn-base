package kr.or.ddit.staff.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.staff.vo.StaffVO;

@Mapper
public interface StaffDAO {

	public int insertStaff(StaffVO staff);
	public StaffVO selectStaff(String tsCd);
	public long selectTotalRecord(PaginationInfo<StaffVO> paging);
	public List<StaffVO> selectStaffList(PaginationInfo<StaffVO> paging);
	public int updateStaff(StaffVO staff);
	public int deleteStaff(String tsCd);
	
}
