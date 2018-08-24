package com.rodrigobaluyot.project.vaadin.components;

import com.rodrigobaluyot.project.vaadin.Message;
import com.rodrigobaluyot.project.vaadin.ScreenName;

import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class MessagesBox extends Panel {
	
	private static final long serialVersionUID = 1L;
	
	private Layout messages = new VerticalLayout();
	
	public MessagesBox() {
		super();
		setSizeFull();
		
		setContent(messages);
	}
//	add ScreenName SN as an argument in the add Method?
	public void add(Message message) {
		getUI().access(() -> {
			messages.addComponent(new MessageLabel(message));
			// little hack to make it scroll to the bottom when new message appears
			setScrollTop(9999999);
		});
	}

}
