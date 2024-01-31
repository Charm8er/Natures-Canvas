package com.calibermc.naturescanvas.worldgen.feature.tree;

import com.calibermc.naturescanvas.util.biome.GeneratorUtil;
import com.calibermc.naturescanvas.worldgen.feature.tree.configs.EvergreenTreeConfiguration;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiConsumer;

public class RedwoodTreeFeature extends NCTreeFeature<EvergreenTreeConfiguration> {
    public RedwoodTreeFeature(Codec<EvergreenTreeConfiguration> codec) {
        super(codec);
    }

    public boolean checkSpace(LevelAccessor world, BlockPos pos, int baseHeight, int height, EvergreenTreeConfiguration config) {
        for (int y = 0; y <= height; y++) {

            int trunkWidth = (config.trunkWidth * (height - y) / height) + 1;
            int trunkStart = Mth.ceil(0.25D - trunkWidth / 2.0D);
            int trunkEnd = Mth.floor(0.25D + trunkWidth / 2.0D);

            // require 3x3 for the leaves, 1x1 for the trunk
            int start = (y <= baseHeight ? trunkStart : trunkStart - 1);
            int end = (y <= baseHeight ? trunkEnd : trunkEnd + 1);

            for (int x = start; x <= end; x++)
            {
                for (int z = start; z <= end; z++)
                {
                    BlockPos pos1 = pos.offset(x, y, z);
                    // note, there may be a sapling on the first layer - make sure this.replace matches it!
                    if (pos1.getY() >= 255 || !this.canReplace(world, pos1))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // generates a layer of leafs
    public void generateLeafLayer(LevelAccessor world, RandomSource rand, BlockPos pos, int leavesRadius, int trunkStart, int trunkEnd, FoliagePlacer.FoliageSetter leaves, EvergreenTreeConfiguration config) {
        int start = trunkStart - leavesRadius;
        int end = trunkEnd + leavesRadius;

        for (int x = start; x <= end; x++)
        {
            for (int z = start; z <= end; z++)
            {
                // skip corners
                if ((leavesRadius > 0 ) && (x == start || x == end) && (z == start || z == end)) {continue;}
                int distFromTrunk = (x < 0 ? trunkStart - x : x - trunkEnd) + (z < 0 ? trunkStart - z : z - trunkEnd);

                // set leaves as long as it's not too far from the trunk to survive
                if (distFromTrunk < 4 || (distFromTrunk == 4 && rand.nextInt(2) == 0))
                {
                    this.placeLeaves(world, pos.offset(x, 0, z), leaves, config);
                }
            }
        }
    }

    public void generateBranch(LevelAccessor world, RandomSource rand, BlockPos pos, Direction direction, int length, BiConsumer<BlockPos, BlockState> logs, FoliagePlacer.FoliageSetter leaves, EvergreenTreeConfiguration config) {
        Direction.Axis axis = direction.getAxis();
        Direction sideways = direction.getClockWise();
        for (int i = 1; i <= length; i++)
        {
            BlockPos pos1 = pos.relative(direction, i);
            int r = (i == 1 || i == length) ? 1 : 2;
            for (int j = -r; j <= r; j++)
            {
                if (i < length || rand.nextInt(2) == 0)
                {
                    this.placeLeaves(world, pos1.relative(sideways, j), leaves, config);
                }
            }
            if (length - i > 2)
            {
                this.placeLeaves(world, pos1.above(), leaves, config);
                this.placeLeaves(world, pos1.above().relative(sideways, -1), leaves, config);
                this.placeLeaves(world, pos1.above().relative(sideways, 1), leaves, config);
                this.placeLog(world, pos1, axis, logs, config);
            }
        }
    }

//    @Override
//    public boolean place(TreeConfiguration pConfig, WorldGenLevel pLevel, ChunkGenerator pChunkGenerator, RandomSource pRandom, BlockPos pOrigin) {
//        if (!pLevel.ensureCanWrite(pOrigin)) return false;
//        final WorldGenLevel worldgenlevel = pLevel;
//        Set<BlockPos> set = Sets.newHashSet();
//        Set<BlockPos> set1 = Sets.newHashSet();
//        final Set<BlockPos> set2 = Sets.newHashSet();
//        Set<BlockPos> set3 = Sets.newHashSet();
//        BiConsumer<BlockPos, BlockState> biconsumer = (p_160555_, p_160556_) -> {
//            set.add(p_160555_.immutable());
//            worldgenlevel.setBlock(p_160555_, p_160556_, 19);
//        };
//        BiConsumer<BlockPos, BlockState> biconsumer1 = (p_160548_, p_160549_) -> {
//            set1.add(p_160548_.immutable());
//            worldgenlevel.setBlock(p_160548_, p_160549_, 19);
//        };
//        FoliagePlacer.FoliageSetter foliageplacer$foliagesetter = new FoliagePlacer.FoliageSetter() {
//            public void set(BlockPos p_272825_, BlockState p_273311_) {
//                set2.add(p_272825_.immutable());
//                worldgenlevel.setBlock(p_272825_, p_273311_, 19);
//            }
//
//            public boolean isSet(BlockPos p_272999_) {
//                return set2.contains(p_272999_);
//            }
//        };
//        BiConsumer<BlockPos, BlockState> biconsumer2 = (p_160543_, p_160544_) -> {
//            set3.add(p_160543_.immutable());
//            worldgenlevel.setBlock(p_160543_, p_160544_, 19);
//        };
//        boolean flag = this.doPlace(worldgenlevel, pRandom, pOrigin, biconsumer, biconsumer1, foliageplacer$foliagesetter, pConfig);
//        if (flag && (!set1.isEmpty() || !set2.isEmpty())) {
//            if (!pConfig.decorators.isEmpty()) {
//                TreeDecorator.Context treedecorator$context = new TreeDecorator.Context(worldgenlevel, biconsumer2, pRandom, set1, set2, set);
//                pConfig.decorators.forEach((p_225282_) -> {
//                    p_225282_.place(treedecorator$context);
//                });
//            }
//
//            return BoundingBox.encapsulatingPositions(Iterables.concat(set, set1, set2, set3)).map((p_225270_) -> {
//                DiscreteVoxelShape discretevoxelshape = updateLeaves(worldgenlevel, p_225270_, set1, set3, set);
//                StructureTemplate.updateShapeAtEdge(worldgenlevel, 3, discretevoxelshape, p_225270_.minX(), p_225270_.minY(), p_225270_.minZ());
//                return true;
//            }).orElse(false);
//        } else {
//            return false;
//        }
//    }

    private static DiscreteVoxelShape updateLeaves(LevelAccessor pLevel, BoundingBox pBox, Set<BlockPos> pRootPositions, Set<BlockPos> pTrunkPositions, Set<BlockPos> pFoliagePositions) {
        DiscreteVoxelShape discretevoxelshape = new BitSetDiscreteVoxelShape(pBox.getXSpan(), pBox.getYSpan(), pBox.getZSpan());
        int i = 7;
        List<Set<BlockPos>> list = Lists.newArrayList();

        for(int j = 0; j < 7; ++j) {
            list.add(Sets.newHashSet());
        }

        for(BlockPos blockpos : Lists.newArrayList(Sets.union(pTrunkPositions, pFoliagePositions))) {
            if (pBox.isInside(blockpos)) {
                discretevoxelshape.fill(blockpos.getX() - pBox.minX(), blockpos.getY() - pBox.minY(), blockpos.getZ() - pBox.minZ());
            }
        }

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        int k1 = 0;
        list.get(0).addAll(pRootPositions);

        while(true) {
            while(k1 >= 7 || !list.get(k1).isEmpty()) {
                if (k1 >= 7) {
                    return discretevoxelshape;
                }

                Iterator<BlockPos> iterator = list.get(k1).iterator();
                BlockPos blockpos1 = iterator.next();
                iterator.remove();
                if (pBox.isInside(blockpos1)) {
                    if (k1 != 0) {
                        BlockState blockstate = pLevel.getBlockState(blockpos1);
                        pLevel.setBlock(blockpos1, blockstate.setValue(BlockStateProperties.DISTANCE, k1), 19);
                    }

                    discretevoxelshape.fill(blockpos1.getX() - pBox.minX(), blockpos1.getY() - pBox.minY(), blockpos1.getZ() - pBox.minZ());

                    for(Direction direction : Direction.values()) {
                        blockpos$mutableblockpos.setWithOffset(blockpos1, direction);
                        if (pBox.isInside(blockpos$mutableblockpos)) {
                            int k = blockpos$mutableblockpos.getX() - pBox.minX();
                            int l = blockpos$mutableblockpos.getY() - pBox.minY();
                            int i1 = blockpos$mutableblockpos.getZ() - pBox.minZ();
                            if (!discretevoxelshape.isFull(k, l, i1)) {
                                BlockState blockstate1 = pLevel.getBlockState(blockpos$mutableblockpos);
                                OptionalInt optionalint = LeavesBlock.getOptionalDistanceAt(blockstate1);
                                if (!optionalint.isEmpty()) {
                                    int j1 = Math.min(optionalint.getAsInt(), k1 + 1);
                                    if (j1 < 7) {
                                        list.get(j1).add(blockpos$mutableblockpos.immutable());
                                        k1 = Math.min(k1, j1);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ++k1;
        }
    }

    @Override
    protected boolean doPlace(WorldGenLevel world, RandomSource random, BlockPos startPos, BiConsumer<BlockPos, BlockState> roots, BiConsumer<BlockPos, BlockState> logs, FoliagePlacer.FoliageSetter leaves, TreeConfiguration configBase) {
        EvergreenTreeConfiguration config = (EvergreenTreeConfiguration)configBase;

        // Move down until we reach the ground
        while (startPos.getY() >= world.getMinBuildHeight()+1 && world.isEmptyBlock(startPos) || world.getBlockState(startPos).is(BlockTags.LEAVES)) {startPos = startPos.below();}

        // Choose heights
        int height = GeneratorUtil.nextIntBetween(random, config.minHeight, config.maxHeight);
        int baseHeight = GeneratorUtil.nextIntBetween(random, (int)(height * 0.6F), (int)(height * 0.4F));
        int leavesHeight = height - baseHeight;
        if (leavesHeight < 3) {
            return false;
        }

        if (!this.checkSpace(world, startPos.above(), baseHeight, height, config)) {
            // Abandon if there isn't enough room
            return false;
        }

        // Start at the top of the tree
        BlockPos pos = startPos.above(height);

        // Leaves at the top
        this.placeLeaves(world, pos, leaves, config);
        pos.below();

        // Add layers of leaves
        for (int i = 0; i < leavesHeight; i++) {
            int trunkWidth = (config.trunkWidth * i / height) + 1;
            int trunkStart = Mth.ceil(0.25D - trunkWidth / 2.0D);
            int trunkEnd = Mth.floor(0.25D + trunkWidth / 2.0D);


            int radius = Math.min(Math.min((i + 2) / 4, 2 + (leavesHeight - i)), 4);
            if (radius == 0) {
                this.placeLeaves(world, pos, leaves, config);
            }
            else if (radius < 2) {
                this.generateLeafLayer(world, random, pos, radius, trunkStart, trunkEnd, leaves, config);
            }
            else {
                if (i % 5 == 0) {
                    this.generateBranch(world, random, pos.offset(trunkStart, 0, trunkStart), Direction.NORTH, radius / 2, logs, leaves, config);
                    this.generateBranch(world, random, pos.offset(trunkEnd, 0, trunkStart), Direction.EAST, radius / 2, logs, leaves, config);
                    this.generateBranch(world, random, pos.offset(trunkEnd, 0, trunkEnd), Direction.SOUTH, radius / 2, logs, leaves, config);
                    this.generateBranch(world, random, pos.offset(trunkStart, 0, trunkEnd), Direction.WEST, radius / 2, logs, leaves, config);
                }
                else {
                    this.generateBranch(world, random, pos.offset(trunkStart, 0, trunkStart), Direction.NORTH, radius, logs, leaves, config);
                    this.generateBranch(world, random, pos.offset(trunkEnd, 0, trunkStart), Direction.EAST, radius, logs, leaves, config);
                    this.generateBranch(world, random, pos.offset(trunkEnd, 0, trunkEnd), Direction.SOUTH, radius, logs, leaves, config);
                    this.generateBranch(world, random, pos.offset(trunkStart, 0, trunkEnd), Direction.WEST, radius, logs, leaves, config);
                }
            }
            pos = pos.below();
        }

        // Create the trunk widths scales
        double[] scalingFactors = new double[]{
                (0.35 + random.nextDouble() * 0.15),
                (0.07 + random.nextDouble() * 0.1),
                (random.nextDouble() * 0.06)
        };

        if (config.trunkWidth == 3) {
            scalingFactors = new double[]{
                    (0.6 + random.nextDouble() * 0.2),
                    (0.1 + random.nextDouble() * 0.2),
                    (0.03 + random.nextDouble() * 0.09)
            };
        }

        // Generate the trunk
        for (int x = -config.trunkWidth; x <= config.trunkWidth; x++) {
            for (int z = -config.trunkWidth; z <= config.trunkWidth; z++) {
                int dist = Math.abs(x) + Math.abs(z);

                int heightHere = height - 2;

                // If we're not the center of the trunk on a single trunk width, give up
                if (config.trunkWidth == 1 && dist > 0) {
                    continue;
                }

                // Scale bigger widths
                if (dist == 1) {
                    heightHere = (int) (height * scalingFactors[0]);
                } else if (dist == 2) {
                    heightHere = (int) (height * scalingFactors[1]);
                } else if (dist == 3) {
                    heightHere = (int) (height * scalingFactors[2]);
                } else if (dist > 3) {
                    continue;
                }

                heightHere += random.nextInt(2);

                boolean didPlace = false;
                for (int y = 0; y < heightHere; y++) {
                    BlockPos local = startPos.offset(x, y, z);
                    didPlace |= this.placeLog(world, local, logs, config);

                    if (dist > 0 && y > 6 && y < (baseHeight - 2) && random.nextInt(15) == 0) {
                        double theta;
                        if (x == 0 && z == 0) {
                            // Prevents bushes originating from the center from generating too low
                            if (y < 10) {
                                continue;
                            }

                            theta = Math.PI * random.nextDouble() * 2;
                        } else {
                            // Make sure the branches only go in the same direction of the current trunk position from the center
                            double angleFromCenter = Math.atan2(x, z);

                            theta = angleFromCenter + (Math.PI * (random.nextDouble() * 0.5 - 0.25));
                        }

                        int branchLength = (3 - dist) + 1 + random.nextInt(2);

                        BlockPos branchPos = null;
                        for (int i = 0; i < branchLength; i++) {
                            branchPos = local.offset(Mth.floor(Math.cos(theta) * i), i / 2, Mth.floor(Math.sin(theta) * i));

                            this.placeLog(world, branchPos, logs, config);
                        }

                        this.generateBush(logs, leaves, world, random, branchPos, config);
                    }
                }

                if (didPlace) {
                    // Place dirt 3 blocks below the trunk if no solid block is found
                    for (int y = 1; y < 4; y++) {
                        BlockPos local = startPos.offset(x, -y, z);
                        BlockState state = world.getBlockState(local);
                        if (!state.isSolid() || isDirt(state)) {
                            world.setBlock(local, Blocks.DIRT.defaultBlockState(), 3);
                        }
                    }
                }
            }
        }

        return true;
    }

    protected boolean generateBush(BiConsumer<BlockPos, BlockState> logs, FoliagePlacer.FoliageSetter leaves, LevelAccessor world, RandomSource random, BlockPos pos, EvergreenTreeConfiguration config)
    {
        int height = 2;

        //Generate a bush 3 blocks tall, with the center block set to a log
        for (int y = 0; y < height; ++y) {
            // log in the center
            if (height - y > 1) {
                this.placeLog(world, pos.offset(0, y, 0), logs, config);
            }

            //Reduces the radius closer to the top of the bush
            int leavesRadius = (height - y > 1 ? 2 : 1);

            for (int x = -leavesRadius; x <= leavesRadius; ++x) {
                for (int z = -leavesRadius; z <= leavesRadius; ++z) {
                    //Randomly prevent the generation of leaves on the corners of each layer
                    if (Math.abs(x) < leavesRadius || Math.abs(z) < leavesRadius) {
                        if (config.altFoliageProvider.getState(random, pos) != Blocks.AIR.defaultBlockState()) {
                            if (random.nextInt(4) == 0) {
                                this.placeAltLeaves(world, pos.offset(x, y, z), leaves, config);
                            }
                            else {
                                this.placeLeaves(world, pos.offset(x, y, z), leaves, config);
                            }
                        }
                        else {
                            this.placeLeaves(world, pos.offset(x, y, z), leaves, config);
                        }
                    }
                }
            }
        }

        return true;
    }
}


