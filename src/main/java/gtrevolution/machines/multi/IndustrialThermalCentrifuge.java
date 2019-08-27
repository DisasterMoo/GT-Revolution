package gtrevolution.machines.multi;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.Textures;
import gtrevolution.block.GRMetaBlocks;
import gtrevolution.block.GRMultiblockCasing;
import gtrevolution.client.GRTextures;

public class IndustrialThermalCentrifuge extends IndustrialMachine
{

    private static final MultiblockAbility<?>[] ALLOWED_ABILITIES = {
            MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.EXPORT_ITEMS, MultiblockAbility.INPUT_ENERGY
    };

    public IndustrialThermalCentrifuge(ResourceLocation metaTileEntityId)
    {
        super(metaTileEntityId, RecipeMaps.THERMAL_CENTRIFUGE_RECIPES, IndustrialType.ITEM_PARALLEL);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder)
    {
        return new IndustrialThermalCentrifuge(metaTileEntityId);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline)
    {
        this.getBaseTexture(null).render(renderState, translation, pipeline);
        Textures.THERMAL_CENTRIFUGE_OVERLAY.render(renderState, translation, pipeline, this.getFrontFacing(), this.recipeMapWorkable.isActive());
        //ClientHandler.OVERL.render(renderState, translation, pipeline, this.getFrontFacing(), this.recipeMapWorkable.isActive());
    }

    @Override
    protected BlockPattern createStructurePattern()
    {
        return FactoryBlockPattern.start()
                .aisle("XXX", "XXX")
                .aisle("XXX", "XXX")
                .aisle("XXX", "XXX")
                .aisle("XSX", "XXX")
                .setAmountAtLeast('X', 8)
                .where('S', selfPredicate())
                .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_ABILITIES)))
                .where('#', isAirPredicate())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
    {
        return GRTextures.THERMAL_CASING;
    }

    protected IBlockState getCasingState()
    {
        return GRMetaBlocks.MULTIBLOCK_CASING.getState(GRMultiblockCasing.CasingType.THERMAL_CASING);
    }
}