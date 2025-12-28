package malicedev.btardim.models;

import malicedev.btardim.block.BlockLogicTardimDoor;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.WorldSource;
import org.useless.dragonfly.data.block.mojang.state.MetaStateInterpreter;

import java.util.HashMap;

public class DoortatableStateInterpreter extends MetaStateInterpreter {

	@Override
	public HashMap<String, String> getStateMap(WorldSource worldSource, int x, int y, int z, Block<?> block, int meta) {
		HashMap<String, String> result = new HashMap<>();
		switch (meta&3) {
			case 0: result.put("side", "west" + (BlockLogicTardimDoor.isOpen(meta)?"_open":""));
				break;
			case 1: result.put("side", "north"+ (BlockLogicTardimDoor.isOpen(meta)?"_open":""));
				break;
			case 2:result.put("side", "east"+ (BlockLogicTardimDoor.isOpen(meta)?"_open":""));
				break;
			case 3:
			default: result.put("side", "south"+ (BlockLogicTardimDoor.isOpen(meta)?"_open":""));
				break;

		}
		return result;

	}
}
