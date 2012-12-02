package exception;

import b.tree.Registry;

public class PageFull extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PageFull()
	{
		super();
	}

	public PageFull(Registry r)
	{
		super(String.format("When tried to insert registry %s", r.toString()));
	}
	
	public PageFull(String s)
	{
		super(s);
	}
}
