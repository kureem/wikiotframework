package framework;

public class Event<T> {

	private T nativeEvent;

	public Event(T nativeEvent) {
		super();
		this.nativeEvent = nativeEvent;
	}

	public T getNativeEvent() {
		return nativeEvent;
	}
	
	
	
	
}
