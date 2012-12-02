package test;

import b.tree.BTree;
import b.tree.Registry;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTree btree = new BTree(2);
		
		Registry ret;
		Registry[] regs = new Registry [2];
		
		regs[0] = new Registry(20);
		regs[1] = new Registry(-30);
		
		for (Registry r: regs)
		{
			System.out.println("Adding reg " + r);
			try
			{
				btree.insert(r);
			}
			catch (Exception e)
			{
				System.err.println(e.toString());
				e.printStackTrace();
			}
		}
		
		System.out.println();
		for (Registry r: regs)
		{
			System.out.println("Searching reg " + r);
			ret = btree.find(r);
			System.out.println("Search result:  "+ ret);
		}
	}

}
