package malicedev.btardim;

import malicedev.btardim.models.DoortatableStateInterpreter;
import malicedev.btardim.models.RotatableStateInterpreter;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelEmpty;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import org.useless.DragonFly;
import org.useless.dragonfly.models.block.BlockModelDFJava;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static malicedev.btardim.ModBlocks.*;

public class TARDIModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {
		ModelHelper.setBlockModel(BlockTardimRoof, ()->
			new BlockModelDFJava<>(BlockTardimRoof, DragonFly.loadBlockModel("btardim:block/btardim_roof"))
			);
		ModelHelper.setBlockModel(BlockTardimWallBottom, ()->
			new BlockModelDFJava<>(BlockTardimWallBottom, DragonFly.loadBlockModel("btardim:block/btardim_wall_bottom"))
				.setStateInterpreter(new RotatableStateInterpreter())
				.setStateData("btardim:btardim_wall_bottom")
			);
		ModelHelper.setBlockModel(BlockTardimWallTop, ()->
			new BlockModelDFJava<>(BlockTardimWallTop, DragonFly.loadBlockModel("btardim:block/btardim_wall_top"))
				.setStateInterpreter(new RotatableStateInterpreter())
				.setStateData("btardim:btardim_wall_top")
		);
		ModelHelper.setBlockModel(BlockTardimFullModel, ()->
			new BlockModelDFJava<>(BlockTardimFullModel, DragonFly.loadBlockModel("btardim:block/btardim_full"))
		);
		ModelHelper.setBlockModel(BlockTardimDoorBottom, ()->
			new BlockModelDFJava<>(BlockTardimDoorBottom, DragonFly.loadBlockModel("btardim:block/btardim_door_closed_north"))
				.setStateInterpreter(new DoortatableStateInterpreter())
				.setStateData("btardim:btardim_door")
		);
		blockModelDispatcher.addDispatch(BlockTardimTeleSpace,new BlockModelEmpty<>(BlockTardimTeleSpace)
			);

	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {
		itemModelDispatcher.addDispatch(new ItemModelStandard(ModItems.DebugTardimDoorPlacer, null).setIcon("btardim:item/debug0"));
		itemModelDispatcher.addDispatch(new ItemModelStandard(ModItems.DebugTardimWallPlacer, null).setIcon("btardim:item/debug1"));
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
