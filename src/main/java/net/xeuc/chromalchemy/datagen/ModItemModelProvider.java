package net.xeuc.chromalchemy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.block.ModBlocks;
import net.xeuc.chromalchemy.item.ModItems;

import java.rmi.registry.Registry;
import java.sql.ResultSet;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChromAlchemy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CHROMA);
        simpleItem(ModItems.COOKED_EGG);
        simpleItem(ModItems.RAW_CHROMA);
        simpleItem(ModItems.MINION_SCEPTER);
        simpleItem(ModItems.PINE_CONE);

        simpleBlockItem(ModBlocks.CHROMA_DOOR);

        // Todo: put other texture: chroma_block.png
        fenceItem(ModBlocks.CHROMA_FENCE, ModBlocks.CHROMA_BLOCK);
        buttonItem(ModBlocks.CHROMA_BUTTON, ModBlocks.CHROMA_BLOCK);
        wallItem(ModBlocks.CHROMA_WALL, ModBlocks.CHROMA_BLOCK);

        evenSimplerBlockItem(ModBlocks.CHROMA_STAIRS);
        evenSimplerBlockItem(ModBlocks.CHROMA_SLAB);
        evenSimplerBlockItem(ModBlocks.CHROMA_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.CHROMA_FENCE_GATE);


        trapdoorItem(ModBlocks.CHROMA_TRAPDOOR);


        handheldItem(ModItems.CHROMA_PICKAXE);
        handheldItem(ModItems.CHROMA_SWORD);
        handheldItem(ModItems.CHROMA_SHOVEL);
        handheldItem(ModItems.CHROMA_AXE);
        handheldItem(ModItems.CHROMA_HOE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChromAlchemy.MODID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block){
        this.withExistingParent(ChromAlchemy.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" +  ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" +  ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChromAlchemy.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ChromAlchemy.MODID, "item/" + item.getId().getPath()));
    }


    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/fence_inventory")).texture("texture", new ResourceLocation(
                ChromAlchemy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()
        ));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/button_inventory")).texture("texture", new ResourceLocation(
                ChromAlchemy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()
        ));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/wall_inventory")).texture("wall", new ResourceLocation(
                ChromAlchemy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()
        ));
    }
}
