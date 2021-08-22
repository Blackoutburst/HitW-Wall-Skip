package com.blackout.hitwskip;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
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
