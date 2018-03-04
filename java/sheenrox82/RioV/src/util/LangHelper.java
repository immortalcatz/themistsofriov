package sheenrox82.RioV.src.util;

import net.minecraft.util.StatCollector;

public class LangHelper {
	
	/**
	 * 
	 * @param key the key, should start with msg.riov.* (put this in the lang file!)
	 * @return translated string
	 * 
	 * @author xbony2 & shedar
	 */
	public static String translate(String key) {
		return StatCollector.translateToLocal(key);
	}
}
