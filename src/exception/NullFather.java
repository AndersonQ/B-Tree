package exception;

public class NullFather extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullFather()
	{
		super("The father must NOT be null when create a new page!");
	}
	
	public NullFather(String s)
	{
		super(String.format("The father must NOT be null when create a new page!\n%s", s));
	}
}
