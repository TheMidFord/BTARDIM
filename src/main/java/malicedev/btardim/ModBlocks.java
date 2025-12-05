package malicedev.btardim;

import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelSlab;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicSlab;
import net.minecraft.core.block.material.Material;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.helper.BlockBuilder;
import static malicedev.btardim.Main.blockId;

public class ModBlocks {
	private ModBlocks() {}
	public static Block BlockTardimRoof;

	public static void init() {
		BlockTardimRoof = new BlockBuilder(Main.MOD_ID)
			.setUnbreakable()
			.build("tardim.roof","tardim_roof",blockId++,
				(block) -> new BlockLogic(block, Material.wood));

	}
}
