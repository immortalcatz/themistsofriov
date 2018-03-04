package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.entity.mob.raetiin.boss.EntityTef;
import sheenrox82.RioV.src.lib.RioVLib;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTef extends RenderBiped
{
	public RenderTef()
	{
		super(new ModelBiped(), 0.0F);

	}

	public void render(EntityTef par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.render((EntityTef)par1Entity, par2, par4, par6, par8, par9);
		EntityTef mob = (EntityTef)par1Entity;

		if(!mob.isDeadBody)
		{
			if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
			{
				func_147906_a((EntityLiving)par1Entity, "Tef", par2, par4, par6, 64);
				func_147906_a((EntityLiving)par1Entity, "Faction: " + Color.DARK_RED + "Raetiin", par2, par4 - 0.25d, par6, 64);
			}
		}
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.render((EntityTef)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return RioVLib.tef;
	}
}
