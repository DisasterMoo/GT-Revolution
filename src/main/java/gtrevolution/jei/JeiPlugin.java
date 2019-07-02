package gtrevolution.jei;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import net.minecraftforge.oredict.OreDictionary;

import crafttweaker.api.item.IngredientItem;
import gtrevolution.GRConfig;
import gtrevolution.item.GRMetaItem;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;

@JEIPlugin
public class JeiPlugin implements IModPlugin {

    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new MultiblockInfoCategory(registry.getJeiHelpers()));
    }

    @Override
    public void register(IModRegistry registry) {
        MultiblockInfoCategory.registerRecipes(registry);

        if(GRConfig.misc.CircuitOverhaul)
        {
            for (ItemStack it : OreDictionary.getOres("circuitBasic"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitGood"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitAdvanced"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitElite"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitExtreme"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitMaster"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitUltimate"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitSuperconductor"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
            for (ItemStack it : OreDictionary.getOres("circuitInfinite"))
                if (!(it.getItem() instanceof GRMetaItem))
                    registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(it);
        }
    }
}
