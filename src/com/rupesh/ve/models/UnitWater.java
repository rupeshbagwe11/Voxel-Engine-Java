package com.rupesh.ve.models;

import com.rupesh.ve.renderengine.Loader;

public class UnitWater extends IUnitCube
{	
	//Id where the array will be stored in VAO
	int miVAOId;	
	int miTextureId;
	
	public UnitWater(Loader pLoader)
	{
		miVAOId = pLoader.loadToVAO(lfVertices, liIndices, liUV);
		miTextureId = pLoader.loadTexture("water");
	}
	
	public int getVaoID() 
	{
		return miVAOId;
	}

	public int getTextureId()
	{
		return miTextureId;
	}
	
	public boolean hasTransparency()
	{
		return true;
	}
	
}
