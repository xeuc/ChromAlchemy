package net.xeuc.chromalchemy.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public record ModArmorMaterialds(String name, int durabilityMultiplier, int[] defenseForType, int enchantability,
                                SoundEvent equipSound, float toughness, float knockbackResistance, Ingredient repairIngredient)
        implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = {13, 15, 16, 11};

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getSlot().getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.defenseForType[type.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}

public enum ModArmorMaterials2 implements ArmorMaterial {
    SAPPHIRE("sapphire", 26, new int[]{ 5, 7, 5, 4 }, 25,
            SoundEvents.ARMOR_EQUIP_GOLD, 1f, 0f, () -> Ingredient.of(ModItems.SAPPHIRE.get()));
}

public class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMORS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, ChromAlchemy.MODID);

    public static final RegistryObject<ArmorMaterial> CHROMA = registerArmor("chroma",
            Util.make(new EnumMap<>(ArmorItem.Type.class), enumMap -> {
                enumMap.put(ArmorItem.Type.BOOTS, 1);
                enumMap.put(ArmorItem.Type.LEGGINGS, 4);
                enumMap.put(ArmorItem.Type.CHESTPLATE, 5);
                enumMap.put(ArmorItem.Type.HELMET, 2);
                enumMap.put(ArmorItem.Type.BODY, 4);
            }),
            12, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(ModItems.CHROMA.get()));

    private static RegistryObject<ArmorMaterial> registerArmor(
            String pGroup, EnumMap<ArmorItem.Type, Integer> pEnumMap, int pEnchantmentValue, Holder<SoundEvent> pEquipSound,
            float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        List<ArmorMaterial.Layer> pLayerList = List.of(new ArmorMaterial.Layer(new ResourceLocation(pGroup)));
        return registerArmor(pGroup, pEnumMap, pEnchantmentValue, pEquipSound, pToughness, pKnockbackResistance,
                pRepairIngredient, pLayerList);
    }

    private static RegistryObject<ArmorMaterial> registerArmor(
            String pGroup, EnumMap<ArmorItem.Type, Integer> pEnumMap, int pEnchantmentValue, Holder<SoundEvent> pEquipSound, float pToughness,
            float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient, List<ArmorMaterial.Layer> pLayerList) {
        return ARMORS.register(pGroup,
                () -> new ArmorMaterial(pEnumMap, pEnchantmentValue, pEquipSound, pRepairIngredient,
                        pLayerList, pToughness, pKnockbackResistance));

    }

    public static void register(IEventBus eventBus) {
        ARMORS.register(eventBus);
    }
}