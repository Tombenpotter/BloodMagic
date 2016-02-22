package WayofTime.bloodmagic.proxy;

import WayofTime.bloodmagic.client.render.*;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import WayofTime.bloodmagic.api.Constants;
import WayofTime.bloodmagic.client.helper.ShaderHelper;
import WayofTime.bloodmagic.client.mesh.CustomMeshDefinitionActivatable;
import WayofTime.bloodmagic.client.render.entity.BloodLightRenderFactory;
import WayofTime.bloodmagic.client.render.entity.SentientArrowRenderFactory;
import WayofTime.bloodmagic.client.render.entity.SoulSnareRenderFactory;
import WayofTime.bloodmagic.entity.projectile.EntityBloodLight;
import WayofTime.bloodmagic.entity.projectile.EntitySentientArrow;
import WayofTime.bloodmagic.entity.projectile.EntitySoulSnare;
import WayofTime.bloodmagic.registry.ModBlocks;
import WayofTime.bloodmagic.registry.ModItems;
import WayofTime.bloodmagic.tile.TileAlchemyArray;
import WayofTime.bloodmagic.tile.TileAltar;
import WayofTime.bloodmagic.tile.TileDemonCrucible;
import WayofTime.bloodmagic.tile.routing.TileRoutingNode;
import WayofTime.bloodmagic.util.handler.ClientEventHandler;
import WayofTime.bloodmagic.util.helper.InventoryRenderHelper;
import WayofTime.bloodmagic.util.helper.InventoryRenderHelperV2;

public class ClientProxy extends CommonProxy
{
    private InventoryRenderHelper renderHelper;
    private InventoryRenderHelperV2 renderHelperV2;

    @Override
    public InventoryRenderHelper getRenderHelper()
    {
        return renderHelper;
    }

    @Override
    public InventoryRenderHelperV2 getRenderHelperV2()
    {
        return renderHelperV2;
    }

    @Override
    public void preInit()
    {
        super.preInit();
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());

        renderHelper = new InventoryRenderHelper(Constants.Mod.DOMAIN);
        renderHelperV2 = new InventoryRenderHelperV2(Constants.Mod.DOMAIN);

        OBJLoader.instance.addDomain(Constants.Mod.MODID);

        ModBlocks.initRenders();
        ModItems.initRenders();

        ClientRegistry.bindTileEntitySpecialRenderer(TileAlchemyArray.class, new RenderAlchemyArray());
        ClientRegistry.bindTileEntitySpecialRenderer(TileAltar.class, new RenderAltar());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRoutingNode.class, new RenderItemRoutingNode());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDemonCrucible.class, new RenderDemonCrucible());
    }

    @Override
    public void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntitySoulSnare.class, new SoulSnareRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntitySentientArrow.class, new SentientArrowRenderFactory());
        RenderingRegistry.registerEntityRenderingHandler(EntityBloodLight.class, new BloodLightRenderFactory());
        ModelLoader.setCustomMeshDefinition(ModItems.sentientSword, new CustomMeshDefinitionActivatable("ItemSentientSword"));
        ModelLoader.setCustomMeshDefinition(ModItems.boundShovel, new CustomMeshDefinitionActivatable("ItemBoundShovel"));
        ModelLoader.setCustomMeshDefinition(ModItems.boundAxe, new CustomMeshDefinitionActivatable("ItemBoundAxe"));
        ModelLoader.setCustomMeshDefinition(ModItems.boundPickaxe, new CustomMeshDefinitionActivatable("ItemBoundPickaxe"));
        ModelLoader.setCustomMeshDefinition(ModItems.boundSword, new CustomMeshDefinitionActivatable("ItemBoundSword"));

        ShaderHelper.init();
    }

    @Override
    public void init()
    {
//        RenderingRegistry.registerEntityRenderingHandler(EntityBloodLight.class, new RenderEntityBloodLight(Minecraft.getMinecraft().getRenderManager()));
    }

    @Override
    public void postInit()
    {

    }
}
