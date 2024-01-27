package com.calibermc.naturescanvas.worldgen.placement;

import com.calibermc.naturescanvas.block.NCBlocks;
import com.calibermc.naturescanvas.util.worldgen.NCPlacementUtils;
import com.calibermc.naturescanvas.worldgen.feature.NCTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class NCTreePlacement {

    public static final ResourceKey<PlacedFeature> REDWOOD_TREE = NCPlacementUtils.registerKey("redwood_tree");
    public static final ResourceKey<PlacedFeature> REDWOOD_TREE_LARGE = NCPlacementUtils.registerKey("redwood_tree_large");
    public static final ResourceKey<PlacedFeature> REDWOOD_TREE_MEDIUM = NCPlacementUtils.registerKey("redwood_tree_medium");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        final Holder<ConfiguredFeature<?, ?>> REDWOOD_TREE = configuredFeatureGetter.getOrThrow(NCTreeFeatures.REDWOOD_TREE);
        final Holder<ConfiguredFeature<?, ?>> REDWOOD_TREE_LARGE = configuredFeatureGetter.getOrThrow(NCTreeFeatures.REDWOOD_TREE_LARGE);
        final Holder<ConfiguredFeature<?, ?>> REDWOOD_TREE_MEDIUM = configuredFeatureGetter.getOrThrow(NCTreeFeatures.REDWOOD_TREE_MEDIUM);

        register(context, NCTreePlacement.REDWOOD_TREE, REDWOOD_TREE, List.of(PlacementUtils.filteredByBlockSurvival(NCBlocks.REDWOOD_SAPLING.get())));
        register(context, NCTreePlacement.REDWOOD_TREE_LARGE, REDWOOD_TREE_LARGE, List.of(PlacementUtils.filteredByBlockSurvival(NCBlocks.REDWOOD_SAPLING.get())));
        register(context, NCTreePlacement.REDWOOD_TREE_MEDIUM, REDWOOD_TREE_MEDIUM, List.of(PlacementUtils.filteredByBlockSurvival(NCBlocks.REDWOOD_SAPLING.get())));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, placedFeatureKey, configuration, List.of(modifiers));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedFeatureKey, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(placedFeatureKey, new PlacedFeature(configuration, modifiers));
    }
}

