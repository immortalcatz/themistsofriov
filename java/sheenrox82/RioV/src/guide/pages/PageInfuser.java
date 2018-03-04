package sheenrox82.RioV.src.guide.pages;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.util.Util;

public class PageInfuser implements GuidePage 
{
	public String getTitle()
	{
		return "Infuser";
	}

	public boolean hasOverride() 
	{
		return true;
	}

	public String getParentCategory()
	{
		return "Table of Contents";
	}

	private ResourceLocation res = new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/pages/" + "infuser.png");

	public ResourceLocation getSketch() 
	{
		return res;
	}

	public String[] getContents(List<String> unlockedPages) 
	{
		return new String[] 
				{ 
				Color.DARK_GREEN + getTitle(),
				"---------------",
				"The Infuser is a block, this ",
				"block is going to be very important",
				"throughout the mod. It is used to",
				"upgrade your armor and tools to further",
				"progress into the mod. To use this, kill",
				"Mages to obtain Orbs, these Orbs are ",
				"the fuel for the Infuser. Place the",
				"Orb in the far left slot in the Infuser",
				"window, and place your armor/tool in",
				"the middle slot and let the Infuser do ",
				"it's thing. Your tool will now be",
				"upgraded with better stats."
				};
	}
}