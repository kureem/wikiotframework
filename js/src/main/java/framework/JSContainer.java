package framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import framework.portal.Designable;
import framework.renderer.ContainerRenderer;
import framework.renderer.Renderer;
import jsweet.lang.JSON;

public class JSContainer extends JSDraggable implements Designable{ 

	private final static Renderer<? extends JSContainer> DEFAULT_RENDERER = new ContainerRenderer();

	private Map<String, List<EventListener>> listeners = new HashMap<>();

	private String id;

	private Object data;

	private Map<String, String> attributes = new HashMap<>();

	private Map<String, String> styles = new HashMap<>();

	private JSContainer parent;

	private List<JSContainer> children = new LinkedList<>();

	private String html = "";

	private String tag = "";

	private String name = "";

	private boolean rendered = false;

	private List<Renderer<? extends JSContainer>> renderers = new ArrayList<>();

	private List<String> changedAttributes = new LinkedList<>();

	private List<String> changedStyles = new LinkedList<>();
	
	private List <JSCommand> commands = new LinkedList<>();

	public JSContainer(String name, String tag) {
		super();
		this.tag = tag;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getChangedAttributes()
	 */
	@Override
	public String[] getChangedAttributes() {
		return changedAttributes.toArray(new String[changedAttributes.size()]);
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getChangedStyles()
	 */
	@Override
	public String[] getChangedStyles() {
		return changedStyles.toArray(new String[changedStyles.size()]);
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#flush(java.lang.String)
	 */
	public void flush(String s) {
		if (s.equals("a28n12l10")) {
			changedAttributes.clear();
			changedStyles.clear();
			commands.clear();
		}
	}

	public JSContainer(String tag) {
		super();
		this.tag = tag;
		// addClass(this.getClass().getSimpleName());
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getRenderers()
	 */
	@Override
	public List<Renderer<? extends JSContainer>> getRenderers() {
		return renderers;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#addRenderer(framework.renderer.Renderer)
	 */
	@Override
	public JSContainer addRenderer(Renderer<? extends JSContainer> renderer) {
		if (!this.renderers.contains(renderer)) {
			renderers.add(renderer);
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getId()
	 */
	@Override
	public String getId() {
		if (id == null) {
			id = uid();
		}

		return id;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#uid()
	 */
	@Override
	public String uid() {

		Static.idCount++;
		return Static.idCount + "";
		// String s= System.currentTimeMillis() + "_" + Math.random();
		// s = s.replace('.', '_');
		// return s;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#addClass(java.lang.String)
	 */
	@Override
	public JSContainer addClass(String styleClass) {
		String styles = getAttribute("class");
		if (styles == null) {
			styles = "";
		}
		String[] aStyles = styles.split(" ");

		boolean add = true;
		for (String style : aStyles) {
			if (style.trim().equals(styleClass)) {
				add = false;
			}
		}
		if (add)
			setAttribute("class", styles.trim() + " " + styleClass);

		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#removeClass(java.lang.String)
	 */
	@Override
	public JSContainer removeClass(String cls) {
		String cl = getAttribute("class");
		cl = cl.replace(cls, "");

		setAttribute("class", cl);
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#addChild(framework.JSContainer)
	 */
	@Override
	public JSContainer addChild(JSContainer container) {
		container.parent = this;
		children.add(container);
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#addChildAt(int, framework.JSContainer)
	 */
	@Override
	public JSContainer addChildAt(int index, JSContainer child) {
		child.parent = this;
		children.add(index, child);
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setVisible(boolean)
	 */
	@Override
	public JSContainer setVisible(boolean b) {
		if (!b) {
			setStyle("display", "none");
		} else {
			styles.remove("display");
			setRendered(false);
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#addEventListener(framework.EventListener, java.lang.String)
	 */
	@Override
	public JSContainer addEventListener(EventListener listener, String type) {
		if (!listeners.containsKey(type)) {
			listeners.put(type, new ArrayList<>());
		}

		if (!listeners.get(type).contains(listener)) {
			listeners.get(type).add(listener);
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getTag()
	 */
	@Override
	public String getTag() {
		return tag;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setTag(java.lang.String)
	 */
	@Override
	public JSContainer setTag(String tag) {
		this.tag = tag;
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setStyle(java.lang.String, java.lang.String)
	 */
	@Override
	public JSContainer setStyle(String key, String value) {
		changedStyles.add(key);
		styles.put(key, value);
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getStyle(java.lang.String)
	 */
	@Override
	public String getStyle(String key) {
		return styles.get(key);
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setAttribute(java.lang.String, java.lang.String)
	 */
	@Override
	public JSContainer setAttribute(String key, String value) {
		changedAttributes.add(key);
		attributes.put(key, value);
		return this;
	}
	

	/* (non-Javadoc)
	 * @see framework.JSContainer_#exec(java.lang.String, jsweet.lang.Object)
	 */
	@Override
	public void exec(String name, jsweet.lang.Object parameter){
		commands.add(new JSCommand(name, JSON.stringify(parameter)));
	}
	
	/* (non-Javadoc)
	 * @see framework.JSContainer_#exec(java.lang.String, java.lang.String)
	 */
	@Override
	public void exec(String name, String variable){
		commands.add(new JSCommand(name, variable));
	}
	
	/* (non-Javadoc)
	 * @see framework.JSContainer_#exec(java.lang.String)
	 */
	@Override
	public void exec(String name){
		exec(name,(String) null);
	}
	
	/* (non-Javadoc)
	 * @see framework.JSContainer_#getCommands()
	 */
	@Override
	public Iterable<JSCommand> getCommands(){
		return commands;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getAttribute(java.lang.String)
	 */
	@Override
	public String getAttribute(String key) {
		return attributes.get(key);
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getParent()
	 */
	@Override
	public JSContainer getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getChildren()
	 */
	@Override
	public List<JSContainer> getChildren() {
		return children;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getStyleNames()
	 */
	@Override
	public Set<String> getStyleNames() {
		return styles.keySet();
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getAttributeNames()
	 */
	@Override
	public Set<String> getAttributeNames() {
		return attributes.keySet();
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getHtml()
	 */
	@Override
	public String getHtml() {
		return html;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setHtml(java.lang.String)
	 */
	@Override
	public JSContainer setHtml(String h) {
		this.html = h;
		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#isRendered()
	 */
	@Override
	public boolean isRendered() {
		return rendered;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setRendered(boolean)
	 */
	@Override
	public JSContainer setRendered(boolean b) {
		this.rendered = b;
		if (!b) {
			for (JSContainer child : children) {
				child.setRendered(b);
			}
		}

		return this;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getListeners()
	 */
	@Override
	public Map<String, List<EventListener>> getListeners() {
		return listeners;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#render()
	 */
	@Override
	public void render() {
		if (renderers.isEmpty()) {
			renderers.add(DEFAULT_RENDERER);
		}
		for (Renderer<?> renderer : renderers)
			renderer.doRender(this);

		for (JSContainer child : getChildren()) {
			child.render();
		}
		rendered = true;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getData()
	 */
	@Override
	public Object getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setData(java.lang.Object)
	 */
	@Override
	public void setData(Object data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getAncestorOfType(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public <T extends JSContainer> T getAncestorOfType(Class<T> classType) {
		// if (classType.isAssignableFrom(getClass()))
		// return (T) this;

		if (parent == null) {
			return null;
		}
		if (parent.getClass().getName().equals(classType.getName())) {
			// if (classType.isAssignableFrom(parent.getClass())) {
			return (T) parent;
		} else {
			return ((JSContainer)parent).getAncestorOfType(classType);
		}
	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getAncestorById(java.lang.String)
	 */
	@Override
	public JSContainer getAncestorById(String id) {
		if (getId().equals(id))
			return (JSContainer) this;

		if (parent == null) {
			return null;
		}

		return parent.getAncestorById(id);

	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getAncestorByName(java.lang.String)
	 */
	@Override
	public JSContainer getAncestorByName(String name) {
		if (getName().equals(name))
			return this;

		if (parent == null) {
			return null;
		}

		return parent.getAncestorByName(name);
	}
	
	

	/* (non-Javadoc)
	 * @see framework.JSContainer_#getRoot()
	 */
	@Override
	public JSContainer getRoot() {
		if (parent == null) {
			return this;
		} else {
			return parent.getRoot();
		}
	}

	public class JSCommand {
		private String name;

		private jsweet.lang.Object parameters;
		
		private String variable;

		
		
		public JSCommand(String name, String vari) {
			super();
			this.name = name;
			this.variable = vari;
		}
		
		public String getVariable(){
			return this.variable;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public jsweet.lang.Object getParameters() {
			return parameters;
		}

		public void setParameters(jsweet.lang.Object parameters) {
			this.parameters = parameters;
		}

	}

	/* (non-Javadoc)
	 * @see framework.JSContainer_#setParameters(java.util.Map)
	 */
	@Override
	public void setParameters(Map<String, String> parameters) {
		
	}
}
