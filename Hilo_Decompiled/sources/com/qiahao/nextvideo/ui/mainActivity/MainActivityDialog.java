package com.qiahao.nextvideo.ui.mainActivity;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.mainActivity.MainActivityData;
import com.qiahao.nextvideo.data.mainActivity.MainActivityItem;
import com.qiahao.nextvideo.databinding.DialogMainActivityBinding;
import com.qiahao.nextvideo.utilities.google.pay.WalletPay;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/mainActivity/MainActivityDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogMainActivityBinding;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;)V", "getData", "()Lcom/qiahao/nextvideo/data/mainActivity/MainActivityData;", "mActivityAdapter", "Lcom/qiahao/nextvideo/ui/mainActivity/MainActivityAdapter;", "getMActivityAdapter", "()Lcom/qiahao/nextvideo/ui/mainActivity/MainActivityAdapter;", "mActivityAdapter$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "isNeedFullScreen", "", "initBanner", "dismiss", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainActivityDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivityDialog.kt\ncom/qiahao/nextvideo/ui/mainActivity/MainActivityDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,83:1\n61#2,9:84\n61#2,9:93\n61#2,9:102\n1878#3,3:111\n*S KotlinDebug\n*F\n+ 1 MainActivityDialog.kt\ncom/qiahao/nextvideo/ui/mainActivity/MainActivityDialog\n*L\n41#1:84,9\n45#1:93,9\n48#1:102,9\n67#1:111,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MainActivityDialog extends BaseBindingDialog<DialogMainActivityBinding> {

    @NotNull
    private final MainActivityData data;

    /* renamed from: mActivityAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mActivityAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityDialog(@NotNull Context context, @NotNull MainActivityData mainActivityData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainActivityData, "data");
        this.data = mainActivityData;
        this.mActivityAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.mainActivity.b
            public final Object invoke() {
                MainActivityAdapter mActivityAdapter_delegate$lambda$1;
                mActivityAdapter_delegate$lambda$1 = MainActivityDialog.mActivityAdapter_delegate$lambda$1(MainActivityDialog.this);
                return mActivityAdapter_delegate$lambda$1;
            }
        });
    }

    private final MainActivityAdapter getMActivityAdapter() {
        return (MainActivityAdapter) this.mActivityAdapter.getValue();
    }

    private final void initBanner() {
        ((DialogMainActivityBinding) getBinding()).bannerView.X(2).a0(UiKtxKt.toPX(25)).W(UiKtxKt.toPX(20)).G(getMActivityAdapter()).I(false).H(false).Z(HiloUtils.INSTANCE.getRightToLeftDirection()).R(8).h(this.data.getList());
        ((DialogMainActivityBinding) getBinding()).bannerView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.mainActivity.a
            @Override // java.lang.Runnable
            public final void run() {
                MainActivityDialog.initBanner$lambda$7(MainActivityDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBanner$lambda$7(MainActivityDialog mainActivityDialog) {
        List<MainActivityItem> list = mainActivityDialog.data.getList();
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                MainActivityItem mainActivityItem = (MainActivityItem) obj;
                if (Intrinsics.areEqual(mainActivityItem.getHasGetReward(), Boolean.FALSE) && Intrinsics.areEqual(mainActivityItem.isCanRecharge(), Boolean.TRUE)) {
                    ((DialogMainActivityBinding) mainActivityDialog.getBinding()).bannerView.J(i, false);
                    return;
                }
                i = i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MainActivityAdapter mActivityAdapter_delegate$lambda$1(MainActivityDialog mainActivityDialog) {
        MainActivityAdapter mainActivityAdapter = new MainActivityAdapter();
        mainActivityAdapter.setMBgUrl(mainActivityDialog.data.getBackgroundUrl());
        mainActivityAdapter.setMTime(mainActivityDialog.data.getDeadlineTimestamp());
        String activityTipText1 = mainActivityDialog.data.getActivityTipText1();
        String str = "";
        if (activityTipText1 == null) {
            activityTipText1 = "";
        }
        String activityTipText2 = mainActivityDialog.data.getActivityTipText2();
        if (activityTipText2 != null) {
            str = activityTipText2;
        }
        mainActivityAdapter.setMContent(activityTipText1 + "\n\n" + str);
        return mainActivityAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$3(MainActivityDialog mainActivityDialog, String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        mainActivityDialog.dismiss();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        getMActivityAdapter().release();
        WalletPay.INSTANCE.release();
        super.dismiss();
    }

    @NotNull
    public final MainActivityData getData() {
        return this.data;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_main_activity;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        final ImageView imageView = ((DialogMainActivityBinding) getBinding()).close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainActivityDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        WalletPay walletPay = WalletPay.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        walletPay.init(context, new Function1() { // from class: com.qiahao.nextvideo.ui.mainActivity.c
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$3;
                onInitialize$lambda$3 = MainActivityDialog.onInitialize$lambda$3(MainActivityDialog.this, (String) obj);
                return onInitialize$lambda$3;
            }
        });
        final FrameLayout frameLayout = ((DialogMainActivityBinding) getBinding()).frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainActivityDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final ConstraintLayout constraintLayout = ((DialogMainActivityBinding) getBinding()).constraint;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.mainActivity.MainActivityDialog$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                }
            }
        });
        initBanner();
    }
}
