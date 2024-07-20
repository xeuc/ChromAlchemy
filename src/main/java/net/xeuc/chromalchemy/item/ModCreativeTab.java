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

                        // pOutput.accept(Items.DIAMOND);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
