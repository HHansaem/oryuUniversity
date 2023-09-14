package kr.or.ddit.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.notice.vo.NoticeDetailVO;
import kr.or.ddit.notice.vo.NotificationVO;

@Mapper
public interface NotificationDAO {

	// 페이징 처리를 위한 전체 레코드 개수 조회
	public long selectTotalNotification(PaginationInfo paging);

	// 전체 알림 조회
	public List<NotificationVO> selectNotificationList(PaginationInfo paging);

	// 선택 알림의 수신자인지 체크
	public int checkReader(NoticeDetailVO detail); 
	
	// 알림 조회시 읽음 표시
	public int checkNotification(NoticeDetailVO detail);

	// 알림 등록
	public int insertNotification(NotificationVO notification);

	// 알림 발신
	public int sendNotification(NotificationVO notification);
	
	// 알림 수정
	public int updateNotification(NotificationVO notification);

	// 알림 삭제
	public int deleteNotification(NotificationVO notification);
	
	// 알림 개수 체크
	public int checkNotice(String userId);
	
	// 알림 상세 조회
	public NotificationVO notificationDetail(String notiCd);
	
	// 본인 알림 조회
	public List<NotificationVO> selectMyNoticeList(PaginationInfo paging);
	
	// 본인 알림 개수 조회
	public long selectMyNotice(PaginationInfo paging);
	
	
	
}
