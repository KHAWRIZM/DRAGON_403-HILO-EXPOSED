package com.qiahao.nextvideo.ui.gameLevel;

import android.view.View;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityGameLevelRulesBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/gameLevel/GameLevelRulesActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGameLevelRulesBinding;", "<init>", "()V", "getLayoutResId", "", "onInitialize", "", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameLevelRulesActivity extends HiloBaseBindingActivity<ActivityGameLevelRulesBinding> {
    private final void initView() {
        getBinding().titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131954205));
        View view = getBinding().titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.gameLevel.n
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = GameLevelRulesActivity.initView$lambda$0(GameLevelRulesActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        getBinding().titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gameLevel.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GameLevelRulesActivity.this.finish();
            }
        });
        getBinding().rulesOne.title.setText(ResourcesKtxKt.getStringById(this, 2131952846));
        getBinding().rulesOne.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131952841));
        getBinding().rulesTwo.title.setText(ResourcesKtxKt.getStringById(this, 2131952847));
        getBinding().rulesTwo.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131952842));
        getBinding().rulesThree.title.setText(ResourcesKtxKt.getStringById(this, 2131952848));
        getBinding().rulesThree.subTitle.setText(ResourcesKtxKt.getStringById(this, 2131952843));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(GameLevelRulesActivity gameLevelRulesActivity, int i, int i2) {
        gameLevelRulesActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_game_level_rules;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }
}
