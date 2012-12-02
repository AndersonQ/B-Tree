package b.tree;

public class Registry implements Comparable<Registry>{

	private int key;
	
	/**
	 * Create a new registry with a defined key
	 * @param key
	 */
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
			/* null registries are bigger then anyone */
			if(r2 == null)
			{
				return 1;
			}
			else if(this.key > r2.getKey())
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
	
	public String toString()
	{
		return String.format("%d", this.key);	
	}
}
