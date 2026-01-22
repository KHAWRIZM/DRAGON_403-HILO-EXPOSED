package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportWhiteDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.IsBroadCastMangerBean;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.ui.base.BlockTextDialog;
import com.qiahao.nextvideo.ui.profile.SvipUnBlockDialog;
import com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/OtherUserActivity$reportImageViewPressed$1$2$1", "Lcom/qiahao/base_common/interfaceing/SelectInterface;", "onSelect", "", "index", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherUserActivity$reportImageViewPressed$1$2$1 implements SelectInterface {
    final /* synthetic */ ApiResponse<IsBroadCastMangerBean> $data;
    final /* synthetic */ BlockOrReportDialog $this_apply;
    final /* synthetic */ OtherUserActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OtherUserActivity$reportImageViewPressed$1$2$1(OtherUserActivity otherUserActivity, BlockOrReportDialog blockOrReportDialog, ApiResponse<IsBroadCastMangerBean> apiResponse) {
        this.this$0 = otherUserActivity;
        this.$this_apply = blockOrReportDialog;
        this.$data = apiResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelect$lambda$4(OtherUserActivity otherUserActivity, boolean z, Integer num) {
        User uiModel;
        if (z && (uiModel = otherUserActivity.getUiModel()) != null) {
            User uiModel2 = otherUserActivity.getUiModel();
            int i = 0;
            if (uiModel2 != null && uiModel2.getNotRecommend() == 0) {
                i = 1;
            }
            uiModel.setNotRecommend(i);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity, com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity, android.app.Activity] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.app.Dialog, com.qiahao.nextvideo.ui.base.BlockTextDialog] */
    public void onSelect(int index) {
        SvipData svip;
        int i;
        SvipData svip2;
        long j;
        String str;
        int i2;
        if (index != 0) {
            if (index != 1) {
                if (index != 2) {
                    if (index != 3) {
                        String str2 = null;
                        if (index != 5) {
                            int i3 = 0;
                            if (index != 6) {
                                if (index != 7) {
                                    if (index == 101) {
                                        AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                                        ?? r10 = this.this$0;
                                        User uiModel = r10.getUiModel();
                                        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
                                            str = "";
                                        }
                                        String str3 = str;
                                        User uiModel2 = this.this$0.getUiModel();
                                        if (uiModel2 != null) {
                                            i2 = uiModel2.getNotRecommend();
                                        } else {
                                            i2 = 0;
                                        }
                                        final OtherUserActivity otherUserActivity = this.this$0;
                                        AppRequestUtils.notRecommendRoom$default(appRequestUtils, r10, 1, str3, i2, new Function2() { // from class: com.qiahao.nextvideo.ui.profile.activity.h0
                                            public final Object invoke(Object obj, Object obj2) {
                                                Unit onSelect$lambda$4;
                                                onSelect$lambda$4 = OtherUserActivity$reportImageViewPressed$1$2$1.onSelect$lambda$4(OtherUserActivity.this, ((Boolean) obj).booleanValue(), (Integer) obj2);
                                                return onSelect$lambda$4;
                                            }
                                        }, false, 32, null);
                                        return;
                                    }
                                    return;
                                }
                                User user = UserStore.INSTANCE.getShared().getUser();
                                if (user != null && (svip2 = user.getSvip()) != null && svip2.checkPrivilege(29)) {
                                    User uiModel3 = this.this$0.getUiModel();
                                    if (uiModel3 != null) {
                                        j = uiModel3.getWealthUserGrade();
                                    } else {
                                        j = 0;
                                    }
                                    if (j >= 5) {
                                        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.this$0, ResourcesKtxKt.getStringById(this, 2131954190), false, 4, (Object) null);
                                        if (normal$default != null) {
                                            normal$default.show();
                                            return;
                                        }
                                        return;
                                    }
                                    Intent intent = new Intent((Context) this.this$0, (Class<?>) SuperAdminReportActivity.class);
                                    User uiModel4 = this.this$0.getUiModel();
                                    if (uiModel4 != null) {
                                        str2 = uiModel4.getExternalId();
                                    }
                                    intent.putExtra(SuperAdminReportActivity.USER_EXTERNAL_ID, str2);
                                    intent.putExtra(SuperAdminReportActivity.REPORT_TYPE, SuperAdminReportActivity.REPORT_TYPE_SVIP9);
                                    this.this$0.startActivity(intent);
                                    return;
                                }
                                this.this$0.svipPrivileges(29);
                                return;
                            }
                            User user2 = UserStore.INSTANCE.getShared().getUser();
                            if (user2 != null && (svip = user2.getSvip()) != null && svip.checkPrivilege(27)) {
                                BaseActivity baseActivity = this.this$0;
                                IsBroadCastMangerBean isBroadCastMangerBean = (IsBroadCastMangerBean) this.$data.getData();
                                if (isBroadCastMangerBean != null) {
                                    i = isBroadCastMangerBean.getDayUnLockTimes();
                                } else {
                                    i = 0;
                                }
                                IsBroadCastMangerBean isBroadCastMangerBean2 = (IsBroadCastMangerBean) this.$data.getData();
                                if (isBroadCastMangerBean2 != null) {
                                    i3 = isBroadCastMangerBean2.getMonthUnLockTimes();
                                }
                                SvipUnBlockDialog svipUnBlockDialog = new SvipUnBlockDialog(baseActivity, i, i3);
                                final OtherUserActivity otherUserActivity2 = this.this$0;
                                svipUnBlockDialog.setListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$5$1
                                    public void cancel() {
                                        OnCommonDialogListener.DefaultImpls.cancel(this);
                                    }

                                    public void confirm() {
                                        OtherUserActivity.this.svipUnBlock();
                                    }
                                });
                                svipUnBlockDialog.show();
                                return;
                            }
                            this.this$0.svipPrivileges(27);
                            return;
                        }
                        Intent intent2 = new Intent((Context) this.this$0, (Class<?>) SuperAdminReportActivity.class);
                        User uiModel5 = this.this$0.getUiModel();
                        if (uiModel5 != null) {
                            str2 = uiModel5.getExternalId();
                        }
                        intent2.putExtra(SuperAdminReportActivity.USER_EXTERNAL_ID, str2);
                        intent2.putExtra(SuperAdminReportActivity.REPORT_TYPE, SuperAdminReportActivity.REPORT_TYPE_SUPER);
                        this.this$0.startActivity(intent2);
                        return;
                    }
                    Context context = this.$this_apply.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131952344)).setDialogListener(new OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$4(this.this$0)).show();
                    return;
                }
                Context context2 = this.$this_apply.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                new TipDialog(context2).setTipContent(ResourcesKtxKt.getStringById(this, 2131952344)).setDialogListener(new OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3(this.this$0, this.$this_apply)).show();
                return;
            }
            ?? blockTextDialog = new BlockTextDialog(this.this$0);
            OtherUserActivity otherUserActivity3 = this.this$0;
            String string = blockTextDialog.getMContext().getString(2131952131);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            blockTextDialog.setContentText(string, true, new OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1(otherUserActivity3, blockTextDialog));
            blockTextDialog.show();
            return;
        }
        new ReportWhiteDialog(this.this$0).setListener(new OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1(this.this$0, this.$this_apply)).show();
    }
}
