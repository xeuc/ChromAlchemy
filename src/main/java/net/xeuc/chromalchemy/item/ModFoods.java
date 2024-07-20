package net.xeuc.chromalchemy.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties COOKED_EGG = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.6F)
            // .effect(new MobEffectInstance(MobEffects.BLINDNESS, 10), 1)
            .build();
}
