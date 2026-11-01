package blazeirongolempeace.modid.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public abstract class MobMixin {

    @Inject(method = "setTarget", at = @At("HEAD"), cancellable = true)
    private void blazesIgnoreIronGolems(LivingEntity target, CallbackInfo ci) {
        Mob self = (Mob) (Object) this;
        if (target != null
                && self.getClass().getSimpleName().equals("Blaze")
                && target.getClass().getSimpleName().equals("IronGolem")) {
            ci.cancel();
        }
    }
}