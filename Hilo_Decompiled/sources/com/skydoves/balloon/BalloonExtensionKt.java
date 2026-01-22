package com.skydoves.balloon;

import android.view.View;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0081\bø\u0001\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0006\u001a\"\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0006\u001a\"\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0006\u001a\"\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0006\u001a\"\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0006\u001a\"\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0006\u001a\"\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"balloon", "", "Landroid/view/View;", MessageMenuDialog.BLOCK, "Lkotlin/Function0;", "showAlignBottom", "Lcom/skydoves/balloon/Balloon;", "xOff", "", "yOff", "showAlignLeft", "showAlignRight", "showAlignTop", "showAsDropDown", "showBalloon", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class BalloonExtensionKt {
    public static final /* synthetic */ void balloon(View view, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "$this$balloon");
        Intrinsics.checkNotNullParameter(function0, MessageMenuDialog.BLOCK);
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$balloon$1
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }

    public static final void showAlignBottom(@NotNull final View view, @NotNull final Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignBottom");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignBottom$$inlined$balloon$1
            @Override // java.lang.Runnable
            public final void run() {
                Balloon.showAlignBottom$default(balloon, view, 0, 0, 6, null);
            }
        });
    }

    public static final void showAlignLeft(@NotNull final View view, @NotNull final Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignLeft");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignLeft$$inlined$balloon$1
            @Override // java.lang.Runnable
            public final void run() {
                Balloon.showAlignLeft$default(balloon, view, 0, 0, 6, null);
            }
        });
    }

    public static final void showAlignRight(@NotNull final View view, @NotNull final Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignRight");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignRight$$inlined$balloon$1
            @Override // java.lang.Runnable
            public final void run() {
                Balloon.showAlignRight$default(balloon, view, 0, 0, 6, null);
            }
        });
    }

    public static final void showAlignTop(@NotNull final View view, @NotNull final Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignTop");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignTop$$inlined$balloon$1
            @Override // java.lang.Runnable
            public final void run() {
                Balloon.showAlignTop$default(balloon, view, 0, 0, 6, null);
            }
        });
    }

    public static final void showAsDropDown(@NotNull final View view, @NotNull final Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "$this$showAsDropDown");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAsDropDown$$inlined$balloon$1
            @Override // java.lang.Runnable
            public final void run() {
                Balloon.showAsDropDown$default(balloon, view, 0, 0, 6, null);
            }
        });
    }

    public static final void showBalloon(@NotNull final View view, @NotNull final Balloon balloon) {
        Intrinsics.checkNotNullParameter(view, "$this$showBalloon");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showBalloon$$inlined$balloon$1
            @Override // java.lang.Runnable
            public final void run() {
                balloon.show(view);
            }
        });
    }

    public static final void showAlignBottom(@NotNull final View view, @NotNull final Balloon balloon, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignBottom");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignBottom$$inlined$balloon$2
            @Override // java.lang.Runnable
            public final void run() {
                balloon.showAlignBottom(view, i, i2);
            }
        });
    }

    public static final void showAlignLeft(@NotNull final View view, @NotNull final Balloon balloon, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignLeft");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignLeft$$inlined$balloon$2
            @Override // java.lang.Runnable
            public final void run() {
                balloon.showAlignLeft(view, i, i2);
            }
        });
    }

    public static final void showAlignRight(@NotNull final View view, @NotNull final Balloon balloon, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignRight");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignRight$$inlined$balloon$2
            @Override // java.lang.Runnable
            public final void run() {
                balloon.showAlignRight(view, i, i2);
            }
        });
    }

    public static final void showAlignTop(@NotNull final View view, @NotNull final Balloon balloon, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$showAlignTop");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAlignTop$$inlined$balloon$2
            @Override // java.lang.Runnable
            public final void run() {
                balloon.showAlignTop(view, i, i2);
            }
        });
    }

    public static final void showAsDropDown(@NotNull final View view, @NotNull final Balloon balloon, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$showAsDropDown");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showAsDropDown$$inlined$balloon$2
            @Override // java.lang.Runnable
            public final void run() {
                balloon.showAsDropDown(view, i, i2);
            }
        });
    }

    public static final void showBalloon(@NotNull final View view, @NotNull final Balloon balloon, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$showBalloon");
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        view.post(new Runnable() { // from class: com.skydoves.balloon.BalloonExtensionKt$showBalloon$$inlined$balloon$2
            @Override // java.lang.Runnable
            public final void run() {
                balloon.show(view, i, i2);
            }
        });
    }
}
