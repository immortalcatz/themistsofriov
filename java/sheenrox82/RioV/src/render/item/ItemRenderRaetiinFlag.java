package sheenrox82.RioV.src.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.model.ModelFlag;
import sheenrox82.RioV.src.util.Util;

public class ItemRenderRaetiinFlag implements IItemRenderer
{
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		GL11.glPushMatrix();
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Util.MOD_ID + ":" + "textures/blocks/RaetiinFlag.png"));
		switch(type){
		case EQUIPPED:
			GL11.glTranslatef(0.4F, 1.6F, 0.4F);
			GL11.glScalef(0.9F, 0.9F, 0.9F);
			GL11.glRotatef(180, 180.0F, 0.0F, 0.0F);
			break;
		case INVENTORY:
			GL11.glTranslatef(-0.2F, 0.4F, 0.0F);
			GL11.glScalef(0.7F, 0.7F, 0.7F);
			GL11.glRotatef(180, 180.0F, 0.0F, 0.0F);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(0.4F, 1.6F, 0.4F);
			GL11.glScalef(0.9F, 0.9F, 0.9F);
			GL11.glRotatef(180, 180.0F, 0.0F, 0.0F);
			break;
		case ENTITY:
			GL11.glTranslatef(0.0F, 1.6F, 0.0F);
			GL11.glScalef(0.9F, 0.9F, 0.9F);
			GL11.glRotatef(180, 180.0F, 0.0F, 0.0F);
			break;
		default: 
			break;
		}

		new ModelFlag().renderAll();
		GL11.glPopMatrix();
	}
}
