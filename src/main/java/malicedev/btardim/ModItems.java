package malicedev.btardim;

import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDoor;
import net.minecraft.core.item.tag.ItemTags;
import turniplabs.halplibe.helper.ItemBuilder;

import static malicedev.btardim.Main.itemId;
import static malicedev.btardim.ModBlocks.*;

public class ModItems {
	private ModItems() {
	}


	public static Item DebugTardimDoorPlacer;
	public static Item DebugTardimWallPlacer;


	public static void init() {

		DebugTardimDoorPlacer = new ItemBuilder(Main.MOD_ID)
			.setTags(ItemTags.NOT_IN_CREATIVE_MENU)
			.build(new ItemDoor("debug_door_placer", "btardim:item/debug0", itemId++, BlockTardimDoorBottom, BlockTardimDoorTop));


		DebugTardimWallPlacer = new ItemBuilder(Main.MOD_ID)
			.setTags(ItemTags.NOT_IN_CREATIVE_MENU)
			.build(new ItemDoor("debug_wall_placer", "btardim:item/debug1", itemId++, BlockTardimWallBottom, BlockTardimWallTop));

	}


}

