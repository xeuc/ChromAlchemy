package net.xeuc.chromalchemy.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import net.xeuc.chromalchemy.ChromAlchemy;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ChromAlchemy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    // https://www.youtube.com/watch?v=enzKJWq0vNI
    // time = 19:40

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        // generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));

        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
            new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput,
                lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
