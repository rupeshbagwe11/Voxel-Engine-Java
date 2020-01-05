package com.rupesh.ve.models;

import com.rupesh.ve.renderengine.Loader;

public class UnitGrass extends IUnitCube
{	
	//Id where the array will be stored in VAO
	int miVAOId;	
	int miTextureId;
	
	public static float[] liUV = {
			
			1.01f / 3f, 1.01f / 3f,
			1.01f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.01f / 3f,
			
			1.01f / 3f, 1.01f / 3f,
			1.01f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.01f / 3f,
			
			1.01f / 3f, 1.01f / 3f,
			1.01f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.01f / 3f,
			
			1.01f / 3f, 1.01f / 3f,
			1.01f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.01f / 3f,
			
			1.01f / 3f, 2.01f / 3f,
			1.01f / 3f, 0.99f,
			1.99f / 3f, 0.99f,
			1.99f / 3f, 2.01f / 3f,
			
			0.01f, 1.01f / 3f,
			0.01f, 1.99f / 3f,
			0.99f / 3f, 1.99f / 3f,
			0.99f / 3f, 1.01f / 3f
			
	};
	
	public UnitGrass(Loader pLoader)
	{
		miVAOId = pLoader.loadToVAO(lfVertices, liIndices, liUV);
		miTextureId = pLoader.loadTexture("grass");
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
