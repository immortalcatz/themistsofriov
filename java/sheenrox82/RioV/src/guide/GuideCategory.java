package sheenrox82.RioV.src.guide;

public interface GuideCategory {
	public String getTitle();
	public boolean hasOverride();
	public GuidePage[] getPages();
}