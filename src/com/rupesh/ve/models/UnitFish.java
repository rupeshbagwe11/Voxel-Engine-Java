package com.rupesh.ve.models;

import com.rupesh.ve.renderengine.Loader;
import com.rupesh.ve.util.CommonConstants;

public class UnitFish extends IUnitCube
{	
	//Id where the array will be stored in VAO
	int miVAOId;	
	int miTextureId;
	
	
	public static float[] liUV = {
			
			1.99f / 4f, 0.01f / 4f,
			1.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.01f / 4f,
			
			1.01f / 4f, 1.01f / 4f,
			1.01f / 4f, 1.99f / 4f,
			1.99f / 4f, 1.99f / 4f,
			1.99f / 4f, 1.01f / 4f,
			
			1.99f / 4f, 1.01f / 4f,
			1.99f / 4f, 1.99f / 4f,
			2.99f / 4f, 1.99f / 4f,
			2.99f / 4f, 1.01f / 4f,
			
			1.99f / 4f, 0.01f / 4f,
			1.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.01f / 4f,
			
			1.99f / 4f, 0.01f / 4f,
			1.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.01f / 4f,
			
			1.99f / 4f, 0.01f / 4f,
			1.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.99f / 4f,
			2.99f / 4f, 0.01f / 4f
			
	};
	
	public UnitFish(Loader pLoader)
	{
		miVAOId = pLoader.loadToVAO(lfVertices, liIndices, liUV);
		miTextureId = pLoader.loadTexture("fish");
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
		return CommonConstants.ANIMATION_JUMP;
	}
}
