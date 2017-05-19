package framework.builder.create;

public class ProjectInfo {

	private String name;

	private boolean multi;

	private boolean samples;

	private ProjectType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMulti() {
		return multi;
	}

	public void setMulti(boolean multi) {
		this.multi = multi;
	}

	public boolean isSamples() {
		return samples;
	}

	public void setSamples(boolean samples) {
		this.samples = samples;
	}

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}

}
