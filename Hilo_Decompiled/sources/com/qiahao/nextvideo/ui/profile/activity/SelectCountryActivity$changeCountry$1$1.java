package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.BaseDialogInterface;
import com.qiahao.base_common.model.eventBus.EditEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.EditCountryData;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.home.discover.ChangeCountryDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/SelectCountryActivity$changeCountry$1$1", "Lcom/qiahao/base_common/interfaceing/BaseDialogInterface;", "clickConfirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SelectCountryActivity$changeCountry$1$1 implements BaseDialogInterface {
    final /* synthetic */ EditCountryData $editCountryData;
    final /* synthetic */ ChangeCountryDialog $this_apply;
    final /* synthetic */ SelectCountryActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SelectCountryActivity$changeCountry$1$1(EditCountryData editCountryData, SelectCountryActivity selectCountryActivity, ChangeCountryDialog changeCountryDialog) {
        this.$editCountryData = editCountryData;
        this.this$0 = selectCountryActivity;
        this.$this_apply = changeCountryDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit clickConfirm$lambda$1(EditCountryData editCountryData, ChangeCountryDialog changeCountryDialog, SelectCountryActivity selectCountryActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserSummaryInfo userSummaryInfo = (UserSummaryInfo) apiResponse.getData();
        if (userSummaryInfo != null) {
            UserStore.INSTANCE.getShared().refreshUserInfo(userSummaryInfo);
            cf.c.c().l(new EditEvent("country", editCountryData));
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = changeCountryDialog.getContext();
            String string = changeCountryDialog.getContext().getString(2131954177);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            selectCountryActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit clickConfirm$lambda$2(ChangeCountryDialog changeCountryDialog, SelectCountryActivity selectCountryActivity, SelectCountryActivity$changeCountry$1$1 selectCountryActivity$changeCountry$1$1, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "throwable");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            if (hiloException.getCode() == 9003) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = changeCountryDialog.getContext();
                String string = selectCountryActivity.getString(2131953045);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                return Unit.INSTANCE;
            }
            if (hiloException.getCode() == 9013) {
                HiloToasty.Companion companion2 = HiloToasty.Companion;
                Context context2 = changeCountryDialog.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(selectCountryActivity$changeCountry$1$1, 2131952667);
                }
                Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, context2, errorMessage, false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
                return Unit.INSTANCE;
            }
        }
        HiloToasty.Companion companion3 = HiloToasty.Companion;
        Context context3 = changeCountryDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            String string2 = selectCountryActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str = string2;
        } else {
            str = localizedMessage;
        }
        Toast normal$default3 = HiloToasty.Companion.normal$default(companion3, context3, str, false, 4, (Object) null);
        if (normal$default3 != null) {
            normal$default3.show();
        }
        return Unit.INSTANCE;
    }

    public void clickConfirm() {
        io.reactivex.rxjava3.core.i0 updateUserInformation$default = UserService.updateUserInformation$default(UserService.INSTANCE.getShared(), null, null, this.$editCountryData.getShortName(), null, null, null, 59, null);
        final EditCountryData editCountryData = this.$editCountryData;
        final ChangeCountryDialog changeCountryDialog = this.$this_apply;
        final SelectCountryActivity selectCountryActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.y1
            public final Object invoke(Object obj) {
                Unit clickConfirm$lambda$1;
                clickConfirm$lambda$1 = SelectCountryActivity$changeCountry$1$1.clickConfirm$lambda$1(EditCountryData.this, changeCountryDialog, selectCountryActivity, (ApiResponse) obj);
                return clickConfirm$lambda$1;
            }
        };
        final ChangeCountryDialog changeCountryDialog2 = this.$this_apply;
        final SelectCountryActivity selectCountryActivity2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(updateUserInformation$default, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.z1
            public final Object invoke(Object obj) {
                Unit clickConfirm$lambda$2;
                clickConfirm$lambda$2 = SelectCountryActivity$changeCountry$1$1.clickConfirm$lambda$2(ChangeCountryDialog.this, selectCountryActivity2, this, (Throwable) obj);
                return clickConfirm$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
    }
}
