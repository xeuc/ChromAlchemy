package net.xeuc.chromalchemy.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.block.ModBlocks;
import net.xeuc.chromalchemy.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CHROMA_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_CHROMA_BLOCK.get());
        this.dropSelf(ModBlocks.XP_PROVIDER.get());

        this.add(ModBlocks.CHROMA_ORE.get(),
                block -> createOreDrop(ModBlocks.CHROMA_ORE.get()/*TODO: try `block` here*/, ModItems.CHROMA.get()));
        this.add(ModBlocks.DEEPSLATE_CHROMA_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_CHROMA_ORE.get()/*TODO: try `block` here*/, ModItems.CHROMA.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
