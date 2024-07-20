package net.xeuc.chromalchemy.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ChromAlchemy.MODID);

    public static final RegistryObject<Block> CHROMA_BLOCK = registerBlock("chroma_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_CHROMA_BLOCK = registerBlock("raw_chroma_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> CHROMA_ORE = registerBlock("chroma_ore",
            () -> new DropExperienceBlock( UniformInt.of(7, 14),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(2f)));
    public static final RegistryObject<Block> DEEPSLATE_CHROMA_ORE = registerBlock("deepslate_chroma_ore",
            () -> new DropExperienceBlock( UniformInt.of(9, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3f)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
