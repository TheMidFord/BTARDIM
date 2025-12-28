package malicedev.btardim.models;

import malicedev.btardim.block.BlockLogicTardimDoor;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.WorldSource;
import org.useless.dragonfly.data.block.mojang.state.MetaStateInterpreter;

import java.util.HashMap;

public class DoortatableStateInterpreter extends MetaStateInterpreter {

	@Override
	public HashMap<String, String> getStateMap(WorldSource worldSource, int x, int y, int z, Block<?> block, int meta) {
		HashMap<String, String> result = new HashMap<>();
		result.put("side", Side.getSideById(meta).name().toLowerCase()+ (BlockLogicTardimDoor.isOpen(meta)?"_open":""));
		return result;
	}
}
