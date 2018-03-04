package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.entity.EntityMobDeadBody;
import sheenrox82.RioV.src.entity.mob.raetiin.EntityShadow;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBipedCore extends RenderBiped
{
	public ResourceLocation texture;
	public String renderName1;
	public String renderName2;

	public RenderBipedCore(ResourceLocation texture, String name1, String name2)
	{
		super(new ModelBiped(), 0.5F);
		this.texture = texture;
		this.renderName1 = name1;
		this.renderName2 = name2;
	}

	public void render(EntityMobDeadBody var1, double var2, double var4, double var6, float var8, float var9)
	{
		super.doRender(var1, var2, var4, var6, var8, var9);
	}

	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		render((EntityMobDeadBody)var1, var2, var4, var6, var8, var9);
		EntityMobDeadBody entity = (EntityMobDeadBody)var1;

		if(!(var1 instanceof EntityShadow))
		{
			if(!entity.isDeadBody)
			{
				if(RioVAPI.getInstance().getUtil().getConfigBool("mobNametags"))
				{
					this.func_147906_a((EntityLiving)var1, renderName1, var2, var4, var6, 64);
					this.func_147906_a((EntityLiving)var1, "Faction: " + renderName2, var2, var4 - 0.25d, var6, 64);
				}
			}
		}
	}

	public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
	{
		render((EntityMobDeadBody)var1, var2, var4, var6, var8, var9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}
}
