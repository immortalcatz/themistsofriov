package sheenrox82.RioV.src.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.Materials;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.content.RioVItems;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCloudPlant extends BlockBush
{
	public BlockCloudPlant()
	{
		super(Materials.customMaterial);
		this.setStepSound(Block.soundTypeGrass);
		this.setCreativeTab(null);
		this.setHardness(0.3F);
	}

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3)
	{
		if(this == RioVBlocks.cloudBerryPlant)
		{
			return RioVItems.cloudBerry;
		}

		return Item.getItemFromBlock(null);
	}

	@SideOnly(Side.CLIENT)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + RioVAPI.getInstance().getUtil().getName(this.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return blockIcon;
	}

	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	protected boolean canPlaceBlockOn(Block par1)
	{		
		return par1 == RioVBlocks.sanctuatiteGrass;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
	{
		return AxisAlignedBB.getBoundingBox((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)var3, (double)(var4 + 1));
	}
}
