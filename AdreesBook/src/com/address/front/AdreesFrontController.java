package com.address.front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.address.command.AAddCommand;
import com.address.command.ACommand;
import com.address.command.AContentCommand;
import com.address.command.AContentDeleteCommand;
import com.address.command.AMainDeleteCommand;
import com.address.command.AModifyCommand;
import com.address.command.AOpenCommand;

/**
 * Servlet implementation class AdreesFrontController
 */
@WebServlet("*.do")
public class AdreesFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdreesFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String viewPage = null;
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String action = uri.substring(path.length());
		if (action.equals("/address_book.do")) {
			ACommand command = new AOpenCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("/address_add_view.do")) {
			viewPage = "address_add.jsp";
		} else if (action.equals("/address_add.do")) {
			ACommand command = new AAddCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("/address_main_delete.do")) {
			ACommand command = new AMainDeleteCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("/address_delete.do")) {
			ACommand command = new AContentDeleteCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("/address_modify.do")) {
			ACommand command = new AModifyCommand();
			viewPage = command.execute(request, response);
		} else if (action.equals("/address_modify_view.do")) {
			viewPage = "address_modify.jsp";
		} else if (action.equals("/address_content.do")) {
			ACommand command = new AContentCommand();
			viewPage = command.execute(request, response);
		} else {
			System.out.println("CANNOT FOUND ACTION.DO");
		}
		response.sendRedirect(viewPage);
	}
}
