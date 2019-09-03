package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BoardEntity;
import service.BoardService;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/writer")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력을 받아요.
		// 클라이언트로부터 입력받은 한글이 정상적으로 처리되기 위해서 한글처리를 해주어요.
		request.setCharacterEncoding("UTF8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		
		// 2. 이렇게 데이터를 입력받으면 이 데이터를 service 객체에 넘겨줘서 로직처리를 해야해요.
		// 이 데이터를 개별적으로 전달하는 게 아니라 객체화시켜서 전달
		// DTO(Data Transfer Object), entity, VO(value object)
		// DO(domain object)
		// class가 있어야지 해당 entity객체를 만들 수 있겠죠?
		
		BoardEntity entity = new BoardEntity();
		entity.setArticleTitle(title);
		entity.setArticleWriter(author);
		entity.setArticleContent(content);
		entity.setArticleDate((new Date()).toLocaleString());

		// 3. 이렇게 만든 entity 객체를 이용해서 로직처리를 해야 해요.
		//    로직 처리하는 객체가 있어야 해요.
		//    service를 객체를 만들기 위해 class부터 만들어야 해요.
		BoardService service = new BoardService();
		// 로직처리 수행시키고 결과를 트루나 폴스로 받을거에요.
		boolean result = service.registerArticle(entity);
		
		// 4. 출력 처리해를 해야 해요!! 출력을 하기 위해 HTML을 이용할 수도 있고
		//  JSP를 이용할 수있어요.
		//  HTML은 고정된 내용으로 출력하고자 할때
		//  JSP는 결과에 따라 다른 내용을 출력하고자 할 때 ( 리스트를 보여준다던지.. )
		//  성공일 경우 success.html을 클라이언트에게 전달
		//  실패했을 경우 fail.html을 클라이언트에게 전달.
		if(result){
			response.sendRedirect("success.html");
		}else{
			response.sendRedirect("fail.html");
		}
	}

}
// 수정사항