package net.xeuc.chromalchemy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
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
        chromaBlockWithCustomTextures(ModBlocks.CHROMA_BLOCK);
        // blockWithItem(ModBlocks.CHROMA_BLOCK);
        blockWithItem(ModBlocks.RAW_CHROMA_BLOCK);
        blockWithItem(ModBlocks.XP_PROVIDER);
        blockWithItem(ModBlocks.CHROMA_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CHROMA_ORE);
    }

    private void chromaBlockWithCustomTextures(RegistryObject<Block> blockRegistryObject) {
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
