package kr.or.ddit.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.dao.CommonDAO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.notice.dao.NotificationDAO;
import kr.or.ddit.notice.vo.NoticeDetailVO;
import kr.or.ddit.notice.vo.NotificationVO;
import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.staff.vo.StaffVO;
import kr.or.ddit.student.vo.StudentVO;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Inject
	private NotificationDAO notificationDAO;

	@Inject
	private CommonDAO commonDAO;

	// 전체 알림 조회
	@Override
	public List<NotificationVO> retrieveNotificationList(PaginationInfo paging) {
		long totalRecord = notificationDAO.selectTotalNotification(paging);
		paging.setTotalRecord(totalRecord);
		return notificationDAO.selectNotificationList(paging);
	}

	// 선택 알림의 수신자인지 체크
	@Override
	public int confirmReader(NoticeDetailVO detail) {
		int cnt = notificationDAO.checkReader(detail);
		return cnt;
	}

	// 알림 조회시 읽음 표시
	@Override
	public int readNotification(NoticeDetailVO detail) {
		int cnt = notificationDAO.checkNotification(detail);
		return cnt;
	}

	// 알림 입력
	@Override
	public int createNotification(NotificationVO notification) {
		int cnt = 0 ;
		notificationDAO.insertNotification(notification);
		String choice = notification.getNotiReceiver();
		if (choice.equals("1")) {
			List<StaffVO> staffList = commonDAO.selectStaffList();
			for (StaffVO staff : staffList) {
				String receiver = staff.getTsCd();
				notification.setNotiReceiver(receiver);
				cnt += notificationDAO.sendNotification(notification);
			}
		} else if (choice.equals("2")) {

			List<ProfessorVO> profList = commonDAO.selectProfessorList();
			for (ProfessorVO prof : profList) {
				String receiver = prof.getPrCd();
				notification.setNotiReceiver(receiver);
				cnt += notificationDAO.sendNotification(notification);
			}
		} else {
			List<StudentVO> studentList = commonDAO.selectStudentList();
			for (StudentVO student : studentList) {
				String receiver = student.getStCd();
				notification.setNotiReceiver(receiver);
				cnt += notificationDAO.sendNotification(notification);
			}
		}
		return cnt;
	}
	// 알림 수정
	@Override
	public int modifyNotification(NotificationVO notification) {
		int cnt = 0;
		return cnt;
	}

	// 알림 삭제
	@Override
	public int removeNotification(NotificationVO notification) {
		int cnt = 0;
		return cnt;
	}

	// 알림 개수 체크
	@Override
	public int countNotice(String userId) {
		int cnt = notificationDAO.checkNotice(userId);
		return cnt;
	}
	
	// 본인 알림 조회
	@Override
	public List<NotificationVO> retrieveMyNoticeList(PaginationInfo paging) {
		long totalRecord = notificationDAO.selectMyNotice(paging);
		paging.setTotalRecord(totalRecord);
		return notificationDAO.selectMyNoticeList(paging);
	}

}
