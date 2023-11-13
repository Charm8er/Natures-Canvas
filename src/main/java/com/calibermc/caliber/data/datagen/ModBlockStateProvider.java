package com.calibermc.caliber.data.datagen;

import com.calibermc.caliber.Caliber;
import com.calibermc.caliber.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Caliber.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.TIN_BLOCK.get());
        simpleBlock(ModBlocks.RAW_TIN_BLOCK.get());
        simpleBlock(ModBlocks.TIN_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TIN_ORE.get());

        simpleBlock(ModBlocks.SILVER_BLOCK.get());
        simpleBlock(ModBlocks.RAW_SILVER_BLOCK.get());
        simpleBlock(ModBlocks.SILVER_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_SILVER_ORE.get());

        simpleBlock(ModBlocks.BLACK_GRANITE.get());
        simpleBlock(ModBlocks.BROWN_GRANITE.get());
        simpleBlock(ModBlocks.PINK_GRANITE.get());
        simpleBlock(ModBlocks.GRAY_GRANITE.get());
        simpleBlock(ModBlocks.WHITE_GRANITE.get());
        stairsBlock((StairBlock) ModBlocks.BLACK_GRANITE_STAIRS.get(), blockTexture(ModBlocks.BLACK_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.BROWN_GRANITE_STAIRS.get(), blockTexture(ModBlocks.BROWN_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.GRAY_GRANITE_STAIRS.get(), blockTexture(ModBlocks.GRAY_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.PINK_GRANITE_STAIRS.get(), blockTexture(ModBlocks.PINK_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.WHITE_GRANITE_STAIRS.get(), blockTexture(ModBlocks.WHITE_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.BLACK_GRANITE_WALL.get(), blockTexture(ModBlocks.BLACK_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.BROWN_GRANITE_WALL.get(), blockTexture(ModBlocks.BROWN_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.GRAY_GRANITE_WALL.get(), blockTexture(ModBlocks.GRAY_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.PINK_GRANITE_WALL.get(), blockTexture(ModBlocks.PINK_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.WHITE_GRANITE_WALL.get(), blockTexture(ModBlocks.WHITE_GRANITE.get()));

        simpleBlock(ModBlocks.POLISHED_BLACK_GRANITE.get());
        simpleBlock(ModBlocks.POLISHED_BROWN_GRANITE.get());
        simpleBlock(ModBlocks.POLISHED_GRAY_GRANITE.get());
        simpleBlock(ModBlocks.POLISHED_PINK_GRANITE.get());
        simpleBlock(ModBlocks.POLISHED_WHITE_GRANITE.get());
        stairsBlock((StairBlock) ModBlocks.POLISHED_BLACK_GRANITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_BLACK_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_BROWN_GRANITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_BROWN_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_GRAY_GRANITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_GRAY_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_PINK_GRANITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_PINK_GRANITE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_WHITE_GRANITE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_WHITE_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_BLACK_GRANITE_WALL.get(), blockTexture(ModBlocks.POLISHED_BLACK_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_BROWN_GRANITE_WALL.get(), blockTexture(ModBlocks.POLISHED_BROWN_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_GRAY_GRANITE_WALL.get(), blockTexture(ModBlocks.POLISHED_GRAY_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_PINK_GRANITE_WALL.get(), blockTexture(ModBlocks.POLISHED_PINK_GRANITE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_RED_GRANITE_WALL.get(), blockTexture(Blocks.GRANITE));
        wallBlock((WallBlock) ModBlocks.POLISHED_WHITE_GRANITE_WALL.get(), blockTexture(ModBlocks.POLISHED_WHITE_GRANITE.get()));

        simpleBlock(ModBlocks.DARK_LIMESTONE.get());
        simpleBlock(ModBlocks.LIGHT_LIMESTONE.get());
        simpleBlock(ModBlocks.PINK_LIMESTONE.get());
        simpleBlock(ModBlocks.TAN_LIMESTONE.get());
        stairsBlock((StairBlock) ModBlocks.DARK_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.DARK_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.LIGHT_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.LIGHT_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.PINK_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.PINK_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.TAN_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.TAN_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.DARK_LIMESTONE_WALL.get(), blockTexture(ModBlocks.DARK_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.LIGHT_LIMESTONE_WALL.get(), blockTexture(ModBlocks.LIGHT_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.LIMESTONE_WALL.get(), blockTexture(Blocks.STONE));
        wallBlock((WallBlock) ModBlocks.PINK_LIMESTONE_WALL.get(), blockTexture(ModBlocks.PINK_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.TAN_LIMESTONE_WALL.get(), blockTexture(ModBlocks.TAN_LIMESTONE.get()));
        buttonBlock((ButtonBlock)ModBlocks.DARK_LIMESTONE_BUTTON.get(), blockTexture(ModBlocks.DARK_LIMESTONE.get()));
        buttonBlock((ButtonBlock)ModBlocks.LIGHT_LIMESTONE_BUTTON.get(), blockTexture(ModBlocks.LIGHT_LIMESTONE.get()));
        buttonBlock((ButtonBlock)ModBlocks.PINK_LIMESTONE_BUTTON.get(), blockTexture(ModBlocks.PINK_LIMESTONE.get()));
        buttonBlock((ButtonBlock)ModBlocks.TAN_LIMESTONE_BUTTON.get(), blockTexture(ModBlocks.TAN_LIMESTONE.get()));
        pressurePlateBlock((PressurePlateBlock)ModBlocks.DARK_LIMESTONE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.DARK_LIMESTONE.get()));
        pressurePlateBlock((PressurePlateBlock)ModBlocks.LIGHT_LIMESTONE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.LIGHT_LIMESTONE.get()));
        pressurePlateBlock((PressurePlateBlock)ModBlocks.PINK_LIMESTONE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PINK_LIMESTONE.get()));
        pressurePlateBlock((PressurePlateBlock)ModBlocks.TAN_LIMESTONE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.TAN_LIMESTONE.get()));

        simpleBlock(ModBlocks.COBBLED_DARK_LIMESTONE.get());
        simpleBlock(ModBlocks.COBBLED_LIGHT_LIMESTONE.get());
        simpleBlock(ModBlocks.COBBLED_PINK_LIMESTONE.get());
        simpleBlock(ModBlocks.COBBLED_TAN_LIMESTONE.get());
        stairsBlock((StairBlock) ModBlocks.COBBLED_DARK_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_DARK_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.COBBLED_LIGHT_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_LIGHT_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.COBBLED_PINK_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_PINK_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.COBBLED_TAN_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.COBBLED_TAN_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.COBBLED_DARK_LIMESTONE_WALL.get(), blockTexture(ModBlocks.COBBLED_DARK_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.COBBLED_LIGHT_LIMESTONE_WALL.get(), blockTexture(ModBlocks.COBBLED_LIGHT_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.COBBLED_PINK_LIMESTONE_WALL.get(), blockTexture(ModBlocks.COBBLED_PINK_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.COBBLED_TAN_LIMESTONE_WALL.get(), blockTexture(ModBlocks.COBBLED_TAN_LIMESTONE.get()));

        simpleBlock(ModBlocks.MOSSY_COBBLED_DARK_LIMESTONE.get());
        simpleBlock(ModBlocks.MOSSY_COBBLED_LIGHT_LIMESTONE.get());
        simpleBlock(ModBlocks.MOSSY_COBBLED_PINK_LIMESTONE.get());
        simpleBlock(ModBlocks.MOSSY_COBBLED_TAN_LIMESTONE.get());
        stairsBlock((StairBlock) ModBlocks.MOSSY_COBBLED_DARK_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.MOSSY_COBBLED_DARK_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.MOSSY_COBBLED_LIGHT_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.MOSSY_COBBLED_LIGHT_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.MOSSY_COBBLED_PINK_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.MOSSY_COBBLED_PINK_LIMESTONE.get()));
        stairsBlock((StairBlock) ModBlocks.MOSSY_COBBLED_TAN_LIMESTONE_STAIRS.get(), blockTexture(ModBlocks.MOSSY_COBBLED_TAN_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_COBBLED_DARK_LIMESTONE_WALL.get(), blockTexture(ModBlocks.MOSSY_COBBLED_DARK_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_COBBLED_LIGHT_LIMESTONE_WALL.get(), blockTexture(ModBlocks.MOSSY_COBBLED_LIGHT_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_COBBLED_PINK_LIMESTONE_WALL.get(), blockTexture(ModBlocks.MOSSY_COBBLED_PINK_LIMESTONE.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_COBBLED_TAN_LIMESTONE_WALL.get(), blockTexture(ModBlocks.MOSSY_COBBLED_TAN_LIMESTONE.get()));

        simpleBlock(ModBlocks.DARK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.LIGHT_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.PINK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.TAN_LIMESTONE_BRICKS.get());
        stairsBlock((StairBlock) ModBlocks.DARK_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.DARK_LIMESTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.LIGHT_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.LIGHT_LIMESTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.PINK_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.PINK_LIMESTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.TAN_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.TAN_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.DARK_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.DARK_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.LIGHT_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.LIGHT_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.PINK_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.PINK_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.TAN_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.TAN_LIMESTONE_BRICKS.get()));

        simpleBlock(ModBlocks.MOSSY_DARK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.MOSSY_LIGHT_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.MOSSY_PINK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.MOSSY_TAN_LIMESTONE_BRICKS.get());
        stairsBlock((StairBlock) ModBlocks.MOSSY_DARK_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.MOSSY_DARK_LIMESTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.MOSSY_LIGHT_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.MOSSY_LIGHT_LIMESTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.MOSSY_PINK_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.MOSSY_PINK_LIMESTONE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.MOSSY_TAN_LIMESTONE_BRICK_STAIRS.get(), blockTexture(ModBlocks.MOSSY_TAN_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_DARK_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.MOSSY_DARK_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_LIGHT_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.MOSSY_LIGHT_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_PINK_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.MOSSY_PINK_LIMESTONE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.MOSSY_TAN_LIMESTONE_BRICK_WALL.get(), blockTexture(ModBlocks.MOSSY_TAN_LIMESTONE_BRICKS.get()));


        simpleBlock(ModBlocks.CRACKED_DARK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.CRACKED_LIGHT_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.CRACKED_PINK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.CRACKED_TAN_LIMESTONE_BRICKS.get());

        simpleBlock(ModBlocks.CHISELED_DARK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.CHISELED_LIGHT_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.CHISELED_PINK_LIMESTONE_BRICKS.get());
        simpleBlock(ModBlocks.CHISELED_TAN_LIMESTONE_BRICKS.get());

        simpleBlock(ModBlocks.SMOOTH_DARK_LIMESTONE.get());
        simpleBlock(ModBlocks.SMOOTH_LIGHT_LIMESTONE.get());
        simpleBlock(ModBlocks.SMOOTH_PINK_LIMESTONE.get());
        simpleBlock(ModBlocks.SMOOTH_TAN_LIMESTONE.get());

        simpleBlock(ModBlocks.BLACK_MARBLE.get());
        simpleBlock(ModBlocks.GRAY_MARBLE.get());
        simpleBlock(ModBlocks.PINK_MARBLE.get());
        simpleBlock(ModBlocks.RED_MARBLE.get());
        simpleBlock(ModBlocks.WHITE_MARBLE.get());
        stairsBlock((StairBlock) ModBlocks.BLACK_MARBLE_STAIRS.get(), blockTexture(ModBlocks.BLACK_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.GRAY_MARBLE_STAIRS.get(), blockTexture(ModBlocks.GRAY_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.PINK_MARBLE_STAIRS.get(), blockTexture(ModBlocks.PINK_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.RED_MARBLE_STAIRS.get(), blockTexture(ModBlocks.RED_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.WHITE_MARBLE_STAIRS.get(), blockTexture(ModBlocks.WHITE_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.BLACK_MARBLE_WALL.get(), blockTexture(ModBlocks.BLACK_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.GRAY_MARBLE_WALL.get(), blockTexture(ModBlocks.GRAY_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.PINK_MARBLE_WALL.get(), blockTexture(ModBlocks.PINK_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.RED_MARBLE_WALL.get(), blockTexture(ModBlocks.RED_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.WHITE_MARBLE_WALL.get(), blockTexture(ModBlocks.WHITE_MARBLE.get()));

        simpleBlock(ModBlocks.POLISHED_BLACK_MARBLE.get());
        simpleBlock(ModBlocks.POLISHED_GRAY_MARBLE.get());
        simpleBlock(ModBlocks.POLISHED_PINK_MARBLE.get());
        simpleBlock(ModBlocks.POLISHED_RED_MARBLE.get());
        simpleBlock(ModBlocks.POLISHED_WHITE_MARBLE.get());
        stairsBlock((StairBlock) ModBlocks.POLISHED_BLACK_MARBLE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_BLACK_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_GRAY_MARBLE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_GRAY_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_PINK_MARBLE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_PINK_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_RED_MARBLE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_RED_MARBLE.get()));
        stairsBlock((StairBlock) ModBlocks.POLISHED_WHITE_MARBLE_STAIRS.get(), blockTexture(ModBlocks.POLISHED_WHITE_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_BLACK_MARBLE_WALL.get(), blockTexture(ModBlocks.POLISHED_BLACK_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_GRAY_MARBLE_WALL.get(), blockTexture(ModBlocks.POLISHED_GRAY_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_PINK_MARBLE_WALL.get(), blockTexture(ModBlocks.POLISHED_PINK_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_RED_MARBLE_WALL.get(), blockTexture(ModBlocks.POLISHED_RED_MARBLE.get()));
        wallBlock((WallBlock) ModBlocks.POLISHED_WHITE_MARBLE_WALL.get(), blockTexture(ModBlocks.POLISHED_WHITE_MARBLE.get()));

        simpleBlock(ModBlocks.SMOOTH_BROWN_SANDSTONE.get());
        simpleBlock(ModBlocks.SMOOTH_ORANGE_SANDSTONE.get());
        wallBlock((WallBlock) ModBlocks.BROWN_SANDSTONE_WALL.get(), blockTexture(ModBlocks.BROWN_SANDSTONE.get()));
        wallBlock((WallBlock) ModBlocks.ORANGE_SANDSTONE_WALL.get(), blockTexture(ModBlocks.ORANGE_SANDSTONE.get()));

        simpleBlock(ModBlocks.BLACK_SAND.get());
        simpleBlock(ModBlocks.BROWN_SAND.get());
        simpleBlock(ModBlocks.ORANGE_SAND.get());
        simpleBlock(ModBlocks.WHITE_SAND.get());

        wallBlock((WallBlock) ModBlocks.ACACIA_WALL.get(), blockTexture(Blocks.ACACIA_PLANKS));
        wallBlock((WallBlock) ModBlocks.BIRCH_WALL.get(), blockTexture(Blocks.BIRCH_PLANKS));
        wallBlock((WallBlock) ModBlocks.DARK_OAK_WALL.get(), blockTexture(Blocks.DARK_OAK_PLANKS));
        wallBlock((WallBlock) ModBlocks.JUNGLE_WALL.get(), blockTexture(Blocks.JUNGLE_PLANKS));
        wallBlock((WallBlock) ModBlocks.OAK_WALL.get(), blockTexture(Blocks.OAK_PLANKS));
        wallBlock((WallBlock) ModBlocks.SPRUCE_WALL.get(), blockTexture(Blocks.SPRUCE_PLANKS));




    }
}
