package danny.nanoflux.items;

import danny.nanoflux.client.CreativeTabsCustom;
import net.minecraft.item.Item;

public class ItemBase extends Item
{

	public ItemBase(String unlocalizedName)
	{
		super();

		this.setRegistryName(unlocalizedName);
		this.setUnlocalizedName(getRegistryName().toString());

		this.setCreativeTab(CreativeTabsCustom.TABNANOFLUX);
	}

}
