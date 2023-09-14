package kr.or.ddit.job.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.job.service.JobService;
import kr.or.ddit.job.vo.AdVO;
import kr.or.ddit.job.vo.JobVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/job")
public class JobAdInsertController {

	@Inject
	private JobService service;

	@RequestMapping("adList.do")
	public void jobAdList(@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
			@ModelAttribute("simpleCondition") SimpleCondition simpleCondition, Model model) throws IOException {
		
		// 웹 크롤링할 url 지정
		String url = "https://www.saramin.co.kr/zf_user/";

		// doc에 페이지 소스 저장
		Document doc = Jsoup.connect(url).get();

		// box_product 클래스에 있는 값들 elements에 담기
		Elements elements = doc.select(".box_product");
		for (Element element : elements) {
			AdVO adVO = new AdVO();
			// 상세페이지
			Elements aTag = element.select("a");
			String urlDetail = String.format("https://www.saramin.co.kr%s",
					aTag.attr("href").replace("https://www.saramin.co.kr", ""));
			System.out.println("urlDetail.........................." + urlDetail);
			adVO.setAdDetail(urlDetail);

			// 이미지url
			Elements img = element.select("img");
			String imgUrl = img.attr("src");
			System.out.println("imgUrl.........................." + imgUrl);
			adVO.setAdImg(imgUrl);

			// 회사명
			String title = img.attr("alt");
			System.out.println("title.........................." + title);
			adVO.setAdTitle(title);

			// 채용정보
			Elements emElement = element.select("em.product_desc");
			String jobDescription = emElement.text();
			System.out.println("Job Description: " + jobDescription);
			adVO.setAdDesc(jobDescription);
			service.createAd(adVO);
		}

	}

	@RequestMapping("adList2.do")
	public void jobAdList() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");
		options.addArguments("--no-sandbox");

		for (int i = 1; i < 18; i++) {
			String locMcd = String.format("%02d", i);
			for (int j = 1; j < 11; j++) {
				WebDriver driver = new ChromeDriver(options);

				String url = "https://www.saramin.co.kr/zf_user/jobs/list/domestic?page=" + j + "&loc_mcd=1" + locMcd
						+ "000&search_optional_item=n&search_done=y&panel_count=y&preview=y&isAjaxRequest=0&page_count=50&sort=RL&type=domestic&is_param=1&isSearchResultEmpty=1&isSectionHome=0&searchParamCount=2&tab=domestic#searchTitle";
				driver.get(url);

				String title = driver.getTitle();
				log.info("Title : {}", title);

				Document doc = Jsoup.parse(driver.getPageSource());

				Elements elements = doc.select(".box_item");
				log.info("elements size : {}", elements.size());

				for (Element boxItem : elements) {
					JobVO jobVo = new JobVO();
					// 회사명
					String jobName = boxItem.select(".col.company_nm a.str_tit, .col.company_nm span.str_tit").text();
					jobVo.setJobName(jobName);
					// 채용 제목
					String jobTitle = boxItem.select(".col.notification_info .job_tit a.str_tit").attr("title");
					jobVo.setJobTitle(jobTitle);
					// 업종 정보
					Elements sectorElements = boxItem.select(".col.notification_info .job_meta .job_sector span");
					StringBuilder sectorsBuilder = new StringBuilder();

					for (Element sectorElement : sectorElements) {
						if (sectorsBuilder.length() > 0) {
							sectorsBuilder.append(" / ");
						}
						sectorsBuilder.append(sectorElement.text());
					}
					String jobSector = sectorsBuilder.toString();
					jobVo.setJobSector(jobSector);

					// 근무지
					String jobPlace = boxItem.select(".col.recruit_info .work_place").text();
					jobVo.setJobPlace(jobPlace);

					// 경력 요건
					String jobReq = boxItem.select(".col.recruit_info .career").text();
					jobVo.setJobReq(jobReq);

					// 학력 요건
					String jobReq2 = boxItem.select(".col.recruit_info .education").text();
					jobVo.setJobReq2(jobReq2);

					// 채용 상세 링크
					String detailLink = boxItem.select(".col.notification_info .job_tit a.str_tit").attr("href");
					String jobLink = "https://www.saramin.co.kr" + detailLink;
					jobVo.setJobLink(jobLink);

					service.createJobAd(jobVo);
				}

				driver.quit(); // 반드시 WebDriver 종료
			}
		}
	}
}
