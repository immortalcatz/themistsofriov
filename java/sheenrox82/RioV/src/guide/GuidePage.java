package sheenrox82.RioV.src.guide;

import java.util.List;

import net.minecraft.util.ResourceLocation;

public interface GuidePage 
{
	public String getTitle();
	public boolean hasOverride();
	public String getParentCategory();
	public ResourceLocation getSketch();
	public String[] getContents(List<String> unlockedPages);
}