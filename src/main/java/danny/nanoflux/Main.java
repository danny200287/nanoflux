package danny.nanoflux;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION, useMetadata = false)
public final class Main
{

	public static final String MODID = "nanoflux";
	public static final String VERSION = "1.0";

	@Instance
	public static Main INSTANCE;

	@SidedProxy(clientSide = "danny.nanoflux.ProxyClient", serverSide = "danny.nanoflux.ProxyServer")
	public static ProxyCommon proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		proxy.postInit(e);
	}

}
