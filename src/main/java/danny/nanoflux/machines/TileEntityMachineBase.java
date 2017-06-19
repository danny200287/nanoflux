package danny.nanoflux.machines;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class TileEntityMachineBase extends TileEntity
{
	private MachineBase machine;
	private EnumFacing facing;

	public TileEntityMachineBase()
	{
	}

	public MachineBase getMachine()
	{
		return machine;
	}

	public EnumFacing getFacing()
	{
		return facing;
	}

	@Override
	public ITextComponent getDisplayName()
	{
		return new TextComponentString(this.getMachine().getRegistryName().toString());
	}
	
	@Override
	public void onLoad()
	{
		this.machine = (MachineBase)super.getBlockType();
		this.facing = EnumFacing.getFront(this.machine.getMetaFromState(this.world.getBlockState(this.pos)));
	}
}
