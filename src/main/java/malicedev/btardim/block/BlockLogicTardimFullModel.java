package malicedev.btardim.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

import java.util.ArrayList;

public class BlockLogicTardimFullModel extends BlockLogic {
	public BlockLogicTardimFullModel(Block<?> block, Material material) {
		super(block, material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1F, 1.0F);
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
