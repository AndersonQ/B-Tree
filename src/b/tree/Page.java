package b.tree;

public class Page {

	/** Total number of registry */
	private int numRegs;
	/** Array to storage registers */
	private Registry registers[];
	/** Array to storage children */
	private Page children[];
	/** A pointer to father */
	private Page father;
	/** the order of this B-tree */
	final int order;
	
	public Page(int order)
	{
		this.order = order;
		this.numRegs = 0;
		this.registers = null;
		this.children = null;
		this.father = null;
	}
	
	/**
	 * Concatenate ...
	 * @param child
	 * @param poschild
	 */
	public void catChild(Page child, int poschild)
	{
		
	}
	
	/** 
	 * Uncatenate ...
	 * @param posChild
	 * @return
	 */
	public void uncatChild(int posChild)
	{
	
	}
	
	/** 
	 * Verify if this page is a leaf
	 * @return true or false if this is full or not
	 */
	public boolean isFull()
	{
		return false;
	}
	
	/**
	 * Find a key and return its position or -1
	 * @param key a key to find
	 * @return the position of the key or -1 if it was not found
	 */
	public int findReg(int key)
	{
		return -1;
	}
	
	/**
	 * Insert a registry
	 * @param reg a registry to insert
	 */
	public void insertReg(Registry reg)
	{
		
	}
	
	/**
	 * Remove a registry and it returns the removed registry
	 * @return the removed registry
	 */
	public Registry removeReg()
	{
		return null;
		
	}
	
	/**
	 * Prints all elements
	 */
	public void listElements()
	{
		
	}
}
