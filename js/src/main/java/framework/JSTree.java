package framework;

import static jsweet.dom.Globals.alert;
import static jsweet.lang.Globals.eval;
import static jsweet.util.Globals.function;

import java.util.LinkedList;
import java.util.List;

import jsweet.lang.Array;
import jsweet.lang.Function;
import jsweet.lang.JSON;
import jsweet.lang.Object;

public class JSTree extends JSContainer {

	private List<TreeNode> nodes = new LinkedList<>();

	private JSContainer tree_ = new JSContainer("ul");

	public JSTree(String name) {
		super(name, "div");
		//addClass("tree-default");
		addChild(tree_);
	}

	public List<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeNode> nodes) {
		tree_.getChildren().clear();
		this.nodes = nodes;
		setRendered(false);
		renderNodes(nodes, tree_);
	}

	protected void renderNodes(List<TreeNode> nodes, Renderable parent) {

		for (TreeNode node : nodes) {
			JSContainer li = new JSContainer("li");
			parent.addChild(li);

			// li.addChild(new JSContainer("span").addClass("icon icon-node"));
			li.addChild(new JSContainer("span").setHtml(node.getText()));
			if (node.getNodes().size() > 0) {
				// li.addChild(new JSContainer("span").addClass("icon
				// expand-icon glyphicon glyphicon-plus"));
				JSContainer tree = new JSContainer("ul");
				li.addChild(tree);
				renderNodes(node.getNodes(), tree);
			}

		}
	}

	@Override
	public void render() {
		
		
		// TODO Auto-generated method stub
		super.render();
		Object dnd = new Object();
		Object edit = new Object();
		edit.$set("adjustWidthOfs", 0);
	 	edit.$set("inputCss", JSON.parse("{\"minWidth\": \"0\"}"));
		edit.$set("triggerStart", new Array<>("f2", "dblclick", "shift+click", "mac+enter"));

		
		Object options = new Object();

		Function dragStart = function((a, b) -> {
			// alert(a);
		}); // new Function("node", "data");
		Function dragEnter = function((a, b) -> {
			// alert(a);

		});
		
		Function save = function((event, data) -> {
			// alert(a);
			Object b = (Object)data;
			alert("save " + b.$get("input")); 
			//alert(data.);
		});
		
		edit.$set("save", save);

		Function dragDrop = function((node, data) -> {
			// alert(a);
			eval("data.otherNode.moveTo(node, data.hitMode);");
		});
		options.$set("checkbox", false);
		options.$set("selectMode", 1);
		options.$set("extensions", new Array<>("dnd", "edit"));
	//	dnd.$set("autoExpandMS", 400);
		dnd.$set("focusOnClick", true);
		//dnd.$set("preventVoidMoves", true);
		//dnd.$set("preventRecursiveMoves", true);
		dnd.$set("dragStart", dragStart);
		dnd.$set("dragEnter", dragEnter);
		dnd.$set("dragDrop", dragDrop);
		options.$set("dnd", dnd);
		options.$set("edit", edit);
		options.$set("init", function((a, b) -> {

			eval("$('.has-tooltip .fancytree-title').tooltip()");
		}));

		//eval("$(" + "\"#" + getId() + "\").fancytree(options)");
	}

}
