package b.tree;

public class Registry implements Comparable<Registry>{

	private int key;
	
	public Registry(int key)
	{
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	/**
	 * List all elements
	 */
	public void listElements()
	{
		
	}

	@Override
	public int compareTo(Registry r2)
	{
			if(this.key > r2.getKey())
			{
				return 1;
			}
			else if (this.key < r2.getKey())
			{
				return -1;
			}
			else
			{
				return 0;
			}
	}	
}
