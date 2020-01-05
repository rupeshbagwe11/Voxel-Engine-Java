package com.rupesh.ve.shaders;

import org.lwjgl.util.vector.Matrix4f;

import com.rupesh.ve.util.CommonConstants;


public class Shader extends IShader
{
	int miModelMatrixLoc;
	int miViewMatrixLoc;
	int miProjectionMatrixLoc;
	int miHasTransLoc;
	
	public Shader() 
	{
		super(CommonConstants.VERTEX_SHADER_FILE, CommonConstants.FRAGMENT_SHADER_FILE);
	}

	@Override
	protected void bindAttributes() 
	{
		bindAttribute(0, "position");
		bindAttribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() 
	{
		miModelMatrixLoc = getUniformLocation("modelMatrix");
		miViewMatrixLoc = getUniformLocation("viewMatrix");
		miProjectionMatrixLoc = getUniformLocation("projectionMatrix");	
		miHasTransLoc= getUniformLocation("hasTransparency");	
	}
	
	public void loadModelMatrix(Matrix4f pMatrix)
	{
		loadMat4f(miModelMatrixLoc, pMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f pMatrix)
	{
		loadMat4f(miProjectionMatrixLoc, pMatrix);
	}
	
	public void loadViewMatrix(Matrix4f pMatrix)
	{
		loadMat4f(miViewMatrixLoc, pMatrix);
	}
	
	public void loadTransparency(Boolean pBoolean)
	{
		loadBoolean(miHasTransLoc, pBoolean);
	}
	

}
