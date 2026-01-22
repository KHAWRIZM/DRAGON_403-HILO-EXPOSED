package com.qiahao.nextvideo.ui.svip;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivitySvipRulesBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipRulesActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySvipRulesBinding;", "<init>", "()V", "getLayoutResId", "", "onInitialize", "", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipRulesActivity extends HiloBaseBindingActivity<ActivitySvipRulesBinding> {
    private final void initView() {
        getBinding().titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131954205));
        View view = getBinding().titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.svip.h0
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = SvipRulesActivity.initView$lambda$0(SvipRulesActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        getBinding().titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SvipRulesActivity.this.onBackPressed();
            }
        });
        getBinding().rulesOne.title.setText(ResourcesKtxKt.getStringById(this, 2131954209));
        getBinding().rulesOne.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131954208));
        getBinding().rulesTwo.title.setText(ResourcesKtxKt.getStringById(this, 2131954213));
        getBinding().rulesTwo.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131954212));
        getBinding().rulesThree.title.setText(ResourcesKtxKt.getStringById(this, 2131954211));
        getBinding().rulesThree.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131954210));
        getBinding().rulesFour.title.setText(ResourcesKtxKt.getStringById(this, 2131954207));
        getBinding().rulesFour.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131954206));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(SvipRulesActivity svipRulesActivity, int i, int i2) {
        svipRulesActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_svip_rules;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }
}
