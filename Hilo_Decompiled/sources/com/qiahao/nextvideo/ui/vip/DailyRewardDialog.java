package com.qiahao.nextvideo.ui.vip;

import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.SplashService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.databinding.DialogDailyVipDiamondBinding;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0018\u001a\u00020\bH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/vip/DailyRewardDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogDailyVipDiamondBinding;", "isVip", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "matchCardNum", "", "context", "Landroid/content/Context;", "<init>", "(ZJILandroid/content/Context;)V", "()Z", "setVip", "(Z)V", "getDiamond", "()J", "setDiamond", "(J)V", "getMatchCardNum", "()I", "setMatchCardNum", "(I)V", "getLayoutResId", "onInitialize", "", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DailyRewardDialog extends BaseBindingDialog<DialogDailyVipDiamondBinding> {
    private long diamond;
    private boolean isVip;
    private int matchCardNum;

    @NotNull
    private final RotateAnimation rotateAnimation;

    public /* synthetic */ DailyRewardDialog(boolean z, long j, int i, Context context, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0L : j, i, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$0(DailyRewardDialog dailyRewardDialog, View view) {
        SplashService.INSTANCE.getShared().getMOperationDialogPublishRelay().accept(Boolean.TRUE);
        dailyRewardDialog.dismiss();
    }

    public final long getDiamond() {
        return this.diamond;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_daily_vip_diamond;
    }

    public final int getMatchCardNum() {
        return this.matchCardNum;
    }

    /* renamed from: isVip, reason: from getter */
    public final boolean getIsVip() {
        return this.isVip;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        setCanceledOnTouchOutside(false);
        ((DialogDailyVipDiamondBinding) getBinding()).diamondText.setText("x" + this.diamond);
        ((DialogDailyVipDiamondBinding) getBinding()).matchTimesText.setText("x" + this.matchCardNum);
        ((DialogDailyVipDiamondBinding) getBinding()).contraint1.setVisibility(8);
        ((DialogDailyVipDiamondBinding) getBinding()).contraint2.setVisibility(8);
        if (this.matchCardNum > 0) {
            ((DialogDailyVipDiamondBinding) getBinding()).contraint1.setVisibility(0);
            ((DialogDailyVipDiamondBinding) getBinding()).light1.setAnimation(this.rotateAnimation);
            ((DialogDailyVipDiamondBinding) getBinding()).light1.getAnimation().startNow();
        }
        if (this.diamond > 0) {
            ((DialogDailyVipDiamondBinding) getBinding()).contraint2.setVisibility(0);
            ((DialogDailyVipDiamondBinding) getBinding()).light2.setAnimation(this.rotateAnimation);
            ((DialogDailyVipDiamondBinding) getBinding()).light2.getAnimation().startNow();
        }
        MatchingProvide.INSTANCE.getMatchConfigSendEvent();
        ((DialogDailyVipDiamondBinding) getBinding()).okButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.vip.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DailyRewardDialog.onInitialize$lambda$0(DailyRewardDialog.this, view);
            }
        });
    }

    public final void setDiamond(long j) {
        this.diamond = j;
    }

    public final void setMatchCardNum(int i) {
        this.matchCardNum = i;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyRewardDialog(boolean z, long j, int i, @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isVip = z;
        this.diamond = j;
        this.matchCardNum = i;
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(5000L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.rotateAnimation = rotateAnimation;
    }
}
