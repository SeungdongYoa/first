package service;

import java.util.ArrayList;

import dao.BookDAO;
import dao.ClientDAO;
import dao.ConnectionMaker;
import entity.BookEntity;

public class BookService {

	// 데이터베이스 처리를 제외한 순수 로직처리가 나와요!
		public ArrayList<BookEntity> searchBook(BookEntity entity) {
			
			
			// 로직처리가 없네!!
			// DB처리를 하기 위해서 DAO를 생성
			//BookDAO dao = new NaverBookDAO();  // 상위타입으로 변수의 타입은 잡아도 되고.
			ConnectionMaker maker = new ClientDAO();//넣자 이거(6단계)  서비스도 네이버가, naverbookdao도 네이버가 만든 거니 여기선 상관없어!
			BookDAO dao = new BookDAO(maker);
			ArrayList<BookEntity> list = dao.select(entity);		
			return list;
			
		}

		public boolean insertBook(BookEntity entity) {
			boolean result = false;
			
			// 로직처리가 없네!!
			// DB처리를 하기 위해서 DAO를 생성
			//BookDAO dao = new NaverBookDAO();
			ConnectionMaker maker = new ClientDAO();//넣자 이거(6단계)
			BookDAO dao = new BookDAO(maker);
			//BookDAO dao = new BookDAO();
			int count = dao.insert(entity);
			if( count == 1 ) {
				result = true;
			} else {
				result = false;
			}
			
			return result;
		}

		public boolean deleteBook(BookEntity entity) {
			boolean result = false;
			
			//BookDAO dao = new NaverBookDAO();
			//BookDAO dao = new BookDAO();
			ConnectionMaker maker = new ClientDAO();//넣자 이거(6단계)
			BookDAO dao = new BookDAO(maker);
			int count = dao.delete(entity);
			if( count == 1 ) {
				result = true;
			} else {
				result = false;
			}
			
			return result;
		}
		
		public boolean updateBook(BookEntity entity) {
			boolean result = false;
			
			//BookDAO dao = new NaverBookDAO();
			//BookDAO dao = new BookDAO();
			ConnectionMaker maker = new ClientDAO();//넣자 이거(6단계)
			BookDAO dao = new BookDAO(maker);
			int count = dao.update(entity);
			if( count == 1 ) {
				result = true;
			} else {
				result = false;
			}
			
			return result;
		}
}
