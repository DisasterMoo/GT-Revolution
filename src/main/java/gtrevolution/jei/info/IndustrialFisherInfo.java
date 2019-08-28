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

public class IndustrialFisherInfo extends MultiblockInfoPage
{

    @Override
    public MultiblockControllerBase getController()
    {
        return GRTileEntities.INDUSTRIAL_FISHER;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes()
    {
        MultiblockShapeInfo shapeInfo = MultiblockShapeInfo.builder()
                .aisle("XXXXX", "XXEXX", "XXXXX")
                .aisle("XXXXX", "X###X", "X###X")
                .aisle("XXXXX", "X###X", "X###X")
                .aisle("XXXXX", "X###X", "X###X")
                .aisle("XXXXX", "X###X", "X###X")
                .aisle("XXXXX", "X###X", "X###X")
                .aisle("XXXXX", "XICBX", "XXXXX")
                .where('C', GRTileEntities.INDUSTRIAL_FISHER, EnumFacing.SOUTH)
                .where('X', GRMetaBlocks.MULTIBLOCK_CASING.getState(GRMultiblockCasing.CasingType.FISHER_CASING))
                .where('#', Blocks.WATER.getDefaultState())
                .where('I', MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV], EnumFacing.SOUTH)
                .where('E', MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV], EnumFacing.NORTH)
                .where('B', MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV], EnumFacing.SOUTH)
                .build();
        return Lists.newArrayList(shapeInfo);
    }

    @Override
    public String[] getDescription()
    {
        return new String[] {I18n.format("gregtech.multiblock.industrial_fisher.description")};
    }

}
