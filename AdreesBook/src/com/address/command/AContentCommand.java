package com.address.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.address.dao.AddressDAO;
import com.address.dto.AddressDTO;


public class AContentCommand implements ACommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "address_content.jsp";
		
		int aID = Integer.parseInt(request.getParameter("aID"));
		AddressDAO dao = new AddressDAO();
		AddressDTO address = dao.callAddressDB(aID);
		if (address != null) {
			HttpSession session = request.getSession();
			session.setAttribute("address", address);
		}
		return viewPage;
	}

}
