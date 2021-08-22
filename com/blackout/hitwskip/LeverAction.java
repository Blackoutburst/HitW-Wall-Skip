package com.blackout.hitwskip;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.BlockPos;

public class LeverAction {

	/**
	 * Search for a lever around the player in a 8x8x8 box 
	 * @return the position of the first lever found in the area
	 */
	public BlockPos searchLever() {
		BlockPos playerPos = HitwSkip.player.getPosition();
		
		for (int x = playerPos.getX() - 4; x < playerPos.getX() + 4; x++) {
			for (int y = playerPos.getY() - 4; y < playerPos.getY() + 4; y++) {
				for (int z = playerPos.getZ() - 4; z < playerPos.getZ() + 4; z++) {
					Block block = HitwSkip.world.getBlockState(new BlockPos(x, y, z)).getBlock();
					if (block.getUnlocalizedName().equals("tile.lever")) {
						return (new BlockPos(x, y-1, z));
					}
				}
			}
		}
		return (null);
	}
	
	/**
	 * When the player is looking at any lever it right click twice per seconds
	 */
	public void flickLever() {
		BlockPos pos = null;
		try {
			pos = Minecraft.getMinecraft().objectMouseOver.getBlockPos();
		} catch (Exception e) {}
		
		Block block = null;
		
		if (pos != null) block = HitwSkip.world.getBlockState(pos).getBlock();
		if (block != null && block.getUnlocalizedName().equals("tile.lever") && ClientEvent.tick > 10) {
			ClientEvent.tick = 0;
			KeyBinding.onTick(Minecraft.getMinecraft().gameSettings.keyBindUseItem.getKeyCode());
		}
	}
	
}
