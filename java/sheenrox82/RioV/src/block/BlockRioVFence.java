package sheenrox82.RioV.src.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.base.RioVAPI;
import sheenrox82.RioV.src.content.RioVBlocks;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRioVFence extends BlockFence
{
    public final String field_94464_a;
    protected final Material blockMaterial = Material.air;
    
    public BlockRioVFence(String par2Str)
    {
        super(par2Str, Material.wood);
        this.field_94464_a = par2Str;
		this.setStepSound(Block.soundTypeWood);
        this.setCreativeTab(RioVAPI.getInstance().tab);
    }

	@SuppressWarnings({ "rawtypes" })
    public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_)
    {
        boolean flag = this.canConnectFenceTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ - 1);
        boolean flag1 = this.canConnectFenceTo(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_ + 1);
        boolean flag2 = this.canConnectFenceTo(p_149743_1_, p_149743_2_ - 1, p_149743_3_, p_149743_4_);
        boolean flag3 = this.canConnectFenceTo(p_149743_1_, p_149743_2_ + 1, p_149743_3_, p_149743_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag || flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
        }

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        boolean flag = this.canConnectFenceTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
        boolean flag1 = this.canConnectFenceTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
        boolean flag2 = this.canConnectFenceTo(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
        boolean flag3 = this.canConnectFenceTo(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_)
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return 11;
    }
    
    public IIcon blockIcon;
    
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}
	
    @SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        if(this == RioVBlocks.glimmerwoodFence) this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "glimmerwoodPlanks");
        if(this == RioVBlocks.cherryBlossomFence) this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryPlanks");
        if(this == RioVBlocks.bloodFence) this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodPlanks");
        if(this == RioVBlocks.skywoodFence) this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodPlanks");
    }
}
