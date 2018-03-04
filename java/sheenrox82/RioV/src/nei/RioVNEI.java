package sheenrox82.RioV.src.nei;

import sheenrox82.RioV.src.api.base.RioVAPI;
import codechicken.nei.api.API;

public class RioVNEI 
{
	public static void addNEI()
	{
		if(RioVAPI.getInstance().nei == true)
		{
			API.registerRecipeHandler(new AnvilNEI());
			API.registerUsageHandler(new AnvilNEI());
		}
	}
}
