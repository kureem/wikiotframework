package framework.lightning;

import framework.JSContainer;

public class Icon extends JSContainer {

	public final static String SMALL = "slds-button_icon_small";

	public final static String EXTRA_SMALL = "slds-_icon_x-small";

	public final static String EXTRA_EXTRA_SMALL = "slds-button_icon_xx-small";

	public final static String LARGE = "slds-button_icon_large";

	public final static String TEXT_DEFAULT = "slds-icon-text-default";

	public final static String TEXT_WARNING = "slds-icon-text-warning";

	public final static String TEXT_ERROR = "slds-icon-text-error";

	public final static String TEXT_LIGHT = "slds-icon-text-light";

	private String assetsUrl = "/lightning/assets/icons";

	private String type = "utility";

	private String iconName = "settings";

	public Icon(String name, String type, String iconName) {
		super(name, "div");
		this.type = type;
		this.iconName = iconName;
		refresh();

	}

	public Icon(String name) {
		super(name, "div");
		refresh();
	}

	public void refresh() {
		String html = "<svg class='slds-button__icon'><use xmlns:xlink=\"http://www.w3.org/1999/xlink\" xlink:href=\"/webjars/lightning/2.3.2/assets/icons/utility-sprite/svg/symbols.svg#settings\"></use></svg>";
		setHtml(html);
	}

	public String getAssetsUrl() {
		return assetsUrl;
	}

	public void setAssetsUrl(String assetsUrl) {
		this.assetsUrl = assetsUrl;
		refresh();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		refresh();
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String name) {
		this.iconName = name;
		refresh();
	}

	public Icon setSize(String size) {
		removeClass(EXTRA_EXTRA_SMALL).removeClass(EXTRA_SMALL).removeClass(LARGE).removeClass(SMALL);
		addClass(size);
		return this;
	}

	public Icon setTextType(String type) {
		removeClass(TEXT_DEFAULT).removeClass(TEXT_ERROR).removeClass(TEXT_LIGHT).removeClass(TEXT_WARNING)
				.addClass(type);
		return this;
	}

}
