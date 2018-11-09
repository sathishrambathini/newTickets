package com.tckt.service;


import java.util.List;

import com.tckt.model.Tickets;

public interface ServiceOperations {
	
public void addTicktService(Tickets t);
public void updateTcktService(Tickets t,String email);
public Tickets getticketService(int id);
public void deleteTicketService(String email);
public List<Tickets> retrivellService();
public void deleteAll(List<Integer> l);
}
