package sheenrox82.RioV.src.guide;

import sheenrox82.RioV.src.guide.pages.PageBosses;
import sheenrox82.RioV.src.guide.pages.PageDimensions;
import sheenrox82.RioV.src.guide.pages.PageEosMagic;
import sheenrox82.RioV.src.guide.pages.PageFactions;
import sheenrox82.RioV.src.guide.pages.PageGettingStarted;
import sheenrox82.RioV.src.guide.pages.PageInfuser;
import sheenrox82.RioV.src.guide.pages.PageTools;


public class CategoryTableOfContents implements GuideCategory {
	public String getTitle() {
		return "Table of Contents";
	}
	
	public boolean hasOverride() {
		return true;
	}
	
	public GuidePage[] getPages()
	{
		return new GuidePage[] { new PageGettingStarted(), new PageTools(), new PageInfuser(), new PageDimensions(), new PageBosses(), new PageEosMagic(), new PageFactions() };
	}
}