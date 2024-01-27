package com.calibermc.naturescanvas.worldgen.feature;

import com.calibermc.naturescanvas.NaturesCanvas;
import com.calibermc.naturescanvas.worldgen.feature.tree.NCTreeFeature;
import com.calibermc.naturescanvas.worldgen.feature.tree.RedwoodTreeFeature;
import com.calibermc.naturescanvas.worldgen.feature.tree.configs.EvergreenTreeConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.BiConsumer;

public class NCFeatures {
    public static final DeferredRegister<Feature<?>> FEATURE_REGISTER = DeferredRegister.create(Registries.FEATURE, NaturesCanvas.MOD_ID);

    public static final NCTreeFeature<EvergreenTreeConfiguration> REDWOOD_TREE = registerFeature("redwood_tree", new RedwoodTreeFeature(EvergreenTreeConfiguration.CODEC));


    private static <C extends FeatureConfiguration, F extends Feature<C>> F registerFeature(String key, F value) {
        FEATURE_REGISTER.register(key, () -> value);
        return value;
    }

    public static void register(IEventBus eventBus) {
        FEATURE_REGISTER.register(eventBus);
    }
}

