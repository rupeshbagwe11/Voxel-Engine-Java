package com.rupesh.ve.shaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public abstract class IShader
{
	int liProgramID;
	int liVertexShaderID;
	int liFragmentShaderID;
	
	FloatBuffer mMatrixBuffer = BufferUtils.createFloatBuffer(16);
	
	public IShader(String pVSFileLoc, String pFSFileLoc)
	{	
		// Initialize the OpenGL Program
	    // A program controls the OpenGL pipeline and it must contains
	    // at least a vertex shader and a fragment shader to be valid
		liProgramID = GL20.glCreateProgram();
		liVertexShaderID = loadShader(pVSFileLoc, GL20.GL_VERTEX_SHADER);
		liFragmentShaderID = loadShader(pFSFileLoc, GL20.GL_FRAGMENT_SHADER);
		
		// Compile the two shaders and upload the binary to the GPU
		GL20.glAttachShader( liProgramID, liVertexShaderID );
		GL20.glAttachShader( liProgramID, liFragmentShaderID );
		bindAttributes();
		GL20.glLinkProgram(liProgramID);
		GL20.glValidateProgram(liProgramID);
		
		getAllUniformLocations();
		
	}
	
	protected abstract void bindAttributes();
	
	private int loadShader(String pFile, int pType) 
	{	
		StringBuilder lShaderSB = new StringBuilder();
		
		InputStream lIS = Class.class.getResourceAsStream(pFile);
		BufferedReader lBFReader = new BufferedReader(new InputStreamReader(lIS));
		
		// convert shader from file to string builder
		String lstrLine;
		try 
		{
			while ( ( lstrLine = lBFReader.readLine()) != null )
			{
				lShaderSB.append(lstrLine).append("//\n");
			}
			lBFReader.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
			System.err.println("Error in loading shader file!");
			System.exit(-1);
		}
		
		//create shader ptype - fragment/vertex
		int liShaderID = GL20.glCreateShader(pType);
		//attach the stringbuffer shader program to its respective shader
		GL20.glShaderSource(liShaderID, lShaderSB);
		GL20.glCompileShader(liShaderID);
		
		//Compile the shader to check for Errors
		if ( GL20.glGetShaderi(liShaderID, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE ) 
		{
			System.out.println(GL20.glGetShaderInfoLog(liShaderID, 1000));
			System.err.println("Error in compiling shader file!");
			System.exit(-1);	
		}
		
		return liShaderID;
		
	}
	
	protected void bindAttribute( int liIndex, String pVarName ) 
	{
		GL20.glBindAttribLocation( liProgramID, liIndex, pVarName );
	}
	
	public void start() 
	{
		GL20.glUseProgram(liProgramID);
	}
	
	public void stop() 
	{
		GL20.glUseProgram(0);
	}
	
	public void cleanUp() 
	{	
		stop();
		GL20.glDetachShader(liProgramID, liVertexShaderID);
		GL20.glDetachShader(liProgramID, liFragmentShaderID);
		GL20.glDeleteShader(liVertexShaderID);
		GL20.glDeleteShader(liFragmentShaderID);
		GL20.glDeleteProgram(liProgramID);	
	}
	
	protected abstract void getAllUniformLocations();
	
	protected int getUniformLocation(String pVarName) 
	{
		return GL20.glGetUniformLocation(liProgramID, pVarName);
	}
	
	protected void loadF(int pLocation, float pValue)
	{
		GL20.glUniform1f(pLocation, pValue);
	}
	
	protected void loadVec2f(int pLocation, Vector2f pVector) 
	{
		GL20.glUniform2f(pLocation, pVector.x, pVector.y);
	}
	
	protected void loadVec3f(int pLocation, Vector3f pVector)
	{
		GL20.glUniform3f(pLocation, pVector.x, pVector.y, pVector.z);
	}

	protected void loadMat4f(int pLocation, Matrix4f pMatrix) 
	{
		pMatrix.store(mMatrixBuffer);
		mMatrixBuffer.flip();
			
		GL20.glUniformMatrix4(pLocation, false, mMatrixBuffer);		
	}
	
	protected void loadBoolean(int pLocation, boolean pBool) 
	{
		float value = pBool?1:0;
		
		GL20.glUniform1f(pLocation, value);
		
	}
}
