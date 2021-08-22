package com.blackout.hitwskip;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientEvent {

	public static int tick = 0;
	
	@SubscribeEvent
	public void onClientTickEvent(final ClientTickEvent event) {
		tick++;
		if (HitwSkip.world == null || HitwSkip.player == null) return;
		BlockPos leverPos = new LeverAction().searchLever();
		if (leverPos == null) return;
		new CameraMovement().lookLever(leverPos);
		new LeverAction().flickLever();
	}
	
	@SubscribeEvent
	public void onPlayerJoin(final EntityJoinWorldEvent event) {
		HitwSkip.player = Minecraft.getMinecraft().thePlayer;
		HitwSkip.world = Minecraft.getMinecraft().theWorld;
		KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindsHotbar[1].getKeyCode());
    }
}
