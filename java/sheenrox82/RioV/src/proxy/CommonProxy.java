package sheenrox82.RioV.src.proxy;

import cpw.mods.fml.common.network.IGuiHandler;
import sheenrox82.RioV.src.container.ContainerAnvil;
import sheenrox82.RioV.src.container.ContainerBagLarge;
import sheenrox82.RioV.src.container.ContainerBagMedium;
import sheenrox82.RioV.src.container.ContainerBagSheen;
import sheenrox82.RioV.src.container.ContainerBagSmall;
import sheenrox82.RioV.src.container.ContainerInfuser;
import sheenrox82.RioV.src.container.ContainerRioVWorkbench;
import sheenrox82.RioV.src.gui.GuiAnvil;
import sheenrox82.RioV.src.gui.GuiGuide;
import sheenrox82.RioV.src.gui.GuiInfuser;
import sheenrox82.RioV.src.gui.GuiLargeBag;
import sheenrox82.RioV.src.gui.GuiMediumBag;
import sheenrox82.RioV.src.gui.GuiSheenBag;
import sheenrox82.RioV.src.gui.GuiSmallBag;
import sheenrox82.RioV.src.gui.GuiWorkbench;
import sheenrox82.RioV.src.inventory.InventoryBagLarge;
import sheenrox82.RioV.src.inventory.InventoryBagMedium;
import sheenrox82.RioV.src.inventory.InventoryBagSheen;
import sheenrox82.RioV.src.inventory.InventoryBagSmall;
import sheenrox82.RioV.src.lib.RioVLib;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;
import sheenrox82.RioV.src.util.Util;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler
{	
	public static int addArmor(String armorName)
	{
		return 0;
	}

	public void init()
	{	

	}

	public void cape()
	{

	}

	public void registerStuff()
	{

	}

	public ModelBiped getArmorModel(int id)
	{
		return null;
	}
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if(tile_entity instanceof TileEntityInfuser){

			return new ContainerInfuser(player.inventory, (TileEntityInfuser) tile_entity);
		}

		if (id == RioVLib.riovWorkbenchID)
		{
			return new ContainerRioVWorkbench(player.inventory, world, x, y, z);
		}

		if (id == RioVLib.anvilID)
		{
			return new ContainerAnvil(player.inventory, world, x, y, z);
		}

		if(id == RioVLib.smallBagID)
		{
			return new ContainerBagSmall(player, player.inventory, new InventoryBagSmall(player.getHeldItem()));
		}

		if(id == RioVLib.mediumBagID)
		{
			return new ContainerBagMedium(player, player.inventory, new InventoryBagMedium(player.getHeldItem()));
		}

		if(id == RioVLib.largeBagID)
		{
			return new ContainerBagLarge(player, player.inventory, new InventoryBagLarge(player.getHeldItem()));
		}

		if(player.getDisplayName().equals(Util.DEVELOPERS[0]))
		{
			if(id == RioVLib.sheensBagID)
			{
				return new ContainerBagSheen(player, player.inventory, new InventoryBagSheen(player.getHeldItem()));
			}
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){

		TileEntity tile_entity = world.getTileEntity(x, y, z);

		if(tile_entity instanceof TileEntityInfuser){

			return new GuiInfuser(player.inventory, (TileEntityInfuser) tile_entity);
		}
		
		if (id == RioVLib.riovWorkbenchID)
		{
			return new GuiWorkbench(player.inventory, world, x, y, z);
		}

		if (id == RioVLib.anvilID)
		{
			return new GuiAnvil(player.inventory, world, x, y, z);
		}

		if(id == RioVLib.smallBagID)
		{
			return new GuiSmallBag((ContainerBagSmall) new ContainerBagSmall(player, player.inventory, new InventoryBagSmall(player.getHeldItem())));
		}

		if(id == RioVLib.mediumBagID)
		{
			return new GuiMediumBag((ContainerBagMedium) new ContainerBagMedium(player, player.inventory, new InventoryBagMedium(player.getHeldItem())));
		}

		if(id == RioVLib.largeBagID)
		{
			return new GuiLargeBag((ContainerBagLarge) new ContainerBagLarge(player, player.inventory, new InventoryBagLarge(player.getHeldItem())));
		}

		if(player.getDisplayName().equals(Util.DEVELOPERS[0]))
		{
			if(id == RioVLib.sheensBagID)
			{
				return new GuiSheenBag((ContainerBagSheen) new ContainerBagSheen(player, player.inventory, new InventoryBagSheen(player.getHeldItem())));
			}
		}
		
		if(id == RioVLib.guideID)
		{
			return new GuiGuide(player.getDisplayName(), "");
		}
	
		return null;
	}
}