package com.blackout.hitwskip;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class CameraMovement {

	/**
	 * Get the yaw and pitch the camera need to look at the lever
	 * @param vec
	 * @return
	 */
	private float[] getNeededRotations2(Vec3 vec)
	{
		Vec3 eyesPos = new Vec3(HitwSkip.player.posX, HitwSkip.player.posY + HitwSkip.player.eyeHeight, HitwSkip.player.posZ);
		
		double diffX = vec.xCoord - eyesPos.xCoord;
		double diffY = vec.yCoord - eyesPos.yCoord;
		double diffZ = vec.zCoord - eyesPos.zCoord;
		
		double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
		
		float yaw = (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90F;
		float pitch = (float)-Math.toDegrees(Math.atan2(diffY, diffXZ));
		
		return new float[]{
				HitwSkip.player.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - HitwSkip.player.rotationYaw), 
				HitwSkip.player.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - HitwSkip.player.rotationPitch)};
	}
	
	/**
	 * Make the player look at the lever
	 * @param pos
	 */
	public void lookLever(BlockPos pos) {
		Vec3 posVec = new Vec3(pos).addVector(0.5, 0.5, 0.5);
		Vec3 hitVec = posVec.add(new Vec3(EnumFacing.UP.getDirectionVec()));
		float[] rot = getNeededRotations2(hitVec);
		
		smoothMovement(rot);
	}
	
	/**
	 * Smooth the camera movement to avoid instant rotation
	 * The camera movement isn't smooth client side but from the
	 * server POV this is smooth
	 * @param rot
	 */
	private void smoothMovement(float[] rot) {
		if (HitwSkip.player.rotationYaw < rot[0] - 5) HitwSkip.player.rotationYaw += 5;
		if (HitwSkip.player.rotationYaw > rot[0] + 5) HitwSkip.player.rotationYaw -= 5;
		if (HitwSkip.player.rotationPitch < rot[1] - 2.5) HitwSkip.player.rotationPitch += 2.5;
		if (HitwSkip.player.rotationPitch > rot[1] + 2.5) HitwSkip.player.rotationPitch -= 2.5;
		if (HitwSkip.player.rotationYaw < rot[0] - 1) HitwSkip.player.rotationYaw += 1;
		if (HitwSkip.player.rotationYaw > rot[0] + 1) HitwSkip.player.rotationYaw -= 1;
		if (HitwSkip.player.rotationPitch < rot[1] - 1) HitwSkip.player.rotationPitch += 1;
		if (HitwSkip.player.rotationPitch > rot[1] + 1) HitwSkip.player.rotationPitch -= 1;
	}
	
}
