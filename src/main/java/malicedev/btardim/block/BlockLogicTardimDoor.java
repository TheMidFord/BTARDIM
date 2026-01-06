package malicedev.btardim.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.BlockLogicDoor;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class BlockLogicTardimDoor extends BlockLogic {
	public BlockLogicTardimDoor(Block<?> block, Material material, boolean isTop) {
		super(block, material);
		this.isTop = isTop;
//  		if (isTop) {
//  			this.setBlockBounds(0.5F - f, -1.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
//  		} else {
//  			this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 2.0F, 0.5F + f);
//  		}
	}

	public boolean isTop;

  	public AABB getBoundsForRotation(int rotation, boolean drawingSelection) {
  		float top = 1.0F;
  		float bottom = 0.0F;
  		if (this.isTop && drawingSelection) {
  			top = 1.0F;
  			bottom = -1.0F;
  		} else if (drawingSelection) {
  			top = 2.0F;
  			bottom = 0.0F;
  		}

  		switch (rotation) {
  			case 0:
  				return AABB.getTemporaryBB(0.0F, bottom, 0.0F, 0.1875F, top, 1.0F);
  			case 1:
  				return AABB.getTemporaryBB(0.0F, bottom, 0.0F, 1.0F, top, 0.1875F);
  			case 2:
  				return AABB.getTemporaryBB((1-0.1875F), bottom, 0.0F, 1.0F, top, 1.0F);
  			case 3:
			default:
  				return AABB.getTemporaryBB(0.0F, bottom, (1-0.1875F), 1.0F, top, 1.0F);

  		}

  	}


	public int getRotation(int i) {
		return i & 3;
	}

	public static boolean isOpen(int i) {
		return (i & 4) == 4;
	}

  	@Override
  	public void getCollidingBoundingBoxes(World world, int x, int y, int z, AABB aabb, ArrayList<AABB> aabbList) {
  		int meta = world.getBlockMetadata(x, y, z);
  		int hRotation = meta & 7;
		  float THICC = (0.1875F)/2;
  		switch (hRotation) {
  			case 0: //East
  				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F).move(x,y,z), aabbList);
  				break;
  			case 1: //South
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F).move(x,y,z), aabbList);
				break;
  			case 2: // West
  				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.1875F, 1.0F, 1.0F).move(x + (1 - 0.1875F), y, z), aabbList);
				break;
  			case 3: //North
  				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1875F).move(x, y, z + (1 - 0.1875F)), aabbList);
  				break;
  			case 4:  //East
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, THICC).move(x, y, z), aabbList);
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, THICC).move(x, y, z + (1-THICC)), aabbList);
				break;
  			case 5: //South
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, THICC, 1.0F, 0.5F).move(x, y, z), aabbList);
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, THICC, 1.0F, 0.5F).move(x + (1-THICC), y, z), aabbList);
				break;
  			case 6:  //West
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, THICC).move(x + 0.5F, y, z), aabbList);
				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, 0.5F, 1.0F, THICC).move(x + 0.5F, y, z + (1-THICC)), aabbList);
				break;
  			case 7: //North
  			default:
  				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, THICC, 1.0F, 0.5F).move(x, y, z + 0.5F), aabbList);
  				this.addIntersectingBoundingBox(aabb, AABB.getTemporaryBB(0.0F, 0.0F, 0.0F, THICC, 1.0F, 0.5F).move(x + (1-THICC), y, z + 0.5F), aabbList);
  				break;
  		}
  	}

	@Override
	public void onBlockPlacedOnSide(World world, int x, int y, int z, @NotNull Side side, double xPlaced, double yPlaced) {
		super.onBlockPlacedOnSide(world, x, y, z, side, xPlaced, yPlaced);
		int meta = world.getBlockMetadata(x, y, z);
		if (world.hasNeighborSignal(x, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, meta | 4);
			if (this.isTop) {
				world.setBlockMetadataWithNotify(x, y - 1, z, meta | 4);
			} else {
				world.setBlockMetadataWithNotify(x, y + 1, z, meta | 4);
			}

			world.playBlockEvent(1003, x, y, z, 0);
		}

	}

	@Override
	public void onBlockRemoved(World world, int x, int y, int z, int data) {
		if (this.isTop) {
			if (world.getBlockLogic(x, y - 1, z, BlockLogicTardimDoor.class) != null) {
				world.setBlockWithNotify(x, y - 1, z, 0);
			}
		} else if (world.getBlockLogic(x, y + 1, z, BlockLogicTardimDoor.class) != null) {
			world.setBlockWithNotify(x, y + 1, z, 0);
		}

	}

  	@Override
  	public AABB getBlockBoundsFromState(WorldSource world, int x, int y, int z) {
  		return this.getBoundsForRotation(this.getRotation(world.getBlockMetadata(x, y, z)), false);
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

	@Override
	public void onBlockLeftClicked(World world, int x, int y, int z, Player player, Side side, double xHit, double yHit) {
		if (!Item.hasTag(player.getCurrentEquippedItem(), ItemTags.PREVENT_LEFT_CLICK_INTERACTIONS)) {
			this.onBlockRightClicked(world, x, y, z, player, side, xHit, yHit);
		}

	}

	@Override
	public boolean onBlockRightClicked(World world, int x, int y, int z, @Nullable Player player, Side side, double xPlaced, double yPlaced) {
		if (this.material != Material.metal && this.material != Material.steel) {
			int l = world.getBlockMetadata(x, y, z);
			if (this.isTop) {
				Block<?> b;
				if ((b = Blocks.blocksList[world.getBlockId(x, y - 1, z)]) != null && b.getLogic() instanceof BlockLogicTardimDoor) {
					Blocks.blocksList[world.getBlockId(x, y - 1, z)].onBlockRightClicked(world, x, y - 1, z, player, side, xPlaced, yPlaced);
				}

				return true;
			} else {
				Block<?> b;
				if ((b = Blocks.blocksList[world.getBlockId(x, y + 1, z)]) != null && b.getLogic() instanceof BlockLogicTardimDoor) {
					world.setBlockMetadataWithNotify(x, y + 1, z, l ^ 4);
				}

				world.setBlockMetadataWithNotify(x, y, z, l ^ 4);
				world.markBlocksDirty(x, y - 1, z, x, y, z);
				world.playBlockEvent(player, 1003, x, y, z, 0);
				return true;
			}
		} else {
			return false;
		}
	}
}
