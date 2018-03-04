package sheenrox82.RioV.src.baubles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import sheenrox82.RioV.src.api.item.RioVItem;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class RioVRing extends RioVItem implements IBauble
{
	public int protectionLevel;
	public boolean isInfused;
	
	public RioVRing(int protectionLevel, boolean infused)
	{
		super();
		this.isInfused = infused;
		this.protectionLevel = protectionLevel;
	}
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(this.isInfused)
		{
			return true;
		}

		return false;
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack itemstack) 
	{
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) 
	{
		player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 100, protectionLevel));
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) 
	{
		
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
	{
		
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) 
	{
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) 
	{
		return true;
	}
}
