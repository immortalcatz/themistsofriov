package sheenrox82.RioV.src.entity.mob.jaerin;

import net.minecraft.entity.Entity;
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
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.entity.EntityMobDeadBody;
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

public class EntityAngel extends EntityMobDeadBody
{
	public EntityAngel(World par1World) 
	{

		super(par1World);
		this.getNavigator().setCanSwim(true);
		this.fallDistance = 0.0f;
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
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}

	
	public void onLivingUpdate()
	{
		if (this.rand.nextInt(24) == 0)
		{
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
		}


		for (int i = 0; i < 2; ++i)
		{
			this.worldObj.spawnParticle("enchantmenttable", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0D);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(Items.feather, 1);
		}
	}
	
	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		return true;
	}
}
