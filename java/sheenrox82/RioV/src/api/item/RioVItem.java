package sheenrox82.RioV.src.api.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import sheenrox82.RioV.src.api.base.RioVAPI;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVItem extends Item
{
	public RioVItem()
	{
		super();
		this.setMaxDamage(0);
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("orb")))
		{
			return true;
		}

		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(RioVAPI.getInstance().getUtil().mod_id + ":" + RioVAPI.getInstance().getUtil().getName(this.getUnlocalizedName()));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
		{
			if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("amethyst")))par3List.add("A gem to show wealth and power");
			if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("onyx")))par3List.add("A dark mass");
			if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("vravinite")))par3List.add("A crystal to show confidence");
			if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("aleris")))par3List.add("A gem to show defence and strategies");
		}
		else
		{
			if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("amethyst")) ||
					par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("onyx")) ||
					par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("vravinite")) ||
					par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("aleris")))
			{
				par3List.add("[SHIFT]");
			}
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
	{
		if(par1ItemStack.getItem().equals(RioVAPI.getInstance().getUtil().getRioVItem("heart")))
		{
			if(player.getHealth() < player.getMaxHealth())
			{
				player.heal(1);

				player.inventory.consumeInventoryItem(RioVAPI.getInstance().getUtil().getRioVItem("heart"));
			}

			if(player.getHealth() >= 20 && player.getMaxHealth() < 60)
			{
				double amount = 2D;

				try
				{
					amount = player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getModifier(player.getPersistentID()).getAmount() + 2D;
				}
				catch (Exception e) {}

				AttributeModifier moreHealth = new AttributeModifier(player.getPersistentID(), "newHealth", amount, 0);
				IAttributeInstance attributeInstance = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);	
				attributeInstance.removeModifier(moreHealth);
				attributeInstance.applyModifier(moreHealth);
			}
		}

		return par1ItemStack;
	}
}
