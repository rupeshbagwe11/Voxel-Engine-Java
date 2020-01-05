package com.rupesh.ve.models;

import com.rupesh.ve.renderengine.Loader;

public class UnitWheat extends IUnitCube
{	
	//Id where the array will be stored in VAO
	int miVAOId;	
	int miTextureId;
	
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
			1,0
			
	};
	
	public UnitWheat(Loader pLoader)
	{
		miVAOId = pLoader.loadToVAO(lfVertices, liIndices, liUV);
		miTextureId = pLoader.loadTexture("wheat");
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
