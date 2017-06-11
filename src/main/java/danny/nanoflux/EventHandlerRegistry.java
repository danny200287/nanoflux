package danny.nanoflux;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public abstract class EventHandlerRegistry
{

	@SubscribeEvent
	public static void registerCapability(AttachCapabilitiesEvent<TileEntity> event)
	{
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
	}

}
