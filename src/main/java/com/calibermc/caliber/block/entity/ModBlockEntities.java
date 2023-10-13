package com.calibermc.caliber.block.entity;

import com.calibermc.caliber.Caliber;
import com.calibermc.caliber.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Caliber.MOD_ID);
    public static final RegistryObject<BlockEntityType<SmelterBlockEntity>> SMELTER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("smelter_block_entity", () ->
                    BlockEntityType.Builder.of(SmelterBlockEntity::new,
                            ModBlocks.SMELTER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
