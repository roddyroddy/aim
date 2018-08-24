package com.rodrigobaluyot.project.vaadin;

import java.util.Date;

import com.rodrigobaluyot.project.vaadin.components.MessagesBox;
import com.rodrigobaluyot.project.vaadin.ScreenName;

import com.vaadin.annotations.Push;
import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Push
public class UI extends com.vaadin.ui.UI {
	
	private static final long serialVersionUID = 1L;

	private static final com.rodrigobaluyot.project.vaadin.ScreenName ScreenName = new ScreenName();	
	
	private MessagesBox messagesBox = new MessagesBox();

	
	@Override
	protected void init(VaadinRequest request) {
		setupLayout();
		
	}
	
	private void setupLayout() {
		VerticalLayout root = new VerticalLayout();
		VerticalLayout popupContent = new VerticalLayout();
		
		TextField screenName = new TextField("Screen Name");
		Button snAdd = new Button("Submit");
		popupContent.addComponent(screenName);
		popupContent.addComponent(snAdd);
		
//		snAdd.addClickListener(click-> {
//			this.ScreenName.add(new ScreenName(screenName.getValue()));
//			
//		});
//		
//		
//		

		// The component itself
		PopupView popup = new PopupView("Enter your Screen Name", popupContent);
		
		root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		root.setSizeFull();
		
		Layout header = createHeader();
		root.addComponent(header);
		
		root.addComponent(popup);
		root.setComponentAlignment(popup, Alignment.TOP_LEFT);

		root.addComponent(this.messagesBox);
		root.setExpandRatio(this.messagesBox, 1f);
		
		Layout userInputArea = createUserInputArea();
		root.addComponent(userInputArea);
		root.setComponentAlignment(userInputArea, Alignment.BOTTOM_CENTER);

		
		setContent(root);	
	}
	
	private Layout createHeader() {	
		Label headline = new Label("Aim");
		headline.addStyleNames(ValoTheme.LABEL_H1);
		
		Label clock = new Label();
		clock.addStyleNames(ValoTheme.LABEL_LIGHT);
		// Update header every second (1000ms) to simulate a clock
		new Thread() {
			public void run() {
				while (true) {
					getUI().access(() -> clock.setValue(new Date().toString()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
		}.start();
		
		VerticalLayout header = new VerticalLayout();
		header.setWidth(100, Unit.PERCENTAGE);
		header.setMargin(false);
		header.addComponent(clock);
		header.setComponentAlignment(clock, Alignment.MIDDLE_RIGHT);
		header.addComponent(headline);
		header.setComponentAlignment(headline, Alignment.MIDDLE_CENTER);
		return header;
	}
	private Layout createUserInputArea() {
		HorizontalLayout userInputArea = new HorizontalLayout();
		userInputArea.setWidth(80, Unit.PERCENTAGE);
		
		TextField task = new TextField();
		Button add = new Button("");
		add.addStyleName(ValoTheme.BUTTON_PRIMARY);
		add.setIcon(VaadinIcons.ENVELOPE_O);
		
		userInputArea.addComponentsAndExpand(task);
		userInputArea.addComponents(add);
		
		add.addClickListener(click->{
			this.messagesBox.add(new Message(task.getValue()));
			task.clear();
			task.focus();
			
		});
		task.focus();
		add.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		
		return userInputArea;
	}	
	
//	stuff below is all the red*************************
	
//	WebSocketClient client = new StandardWebSocketClient();
//	 
//	WebSocketStompClient stompClient = new WebSocketStompClient(client);
//	stompClient.setMessageConverter(new MappingJackson2MessageConverter());
//	 
//	StompSessionHandler sessionHandler = new MyStompSessionHandler();
//	stompClient.connect("/topic/greetings", sessionHandler);
//	 
//	new Scanner(System.in).nextLine(); // Don't close immediately.

}



