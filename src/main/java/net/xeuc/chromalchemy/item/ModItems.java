package net.xeuc.chromalchemy.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.item.custom.FuelItem;
import net.xeuc.chromalchemy.item.custom.MinionScepterItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChromAlchemy.MODID);

    public static final RegistryObject<Item> CHROMA = ITEMS.register("chroma",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CHROMA = ITEMS.register("raw_chroma",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MINION_SCEPTER = ITEMS.register("minion_scepter",
            () -> new MinionScepterItem(new Item.Properties().durability(20)));

    public static final RegistryObject<Item> COOKED_EGG = ITEMS.register("cooked_egg",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_EGG)));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 200));

    public static final RegistryObject<Item> SCEPTER_CHROMA = ITEMS.register("scepter_chroma",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
