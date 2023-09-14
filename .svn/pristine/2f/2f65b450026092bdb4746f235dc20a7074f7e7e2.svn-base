package kr.or.ddit.academicBusinessPlan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.academicBusinessPlan.vo.ABPVO;
import kr.or.ddit.common.vo.PaginationInfo;

@Mapper //ABPDAO가 호출되었을때 ibatis에 매핑된 해당 다오가 인터페이스기능을 제공함. (인터페이스란 : 인터페이스(interface)란 다른 클래스를 작성할 때 기본이 되는 틀을 제공하면서, 다른 클래스 사이의 중간 매개 역할까지 담당하는 일종의 추상 클래스를 의미)
public interface ABPDAO {
	
//-Paging-----------------------------------------------------------------------------------

	public long selectTotalRecord(PaginationInfo<ABPVO> paging); //ABPVO를 페이징처리한 paging객체를 매개변수로, long타입의 selectTotalRecord를 public으로 선언.

//-Retrieve-----------------------------------------------------------------------------------
	
	public List<ABPVO> selectABPList(PaginationInfo<ABPVO> paging); // ABPVO를 페이징처리한 paging객체를 매개변수로, ABPVO를 타입으로하는 List를 public으로 selectABPList를 선언. -> ABP의 목록

	public ABPVO selectABP(String buPlSn); // ABPVO의 int buPlSn 학술사업계획서순번을 가지고 단일조회에 사용.
	
//-Insert-------------------------------------------------------------------------------------
	
	public int insertABP(ABPVO aBPVO); //ABPVO에 aBPVO를 선언하고 매개변수로 사용하는 int값의 insertABP method
	
//-Update---------------------------------------------------------------------------------
	
	public int updateABP(ABPVO aBPVO); // ABPVO에 aBPVO메서드를 매개변수로 사용하여 int타입의 updateABP method를 선언
	
//-Delete---------------------------------------------------------------------------------
	
	public int deleteABP(ABPVO aBPVO); // ABPVO에 aBPVO메서드를 매개변수로 사용하여 int타입의 DeleteABP method를 선언
	
}

/*
 PaginationInfo코드 -> paging처리에 필요한 모든 코드를 가지고 있는 객체.
@NoArgsConstructor
@Getter
public class PaginationInfo<T> {
	
	public PaginationInfo(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}

	private long totalRecord; // DB 조회
	private int screenSize = 10;
	private int blockSize = 5;
	
	private long totalPage; // 연산1
	private long currentPage; // request parameter
	
	private long startRow; // 연산2
	private long endRow; // 연산3
	
	private long startPage; // 연산4
	private long endPage; // 연산5
	
	private SimpleCondition simpleCondition;
	
	private List<T> dataList;
	
	//검색 보완
	private Map<String,Object> detailCondition;

	public void setDetailCondition(Map<String, Object> detailCondition) {
		this.detailCondition = detailCondition;
	}
	
	public void setSimpleCondition(SimpleCondition simpleCondition) {
		this.simpleCondition = simpleCondition;
	}
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = (totalRecord + screenSize-1 )/ screenSize;
	}
	
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
		
		this.endRow = currentPage * screenSize;
		this.startRow = endRow - (screenSize - 1);
		
		this.endPage = ( (currentPage + blockSize-1 ) / blockSize ) * blockSize; 
		this.startPage = endPage - (blockSize - 1);
	}
	
	
	String htmlPattern = "<a href=''javascript:fn_paging({0});'' data-page=''{0}''>{1}</a>";
	String liPtrn = "<li class=''page-item {0}''>";
	String aPtrn = "<a class='page-link' href=''javascript:fn_paging({0});'' data-page=''{0}''>{1}</a>";
	String curPtrn = "<li class=''page-item active'' aria-current=''page''><a class=''page-link'' href=''#''>{0}</a></li>";

	public String getPagingHTML() {
		StringBuilder html = new StringBuilder();
		html.append("<nav aria-label='...'>");
		html.append("<ul class='pagination'>");
		
		html.append(MessageFormat.format(liPtrn, startPage<=1 ? "disabled" : ""));
		html.append(
			MessageFormat.format(aPtrn, startPage-1, "이전")	
		);
		html.append("</li>");
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		for(long page = startPage; page <= endPage; page++ ) {
			if(page==currentPage) {
				html.append(MessageFormat.format(curPtrn, page));
			}else {
				html.append(MessageFormat.format(liPtrn, ""));
				html.append(
					MessageFormat.format(aPtrn, page, page)	
				);
				html.append("</li>");
			}
		}
		
		html.append(MessageFormat.format(liPtrn, endPage >= totalPage ? "disabled" : ""));
		html.append(
			MessageFormat.format(aPtrn, endPage+1, "다음")	
		);
		html.append("</li>");
		
		html.append("</ul>");
		html.append("</nav>");
		return html.toString();
	}
	
	public String getPagingHTMLSimple() {
		StringBuilder html = new StringBuilder();
		
		if(startPage>1) {
			html.append(
				MessageFormat.format(htmlPattern, startPage-1, "이전")	
			);
		}
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		for(long page = startPage; page <= endPage; page++ ) {
			html.append(
				MessageFormat.format(htmlPattern, page, page)	
			);
		}
		
		if(endPage < totalPage) {
			html.append(
				MessageFormat.format(htmlPattern, endPage+1, "다음")	
			);
		}
		return html.toString();
	}

	

	
}

*/