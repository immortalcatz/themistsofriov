package sheenrox82.RioV.src.guide.pages;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.util.Util;

public class PageGettingStarted implements GuidePage 
{
	public String getTitle() {
		return "Getting Started";
	}

	public boolean hasOverride() {
		return true;
	}

	public String getParentCategory() {
		return "Table of Contents";
	}

	private ResourceLocation res = new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/pages/" + "gettingStarted.png");

	public ResourceLocation getSketch() 
	{
		return res;
	}

	public String[] getContents(List<String> unlockedPages) {
		return new String[] 
				{ 
				Color.DARK_GREEN + getTitle(),
				"-----------------",
				"Welcome to " + Util.MOD_NAME + ". This will",
				"be a difficult and frustrating mod",
				"as you advance throughout it.",
				"To get started, do as you would",
				"normally do in Minecraft. Gather",
				"wood, make a house, etc. Once you",
				"get an Iron Pickaxe, proceed to find",
				"Onyx Ore (It is a black colored ore",
				"in the Overworld) and mine it. Gather",
				"Amethyst too, if you wish, but it's not ",
				"as good as Onyx. Next travel to the",
				"Nether to find Black Bone. Black Bone",
				"is found by killing Skeletal Horses in",
				"the Nether. Once you have these materials,",
				"you need a RioV Anvil. To make this, get",
				"Red Wool and Slate Bricks (Slate is",
				"like stone, found in Overworld) and",
				"make the anvil. Combine the Black Bones",
				"and the Onyx to make an Onyx Pickaxe.",
				"However, not all tools in this mod need",
				"Black Bones. Some need sticks! These",
				"sticks/other handles can be found in",
				"the dimension the material for the",
				"tools are in."
				};
	}
}