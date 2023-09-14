package kr.or.ddit.lectureContents.attendance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.lectureContents.attendance.service.AttendanceService;
import kr.or.ddit.lectureContents.vo.AttendanceStateVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
@RequestMapping("/lecture/AttendanceInsert.do")
public class AttendanceInsertController {
	
	@Inject
	AttendanceService atService;
	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> saveAttendance(@RequestBody ArrayList<AttendanceStateVO> attendanceStateList) {
		Map<String, Object> respMap = new HashMap<>();
		ServiceResult result = atService.registerAttendance(attendanceStateList);
		switch(result) {
		case OK:
			respMap.put("result", "성공");
			break;
		case FAIL:
			respMap.put("result", "실패");
			break;
		default:
			respMap.put("result", "에러");
			break;
		}
		
		return ResponseEntity.ok(respMap);
	}
}
