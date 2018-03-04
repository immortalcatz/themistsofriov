package sheenrox82.RioV.src.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.client.config.GuiConfig;
 
public class GuiRioVConfig extends GuiConfig 
{
	public GuiRioVConfig(GuiScreen parent) 
    {
        super(parent, new ConfigElement<Object>(Config.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Util.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath("The Mists of RioV Config"));
    }
}