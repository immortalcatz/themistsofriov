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
import sheenrox82.RioV.src.entity.mob.jaerin.boss.EntityWoodElfKing;
import sheenrox82.RioV.src.lib.RioVLib;

public class RenderWoodElfKing extends RenderBiped
{
	public RenderWoodElfKing()
	{
		super(new ModelBiped(), 0.5F);

	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityWoodElfKing)par1Entity, par2, par4, par6, par8, par9);
		EntityWoodElfKing mob = (EntityWoodElfKing)par1Entity;

		if(!mob.isDeadBody)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
			{
				func_147906_a((EntityLiving)par1Entity, "Wood Elf King", par2, par4, par6, 64);
				func_147906_a((EntityLiving)par1Entity, "Faction: " + Color.GREEN + "Jaerin", par2, par4, par6, 64);
			}
		}
	}


	public void func_82418_a(EntityWoodElfKing par1EntityGiantZombie, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1EntityGiantZombie, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1EntityGiantZombie, true);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityWoodElfKing)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected void preRenderScale(EntityWoodElfKing par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(2, 2, 2);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityWoodElfKing)par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return RioVLib.wood_elf;
	}
}