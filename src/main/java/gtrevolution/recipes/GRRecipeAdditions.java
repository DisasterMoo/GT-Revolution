package gtrevolution.recipes;

import java.util.*;

import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.machines.GATileEntities;
import gregicadditions.recipes.GARecipeMaps;
import gregtech.api.GTValues;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.*;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.ingredients.IntCircuitIngredient;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.IngotMaterial;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.api.util.EnumValidationResult;
import gregtech.api.util.ValidationResult;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gtrevolution.GRConfig;
import gtrevolution.GRMaterials;
import gtrevolution.block.GRMetaBlocks;
import gtrevolution.block.GRMultiblockCasing;
import gtrevolution.item.GRMetaItems;
import gtrevolution.machines.GRTileEntities;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType.*;
import static gregtech.common.blocks.BlockFireboxCasing.FireboxCasingType.*;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.*;
import static gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.*;
import static gregtech.common.blocks.BlockTurbineCasing.TurbineCasingType.*;
import static gtrevolution.recipes.GRCraftingComponents.*;

public class GRRecipeAdditions
{

    public static void init() {     	
    	//Casing Recipes
		int casingNumber = GRConfig.misc.HarderCasings ? 1 : 3;
    	ModHandler.addShapedRecipe("maceration_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.MACERATION_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "platePalladium", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("washplant_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.WASHPLANT_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateBlueSteel", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("thermal_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.THERMAL_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateRedSteel", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("chemical_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.CHEMICAL_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "platePolytetrafluoroethylene", 'H', gregtech.common.blocks.MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.STEEL_SOLID, 1));
    	ModHandler.addShapedRecipe("fisher_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.FISHER_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateInconel792", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("electrolyzer_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.ELECTROLYZER_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "platePotin", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("centrifuge_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.CENTRIFUGE_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateInconel690", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("wire_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.WIRE_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateTalonite", 'H', "frameGtStaballoy");
    	ModHandler.addShapedRecipe("sieve_casing", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.SIEVE_CASING, casingNumber), "PhP", "PHP", "PwP", 'P', "plateEglinSteel", 'H', "frameGtBlueSteel");
    	ModHandler.addShapedRecipe("sieve_grate", GRMetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRMultiblockCasing.CasingType.SIEVE_GRATE, casingNumber), "TPT", "WHW", "TWT", 'P', MetaItems.ITEM_FILTER.getStackForm(), 'T', "plateBlackSteel", 'W', "wireFineSteel", 'H', "frameGtSteel");
        
