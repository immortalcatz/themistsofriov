package sheenrox82.RioV.src.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.api.util.RioVPlayer;
import sheenrox82.RioV.src.base.Config;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiEosBar extends Gui
{
	public Minecraft mc;

	public GuiEosBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void render(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		ResourceLocation icons = new ResourceLocation("riov", "textures/gui/eos_bar.png");
		RioVPlayer props = RioVPlayer.get(mc.thePlayer);

		if (props == null || props.getMaxEos() == 0)
		{
			return;
		}

		if(RioVAPI.getInstance().getUtil().getConfigBool("EOS") == true)
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(icons);
				int height = event.resolution.getScaledHeight();
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				int eos = (int)(((float) props.getCurrentEos() / props.getMaxEos()) * 80);
				this.drawTexturedModalRect(Config.hudPosX + 15, height - Config.hudPosY, 0, 49, 102, 14);
				this.drawTexturedModalRect(Config.hudPosX + 26, (height - Config.hudPosY) + 4, 11, 64, eos, 6);
				GL11.glPopMatrix();
			}
		}

		if(RioVAPI.getInstance().getUtil().getConfigBool("EOS") == false)
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				GL11.glEnable(GL11.GL_BLEND);
				int height = event.resolution.getScaledHeight();
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				String s = "Eos: " + props.getCurrentEos() + "/" + props.getMaxEos();
				this.mc.fontRenderer.drawString(s, Config.hudPosX + 21, height - Config.hudPosY, 0);
				this.mc.fontRenderer.drawString(s, Config.hudPosX + 19, height - Config.hudPosY, 0);
				this.mc.fontRenderer.drawString(s, Config.hudPosX + 20, height - Config.hudPosY + 1, 0);
				this.mc.fontRenderer.drawString(s, Config.hudPosX + 20, height - Config.hudPosY - 1, 0);
				this.mc.fontRenderer.drawString(Color.LIGHT_PURPLE + s, Config.hudPosX + 20, height - Config.hudPosY, 8453920);

				GL11.glDisable(GL11.GL_BLEND);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(true);
			}
		}
	}
}