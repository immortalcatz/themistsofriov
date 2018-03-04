package sheenrox82.RioV.src.guide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.lib.RioVLib;

public class GuideHelper 
{	
	private static HashMap<String, ArrayList<String>> journals = new HashMap<String, ArrayList<String>>();
	private static List<GuideCategory> journalCategories = null;

	public static void clientInit() {
		journalCategories = new ArrayList<GuideCategory>();
		journalCategories.add(new CategoryTableOfContents());
	}

	public static String serializeInfo(String player)
	{
		if(journals.containsKey(player)) {
			String info = "";
			for(int i = 0; i < journals.get(player).size(); i++)
				info += journals.get(player).get(i) + ";";
			return info;
		}

		return "";
	}

	public static List<String> deserializeInfo(String info)
	{
		if(info != null && info.contains(";"))
			return Arrays.asList(info.split(";"));
		return null;
	}

	public static void addNewJournal(String owner) 
	{
		if(!journals.containsKey(owner))
			journals.put(owner, new ArrayList<String>());
	}

	public static String openingJournalInfo = "";

	public static void openJournal(EntityPlayer player, String info) 
	{
		openingJournalInfo = info;
		player.openGui(TheMistsOfRioV.INSTANCE, RioVLib.guideID, player.worldObj, 0, 0, 0);
	}

	public static List<GuideCategory> getCategories() 
	{
		if(journalCategories == null)
			clientInit();
		return journalCategories;
	}

	public static boolean hasPageInCategory(GuideCategory cat, List<String> unlockedPages)
	{
		for(GuidePage page : cat.getPages())
		{
			if(page.hasOverride())
				continue;
			for(String unlocked : unlockedPages)
				if(page.getTitle().equals(unlocked))
					return true;
		}
		return false;
	}
}