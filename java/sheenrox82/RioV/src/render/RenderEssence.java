package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.entity.mob.jaerin.EntityAltruEssence;
import sheenrox82.RioV.src.lib.RioVLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEssence extends RenderBiped
{
	public RenderEssence()
	{
		super(new ModelBiped(), 0.0F);

	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityAltruEssence)par1Entity, par2, par4, par6, par8, par9);
		EntityAltruEssence mob = (EntityAltruEssence)par1Entity;

		if(!mob.isDeadBody)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
			{
				this.func_147906_a((EntityLiving)par1Entity, "Altru Essence", par2, par4, par6, 64);
				this.func_147906_a((EntityLiving)par1Entity, "Faction: " + Color.GREEN + "Jaerin", par2, par4 - 0.25d, par6, 64);
			}
		}
	}


	public void func_82418_a(EntityAltruEssence par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityAltruEssence)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return RioVLib.essence;
	}
}
