package gtrevolution;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import gtrevolution.block.GRMetaBlocks;


@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        GRMetaBlocks.registerItemModels();
    }

    public void preInit()
    {
        super.preInit();
        new GRTextures();
    }

    public void postInit()
    {

    }
}
