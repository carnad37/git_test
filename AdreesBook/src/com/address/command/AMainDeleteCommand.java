package com.address.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.address.dao.AddressDAO;

public class AMainDeleteCommand implements ACommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String veiwPage = "address_book.do";
		String result = null;
		HttpSession session = request.getSession();
		
		String[] targetID = request.getParameterValues("del_id");
		if(targetID.length != 0) {
			AddressDAO dao = new AddressDAO();
			String SQL = makeDeleteSQL(targetID);
			int retval = dao.deleteArrayAddress(targetID, SQL);
			if (retval != 1) {
				result = "FAIL";
			} else {
				result = "PASS";
			}
			session.setAttribute("result", result);
		}
		return veiwPage;
	}
	
	private String makeDeleteSQL(String[] targetID) {
		String SQL = "DELETE FROM address_book WHERE aId = ?";
		for (int i = 1; i < targetID.length; i++) {
			SQL += " OR aId = ?";
		}
		return SQL;
	}

}
