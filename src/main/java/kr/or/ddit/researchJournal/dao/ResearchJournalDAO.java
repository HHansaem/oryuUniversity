package kr.or.ddit.researchJournal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.researchJournal.vo.ResearchJournalVO;

@Mapper
public interface ResearchJournalDAO {

	//패이징처리
	public long selectTotalRecord(PaginationInfo<ResearchJournalVO> paging);
	
	// rjsn으로 단일검색.
	public ResearchJournalVO selectResearchJournal(int rjsn);
	
	//researchJournalvo 의 전체 리스트 조회.
	public List<ResearchJournalVO> selectResearchJournalList(PaginationInfo<ResearchJournalVO> paging);
	
	//rjvo에서 등록!하기.
	public int insertResearchJournal(ResearchJournalVO researchJournal);
	
	//rjvo에서 수정하기.
	public int updateResearchJournal(ResearchJournalVO researchJournal);
	
	//rjvo에서 삭제하기
	public int deleteResarchJournal(String	rjSn);
	
}
