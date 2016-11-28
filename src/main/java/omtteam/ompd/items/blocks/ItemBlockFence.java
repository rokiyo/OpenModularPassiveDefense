package omtteam.ompd.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import omtteam.ompd.handler.ConfigHandler;
import omtteam.ompd.init.ModBlocks;
import omtteam.ompd.reference.Names;

import java.util.List;

public class ItemBlockFence extends ItemBlock {
    public ItemBlockFence(Block block) {
        super(block);
        setHasSubtypes(true);
    }

    public final static String[] subNames = {
            Names.Blocks.fenceTierOne, Names.Blocks.fenceTierTwo, Names.Blocks.fenceTierThree,
            Names.Blocks.fenceTierTwo, Names.Blocks.fenceTierFive
    };

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for (int i = 0; i < 5; i++) {
            subItems.add(new ItemStack(ModBlocks.hardWall, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return subNames[itemStack.getItemDamage()];
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        switch (stack.getMetadata()) {
            case 0:
                tooltip.add("");
                tooltip.add(TextFormatting.AQUA + "--" + I18n.translateToLocal("tooptip.energy.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.rf.max") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierOneMaxCharge());
                tooltip.add(I18n.translateToLocal("tooltip.rf.io") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierOneMaxIo());
                tooltip.add("");
                tooltip.add(TextFormatting.GREEN + "--" + I18n.translateToLocal("tooltip.extras.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.extras.addons.0"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.base.1"));
                return;
            case 1:
                tooltip.add("");
                tooltip.add(TextFormatting.AQUA + "--" + I18n.translateToLocal("tooptip.energy.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.rf.max") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierTwoMaxCharge());
                tooltip.add(I18n.translateToLocal("tooltip.rf.io") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierTwoMaxIo());
                tooltip.add("");
                tooltip.add(TextFormatting.GREEN + "--" + I18n.translateToLocal("tooltip.extras.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.extras.addons.2"));
                tooltip.add(I18n.translateToLocal("tooltip.extras.upgrade.1"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.base.2"));
                return;
            case 2:
                tooltip.add("");
                tooltip.add(TextFormatting.AQUA + "--" + I18n.translateToLocal("tooptip.energy.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.rf.max") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierThreeMaxCharge());
                tooltip.add(I18n.translateToLocal("tooltip.rf.io") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierThreeMaxIo());
                tooltip.add("");
                tooltip.add(TextFormatting.GREEN + "--" + I18n.translateToLocal("tooltip.extras.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.extras.addons.2"));
                tooltip.add(I18n.translateToLocal("tooltip.extras.upgrade.1"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.base.3"));
                return;
            case 3:
                tooltip.add("");
                tooltip.add(TextFormatting.AQUA + "--" + I18n.translateToLocal("tooptip.energy.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.rf.max") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierFourMaxCharge());
                tooltip.add(I18n.translateToLocal("tooltip.rf.io") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierFourMaxIo());
                tooltip.add("");
                tooltip.add(TextFormatting.GREEN + "--" + I18n.translateToLocal("tooltip.extras.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.extras.addons.2"));
                tooltip.add(I18n.translateToLocal("tooltip.extras.upgrade.1"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.base.4"));
                return;
            case 4:
                tooltip.add("");
                tooltip.add(TextFormatting.AQUA + "--" + I18n.translateToLocal("tooptip.energy.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.rf.max") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierFiveMaxCharge());
                tooltip.add(I18n.translateToLocal("tooltip.rf.io") + ": " + TextFormatting.WHITE +
                        ConfigHandler.getBaseTierFiveMaxIo());
                tooltip.add("");
                tooltip.add(TextFormatting.GREEN + "--" + I18n.translateToLocal("tooltip.extras.label") + "--");
                tooltip.add(I18n.translateToLocal("tooltip.extras.addons.2"));
                tooltip.add(I18n.translateToLocal("tooltip.extras.upgrade.2"));
                tooltip.add("");
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.base.5a"));
                tooltip.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.base.5b"));
        }
    }
}