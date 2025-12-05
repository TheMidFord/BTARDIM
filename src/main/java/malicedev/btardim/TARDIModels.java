package malicedev.btardim;

import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import org.useless.DragonFly;
import org.useless.dragonfly.models.block.BlockModelDFJava;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

import static malicedev.btardim.ModBlocks.BlockTardimRoof;

public class TARDIModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {
		ModelHelper.setBlockModel(BlockTardimRoof, ()->
			new BlockModelDFJava<>(BlockTardimRoof, DragonFly.loadBlockModel("btardim/block:tardim_roof"))
			);
	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {

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
