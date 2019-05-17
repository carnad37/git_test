package com.address.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.address.dao.AddressDAO;

public class AContentDeleteCommand implements ACommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String veiwPage = "address_book.do";
		String result = null;
		HttpSession session = request.getSession();
		
		int targetID = Integer.parseInt(request.getParameter("del_id"));
		AddressDAO dao = new AddressDAO();
		int retval = dao.deleteAddress(targetID);
		if (retval != 1) {
			result = "FAIL";
		} else {
			result = "PASS";
		}
		session.setAttribute("result", result);		
		return veiwPage;
	}

}
