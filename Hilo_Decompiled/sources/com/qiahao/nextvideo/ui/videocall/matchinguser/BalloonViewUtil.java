package com.qiahao.nextvideo.ui.videocall.matchinguser;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.skydoves.balloon.ArrowConstraints;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/matchinguser/BalloonViewUtil;", "", "<init>", "()V", "createView", "Lcom/skydoves/balloon/Balloon;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "marginButton", "", "marginLeft", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBalloonViewUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BalloonViewUtil.kt\ncom/qiahao/nextvideo/ui/videocall/matchinguser/BalloonViewUtil\n+ 2 Balloon.kt\ncom/skydoves/balloon/BalloonKt\n*L\n1#1,71:1\n94#2:72\n94#2:73\n*S KotlinDebug\n*F\n+ 1 BalloonViewUtil.kt\ncom/qiahao/nextvideo/ui/videocall/matchinguser/BalloonViewUtil\n*L\n21#1:72\n55#1:73\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BalloonViewUtil {

    @NotNull
    public static final BalloonViewUtil INSTANCE = new BalloonViewUtil();

    private BalloonViewUtil() {
    }

    public static /* synthetic */ Balloon createView$default(BalloonViewUtil balloonViewUtil, Context context, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloonViewUtil.createView(context, view, i, i2);
    }

    @NotNull
    public final Balloon createView(@NotNull Context context, @NotNull View view, int marginButton, int marginLeft) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Balloon.Builder builder = new Balloon.Builder(context);
        builder.setElevation(0);
        builder.setLayout(view);
        builder.setArrowColorResource(2131099824);
        builder.setArrowSize(10);
        builder.setArrowConstraints(ArrowConstraints.ALIGN_ANCHOR);
        builder.setCornerRadius(10.0f);
        builder.setHeight(Integer.MIN_VALUE);
        builder.setMargin(10);
        builder.setBackgroundColorResource(2131099824);
        builder.setDismissWhenTouchOutside(false);
        builder.setDismissWhenClicked(false);
        builder.setDismissWhenOverlayClicked(false);
        builder.setBalloonAnimation(BalloonAnimation.FADE);
        builder.setHeight(80);
        builder.setWidthRatio(1.0f);
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            builder.setMarginLeft(marginLeft);
        } else {
            builder.setMarginRight(marginLeft);
        }
        builder.setLifecycleOwner(builder.lifecycleOwner);
        if (marginButton <= 10) {
            marginButton = 10;
        }
        builder.setMarginBottom(marginButton);
        Balloon build = builder.build();
        build.getContentView().getRootView().startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_floating_popup));
        return build;
    }

    public static /* synthetic */ Balloon createView$default(BalloonViewUtil balloonViewUtil, Context context, View view, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return balloonViewUtil.createView(context, view, i);
    }

    @NotNull
    public final Balloon createView(@NotNull Context context, @NotNull View view, int marginButton) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Balloon.Builder builder = new Balloon.Builder(context);
        builder.setLayout(view);
        builder.setIsVisibleArrow(false);
        builder.setHeight(Integer.MIN_VALUE);
        builder.setWidthRatio(1.0f);
        builder.setBackgroundColorResource(2131101182);
        builder.setDismissWhenTouchOutside(true);
        builder.setDismissWhenClicked(false);
        builder.setDismissWhenOverlayClicked(false);
        builder.setBalloonAnimation(BalloonAnimation.FADE);
        builder.setLifecycleOwner(builder.lifecycleOwner);
        builder.setMarginBottom(marginButton);
        return builder.build();
    }
}
