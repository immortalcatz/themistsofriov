package sheenrox82.RioV.src.guide.pages;

import java.util.List;

import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.util.Util;

public class PageDimensions implements GuidePage 
{
	public String getTitle()
	{
		return "Dimensions";
	}

	public boolean hasOverride() 
	{
		return true;
	}

	public String getParentCategory()
	{
		return "Table of Contents";
	}

	private ResourceLocation res = new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/pages/" + "dimensions.png");

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
				"Dimensions are a huge part of this mod.",
				"You will use these dimensions to fight bosses",
				"and mine for tools and gather unique food.",
				"There are four dimensions, each consisting ",
				"of deadly mobs, and dangerous landscapes.",
				"Such as: deadly black liquid, tall and",
				"steep mountains and floating islands.",
				"Certain bosses can only be spawned in",
				"certain dimensions, the boss summoning",
				"crystals will tell you which dimension",
				"to spawn the boss in.",
				"",
				"Here is a list of the new dimensions in RioV:",
				"1. Blind Oasis: The first dimension, a dark place.",
				"2. Vaeryn: A blue world, with deadly creatures.",
				"3. Flamonor: A blood-red hell.",
				"4. Sanctuatite: A sanctuary."
				};
	}
}