package me.dale3rulz5577.dimension51.main;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderHell;

public class WorldProviderD51 extends WorldProvider{

	public void registerChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.jungle, 0.2F, 0.75F);
		this.dimensionId = Main.dimensionId;
	}
	
	public IChunkProvider createChunkProvider(){
		return new ChunkProviderD51();
	}
	public String getDimensionName() {
		return "Dimension 51";
	}

}
