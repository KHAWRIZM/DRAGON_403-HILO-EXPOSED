package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.ReportDialog;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DialogItemData;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ActivityActivitiesDetailBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.ui.home.discover.viewModel.ActivitiesDetailViewModel;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0006\u0010\u0017\u001a\u00020\u0013J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesDetailActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityActivitiesDetailBinding;", "<init>", "()V", "adapter", "Lcom/qiahao/nextvideo/ui/home/discover/ActivityDetailAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/ActivityDetailAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesDetailViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesDetailViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "showReport", "deleteActivity", "reportGroup", "blackOrReport", "initData", "refreshData", "it", "Lcom/qiahao/base_common/model/ActivityDetailData;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nActivitiesDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivitiesDetailActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesDetailActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,473:1\n61#2,9:474\n61#2,9:483\n61#2,9:492\n*S KotlinDebug\n*F\n+ 1 ActivitiesDetailActivity.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesDetailActivity\n*L\n86#1:474,9\n113#1:483,9\n128#1:492,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesDetailActivity extends HiloBaseBindingActivity<ActivityActivitiesDetailBinding> {

    @NotNull
    public static final String ACTIVITY_ID = "activityId";

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.k
        public final Object invoke() {
            ActivityDetailAdapter adapter_delegate$lambda$0;
            adapter_delegate$lambda$0 = ActivitiesDetailActivity.adapter_delegate$lambda$0();
            return adapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.l
        public final Object invoke() {
            ActivitiesDetailViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = ActivitiesDetailActivity.viewModel_delegate$lambda$1(ActivitiesDetailActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityDetailAdapter adapter_delegate$lambda$0() {
        return new ActivityDetailAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteActivity() {
        getViewModel().deleteActivity(getViewModel().getActivityId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivitiesDetailViewModel getViewModel() {
        return (ActivitiesDetailViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getActivityDetail().observe(this, new ActivitiesDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.b
            public final Object invoke(Object obj) {
                Unit initData$lambda$13;
                initData$lambda$13 = ActivitiesDetailActivity.initData$lambda$13(ActivitiesDetailActivity.this, (ActivityDetailData) obj);
                return initData$lambda$13;
            }
        }));
        getViewModel().getSubscribeUserList().observe(this, new ActivitiesDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.f
            public final Object invoke(Object obj) {
                Unit initData$lambda$15;
                initData$lambda$15 = ActivitiesDetailActivity.initData$lambda$15(ActivitiesDetailActivity.this, (List) obj);
                return initData$lambda$15;
            }
        }));
        getViewModel().getSubscribe().observe(this, new ActivitiesDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.g
            public final Object invoke(Object obj) {
                Unit initData$lambda$16;
                initData$lambda$16 = ActivitiesDetailActivity.initData$lambda$16(ActivitiesDetailActivity.this, (String) obj);
                return initData$lambda$16;
            }
        }));
        getViewModel().getMException().observe(this, new ActivitiesDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.h
            public final Object invoke(Object obj) {
                Unit initData$lambda$17;
                initData$lambda$17 = ActivitiesDetailActivity.initData$lambda$17(ActivitiesDetailActivity.this, (Pair) obj);
                return initData$lambda$17;
            }
        }));
        getViewModel().getMSuccess().observe(this, new ActivitiesDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.i
            public final Object invoke(Object obj) {
                Unit initData$lambda$18;
                initData$lambda$18 = ActivitiesDetailActivity.initData$lambda$18(ActivitiesDetailActivity.this, (Pair) obj);
                return initData$lambda$18;
            }
        }));
        getViewModel().getDelete().observe(this, new ActivitiesDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.j
            public final Object invoke(Object obj) {
                Unit initData$lambda$19;
                initData$lambda$19 = ActivitiesDetailActivity.initData$lambda$19(ActivitiesDetailActivity.this, (Boolean) obj);
                return initData$lambda$19;
            }
        }));
        getViewModel().requestActivityDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$13(ActivitiesDetailActivity activitiesDetailActivity, ActivityDetailData activityDetailData) {
        boolean z;
        activitiesDetailActivity.getAdapter().setActivityShowDiamonds(activitiesDetailActivity.getViewModel().getActivityIsEndOrRunning());
        ActivityDetailAdapter adapter = activitiesDetailActivity.getAdapter();
        if (activityDetailData != null) {
            z = activityDetailData.getShowDiamond();
        } else {
            z = false;
        }
        adapter.setShowDiamond(z);
        if (activityDetailData != null) {
            activitiesDetailActivity.getViewModel().getSubscribeUserListData().resetPage();
            activitiesDetailActivity.getViewModel().requestSquareList();
            activitiesDetailActivity.refreshData(activityDetailData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$15(ActivitiesDetailActivity activitiesDetailActivity, List list) {
        if (list != null) {
            if (activitiesDetailActivity.getViewModel().getSubscribeUserListData().isOnePage()) {
                activitiesDetailActivity.getAdapter().setList(list);
                if (list.isEmpty()) {
                    activitiesDetailActivity.getBinding().centerLayout.setVisibility(8);
                }
            } else {
                activitiesDetailActivity.getAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$16(ActivitiesDetailActivity activitiesDetailActivity, String str) {
        boolean z;
        Toast normal$default;
        if (!TextUtils.isEmpty(str)) {
            ActivityDetailData activityDetailData = (ActivityDetailData) activitiesDetailActivity.getViewModel().getActivityDetail().getValue();
            if (activityDetailData != null) {
                z = Intrinsics.areEqual(activityDetailData.isSubscribe(), Boolean.FALSE);
            } else {
                z = false;
            }
            if (z && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activitiesDetailActivity, ResourcesKtxKt.getStringById(activitiesDetailActivity, 2131954177), false, 4, (Object) null)) != null) {
                normal$default.show();
            }
            activitiesDetailActivity.getViewModel().requestActivityDetail();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$17(ActivitiesDetailActivity activitiesDetailActivity, Pair pair) {
        if ((Intrinsics.areEqual(pair.getFirst(), ActivitiesDetailViewModel.ACTIVITY_DETAIL) || Intrinsics.areEqual(pair.getFirst(), ActivitiesDetailViewModel.ACTIVITY_RESET)) && (pair.getSecond() instanceof HiloException)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloException hiloException = (HiloException) second;
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = hiloException.getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(activitiesDetailActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, activitiesDetailActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            if (hiloException.getCode() == 25006) {
                activitiesDetailActivity.finish();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$18(ActivitiesDetailActivity activitiesDetailActivity, Pair pair) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activitiesDetailActivity, ResourcesKtxKt.getStringById(activitiesDetailActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$19(ActivitiesDetailActivity activitiesDetailActivity, Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activitiesDetailActivity, ResourcesKtxKt.getStringById(activitiesDetailActivity, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            activitiesDetailActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(ActivitiesDetailActivity activitiesDetailActivity, int i, int i2) {
        activitiesDetailActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onInitialize$lambda$5(ActivitiesDetailActivity activitiesDetailActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = (User) activitiesDetailActivity.getAdapter().getData().get(i);
        SvipData svip = user.getSvip();
        if (svip != null && svip.isRankStealth() && user.checkNotOfficialStaff()) {
            new TipDialog(activitiesDetailActivity).setTipContent(ResourcesKtxKt.getStringById(activitiesDetailActivity, 2131954198)).show();
        } else {
            AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, user.getExternalId(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$6(ActivitiesDetailActivity activitiesDetailActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        activitiesDetailActivity.getViewModel().getSubscribeUserListData().resetPage();
        activitiesDetailActivity.getViewModel().requestActivityDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(ActivitiesDetailActivity activitiesDetailActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        activitiesDetailActivity.getViewModel().requestSquareList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void refreshData(ActivityDetailData it) {
        long j;
        long j2;
        long j3;
        TextView textView = ((ActivityActivitiesDetailBinding) getBinding()).title;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131951954), Arrays.copyOf(new Object[]{it.getGroupOwnerCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        QMUIRadiusImageView2 qMUIRadiusImageView2 = ((ActivityActivitiesDetailBinding) getBinding()).centerImage;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "centerImage");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, it.getBanner(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
        ((ActivityActivitiesDetailBinding) getBinding()).stateImage.setImageDrawable(androidx.core.content.a.getDrawable(this, it.getActivityTypeIcon()));
        ((ActivityActivitiesDetailBinding) getBinding()).stateContent.setText(it.getActivityTypeText());
        AppCompatTextView appCompatTextView = ((ActivityActivitiesDetailBinding) getBinding()).timeContent;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        Long startAt = it.getStartAt();
        long j4 = 0;
        if (startAt != null) {
            j = startAt.longValue();
        } else {
            j = 0;
        }
        Long endAt = it.getEndAt();
        if (endAt != null) {
            j2 = endAt.longValue();
        } else {
            j2 = 0;
        }
        appCompatTextView.setText(hiloUtils.formatActivityTime(j, j2));
        ((ActivityActivitiesDetailBinding) getBinding()).content.setText(it.getTheme());
        ((ActivityActivitiesDetailBinding) getBinding()).subContent.setText(it.getDesc());
        QMUIRadiusImageView2 qMUIRadiusImageView22 = ((ActivityActivitiesDetailBinding) getBinding()).headerImage;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView22, "headerImage");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView22, it.getGroupIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232432, 2131232432, (c5.g) null, 40958, (Object) null);
        ((ActivityActivitiesDetailBinding) getBinding()).nickName.setText(it.getGroupName());
        TextView textView2 = ((ActivityActivitiesDetailBinding) getBinding()).idText;
        String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{it.getGroupCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView2.setText(format2);
        ((ActivityActivitiesDetailBinding) getBinding()).trophyNumber.setText(NumberUtilsKt.rankNumberFormat(it.getDiamond()));
        ((ActivityActivitiesDetailBinding) getBinding()).peopleNumber.setText(String.valueOf(it.getSupportNum()));
        Long startAt2 = it.getStartAt();
        if (startAt2 != null) {
            j3 = startAt2.longValue();
        } else {
            j3 = 0;
        }
        Long endAt2 = it.getEndAt();
        if (endAt2 != null) {
            j4 = endAt2.longValue();
        }
        int checkActivityStart = hiloUtils.checkActivityStart(j3, j4);
        if (checkActivityStart != 0) {
            if (checkActivityStart != 1) {
                if (checkActivityStart != 2) {
                    ((ActivityActivitiesDetailBinding) getBinding()).timeImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.discover_time));
                    ((ActivityActivitiesDetailBinding) getBinding()).timeContent.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
                    ((ActivityActivitiesDetailBinding) getBinding()).centerLayout.setVisibility(8);
                    ((ActivityActivitiesDetailBinding) getBinding()).interested.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_gradient_f0f0f0_e6e6e6_24dp));
                    ((ActivityActivitiesDetailBinding) getBinding()).interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.discover_icon_subscription));
                    ((ActivityActivitiesDetailBinding) getBinding()).interestedText.setTextColor(androidx.core.content.a.getColor(this, 2131099900));
                    TextView textView3 = ((ActivityActivitiesDetailBinding) getBinding()).interestedText;
                    String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(it.getPersonNum())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                    textView3.setText(format3);
                    return;
                }
                ((ActivityActivitiesDetailBinding) getBinding()).buttonLayout.setVisibility(8);
                ((ActivityActivitiesDetailBinding) getBinding()).timeImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.discover_time));
                ((ActivityActivitiesDetailBinding) getBinding()).timeContent.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
                ((ActivityActivitiesDetailBinding) getBinding()).centerLayout.setVisibility(0);
                ((ActivityActivitiesDetailBinding) getBinding()).interested.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_gradient_f0f0f0_e6e6e6_24dp));
                ((ActivityActivitiesDetailBinding) getBinding()).interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.discover_icon_subscription));
                ((ActivityActivitiesDetailBinding) getBinding()).interestedText.setTextColor(androidx.core.content.a.getColor(this, 2131099900));
                TextView textView4 = ((ActivityActivitiesDetailBinding) getBinding()).interestedText;
                String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(it.getPersonNum())}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                textView4.setText(format4);
                return;
            }
            ((ActivityActivitiesDetailBinding) getBinding()).buttonLayout.setVisibility(8);
            ((ActivityActivitiesDetailBinding) getBinding()).timeImage.setImageDrawable(androidx.core.content.a.getDrawable(this, 2131231681));
            ((ActivityActivitiesDetailBinding) getBinding()).timeContent.setTextColor(androidx.core.content.a.getColor(this, 2131100001));
            ((ActivityActivitiesDetailBinding) getBinding()).centerLayout.setVisibility(0);
            ((ActivityActivitiesDetailBinding) getBinding()).interested.setBackground(androidx.core.content.a.getDrawable(this, 2131233379));
            ((ActivityActivitiesDetailBinding) getBinding()).interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(this, 2131231678));
            ((ActivityActivitiesDetailBinding) getBinding()).interestedText.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
            TextView textView5 = ((ActivityActivitiesDetailBinding) getBinding()).interestedText;
            String format5 = String.format(ResourcesKtxKt.getStringById(this, 2131951956), Arrays.copyOf(new Object[]{Integer.valueOf(it.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
            textView5.setText(format5);
            return;
        }
        ((ActivityActivitiesDetailBinding) getBinding()).buttonLayout.setVisibility(0);
        ((ActivityActivitiesDetailBinding) getBinding()).timeImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.discover_time));
        ((ActivityActivitiesDetailBinding) getBinding()).timeContent.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
        ((ActivityActivitiesDetailBinding) getBinding()).centerLayout.setVisibility(8);
        if (Intrinsics.areEqual(it.isSubscribe(), Boolean.FALSE)) {
            ((ActivityActivitiesDetailBinding) getBinding()).interested.setBackground(androidx.core.content.a.getDrawable(this, 2131233375));
            ((ActivityActivitiesDetailBinding) getBinding()).interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(this, 2131230851));
            ((ActivityActivitiesDetailBinding) getBinding()).interestedText.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
            TextView textView6 = ((ActivityActivitiesDetailBinding) getBinding()).interestedText;
            String format6 = String.format(ResourcesKtxKt.getStringById(this, 2131951964), Arrays.copyOf(new Object[]{Integer.valueOf(it.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
            textView6.setText(format6);
            return;
        }
        ((ActivityActivitiesDetailBinding) getBinding()).interested.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_gradient_f0f0f0_e6e6e6_24dp));
        ((ActivityActivitiesDetailBinding) getBinding()).interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.discover_icon_subscription));
        ((ActivityActivitiesDetailBinding) getBinding()).interestedText.setTextColor(androidx.core.content.a.getColor(this, 2131099900));
        TextView textView7 = ((ActivityActivitiesDetailBinding) getBinding()).interestedText;
        String format7 = String.format(ResourcesKtxKt.getStringById(this, 2131951963), Arrays.copyOf(new Object[]{Integer.valueOf(it.getPersonNum())}, 1));
        Intrinsics.checkNotNullExpressionValue(format7, "format(...)");
        textView7.setText(format7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reportGroup() {
        new ReportDialog(this).setListener(new ActivitiesDetailActivity$reportGroup$1(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showReport() {
        long j;
        int i;
        String str;
        ActivityDetailData activityDetailData = (ActivityDetailData) getViewModel().getActivityDetail().getValue();
        if (activityDetailData != null) {
            ArrayList textList$default = BlockOrReportDialog.Companion.getTextList$default(BlockOrReportDialog.INSTANCE, "report", false, false, false, 14, null);
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            Long startAt = activityDetailData.getStartAt();
            long j2 = 0;
            if (startAt != null) {
                j = startAt.longValue();
            } else {
                j = 0;
            }
            Long endAt = activityDetailData.getEndAt();
            if (endAt != null) {
                j2 = endAt.longValue();
            }
            if (hiloUtils.checkActivityStart(j, j2) == 0) {
                String groupOwnerId = activityDetailData.getGroupOwnerId();
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    str = user.getExternalId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(groupOwnerId, str)) {
                    textList$default.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131952536), 4));
                }
            }
            User user2 = UserStore.INSTANCE.getShared().getUser();
            if (user2 != null && user2.isOfficialStaff()) {
                textList$default.add(new DialogItemData(ResourcesKtxKt.getStringById(this, 2131953920), 8));
                ActivityDetailData activityDetailData2 = (ActivityDetailData) getViewModel().getActivityDetail().getValue();
                if (activityDetailData2 != null && activityDetailData2.getNotRecommend() == 0) {
                    i = 2131953554;
                } else {
                    i = 2131953861;
                }
                textList$default.add(new DialogItemData(ResourcesKtxKt.getStringById(this, i), 102));
            }
            BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(this, textList$default);
            blockOrReportDialog.setMListener(new ActivitiesDetailActivity$showReport$1$1$1(this));
            blockOrReportDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivitiesDetailViewModel viewModel_delegate$lambda$1(ActivitiesDetailActivity activitiesDetailActivity) {
        return new ViewModelProvider(activitiesDetailActivity).get(ActivitiesDetailViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void blackOrReport() {
        String str;
        String str2;
        String str3;
        String groupId;
        Toast normal = HiloToasty.Companion.normal(this, ResourcesKtxKt.getStringById(this, 2131954177), false);
        if (normal != null) {
            normal.show();
        }
        GroupService.Companion companion = GroupService.INSTANCE;
        je.b mGroupEventProcessorObservable = companion.getMGroupEventProcessorObservable();
        GroupEvent groupEvent = new GroupEvent();
        ActivityDetailData activityDetailData = (ActivityDetailData) getViewModel().getActivityDetail().getValue();
        String str4 = "";
        if (activityDetailData == null || (str = activityDetailData.getGroupId()) == null) {
            str = "";
        }
        mGroupEventProcessorObservable.onNext(groupEvent.leaveGroup(str));
        cf.c c = cf.c.c();
        ActivityDetailData activityDetailData2 = (ActivityDetailData) getViewModel().getActivityDetail().getValue();
        if (activityDetailData2 != null) {
            str2 = activityDetailData2.getGroupId();
        } else {
            str2 = null;
        }
        c.l(new LiveEvent("EXIT_ROOM", DataExternalKt.createExitRoom(str2, 1)));
        GroupService companion2 = companion.getInstance();
        ActivityDetailData activityDetailData3 = (ActivityDetailData) getViewModel().getActivityDetail().getValue();
        if (activityDetailData3 == null || (str3 = activityDetailData3.getGroupId()) == null) {
            str3 = "";
        }
        companion2.setBlockRoomIdList(str3);
        je.b mGroupEventProcessorObservable2 = companion.getMGroupEventProcessorObservable();
        GroupEvent groupEvent2 = new GroupEvent();
        ActivityDetailData activityDetailData4 = (ActivityDetailData) getViewModel().getActivityDetail().getValue();
        if (activityDetailData4 != null && (groupId = activityDetailData4.getGroupId()) != null) {
            str4 = groupId;
        }
        mGroupEventProcessorObservable2.onNext(groupEvent2.blockRoomToLocal(str4));
    }

    @NotNull
    public final ActivityDetailAdapter getAdapter() {
        return (ActivityDetailAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_activities_detail;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        ActivitiesDetailViewModel viewModel = getViewModel();
        String stringExtra = getIntent().getStringExtra(ACTIVITY_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        viewModel.setActivityId(stringExtra);
        if (TextUtils.isEmpty(getViewModel().getActivityId())) {
            finish();
        }
        View view = ((ActivityActivitiesDetailBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.discover.m
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = ActivitiesDetailActivity.onInitialize$lambda$2(ActivitiesDetailActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        ((ActivityActivitiesDetailBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivitiesDetailActivity.this.onBackPressed();
            }
        });
        final ImageView imageView = ((ActivityActivitiesDetailBinding) getBinding()).more;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.showReport();
                }
            }
        });
        ((ActivityActivitiesDetailBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.c
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                ActivitiesDetailActivity.onInitialize$lambda$5(ActivitiesDetailActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getViewModel().getSubscribeUserListData().registerStatusLayoutAndRefreshLayout(((ActivityActivitiesDetailBinding) getBinding()).refreshLayout, ((ActivityActivitiesDetailBinding) getBinding()).statusView);
        ((ActivityActivitiesDetailBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.discover.d
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                ActivitiesDetailActivity.onInitialize$lambda$6(ActivitiesDetailActivity.this, fVar);
            }
        });
        ((ActivityActivitiesDetailBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        final LinearLayout linearLayout = ((ActivityActivitiesDetailBinding) getBinding()).interested;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivitiesDetailViewModel viewModel2;
                boolean z;
                ActivitiesDetailViewModel viewModel3;
                ActivitiesDetailViewModel viewModel4;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                    viewModel2 = this.getViewModel();
                    ActivityDetailData activityDetailData = (ActivityDetailData) viewModel2.getActivityDetail().getValue();
                    boolean z2 = false;
                    if (activityDetailData != null) {
                        z = Intrinsics.areEqual(activityDetailData.isSubscribe(), Boolean.TRUE);
                    } else {
                        z = false;
                    }
                    if (!z) {
                        viewModel3 = this.getViewModel();
                        viewModel4 = this.getViewModel();
                        ActivityDetailData activityDetailData2 = (ActivityDetailData) viewModel4.getActivityDetail().getValue();
                        if (activityDetailData2 != null) {
                            z2 = Intrinsics.areEqual(activityDetailData2.isSubscribe(), Boolean.TRUE);
                        }
                        viewModel3.activitySubscribe(z2);
                        return;
                    }
                    TipDialog confirmContent = new TipDialog(this).setTipContent(ResourcesKtxKt.getStringById(this, 2131951950)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331));
                    final ActivitiesDetailActivity activitiesDetailActivity = this;
                    confirmContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity$onInitialize$6$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            ActivitiesDetailViewModel viewModel5;
                            ActivitiesDetailViewModel viewModel6;
                            boolean z3;
                            viewModel5 = ActivitiesDetailActivity.this.getViewModel();
                            viewModel6 = ActivitiesDetailActivity.this.getViewModel();
                            ActivityDetailData activityDetailData3 = (ActivityDetailData) viewModel6.getActivityDetail().getValue();
                            if (activityDetailData3 != null) {
                                z3 = Intrinsics.areEqual(activityDetailData3.isSubscribe(), Boolean.TRUE);
                            } else {
                                z3 = false;
                            }
                            viewModel5.activitySubscribe(z3);
                        }
                    }).show();
                }
            }
        });
        final TextView textView = ((ActivityActivitiesDetailBinding) getBinding()).go;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivitiesDetailViewModel viewModel2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                    viewModel2 = this.getViewModel();
                    ActivityDetailData activityDetailData = (ActivityDetailData) viewModel2.getActivityDetail().getValue();
                    if (activityDetailData == null || (str = activityDetailData.getGroupId()) == null) {
                        str = "";
                    }
                    StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                }
            }
        });
        ((ActivityActivitiesDetailBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.discover.e
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                ActivitiesDetailActivity.onInitialize$lambda$9(ActivitiesDetailActivity.this, fVar);
            }
        });
        ((ActivityActivitiesDetailBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity$onInitialize$9
            public void onRetry(IStatusView statusView, Status status) {
                ActivitiesDetailViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel2 = ActivitiesDetailActivity.this.getViewModel();
                viewModel2.requestSquareList();
            }
        });
        initData();
    }
}
