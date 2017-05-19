package framework;

public interface Clickable<T> {

	public T addOnClick(EventListener l);
	
	public T addOnDoubleClick(EventListener l);
	
	
	
}
