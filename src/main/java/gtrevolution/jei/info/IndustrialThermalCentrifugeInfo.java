package gtrevolution.jei.info;

import java.util.List;

import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumFacing;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockInfoPage;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import gtrevolution.block.GRMetaBlocks;
import gtrevolution.block.GRMultiblockCasing;
import gtrevolution.machines.GRTileEntities;

public class IndustrialThermalCentrifugeInfo extends MultiblockInfoPage
{

    @Override
    public MultiblockControllerBase getController()
    {
        return GRTileEntities.INDUSTRIAL_THERMALCENTRIFUGE;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes()
    {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
                .aisle("XCX", "BXI")
                .aisle("XXX", "XXX")
                .aisle("XXX", "XXX")
                .aisle("XEX", "XXX")
                .where('C', GRTileEntities.INDUSTRIAL_THERMALCENTRIFUGE, EnumFacing.NORTH)
                .where('X', GRMetaBlocks.MULTIBLOCK_CASING.getState(GRMultiblockCasing.CasingType.THERMAL_CASING))
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.NORTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.SOUTH)
                .where('B', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV], EnumFacing.NORTH)
                .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription()
    {
        return new String[] {I18n.format("gregtech.multiblock.industrial_thermalcentrifuge.description")};
    }

}