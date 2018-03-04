package sheenrox82.RioV.src.render.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.tileentity.TileEntityInfuser;

public class RenderTileEntityInfuser extends TileEntitySpecialRenderer
{
	public RenderTileEntityInfuser() 
	{
	}

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f)
	{
		TileEntityInfuser infuser = (TileEntityInfuser)entity;
		ItemStack itemToRender = infuser.getStackInSlot(0);
		ItemStack itemToRender1 = infuser.getStackInSlot(2);

		if(itemToRender != null && itemToRender1 == null)
		{
			GL11.glPushMatrix();
			ItemStack stack = new ItemStack(itemToRender.getItem(), 1, 0);
			EntityItem entItem = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), 0D, 0D, 0D, stack);
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 0.3F);
			GL11.glRotatef(180, 0, 1, 1);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
		}
		
		if(itemToRender1 != null && itemToRender == null)
		{
			GL11.glPushMatrix();
			ItemStack stack = new ItemStack(itemToRender1.getItem(), 1, 0);
			EntityItem entItem = new EntityItem(Minecraft.getMinecraft().thePlayer.getEntityWorld(), 0D, 0D, 0D, stack);
			entItem.hoverStart = 0.0F;
			RenderItem.renderInFrame = true;
			GL11.glTranslatef((float)x + 0.5F, (float)y + 1.02F, (float)z + 0.3F);
			GL11.glRotatef(180, 0, 1, 1);
			RenderManager.instance.renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			RenderItem.renderInFrame = false;
			GL11.glPopMatrix();
		}
	}
}