package com.address.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.address.dao.AddressDAO;
import com.address.dto.AddressDTO;

public class AOpenCommand implements ACommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		String viewPage = "address_book.jsp";
		HttpSession session = request.getSession();
		AddressDAO dao = new AddressDAO();
		List<AddressDTO> addressList = dao.callAddressListDB(); 
		session.setAttribute("aList", addressList);
		return viewPage;
	}

}
