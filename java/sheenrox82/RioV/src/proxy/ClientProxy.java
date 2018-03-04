package sheenrox82.RioV.src.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
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
import sheenrox82.RioV.src.entity.mob.neutral.EntityDove;
import sheenrox82.RioV.src.entity.mob.neutral.EntityFairy;
import sheenrox82.RioV.src.entity.mob.neutral.EntityMage;
import sheenrox82.RioV.src.entity.mob.neutral.EntityNizonian;
import sheenrox82.RioV.src.entity.mob.neutral.EntityPaladin;
import sheenrox82.RioV.src.entity.mob.neutral.EntityRabbit;
import sheenrox82.RioV.src.entity.mob.neutral.EntityVravinite;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityAunTunBodyguard;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityBloodGhoul;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityDarkElf;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityHellhound;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityShadow;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityShadowWizard;
import sheenrox82.RioV.src.entity.mob.raetiin.EntitySkeletalHorse;
import sheenrox82.RioV.src.entity.mob.raetiin.EntitySoverianOfficer;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityTefGuard;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTef;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTerron;
import sheenrox82.RioV.src.entity.projectile.EntityDarkMatter;
import sheenrox82.RioV.src.entity.projectile.EntityDarknessArrow;
import sheenrox82.RioV.src.entity.projectile.EntityPinkEssence;
import sheenrox82.RioV.src.entity.projectile.EntityRawDarkMatter;
import sheenrox82.RioV.src.entity.projectile.EntityVraviniteArrow;
import sheenrox82.RioV.src.gui.hud.GuiEosBar;
import sheenrox82.RioV.src.gui.hud.GuiHelmetOverlay;
import sheenrox82.RioV.src.gui.hud.GuiReputationMeter;
import sheenrox82.RioV.src.lib.RioVLib;
import sheenrox82.RioV.src.model.ModelDemonAngel;
import sheenrox82.RioV.src.model.ModelDragonWings;
import sheenrox82.RioV.src.model.ModelHellhound;
import sheenrox82.RioV.src.model.ModelTerron;
import sheenrox82.RioV.src.render.RenderAltru;
import sheenrox82.RioV.src.render.RenderAngel;
import sheenrox82.RioV.src.render.RenderAunTun;
import sheenrox82.RioV.src.render.RenderBipedCore;
import sheenrox82.RioV.src.render.RenderBossCore;
import sheenrox82.RioV.src.render.RenderDarkEssence;
import sheenrox82.RioV.src.render.RenderDove;
import sheenrox82.RioV.src.render.RenderEssence;
import sheenrox82.RioV.src.render.RenderFairy;
import sheenrox82.RioV.src.render.RenderLivingCore;
import sheenrox82.RioV.src.render.RenderOrc;
import sheenrox82.RioV.src.render.RenderPaladin;
import sheenrox82.RioV.src.render.RenderRabbit;
import sheenrox82.RioV.src.render.RenderSkeletalHorse;
import sheenrox82.RioV.src.render.RenderTef;
import sheenrox82.RioV.src.render.RenderTiTun;
import sheenrox82.RioV.src.render.RenderWoodElfKing;
import sheenrox82.RioV.src.render.item.ItemRenderBow;
import sheenrox82.RioV.src.render.item.ItemRenderJaerinFlag;
import sheenrox82.RioV.src.render.item.ItemRenderLongbow;
import sheenrox82.RioV.src.render.item.ItemRenderNoFactionFlag;
import sheenrox82.RioV.src.render.item.ItemRenderRaetiinFlag;
import sheenrox82.RioV.src.render.projectile.RenderDarkMatter;
import sheenrox82.RioV.src.render.projectile.RenderDarknessArrow;
import sheenrox82.RioV.src.render.projectile.RenderPinkEssence;
import sheenrox82.RioV.src.render.projectile.RenderVraviniteArrow;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityInfuser;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityJaerinFlag;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityNoFactionFlag;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityRaetiinFlag;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;
import sheenrox82.RioV.src.tileentity.TileEntityJaerinFlag;
import sheenrox82.RioV.src.tileentity.TileEntityNoFactionFlag;
import sheenrox82.RioV.src.tileentity.TileEntityRaetiinFlag;
import sheenrox82.RioV.src.util.ExpansionChecker;
import sheenrox82.RioV.src.util.Util;

