package kr.or.ddit.staff.service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.exception.PKNotFoundException;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.staff.dao.StaffDAO;
import kr.or.ddit.staff.vo.StaffVO;

@Service
public class StaffServiceImpl implements StaffService {

	@Inject
	private StaffDAO staffDAO;
	@Inject
	private PasswordEncoder encoder;
	@Value("#{appInfo.ProfileImagePath}")
	private Resource staffSaveRes;
	
	private ServiceResult processStaffImage(StaffVO staff) {
		if(staff.getTsImage()==null) return ServiceResult.OK;
		try {
			File saveFile = new File(staffSaveRes.getFile(), staff.getTsFic());
			staff.getTsImage().transferTo(saveFile);
			return ServiceResult.OK;
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void encryptMember(StaffVO staff) {
		String plain = staff.getTsPass();
		String encoded = encoder.encode(plain);
		staff.setTsPass(encoded);
	}
	
	@Override
	public ServiceResult createStaff(StaffVO staff) {
		ServiceResult result = null;
		try {
			retrieveStaff(staff.getTsCd());
			result = ServiceResult.PKDUPLICATE;
		}catch (PKNotFoundException e) {
			encryptMember(staff);
			int cnt = staffDAO.insertStaff(staff);
			result = cnt > 0 ? processStaffImage(staff) : ServiceResult.FAIL;
		}		
		return result;
	}

	@Override
	public StaffVO retrieveStaff(String tsCd) {
		StaffVO saved = staffDAO.selectStaff(tsCd);
		if(saved==null)
			throw new PKNotFoundException(MessageFormat.format("{0} 해당 사용자 없음.", tsCd));
		return saved;
	}

	@Override
	public List<StaffVO> retrieveStaffList(PaginationInfo<StaffVO> paging) {
		long totalRecord = staffDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return staffDAO.selectStaffList(paging);
	}

	@Override
	public ServiceResult modifyStaff(StaffVO staff) {
		ServiceResult result = null;
		int cnt = staffDAO.updateStaff(staff);
		if(cnt > 0) {
			result = processStaffImage(staff);
		}else {
			result = ServiceResult.FAIL;
		}
		return result;
	}

	@Override
	public ServiceResult removeStaff(String tsCd) {
		ServiceResult result = null;
		int cnt = staffDAO.deleteStaff(tsCd);
		result = cnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		return result;
	}

}
