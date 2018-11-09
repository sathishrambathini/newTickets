package com.tckt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tckt.model.Tickets;

import om.tckt.util.Connc;

public class DaoImpl implements DaoOperations {

	public void addTicket(Tickets t) {
		// TODO Auto-generated method stub
		String query = "insert into ticket (issueType,decr,dept,isActive,createdBy,createdDate,updatedDate,updatedBy,name,email,mobileNumber) values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection con = Connc.getConnect();
		try {
			PreparedStatement pstmp = con.prepareStatement(query);
			pstmp.setString(1, t.getIssueType());
			pstmp.setString(2, t.getDescr());
			pstmp.setString(3, t.getDept());
			pstmp.setBoolean(4, t.isActive());
			pstmp.setString(5, t.getCreatedBy());
			pstmp.setString(6, t.getCreatedDate());
			pstmp.setString(7, t.getUpdatedDate());
			pstmp.setString(8, t.getUpdatedBy());
			pstmp.setString(9, t.getName());
			pstmp.setString(10, t.getEmail());
			pstmp.setLong(11, t.getMobileNumber());
			int m = pstmp.executeUpdate();
			if (m == 1) {
				System.out.println("row inserted");
			} else {
				System.out.println("row not inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateTicket(Tickets t, String name) {
		// TODO Auto-generated method stub
		String query = "update ticket set name = ? where email = ?";
		Connection con = Connc.getConnect();
		try {
			PreparedStatement pstmp = con.prepareStatement(query);
			pstmp.setString(2, t.getEmail());
			pstmp.setString(1, name);
			int m = pstmp.executeUpdate();
			if (m == 1) {
				System.out.println("updated");
			} else {
				System.out.println("not updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Tickets getticket(int id) {
		// TODO Auto-generated method stub
		String query = "select * from ticket where id = ?";
		Connection con = Connc.getConnect();
		Tickets t = new Tickets();
		try {
			PreparedStatement pstmp = con.prepareStatement(query);
			pstmp.setInt(1, id);
			ResultSet rs = pstmp.executeQuery();
			while (rs.next()) {
				t.setIssueType(rs.getString(2));
				t.setDescr(rs.getString(3));
				t.setDept(rs.getString(4));
				t.setActive(rs.getBoolean(5));
				t.setCreatedBy(rs.getString(6));
				t.setCreatedDate(rs.getString(7));
				t.setUpdatedDate(rs.getString(8));
				t.setUpdatedBy(rs.getString(9));
				t.setName(rs.getString(10));
				t.setEmail(rs.getString(11));
				t.setMobileNumber(rs.getLong(12));
				System.out.println(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public void deleteTicket(String email) {
		// TODO Auto-generated method stub
		String query = "delete from ticket where email = ?";
		Connection con = Connc.getConnect();
		try {
			PreparedStatement pstmp = con.prepareStatement(query);
			pstmp.setString(1, email);
			pstmp.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Tickets> retriveAll() {
		// TODO Auto-generated method stub
		String query = "select * from ticket";
		Connection con = Connc.getConnect();
		List<Tickets> ll = new ArrayList<>();
		try {
			PreparedStatement pstmp = con.prepareStatement(query);
			ResultSet rs = pstmp.executeQuery();
			while(rs.next())
			{
				Tickets t = new Tickets();
				t.setIssueType(rs.getString(2));
				t.setDescr(rs.getString(3));
				t.setDept(rs.getString(4));
				t.setActive(rs.getBoolean(5));
				t.setCreatedBy(rs.getString(6));
				t.setCreatedDate(rs.getString(7));
				t.setUpdatedDate(rs.getString(8));
				t.setUpdatedBy(rs.getString(9));
				t.setName(rs.getString(10));
				t.setEmail(rs.getString(11));
				t.setMobileNumber(rs.getLong(12));
				ll.add(t);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ll;
	}

	@Override
	public void deleteAll(int id) {
		// TODO Auto-generated method stub
		
	}

}




































