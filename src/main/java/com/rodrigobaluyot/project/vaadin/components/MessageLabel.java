package com.rodrigobaluyot.project.vaadin.components;

import com.rodrigobaluyot.project.vaadin.Message;
import com.vaadin.ui.Label;
import com.rodrigobaluyot.project.vaadin.ScreenName;


public class MessageLabel extends Label {

	public MessageLabel(Message message, ScreenName SN) {
		super();
		
		if(SN == null) {
			this.setValue(message.getCreated().toString() + " - " + message.getText());

		}
		else {
			this.setValue(message.getCreated().toString() + " - " + SN.getSN() + ": " + message.getText());

		}
	}

	private static final long serialVersionUID = 1L;

}
