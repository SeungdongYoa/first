package entity;

public class BoardEntity {

	// 게시판 프로그램에 대한 entity
	// entity를 만들때 기본적으로 이 entity가 사용될 Database Table을 기준으로 작성
	private int articleNum;
	private String articleTitle;
	private String articleContent;
	private String articleWriter;
	private String articleDate;
	
	public BoardEntity() {
	
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleWriter() {
		return articleWriter;
	}

	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}

	public String getArticleDate() {
		return articleDate;
	}

	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}
	
	
}
