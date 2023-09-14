package kr.or.ddit.student.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.vo.StudentVO;

@Controller
public class StudentExcelInsertController {

	@Inject
	private StudentService service;
	
	@PostMapping(value="/Excel/insert.do", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertExcel(
			MultipartFile file
	) throws IOException {
		
		InputStream inputStream = file.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("시트1");
        
        List<StudentVO> students = new ArrayList<>();
        
        for (Row row : sheet) {
            if (row.getRowNum() > 0) { // 첫 번째 행은 열 이름이므로 제외
            	
            	row.getCell(0).setCellType(CellType.STRING);
				row.getCell(1).setCellType(CellType.STRING);
				row.getCell(2).setCellType(CellType.STRING);
				row.getCell(3).setCellType(CellType.STRING);
				row.getCell(4).setCellType(CellType.STRING);
				row.getCell(5).setCellType(CellType.STRING);
				row.getCell(6).setCellType(CellType.STRING);
				row.getCell(7).setCellType(CellType.STRING);
				row.getCell(8).setCellType(CellType.STRING);
				row.getCell(9).setCellType(CellType.STRING);
				row.getCell(10).setCellType(CellType.STRING);
            	
                String value1 = row.getCell(0).getStringCellValue();
                String value2 = row.getCell(1).getStringCellValue();
                String value3 = row.getCell(2).getStringCellValue();
                String value4 = row.getCell(3).getStringCellValue();
                String value5 = row.getCell(4).getStringCellValue();
                String value6 = row.getCell(5).getStringCellValue();
                String value7 = row.getCell(6).getStringCellValue();
                String value8 = row.getCell(7).getStringCellValue();
                String value9 = row.getCell(8).getStringCellValue();
                String value10 = row.getCell(9).getStringCellValue();
                String value11 = row.getCell(10).getStringCellValue();
                // ... (필요한 만큼 열의 값 읽기)

                StudentVO student = new StudentVO();
                student.setStCd(value1);
                student.setDtCd(value2);
                student.setStNm(value3);
                student.setStPh(value4);
                student.setStEmail(value5);
                student.setStPass(value6);
                student.setStStatus(value7);
                student.setStAddr1(value8);
                student.setStAddr2(value9);
                student.setStReg1(value10);
                student.setStReg2(value11);
                // ... (User 객체에 데이터 설정)
                
                students.add(student);
            }
        }
        
        ServiceResult result = service.createStudents(students);
        Map<String, Object> respMap = new HashMap<>();
		switch(result) {
		case PKDUPLICATE:
			respMap.put("result", "중복");
			break;
		case OK:
			respMap.put("result", "성공");
			break;
		default:
			respMap.put("result", "실패");
			break;
		}
        
        workbook.close();
        inputStream.close();

        return ResponseEntity.ok(respMap);
        
	}
	@PostMapping("/Excel/insert2.do")
	public String insertExcel2(
			MultipartFile file
			, HttpSession session
	) throws IOException {
		
		InputStream inputStream = file.getInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("시트1");
        
        List<StudentVO> studentList = new ArrayList<>();
        
        for (Row row : sheet) {
            if (row.getRowNum() > 0) { // 첫 번째 행은 열 이름이므로 제외
            	
            	row.getCell(0).setCellType(CellType.STRING);
				row.getCell(1).setCellType(CellType.STRING);
				row.getCell(2).setCellType(CellType.STRING);
				row.getCell(3).setCellType(CellType.STRING);
				row.getCell(4).setCellType(CellType.STRING);
            	
                String value1 = row.getCell(0).getStringCellValue();
                String value2 = row.getCell(1).getStringCellValue();
                String value3 = row.getCell(2).getStringCellValue();
                String value4 = row.getCell(3).getStringCellValue();
                String value5 = row.getCell(4).getStringCellValue();
                // ... (필요한 만큼 열의 값 읽기)

                StudentVO student = new StudentVO();
                student.setStCd(value1);
                student.setEmpStat(value2);
                student.setEmpYear(value3);
                student.setEmpField(value4);
                student.setEmpLoc(value5);
                // ... (User 객체에 데이터 설정)
                System.out.println(student);
                studentList.add(student);
            }
        }
        
		int count = 0;
//		String result = null;
		count = service.modifyStatusFile(studentList);
//		if(count>0) {
//			result="취업현황 "+count+"명 업데이트 완료";
//		}else {
//			result="취업현황 업데이트 실패";
//		}
        workbook.close();
        inputStream.close();

        return "redirect:/student/studentJobList.do";
	}
	
}
