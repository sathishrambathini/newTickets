package com.tckt.dao;

import java.util.List;

import com.tckt.model.Tickets;

public interface DaoOperations {
		public void addTicket(Tickets t);
		public void updateTicket(Tickets t ,String email);
		public Tickets getticket(int id);
		public void deleteTicket(String email);
		public List<Tickets> retriveAll();
		public void deleteAll(int id); 
}
