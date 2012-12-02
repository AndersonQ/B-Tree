package test;

import b.tree.BTree;
import b.tree.Registry;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BTree btree = new BTree(2);
		
		Registry r1, r2;
		
		r1 = new Registry(10);
		r2 = new Registry(20);
		
		System.out.println("Adding reg " + r1);
		try
		{
			btree.insert(r1);
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
			e.printStackTrace();
		}
		
		System.out.println("Adding reg " + r2);
		try
		{
			btree.insert(r2);
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
			e.printStackTrace();
		}
		
		/*
		System.out.println("Searching reg " + r1);
		Registry ret = btree.find(r1);
		System.out.println("Search result:  "+ ret);

		
		System.out.println("Adding reg " + r2);
		try
		{
			btree.insert(r2);
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
			e.printStackTrace();
		}

		System.out.println();*/
	}

}
