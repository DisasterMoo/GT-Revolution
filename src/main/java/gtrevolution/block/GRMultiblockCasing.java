package gtrevolution.block;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import gregtech.common.blocks.VariantBlock;
import mcp.MethodsReturnNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GRMultiblockCasing extends VariantBlock<GRMultiblockCasing.CasingType>
{
    public GRMultiblockCasing()
    {
        super(Material.IRON);
        setUnlocalizedName("gr_multiblock_casing");
        setHardness(5.0f);
        setResistance(10.0f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(CasingType.MACERATION_CASING));
    }

    @SideOnly(Side.CLIENT)
    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type)
    {
        return false;
    }


    public enum CasingType implements IStringSerializable
    {

        MACERATION_CASING("maceration_casing"),
        WASHPLANT_CASING("washplant_casing"),
        THERMAL_CASING("thermal_casing"),
        CHEMICAL_CASING("chemical_casing"),
        FISHER_CASING("fisher_casing"),
        ELECTROLYZER_CASING("electrolyzer_casing"),
        CENTRIFUGE_CASING("centrifuge_casing"),
        SIEVE_CASING("sieve_casing"),
        SIEVE_GRATE("sieve_grate"),
        CUTTER_CASING("cutter_casing"),
        LASER_CASING("laser_casing"),
        WIRE_CASING("wire_casing"),

        TUNGSTENSTEEL_GEARBOX_CASING("tungstensteel_gearbox_casing"),

        REINFORCED_GLASS("reinforced_glass");

        private final String name;

        CasingType(String name)
        {
            this.name = name;
        }

        @Override
        public String getName()
        {
            return this.name;
        }

    }
}
