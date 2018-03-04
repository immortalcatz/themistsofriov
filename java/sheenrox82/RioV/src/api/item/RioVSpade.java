package sheenrox82.RioV.src.api.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.api.util.Color;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVSpade extends ItemSpade
{
	public boolean isInfused;

	public RioVSpade(ToolMaterial par2EnumToolMaterial, boolean par2)
	{
		super(par2EnumToolMaterial);
		this.isInfused = par2;
		this.setCreativeTab(RioVAPI.getInstance().tab);
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if (isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(RioVAPI.getInstance().getUtil().mod_id + ":" + RioVAPI.getInstance().getUtil().getName(this.getUnlocalizedName()));

		if(RioVAPI.getInstance().natura)
		{
			if(this == RioVAPI.getInstance().getUtil().getRioVItem("infusedBloodwoodShovel") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedGhostwoodShovel") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedDarkwoodShovel") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedFusewoodShovel") || this == RioVAPI.getInstance().getUtil().getRioVItem("infusedNetherquartzShovel"))
				this.itemIcon = par1IconRegister.registerIcon(RioVAPI.getInstance().getUtil().getName(this.getUnlocalizedName()));
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(RioVAPI.getInstance().getUtil().getConfigBool("showToolInfo") == true)
		{
			var3.add(Color.gold + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.dark_purple + "Digging Speed: " + toolMaterial.getEfficiencyOnProperMaterial());
			var3.add(Color.aqua + "Harvest Level: " + toolMaterial.getHarvestLevel());
		}
	}
}
