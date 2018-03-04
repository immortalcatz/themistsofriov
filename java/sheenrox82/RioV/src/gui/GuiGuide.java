package sheenrox82.RioV.src.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.guide.GuideCategory;
import sheenrox82.RioV.src.guide.GuideHelper;
import sheenrox82.RioV.src.guide.GuidePage;
import sheenrox82.RioV.src.lib.RioVLib;
import sheenrox82.RioV.src.util.Util;

public class GuiGuide extends GuiScreen 
{
	private static int xSize = 151;
	private static int ySize = 96;

	private List<GuideCategory> journalCategories = new ArrayList<GuideCategory>();
	private List<GuidePage> categoryUnlockedPages = new ArrayList<GuidePage>();
	private int category = -1;

	private List<String> unlockedPages = new ArrayList<String>();
	private int page = -1;

	private int hovering = -1;

	private String owner = "";

	public GuiGuide(String owner, String info) 
	{
		GuideHelper.openingJournalInfo = "";

		this.owner = owner;

		if(info != null)
			for(String page : Arrays.asList(info.split(";")))
				unlockedPages.add(page);

		for(GuideCategory cat : GuideHelper.getCategories())
			if(cat.hasOverride() || GuideHelper.hasPageInCategory(cat, unlockedPages))
				journalCategories.add(cat);
	}

	private int getCategoryId(String category) 
	{
		for(int i = 0; i < journalCategories.size(); i++)
			if(journalCategories.get(i).getTitle().equals(category))
				return i;
		return -1;
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int which)
	{
		if(category == -1) 
		{
			category = hovering;
			updateUnlockedPagesForCategory();
		}
		else if(hovering == -2)
			if(page == -1)
				category = -1;
			else
			{
				category = getCategoryId(journalCategories.get(category).getPages()[page].getParentCategory());
				page = -1;
			}
		else if(page == -1)
			page = hovering;
	}

	@Override
	public void updateScreen() 
	{
		super.updateScreen();

		int mouseX = Mouse.getEventX() * width / mc.displayWidth - (width / 2 - xSize);
		int mouseY = height - Mouse.getEventY() * height / mc.displayHeight - 1 - (height / 2 - ySize);

		if(page == -1) 
		{
			if(category != -1)
				for(int i = 0; i < categoryUnlockedPages.size(); i++) 
				{
					if(mouseX > 24 && mouseX < 130 && mouseY > 22 + 10 * i && mouseY < 32 + 10 * i)
					{
						hovering = i;
						return;
					}
				}
			else
				for(int i = 0; i < journalCategories.size(); i++) 
				{
					if(mouseX > 24 && mouseX < 130 && mouseY > 22 + 10 * i && mouseY < 32 + 10 * i) 
					{
						hovering = i;
						return;
					}
				}

			hovering = -1;
		}

		if(category != -1)
			if(mouseX > 12 && mouseX < 26 && mouseY > 166 && mouseY < 182)
				hovering = -2;
			else
				hovering = -1;
	}

	@Override
	public void drawScreen(int par1, int par2, float par3)
	{
		drawBackground(0);
	}

	@Override
	public void drawBackground(int par1) 
	{
		int x = width / 2 - xSize;
		int y = height / 2 - ySize;
		GL11.glPushMatrix();
		GL11.glTranslatef(-x, -y, 0F);
		GL11.glScalef(2F, 2F, 1F);
		mc.renderEngine.bindTexture(RioVLib.guide);
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

		if(category != -1)
			drawTexturedModalRect(x + 6, y + ySize - 13, 0, ySize + (hovering == -2 ? 8 : 0), 8, 8);
		GL11.glPopMatrix();

		if(category == -1)
		{
			String title = Util.MOD_NAME + " Guide";
			fontRendererObj.drawString(title, x + 79 - fontRendererObj.getStringWidth(title) / 2, y + 10, 0);

			GL11.glPushMatrix();
			GL11.glScalef(.5F, .5F, 1F);
			GL11.glTranslatef(-x + x * 2, -y + y * 2, 0F);
			for(int i = 0; i < journalCategories.size(); i++)
				fontRendererObj.drawString(journalCategories.get(i).getTitle(), x + 56, y + 52 + 20 * i, (hovering == i ? 0x555555 : 0));
			GL11.glPopMatrix();
		}
		else
		{
			if(page == -1) 
			{
				fontRendererObj.drawString(journalCategories.get(category).getTitle(), x + 79 - fontRendererObj.getStringWidth(journalCategories.get(category).getTitle()) / 2, y + 10, 0);
				GL11.glPushMatrix();
				GL11.glScalef(.5F, .5F, 1F);
				GL11.glTranslatef(-x + x * 2, -y + y * 2, 0F);
				for(int i = 0; i <categoryUnlockedPages.size(); i++)
					fontRendererObj.drawString(categoryUnlockedPages.get(i).getTitle(), x + 56, y + 52 + 20 * i, (hovering == i ? 0x555555 : 0));
				GL11.glPopMatrix();
			}
			else
			{
				GuidePage thePage = journalCategories.get(category).getPages()[page];

				fontRendererObj.drawString(thePage.getTitle(), x + 79 - fontRendererObj.getStringWidth(thePage.getTitle()) / 2, y + 10, 0);
				drawContent(x, y, thePage.getContents(unlockedPages));
				drawSketch(x + 164, y + 13, thePage.getSketch());
			}
		}
	}

	private void updateUnlockedPagesForCategory() 
	{
		categoryUnlockedPages.clear();
		if(category != -1)
			for(GuidePage gp : journalCategories.get(category).getPages())
				if(gp.hasOverride() || unlockedPages.contains(gp.getTitle()))
					categoryUnlockedPages.add(gp);
	}

	private void drawContent(int x, int y, String[] contents) 
	{
		GL11.glPushMatrix();
		GL11.glScalef(.5F, .5F, 1F);
		GL11.glTranslatef(-x + x * 2, -y + y * 2, 0F);
		for(int i = 0; i < contents.length; i++) {
			contents[i] = contents[i].replace("[name]", owner);
			if(contents[i].startsWith("["))
				fontRendererObj.drawString(contents[i].substring(1), x + 40, y + 50 + 10 * i, 0);
			else if(contents[i].startsWith("]"))
				fontRendererObj.drawString(contents[i].substring(1), x + 275 - fontRendererObj.getStringWidth(contents[i].substring(1)), y + 50 + 10 * i, 0);
			else
				fontRendererObj.drawString(contents[i], x + 45, y + 50 + 10 * i, 0);
		}
		GL11.glPopMatrix();
	}

	private void drawSketch(int x, int y, ResourceLocation res) 
	{
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		mc.renderEngine.bindTexture(res);
		drawTexturedModalRect(x, y, 0, 0, 122, 164);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}