package com.rupesh.ve.renderengine;


import java.util.List;
import java.util.Map;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.PixelFormat;

import com.rupesh.ve.entities.Camera;
import com.rupesh.ve.entities.Entity;
import com.rupesh.ve.entities.World;
import com.rupesh.ve.shaders.Shader;
import com.rupesh.ve.util.CommonConstants;
import com.rupesh.ve.util.Helper;


public class WindowRenderManager 
{
	Shader mShader;
	Loader mLoader;
	
	public WindowRenderManager()
	{
		createWindow();
		
		mShader = new Shader();
		mLoader = new Loader();

		mShader.start();
		mShader.loadProjectionMatrix(Helper.createProjectionMatrix());
		mShader.stop();
		
	}
	
	// create a window
	public void createWindow()
	{
		//version number
		ContextAttribs lContextAttribs = new ContextAttribs(3,2)
				.withForwardCompatible(true)
				.withProfileCore(true);
				
		try 
		{
			//width and height of window
			Display.setDisplayMode(new DisplayMode(CommonConstants.WINDOW_WIDTH, CommonConstants.WINDOW_HEIGHT));
			Display.create(new PixelFormat(), lContextAttribs);
			Display.setTitle("Rupesh Voxel Engine");
			//Display.setFullscreen(true);
			GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
		} 
		catch (LWJGLException e)
		{
			e.printStackTrace();
		}
	}
	
	//Update window at fps rate
	public void updateWindow()
	{
		Display.sync(CommonConstants.FPS);
		Display.update();
		
		
		//handle keyboard events
		while(Keyboard.next()) 
		{
			if(Keyboard.getEventKeyState())
			{
				if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) 
				{
					closeWindow();
				}
				
				if( Keyboard.isKeyDown(Keyboard.KEY_M) )
				{
					if( Mouse.isGrabbed() )
					{
						Mouse.setGrabbed(false);
					}
					else
					{
						Mouse.setGrabbed(true);
					}
				}	
			}
			
			
		}
	}
	
	//clear the screen
	public void prepare()
	{
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glClearColor(0.5f, 0.8f, 1.0f, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		 
	}
	
	public void renderWorld(Camera pCamera, World pWorld)
	{
		prepare();
		mShader.start();
		mShader.loadViewMatrix(Helper.createViewMatrix(pCamera));
		render(pWorld);
		mShader.stop();
		
		pWorld.clear();	
	}
	
	
	private void render(World pWorld) 
	{	
		Map<Integer, List<Entity>> lUnitCubesTextureMapping = pWorld.getUnitTextureCubes();	
	//	Object[] liTextureIds = lUnitCubesTextureMapping.keySet().toArray();
	//	for (int i = 0; i < liTextureIds.length; i++)
	//	{
	//		int liTextureId = (int) liTextureIds[i];
		for (Integer liTextureId : lUnitCubesTextureMapping.keySet()) 
		{	
			
			List<Entity> lSameUnitCubesEntityList = lUnitCubesTextureMapping.get(liTextureId);
			
			GL30.glBindVertexArray(lSameUnitCubesEntityList.get(0).getUnitCube().getVaoID());
			GL20.glEnableVertexAttribArray(0);
			GL20.glEnableVertexAttribArray(1);
			
			//bind to texturesampler
			GL13.glActiveTexture(GL13.GL_TEXTURE0);
			GL11.glBindTexture(GL11.GL_TEXTURE_2D, liTextureId);
			mShader.loadTransparency(lSameUnitCubesEntityList.get(0).getUnitCube().hasTransparency());
			
		//	for (int j = 0; j < lSameUnitCubesEntityList.size(); j++)
		//	{
		//		Entity lEntity = lSameUnitCubesEntityList.get(j);
			for (Entity lEntity : lSameUnitCubesEntityList) 
			{
				mShader.loadModelMatrix(lEntity.getModelMatrix());		
				GL11.glDrawElements(GL11.GL_TRIANGLES, lEntity.getUnitCube().getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
				//GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getModel().getVertexCount());
			}
			
			GL20.glDisableVertexAttribArray(0);
			GL20.glDisableVertexAttribArray(1);
			GL30.glBindVertexArray(0);
			
		}
		
	}
	

	
	public Loader getLoader()
	{
		return mLoader;	
	}
	
	public Shader getShader()
	{
		return mShader;
	}
	
	
	//close the window
	public void closeWindow()
	{
		mShader.cleanUp();
		mLoader.cleanUp();
		Display.destroy();
		System.exit(0);
	}
}
