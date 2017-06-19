package danny.nanoflux;

import danny.nanoflux.machines.RendererTileEntityMachineBase;
import danny.nanoflux.machines.TileEntityMachineBase;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public final class ProxyClient extends ProxyCommon
{

	@Override
	public void preInit(FMLPreInitializationEvent e)
	{
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e)
	{
		super.init(e);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachineBase.class, new RendererTileEntityMachineBase());
	}

	@Override
	public void postInit(FMLPostInitializationEvent e)
	{
		super.postInit(e);
	}

}
