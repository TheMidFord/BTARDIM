package malicedev.btardim;

import malicedev.btardim.block.BlockLogicTardimRoof;
import malicedev.btardim.block.BlockLogicTardimWall;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelSlab;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicSlab;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.sound.BlockSound;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.helper.BlockBuilder;
import static malicedev.btardim.Main.blockId;

public class ModBlocks {
	private ModBlocks() {}
	public static Block BlockTardimRoof;
	public static Block BlockTardimWallBottom;
	public static Block BlockTardimWallTop;

	public static void init() {
		BlockTardimRoof = new BlockBuilder(Main.MOD_ID)
			.setUnbreakable()
			.setResistance(99999999)
			.setBlockSound(BlockSounds.WOOD)
			.build("tardim_roof","tardim_roof",blockId++,
				(block) -> new BlockLogicTardimRoof(block, Material.wood));

		BlockTardimWallBottom = new BlockBuilder(Main.MOD_ID)
			.setUnbreakable()
			.setResistance(99999999)
			.setBlockSound(BlockSounds.WOOD)
			.build("tardim_wall_bottom","tardim_wall_bottom",blockId++,
				(block) -> new BlockLogicTardimWall(block, Material.wood));

		BlockTardimWallTop = new BlockBuilder(Main.MOD_ID)
			.setUnbreakable()
			.setResistance(99999999)
			.setBlockSound(BlockSounds.WOOD)
			.build("tardim_wall_top","tardim_wall_top",blockId++,
				(block) -> new BlockLogicTardimWall(block, Material.wood));

	}
}
