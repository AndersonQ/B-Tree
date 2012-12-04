package b.tree;

import java.util.Comparator;

/**
 * Compare two registries even one or both of they are null
 * A null registry is bigger then any other
 * @author Anderson Queiroz <contato(at)andersonq(dot)eti(dot)br
 *
 */
public class CompareRegistries implements Comparator<Registry> {

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
}
