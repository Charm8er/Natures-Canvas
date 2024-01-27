package com.calibermc.naturescanvas.worldgen.feature;

import com.calibermc.naturescanvas.block.NCBlocks;
import com.calibermc.naturescanvas.util.worldgen.NCFeatureUtils;
import com.calibermc.naturescanvas.worldgen.feature.tree.configs.EvergreenTreeConfiguration;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class NCTreeFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE = NCFeatureUtils.registerKey("redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE_LARGE = NCFeatureUtils.registerKey("redwood_tree_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE_MEDIUM = NCFeatureUtils.registerKey("redwood_tree_medium");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> pContext) {
        register(pContext, NCTreeFeatures.REDWOOD_TREE, NCFeatures.REDWOOD_TREE, createRedwood(NCBlocks.REDWOOD_LOG.get()).minHeight(10).maxHeight(30).build());
        register(pContext, NCTreeFeatures.REDWOOD_TREE_LARGE, NCFeatures.REDWOOD_TREE, createRedwood(NCBlocks.REDWOOD_WOOD.get()).minHeight(45).maxHeight(60).trunkWidth(3).build());
        register(pContext, NCTreeFeatures.REDWOOD_TREE_MEDIUM, NCFeatures.REDWOOD_TREE, createRedwood(NCBlocks.REDWOOD_WOOD.get()).minHeight(25).maxHeight(40).trunkWidth(2).build());


    }



    private static EvergreenTreeConfiguration.Builder createFir() {
        return new EvergreenTreeConfiguration.Builder().trunk(BlockStateProvider.simple(NCBlocks.FIR_LOG.get())).foliage(BlockStateProvider.simple(NCBlocks.FIR_LEAVES.get()));
    }

    private static EvergreenTreeConfiguration.Builder createPine() {
        return new EvergreenTreeConfiguration.Builder().trunk(BlockStateProvider.simple(NCBlocks.PINE_LOG.get())).foliage(BlockStateProvider.simple(NCBlocks.FIR_LEAVES.get()));
    }

    private static EvergreenTreeConfiguration.Builder createRedwood(Block log){
        return new EvergreenTreeConfiguration.Builder().trunk(BlockStateProvider.simple(log)).foliage(BlockStateProvider.simple(NCBlocks.REDWOOD_LEAVES.get()));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, F feature, FC configuration){
        context.register(configuredFeatureKey, new ConfiguredFeature<>(feature, configuration));
    }
}

