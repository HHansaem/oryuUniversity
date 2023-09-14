package kr.or.ddit.academicBusinessPlan.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;

@Controller
public class ABPAtchDownloadController {
	@Inject
	private AtchFileService atchService;
	
	@RequestMapping("/academicBusinessPlan/aBPDownload.do")
	public String download(AtchFileDetailVO condition, Model model) {
		AtchFileDetailVO metadata = atchService.retrieveAtchFileDetail(condition);
		model.addAttribute("atchFile", metadata);
		return "downloadView";
	}
}
