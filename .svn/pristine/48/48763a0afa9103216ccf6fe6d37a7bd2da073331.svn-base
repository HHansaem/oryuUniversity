package kr.or.ddit.lecture.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.college.dao.CollegeDAO;
import kr.or.ddit.college.vo.CollegeVO;
import kr.or.ddit.common.dao.CommonDAO;
import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.common.vo.ClassRoomVO;
import kr.or.ddit.common.vo.DaytimeScheduleVO;
import kr.or.ddit.department.dao.DepartmentDAO;
import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.lecture.service.LectureService;
import kr.or.ddit.lecture.vo.LectureVO;
import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.subject.dao.SubjectDAO;
import kr.or.ddit.subject.vo.SubjectVO;

@Controller
@RequestMapping("/lecture")
public class LectureManagementController {
	
	@Inject
	private LectureService service;
	
	@ModelAttribute("lecture")
	public LectureVO lecture() {
		return new LectureVO();
	}
	
	@Inject 
	private DepartmentDAO departmentDAO;
	@Inject
	private CollegeDAO collegeDAO;
	@Inject
	private SubjectDAO subjectDAO;
	@Inject
	private CommonDAO commonDAO;
	
	@ModelAttribute("classRoomList")
	public List<ClassRoomVO> classRoomList(){
		return commonDAO.selectClassRoomList();
	}
	
	@ModelAttribute("daytimeScheduleList")
	public List<DaytimeScheduleVO> daytimeScheduleList(){
		return commonDAO.selectDaytimeScheduleList();
	}

	@ModelAttribute("subjectList")
	public List<SubjectVO> subjectList(){
		return subjectDAO.SubjectList();
	}
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList(){
		return departmentDAO.selectDepartmentList();
	}
	@ModelAttribute("collegeList")
	public List<CollegeVO> collegeList(){
		return collegeDAO.selectCollegeList();
	}
	
	// 강의 등록(교직원) get
	@GetMapping("lectureInsert.do")
	public String lectureForm() {
		return "lecture/ajax/modal/lectureForm";
	}
	
