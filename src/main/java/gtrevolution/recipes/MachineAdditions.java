package gtrevolution.recipes;

import java.util.Arrays;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import gregtech.api.GTValues;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockWireCoil;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gtrevolution.GTRevolution;
import gtrevolution.block.GRMetaBlocks;
import gtrevolution.block.GRMultiblockCasing;
import gtrevolution.item.GRMetaItems;
import gtrevolution.machines.GRTileEntities;
import gtrevolution.util.GRConfig;

import static gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.ASSEMBLER_CASING;
import static gtrevolution.recipes.GRCraftingComponents.*;

public final class MachineAdditions
{

    public static void init()
    {
        //Added machines
        registerMachineRecipe(GRTileEntities.MASS_FABRICATOR, false, "CFC", "WMW", "CFC",
                'M', HULL, 'F', FIELD_GENERATOR, 'C', CIRCUIT, 'W', CABLE_QUAD);

        registerMachineRecipe(GRTileEntities.REPLICATOR, false, "EFE", "CMC", "EWE",
                'M', HULL, 'F', FIELD_GENERATOR, 'C', CIRCUIT, 'W', CABLE_QUAD, 'E', EMITTER);

        registerMachineRecipe(GRTileEntities.NAQUADAH_REACTOR, true, "SCS", "FMF", "WCW",
                'M', HULL, 'F', FIELD_GENERATOR, 'C', CIRCUIT, 'W', CABLE_QUAD, 'S', STICK_RADIOACTIVE);

        registerMachineRecipe(GRTileEntities.DISASSEMBLER, true, "RCR", "RHR", "GCG",
                'H', HULL, 'C', CIRCUIT, 'R', ROBOT_ARM, 'G', CABLE);

        //Fusion computer
        ModHandler.addShapedRecipe(GTRevolution.MODID + ":fusion_mark1", GRTileEntities.FUSION_REACTOR[0].getStackForm(),
                "CPC", "FMF", "CNC",
                'C', CIRCUIT.getIngredient(5),
                'F', FIELD_GENERATOR.getIngredient(5),
                'P', OreDictUnifier.get(OrePrefix.plate, Materials.Plutonium241),
                'N', OreDictUnifier.get(OrePrefix.plate, Materials.NetherStar),
                'M', MetaBlocks.WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.FUSION_COIL, 1));

        ModHandler.addShapedRecipe(GTRevolution.MODID + ":fusion_mark2", GRTileEntities.FUSION_REACTOR[1].getStackForm(),
                "CPC", "FMF", "CPC",
                'C', CIRCUIT.getIngredient(6),
                'F', FIELD_GENERATOR.getIngredient(6),
                'P', OreDictUnifier.get(OrePrefix.plate, Materials.Europium),
                'M', GRTileEntities.FUSION_REACTOR[0].getStackForm());

        ModHandler.addShapedRecipe(GTRevolution.MODID + ":fusion_mark3", GRTileEntities.FUSION_REACTOR[2].getStackForm(),
                "CPC", "FMF", "CPC",
                'C', CIRCUIT.getIngredient(7),
                'F', FIELD_GENERATOR.getIngredient(7),
                'P', OreDictUnifier.get(OrePrefix.plate, Materials.Americium),
                'M', GRTileEntities.FUSION_REACTOR[1].getStackForm());

        //Assembly Line
        ModHandler.addShapedRecipe(GTRevolution.MODID + ":assembly_line", GRTileEntities.ASSEMBLY_LINE.getStackForm(), "CRC", "SAS", "CRC", 'A', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'R', MetaItems.ROBOT_ARM_IV, 'C', MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(ASSEMBLER_CASING), 'S', "circuitElite");

