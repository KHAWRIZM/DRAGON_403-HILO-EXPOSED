package com.qiahao.nextvideo.ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.ControllerListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxJava;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.BinderThirdType;
import com.qiahao.nextvideo.data.model.IsDealerBean;
import com.qiahao.nextvideo.data.promote.PromoteData;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerSettingNativeBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.feedback.FeedbackActivity;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.promoter.PromoterActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;
import com.qiahao.nextvideo.ui.setting.platformprotocals.PlatformProtocalViewController;
import com.qiahao.nextvideo.ui.transfer.TransferActivity;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.FileManager;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J'\u0010\f\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J'\u0010\u000f\u001a\u00020\u00052\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010#\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\"H\u0017¢\u0006\u0004\b&\u0010'J\u001f\u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0004R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR2\u0010V\u001a\u0012\u0012\u0004\u0012\u00020U0\bj\b\u0012\u0004\u0012\u00020U`\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010\r¨\u0006\\"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/SettingViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "<init>", "()V", "", "judgeIsDealer", "uploadOperationLog", "Ljava/util/ArrayList;", "Ljava/io/File;", "Lkotlin/collections/ArrayList;", "files", "startUploadOperationLog", "(Ljava/util/ArrayList;)V", "uploadAgoraLog", "startUpload", "cacheSizeTextViewPressed", "connectedLogButtonPressed", "platformPolicyButtonPressed", "", "isChecked", "matchingNotificationSwitchViewPressed", "(Z)V", "commitStarButtonPressed", "commitSuggestButtonPressed", "exitAccountButtonPressed", "Lio/reactivex/rxjava3/core/i0;", "", "cleanCache", "()Lio/reactivex/rxjava3/core/i0;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "Lcom/qiahao/nextvideo/databinding/ViewControllerSettingNativeBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerSettingNativeBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerSettingNativeBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerSettingNativeBinding;)V", "Landroidx/core/app/r;", "notificationManagerCompat", "Landroidx/core/app/r;", "getNotificationManagerCompat", "()Landroidx/core/app/r;", "setNotificationManagerCompat", "(Landroidx/core/app/r;)V", "mHasInvite", "Z", "Lcom/qiahao/nextvideo/data/promote/PromoteData;", "mPromoter", "Lcom/qiahao/nextvideo/data/promote/PromoteData;", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "mListener", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "getMListener", "()Lcom/qiahao/base_common/interfaceing/ControllerListener;", "setMListener", "(Lcom/qiahao/base_common/interfaceing/ControllerListener;)V", "moreTouch", "I", "getMoreTouch", "()I", "setMoreTouch", "(I)V", AgooConstants.MESSAGE_TIME, "J", "getTime", "()J", "setTime", "(J)V", "", "listName", "Ljava/util/ArrayList;", "getListName", "()Ljava/util/ArrayList;", "setListName", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingViewController.kt\ncom/qiahao/nextvideo/ui/setting/SettingViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,532:1\n1#2:533\n61#3,9:534\n61#3,9:543\n61#3,9:552\n61#3,9:561\n61#3,9:570\n61#3,9:579\n61#3,9:588\n3829#4:597\n4344#4,2:598\n3829#4:600\n4344#4,2:601\n3829#4:603\n4344#4,2:604\n3829#4:606\n4344#4,2:607\n*S KotlinDebug\n*F\n+ 1 SettingViewController.kt\ncom/qiahao/nextvideo/ui/setting/SettingViewController\n*L\n168#1:534,9\n178#1:543,9\n181#1:552,9\n184#1:561,9\n187#1:570,9\n203#1:579,9\n230#1:588,9\n271#1:597\n271#1:598,2\n279#1:600\n279#1:601,2\n297#1:603\n297#1:604,2\n375#1:606\n375#1:607,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SettingViewController extends BaseViewController implements ConfirmTipViewControllerDelegate {

    @NotNull
    public static final String TAG = "setting";
    public ViewControllerSettingNativeBinding binding;

    @NotNull
    private ArrayList<String> listName;
    private boolean mHasInvite;

    @Nullable
    private ControllerListener mListener;

    @Nullable
    private PromoteData mPromoter;
    private int moreTouch;
    public androidx.core.app.r notificationManagerCompat;
    private long time;

    public SettingViewController() {
        setTag(TAG);
        this.time = System.currentTimeMillis();
        this.listName = CollectionsKt.arrayListOf(new String[]{"agorasdk.log", "agorasdk_1.log", "agorasdk_2.log", "agorasdk_3.log", "agorasdk_4.log"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheSizeTextViewPressed() {
        ConfirmPreloadModel init = ConfirmPreloadModel.INSTANCE.init(BaseViewControllerKt.getString(this, 2131952351, new Object[0]), BaseViewControllerKt.getString(this, 2131952331, new Object[0]), BaseViewControllerKt.getString(this, 2131952171, new Object[0]));
        init.setFromCode(8);
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(init, null, 2, null);
        confirmTipViewController.setDelegate(this);
        ViewController.present$default(this, confirmTipViewController, true, null, 4, null);
    }

    private final io.reactivex.rxjava3.core.i0<Long> cleanCache() {
        io.reactivex.rxjava3.core.i0<Long> d = io.reactivex.rxjava3.core.i0.d(new io.reactivex.rxjava3.core.l0() { // from class: com.qiahao.nextvideo.ui.setting.b0
            public final void a(io.reactivex.rxjava3.core.j0 j0Var) {
                SettingViewController.cleanCache$lambda$50(SettingViewController.this, j0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(d, "create(...)");
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cleanCache$lambda$50(SettingViewController settingViewController, io.reactivex.rxjava3.core.j0 j0Var) {
        BaseActivity baseActivity;
        Intrinsics.checkNotNullParameter(j0Var, "it");
        FileManager fileManager = FileManager.INSTANCE;
        fileManager.deleteCache(settingViewController.getRequireActivity());
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, MMKVToLocalCache.OPEN_APP_TIMES, 0, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, MMKVToLocalCache.OPEN_SOURCE_DATA, "", (String) null, 4, (Object) null);
        if (settingViewController.get_activity() != null && (baseActivity = settingViewController.get_activity()) != null && (!baseActivity.isFinishing())) {
            File cacheDir = settingViewController.getRequireActivity().getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
            j0Var.onSuccess(Long.valueOf(fileManager.getDirSize(cacheDir)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitStarButtonPressed() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + getRequireActivity().getApplication().getPackageName()));
            getRequireActivity().startActivity(intent);
        } catch (Exception e) {
            Toast error$default = HiloToasty.Companion.error$default(HiloToasty.Companion, getContext(), BaseViewControllerKt.getString(this, 2131952667, new Object[0]), false, 4, (Object) null);
            if (error$default != null) {
                error$default.show();
            }
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitSuggestButtonPressed() {
        getRequireActivity().startActivity(new Intent((Context) getRequireActivity(), (Class<?>) FeedbackActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$49(int i, final SettingViewController settingViewController) {
        if (i != 8) {
            if (i == 9) {
                AppUtilitiesKt.toAppSetting(settingViewController.getRequireActivity());
            }
        } else {
            io.reactivex.rxjava3.core.i0 p = settingViewController.cleanCache().p(ke.a.b());
            Intrinsics.checkNotNullExpressionValue(p, "subscribeOn(...)");
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(p, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.j0
                public final Object invoke(Object obj) {
                    Unit confirmTipViewControllerDidConfirm$lambda$49$lambda$47;
                    confirmTipViewControllerDidConfirm$lambda$49$lambda$47 = SettingViewController.confirmTipViewControllerDidConfirm$lambda$49$lambda$47(SettingViewController.this, (Long) obj);
                    return confirmTipViewControllerDidConfirm$lambda$49$lambda$47;
                }
            }, (Function1) null, new Function0() { // from class: com.qiahao.nextvideo.ui.setting.k0
                public final Object invoke() {
                    Unit confirmTipViewControllerDidConfirm$lambda$49$lambda$48;
                    confirmTipViewControllerDidConfirm$lambda$49$lambda$48 = SettingViewController.confirmTipViewControllerDidConfirm$lambda$49$lambda$48(SettingViewController.this);
                    return confirmTipViewControllerDidConfirm$lambda$49$lambda$48;
                }
            }, false, 10, (Object) null), settingViewController.getCompositeDisposable());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$49$lambda$47(SettingViewController settingViewController, Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        settingViewController.getBinding().cacheSizeTextView.setText(String.valueOf(l.longValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$49$lambda$48(SettingViewController settingViewController) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, settingViewController.getContext(), BaseViewControllerKt.getString(settingViewController, 2131954177, new Object[0]), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectedLogButtonPressed() {
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            Boolean isAgentMgr = user.isAgentMgr();
            Boolean bool = Boolean.TRUE;
            if (Intrinsics.areEqual(isAgentMgr, bool)) {
                NavigationHelper.jump$default(NavigationHelper.INSTANCE, (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "mgrGuildDataUrl", "", (String) null, 4, (Object) null), (SuperCallBack) null, 2, (Object) null);
            } else if (Intrinsics.areEqual(user.isTradeUnion(), bool)) {
                NavigationHelper.jump$default(NavigationHelper.INSTANCE, (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "guildDataUrl", "", (String) null, 4, (Object) null), (SuperCallBack) null, 2, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exitAccountButtonPressed() {
        UserStore.INSTANCE.getShared().logout();
    }

    private final void judgeIsDealer() {
        final AppCompatTextView appCompatTextView = getBinding().transferButton;
        final long j = 800;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$judgeIsDealer$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean z;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    TransferActivity.Companion companion = TransferActivity.INSTANCE;
                    Context requireContext = this.getRequireContext();
                    z = this.mHasInvite;
                    companion.start(requireContext, z);
                }
            }
        });
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getIsDealer(), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.c0
            public final Object invoke(Object obj) {
                Unit judgeIsDealer$lambda$27;
                judgeIsDealer$lambda$27 = SettingViewController.judgeIsDealer$lambda$27(SettingViewController.this, (ApiResponse) obj);
                return judgeIsDealer$lambda$27;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.d0
            public final Object invoke(Object obj) {
                Unit judgeIsDealer$lambda$28;
                judgeIsDealer$lambda$28 = SettingViewController.judgeIsDealer$lambda$28((Throwable) obj);
                return judgeIsDealer$lambda$28;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit judgeIsDealer$lambda$27(SettingViewController settingViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        IsDealerBean isDealerBean = (IsDealerBean) apiResponse.getData();
        if (isDealerBean != null) {
            settingViewController.mHasInvite = isDealerBean.getHasInvite();
            if (isDealerBean.getIsdl()) {
                settingViewController.getBinding().llTransfer.setVisibility(0);
            } else {
                settingViewController.getBinding().llTransfer.setVisibility(8);
            }
            PromoteData pt = isDealerBean.getPt();
            if (pt != null) {
                settingViewController.getBinding().promoteLayout.setVisibility(0);
                settingViewController.mPromoter = pt;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit judgeIsDealer$lambda$28(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void matchingNotificationSwitchViewPressed(final boolean isChecked) {
        int i;
        ServerApi apis = AppServer.INSTANCE.getApis();
        if (isChecked) {
            i = 1;
        } else {
            i = 2;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.tradeUnionNotification(i), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.h0
            public final Object invoke(Object obj) {
                Unit matchingNotificationSwitchViewPressed$lambda$45;
                matchingNotificationSwitchViewPressed$lambda$45 = SettingViewController.matchingNotificationSwitchViewPressed$lambda$45(SettingViewController.this, isChecked, (ApiResponse) obj);
                return matchingNotificationSwitchViewPressed$lambda$45;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.i0
            public final Object invoke(Object obj) {
                Unit matchingNotificationSwitchViewPressed$lambda$46;
                matchingNotificationSwitchViewPressed$lambda$46 = SettingViewController.matchingNotificationSwitchViewPressed$lambda$46(SettingViewController.this, isChecked, (Throwable) obj);
                return matchingNotificationSwitchViewPressed$lambda$46;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit matchingNotificationSwitchViewPressed$lambda$45(SettingViewController settingViewController, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (!apiResponse.isOk()) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, settingViewController.getContext(), BaseViewControllerKt.getString(settingViewController, 2131952667, new Object[0]), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            settingViewController.getBinding().matchingNotificationSwitchView.setCheckedImmediatelyNoEvent(!z);
            return Unit.INSTANCE;
        }
        Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, settingViewController.getContext(), BaseViewControllerKt.getString(settingViewController, 2131954177, new Object[0]), false, 4, (Object) null);
        if (normal$default2 != null) {
            normal$default2.show();
        }
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user == null) {
            return Unit.INSTANCE;
        }
        UserStore shared = companion.getShared();
        user.setTradeUnionMatchNotification(Boolean.valueOf(z));
        UserStore.refreshUserInfo$default(shared, user, null, null, true, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit matchingNotificationSwitchViewPressed$lambda$46(SettingViewController settingViewController, boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, settingViewController.getContext(), BaseViewControllerKt.getString(settingViewController, 2131952667, new Object[0]), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        settingViewController.getBinding().matchingNotificationSwitchView.setCheckedImmediatelyNoEvent(!z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void platformPolicyButtonPressed() {
        ViewController.present$default(this, new PlatformProtocalViewController(), true, null, 4, null);
    }

    private final void startUpload(final ArrayList<File> files) {
        String str;
        Toast normal$default;
        if (files.isEmpty()) {
            dismissProgressDialog();
            return;
        }
        if (!files.get(0).exists()) {
            dismissProgressDialog();
            Context context = getContext();
            if (context != null && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, BaseViewControllerKt.getString(this, 2131952667, new Object[0]), false, 4, (Object) null)) != null) {
                normal$default.show();
                return;
            }
            return;
        }
        AliCloudService shared = AliCloudService.INSTANCE.getShared();
        File file = files.get(0);
        Intrinsics.checkNotNullExpressionValue(file, "get(...)");
        File file2 = file;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getCode()) == null) {
            str = "000000";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.uploadAgoraFileToAWS(AliCloudService.OSS_FOLDER_AGOR_UNION, file2, str), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.f0
            public final Object invoke(Object obj) {
                Unit startUpload$lambda$40;
                startUpload$lambda$40 = SettingViewController.startUpload$lambda$40(files, this, (Pair) obj);
                return startUpload$lambda$40;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.g0
            public final Object invoke(Object obj) {
                Unit startUpload$lambda$41;
                startUpload$lambda$41 = SettingViewController.startUpload$lambda$41(SettingViewController.this, (Throwable) obj);
                return startUpload$lambda$41;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUpload$lambda$40(ArrayList arrayList, SettingViewController settingViewController, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            Log.d(TAG, "startUpload: 返回的路径信息" + pair.getSecond());
            arrayList.remove(0);
            if (arrayList.isEmpty()) {
                settingViewController.getBinding().commitAgoraLog.setVisibility(8);
                settingViewController.dismissProgressDialog();
                return Unit.INSTANCE;
            }
            settingViewController.startUpload(arrayList);
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, settingViewController.getContext(), BaseViewControllerKt.getString(settingViewController, 2131952667, new Object[0]), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            settingViewController.dismissProgressDialog();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUpload$lambda$41(SettingViewController settingViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = settingViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = BaseViewControllerKt.getString(settingViewController, 2131952667, new Object[0]);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        settingViewController.dismissProgressDialog();
        return Unit.INSTANCE;
    }

    private final void startUploadOperationLog(final ArrayList<File> files) {
        String str;
        Toast normal$default;
        if (files.isEmpty()) {
            return;
        }
        if (!files.get(0).exists()) {
            Context context = getContext();
            if (context != null && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, BaseViewControllerKt.getString(this, 2131952667, new Object[0]), false, 4, (Object) null)) != null) {
                normal$default.show();
                return;
            }
            return;
        }
        AliCloudService shared = AliCloudService.INSTANCE.getShared();
        File file = files.get(0);
        Intrinsics.checkNotNullExpressionValue(file, "get(...)");
        File file2 = file;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getCode()) == null) {
            str = "000000";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.uploadOperationFileToAWS(AliCloudService.OSS_FOLDER_OPERATION_UNION, file2, str), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.t
            public final Object invoke(Object obj) {
                Unit startUploadOperationLog$lambda$36;
                startUploadOperationLog$lambda$36 = SettingViewController.startUploadOperationLog$lambda$36(files, this, (Pair) obj);
                return startUploadOperationLog$lambda$36;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.e0
            public final Object invoke(Object obj) {
                Unit startUploadOperationLog$lambda$37;
                startUploadOperationLog$lambda$37 = SettingViewController.startUploadOperationLog$lambda$37(SettingViewController.this, (Throwable) obj);
                return startUploadOperationLog$lambda$37;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUploadOperationLog$lambda$36(ArrayList arrayList, SettingViewController settingViewController, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "it");
        if (((Boolean) pair.getFirst()).booleanValue()) {
            Log.d(TAG, "startUpload: 返回的路径信息" + pair.getSecond());
            arrayList.remove(0);
            if (arrayList.isEmpty()) {
                settingViewController.getBinding().commitOperationLog.setVisibility(8);
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, settingViewController.getContext(), BaseViewControllerKt.getString(settingViewController, 2131954176, new Object[0]), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
                settingViewController.dismissProgressDialog();
                return Unit.INSTANCE;
            }
            settingViewController.startUploadOperationLog(arrayList);
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, settingViewController.getContext(), BaseViewControllerKt.getString(settingViewController, 2131952667, new Object[0]), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
            settingViewController.dismissProgressDialog();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startUploadOperationLog$lambda$37(SettingViewController settingViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = settingViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = BaseViewControllerKt.getString(settingViewController, 2131952667, new Object[0]);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        settingViewController.dismissProgressDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadAgoraLog() {
        ArrayList<File> arrayList;
        File[] listFiles;
        File externalFilesDir = getBinding().commitAgoraLog.getContext().getExternalFilesDir("");
        if (externalFilesDir != null && (listFiles = externalFilesDir.listFiles()) != null) {
            arrayList = new ArrayList<>();
            for (File file : listFiles) {
                if (this.listName.contains(file.getName())) {
                    arrayList.add(file);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            DebugToolsKt.printfE("上传声网文件为空");
        } else {
            showProgressDialog("");
            startUpload(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadOperationLog() {
        File[] listFiles;
        File[] listFiles2;
        FileManager fileManager = FileManager.INSTANCE;
        File file = new File(fileManager.getCacheFilePrinter());
        Context context = getBinding().commitAgoraLog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String sudFile = fileManager.getSudFile(context);
        Context context2 = getBinding().commitAgoraLog.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        String tIMFile = fileManager.getTIMFile(context2);
        ArrayList<File> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (file.exists()) {
            File[] listFiles3 = file.listFiles();
            if (listFiles3 != null) {
                ArrayList arrayList3 = new ArrayList();
                for (File file2 : listFiles3) {
                    arrayList3.add(file2);
                }
                arrayList.addAll(arrayList3);
            }
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), "files not exists", false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        File file3 = new File(sudFile);
        if (file3.exists() && (listFiles2 = file3.listFiles()) != null) {
            ArrayList arrayList4 = new ArrayList();
            for (File file4 : listFiles2) {
                arrayList4.add(file4);
            }
            arrayList.addAll(arrayList4);
        }
        for (int i = 0; i < 6; i++) {
            File file5 = new File(sudFile + File.separator + ("SudMGP_" + com.qiahao.base_common.utils.f.f(new Date().getTime() - (i * Constants.CLIENT_FLUSH_INTERVAL), com.qiahao.base_common.utils.f.g) + "_com.qiahao.nextvideo.txt"));
            if (file5.exists()) {
                arrayList.add(file5);
            }
        }
        File file6 = new File(tIMFile);
        if (file6.exists() && (listFiles = file6.listFiles()) != null) {
            ArrayList arrayList5 = new ArrayList();
            for (File file7 : listFiles) {
                arrayList5.add(file7);
            }
            arrayList2.addAll(arrayList5);
        }
        for (int i2 = 0; i2 < 6; i2++) {
            File file8 = new File(tIMFile + File.separator + ("imsdk_C_" + com.qiahao.base_common.utils.f.f(new Date().getTime() - (i2 * Constants.CLIENT_FLUSH_INTERVAL), com.qiahao.base_common.utils.f.h) + ".xlog"));
            if (file8.exists()) {
                arrayList.add(file8);
            }
        }
        if (arrayList.isEmpty()) {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, getContext(), "no has file", false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
                return;
            }
            return;
        }
        showProgressDialog("");
        startUploadOperationLog(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$1(SettingViewController settingViewController, int i, int i2) {
        settingViewController.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$23(SettingViewController settingViewController, View view) {
        if (System.currentTimeMillis() - settingViewController.time < 1500) {
            settingViewController.time = System.currentTimeMillis();
            settingViewController.moreTouch++;
        } else {
            settingViewController.time = System.currentTimeMillis();
            settingViewController.moreTouch = 1;
        }
        if (settingViewController.moreTouch >= 5) {
            settingViewController.moreTouch = 1;
            settingViewController.getBinding().commitAgoraLog.setVisibility(0);
            settingViewController.getBinding().commitOperationLog.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean viewDidLoad$lambda$5(SettingViewController settingViewController, View view, MotionEvent motionEvent) {
        if (settingViewController.getNotificationManagerCompat().a()) {
            return false;
        }
        ConfirmPreloadModel init = ConfirmPreloadModel.INSTANCE.init(BaseViewControllerKt.getString(settingViewController, 2131954558, new Object[0]), BaseViewControllerKt.getString(settingViewController, 2131952917, new Object[0]), BaseViewControllerKt.getString(settingViewController, 2131952171, new Object[0]));
        init.setFromCode(9);
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(init, null, 2, null);
        confirmTipViewController.setDelegate(settingViewController);
        ViewController.present$default(settingViewController, confirmTipViewController, true, null, 4, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$7(CompoundButton compoundButton, boolean z) {
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "open_gift_banner", Boolean.valueOf(z), (String) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$8(SettingViewController settingViewController, io.reactivex.rxjava3.core.b0 b0Var) {
        Intrinsics.checkNotNullParameter(b0Var, "e");
        FileManager fileManager = FileManager.INSTANCE;
        File cacheDir = settingViewController.getRequireActivity().getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
        b0Var.onNext(fileManager.readableFileSize(fileManager.getDirSize(cacheDir)));
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(final int fromCode, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.setting.l0
            public final Object invoke() {
                Unit confirmTipViewControllerDidConfirm$lambda$49;
                confirmTipViewControllerDidConfirm$lambda$49 = SettingViewController.confirmTipViewControllerDidConfirm$lambda$49(fromCode, this);
                return confirmTipViewControllerDidConfirm$lambda$49;
            }
        });
    }

    @NotNull
    public final ViewControllerSettingNativeBinding getBinding() {
        ViewControllerSettingNativeBinding viewControllerSettingNativeBinding = this.binding;
        if (viewControllerSettingNativeBinding != null) {
            return viewControllerSettingNativeBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final ArrayList<String> getListName() {
        return this.listName;
    }

    @Nullable
    public final ControllerListener getMListener() {
        return this.mListener;
    }

    public final int getMoreTouch() {
        return this.moreTouch;
    }

    @NotNull
    public final androidx.core.app.r getNotificationManagerCompat() {
        androidx.core.app.r rVar = this.notificationManagerCompat;
        if (rVar != null) {
            return rVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("notificationManagerCompat");
        return null;
    }

    public final long getTime() {
        return this.time;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerSettingNativeBinding viewControllerSettingNativeBinding = (ViewControllerSettingNativeBinding) androidx.databinding.g.h(inflater, R.layout.view_controller_setting_native, container, false);
        setBinding(viewControllerSettingNativeBinding);
        View root = viewControllerSettingNativeBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void setBinding(@NotNull ViewControllerSettingNativeBinding viewControllerSettingNativeBinding) {
        Intrinsics.checkNotNullParameter(viewControllerSettingNativeBinding, "<set-?>");
        this.binding = viewControllerSettingNativeBinding;
    }

    public final void setListName(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.listName = arrayList;
    }

    public final void setMListener(@Nullable ControllerListener controllerListener) {
        this.mListener = controllerListener;
    }

    public final void setMoreTouch(int i) {
        this.moreTouch = i;
    }

    public final void setNotificationManagerCompat(@NotNull androidx.core.app.r rVar) {
        Intrinsics.checkNotNullParameter(rVar, "<set-?>");
        this.notificationManagerCompat = rVar;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @SuppressLint({"ClickableViewAccessibility"})
    public void viewDidLoad(@NotNull View view) {
        boolean a;
        ArrayList<Integer> arrayList;
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        View view2 = getBinding().titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view2, "bar");
        requireActivity.getStatusBarTopOrBottom(view2, new Function2() { // from class: com.qiahao.nextvideo.ui.setting.m0
            public final Object invoke(Object obj, Object obj2) {
                Unit viewDidLoad$lambda$1;
                viewDidLoad$lambda$1 = SettingViewController.viewDidLoad$lambda$1(SettingViewController.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return viewDidLoad$lambda$1;
            }
        });
        getBinding().titleBar.linearLayout.setBackgroundColor(androidx.core.content.a.getColor(getRequireContext(), 2131101214));
        getBinding().titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131954065));
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            Boolean isTradeUnion = user.isTradeUnion();
            Boolean bool = Boolean.FALSE;
            if (Intrinsics.areEqual(isTradeUnion, bool) && Intrinsics.areEqual(user.isAgentMgr(), bool)) {
                getBinding().connectedLogButton.setVisibility(8);
                getBinding().connectedLogButtonDivideView.setVisibility(8);
            }
            if (Intrinsics.areEqual(user.isTradeUnion(), bool)) {
                getBinding().matchNotificationContainer.setVisibility(8);
                getBinding().matchNotificationContainerDivideView.setVisibility(8);
            }
        }
        setNotificationManagerCompat(androidx.core.app.r.d(getRequireContext()));
        SwitchButton switchButton = getBinding().matchingNotificationSwitchView;
        if (getNotificationManagerCompat().a()) {
            a = companion.getShared().hasMatchingNotificationOpened();
        } else {
            a = getNotificationManagerCompat().a();
        }
        switchButton.setChecked(a);
        getBinding().matchingNotificationSwitchView.setOnTouchListener(new View.OnTouchListener() { // from class: com.qiahao.nextvideo.ui.setting.r0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                boolean viewDidLoad$lambda$5;
                viewDidLoad$lambda$5 = SettingViewController.viewDidLoad$lambda$5(SettingViewController.this, view3, motionEvent);
                return viewDidLoad$lambda$5;
            }
        });
        getBinding().matchingNotificationSwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.ui.setting.s0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettingViewController.this.matchingNotificationSwitchViewPressed(z);
            }
        });
        getBinding().giftBannerSwitchView.setChecked(((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "open_gift_banner", Boolean.TRUE, (String) null, 4, (Object) null)).booleanValue());
        getBinding().giftBannerSwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.qiahao.nextvideo.ui.setting.u
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SettingViewController.viewDidLoad$lambda$7(compoundButton, z);
            }
        });
        BinderThirdType binderThirdType = BinderThirdType.INSTANCE;
        User user2 = companion.getShared().getUser();
        if (user2 != null) {
            arrayList = user2.getThirdList();
        } else {
            arrayList = null;
        }
        if (binderThirdType.isBinderPhone(arrayList)) {
            getBinding().changePassword.setVisibility(0);
            getBinding().changePasswordDivideView.setVisibility(0);
        } else {
            getBinding().changePassword.setVisibility(8);
            getBinding().changePasswordDivideView.setVisibility(8);
        }
        getBinding().commitStarButton.setText(((Object) getBinding().commitStarButton.getText()) + " 4.41.0");
        RxJava.INSTANCE.rx(new io.reactivex.rxjava3.core.c0() { // from class: com.qiahao.nextvideo.ui.setting.v
            public final void a(io.reactivex.rxjava3.core.b0 b0Var) {
                SettingViewController.viewDidLoad$lambda$8(SettingViewController.this, b0Var);
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$7
            public final void accept(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                SettingViewController.this.getBinding().cacheSizeTextView.setText(str);
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$8
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                SettingViewController.this.getBinding().cacheSizeTextView.setText(MessageService.MSG_DB_READY_REPORT);
            }
        });
        getBinding().clearCacheButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.cacheSizeTextViewPressed();
            }
        });
        final AppCompatTextView appCompatTextView = getBinding().blockedUsersButton;
        final long j = 800;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    BlockedUserListActivity.Companion.start(this.getRequireContext());
                }
            }
        });
        getBinding().connectedLogButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.connectedLogButtonPressed();
            }
        });
        getBinding().commitStarButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.commitStarButtonPressed();
            }
        });
        getBinding().commitSuggestButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.commitSuggestButtonPressed();
            }
        });
        getBinding().exitAccountButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.exitAccountButtonPressed();
            }
        });
        getBinding().platformPolicyButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.platformPolicyButtonPressed();
            }
        });
        final AppCompatImageView appCompatImageView = getBinding().titleBar.backImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    ControllerListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.onBackPress();
                    }
                }
            }
        });
        getBinding().commitAgoraLog.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.uploadAgoraLog();
            }
        });
        getBinding().commitOperationLog.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.this.uploadOperationLog();
            }
        });
        final FrameLayout frameLayout = getBinding().account;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.getRequireActivity().startActivity(new Intent(this.getRequireContext(), (Class<?>) AccountActivity.class));
                }
            }
        });
        final AppCompatTextView appCompatTextView2 = getBinding().promoterButton;
        appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView2) > j || (appCompatTextView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView2, currentTimeMillis);
                    AppCompatTextView appCompatTextView3 = appCompatTextView2;
                    PromoterActivity.INSTANCE.start(this.getRequireContext());
                }
            }
        });
        final FrameLayout frameLayout2 = getBinding().changePassword;
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                FragmentManager fragmentManager;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout2) > j || (frameLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout2, currentTimeMillis);
                    this.getBinding().loginFrameLayout.setVisibility(0);
                    VerificationCodeFragment verificationCodeFragment = new VerificationCodeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("type", VerificationCodeFragment.TYPE_FORGOT_PASSWORD);
                    verificationCodeFragment.setArguments(bundle);
                    FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
                    HiloBaseActivity hiloBaseActivity = this.get_activity();
                    if (hiloBaseActivity != null) {
                        fragmentManager = hiloBaseActivity.getSupportFragmentManager();
                    } else {
                        fragmentManager = null;
                    }
                    fragmentUtils.addFragmentBackStack(fragmentManager, R.id.loginFrameLayout, verificationCodeFragment, VerificationCodeFragment.TYPE_FORGOT_PASSWORD);
                }
            }
        });
        final FrameLayout frameLayout3 = getBinding().notificationSetting;
        frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.SettingViewController$viewDidLoad$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout3) > j || (frameLayout3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout3, currentTimeMillis);
                    BaseActivity activity = HiloUtils.INSTANCE.getActivity(this.getContext());
                    if (activity != null) {
                        AppUtilitiesKt.toAppSetting(activity);
                    }
                }
            }
        });
        getBinding().titleBar.title.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.setting.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SettingViewController.viewDidLoad$lambda$23(SettingViewController.this, view3);
            }
        });
        judgeIsDealer();
    }
}
