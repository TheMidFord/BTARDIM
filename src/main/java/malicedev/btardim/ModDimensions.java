package malicedev.btardim;

import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.type.WorldTypes;

import static malicedev.btardim.Main.dimId;

public class ModDimensions {
	private ModDimensions(){}


	public static void init() {
		Dimension BTARDIMInterior = new Dimension("btardiminterior", null, 1, null, WorldTypes.EMPTY);
		Dimension.registerDimension(dimId,BTARDIMInterior);
	}
}
