package b.tree;

import java.util.Arrays;
import java.util.Comparator;

import exception.PageFull;

public class Page {

	/** Total number of registry */
	private int numRegs;
	/** Array to storage registers */
	private Registry registries[];
	/** Array to storage children */
	private Page children[];
	/** A pointer to father */
	private Page father;
	/** the order of this Page */
	final int order;
	
	/**
	 * Create root to a B-tree with a order
	 * @param order the order of this page
	 */
	public Page(int order)
	{
		this.order = order;
		this.numRegs = 0;
		this.registries = new Registry [2 * order];
		this.children = new Page [2 * order + 1];
		this.father = null;
		
		//Initialise arrays
		for(Registry reg: registries)
		{
			reg = null;
		}
		for(Page p: children)
		{
			p = null;
		}
	}
	
	/**
	 * Create a page to a B-tree with a order
	 * @param the father of this new page
	 * @throws Exception The argument must NOT be null!
	 */
	public Page(Page father) throws Exception
	{
		if (father == null)
		{
			throw new Exception("The argument must NOT be null!");
		}
		this.order = father.getOrder();
		this.numRegs = 0;
		this.registries = new Registry [2 * order];
		this.children = new Page [2 * order + 1];
		this.father = father;
		
		//Initialise arrays
		for(Registry reg: registries)
		{
			reg = null;
		}
		for(Page p: children)
		{
			p = null;
		}
	}
	
	/**
	 * Get the number of registries
	 * @return the number of registries
	 */
	public int getNumRegs() {
		return numRegs;
	}
	
	/**
	 * Set the number of registries
	 * @param n new number of registries
	 */
	public void setNumRegs(int n)
	{
		numRegs = n;
	}

	/**
	 * Get the array of registers
	 * @return
	 */
	public Registry[] getRegistries() {
		return registries;
	}
	
	/**
	 * Get the registry i
	 * TODO It should return a error if i is bigger then registers.lenght()
	 * @param i
	 * @return
	 */
	public Registry getRegistry(int i)
	{
		return registries[i];
	}
	
	/**
	 * Get the key of a registry
	 * TODO It should return a error if i is bigger then registries.lenght()
	 * @param i the index of the registry 
	 * @return the key of registry i
	 */
	public int getRegistryKey(int i)
	{
		return registries[i].getKey();
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
	
	public void setChild(int i, Page p)
	{
		children[i] = p;
	}

	public Page getFather() {
		return father;
	}
	
	public int getOrder() {
		return order;
	}
	
	/**
	 * Insert a page in a position
	 * @param page the page to be inserted
	 * @param pos the position to insert the page
	 */
	public void insertPage(Page page, int pos)
	{
		children[pos] = page;
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
	 * Verify if this page is a leaf
	 * @return true or false is this page is a leaf or not
	 */
	public boolean isLeaf()
	{
		return children[0] == null;
	}
	
	/** 
	 * Verify if this page has the maximum number of registries
	 * @return true or false if this is full or not
	 */
	public boolean isFullOfRegistries()
	{
		return (this.numRegs == (this.order * 2));
	}
	
	/** 
	 * Verify if this page has the maximum number of registries
	 * @return true or false if this is full or not
	 */
	public boolean isFullOfPages()
	{
		return (this.numRegs == ((this.order * 2) + 1));
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
	 * @throws Exception 
	 */
	public void insertReg(Registry reg) throws Exception
	{
		//System.out.println("Page.insertReg(Registry reg): numRegs: " + this.numRegs);
		if(this.numRegs == this.order * 2)
			throw new PageFull(reg);
		
		registries[numRegs++] = reg;

		Arrays.sort(registries, new Comparator<Registry>()
				{
					@Override
					public int compare(Registry r1, Registry r2)
					{
						/*null registries are bigger then anyone*/
						//Both are null 
						if(r1 == null && r2 == null)
						{
							return 0;
						}
						//r2 is null, so r2 is bigger than r1
						else if(r2 == null)
						{
							return -1;
						}
						//r1 is null, so r1 is bigger then r1
						else if(r1 == null)
						{
							return 1;
						}
						else if(r1.getKey() > r2.getKey())
						{
							return 1;
						}
						else if(r1.getKey() < r2.getKey())
						{
							return -1;
						}
						else
						{
							return 0;
						}
					}
				});
		
		System.out.print(": Page.insertReg(Registry reg): this.registries after sort: ");
		for(Registry r: registries)
		{
			System.out.print(r + ", ");
		}
		System.out.println();
	}
	
	/**
	 * Insert a registry in a defined position, this method is called only if there is a empty
	 * space in this page!
	 * @param reg a registry to insert
	 * @param i the position where to insert reg
	 */
	public void insertReg(Registry reg, int i)
	{
		registries[i] = reg;
		numRegs++;
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
