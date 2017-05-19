package framework.builder;

import java.util.LinkedList;
import java.util.List;

import def.jquery.JQueryEventObject;
import framework.Event;
import framework.EventListener;
import framework.JSContainer;
import framework.JSFileExplorerModal;
import framework.JSTree;
import framework.Renderable;
import framework.TreeNode;
import framework.builder.create.JSNewWizard;
import framework.builder.create.ProjectInfo;
import framework.portal.JSButton;
import framework.portal.JSCol;
import framework.portal.JSDropdown;
import framework.portal.JSDropdownMenu;
import framework.portal.JSPage;
import framework.portal.JSRow;
import framework.portal.JSSecondarySideBar;
import framework.portal.JSSideBarWidget;
import framework.services.Component;
import framework.services.ComponentService;
import framework.services.FileService;
import framework.services.Layout;
import jsweet.lang.JSON;

public class JSBuilder extends JSPage implements EventListener {

	private JSRow row = new JSRow();

	private JSCol workspace = new JSCol("workspace");

	private JSCol actions = new JSCol("actions");

	private JSSecondarySideBar secondarySideBar = new JSSecondarySideBar("secondarySideBar");

	private ComponentService componentService = ComponentService.getInstance();

	private JSFileExplorerModal fileExplorer = null;

	private JSNewWizard createNew = null;
	
	private JSTree tree = new JSTree("structure");

	public JSBuilder() {
		super("JSBuilder");

		// alert();
	}

	@Override
	public void buildPage() {
		row.addChild(workspace);
		row.addChild(actions);
		workspace.setWidthLarge(10);
		workspace.setWidthMedium(10);
		actions.setWidthLarge(2);
		actions.setWidthMedium(2);
		actions.addChild(secondarySideBar);
		getContent().addChild(row);

		getHeader().setTitle("Application Builder");
		getHeader().hideTitle(true);

		for (Component c : componentService.getComponents()) {
			getHeader().addButtonItem(new JSComponent(c));
		}

		initFileExplorer();
		initFileMenu();
		initEditMenu();
		initAllProperties();
		initAppStructure();
		addClass("builder");
		workspace.addClass("workspace");
		actions.addClass("actions");
	}