import com.jadarstudios.developercapes.DevCapes;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy 
{	
	private static final ModelDragonWings dragonWings = new ModelDragonWings(1.0F);

	@Override
	public void init() 
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderBipedCore(RioVLib.mage, "Mage", "No Faction"));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunBodyguard.class, new RenderBipedCore(RioVLib.auntun, "Aun'Tun Bodyguard", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityAdv.class, new RenderBipedCore(RioVLib.adventurer, "Adventurer", Color.GREEN + "Jaerin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityTerron.class, new RenderBossCore(new ModelTerron(), 0.5F, 1.8F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDemonAngel.class, new RenderBossCore(new ModelDemonAngel(), 0.5F, 2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkElf.class, new RenderBipedCore(RioVLib.dark_elf, "Dark Elf", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTun.class, new RenderAunTun());
		RenderingRegistry.registerEntityRenderingHandler(EntityAltruEssence.class, new RenderEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityNizonian.class, new RenderLivingCore(new ModelTerron(), 0.5F, 1.5F, 1.5F, 1.5F, "Nizonian", "No Faction"));
		RenderingRegistry.registerEntityRenderingHandler(EntityGalokin.class, new RenderBipedCore(RioVLib.galokin, "Galokin", Color.GREEN + "Jaerin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityOrc.class, new RenderOrc());
		RenderingRegistry.registerEntityRenderingHandler(EntityFairy.class, new RenderFairy());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkEssence.class, new RenderDarkEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class, new RenderLivingCore(new ModelHellhound(), 0.6F, 1.5F, 1.5F, 1.5F, "Hellhound", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodElf.class, new RenderBipedCore(RioVLib.wood_elf, "Wood Elf", Color.GREEN + "Jaerin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityTef.class, new RenderTef());
		RenderingRegistry.registerEntityRenderingHandler(EntityTefGuard.class, new RenderBipedCore(RioVLib.essence, "Tef Guard", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, new RenderBipedCore(RioVLib.shadow, (String)null, (String)null));
		RenderingRegistry.registerEntityRenderingHandler(EntityVravinite.class, new RenderBipedCore(RioVLib.vravinite, "Vravinite", "No Faction"));
		RenderingRegistry.registerEntityRenderingHandler(EntityDove.class, new RenderDove());
		RenderingRegistry.registerEntityRenderingHandler(EntityAngel.class, new RenderAngel());
		RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RenderRabbit());
		RenderingRegistry.registerEntityRenderingHandler(EntitySoverianOfficer.class, new RenderBipedCore(RioVLib.officer, "Soverian Officer", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityPaladin.class, new RenderPaladin());
		RenderingRegistry.registerEntityRenderingHandler(EntityPinkEssence.class, new RenderPinkEssence(new ResourceLocation(Util.MOD_ID + ":" + "pinkEssence.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkMatter.class, new RenderDarkMatter(new ResourceLocation(Util.MOD_ID + ":" + "darkMatter.png")));
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunMinion.class, new RenderBipedCore(RioVLib.auntun, "Aun'Tun Minion", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodGhoul.class, new RenderBipedCore(RioVLib.blood_ghoul, "Blood Ghoul", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessArrow.class, new RenderDarknessArrow(RioVLib.darkness_arrow));
		RenderingRegistry.registerEntityRenderingHandler(EntityVraviniteArrow.class, new RenderVraviniteArrow(RioVLib.vravinite_arrow));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodElfKing.class, new RenderWoodElfKing());
		RenderingRegistry.registerEntityRenderingHandler(EntityTiTun.class, new RenderTiTun());
		RenderingRegistry.registerEntityRenderingHandler(EntityShadowWizard.class, new RenderBipedCore(RioVLib.essence, "Shadownite Wizard", Color.DARK_RED + "Raetiin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityRawDarkMatter.class, new RenderDarkMatter(new ResourceLocation(Util.MOD_ID + ":" + "darkMatter.png")));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNoFactionFlag.class, new RenderTileEntityNoFactionFlag());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRaetiinFlag.class, new RenderTileEntityRaetiinFlag());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJaerinFlag.class, new RenderTileEntityJaerinFlag());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, new RenderTileEntityInfuser());
		RenderingRegistry.registerEntityRenderingHandler(EntityAltru.class, new RenderAltru());
		MinecraftForge.EVENT_BUS.register(new GuiHelmetOverlay(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiEosBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiReputationMeter(Minecraft.getMinecraft()));

		RioVAPI.getInstance().getLogger().info("HUD elements registered.");
	}

	@Override
	public void registerStuff()
	{
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RioVBlocks.noFacFlag), new ItemRenderNoFactionFlag());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RioVBlocks.raetiinFlag), new ItemRenderRaetiinFlag());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(RioVBlocks.jaerinFlag), new ItemRenderJaerinFlag());

		MinecraftForgeClient.registerItemRenderer(RioVItems.bowOfWurTun, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(RioVItems.enforcedBowOfWurTun, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(RioVItems.vraviniteBow, new ItemRenderLongbow());
		RioVAPI.getInstance().getLogger().info("Item renderers registered.");
		ExpansionChecker.checkNEI();
	}

	@Override
	public void cape()
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("runCapes") == true)
		{
			DevCapes.getInstance().registerConfig("https://dl.dropbox.com/u/126631367/RioVCapes.json");
			RioVAPI.getInstance().getLogger().info("Cape .json file registered.");
		}
		else
		{
			RioVAPI.getInstance().getLogger().info("Cape .json file not registered.");
		}
	}

	public static int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
	
	@Override
	public ModelBiped getArmorModel(int id)
	{
		switch (id) {
		case 0:
			return dragonWings;
		default:
			break;
		}
		return dragonWings;
	}
}