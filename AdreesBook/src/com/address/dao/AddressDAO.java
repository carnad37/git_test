package com.address.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.address.dto.AddressDTO;

public class AddressDAO {
	//===================update
	public int addAddress(AddressDTO dto) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = "INSERT INTO address_book(name, address, phone) VALUES(?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddress());
			pstmt.setString(3, dto.getPhone());
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("ADDRESS INSERT ERROR");
			} else {
				System.out.println("ADDRESS INSERT SUCCES");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int updateAddress(AddressDTO dto) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = "UPDATE address_book SET name = ?, address = ?, phone = ? WHERE aId = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddress());
			pstmt.setString(3, dto.getPhone());
			pstmt.setInt(4, dto.getaID());
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("ADDRESS UPDATE ERROR");
			} else {
				System.out.println("ADDRESS UPDATE SUCCES");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int deleteArrayAddress(String[] targetID, String SQL) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			System.out.println(SQL);
			for (int i = 0; i < targetID.length; i++) {
				int num = Integer.parseInt(targetID[i]);
				pstmt.setInt(i + 1, num);
			}
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("ADDRESS DELETE ERROR");
			} else {
				System.out.println("ADDRESS DELETE SUCCES");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	public int deleteAddress(int targetID) {
		int retval = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String SQL = "DELETE FROM address_book WHERE aId = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			System.out.println(SQL);
			pstmt.setInt(1, targetID);
			retval = pstmt.executeUpdate();
			if (retval != 1) {
				System.out.println("ADDRESS DELETE ERROR");
			} else {
				System.out.println("ADDRESS DELETE SUCCES");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return retval;
	}
	
	//===================query
	public List<AddressDTO> callAddressListDB() {
		List<AddressDTO> addressList = null;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String SQL = "SELECT * FROM address_book";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL);
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("ADDRESS_BOOK OPEN FAIL..");
			} else {
				addressList = new ArrayList<AddressDTO>();
				while (rs.next()) {
					AddressDTO dto = new AddressDTO();
					dto.setName(rs.getString("name"));
					dto.setAddress(rs.getString("address"));;
					dto.setPhone(rs.getString("phone"));;
					dto.setaID(rs.getInt("aID"));
					addressList.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try {stmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return addressList;
	}
	
	public AddressDTO callAddressDB(int aId) {
		AddressDTO address = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String SQL = "SELECT * FROM address_book WHERE aId = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, aId);
			rs = pstmt.executeQuery();
			boolean check = rs.isBeforeFirst();
			if (check == false) {
				System.out.println("ADDRESS_BOOK OPEN FAIL..");
			} else {
				address = new AddressDTO();
				while (rs.next()) {
					address.setName(rs.getString("name"));
					address.setAddress(rs.getString("address"));;
					address.setPhone(rs.getString("phone"));;
					address.setaID(rs.getInt("aID"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return address;
	}

	private Connection getConnection() throws SQLException{
		Connection connection = null;
		Context context = null;
		Context envContext= null;
		DataSource dataSource = null;
		try {
			context = new InitialContext();
			envContext = (Context)context.lookup("java:comp/env");
			dataSource = (DataSource)envContext.lookup("jdbc/MyJSPDB");
			connection = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
