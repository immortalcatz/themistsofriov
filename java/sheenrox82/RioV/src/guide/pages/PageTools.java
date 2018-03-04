package sheenrox82.RioV.src.guide.pages;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.util.Util;

public class PageTools implements GuidePage 
{
	public String getTitle()
	{
		return "Tools";
	}

	public boolean hasOverride() 
	{
		return true;
	}

	public String getParentCategory()
	{
		return "Table of Contents";
	}

	private ResourceLocation res = new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/pages/" + "tools.png");

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
				"Tools are a very important part in this",
				"mod. They are heavily required to be",
				"upgraded and used to advance through",
				"dimensions, get materials to fight bosses,",
				"and more. There are new ores in every",
				"dimension to make tools out of. Some of",
				"these tools are very weak and some, strong.",
				"If you look at the handle of the tool you",
				"are making, it is very easy to determine",
				"the item you need.",
				"",
				"White = Skywood Sticks (Found in Sanctuatite)",
				"Black = Black Bones (Found in Nether)",
				"Red = Blood Sticks (Found in Flamonor)",
				"Blue = Glimmerwood Sticks (Found in Vaeryn)",
				"These are the main items you need to make",
				"tools. The weakest tool/armor set is the",
				Color.DARK_PURPLE + "Amethyst" + Color.BLACK + " set. The strongest is " + Color.DARK_PURPLE + "Aleris" + Color.BLACK + ", but the",
				Color.DARK_RED + "Supreme Aun'Tun " + Color.BLACK + "gear is stronger,",
				"however that is not a complete tool set."
				};
	}
}