package malicedev.btardim.mixin;

import malicedev.btardim.interfaces.IEntityTeleportCooldown;
import net.minecraft.core.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = 	Entity.class,remap = false)
public class EntityMixin implements IEntityTeleportCooldown {
	@Unique
	boolean cooldown = false;

	@Override
	public boolean getTeleportCooldown() {
		return cooldown;
	}

	@Override
	public void setTeleportCooldown(boolean cooldown) {
		this.cooldown = cooldown;
	}
}
