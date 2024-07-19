package net.xeuc.chromalchemy.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChromAlchemy.MODID);

    public static final RegistryObject<Item> CHROMA = ITEMS.register("chroma",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CHROMA = ITEMS.register("raw_chroma",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
