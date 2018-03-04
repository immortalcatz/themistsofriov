package sheenrox82.RioV.src.entity.mob.jaerin.boss;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.entity.EntityBossCore;
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

public class EntityWoodElfKing extends EntityBossCore implements IRangedAttackMob
{
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, 20, 60, 15.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);

	public EntityWoodElfKing(World par1World)
	{
		super(par1World);
		this.setSize(1F, 3.8F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this,  0.56D));
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
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.fallDistance = 0.0f;
		this.setCurrentItemOrArmor(4, new ItemStack(RioVItems.infusedAmethystHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(RioVItems.infusedAmethystChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(RioVItems.infusedAmethystLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(RioVItems.infusedAmethystBoots));
		this.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
		if (par1World != null && !par1World.isRemote)
		{
			this.setCombatTask();
		}
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
		this.dataWatcher.addObject(13, new Byte((byte)0));
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
	
		if(this.worldObj.isRemote)
		{
			RioVAPI.getInstance().getUtil().sendMessageToAll("Wood Elf King: *Scream*");
			RioVAPI.getInstance().getUtil().sendMessageToAll("Wood Elf King was killed!");
		}
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(RioVItems.elfCrystal, 2);
	}

	public void setCombatTask()
	{
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack itemstack = this.getHeldItem();

		if (itemstack != null && itemstack.getItem() == Items.bow)
		{
			this.tasks.addTask(4, this.aiArrowAttack);
		}
		else
		{
			this.tasks.addTask(4, this.aiAttackOnCollide);
		}
	}

	@Override
	public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack)
	{
		super.setCurrentItemOrArmor(par1, par2ItemStack);

		if (!this.worldObj.isRemote && par1 == 0)
		{
			this.setCombatTask();
		}
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase, float par2)
	{
		EntityArrow entityarrow = new EntityArrow(this.worldObj, this, entitylivingbase, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
		entityarrow.setDamage(5.0D);
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());

		if (j > 0)
		{
			entityarrow.setKnockbackStrength(j);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);

	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(900.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(14.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0D);
	}
	
	@Override
	protected String getHurtSound()
	{
		return Sounds.pain.getPrefixedName();
	}
}
