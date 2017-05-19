package framework.services;

import framework.builder.JSBuilder;

public class NavigationService {
	
	public Node getRootNode(User user){
		Node root = new Node();
		root.setLabel("Main");
		
		Node dashboard = new Node();
		dashboard.setLabel("Dashboard");
		dashboard.setName("dashboard");
		dashboard.setActive(true);
		dashboard.setIcon("fa fa-home");
		dashboard.setParent(root);
		root.getChildren().add(dashboard);
		
		
		Node builder = new Node();
		builder.setLabel("Builder");
		builder.setName("builder");
		builder.setIcon("fa fa-cog");
		Page page = new Page();
		page.setImplementation(JSBuilder.class);
		page.setLabel("Application builder");
		page.setName("application-builder");
		builder.setPage(page);
		builder.setParent(root);
		root.getChildren().add(builder);
		
		return root;
	}

}