	public void initFileExplorer() {
		try {
			fileExplorer = new JSFileExplorerModal("fileExplorerModal");
			addChild(fileExplorer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public void performAction(JSContainer source, Event<JQueryEventObject> evt) {
		if (source.getName().equals("open")) {
			fileExplorer.show();
		} else if (source.getName().equals("new")) {
			if (createNew == null) {
				createNew = new JSNewWizard("new", this);
				addChild(createNew);
			}
			createNew.show();
		}

	}

	public void createNew(ProjectInfo info) {
 
		try {
			rootLayout = new Layout();
			rootLayout.setComponentName("div");
			this.layoutName = info.getName();
			//save(layoutName, rootLayout);
			openLayout(rootLayout, workspace);
			refreshTreeStructure();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private String layoutName;
	private Layout rootLayout = new Layout();

	public void save(String name, Layout layout) throws Exception {
		String fileName = name + ".lt";
		FileService service = FileService.getInstance();
		JSON.stringify(layout, (a,b)->{
			
			return 1;
		}, 0);
		service.addObject(fileName, layout);
		service.flush();
	}

	public Layout loadLayout(String name) throws Exception {
		String fileName = name + ".lt";
		FileService service = FileService.getInstance();
		String json = service.readFile(fileName);

		Layout layout = (Layout) JSON.parse(json);
		return layout;
	}

	public void openLayout(Layout layout, Renderable parent) {
		ComponentService service = ComponentService.getInstance();
		JSContainer container = service.createInstance(layout, true);
		parent.addChild(container);
		for (Object childLayout : layout.getChildren()) {
			openLayout((Layout)childLayout, container);
		}
	}

	public JSSecondarySideBar getSideBar() {
		return secondarySideBar;
	}

	public void initProperties(String[] labels, String title) {
		List<FieldDefinition> definitions = new LinkedList<>();

		for (int i = 0; i < labels.length; i++) {
			FieldDefinition df1 = new FieldDefinition();
			df1.setType("lookup");
			df1.setName(labels[i]);
			definitions.add(df1);
		}

		JSPropertiesEditor pro = new JSPropertiesEditor("my prop", definitions);

		JSSideBarWidget widget = new JSSideBarWidget("prope");
		widget.close();
		widget.setTitle(title);
		widget.getTitleContainer().addClass("bg-grey");
		widget.getContent().addChild(pro);
		secondarySideBar.addWidget(widget);
		widget.pack(true);
	}

	public void initAppStructure() {
		
		JSSideBarWidget widget = new JSSideBarWidget("structure");

		TreeNode root = new TreeNode();
		root.setText("Main");
		List<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		TreeNode page = new TreeNode();
		page.setText("Page 1");
		root.getNodes().add(page);

		TreeNode pageHeader = new TreeNode();
		pageHeader.setText("Header");

		TreeNode pageBody = new TreeNode();
		pageBody.setText("Body");

		TreeNode pageFooter = new TreeNode();
		pageFooter.setText("Footer");

		page.getNodes().add(pageHeader);
		page.getNodes().add(pageBody);
		page.getNodes().add(pageFooter);

		widget.getContent().addChild(tree);
		getSideBar().addWidget(widget);
		// widget.pack(true);
		widget.setTitle("Structure");
		tree.setNodes(nodes);
	}
	
	public void refreshTreeStructure(){
		if(this.rootLayout != null){
			TreeNode root = new TreeNode();
			root.setText(rootLayout.getComponentName());
			root.setUserObject(rootLayout);
			for(Layout l : rootLayout.getChildren()){
				createNode(l, root);
			}
			List<TreeNode> nodes = new LinkedList<>();
			nodes.add(root);
			tree.setNodes(nodes);
		}
		
		
	}
	
	
	private void createNode(Layout l, TreeNode parent){
		TreeNode t = new TreeNode();
		t.setText(l.getComponentName());
		t.setUserObject(l);
		if(parent != null)
			parent.getNodes().add(t);
		for(Layout child : l.getChildren()){
			createNode(child, t);
		}
		
	}
	
	

	public void initDimensionProperties() {

		String[] labels = new String[] { "width", "height", "min-width", "min-height", "max-width", "max-height" };
		initProperties(labels, "Dimensions");
	}

	public void initPositioningProperties() {

		String[] labels = new String[] { "float", "position", "top", "right", "bottom", "left" };
		initProperties(labels, "Positions");
	}

	public void initAllProperties() {
		initDimensionProperties();
		initPositioningProperties();
		initBoxProperties();
	}

	public void initBoxProperties() {
		init4Sides("margin", "Margin");
		init4Sides("padding", "Padding");
		init4Sides("border", "Border");
	}

	public void init4Sides(String prefix, String title) {
		String[] labels = new String[] { prefix + "-top", prefix + "-right", prefix + "-bottom", prefix + "-left" };
		initProperties(labels, title);

	}

	public void initFileMenu() {
		JSButton fileButton = new JSButton("file").setText("File");
		fileButton.addClass("btn-link").addClass("btn-sm");
		JSDropdownMenu menuFile = new JSDropdownMenu("fileDrop");
		menuFile.addButton(new JSButton("new").setText("New").addOnClick(this));
		menuFile.addButton(new JSButton("open").setText("Open File").addOnClick(this));
		menuFile.addDivider();
		menuFile.addButton(new JSButton("close").setText("Close"));
		menuFile.addButton(new JSButton("closeAll").setText("Close All"));
		menuFile.addDivider();
		menuFile.addButton(new JSButton("save").setText("Save"));
		menuFile.addButton(new JSButton("saveAll").setText("Save All"));
		JSDropdown file = new JSDropdown(fileButton, menuFile);
		getOwner().getLeftNavBarGroup().addDropdownItem(file);
	}

	public void initEditMenu() {
		JSButton button = new JSButton("edit").setText("Edit");
		button.addClass("btn-link").addClass("btn-sm");
		JSDropdownMenu menu = new JSDropdownMenu("dropdownMenu");
		menu.addButton(new JSButton("undo").setText("Undo"));
		menu.addButton(new JSButton("redo").setText("Redo"));
		menu.addDivider();
		menu.addButton(new JSButton("cut").setText("Cut"));
		menu.addButton(new JSButton("copy").setText("Copy"));
		JSDropdown dropdown = new JSDropdown(button, menu);
		getOwner().getLeftNavBarGroup().addDropdownItem(dropdown);
	}

}
