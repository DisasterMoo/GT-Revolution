package gtrevolution.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.CutterRecipeBuilder;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.recipes.machines.FuelRecipeMap;
import gtrevolution.recipes.recipemaps.RecipeMapAssemblyLine;
import gtrevolution.recipes.recipemaps.RecipeMapDisassembler;
import stanhebben.zenscript.annotations.ZenProperty;

public class GRRecipeMaps
{
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISASSEMBLER_LV;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISASSEMBLER_MV;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISASSEMBLER_HV;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISASSEMBLER_EV;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISASSEMBLER_IV;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> OILRIG;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> INDUSTRIAL_CHEMICAL_REACTOR;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> INDUSTRIAL_LASER;

    @ZenProperty
    public static final RecipeMap<CutterRecipeBuilder> INDUSTRIAL_CUTTER;

    @ZenProperty
    public static final RecipeMap<IntCircuitRecipeBuilder> INDUSTRIAL_FISHER;

    @ZenProperty
    public static final FuelRecipeMap NAQUADAH_REACTOR_FUELS;

    @ZenProperty
    public static final RecipeMapAssemblyLine<SimpleRecipeBuilder> ASSEMBLY_LINE_RECIPES;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> MASS_FABRICATOR_RECIPES;

    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> REPLICATOR_RECIPES;


    static
    {
        DISASSEMBLER_LV = new RecipeMapDisassembler("disassembler.lv", 1);
        DISASSEMBLER_MV = new RecipeMapDisassembler("disassembler.mv", 2);
        DISASSEMBLER_HV = new RecipeMapDisassembler("disassembler.hv", 3);
        DISASSEMBLER_EV = new RecipeMapDisassembler("disassembler.ev", 4);
        DISASSEMBLER_IV = new RecipeMapDisassembler("disassembler.iv", 5);

        INDUSTRIAL_FISHER = new RecipeMap<>("industrial_fisher",
                1, 1,
                1, 6,
                0, 0,
                0, 0,
                new IntCircuitRecipeBuilder());

        OILRIG = new RecipeMap<>("oil_rig",
                0, 0,
                0, 0,
                1, 1,
                1, 1,
                new SimpleRecipeBuilder());

        INDUSTRIAL_LASER = new RecipeMap<>("industrial_laser", 2, 2, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder())
                .setSlotOverlay(false, false, true, GuiTextures.LENS_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);

        INDUSTRIAL_CUTTER = (new RecipeMap<>("industrial_cutter",
                1, 1,
                1, 2,
                0, 1,
                0, 0,
                new CutterRecipeBuilder()))
                .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
                .setSlotOverlay(true, false, false, GuiTextures.CUTTER_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_SLICE, ProgressWidget.MoveType.HORIZONTAL);

        INDUSTRIAL_CHEMICAL_REACTOR = (new RecipeMap<>("industrial_chemical_reactor",
                0, 2,
                0, 1,
                0, 3,
                0, 2,
                (new SimpleRecipeBuilder()).EUt(30)))
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
                .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL);

        ASSEMBLY_LINE_RECIPES = (new RecipeMapAssemblyLine<>("assembly_line",
                4, 16,
                1, 1,
                0, 4,
                0, 0,
                new SimpleRecipeBuilder()).setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL));
        ASSEMBLY_LINE_RECIPES.setSlotOverlay(false, false, GuiTextures.MOLD_OVERLAY);

        NAQUADAH_REACTOR_FUELS = new FuelRecipeMap("naquadah_reactor");

        MASS_FABRICATOR_RECIPES = new RecipeMap<>("mass_fab",
                0, 1,
                0, 0,
                0, 1,
                1, 2,
                new SimpleRecipeBuilder()).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);

        REPLICATOR_RECIPES = new RecipeMap<>("replicator",
                0, 1,
                0, 1,
                1, 2,
                0, 1,
                new SimpleRecipeBuilder()).setProgressBar(GuiTextures.PROGRESS_BAR_BENDING, ProgressWidget.MoveType.HORIZONTAL);

    }
}
