package sheenrox82.RioV.src.event;

import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import sheenrox82.Core.src.base.ModUpdateChecker;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.api.util.RioVPlayer;
import sheenrox82.RioV.src.block.BlockRioVSapling;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityAdv;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityAltruEssence;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityAngel;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityGalokin;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityOrc;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityWoodElf;
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityAltru;
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityTiTun;
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityWoodElfKing;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityAunTunBodyguard;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityBloodGhoul;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityDarkElf;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityHellhound;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityShadow;
import sheenrox82.RioV.src.entity.mob.raetiin.EntitySkeletalHorse;
import sheenrox82.RioV.src.entity.mob.raetiin.EntitySoverianOfficer;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityTefGuard;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTef;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTerron;
import sheenrox82.RioV.src.util.Util;

public class Events
{
	public boolean hasSeen;

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void clientLoggedIn(EntityJoinWorldEvent event)
	{			
		if (event.entity instanceof EntityPlayer) 
		{
			EntityPlayer p = (EntityPlayer) event.entity;

			if (!p.worldObj.isRemote) 
			{
				RioVAPI instance = RioVAPI.getInstance();
				RioVAPIUtil util = instance.getUtil();

				if (ModUpdateChecker.isUpdateAvailable() == ModUpdateChecker.newUpdate) 
				{
					if(!hasSeen)
					{
						p.addChatMessage(util.addChatMessage(Color.DARK_RED, "Hey, " + p.getDisplayName() + "! Version " + ModUpdateChecker.newVersionStr + " is available! Check http://minecraft.m4gdev.com"));
						hasSeen = true;
					}
				}

				else if (ModUpdateChecker.isUpdateAvailable() == ModUpdateChecker.noUpdate) 
				{
					if(!hasSeen)
					{
						p.addChatMessage(util.addChatMessage(Color.GREEN, "Hey, " + p.getDisplayName() + "! Thank you for downloading " + Util.MOD_NAME + "! You are up-to-date!"));
						hasSeen = true;
					}	
				}

				else if (ModUpdateChecker.isUpdateAvailable() == ModUpdateChecker.offline) 
				{
					if(!hasSeen)
					{
						p.addChatMessage(util.addChatMessage(Color.GOLD, "Cannot connect to update checking website."));
						hasSeen = true;
					}
				}
			}
		} 
	}

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) 
	{
		if (event.source.getDamageType().equals("player")) 
		{
			if (event.entityLiving instanceof EntityBlaze) 
			{
				event.entityLiving.dropItem(RioVItems.onyx, 2);
			}
			else if (event.entityLiving instanceof EntityDragon) 
			{
				event.entityLiving.dropItem(RioVItems.dragonSoul, 40);
			}
			else if (event.entityLiving instanceof EntityHorse) 
			{
				event.entityLiving.dropItem(RioVItems.horseMeat, 2);
			}
		}
	}

	@SubscribeEvent
	public void bonemealUsed(BonemealEvent event)
	{
		if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.glimmerwoodSapling)
		{
			((BlockRioVSapling)RioVBlocks.glimmerwoodSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}

		else if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.cherryBlossomSapling)
		{
			((BlockRioVSapling)RioVBlocks.cherryBlossomSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}

		else if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.bloodSapling)
		{
			((BlockRioVSapling)RioVBlocks.bloodSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}

		else if(event.world.getBlock(event.x, event.y, event.z) == RioVBlocks.skywoodSapling)
		{
			((BlockRioVSapling)RioVBlocks.skywoodSapling).func_149878_d(event.world, event.x, event.y, event.z, event.world.rand);
		}
	}

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) 
	{
		if (event.entity instanceof EntityPlayer && RioVPlayer.get((EntityPlayer) event.entity) == null) 
		{
			RioVPlayer.register((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) 
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer)event.entity;

			if (RioVPlayer.get(player) != null)
			{
				RioVPlayer playerRioV = RioVPlayer.get(player);

				playerRioV.loadProxyData(player);

				if(playerRioV.getReceivedBook() == false)
				{
					player.inventory.addItemStackToInventory(new ItemStack(RioVItems.guideBook));
					playerRioV.setReceivedBook(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) 
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			EntityPlayer entityPlayer = (EntityPlayer)event.entity;
			RioVPlayer player = RioVPlayer.get(entityPlayer);

			if (player != null)
			{
				player.saveProxyData(entityPlayer);
			}
		}

		if ((event.source.getEntity() instanceof EntityPlayer))
		{
			EntityPlayer entityplayer = (EntityPlayer)event.source.getEntity();
			RioVPlayer player = RioVPlayer.get(entityplayer);

			if(event.entityLiving instanceof EntityAunTunMinion || event.entityLiving instanceof EntityAunTunBodyguard || event.entityLiving instanceof EntityBloodGhoul || 
					event.entityLiving instanceof EntityDarkElf || event.entityLiving instanceof EntityHellhound || event.entityLiving instanceof EntityShadow || 
					event.entityLiving instanceof EntitySkeletalHorse || event.entityLiving instanceof EntitySoverianOfficer || event.entityLiving instanceof EntityTefGuard || 
					event.entityLiving instanceof EntityAunTun || event.entityLiving instanceof EntityDarkEssence || event.entityLiving instanceof EntityDemonAngel || 
					event.entityLiving instanceof EntityTef || event.entityLiving instanceof EntityTerron)
			{
				player.consumeRep(-3);
			}

			if(event.entityLiving instanceof EntityAdv || event.entityLiving instanceof EntityAltruEssence || event.entityLiving instanceof EntityAngel || 
					event.entityLiving instanceof EntityGalokin || event.entityLiving instanceof EntityOrc || event.entityLiving instanceof EntityWoodElf || 
					event.entityLiving instanceof EntityAltru || event.entityLiving instanceof EntityTiTun || event.entityLiving instanceof EntityWoodElfKing)
			{
				player.consumeRep(3);
			}
		}
	}

	public int regenTimer;

	@SubscribeEvent
	public void playerUpdate(LivingEvent.LivingUpdateEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) 
		{
			EntityPlayer entityplayer = (EntityPlayer)event.entity;
			RioVPlayer player = RioVPlayer.get(entityplayer);

			if (RioVPlayer.get(entityplayer) != null)
			{
				player.saveProxyData(entityplayer);
			}

			if(player.getCurrentRep() > 0)
			{
				player.setFactionID(player.jaerinID);
			}

			if(player.getCurrentRep() == 0)
			{
				player.setFactionID(player.noFactionID);
			}

			if(player.getCurrentRep() < 0)
			{
				player.setFactionID(player.raetiinID);
			}

			if(!entityplayer.capabilities.isCreativeMode)
			{
				if(player.getCurrentEos() < player.getMaxEos())
				{
					++regenTimer;

					if(regenTimer > 100)
					{
						player.consumeEos(-1);
						regenTimer = 0;
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerDamage(LivingAttackEvent event)
	{
		if (event.entity instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			RioVPlayer riovPlayer = RioVPlayer.get(player);

			if(event.source.getDamageType().equals("onFire") || event.source.getDamageType().equals("inFire") || event.source.getDamageType().equals("lava"))
			{
				if(riovPlayer.getFactionID() == riovPlayer.raetiinID)
				{
					event.setCanceled(true);
				}
			}

			else if(event.source.getDamageType().equals("fall") || event.source.getDamageType().equals("cactus"))
			{
				if(riovPlayer.getFactionID() == riovPlayer.jaerinID)
				{
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void entityTarget(LivingSetAttackTargetEvent event)
	{
		if (event.target instanceof EntityPlayer) 
		{
			EntityPlayer player = (EntityPlayer)event.target;
			RioVPlayer riov = RioVPlayer.get(player);

			if(riov.getFactionID() == riov.raetiinID)
			{
				if(event.entity instanceof EntityAunTunMinion)
				{
					((EntityAunTunMinion)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityAunTunBodyguard)
				{
					((EntityAunTunBodyguard)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityBloodGhoul)
				{
					((EntityBloodGhoul)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityDarkElf)
				{
					((EntityDarkElf)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityHellhound)
				{
					((EntityHellhound)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityShadow)
				{
					((EntityShadow)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntitySkeletalHorse)
				{
					((EntitySkeletalHorse)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntitySoverianOfficer)
				{
					((EntitySoverianOfficer)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityTefGuard)
				{
					((EntityTefGuard)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityAunTun)
				{
					((EntityAunTun)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityDarkEssence)
				{
					((EntityDarkEssence)event.entity).setAttackTarget(null);
				}
				else if(event.entityLiving instanceof EntityDemonAngel)
				{
					((EntityDemonAngel)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityTef)
				{
					((EntityTef)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityTerron)
				{
					((EntityTerron)event.entity).setAttackTarget(null);
				}
			}

			if(riov.getFactionID() == riov.jaerinID)
			{
				if(event.entity instanceof EntityAdv)
				{
					((EntityAdv)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityAltruEssence)
				{
					((EntityAltruEssence)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityAngel)
				{
					((EntityAngel)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityGalokin)
				{
					((EntityGalokin)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityOrc)
				{
					((EntityOrc)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityWoodElf)
				{
					((EntityWoodElf)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityAltru)
				{
					((EntityAltru)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityTiTun)
				{
					((EntityTiTun)event.entity).setAttackTarget(null);
				}
				else if(event.entity instanceof EntityWoodElfKing)
				{
					((EntityWoodElfKing)event.entity).setAttackTarget(null);
				}
			}
		}
	}

	@SubscribeEvent
	public void onServerChatReceivedEvent(ServerChatEvent event)
	{
		if (event.player != null) 
		{
			EntityPlayer player = (EntityPlayer) event.player;
			RioVPlayer riovPlayer = RioVPlayer.get(player);

			if (player != null)
			{
				event.setCanceled(true);

				List<?> players = MinecraftServer.getServer().getConfigurationManager().playerEntityList;

				for (int i = 0; i < + players.size(); i++) 
				{
					EntityPlayer target = (EntityPlayer) players.get(i);

					String raetiinMsg = "[" + Color.DARK_RED + "Raetiin" + Color.WHITE + "] <" + player.getDisplayName() + "> " + event.message;
					String jaerinMsg = "[" + Color.GREEN + "Jaerin" + Color.WHITE + "] <" + player.getDisplayName() + "> " + event.message;
					String noFacMsg = "[" + "No Faction" + "] <" + player.getDisplayName() + "> " + event.message;

					if(player.getDisplayName().equals(Util.DEVELOPERS[0]))
					{
						if(riovPlayer.getFactionID() == 2)
							target.addChatMessage(new ChatComponentTranslation(Color.DARK_AQUA + "[" + Color.DARK_GRAY + "RioV" + Color.DARK_AQUA + "]" + Color.WHITE + jaerinMsg));
						else if(riovPlayer.getFactionID() == 0)
							target.addChatMessage(new ChatComponentTranslation(Color.DARK_AQUA + "[" + Color.DARK_GRAY + "RioV" + Color.DARK_AQUA + "]" + Color.WHITE + noFacMsg));
						else if(riovPlayer.getFactionID() == 1)
							target.addChatMessage(new ChatComponentTranslation(Color.DARK_AQUA + "[" + Color.DARK_GRAY + "RioV" + Color.DARK_AQUA + "]" + Color.WHITE + raetiinMsg));
					}
					else
					{
						if(riovPlayer.getFactionID() == 2)
							target.addChatMessage(new ChatComponentTranslation(jaerinMsg));
						else if(riovPlayer.getFactionID() == 0)
							target.addChatMessage(new ChatComponentTranslation(noFacMsg));
						else if(riovPlayer.getFactionID() == 1)
							target.addChatMessage(new ChatComponentTranslation(raetiinMsg));
					}
				}
			}
		}
	}
}