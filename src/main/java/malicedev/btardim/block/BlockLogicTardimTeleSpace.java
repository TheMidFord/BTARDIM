package malicedev.btardim.block;

import malicedev.btardim.ModDimensions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.WorldClient;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;

public class BlockLogicTardimTeleSpace extends BlockLogic {
	public BlockLogicTardimTeleSpace(Block<?> block, Material material) {
		super(block, material);
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(WorldSource world, int x, int y, int z) {
		return null;
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		return null;

	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		super.onEntityCollidedWithBlock(world, x, y, z, entity);
		Minecraft.getMinecraft().thePlayer.removed = false;
		Minecraft.getMinecraft().thePlayer.dimension = ModDimensions.BTARDIMInterior;
		float xrot = entity.xRot;
		float yrot = entity.yRot;
		WorldClient worldClient = new WorldClient(Minecraft.getMinecraft().currentWorld, ModDimensions.BTARDIMInterior);
		Minecraft.getMinecraft().changeWorld(worldClient,"Biggering on your insides",Minecraft.getMinecraft().thePlayer);
		entity.moveTo(0,60,0,yrot,xrot);

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
