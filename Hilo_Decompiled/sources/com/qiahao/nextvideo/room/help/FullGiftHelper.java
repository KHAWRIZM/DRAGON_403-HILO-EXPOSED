package com.qiahao.nextvideo.room.help;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.view.RoomAllGiftView;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/room/help/FullGiftHelper;", "", "frameLayout", "Landroid/widget/FrameLayout;", "<init>", "(Landroid/widget/FrameLayout;)V", "getFrameLayout", "()Landroid/widget/FrameLayout;", "giftView", "Lcom/qiahao/nextvideo/view/RoomAllGiftView;", "getGiftView", "()Lcom/qiahao/nextvideo/view/RoomAllGiftView;", "setGiftView", "(Lcom/qiahao/nextvideo/view/RoomAllGiftView;)V", "startAllGift", "", "bitmap", "Landroid/graphics/Bitmap;", "lifecycleScope", "Landroidx/lifecycle/LifecycleOwner;", "isPlayAnimation", "", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FullGiftHelper {

    @Nullable
    private final FrameLayout frameLayout;

    @Nullable
    private RoomAllGiftView giftView;

    public FullGiftHelper(@Nullable FrameLayout frameLayout) {
        this.frameLayout = frameLayout;
    }

    public static /* synthetic */ void startAllGift$default(FullGiftHelper fullGiftHelper, Bitmap bitmap, LifecycleOwner lifecycleOwner, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = null;
        }
        fullGiftHelper.startAllGift(bitmap, lifecycleOwner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAllGift$lambda$4(final FullGiftHelper fullGiftHelper, LifecycleOwner lifecycleOwner, final Bitmap bitmap) {
        Context context;
        if (fullGiftHelper.giftView == null) {
            FrameLayout frameLayout = fullGiftHelper.frameLayout;
            if (frameLayout != null) {
                context = frameLayout.getContext();
            } else {
                context = null;
            }
            RoomAllGiftView roomAllGiftView = new RoomAllGiftView(context);
            roomAllGiftView.bindToLifecycle(lifecycleOwner);
            roomAllGiftView.setMListener(new Function0() { // from class: com.qiahao.nextvideo.room.help.a5
                public final Object invoke() {
                    Unit startAllGift$lambda$4$lambda$2$lambda$1;
                    startAllGift$lambda$4$lambda$2$lambda$1 = FullGiftHelper.startAllGift$lambda$4$lambda$2$lambda$1(FullGiftHelper.this);
                    return startAllGift$lambda$4$lambda$2$lambda$1;
                }
            });
            fullGiftHelper.giftView = roomAllGiftView;
            FrameLayout frameLayout2 = fullGiftHelper.frameLayout;
            if (frameLayout2 != null) {
                frameLayout2.addView(roomAllGiftView, -1, -1);
            }
        }
        RoomAllGiftView roomAllGiftView2 = fullGiftHelper.giftView;
        if (roomAllGiftView2 != null) {
            roomAllGiftView2.post(new Runnable() { // from class: com.qiahao.nextvideo.room.help.b5
                @Override // java.lang.Runnable
                public final void run() {
                    FullGiftHelper.startAllGift$lambda$4$lambda$3(FullGiftHelper.this, bitmap);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startAllGift$lambda$4$lambda$2$lambda$1(final FullGiftHelper fullGiftHelper) {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.c5
            @Override // java.lang.Runnable
            public final void run() {
                FullGiftHelper.startAllGift$lambda$4$lambda$2$lambda$1$lambda$0(FullGiftHelper.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAllGift$lambda$4$lambda$2$lambda$1$lambda$0(FullGiftHelper fullGiftHelper) {
        FrameLayout frameLayout = fullGiftHelper.frameLayout;
        if (frameLayout != null) {
            frameLayout.removeView(fullGiftHelper.giftView);
        }
        fullGiftHelper.giftView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAllGift$lambda$4$lambda$3(FullGiftHelper fullGiftHelper, Bitmap bitmap) {
        RoomAllGiftView roomAllGiftView = fullGiftHelper.giftView;
        if (roomAllGiftView != null) {
            roomAllGiftView.startAllGift(bitmap);
        }
    }

    public final void destroy() {
        FrameLayout frameLayout = this.frameLayout;
        if (frameLayout != null) {
            frameLayout.removeView(this.giftView);
        }
        RoomAllGiftView roomAllGiftView = this.giftView;
        if (roomAllGiftView != null) {
            roomAllGiftView.destroy();
        }
        this.giftView = null;
    }

    @Nullable
    public final FrameLayout getFrameLayout() {
        return this.frameLayout;
    }

    @Nullable
    public final RoomAllGiftView getGiftView() {
        return this.giftView;
    }

    public final boolean isPlayAnimation() {
        RoomAllGiftView roomAllGiftView = this.giftView;
        if (roomAllGiftView != null) {
            return roomAllGiftView.isPlayAnimation();
        }
        return false;
    }

    public final void setGiftView(@Nullable RoomAllGiftView roomAllGiftView) {
        this.giftView = roomAllGiftView;
    }

    public final void startAllGift(@Nullable final Bitmap bitmap, @NotNull final LifecycleOwner lifecycleScope) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.z4
            @Override // java.lang.Runnable
            public final void run() {
                FullGiftHelper.startAllGift$lambda$4(FullGiftHelper.this, lifecycleScope, bitmap);
            }
        });
    }
}
