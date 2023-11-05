package com.calibermc.caliber.block.custom;

import com.calibermc.caliber.block.properties.CornerShape;
import com.calibermc.caliber.util.ModBlockStateProperties;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;

import static net.minecraft.core.Direction.*;
import static net.minecraft.core.Direction.WEST;


public class CornerBlock extends Block implements SimpleWaterloggedBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<CornerShape> TYPE = ModBlockStateProperties.CORNER_SHAPE;

    public static final Map<Direction, VoxelShape> LEFT_SHAPE = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Shapes.join(Block.box(0, 0, 8, 16, 16, 16), Block.box(8, 0, 0, 16, 16, 8), BooleanOp.OR),
            Direction.SOUTH, Shapes.join(Block.box(0, 0, 0, 16, 16, 8), Block.box(0, 0, 8, 8, 16, 16), BooleanOp.OR),
            Direction.EAST, Shapes.join(Block.box(0, 0, 0, 8, 16, 16), Block.box(8, 0, 8, 16, 16, 16), BooleanOp.OR),
            Direction.WEST, Shapes.join(Block.box(8, 0, 0, 16, 16, 16), Block.box(0, 0, 0, 8, 16, 8), BooleanOp.OR)));

    public static final Map<Direction, VoxelShape> RIGHT_SHAPE = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Shapes.join(Block.box(0, 0, 8, 16, 16, 16), Block.box(0, 0, 0, 8, 16, 8), BooleanOp.OR),
            Direction.SOUTH, Shapes.join(Block.box(0, 0, 0, 16, 16, 8), Block.box(8, 0, 8, 16, 16, 16), BooleanOp.OR),
            Direction.EAST, Shapes.join(Block.box(0, 0, 0, 8, 16, 16), Block.box(8, 0, 0, 16, 16, 8), BooleanOp.OR),
            Direction.WEST, Shapes.join(Block.box(8, 0, 0, 16, 16, 16), Block.box(0, 0, 8, 8, 16, 16), BooleanOp.OR)));

    public CornerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(TYPE, CornerShape.RIGHT)
                .setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, TYPE, WATERLOGGED);
    }
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        CornerShape cornerShape = pState.getValue(TYPE);
        switch (cornerShape) {
            case LEFT -> {
                return LEFT_SHAPE.get(pState.getValue(FACING));
            }
            default -> {
                return RIGHT_SHAPE.get(pState.getValue(FACING));
            }
        }
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        double hitX = pContext.getClickLocation().x - (double) blockpos.getX();
        double hitZ = pContext.getClickLocation().z - (double) blockpos.getZ();
        Direction direction = pContext.getHorizontalDirection().getOpposite();
        FluidState fluidstate = pContext.getLevel().getFluidState(blockpos);
        BlockState blockstate1 = this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                .setValue(TYPE, CornerShape.RIGHT).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));

        if (direction == NORTH && hitX < 0.5 || direction == EAST && hitZ < 0.5) {
            return blockstate1.setValue(TYPE, CornerShape.RIGHT);
        } else if (direction == NORTH && hitX > 0.5 || direction == EAST && hitZ > 0.5) {
            return blockstate1.setValue(TYPE, CornerShape.LEFT);
        } else if (direction == SOUTH && hitX > 0.5 || direction == WEST && hitZ > 0.5) {
            return blockstate1.setValue(TYPE, CornerShape.RIGHT);
        } else if (direction == SOUTH && hitX < 0.5 || direction == WEST && hitZ < 0.5) {
            return blockstate1.setValue(TYPE, CornerShape.LEFT);
        } else {
            return blockstate1.setValue(TYPE, CornerShape.RIGHT);
        }

    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        switch(pType) {
            case LAND:
                return false;
            case WATER:
                return pLevel.getFluidState(pPos).is(FluidTags.WATER);
            case AIR:
                return false;
            default:
                return false;
        }
    }
}