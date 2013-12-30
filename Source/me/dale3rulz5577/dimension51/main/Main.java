package me.dale3rulz5577.dimension51.main;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Dimension51", name = "Dimension 51", version = "1.0.0 APLHA")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class Main {
	public static Block hydraore;
	public static Block hydrablock;
	public static Block blockTeleporter;
	public static BiomeGenBase biome1;
	public static Item hydraessence;
	public static Item hydra;
	
	public final static int dimensionId = 51;
	@Init
	public void load(FMLInitializationEvent event) {
		blockTeleporter = new BlockTeleporter(3104).setUnlocalizedName("teleporter");
		hydra = new Hydra(3102).setUnlocalizedName("hydra_item");
		hydrablock = new HydraBlock(3103, "hydrablock")
		.setUnlocalizedName("hydrablock").setHardness(40.0F)
		.setStepSound(Block.soundStoneFootstep).setResistance(6000.0F);
		hydraessence = new HydraEssence(3101).setUnlocalizedName("hydraessence");
		hydraore = new HydraOre(3100, "hydraore")
				.setUnlocalizedName("hydraore").setHardness(25.0F)
				.setStepSound(Block.soundStoneFootstep);
		biome1 = new BiomeGen1(51).setBiomeName("Alien Planet").setTemperatureRainfall(1.2F, 0.9F);
		MinecraftForge.setBlockHarvestLevel(hydraore, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(hydrablock, "pickaxe", 3);
		
		DimensionManager.registerProviderType(dimensionId, WorldProviderD51.class, false);
		DimensionManager.registerDimension(dimensionId, dimensionId);
		GameRegistry.registerBlock(blockTeleporter, "Teleportation block");
		GameRegistry.registerItem(hydra, "hydra");
		GameRegistry.registerBlock(hydrablock, "hydra_block");
		GameRegistry.registerItem(hydraessence, "hydra_essence");
		GameRegistry.registerBlock(hydraore, "hydra_ore");
		GameRegistry.addBiome(biome1);
		
		LanguageRegistry.addName(hydra, "Hydra");
		LanguageRegistry.addName(hydrablock, "Block of Hydra");
		LanguageRegistry.addName(hydraessence, "Essence of Hydra");
		LanguageRegistry.addName(hydraore, "Hydra Ore");
		
		GameRegistry.addShapelessRecipe(new ItemStack(hydra, 9),
				new Object[]{
			hydrablock});
		GameRegistry.addRecipe(new ItemStack(hydrablock, 1),
				new Object[]{
						"TTT", "TTT", "TTT", 'T', hydra,});
		GameRegistry.registerWorldGenerator(new HydraOreWorldGenerator());
		GameRegistry.addSmelting(hydraessence.itemID, new ItemStack(hydra, 1), 5F);
	}

}
