package b.tree;

import exception.PageFull;

public class BTree {

	/** The root of this tree */
	Page root;
	/** A temporary 'pointer' to keep where is the key */
	Page page; //pt
	/** Order of the tree */
	int order;
	/** 2*order of the tree */
	int doubleorder;
	/** A boolean to indicate success or fail */
	boolean found; //f
	/** The position of the key in the page 'returned' by findB*/
	int pos; //g

	public BTree(int order) {
		this.root = new Page(order);
		this.order = order;
		this.doubleorder = 2 * this.order;
	}

	/**
	 * Find a registry
	 * @param reg a registry to find
	 * @return a registry or null if it fails
	 */
	public Registry find(Registry reg)
	{
		return find(reg, this.root);
	}
	
	/**
	 * Find a registry recursively
	 * @param reg a registry to look for
	 * @param p a page where look for reg
	 * @return the registry or null if it was not found
	 */
	private Registry find(Registry reg, Page p)
	{
		//Page not found!
		if(p == null)
		{
			return null;
		}

		int i = 0;
		//Get all registries from p
		Registry pageregistries[] = p.getRegistries();
		//Look for reg in pages of p until find a page with registry bigger then reg
		while( (i < p.getNumRegs()) && (reg.compareTo(pageregistries[i]) > 0) )
		{
			/* It only walk through array pageregistries, 
			 * until find a registry with key bigger or equal to reg
			 */
			i++;
		}
		//If reg was found! return the registry
		if(reg.compareTo(pageregistries[i]) == 0)
		{
			return pageregistries[i];
		}
		//If reg is lower then pageregistries[i], go search into p[i] 
		else if(reg.compareTo(pageregistries[i]) < 0)
		{
			return find(reg, p.getChild(i));
		}
		//Other wise, go search in p[i+1]
		else
		{
			return find(reg, p.getChild(i + 1));
		}
	}
	
	/**
	 * Insert a registry into the B-tree
	 * @param reg a registry to insert
	 * @throws Exception
	 */
	public void insert(Registry reg) throws Exception
	{
		insert(reg, this.root);
	}
	
	/**
	 * Insert a registry into the B-tree recursively
	 * @param reg reg a registry to insert
	 * @param p the page where try to insert reg
	 * @throws Exception Registry already exist!
	 */
	public void insert(Registry reg, Page p) throws Exception
	{
		//This index will be used in all method
		int i = 0;
		//Keep the father of p
		Page father = p;

		while(p != null)
		{
			//Searching where insert reg
			for(i = 0; i < p.getNumRegs(); i++)
			{
				//If the registry to be inserted already exist, throws exception
				if(reg.compareTo(p.getRegistry(i)) == 0)
				{
					throw new Exception(String.format("Registry with key " + reg.getKey() + " already exist!"));
				}
				//If it found a registry bigger then reg, so insert reg in page previous the bigger registry
				else if(reg.compareTo(p.getRegistry(i)) > 0)
				{
					//Skip the loop to insert reg
					break;
				}
			}
			
			//If p is a Leaf, then try insert reg into p
			if(p.isLeaf())
			{
				break;
			}
			//other wise, look for a leaf to insert reg
			else
			{
				father = p;
				p = p.getChild(i);
			}
		}
		
		//Trying to insert, if the page is full, split it!
		try
		{
			father.insertReg(reg);
		}
		catch(PageFull e)
		{
			System.out.println("\nSplitting...");
			split(p, reg);
		}
	}
	
	/**
	 * Splits a page to insert a registry
	 * @param p a page to be split
	 * @param r the registry to insert
	 */
	private void split(Page p, Registry r)
	{

	}
	
	/**
	 * Remove a registry
	 * @param reg a registry to remove
	 */
	public void removeReg(Registry reg) {

	}

	/**
	 * List all elements in-order
	 */
	public void listInOrder() {

	}	
}
