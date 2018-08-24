package com.rodrigobaluyot.project.vaadin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rodrigobaluyot.project.vaadin.components.MessageLabel;

@Entity
public class ScreenName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String SN;
	
	public ScreenName() {};
	
	public ScreenName(String SN) {
		this.SN = SN;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

//	public void add(ScreenName screenName) {
//		ScreenName.addComponent(new MessageLabel(SN));
//		
//	}
	
	
	
	
}

