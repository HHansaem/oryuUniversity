package kr.or.ddit.lectureContents.videoLecture.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lectureContents.videoLecture.service.VideoLectureService;
import kr.or.ddit.lectureContents.vo.VideoLectureVO;

@Controller
@RequestMapping("/lecture/videoLectureList.do")
public class VideoLecRetrieveController {
	@Inject
	VideoLectureService service;
	
	@GetMapping
	public String videoList(String lecCd, Model model) {
		List<VideoLectureVO> videoList = service.retreiveVideoLectureList(lecCd);
		model.addAttribute("videoList",videoList);
		return "lecture/videoLecture/videoLectureList";
		
	}
}
