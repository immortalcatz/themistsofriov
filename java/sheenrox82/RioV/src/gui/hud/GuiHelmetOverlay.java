package sheenrox82.RioV.src.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHelmetOverlay extends Gui
{
	public Minecraft mc;
	
	public GuiHelmetOverlay(Minecraft mc)
	{
		super();
		this.mc = mc;
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void render(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		ItemStack itemstack = this.mc.thePlayer.inventory.armorItemInSlot(3);
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		int k = scaledresolution.getScaledWidth();
		int l = scaledresolution.getScaledHeight();

		if(RioVAPI.getInstance().getUtil().getConfigBool("Helmet") == true)
		{
			if(this.mc.gameSettings.thirdPersonView == 0 && itemstack != null)
			{
				if(itemstack.getItem() == RioVItems.alerisHelmet || itemstack.getItem() == RioVItems.infusedAlerisHelmet || itemstack.getItem() == RioVItems.tiTunHelmet || itemstack.getItem() == RioVItems.vraviniteHelmet || itemstack.getItem() == RioVItems.infusedVraviniteHelmet)
				{
					this.renderHelmOverlay(k, l, new ResourceLocation(Util.MOD_ID + ":" + "textures/misc/helm1.png"));
				}
				if(itemstack.getItem() == RioVItems.amethystHelmet || itemstack.getItem() == RioVItems.infusedAmethystHelmet || itemstack.getItem() == RioVItems.onyxHelmet || itemstack.getItem() == RioVItems.infusedOnyxHelmet || itemstack.getItem() == RioVItems.helmetOfFlame || itemstack.getItem() == RioVItems.auntunHelmet || itemstack.getItem() == RioVItems.supremeAunTunHelmet)
				{
					this.renderHelmOverlay(k, l, new ResourceLocation(Util.MOD_ID + ":" + "textures/misc/helm2.png"));
				}
				if(itemstack.getItem() == RioVItems.mythrilHelmet || itemstack.getItem() == RioVItems.paladinHelmet || itemstack.getItem() == RioVItems.dragonHelmet || itemstack.getItem() == RioVItems.shadowniteHelmet || itemstack.getItem() == RioVItems.infusedShadowniteHelmet)
				{
					this.renderHelmOverlay(k, l, new ResourceLocation(Util.MOD_ID + ":" + "textures/misc/helm3.png"));
				}
			}
		}
	}

	protected void renderHelmOverlay(int p_73836_1_, int p_73836_2_, ResourceLocation loc)
	{
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		this.mc.getTextureManager().bindTexture(loc);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(0.0D, (double)p_73836_2_, -90.0D, 0.0D, 1.0D);
		tessellator.addVertexWithUV((double)p_73836_1_, (double)p_73836_2_, -90.0D, 1.0D, 1.0D);
		tessellator.addVertexWithUV((double)p_73836_1_, 0.0D, -90.0D, 1.0D, 0.0D);
		tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
		tessellator.draw();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
}
