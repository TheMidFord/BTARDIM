package malicedev.btardim.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicRotatable;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.ArrayList;

public class BlockLogicTardimWall extends BlockLogicRotatable {
	public BlockLogicTardimWall(Block<?> block, Material material) {
		super(block, material);
		//this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
	}


	@Override
	public void getCollidingBoundingBoxes(World world, int x, int y, int z, AABB aabb, ArrayList<AABB> aabbList) {
		int meta = world.getBlockMetadata(x, y, z);
		int hRotation = meta & 3;
		switch (hRotation) {
			case 0:
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F).move(x, y, z), aabbList);
				break;
			case 1:
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F).move(x + (1 - 0.1875F), y, z), aabbList);
				break;
			case 2:
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F).move(x, y, z), aabbList);
				break;
			default:
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F).move(x, y, z + (1 - 0.1875F)), aabbList);

		}
	}

	public AABB getBlockBoundsFromState(WorldSource world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		int hRotation = meta & 3;
		switch (hRotation) {
			case 0:
				return AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F);
			case 1:
				return AABB.getTemporaryBB((1 - 0.1875F), 0.0F, 0.0F, 1, 1.0F, 1.0F);//.move(x + (1 - 0.1875F), y, z);
			case 2:
				return AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F);
			default:
				return AABB.getTemporaryBB(0.0F, 0.0F, (1 - 0.1875F), 1.0F, 1.0F, 1);//.move(x, y, z + (1 - 0.1875F));
		}
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return null;

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
