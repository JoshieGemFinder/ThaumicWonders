package com.verdantartifice.thaumicwonders;

import org.apache.logging.log4j.Logger;

import com.verdantartifice.thaumicwonders.common.misc.CreativeTabTW;
import com.verdantartifice.thaumicwonders.proxy.IProxyTW;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ThaumicWonders.MODID, name = ThaumicWonders.NAME, version = ThaumicWonders.VERSION, dependencies = ThaumicWonders.DEPENDENCIES)
public class ThaumicWonders
{
    public static final String MODID = "thaumicwonders";
    public static final String NAME = "Thaumic Wonders";
    public static final String VERSION = "1.0.0";
    public static final String DEPENDENCIES = "required-after:thaumcraft";

    public static final CreativeTabs CREATIVE_TAB = new CreativeTabTW(CreativeTabs.getNextID(), ThaumicWonders.MODID);

    public static Logger LOGGER;
    
    @Mod.Instance(ThaumicWonders.MODID)
    public static ThaumicWonders INSTANCE;
    
    @SidedProxy(clientSide="com.verdantartifice.thaumicwonders.proxy.ClientProxy", serverSide="com.verdantartifice.thaumicwonders.proxy.ServerProxy")
    public static IProxyTW proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
}
