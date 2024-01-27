package com.calibermc.naturescanvas.util.compat;

import net.minecraftforge.fml.ModList;

public class ModCompats {

    public static final boolean BOP;
    public static final boolean CALIBER;
    public static final boolean DOUBLE_DOORS;
    public static final boolean MANYIDEAS_DOORS;

    static {
        BOP = ModList.get().isLoaded("biomesoplenty");
        CALIBER = ModList.get().isLoaded("caliber");
        DOUBLE_DOORS = ModList.get().isLoaded("doubledoors");
        MANYIDEAS_DOORS = ModList.get().isLoaded("manyideas_doors");
    }
}

