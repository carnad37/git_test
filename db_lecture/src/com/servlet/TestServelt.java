package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServelt
 */
@WebServlet("/TestServelt")
public class TestServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PrintWriter out = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("test/html");
		out = response.getWriter();
		for (int i = 0; i < 20; i++) {
			out.println("count = " + (i + 1) + "<br>");
			out.flush();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
