package com.rupesh.ve.util;

public class CommonConstants 
{
	public static final int WINDOW_WIDTH = 1024;
	public static final int WINDOW_HEIGHT = 768;
	public static final int FPS = 120;
	
	public static final String VERTEX_SHADER_FILE = "/com/rupesh/ve/shaders/vertexShader.txt";
	public static final String FRAGMENT_SHADER_FILE = "/com/rupesh/ve/shaders/fragmentShader.txt";
	
	public static final float FOV = 70f;
	public static final float NEAR_PLANE = 0.1f;
	public static final float FAR_PLANE = 10000f;
	
	public static final float CAMERA_SPEED = 0.3f; 
	public static final float CAMERA_TURN_SPEED = 0.2f; 
	
	public static final int FIELD_SIZE = 16;
	public static final int WORLD_SIZE = 5 * FIELD_SIZE;
	
	public static final int ANIMATION_MOVE = 1;
	public static final int ANIMATION_JUMP = 2;
	public static final int ANIMATION_FLY = 3;
	
}
