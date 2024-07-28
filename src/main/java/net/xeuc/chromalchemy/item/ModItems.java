package net.xeuc.chromalchemy.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.item.custom.FuelItem;
import net.xeuc.chromalchemy.item.custom.MinionScepterItem;

import java.util.EnumMap;


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


    public static final RegistryObject<Item> CHROMA_SWORD = ITEMS.register("chroma_sword",
            () -> new SwordItem(ModToolTiers.CHROMA, new Item.Properties()));
    public static final RegistryObject<Item> CHROMA_PICKAXE = ITEMS.register("chroma_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CHROMA, new Item.Properties()));
    public static final RegistryObject<Item> CHROMA_AXE = ITEMS.register("chroma_axe",
            () -> new AxeItem(ModToolTiers.CHROMA, new Item.Properties()));
    public static final RegistryObject<Item> CHROMA_SHOVEL = ITEMS.register("chroma_shovel",
            () -> new ShovelItem(ModToolTiers.CHROMA, new Item.Properties()));
    public static final RegistryObject<Item> CHROMA_HOE = ITEMS.register("chroma_hoe",
            () -> new HoeItem(ModToolTiers.CHROMA, new Item.Properties()));

//    public static final RegistryObject<Item> CHROMA_HELMET = ITEMS.register("chroma_helmet",
//            () -> new ArmorItem(ModArmorMaterials.CHROMA.getHolder().orElseThrow(), ArmorItem.Type.HELMET, new Item.Properties()));
//    public static final RegistryObject<Item> CHROMA_CHESTPLATE = ITEMS.register("chroma_chestplate",
//            () -> new ArmorItem(ModArmorMaterials.CHROMA.getHolder().orElseThrow(), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
//    public static final RegistryObject<Item> CHROMA_LEGGINGS = ITEMS.register("chroma_leggings",
//            () -> new ArmorItem(ModArmorMaterials.CHROMA.getHolder().orElseThrow(), ArmorItem.Type.LEGGINGS, new Item.Properties()));
//    public static final RegistryObject<Item> CHROMA_BOOTS = ITEMS.register("chroma_boots",
//            () -> new ArmorItem(ModArmorMaterials.CHROMA.getHolder().orElseThrow(), ArmorItem.Type.BOOTS, new Item.Properties()));

    // public static final RegistryObject<Item> CHROMA_BOOTS = ITEMS.register("chroma_boots",
    //        () -> new ArmorItem(Holder.direct(ModArmorMaterials.CHROMA), ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> CHROMA_HELMET = ITEMS.register("chroma_helmet", () -> {
        return new ArmorItem(
                ModArmorMaterials.CHROMA.getHolder().orElseThrow(),
                ArmorItem.Type.HELMET,
                new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))
        );
    });
    public static final RegistryObject<Item> CHROMA_CHESTPLATE = ITEMS.register("chroma_chestplate", () -> {
        return new ArmorItem(
                ModArmorMaterials.CHROMA.getHolder().orElseThrow(),
                ArmorItem.Type.CHESTPLATE,
                new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))
        );
    });
    public static final RegistryObject<Item> CHROMA_LEGGINGS = ITEMS.register("chroma_leggings", () -> {
        return new ArmorItem(
                ModArmorMaterials.CHROMA.getHolder().orElseThrow(),
                ArmorItem.Type.LEGGINGS,
                new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))
        );
    });
    public static final RegistryObject<Item> CHROMA_BOOTS = ITEMS.register("chroma_boots", () -> {
        return new ArmorItem(
                ModArmorMaterials.CHROMA.getHolder().orElseThrow(),
                ArmorItem.Type.BOOTS,
                new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))
        );
    });


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}
