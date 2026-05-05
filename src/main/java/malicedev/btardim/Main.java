package malicedev.btardim;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.texture.stitcher.AtlasStitcher;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.TextureHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;

public class Main implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint {
	public static final String MOD_ID = "btardim";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static int itemId;
	public static int blockId;
	public static int dimId;
	static {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","8900");
		prop.setProperty("starting_item_id","28000");
		prop.setProperty("btardim_interior_dimension_id","40");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);

		blockId = config.getInt("starting_block_id");
		itemId = config.getInt("starting_item_id");
		dimId = config.getInt("btardim_interior_dimension_id");

		config.updateConfig();
	}
	@Override
	public void onInitialize() {
		LOGGER.info("BTARDIM initialized.");
		ModBlocks.init();
		ModItems.init();
		ModDimensions.init();

	}
	@Override
	public void onRecipesReady() {}

	@Override
	public void initNamespaces() {}

	@Override
	public void beforeGameStart() {}

	@Override
	public void afterGameStart() {}
}
