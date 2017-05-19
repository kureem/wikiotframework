package framework.portal;

public interface InputField<T> {

	public T getValue();
	
	public void setValue(T val);
	
	public void setRawValue(String value);
	
}
