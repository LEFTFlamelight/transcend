package huige233.transcend.gui;

import huige233.transcend.tileEntity.ContainerVirusGenerator;
import huige233.transcend.tileEntity.GuiVirusGenerator;
import huige233.transcend.tileEntity.TileEntityVirusGenerator;
import huige233.transcend.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

public class ModGuiElementLoader implements IGuiHandler {
    public static final int GUI_VIRUS_GENERATOR = 1;
    public static final int GUI_DEMO = 2;
    public static final int GUI_RESEARCH = 3;

    public ModGuiElementLoader() {
        NetworkRegistry.INSTANCE.registerGuiHandler(Reference.instance, this);
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x,int y,int z) {
        switch (ID)
        {
            case GUI_VIRUS_GENERATOR:
                return new ContainerVirusGenerator(player.inventory,(TileEntityVirusGenerator) world.getTileEntity(new BlockPos(x,y,z)));

            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID)
        {
            case GUI_VIRUS_GENERATOR:
                return new GuiVirusGenerator(player.inventory,(TileEntityVirusGenerator) world.getTileEntity(new BlockPos(x,y,z)));

            default:
                return null;
        }
    }
}
