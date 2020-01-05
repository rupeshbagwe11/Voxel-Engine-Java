package com.rupesh.ve.util;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.rupesh.ve.entities.Camera;

public class Helper
{
	public static long mStartTime = 0;
	private static long miAnimationCounter = 0;
	
	public static long getAnimationCounter()
	{
		long lCurrTime = System.currentTimeMillis();
		long lDiffTime = lCurrTime - mStartTime;
		
		if( lDiffTime > 2000 )
		{
			mStartTime = lCurrTime;
			miAnimationCounter++;	
		}	
			
		return miAnimationCounter;
	}
	
	public static Matrix4f createProjectionMatrix()
	{	
		Matrix4f lProjectionMatrix = new Matrix4f();
		
		float lfAspectRatio = (float) Display.getWidth() / (float) Display.getHeight();
		float lfYScale = (float) (1f / Math.tan(Math.toRadians(CommonConstants.FOV / 2f)));
		float lfXScale = lfYScale / lfAspectRatio;
		float lfZP = CommonConstants.FAR_PLANE + CommonConstants.NEAR_PLANE;
		float lfZM = CommonConstants.FAR_PLANE / CommonConstants.NEAR_PLANE;
		
		lProjectionMatrix.m00 = lfXScale;
		lProjectionMatrix.m11 = lfYScale;
		lProjectionMatrix.m22 = -lfZP/lfZM;
		lProjectionMatrix.m23 = -1;
		lProjectionMatrix.m32 = -(2 * CommonConstants.FAR_PLANE * CommonConstants.NEAR_PLANE) / lfZM;
		lProjectionMatrix.m33 = 0;
		
		return lProjectionMatrix;
	}
	
	public static Matrix4f createViewMatrix(Camera pCamera)
	{	
		Matrix4f lMatrix = new Matrix4f();
		lMatrix.setIdentity();
		
		Matrix4f.rotate((float) Math.toRadians(pCamera.getRotX()), new Vector3f(1, 0, 0),  lMatrix, lMatrix);
		Matrix4f.rotate((float) Math.toRadians(pCamera.getRotY()), new Vector3f(0, 1, 0),  lMatrix, lMatrix);
		Matrix4f.rotate((float) Math.toRadians(pCamera.getRotZ()), new Vector3f(0, 0, 1),  lMatrix, lMatrix);
		Matrix4f.translate(new Vector3f(-pCamera.getPosition().x, -pCamera.getPosition().y, -pCamera.getPosition().z), lMatrix, lMatrix);
		
		return lMatrix;
		
	}
	
	public static int getHeight(int pX, int pZ)
	{
		int liHeight = 0;
		if( pX == 0 || pZ == 0 || pX == 15 || pZ == 15 )
		{
			liHeight = 1;
		}
		else if( pX == 1 || pZ == 1 || pX == 14 || pZ == 14 )
		{
			liHeight = 2;
		}
		else if( pX == 2 || pZ == 2 || pX == 13 || pZ == 13 )
		{
			liHeight = 3;
		}
		else if( pX == 3 || pZ == 3 || pX == 12 || pZ == 12 )
		{
			liHeight = 4;
		}
		else if( pX == 4 || pZ == 4 || pX == 11 || pZ == 11 )
		{
			liHeight = 5;
		}
		else if( pX == 5 || pZ == 5 || pX == 10 || pZ == 10 )
		{
			liHeight = 6;
		}
		else if( pX == 6 || pZ == 6 || pX == 9 || pZ == 9 )
		{
			liHeight = 7;
		}
		else if( pX == 7 || pZ == 7 || pX == 8 || pZ == 8 )
		{
			liHeight = 8;
		}
		
		if( pX == 7 || pZ == 7 || pX == 8 || pZ == 8 )
		{
			liHeight++;
		}
		
		if( pX == pZ)
		{
			liHeight++;
		}
		
		return liHeight;
	}
	
	public static float getRandomNumberFloat(float pMin, float pMax)
	{
		float lfRandom = (float) (pMin + Math.random() * (pMax - pMin));
		return lfRandom;
	}
	
	public static float getRandomNumberInteger(int pMin, int pMax)
	{
		int liRandom = (int) (pMin + Math.random() * (pMax - pMin));
		return liRandom;
	}
	
	
}
