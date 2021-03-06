package WayofTime.bloodmagic.item.sigil;

import WayofTime.bloodmagic.api.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSigilFastMiner extends ItemSigilToggleable
{
    public ItemSigilFastMiner()
    {
        super("fastMiner", 100);
        setRegistryName(Constants.BloodMagicItem.SIGIL_FAST_MINER.getRegName());
    }

    @Override
    public void onSigilUpdate(ItemStack stack, World world, EntityPlayer player, int itemSlot, boolean isSelected)
    {
        player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 2, 0, true, false));
    }
}
