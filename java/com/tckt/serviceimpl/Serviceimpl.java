package com.tckt.serviceimpl;

import java.util.List;

import com.tckt.dao.DaoImpl;
import com.tckt.model.Tickets;
import com.tckt.service.ServiceOperations;

public class Serviceimpl implements ServiceOperations{

	public void addTicktService(Tickets t) {
		// TODO Auto-generated method stub
		DaoImpl d = new DaoImpl();
		d.addTicket(t);
	}

	public void updateTcktService(Tickets t, String email) {
		// TODO Auto-generated method stub
		DaoImpl d = new DaoImpl();
		d.updateTicket(t, email);
	}

	public Tickets getticketService(int id) {
		// TODO Auto-generated method stub
		DaoImpl d = new DaoImpl();
		return d.getticket(id);
	}

	public void deleteTicketService(String email) {
		// TODO Auto-generated method stub
		DaoImpl d = new DaoImpl();
		d.deleteTicket(email);
}

	@Override
	public List<Tickets> retrivellService() {
		// TODO Auto-generated method stub
		DaoImpl d = new DaoImpl();
		return d.retriveAll();
	}

	@Override
	public void deleteAll(List<Integer> l) {
		// TODO Auto-generated method stub
		
	}

}
