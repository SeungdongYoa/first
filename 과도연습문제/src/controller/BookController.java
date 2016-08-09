package controller;

import java.util.ArrayList;
import java.util.Scanner;


import entity.BookEntity;
import service.BookService;

public class BookController {

	Scanner s, s1; 
	BookService service;
	
	public BookController() {
		s = new Scanner(System.in);
		s1 = new Scanner(System.in);
		service = new BookService();
		printMenu();
	}
	
	public void printMenu() {
		
		int menu = 0;
		
		int bookMenu = 0;
		int userMenu = 0;
		int rentMenu = 0;
		
		do {			
			System.out.println("---- 메뉴를 선택해 주세요!! ----");
			System.out.println("1. 도서 관리");
			System.out.println("2. 사용자 관리");
			System.out.println("3. 대여 관리");
			System.out.println("4. 종료");
			System.out.print("메뉴 번호를 입력하세요. ==> ");
			menu = s.nextInt();
			
			if(menu == 1) {
				// 사용자로부터 책에 대한 정보를 받아서
				// entity로 만들어서
				// service객체한테 전달.
			do{
				System.out.println("---- 도서 관리입니다! ----");
				System.out.println("1. 책 입력");
				System.out.println("2. 책 번호로 책 제목 수정");
				System.out.println("3. 책 번호로 책 삭제");
				System.out.println("4. 책 제목에 대한 키워드 입력 후 찾은 책 출력");
				System.out.println("5. 종료");
				System.out.print("메뉴 번호를 입력하세요. ==> ");
				menu = s1.nextInt();
				
				if(bookMenu == 1){
				
			    BookEntity entity = new BookEntity();
				System.out.print("책 번호를 입력하세요 ==> ");
				entity.setbIsbn(s1.next());
				System.out.print("책 제목을 입력하세요 ==> ");
				entity.setbTitle(s1.next());
				System.out.print("책 저자를 입력하세요 ==> ");
				entity.setbAuthor(s1.next());
				System.out.print("책 가격을 입력하세요 ==> ");
				entity.setbPrice(s1.nextInt());
				
				boolean result = service.insertBook(entity);
				if( result ) {
					System.out.println("정상적으로 처리되었습니다.");
				} else {
					System.out.println("입력에 실패했어요!");
				}
				
				}else if( bookMenu == 2){
					
					BookEntity entity = new BookEntity();
					System.out.print("책 번호를 입력하세요 ==> ");
					entity.setbIsbn(s1.next());
					System.out.print("책 수정할 제목을 입력하세요 ==> ");
					entity.setbTitle(s1.next());
					
					boolean result = service.updateBook(entity);
					if( result ) {
						System.out.println("정상적으로 처리되었습니다.");
					} else {
						System.out.println("수정에 실패했어요!");
					}
					
				}else if( bookMenu == 3){
					
					BookEntity entity = new BookEntity();
					System.out.print("삭제할 책 번호를 입력하세요 ==> ");
					entity.setbIsbn(s1.next());
					
					boolean result = service.deleteBook(entity);
					if( result ) {
						System.out.println("정상적으로 처리되었습니다.");
					} else {
						System.out.println("수정에 실패했어요!");
					}
				}else if( bookMenu == 4){
					
					BookEntity entity = new BookEntity();
					System.out.print("찾을 책 제목에 대한 키워드를 입력하세요 ==> ");
					entity.setbTitle(s1.next());
					
					// DAO에서 책 1권에 대한 데이터가 entity 1개로 표현
					ArrayList<BookEntity> list = 
							service.searchBook(entity);
					for(BookEntity tmp  : list) {
						System.out.println(tmp.getbTitle());
					}
				}
				
			}while(bookMenu !=5);
			
			}else if( menu == 2) { // 사용자관리
				
			do{
				System.out.println("---- 사용자 관리입니다! ----");
				System.out.println("1. 사용자 추가");
				System.out.println("2. 사용자 수정");
				System.out.println("3. 사용자 삭제");
				System.out.println("4. 사용자 검색");
				System.out.println("5. 종료");
				System.out.print("메뉴 번호를 입력하세요. ==> ");
				menu = s1.nextInt();
				
				if(bookMenu == 1){
				
			    BookEntity entity = new BookEntity();
				System.out.print("id를 입력하세요 ==> ");
				entity.setbIsbn(s1.next());
				System.out.print("이름을 입력하세요 ==> ");
				entity.setbTitle(s1.next());
				System.out.print("빌려간 책 번호를 입력하세요 ==> ");
				entity.setbAuthor(s1.next());
				System.out.print("반납일을 입력하세요 ==> ");
				entity.setbPrice(s1.nextInt());
				
				boolean result = service.insertBook(entity);
				if( result ) {
					System.out.println("정상적으로 처리되었습니다.");
				} else {
					System.out.println("입력에 실패했어요!");
				}
				
				}else if( bookMenu == 2){
					
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
					
				}else if( bookMenu == 3){
					
					BookEntity entity = new BookEntity();
					System.out.print("삭제할 책 번호를 입력하세요 ==> ");
					entity.setbIsbn(s.next());
					
					boolean result = service.deleteBook(entity);
					if( result ) {
						System.out.println("정상적으로 처리되었습니다.");
					} else {
						System.out.println("수정에 실패했어요!");
					}
				}else if( bookMenu == 4){
					
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
				
			}while(bookMenu !=5);
			
			
				
			} else if( menu == 3) {
				
				}
			} while(menu != 4);
	
}
}