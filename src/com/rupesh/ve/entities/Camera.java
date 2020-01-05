package com.rupesh.ve.entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import com.rupesh.ve.util.CommonConstants;

public class Camera
{
	Vector3f mPos;
	float mfRotX;
	float mfRotY;
	float mfRotZ;
	
	float lfMoveAt = 0;
	
	public Camera(Vector3f pPos, float pRotX, float pRotY, float pRotZ) 
	{
		this.mPos = pPos;
		this.mfRotX = pRotX;
		this.mfRotY = pRotY;
		this.mfRotZ = pRotZ;	
	}
	
	public Vector3f getPosition()
	{
		return mPos;
	}

	public float getRotX() 
	{
		return mfRotX;
	}
	
	public float getRotY() 
	{
		return mfRotY;
	}

	public float getRotZ()
	{
		return mfRotZ;
	}
	
	public void move() {
		
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) 
		{
			lfMoveAt = -CommonConstants.CAMERA_SPEED;
		} 
		else if (Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			lfMoveAt = CommonConstants.CAMERA_SPEED;
		} 
		else 
		{
			lfMoveAt = 0;
		}
			
		mfRotX += -Mouse.getDY() * CommonConstants.CAMERA_TURN_SPEED;
		mfRotY += Mouse.getDX() * CommonConstants.CAMERA_TURN_SPEED;
		
		float dx = (float) -(lfMoveAt * Math.sin(Math.toRadians(mfRotY)));
		float dy = (float) (lfMoveAt * Math.sin(Math.toRadians(mfRotX)));
		float dz = (float) (lfMoveAt * Math.cos(Math.toRadians(mfRotY)));
		
		mPos.x = mPos.x + dx;
		mPos.y = mPos.y + dy;
		mPos.z = mPos.z + dz;
		
	}
}
