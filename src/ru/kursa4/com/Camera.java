package ru.kursa4.com;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

public class Camera 
{

	//coordinates of camera
	private float x;
	private float y;
	private float z;
	
	//rotation
	private float rx;
	private float ry;
	private float rz;
	
	//field of view
	private float fov;
	
	
	private float aspect;
	
	//can't see something too close 
	private float near;
	
	//something to far
	private float far;
	
	
	
	
	public Camera(float fov, float aspect, float near, float far)
	{
		x = -2;
		y = -3;
		z = 16;
		rx = 1;
		ry = 176;
		rz = 1;
		
		this.fov = fov;
		this.aspect = aspect;
		this.near = near;
		this.far = far;
		
		initProjection();
	}
	
	
	public void initProjection()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, aspect, near,far);
		glMatrixMode(GL_MODELVIEW);
		
		glEnable(GL_DEPTH_TEST);		
	}
	
	public void useView()
	{
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 1, 0);
		glRotatef(rz, 1, 0, 1);
		
		glTranslatef(x, y, z);
	}
	
	////////////////////////
	public float getFov()
	{
		return this.fov;
	}
	
	public void setFov(float fov)
	{
		this.fov = fov;
	}
	
	public void setAspect(float aspect)
	{
		this.aspect = aspect;
	}
////////////////////////
	
	
	
	
	
	//////////////////////////
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getZ()
	{
		return z;
	}
	
	
	public void setX(float x)
	{
		this.x = x;
	}
	
	public void setY(float y)
	{
		this.y = y;
	}
	
	public void setZ(float z)
	{
		this.z = z;
	}
	//////////////////////////
	
	public float getRX()
	{
		return rx;
	}
	
	public float getRY()
	{
		return ry;
	}
	
	public float getRZ()
	{
		return rz;
	}
	
	
	public void setRX(float rx)
	{
		this.rx = rx;
	}
	
	public void setRY(float ry)
	{
		this.ry = ry;
	}
	
	public void setRZ(float rz)
	{
		this.rz = rz;
	}
	
	public void moveLR(float amt, float dir)
	{
	z += amt * Math.sin(Math.toRadians(ry + 90 * dir));
	x += amt * Math.cos(Math.toRadians(ry + 90 * dir));
	}
	
	public float coof = 0;
	
	public void moveUD(float amt, float dir)
	{
		y += 2*amt * Math.cos(Math.toRadians(rz + 90 * dir));
	}
	
	
	public void rotateY(float amt)
	{
		ry += amt + coof;		
	}
	
	public void rotateX(float amt)
	{
		rx += amt + coof;	
	}
	
	//////////////////////////
	
}
