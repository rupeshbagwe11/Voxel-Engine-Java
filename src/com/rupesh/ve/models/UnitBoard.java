package com.rupesh.ve.models;

import com.rupesh.ve.renderengine.Loader;

public class UnitBoard extends IUnitCube
{	
	//Id where the array will be stored in VAO
	int miVAOId;	
	int miTextureId;
	
	public static float[] lfVertices = {			
			-0.1f,1.5f,-0.1f,	
			-0.1f,-0.5f,-0.1f,	
			0.1f,-0.5f,-0.1f,	
			0.1f,1.5f,-0.1f,		
			
			-0.1f,1.5f,0.1f,	
			-0.1f,-0.5f,0.1f,	
			0.1f,-0.5f,0.1f,	
			0.1f,1.5f,0.1f,
			
			0.1f,1.5f,-0.1f,	
			0.1f,-0.5f,-0.1f,	
			0.1f,-0.5f,0.1f,	
			0.1f,1.5f,0.1f,
			
			-0.1f,1.5f,-0.1f,	
			-0.1f,-0.5f,-0.1f,	
			-0.1f,-0.5f,0.1f,	
			-0.1f,1.5f,0.1f,
			
			-0.1f,1.5f,0.1f,
			-0.1f,1.5f,-0.1f,
			0.1f,1.5f,-0.1f,
			0.1f,1.5f,0.1f,
			
			-0.1f,-0.5f,0.1f,
			-0.1f,-0.5f,-0.1f,
			0.1f,-0.5f,-0.1f,
			0.1f,-0.5f,0.1f,
			
			//Board
			-2.1f,3.5f,-0.2f,	
			-2.1f,1.5f,-0.2f,	
			2.1f,1.5f,-0.2f,	
			2.1f,3.5f,-0.2f,		
			
			-2.1f,3.5f,0.2f,	
			-2.1f,1.5f,0.2f,	
			2.1f,1.5f,0.2f,	
			2.1f,3.5f,0.2f,
			
			2.1f,3.5f,-0.2f,	
			2.1f,1.5f,-0.2f,
			2.1f,1.5f,0.2f,	
			2.1f,3.5f,0.2f,
			
			-2.1f,3.5f,-0.2f,	
			-2.1f,1.5f,-0.2f,	
			-2.1f,1.5f,0.2f,	
			-2.1f,3.5f,0.2f,
			
			-2.1f,3.5f,0.2f,
			-2.1f,3.5f,-0.2f,
			2.1f,3.5f,-0.2f,
			2.1f,3.5f,0.2f,
			
			-2.1f,1.5f,0.2f,
			-2.1f,1.5f,-0.2f,
			2.1f,1.5f,-0.2f,
			2.1f,1.5f,0.2f
			
			
	};
	
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
			
			//Board
			1.01f / 3f, 1.01f / 3f,
			1.01f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.99f / 3f,
			1.99f / 3f, 1.01f / 3f,
			
			1, 0.01f / 3f,	
			1, 0.99f / 3f,
			0.01f, 0.99f / 3f,
			0.01f, 0.01f / 3f,
			
			0.01f, 0.01f / 3f,
			0.01f, 0.99f / 3f,
			1, 0.99f / 3f,
			1, 0.01f / 3f,
			
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
			1.99f / 3f, 1.01f / 3f
			
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
			47,45,46
	};
	
	public UnitBoard(Loader pLoader)
	{
		miVAOId = pLoader.loadToVAO(lfVertices, liIndices, liUV);
		miTextureId = pLoader.loadTexture("board");
	}
	
	public int getVaoID() 
	{
		return miVAOId;
	}

	public int getTextureId()
	{
		return miTextureId;
	}
	
	public int getVertexCount()
	{
		return liIndices.length;
	}
	
}
