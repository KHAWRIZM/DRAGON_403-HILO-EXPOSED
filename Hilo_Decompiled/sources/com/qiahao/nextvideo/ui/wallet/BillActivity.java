package com.qiahao.nextvideo.ui.wallet;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityBillBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/BillActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityBillBinding;", "<init>", "()V", "getLayoutResId", "", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBillActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BillActivity.kt\ncom/qiahao/nextvideo/ui/wallet/BillActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,59:1\n61#2,9:60\n61#2,9:69\n61#2,9:78\n61#2,9:87\n61#2,9:96\n*S KotlinDebug\n*F\n+ 1 BillActivity.kt\ncom/qiahao/nextvideo/ui/wallet/BillActivity\n*L\n42#1:60,9\n45#1:69,9\n48#1:78,9\n51#1:87,9\n54#1:96,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BillActivity extends HiloBaseBindingActivity<ActivityBillBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/BillActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) BillActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$0(BillActivity billActivity, int i, int i2) {
        billActivity.getBinding().titleLayout.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_bill;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = ((ActivityBillBinding) getBinding()).titleLayout.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.wallet.a
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$0;
                onInitialize$lambda$0 = BillActivity.onInitialize$lambda$0(BillActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$0;
            }
        });
        ((ActivityBillBinding) getBinding()).titleLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131952114));
        ((ActivityBillBinding) getBinding()).titleLayout.linearLayout.setBackgroundColor(androidx.core.content.a.getColor(this, 2131101214));
        final AppCompatImageView appCompatImageView = ((ActivityBillBinding) getBinding()).titleLayout.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.BillActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final View root = ((ActivityBillBinding) getBinding()).diamond.getRoot();
        root.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.BillActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                    ExchangeDetailActivity.Companion.start(this, ExchangeDetailActivity.TYPE_DIAMOND);
                }
            }
        });
        final View root2 = ((ActivityBillBinding) getBinding()).beans.getRoot();
        root2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.BillActivity$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root2) > j || (root2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root2, currentTimeMillis);
                    ExchangeDetailActivity.Companion.start(this, ExchangeDetailActivity.TYPE_BEANS);
                }
            }
        });
        final View root3 = ((ActivityBillBinding) getBinding()).coins.getRoot();
        root3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.BillActivity$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root3) > j || (root3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root3, currentTimeMillis);
                    ExchangeDetailActivity.Companion.start(this, ExchangeDetailActivity.TYPE_COINS);
                }
            }
        });
        final View root4 = ((ActivityBillBinding) getBinding()).recharge.getRoot();
        root4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.BillActivity$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(root4) > j || (root4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(root4, currentTimeMillis);
                    ExchangeDetailActivity.Companion.start(this, ExchangeDetailActivity.TYPE_RECHARGE);
                }
            }
        });
    }
}
