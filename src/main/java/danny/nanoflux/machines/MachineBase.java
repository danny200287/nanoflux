package danny.nanoflux.machines;

import danny.nanoflux.client.CreativeTabsCustom;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachineBase extends BlockDirectional implements ITileEntityProvider
{

	protected TexturesMachine textures;

	public MachineBase(String unlocalizedName, Material materialIn, float hardness, float resistance)
	{
		super(materialIn);

		this.setRegistryName(unlocalizedName);
		this.setUnlocalizedName(this.getRegistryName().toString());

		this.setCreativeTab(CreativeTabsCustom.TABNANOFLUX);

		this.setHardness(hardness);
		this.setResistance(resistance);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));

		this.setTextures();
	}

	public MachineBase(String unlocalizedName, float hardness, float resistance)
	{
		this(unlocalizedName, Material.ROCK, hardness, resistance);
	}

	public MachineBase(String unlocalizedName)
	{
		this(unlocalizedName, 2.0f, 10.0f);
	}

	protected void setTextures()
	{
		ResourceLocation resourceLocationMachine = this.getRegistryName();
		String domain = resourceLocationMachine.getResourceDomain();
		String path = resourceLocationMachine.getResourcePath();
		
		this.textures = new TexturesMachine(
			new ResourceLocation(String.format("%s:textures/machines/%s_front.png", domain, path)), 
			new ResourceLocation(String.format("%s:textures/machines/%s_side.png", domain, path))
		);
	}

	public TexturesMachine getTextures()
	{
		return this.textures;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityMachineBase();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

	@Override
    public int getMetaFromState(IBlockState state)
    {
    	return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }
    
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] { FACING });
    }

}
