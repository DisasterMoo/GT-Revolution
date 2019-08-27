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
import gtrevolution.block.GRMetaBlocks;
import gtrevolution.block.GRMultiblockCasing;
import gtrevolution.client.GRTextures;

public class IndustrialMacerator extends IndustrialMachine
{

    private static final MultiblockAbility<?>[] ALLOWED_INPUT_ONLY = {
            MultiblockAbility.IMPORT_ITEMS, MultiblockAbility.INPUT_ENERGY
    };
    protected int parallel;

    public IndustrialMacerator(ResourceLocation metaTileEntityId)
    {
        super(metaTileEntityId, RecipeMaps.MACERATOR_RECIPES, IndustrialType.ITEM_PARALLEL);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder)
    {
        return new IndustrialMacerator(metaTileEntityId);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline)
    {
        this.getBaseTexture(null).render(renderState, translation, pipeline);
        GRTextures.INDUSTRIAL_MACERATOR_OVERLAY.render(renderState, translation, pipeline, this.getFrontFacing(), this.recipeMapWorkable.isActive());
        //ClientHandler.OVERL.render(renderState, translation, pipeline, this.getFrontFacing(), this.recipeMapWorkable.isActive());
    }

    @Override
    protected BlockPattern createStructurePattern()
    {
        return FactoryBlockPattern.start()
                .aisle("III", "XXX", "XXX", "XXX")
                .aisle("IHI", "X#X", "X#X", "XHX")
                .aisle("ISI", "XXX", "XXX", "XXX")
                .setAmountAtLeast('X', 10)
                .where('S', selfPredicate())
                .where('I', statePredicate(getCasingState()).or(abilityPartPredicate(ALLOWED_INPUT_ONLY)))
                .where('X', statePredicate(getCasingState()).or(abilityPartPredicate(MultiblockAbility.EXPORT_ITEMS)))
                .where('H', statePredicate(getCasingState()))
                .where('#', isAirPredicate())
                .build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
    {
        return GRTextures.MACERATION_CASING;
    }

    protected IBlockState getCasingState()
    {
        return GRMetaBlocks.MULTIBLOCK_CASING.getState(GRMultiblockCasing.CasingType.MACERATION_CASING);
    }
}

