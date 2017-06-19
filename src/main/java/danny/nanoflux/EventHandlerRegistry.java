package danny.nanoflux;

import danny.nanoflux.blocks.ModBlocks;
import danny.nanoflux.items.ModItems;
import danny.nanoflux.machines.ModMachines;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public abstract class EventHandlerRegistry
{

	@SubscribeEvent
	public static void registerCapability(AttachCapabilitiesEvent<TileEntity> event)
	{
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS);
		event.getRegistry().registerAll(ModMachines.MACHINES);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS);

		for (Block block : ModBlocks.BLOCKS)
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		
		for (Block block : ModMachines.MACHINES)
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		for (Block block : ModBlocks.BLOCKS)
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		
		for (Block block : ModMachines.MACHINES)
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));

		for (Item item : ModItems.ITEMS)
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
