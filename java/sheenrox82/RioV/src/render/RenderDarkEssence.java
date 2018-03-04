package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityDarkEssence;
import sheenrox82.RioV.src.lib.RioVLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDarkEssence extends RenderBiped
{

	public RenderDarkEssence()
	{
		super(new ModelBiped(), 0.0F);

	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityDarkEssence)par1Entity, par2, par4, par6, par8, par9);
		EntityDarkEssence mob = (EntityDarkEssence)par1Entity;

		if(!mob.isDeadBody)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
			{
				this.func_147906_a((EntityLiving)par1Entity, "The Darkness", par2, par4, par6, 64);
				this.func_147906_a((EntityLiving)par1Entity, "Faction: " + Color.DARK_RED + "Raetiin", par2, par4 - 0.25d, par6, 64);
			}
		}
	}


	public void func_82418_a(EntityDarkEssence par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}

	protected void preRenderScale(EntityDarkEssence par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(2.0F, 2.0F, 2.0F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityDarkEssence)par1EntityLivingBase, par2);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityDarkEssence)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return RioVLib.essence;
	}
}
