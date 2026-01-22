package com.qiahao.nextvideo.ui.home.discover;

import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.nextvideo.ui.home.discover.viewModel.ActivitiesDetailViewModel;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qiahao/nextvideo/ui/home/discover/ActivitiesDetailActivity$showReport$1$1$1", "Lcom/qiahao/base_common/interfaceing/SelectInterface;", "onSelect", "", "index", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesDetailActivity$showReport$1$1$1 implements SelectInterface {
    final /* synthetic */ ActivitiesDetailActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivitiesDetailActivity$showReport$1$1$1(ActivitiesDetailActivity activitiesDetailActivity) {
        this.this$0 = activitiesDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelect$lambda$0(ActivitiesDetailActivity activitiesDetailActivity, boolean z, Integer num) {
        ActivitiesDetailViewModel viewModel;
        if (z) {
            viewModel = activitiesDetailActivity.getViewModel();
            viewModel.changeRecommendState();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity, android.app.Activity] */
    public void onSelect(int index) {
        ActivitiesDetailViewModel viewModel;
        String str;
        ActivitiesDetailViewModel viewModel2;
        int i;
        if (index == 0) {
            this.this$0.reportGroup();
            return;
        }
        if (index != 4) {
            if (index != 8) {
                if (index == 102) {
                    AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                    ?? r2 = this.this$0;
                    viewModel = r2.getViewModel();
                    ActivityDetailData activityDetailData = (ActivityDetailData) viewModel.getActivityDetail().getValue();
                    if (activityDetailData == null || (str = activityDetailData.getGroupId()) == null) {
                        str = "";
                    }
                    String str2 = str;
                    viewModel2 = this.this$0.getViewModel();
                    ActivityDetailData activityDetailData2 = (ActivityDetailData) viewModel2.getActivityDetail().getValue();
                    if (activityDetailData2 != null) {
                        i = activityDetailData2.getNotRecommend();
                    } else {
                        i = 0;
                    }
                    final ActivitiesDetailActivity activitiesDetailActivity = this.this$0;
                    AppRequestUtils.notRecommendRoom$default(appRequestUtils, r2, 3, str2, i, new Function2() { // from class: com.qiahao.nextvideo.ui.home.discover.r
                        public final Object invoke(Object obj, Object obj2) {
                            Unit onSelect$lambda$0;
                            onSelect$lambda$0 = ActivitiesDetailActivity$showReport$1$1$1.onSelect$lambda$0(ActivitiesDetailActivity.this, ((Boolean) obj).booleanValue(), (Integer) obj2);
                            return onSelect$lambda$0;
                        }
                    }, false, 32, null);
                    return;
                }
                return;
            }
            TipDialog tipContent = new TipDialog(this.this$0).setTipContent(ResourcesKtxKt.getStringById(this, 2131953921));
            final ActivitiesDetailActivity activitiesDetailActivity2 = this.this$0;
            tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity$showReport$1$1$1$onSelect$2
                public void cancel() {
                    OnCommonDialogListener.DefaultImpls.cancel(this);
                }

                public void confirm() {
                    ActivitiesDetailViewModel viewModel3;
                    ActivitiesDetailViewModel viewModel4;
                    viewModel3 = ActivitiesDetailActivity.this.getViewModel();
                    viewModel4 = ActivitiesDetailActivity.this.getViewModel();
                    viewModel3.resetActivity(viewModel4.getActivityId());
                }
            }).show();
            return;
        }
        TipDialog confirmContent = new TipDialog(this.this$0).setTipContent(ResourcesKtxKt.getStringById(this, 2131952335)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952536));
        final ActivitiesDetailActivity activitiesDetailActivity3 = this.this$0;
        confirmContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity$showReport$1$1$1$onSelect$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                ActivitiesDetailActivity.this.deleteActivity();
            }
        }).show();
    }
}
