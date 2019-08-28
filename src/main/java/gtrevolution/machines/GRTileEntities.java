package gtrevolution.machines;

import net.minecraft.util.ResourceLocation;

import gregtech.api.GTValues;
import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleGeneratorMetaTileEntity;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.common.metatileentities.electric.MetaTileEntityMacerator;
import gtrevolution.GTRevolution;
import gtrevolution.client.GRTextures;
import gtrevolution.machines.multi.*;
import gtrevolution.recipes.GRRecipeMaps;
import gtrevolution.util.GRConfig;

@SuppressWarnings("WeakerAccess")
public class GRTileEntities
{
    /**
     * Static additions
     */
    public static SimpleMachineMetaTileEntity[] DISASSEMBLER = new SimpleMachineMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] MASS_FABRICATOR = new SimpleMachineMetaTileEntity[8];
    public static SimpleGeneratorMetaTileEntity[] NAQUADAH_REACTOR = new SimpleGeneratorMetaTileEntity[8];
    public static SimpleMachineMetaTileEntity[] REPLICATOR = new SimpleMachineMetaTileEntity[8];
    public static FusionReactor[] FUSION_REACTOR = new FusionReactor[3];
    public static AssemblyLine ASSEMBLY_LINE;
    /**
     * Config based
     */
    public static IndustrialMacerator INDUSTRIAL_MACERATOR;
    public static ImprovedBlastFurnace BLAST_FURNACE;
    public static IndustrialThermalCentrifuge INDUSTRIAL_THERMALCENTRIFUGE;
    public static IndustrialOreWasher INDUSTRIAL_OREWASHER;
    public static IndustrialCentrifuge INDUSTRIAL_CENTRIFUGE;
    public static IndustrialElectrolyzer INDUSTRIAL_ELECTROLYZER;
    public static IndustrialChemicalReactor INDUSTRIAL_CHEMICALREACTOR;
    public static IndustrialFisher INDUSTRIAL_FISHER;
    public static IndustrialWiremill INDUSTRIAL_WIREMILL;
    public static IndustrialSifter INDUSTRIAL_SIFTER;
    public static IndustrialLaserProcessor INDUSTRIAL_LASER;
    public static IndustrialCuttingFactory INDUSTRIAL_CUTTER;
    public static OilRig OIL_RIG;

    public static void init()
    {
        int id = 3001;

        DISASSEMBLER[0] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.lv"), GRRecipeMaps.DISASSEMBLER_LV, Textures.ASSEMBLER_OVERLAY, 1));
        DISASSEMBLER[1] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.mv"), GRRecipeMaps.DISASSEMBLER_MV, Textures.ASSEMBLER_OVERLAY, 2));
        DISASSEMBLER[2] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.hv"), GRRecipeMaps.DISASSEMBLER_HV, Textures.ASSEMBLER_OVERLAY, 3));
        DISASSEMBLER[3] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.ev"), GRRecipeMaps.DISASSEMBLER_EV, Textures.ASSEMBLER_OVERLAY, 4));
        DISASSEMBLER[4] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.iv"), GRRecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 5));
        DISASSEMBLER[5] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.luv"), GRRecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 6));
        DISASSEMBLER[6] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.zpm"), GRRecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 7));
        DISASSEMBLER[7] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("disassembler.uv"), GRRecipeMaps.DISASSEMBLER_IV, Textures.ASSEMBLER_OVERLAY, 8));

        NAQUADAH_REACTOR[3] = GregTechAPI.registerMetaTileEntity(id++, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk1"), GRRecipeMaps.NAQUADAH_REACTOR_FUELS, GRTextures.NAQUADAH_OVERLAY, 4));
        NAQUADAH_REACTOR[4] = GregTechAPI.registerMetaTileEntity(id++, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk2"), GRRecipeMaps.NAQUADAH_REACTOR_FUELS, GRTextures.NAQUADAH_OVERLAY, 5));
        NAQUADAH_REACTOR[5] = GregTechAPI.registerMetaTileEntity(id++, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk3"), GRRecipeMaps.NAQUADAH_REACTOR_FUELS, GRTextures.NAQUADAH_OVERLAY, 6));
        NAQUADAH_REACTOR[6] = GregTechAPI.registerMetaTileEntity(id++, new SimpleGeneratorMetaTileEntity(location("naquadah_reactor.mk4"), GRRecipeMaps.NAQUADAH_REACTOR_FUELS, GRTextures.NAQUADAH_OVERLAY, 7));

        MASS_FABRICATOR[0] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.lv"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 1));
        MASS_FABRICATOR[1] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.mv"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 2));
        MASS_FABRICATOR[2] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.hv"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 3));
        MASS_FABRICATOR[3] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.ev"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 4));
        MASS_FABRICATOR[4] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.iv"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 5));
        MASS_FABRICATOR[5] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.luv"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 6));
        MASS_FABRICATOR[6] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.zpm"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 7));
        MASS_FABRICATOR[7] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("mass_fab.uv"), GRRecipeMaps.MASS_FABRICATOR_RECIPES, GRTextures.MASS_FABRICATOR_OVERLAY, 8));

        REPLICATOR[0] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.lv"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 1));
        REPLICATOR[1] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.mv"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 2));
        REPLICATOR[2] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.hv"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 3));
        REPLICATOR[3] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.ev"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 4));
        REPLICATOR[4] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.iv"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 5));
        REPLICATOR[5] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.luv"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 6));
        REPLICATOR[6] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.zpm"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 7));
        REPLICATOR[7] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(location("replicator.uv"), GRRecipeMaps.REPLICATOR_RECIPES, GRTextures.REPLICATOR_OVERLAY, 8));

        ASSEMBLY_LINE = GregTechAPI.registerMetaTileEntity(id++, new AssemblyLine(location("assembly_line")));

        FUSION_REACTOR[0] = GregTechAPI.registerMetaTileEntity(id++, new FusionReactor(location("fusion_reactor.luv"), 6));
        FUSION_REACTOR[1] = GregTechAPI.registerMetaTileEntity(id++, new FusionReactor(location("fusion_reactor.zpm"), 7));
        FUSION_REACTOR[2] = GregTechAPI.registerMetaTileEntity(id++, new FusionReactor(location("fusion_reactor.uv"), 8));

        if (GRConfig.multiblocks.Macerator)
        {
            INDUSTRIAL_MACERATOR = GregTechAPI.registerMetaTileEntity(id++, new IndustrialMacerator(location("industrial_macerator")));
        }

        if (GRConfig.multiblocks.Thermal)
        {
            INDUSTRIAL_THERMALCENTRIFUGE = GregTechAPI.registerMetaTileEntity(id++, new IndustrialThermalCentrifuge(location("industrial_thermalcentrifuge")));
        }

        if (GRConfig.multiblocks.Orewash)
        {
            INDUSTRIAL_OREWASHER = GregTechAPI.registerMetaTileEntity(id++, new IndustrialOreWasher(location("industrial_orewasher")));
        }

        if (GRConfig.multiblocks.Electrolyzer)
        {
            INDUSTRIAL_ELECTROLYZER = GregTechAPI.registerMetaTileEntity(id++, new IndustrialElectrolyzer(location("industrial_electrolyzer")));
        }

        if (GRConfig.multiblocks.Centrifuge)
        {
            INDUSTRIAL_CENTRIFUGE = GregTechAPI.registerMetaTileEntity(id++, new IndustrialCentrifuge(location("industrial_centrifuge")));
        }

        if (GRConfig.multiblocks.Fisher)
        {
            INDUSTRIAL_FISHER = GregTechAPI.registerMetaTileEntity(id++, new IndustrialFisher(location("industrial_fisher")));
        }

        if (GRConfig.multiblocks.EBF)
        {
            BLAST_FURNACE = GregTechAPI.registerMetaTileEntity(id++, new ImprovedBlastFurnace(location("improved_blast_furnace")));
        }

        if (GRConfig.multiblocks.Wiremill)
        {
            INDUSTRIAL_WIREMILL = GregTechAPI.registerMetaTileEntity(id++, new IndustrialWiremill(location("industrial_wiremill")));
        }

        if (GRConfig.multiblocks.Wiremill)
        {
            INDUSTRIAL_SIFTER = GregTechAPI.registerMetaTileEntity(id++, new IndustrialSifter(location("industrial_sifter")));
        }

        if (GRConfig.multiblocks.OilRig)
        {
            OIL_RIG = GregTechAPI.registerMetaTileEntity(id++, new OilRig(location("oil_rig")));
        }

        if (GRConfig.misc.CircuitOverhaul)
        {
            INDUSTRIAL_LASER = GregTechAPI.registerMetaTileEntity(id++, new IndustrialLaserProcessor(location("industrial_laser")));
            INDUSTRIAL_CUTTER = GregTechAPI.registerMetaTileEntity(id++, new IndustrialCuttingFactory(location("industrial_cutter")));
            INDUSTRIAL_CHEMICALREACTOR = GregTechAPI.registerMetaTileEntity(id++, new IndustrialChemicalReactor(location("industrial_chemicalreactor")));
        }

        //=========== Register missing machines ===========

        SimpleMachineMetaTileEntity[] ELECTRIC_FURNACE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.ELECTRIC_FURNACE, 0, ELECTRIC_FURNACE, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            ELECTRIC_FURNACE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("electric_furnace", i), RecipeMaps.FURNACE_RECIPES, Textures.ELECTRIC_FURNACE_OVERLAY, i + 1));
        }
        MetaTileEntities.ELECTRIC_FURNACE = ELECTRIC_FURNACE;

        //Macerator
        MetaTileEntityMacerator[] MACERATOR = new MetaTileEntityMacerator[8];
        System.arraycopy(MetaTileEntities.MACERATOR, 0, MACERATOR, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            MACERATOR[i] = GregTechAPI.registerMetaTileEntity(id++, new MetaTileEntityMacerator(machineResource("macerator", i), RecipeMaps.MACERATOR_RECIPES, 3, Textures.MACERATOR_OVERLAY, i + 1));
        }
        MetaTileEntities.MACERATOR = MACERATOR;

        //Alloy smelter
        SimpleMachineMetaTileEntity[] ALLOY_SMELTER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.ALLOY_SMELTER, 0, ALLOY_SMELTER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            ALLOY_SMELTER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("alloy_smelter", i), RecipeMaps.ALLOY_SMELTER_RECIPES, Textures.ALLOY_SMELTER_OVERLAY, i + 1));
        }
        MetaTileEntities.ALLOY_SMELTER = ALLOY_SMELTER;

        //Amplificator
        SimpleMachineMetaTileEntity[] AMPLIFABRICATOR = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.AMPLIFABRICATOR, 0, AMPLIFABRICATOR, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            AMPLIFABRICATOR[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("amplifab", i), RecipeMaps.AMPLIFIERS, Textures.AMPLIFAB_OVERLAY, i + 1));
        }
        MetaTileEntities.AMPLIFABRICATOR = AMPLIFABRICATOR;

        //Arc furnace
        SimpleMachineMetaTileEntity[] ARC_FURNACE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.ARC_FURNACE, 0, ARC_FURNACE, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            ARC_FURNACE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("arc_furnace", i), RecipeMaps.ARC_FURNACE_RECIPES, Textures.ARC_FURNACE_OVERLAY, i + 1));
        }
        MetaTileEntities.ARC_FURNACE = ARC_FURNACE;

        //Assemblers
        SimpleMachineMetaTileEntity[] ASSEMBLER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.ASSEMBLER, 0, ASSEMBLER, 0, 5);
        for (int i = 5; i < 8; i++)
        {
            ASSEMBLER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("assembler", i), RecipeMaps.ASSEMBLER_RECIPES, Textures.ASSEMBLER_OVERLAY, i + 1));
        }
        MetaTileEntities.ASSEMBLER = ASSEMBLER;

        //Autoclaves
        SimpleMachineMetaTileEntity[] AUTOCLAVE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.AUTOCLAVE, 0, AUTOCLAVE, 0, 5);
        for (int i = 5; i < 8; i++)
        {
            AUTOCLAVE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("autoclave", i), RecipeMaps.AUTOCLAVE_RECIPES, Textures.AUTOCLAVE_OVERLAY, i + 1));
        }
        MetaTileEntities.AUTOCLAVE = AUTOCLAVE;

        //Bending
        SimpleMachineMetaTileEntity[] BENDER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.BENDER, 0, BENDER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            BENDER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("bender", i), RecipeMaps.BENDER_RECIPES, Textures.BENDER_OVERLAY, i + 1));
        }
        MetaTileEntities.BENDER = BENDER;

        //Brewery
        SimpleMachineMetaTileEntity[] BREWERY = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.BREWERY, 0, BREWERY, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            BREWERY[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("brewery", i), RecipeMaps.BREWING_RECIPES, Textures.BREWERY_OVERLAY, i + 1));
        }
        MetaTileEntities.BREWERY = BREWERY;

        //Canner
        SimpleMachineMetaTileEntity[] CANNER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.CANNER, 0, CANNER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            CANNER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("canner", i), RecipeMaps.CANNER_RECIPES, Textures.CANNER_OVERLAY, i + 1));
        }
        MetaTileEntities.CANNER = CANNER;

        //Centrifuge
        SimpleMachineMetaTileEntity[] CENTRIFUGE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.CENTRIFUGE, 0, CENTRIFUGE, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            CENTRIFUGE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("centrifuge", i), RecipeMaps.CENTRIFUGE_RECIPES, Textures.CENTRIFUGE_OVERLAY, i + 1));
        }
        MetaTileEntities.CENTRIFUGE = CENTRIFUGE;

        //Chemical bath
        SimpleMachineMetaTileEntity[] CHEMICAL_BATH = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.CHEMICAL_BATH, 0, CHEMICAL_BATH, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            CHEMICAL_BATH[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("chemical_bath", i), RecipeMaps.CHEMICAL_BATH_RECIPES, Textures.CHEMICAL_BATH_OVERLAY, i + 1));
        }
        MetaTileEntities.CHEMICAL_BATH = CHEMICAL_BATH;

        //Chemical reactor
        SimpleMachineMetaTileEntity[] CHEMICAL_REACTOR = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.CHEMICAL_REACTOR, 0, CHEMICAL_REACTOR, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            CHEMICAL_REACTOR[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("chemical_reactor", i), RecipeMaps.CHEMICAL_RECIPES, Textures.CHEMICAL_REACTOR_OVERLAY, i + 1));
        }
        MetaTileEntities.CHEMICAL_REACTOR = CHEMICAL_REACTOR;

        //Compressor
        SimpleMachineMetaTileEntity[] COMPRESSOR = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.COMPRESSOR, 0, COMPRESSOR, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            COMPRESSOR[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("compressor", i), RecipeMaps.COMPRESSOR_RECIPES, Textures.COMPRESSOR_OVERLAY, i + 1));
        }
        MetaTileEntities.COMPRESSOR = COMPRESSOR;

        //Cutter
        SimpleMachineMetaTileEntity[] CUTTER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.CUTTER, 0, CUTTER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            CUTTER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("cutter", i), RecipeMaps.CUTTER_RECIPES, Textures.CUTTER_OVERLAY, i + 1));
        }
        MetaTileEntities.CUTTER = CUTTER;

        //Distillery
        SimpleMachineMetaTileEntity[] DISTILLERY = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.DISTILLERY, 0, DISTILLERY, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            DISTILLERY[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("distillery", i), RecipeMaps.DISTILLERY_RECIPES, Textures.DISTILLERY_OVERLAY, i + 1));
        }
        MetaTileEntities.DISTILLERY = DISTILLERY;

        //Electrolyzer
        SimpleMachineMetaTileEntity[] ELECTROLYZER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.ELECTROLYZER, 0, ELECTROLYZER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            ELECTROLYZER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("electrolyzer", i), RecipeMaps.ELECTROLYZER_RECIPES, Textures.ELECTROLYZER_OVERLAY, i + 1));
        }
        MetaTileEntities.ELECTROLYZER = ELECTROLYZER;

        //Electromagnetic separator
        SimpleMachineMetaTileEntity[] ELECTROMAGNETIC_SEPARATOR = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.ELECTROMAGNETIC_SEPARATOR, 0, ELECTROMAGNETIC_SEPARATOR, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            ELECTROMAGNETIC_SEPARATOR[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("electromagnetic_separator", i), RecipeMaps.ELECTROMAGNETIC_SEPARATOR_RECIPES, Textures.ELECTROMAGNETIC_SEPARATOR_OVERLAY, i + 1));
        }
        MetaTileEntities.ELECTROMAGNETIC_SEPARATOR = ELECTROMAGNETIC_SEPARATOR;

        //Extractor
        SimpleMachineMetaTileEntity[] EXTRACTOR = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.EXTRACTOR, 0, EXTRACTOR, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            EXTRACTOR[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("extractor", i), RecipeMaps.EXTRACTOR_RECIPES, Textures.EXTRACTOR_OVERLAY, i + 1));
        }
        MetaTileEntities.EXTRACTOR = EXTRACTOR;

        //Extruder is a special case
        SimpleMachineMetaTileEntity[] EXTRUDER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.EXTRUDER, 0, EXTRUDER, 1, 3);
        EXTRUDER[0] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("extruder", 0), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, 1));
        for (int i = 4; i < 8; i++)
        {
            EXTRUDER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("extruder", i), RecipeMaps.EXTRUDER_RECIPES, Textures.EXTRUDER_OVERLAY, i + 1));
        }
        MetaTileEntities.EXTRUDER = EXTRUDER;

        //Fermenter
        SimpleMachineMetaTileEntity[] FERMENTER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.FERMENTER, 0, FERMENTER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            FERMENTER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("fermenter", i), RecipeMaps.FERMENTING_RECIPES, Textures.FERMENTER_OVERLAY, i + 1));
        }
        MetaTileEntities.FERMENTER = FERMENTER;

        //Fluid canner
        SimpleMachineMetaTileEntity[] FLUID_CANNER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.FLUID_CANNER, 0, FLUID_CANNER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            FLUID_CANNER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("fluid_canner", i), RecipeMaps.FLUID_CANNER_RECIPES, Textures.FLUID_CANNER_OVERLAY, i + 1));
        }
        MetaTileEntities.FLUID_CANNER = FLUID_CANNER;

        //Fluid extractor
        SimpleMachineMetaTileEntity[] FLUID_EXTRACTOR = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.FLUID_EXTRACTOR, 0, FLUID_EXTRACTOR, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            FLUID_EXTRACTOR[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("fluid_extractor", i), RecipeMaps.FLUID_EXTRACTION_RECIPES, Textures.FLUID_EXTRACTOR_OVERLAY, i + 1));
        }
        MetaTileEntities.FLUID_EXTRACTOR = FLUID_EXTRACTOR;

        //Fluid heater
        SimpleMachineMetaTileEntity[] FLUID_HEATER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.FLUID_HEATER, 0, FLUID_HEATER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            FLUID_HEATER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("fluid_heater", i), RecipeMaps.FLUID_HEATER_RECIPES, Textures.FLUID_HEATER_OVERLAY, i + 1));
        }
        MetaTileEntities.FLUID_HEATER = FLUID_HEATER;

        //Fluid solidifier
        SimpleMachineMetaTileEntity[] FLUID_SOLIDIFIER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.FLUID_SOLIDIFIER, 0, FLUID_SOLIDIFIER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            FLUID_SOLIDIFIER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("fluid_solidifier", i), RecipeMaps.FLUID_SOLIDFICATION_RECIPES, Textures.FLUID_SOLIDIFIER_OVERLAY, i + 1));
        }
        MetaTileEntities.FLUID_SOLIDIFIER = FLUID_SOLIDIFIER;

        //Forge hammer
        SimpleMachineMetaTileEntity[] FORGE_HAMMER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.FORGE_HAMMER, 0, FORGE_HAMMER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            FORGE_HAMMER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("forge_hammer", i), RecipeMaps.FORGE_HAMMER_RECIPES, Textures.FORGE_HAMMER_OVERLAY, i + 1));
        }
        MetaTileEntities.FORGE_HAMMER = FORGE_HAMMER;

        //Forming press
        SimpleMachineMetaTileEntity[] FORMING_PRESS = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.FORMING_PRESS, 0, FORMING_PRESS, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            FORMING_PRESS[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("forming_press", i), RecipeMaps.FORMING_PRESS_RECIPES, Textures.FORMING_PRESS_OVERLAY, i + 1));
        }
        MetaTileEntities.FORMING_PRESS = FORMING_PRESS;

        //Lathe
        SimpleMachineMetaTileEntity[] LATHE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.LATHE, 0, LATHE, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            LATHE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("lathe", i), RecipeMaps.LATHE_RECIPES, Textures.LATHE_OVERLAY, i + 1));
        }
        MetaTileEntities.LATHE = LATHE;

        //Microwave
        SimpleMachineMetaTileEntity[] MICROWAVE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.MICROWAVE, 0, MICROWAVE, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            MICROWAVE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("microwave", i), RecipeMaps.MICROWAVE_RECIPES, Textures.MICROWAVE_OVERLAY, i + 1));
        }
        MetaTileEntities.MICROWAVE = MICROWAVE;

        SimpleMachineMetaTileEntity[] MIXER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.MIXER, 0, MIXER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            MIXER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("mixer", i), RecipeMaps.MIXER_RECIPES, Textures.MIXER_OVERLAY, i + 1));
        }
        MetaTileEntities.MIXER = MIXER;

        SimpleMachineMetaTileEntity[] ORE_WASHER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.ORE_WASHER, 0, ORE_WASHER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            ORE_WASHER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("ore_washer", i), RecipeMaps.ORE_WASHER_RECIPES, Textures.ORE_WASHER_OVERLAY, i + 1));
        }
        MetaTileEntities.ORE_WASHER = ORE_WASHER;

        SimpleMachineMetaTileEntity[] PACKER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.PACKER, 0, PACKER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            PACKER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("packer", i), RecipeMaps.PACKER_RECIPES, Textures.PACKER_OVERLAY, i + 1));
        }
        MetaTileEntities.PACKER = PACKER;

        SimpleMachineMetaTileEntity[] UNPACKER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.UNPACKER, 0, UNPACKER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            UNPACKER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("unpacker", i), RecipeMaps.UNPACKER_RECIPES, Textures.UNPACKER_OVERLAY, i + 1));
        }
        MetaTileEntities.UNPACKER = UNPACKER;

        SimpleMachineMetaTileEntity[] PLASMA_ARC_FURNACE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.PLASMA_ARC_FURNACE, 0, PLASMA_ARC_FURNACE, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            PLASMA_ARC_FURNACE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("plasma_arc_furnace", i), RecipeMaps.PLASMA_ARC_FURNACE_RECIPES, Textures.PLASMA_ARC_FURNACE_OVERLAY, i + 1));
        }
        MetaTileEntities.PLASMA_ARC_FURNACE = PLASMA_ARC_FURNACE;

        SimpleMachineMetaTileEntity[] POLARIZER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.POLARIZER, 0, POLARIZER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            POLARIZER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("polarizer", i), RecipeMaps.POLARIZER_RECIPES, Textures.POLARIZER_OVERLAY, i + 1));
        }
        MetaTileEntities.POLARIZER = POLARIZER;

        SimpleMachineMetaTileEntity[] LASER_ENGRAVER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.LASER_ENGRAVER, 0, LASER_ENGRAVER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            LASER_ENGRAVER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("laser_engraver", i), RecipeMaps.LASER_ENGRAVER_RECIPES, Textures.LASER_ENGRAVER_OVERLAY, i + 1));
        }
        MetaTileEntities.LASER_ENGRAVER = LASER_ENGRAVER;

        SimpleMachineMetaTileEntity[] SIFTER = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.SIFTER, 0, SIFTER, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            SIFTER[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("sifter", i), RecipeMaps.SIFTER_RECIPES, Textures.SIFTER_OVERLAY, i + 1));
        }
        MetaTileEntities.SIFTER = SIFTER;

        SimpleMachineMetaTileEntity[] THERMAL_CENTRIFUGE = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.THERMAL_CENTRIFUGE, 0, THERMAL_CENTRIFUGE, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            THERMAL_CENTRIFUGE[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("thermal_centrifuge", i), RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, Textures.THERMAL_CENTRIFUGE_OVERLAY, i + 1));
        }
        MetaTileEntities.THERMAL_CENTRIFUGE = THERMAL_CENTRIFUGE;

        SimpleMachineMetaTileEntity[] WIREMILL = new SimpleMachineMetaTileEntity[8];
        System.arraycopy(MetaTileEntities.WIREMILL, 0, WIREMILL, 0, 4);
        for (int i = 4; i < 8; i++)
        {
            WIREMILL[i] = GregTechAPI.registerMetaTileEntity(id++, new SimpleMachineMetaTileEntity(machineResource("wiremill", i), RecipeMaps.WIREMILL_RECIPES, Textures.WIREMILL_OVERLAY, i + 1));
        }
        MetaTileEntities.WIREMILL = WIREMILL;
    }

    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(GTRevolution.MODID, name);
    }

    private static ResourceLocation machineResource(String machineType, int tier)
    {
        return new ResourceLocation(GTValues.MODID, machineType + "." + GTValues.VN[tier + 1].toLowerCase());
    }
}
