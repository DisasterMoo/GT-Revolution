package gtrevolution.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import gtrevolution.GTRevolution;
import gtrevolution.block.GRMetaBlocks;

@Mod.EventBusSubscriber(modid = GTRevolution.MODID, value = Side.CLIENT)
public class ClientHandler
{
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        GRMetaBlocks.registerItemModels();
    }
}
