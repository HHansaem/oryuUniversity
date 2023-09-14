package kr.or.ddit.lectureContents.videoLecture.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.lectureContents.videoLecture.service.VideoLectureService;
import kr.or.ddit.lectureContents.vo.AssignmentVO;
import kr.or.ddit.lectureContents.vo.VideoLectureVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
@RequestMapping("/lecture/videoLectureInsert.do")
public class VideoLecInsertController {
	
	@Inject
	VideoLectureService service;
	
	@ModelAttribute("videoLecture")
	public VideoLectureVO videoLecture(String lecture,String vlsCd) {
		return new VideoLectureVO(lecture);
	}
	
	
	@GetMapping
	public String videoLecForm() {
		return "lecture/videoLecture/videoLectureForm";
	}
	
	@PostMapping
	public String videoLecInsert(@Validated(InsertGroup.class) @ModelAttribute("videoLecture") VideoLectureVO videoLecture
			, Errors errors, Model model) {
		String logicalViewName = null;
		if (!errors.hasErrors()) {
			ServiceResult result = service.registerVideoLecture(videoLecture);
			switch(result) {
				case OK:
					logicalViewName = "redirect:/lecture/videoLectureList.do?lecCd="+videoLecture.getLecCd();
					break;
				case FAIL:
					logicalViewName = "lecture/videoLecture/videoLectureForm";
				default:
					model.addAttribute("message","서버 오류, 잠시 뒤 다시 시도하시오.");
					logicalViewName = "lecture/videoLecture/videoLectureForm";
					break;
			}
		} else {
			logicalViewName = "lecture/videoLecture/videoLectureForm";
		}

		return logicalViewName;
	}
}
