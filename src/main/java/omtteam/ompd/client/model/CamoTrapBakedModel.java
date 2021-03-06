package omtteam.ompd.client.model;

import com.google.common.base.Function;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;
import omtteam.omlib.render.CamoBakedModel;
import omtteam.ompd.reference.OMPDNames;
import omtteam.ompd.reference.Reference;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Keridos on 31/01/17.
 * This Class
 */
public class CamoTrapBakedModel extends CamoBakedModel {
    private static final ResourceLocation FAKE_LOCATION = new ResourceLocation(Reference.MOD_ID, "models/block/custom/camo_trap");

    private CamoTrapBakedModel(List<IBakedModel> list) {
        super(list);
    }

    @Override
    protected IBakedModel getModel(List<IBakedModel> list, IBlockState state) {
        return list.get(0);
    }

    public static class Model implements IModel {
        @Override
        public Collection<ResourceLocation> getDependencies() {
            List<ResourceLocation> list = new ArrayList<>();
            list.add(new ModelResourceLocation(Reference.MOD_ID + ":camo_trap_normal"));
            return list;
        }

        @Override
        public Collection<ResourceLocation> getTextures() {
            return Collections.emptyList();
        }

        @Override
        public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
            List<IBakedModel> list = new ArrayList<>();
            try {
                list.add(ModelLoaderRegistry.getModel(new ModelResourceLocation(Reference.MOD_ID + ":camo_trap_normal")).bake(state, format, bakedTextureGetter));
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new CamoTrapBakedModel(list);
        }

        @Override
        public IModelState getDefaultState() {
            return null;
        }
    }

    public static class ModelLoader implements ICustomModelLoader {

        @Override
        public boolean accepts(ResourceLocation modelLocation) {
            return (!modelLocation.getResourceDomain().equals(Reference.MOD_ID) && modelLocation.equals(FAKE_LOCATION));
        }

        @Override
        public IModel loadModel(ResourceLocation modelLocation) throws Exception {
            return new Model();
        }

        @Override
        @ParametersAreNonnullByDefault
        public void onResourceManagerReload(IResourceManager resourceManager) {
            // Nothing to do
        }
    }

    public static class Statemapper extends StateMapperBase {
        private static final ModelResourceLocation LOCATION = new ModelResourceLocation(Reference.MOD_ID + ":" + OMPDNames.Blocks.camoTrap, "normal");

        @Override
        @Nonnull
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            return LOCATION;
        }
    }
}
