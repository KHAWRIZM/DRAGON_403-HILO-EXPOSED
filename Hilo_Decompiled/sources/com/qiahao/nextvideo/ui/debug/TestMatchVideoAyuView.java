package com.qiahao.nextvideo.ui.debug;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.qiahao.nextvideo.databinding.ViewControllerTestVideoCallingBinding;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.videocall.matchinguser.balloon.KeepCallTipsBalloon;
import com.qiahao.nextvideo.ui.videocall.matchinguser.balloon.KeepCallTipsPopupDelegate;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020\u001eR\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/ui/debug/TestMatchVideoAyuView;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsPopupDelegate;", "<init>", "()V", "freeAddTimeKeepCallTipsBalloon", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon;", "getFreeAddTimeKeepCallTipsBalloon", "()Lcom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloon;", "freeAddTimeKeepCallTipsBalloon$delegate", "Lkotlin/Lazy;", "giftAddTimeKeepCallTipsBalloon", "getGiftAddTimeKeepCallTipsBalloon", "giftAddTimeKeepCallTipsBalloon$delegate", "loveKeepCallTipsBalloon", "getLoveKeepCallTipsBalloon", "loveKeepCallTipsBalloon$delegate", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerTestVideoCallingBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerTestVideoCallingBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerTestVideoCallingBinding;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "viewDidLoad", "", "view", "keepCallTipsPopupDelegateDidOkay", "type", "", "setupKeepCallTipsBalloon", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTestMatchVideoAyuView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TestMatchVideoAyuView.kt\ncom/qiahao/nextvideo/ui/debug/TestMatchVideoAyuView\n+ 2 KeepCallTipsBalloon.kt\ncom/qiahao/nextvideo/ui/videocall/matchinguser/balloon/KeepCallTipsBalloonKt\n*L\n1#1,94:1\n30#2:95\n30#2:96\n30#2:97\n*S KotlinDebug\n*F\n+ 1 TestMatchVideoAyuView.kt\ncom/qiahao/nextvideo/ui/debug/TestMatchVideoAyuView\n*L\n22#1:95\n30#1:96\n38#1:97\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TestMatchVideoAyuView extends BaseViewController implements KeepCallTipsPopupDelegate {
    public ViewControllerTestVideoCallingBinding binding;

    /* renamed from: freeAddTimeKeepCallTipsBalloon$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy freeAddTimeKeepCallTipsBalloon = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.debug.d
        public final Object invoke() {
            KeepCallTipsBalloon freeAddTimeKeepCallTipsBalloon_delegate$lambda$1;
            freeAddTimeKeepCallTipsBalloon_delegate$lambda$1 = TestMatchVideoAyuView.freeAddTimeKeepCallTipsBalloon_delegate$lambda$1(TestMatchVideoAyuView.this);
            return freeAddTimeKeepCallTipsBalloon_delegate$lambda$1;
        }
    });

    /* renamed from: giftAddTimeKeepCallTipsBalloon$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy giftAddTimeKeepCallTipsBalloon = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.debug.e
        public final Object invoke() {
            KeepCallTipsBalloon giftAddTimeKeepCallTipsBalloon_delegate$lambda$3;
            giftAddTimeKeepCallTipsBalloon_delegate$lambda$3 = TestMatchVideoAyuView.giftAddTimeKeepCallTipsBalloon_delegate$lambda$3(TestMatchVideoAyuView.this);
            return giftAddTimeKeepCallTipsBalloon_delegate$lambda$3;
        }
    });

    /* renamed from: loveKeepCallTipsBalloon$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy loveKeepCallTipsBalloon = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.debug.f
        public final Object invoke() {
            KeepCallTipsBalloon loveKeepCallTipsBalloon_delegate$lambda$5;
            loveKeepCallTipsBalloon_delegate$lambda$5 = TestMatchVideoAyuView.loveKeepCallTipsBalloon_delegate$lambda$5(TestMatchVideoAyuView.this);
            return loveKeepCallTipsBalloon_delegate$lambda$5;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeepCallTipsBalloon freeAddTimeKeepCallTipsBalloon_delegate$lambda$1(TestMatchVideoAyuView testMatchVideoAyuView) {
        KeepCallTipsBalloon.Builder builder = new KeepCallTipsBalloon.Builder(testMatchVideoAyuView.getRequireContext());
        builder.setAnchorView(testMatchVideoAyuView.getBinding().addTimeImageView);
        builder.setContent(testMatchVideoAyuView.getRequireContext().getString(2131952265));
        builder.setKeepCallType(1);
        builder.setDelegate(testMatchVideoAyuView);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeepCallTipsBalloon giftAddTimeKeepCallTipsBalloon_delegate$lambda$3(TestMatchVideoAyuView testMatchVideoAyuView) {
        KeepCallTipsBalloon.Builder builder = new KeepCallTipsBalloon.Builder(testMatchVideoAyuView.getRequireContext());
        builder.setAnchorView(testMatchVideoAyuView.getBinding().giftsPanelImageView);
        builder.setContent(testMatchVideoAyuView.getRequireContext().getString(2131952266));
        builder.setKeepCallType(2);
        builder.setDelegate(testMatchVideoAyuView);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KeepCallTipsBalloon loveKeepCallTipsBalloon_delegate$lambda$5(TestMatchVideoAyuView testMatchVideoAyuView) {
        KeepCallTipsBalloon.Builder builder = new KeepCallTipsBalloon.Builder(testMatchVideoAyuView.getRequireContext());
        builder.setAnchorView(testMatchVideoAyuView.getBinding().loveImageView);
        builder.setContent(testMatchVideoAyuView.getRequireContext().getString(2131952267));
        builder.setKeepCallType(3);
        builder.setDelegate(testMatchVideoAyuView);
        return builder.build();
    }

    @NotNull
    public final ViewControllerTestVideoCallingBinding getBinding() {
        ViewControllerTestVideoCallingBinding viewControllerTestVideoCallingBinding = this.binding;
        if (viewControllerTestVideoCallingBinding != null) {
            return viewControllerTestVideoCallingBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final KeepCallTipsBalloon getFreeAddTimeKeepCallTipsBalloon() {
        return (KeepCallTipsBalloon) this.freeAddTimeKeepCallTipsBalloon.getValue();
    }

    @NotNull
    public final KeepCallTipsBalloon getGiftAddTimeKeepCallTipsBalloon() {
        return (KeepCallTipsBalloon) this.giftAddTimeKeepCallTipsBalloon.getValue();
    }

    @NotNull
    public final KeepCallTipsBalloon getLoveKeepCallTipsBalloon() {
        return (KeepCallTipsBalloon) this.loveKeepCallTipsBalloon.getValue();
    }

    @Override // com.qiahao.nextvideo.ui.videocall.matchinguser.balloon.KeepCallTipsPopupDelegate
    public void keepCallTipsPopupDelegateDidOkay(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type == 3) {
                    KeepCallTipsBalloon.dismiss$default(getLoveKeepCallTipsBalloon(), null, 1, null);
                    return;
                }
                return;
            } else {
                KeepCallTipsBalloon.dismiss$default(getGiftAddTimeKeepCallTipsBalloon(), null, 1, null);
                getLoveKeepCallTipsBalloon().show();
                return;
            }
        }
        KeepCallTipsBalloon.dismiss$default(getFreeAddTimeKeepCallTipsBalloon(), null, 1, null);
        getGiftAddTimeKeepCallTipsBalloon().show();
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerTestVideoCallingBinding inflate = ViewControllerTestVideoCallingBinding.inflate(inflater, container, false);
        setBinding(inflate);
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setBinding(@NotNull ViewControllerTestVideoCallingBinding viewControllerTestVideoCallingBinding) {
        Intrinsics.checkNotNullParameter(viewControllerTestVideoCallingBinding, "<set-?>");
        this.binding = viewControllerTestVideoCallingBinding;
    }

    public final void setupKeepCallTipsBalloon() {
        getBinding().addTimeImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.qiahao.nextvideo.ui.debug.TestMatchVideoAyuView$setupKeepCallTipsBalloon$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                KeepCallTipsBalloon.Companion companion = KeepCallTipsBalloon.INSTANCE;
                if (!companion.hasPrompted(KeepCallTipsBalloon.keyOfFreeMMKV)) {
                    TestMatchVideoAyuView.this.getFreeAddTimeKeepCallTipsBalloon().show();
                } else if (!companion.hasPrompted(KeepCallTipsBalloon.keyOfGiftMMKV)) {
                    TestMatchVideoAyuView.this.getGiftAddTimeKeepCallTipsBalloon().show();
                } else if (!companion.hasPrompted(KeepCallTipsBalloon.keyOfLoveMMKV)) {
                    TestMatchVideoAyuView.this.getLoveKeepCallTipsBalloon().show();
                }
                TestMatchVideoAyuView.this.getBinding().addTimeImageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        KeepCallTipsBalloon.Companion companion = KeepCallTipsBalloon.INSTANCE;
        companion.unMarkHasPrompted(KeepCallTipsBalloon.keyOfFreeMMKV);
        companion.unMarkHasPrompted(KeepCallTipsBalloon.keyOfGiftMMKV);
        companion.unMarkHasPrompted(KeepCallTipsBalloon.keyOfLoveMMKV);
        setupKeepCallTipsBalloon();
    }
}
