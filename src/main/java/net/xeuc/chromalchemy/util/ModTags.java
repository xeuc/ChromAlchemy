package net.xeuc.chromalchemy.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.xeuc.chromalchemy.ChromAlchemy;

import java.util.List;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> RED_ORE = tag("red_ore");
        public static final TagKey<Block> NEEDS_CHROMA_TOOL = tag("needs_chroma_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ChromAlchemy.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> RED_MINERAL = tag("red_mineral");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ChromAlchemy.MODID, name));
        }
    }
}
