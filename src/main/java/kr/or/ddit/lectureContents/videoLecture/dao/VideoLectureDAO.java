package kr.or.ddit.lectureContents.videoLecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.lectureContents.vo.VideoLectureVO;

@Mapper
public interface VideoLectureDAO {
	//동영상 강의 등록
	public int insertVideoLecture(VideoLectureVO videoLec);
	// 동영상 강의 상세조회
	public VideoLectureVO selectVideoLectureDetail(String vlsCd);
	// 동영상 강의 목록조회
	public List<VideoLectureVO> selectVideoLectureList(String lecCd);
	// 동영상 강의 업데이트
	public int updateVideoLecture(VideoLectureVO videoLec);
	// 동영상 강의 삭제
	public int deleteVideoLecture(String vlsCd);
	
}