		if(GRConfig.multiblocks.EBF) {
			ModHandler.removeRecipes(MetaTileEntities.ELECTRIC_BLAST_FURNACE.getStackForm());
			ModHandler.addShapedRecipe("improved_blast_furnace", GRTileEntities.BLAST_FURNACE.getStackForm(), "FFF", "CHC", "WCW", 'F', new ItemStack(Blocks.FURNACE, 1), 'C', "circuitBasic", 'H', gregtech.common.blocks.MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.INVAR_HEATPROOF, 1), 'W', "cableGtSingleTin");
		}
		
		//Industrial Machine Controllers recipes
		if(GRConfig.multiblocks.Macerator)ModHandler.addShapedRecipe("multiblock_industrial_macerator", GRTileEntities.INDUSTRIAL_MACERATOR.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.MACERATOR[GTValues.HV].getStackForm(), 'C', "circuitMaster", 'W', MetaItems.COMPONENT_GRINDER_TUNGSTEN.getStackForm(), 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateTungstenCarbide");
		if(GRConfig.multiblocks.Thermal)ModHandler.addShapedRecipe("multiblock_industrial_thermalcentrifuge", GRTileEntities.INDUSTRIAL_THERMALCENTRIFUGE.getStackForm(), "TWT", "MCM", "TIT", 'M', "stickTalonite", 'W', "circuitMaster", 'C', MetaTileEntities.THERMAL_CENTRIFUGE[GTValues.HV].getStackForm(), 'I', "gearTalonite", 'T', "plateRedSteel");
		if(GRConfig.multiblocks.Orewash)ModHandler.addShapedRecipe("multiblock_industrial_orewasher", GRTileEntities.INDUSTRIAL_OREWASHER.getStackForm(), "TWT", "MCM", "TIT", 'M', "plateTalonite", 'I', "circuitMaster", 'C', MetaTileEntities.ORE_WASHER[GTValues.HV].getStackForm(), 'W', MetaItems.ELECTRIC_PUMP_EV, 'T', "plateBlueSteel");
		if(GRConfig.multiblocks.Electrolyzer)ModHandler.addShapedRecipe("multiblock_industrial_electrolyzer", GRTileEntities.INDUSTRIAL_ELECTROLYZER.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.ELECTROLYZER[GTValues.HV].getStackForm(), 'W', "circuitMaster", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "platePotin");
		if(GRConfig.multiblocks.Centrifuge)ModHandler.addShapedRecipe("multiblock_industrial_centrifuge", GRTileEntities.INDUSTRIAL_CENTRIFUGE.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.CENTRIFUGE[GTValues.HV].getStackForm(), 'W', "circuitMaster", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateInconel690");
		if(GRConfig.multiblocks.Fisher)ModHandler.addShapedRecipe("multiblock_industrial_fisher", GRTileEntities.INDUSTRIAL_FISHER.getStackForm(), "TWT", "MCM", "TWT", 'M', "wireFineElectrum", 'W', "circuitAdvanced", 'C', "rotorStellite", 'T', "plateInconel792");
		if(GRConfig.multiblocks.Wiremill)ModHandler.addShapedRecipe("multiblock_industrial_wiremill", GRTileEntities.INDUSTRIAL_WIREMILL.getStackForm(), "TCT", "MSM", "TCT", 'S', MetaTileEntities.WIREMILL[GTValues.HV].getStackForm(), 'M', "circuitMaster", 'C', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'T', "plateTalonite");
		if(GRConfig.multiblocks.Sifter)ModHandler.addShapedRecipe("multiblock_industrial_sifter", GRTileEntities.INDUSTRIAL_SIFTER.getStackForm(), "TCT", "WSW", "TCT", 'W', "cableGtQuadrupleCopper", 'C', "circuitMaster", 'S', MetaTileEntities.SIFTER[GTValues.HV].getStackForm(), 'T', "plateEglinSteel");
		if(GRConfig.misc.CircuitOverhaul){
			ModHandler.addShapedRecipe("multiblock_industrial_chemicalreactor", GRTileEntities.INDUSTRIAL_CHEMICALREACTOR.getStackForm(), "TWT", "MCM", "TIT", 'M', MetaTileEntities.CHEMICAL_REACTOR[GTValues.HV].getStackForm(), 'W', "circuitElite", 'C', "rotorStellite", 'I', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'T', "platePolytetrafluorethylene");
			//TODO Casings + Shapes + Recipe for industrial laser + cutter
			//TODO Era bom mudar o estilo das maquinas industriais para algo mais interessante
		}

		if(GRConfig.multiblocks.OilRig){
			ModHandler.addShapedRecipe("multiblock_oil_rig", GRTileEntities.OIL_RIG.getStackForm(), "FFF", "ACA", "MMM", 'F', "frameGtSteel", 'A', "circuitGood", 'C', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'M', MetaItems.ELECTRIC_MOTOR_MV.getStackForm());
			Material material = Materials.StainlessSteel;
			ItemStack output = ((ToolMetaItem<?>.MetaToolValueItem) GRMetaItems.OIL_SCANNER).getStackForm(Materials.StainlessSteel, 1);
			ModHandler.addShapedRecipe(String.format("oil_scanner_%s", Materials.StainlessSteel.toString()), output,
					"  E", "CTC", "XBX", 'E', new ItemStack(Blocks.GLASS_PANE),
					'C', "circuitAdvanced", 'T', MetaItems.COVER_SCREEN.getStackForm(),
					'B', MetaItems.BATTERY_RE_HV_LITHIUM.getStackForm(),
					'X', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel));
		}



		//Disassembler recipes
		registerMachineRecipe(GRTileEntities.DISASSEMBLER, true, "RCR", "RHR", "GCG",
				'H', HULL, 'C', CIRCUIT, 'R', ROBOT_ARM, 'G', CABLE);

    	
    	GRRecipeMaps.INDUSTRIALFISHER.recipeBuilder()
											        .circuitMeta(1)
											        .outputs(new ItemStack(Items.FISH, 14, 0), new ItemStack(Items.FISH, 10, 1), new ItemStack(Items.FISH, 7, 2),  new ItemStack(Items.FISH, 4, 3))
											        .EUt(10)
											        .duration(6000)
											        .buildAndRegister();
    	
    	
    	//Machine Recipes
		for (OrePrefix Prefix : Arrays.asList(OrePrefix.dust, OrePrefix.dustSmall, OrePrefix.dustTiny))
		{
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (500L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Lead, 2).input(Prefix, Materials.Bronze, 2).input(Prefix, Materials.Tin, 1).outputs(OreDictUnifier.getDust(GRMaterials.Potin, 5L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (600L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Nickel, 2).input(Prefix, Materials.Niobium, 1).input(Prefix, Materials.Aluminium, 2).input(Prefix, Materials.Nichrome, 1).outputs(OreDictUnifier.getDust(GRMaterials.Inconel792, 6L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (800L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Chrome, 1).input(Prefix, Materials.Niobium, 2).input(Prefix, Materials.Molybdenum, 2).input(Prefix, Materials.Nichrome, 3).outputs(OreDictUnifier.getDust(GRMaterials.Inconel690, 8L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1000L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, Materials.Uranium, 9).input(Prefix, Materials.Titanium, 1).outputs(OreDictUnifier.getDust(GRMaterials.Staballoy, 10L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1100L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, GRMaterials.Tantalloy60, 1).input(Prefix, Materials.Titanium, 6).input(Prefix, Materials.Yttrium, 4).outputs(OreDictUnifier.getDust(GRMaterials.Tantalloy61, 11L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (2500L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, Materials.Tungsten, 2).input(Prefix, Materials.Tantalum, 23).outputs(OreDictUnifier.getDust(GRMaterials.Tantalloy60, 25L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1800L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Cobalt, 7).input(Prefix, Materials.Chrome, 7).input(Prefix, Materials.Manganese, 2).input(Prefix, Materials.Titanium, 2).outputs(OreDictUnifier.getDust(GRMaterials.Stellite, 18L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1100L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Cobalt, 4).input(Prefix, Materials.Chrome, 4).input(Prefix, Materials.Phosphor, 2).input(Prefix, Materials.Molybdenum, 1).outputs(OreDictUnifier.getDust(GRMaterials.Talonite, 11L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1000L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, Materials.Iron, 4).input(Prefix, Materials.Kanthal, 1).input(Prefix, Materials.Invar, 5).outputs(OreDictUnifier.getDust(GRMaterials.EglinBase, 10L * Prefix.materialAmount)).buildAndRegister();
			RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1600L * Prefix.materialAmount / 3628800L)).EUt(30).input(Prefix, GRMaterials.EglinBase, 10).input(Prefix, Materials.Sulfur, 1).input(Prefix, Materials.Silicon, 4).input(Prefix, Materials.Carbon, 1).outputs(OreDictUnifier.getDust(GRMaterials.EglinSteel, 16L * Prefix.materialAmount)).buildAndRegister();

			if(GRConfig.misc.Superconductors) {
				RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (300L * Prefix.materialAmount / 3628800L)).EUt(8).input(Prefix, Materials.Redstone, 1).input(Prefix, Materials.Silicon, 1).input(Prefix, Materials.Tin, 1).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[0], 3L * Prefix.materialAmount)).buildAndRegister();
				RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (600L * Prefix.materialAmount / 3628800L)).EUt(24).input(Prefix, Materials.Cadmium, 5).input(Prefix, Materials.Magnesium, 1).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[1], 6L * Prefix.materialAmount)).buildAndRegister();
				RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (4000L * Prefix.materialAmount / 3628800L)).EUt(120).input(Prefix, Materials.Titanium, 1).input(Prefix, Materials.Barium, 9).input(Prefix, Materials.Copper, 10).fluidInputs(Materials.Oxygen.getFluid(20000)).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[2], 40L * Prefix.materialAmount)).buildAndRegister();
				RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (400L * Prefix.materialAmount / 3628800L)).EUt(480).input(Prefix, Materials.Platinum, 3).input(Prefix, Materials.Uranium, 1).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[3], 4L * Prefix.materialAmount)).buildAndRegister();
				RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (400L * Prefix.materialAmount / 3628800L)).EUt(1920).input(Prefix, Materials.Vanadium, 1).input(Prefix, Materials.Indium, 3).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[4], 4L * Prefix.materialAmount)).buildAndRegister();
				RecipeMaps.MIXER_RECIPES.recipeBuilder().duration((int) (1400L * Prefix.materialAmount / 3628800L)).EUt(7680).input(Prefix, Materials.Titanium, 1).input(Prefix, Materials.Barium, 2).input(Prefix, Materials.Copper, 7).input(Prefix, Materials.Indium, 4).outputs(OreDictUnifier.getDust(GRMaterials.SuperConductor[5], 14L * Prefix.materialAmount)).buildAndRegister();
			}

		}

		for (Material m : Material.MATERIAL_REGISTRY) {
			if(m.hasFlag(IngotMaterial.MatFlags.GENERATE_ROTOR)){
				RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
						.duration((int) (m.getAverageMass() * 5))
						.EUt(6 * getVoltageMultiplier(m))
						.notConsumable(GRMetaItems.SHAPE_EXTRUDER_ROTOR)
						.input(OrePrefix.ingot, m, 5)
						.outputs(OreDictUnifier.get(OrePrefix.rotor, m))
						.buildAndRegister();
			}
			if(m.hasFlag(IngotMaterial.MatFlags.GENERATE_SMALL_GEAR)){
				RecipeMaps.EXTRUDER_RECIPES.recipeBuilder()
						.duration((int) (m.getAverageMass()))
						.EUt(6 * getVoltageMultiplier(m))
						.notConsumable(GRMetaItems.SHAPE_EXTRUDER_SMALLGEAR)
						.input(OrePrefix.ingot, m, 1)
						.outputs(OreDictUnifier.get(OrePrefix.gearSmall, m))
						.buildAndRegister();
				if(GRConfig.misc.HarderSmallGears){
					ModHandler.removeRecipes(OreDictUnifier.get(OrePrefix.gearSmall, m));
					ModHandler.addShapedRecipe(String.format("gr_smallgear_%s", m.toString()), OreDictUnifier.get(OrePrefix.gearSmall, m), " R ", "hPx", " R ", 'P', OreDictUnifier.get(OrePrefix.plate, m), 'R', OreDictUnifier.get(OrePrefix.stick, m));
					Recipe recipe = RecipeMaps.FORGE_HAMMER_RECIPES.findRecipe(6, Collections.singletonList(OreDictUnifier.get(OrePrefix.plate, m)), Collections.emptyList(), 0);
					RecipeMaps.FORGE_HAMMER_RECIPES.removeRecipe(recipe);
				}
			}
		}

		if(GRConfig.misc.HarderCasings)
		{
			UnregisterCasings();
			RegisterHarderCasings();
		}

		if(GRConfig.misc.HarderCables)
		{
			List<Recipe> recipesRemove = new ArrayList<>();
			for(Recipe recipe : RecipeMaps.ASSEMBLER_RECIPES.getRecipeList())
			{
				for(FluidStack fluid : recipe.getFluidInputs()){
					if(fluid.getFluid() == Materials.Rubber.getMaterialFluid()){
						for(ItemStack stack : recipe.getOutputs()){
							Material mat = MetaBlocks.CABLE.getItemMaterial(stack);
							if(mat instanceof IngotMaterial
									&& ((IngotMaterial)mat).cableProperties != null
									&& ((IngotMaterial)mat).cableProperties.voltage > 2048)
							{
								recipesRemove.add(recipe);
								break;
							}
						}
					}
				}
			}
			for(Recipe recipe: recipesRemove)RecipeMaps.ASSEMBLER_RECIPES.removeRecipe(recipe);
			recipesRemove.clear();
		}

		//Why GTCE won't let we craft tin and red alloy cables from rubber?
		for(Material material : Arrays.asList(Materials.RedAlloy, Materials.Tin))
			for(OrePrefix wirePrefix : Arrays.asList(OrePrefix.wireGtSingle, OrePrefix.wireGtDouble, OrePrefix.wireGtQuadruple, OrePrefix.wireGtOctal))
			{
				int cableAmount = (int) (wirePrefix.materialAmount * 2 / GTValues.M);
				OrePrefix cablePrefix = OrePrefix.valueOf("cable" + wirePrefix.name().substring(4));
				ItemStack cableStack = OreDictUnifier.get(cablePrefix, material);
				RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
						.input(wirePrefix, material).circuitMeta(24)
						.fluidInputs(Materials.Rubber.getFluid(144 * cableAmount))
						.outputs(cableStack)
						.duration(150).EUt(8)
						.buildAndRegister();
			}


		if(GRConfig.misc.HarderFuelCracking)
		{
			UnregisterCrackingRecipes();
			RegisterCrackingRecipes();
		}

		if(GRConfig.misc.CircuitOverhaul)
		{
			//Copy all recipes to industrial machines
			RecipeMaps.CHEMICAL_RECIPES.getRecipeList().forEach( recipe ->
				GRRecipeMaps.INDUSTRIAL_CHEMICAL_REACTOR.addRecipe(new ValidationResult<>(EnumValidationResult.VALID, recipe))
			);
			RecipeMaps.LASER_ENGRAVER_RECIPES.getRecipeList().forEach( recipe ->
				GRRecipeMaps.INDUSTRIAL_LASER.addRecipe(new ValidationResult<>(EnumValidationResult.VALID, recipe))
			);
			RecipeMaps.CUTTER_RECIPES.getRecipeList().forEach( recipe ->
				GRRecipeMaps.INDUSTRIAL_CUTTER.addRecipe(new ValidationResult<>(EnumValidationResult.VALID, recipe))
			);

			//Remove all recipes that must be made in industrial machinery
			List<Recipe> recipesRemove = new ArrayList<>();
			for(Recipe recipe : RecipeMaps.LASER_ENGRAVER_RECIPES.getRecipeList())
			{
				for(ItemStack stack : recipe.getOutputs()){
					if(isOverhaulNeeded(stack)){
						recipesRemove.add(recipe);
						break;
					}
				}
			}
			for(Recipe recipe: recipesRemove)RecipeMaps.LASER_ENGRAVER_RECIPES.removeRecipe(recipe);
			recipesRemove.clear();

			for(Recipe recipe : RecipeMaps.CUTTER_RECIPES.getRecipeList())
			{
				for(ItemStack stack : recipe.getOutputs()){
					if(isOverhaulNeeded(stack)){
						recipesRemove.add(recipe);
						break;
					}
				}
			}
			for(Recipe recipe: recipesRemove)RecipeMaps.CUTTER_RECIPES.removeRecipe(recipe);
			recipesRemove.clear();

			for(Recipe recipe : RecipeMaps.CHEMICAL_RECIPES.getRecipeList())
			{
				for(ItemStack stack : recipe.getOutputs()){
					if(isOverhaulNeeded(stack)){
						recipesRemove.add(recipe);
						break;
					}
				}
			}
			for(Recipe recipe: recipesRemove)RecipeMaps.CHEMICAL_RECIPES.removeRecipe(recipe);
			recipesRemove.clear();

			for(Recipe recipe : RecipeMaps.ASSEMBLER_RECIPES.getRecipeList())
			{
				for(ItemStack stack : recipe.getOutputs()){
					if(isOverhaulNeeded(stack)){

						recipesRemove.add(recipe);
						break;
					}
				}
			}
			for(Recipe recipe: recipesRemove)RecipeMaps.ASSEMBLER_RECIPES.removeRecipe(recipe);
			recipesRemove.clear();

			for(Recipe recipe : RecipeMaps.BLAST_RECIPES.getRecipeList())
			{
				for(ItemStack stack : recipe.getOutputs()){
					if(isOverhaulNeeded(stack)){
						recipesRemove.add(recipe);
						break;
					}
				}
			}
			for(Recipe recipe: recipesRemove)RecipeMaps.BLAST_RECIPES.removeRecipe(recipe);
			recipesRemove.clear();

			//Unregistering from industrial
			for(Recipe recipe : GRRecipeMaps.INDUSTRIAL_LASER.getRecipeList())
			{
				for(ItemStack stack : recipe.getOutputs()){
					if(stack.isItemEqual(MetaItems.SYSTEM_ON_CHIP_WAFER.getStackForm())){
						recipesRemove.add(recipe);
						break;
					}
				}
			}
			for(Recipe recipe: recipesRemove)GRRecipeMaps.INDUSTRIAL_LASER.removeRecipe(recipe);
			recipesRemove.clear();

			for(Recipe recipe : GRRecipeMaps.INDUSTRIAL_CHEMICAL_REACTOR.getRecipeList())
			{
				for(ItemStack stack : recipe.getOutputs()){
					if(stack.isItemEqual(MetaItems.PLASTIC_BOARD.getStackForm()) ||
							stack.isItemEqual(MetaItems.EPOXY_BOARD.getStackForm()) ||
							stack.isItemEqual(MetaItems.FIBER_BOARD.getStackForm()) ||
							stack.isItemEqual(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm()) ||
							stack.isItemEqual(MetaItems.WETWARE_BOARD.getStackForm())){
						recipesRemove.add(recipe);
						break;
					}
				}
			}
			for(Recipe recipe: recipesRemove)GRRecipeMaps.INDUSTRIAL_CHEMICAL_REACTOR.removeRecipe(recipe);
			recipesRemove.clear();

			//Overhaul assembling machine recipe
			ModHandler.removeRecipes(MetaTileEntities.ASSEMBLER[0].getStackForm());
			ModHandler.removeRecipes(MetaTileEntities.ASSEMBLER[1].getStackForm());
			ModHandler.removeRecipes(MetaTileEntities.ASSEMBLER[2].getStackForm());
			ModHandler.removeRecipes(MetaTileEntities.ASSEMBLER[3].getStackForm());
			ModHandler.removeRecipes(MetaTileEntities.ASSEMBLER[4].getStackForm());
			ModHandler.removeRecipes(GATileEntities.ASSEMBLER[5].getStackForm());
			ModHandler.removeRecipes(GATileEntities.ASSEMBLER[6].getStackForm());
			ModHandler.removeRecipes(GATileEntities.ASSEMBLER[7].getStackForm());
			ModHandler.removeRecipes(MetaItems.RESISTOR.getStackForm(3));
			ModHandler.removeRecipes(MetaItems.DIODE.getStackForm(4));
			ModHandler.removeRecipes(MetaItems.VACUUM_TUBE.getStackForm());

			registerMachineRecipe(MetaTileEntities.ASSEMBLER, true, "ACA", "VMV", "WCW", 'M', HULL, 'V', CONVEYOR, 'A', ROBOT_ARM, 'C', CIRCUIT, 'W', CABLE);
			registerMachineRecipe(GATileEntities.ASSEMBLER, true, "ACA", "VMV", "WCW", 'M', HULL, 'V', CONVEYOR, 'A', ROBOT_ARM, 'C', CIRCUIT, 'W', CABLE);

			RegisterBasicComponentRecipes();
			RegisterBlastRecipes();
			RegisterCircuitBoardRecipes();
			RegisterCutterRecipes();
			RegisterLaserRecipes();
			RegisterCircuitRecipes();

		}
   }

	private static <T extends MetaTileEntity> void registerMachineRecipe(T[] metaTileEntities, boolean circuitUp, Object... recipe) {
	for (int i = 0; i < metaTileEntities.length; i++) {
		if (metaTileEntities[i] != null) ModHandler.addShapedRecipe(String.format("gr_%s", metaTileEntities[i].getMetaName()), metaTileEntities[i].getStackForm(), prepareRecipe(i + 1, circuitUp, Arrays.copyOf(recipe, recipe.length)));
	}
}

	private static Object[] prepareRecipe(int tier, boolean circuitUp, Object... recipe) {
		for (int i = 3; i < recipe.length; i++) {
			if (recipe[i] instanceof GRCraftingComponents) {
				if(circuitUp && recipe[i] == GRCraftingComponents.CIRCUIT)
					recipe[i] = ((GRCraftingComponents) recipe[i]).getIngredient(tier+1);
				else
					recipe[i] = ((GRCraftingComponents) recipe[i]).getIngredient(tier);
			}
		}
		return recipe;
	}

	private static int getVoltageMultiplier(Material material) {
    	if(material instanceof IngotMaterial){
    		IngotMaterial ingotM = ((IngotMaterial) material);
    		if(ingotM.blastFurnaceTemperature < 2800) //Stainless steel and below
    			return 8;
    		else if(ingotM.blastFurnaceTemperature < 5400) //Tungstensteel and below
				return 32;
    		else if(ingotM.blastFurnaceTemperature < 7200) //HSS-E and below
				return 128;
    		else
				return 512;
		}
    	return 8;
	}

	/**
	 * Returns true if item is from overhaul list
	 * @param stack the recipe's output stack
	 * @return true if overhaul
	 */
	private static boolean isOverhaulNeeded(ItemStack stack)
	{
		if(stack == null || stack.isEmpty())return false;

		if(stack.isItemEqual(MetaItems.GLOWSTONE_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.NAQUADAH_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.SYSTEM_ON_CHIP_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.ADVANCED_SYSTEM_ON_CHIP_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.NAND_MEMORY_CHIP_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.NOR_MEMORY_CHIP_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.CENTRAL_PROCESSING_UNIT_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.NANO_CENTRAL_PROCESSING_UNIT_WAFER.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.QBIT_CENTRAL_PROCESSING_UNIT_WAFER.getStackForm()))return true;


		if(stack.isItemEqual(MetaItems.SYSTEM_ON_CHIP.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.ADVANCED_SYSTEM_ON_CHIP.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.CRYSTAL_SYSTEM_ON_CHIP.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.POWER_INTEGRATED_CIRCUIT.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.NAND_MEMORY_CHIP.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.NOR_MEMORY_CHIP.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.CENTRAL_PROCESSING_UNIT.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.QBIT_CENTRAL_PROCESSING_UNIT.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm()))return true;

		if(stack.isItemEqual(MetaItems.PLASTIC_BOARD.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.EPOXY_BOARD.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.FIBER_BOARD.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.WETWARE_BOARD.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.TOOL_DATA_STICK.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.TOOL_DATA_ORB.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.ENERGY_LAPOTRONIC_ORB.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm()))return true;

		if(stack.isItemEqual(MetaItems.DIODE.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.RESISTOR.getStackForm()))return true;
		if(stack.isItemEqual(MetaItems.VACUUM_TUBE.getStackForm()))return true;

		if(stack.isItemEqual(MetaItems.SILICON_BOULE.getStackForm()))return true;
		if(stack.isItemEqual(OreDictUnifier.get(OrePrefix.ingot, Materials.GalliumArsenide)))return true;
		if(stack.isItemEqual(OreDictUnifier.get(OrePrefix.nugget, Materials.GalliumArsenide)))return true;

		//Harder casings?
		if(GRConfig.misc.HarderCasings)
		{
			if(stack.isItemEqual(MetaBlocks.METAL_CASING.getItemVariant(INVAR_HEATPROOF)))return true;
			if(stack.isItemEqual(MetaBlocks.METAL_CASING.getItemVariant(ALUMINIUM_FROSTPROOF)))return true;
			if(stack.isItemEqual(MetaBlocks.METAL_CASING.getItemVariant(STEEL_SOLID)))return true;
			if(stack.isItemEqual(MetaBlocks.METAL_CASING.getItemVariant(STAINLESS_CLEAN)))return true;
			if(stack.isItemEqual(MetaBlocks.METAL_CASING.getItemVariant(TITANIUM_STABLE)))return true;
			if(stack.isItemEqual(MetaBlocks.METAL_CASING.getItemVariant(TUNGSTENSTEEL_ROBUST)))return true;

			if(stack.isItemEqual(MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING)))return true;
			if(stack.isItemEqual(MetaBlocks.TURBINE_CASING.getItemVariant(TITANIUM_TURBINE_CASING)))return true;
			if(stack.isItemEqual(MetaBlocks.TURBINE_CASING.getItemVariant(STAINLESS_TURBINE_CASING)))return true;
			if(stack.isItemEqual(MetaBlocks.TURBINE_CASING.getItemVariant(TUNGSTENSTEEL_TURBINE_CASING)))return true;
		}

		//All circuit from other mods
		for(ItemStack it : OreDictionary.getOres("circuitPrimitive"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitBasic"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitGood"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitAdvanced"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitElite"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitExtreme"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitMaster"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitUltimate"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitSuperconductor"))
			if(it.isItemEqual(stack))return true;
		for(ItemStack it : OreDictionary.getOres("circuitInfinite"))
			if(it.isItemEqual(stack))return true;
		return false;
	}

	private static final MaterialStack[] solderingList = {
			new MaterialStack(Materials.Tin, 2L),
			new MaterialStack(Materials.SolderingAlloy, 1L)
	};

	private static final FluidStack[] crackingList = {
			Materials.HydroCrackedEthane.getFluid(1),
			Materials.HydroCrackedEthylene.getFluid(1),
			Materials.HydroCrackedPropene.getFluid(1),
			Materials.HydroCrackedPropane.getFluid(1),
			Materials.HydroCrackedLightFuel.getFluid(1),
			Materials.HydroCrackedButane.getFluid(1),
			Materials.HydroCrackedNaphtha.getFluid(1),
			Materials.HydroCrackedHeavyFuel.getFluid(1),
			Materials.HydroCrackedGas.getFluid(1),
			Materials.HydroCrackedButene.getFluid(1),
			Materials.HydroCrackedButadiene.getFluid(1),
			Materials.SteamCrackedEthane.getFluid(1),
			Materials.SteamCrackedEthylene.getFluid(1),
			Materials.SteamCrackedPropene.getFluid(1),
			Materials.SteamCrackedPropane.getFluid(1),
			Materials.CrackedLightFuel.getFluid(1),
			Materials.SteamCrackedButane.getFluid(1),
			Materials.SteamCrackedNaphtha.getFluid(1),
			Materials.CrackedHeavyFuel.getFluid(1),
			Materials.SteamCrackedGas.getFluid(1),
			Materials.SteamCrackedButene.getFluid(1),
			Materials.SteamCrackedButadiene.getFluid(1)
	};

	private static void UnregisterCrackingRecipes()
	{
		List<Recipe> recipesRemove = new ArrayList<>();
		for(Recipe recipe : RecipeMaps.CHEMICAL_RECIPES.getRecipeList())
		{
			for(FluidStack fluid : recipe.getFluidOutputs())
			{
				for(FluidStack compare : crackingList)
				{
					if(fluid.isFluidEqual(compare)){
						recipesRemove.add(recipe);
						break;
					}
				}
			}
		}
		for(Recipe recipe: recipesRemove)RecipeMaps.CHEMICAL_RECIPES.removeRecipe(recipe);
		recipesRemove.clear();
	}

	private static void RegisterCrackingRecipes()
	{
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Ethane.getFluid(1000)).fluidOutputs(Materials.HydroCrackedEthane.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Ethylene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedEthylene.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Propene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedPropene.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Propane.getFluid(1000)).fluidOutputs(Materials.HydroCrackedPropane.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.LightFuel.getFluid(1000)).fluidOutputs(Materials.HydroCrackedLightFuel.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Butane.getFluid(1000)).fluidOutputs(Materials.HydroCrackedButane.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Naphtha.getFluid(1000)).fluidOutputs(Materials.HydroCrackedNaphtha.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.HeavyFuel.getFluid(1000)).fluidOutputs(Materials.HydroCrackedHeavyFuel.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Gas.getFluid(1000)).fluidOutputs(Materials.HydroCrackedGas.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Butene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedButene.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Hydrogen.getFluid(2000), Materials.Butadiene.getFluid(1000)).fluidOutputs(Materials.HydroCrackedButadiene.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Ethane.getFluid(1000)).fluidOutputs(Materials.SteamCrackedEthane.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Ethylene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedEthylene.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Propene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedPropene.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Propane.getFluid(1000)).fluidOutputs(Materials.SteamCrackedPropane.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.LightFuel.getFluid(1000)).fluidOutputs(Materials.CrackedLightFuel.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Butane.getFluid(1000)).fluidOutputs(Materials.SteamCrackedButane.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Naphtha.getFluid(1000)).fluidOutputs(Materials.SteamCrackedNaphtha.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.HeavyFuel.getFluid(1000)).fluidOutputs(Materials.CrackedHeavyFuel.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Gas.getFluid(1000)).fluidOutputs(Materials.SteamCrackedGas.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Butene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedButene.getFluid(800)).buildAndRegister();
		RecipeMaps.CHEMICAL_RECIPES.recipeBuilder().duration(320).EUt(30).fluidInputs(Materials.Steam.getFluid(2000), Materials.Butadiene.getFluid(1000)).fluidOutputs(Materials.SteamCrackedButadiene.getFluid(800)).buildAndRegister();
	}

	private static void UnregisterCasings()
	{
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_bronze_bricks"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_steel_solid"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_titanium_stable"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_invar_heatproof"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_aluminium_frostproof"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_stainless_clean"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_tungstensteel_robust"));

		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_steel_turbine_casing"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_stainless_turbine_casing"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_titanium_turbine_casing"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_tungstensteel_turbine_casing"));

		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_bronze_pipe"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_steel_pipe"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_titanium_pipe"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_tungstensteel_pipe"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_bronze_firebox"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_steel_firebox"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_titanium_firebox"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_tungstensteel_firebox"));

		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_bronze_gearbox"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_steel_gearbox"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_titanium_gearbox"));

		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_grate_casing"));
		ModHandler.removeRecipeByName(new ResourceLocation("gregtech:casing_assembler_casing"));

		ModHandler.removeRecipeByName(new ResourceLocation("gtadditions:assline_casing"));
		ModHandler.removeRecipeByName(new ResourceLocation("gtadditions:ga_assmbler_casing"));
	}

	private static void RegisterHarderCasings()
	{
		ModHandler.addShapedRecipe("casing_bronze_bricks", MetaBlocks.METAL_CASING.getItemVariant(BRONZE_BRICKS), "PhP", "PBP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'B', new ItemStack(Blocks.BRICK_BLOCK, 1));
		ModHandler.addShapedRecipe("casing_steel_solid", MetaBlocks.METAL_CASING.getItemVariant(STEEL_SOLID), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel));
		ModHandler.addShapedRecipe("casing_titanium_stable", MetaBlocks.METAL_CASING.getItemVariant(TITANIUM_STABLE), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium));
		ModHandler.addShapedRecipe("casing_invar_heatproof", MetaBlocks.METAL_CASING.getItemVariant(INVAR_HEATPROOF), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Invar), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Invar));
		ModHandler.addShapedRecipe("casing_aluminium_frostproof", MetaBlocks.METAL_CASING.getItemVariant(ALUMINIUM_FROSTPROOF), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Aluminium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Aluminium));
		ModHandler.addShapedRecipe("casing_stainless_clean", MetaBlocks.METAL_CASING.getItemVariant(STAINLESS_CLEAN), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.StainlessSteel));
		ModHandler.addShapedRecipe("casing_tungstensteel_robust", MetaBlocks.METAL_CASING.getItemVariant(TUNGSTENSTEEL_ROBUST), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel));

		ModHandler.addShapedRecipe("casing_steel_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Magnalium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.BlueSteel));
		ModHandler.addShapedRecipe("casing_stainless_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(STAINLESS_TURBINE_CASING), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel), 'F', MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING));
		ModHandler.addShapedRecipe("casing_titanium_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(TITANIUM_TURBINE_CASING), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING));
		ModHandler.addShapedRecipe("casing_tungstensteel_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(TUNGSTENSTEEL_TURBINE_CASING), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING));

		ModHandler.addShapedRecipe("casing_bronze_pipe", MetaBlocks.BOILER_CASING.getItemVariant(BRONZE_PIPE), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Bronze), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.Bronze));
		ModHandler.addShapedRecipe("casing_steel_pipe", MetaBlocks.BOILER_CASING.getItemVariant(STEEL_PIPE), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.Steel));
		ModHandler.addShapedRecipe("casing_titanium_pipe", MetaBlocks.BOILER_CASING.getItemVariant(TITANIUM_PIPE), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.Titanium));
		ModHandler.addShapedRecipe("casing_tungstensteel_pipe", MetaBlocks.BOILER_CASING.getItemVariant(TUNGSTENSTEEL_PIPE), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.TungstenSteel));

		ModHandler.addShapedRecipe("casing_bronze_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(BRONZE_FIREBOX), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Bronze), 'S', new UnificationEntry(OrePrefix.stick, Materials.Bronze));
		ModHandler.addShapedRecipe("casing_steel_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(STEEL_FIREBOX), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'S', new UnificationEntry(OrePrefix.stick, Materials.Steel));
		ModHandler.addShapedRecipe("casing_titanium_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(TITANIUM_FIREBOX), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium), 'S', new UnificationEntry(OrePrefix.stick, Materials.Titanium));
		ModHandler.addShapedRecipe("casing_tungstensteel_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(TUNGSTENSTEEL_FIREBOX), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel), 'S', new UnificationEntry(OrePrefix.stick, Materials.TungstenSteel));

		ModHandler.addShapedRecipe("casing_bronze_gearbox", MetaBlocks.TURBINE_CASING.getItemVariant(BRONZE_GEARBOX), "PhP", "GFG", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Bronze), 'G', new UnificationEntry(OrePrefix.gear, Materials.Bronze));
		ModHandler.addShapedRecipe("casing_steel_gearbox", MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_GEARBOX), "PhP", "GFG", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'G', new UnificationEntry(OrePrefix.gear, Materials.Steel));
		ModHandler.addShapedRecipe("casing_titanium_gearbox", MetaBlocks.TURBINE_CASING.getItemVariant(TITANIUM_GEARBOX), "PhP", "GFG", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium), 'G', new UnificationEntry(OrePrefix.gear, Materials.Titanium));

		ModHandler.addShapedRecipe("casing_grate_casing", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GRATE_CASING), "PVP", "PFP", "PMP", 'P', new ItemStack(Blocks.IRON_BARS, 1), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'M', MetaItems.ELECTRIC_MOTOR_MV, 'V', new UnificationEntry(OrePrefix.rotor, Materials.Steel));
		ModHandler.addShapedRecipe("assline_casing", GAMetaBlocks.MUTLIBLOCK_CASING.getItemVariant(GAMultiblockCasing.CasingType.TUNGSTENSTEEL_GEARBOX_CASING), "PhP", "AFA", "PwP", 'P', "plateSteel", 'A', MetaItems.ROBOT_ARM_IV.getStackForm(), 'F', OreDictUnifier.get(OrePrefix.frameGt, Materials.TungstenSteel));
		ModHandler.addShapedRecipe("gt_assmbler_casing", MetaBlocks.MUTLIBLOCK_CASING.getItemVariant(ASSEMBLER_CASING), "MUM", "MFM", "MEM", 'U', "circuitUltimate", 'M', "circuitMaster", 'F', "frameGtTungstenSteel", 'E', MetaItems.ELECTRIC_MOTOR_IV.getStackForm());
	}

	private static void RegisterBlastRecipes()
	{
		RecipeMaps.BLAST_RECIPES.recipeBuilder()
				.inputs(new CountableIngredient(new IntCircuitIngredient(0), 0))
				.inputs(OreDictUnifier.get(OrePrefix.dust, Materials.GalliumArsenide))
				.outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.GalliumArsenide))
				.blastFurnaceTemp(1200)
				.EUt(120).duration(1728)
				.buildAndRegister();

		RecipeMaps.BLAST_RECIPES.recipeBuilder()
				.inputs(new CountableIngredient(new IntCircuitIngredient(0), 0))
				.inputs(OreDictUnifier.get(OrePrefix.dustTiny, Materials.GalliumArsenide))
				.outputs(OreDictUnifier.get(OrePrefix.nugget, Materials.GalliumArsenide))
				.blastFurnaceTemp(1200)
				.EUt(120).duration(192)
				.buildAndRegister();

		RecipeMaps.BLAST_RECIPES.recipeBuilder()
				.inputs(new CountableIngredient(new IntCircuitIngredient(1), 0))
				.inputs(OreDictUnifier.get(OrePrefix.dustTiny, Materials.GalliumArsenide),
						OreDictUnifier.get(OrePrefix.dust, Materials.Silicon, 32))
				.outputs(OreDictUnifier.get(OrePrefix.ingot, Materials.GalliumArsenide))
				.blastFurnaceTemp(1784)
				.EUt(120).duration(9000)
				.buildAndRegister();
	}

	private static void RegisterCircuitBoardRecipes()
	{
		//1st Board
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(MetaItems.COATED_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Copper, 4))
				.fluidInputs(Materials.Glue.getFluid(100))
				.outputs(GRMetaItems.CIRCUIT_BOARD.getStackForm())
				.EUt(8).duration(200)
				.buildAndRegister();

		ModHandler.addShapedRecipe("circuit_board", GRMetaItems.CIRCUIT_BOARD.getStackForm(), "WWW", "WBW", "WWW", 'W', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper), 'B', MetaItems.COATED_BOARD);

		for(RecipeMap<SimpleRecipeBuilder> recipeMap : Arrays.asList(RecipeMaps.CHEMICAL_RECIPES, GRRecipeMaps.INDUSTRIAL_CHEMICAL_REACTOR))
		{
			//2nd Board
			recipeMap.recipeBuilder()
					.inputs(MetaItems.PHENOLIC_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Gold, 4))
					.fluidInputs(Materials.SodiumPersulfate.getFluid(200))
					.outputs(GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm())
					.EUt(30).duration(600)
					.buildAndRegister();

			recipeMap.recipeBuilder()
					.inputs(MetaItems.PHENOLIC_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Gold, 4))
					.fluidInputs(GRMaterials.Iron3Chloride.getFluid(100))
					.outputs(GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm())
					.EUt(30).duration(300)
					.buildAndRegister();

			//3rd Board
			recipeMap.recipeBuilder()
					.inputs(MetaItems.PLASTIC_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Copper, 6))
					.fluidInputs(Materials.SodiumPersulfate.getFluid(500))
					.outputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm())
					.EUt(30).duration(800)
					.buildAndRegister();

			recipeMap.recipeBuilder()
					.inputs(MetaItems.PLASTIC_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Copper, 6))
					.fluidInputs(GRMaterials.Iron3Chloride.getFluid(250))
					.outputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm())
					.EUt(30).duration(400)
					.buildAndRegister();

			//4th Board
			recipeMap.recipeBuilder()
					.inputs(MetaItems.EPOXY_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 8))
					.fluidInputs(Materials.SodiumPersulfate.getFluid(1000))
					.outputs(GRMetaItems.EPOXY_CIRCUIT_BOARD.getStackForm())
					.EUt(30).duration(1200)
					.buildAndRegister();

			recipeMap.recipeBuilder()
					.inputs(MetaItems.EPOXY_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 8))
					.fluidInputs(GRMaterials.Iron3Chloride.getFluid(500))
					.outputs(GRMetaItems.EPOXY_CIRCUIT_BOARD.getStackForm())
					.EUt(30).duration(600)
					.buildAndRegister();

			//5th Board
			recipeMap.recipeBuilder()
					.inputs(MetaItems.FIBER_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.AnnealedCopper, 12))
					.fluidInputs(Materials.SodiumPersulfate.getFluid(2000))
					.outputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm())
					.EUt(120).duration(1800)
					.buildAndRegister();

			recipeMap.recipeBuilder()
					.inputs(MetaItems.FIBER_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.AnnealedCopper, 12))
					.fluidInputs(GRMaterials.Iron3Chloride.getFluid(1000))
					.outputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm())
					.EUt(120).duration(900)
					.buildAndRegister();

			//6th Board
			recipeMap.recipeBuilder()
					.inputs(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 16))
					.fluidInputs(Materials.SodiumPersulfate.getFluid(4000))
					.outputs(GRMetaItems.MULTILAYER_FIBER_CIRCUIT_BOARD.getStackForm())
					.EUt(480).duration(2400)
					.buildAndRegister();

			recipeMap.recipeBuilder()
					.inputs(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 16))
					.fluidInputs(GRMaterials.Iron3Chloride.getFluid(2000))
					.outputs(GRMetaItems.MULTILAYER_FIBER_CIRCUIT_BOARD.getStackForm())
					.EUt(480).duration(1200)
					.buildAndRegister();

			//7th Board and last
			recipeMap.recipeBuilder()
					.inputs(MetaItems.WETWARE_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.NiobiumTitanium, 32))
					.fluidInputs(Materials.SodiumPersulfate.getFluid(10000))
					.outputs(GRMetaItems.WETWARE_CIRCUIT_BOARD.getStackForm())
					.EUt(1920).duration(3000)
					.buildAndRegister();

			recipeMap.recipeBuilder()
					.inputs(MetaItems.WETWARE_BOARD.getStackForm(1), OreDictUnifier.get(OrePrefix.foil, Materials.NiobiumTitanium, 32))
					.fluidInputs(GRMaterials.Iron3Chloride.getFluid(5000))
					.outputs(GRMetaItems.WETWARE_CIRCUIT_BOARD.getStackForm())
					.EUt(1920).duration(1500)
					.buildAndRegister();

			//Iron(III) Chloride
			recipeMap.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.dust, Materials.Iron, 1))
					.fluidInputs(Materials.HydrochloricAcid.getFluid(500))
					.fluidOutputs(GRMaterials.Iron3Chloride.getFluid(1000))
					.EUt(30).duration(200)
					.buildAndRegister();

			//Plastic board
			recipeMap.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.foil, Materials.Copper, 4),
							OreDictUnifier.get(OrePrefix.plate, Materials.Plastic))
					.fluidInputs(Materials.SulfuricAcid.getFluid(250))
					.outputs(MetaItems.PLASTIC_BOARD.getStackForm())
					.EUt(10).duration(500)
					.buildAndRegister();

			//Plastic board
			recipeMap.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.foil, Materials.Copper, 4),
							OreDictUnifier.get(OrePrefix.plate, Materials.PolyvinylChloride))
					.fluidInputs(Materials.SulfuricAcid.getFluid(250))
					.outputs(MetaItems.PLASTIC_BOARD.getStackForm(2))
					.EUt(10).duration(500)
					.buildAndRegister();

			//Plastic board
			recipeMap.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.foil, Materials.Copper, 4),
							OreDictUnifier.get(OrePrefix.plate, Materials.Polytetrafluoroethylene))
					.fluidInputs(Materials.SulfuricAcid.getFluid(250))
					.outputs(MetaItems.PLASTIC_BOARD.getStackForm(4))
					.EUt(10).duration(500)
					.buildAndRegister();

			//Epoxy board
			recipeMap.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.foil, Materials.Electrum, 8),
							OreDictUnifier.get(OrePrefix.plate, Materials.Epoxid))
					.fluidInputs(Materials.SulfuricAcid.getFluid(500))
					.outputs(MetaItems.EPOXY_BOARD.getStackForm())
					.EUt(10).duration(500)
					.buildAndRegister();

			//Fiber board
			recipeMap.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.foil, Materials.AnnealedCopper, 12),
							OreDictUnifier.get(OrePrefix.plate, Materials.ReinforcedEpoxyResin))
					.fluidInputs(Materials.SulfuricAcid.getFluid(500))
					.outputs(MetaItems.FIBER_BOARD.getStackForm())
					.EUt(10).duration(500)
					.buildAndRegister();

			//Multilayer board
			recipeMap.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.foil, Materials.Platinum, 16),
							MetaItems.FIBER_BOARD.getStackForm(2))
					.fluidInputs(Materials.SulfuricAcid.getFluid(500))
					.outputs(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm())
					.EUt(480).duration(600)
					.buildAndRegister();
		}



		ModHandler.addShapedRecipe("phenolic_circuit_board", GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm(), "WWW", "WBW", "WWW", 'W', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Gold), 'B', MetaItems.PHENOLIC_BOARD);



		//Petri dish
		RecipeMaps.FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
				.notConsumable(MetaItems.SHAPE_MOLD_CYLINDER)
				.fluidInputs(Materials.Polystyrene.getFluid(144))
				.outputs(GRMetaItems.PETRI_DISH.getStackForm())
				.EUt(8).duration(40)
				.buildAndRegister();

		//Wetware board
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(MetaItems.MULTILAYER_FIBER_BOARD.getStackForm(),
						GRMetaItems.PETRI_DISH.getStackForm(),
						MetaItems.ELECTRIC_PUMP_HV.getStackForm(),
						MetaItems.SENSOR_HV.getStackForm(),
						OreDictUnifier.get(OrePrefix.foil, Materials.NiobiumTitanium, 4))
				.input(OrePrefix.circuit, MarkerMaterials.Tier.Advanced)
				.fluidInputs(GRMaterials.BacterialGrowth.getFluid(144))
				.outputs(MetaItems.WETWARE_BOARD.getStackForm())
				.EUt(1920).duration(600)
				.buildAndRegister();
	}

	private static void RegisterCutterRecipes()
	{
		RecipeMaps.CUTTER_RECIPES.recipeBuilder()
				.inputs(GRMetaItems.SIMPLE_SYSTEM_ON_CHIP_WAFER.getStackForm())
				.fluidInputs(Materials.Water.getFluid(250))
				.outputs(GRMetaItems.SIMPLE_SYSTEM_ON_CHIP.getStackForm(6))
				.EUt(64).duration(300)
				.buildAndRegister();
	}

	private static void RegisterLaserRecipes()
	{
		RecipeMaps.LASER_ENGRAVER_RECIPES.recipeBuilder()
				.notConsumable(OreDictUnifier.get(OrePrefix.lens, Materials.Topaz))
				.inputs(MetaItems.SILICON_WAFER.getStackForm())
				.outputs(GRMetaItems.SIMPLE_SYSTEM_ON_CHIP_WAFER.getStackForm())
				.EUt(64).duration(300)
				.buildAndRegister();

		GRRecipeMaps.INDUSTRIAL_LASER.recipeBuilder()
				.notConsumable(OreDictUnifier.get(OrePrefix.lens, Materials.Topaz))
				.inputs(MetaItems.GLOWSTONE_WAFER.getStackForm())
				.outputs(MetaItems.SYSTEM_ON_CHIP_WAFER.getStackForm())
				.EUt(64).duration(300)
				.buildAndRegister();
	}

	private static void RegisterBasicComponentRecipes()
	{
		ModHandler.addShapedRecipe("gr_vacuum_tube", MetaItems.VACUUM_TUBE.getStackForm(),
				"CCC", "WGW", "RBR",
				'C', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper),
				'W', OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper),
				'G', MetaItems.GLASS_TUBE.getStackForm(),
				'R', OreDictUnifier.get(OrePrefix.stick, Materials.Steel),
				'B', OreDictUnifier.get(OrePrefix.bolt, Materials.RedAlloy));

		ModHandler.addShapedRecipe("gr_resistor_coal", MetaItems.RESISTOR.getStackForm(),
				"RCR", "WGW", " C ",
				'C', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper),
				'W', OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper),
				'G', OreDictUnifier.get(OrePrefix.dust, Materials.Coal),
				'R', MetaItems.RUBBER_DROP.getStackForm());

		ModHandler.addShapedRecipe("gr_resistor_charcoal", MetaItems.RESISTOR.getStackForm(),
				"RCR", "WGW", " C ",
				'C', OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Copper),
				'W', OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper),
				'G', OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal),
				'R', MetaItems.RUBBER_DROP.getStackForm());

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 4),
						OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal))
				.fluidInputs(Materials.Glue.getFluid(100))
				.outputs(MetaItems.RESISTOR.getStackForm(4))
				.EUt(30).duration(200)
				.buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 4),
						OreDictUnifier.get(OrePrefix.dust, Materials.Coal))
				.fluidInputs(Materials.Glue.getFluid(100))
				.outputs(MetaItems.RESISTOR.getStackForm(4))
				.EUt(30).duration(200)
				.buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 2),
						MetaItems.GLASS_TUBE.getStackForm(),
						OreDictUnifier.get(OrePrefix.stick, Materials.Steel))
				.fluidInputs(Materials.RedAlloy.getFluid(36))
				.outputs(MetaItems.VACUUM_TUBE.getStackForm())
				.EUt(30).duration(200)
				.buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 4),
						MetaItems.SILICON_WAFER.getStackForm())
				.fluidInputs(Materials.Glass.getFluid(72))
				.outputs(MetaItems.DIODE.getStackForm())
				.EUt(30).duration(600)
				.buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 4),
						MetaItems.SILICON_WAFER.getStackForm())
				.fluidInputs(Materials.Glass.getFluid(72))
				.outputs(MetaItems.DIODE.getStackForm())
				.EUt(30).duration(600)
				.buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.AnnealedCopper, 4),
						MetaItems.SILICON_WAFER.getStackForm())
				.fluidInputs(Materials.Glass.getFluid(144))
				.outputs(MetaItems.DIODE.getStackForm(2))
				.EUt(30).duration(600)
				.buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 4),
						OreDictUnifier.get(OrePrefix.dustTiny, Materials.GalliumArsenide, 1))
				.fluidInputs(Materials.Glass.getFluid(288))
				.outputs(MetaItems.DIODE.getStackForm(4))
				.EUt(30).duration(600)
				.buildAndRegister();

		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 4),
						OreDictUnifier.get(OrePrefix.dustTiny, Materials.GalliumArsenide, 1))
				.fluidInputs(Materials.Glass.getFluid(432))
				.outputs(MetaItems.DIODE.getStackForm(6))
				.EUt(30).duration(600)
				.buildAndRegister();

	}

	private static void RegisterCircuitRecipes()
	{
		ModHandler.removeRecipes(MetaItems.BASIC_CIRCUIT_LV.getStackForm());
		ModHandler.removeRecipes(MetaItems.GOOD_INTEGRATED_CIRCUIT_MV.getStackForm());
		//Basic
		ModHandler.addShapedRecipe("gr_basic_circuit", GRMetaItems.BASIC_CIRCUIT.getStackForm(), "RSR", "VBV", "CCC", 'S', "plateSteel", 'R', MetaItems.RESISTOR.getStackForm(), 'V', "circuitPrimitive", 'B', GRMetaItems.CIRCUIT_BOARD.getStackForm(), 'C', "cableGtSingleRedAlloy");
		//Good
		ModHandler.addShapedRecipe("gr_basic_circuit_array", GRMetaItems.BASIC_CIRCUIT_ARRAY.getStackForm(), "CVC", "WBW", "CVC", 'C', GRMetaItems.BASIC_CIRCUIT.getStackForm(), 'V', "circuitPrimitive", 'B', GRMetaItems.CIRCUIT_BOARD.getStackForm(), 'W', "cableGtSingleTin");

		for (MaterialStack stack : solderingList)
		{
			IngotMaterial material = (IngotMaterial) stack.material;
			int multiplier = (int) stack.amount;


			//Data Stick
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.MICRO_CIRCUIT.getStackForm(),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4),
							MetaItems.NAND_MEMORY_CHIP.getStackForm(32),
							OreDictUnifier.get(OrePrefix.plate, Materials.Plastic, 4),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 8))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(MetaItems.TOOL_DATA_STICK.getStackForm())
					.EUt(90).duration(400)
					.buildAndRegister();

			//Data orb
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.EPOXY_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.NANO_CIRCUIT.getStackForm(),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4),
							MetaItems.NAND_MEMORY_CHIP.getStackForm(64),
							MetaItems.NOR_MEMORY_CHIP.getStackForm(32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 32))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(MetaItems.TOOL_DATA_ORB.getStackForm())
					.EUt(1200).duration(400)
					.buildAndRegister();

			//Lapotron orb
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm(),
							MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
							MetaItems.ENGRAVED_LAPOTRON_CHIP.getStackForm(18),
							MetaItems.NAND_MEMORY_CHIP.getStackForm(64),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 16))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(MetaItems.ENERGY_LAPOTRONIC_ORB.getStackForm())
					.EUt(1024).duration(512)
					.buildAndRegister();

			//Lapotron orb2
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm(),
							MetaItems.QBIT_CENTRAL_PROCESSING_UNIT.getStackForm(),
							MetaItems.ENERGY_LAPOTRONIC_ORB.getStackForm(8),
							MetaItems.HIGH_POWER_INTEGRATED_CIRCUIT.getStackForm(4),
							OreDictUnifier.get(OrePrefix.plate, Materials.Europium, 4),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 16))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(MetaItems.ENERGY_LAPOTRONIC_ORB2.getStackForm())
					.EUt(4096).duration(1024)
					.buildAndRegister();

		//Basic
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(GRMetaItems.CIRCUIT_BOARD.getStackForm(),
						MetaItems.RESISTOR.getStackForm(2),
						OreDictUnifier.get(OrePrefix.wireFine, Materials.Tin, 2))
				.input("circuitPrimitive", 2)
				.fluidInputs(material.getFluid(72 * multiplier))
				.outputs(GRMetaItems.BASIC_CIRCUIT.getStackForm())
				.EUt(30).duration(200)
				.buildAndRegister();

		//Good
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
				.inputs(GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm(),
						GRMetaItems.BASIC_CIRCUIT.getStackForm(2),
						MetaItems.DIODE.getStackForm(4),
						OreDictUnifier.get(OrePrefix.wireFine, Materials.Tin, 4))
				.fluidInputs(material.getFluid(72 * multiplier))
				.outputs(GRMetaItems.GOOD_CIRCUIT.getStackForm())
				.EUt(30).duration(400)
				.buildAndRegister();

		//Adv
		RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.GOOD_CIRCUIT.getStackForm(),
							MetaItems.INTEGRATED_LOGIC_CIRCUIT.getStackForm(),
							MetaItems.RESISTOR.getStackForm(4),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4),
							OreDictUnifier.get(OrePrefix.bolt, Materials.Tin, 4),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Tin, 4))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.ADV_CIRCUIT.getStackForm())
					.EUt(30).duration(400)
					.buildAndRegister();

			//Integrated
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.SIMPLE_SYSTEM_ON_CHIP.getStackForm(),
							OreDictUnifier.get(OrePrefix.bolt, Materials.Tin, 2),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Tin, 2))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.NAND_CHIP.getStackForm(4))
					.EUt(60).duration(50)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm(),
							MetaItems.INTEGRATED_LOGIC_CIRCUIT.getStackForm(),
							MetaItems.RESISTOR.getStackForm(2),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Tin, 2))
					.input("circuitPrimitive", 2)
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.INTEGRATED_CIRCUIT.getStackForm())
					.EUt(60).duration(200)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.INTEGRATED_CIRCUIT.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(2),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(2),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Tin, 4))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.INTEGRATED_PROCESSOR.getStackForm())
					.EUt(60).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PHENOLIC_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.INTEGRATED_PROCESSOR.getStackForm(2),
							MetaItems.DIODE.getStackForm(2),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4),
							OreDictUnifier.get(OrePrefix.bolt, Materials.Tin, 4),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Tin, 4))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.INTEGRATED_PROCESSOR_ARRAY.getStackForm())
					.EUt(60).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium, 2),
							GRMetaItems.INTEGRATED_PROCESSOR_ARRAY.getStackForm(2),
							MetaItems.TRANSISTOR.getStackForm(8),
							MetaItems.CAPACITOR.getStackForm(4),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(8),
							OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Tin, 8))
					.fluidInputs(material.getFluid(288 * multiplier))
					.outputs(GRMetaItems.INTEGRATED_PROCESSOR_MAINFRAME.getStackForm())
					.EUt(120).duration(1600)
					.buildAndRegister();

			//Micro
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm(),
							MetaItems.SYSTEM_ON_CHIP.getStackForm(),
							OreDictUnifier.get(OrePrefix.bolt, Materials.Copper, 2),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 2))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.MICRO_CHIP.getStackForm(2))
					.EUt(600).duration(50)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm(),
							MetaItems.CENTRAL_PROCESSING_UNIT.getStackForm(),
							MetaItems.SMD_RESISTOR.getStackForm(2),
							MetaItems.SMD_CAPACITOR.getStackForm(2),
							MetaItems.SMD_TRANSISTOR.getStackForm(2),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Copper, 2))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.MICRO_CHIP.getStackForm(2))
					.EUt(240).duration(200)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm(),
							MetaItems.SYSTEM_ON_CHIP.getStackForm(),
							OreDictUnifier.get(OrePrefix.bolt, Materials.RedAlloy, 4),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 4))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.MICRO_CIRCUIT.getStackForm())
					.EUt(2400).duration(50)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm(),
							MetaItems.CENTRAL_PROCESSING_UNIT.getStackForm(),
							MetaItems.SMD_RESISTOR.getStackForm(4),
							MetaItems.SMD_CAPACITOR.getStackForm(4),
							MetaItems.SMD_TRANSISTOR.getStackForm(4),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 4))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.MICRO_CIRCUIT.getStackForm())
					.EUt(240).duration(200)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.MICRO_CIRCUIT.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(4),
							MetaItems.SMD_CAPACITOR.getStackForm(4),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(4),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 8))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.MICRO_PROCESSOR.getStackForm())
					.EUt(240).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.PLASTIC_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.MICRO_PROCESSOR.getStackForm(2),
							MetaItems.SMD_DIODE.getStackForm(4),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(8),
							OreDictUnifier.get(OrePrefix.bolt, Materials.Electrum, 16),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.RedAlloy, 8))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.MICRO_PROCESSOR_ARRAY.getStackForm())
					.EUt(240).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium, 2),
							GRMetaItems.MICRO_PROCESSOR_ARRAY.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(16),
							MetaItems.SMD_CAPACITOR.getStackForm(16),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16),
							OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.AnnealedCopper, 16))
					.fluidInputs(material.getFluid(288 * multiplier))
					.outputs(GRMetaItems.MICRO_PROCESSOR_MAINFRAME.getStackForm())
					.EUt(480).duration(1600)
					.buildAndRegister();

			//Nano
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.EPOXY_CIRCUIT_BOARD.getStackForm(),
							MetaItems.ADVANCED_SYSTEM_ON_CHIP.getStackForm(),
							OreDictUnifier.get(OrePrefix.bolt, Materials.Electrum, 8),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 8))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.NANO_CIRCUIT.getStackForm())
					.EUt(9600).duration(50)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.EPOXY_CIRCUIT_BOARD.getStackForm(),
							MetaItems.NANO_CENTRAL_PROCESSING_UNIT.getStackForm(),
							MetaItems.SMD_RESISTOR.getStackForm(8),
							MetaItems.SMD_CAPACITOR.getStackForm(8),
							MetaItems.SMD_TRANSISTOR.getStackForm(8),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 8))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.NANO_CIRCUIT.getStackForm())
					.EUt(600).duration(200)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.EPOXY_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.NANO_CIRCUIT.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(8),
							MetaItems.SMD_CAPACITOR.getStackForm(8),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(8),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 16))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.NANO_PROCESSOR.getStackForm())
					.EUt(600).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.EPOXY_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.NANO_PROCESSOR.getStackForm(2),
							MetaItems.SMD_DIODE.getStackForm(8),
							MetaItems.NOR_MEMORY_CHIP.getStackForm(4),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Electrum, 16))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.NANO_PROCESSOR_ARRAY.getStackForm())
					.EUt(600).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium, 2),
							GRMetaItems.NANO_PROCESSOR_ARRAY.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(24),
							MetaItems.SMD_CAPACITOR.getStackForm(24),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(24),
							OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Electrum, 24))
					.fluidInputs(material.getFluid(288 * multiplier))
					.outputs(GRMetaItems.NANO_PROCESSOR_MAINFRAME.getStackForm())
					.EUt(1920).duration(1600)
					.buildAndRegister();

			//Quantum
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm(),
							MetaItems.ADVANCED_SYSTEM_ON_CHIP.getStackForm(),
							OreDictUnifier.get(OrePrefix.bolt, Materials.Platinum, 16),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 16))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.QUANTUM_CIRCUIT.getStackForm())
					.EUt(38400).duration(50)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm(),
							MetaItems.QBIT_CENTRAL_PROCESSING_UNIT.getStackForm(),
							MetaItems.SMD_RESISTOR.getStackForm(16),
							MetaItems.SMD_CAPACITOR.getStackForm(16),
							MetaItems.SMD_TRANSISTOR.getStackForm(16),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 16))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.QUANTUM_CIRCUIT.getStackForm())
					.EUt(2400).duration(200)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.QUANTUM_CIRCUIT.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(16),
							MetaItems.SMD_CAPACITOR.getStackForm(16),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 32))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.QUANTUM_PROCESSOR.getStackForm())
					.EUt(2400).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.FIBER_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.QUANTUM_PROCESSOR.getStackForm(2),
							MetaItems.SMD_DIODE.getStackForm(16),
							MetaItems.NOR_MEMORY_CHIP.getStackForm(4),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(16),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.Platinum, 32))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.QUANTUM_PROCESSOR_ARRAY.getStackForm())
					.EUt(2400).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium, 2),
							GRMetaItems.QUANTUM_PROCESSOR_ARRAY.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(40),
							MetaItems.SMD_CAPACITOR.getStackForm(40),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(40),
							OreDictUnifier.get(OrePrefix.wireGtSingle, Materials.Platinum, 40))
					.fluidInputs(material.getFluid(288 * multiplier))
					.outputs(GRMetaItems.QUANTUM_PROCESSOR_MAINFRAME.getStackForm())
					.EUt(7680).duration(1600)
					.buildAndRegister();

			//Crystal
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.MULTILAYER_FIBER_CIRCUIT_BOARD.getStackForm(),
							MetaItems.CRYSTAL_SYSTEM_ON_CHIP.getStackForm(),
							OreDictUnifier.get(OrePrefix.bolt, Materials.NiobiumTitanium, 32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 32))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.CRYSTAL_CIRCUIT.getStackForm())
					.EUt(153600).duration(50)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.MULTILAYER_FIBER_CIRCUIT_BOARD.getStackForm(),
							MetaItems.CRYSTAL_CENTRAL_PROCESSING_UNIT.getStackForm(),
							MetaItems.SMD_RESISTOR.getStackForm(32),
							MetaItems.SMD_CAPACITOR.getStackForm(32),
							MetaItems.SMD_TRANSISTOR.getStackForm(32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 32))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.CRYSTAL_CIRCUIT.getStackForm())
					.EUt(9600).duration(200)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.MULTILAYER_FIBER_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.CRYSTAL_CIRCUIT.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(32),
							MetaItems.SMD_CAPACITOR.getStackForm(32),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 64))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.CRYSTAL_PROCESSOR.getStackForm())
					.EUt(9600).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.MULTILAYER_FIBER_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.CRYSTAL_PROCESSOR.getStackForm(2),
							MetaItems.NAND_MEMORY_CHIP.getStackForm(8),
							MetaItems.NOR_MEMORY_CHIP.getStackForm(8),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.NiobiumTitanium, 64))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.CRYSTAL_PROCESSOR_ARRAY.getStackForm())
					.EUt(9600).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Aluminium, 2),
							GRMetaItems.CRYSTAL_PROCESSOR_ARRAY.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(64),
							MetaItems.SMD_CAPACITOR.getStackForm(64),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(64),
							OreDictUnifier.get(OrePrefix.wireGtSingle, GRMaterials.SuperConductor[4], 16))
					.fluidInputs(material.getFluid(288 * multiplier))
					.outputs(GRMetaItems.CRYSTAL_PROCESSOR_MAINFRAME.getStackForm())
					.EUt(30720).duration(1600)
					.buildAndRegister();

			//Wetware
			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.WETWARE_CIRCUIT_BOARD.getStackForm(),
							MetaItems.CRYSTAL_SYSTEM_ON_CHIP.getStackForm(),
							MetaItems.SMD_RESISTOR.getStackForm(32),
							MetaItems.SMD_CAPACITOR.getStackForm(32),
							MetaItems.SMD_TRANSISTOR.getStackForm(32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 32))
					.fluidInputs(material.getFluid(72 * multiplier))
					.outputs(GRMetaItems.WETWARE_CIRCUIT.getStackForm())
					.EUt(38400).duration(400)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.WETWARE_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.WETWARE_CIRCUIT.getStackForm(2),
							MetaItems.SMALL_COIL.getStackForm(32),
							MetaItems.SMD_CAPACITOR.getStackForm(32),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 64))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.WETWARE_PROCESSOR.getStackForm())
					.EUt(38400).duration(800)
					.buildAndRegister();

			RecipeMaps.ASSEMBLER_RECIPES.recipeBuilder()
					.inputs(GRMetaItems.WETWARE_CIRCUIT_BOARD.getStackForm(),
							GRMetaItems.WETWARE_PROCESSOR.getStackForm(2),
							MetaItems.NAND_MEMORY_CHIP.getStackForm(16),
							MetaItems.NOR_MEMORY_CHIP.getStackForm(16),
							MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(32),
							OreDictUnifier.get(OrePrefix.wireFine, Materials.YttriumBariumCuprate, 64))
					.fluidInputs(material.getFluid(144 * multiplier))
					.outputs(GRMetaItems.WETWARE_PROCESSOR_ARRAY.getStackForm())
					.EUt(38400).duration(800)
					.buildAndRegister();


		}
		//The infinity is made in assembly line
		GARecipeMaps.ASSEMBLY_LINE_RECIPES.recipeBuilder()
				.inputs(OreDictUnifier.get(OrePrefix.frameGt, Materials.Tritanium, 2),
						GRMetaItems.WETWARE_PROCESSOR.getStackForm(2),
						MetaItems.SMALL_COIL.getStackForm(64),
						MetaItems.SMD_RESISTOR.getStackForm(64),
						MetaItems.SMD_CAPACITOR.getStackForm(64),
						MetaItems.SMD_TRANSISTOR.getStackForm(64),
						MetaItems.SMD_DIODE.getStackForm(64),
						MetaItems.RANDOM_ACCESS_MEMORY.getStackForm(48),
						OreDictUnifier.get(OrePrefix.foil, Materials.SiliconeRubber, 64),
						OreDictUnifier.get(OrePrefix.wireGtSingle, MarkerMaterials.Tier.Superconductor, 64))
				.fluidInputs(Materials.SolderingAlloy.getFluid(2880))
				.outputs(GRMetaItems.WETWARE_PROCESSOR_MAINFRAME.getStackForm())
				.EUt(300000).duration(2000)
				.buildAndRegister();

	}
}
