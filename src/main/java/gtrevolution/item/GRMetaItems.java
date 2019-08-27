package gtrevolution.item;

import gregtech.api.items.metaitem.MetaItem;

public class GRMetaItems
{
    public static MetaItem<?>.MetaValueItem OIL_SCANNER;

    //Extruder Shapes
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_SMALLGEAR;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_ROTOR;

    //Circuit Overhaul
    public static MetaItem<?>.MetaValueItem CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem PHENOLIC_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem PLASTIC_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem EPOXY_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem FIBER_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem MULTILAYER_FIBER_CIRCUIT_BOARD;
    public static MetaItem<?>.MetaValueItem WETWARE_CIRCUIT_BOARD;

    //Petri Dish
    public static MetaItem<?>.MetaValueItem PETRI_DISH;

    //Replacement for ULV and LV circuits(not tiered)
    public static MetaItem<?>.MetaValueItem NAND_CHIP; //ULV circuit/Vaccum tube replacement, MV assembler needed. use SoC on HV
    public static MetaItem<?>.MetaValueItem MICRO_CHIP; //LV Circuit replacement, HV assembler needed, use SoC on EV

    //1st tier circuits (made by hand and LV assembler)
    //Hand
    public static MetaItem<?>.MetaValueItem BASIC_CIRCUIT;
    public static MetaItem<?>.MetaValueItem BASIC_CIRCUIT_ARRAY;
    //Assembling LV
    public static MetaItem<?>.MetaValueItem GOOD_CIRCUIT;
    public static MetaItem<?>.MetaValueItem ADV_CIRCUIT;

    //2nd tier circuits (MV assembler)
    public static MetaItem<?>.MetaValueItem INTEGRATED_CIRCUIT;
    public static MetaItem<?>.MetaValueItem INTEGRATED_PROCESSOR;
    public static MetaItem<?>.MetaValueItem INTEGRATED_PROCESSOR_ARRAY;
    public static MetaItem<?>.MetaValueItem INTEGRATED_PROCESSOR_MAINFRAME;

    //3rd tier circuits (HV assembler)
    public static MetaItem<?>.MetaValueItem MICRO_CIRCUIT;
    public static MetaItem<?>.MetaValueItem MICRO_PROCESSOR;
    public static MetaItem<?>.MetaValueItem MICRO_PROCESSOR_ARRAY;
    public static MetaItem<?>.MetaValueItem MICRO_PROCESSOR_MAINFRAME;

    //4th tier circuits (EV assembler)
    public static MetaItem<?>.MetaValueItem NANO_CIRCUIT;
    public static MetaItem<?>.MetaValueItem NANO_PROCESSOR;
    public static MetaItem<?>.MetaValueItem NANO_PROCESSOR_ARRAY;
    public static MetaItem<?>.MetaValueItem NANO_PROCESSOR_MAINFRAME;

    //5th tier circuits (IV assembler)
    public static MetaItem<?>.MetaValueItem QUANTUM_CIRCUIT;
    public static MetaItem<?>.MetaValueItem QUANTUM_PROCESSOR;
    public static MetaItem<?>.MetaValueItem QUANTUM_PROCESSOR_ARRAY;
    public static MetaItem<?>.MetaValueItem QUANTUM_PROCESSOR_MAINFRAME;

    //6th tier circuits (LuV assembler)
    public static MetaItem<?>.MetaValueItem CRYSTAL_CIRCUIT;
    public static MetaItem<?>.MetaValueItem CRYSTAL_PROCESSOR;
    public static MetaItem<?>.MetaValueItem CRYSTAL_PROCESSOR_ARRAY;
    public static MetaItem<?>.MetaValueItem CRYSTAL_PROCESSOR_MAINFRAME;

    //7th tier circuits (ZPM assembler)
    public static MetaItem<?>.MetaValueItem WETWARE_CIRCUIT;
    public static MetaItem<?>.MetaValueItem WETWARE_PROCESSOR;
    public static MetaItem<?>.MetaValueItem WETWARE_PROCESSOR_ARRAY;
    //public static MetaItem<?>.MetaValueItem WETWARE_PROCESSOR_MAINFRAME; //Use the GTCE one

    public static MetaItem<?>.MetaValueItem SIMPLE_SYSTEM_ON_CHIP_WAFER;
    public static MetaItem<?>.MetaValueItem SIMPLE_SYSTEM_ON_CHIP;

    public static void init()
    {
        GRMetaItem item = new GRMetaItem();
        item.setRegistryName("gr_meta_item");
        ScannerTool scanner = new ScannerTool();
        scanner.setRegistryName("gr_meta_scannertool");
    }
}
