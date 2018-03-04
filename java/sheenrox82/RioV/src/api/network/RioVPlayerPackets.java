package sheenrox82.RioV.src.api.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import sheenrox82.RioV.src.api.util.RioVPlayer;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class RioVPlayerPackets implements IMessage, IMessageHandler<RioVPlayerPackets, IMessage> 
{
	private NBTTagCompound data;
	public EntityPlayer player;

	public RioVPlayerPackets()
	{

	}

	public RioVPlayerPackets(EntityPlayer player) 
	{
		data = new NBTTagCompound();
		this.player = player;
		RioVPlayer.get(this.player).saveNBTData(data);
	}

	@Override
	public void toBytes(ByteBuf buffer) 
	{
		ByteBufUtils.writeTag(buffer, data);
	}

	@Override
	public void fromBytes(ByteBuf buffer) 
	{
		data = ByteBufUtils.readTag(buffer);
	}

	@Override
	public IMessage onMessage(RioVPlayerPackets message, MessageContext ctx)
	{
		return null;
	}
}