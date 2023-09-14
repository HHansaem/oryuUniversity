package kr.or.ddit.lectureContents.zoom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zoom")
public class zoomController {
	
	
	@GetMapping("/startZoom")
	public String startingZoom() {
		return "zoom/CDN/index";
	}
	
	
	@GetMapping("/meetingZoom")
	public String meetingZoom() {
		return "zoom/CDN/meeting";
	}
	
	@GetMapping("/externalZoom")
	public String externalZoom() {
		return "zoom/CDN/externalLinkPage";
	}
	
}
