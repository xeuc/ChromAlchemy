package net.xeuc.chromalchemy.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class MinionScepterItem extends Item {
    public MinionScepterItem(Properties pProperties){
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(!pContext.getLevel().isClientSide()) {
            Player player = pContext.getPlayer();
            // Spawn a chicken
            Chicken chicken = new Chicken(EntityType.CHICKEN, pContext.getLevel());
            BlockPos positionClicked = pContext.getClickedPos();
            chicken.setPos(positionClicked.getX() + .5, positionClicked.getY() + 1, positionClicked.getZ() + .5);
            pContext.getLevel().addFreshEntity(chicken);
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), EquipmentSlot.MAINHAND);

        return InteractionResult.SUCCESS;
    }
}
