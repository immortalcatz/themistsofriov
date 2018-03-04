package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityOrc;
import sheenrox82.RioV.src.lib.RioVLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderOrc extends RenderBiped
{
	public RenderOrc()
	{
		super(new ModelBiped(), 0.5F);

	}

	public void renderAdv(EntityOrc var1, double var2, double var4, double var6, float var8, float var9)
	{
		super.doRender(var1, var2, var4, var6, var8, var9);
	}

	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityOrc)var1, var2, var4, var6, var8, var9);
		EntityOrc mob = (EntityOrc)var1;

		if(!mob.isDeadBody)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
			{
				this.func_147906_a((EntityLiving)var1, "Orc", var2, var4, var6, 64);
				this.func_147906_a((EntityLiving)var1, "Faction: " + Color.GREEN + "Jaerin", var2, var4 - 0.25d, var6, 64);
			}
		}
	}

	public void doRenderLiving(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityOrc)var1, var2, var4, var6, var8, var9);
	}

	protected void preRenderScale(EntityOrc par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(1.2F, 0.8F, 1.2F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityOrc)par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return RioVLib.orc;
	}
}
