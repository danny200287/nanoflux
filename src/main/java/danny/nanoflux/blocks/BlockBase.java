package danny.nanoflux.blocks;

import danny.nanoflux.client.CreativeTabsCustom;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{

	public BlockBase(String unlocalizedName, Material materialIn, float hardness, float resistance)
	{
		super(materialIn);

		this.setRegistryName(unlocalizedName);
		this.setUnlocalizedName(getRegistryName().toString());

		this.setCreativeTab(CreativeTabsCustom.TABNANOFLUX);

		this.setHardness(hardness);
		this.setResistance(resistance);
	}

	public BlockBase(String unlocalizedName, float hardness, float resistance)
	{
		this(unlocalizedName, Material.ROCK, hardness, resistance);
	}

	public BlockBase(String unlocalizedName)
	{
		this(unlocalizedName, 2.0f, 10.0f);
	}

}
