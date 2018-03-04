package sheenrox82.RioV.src.world.provider;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.content.Biomes;
import sheenrox82.RioV.src.world.chunk.ChunkProviderFlamonor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderFlamonor extends WorldProvider
{
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Biomes.flamonor, 0.5F);
		this.dimensionId = Config.flamonorID;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderFlamonor(this.worldObj, this.worldObj.getSeed());
	}

	public String getDimensionName()
	{
		return "Flamonor";
	}

	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		return "Entering Flamonor";
	}
	
	public boolean canRespawnHere()
    {
        return false;
    }
	
    public String getSaveFolder()
    {
        return "FlamonorDim";
    }
}