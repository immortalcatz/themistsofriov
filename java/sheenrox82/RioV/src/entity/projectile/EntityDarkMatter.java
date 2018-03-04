package sheenrox82.RioV.src.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDarkMatter extends EntityThrowable
{
	double bounceFactor;
	int fuse;
	boolean exploded;
	boolean collided;
	boolean stopped;
    public Entity shootingEntity;

	public EntityDarkMatter(World var1)
	{
		super(var1);
	}

	public EntityDarkMatter(World var1, EntityLivingBase var2)
	{
		super(var1, var2);
	}

	public EntityDarkMatter(World var1, double var2, double var4, double var6)
	{
		super(var1, var2, var4, var6);
	}

	public EntityDarkMatter(World p_i1755_1_, EntityLivingBase p_i1755_2_, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_)
    {
        super(p_i1755_1_);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = p_i1755_2_;

        this.posY = p_i1755_2_.posY + (double)p_i1755_2_.getEyeHeight() - 0.10000000149011612D;
        double d0 = p_i1755_3_.posX - p_i1755_2_.posX;
        double d1 = p_i1755_3_.boundingBox.minY + (double)(p_i1755_3_.height / 3.0F) - this.posY;
        double d2 = p_i1755_3_.posZ - p_i1755_2_.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);

        if (d3 >= 1.0E-7D)
        {
            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(p_i1755_2_.posX + d4, this.posY, p_i1755_2_.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float)d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double)f4, d2, p_i1755_4_, p_i1755_5_);
        }
    }
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	protected void onImpact(MovingObjectPosition var1)
	{
		if (this.fuse-- <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.explode();
            }
        }
        else
        {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
	}

	protected void explode()
	{
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, true);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound var1)
	{
		super.writeEntityToNBT(var1);
		var1.setByte("Fuse", (byte)this.fuse);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound var1)
	{
		super.readEntityFromNBT(var1);
		this.fuse = var1.getByte("Fuse");
	}
}