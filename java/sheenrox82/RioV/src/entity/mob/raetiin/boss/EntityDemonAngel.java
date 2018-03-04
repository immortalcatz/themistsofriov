package sheenrox82.RioV.src.entity.mob.raetiin.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.entity.EntityBossCore;
import sheenrox82.RioV.src.api.util.RioVPlayer;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.content.Sounds;

public class EntityDemonAngel extends EntityBossCore
{
	private float heightOffset = 0.5F;
	private int heightOffsetUpdateTime;
	private int field_70846_g;

	public EntityDemonAngel(World par1World)
	{
		super(par1World);
		this.setSize(1.0F, 4F);
		this.isImmuneToFire = true;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.experienceValue = 46;
	}

	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
		
		if(this.worldObj.isRemote)
		{
			RioVAPI.getInstance().getUtil().sendMessageToAll("Demon Angel: Aarrrrrrgghhhhhhhh!");
			RioVAPI.getInstance().getUtil().sendMessageToAll("Demon Angel was killed!");
		}
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(100));
	}

	@Override
	public void onLivingUpdate()
	{
		if (!this.worldObj.isRemote)
		{

			--this.heightOffsetUpdateTime;

			if (this.heightOffsetUpdateTime <= 0)
			{
				this.heightOffsetUpdateTime = 100;
				this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
			}

			if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
			{
				this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
			}
		}

		if (this.rand.nextInt(24) == 0)
		{
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
		}

		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}
		
		super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(Entity par1Entity, float par2)
	{
		if(par1Entity instanceof EntityPlayer)
		{
			EntityPlayer entityplayer = (EntityPlayer)par1Entity;
			RioVPlayer player = RioVPlayer.get(entityplayer);

			if(player.getFactionID() != player.raetiinID)
			{
				this.attack(par1Entity, par2);
			}
		}
		else
		{
			this.attack(par1Entity, par2);
		}
	}

	public void attack(Entity par1Entity, float par2)
	{
		if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(par1Entity);
		}
		else if (par2 < 30.0F)
		{
			double var3 = par1Entity.posX - this.posX;
			double var5 = par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
			double var7 = par1Entity.posZ - this.posZ;

			if (this.attackTime == 0)
			{
				++this.field_70846_g;

				if (this.field_70846_g == 1)
				{
					this.attackTime = 1;
				}
				else if (this.field_70846_g <= 4)
				{
					this.attackTime = 6;
				}
				else
				{
					this.attackTime = 1;
					this.field_70846_g = 0;
				}

				if (this.field_70846_g > 1)
				{
					float var9 = MathHelper.sqrt_float(par2) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

					for (int var10 = 0; var10 < 1; ++var10)
					{
						EntityLargeFireball var11 = new EntityLargeFireball(this.worldObj, this, var3 + this.rand.nextGaussian() * (double)var9, var5, var7 + this.rand.nextGaussian() * (double)var9);
						var11.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
						this.worldObj.spawnEntityInWorld(var11);
					}
				}
			}

			this.rotationYaw = (float)(Math.atan2(var7, var3) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(1200.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(17.0D);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(RioVItems.vulron, 2);
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		this.dropItem(RioVItems.darkMatter, 1);
	}

	@Override
	protected String getLivingSound()
	{
		return Sounds.demon.getPrefixedName();
	}

}
