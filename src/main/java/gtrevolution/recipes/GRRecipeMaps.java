package gtrevolution.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.CutterRecipeBuilder;
import gregtech.api.recipes.builders.IntCircuitRecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gtrevolution.recipes.recipemap.Disassembler;
import stanhebben.zenscript.annotations.ZenProperty;

public class GRRecipeMaps
{
    @ZenProperty
    public static final RecipeMap<SimpleRecipeBuilder> DISASSEMBLER_LV,
            DISASSEMBLER_MV,
            DISASSEMBLER_HV,
            DISASSEMBLER_EV,
            DISASSEMBLER_IV,
            OILRIG,
            INDUSTRIAL_CHEMICAL_REACTOR,
            INDUSTRIAL_LASER;

    @ZenProperty
    public static final RecipeMap<CutterRecipeBuilder> INDUSTRIAL_CUTTER;

    public static final RecipeMap<IntCircuitRecipeBuilder> INDUSTRIALFISHER;


    static {
        DISASSEMBLER_LV = new Disassembler("disassembler.lv", 1);
        DISASSEMBLER_MV = new Disassembler("disassembler.mv", 2);
        DISASSEMBLER_HV = new Disassembler("disassembler.hv", 3);
        DISASSEMBLER_EV = new Disassembler("disassembler.ev", 4);
        DISASSEMBLER_IV = new Disassembler("disassembler.iv", 5);
        INDUSTRIALFISHER = new RecipeMap("industrial_fisher", 1, 1, 1, 6, 0, 0, 0, 0, new IntCircuitRecipeBuilder());
        OILRIG = new RecipeMap<SimpleRecipeBuilder>("oil_rig", 0, 0, 0, 0, 1, 1, 1, 1, new SimpleRecipeBuilder());
        INDUSTRIAL_LASER = new RecipeMap("industrial_laser", 2, 2, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder())
                .setSlotOverlay(false, false, true, GuiTextures.LENS_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressWidget.MoveType.HORIZONTAL);
        INDUSTRIAL_CUTTER = (new RecipeMap("industrial_cutter", 1, 1, 1, 2, 0, 1, 0, 0, new CutterRecipeBuilder()))
                .setSlotOverlay(false, false, GuiTextures.BOX_OVERLAY)
                .setSlotOverlay(true, false, false, GuiTextures.CUTTER_OVERLAY)
                .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
                .setProgressBar(GuiTextures.PROGRESS_BAR_SLICE, ProgressWidget.MoveType.HORIZONTAL);

        INDUSTRIAL_CHEMICAL_REACTOR = (new RecipeMap("industrial_chemical_reactor", 0, 2, 0, 1, 0, 3, 0, 2, (new SimpleRecipeBuilder()).EUt(30)))
                .setSlotOverlay(false, false, false, GuiTextures.MOLECULAR_OVERLAY_1)
                .setSlotOverlay(false, false, true, GuiTextures.MOLECULAR_OVERLAY_2)
                .setSlotOverlay(false, true, GuiTextures.MOLECULAR_OVERLAY_3)
                .setSlotOverlay(true, false, GuiTextures.VIAL_OVERLAY_1)
                .setSlotOverlay(true, true, GuiTextures.VIAL_OVERLAY_2)
                .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressWidget.MoveType.HORIZONTAL);




    }
}
