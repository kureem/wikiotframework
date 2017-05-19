package app;

import framework.mobile.ONSInput;
import framework.mobile.ONSPage;
import framework.mobile.ONSRow;

public class CHLogin extends ONSPage{

	private ONSInput email;
	
	private ONSInput password;
	
	
	public CHLogin() {
		super("Login");
		
		ONSRow logoRow = new ONSRow("d");
		addChild(logoRow);
		
		email = new ONSInput("email");
		email.setPlaceholder("E-mail Address");
		
		ONSRow emailRow = new ONSRow("dd");
		addChild(emailRow);
		
		emailRow.addChild(email);
		 
		
		ONSRow passwordRow = new ONSRow("dd");
		addChild(passwordRow);
		 
		password = new ONSInput("password");
		password.setType("password");
		passwordRow.addChild(password);
		
		
	}
	
	

}
