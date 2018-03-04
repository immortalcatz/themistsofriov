package sheenrox82.RioV.src.nei;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.recipe.AnvilShapedRecipes;
import sheenrox82.RioV.src.gui.GuiAnvil;
import sheenrox82.RioV.src.util.Util;
import codechicken.lib.gui.GuiDraw;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;

public class AnvilNEI extends TemplateRecipeHandler
{
	@Override
	public String getRecipeName() 
	{
		return "Anvil";
	}

	@Override
	public String getGuiTexture()
	{
		return Util.MOD_ID + ":" + "textures/gui/" + "anvil.png";
	}

	public void drawBackground(int recipe)
	{
		GL11.glColor4f(1, 1, 1, 1);
		GuiDraw.changeTexture(getGuiTexture());
		GuiDraw.drawTexturedModalRect(0, 0, 5, 7, 166, 75);
	}

	@Override
	public int recipiesPerPage()
	{
		return 1;
	}

	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiAnvil.class;
	}

	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if(outputId.equals("crafting") && getClass() == AnvilNEI.class)
		{
			List<IRecipe> allrecipes = RioVAPI.getInstance().getCraftingManager().getRecipeList();

			for(IRecipe irecipe : allrecipes)
			{
				if(irecipe instanceof AnvilShapedRecipes)
				{
					AnvilShapedRecipes energyRecipe = (AnvilShapedRecipes)irecipe;
					CachedAnvilNEI recipe = new CachedAnvilNEI(energyRecipe.recipeWidth, energyRecipe.recipeHeight, energyRecipe.recipeItems, energyRecipe.getRecipeOutput());
					arecipes.add(recipe);
				}
			}
		}
		else 
		{
			super.loadCraftingRecipes(outputId, results);
		}
	}

	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		List<IRecipe> allrecipes = RioVAPI.getInstance().getCraftingManager().getRecipeList();

		for(IRecipe irecipe : allrecipes)
		{
			if(irecipe instanceof AnvilShapedRecipes && areEqual(irecipe.getRecipeOutput(), result))
			{
				AnvilShapedRecipes anvil = (AnvilShapedRecipes)irecipe;
				CachedAnvilNEI recipe = new CachedAnvilNEI(anvil.recipeWidth, anvil.recipeHeight, anvil.recipeItems, anvil.getRecipeOutput());
				arecipes.add(recipe);
			}
		}
	}

	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		List<IRecipe> allrecipes = RioVAPI.getInstance().getCraftingManager().getRecipeList();

		for(IRecipe irecipe : allrecipes)
		{
			if(irecipe instanceof AnvilShapedRecipes)
			{
				AnvilShapedRecipes anvil = (AnvilShapedRecipes)irecipe;
				CachedAnvilNEI recipe = new CachedAnvilNEI(anvil.recipeWidth, anvil.recipeHeight, anvil.recipeItems, anvil.getRecipeOutput());

				if(recipe.contains(recipe.ingredients, ingredient))
				{
					recipe.setIngredientPermutation(recipe.ingredients, ingredient);
					arecipes.add(recipe);
				}
			}
		}
	}

	public class CachedAnvilNEI extends TemplateRecipeHandler.CachedRecipe
	{
		public ArrayList<PositionedStack> ingredients;
		public PositionedStack result;

		public CachedAnvilNEI(int width, int height, Object[] items, ItemStack out)
		{
			result = new PositionedStack(out, 124, 37);
			ingredients = new ArrayList<PositionedStack>();
			setIngredients(width, height, items);
		}

		public void setIngredients(int width, int height, Object[] items)
		{
			for(int x = 0; x < width; x++)
			{
				for(int y = 0; y < height; y++)
				{
					if(items[y * width + x] == null)
					{
						continue;
					}

					PositionedStack stack = new PositionedStack(items[y * width + x], 39 + x * 18, 1 + y * 18);
					stack.setMaxSize(1);
					ingredients.add(stack);
				}
			}
		}

		@Override
		public ArrayList<PositionedStack> getIngredients()
		{
			return (ArrayList<PositionedStack>)getCycledIngredients(AnvilNEI.this.cycleticks / 20, ingredients);
		}

		@Override
		public PositionedStack getResult()
		{
			return result;
		}
	}

	public static boolean areEqual(ItemStack target, ItemStack input)
	{
		if(target == null && input != null || target != null && input == null)
		{
			return false;
		}
		else if(target == null && input == null)
		{
			return true;
		}

		if(target.getItem() != input.getItem())
		{
			return false;
		}

		return true;
	}
}