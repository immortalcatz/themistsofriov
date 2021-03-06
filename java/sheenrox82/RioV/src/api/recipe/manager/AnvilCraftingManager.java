package sheenrox82.RioV.src.api.recipe.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.recipe.AnvilShapedRecipes;
import sheenrox82.RioV.src.api.recipe.AnvilShapelessRecipes;

public class AnvilCraftingManager
{
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	public static AnvilCraftingManager instance = new AnvilCraftingManager();
	public static ArrayList<IRecipe> recipes = new ArrayList<IRecipe>();

	public AnvilCraftingManager()
	{
		recipes = new ArrayList<IRecipe>();
		
		Collections.sort(AnvilCraftingManager.recipes, new Comparator<Object>()
		{
			public int compare(IRecipe par1IRecipe, IRecipe par2IRecipe)
			{
				return par1IRecipe instanceof AnvilShapelessRecipes && par2IRecipe instanceof AnvilShapedRecipes ? 1 : (par2IRecipe instanceof AnvilShapelessRecipes && par1IRecipe instanceof AnvilShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
			}
			public int compare(Object par1Obj, Object par2Obj)
			{
				return this.compare((IRecipe)par1Obj, (IRecipe)par2Obj);
			}
		});
	}

	public AnvilShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (par2ArrayOfObj[i] instanceof String[])
		{
			String[] astring = (String[])((String[])par2ArrayOfObj[i++]);

			for (int l = 0; l < astring.length; ++l)
			{
				String s1 = astring[l];
				++k;
				j = s1.length();
				s = s + s1;
			}
		}
		else
		{
			while (par2ArrayOfObj[i] instanceof String)
			{
				String s2 = (String)par2ArrayOfObj[i++];
				++k;
				j = s2.length();
				s = s + s2;
			}
		}

		HashMap<Character, ItemStack> hashmap;

		for (hashmap = new HashMap<Character, ItemStack>(); i < par2ArrayOfObj.length; i += 2)
		{
			Character character = (Character)par2ArrayOfObj[i];
			ItemStack itemstack1 = null;

			if (par2ArrayOfObj[i + 1] instanceof Item)
			{
				itemstack1 = new ItemStack((Item)par2ArrayOfObj[i + 1]);
			}
			else if (par2ArrayOfObj[i + 1] instanceof Block)
			{
				itemstack1 = new ItemStack((Block)par2ArrayOfObj[i + 1], 1, 32767);
			}
			else if (par2ArrayOfObj[i + 1] instanceof ItemStack)
			{
				itemstack1 = (ItemStack)par2ArrayOfObj[i + 1];
			}

			hashmap.put(character, itemstack1);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1)
		{
			char c0 = s.charAt(i1);

			if (hashmap.containsKey(Character.valueOf(c0)))
			{
				aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
			}
			else
			{
				aitemstack[i1] = null;
			}
		}

		AnvilShapedRecipes shapedrecipes = new AnvilShapedRecipes(j, k, aitemstack, par1ItemStack);
		AnvilCraftingManager.recipes.add(shapedrecipes);
		return shapedrecipes;
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		ArrayList<ItemStack> arraylist = new ArrayList<ItemStack>();
		Object[] aobject = par2ArrayOfObj;
		int i = par2ArrayOfObj.length;

		for (int j = 0; j < i; ++j)
		{
			Object object1 = aobject[j];

			if (object1 instanceof ItemStack)
			{
				arraylist.add(((ItemStack)object1).copy());
			}
			else if (object1 instanceof Item)
			{
				arraylist.add(new ItemStack((Item)object1));
			}
			else
			{
				if (!(object1 instanceof Block))
				{
					throw new RuntimeException("Invalid shapeless recipy!");
				}

				arraylist.add(new ItemStack((Block)object1));
			}
		}

		AnvilCraftingManager.recipes.add(new AnvilShapelessRecipes(par1ItemStack, arraylist));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
	{
		int i = 0;
		ItemStack itemstack = null;
		ItemStack itemstack1 = null;
		int j;

		for (j = 0; j < par1InventoryCrafting.getSizeInventory(); ++j)
		{
			ItemStack itemstack2 = par1InventoryCrafting.getStackInSlot(j);

			if (itemstack2 != null)
			{
				if (i == 0)
				{
					itemstack = itemstack2;
				}

				if (i == 1)
				{
					itemstack1 = itemstack2;
				}

				++i;
			}
		}

		if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
		{
			Item item = itemstack.getItem();
			int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
			int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
			int l = j1 + k + item.getMaxDamage() * 5 / 100;
			int i1 = item.getMaxDamage() - l;

			if (i1 < 0)
			{
				i1 = 0;
			}

			return new ItemStack(itemstack.getItem(), 1, i1);
		}
		else
		{
			for (j = 0; j < AnvilCraftingManager.recipes.size(); ++j)
			{
				IRecipe irecipe = (IRecipe)AnvilCraftingManager.recipes.get(j);

				if (irecipe.matches(par1InventoryCrafting, par2World))
				{
					return irecipe.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}
	}

	public List<IRecipe> getRecipeList()
	{
		return AnvilCraftingManager.recipes;
	}
}