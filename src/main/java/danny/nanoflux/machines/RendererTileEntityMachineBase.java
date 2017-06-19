package danny.nanoflux.machines;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class RendererTileEntityMachineBase extends TileEntitySpecialRenderer<TileEntityMachineBase>
{
	@Override
	public void renderTileEntityAt(TileEntityMachineBase te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);

		MachineBase machine = te.getMachine();
		TexturesMachine textures = machine.getTextures();
				
		this.render(textures.getFront(), te.getFacing(), x, y, z);
		this.render(textures.getSide(), te.getFacing().rotateY(), x, y, z);
		this.render(textures.getSide(), te.getFacing().rotateY().rotateY(), x, y, z);
		this.render(textures.getSide(), te.getFacing().rotateY().rotateY().rotateY(), x, y, z);

		this.render(textures.getUp(), EnumFacing.UP, x, y, z);
		this.render(textures.getDown(), EnumFacing.DOWN, x, y, z);
	}
	
	private void render(ResourceLocation texture, EnumFacing facing, double x, double y, double z)
	{
		GlStateManager.pushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GlStateManager.translate(x, y, z);
		
		Tessellator te = Tessellator.getInstance();
		VertexBuffer vb = te.getBuffer();
		vb.begin(7, DefaultVertexFormats.POSITION_TEX);
		super.bindTexture(texture);
		
		switch (facing)
		{
			case UP:
				vb.pos(0, 1, 0).tex(1, 1).endVertex();
				vb.pos(0, 1, 1).tex(1, 0).endVertex();
				vb.pos(1, 1, 1).tex(0, 0).endVertex();
				vb.pos(1, 1, 0).tex(0, 1).endVertex();
				break;

			case DOWN:
				vb.pos(1, 0, 0).tex(1, 1).endVertex();
				vb.pos(1, 0, 1).tex(1, 0).endVertex();
				vb.pos(0, 0, 1).tex(0, 0).endVertex();
				vb.pos(0, 0, 0).tex(0, 1).endVertex();
				break;

			case NORTH:
				vb.pos(0, 0, 0).tex(1, 1).endVertex();
				vb.pos(0, 1, 0).tex(1, 0).endVertex();
				vb.pos(1, 1, 0).tex(0, 0).endVertex();
				vb.pos(1, 0, 0).tex(0, 1).endVertex();
				break;

			case SOUTH:
				vb.pos(1, 0, 1).tex(1, 1).endVertex();
				vb.pos(1, 1, 1).tex(1, 0).endVertex();
				vb.pos(0, 1, 1).tex(0, 0).endVertex();
				vb.pos(0, 0, 1).tex(0, 1).endVertex();
				break;

			case EAST:
				vb.pos(1, 0, 0).tex(1, 1).endVertex();
				vb.pos(1, 1, 0).tex(1, 0).endVertex();
				vb.pos(1, 1, 1).tex(0, 0).endVertex();
				vb.pos(1, 0, 1).tex(0, 1).endVertex();
				break;

			case WEST:
				vb.pos(0, 0, 1).tex(1, 1).endVertex();
				vb.pos(0, 1, 1).tex(1, 0).endVertex();
				vb.pos(0, 1, 0).tex(0, 0).endVertex();
				vb.pos(0, 0, 0).tex(0, 1).endVertex();
				break;

			default:
				vb.pos(0, 0, 0).tex(1, 1).endVertex();
				vb.pos(0, 1, 0).tex(1, 0).endVertex();
				vb.pos(1, 1, 0).tex(0, 0).endVertex();
				vb.pos(1, 0, 0).tex(0, 1).endVertex();
				break;
		}
		
		te.draw();
		GlStateManager.popMatrix();
	}
	
}
