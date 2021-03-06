package omtteam.ompd.compatability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import omtteam.ompd.reference.Reference;

import java.util.logging.Logger;

/**
 * Created by Keridos on 23/01/2015. This Class
 */
public class ModCompatibility {
    public static boolean IGWModLoaded = false;
    public static boolean ThermalExpansionLoaded = false;
    public static boolean EnderIOLoaded = false;
    public static boolean MekanismLoaded = false;
    public static boolean ThaumcraftLoaded = false;
    public static boolean OpenComputersLoaded = false;
    public static boolean ComputercraftLoaded = false;
    public static boolean IC2Loaded = false;
    public static IGWHandler igwHandler = null;
    private static Logger logger;

    public static void checkForMods() {
        logger = Logger.getLogger("OpenModularTurrets");

        ThermalExpansionLoaded = Loader.isModLoaded("ThermalExpansion");
        if (ThermalExpansionLoaded) {
            logger.info("Hi there, dV=V0B(t1-t0)! (Found ThermalExpansion)");
        }

        EnderIOLoaded = Loader.isModLoaded("EnderIO");
        if (EnderIOLoaded) {
            logger.info("Not sure if iron ingot, or electrical steel ingot... (Found EnderIO)");
        }

        MekanismLoaded = Loader.isModLoaded("Mekanism");
        if (MekanismLoaded) {
            logger.info("Mur omsimu, plz. (Found Mekanism)");
        }

        ThaumcraftLoaded = Loader.isModLoaded("Thaumcraft");
        if (ThaumcraftLoaded) {
            logger.info("Afrikaners is plesierig. (Found Thaumcraft)");
        }

        OpenComputersLoaded = Loader.isModLoaded("OpenComputers");
        ComputercraftLoaded = Loader.isModLoaded("ComputerCraft");
        if (OpenComputersLoaded || ComputercraftLoaded) {
            logger.info("Enabling LUA integration. (Found OpenComputers/ComputerCraft)");
        }
        IC2Loaded = Loader.isModLoaded("IC2");

        IGWModLoaded = Loader.isModLoaded("IGWMod");
    }

    private static void addVersionCheckerInfo() {
        NBTTagCompound versionchecker = new NBTTagCompound();
        versionchecker.setString("curseProjectName", "254332-opmd");
        versionchecker.setString("curseFilenameParser", "ompd-1.7.10-[].jar");
        versionchecker.setString("modDisplayName", "Open Modular Passive Defense");
        versionchecker.setString("oldVersion", Reference.VERSION);
        FMLInterModComms.sendRuntimeMessage("omtteam/ompd", "VersionChecker", "addCurseCheck", versionchecker);
    }

    public static void performModCompat() {
        FMLInterModComms.sendMessage("Waila", "register",
                                     "omtteam.ompd.compatability.WailaTileHandler.callbackRegister");
        addVersionCheckerInfo();
        if (ComputercraftLoaded) {
            registerCCCompat();
        }
    }

    @Optional.Method(modid = "ComputerCraft")
    private static void registerCCCompat() {
        //ComputerCraftAPI.registerPeripheralProvider(CCPeripheralProvider.getInstance());
    }

}
