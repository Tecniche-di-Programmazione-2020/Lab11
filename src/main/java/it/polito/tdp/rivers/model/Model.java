package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	RiversDAO dao;
	List<River> rivers ;
	River fiume;
	int fattore;
	double q;
	double c;
	double flussoMin;
	
	
	public Model() {
		dao= new RiversDAO();
		rivers = new LinkedList<River>(dao.getAllRivers());
		fattore=1;
		
	}
	
	// Carico le rilevazioni del fiume
	public void program() {
		fiume= rivers.get(0);
		fiume.setFlows(dao.getAllFlows(fiume));
		fiume.runStats();
		
		System.out.println(fiume.getFirstday());
		System.out.println(fiume.getLastday());
		System.out.println(fiume.getNumeroMisurazioni());
		System.out.println(fiume.getFlowAvg());
		
		
		
	}
	private void simula() {
		
		q=fattore*fiume.getFlowAvg()*30;
		c=q/2.0;
		flussoMin=0.8*fiume.getFlowAvg();
		
		
	}
	
	
}
