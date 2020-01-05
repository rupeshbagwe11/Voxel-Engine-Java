package com.rupesh.ve.entities;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import com.rupesh.ve.models.IUnitCube;
import com.rupesh.ve.models.UnitBoard;
import com.rupesh.ve.models.UnitCow;
import com.rupesh.ve.models.UnitDirt;
import com.rupesh.ve.models.UnitFish;
import com.rupesh.ve.models.UnitFlower;
import com.rupesh.ve.models.UnitGrass;
import com.rupesh.ve.models.UnitParrot;
import com.rupesh.ve.models.UnitSand;
import com.rupesh.ve.models.UnitSnow;
import com.rupesh.ve.models.UnitTree;
import com.rupesh.ve.models.UnitWater;
import com.rupesh.ve.models.UnitWheat;
import com.rupesh.ve.renderengine.WindowRenderManager;
import com.rupesh.ve.util.CommonConstants;
import com.rupesh.ve.util.Helper;

public class FieldGenerator 
{
	public static final int FIELDTYPE_GRASS = 0;
	public static final int FIELDTYPE_MOUNTAIN = 1;
	public static final int FIELDTYPE_LAKE = 2;
	public static final int FIELDTYPE_COWS = 3;
	public static final int FIELDTYPE_GARDEN = 4;
	public static final int FIELDTYPE_FOREST = 5;
	public static final int FIELDTYPE_SIGN = 6;
	public static final int FIELDTYPE_DESERT = 7;
	public static final int FIELDTYPE_FARM = 8;
	
	IUnitCube lDirt;
	IUnitCube lCowWhite;
	IUnitCube lCowBrown;
	IUnitCube lSnow;
	IUnitCube lGrass;
	IUnitCube lWater;
	IUnitCube lFlowerRed;
	IUnitCube lFlowerWhite;
	IUnitCube lFlowerBlue;
	IUnitCube lFlowerPink;
	IUnitCube lTree;
	IUnitCube lFish;
	IUnitCube lSignBoard;
	IUnitCube lSand;
	IUnitCube lWheat;
	IUnitCube lParrot;
	
	public FieldGenerator(WindowRenderManager pWindowRenderManager)
	{
		 lDirt = new UnitDirt(pWindowRenderManager.getLoader());
		 lCowWhite = new UnitCow(pWindowRenderManager.getLoader(), UnitCow.COW_WHITE);
		 lCowBrown = new UnitCow(pWindowRenderManager.getLoader(), UnitCow.COW_BROWN );
		 lSnow = new UnitSnow(pWindowRenderManager.getLoader());
		 lGrass = new UnitGrass(pWindowRenderManager.getLoader());
		 lWater = new UnitWater(pWindowRenderManager.getLoader());
		 lFlowerRed = new UnitFlower(pWindowRenderManager.getLoader(), UnitFlower.FLOWER_RED);
		 lFlowerWhite = new UnitFlower(pWindowRenderManager.getLoader(), UnitFlower.FLOWER_WHITE);
		 lFlowerBlue = new UnitFlower(pWindowRenderManager.getLoader(), UnitFlower.FLOWER_BLUE);
		 lFlowerPink = new UnitFlower(pWindowRenderManager.getLoader(), UnitFlower.FLOWER_PINK);
		 lTree = new UnitTree(pWindowRenderManager.getLoader());
		 lFish = new UnitFish(pWindowRenderManager.getLoader());
		 lSignBoard = new UnitBoard(pWindowRenderManager.getLoader());
		 lSand = new UnitSand(pWindowRenderManager.getLoader());
		 lWheat = new UnitWheat(pWindowRenderManager.getLoader());
		 lParrot = new UnitParrot(pWindowRenderManager.getLoader());
	}
	
