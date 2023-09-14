package kr.or.ddit.lectureContents.attendance.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lecture.service.LectureService;
import kr.or.ddit.lectureContents.attendance.service.AttendanceService;
import kr.or.ddit.lectureContents.vo.AttendanceStateVO;
import kr.or.ddit.lectureContents.vo.AttendanceVO;
import kr.or.ddit.lectureSchedule.service.LectureScheduleService;
import kr.or.ddit.lectureSchedule.vo.LectureScheduleVO;

@Controller
@RequestMapping("/lecture")
public class AttendanceRetreiveController {
	
	@Inject
	AttendanceService atService;
	@Inject
	LectureScheduleService lecScheService;
	
	@GetMapping
	@RequestMapping("/AttendanceView.do")
	public String getAttendance(Authentication authentication,String lecCd, Model model) {
		String role = "";
		String memId = "";
		List<Integer> weekCnt = new ArrayList<>();
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			memId = userDetails.getUsername();
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			for (GrantedAuthority authority : authorities) {
				 role = authority.getAuthority();
			}
		}
		if(role.equals("ROLE_ST")) {
			AttendanceVO attendance = new AttendanceVO(lecCd,memId);
			List<LectureScheduleVO> lectureSchedule = lecScheService.retrieveLectureScheduleDetail(lecCd);
			AttendanceVO stAttendance = atService.retrieveStAttendanceList(attendance);
			model.addAttribute("lectureSchedule", lectureSchedule);
			model.addAttribute("attendance", stAttendance);
			return "lecture/attendance/attendanceStView";
		}else {
			String scheCd = "";
			String week = "1";
			if(!StringUtils.isBlank(lecCd)) {
				List<LectureScheduleVO> schedule = lecScheService.retrieveLectureScheduleDetail(lecCd);
				scheCd = schedule.get(0).getScheCd();
			}
			AttendanceVO attendance =  new AttendanceVO();
			attendance.setLecCd(lecCd);
			attendance.setAttsSche(scheCd);
			attendance.setAttsWeek(week);
			List<AttendanceVO> attendanceList = atService.retrieveAttendanceList(attendance);
			model.addAttribute("attendance", attendanceList);
			return "lecture/attendance/attendanceView";
		}
		
	}
	
	@GetMapping
	@RequestMapping("/AttendanceList.do")
	public String getAttendanceList(String lecCd, String attsSche, String attsWeek, Model model) {
		String scheCd = "";
		AttendanceVO attendance =  new AttendanceVO();
		attendance.setLecCd(lecCd);
		
		if(!StringUtils.isBlank(lecCd)) {
			List<LectureScheduleVO> lectureSchedule = lecScheService.retrieveLectureScheduleDetail(lecCd);
			scheCd = lectureSchedule.get(0).getScheCd();
			model.addAttribute("lectureSchedule", lectureSchedule);
		}
		if(StringUtils.isBlank(attsSche)) {
			attendance.setAttsSche(scheCd);
			attendance.setAttsWeek("1");
		}else {
			attendance.setAttsSche(attsSche);
			attendance.setAttsWeek(attsWeek);
		}
		List<AttendanceVO> attendanceList = atService.retrieveAttendanceList(attendance);
		model.addAttribute("attendanceList", attendanceList);
		model.addAttribute("attsSche",attsSche);
		model.addAttribute("attsWeek",attsWeek);
		
		return "lecture/attendance/ajax/attendanceList";
	}
	
}
