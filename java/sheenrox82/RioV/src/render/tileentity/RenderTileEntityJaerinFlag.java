package sheenrox82.RioV.src.render.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.model.ModelFlag;
import sheenrox82.RioV.src.util.Util;

public class RenderTileEntityJaerinFlag extends TileEntitySpecialRenderer 
{
	private final ModelFlag model;

	public RenderTileEntityJaerinFlag() 
	{
		this.model = new ModelFlag();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float par8) 
	{
		ResourceLocation textures = (new ResourceLocation(Util.MOD_ID + ":" + "textures/blocks/JaerinFlag.png")); 
		int metadata = tileentity.getBlockMetadata();

		int rotationAngle = 0;
		
		if(metadata%4 == 2)
		{
			rotationAngle = 270;
		}
		
		if(metadata%4 == 3)
		{
			rotationAngle = 0;
		}
		
		if(metadata%4 == 0)
		{
			rotationAngle = 90;
		}
		
		if(metadata%4 == 1)
		{
			rotationAngle = 180;
		}

		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 3F, (float)z + 0.5F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(2, 2, 2);
		GL11.glPushMatrix();
		this.bindTexture(textures);
		model.renderAll();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}