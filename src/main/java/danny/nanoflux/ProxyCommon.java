package danny.nanoflux;

import danny.nanoflux.machines.TileEntityMachineBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class ProxyCommon
{

	public void preInit(FMLPreInitializationEvent e)
	{
		GameRegistry.registerTileEntity(TileEntityMachineBase.class, "nanoflux:TileEntityMachineBase");
	}

	public void init(FMLInitializationEvent e)
	{
	}

	public void postInit(FMLPostInitializationEvent e)
	{
	}

}
