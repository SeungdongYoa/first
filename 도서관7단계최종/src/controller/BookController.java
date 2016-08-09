package controller;

import java.util.ArrayList;
import java.util.Scanner;

import entity.BookEntity;
import service.BookService;

// 사용자와의 입출력을 담당.
// 입력받은 데이터를 entity로 만들어서 service에게 전달
public class BookController {

	Scanner s, s1; 
	BookService service;
	
	public BookController() {
		s = new Scanner(System.in);
		service = new BookService();
		printMenu();
	}
	
	public void printMenu() {
		int menu = 0;
		int test1 = 0;
		do {			
			System.out.println("---- 메뉴를 선택해 주세요!! ----");
			System.out.println("1. 책 입력");
			System.out.println("2. 책 번호로 책 제목 수정");
			System.out.println("3. 책 번호로 책 삭제");
			System.out.println("4. 책 제목에 대한 키워드 입력 후 찾은 책 출력");
			System.out.println("5. 종료");
			System.out.print("메뉴 번호를 입력하세요. ==> ");
			menu = s.nextInt(); // s하나로 될 수 있는건 s라는 객체로 다 이용가능. s의 메서드 이용하면서~!
			
			if(menu == 1) {
				s1 = new Scanner(System.in);
				// 사용자로부터 책에 대한 정보를 받아서
				// entity로 만들어서
				// service객체한테 전달.
				BookEntity entity = new BookEntity();
				System.out.print("책 번호를 입력하세요 ==> ");
				entity.setbIsbn(s1.next());
				System.out.print("책 제목을 입력하세요 ==> ");
				entity.setbTitle(s1.next());
				System.out.print("책 저자를 입력하세요 ==> ");
				entity.setbAuthor(s.next());
				System.out.print("책 가격을 입력하세요 ==> ");
				entity.setbPrice(s.nextInt());
				
				boolean result = service.insertBook(entity);
				if( result ) {
					System.out.println("정상적으로 처리되었습니다.");
				} else {
					System.out.println("입력에 실패했어요!");
				}
			} else if( menu == 2) {
				BookEntity entity = new BookEntity();
				System.out.print("책 번호를 입력하세요 ==> ");
				entity.setbIsbn(s.next());
				System.out.print("책 수정할 제목을 입력하세요 ==> ");
				entity.setbTitle(s.next());
				
				boolean result = service.updateBook(entity);
				if( result ) {
					System.out.println("정상적으로 처리되었습니다.");
				} else {
					System.out.println("수정에 실패했어요!");
				}
				
			} else if( menu == 3) {
				BookEntity entity = new BookEntity();
				System.out.print("삭제할 책 번호를 입력하세요 ==> ");
				entity.setbIsbn(s.next());
				
				boolean result = service.deleteBook(entity);
				if( result ) {
					System.out.println("정상적으로 처리되었습니다.");
				} else {
					System.out.println("수정에 실패했어요!");
				}
				
			} else if( menu == 4) {
				BookEntity entity = new BookEntity();
				System.out.print("찾을 책 제목에 대한 키워드를 입력하세요 ==> ");
				entity.setbTitle(s.next());
				
				// DAO에서 책 1권에 대한 데이터가 entity 1개로 표현
				ArrayList<BookEntity> list = 
						service.searchBook(entity);
				for(BookEntity tmp  : list) {
					System.out.println(tmp.getbTitle());
				}
			}
			
		} while(menu != 5);
	}
	
}






