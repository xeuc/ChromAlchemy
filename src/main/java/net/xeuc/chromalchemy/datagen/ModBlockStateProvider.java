package net.xeuc.chromalchemy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChromAlchemy.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        BlockWithMultipleTextures(ModBlocks.CHROMA_BLOCK);
        blockWithItem(ModBlocks.RAW_CHROMA_BLOCK);
        blockWithItem(ModBlocks.XP_PROVIDER);
        blockWithItem(ModBlocks.CHROMA_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CHROMA_ORE);

        ResourceLocation chroma_block = blockTexture(ModBlocks.CHROMA_BLOCK.get());
        // ResourceLocation chroma_block =  modLoc("block/chrome_block");


        stairsBlock(((StairBlock) ModBlocks.CHROMA_STAIRS.get()), chroma_block);
        slabBlock(((SlabBlock) ModBlocks.CHROMA_SLAB.get()), chroma_block, chroma_block);

        buttonBlock(((ButtonBlock) ModBlocks.CHROMA_BUTTON.get()), chroma_block);
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CHROMA_PRESSURE_PLATE.get()), chroma_block);

        fenceBlock(((FenceBlock) ModBlocks.CHROMA_FENCE.get()), chroma_block);
        fenceGateBlock(((FenceGateBlock) ModBlocks.CHROMA_FENCE_GATE.get()), chroma_block);
        wallBlock(((WallBlock) ModBlocks.CHROMA_WALL.get()), chroma_block);

        doorBlockWithRenderType(((DoorBlock) ModBlocks.CHROMA_DOOR.get()),
                modLoc("block/chroma_door_bottom"), modLoc("block/chroma_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CHROMA_TRAPDOOR.get()),
                modLoc("block/chroma_trapdoor"), true, "cutout");
    }

    private void BlockWithMultipleTextures(RegistryObject<Block> blockRegistryObject) {
        ModelFile model = models().withExistingParent(blockRegistryObject.getId().getPath(), "minecraft:block/cube")
                .texture("up", modLoc("block/chroma_block_up"))
                .texture("down", modLoc("block/chroma_block_down"))
                .texture("north", modLoc("block/chroma_block_north"))
                .texture("south", modLoc("block/chroma_block_south"))
                .texture("east", modLoc("block/chroma_block_east"))
                .texture("west", modLoc("block/chroma_block_west"));
        simpleBlock(blockRegistryObject.get(), model);
        simpleBlockItem(blockRegistryObject.get(), model);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
