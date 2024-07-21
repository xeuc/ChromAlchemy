package net.xeuc.chromalchemy.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.block.ModBlocks;
import net.xeuc.chromalchemy.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ChromAlchemy.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.RED_ORE).add(Blocks.REDSTONE_ORE);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CHROMA_BLOCK.get(),
                    ModBlocks.CHROMA_ORE.get(),
                    ModBlocks.DEEPSLATE_CHROMA_ORE.get(),
                    ModBlocks.XP_PROVIDER.get(),
                    ModBlocks.RAW_CHROMA_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.CHROMA_BLOCK.get(),
                        ModBlocks.CHROMA_ORE.get(),
                        ModBlocks.DEEPSLATE_CHROMA_ORE.get(),
                        ModBlocks.XP_PROVIDER.get(),
                        ModBlocks.RAW_CHROMA_BLOCK.get());

    }
}
