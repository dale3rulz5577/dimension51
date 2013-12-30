package me.dale3rulz5577.dimension51.main;

import java.util.Random;

import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterD51 extends Teleporter{

	private final WorldServer worldServerInstance;
	private final Random random;
	public TeleporterD51(WorldServer par1WorldServer) {
		super(par1WorldServer);
		
		this.worldServerInstance = par1WorldServer;
		this.random = new Random(par1WorldServer.getSeed());
		
	}

}
