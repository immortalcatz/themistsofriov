package sheenrox82.RioV.src.block;

import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.util.Util;

public class BlockSancuatiteStill extends BlockStaticLiquid
{
	public IIcon blockIcon;
	
	public BlockSancuatiteStill() 
	{
		super(Material.water);
		this.setCreativeTab(null);
	}

	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return blockIcon;
	}

	@Override
	public void registerBlockIcons(IIconRegister i)
	{
		this.blockIcon = i.registerIcon(Util.MOD_ID + ":" + RioVAPI.getInstance().getUtil().getName(this.getUnlocalizedName()));
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (par5Entity instanceof EntityLivingBase)
		{
			((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 100, 2));
		}
	}
}
