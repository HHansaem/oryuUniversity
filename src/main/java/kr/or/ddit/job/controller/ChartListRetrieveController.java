package kr.or.ddit.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.net.MediaType;

import kr.or.ddit.college.dao.CollegeDAO;
import kr.or.ddit.college.vo.CollegeVO;
import kr.or.ddit.common.dao.CommonDAO;
import kr.or.ddit.department.dao.DepartmentDAO;
import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.job.service.JobService;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/job/")
public class ChartListRetrieveController {

	@Inject
	private JobService jService;
	@Inject
	private CollegeDAO collegeDAO;
	@Inject
	private DepartmentDAO departmentDAO;
	
	@ModelAttribute("collegeList")
	public List<CollegeVO> collegeList(){
		return collegeDAO.selectCollegeList();
	}
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList(){
		List<DepartmentVO> dList = departmentDAO.selectDepartmentList();
		return dList;
	}
	@GetMapping("chartList.do")
	public String chartList(
		Model model
	) {
		return "job/chartList";
	}
	
	@GetMapping("circle.do")
	public String CircleChart(
		String year,
		String colg,
		String dept,
		Model model	
	) {
		Map<String,Object> detailCondition = new HashMap<String, Object>();
		detailCondition.put("year",year);
		detailCondition.put("colg",colg);
		detailCondition.put("dept",dept);
		StudentVO student = new StudentVO();
		student.setDetailCondition(detailCondition);
        student = jService.retrieveEmpInfo(student);
        
        model.addAttribute("circle",student);
        return "jsonView";
	}

	@GetMapping("map.do")
	public String mapChart(
			String year,
			String colg,
			String dept,
			Model model	 	
	) {
		Map<String,Object> detailCondition = new HashMap<String, Object>();
		detailCondition.put("year",year);
		detailCondition.put("colg",colg);
		detailCondition.put("dept",dept);
		
		StudentVO student = new StudentVO();
		student.setDetailCondition(detailCondition);
		
		List<StudentVO> locCount = jService.retrieveEmpLoc(student);
		model.addAttribute("loc",locCount);
		log.info("11111111111111"+locCount);
		return "jsonView";
	}
	
	
}
