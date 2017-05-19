package org.castafiore.ui;

import org.castafiore.mobile.EXIcon;
import org.castafiore.mobile.EXPage;
import org.castafiore.mobile.EXToolbar;
import org.castafiore.mobile.EXToolbarButton;

@SuppressWarnings("serial")
@org.springframework.stereotype.Component
public class Documentation extends EXApplication{
	
	
	private EXPage root = new EXPage("root");
	
	private EXToolbar toolbar = new EXToolbar("rtb");
	
	

	public Documentation() {
		super("documentation");
		addChild(root);
		root.addChild(toolbar);
		
		Container left =new EXContainer("left", "div").addClass("left");
		EXToolbarButton tbt = new EXToolbarButton("ltbt");
		EXIcon icon = new EXIcon("s");
		icon.setIcon("md-menu");
		tbt.addChild(icon);
		left.addChild(tbt);
		toolbar.addChild(left);
		
		//addChild(new EXPage("root").addChild(new EXButton("button")));
		/*
		 *  <div data-role="page" id="list-page">
        <div data-role="header" data-position="fixed" data-theme="c">
            <h1>TODO App</h1>
            <a href="#add-page" data-icon="add" class="ui-btn-right">Add</a>
        </div>
        <div data-role="content">
            <ul data-role="listview" data-inset="true" id="todo-list"></ul>
        </div>
    </div>

    <div data-role="page" id="add-page">
        <div data-role="header" data-position="fixed" data-theme="c">
            <h1>Add TODO</h1>
            <a href="#list-page" data-icon="back" class="ui-btn-left">back</a>
        </div>
        <div data-role="content">
            <input id="todo-title" type="text" placeholder="TODO Title">
            <textarea id="todo-body" style="height: 8em" placeholder="Description"></textarea>
            <input id="add-button" type="button" value="Save" onclick="addTodo()">
            <input id="add-button" type="button" value="Picture And Save" onclick="addTodoPicture()"  data-theme="b">
        </div>
    </div>
		 */
		
	}

}
