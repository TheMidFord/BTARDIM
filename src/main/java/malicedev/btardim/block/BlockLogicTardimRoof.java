package malicedev.btardim.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.ArrayList;

public class BlockLogicTardimRoof extends BlockLogic {
	public BlockLogicTardimRoof(Block<?> block, Material material) {
		super(block, material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	@Override
	public void getCollidingBoundingBoxes(World world, int x, int y, int z, AABB aabb, ArrayList<AABB> aabbList) {
		this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F).move(x, y, z), aabbList);
		this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F).move(x + 0.25, y + 0.5, z + 0.25), aabbList);
	}

	@Override
	public boolean renderAsNormalBlockOnCondition(WorldSource world, int x, int y, int z) {
		return false;
	}
	@Override
	public boolean isSolidRender() {
		return false;
	}


}
