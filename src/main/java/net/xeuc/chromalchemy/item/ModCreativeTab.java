package net.xeuc.chromalchemy.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.block.ModBlocks;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChromAlchemy.MODID);

    public static final RegistryObject<CreativeModeTab> CHROMA_TAB = CREATIVE_MODE_TABS.register("chroma_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CHROMA.get()))
                    .title(Component.translatable("creativetab.chroma_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CHROMA.get());
                        pOutput.accept(ModItems.RAW_CHROMA.get());
                        pOutput.accept(ModBlocks.CHROMA_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_CHROMA_BLOCK.get());
                        pOutput.accept(ModBlocks.CHROMA_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_CHROMA_ORE.get());
                        pOutput.accept(ModItems.MINION_SCEPTER.get());
                        pOutput.accept(ModBlocks.XP_PROVIDER.get());
                        pOutput.accept(ModItems.COOKED_EGG.get());
                        pOutput.accept(ModItems.PINE_CONE.get());
                        pOutput.accept(ModItems.SCEPTER_CHROMA.get());
                        pOutput.accept(ModItems.CHROMA_SHOVEL.get());
                        pOutput.accept(ModItems.CHROMA_SWORD.get());
                        pOutput.accept(ModItems.CHROMA_PICKAXE.get());
                        pOutput.accept(ModItems.CHROMA_AXE.get());
                        pOutput.accept(ModItems.CHROMA_HOE.get());

                        pOutput.accept(ModBlocks.CHROMA_STAIRS.get());
                        pOutput.accept(ModBlocks.CHROMA_SLAB.get());
                        pOutput.accept(ModBlocks.CHROMA_BUTTON.get());
                        pOutput.accept(ModBlocks.CHROMA_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.CHROMA_FENCE.get());
                        pOutput.accept(ModBlocks.CHROMA_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.CHROMA_WALL.get());
                        pOutput.accept(ModBlocks.CHROMA_DOOR.get());
                        pOutput.accept(ModBlocks.CHROMA_TRAPDOOR.get());

                        // pOutput.accept(Items.DIAMOND);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
