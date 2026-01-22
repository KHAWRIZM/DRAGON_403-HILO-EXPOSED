package com.qiahao.nextvideo.ui.vip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.e0;
import com.android.billingclient.api.w;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.databinding.ViewControllerVipBinding;
import com.qiahao.nextvideo.room.dialog.CommonLoadingDialog;
import com.qiahao.nextvideo.utilities.google.pay.BillingRepository;
import com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001]B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010\u0010J\u000f\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\u0010J\u001f\u0010&\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u000eH\u0016¢\u0006\u0004\b(\u0010\u0010J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u000eH\u0016¢\u0006\u0004\b,\u0010\u0010J\u000f\u0010-\u001a\u00020\u000eH\u0016¢\u0006\u0004\b-\u0010\u0010J\u0017\u00100\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u000eH\u0016¢\u0006\u0004\b2\u0010\u0010J\u0017\u00103\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b3\u00101J\u0017\u00105\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u0016H\u0016¢\u0006\u0004\b5\u00106R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00107\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010:R\"\u0010;\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R*\u0010B\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\u0018\"\u0004\bK\u00106R$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010UR$\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\¨\u0006^"}, d2 = {"Lcom/qiahao/nextvideo/ui/vip/VipViewDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewControllerVipBinding;", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "", "position", "Landroid/content/Context;", "context", "<init>", "(ILandroid/content/Context;)V", "", "Lcom/qiahao/nextvideo/ui/vip/VipBannerBean;", "createData", "()Ljava/util/List;", "", "refreshMoneyView", "()V", "setDescriptionClick", "showLoadingDialog", "dissmissLoadingDialog", "getLayoutResId", "()I", "", "isNeedFullScreen", "()Z", "onInitialize", "activityIngResponseBean", "setData", "(Ljava/util/List;)V", "canAutoPlay", "setCanAutoPlay", "(Z)Lcom/qiahao/nextvideo/ui/vip/VipViewDialog;", "show", "dismiss", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "endTime", "subSuccess", "(Lcom/android/billingclient/api/Purchase;J)V", "subTerminateSuccess", "purchaseSuccess", "(Lcom/android/billingclient/api/Purchase;)V", "consumeSuccess", "startupPurchaseFlow", "querySkuDetailAsyncDidFailure", "Lcom/android/billingclient/api/w;", "billingResult", "purchasesUpdatedDidFailure", "(Lcom/android/billingclient/api/w;)V", "showUnChargeGoogleToast", "onBillingSetupFinishedDidFailure", "isSub", "onInitSKUListSuccess", "(Z)V", "I", "getPosition", "setPosition", "(I)V", "mCurrentContext", "Landroid/content/Context;", "getMCurrentContext", "()Landroid/content/Context;", "setMCurrentContext", "(Landroid/content/Context;)V", "Lcom/zhpan/bannerview/BannerViewPager;", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "getMViewPager", "()Lcom/zhpan/bannerview/BannerViewPager;", "setMViewPager", "(Lcom/zhpan/bannerview/BannerViewPager;)V", "autoPlay", "Z", "getAutoPlay", "setAutoPlay", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "mBillingRepository", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "getMBillingRepository", "()Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "setMBillingRepository", "(Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;)V", "Lcom/qiahao/nextvideo/ui/vip/VipBannerPagerAdapter;", "mVipBannerPagerAdapter", "Lcom/qiahao/nextvideo/ui/vip/VipBannerPagerAdapter;", "Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;", "dialog", "Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;", "getDialog", "()Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;", "setDialog", "(Lcom/qiahao/nextvideo/room/dialog/CommonLoadingDialog;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVipViewDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VipViewDialog.kt\ncom/qiahao/nextvideo/ui/vip/VipViewDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,432:1\n61#2,9:433\n61#2,9:442\n1#3:451\n1869#4,2:452\n*S KotlinDebug\n*F\n+ 1 VipViewDialog.kt\ncom/qiahao/nextvideo/ui/vip/VipViewDialog\n*L\n93#1:433,9\n117#1:442,9\n255#1:452,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VipViewDialog extends BaseBindingDialog<ViewControllerVipBinding> implements GooglePayConsumeListener {
    public static final int CHANGE_CAMERA = 12;
    public static final int CLOSE_CAMERA = 11;
    public static final int GROUP_LIMIT = 4;
    public static final int HIDE_AGE = 3;
    public static final int LIKE_LIMIT = 5;

    @NotNull
    private static final String TAG = "VipViewDialog";
    public static final int VIEW_VISITORS = 9;
    private boolean autoPlay;

    @Nullable
    private CommonLoadingDialog dialog;

    @Nullable
    private BillingRepository mBillingRepository;

    @NotNull
    private Context mCurrentContext;

    @Nullable
    private BannerViewPager<VipBannerBean> mViewPager;
    private VipBannerPagerAdapter mVipBannerPagerAdapter;
    private int position;

    public /* synthetic */ VipViewDialog(int i, Context context, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, context);
    }

    private final List<VipBannerBean> createData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip1, ResourcesKtxKt.getStringById(this, 2131954116), ResourcesKtxKt.getStringById(this, 2131954118)));
        String stringById = ResourcesKtxKt.getStringById(this, 2131952482);
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952483), Arrays.copyOf(new Object[]{"1000"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip2, stringById, format));
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip3, ResourcesKtxKt.getStringById(this, 2131953823), ResourcesKtxKt.getStringById(this, 2131953819)));
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip7, ResourcesKtxKt.getStringById(this, 2131953053), ResourcesKtxKt.getStringById(this, 2131953056)));
        String stringById2 = ResourcesKtxKt.getStringById(this, 2131952647);
        String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952648), Arrays.copyOf(new Object[]{MessageService.MSG_DB_COMPLETE, "300"}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip8, stringById2, format2));
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip9, ResourcesKtxKt.getStringById(this, 2131952649), ResourcesKtxKt.getStringById(this, 2131952650)));
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip10, ResourcesKtxKt.getStringById(this, 2131954115), ResourcesKtxKt.getStringById(this, 2131952619)));
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip11, ResourcesKtxKt.getStringById(this, 2131954119), ResourcesKtxKt.getStringById(this, 2131954120)));
        String format3 = String.format(ResourcesKtxKt.getStringById(this, 2131954373), Arrays.copyOf(new Object[]{"1.5"}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        String format4 = String.format(ResourcesKtxKt.getStringById(this, 2131953209), Arrays.copyOf(new Object[]{"1.5"}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip12, format3, format4));
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip13, ResourcesKtxKt.getStringById(this, 2131953253), ResourcesKtxKt.getStringById(this, 2131953254)));
        arrayList.add(new VipBannerBean(R.drawable.icon_vip_tip14, ResourcesKtxKt.getStringById(this, 2131954458), ResourcesKtxKt.getStringById(this, 2131954453)));
        arrayList.add(new VipBannerBean(R.drawable.vip_close_camera, ResourcesKtxKt.getStringById(this, 2131954452), ResourcesKtxKt.getStringById(this, 2131954451)));
        arrayList.add(new VipBannerBean(R.drawable.vip_change_camera, ResourcesKtxKt.getStringById(this, 2131954450), ResourcesKtxKt.getStringById(this, 2131954449)));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dissmissLoadingDialog() {
        CommonLoadingDialog commonLoadingDialog = this.dialog;
        if (commonLoadingDialog != null) {
            commonLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$3(VipViewDialog vipViewDialog, View view) {
        BillingRepository billingRepository;
        User user = UserStore.INSTANCE.getShared().getUser();
        if ((user == null || !user.isVip()) && (billingRepository = vipViewDialog.mBillingRepository) != null) {
            Context context = vipViewDialog.mCurrentContext;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            billingRepository.launchBillingFollow((Activity) context, BillingRepository.VIP_PRODUCT_ID, "subs");
        }
    }

    private final void refreshMoneyView() {
        long j;
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null && user.isVip()) {
            ((ViewControllerVipBinding) getBinding()).getVipOrVipEndTime.setText(ResourcesKtxKt.getStringById(this, 2131952613));
            TextView textView = ((ViewControllerVipBinding) getBinding()).monthMoneyOrEndTime;
            String stringById = ResourcesKtxKt.getStringById(this, 2131952653);
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                j = user2.getVipExpireTime();
            } else {
                j = 0;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{DateTimeUtilityKt.getDateInSecs$default(j, (Locale) null, "yyyy/MM/dd", 2, (Object) null)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            ((ViewControllerVipBinding) getBinding()).nextTime.setText(ResourcesKtxKt.getStringById(this, 2131953574));
            return;
        }
        RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().fetchPurchaseVipList(), new Function1() { // from class: com.qiahao.nextvideo.ui.vip.b
            public final Object invoke(Object obj) {
                Unit refreshMoneyView$lambda$9;
                refreshMoneyView$lambda$9 = VipViewDialog.refreshMoneyView$lambda$9(VipViewDialog.this, (ApiResponse) obj);
                return refreshMoneyView$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.vip.c
            public final Object invoke(Object obj) {
                Unit refreshMoneyView$lambda$10;
                refreshMoneyView$lambda$10 = VipViewDialog.refreshMoneyView$lambda$10(VipViewDialog.this, (Throwable) obj);
                return refreshMoneyView$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null);
        ((ViewControllerVipBinding) getBinding()).nextTime.setText(ResourcesKtxKt.getStringById(this, 2131953525));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit refreshMoneyView$lambda$10(VipViewDialog vipViewDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, vipViewDialog.getContext(), ResourcesKtxKt.getStringById(vipViewDialog, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshMoneyView$lambda$9(VipViewDialog vipViewDialog, ApiResponse apiResponse) {
        PurchaseDiamondDetail purchaseDiamondDetail;
        Float f;
        List<e0> skuSubsDetailsList;
        String str;
        e0.e eVar;
        e0.d b;
        List a;
        e0.c cVar;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List list = (List) apiResponse.getData();
            if (list != null) {
                purchaseDiamondDetail = (PurchaseDiamondDetail) list.get(0);
            } else {
                purchaseDiamondDetail = null;
            }
            if (purchaseDiamondDetail != null) {
                f = Float.valueOf(purchaseDiamondDetail.getPrice());
            } else {
                f = null;
            }
            String str2 = "USD " + f;
            Context context = vipViewDialog.mCurrentContext;
            BillingRepository billingRepository = vipViewDialog.mBillingRepository;
            if (billingRepository != null && (skuSubsDetailsList = billingRepository.getSkuSubsDetailsList()) != null) {
                for (e0 e0Var : skuSubsDetailsList) {
                    String b2 = e0Var.b();
                    if (purchaseDiamondDetail != null) {
                        str = purchaseDiamondDetail.getProductID();
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(b2, str)) {
                        List d = e0Var.d();
                        if (d == null || (eVar = (e0.e) d.get(0)) == null || (b = eVar.b()) == null || (a = b.a()) == null || (cVar = (e0.c) a.get(0)) == null || (str2 = cVar.a()) == null) {
                            str2 = "USD " + purchaseDiamondDetail.getPrice();
                        }
                        ((ViewControllerVipBinding) vipViewDialog.getBinding()).monthMoneyOrEndTime.setText(((Object) str2) + "/" + ResourcesKtxKt.getStringById(vipViewDialog, 2131953580));
                    }
                }
            }
            ((ViewControllerVipBinding) vipViewDialog.getBinding()).getVipOrVipEndTime.setText(ResourcesKtxKt.getStringById(vipViewDialog, 2131952883));
            ((ViewControllerVipBinding) vipViewDialog.getBinding()).monthMoneyOrEndTime.setText(((Object) str2) + "/" + ResourcesKtxKt.getStringById(vipViewDialog, 2131953580));
            ((ViewControllerVipBinding) vipViewDialog.getBinding()).nextTime.setText(ResourcesKtxKt.getStringById(vipViewDialog, 2131953525));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$6(VipViewDialog vipViewDialog, List list) {
        BannerViewPager<VipBannerBean> bannerViewPager;
        if (vipViewDialog.position < list.size() && (bannerViewPager = vipViewDialog.mViewPager) != null) {
            bannerViewPager.J(vipViewDialog.position, false);
        }
    }

    private final void setDescriptionClick() {
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952009), Arrays.copyOf(new Object[]{ResourcesKtxKt.getStringById(this, 2131954238), ResourcesKtxKt.getStringById(this, 2131953716)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        String stringById = ResourcesKtxKt.getStringById(this, 2131954238);
        String stringById2 = ResourcesKtxKt.getStringById(this, 2131953716);
        int indexOf$default = StringsKt.indexOf$default(format, stringById, 0, false, 6, (Object) null);
        int length = stringById.length() + indexOf$default;
        int indexOf$default2 = StringsKt.indexOf$default(format, stringById2, 0, false, 6, (Object) null);
        int length2 = stringById2.length() + indexOf$default2;
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.qiahao.nextvideo.ui.vip.VipViewDialog$setDescriptionClick$serviceClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                NavigationHelper.jump$default(NavigationHelper.INSTANCE, "https://hiloconn.com/action/policy/Terms_of_Service.html", (SuperCallBack) null, 2, (Object) null);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#c5c5c5"));
                ds.setUnderlineText(true);
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() { // from class: com.qiahao.nextvideo.ui.vip.VipViewDialog$setDescriptionClick$privacyPolicyContentClickableSpan$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.checkNotNullParameter(widget, "widget");
                NavigationHelper.jump$default(NavigationHelper.INSTANCE, "https://hiloconn.com/action/policy/Privacy_Policy.html", (SuperCallBack) null, 2, (Object) null);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#c5c5c5"));
                ds.setUnderlineText(true);
            }
        };
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(clickableSpan, indexOf$default, length, 33);
        spannableStringBuilder.setSpan(clickableSpan2, indexOf$default2, length2, 33);
        ((ViewControllerVipBinding) getBinding()).descriptionText.setMovementMethod(LinkMovementMethod.getInstance());
        ((ViewControllerVipBinding) getBinding()).descriptionText.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingDialog() {
        CommonLoadingDialog commonLoadingDialog;
        CommonLoadingDialog commonLoadingDialog2;
        AppCompatDialog appCompatDialog = this.dialog;
        if (appCompatDialog == null) {
            commonLoadingDialog = new CommonLoadingDialog(this.mCurrentContext, null, 2, null);
        } else {
            if (appCompatDialog != null && appCompatDialog.isShowing() && (commonLoadingDialog2 = this.dialog) != null) {
                commonLoadingDialog2.dismiss();
            }
            commonLoadingDialog = new CommonLoadingDialog(this.mCurrentContext, null, 2, null);
        }
        this.dialog = commonLoadingDialog;
        commonLoadingDialog.show();
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void consumeSuccess(@NotNull Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        dissmissLoadingDialog();
    }

    public void dismiss() {
        super.dismiss();
        Log.d(TAG, " BillingRepository  viewWillUnload: 设置为本对象为null");
        BillingRepository billingRepository = this.mBillingRepository;
        if (billingRepository != null) {
            billingRepository.setDelegate(null);
        }
        this.mBillingRepository = null;
    }

    public final boolean getAutoPlay() {
        return this.autoPlay;
    }

    @Nullable
    public final CommonLoadingDialog getDialog() {
        return this.dialog;
    }

    protected int getLayoutResId() {
        return R.layout.view_controller_vip;
    }

    @Nullable
    public final BillingRepository getMBillingRepository() {
        return this.mBillingRepository;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @Nullable
    public final BannerViewPager<VipBannerBean> getMViewPager() {
        return this.mViewPager;
    }

    public final int getPosition() {
        return this.position;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void onBillingSetupFinishedDidFailure(@NotNull w billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.vip.e
            @Override // java.lang.Runnable
            public final void run() {
                VipViewDialog.this.dissmissLoadingDialog();
            }
        });
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void onInitSKUListSuccess(boolean isSub) {
        if (isSub) {
            refreshMoneyView();
        }
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        BillingRepository billingRepository = new BillingRepository(this.mCurrentContext);
        billingRepository.setDelegate(this);
        billingRepository.startDataSourceConnections();
        this.mBillingRepository = billingRepository;
        setGravity(17);
        this.mVipBannerPagerAdapter = new VipBannerPagerAdapter(this.mCurrentContext);
        BannerViewPager<VipBannerBean> bannerViewPager = ((ViewControllerVipBinding) getBinding()).bannerView;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.ui.vip.VipBannerBean>");
        this.mViewPager = bannerViewPager;
        if (bannerViewPager != null) {
            VipBannerPagerAdapter vipBannerPagerAdapter = this.mVipBannerPagerAdapter;
            if (vipBannerPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVipBannerPagerAdapter");
                vipBannerPagerAdapter = null;
            }
            bannerViewPager.G(vipBannerPagerAdapter);
        }
        BannerViewPager<VipBannerBean> bannerViewPager2 = this.mViewPager;
        if (bannerViewPager2 != null) {
            bannerViewPager2.g();
        }
        setData(createData());
        ((ViewControllerVipBinding) getBinding()).text1.getPaint().setFlags(8);
        ((ViewControllerVipBinding) getBinding()).text1.getPaint().setAntiAlias(true);
        final TextView textView = ((ViewControllerVipBinding) getBinding()).text1;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.vip.VipViewDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    try {
                        Context context = this.getContext();
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions?sku=hilo_vip_monthly&package=com.qiahao.nextvideo"));
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ((ViewControllerVipBinding) getBinding()).getVip.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.vip.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipViewDialog.onInitialize$lambda$3(VipViewDialog.this, view);
            }
        });
        final FrameLayout frameLayout = ((ViewControllerVipBinding) getBinding()).frameLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.vip.VipViewDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        ((ViewControllerVipBinding) getBinding()).nextTime.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.vip.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipViewDialog.this.dismiss();
            }
        });
        setDescriptionClick();
        refreshMoneyView();
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void purchaseSuccess(@NotNull Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void purchasesUpdatedDidFailure(@NotNull w billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.vip.g
            @Override // java.lang.Runnable
            public final void run() {
                VipViewDialog.this.dissmissLoadingDialog();
            }
        });
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void querySkuDetailAsyncDidFailure() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.vip.d
            @Override // java.lang.Runnable
            public final void run() {
                VipViewDialog.this.dissmissLoadingDialog();
            }
        });
    }

    public final void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    @NotNull
    public final VipViewDialog setCanAutoPlay(boolean canAutoPlay) {
        this.autoPlay = canAutoPlay;
        return this;
    }

    public final void setData(@NotNull final List<VipBannerBean> activityIngResponseBean) {
        BannerViewPager L;
        BannerViewPager P;
        BannerViewPager N;
        BannerViewPager K;
        BannerViewPager M;
        Intrinsics.checkNotNullParameter(activityIngResponseBean, "activityIngResponseBean");
        BannerViewPager<VipBannerBean> bannerViewPager = this.mViewPager;
        if (bannerViewPager != null && (L = bannerViewPager.L(5)) != null && (P = L.P(4)) != null && (N = P.N(dd.a.a(6.0f))) != null && (K = N.K(dd.a.a(6.0f))) != null && (M = K.M(Color.parseColor("#d8d8d8"), Color.parseColor("#4c4c4c"))) != null) {
            M.O(dd.a.a(6.0f), dd.a.a(6.0f));
        }
        BannerViewPager<VipBannerBean> bannerViewPager2 = this.mViewPager;
        if (bannerViewPager2 != null) {
            bannerViewPager2.C(activityIngResponseBean);
        }
        ((ViewControllerVipBinding) getBinding()).bannerView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.vip.f
            @Override // java.lang.Runnable
            public final void run() {
                VipViewDialog.setData$lambda$6(VipViewDialog.this, activityIngResponseBean);
            }
        });
    }

    public final void setDialog(@Nullable CommonLoadingDialog commonLoadingDialog) {
        this.dialog = commonLoadingDialog;
    }

    public final void setMBillingRepository(@Nullable BillingRepository billingRepository) {
        this.mBillingRepository = billingRepository;
    }

    public final void setMCurrentContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mCurrentContext = context;
    }

    public final void setMViewPager(@Nullable BannerViewPager<VipBannerBean> bannerViewPager) {
        this.mViewPager = bannerViewPager;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public void show() {
        super/*com.oudi.core.component.SuperDialog*/.show();
        BannerViewPager<VipBannerBean> bannerViewPager = this.mViewPager;
        if (bannerViewPager != null) {
            bannerViewPager.H(this.autoPlay);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void showUnChargeGoogleToast() {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), ResourcesKtxKt.getStringById(this, 2131952929), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void startupPurchaseFlow() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.vip.h
            @Override // java.lang.Runnable
            public final void run() {
                VipViewDialog.this.showLoadingDialog();
            }
        });
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void subSuccess(@NotNull Purchase purchase, long endTime) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
        ((ViewControllerVipBinding) getBinding()).getVipOrVipEndTime.setText(ResourcesKtxKt.getStringById(this, 2131952613));
        TextView textView = ((ViewControllerVipBinding) getBinding()).monthMoneyOrEndTime;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952653), Arrays.copyOf(new Object[]{DateTimeUtilityKt.getDateInSecs$default(endTime, (Locale) null, "yyyy/MM/dd", 2, (Object) null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        ((ViewControllerVipBinding) getBinding()).nextTime.setText(ResourcesKtxKt.getStringById(this, 2131953574));
        MatchingProvide.INSTANCE.getMatchConfigSendEvent();
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void subTerminateSuccess() {
        dissmissLoadingDialog();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipViewDialog(int i, @NotNull Context context) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.position = i;
        this.mCurrentContext = context;
        this.autoPlay = true;
    }
}
