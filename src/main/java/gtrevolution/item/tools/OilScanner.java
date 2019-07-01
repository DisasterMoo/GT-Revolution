package gtrevolution.item.tools;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.items.metaitem.stats.IItemBehaviour;
import gregtech.common.tools.ToolBase;

public class OilScanner extends ToolBase
{

    @Override
    public int getToolDamagePerBlockBreak(ItemStack stack) {
        return 10;
    }

    @Override
    public int getToolDamagePerContainerCraft(ItemStack stack) {
        return 5;
    }

    @Override
    public float getMaxDurabilityMultiplier(ItemStack stack) {
        return 40.0F;
    }


    public static class Behaviour implements IItemBehaviour
    {
        @Override
        public ActionResult<ItemStack> onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
        {

            ItemStack stack = player.getHeldItem(hand);
            IElectricItem electricItem = stack.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
            if (electricItem == null)
                return ActionResult.newResult(EnumActionResult.PASS, stack);
            player.setActiveHand(hand);
            return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
        }
    }
}