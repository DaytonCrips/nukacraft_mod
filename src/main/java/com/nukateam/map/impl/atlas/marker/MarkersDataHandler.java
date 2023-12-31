package com.nukateam.map.impl.atlas.marker;

import com.nukateam.map.impl.atlas.item.AtlasItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.DimensionDataStorage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Provides access to {@link MarkersData}. Maintains a cache on the client side,
 * because WorldClient is reset along with all WorldSavedData when the player
 * changes dimension (fixes #67).
 * @author Hunternif
 */
public class MarkersDataHandler {
	private static final String MARKERS_DATA_PREFIX = "aaMarkers_";

	private final Map<String, MarkersData> markersDataClientCache = new ConcurrentHashMap<>();

	/** Loads data for the given atlas or creates a new one. */
	public MarkersData getMarkersData(ItemStack stack, Level world) {
		if (stack.getItem() instanceof AtlasItem) {
			return getMarkersData(AtlasItem.getAtlasID(stack), world);
		} else {
			return null;
		}
	}

	/** Loads data for the given atlas ID or creates a new one. */
	public MarkersData getMarkersData(int atlasID, Level world) {
		String key = getMarkersDataKey(atlasID);
		if (world.isClientSide) {
			// Since atlas data doesn't really belong to a single world-dimension,
			// it can be cached. This should fix #67
			return markersDataClientCache.computeIfAbsent(key, s -> new MarkersData());
		} else {
			DimensionDataStorage manager = ((ServerLevel) world).getDataStorage();
			return manager.computeIfAbsent(MarkersData::readNbt, () -> new MarkersData(), key);
		}
	}

	private String getMarkersDataKey(int atlasID) {
		return MARKERS_DATA_PREFIX + atlasID;
	}

	/**
	 * This method resets the cache when the client loads a new world.
	 * It is required in order that old markers data is not
	 * transferred from a previous world the client visited.
	 * <p>
	 * Using a "connect" event instead of "disconnect" because according to a
	 * form post, the latter event isn't actually fired on the client.
	 * </p>
	 */
	public void onClientConnectedToServer(boolean isRemote) {
		markersDataClientCache.clear();
	}
}
