package gtrevolution;

import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import gtrevolution.block.GRMetaBlocks;
import gtrevolution.item.GRMetaItems;
import gtrevolution.machines.GRTileEntities;

@SuppressWarnings("WeakerAccess")
@Mod(modid = GTRevolution.MODID,
        name = GTRevolution.NAME,
        version = GTRevolution.VERSION,
        dependencies = "required-after:gregtech")
public class GTRevolution
{
    public static final String MODID = "gtrevolution";
    public static final String NAME = "GT Revolution";
    public static final String VERSION = "@VERSION@";

    private static Logger logger;

    public static Logger getLogger()
    {
        return logger;
    }

    public GTRevolution()
    {
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        GRMetaItems.init();
        GRMetaBlocks.init();
        GRTileEntities.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}
