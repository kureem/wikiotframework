package framework;

import framework.builder.Builder;

public class Main {

	public static void main(String[] args) {
	
		//new TestApp().render();
		 
		//new TestApp().render();
		new Builder("builder").render();
		 
		
		/*setTimeout(function(()->{
			c.render(document.getElementById("root"));
		}),5000);*/ 
		

	}

}
