package kr.or.ddit.lectureContents.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.lectureContents.vo.ExamViewVO;

@Mapper
public interface ExamViewDAO {
	//시험문제 보기 등록
	public int InsertExamView(List<ExamViewVO> examViewList);
}
