package gtrevolution.machines.multi;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.multiblock.IMultiblockPart;
import gregtech.api.metatileentity.multiblock.MultiblockAbility;
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController;
import gregtech.api.multiblock.BlockPattern;
import gregtech.api.multiblock.FactoryBlockPattern;
import gregtech.api.render.ICubeRenderer;
import gregtech.api.render.Textures;
import gregtech.common.blocks.BlockMetalCasing;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gtrevolution.block.GRMetaBlocks;
import gtrevolution.block.GRMultiblockCasing;
import gtrevolution.recipes.GRRecipeMaps;

import static gregtech.api.multiblock.BlockPattern.RelativeDirection.*;

/**
 * This is a direct copy from GregicAdditions, credits to
 * it's author EmosewaPixel https://github.com/EmosewaPixel
 */
public class AssemblyLine extends RecipeMapMultiblockController
{

    public AssemblyLine(ResourceLocation metaTileEntityId)
    {
        super(metaTileEntityId, GRRecipeMaps.ASSEMBLY_LINE_RECIPES);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder)
    {
        return new AssemblyLine(metaTileEntityId);
    }

    @Override
    protected BlockPattern createStructurePattern()
    {
        return FactoryBlockPattern.start(LEFT, DOWN, BACK)
                .aisle("#Y#", "GAG", "RTR", "COC")
                .aisle("#Y#", "GAG", "RTR", "FIF").setRepeatable(3, 14)
                .aisle("#Y#", "GSG", "RTR", "FIF")
                .where('S', selfPredicate())
                .where('C', statePredicate(getCasingState()))
                .where('F', statePredicate(getCasingState()).or(abilityPartPredicate(MultiblockAbility.IMPORT_FLUIDS)))
                .where('O', statePredicate(getCasingState()).or(abilityPartPredicate(MultiblockAbility.EXPORT_ITEMS)))
                .where('Y', statePredicate(getCasingState()).or(abilityPartPredicate(MultiblockAbility.INPUT_ENERGY)))
                .where('I', tilePredicate((state, tile) -> tile.metaTileEntityId.equals(MetaTileEntities.ITEM_IMPORT_BUS[0].metaTileEntityId)))
                .where('G', statePredicate(MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING)))
                .where('A', statePredicate(MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLER_CASING)))
                .where('R', statePredicate(Blocks.GLASS.getDefaultState()))
                .where('T', statePredicate(GRMetaBlocks.MULTIBLOCK_CASING.getState(GRMultiblockCasing.CasingType.TUNGSTENSTEEL_GEARBOX_CASING)))
                .where('#', (tile) -> true).build();
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart)
    {
        return Textures.SOLID_STEEL_CASING;
    }

    protected IBlockState getCasingState()
    {
        return MetaBlocks.METAL_CASING.getState(BlockMetalCasing.MetalCasingType.STEEL_SOLID);
    }
}