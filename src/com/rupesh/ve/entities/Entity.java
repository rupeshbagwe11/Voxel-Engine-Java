package com.rupesh.ve.entities;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

import com.rupesh.ve.models.IUnitCube;
import com.rupesh.ve.util.CommonConstants;
import com.rupesh.ve.util.Helper;

public class Entity 
{
	IUnitCube mUnitCube;
	Vector3f mPosition;
	float mfRotX, mfRotY, mfRotZ;
	float mfScale;
	int miAnimationTracker[] = {0,0}; 
	
	public Entity(IUnitCube pUnitCube, Vector3f pPosition, float pRotX, float pRotY, float pRotZ, float pScale)
	{
		mUnitCube = pUnitCube;
		mPosition = pPosition;
		mfRotX = pRotX;
		mfRotY = pRotY;
		mfRotZ = pRotZ;
		mfScale = pScale;	
	}
	
	public void translate(float pDiffX, float pDiffY, float pDiffZ) 
	{	
		mPosition.x = mPosition.x + pDiffX;
		mPosition.y = mPosition.y + pDiffY;
		mPosition.z = mPosition.z + pDiffZ;	
	}
	
	public void rotate(float pDiffX, float pDiffY, float pDiffZ) 
	{
		mfRotX = mfRotX + pDiffX;
		mfRotY = mfRotY + pDiffY;
		mfRotZ = mfRotZ + pDiffZ;		
	}
	
	public void scale(float pScale) 
	{	
		mfScale = mfScale + pScale;	
	}

	public IUnitCube getUnitCube()
	{
		return mUnitCube;
	}

	public void setTextureModel(IUnitCube pUnitCube) 
	{
		mUnitCube = pUnitCube;
	}

	public Vector3f getPosition()
	{
		return mPosition;
	}

	public void setPosition(Vector3f pPosition) 
	{
		mPosition = pPosition;
	}

	public float getRotX() 
	{
		return mfRotX;
	}

	public void setRotX(float pRotX)
	{
		mfRotX = pRotX;
	}

	public float getRotY() 
	{
		return mfRotY;
	}

	public void setRotY(float pRotY)
	{
		mfRotZ = pRotY;
	}

	public float getRotZ()
	{
		return mfRotZ;
	}

	public void setRotZ(float pRotZ) 
	{
		mfRotZ = pRotZ;
	}

	public float getScale()
	{
		return mfScale;
	}

	public void setScale(float pScale)
	{
		mfScale = pScale;
	}
	
	public Matrix4f getModelMatrix() 
	{		
		Matrix4f lMatrix = new Matrix4f();
		lMatrix.setIdentity();
		
		if(mUnitCube.hasAnimation() == true)
		{
			Vector3f ldiff = animateModel(mUnitCube.getAnimation());
			mPosition.x = mPosition.x + ldiff.x;
			mPosition.y = mPosition.y + ldiff.y;
			mPosition.z = mPosition.z + ldiff.z;
			
			Matrix4f.translate(mPosition, lMatrix, lMatrix);
		}
		else
		{
			Matrix4f.translate(mPosition, lMatrix, lMatrix);
		}
		
		Matrix4f.rotate((float) Math.toRadians(mfRotX), new Vector3f(1, 0, 0),  lMatrix, lMatrix);
		Matrix4f.rotate((float) Math.toRadians(mfRotY), new Vector3f(0, 1, 0),  lMatrix, lMatrix);
		Matrix4f.rotate((float) Math.toRadians(mfRotZ), new Vector3f(0, 0, 1),  lMatrix, lMatrix);
		Matrix4f.scale(new Vector3f(mfScale, mfScale, mfScale), lMatrix, lMatrix);
		
		return lMatrix;	
	}
	
	public Vector3f animateModel(int pType)
	{	
		 
		long miAnimationCounter = Helper.getAnimationCounter();
		

		int lAnimationT = (int) (miAnimationCounter % 8);
		
		if(pType == CommonConstants.ANIMATION_MOVE)
		{
			Vector3f ldiff  = new Vector3f(0,0,0);
// continuous animation			
//			int sign = -1;
//			if( lAnimationT < 4 )
//			{
//				sign = 1;
//			}
//			ldiff.x = ldiff.x + ( sign * 0.05f);
// per counter animation			
			if(miAnimationTracker[0] != lAnimationT)
			{
				if( lAnimationT < 4 )
				{
					ldiff.x = ldiff.x + lAnimationT;
				}
				else
				{
					ldiff.x = ldiff.x - (lAnimationT - 4);
				}
				miAnimationTracker[0] = lAnimationT;
			}	
			return ldiff;
		}
		else if(pType == CommonConstants.ANIMATION_JUMP)
		{
			Vector3f ldiff  = new Vector3f(0,0,0);
			int sign = -1;
			if( lAnimationT < 4 )
			{
				sign = 1;
			}
			ldiff.y = ldiff.y + ( sign * 0.02f);
			
			
//			if(miAnimationTracker[1] != lAnimationX)
//			{
//				if( lAnimationX < 4 )
//				{
//					ldiff.y = ldiff.y + (lAnimationX * 0.25f);
//				}
//				else
//				{
//					ldiff.y = ldiff.y - ((lAnimationX - 4) * 0.25f);
//				}
//				miAnimationTracker[1] = lAnimationX;
//			}	
			return ldiff;
		}
		else if(pType == CommonConstants.ANIMATION_FLY)
		{
			Vector3f ldiff  = new Vector3f(0,0,0);
			int signX = -1, signY = 1;
			if( lAnimationT < 4 )
			{
				signX = 1;		
			}
			if(lAnimationT > 1 && lAnimationT < 6 )
			{
				signY = - 1;
			}
			if(lAnimationT > 0 && lAnimationT < 3)
			{
				signY =  0;
			}
			ldiff.x = ldiff.x + ( signX * 0.05f);
			ldiff.y = ldiff.y + ( signY * 0.04f);
			return ldiff;
		}
		
		return new Vector3f(0,0,0);
	}
	
}
