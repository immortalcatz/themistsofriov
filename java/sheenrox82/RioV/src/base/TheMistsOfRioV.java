package sheenrox82.RioV.src.base;

import sheenrox82.RioV.src.proxy.CommonProxy;
import sheenrox82.RioV.src.util.Registry;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Util.MOD_ID, name = Util.MOD_NAME, version = Util.VERSION, guiFactory = Util.GUI_FACTORY)
public class TheMistsOfRioV
{
	@Instance(Util.MOD_ID)
	public static TheMistsOfRioV INSTANCE;

	@SidedProxy(clientSide = Util.CLIENT, serverSide = Util.COMMON)
	public static CommonProxy commonProxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent initEvent)
	{
		Registry.preInit(initEvent);
	}

	@EventHandler
	public void init(FMLInitializationEvent initEvent)
	{
		Registry.init(initEvent);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent initEvent)
	{
		Registry.postInit(initEvent);
	}
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		Registry.serverLoad(event);
	}
}
