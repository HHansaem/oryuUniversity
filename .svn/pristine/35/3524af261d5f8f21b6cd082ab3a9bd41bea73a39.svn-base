package kr.or.ddit.lectureSchedule.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.lectureSchedule.service.LectureScheduleService;
import kr.or.ddit.lectureSchedule.vo.LectureScheduleVO;

@Controller
public class lectureScheduleRetrieveController {
	
	@Inject
	private LectureScheduleService service;
	
	@PostMapping(value = "lectureSchedule/loadTable", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<LectureScheduleVO> loadTimeTable(@RequestParam("clasCd") String clasCd) {
        // 강의실 코드를 이용하여 시간표 정보를 불러옴 (lectureScheduleService 사용)
		List<LectureScheduleVO> schedule = service.retrievedLectureSchedule(clasCd);
		
		
        return schedule;
    }

}
