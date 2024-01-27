package com.calibermc.naturescanvas.event;

import com.calibermc.naturescanvas.NaturesCanvas;
import com.calibermc.naturescanvas.worldgen.feature.tree.RedwoodTreeFeature;
import com.calibermc.naturescanvas.worldgen.feature.tree.configs.EvergreenTreeConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = NaturesCanvas.MOD_ID)
public class NCEventBus {

//    @SubscribeEvent
//    public static void registerCommands(RegisterCommandsEvent event) {
//        NaturesCanvasCommands.register(event.getDispatcher());
//    }

//    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, NaturesCanvas.MOD_ID);
//
//    public static final RegistryObject<Feature<?>> MY_FEATURE = FEATURES.register("my_feature",
//            () -> new MyFeatureConfigured(FeatureConfig.CODEC));
//
//
//    @SubscribeEvent
//    public static void onRegisterFeaturesEvent(final RegistryEvent.Register<Feature<?>> event) {
//        // Manually register each feature
//        event.getRegistry().registerAll(
//                new RedwoodTreeFeature(EvergreenTreeConfiguration.CODEC).setRegistryName("redwood_tree"),
//                // any other features would follow here...
//        );
//    }
}
