package com.address.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.address.dao.AddressDAO;
import com.address.dto.AddressDTO;

public class AAddCommand implements ACommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String viewPage = "address_book.do";
		String result = null;
		HttpSession session = request.getSession();
		AddressDAO dao = new AddressDAO();
	
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		AddressDTO dto = new AddressDTO();
		dto.setAddress(address);
		dto.setName(name);
		dto.setPhone(phone);		
		int retval = dao.addAddress(dto);
		if (retval != 1) {
			result = "FAIL";
		} else {
			result = "PASS";
		}
		session.setAttribute("result", result);
		return viewPage;
	}

}
