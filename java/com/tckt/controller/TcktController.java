package com.tckt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tckt.model.Tickets;
import com.tckt.service.ServiceOperations;
import com.tckt.serviceimpl.Serviceimpl;

import om.tckt.util.DateTckts;

/**
 * Servlet implementation class TcktController
 */
public class TcktController extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ServletDemo.doGet()");
		response.getWriter().append("Server at: ").append(request.getContextPath());
		// doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Now i'm in ServletDemo.doPost()");
		String type = request.getParameter("actionType");
		ServiceOperations si = new Serviceimpl();
		ObjectMapper mapper = new ObjectMapper();
		if (type.equals("insert")) {
			System.out.println("i'm going to insert");
			try {
				Tickets tc = new Tickets();
				tc.setIssueType(request.getParameter("it"));
				tc.setDescr(request.getParameter("de"));
				tc.setDept(request.getParameter("dept"));
				tc.setActive(true);
				tc.setCreatedBy(request.getParameter("cb"));
				tc.setCreatedDate(DateTckts.toDateTime(request.getParameter("cd")));
				tc.setUpdatedDate(DateTckts.toDateTime(request.getParameter("ud")));
				tc.setUpdatedBy(request.getParameter("ub"));
				tc.setName(request.getParameter("name"));
				tc.setEmail(request.getParameter("email"));
				tc.setMobileNumber(Long.parseLong(request.getParameter("mob")));
				si.addTicktService(tc);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (type.equals("update")) {
			Tickets tc = new Tickets();
			String name = request.getParameter("fn");
			tc.setEmail(request.getParameter("email"));
			si.updateTcktService(tc, name);
		} else if (type.equals("delete")) {
			Tickets tc = new Tickets();
			String email = request.getParameter("email");
			si.deleteTicketService(email);
		} else if (type.equals("get")) {
			Tickets tc = new Tickets();
			String id1 = request.getParameter("id");
			int id = Integer.parseInt(id1);
			Tickets ts = si.getticketService(id);
			out.println(ts);
		} else if (type.equals("retriveall")) {
			List<Tickets> l = si.retrivellService();
			for (int i = 0; i < l.size(); i++) {
				mapper.writeValueAsString(l.get(i));

				String jsonInString1 = mapper.writeValueAsString(l.get(i));
				System.out.println(jsonInString1);

				jsonInString1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(l.get(i));
				System.out.println(jsonInString1);
			}
		} else if (type.equals("deleteall")) {

		}
	}
}
