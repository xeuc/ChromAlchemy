package net.xeuc.chromalchemy.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xeuc.chromalchemy.ChromAlchemy;
import net.xeuc.chromalchemy.block.ModBlocks;
import net.xeuc.chromalchemy.item.ModItems;

import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChromAlchemy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CHROMA);
        simpleItem(ModItems.COOKED_EGG);
        simpleItem(ModItems.RAW_CHROMA);
        simpleItem(ModItems.MINION_SCEPTER);
        simpleItem(ModItems.PINE_CONE);

        simpleBlockItem(ModBlocks.CHROMA_DOOR);

        // Todo: put other texture: chroma_block.png
        fenceItem(ModBlocks.CHROMA_FENCE, ModBlocks.CHROMA_BLOCK);
        buttonItem(ModBlocks.CHROMA_BUTTON, ModBlocks.CHROMA_BLOCK);
        wallItem(ModBlocks.CHROMA_WALL, ModBlocks.CHROMA_BLOCK);

        evenSimplerBlockItem(ModBlocks.CHROMA_STAIRS);
        evenSimplerBlockItem(ModBlocks.CHROMA_SLAB);
        evenSimplerBlockItem(ModBlocks.CHROMA_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.CHROMA_FENCE_GATE);


        trapdoorItem(ModBlocks.CHROMA_TRAPDOOR);


        handheldItem(ModItems.CHROMA_PICKAXE);
        handheldItem(ModItems.CHROMA_SWORD);
        handheldItem(ModItems.CHROMA_SHOVEL);
        handheldItem(ModItems.CHROMA_AXE);
        handheldItem(ModItems.CHROMA_HOE);

        trimmedArmorItem(ModItems.CHROMA_HELMET);
        trimmedArmorItem(ModItems.CHROMA_CHESTPLATE);
        trimmedArmorItem(ModItems.CHROMA_LEGGINGS);
        trimmedArmorItem(ModItems.CHROMA_BOOTS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChromAlchemy.MODID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block){
        this.withExistingParent(ChromAlchemy.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" +  ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block){
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" +  ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChromAlchemy.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ChromAlchemy.MODID, "item/" + item.getId().getPath()));
    }


    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/fence_inventory")).texture("texture", new ResourceLocation(
                ChromAlchemy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()
        ));
    }
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/button_inventory")).texture("texture", new ResourceLocation(
                ChromAlchemy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()
        ));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                mcLoc("block/wall_inventory")).texture("wall", new ResourceLocation(
                ChromAlchemy.MODID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()
        ));
    }



    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ChromAlchemy.MODID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

}
