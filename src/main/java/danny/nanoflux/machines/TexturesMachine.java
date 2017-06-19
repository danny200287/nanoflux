package danny.nanoflux.machines;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class TexturesMachine
{
	private ResourceLocation front;
	private ResourceLocation back;
	private ResourceLocation side;
	private ResourceLocation up;
	private ResourceLocation down;

	public TexturesMachine(ResourceLocation front, ResourceLocation back, ResourceLocation side, ResourceLocation up, ResourceLocation down)
	{
		this.front = front;
		this.back = back;
		this.side = side;
		this.up = up;
		this.down = down;
	}
	
	public TexturesMachine(ResourceLocation front, ResourceLocation side)
	{
		this.front = front;
		this.back = side;
		this.side = side;
		this.up = side;
		this.down = side;
	}

	public ResourceLocation getDown()
	{
		return down;
	}

	public ResourceLocation getFront()
	{
		return front;
	}

	public ResourceLocation getSide()
	{
		return side;
	}

	public ResourceLocation getUp()
	{
		return up;
	}
	
	public ResourceLocation getBack()
	{
		return back;
	}
	
	public ResourceLocation getTextureFromFacing(EnumFacing facing)
	{
		switch (facing)
		{
			case UP:
				return this.up;
				
			case DOWN:
				return this.down;
				
			default:
				return this.side;
		}
	}
}
