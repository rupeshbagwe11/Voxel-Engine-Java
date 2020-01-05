package com.rupesh.ve.models;

import com.rupesh.ve.renderengine.Loader;

public class UnitFlower extends IUnitCube
{	
	//Id where the array will be stored in VAO
	int miVAOId;	
	int miTextureId;
	
	public static final int FLOWER_WHITE = 1;
	public static final int FLOWER_RED = 2;
	public static final int FLOWER_BLUE = 3;
	public static final int FLOWER_PINK = 4;
	
	public static float[] lfVertices = {			
			-0.2f,0.5f,-0.2f,	
			-0.2f,-0.5f,-0.2f,	
			0.2f,-0.5f,-0.2f,	
			0.2f,0.5f,-0.2f,		
			
			-0.2f,0.5f,0.2f,	
			-0.2f,-0.5f,0.2f,	
			0.2f,-0.5f,0.2f,	
			0.2f,0.5f,0.2f,
			
			0.2f,0.5f,-0.2f,	
			0.2f,-0.5f,-0.2f,	
			0.2f,-0.5f,0.2f,	
			0.2f,0.5f,0.2f,
			
			-0.2f,0.5f,-0.2f,	
			-0.2f,-0.5f,-0.2f,	
			-0.2f,-0.5f,0.2f,	
			-0.2f,0.5f,0.2f,
			
			-0.2f,0.5f,0.2f,
			-0.2f,0.5f,-0.2f,
			0.2f,0.5f,-0.2f,
			0.2f,0.5f,0.2f,
			
			-0.2f,-0.5f,0.2f,
			-0.2f,-0.5f,-0.2f,
			0.2f,-0.5f,-0.2f,
			0.2f,-0.5f,0.2f
			
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
			
			
			
	};
	
	
	public UnitFlower(Loader pLoader, int pType)
	{
		miVAOId = pLoader.loadToVAO(lfVertices, liIndices, liUV);
		if(pType == FLOWER_RED)
		{
			miTextureId = pLoader.loadTexture("redflower");
		}
		else if(pType == FLOWER_WHITE)
		{
			miTextureId = pLoader.loadTexture("whiteflower");
		}
		else if(pType == FLOWER_BLUE)
		{
			miTextureId = pLoader.loadTexture("blueflower");
		}
		else if(pType == FLOWER_PINK)
		{
			miTextureId = pLoader.loadTexture("pinkflower");
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
	
}
