package service;

import dao.BoardDAO;
import entity.BoardEntity;

// 로직 처리 객체를 만들기 위한 클래스
public class BoardService {

	public BoardService() {
	
	}
	
	// 글 등록하는 일을 실제로 처리하는 business method
	public boolean registerArticle(BoardEntity entity){
		// 로직처리(데이터베이스에 글을 등록)를 해요!!
		// 정상처리되었으면 true return		
		
		boolean result = false;
		// 지금 우리 코드는 별다른 로직이 없고 DB처리만 있어요.
		// database 처리를 해야 하는데 DAO를 이용해서 처리.
		// DAO를 만들기 위해서 DAO 클래스 생성
		
		BoardDAO dao = new BoardDAO();
		result = dao.insert(entity);
		
		return result;
	}
}
