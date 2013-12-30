package me.dale3rulz5577.dimension51.main;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGen1 extends BiomeGenBase {

	public BiomeGen1(int id) {
		super(id);
		this.topBlock= (byte) Block.glass.blockID;
		this.fillerBlock = (byte) Main.hydrablock.blockID;
	}

}
