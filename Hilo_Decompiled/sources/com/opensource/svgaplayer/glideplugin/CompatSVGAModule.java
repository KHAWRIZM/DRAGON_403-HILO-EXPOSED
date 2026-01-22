package com.opensource.svgaplayer.glideplugin;

import a5.b;
import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.g;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message = "Replaced by [SVGAModule] for Applications that use Glide's annotations.")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/CompatSVGAModule;", "La5/b;", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/bumptech/glide/b;", "builder", "", "applyOptions", "(Landroid/content/Context;Lcom/bumptech/glide/b;)V", "Lcom/bumptech/glide/Glide;", "glide", "Lcom/bumptech/glide/g;", "registry", "registerComponents", "(Landroid/content/Context;Lcom/bumptech/glide/Glide;Lcom/bumptech/glide/g;)V", "Lcom/opensource/svgaplayer/glideplugin/SVGAModule;", "actualModule$delegate", "Lkotlin/Lazy;", "getActualModule", "()Lcom/opensource/svgaplayer/glideplugin/SVGAModule;", "actualModule", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class CompatSVGAModule implements b {

    /* renamed from: actualModule$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy actualModule = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SVGAModule>() { // from class: com.opensource.svgaplayer.glideplugin.CompatSVGAModule$actualModule$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SVGAModule invoke() {
            return new SVGAModule();
        }
    });

    private final SVGAModule getActualModule() {
        return (SVGAModule) this.actualModule.getValue();
    }

    @Override // a5.b
    public void applyOptions(@NotNull Context context, @NotNull com.bumptech.glide.b builder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    @Override // a5.b
    public void registerComponents(@NotNull Context context, @NotNull Glide glide, @NotNull g registry) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(glide, "glide");
        Intrinsics.checkNotNullParameter(registry, "registry");
        getActualModule().registerComponents(context, glide, registry);
    }
}
