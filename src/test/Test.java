package test;

import b.tree.BTree;
import b.tree.Registry;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BTree btree = new BTree(2);
		
		Registry ret;
		Registry[] regs = new Registry [15];
		Registry r30, r29;
		
		r30 = new Registry(30);
		r29 = new Registry(29);
		
		//int j = regs.length;
		for (int i = 0; i < regs.length; i++)
		{
			regs[i] = new Registry((i+1));
			//j--;
		}
		
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
		
		btree.insert(r30);
		btree.insert(r29);
		
		System.out.println();
		for (Registry r: regs)
		{
			System.out.println("Searching reg " + r);
			ret = btree.find(r);
			System.out.println("Search result:  "+ ret);
			System.out.println();
		}
		
		System.out.println("Searching reg " + r30);
		ret = btree.find(r30);
		System.out.println("Search result:  "+ ret);
		System.out.println();
		
		System.out.println("\nPrinting B-Tree...\n" + btree.toString());
	}
}
