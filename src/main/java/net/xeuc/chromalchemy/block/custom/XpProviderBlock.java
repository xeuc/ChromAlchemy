package net.xeuc.chromalchemy.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class XpProviderBlock extends Block {
    public XpProviderBlock(Properties pProperties){
        super(pProperties);
    }


    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            // Give some XP
            if (pPlayer instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer) pPlayer;
                serverPlayer.giveExperiencePoints(1);
            }
        }
        return ItemInteractionResult.SUCCESS;
    }
}
