package malicedev.btardim;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemDoor;
import turniplabs.halplibe.helper.ItemBuilder;

import static malicedev.btardim.Main.itemId;
import static malicedev.btardim.ModBlocks.BlockTardimDoorBottom;
import static malicedev.btardim.ModBlocks.BlockTardimDoorTop;

public class ModItems {
	private ModItems() {};
	public static Item DebugTardimDoorPlacer;


	public static void init() {

			DebugTardimDoorPlacer = new ItemBuilder(Main.MOD_ID)
				.build(new ItemDoor("debug_door_placer", "btardim:item/debug_door_placer", itemId++, BlockTardimDoorBottom, BlockTardimDoorTop));
		}
	}

