package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.notice.vo.NoticeDetailVO;
import kr.or.ddit.notice.vo.NotificationVO;

public interface NotificationService {

	// 전체 알림 조회
	public List<NotificationVO> retrieveNotificationList(PaginationInfo paging);

	// 선택 알림의 수신자인지 체크
	public int confirmReader(NoticeDetailVO detail); 
		
	// 알림 조회시 읽음 표시
	public int readNotification(NoticeDetailVO detail);

	// 알림 입력
	public int createNotification(NotificationVO notification);

	// 알림 수정
	public int modifyNotification(NotificationVO notification);

	// 알림 삭제
	public int removeNotification(NotificationVO notification);
	
	// 알림 개수 체크
	public int countNotice(String userId);
	
	// 본인 알림 조회
	public List<NotificationVO> retrieveMyNoticeList(PaginationInfo paging);

}
