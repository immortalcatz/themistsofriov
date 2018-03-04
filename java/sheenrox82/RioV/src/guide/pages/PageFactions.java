package sheenrox82.RioV.src.guide.pages;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.util.Util;

public class PageFactions implements GuidePage 
{
	public String getTitle()
	{
		return "Factions/Reputation";
	}

	public boolean hasOverride() 
	{
		return true;
	}

	public String getParentCategory()
	{
		return "Table of Contents";
	}

	private ResourceLocation res = new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/pages/" + "factions.png");

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
				"Factions and Reputation are two things that",
				"determine which God you are going to kill.",
				"Your reputation decides your faction. If you ",
				"have a positive reputation, you will be on ",
				Color.GREEN + "Jaerin" + Color.BLACK + ". If you are negative, you will be on ",
				Color.DARK_RED + "Raetiin" + Color.BLACK + ". Depending on your faction, certain",
				"RioV mobs will not attack you; mobs are on",
				"factions as well. You can find out their",
				"faction by looking at their nametags above",
				"them."
				};
	}
}