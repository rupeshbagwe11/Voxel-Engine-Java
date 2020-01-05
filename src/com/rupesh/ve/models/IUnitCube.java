package com.rupesh.ve.models;

public abstract class IUnitCube 
{
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
			0.5f,-0.5f,0.5f
			
	};
	
	public static float[] liUV = {
			
			0,0,
			0,1,
			1,1,
			1,0,
			
			0,0,
			0,1,
			1,1,
			1,0,			
			
			0,0,
			0,1,
			1,1,
			1,0,
			
			0,0,
			0,1,
			1,1,
			1,0,
			
			0,0,
			0,1,
			1,1,
			1,0,
			
			0,0,
			0,1,
			1,1,
			1,0
			
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
			
			
	};
	
	public abstract int getVaoID(); 
	
	public abstract int getTextureId();
	
	public int getVertexCount()
	{
		return liIndices.length;
	}
	
	public boolean hasAnimation()
	{
		return false;
	}
	
	public boolean hasTransparency()
	{
		return false;
	}
	
	public int getAnimation()
	{
		return -1;
	}
}
