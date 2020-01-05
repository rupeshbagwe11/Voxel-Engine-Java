package com.rupesh.ve.entities;

import java.util.List;

import org.lwjgl.util.vector.Vector3f;

public class FieldBlocks 
{
	private List<Entity> mlistEntities;
	private Vector3f mPosition;
	
	public FieldBlocks(List<Entity> plistEntities, Vector3f pPosition)
	{	
		mlistEntities = plistEntities;
		mPosition = pPosition;
	}
	
	public Vector3f getPosition()
	{
		return mPosition;
	}
	
	public List<Entity> getEntities()
	{
		return mlistEntities;
	}
}
