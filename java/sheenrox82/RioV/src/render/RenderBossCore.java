package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.entity.EntityBossCore;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityWoodElfKing;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTerron;
import sheenrox82.RioV.src.lib.RioVLib;


public class RenderBossCore extends RenderLiving
{
	public static float shadow;
	public float scale;

	public RenderBossCore(ModelBase base, float shadow, float scale)
	{
		super(base, shadow);
		this.scale = scale;
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderBoss((EntityBossCore)par1Entity, par2, par4, par6, par8, par9);

		if(par1Entity instanceof EntityDemonAngel)
		{
			EntityDemonAngel mob = (EntityDemonAngel)par1Entity;

			if(!mob.isDeadBody)
			{
				if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
				{
					this.func_147906_a((EntityLiving)par1Entity, "Demon Angel", par2, par4, par6, 64);
					this.func_147906_a((EntityLiving)par1Entity, "Faction: " + Color.DARK_RED + "Raetiin", par2, par4 - 0.25d, par6, 64);
				}
			}
		}

		if(par1Entity instanceof EntityTerron)
		{
			EntityTerron mob = (EntityTerron)par1Entity;

			if(!mob.isDeadBody)
			{
				if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
				{
					this.func_147906_a((EntityLiving)par1Entity, "Terron", par2, par4, par6, 64);
					this.func_147906_a((EntityLiving)par1Entity, "Faction: " + Color.DARK_RED + "Raetiin", par2, par4 - 0.25d, par6, 64);
				}
			}
		}

		doRenderLiving((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
	}

	public void renderBoss(EntityBossCore par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}

	protected void preRenderScale(EntityBossCore par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(scale, scale, scale);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityBossCore)par1EntityLivingBase, par2);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderBoss((EntityBossCore)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		if(entity instanceof EntityTerron) return RioVLib.terron;
		if(entity instanceof EntityDemonAngel) return RioVLib.demon_angel;
		if(entity instanceof EntityWoodElfKing) return RioVLib.wood_elf;
		return null;
	}
}