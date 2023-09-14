package kr.or.ddit.atch.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;

@Mapper
public interface AtchFileDAO {
	public AtchFileDetailVO selectAtchFileDetail(AtchFileDetailVO condition);
	public AtchFileVO selectAtchFileGroup(int atchFileId);
	
	public int insertAtchFileGroup(AtchFileVO atchFileGroup);
	
//	public int updateAtchFileGroup(int atchFileId);
	
	public int deleteAtchFileGroup(int atchFileId);
	public int deleteAtchFileDetails(int atchFileId);
}
