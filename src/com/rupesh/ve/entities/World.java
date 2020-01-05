package com.rupesh.ve.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World 
{
	Map<Integer, List<Entity>> mUnitCubeTextureMapping = new HashMap<Integer, List<Entity>>();
	
	public void addEntity(Entity pEntity) 
	{
		
		int liTextureId = pEntity.getUnitCube().getTextureId();
		List<Entity> lSameTextureCubes = mUnitCubeTextureMapping.get(liTextureId);
		
		if (lSameTextureCubes != null)
		{
			lSameTextureCubes.add(pEntity);
		} 
		else 
		{	
			List<Entity> lSameTextureCubesList = new ArrayList<Entity>();
			lSameTextureCubesList.add(pEntity);
			mUnitCubeTextureMapping.put(liTextureId, lSameTextureCubesList);		
		}	
	}
	
	public Map<Integer, List<Entity>> getUnitTextureCubes()
	{
		return mUnitCubeTextureMapping;
	}
	
	public void clear()
	{
		mUnitCubeTextureMapping.clear();
	}
	
}
