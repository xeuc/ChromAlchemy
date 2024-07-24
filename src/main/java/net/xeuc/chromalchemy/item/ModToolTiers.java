package net.xeuc.chromalchemy.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraftforge.common.TierSortingRegistry;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.util.ModTags;


import java.util.List;
/*
public class ModToolTiers {
    public static final Tier CHROMA = TierSortingRegistry.registerTier(
            new ForgeTier(1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_CHROMA_TOOL , () -> Ingredient.of(ModItems.CHROMA.get()), ModTags.Blocks.RED_ORE),
            new ResourceLocation(ChromAlchemy.MODID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
}
*/

public class ModToolTiers {
    public static final Tier CHROMA = new ForgeTier(
            1500, 5f, 4f, 25,
            ModTags.Blocks.NEEDS_CHROMA_TOOL , () -> Ingredient.of(ModItems.CHROMA.get()), BlockTags.INCORRECT_FOR_DIAMOND_TOOL);
}