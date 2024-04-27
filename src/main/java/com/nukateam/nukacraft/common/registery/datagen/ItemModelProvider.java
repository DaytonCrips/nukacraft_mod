package com.nukateam.nukacraft.common.registery.datagen;

import com.nukateam.nukacraft.NukaCraftMod;
import com.nukateam.nukacraft.common.data.annotation.DataGen;
import com.nukateam.nukacraft.common.registery.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static com.nukateam.nukacraft.common.data.enums.ResourceType.ITEM;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NukaCraftMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        generate(ModItems.class);
    }

    private void generate(Class<?> modItemsClass) {
        var fields = modItemsClass.getFields();

        try {
            for (var field : fields) {
                var obj = field.get(null);

                if (!(obj instanceof RegistryObject<?>)) continue;

                if(field.isAnnotationPresent(DataGen.class)){
                    var annotation = field.getAnnotation(DataGen.class);

                    switch (annotation.type()) {
                        case ITEM -> {
                            var item = (RegistryObject<Item>) obj;
                            genItems(item, annotation);
                        }
                        case BLOCK -> {
                            var block = (RegistryObject<Block>) obj;
                            blockModel(block);
                        }
                    }
                }
            }
        } catch (Exception e) {
            NukaCraftMod.LOGGER.error(e.getMessage(), e);
        }
    }

    private void genItems(RegistryObject<Item> item, DataGen annotation) {
        var modelFile = getModelFile(annotation.parent().getPath());

        switch (annotation.parent()){
            case SPAWN_EGG -> spawnEggModel(item, modelFile);
            default -> itemModel(item, modelFile);
        }
    }

    private ModelFile getModelFile(String path){
        return getExistingFile(new ResourceLocation(path));
    }

//    private void spawnEggModel(RegistryObject<Item> egg) {
//        withExistingParent(egg.getId().getPath(), new ResourceLocation("item"));
//    }

    public void blockModel(RegistryObject<? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void blockModel(RegistryObject<? extends Block> block, String suffix) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_" + suffix));
    }

    public void blockItemModel(RegistryObject<?> block, RegistryObject<?> textureBlock, ModelFile modelFile) {
        getBuilder(block.getId().getPath()).parent(modelFile).texture("layer0", "block/" + textureBlock.getId().getPath());
    }

    public ItemModelBuilder itemModel(RegistryObject<?> item, ModelFile modelFile) {
        return getBuilder(item.getId().getPath()).parent(modelFile).texture("layer0", "item/" + item.getId().getPath());
    }

    public ItemModelBuilder spawnEggModel(RegistryObject<?> item, ModelFile modelFile) {
        return getBuilder(item.getId().getPath()).parent(modelFile);
    }

    public void itemModelWithSuffix(RegistryObject<?> item, ModelFile modelFile, String suffix) {
        getBuilder(item.getId().getPath() + "_" + suffix).parent(modelFile).texture("layer0", "item/" + item.getId().getPath() + "_" + suffix);
    }

    private ModelFile.ExistingModelFile getModel(RegistryObject<?> item, String suffix) {
        return new ModelFile.ExistingModelFile(modLoc("item/" + item.getId().getPath() + "_" + suffix), existingFileHelper);
    }
}
