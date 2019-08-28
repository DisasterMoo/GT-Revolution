package gtrevolution.recipes;

import net.minecraftforge.fluids.FluidStack;

import gregtech.api.GTValues;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.machines.FuelRecipeMap;
import gregtech.api.recipes.recipes.FuelRecipe;
import gregtech.api.unification.material.Materials;

public final class FuelModifications
{
    public static void init()
    {
        registerNaquadahReactorFuel(Materials.NaquadahEnriched.getFluid(1), 750, GTValues.LV);
    }

    private static void registerPlasmaFuel(FluidStack fuelStack, int duration, int tier)
    {
        RecipeMaps.PLASMA_GENERATOR_FUELS.addRecipe(new FuelRecipe(fuelStack, duration, GTValues.V[tier]));
    }

    private static void registerNaquadahReactorFuel(FluidStack fuelStack, int duration, int tier)
    {
        GRRecipeMaps.NAQUADAH_REACTOR_FUELS.addRecipe(new FuelRecipe(fuelStack, duration, GTValues.V[tier]));
    }

    private static void removeFuelRecipe(FuelRecipeMap map, FluidStack fluidStack)
    {
        map.removeRecipe(map.findRecipe(Integer.MAX_VALUE, fluidStack));
    }
}
