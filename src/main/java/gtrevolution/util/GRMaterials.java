package gtrevolution.util;

import com.google.common.collect.ImmutableList;
import net.minecraftforge.fml.common.Loader;

import gregtech.api.GTValues;
import gregtech.api.unification.material.IMaterialHandler;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.stack.MaterialStack;

@SuppressWarnings("WeakerAccess")
@IMaterialHandler.RegisterMaterialHandler
public class GRMaterials implements IMaterialHandler
{
    public static DustMaterial EGLIN_BASE;
    public static IngotMaterial TALONITE;
    public static IngotMaterial STELLITE;
    public static IngotMaterial TANTALLOY60;
    public static IngotMaterial TANTALLOY61;
    public static IngotMaterial STABALLOY;
    public static IngotMaterial INCONEL690;
    public static IngotMaterial INCONEL792;
    public static IngotMaterial POTIN;
    public static IngotMaterial EGLIN_STEEL;
    public static IngotMaterial DRACONIUM;
    public static IngotMaterial AWAKENED_DRACONIUM;
    public static IngotMaterial METEORIC_IRON;
    public static IngotMaterial DESH;
    private static final long INGOT_FLAGS = DustMaterial.MatFlags.GENERATE_PLATE |
            SolidMaterial.MatFlags.GENERATE_ROD |
            SolidMaterial.MatFlags.GENERATE_LONG_ROD |
            IngotMaterial.MatFlags.GENERATE_FOIL |
            SolidMaterial.MatFlags.GENERATE_GEAR |
            IngotMaterial.MatFlags.GENERATE_SMALL_GEAR |
            IngotMaterial.MatFlags.GENERATE_BOLT_SCREW |
            IngotMaterial.MatFlags.GENERATE_RING |
            SolidMaterial.MatFlags.GENERATE_FRAME |
            IngotMaterial.MatFlags.GENERATE_ROTOR |
            IngotMaterial.MatFlags.GENERATE_FINE_WIRE;

    public static IngotMaterial[] SUPERCONDUCTOR;
    public static FluidMaterial IRON_III_CHLORIDE;
    public static FluidMaterial BACTERIAL_GROWTH;

    private static int id = 601;
    public static IngotMaterial NEUTRONIUM;
    private static final long ALLOY_FLAGS = INGOT_FLAGS |
            Material.MatFlags.DECOMPOSITION_BY_CENTRIFUGING;

