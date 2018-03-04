package sheenrox82.RioV.src.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.util.Color;
import sheenrox82.RioV.src.api.util.RioVPlayer;
import sheenrox82.RioV.src.base.Config;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiReputationMeter extends Gui
{
	public Minecraft mc;

	public GuiReputationMeter(Minecraft mc)
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

		RioVPlayer props = RioVPlayer.get(mc.thePlayer);

		if (props == null || props.maxEos == 0)
		{
			return;
		}

		if(!mc.thePlayer.capabilities.isCreativeMode)
		{
			GL11.glPushMatrix();
			
			if(props.getCurrentRep() < 0)
			{
				this.renderString(event, props, Color.DARK_RED, "Raetiin");
			}
			
			if(props.getCurrentRep() > 0)
			{
				this.renderString(event, props, Color.GREEN, "Jaerin");
			}
			
			if(props.getCurrentRep() == 0)
			{
				this.renderString(event, props, Color.WHITE, "No Faction");
			}
				
			GL11.glPopMatrix();
		}
	}
	
	public void renderString(RenderGameOverlayEvent event, RioVPlayer props, EnumChatFormatting color, String facStr)
	{
		GL11.glEnable(GL11.GL_BLEND);
		int height = event.resolution.getScaledHeight();
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		String rep = "Reputation: " + color + props.getCurrentRep();
		this.mc.fontRenderer.drawString(Color.BLACK + "Reputation: " + props.getCurrentRep(), Config.hudPosX + 21, height - Config.hudPosY - 20, 0);
		this.mc.fontRenderer.drawString(Color.BLACK + "Reputation: " + props.getCurrentRep(), Config.hudPosX + 19, height - Config.hudPosY - 20, 0);
		this.mc.fontRenderer.drawString(Color.BLACK + "Reputation: " + props.getCurrentRep(), Config.hudPosX + 20, height - Config.hudPosY - 21, 0);
		this.mc.fontRenderer.drawString(Color.BLACK + "Reputation: " + props.getCurrentRep(), Config.hudPosX + 20, height - Config.hudPosY - 19, 0);
		this.mc.fontRenderer.drawString(Color.WHITE + rep, Config.hudPosX + 20, height - Config.hudPosY - 20, 8453920);

		String faction = "Faction: " + color + facStr;
		this.mc.fontRenderer.drawString(Color.BLACK + "Faction: " + facStr, Config.hudPosX + 21, height - Config.hudPosY - 10, 0);
		this.mc.fontRenderer.drawString(Color.BLACK + "Faction: " + facStr, Config.hudPosX + 19, height - Config.hudPosY - 10, 0);
		this.mc.fontRenderer.drawString(Color.BLACK + "Faction: " + facStr, Config.hudPosX + 20, height - Config.hudPosY - 11, 0);
		this.mc.fontRenderer.drawString(Color.BLACK + "Faction: " + facStr, Config.hudPosX + 20, height - Config.hudPosY - 9, 0);
		this.mc.fontRenderer.drawString(Color.WHITE + faction, Config.hudPosX + 20, height - Config.hudPosY - 10, 8453920);
		
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
	}
}