	public FieldBlocks addField(Vector3f pPosition)
	{	
		int liFieldType = getFieldType((int)pPosition.x,(int) pPosition.z);
		//	int liFieldType = FIELDTYPE_SIGN;
		List<Entity> llistEntities;
		switch(liFieldType)
		{
			case FIELDTYPE_MOUNTAIN:
			{
				llistEntities = addMountainField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_LAKE:
			{
				llistEntities = addLakeField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_COWS:
			{
				llistEntities = addCowsField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_GARDEN:
			{
				llistEntities = addGardenField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_FOREST:
			{
				llistEntities = addForestField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_SIGN:
			{
				llistEntities = addSignField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_DESERT:
			{
				llistEntities = addDesertField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_FARM:
			{
				llistEntities = addFarmField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			case FIELDTYPE_GRASS:
			{
				llistEntities = addGrassField((int)pPosition.x, (int) pPosition.z);
				break;
			}
			default:
			{
				llistEntities = addGrassField((int)pPosition.x, (int) pPosition.z);
				break;
			}
		}

		FieldBlocks lFieldBlocks = new FieldBlocks(llistEntities, pPosition);
		
		return lFieldBlocks;
	}
	
	public int getFieldType(int pX, int pZ)
	{
		int liOrgX = Math.abs( pX / CommonConstants.FIELD_SIZE) % 5;
		int liOrgZ = Math.abs( pZ / CommonConstants.FIELD_SIZE) % 5;
		
		if(liOrgX == 0 && liOrgZ == 3)
		{
			return FIELDTYPE_MOUNTAIN; 
		}
		if(liOrgX == 1 && liOrgZ == 2)
		{
			return FIELDTYPE_MOUNTAIN; 
		}
		if(liOrgX == 3 && liOrgZ == 3)
		{
			return FIELDTYPE_LAKE; 
		}
		if(liOrgX == 1 && liOrgZ == 0)
		{
			return FIELDTYPE_LAKE; 
		}
		if(liOrgX == 3 && liOrgZ == 2)
		{
			return FIELDTYPE_LAKE; 
		}
		
		if(liOrgX == 2 && liOrgZ == 1)
		{
			return FIELDTYPE_COWS; 
		}
		if(liOrgX == 1 && liOrgZ == 4)
		{
			return FIELDTYPE_COWS; 
		}
		
		if(liOrgX == 2 && liOrgZ == 2)
		{
			return FIELDTYPE_GARDEN; 
		}
		if(liOrgX == 3 && liOrgZ == 0)
		{
			return FIELDTYPE_GARDEN; 
		}
		
		if(liOrgX == 0 && liOrgZ == 1)
		{
			return FIELDTYPE_FOREST; 
		}
		if(liOrgX == 4 && liOrgZ == 3)
		{
			return FIELDTYPE_FOREST; 
		}
		
		if(liOrgX == 0 && liOrgZ == 0)
		{
			return FIELDTYPE_SIGN;
		}
		
		if(liOrgX == 1 && liOrgZ == 1)
		{
			return FIELDTYPE_DESERT;
		}
		if(liOrgX == 3 && liOrgZ == 4)
		{
			return FIELDTYPE_DESERT;
		}
		if(liOrgX == 4 && liOrgZ == 1)
		{
			return FIELDTYPE_FARM;
		}
		if(liOrgX == 2 && liOrgZ == 3)
		{
			return FIELDTYPE_FARM;
		}
		return FIELDTYPE_GRASS;	
	}
	
	public List<Entity> addGrassField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{		
					lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 0, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
				
					lEntity = new Entity( lGrass, new Vector3f(pOrgX + x, 1, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
			}	
		}	
		
		return llistEntities;
	}
	
	public List<Entity> addMountainField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{				
				int liYCounter = 0;
				lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, liYCounter, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
				liYCounter++;
				lEntity = new Entity( lGrass, new Vector3f(pOrgX + x, liYCounter, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
				liYCounter++;
				
				int lHeight = Helper.getHeight(x,z);
				
				for(int y = 0; y < lHeight; y++)
				{
					if(liYCounter > 7)
					{
						lEntity = new Entity( lSnow, new Vector3f(pOrgX + x, liYCounter, pOrgZ + z), 0, 0, 0, 1);
					}
					else
					{
						lEntity = new Entity( lGrass, new Vector3f(pOrgX + x, liYCounter, pOrgZ + z), 0, 0, 0, 1);
					}			
					llistEntities.add(lEntity);
					liYCounter++;
				}	
			}
		}
		return llistEntities;		
	}
	
	public List<Entity> addLakeField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		if(Helper.getRandomNumberInteger(0, 2) == 0)
		{		
			lEntity = new Entity(lFish, new Vector3f(pOrgX+ 2, 1f, pOrgZ + 2), 0, 0, 0, 1);
			llistEntities.add(lEntity);
		}
		if(Helper.getRandomNumberInteger(0, 2) == 0)
		{		
			lEntity = new Entity(lFish, new Vector3f(pOrgX+ 10, 1.25f, pOrgZ + 10), 0, 0, 0, 1);
			llistEntities.add(lEntity);
		}
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{				
				lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 0, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
			
				lEntity = new Entity( lWater, new Vector3f(pOrgX + x, 1, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);

			}
		}	
		return llistEntities;
	}
	
	public List<Entity> addCowsField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{				
				lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 0, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
			
				lEntity = new Entity( lGrass, new Vector3f(pOrgX + x, 1, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
				
				if(x == 2 && z == 2)
				{
					lEntity = new Entity(lCowWhite, new Vector3f(pOrgX+ x, 2, pOrgZ + z), 0, 90, 0, 1);
					llistEntities.add(lEntity);
				}
				if(x == 3 && z == 4)
				{
					lEntity = new Entity(lCowBrown, new Vector3f(pOrgX+ x, 2, pOrgZ + z), 0, 90, 0, 1);
					llistEntities.add(lEntity);
				}
				if(x == 10 && z == 10)
				{
					lEntity = new Entity(lCowBrown, new Vector3f(pOrgX+ x, 2, pOrgZ + z), 0, 90, 0, 1);
					llistEntities.add(lEntity);
				}
				if(x == 8 && z == 8)
				{
					lEntity = new Entity(lCowWhite, new Vector3f(pOrgX+ x, 2, pOrgZ + z), 0, 90, 0, 1);
					llistEntities.add(lEntity);
				}
				if(x == 4 && z == 10)
				{
					lEntity = new Entity(lCowBrown, new Vector3f(pOrgX+ x, 2, pOrgZ + z), 0, 90, 0, 1);
					llistEntities.add(lEntity);
				}
				if(x == 5 && z == 8)
				{
					lEntity = new Entity(lCowWhite, new Vector3f(pOrgX+ x, 2, pOrgZ + z), 0, 90, 0, 1);
					llistEntities.add(lEntity);
				}
			}
		}
		return llistEntities;
	}
	
	public List<Entity> addGardenField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{				
				lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 0, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
			
				lEntity = new Entity( lGrass, new Vector3f(pOrgX + x, 1, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
			
				if(Helper.getRandomNumberInteger(0, 4) == 0)
				{
					lEntity = new Entity(lFlowerWhite, new Vector3f(pOrgX+ x + Helper.getRandomNumberFloat(0, 0.3f) , 2f, pOrgZ + z + Helper.getRandomNumberFloat(0, 0.3f)), 0, 0, 0, 1);
				}
				else if(Helper.getRandomNumberInteger(0, 4) == 1)
				{
					lEntity = new Entity(lFlowerRed, new Vector3f(pOrgX+ x + Helper.getRandomNumberFloat(0, 0.3f) , 2f, pOrgZ + z + Helper.getRandomNumberFloat(0, 0.3f)), 0, 90, 0, 1);		
				}
				else if(Helper.getRandomNumberInteger(0, 4) == 2)
				{
					lEntity = new Entity(lFlowerBlue, new Vector3f(pOrgX+ x + Helper.getRandomNumberFloat(0, 0.3f) , 2f, pOrgZ + z + Helper.getRandomNumberFloat(0, 0.3f)), 0, 270, 0, 1);		
				}
				else if(Helper.getRandomNumberInteger(0, 4) == 3)
				{
					lEntity = new Entity(lFlowerPink, new Vector3f(pOrgX+ x + Helper.getRandomNumberFloat(0, 0.3f) , 2f, pOrgZ + z + Helper.getRandomNumberFloat(0, 0.3f)), 0, 180, 0 , 1);		
				}
				
				llistEntities.add(lEntity);
				
			}
		}
		return llistEntities;
	}
	
	
	public List<Entity> addForestField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{				
				lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 0, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
			
				lEntity = new Entity( lGrass, new Vector3f(pOrgX + x, 1, pOrgZ + z), 0, 0, 0, 1);
				llistEntities.add(lEntity);
				
				if((x + z) % 3 == 0)
				{
					lEntity = new Entity(lTree, new Vector3f(pOrgX+ x + Helper.getRandomNumberFloat(0, 0.02f) , 2, pOrgZ + z + Helper.getRandomNumberFloat(0, 0.2f)), 0, 0, 0, 1);		
					llistEntities.add(lEntity);	
				}
			}
		}
		
		lEntity = new Entity(lParrot, new Vector3f(pOrgX+ 4, 4.2f, pOrgZ + 5), 0, 90, 0, 0.5f);
		llistEntities.add(lEntity);

		lEntity = new Entity(lParrot, new Vector3f(pOrgX+ 2, 4.4f, pOrgZ + 8), 0, 90, 0, 0.5f);
		llistEntities.add(lEntity);
		
		return llistEntities;
	}
	
	
	public List<Entity> addSignField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{		
					lEntity = new Entity( lDirt, new Vector3f(pOrgX + x,  0, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
				
					lEntity = new Entity( lGrass, new Vector3f(pOrgX + x,  1, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
					
					if( x == 8 && z == 8)
					{
						lEntity = new Entity( lSignBoard, new Vector3f(pOrgX + x,  2, pOrgZ + z), 0, 0, 0, 1);
						llistEntities.add(lEntity);
					}
			}	
		}
		
		return llistEntities;
	}
	
	
	public List<Entity> addDesertField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{		
					lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 0, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
				
					lEntity = new Entity( lSand, new Vector3f(pOrgX + x, 1, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
					
			}	
		}	
		
		return llistEntities;
	}
	
	public List<Entity> addFarmField(int pOrgX, int pOrgZ)
	{
		Entity lEntity;
		List<Entity> llistEntities = new ArrayList<Entity>();
		for (int x = 0; x < CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = 0; z < CommonConstants.FIELD_SIZE; z++) 
			{		
					lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 0, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
				
					lEntity = new Entity( lDirt, new Vector3f(pOrgX + x, 1, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
					
					lEntity = new Entity( lWheat, new Vector3f(pOrgX + x, 2, pOrgZ + z), 0, 0, 0, 1);
					llistEntities.add(lEntity);
					
			}	
		}	
		return llistEntities;
	}
	
	
}
