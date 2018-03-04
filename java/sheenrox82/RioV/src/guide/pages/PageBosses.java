package sheenrox82.RioV.src.guide.pages;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.util.Util;

public class PageBosses implements GuidePage 
{
	public String getTitle()
	{
		return "Bosses";
	}

	public boolean hasOverride() 
	{
		return true;
	}

	public String getParentCategory()
	{
		return "Table of Contents";
	}

	private ResourceLocation res = new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/pages/" + "bosses.png");

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
				"There are several bosses in this mod, and",
				"some are friendlydepending on your Faction",
				"(explained later on). Bosses are on",
				"Factions, too. Depending on your Faction,",
				"they will either attack you, or help",
				"you. Your main goal is to kill the opposing",
				"Faction's God. There are two Gods.",
				"Jaerin: Ti'Tun",
				"Raetiin: Aun'Tun",
				"If you are on Jaerin, you want to kill Aun'Tun.",
				"If you are on Raetiin, you want to kill Ti'Tun."
				};
	}
}