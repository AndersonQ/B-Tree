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
		Registry[] regs = new Registry [4];
		
		int j = regs.length;
		for (int i = 0; i < regs.length; i++)
		{
			regs[i] = new Registry((j)*10);
			j--;
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
		
		System.out.println();
		for (Registry r: regs)
		{
			System.out.println("Searching reg " + r);
			ret = btree.find(r);
			System.out.println("Search result:  "+ ret);
		}
	}

}
