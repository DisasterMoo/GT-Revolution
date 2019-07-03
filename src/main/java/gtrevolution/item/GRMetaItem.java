package gtrevolution.item;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gtrevolution.GRConfig;

public class GRMetaItem extends MaterialMetaItem
{
    public GRMetaItem()
    {
        super();
    }

    @Override
    public void registerSubItems()
    {
        //Extruder
        GRMetaItems.SHAPE_EXTRUDER_SMALLGEAR = addItem(0, "shape.extruder.smallgear");
        GRMetaItems.SHAPE_EXTRUDER_ROTOR = addItem(1, "shape.extruder.rotor");

        //Circuit Overhaul
        if(GRConfig.misc.CircuitOverhaul)
        {
            //Boards
            GRMetaItems.CIRCUIT_BOARD = addItem(2, "board.circuit.basic");
            GRMetaItems.PHENOLIC_CIRCUIT_BOARD = addItem(3, "board.circuit.advanced");
            GRMetaItems.PLASTIC_CIRCUIT_BOARD = addItem(4, "board.circuit.plastic");
            GRMetaItems.EPOXY_CIRCUIT_BOARD = addItem(5, "board.circuit.epoxy");
            GRMetaItems.FIBER_CIRCUIT_BOARD = addItem(6, "board.circuit.fiber");
            GRMetaItems.MULTILAYER_FIBER_CIRCUIT_BOARD = addItem(7, "board.circuit.multilayer_fiber");
            GRMetaItems.WETWARE_CIRCUIT_BOARD = addItem(8, "board.circuit.wetware");

            GRMetaItems.PETRI_DISH = addItem(9, "cylinder.petri_dish");

            //Replacement for ULV and LV circuits(not tiered)
            GRMetaItems.NAND_CHIP = addItem(10, "assembly.circuit.nand_chip").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Primitive); //ULV circuit/Vacuum tube replacement, MV assembler needed. use SoC on HV
            GRMetaItems.MICRO_CHIP = addItem(11, "assembly.circuit.micro_chip").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Basic); //LV Circuit replacement, HV assembler needed, use SoC on EV

            //1st tier circuits (made by hand and LV assembler)
            GRMetaItems.BASIC_CIRCUIT = addItem(12, "assembly.circuit.basic_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Basic);
            GRMetaItems.BASIC_CIRCUIT_ARRAY = addItem(13, "assembly.circuit.basic_circuit_array").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Good);

            GRMetaItems.GOOD_CIRCUIT = addItem(14, "assembly.circuit.good_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Good);
            GRMetaItems.ADV_CIRCUIT = addItem(15, "assembly.circuit.adv_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Advanced);

            //2nd tier circuits (MV assembler)
            GRMetaItems.INTEGRATED_CIRCUIT = addItem(16, "assembly.circuit.integrated_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Basic);
            GRMetaItems.INTEGRATED_PROCESSOR = addItem(17, "assembly.circuit.integrated_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Good);
            GRMetaItems.INTEGRATED_PROCESSOR_ARRAY = addItem(18, "assembly.circuit.integrated_processor_array").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Advanced);
            GRMetaItems.INTEGRATED_PROCESSOR_MAINFRAME = addItem(19, "assembly.circuit.integrated_processor_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Extreme);

            //3rd tier circuits (HV assembler)
            GRMetaItems.MICRO_CIRCUIT = addItem(20, "assembly.circuit.micro_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Good);
            GRMetaItems.MICRO_PROCESSOR = addItem(21, "assembly.circuit.micro_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Advanced);
            GRMetaItems.MICRO_PROCESSOR_ARRAY = addItem(22, "assembly.circuit.micro_processor_array").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Extreme);
            GRMetaItems.MICRO_PROCESSOR_MAINFRAME = addItem(23, "assembly.circuit.micro_processor_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Elite);

            //4th tier circuits (EV assembler)
            GRMetaItems.NANO_CIRCUIT = addItem(24, "assembly.circuit.nano_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Advanced);
            GRMetaItems.NANO_PROCESSOR = addItem(25, "assembly.circuit.nano_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Extreme);
            GRMetaItems.NANO_PROCESSOR_ARRAY = addItem(26, "assembly.circuit.nano_processor_array").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Elite);
            GRMetaItems.NANO_PROCESSOR_MAINFRAME = addItem(27, "assembly.circuit.nano_processor_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Master);

            //5th tier circuits (IV assembler)
            GRMetaItems.QUANTUM_CIRCUIT = addItem(28, "assembly.circuit.quantum_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Extreme);
            GRMetaItems.QUANTUM_PROCESSOR = addItem(29, "assembly.circuit.quantum_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Elite);
            GRMetaItems.QUANTUM_PROCESSOR_ARRAY = addItem(30, "assembly.circuit.quantum_processor_array").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Master);
            GRMetaItems.QUANTUM_PROCESSOR_MAINFRAME = addItem(31, "assembly.circuit.quantum_processor_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultimate);

            //6th tier circuits (LuV assembler)
            GRMetaItems.CRYSTAL_CIRCUIT = addItem(32, "assembly.circuit.crystal_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Elite);
            GRMetaItems.CRYSTAL_PROCESSOR = addItem(33, "assembly.circuit.crystal_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Master);
            GRMetaItems.CRYSTAL_PROCESSOR_ARRAY = addItem(34, "assembly.circuit.crystal_processor_array").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultimate);
            GRMetaItems.CRYSTAL_PROCESSOR_MAINFRAME = addItem(35, "assembly.circuit.crystal_processor_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Superconductor);

            //7th tier circuits (ZPM assembler)
            GRMetaItems.WETWARE_CIRCUIT = addItem(36, "assembly.circuit.wetware_circuit").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Master);
            GRMetaItems.WETWARE_PROCESSOR = addItem(37, "assembly.circuit.wetware_processor").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Ultimate);
            GRMetaItems.WETWARE_PROCESSOR_ARRAY = addItem(38, "assembly.circuit.wetware_processor_array").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Superconductor);
            //GRMetaItems.WETWARE_PROCESSOR_MAINFRAME = addItem(39, "assembly.circuit.wetware_processor_mainframe").setUnificationData(OrePrefix.circuit, MarkerMaterials.Tier.Infinite);

            //Simple SoC
            GRMetaItems.SIMPLE_SYSTEM_ON_CHIP_WAFER = addItem(40, "wafer.simple_system_on_chip");
            GRMetaItems.SIMPLE_SYSTEM_ON_CHIP = addItem(41, "plate.simple_system_on_chip");

        }
    }
}
