package com.rupesh.ve.models;

import com.rupesh.ve.renderengine.Loader;
import com.rupesh.ve.util.CommonConstants;

public class UnitCow extends IUnitCube
{	
	//Id where the array will be stored in VAO
	int miVAOId;	
	int miTextureId;
	
	public static final int COW_WHITE = 1;
	public static final int COW_BROWN = 2;
	
	
	public static float[] liUV = {
			
			//tail
			6.15f / 10f, 0.8f / 6f,
			6.15f / 10f, 2.5f / 6f,
			8.05f / 10f, 2.5f / 6f,
			8.05f / 10f, 0.8f / 6f,
			
			4.00f / 10f, 2.65f / 6f,
			4.00f / 10f, 4.65f / 6f,
			8.05f / 10f, 4.65f / 6f,
			8.05f / 10f, 2.65f / 6f,
			
			4.00f / 10f, 2.65f / 6f,
			4.00f / 10f, 4.65f / 6f,
			8.05f / 10f, 4.65f / 6f,
			8.05f / 10f, 2.65f / 6f,
			
			4.00f / 10f, 2.65f / 6f,
			4.00f / 10f, 4.65f / 6f,
			8.05f / 10f, 4.65f / 6f,
			8.05f / 10f, 2.65f / 6f,
				
			4.00f / 10f, 2.65f / 6f,
			4.00f / 10f, 4.65f / 6f,
			8.05f / 10f, 4.65f / 6f,
			8.05f / 10f, 2.65f / 6f,
			
			4.00f / 10f, 2.65f / 6f,
			4.00f / 10f, 4.65f / 6f,
			8.05f / 10f, 4.65f / 6f,
			8.05f / 10f, 2.65f / 6f,
			
			//facepart
			4.00f / 10f, 2.65f / 6f,
			4.00f / 10f, 4.65f / 6f,
			9.05f / 10f, 4.65f / 6f,
			9.05f / 10f, 2.65f / 6f,
			
//			0.35f / 10f, 1.25f / 6f,
//			0.35f / 10f, 2.6f / 6f,
//			2.85f / 10f, 2.6f / 6f,
//			2.85f / 10f, 1.25f / 6f,
			
			0.7f / 10f, 1.25f / 6f,
			0.7f / 10f, 2.6f / 6f,
			2.55f / 10f, 2.6f / 6f,
			2.55f / 10f, 1.25f / 6f,
			
			0.2f / 10f, 1.25f / 6f,
			0.2f / 10f, 2.6f / 6f,
			0.65f / 10f, 2.6f / 6f,
			0.65f / 10f, 1.25f / 6f,
			
			0.2f / 10f, 1.25f / 6f,
			0.2f / 10f, 2.6f / 6f,
			0.65f / 10f, 2.6f / 6f,
			0.65f / 10f, 1.25f / 6f,
				
			0.7f / 10f, 0.25f / 6f,
			0.7f / 10f, 1.25f / 6f,
			2.55f / 10f, 1.25f / 6f,
			2.55f / 10f, 0.25f / 6f,
			
			4.00f / 10f, 2.65f / 6f,
			4.00f / 10f, 4.65f / 6f,
			8.05f / 10f, 4.65f / 6f,
			8.05f / 10f, 2.65f / 6f
			
	};
	
	public static float[] lfVertices = {			
			-0.5f,0.5f,-0.5f,	
			-0.5f,-0.5f,-0.5f,	
			0.5f,-0.5f,-0.5f,	
			0.5f,0.5f,-0.5f,		
			
			-0.5f,0.5f,0.5f,	
			-0.5f,-0.5f,0.5f,	
			0.5f,-0.5f,0.5f,	
			0.5f,0.5f,0.5f,
			
			0.5f,0.5f,-0.5f,	
			0.5f,-0.5f,-0.5f,	
			0.5f,-0.5f,0.5f,	
			0.5f,0.5f,0.5f,
			
			-0.5f,0.5f,-0.5f,	
			-0.5f,-0.5f,-0.5f,	
			-0.5f,-0.5f,0.5f,	
			-0.5f,0.5f,0.5f,
			
			-0.5f,0.5f,0.5f,
			-0.5f,0.5f,-0.5f,
			0.5f,0.5f,-0.5f,
			0.5f,0.5f,0.5f,
			
			-0.5f,-0.5f,0.5f,
			-0.5f,-0.5f,-0.5f,
			0.5f,-0.5f,-0.5f,
			0.5f,-0.5f,0.5f,
	
			//face		
			-0.3f,  0.8f,  0.5f,	
			-0.3f, -0.1f,  0.5f,	
			 0.3f, -0.1f,  0.5f,	
			 0.3f,  0.8f,  0.5f,		

			-0.3f,  0.8f,  0.9f,	
			-0.3f, -0.1f,  0.9f,	
			 0.3f, -0.1f,  0.9f,	
			 0.3f,  0.8f,  0.9f,

			 0.3f,  0.8f,  0.5f,	
			 0.3f, -0.1f,  0.5f,	
			 0.3f, -0.1f,  0.9f,	
			 0.3f,  0.8f,  0.9f,

			-0.3f,  0.8f,  0.5f,	
			-0.3f, -0.1f,  0.5f,	
			-0.3f, -0.1f,  0.9f,	
			-0.3f,  0.8f,  0.9f,

			-0.3f,  0.8f,  0.9f,
			-0.3f,  0.8f,  0.5f,
			 0.3f,  0.8f,  0.5f,
			 0.3f,  0.8f,  0.9f,

			-0.3f, -0.1f,  0.9f,
			-0.3f, -0.1f,  0.5f,
			 0.3f, -0.1f,  0.5f,
			 0.3f, -0.1f,  0.9f,
			 
	};
	
	
	public static int[] liIndices = {
			0,1,3,	
			3,1,2,	
			
			4,5,7,
			7,5,6,
			
			8,9,11,
			11,9,10,
			
			12,13,15,
			15,13,14,	
			
			16,17,19,
			19,17,18,
			
			20,21,23,
			23,21,22,
			//face
			24,25,27,	
			27,25,26,	
			
			28,29,31,
			31,29,30,
			
			32,33,35,
			35,33,34,
			
			36,37,39,
			39,37,38,	
			
			40,41,43,
			43,41,42,
			
			44,45,47,
			47,45,46,
		//
			
	};

	public UnitCow(Loader pLoader, int pType)
	{
		miVAOId = pLoader.loadToVAO(lfVertices, liIndices, liUV);
		if(pType == COW_WHITE)
		{
			miTextureId = pLoader.loadTexture("cow");
		}
		else
		{
			miTextureId = pLoader.loadTexture("cow2");
		}
		
	}
	
	public int getVaoID() 
	{
		return miVAOId;
	}

	public int getTextureId()
	{
		return miTextureId;
	}
	
	public boolean hasAnimation()
	{
		return true;
	}
	
	public int getAnimation()
	{
		return CommonConstants.ANIMATION_MOVE;
	}
	
	public int getVertexCount()
	{
		return liIndices.length;
	}
}
