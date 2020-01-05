package com.rupesh.ve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;


import com.rupesh.ve.entities.Camera;
import com.rupesh.ve.entities.Entity;
import com.rupesh.ve.entities.FieldBlocks;
import com.rupesh.ve.entities.FieldGenerator;
import com.rupesh.ve.entities.World;
import com.rupesh.ve.renderengine.WindowRenderManager;
import com.rupesh.ve.util.CommonConstants;
import com.rupesh.ve.util.Helper;

public class Main
{
	static boolean mbCloseWindow = false;
	
	static Vector3f mCamPos = new Vector3f(0,0,0);
	
	static List<FieldBlocks> mlistFieldBlocks = Collections.synchronizedList(new ArrayList<FieldBlocks>());
	
	static List<Vector3f> mUsedPos  = Collections.synchronizedList(new ArrayList<Vector3f>());
	
	public static void main(String args[])
	{

		WindowRenderManager lWindowRenderManager = new WindowRenderManager(); 
		FieldGenerator lFieldHelper = new FieldGenerator(lWindowRenderManager);
		
		Helper.mStartTime = System.currentTimeMillis();
		
		Camera lCamera = new Camera(new Vector3f(0,2,0), 0, 0, 0);
		
		World lWorld = new World(); 


		new Thread( new Runnable() 
		{
			public void run() 
			{
				while(mbCloseWindow == false) 
				{
					addFields(lFieldHelper);			
				}
			}
		}).start();

		while(!Display.isCloseRequested())
		{
			
			lCamera.move();
			//for thread location
			mCamPos = lCamera.getPosition();
						
			displayWorld(lWorld);
		//	displaySingleField(lFieldHelper, lWorld);		
			
			lWindowRenderManager.renderWorld(lCamera, lWorld);

			//update window at given fps rate
			lWindowRenderManager.updateWindow();
		}
		
		mbCloseWindow = true;
		
		//clean gpu memory and close
		lWindowRenderManager.closeWindow();
	}
	
	
	public static void displaySingleField(FieldGenerator pFieldHelper, World pWorld) 
	{
		FieldBlocks lFieldBlocks =  pFieldHelper.addField(new Vector3f(0, 0 ,0));
		
		for(int  j = 0; j < lFieldBlocks.getEntities().size(); j++) 
		{
			pWorld.addEntity(lFieldBlocks.getEntities().get(j));
		}
	}
	
	public static void addFields(FieldGenerator pFieldHelper) 
	{
		for (int x = (int) (mCamPos.x - CommonConstants.WORLD_SIZE)/CommonConstants.FIELD_SIZE; x < (mCamPos.x + CommonConstants.WORLD_SIZE)/CommonConstants.FIELD_SIZE; x++) 
		{
			for (int z = (int) (mCamPos.z - CommonConstants.WORLD_SIZE)/CommonConstants.FIELD_SIZE; z < (mCamPos.z + CommonConstants.WORLD_SIZE)/CommonConstants.FIELD_SIZE; z++) 
			{		
				if(mUsedPos.contains(new Vector3f(x * CommonConstants.FIELD_SIZE, 0 , z * CommonConstants.FIELD_SIZE)) == false)
				{
					FieldBlocks lFieldBlocks =  pFieldHelper.addField(new Vector3f(x * CommonConstants.FIELD_SIZE, 0 , z * CommonConstants.FIELD_SIZE));
					//lFieldHelper.addGrassField(x, z);
					mlistFieldBlocks.add(lFieldBlocks);
					mUsedPos.add(new Vector3f(x * CommonConstants.FIELD_SIZE, 0 , z * CommonConstants.FIELD_SIZE));						
				}
			}
		}	
	}
	
	public static void displayWorld(World pWorld) 
	{
		for( int i = 0; i < mlistFieldBlocks.size(); i++ )
		{
			Vector3f lBlockPosition = mlistFieldBlocks.get(i).getPosition();
			int distX = (int) (mCamPos.x - lBlockPosition.x);
			int distZ = (int) (mCamPos.z - lBlockPosition.z);
				
			distX = Math.abs(distX);
			distZ = Math.abs(distZ);
			if( distX <= CommonConstants.WORLD_SIZE && distZ <= CommonConstants.WORLD_SIZE)
			{
				List<Entity> llistFieldEntities = mlistFieldBlocks.get(i).getEntities();
				for(int  j = 0; j < llistFieldEntities.size(); j++) 
				{
					pWorld.addEntity(llistFieldEntities.get(j));
				}
			}
		}	
	}
}
