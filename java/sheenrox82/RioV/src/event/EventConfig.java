package sheenrox82.RioV.src.event;

import sheenrox82.RioV.src.util.Registry;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventConfig
{
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) 
	{
		if(eventArgs.modID.equals(Util.MOD_ID))
		{
			Registry.syncConfig();
		}
	}
}
