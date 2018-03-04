package sheenrox82.RioV.src.api.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVPickaxe extends ItemPickaxe
{
	public boolean isInfused;
	public RioVPickaxe(ToolMaterial par2EnumToolMaterial, boolean par2)
	{
		super(par2EnumToolMaterial);
		this.isInfused = par2;
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("showToolInfo") == true)
		{
			var3.add(Color.gold + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.dark_purple + "Mining Speed: " + toolMaterial.getEfficiencyOnProperMaterial());
			var3.add(Color.aqua + "Harvest Level: " + toolMaterial.getHarvestLevel());
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(RioVAPI.getInstance().getUtil().mod_id + ":" + RioVAPI.getInstance().getUtil().getName(this.getUnlocalizedName()));

		if(RioVAPI.getInstance().natura)
		{
			if(this == RioVAPI.getInstance().getUtil().getRioVItem("infusedBloodwoodPickaxe") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedGhostwoodPickaxe") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedDarkwoodPickaxe") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedFusewoodPickaxe") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedNetherquartzPickaxe"))
				this.itemIcon = par1IconRegister.registerIcon(RioVAPI.getInstance().getUtil().getName(this.getUnlocalizedName()));
		}
	}
}
