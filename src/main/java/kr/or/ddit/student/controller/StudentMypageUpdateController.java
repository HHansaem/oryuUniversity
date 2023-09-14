package kr.or.ddit.student.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.dao.OthersDAO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.vo.StudentVO;
import kr.or.ddit.validate.groups.UpdateGroup;

@Controller
public class StudentMypageUpdateController {
	
	@Inject
	private StudentService service;
	@Inject
	private OthersDAO othersDAO;
	@Inject
	private PasswordEncoder encoder;
	
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList() {
		return othersDAO.selectDepartmentList();
	}
	
	@PostMapping("/mypage/studentUpdateCheck.do")
	public String updateCheck(
		@RequestParam("who") String stCd
		, @RequestParam("password") String password
		, Model model
	){
		StudentVO student = service.retrieveStudent(stCd);
		String originPass = student.getStPass();
		
		model.addAttribute("student", student);
		
		if(encoder.matches(password, originPass)) {
			model.addAttribute("result", "일치");
		}else {
			model.addAttribute("result", "불일치");
		}
		return "jsonView";
	}
	
	@GetMapping("/mypage/studentMypageEdit.do")
	public String goStudentMypageEdit(
		@RequestParam("who") String stCd
		, Model model
	){
		StudentVO student = service.retrieveStudent(stCd);
		model.addAttribute("student", student);
		
		return "student/studentMypageEdit";
	}

	@PostMapping("/mypage/studentUpdate.do")
	public String updateProcess(
		@Validated(UpdateGroup.class) @ModelAttribute("student") StudentVO student
		, HttpSession session
		, BindingResult errors
		, Model model
	) {
		String plain = student.getStPass();
		String encoded = encoder.encode(plain);
		student.setStPass(encoded);
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyStudent(student);
			if(ServiceResult.OK == result) {
				model.addAttribute("result", "수정완료");
				session.removeAttribute("memImage");
				session.setAttribute("memImage", student.getStFic());
			}else {
				model.addAttribute("result", "수정실패");
			}
		}else {
			model.addAttribute("result", "수정실패");
		}
		return "jsonView";
	}
	
}
