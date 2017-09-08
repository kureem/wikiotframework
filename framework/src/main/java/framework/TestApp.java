package framework;

import static jsweet.dom.Globals.alert;

import jsweet.dom.Event;

public class TestApp extends JSContainer{

	public TestApp() {
		super("root", "div");
		setStyle("width", "200px");
		setStyle("height", "400px");
		setStyle("border", "solid 1px silver");
		
		JSContainer child = new JSContainer("div");
		child.setStyle("width", "100px").setStyle("height", "100px").setStyle("background-color", "steelblue");
		addChild(child);
		
		child.addEventListener(new EventListener() {
			
			@Override
			public void performAction(JSContainer source, Event evt) {
				
				alert("Hello world !!");
				
			}
		}, "click");
		
	}

}
