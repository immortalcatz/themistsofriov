package sheenrox82.RioV.src.util;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.nei.RioVNEI;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ExpansionChecker 
{
	public static void check()
	{
		try
		{
			Class.forName("optifine.OptiFineClassTransformer");
			RioVAPI.getInstance().optifine = true;
			RioVAPI.getInstance().getLogger().info("Optifine detected! Disabling RioV capes for safety measures!");
		}
		catch (Throwable var11)
		{
			FMLLog.info("Optifine not detected! RioV Capes is activating using DeveloperCapes by Jadar.");
			RioVAPI.getInstance().optifine = false;
		}

		if(Loader.isModLoaded("Natura"))
		{
			RioVAPI.getInstance().natura = true;
			RioVAPI.getInstance().getLogger().info("Natura detected! You get the Natura Expansion for RioV! :)");

			if(RioVAPI.getInstance().natura)
			{
				RioVItems.addNatura();
			}
		}
		else
		{
			RioVAPI.getInstance().natura = false;
			RioVAPI.getInstance().getLogger().info("Natura wasn't detected... No Natura Expansion for you. :(");
		}

		if(Loader.isModLoaded("Baubles"))
		{
			RioVAPI.getInstance().baubles = true;
			RioVAPI.getInstance().getLogger().info("Baubles detected! You get the Baubles Expansion for RioV! :)");

			if(RioVAPI.getInstance().baubles == true)
			{
				RioVItems.addBaubles();
			}
		}
		else
		{
			RioVAPI.getInstance().baubles = false;
			RioVAPI.getInstance().getLogger().info("Baubles wasn't detected... No Baubles Expansion for you. :(");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void checkNEI()
	{
		if (Loader.isModLoaded("NotEnoughItems"))
		{
			RioVAPI.getInstance().nei = true;
			RioVAPI.getInstance().getLogger().info("NEI detected! RioV NEI integration is being added!");

			if(RioVAPI.getInstance().nei == true)
			{
				RioVNEI.addNEI();
			}
		}
		else
		{
			RioVAPI.getInstance().nei = false;
			RioVAPI.getInstance().getLogger().info("NEI was not detected, no RioV NEI integration for you. :(");
		}
	}
}
