package sheenrox82.RioV.src.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RioVAPIUtil 
{
	public final String mod_id = getUtilString("MOD_ID");
	public final String mod_name = getUtilString("MOD_NAME");
	public final String version = getUtilString("VERSION");

	public static void registerItem(Item item, String string)
	{
		GameRegistry.registerItem(item, string);	
	}

	public static void registerBlock(Block block, String string)
	{
		GameRegistry.registerBlock(block, string);
	}

	public String getName(String unlocalizedName) 
	{
		return unlocalizedName.substring(unlocalizedName.lastIndexOf(".") + 1);
	}

	public void registerDimension(int id, Class<? extends WorldProvider> worldProvider)
	{
		DimensionManager.registerProviderType(id, worldProvider, true);
		DimensionManager.registerDimension(id, id);
	}

	/**
	 * Get a RioV Item using a string.
	 * 
	 * @param itemName - Object name in RioVItems.java (check Github).
	 */
	public Item getRioVItem(String itemName)
	{
		try
		{
			Class<?> riovItems = Class.forName("sheenrox82.RioV.src.content.RioVItems");
			Item itemToGet = (Item)riovItems.getDeclaredField(itemName).get(null);
			return itemToGet;
		}
		catch(Exception e)
		{
			//If it can't find the item it will revert 
			//to this until the item is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return Items.IRON_SHOVEL;
		}
	}

	/**
	 * Get a RioV Block using a string.
	 * 
	 * @param blockName - Object name in RioVBlocks.java (check Github).
	 */
	public Block getRioVBlock(String blockName)
	{
		try
		{
			Class<?> riovBlocks = Class.forName("sheenrox82.RioV.src.content.RioVBlocks");
			Block blockToGet = (Block)riovBlocks.getDeclaredField(blockName).get(null);
			return blockToGet;
		}
		catch(Exception e)
		{
			//If it can't find the block it will revert 
			//to this until the block is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return Blocks.STONE;
		}
	}

	/**
	 * Get a RioV Enchantment using a string.
	 * 
	 * @param enchantmentName - Object name in Enchantments.java (check Github).
	 */
	public Enchantment getRioVEnchantment(String enchantmentName)
	{
		try
		{
			Class<?> riovEnchants = Class.forName("sheenrox82.RioV.src.content.Enchantments");
			Enchantment enchantToGet = (Enchantment)riovEnchants.getDeclaredField(enchantmentName).get(null);
			return enchantToGet;
		}
		catch(Exception e)
		{
			//If it can't find the enchantment it will revert 
			//to this until the enchantment is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return Enchantments.PROTECTION;
		}
	}

	/**
	 * Get a RioV Biome using a string.
	 * 
	 * @param biomeName - Object name in Biomes.java (check Github).
	 */
	public Biome getRioVBiome(String biomeName)
	{
		try
		{
			Class<?> riovBiomes = Class.forName("sheenrox82.RioV.src.content.Biomes");
			Biome biomeToGet = (Biome)riovBiomes.getDeclaredField(biomeName).get(null);
			return biomeToGet;
		}
		catch(Exception e)
		{
			//If it can't find the biome it will revert 
			//to this until the biome is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return Biomes.PLAINS;
		}
	}

	/**
	 * Get a RioV Sound using a string.
	 * 
	 * @param soundName - Object name in Sounds.java (check Github).
	 */
	public String getRioVSound(String soundName)
	{
		try
		{
			Class<?> riovSounds = Class.forName("sheenrox82.RioV.src.content.Sounds");
			Sound soundToGet = (Sound)riovSounds.getDeclaredField(soundName).get(null);
			return soundToGet.getPrefixedName();
		}
		catch(Exception e)
		{
			//If it can't find the sound it will revert 
			//to this until the sound is found. This is so 
			//you don't crash with this API in Eclipse because you don't have the RioV source code.
			return "";
		}
	}

	/**
	 * Get a RioV Config boolean field using a string.
	 * 
	 * @param field - Field name in Config.java (check Github).
	 */
	public boolean getConfigBool(String field)
	{
		try
		{
			Class<?> configFile = Class.forName("sheenrox82.RioV.src.base.Config");
			boolean boolToGet = (Boolean)configFile.getDeclaredField(field).get(null);
			return boolToGet;
		}
		catch(Exception e)
		{
			//If field is not found, the boolean will return false.
			return false;
		}
	}

	/**
	 * Get a RioV Config integer field using a string.
	 * 
	 * @param field - Field name in Config.java (check Github).
	 */
	public int getConfigInt(String field)
	{
		try
		{
			Class<?> configFile = Class.forName("sheenrox82.RioV.src.base.Config");
			int intToGet = (Integer)configFile.getDeclaredField(field).get(null);
			return intToGet;
		}
		catch(Exception e)
		{
			return 0;
		}
	}

	/**
	 * Replace a field in a class.
	 */
	public void replaceField(String fieldName, Class<?> clazz, Object value, Object instance)
	{
		try
		{
			Field field = clazz.getDeclaredField(fieldName);

			if(field != null)
			{
				field.setAccessible(true);

				Field modField = Field.class.getDeclaredField("modifiers");

				modField.setAccessible(true);
				modField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

				field.set(instance, value);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public String getUtilString(String utilString)
	{
		try
		{
			Class<?> util = Class.forName("sheenrox82.RioV.src.util.Util");
			String strToGet = (String)util.getDeclaredField(utilString).get(null);
			return strToGet;
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public UUID getPlayerUUID(EntityPlayer entityplayer)
	{
		return entityplayer.getUniqueID();
	}
}
