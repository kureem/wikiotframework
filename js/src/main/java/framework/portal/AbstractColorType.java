package framework.portal;

import framework.JSContainer;

public class AbstractColorType extends JSContainer {

	private ColorType colorType;

	private String prefix = "";

	public AbstractColorType(String name, String tag, String prefix) {
		super(name, tag);
		this.prefix = prefix;
		addClass(prefix);
	}

	public AbstractColorType setColorType(ColorType type) {
		if (type != colorType) {
			if(colorType != null)
				removeClass(prefix + "-" + colorType.name().toLowerCase());
			colorType = type;
			addClass(prefix + "-" + colorType.name().toLowerCase());
		}

		return this;
	}

}
