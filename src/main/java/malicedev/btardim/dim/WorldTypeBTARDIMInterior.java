package malicedev.btardim.dim;


import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.provider.BiomeProvider;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.type.WorldType;

public class WorldTypeBTARDIMInterior extends WorldType {

	public WorldTypeBTARDIMInterior(Properties properties) {
		super(properties);
	}

	@Override
	public BiomeProvider createBiomeProvider(World world) {
		return null;
	}

	@Override
	public ChunkGenerator createChunkGenerator(World world) {
		return null;
	}

	@Override
	public boolean isValidSpawn(World world, int i, int i1, int i2) {
		return false;
	}

	@Override
	public float getCelestialAngle(World world, long l, float v) {
		return 0;
	}

	@Override
	public int getSkyDarken(World world, long l, float v) {
		return 0;
	}
}