        //Casing Recipes
        int casingNumber = GRConfig.misc.HarderCasings ? 1 : 3;
        ModHandler.addShapedRecipe("maceration_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.MACERATION_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "platePalladium", 'H', "frameGtBlueSteel");
        ModHandler.addShapedRecipe("washplant_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.WASHPLANT_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateBlueSteel", 'H', "frameGtBlueSteel");
        ModHandler.addShapedRecipe("thermal_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.THERMAL_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateRedSteel", 'H', "frameGtBlueSteel");
        ModHandler.addShapedRecipe("chemical_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.CHEMICAL_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "platePolytetrafluoroethylene", 'H', gregtech.common.blocks.MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STEEL_SOLID, 1));
        ModHandler.addShapedRecipe("fisher_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.FISHER_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateInconel792", 'H', "frameGtStaballoy");
        ModHandler.addShapedRecipe("electrolyzer_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.ELECTROLYZER_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "platePotin", 'H', "frameGtStaballoy");
        ModHandler.addShapedRecipe("centrifuge_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.CENTRIFUGE_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateInconel690", 'H', "frameGtStaballoy");
        ModHandler.addShapedRecipe("wire_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.WIRE_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateTalonite", 'H', "frameGtStaballoy");
        ModHandler.addShapedRecipe("sieve_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.SIEVE_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateEglinSteel", 'H', "frameGtBlueSteel");
        ModHandler.addShapedRecipe("cutter_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.CUTTER_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateBlackSteel", 'H', "frameGtSteel");
        ModHandler.addShapedRecipe("laser_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.LASER_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateBlueSteel", 'H', "frameGtAluminium");

        ModHandler.addShapedRecipe("sieve_grate", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.SIEVE_GRATE, casingNumber), "TPT", "WHW", "TWT", 'P', MetaItems.ITEM_FILTER.getStackForm(), 'T', "plateBlackSteel", 'W', "wireFineSteel", 'H', "frameGtSteel");

        if (GRConfig.multiblocks.EBF)
        {
            ModHandler.removeRecipes(MetaTileEntities.ELECTRIC_BLAST_FURNACE.getStackForm());
            ModHandler.addShapedRecipe("improved_blast_furnace", GRTileEntities.BLAST_FURNACE.getStackForm(), "FFF", "CHC", "WCW", 'F', new ItemStack(Blocks.FURNACE, 1), 'C', "circuitBasic", 'H', gregtech.common.blocks.MetaBlocks.METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.INVAR_HEATPROOF, 1), 'W', "cableGtSingleTin");
        }

        //Industrial Machine Controllers recipes
        if (GRConfig.multiblocks.Macerator)
            ModHandler.addShapedRecipe("multiblock_industrial_macerator", GRTileEntities.INDUSTRIAL_MACERATOR.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.MACERATOR[GTValues.HV].getStackForm(), 'C', "circuitMaster", 'W', MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm(), 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateTungstenCarbide");
        if (GRConfig.multiblocks.Thermal)
            ModHandler.addShapedRecipe("multiblock_industrial_thermalcentrifuge", GRTileEntities.INDUSTRIAL_THERMALCENTRIFUGE.getStackForm(), "TWT", "MCM", "TIT", 'M', "stickTalonite", 'W', "circuitMaster", 'C', MetaTileEntities.THERMAL_CENTRIFUGE[GTValues.HV].getStackForm(), 'I', "gearTalonite", 'T', "plateRedSteel");
        if (GRConfig.multiblocks.Orewash)
            ModHandler.addShapedRecipe("multiblock_industrial_orewasher", GRTileEntities.INDUSTRIAL_OREWASHER.getStackForm(), "TWT", "MCM", "TIT", 'M', "plateTalonite", 'I', "circuitMaster", 'C', MetaTileEntities.ORE_WASHER[GTValues.HV].getStackForm(), 'W', MetaItems.ELECTRIC_PUMP_EV, 'T', "plateBlueSteel");
        if (GRConfig.multiblocks.Electrolyzer)
            ModHandler.addShapedRecipe("multiblock_industrial_electrolyzer", GRTileEntities.INDUSTRIAL_ELECTROLYZER.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.ELECTROLYZER[GTValues.HV].getStackForm(), 'W', "circuitMaster", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "platePotin");
        if (GRConfig.multiblocks.Centrifuge)
            ModHandler.addShapedRecipe("multiblock_industrial_centrifuge", GRTileEntities.INDUSTRIAL_CENTRIFUGE.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.CENTRIFUGE[GTValues.HV].getStackForm(), 'W', "circuitMaster", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateInconel690");
        if (GRConfig.multiblocks.Fisher)
            ModHandler.addShapedRecipe("multiblock_industrial_fisher", GRTileEntities.INDUSTRIAL_FISHER.getStackForm(), "TWT", "MCM", "TWT", 'M', "wireFineElectrum", 'W', "circuitAdvanced", 'C', "rotorStellite", 'T', "plateInconel792");
        if (GRConfig.multiblocks.Wiremill)
            ModHandler.addShapedRecipe("multiblock_industrial_wiremill", GRTileEntities.INDUSTRIAL_WIREMILL.getStackForm(), "TCT", "MSM", "TCT", 'S', MetaTileEntities.WIREMILL[GTValues.HV].getStackForm(), 'M', "circuitMaster", 'C', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateTalonite");
        if (GRConfig.multiblocks.Sifter)
            ModHandler.addShapedRecipe("multiblock_industrial_sifter", GRTileEntities.INDUSTRIAL_SIFTER.getStackForm(), "TCT", "WSW", "TCT", 'W', "cableGtQuadrupleCopper", 'C', "circuitMaster", 'S', MetaTileEntities.SIFTER[GTValues.HV].getStackForm(), 'T', "plateEglinSteel");
        if (GRConfig.misc.CircuitOverhaul)
        {
            ModHandler.addShapedRecipe("multiblock_industrial_chemicalreactor", GRTileEntities.INDUSTRIAL_CHEMICALREACTOR.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.CHEMICAL_REACTOR[GTValues.HV].getStackForm(), 'W', "circuitElite", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'T', "platePolytetrafluorethylene");
            ModHandler.addShapedRecipe("multiblock_industrial_cutter", GRTileEntities.INDUSTRIAL_CUTTER.getStackForm(), "PPP", "CMC", "WCW", 'M', MetaTileEntities.CUTTER[GTValues.MV].getStackForm(), 'C', "circuitAdvanced", 'W', OreDictUnifier.get(OrePrefix.cableGtDouble, Materials.Silver), 'P', "plateBlackSteel");
            ModHandler.addShapedRecipe("multiblock_industrial_laser", GRTileEntities.INDUSTRIAL_LASER.getStackForm(), "PPP", "CMC", "WCW", 'M', MetaTileEntities.LASER_ENGRAVER[GTValues.MV].getStackForm(), 'C', "circuitAdvanced", 'W', OreDictUnifier.get(OrePrefix.cableGtDouble, Materials.Silver), 'P', "plateBlueSteel");
        }

        if (GRConfig.multiblocks.OilRig)
        {
            ModHandler.addShapedRecipe("multiblock_oil_rig", GRTileEntities.OIL_RIG.getStackForm(), "FFF", "ACA", "MMM", 'F', "frameGtSteel", 'A', "circuitGood", 'C', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'M', MetaItems.ELECTRIC_MOTOR_MV.getStackForm());
            ItemStack output = ((ToolMetaItem<?>.MetaToolValueItem) GRMetaItems.OIL_SCANNER).getStackForm(Materials.StainlessSteel, 1);
            ModHandler.addShapedRecipe(String.format("oil_scanner_%s", Materials.StainlessSteel.toString()), output,
                    "  E", "CTC", "XBX", 'E', MetaItems.SENSOR_HV.getStackForm(),
                    'C', "circuitExtreme", 'T', new ItemStack(Blocks.GLASS_PANE),
                    'B', MetaItems.BATTERY_RE_HV_LITHIUM.getStackForm(),
                    'X', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel));
        }


        //Just for show
        GRRecipeMaps.INDUSTRIAL_FISHER.recipeBuilder()
                .circuitMeta(1)
                .outputs(new ItemStack(Items.FISH, 14, 0), new ItemStack(Items.FISH, 10, 1), new ItemStack(Items.FISH, 7, 2), new ItemStack(Items.FISH, 4, 3))
                .EUt(10)
                .duration(6000)
                .buildAndRegister();

    }

    public static <T extends MetaTileEntity> void registerMachineRecipe(T[] metaTileEntities, boolean circuitUp, Object... recipe)
    {
        for (int i = 0; i < metaTileEntities.length; i++)
        {
            if (metaTileEntities[i] != null)
                ModHandler.addShapedRecipe(String.format(GTRevolution.MODID + ":%s", metaTileEntities[i].getMetaName()), metaTileEntities[i].getStackForm(), prepareRecipe(i + 1, circuitUp, Arrays.copyOf(recipe, recipe.length)));
        }
    }

    private static Object[] prepareRecipe(int tier, boolean circuitUp, Object... recipe)
    {
        for (int i = 3; i < recipe.length; i++)
        {
            if (recipe[i] instanceof GRCraftingComponents)
            {
                if (circuitUp && recipe[i] == GRCraftingComponents.CIRCUIT)
                    recipe[i] = ((GRCraftingComponents) recipe[i]).getIngredient(tier + 1);
                else
                    recipe[i] = ((GRCraftingComponents) recipe[i]).getIngredient(tier);
            }
        }
        return recipe;
    }
}
