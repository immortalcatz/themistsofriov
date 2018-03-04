package sheenrox82.RioV.src.entity.mob.jaerin;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.entity.EntityMobDeadBody;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.content.Sounds;
import sheenrox82.RioV.src.entity.mob.neutral.EntityMage;
import sheenrox82.RioV.src.entity.mob.neutral.EntityPaladin;
import sheenrox82.RioV.src.entity.mob.neutral.EntityVravinite;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityAunTunBodyguard;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityDarkElf;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityHellhound;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityShadowWizard;
import sheenrox82.RioV.src.entity.mob.raetiin.EntitySkeletalHorse;
import sheenrox82.RioV.src.entity.mob.raetiin.EntitySoverianOfficer;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityTefGuard;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTef;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTerron;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityAdv extends EntityMobDeadBody
{
	public static ItemStack defaultHeldItem;

	public EntityAdv(World par1World)
	{
		super(par1World);
		this.setSize(1f, 2.1f);
		isImmuneToFire = false;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.56D));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAunTun.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityHellhound.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAunTunBodyguard.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAunTunMinion.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDarkElf.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDemonAngel.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMage.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTef.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTefGuard.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySkeletalHorse.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTerron.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDarkEssence.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVravinite.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySoverianOfficer.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPaladin.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityShadowWizard.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityGhast.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMagmaCube.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPigZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
		this.fallDistance = 0.0f;
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));

		int var1 = this.rand.nextInt(2);
		int var2 = this.rand.nextInt(5);
		int var3 = this.rand.nextInt(4);

		if (var1 == 0)
		{
			if (var2 == 0)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(RioVItems.amethystHelmet));
				this.setCurrentItemOrArmor(3, new ItemStack(RioVItems.amethystChestplate));
				this.setCurrentItemOrArmor(2, new ItemStack(RioVItems.amethystLeggings));
				this.setCurrentItemOrArmor(1, new ItemStack(RioVItems.amethystBoots));
			}
			else if (var2 == 1)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
				this.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
			}
			else if (var2 == 2)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
				this.setCurrentItemOrArmor(3, new ItemStack(Items.iron_chestplate));
				this.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
				this.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
			}
			else if (var2 == 3)
			{
				this.setCurrentItemOrArmor(3, new ItemStack(Items.golden_chestplate));
				this.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
				this.setCurrentItemOrArmor(1, new ItemStack(Items.golden_boots));
			}
			else if (var2 == 4)
			{
				this.setCurrentItemOrArmor(3, new ItemStack(RioVItems.onyxChestplate));
				this.setCurrentItemOrArmor(4, new ItemStack(Items.iron_helmet));
				this.setCurrentItemOrArmor(2, new ItemStack(Items.iron_leggings));
				this.setCurrentItemOrArmor(1, new ItemStack(RioVItems.onyxBoots));
			}
		}
		else if (var1 == 1)
		{
			if (var3 == 0)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(RioVItems.onyxHelmet));
				this.setCurrentItemOrArmor(3, new ItemStack(RioVItems.onyxChestplate));
				this.setCurrentItemOrArmor(2, new ItemStack(RioVItems.onyxLeggings));
				this.setCurrentItemOrArmor(1, new ItemStack(RioVItems.onyxBoots));
			}
			else if (var3 == 1)
			{
				this.setCurrentItemOrArmor(3, new ItemStack(RioVItems.onyxChestplate));
				this.setCurrentItemOrArmor(2, new ItemStack(RioVItems.onyxLeggings));
				this.setCurrentItemOrArmor(1, new ItemStack(RioVItems.onyxBoots));
			}

			if (var3 == 2)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(RioVItems.onyxHelmet));
				this.setCurrentItemOrArmor(3, new ItemStack(RioVItems.amethystChestplate));
				this.setCurrentItemOrArmor(2, new ItemStack(RioVItems.onyxLeggings));
			}
			else if (var3 == 3)
			{
				this.setCurrentItemOrArmor(4, new ItemStack(RioVItems.amethystHelmet));
				this.setCurrentItemOrArmor(2, new ItemStack(RioVItems.onyxLeggings));
				this.setCurrentItemOrArmor(1, new ItemStack(RioVItems.onyxBoots));
			}

		}
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	public ItemStack getHeldItem()
	{
		if(!this.isDeadBody)
		{
			return defaultHeldItem;
		}
		else
		{
			return (ItemStack)null;
		}
	}

	static
	{
		defaultHeldItem = new ItemStack(RioVItems.amethystSword);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int var1 = this.rand.nextInt(10);

		if (var1 == 0)
		{
			this.dropItem(RioVItems.ambrosia, 1);
		}
		if (var1 == 1)
		{
			this.dropItem(RioVItems.amethystSword, 1);
		}
		if (var1 == 3)
		{
			this.dropItem(RioVItems.greenApple, 1);
		}
		if (var1 == 4)
		{
			this.dropItem(RioVItems.greenApple, 1);
		}
		if (var1 == 5)
		{
			this.dropItem(RioVItems.manchet, 1);
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0D);
	}

	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		if(!this.isDeadBody)
		{
			par1EntityPlayer.playSound(Sounds.hello.getPrefixedName(), 1, 1);

			if(!this.worldObj.isRemote)
				par1EntityPlayer.addChatMessage(RioVAPI.getInstance().getUtil().addChatMessage(EnumChatFormatting.WHITE, "Hello to you too, " + par1EntityPlayer.getDisplayName() + "!"));
			
			return true;
		}
		
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected String getLivingSound()
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("allowBreathing") == true)
		{
			return Sounds.exhale.getPrefixedName();
		}

		return null;
	}
}
