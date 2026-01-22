package com.qiahao.nextvideo.room.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.data.model.SocketGlobalBroadCastBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0012J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0012R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/room/view/GlobalRoomBroadCastLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mGlobalRoomBroadCastLayoutHandler", "Lcom/qiahao/nextvideo/room/view/GlobalRoomBroadCastLayoutHandler;", "mTextBroadCastList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/SocketGlobalBroadCastBean;", "Lkotlin/collections/ArrayList;", "animator", "Landroid/animation/ObjectAnimator;", "initView", "", "hasNewBroadcast", "socketGlobalBroadCastBean", "showBroadCastView", "judgeTime", "", "view", "", "release", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGlobalRoomBroadCastLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalRoomBroadCastLayout.kt\ncom/qiahao/nextvideo/room/view/GlobalRoomBroadCastLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,137:1\n255#2:138\n*S KotlinDebug\n*F\n+ 1 GlobalRoomBroadCastLayout.kt\ncom/qiahao/nextvideo/room/view/GlobalRoomBroadCastLayout\n*L\n52#1:138\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalRoomBroadCastLayout extends FrameLayout {
    public static final int MSG_SHOW_BROADCAST = 1;

    @NotNull
    public static final String TAG = "GlobalRoomBroad";

    @Nullable
    private ObjectAnimator animator;

    @Nullable
    private GlobalRoomBroadCastLayoutHandler mGlobalRoomBroadCastLayoutHandler;

    @NotNull
    private final ArrayList<SocketGlobalBroadCastBean> mTextBroadCastList;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlobalRoomBroadCastLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void initView() {
        this.mGlobalRoomBroadCastLayoutHandler = new GlobalRoomBroadCastLayoutHandler(this);
    }

    private final float judgeTime(int view) {
        Dimens dimens = Dimens.INSTANCE;
        return (6000 * (view + dimens.getScreenWidth())) / dimens.getScreenWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBroadCastView$lambda$1(final GlobalRoomBroadCastLayout globalRoomBroadCastLayout, final GlobalRoomBroadCastChildLayout globalRoomBroadCastChildLayout) {
        float screenWidth;
        float f;
        float judgeTime = globalRoomBroadCastLayout.judgeTime(globalRoomBroadCastChildLayout.getCurrentSize());
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        if (hiloUtils.getRightToLeftDirection()) {
            screenWidth = -globalRoomBroadCastChildLayout.getWidth();
        } else {
            screenWidth = Dimens.INSTANCE.getScreenWidth();
        }
        if (hiloUtils.getRightToLeftDirection()) {
            f = Dimens.INSTANCE.getScreenWidth();
        } else {
            f = -globalRoomBroadCastChildLayout.getWidth();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(globalRoomBroadCastChildLayout, (Property<GlobalRoomBroadCastChildLayout, Float>) View.TRANSLATION_X, screenWidth, f);
        ofFloat.setDuration(judgeTime);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.view.GlobalRoomBroadCastLayout$showBroadCastView$1$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                globalRoomBroadCastLayout.animator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ArrayList arrayList;
                GlobalRoomBroadCastLayoutHandler globalRoomBroadCastLayoutHandler;
                Intrinsics.checkNotNullParameter(animation, "animation");
                globalRoomBroadCastLayout.removeAllViews();
                arrayList = globalRoomBroadCastLayout.mTextBroadCastList;
                if (!arrayList.isEmpty()) {
                    globalRoomBroadCastLayoutHandler = globalRoomBroadCastLayout.mGlobalRoomBroadCastLayoutHandler;
                    if (globalRoomBroadCastLayoutHandler != null) {
                        globalRoomBroadCastLayoutHandler.sendEmptyMessage(1);
                    }
                } else {
                    globalRoomBroadCastLayout.setVisibility(8);
                }
                globalRoomBroadCastLayout.animator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                GlobalRoomBroadCastChildLayout.this.setVisibility(0);
            }
        });
        globalRoomBroadCastLayout.animator = ofFloat;
        ofFloat.start();
    }

    public final void hasNewBroadcast(@NotNull SocketGlobalBroadCastBean socketGlobalBroadCastBean) {
        Intrinsics.checkNotNullParameter(socketGlobalBroadCastBean, "socketGlobalBroadCastBean");
        this.mTextBroadCastList.add(socketGlobalBroadCastBean);
        if (getVisibility() != 0) {
            setVisibility(0);
            GlobalRoomBroadCastLayoutHandler globalRoomBroadCastLayoutHandler = this.mGlobalRoomBroadCastLayoutHandler;
            if (globalRoomBroadCastLayoutHandler != null) {
                globalRoomBroadCastLayoutHandler.sendEmptyMessage(1);
            }
        }
    }

    public final void release() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.animator = null;
        removeAllViews();
        GlobalRoomBroadCastLayoutHandler globalRoomBroadCastLayoutHandler = this.mGlobalRoomBroadCastLayoutHandler;
        if (globalRoomBroadCastLayoutHandler != null) {
            globalRoomBroadCastLayoutHandler.removeCallbacksAndMessages(null);
        }
    }

    public final void showBroadCastView() {
        if (this.mTextBroadCastList.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SocketGlobalBroadCastBean remove = this.mTextBroadCastList.remove(0);
        Intrinsics.checkNotNullExpressionValue(remove, "removeAt(...)");
        final GlobalRoomBroadCastChildLayout globalRoomBroadCastChildLayout = new GlobalRoomBroadCastChildLayout(context, remove);
        globalRoomBroadCastChildLayout.post(new Runnable() { // from class: com.qiahao.nextvideo.room.view.e
            @Override // java.lang.Runnable
            public final void run() {
                GlobalRoomBroadCastLayout.showBroadCastView$lambda$1(GlobalRoomBroadCastLayout.this, globalRoomBroadCastChildLayout);
            }
        });
        globalRoomBroadCastChildLayout.setVisibility(4);
        addView(globalRoomBroadCastChildLayout);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalRoomBroadCastLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTextBroadCastList = new ArrayList<>();
        initView();
    }
}
