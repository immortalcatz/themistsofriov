package sheenrox82.RioV.src.entity.mob.raetiin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.entity.EntityMobDeadBody;
import sheenrox82.RioV.src.content.Sounds;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityAdv;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityAltruEssence;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityAngel;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityGalokin;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityOrc;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityWoodElf;
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityAltru;
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityTiTun;
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityWoodElfKing;

public class EntityHellhound extends EntityMobDeadBody
{

	public EntityHellhound(World par1World)
	{
		super(par1World);
		this.getNavigator().setCanSwim(true);
		this.setSize(1.5f, 1.7f);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this,  0.56D));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAltruEssence.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAdv.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAngel.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityGalokin.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityOrc.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityWoodElf.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAltru.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTiTun.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityWoodElfKing.class, 0, true));

		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this,  0.56D, true));
		this.isImmuneToFire = true;

	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(50.0D);
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if (super.attackEntityAsMob(par1Entity))
        {
            if (par1Entity instanceof EntityLivingBase)
            {
                byte b0 = 0;

                if (this.worldObj.difficultySetting.getDifficultyId() > 1)
                {
                    if (this.worldObj.difficultySetting.getDifficultyId() == 2)
                    {
                        b0 = 7;
                    }
                    else if (this.worldObj.difficultySetting.getDifficultyId() == 3)
                    {
                        b0 = 15;
                    }
                }

                if (b0 > 0)
                {
                    ((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 5));
                }
            }

            return true;
        }
        else
        {
            return false;
        }
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected String getLivingSound()
	{
		return Sounds.hellhound.getPrefixedName();
	}
	
}
