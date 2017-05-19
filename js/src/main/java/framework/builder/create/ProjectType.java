package framework.builder.create;

public class ProjectType {

	private String name;

	private String label;

	private String icon;

	public ProjectType(String name, String label, String icon) {
		super();
		this.name = name;
		this.label = label;
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
