package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.entity.EntityMobDeadBody;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityWoodElf;
import sheenrox82.RioV.src.entity.mob.neutral.EntityNizonian;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityHellhound;
import sheenrox82.RioV.src.lib.RioVLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLivingCore extends RenderLiving
{
	public float scale;
	public float scale1;
	public float scale2;
	public String renderName1;
	public String renderName2;

	public RenderLivingCore(ModelBase base, float f, float scale, float scale1, float scale2, String name1, String name2)
	{
		super(base, f);
		this.scale = scale;
		this.scale1 = scale1;
		this.scale2 = scale2;
		this.renderName1 = name1;
		this.renderName2 = name2;
	}

	public void render(EntityMobDeadBody var1, double var2, double var4, double var6, float var8, float var9)
	{
		super.doRender(var1, var2, var4, var6, var8, var9);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		render((EntityMobDeadBody)par1Entity, par2, par4, par6, par8, par9);
		EntityMobDeadBody mob = (EntityMobDeadBody)par1Entity;

		if(!mob.isDeadBody)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
			{
				this.func_147906_a((EntityLiving)par1Entity, renderName1, par2, par4, par6, 64);
				this.func_147906_a((EntityLiving)par1Entity, "Faction: " + renderName2, par2, par4 - 0.25d, par6, 64);
			}
		}
	}

	public void doRenderLiving(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		render((EntityMobDeadBody)var1, var2, var4, var6, var8, var9);
	}

	protected void preRenderScale(EntityMobDeadBody par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(scale, scale1, scale2);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityMobDeadBody)par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		if(entity instanceof EntityNizonian)
		{
			return RioVLib.nizonian;
		}

		if(entity instanceof EntityHellhound)
		{
			return RioVLib.hellhound;
		}

		if(entity instanceof EntityWoodElf)
		{
			return RioVLib.wood_elf;
		}

		return null;
	}
}

