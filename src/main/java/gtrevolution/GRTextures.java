package gtrevolution;

import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.SimpleCubeRenderer;

@SuppressWarnings("WeakerAccess")
public class GRTextures
{
    public static final SimpleCubeRenderer MACERATION_CASING;
    public static final SimpleCubeRenderer WASHPLANT_CASING;
    public static final SimpleCubeRenderer THERMAL_CASING;
    public static final SimpleCubeRenderer FISHER_CASING;
    public static final SimpleCubeRenderer ELECTROLYZER_CASING;
    public static final SimpleCubeRenderer CHEMICAL_CASING;
    public static final SimpleCubeRenderer CENTRIFUGE_CASING;
    public static final SimpleCubeRenderer SIEVE_CASING;
    public static final SimpleCubeRenderer SIEVE_GRATE;
    public static final SimpleCubeRenderer CUTTER_CASING;
    public static final SimpleCubeRenderer LASER_CASING;
    public static final SimpleCubeRenderer WIRE_CASING;

    public static OrientedOverlayRenderer INDUSTRIAL_MACERATOR_OVERLAY;
    public static OrientedOverlayRenderer INDUSTRIAL_LASER_OVERLAY;

    static
    {
        MACERATION_CASING = new SimpleCubeRenderer("casings/industrial/maceration_casing");
        WASHPLANT_CASING = new SimpleCubeRenderer("casings/industrial/washplant_casing");
        THERMAL_CASING = new SimpleCubeRenderer("casings/industrial/thermal_casing");
        FISHER_CASING = new SimpleCubeRenderer("casings/industrial/fisher_casing");
        ELECTROLYZER_CASING = new SimpleCubeRenderer("casings/industrial/electrolyzer_casing");
        CHEMICAL_CASING = new SimpleCubeRenderer("casings/industrial/chemical_casing");
        CENTRIFUGE_CASING = new SimpleCubeRenderer("casings/industrial/centrifuge_casing");
        SIEVE_CASING = new SimpleCubeRenderer("casings/industrial/sieve_casing");
        SIEVE_GRATE = new SimpleCubeRenderer("casings/industrial/sieve_grate");
        WIRE_CASING = new SimpleCubeRenderer("casings/industrial/wire_casing");
        CUTTER_CASING = new SimpleCubeRenderer("casings/industrial/cutter_casing");
        LASER_CASING = new SimpleCubeRenderer("casings/industrial/laser_casing");

        INDUSTRIAL_MACERATOR_OVERLAY = new OrientedOverlayRenderer("machines/industrial_macerator",
                OrientedOverlayRenderer.OverlayFace.FRONT);

        INDUSTRIAL_LASER_OVERLAY = new OrientedOverlayRenderer("machines/industrial_laser",
                OrientedOverlayRenderer.OverlayFace.FRONT);
    }
}
