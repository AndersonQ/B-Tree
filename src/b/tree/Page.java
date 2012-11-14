package b.tree;

import java.util.Arrays;
import java.util.Comparator;

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
	
	/**
	 * Create a page to a B-tree with a order
	 * @param order the order of this page
	 */
	public Page(int order)
	{
		this.order = order;
		this.numRegs = 0;
		this.registers = new Registry [2 * order];
		this.children = new Page [2 * order + 1];
		this.father = null;
		
		//Initialise arrays
		for(Registry reg: registers)
		{
			reg = null;
		}
		for(Page p: children)
		{
			p = null;
		}
		
	}
	
	/**
	 * Get the number of registers
	 * @return the number of registers
	 */
	public int getNumRegs() {
		return numRegs;
	}

	/**
	 * Get the array of registers
	 * @return
	 */
	public Registry[] getRegisters() {
		return registers;
	}
	
	/**
	 * Get the key of a registry
	 * It should return a error if i is bigger then registers.lenght()
	 * @param i the index of the registry 
	 * @return the key of registry i
	 */
	public int getRegistryKey(int i)
	{
		return registers[i].getKey();
	}

	public Page[] getChildren() {
		return children;
	}
	
	/**
	 * Get a child page
	 * It should return a error if i is bigger then children.length()
	 * @param i the index of child page
	 * @return the child page i
	 */
	public Page getChild(int i)
	{
		return children[i];
	}

	public Page getFather() {
		return father;
	}

	public void setFather(Page father) {
		this.father = father;
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
	 * Verify is this page is a leaf
	 * @return true or false is this page is a leaf or not
	 */
	public boolean isLeaf()
	{
		return children[0] == null;
	}
	/** 
	 * Verify if this page is a leaf
	 * @return true or false if this is full or not
	 */
	public boolean isFull()
	{
		return (this.numRegs == (this.order * 2));
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
	 * Insert a registry, this method is called only if there is a empty
	 * space in this page!
	 * @param reg a registry to insert
	 */
	public void insertReg(Registry reg)
	{
		registers[numRegs++] = reg;
		//Sort registers, class Registry implements Comparable
		Arrays.sort(registers);
	}
	
	/**
	 * Insert a registry in a defined position, this method is called only if there is a empty
	 * space in this page!
	 * @param reg a registry to insert
	 * @param i the position where to insert reg
	 */
	public void insertReg(Registry reg, int i)
	{
		registers[i] = reg;
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
