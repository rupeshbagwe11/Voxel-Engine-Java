package com.rupesh.ve.renderengine;

import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Loader 
{
	static List<Integer> mlistVAOs = new ArrayList<Integer>();
	static List<Integer> mlistVBOs = new ArrayList<Integer>();
	static List<Integer> mlistTextures = new ArrayList<Integer>();
	
	//load the model in VAO
	public int loadToVAO( float[] pVertices, int[] pIndices, float[] pUV)
	{	
		int liVAOID = createVAO();
		storeDataInAttributeList(pVertices, 0, 3);
		storeDataInAttributeList(pUV, 1, 2);
		bindIndicesBuffer(pIndices);
		GL30.glBindVertexArray(0);
		
		return liVAOID;	
	}
	
	//creat a VertexArrayObject
	private int createVAO()
	{	
		int liVAOID = GL30.glGenVertexArrays();
		mlistVAOs.add(liVAOID);
		GL30.glBindVertexArray(liVAOID);
		
		return liVAOID;	
	}
	
	//convert float[] to floatbuffer[] format
	private FloatBuffer storeDataInFloatBuffer(float[] pData)
	{	
		FloatBuffer liFBuffer = BufferUtils.createFloatBuffer(pData.length);
		liFBuffer.put(pData);
		liFBuffer.flip();
		
		return liFBuffer;
	}
	
	//store the data in VBO which is stored in VAO[pAtrributeNumber]
	private void storeDataInAttributeList(float[] pData, int pAttributeNumber, int pDimentions) 
	{	
		int liVBOID = GL15.glGenBuffers();
		mlistVBOs.add(liVBOID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, liVBOID);
		FloatBuffer liFBuffer = storeDataInFloatBuffer(pData);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, liFBuffer, GL15.GL_STATIC_DRAW);
		//set format and source location of VBO 
		GL20.glVertexAttribPointer(pAttributeNumber, pDimentions, GL11.GL_FLOAT, false, 0, 0);
		//unbind
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);	
	}
	
	//store the indices in VBO
	private void bindIndicesBuffer(int[] pIndices) 
	{	
		//generate a VBO
		int liVBOID = GL15.glGenBuffers();
		mlistVBOs.add(liVBOID);
		//attach to location
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, liVBOID);
		IntBuffer liIBuffer = storeDataInIntBuffer(pIndices);
		//allocate memory and fill it with data
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, liIBuffer, GL15.GL_STATIC_DRAW);	
	}
	
	//convert int[] to intbuffer[] format
	IntBuffer storeDataInIntBuffer(int[] pData) 
	{	
		IntBuffer liIBuffer = BufferUtils.createIntBuffer(pData.length);
		liIBuffer.put(pData);
		liIBuffer.flip();
		
		return liIBuffer;	
	}
	
	
	//Clear all the VAO's and VBO's from GPU
	public void cleanUp() 
	{	
		for (int liVAO : mlistVAOs) 
		{
			GL30.glDeleteVertexArrays(liVAO);
		}
		
		for (int liVBO : mlistVBOs)
		{
			GL15.glDeleteBuffers(liVBO);
		}	
		
		for (int liTexture : mlistTextures)
		{
			GL11.glDeleteTextures(liTexture);
		}
	}
	
	public int loadTexture(String pFileName) 
	{	
		Texture lTexture = null;
		try 
		{
			lTexture = TextureLoader.getTexture("PNG", getClass().getResourceAsStream("/resources/models/" + pFileName + ".png"));
			GL30.glGenerateMipmap(GL11.GL_TEXTURE_2D);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		int liTextureID = lTexture.getTextureID();
		mlistTextures.add(liTextureID);
		
		return liTextureID;		
	}
		
}
