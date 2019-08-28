package gtrevolution.jei.info;

import java.util.List;

import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import gtrevolution.block.GRMetaBlocks;
import gtrevolution.block.GRMultiblockCasing;
import gtrevolution.machines.GRTileEntities;

public class IndustrialCutterInfo extends MultiblockInfoPage
{

    @Override
    public MultiblockControllerBase getController()
    {
        return GRTileEntities.INDUSTRIAL_CUTTER;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes()
    {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
                .aisle("ECI", "XFX")
                .aisle("XXX", "XXX")
                .aisle("XXX", "XXX")
                .aisle("XBX", "XXX")
                .where('C', GRTileEntities.INDUSTRIAL_CUTTER, EnumFacing.NORTH)
                .where('X', GRMetaBlocks.MULTIBLOCK_CASING.getState(GRMultiblockCasing.CasingType.CUTTER_CASING))
                .where('#', Blocks.AIR.getDefaultState())
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.NORTH)
                .where('B', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.SOUTH)
                .where('E', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV], EnumFacing.NORTH)
                .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.HV], EnumFacing.NORTH)
                .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription()
    {
        return new String[] {I18n.format("gregtech.multiblock.industrial_cutter.description")};
    }

}
