package kr.or.ddit.lectureContents.examSubmission.service;

import java.util.List;

import kr.or.ddit.enrollment.vo.EnrollmentVO;
import kr.or.ddit.lectureContents.vo.ExamQuestionVO;
import kr.or.ddit.lectureContents.vo.ExamSubmitVO;
import kr.or.ddit.serviceresult.ServiceResult;

public interface ExamSubmitService {
	//학생 시험제출,답안 등록
	public ServiceResult registerExamSubmit(ExamSubmitVO examSubmit);
	//학생 시험제출 목록 조회
	public List<ExamSubmitVO> retrieveExamSubmitList(String examCd); 
	//학생 시험제출 상세조회
	public List<ExamQuestionVO> retrieveExamSubmit(ExamSubmitVO examSubmit);
	//교수 학생시험제출 채점(점수업데이트)
	public ServiceResult modifyExamSubmitScore(ExamSubmitVO examSubmit);

}
