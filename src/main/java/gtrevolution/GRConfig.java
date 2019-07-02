package gtrevolution;

import net.minecraftforge.common.config.Config;

@Config(modid = GTRevolution.MODID)
public class GRConfig
{

    @Config.Comment("Config options for multiblock features")
    public static Multiblocks multiblocks = new Multiblocks();

    public static class Multiblocks {
        @Config.Comment("Should Electric Blast Furnace be improved(each 2 tier of coils overclock recipes) ?")
        @Config.Name("Improved EBF")
        public boolean EBF = true;
        
        @Config.Comment("Multiblock macerator")
        @Config.Name("Industrial Macerator")
        public boolean Macerator = true;
        
        @Config.Comment("Multiblock Thermal Centrifuge")
        @Config.Name("Industrial Thermal Centrifuge")
        public boolean Thermal = true;
        
        @Config.Comment("Multiblock Ore Washing")
        @Config.Name("Industrial Ore Washing")
        public boolean Orewash = true;
        
        @Config.Comment("Multiblock Centrifuge")
        @Config.Name("Industrial Centrifuge")
        public boolean Centrifuge = true;
        
        @Config.Comment("Multiblock Sifting")
        @Config.Name("Industrial Sifter")
        public boolean Sifter = true;
        
        @Config.Comment("Multiblock Electrolyzer")
        @Config.Name("Industrial Electrolyzer")
        public boolean Electrolyzer = true;
        
        @Config.Comment("Multiblock Wiremill")
        @Config.Name("Wire Factory")
        public boolean Wiremill = true;
        
        @Config.Comment("Industrial machine that produces fish")
        @Config.Name("Industrial Fisher")
        public boolean Fisher = true;

        @Config.Comment("Industrial machine that pumps oil from chunks")
        @Config.Name("Oil Rig")
        public boolean OilRig = true;
    }

    @Config.Comment("Config options for miscellaneous stuff")
    public static Misc misc = new Misc();

    public static class Misc {
        @Config.Comment("LV-LuV Superconductor cables")
        @Config.Name("Superconductors")
        public boolean Superconductors = true;

        @Config.Comment("Make small gears harder to craft")
        @Config.Name("Harder small gears")
        public boolean HarderSmallGears = true;

        @Config.Comment("Make all casings recipes outputs only one per craft")
        @Config.Name("Harder casings")
        public boolean HarderCasings = true;

        @Config.Comment("Disable cheap rubber for IV+ cables")
        @Config.Name("Harder cables")
        public boolean HarderCables = true;

        @Config.Comment("Make all fuel cracking recipes in the chemical reactor worse than using the cracking unit")
        @Config.Name("Harder Fuel Cracking")
        public boolean HarderFuelCracking = true;

        @Config.Comment("Make everything related to circuitry harder with more options and steps")
        @Config.Name("Circuit overhaul")
        public boolean CircuitOverhaul = true;
    }
}
