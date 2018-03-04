package sheenrox82.RioV.src.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.guide.GuideHelper;
import sheenrox82.RioV.src.util.LangHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGuideBook extends Item
{
	public ItemGuideBook()
	{
		super();
		this.setMaxDamage(0);
		this.setCreativeTab(RioVAPI.getInstance().tab);
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
		par3List.add(LangHelper.translate("msg.riov.Book"));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
	{
		GuideHelper.openJournal(player, "");
		return par1ItemStack;
	}
}
