package malicedev.btardim;

import net.minecraft.client.render.texture.stitcher.AtlasStitcher;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.TextureHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;

import static malicedev.btardim.Main.MOD_ID;

public class ModClient implements ClientStartEntrypoint {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void beforeClientStart() {
		for (final AtlasStitcher stitcher : TextureRegistry.stitcherMap.values()) {
			try {
				TextureHelper.initializeAllFiles(MOD_ID, stitcher, Integer.MAX_VALUE);
			} catch (Exception e) {
				LOGGER.error("Failed to initialize texture files!", e);
			}
		}
	}

	@Override
	public void afterClientStart() {

	}
}
