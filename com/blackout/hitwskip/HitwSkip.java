package com.blackout.hitwskip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = HitwSkip.MODID, version = HitwSkip.VERSION)
public class HitwSkip
{
    public static final String MODID = "hitwskip";
    public static final String VERSION = "1.0";
    public static EntityPlayer player = null;
	public static World world = null;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new ClientEvent());
    }
}
