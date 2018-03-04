package sheenrox82.RioV.src.guide.pages;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.util.Util;

public class PageEosMagic implements GuidePage 
{
	public String getTitle()
	{
		return "Eos Magic";
	}

	public boolean hasOverride() 
	{
		return true;
	}

	public String getParentCategory()
	{
		return "Table of Contents";
	}

	private ResourceLocation res = new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/pages/" + "eosMagic.png");

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
				"Eos is an essential part of RioV as well, you",
				"need it to do certain things. You can",
				"monitor your Eos count by looking at the",
				"purple bar/text in the lower left-hand",
				"corner. You all have 50 max Eos, and this",
				"does regenerate. You can also use an Eos",
				"potion (found by killing Mages) to speed",
				"up the process. Eos is needed to use",
				"wands in the mod, and summon bosses or",
				"make portals."
				};
	}
}