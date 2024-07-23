package net.xeuc.chromalchemy.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.block.custom.XpProviderBlock;
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

    public static final RegistryObject<Block> XP_PROVIDER = registerBlock("xp_provider",
            () -> new XpProviderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL).sound(SoundType.METAL)));

    public static final RegistryObject<Block> CHROMA_STAIRS = registerBlock("chroma_stairs",
            () -> new StairBlock(ModBlocks.CHROMA_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> CHROMA_SLAB = registerBlock("chroma_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> CHROMA_BUTTON = registerBlock("chroma_button",
            () -> new ButtonBlock(BlockSetType.IRON, 10,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> CHROMA_PRESSURE_PLATE = registerBlock("chroma_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> CHROMA_FENCE = registerBlock("chroma_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> CHROMA_FENCE_GATE = registerBlock("chroma_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> CHROMA_WALL = registerBlock("chroma_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> CHROMA_DOOR = registerBlock("chroma_door",
            () -> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion()));
    public static final RegistryObject<Block> CHROMA_TRAPDOOR = registerBlock("chroma_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).noOcclusion()));

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
