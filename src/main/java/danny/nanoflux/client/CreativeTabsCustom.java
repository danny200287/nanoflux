package danny.nanoflux.client;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class CreativeTabsCustom
{

	public static final CreativeTabs TABNANOFLUX = new CreativeTabs(CreativeTabs.getNextID(), "Nano Flux")
	{
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem()
		{
			return new ItemStack(Items.EMERALD);
		}
	};

}