    static
    {
        NEUTRONIUM = new IngotMaterial(id++, "neutronium", 0xC3C3C3, MaterialIconSet.METALLIC, 6, ImmutableList.of(), INGOT_FLAGS);
        TALONITE = new IngotMaterial(id++, "talonite", 0xC54066, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Cobalt, 4), new MaterialStack(Materials.Chrome, 4), new MaterialStack(Materials.Phosphor, 2), new MaterialStack(Materials.Molybdenum, 1)), ALLOY_FLAGS);
        STELLITE = new IngotMaterial(id++, "stellite", 0x663B5F, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Cobalt, 7), new MaterialStack(Materials.Chrome, 7), new MaterialStack(Materials.Manganese, 2), new MaterialStack(Materials.Titanium, 2)), ALLOY_FLAGS, null, 700);
        TANTALLOY60 = new IngotMaterial(id++, "tantalloy60", 0xA8B2B7, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Tungsten, 2), new MaterialStack(Materials.Tantalum, 23)), ALLOY_FLAGS, null, 1400);
        TANTALLOY61 = new IngotMaterial(id++, "tantalloy61", 0x99A4A8, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(GRMaterials.TANTALLOY60, 1), new MaterialStack(Materials.Titanium, 6), new MaterialStack(Materials.Yttrium, 4)), ALLOY_FLAGS, null, 1400);
        STABALLOY = new IngotMaterial(id++, "staballoy", 0x373C34, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Uranium, 9), new MaterialStack(Materials.Titanium, 1)), ALLOY_FLAGS, null, 1400);
        INCONEL690 = new IngotMaterial(id++, "inconel690", 0x56BD5D, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Chrome, 1), new MaterialStack(Materials.Niobium, 2), new MaterialStack(Materials.Molybdenum, 2), new MaterialStack(Materials.Nichrome, 3)), ALLOY_FLAGS, null, 700);
        INCONEL792 = new IngotMaterial(id++, "inconel792", 0x489F4E, MaterialIconSet.METALLIC, 1, ImmutableList.of(new MaterialStack(Materials.Nickel, 2), new MaterialStack(Materials.Niobium, 1), new MaterialStack(Materials.Aluminium, 2), new MaterialStack(Materials.Nichrome, 1)), ALLOY_FLAGS, null, 700);
        POTIN = new IngotMaterial(id++, "potin", 0x916D2A, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Lead, 2), new MaterialStack(Materials.Bronze, 2), new MaterialStack(Materials.Tin, 1)), ALLOY_FLAGS);
        EGLIN_BASE = new DustMaterial(id++, "eglin_base", 0x763A10, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Iron, 4), new MaterialStack(Materials.Kanthal, 1), new MaterialStack(Materials.Invar, 5)), Material.MatFlags.DECOMPOSITION_BY_CENTRIFUGING);
        EGLIN_STEEL = new IngotMaterial(id++, "eglin_steel", 0x763A10, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(GRMaterials.EGLIN_BASE, 10), new MaterialStack(Materials.Sulfur, 1), new MaterialStack(Materials.Silicon, 4), new MaterialStack(Materials.Carbon, 1)), ALLOY_FLAGS);

        //ALL NORMAL PIPE VALUES!!!
        TANTALLOY60.setFluidPipeProperties(750, 4250, true);
        TANTALLOY61.setFluidPipeProperties(900, 5800, true);
        STABALLOY.setFluidPipeProperties(937, 7500, true);
        INCONEL690.setFluidPipeProperties(1125, 4800, true);
        INCONEL792.setFluidPipeProperties(1200, 5500, true);
        POTIN.setFluidPipeProperties(72, 2000, true);

        if (GRConfig.misc.Superconductors || GRConfig.misc.CircuitOverhaul)
        {
            SUPERCONDUCTOR = new IngotMaterial[7];
            SUPERCONDUCTOR[0] = new IngotMaterial(id++, "superconductor_lv", 0xAC0000, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Redstone, 1), new MaterialStack(Materials.Silicon, 1), new MaterialStack(Materials.Tin, 1)), ALLOY_FLAGS, null, 1, 64, 1200);
            SUPERCONDUCTOR[1] = new IngotMaterial(id++, "superconductor_mv", 0x4C4C4C, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Cadmium, 5), new MaterialStack(Materials.Magnesium, 1)), ALLOY_FLAGS, null, 1, 128, 2500);
            SUPERCONDUCTOR[2] = new IngotMaterial(id++, "superconductor_hv", 0x2B1500, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Titanium, 1), new MaterialStack(Materials.Barium, 9), new MaterialStack(Materials.Copper, 10), new MaterialStack(Materials.Oxygen, 20)), INGOT_FLAGS | Material.MatFlags.DECOMPOSITION_BY_ELECTROLYZING, null, 1, 512, 3300);
            SUPERCONDUCTOR[3] = new IngotMaterial(id++, "superconductor_ev", 0x24FF24, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Platinum, 3), new MaterialStack(Materials.Uranium, 1)), ALLOY_FLAGS, null, 1, 512, 4400);
            SUPERCONDUCTOR[4] = new IngotMaterial(id++, "superconductor_iv", 0x2E002E, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Vanadium, 1), new MaterialStack(Materials.Indium, 3)), ALLOY_FLAGS, null, 1, 1024, 5200);
            SUPERCONDUCTOR[5] = new IngotMaterial(id++, "superconductor_luv", 0x820040, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Titanium, 1), new MaterialStack(Materials.Barium, 2), new MaterialStack(Materials.Copper, 7), new MaterialStack(Materials.Indium, 4)), ALLOY_FLAGS, null, 1, 1024, 6000);
            SUPERCONDUCTOR[6] = new IngotMaterial(id++, "superconductor_zpm", 0x111111, MaterialIconSet.DULL, 1, ImmutableList.of(new MaterialStack(Materials.Naquadah, 4), new MaterialStack(Materials.Indium, 2), new MaterialStack(Materials.Palladium, 6), new MaterialStack(Materials.Osmium, 1)), ALLOY_FLAGS, null, 1, 2048, 9000);
            SUPERCONDUCTOR[0].setCableProperties(GTValues.V[GTValues.LV], 1, 0);
            SUPERCONDUCTOR[1].setCableProperties(GTValues.V[GTValues.MV], 2, 0);
            SUPERCONDUCTOR[2].setCableProperties(GTValues.V[GTValues.HV], 2, 0);
            SUPERCONDUCTOR[3].setCableProperties(GTValues.V[GTValues.EV], 4, 0);
            SUPERCONDUCTOR[4].setCableProperties(GTValues.V[GTValues.IV], 4, 0);
            SUPERCONDUCTOR[5].setCableProperties(GTValues.V[GTValues.LuV], 8, 0);
            SUPERCONDUCTOR[6].setCableProperties(GTValues.V[GTValues.ZPM], 8, 0);
        }

        if (Loader.isModLoaded("draconicevolution"))
        {
            DRACONIUM = new IngotMaterial(id++, "draconium", 0x68369A, MaterialIconSet.DULL, 6, ImmutableList.of(), INGOT_FLAGS, null, 6, 10240, 8500);
            AWAKENED_DRACONIUM = new IngotMaterial(id++, "awakened_draconium", 0xFFC400, MaterialIconSet.DULL, 7, ImmutableList.of(), INGOT_FLAGS, null, 6, 10240, 9200);
            DRACONIUM.setCableProperties(GTValues.ZPM, 4, 2);
            DRACONIUM.setFluidPipeProperties(1000, 1000000, true);
            AWAKENED_DRACONIUM.setCableProperties(GTValues.UV, 2, 1);
            AWAKENED_DRACONIUM.setFluidPipeProperties(2000, 1000000, true);
        }

        if (Loader.isModLoaded("GalacticraftCore"))
        {
            METEORIC_IRON = new IngotMaterial(id++, "meteoric_iron", 0x7D7165, MaterialIconSet.ROUGH, 4, ImmutableList.of(), INGOT_FLAGS, null, 3, 620, 2500);
            DESH = new IngotMaterial(id++, "desh", 0x313131, MaterialIconSet.ROUGH, 4, ImmutableList.of(), INGOT_FLAGS, null, 4, 2560, 3500);
            DESH.setFluidPipeProperties(600, 3300, true);
            DESH.setCableProperties(GTValues.IV, 2, 4);
        }

        if (GRConfig.misc.CircuitOverhaul)
        {
            IRON_III_CHLORIDE = new FluidMaterial(id++, "iron_III_chloride", 0x111216, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK);
            BACTERIAL_GROWTH = new FluidMaterial(id++, "bacterial_growth", 0xA37E64, MaterialIconSet.FLUID, ImmutableList.of(), FluidMaterial.MatFlags.GENERATE_FLUID_BLOCK);

        }
    }

    @Override
    public void onMaterialsInit()
    {
        //Add missing GTCE flags
        for (Material m : Material.MATERIAL_REGISTRY)
        {
            if (m instanceof IngotMaterial && m != Materials.Rubber && m != Materials.SiliconeRubber && m != Materials.StyreneButadieneRubber)
            {
                m.addFlag(INGOT_FLAGS);
            }
        }
        Materials.Naquadah.setFluidPipeProperties(1200, 5500, true);
    }
}