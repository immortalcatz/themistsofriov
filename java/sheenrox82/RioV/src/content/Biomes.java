package sheenrox82.RioV.src.content;

import net.minecraft.world.biome.BiomeGenBase;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.world.biome.BiomeGenBlindOasis;
import sheenrox82.RioV.src.world.biome.BiomeGenFlamonor;
import sheenrox82.RioV.src.world.biome.BiomeGenGlimmerwood;
import sheenrox82.RioV.src.world.biome.BiomeGenSanctuatite;

public class Biomes 
{
	public static BiomeGenBase blindOasis = new BiomeGenBlindOasis(Config.blindOasisBiomeID);
	public static BiomeGenBase glimmerwood = new BiomeGenGlimmerwood(Config.glimmerwoodBiomeID);
	public static BiomeGenBase flamonor = new BiomeGenFlamonor(Config.flamonorBiomeID);
	public static BiomeGenBase sanctuatite = new BiomeGenSanctuatite(Config.sanctuatiteBiomeID);
}
