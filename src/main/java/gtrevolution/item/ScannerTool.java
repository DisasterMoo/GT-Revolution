package gtrevolution.item;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import net.minecraftforge.fluids.FluidStack;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.toolitem.ToolMetaItem;
import gregtech.api.util.GTUtility;
import gtrevolution.item.tools.OilScanner;
import gtrevolution.machines.multi.OilRig;

public class ScannerTool extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem>
{

    public ScannerTool()
    {
        super();
        this.addPropertyOverride(new ResourceLocation("progress"), new IItemPropertyGetter()
        {
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                float ticksNeededForCompletion = 100.0F;
                if (entityIn == null)
                {
                    return 0.0F;
                }
                else
                {
                    if(entityIn.getActiveItemStack().getItem() != GRMetaItems.OIL_SCANNER.getMetaItem())return 0F;
                    IElectricItem electricItem = entityIn.getActiveItemStack().getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
                    if(electricItem == null || !electricItem.canUse(80000))return -1F;
                    return (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / ticksNeededForCompletion;
                }
            }
        });
        this.addPropertyOverride(new ResourceLocation("using"), new IItemPropertyGetter()
        {
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    @Override
    public void registerSubItems(){
        GRMetaItems.OIL_SCANNER = addItem(0,"tool.oil_scanner")
                .setToolStats(new OilScanner())
                .addStats(new OilScanner.Behaviour())
                .addStats(ElectricStats.createElectricItem(1600000L, 3L));
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if(worldIn.isRemote)return;
        int ticksInUse = this.getMaxItemUseDuration(stack) - timeLeft;
        if(ticksInUse >= 100) {
            GTUtility.doDamageItem(stack, 800, false);
            Chunk chunkAt = worldIn.getChunkFromBlockCoords(entityLiving.getPosition());
            FluidStack output = new OilRig.ChunkReserve(chunkAt.x, chunkAt.z, worldIn.getSeed()).getOutput();
            if (output != null)
            {
                entityLiving.sendMessage(new TextComponentString("Found " + output.getLocalizedName() + "{" + output.amount + " mB}"));
            }
            else
            {
                entityLiving.sendMessage(new TextComponentString("No oil reserves found"));
            }
        }
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.NONE;
    }
}