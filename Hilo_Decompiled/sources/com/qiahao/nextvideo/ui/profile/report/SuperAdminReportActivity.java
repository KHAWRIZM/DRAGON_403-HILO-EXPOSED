package com.qiahao.nextvideo.ui.profile.report;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.oudi.adapter.IListAdapter;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.picture.PictureSelector;
import com.qiahao.base_common.utils.picture.PictureSelectorConfigures;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.SelectImageData;
import com.qiahao.nextvideo.databinding.ActivitySuperAdminReportBinding;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020\u0006H\u0014J\b\u0010#\u001a\u00020$H\u0017J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0018\u0010*\u001a\u00020$2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,J\b\u0010.\u001a\u00020$H\u0002J\u0016\u0010/\u001a\u00020$2\f\u00100\u001a\b\u0012\u0004\u0012\u00020-01H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 ¨\u00063"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/report/SuperAdminReportActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySuperAdminReportBinding;", "<init>", "()V", "mSelectPosition", "", "getMSelectPosition", "()I", "setMSelectPosition", "(I)V", "mSelectTime", "getMSelectTime", "setMSelectTime", "toUserExternalId", "", "getToUserExternalId", "()Ljava/lang/String;", "setToUserExternalId", "(Ljava/lang/String;)V", "mType", "getMType", "setMType", "viewModel", "Lcom/qiahao/nextvideo/ui/profile/report/SuperReportViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/profile/report/SuperReportViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/qiahao/nextvideo/ui/profile/report/SuperReportAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/profile/report/SuperReportAdapter;", "adapter$delegate", "getLayoutResId", "onInitialize", "", "checkSubmitButton", "refreshButton", "buttonType", "refreshTime", AgooConstants.MESSAGE_TIME, "refreshData", "list", "", "Lcom/luck/picture/lib/entity/LocalMedia;", "selectImage", "choosePicture", "listener", "Lcom/luck/picture/lib/interfaces/OnResultCallbackListener;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperAdminReportActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperAdminReportActivity.kt\ncom/qiahao/nextvideo/ui/profile/report/SuperAdminReportActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,260:1\n61#2,9:261\n61#2,9:270\n61#2,9:279\n61#2,9:288\n61#2,9:297\n61#2,9:306\n61#2,9:315\n61#2,9:324\n61#2,9:333\n1869#3,2:342\n1869#3,2:344\n*S KotlinDebug\n*F\n+ 1 SuperAdminReportActivity.kt\ncom/qiahao/nextvideo/ui/profile/report/SuperAdminReportActivity\n*L\n86#1:261,9\n89#1:270,9\n92#1:279,9\n95#1:288,9\n98#1:297,9\n101#1:306,9\n104#1:315,9\n107#1:324,9\n140#1:333,9\n217#1:342,2\n242#1:344,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SuperAdminReportActivity extends HiloBaseBindingActivity<ActivitySuperAdminReportBinding> {
    public static final int ONE_DAY = 24;
    public static final int PERMANENT = -1;

    @NotNull
    public static final String REPORT_TYPE = "REPORT_TYPE";

    @NotNull
    public static final String REPORT_TYPE_SUPER = "REPORT_TYPE_SUPER";

    @NotNull
    public static final String REPORT_TYPE_SVIP9 = "REPORT_TYPE_SVIP9";
    public static final int THIRTY_DAY = 720;
    public static final int THREE_DAY = 72;

    @NotNull
    public static final String USER_EXTERNAL_ID = "user_external_id";
    private int mSelectPosition;
    private int mSelectTime;

    @NotNull
    private String toUserExternalId = "";

    @NotNull
    private String mType = REPORT_TYPE_SUPER;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.report.a
        public final Object invoke() {
            SuperReportViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = SuperAdminReportActivity.viewModel_delegate$lambda$0(SuperAdminReportActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.report.b
        public final Object invoke() {
            SuperReportAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = SuperAdminReportActivity.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperReportAdapter adapter_delegate$lambda$1() {
        return new SuperReportAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void checkSubmitButton() {
        if (this.mSelectPosition > 0 && !TextUtils.isEmpty(String.valueOf(((ActivitySuperAdminReportBinding) getBinding()).editText.getText())) && ((SelectImageData) getAdapter().getData().get(0)).getMedia() != null) {
            ((ActivitySuperAdminReportBinding) getBinding()).submit.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_9036ff_25));
        } else {
            ((ActivitySuperAdminReportBinding) getBinding()).submit.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.shape_809036ff_25));
        }
    }

    private final void choosePicture(OnResultCallbackListener<LocalMedia> listener) {
        ArrayList arrayList = new ArrayList();
        Iterator it = getAdapter().getData().iterator();
        while (it.hasNext()) {
            LocalMedia media = ((SelectImageData) it.next()).getMedia();
            if (media != null) {
                arrayList.add(media);
            }
        }
        PictureSelector.INSTANCE.selectorPicture(new PictureSelectorConfigures.Companion.Builder().isEnablePreviewImage(true).setWithCamera(true).setMShowType(SelectMimeType.ofAll()).setMVideoMaxSecond(100).setMVideoMinSecond(3).setSelectList(arrayList).isMEnableCrop(false).build(), listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuperReportViewModel getViewModel() {
        return (SuperReportViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$12(SuperAdminReportActivity superAdminReportActivity, IListAdapter iListAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(iListAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        int id2 = view.getId();
        if (id2 != 2131361925) {
            if (id2 != 2131362627) {
                if (id2 == 2131363201) {
                    superAdminReportActivity.selectImage();
                }
            } else {
                superAdminReportActivity.getAdapter().removeAt(i);
                refreshData$default(superAdminReportActivity, null, 1, null);
            }
        } else {
            superAdminReportActivity.selectImage();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$14(SuperAdminReportActivity superAdminReportActivity, Boolean bool) {
        if (bool.booleanValue()) {
            HiloBaseActivity.showProgressDialog$default((HiloBaseActivity) superAdminReportActivity, (String) null, false, (Function0) null, 7, (Object) null);
        } else {
            HiloBaseActivity.dismissProgressDialog$default(superAdminReportActivity, false, null, 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$15(SuperAdminReportActivity superAdminReportActivity, Boolean bool) {
        if (bool.booleanValue()) {
            superAdminReportActivity.getViewModel().superAdminReport(superAdminReportActivity.toUserExternalId, superAdminReportActivity.mSelectPosition, String.valueOf(superAdminReportActivity.getBinding().editText.getText()), DataExternalKt.arrayListToString(superAdminReportActivity.getViewModel().getUrlList()), Integer.valueOf(superAdminReportActivity.mSelectTime));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onInitialize$lambda$16(SuperAdminReportActivity superAdminReportActivity, Boolean bool) {
        if (bool.booleanValue()) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, superAdminReportActivity, ResourcesKtxKt.getStringById(superAdminReportActivity, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            superAdminReportActivity.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(SuperAdminReportActivity superAdminReportActivity, int i, int i2) {
        superAdminReportActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void refreshButton(int buttonType) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        this.mSelectPosition = buttonType;
        TextView textView = ((ActivitySuperAdminReportBinding) getBinding()).harassment;
        int i7 = 2131230998;
        if (buttonType == 1) {
            i = 2131231001;
        } else {
            i = 2131230998;
        }
        textView.setBackground(androidx.core.content.a.getDrawable(this, i));
        TextView textView2 = ((ActivitySuperAdminReportBinding) getBinding()).privacy;
        if (buttonType == 2) {
            i2 = 2131231001;
        } else {
            i2 = 2131230998;
        }
        textView2.setBackground(androidx.core.content.a.getDrawable(this, i2));
        TextView textView3 = ((ActivitySuperAdminReportBinding) getBinding()).violation;
        if (buttonType == 3) {
            i3 = 2131231001;
        } else {
            i3 = 2131230998;
        }
        textView3.setBackground(androidx.core.content.a.getDrawable(this, i3));
        TextView textView4 = ((ActivitySuperAdminReportBinding) getBinding()).official;
        if (buttonType == 4) {
            i7 = 2131231001;
        }
        textView4.setBackground(androidx.core.content.a.getDrawable(this, i7));
        TextView textView5 = ((ActivitySuperAdminReportBinding) getBinding()).harassment;
        int i8 = 2131099918;
        if (buttonType == 1) {
            i4 = 2131101214;
        } else {
            i4 = 2131099918;
        }
        textView5.setTextColor(androidx.core.content.a.getColor(this, i4));
        TextView textView6 = ((ActivitySuperAdminReportBinding) getBinding()).privacy;
        if (buttonType == 2) {
            i5 = 2131101214;
        } else {
            i5 = 2131099918;
        }
        textView6.setTextColor(androidx.core.content.a.getColor(this, i5));
        TextView textView7 = ((ActivitySuperAdminReportBinding) getBinding()).violation;
        if (buttonType == 3) {
            i6 = 2131101214;
        } else {
            i6 = 2131099918;
        }
        textView7.setTextColor(androidx.core.content.a.getColor(this, i6));
        TextView textView8 = ((ActivitySuperAdminReportBinding) getBinding()).official;
        if (buttonType == 4) {
            i8 = 2131101214;
        }
        textView8.setTextColor(androidx.core.content.a.getColor(this, i8));
        checkSubmitButton();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void refreshData$default(SuperAdminReportActivity superAdminReportActivity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        superAdminReportActivity.refreshData(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void refreshTime(int time) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        this.mSelectTime = time;
        TextView textView = ((ActivitySuperAdminReportBinding) getBinding()).oneDay;
        int i7 = 2131230998;
        if (this.mSelectTime == 24) {
            i = 2131231001;
        } else {
            i = 2131230998;
        }
        textView.setBackground(androidx.core.content.a.getDrawable(this, i));
        TextView textView2 = ((ActivitySuperAdminReportBinding) getBinding()).twoDay;
        if (this.mSelectTime == 72) {
            i2 = 2131231001;
        } else {
            i2 = 2131230998;
        }
        textView2.setBackground(androidx.core.content.a.getDrawable(this, i2));
        TextView textView3 = ((ActivitySuperAdminReportBinding) getBinding()).threeDay;
        if (this.mSelectTime == 720) {
            i3 = 2131231001;
        } else {
            i3 = 2131230998;
        }
        textView3.setBackground(androidx.core.content.a.getDrawable(this, i3));
        TextView textView4 = ((ActivitySuperAdminReportBinding) getBinding()).permanent;
        if (this.mSelectTime == -1) {
            i7 = 2131231001;
        }
        textView4.setBackground(androidx.core.content.a.getDrawable(this, i7));
        TextView textView5 = ((ActivitySuperAdminReportBinding) getBinding()).oneDay;
        int i8 = 2131099918;
        if (this.mSelectTime == 24) {
            i4 = 2131101214;
        } else {
            i4 = 2131099918;
        }
        textView5.setTextColor(androidx.core.content.a.getColor(this, i4));
        TextView textView6 = ((ActivitySuperAdminReportBinding) getBinding()).twoDay;
        if (this.mSelectTime == 72) {
            i5 = 2131101214;
        } else {
            i5 = 2131099918;
        }
        textView6.setTextColor(androidx.core.content.a.getColor(this, i5));
        TextView textView7 = ((ActivitySuperAdminReportBinding) getBinding()).threeDay;
        if (this.mSelectTime == 720) {
            i6 = 2131101214;
        } else {
            i6 = 2131099918;
        }
        textView7.setTextColor(androidx.core.content.a.getColor(this, i6));
        TextView textView8 = ((ActivitySuperAdminReportBinding) getBinding()).permanent;
        if (this.mSelectTime == -1) {
            i8 = 2131101214;
        }
        textView8.setTextColor(androidx.core.content.a.getColor(this, i8));
        checkSubmitButton();
    }

    private final void selectImage() {
        choosePicture(new OnResultCallbackListener<LocalMedia>() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$selectImage$1
            public void onCancel() {
            }

            public void onResult(ArrayList<LocalMedia> result) {
                SuperAdminReportActivity.this.refreshData(result);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperReportViewModel viewModel_delegate$lambda$0(SuperAdminReportActivity superAdminReportActivity) {
        return new ViewModelProvider(superAdminReportActivity).get(SuperReportViewModel.class);
    }

    @NotNull
    public final SuperReportAdapter getAdapter() {
        return (SuperReportAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_super_admin_report;
    }

    public final int getMSelectPosition() {
        return this.mSelectPosition;
    }

    public final int getMSelectTime() {
        return this.mSelectTime;
    }

    @NotNull
    public final String getMType() {
        return this.mType;
    }

    @NotNull
    public final String getToUserExternalId() {
        return this.toUserExternalId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    @SuppressLint({"SetTextI18n"})
    public void onInitialize() {
        super.onInitialize();
        String stringExtra = getIntent().getStringExtra(USER_EXTERNAL_ID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.toUserExternalId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(REPORT_TYPE);
        if (stringExtra2 == null) {
            stringExtra2 = REPORT_TYPE_SUPER;
        }
        this.mType = stringExtra2;
        if (Intrinsics.areEqual(stringExtra2, REPORT_TYPE_SUPER)) {
            ((ActivitySuperAdminReportBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131953910));
            ((ActivitySuperAdminReportBinding) getBinding()).svipGroup.setVisibility(8);
        } else {
            this.mSelectTime = 24;
            ((ActivitySuperAdminReportBinding) getBinding()).svipGroup.setVisibility(0);
            ((ActivitySuperAdminReportBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131952076));
            TextView textView = ((ActivitySuperAdminReportBinding) getBinding()).oneDay;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952500), Arrays.copyOf(new Object[]{""}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(MessageService.MSG_DB_NOTIFY_REACHED + format);
            TextView textView2 = ((ActivitySuperAdminReportBinding) getBinding()).twoDay;
            String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952502), Arrays.copyOf(new Object[]{3}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView2.setText(format2);
            TextView textView3 = ((ActivitySuperAdminReportBinding) getBinding()).threeDay;
            String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131952502), Arrays.copyOf(new Object[]{30}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textView3.setText(format3);
            ((ActivitySuperAdminReportBinding) getBinding()).permanent.setText(ResourcesKtxKt.getStringById(this, 2131953619));
            refreshTime(this.mSelectTime);
        }
        View view = ((ActivitySuperAdminReportBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.profile.report.c
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = SuperAdminReportActivity.onInitialize$lambda$2(SuperAdminReportActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        ((ActivitySuperAdminReportBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SuperAdminReportActivity.this.onBackPressed();
            }
        });
        final TextView textView4 = ((ActivitySuperAdminReportBinding) getBinding()).oneDay;
        final long j = 800;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    this.refreshTime(24);
                }
            }
        });
        final TextView textView5 = ((ActivitySuperAdminReportBinding) getBinding()).twoDay;
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView5) > j || (textView5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView5, currentTimeMillis);
                    this.refreshTime(72);
                }
            }
        });
        final TextView textView6 = ((ActivitySuperAdminReportBinding) getBinding()).threeDay;
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView6) > j || (textView6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView6, currentTimeMillis);
                    this.refreshTime(SuperAdminReportActivity.THIRTY_DAY);
                }
            }
        });
        final TextView textView7 = ((ActivitySuperAdminReportBinding) getBinding()).permanent;
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView7) > j || (textView7 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView7, currentTimeMillis);
                    this.refreshTime(-1);
                }
            }
        });
        final TextView textView8 = ((ActivitySuperAdminReportBinding) getBinding()).harassment;
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView8) > j || (textView8 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView8, currentTimeMillis);
                    this.refreshButton(1);
                }
            }
        });
        final TextView textView9 = ((ActivitySuperAdminReportBinding) getBinding()).privacy;
        textView9.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView9) > j || (textView9 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView9, currentTimeMillis);
                    this.refreshButton(2);
                }
            }
        });
        final TextView textView10 = ((ActivitySuperAdminReportBinding) getBinding()).violation;
        textView10.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView10) > j || (textView10 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView10, currentTimeMillis);
                    this.refreshButton(3);
                }
            }
        });
        final TextView textView11 = ((ActivitySuperAdminReportBinding) getBinding()).official;
        textView11.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView11) > j || (textView11 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView11, currentTimeMillis);
                    this.refreshButton(4);
                }
            }
        });
        ((ActivitySuperAdminReportBinding) getBinding()).editText.addTextChangedListener(new TextWatcher() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$11
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ActivitySuperAdminReportBinding binding;
                Intrinsics.checkNotNullParameter(s, "s");
                binding = SuperAdminReportActivity.this.getBinding();
                binding.lengthTextView.setText("(" + s.length() + "/120)");
                SuperAdminReportActivity.this.checkSubmitButton();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        ((ActivitySuperAdminReportBinding) getBinding()).titleBar.getRoot().setBackgroundColor(Color.parseColor("#9036ff"));
        ((ActivitySuperAdminReportBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        getAdapter().addChildClickViewIds(new int[]{R.id.addImage, R.id.deleteImage, 2131363201});
        getAdapter().setOnItemChildClickListener(new Function3() { // from class: com.qiahao.nextvideo.ui.profile.report.e
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit onInitialize$lambda$12;
                onInitialize$lambda$12 = SuperAdminReportActivity.onInitialize$lambda$12(SuperAdminReportActivity.this, (IListAdapter) obj, (View) obj2, ((Integer) obj3).intValue());
                return onInitialize$lambda$12;
            }
        });
        final TextView textView12 = ((ActivitySuperAdminReportBinding) getBinding()).submit;
        textView12.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity$onInitialize$$inlined$singleClick$default$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActivitySuperAdminReportBinding binding;
                SuperReportViewModel viewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView12) > j || (textView12 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView12, currentTimeMillis);
                    if (this.getMSelectPosition() > 0) {
                        binding = this.getBinding();
                        if (!TextUtils.isEmpty(String.valueOf(binding.editText.getText())) && ((SelectImageData) this.getAdapter().getData().get(0)).getMedia() != null) {
                            viewModel = this.getViewModel();
                            viewModel.uploadFile(this.getAdapter().getData());
                        }
                    }
                }
            }
        });
        getViewModel().getShowDialog().observe(this, new SuperAdminReportActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.profile.report.f
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$14;
                onInitialize$lambda$14 = SuperAdminReportActivity.onInitialize$lambda$14(SuperAdminReportActivity.this, (Boolean) obj);
                return onInitialize$lambda$14;
            }
        }));
        getViewModel().getUploadSuccess().observe(this, new SuperAdminReportActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.profile.report.g
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$15;
                onInitialize$lambda$15 = SuperAdminReportActivity.onInitialize$lambda$15(SuperAdminReportActivity.this, (Boolean) obj);
                return onInitialize$lambda$15;
            }
        }));
        getViewModel().getReportSuccess().observe(this, new SuperAdminReportActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.profile.report.h
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$16;
                onInitialize$lambda$16 = SuperAdminReportActivity.onInitialize$lambda$16(SuperAdminReportActivity.this, (Boolean) obj);
                return onInitialize$lambda$16;
            }
        }));
        refreshData$default(this, null, 1, null);
        checkSubmitButton();
    }

    public final void refreshData(@Nullable List<? extends LocalMedia> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new SelectImageData(1, (LocalMedia) it.next()));
            }
        } else {
            arrayList.add(new SelectImageData(2, null, 2, null));
        }
        getAdapter().setList(arrayList);
        checkSubmitButton();
    }

    public final void setMSelectPosition(int i) {
        this.mSelectPosition = i;
    }

    public final void setMSelectTime(int i) {
        this.mSelectTime = i;
    }

    public final void setMType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mType = str;
    }

    public final void setToUserExternalId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.toUserExternalId = str;
    }
}
