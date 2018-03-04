package sheenrox82.RioV.src.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import cpw.mods.fml.common.registry.EntityRegistry;

public class MethodUtil 
{
	public static int id = 500;

	public static DamageSource causeArrowDamage(Entity entityRioVArrow, Entity par1Entity)
	{
		return (new EntityDamageSourceIndirect("arrow", entityRioVArrow, par1Entity)).setProjectile();
	}

	public static void registerEntity(Class<? extends Entity> entityClass, String entityName)
	{
		int entityID = Config.addEntity(entityName);
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, TheMistsOfRioV.INSTANCE, 128, 1, true);
	}

	@SuppressWarnings("unchecked")
	public static void registerEgg(Class<? extends Entity> entityClass)
	{
		int ID = uniqueEggID();
		EntityList.IDtoClassMapping.put(ID, entityClass);
		EntityList.entityEggs.put(ID, new EntityEggInfo(ID, 0xffffff, 0x000000));
	}

	public static int uniqueEggID()
	{
		return id++;
	}
}
