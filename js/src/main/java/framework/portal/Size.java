package framework.portal;

public enum Size {

	EXTRA_SMALL("xs"), SMALL("sm"),  LARGE("lg"), FULL("full");
	
	private final String prefix;

	private Size(String prefix) {
		this.prefix = prefix;
	}
	
	
	public boolean equalsName(String otherName) {
        return prefix.equals(otherName);
    }

    public String toString() {
       return this.prefix;
    }
	
	
	
}
