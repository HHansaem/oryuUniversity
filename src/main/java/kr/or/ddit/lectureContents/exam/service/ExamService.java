package kr.or.ddit.lectureContents.exam.service;

import java.util.List;

import kr.or.ddit.lectureContents.vo.ExamQuestionVO;
import kr.or.ddit.lectureContents.vo.ExamVO;
import kr.or.ddit.serviceresult.ServiceResult;

public interface ExamService {
	// 시험 목록 조회
	public List<ExamVO> retrieveExamList(String lecCd);
	// 시험 세부사항 등록
	public ServiceResult registerExam(ExamVO exam);
	// 시험문제 등록
	public ServiceResult registerExamQue(ExamQuestionVO examQue);
	// 시험 세부사항 수정
	public ServiceResult modifyExam(ExamVO exam);
	// 시험문제 수정
	public ServiceResult modifyExamQue(ExamQuestionVO examQue);
	// 시험문제 조회
	public List<ExamQuestionVO> retrieveExamQuestionList(String examCd);
	//시험문제 삭제
	public ServiceResult removeExamQuestion(ExamQuestionVO examQue);
	//시험문제 번호 감소
	public ServiceResult reduceExamQuestionNum(ExamQuestionVO examQue);
	//시험 세부사항 조회
	public ExamVO retrieveExamDetail(String examCd);
	//시험 문제 전체 등록
	public ServiceResult registerAllExamQue(List<ExamQuestionVO> examQueList);
	//시험 상태 활성화
	public ServiceResult modifyExamState(ExamVO exam);
	//시험문제 조회
	public ExamVO retrieveTakeExam(String examCd);

}