	// 강의 등록(교직원) post
	@PostMapping(value = "lectureInsert.do", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> lectureInsert(
			@RequestParam("subjCd") String subjCd,
            @RequestParam("prCd") String prCd,
            @RequestParam("lecLectTitle") String lecLectTitle,
            @RequestParam("lecGraCd") String lecGraCd,
            @RequestParam("lecSemeCd") String lecSemeCd,
            @RequestParam("lecLectCred") String lecLectCred,
            @RequestParam("lecEnroLimit") String lecEnroLimit,
            @RequestParam("lecLectDivision") String lecLectDivision,
            @RequestParam("grMid") String grMid,
            @RequestParam("grFinal") String grFinal,
            @RequestParam("grAttend") String grAttend,
            @RequestParam("grAssi") String grAssi,
            @RequestParam("lectureFiles") MultipartFile[] lectureFiles
    ) {
	   LectureVO lecture = new LectureVO();
	   lecture.setSubjCd(subjCd);
	   lecture.setPrCd(prCd);
	   lecture.setLecLectTitle(lecLectTitle);
	   lecture.setLecGraCd(lecGraCd);
	   lecture.setLecSemeCd(lecSemeCd);
	   lecture.setLecLectCred(lecLectCred);
	   lecture.setLecEnroLimit(lecEnroLimit);
	   lecture.setLecLectDivision(lecLectDivision);
	   lecture.setGrMid(Integer.parseInt(grMid));
	   lecture.setGrFinal(Integer.parseInt(grFinal));
	   lecture.setGrAttend(Integer.parseInt(grAttend));
	   lecture.setGrAssi(Integer.parseInt(grAssi));
	   lecture.setLectureFiles(lectureFiles);
	   
	   ServiceResult result = service.createLecture(lecture);
	   
	   String responseMessage;
	    if (ServiceResult.OK == result) {
	        responseMessage = lecLectTitle+"강의 등록 완료";
	    } else {
	        responseMessage = lecLectTitle+"강의 등록 실패";
	    }

	    return ResponseEntity.ok(responseMessage);
	}
	
	// 강의 수정 (교직원) get
	@GetMapping("lectureUpdate.do")
	public String updateForm(
		@RequestParam String lecCd
		, Model model	
	) {
		LectureVO lecture = service.retrieveLecture(lecCd);
		model.addAttribute("lecture",lecture);
		return "lecture/ajax/modal/lectureForm";
	}
	
	// 강의 수정 (교직원) post
	@PostMapping(value = "lectureUpdate.do", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> lectureUpdate(
			@RequestParam("lecCd") String lecCd,
			@RequestParam("subjCd") String subjCd,
            @RequestParam("prCd") String prCd,
            @RequestParam("lecLectTitle") String lecLectTitle,
            @RequestParam("lecGraCd") String lecGraCd,
            @RequestParam("lecSemeCd") String lecSemeCd,
            @RequestParam("lecLectCred") String lecLectCred,
            @RequestParam("lecEnroLimit") String lecEnroLimit,
            @RequestParam("lecLectDivision") String lecLectDivision,
            @RequestParam("grMid") String grMid,
            @RequestParam("grFinal") String grFinal,
            @RequestParam("grAttend") String grAttend,
            @RequestParam("grAssi") String grAssi,
            @RequestParam("lectureFiles") MultipartFile[] lectureFiles
    ) {
	   LectureVO lecture = new LectureVO();
	   lecture.setLecCd(lecCd);
	   lecture.setSubjCd(subjCd);
	   lecture.setPrCd(prCd);
	   lecture.setLecLectTitle(lecLectTitle);
	   lecture.setLecGraCd(lecGraCd);
	   lecture.setLecSemeCd(lecSemeCd);
	   lecture.setLecLectCred(lecLectCred);
	   lecture.setLecEnroLimit(lecEnroLimit);
	   lecture.setLecLectDivision(lecLectDivision);
	   lecture.setGrMid(Integer.parseInt(grMid));
	   lecture.setGrFinal(Integer.parseInt(grFinal));
	   lecture.setGrAttend(Integer.parseInt(grAttend));
	   lecture.setGrAssi(Integer.parseInt(grAssi));
	   lecture.setLectureFiles(lectureFiles);
	   
	   ServiceResult result = service.modifyLecture(lecture);
	   
	   String responseMessage;
	    if (ServiceResult.OK == result) {
	        responseMessage = lecLectTitle+"강의 수정 완료";
	    } else {
	        responseMessage = lecLectTitle+"강의 수정 실패";
	    }

	    return ResponseEntity.ok(responseMessage);
	}

	// 강의 요청(교수) get
	@GetMapping("lectureRequest.do")
	public String requestForm(
		@RequestParam String prCd,
		Model model
	) {
		DepartmentVO prof = commonDAO.profInfo(prCd);
		String dtCd = prof.getDtCd();
		List<SubjectVO> subjectList = commonDAO.subjectList(dtCd); 
		model.addAttribute("subjectList2",subjectList);
		model.addAttribute("prof",prof);
		return "lecture/ajax/modal/lectureForm2";
	}
	// 강의 수정(교수) get
	@GetMapping("lectureFix.do")
	public String fixForm(
		@RequestParam String prCd,
		@RequestParam String lecCd,
		Model model
	) {
		DepartmentVO prof = commonDAO.profInfo(prCd);
		String dtCd = prof.getDtCd();
		List<SubjectVO> subjectList = commonDAO.subjectList(dtCd); 
		LectureVO lecture = service.retrieveLecture(lecCd);
		model.addAttribute("lecture",lecture);
		model.addAttribute("subjectList2",subjectList);
		model.addAttribute("prof",prof);
		return "lecture/ajax/modal/lectureForm2";
	}
	// 강의 요청(교수) post
	@PostMapping(value = "lectureRequest.do", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> lectureRequest(
			@RequestParam("subjCd") String subjCd,
            @RequestParam("prCd") String prCd,
            @RequestParam("lecLectTitle") String lecLectTitle,
            @RequestParam("lecGraCd") String lecGraCd,
            @RequestParam("lecSemeCd") String lecSemeCd,
            @RequestParam("lecLectCred") String lecLectCred,
            @RequestParam("lecEnroLimit") String lecEnroLimit,
            @RequestParam("lecLectDivision") String lecLectDivision,
            @RequestParam("grMid") String grMid,
            @RequestParam("grFinal") String grFinal,
            @RequestParam("grAttend") String grAttend,
            @RequestParam("grAssi") String grAssi,
            @RequestParam("lectureFiles") MultipartFile[] lectureFiles
    ) {
	   LectureVO lecture = new LectureVO();
	   lecture.setSubjCd(subjCd);
	   lecture.setPrCd(prCd);
	   lecture.setLecLectTitle(lecLectTitle);
	   lecture.setLecGraCd(lecGraCd);
	   lecture.setLecSemeCd(lecSemeCd);
	   lecture.setLecLectCred(lecLectCred);
	   lecture.setLecEnroLimit(lecEnroLimit);
	   lecture.setLecLectDivision(lecLectDivision);
	   lecture.setGrMid(Integer.parseInt(grMid));
	   lecture.setGrFinal(Integer.parseInt(grFinal));
	   lecture.setGrAttend(Integer.parseInt(grAttend));
	   lecture.setGrAssi(Integer.parseInt(grAssi));
	   lecture.setLectureFiles(lectureFiles);
	   
	   ServiceResult result = service.submitLecture(lecture);
	   
	    String responseMessage;
	    if (ServiceResult.OK == result) {
	        responseMessage = lecLectTitle+"강의 요청 완료";
	    } else {
	        responseMessage = lecLectTitle+"강의 요청 실패";
	    }
	    
	    return ResponseEntity.ok(responseMessage);
	}

	// 강의 요청 수락(교직원) ->3
	@PostMapping("allowLecture.do")
	@ResponseBody
	public String allowLecture(
			String[] lecCd
	) {
		int cnt = 0;
		String result = null;
		for(String cd : lecCd) {
			LectureVO lecture = service.retrieveLecture(cd);
			cnt += service.allowLecture(lecture);
		}
		System.out.println(cnt);
		if(cnt==lecCd.length) {
			result="success";
		}else {
			result="fail";
		}
		return result;
	}
	// 강의 요청 거절(교직원) ->5
	@PostMapping("refuseLecture.do")
	@ResponseBody
	public String refuseLecture(
			String[] lecCd
	) {
		int cnt = 0;
		String result = null;
		for(String cd : lecCd) {
			LectureVO lecture = service.retrieveLecture(cd);
			cnt += service.rejectLecture(lecture);
		}
		if(cnt==lecCd.length) {
			result="success";
		}else {
			result="fail";
		}
		return result;
	}
	// 수강 등록 완료(교직원) ->1
	@PostMapping("commitEnrollment.do")
	@ResponseBody
	public String commitEnrollment(
			String[] lecCd
	) {
		int cnt = 0;
		String result = null;
		for(String cd : lecCd) {
			LectureVO lecture = service.retrieveLecture(cd);
			cnt += service.commitEnrollment(lecture);
		}
		if(cnt==lecCd.length) {
			result="success";
		}else {
			result="fail";
		}
		return result;
	}
	// 휴강 등록 완료(교직원) ->2
	@PostMapping("standEnrollment.do")
	@ResponseBody
	public String standEnrollment(
			String[] lecCd
	) {
		int cnt = 0;
		String result = null;
		for(String cd : lecCd) {
			LectureVO lecture = service.retrieveLecture(cd);
			cnt += service.stateEnrollment(lecture);
		}
		if(cnt==lecCd.length) {
			result="success";
		}else {
			result="fail";
		}
		return result;
	}
	
	@GetMapping("getProfList.do")
	@ResponseBody
	public ResponseEntity<List<ProfessorVO>> getProfList(
			@RequestParam String dtCd	
	){
		List<ProfessorVO> profList = commonDAO.selectProfList(dtCd);
		return ResponseEntity.ok(profList);
	}
	
}
