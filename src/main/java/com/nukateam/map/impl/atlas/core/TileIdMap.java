package com.nukateam.map.impl.atlas.core;

import com.nukateam.map.impl.atlas.MapCore;
import net.minecraft.resources.ResourceLocation;


/**
 * Just a collection of Identifiers used when tiles are referenced from code
 *
 * @author Hunternif
 */
public class TileIdMap {
    public static final ResourceLocation
            // Village:
            TILE_VILLAGE_LIBRARY = MapCore.id("npc_village_library"),
            TILE_VILLAGE_SMITHY = MapCore.id("npc_village_smithy"),
            TILE_VILLAGE_L_HOUSE = MapCore.id("npc_village_l_house"),
            TILE_VILLAGE_FARMLAND_SMALL = MapCore.id("npc_village_farmland_small"),
            TILE_VILLAGE_FARMLAND_LARGE = MapCore.id("npc_village_farmland_large"),
            TILE_VILLAGE_WELL = MapCore.id("npc_village_well"),
            TILE_VILLAGE_TORCH = MapCore.id("npc_village_torch"),
            TILE_VILLAGE_PATH_X = MapCore.id("npc_village_path_x"),
            TILE_VILLAGE_PATH_Z = MapCore.id("npc_village_path_z"),
            TILE_VILLAGE_HUT = MapCore.id("npc_village_hut"),
            TILE_VILLAGE_SMALL_HOUSE = MapCore.id("npc_village_small_house"),
            TILE_VILLAGE_BUTCHERS_SHOP = MapCore.id("npc_village_butchers_shop"),
            TILE_VILLAGE_CHURCH = MapCore.id("npc_village_church"),

            TILE_RAVINE = MapCore.id("ravine"),
            SWAMP_WATER = MapCore.id("swamp_water"),

            // Overworld stuff:
            RUINED_PORTAL = MapCore.id("ruined_portal"),

            // Nether & Nether Fortress:
            TILE_LAVA = MapCore.id("lava"),
            TILE_LAVA_SHORE = MapCore.id("lava_shore"),
            NETHER_FORTRESS_BRIDGE_CROSSING = MapCore.id("nether_bridge"),
            NETHER_BRIDGE_X = MapCore.id("nether_bridge_x"),
            NETHER_BRIDGE_Z = MapCore.id("nether_bridge_z"),
            NETHER_BRIDGE_END_X = MapCore.id("nether_bridge_end_x"),
            NETHER_BRIDGE_END_Z = MapCore.id("nether_bridge_end_z"),
            NETHER_FORTRESS_BRIDGE_SMALL_CROSSING = MapCore.id("nether_bridge_gate"),
            NETHER_FORTRESS_BRIDGE_STAIRS = MapCore.id("nether_tower"),
            NETHER_FORTRESS_WALL = MapCore.id("nether_wall"),
            NETHER_FORTRESS_EXIT = MapCore.id("nether_hall"),
            NETHER_FORTRESS_CORRIDOR_NETHER_WARTS_ROOM = MapCore.id("nether_fort_stairs"),
            NETHER_FORTRESS_BRIDGE_PLATFORM = MapCore.id("nether_throne");
}
