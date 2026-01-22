package com.qiahao.nextvideo.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cf.m;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.support.ActivityLifecycleListener;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.eventBus.ChatRoomStatusEvent;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeData;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeDataList;
import com.qiahao.nextvideo.data.mainActivity.MainActivityData;
import com.qiahao.nextvideo.data.model.MainListData;
import com.qiahao.nextvideo.data.model.OpenScreenBean;
import com.qiahao.nextvideo.data.model.VipDailyDiamondBean;
import com.qiahao.nextvideo.data.service.OutPutOtherModuleService;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.SplashService;
import com.qiahao.nextvideo.data.service.TIMService;
import com.qiahao.nextvideo.databinding.ActivityMainBinding;
import com.qiahao.nextvideo.databinding.SplashAdvertisingViewBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.service.ChatRoomServer;
import com.qiahao.nextvideo.service.ChatRoomServiceConnection;
import com.qiahao.nextvideo.service.IChatRoomService;
import com.qiahao.nextvideo.ui.authentication.AuthenticationActivity;
import com.qiahao.nextvideo.ui.firstCharge.FirstChargeDialog;
import com.qiahao.nextvideo.ui.home.DailyOperatingDialog;
import com.qiahao.nextvideo.ui.home.HomeFragment;
import com.qiahao.nextvideo.ui.mainActivity.MainActivityDialog;
import com.qiahao.nextvideo.ui.vip.DailyRewardDialog;
import com.qiahao.nextvideo.utilities.ActivityUtilKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.OnlyOneDialogUtil;
import com.taobao.accs.messenger.MessengerService;
import io.reactivex.rxjava3.core.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0015¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010)\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\t0\t0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\"\u00101\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/qiahao/nextvideo/app/MainActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityMainBinding;", "<init>", "()V", "", "setupObserver", "showSplashView", "hideSplashView", "", "animated", "isShowCover", "presentAuthenticationController", "(ZZ)V", "", "getLayoutResId", "()I", "Landroid/content/Intent;", MessengerService.INTENT, "onNewIntent", "(Landroid/content/Intent;)V", "onInitialize", "initView", "onResume", "onDestroy", "showAllList", "Lcom/qiahao/base_common/model/eventBus/ChatRoomStatusEvent;", "event", "onRoomStatusEvent", "(Lcom/qiahao/base_common/model/eventBus/ChatRoomStatusEvent;)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "Lcom/qiahao/nextvideo/service/ChatRoomServiceConnection;", "connection", "Lcom/qiahao/nextvideo/service/ChatRoomServiceConnection;", "Lcom/qiahao/nextvideo/ui/home/HomeFragment;", "homeFragment", "Lcom/qiahao/nextvideo/ui/home/HomeFragment;", "Lla/b;", "kotlin.jvm.PlatformType", "mainViewInit", "Lla/b;", "Lcom/qiahao/nextvideo/ui/home/DailyOperatingDialog;", "mDailyDialog", "Lcom/qiahao/nextvideo/ui/home/DailyOperatingDialog;", "Lcom/qiahao/nextvideo/app/AdvertisingContentView;", "mAdvertisingContentView", "Lcom/qiahao/nextvideo/app/AdvertisingContentView;", "hasAddRoot", "Z", "getHasAddRoot", "()Z", "setHasAddRoot", "(Z)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainActivity.kt\ncom/qiahao/nextvideo/app/MainActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,366:1\n1869#2,2:367\n*S KotlinDebug\n*F\n+ 1 MainActivity.kt\ncom/qiahao/nextvideo/app/MainActivity\n*L\n292#1:367,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MainActivity extends HiloBaseBindingActivity<ActivityMainBinding> {

    @NotNull
    public static final String TAG = "MainActivity";

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    @Nullable
    private ChatRoomServiceConnection connection;
    private boolean hasAddRoot;

    @Nullable
    private HomeFragment homeFragment;

    @Nullable
    private AdvertisingContentView mAdvertisingContentView;

    @Nullable
    private DailyOperatingDialog mDailyDialog;

    @NotNull
    private final la.b mainViewInit;

    public MainActivity() {
        la.b e = la.b.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.mainViewInit = e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void hideSplashView() {
        ((ActivityMainBinding) getBinding()).bgLaunchImageView.setVisibility(8);
        AdvertisingContentView advertisingContentView = this.mAdvertisingContentView;
        if (advertisingContentView != null) {
            advertisingContentView.hide();
        }
        ActivityUtilKt.setSystemBarsVisibility(this, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$2(MainActivity mainActivity) {
        mainActivity.compositeDisposable.d();
        if (mainActivity.getSupportFragmentManager().isStateSaved()) {
            mainActivity.finish();
            return;
        }
        HomeFragment homeFragment = new HomeFragment();
        mainActivity.homeFragment = homeFragment;
        FragmentUtils.INSTANCE.addFragment(mainActivity.getSupportFragmentManager(), R.id.activity_main_container, homeFragment, HomeFragment.TAG);
        mainActivity.setupObserver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void presentAuthenticationController(boolean animated, boolean isShowCover) {
        Intent intent = new Intent((Context) this, (Class<?>) AuthenticationActivity.class);
        intent.putExtra("keyPreloadModel", isShowCover);
        startActivity(intent);
        if (!animated) {
            overridePendingTransition(0, 0);
        }
    }

    private final void setupObserver() {
        nd.c subscribe = this.mainViewInit.observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.app.MainActivity$setupObserver$1
            public final void accept(Boolean bool) {
                nd.a aVar;
                if (MainActivity.this.getHasAddRoot()) {
                    return;
                }
                MainActivity.this.setHasAddRoot(true);
                try {
                    MainActivity.this.hideSplashView();
                    UserStore.Companion companion = UserStore.INSTANCE;
                    UserStore.fetchUserDetailInfo$default(companion.getShared(), false, 1, null);
                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "是否第一次安装：" + IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "FirstOpenAppAndLogin", Boolean.TRUE, (String) null, 4, (Object) null), false, 4, (Object) null);
                    if (!companion.getShared().isAuthenticated()) {
                        MainActivity.this.presentAuthenticationController(false, true);
                    } else {
                        Log.d(MainActivity.TAG, "onResume: HiloApplication.isDailyOneRequest " + HiloApplication.INSTANCE.isDailyOneRequest());
                        MainActivity.this.showAllList();
                    }
                    SplashService.Companion companion2 = SplashService.INSTANCE;
                    companion2.getShared().gotoDownloadGlobalOpenSource();
                    z observeOn = companion2.getShared().getImSDkLoginBehaviorRelay().observeOn(RxUtilsKt.getMainThread());
                    final MainActivity mainActivity = MainActivity.this;
                    nd.c subscribe2 = observeOn.subscribe(new pd.g() { // from class: com.qiahao.nextvideo.app.MainActivity$setupObserver$1.1
                        public final void accept(Boolean bool2) {
                            if (bool2.booleanValue()) {
                                SplashService.Companion companion3 = SplashService.INSTANCE;
                                if (companion3.getMAdvertisingH5().length() > 0) {
                                    Log.d(MainActivity.TAG, "LevelShowActivity1111 " + companion3.getMAdvertisingH5());
                                    NavigationHelper.jump$default(NavigationHelper.INSTANCE, companion3.getMAdvertisingH5(), (SuperCallBack) null, 2, (Object) null);
                                    companion3.setMAdvertisingH5("");
                                    return;
                                }
                                if (companion3.getMGroupId().length() > 0) {
                                    Log.d(MainActivity.TAG, "LevelShowActivity1111 " + companion3.getMGroupId());
                                    MainActivity.this.openRoom(companion3.getMGroupId(), 6);
                                    companion3.setMGroupId("");
                                }
                            }
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
                    aVar = MainActivity.this.compositeDisposable;
                    RxUtilsKt.addTo(subscribe2, aVar);
                } catch (Exception e) {
                    DebugToolsKt.printfE(MainActivity.TAG, "agoraServiceStateRelay内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.app.MainActivity$setupObserver$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                DebugToolsKt.printfE(MainActivity.TAG, th.getLocalizedMessage());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        nd.c subscribe2 = UserStore.INSTANCE.getShared().getUserObjectRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new MainActivity$setupObserver$3(this), new pd.g() { // from class: com.qiahao.nextvideo.app.MainActivity$setupObserver$4
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
                DebugToolsKt.printfE(MainActivity.TAG, th.getLocalizedMessage());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAllList$lambda$10(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MainActivityData mainActivityData = (MainActivityData) apiResponse.getData();
        if (mainActivityData != null) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "main_activity_data", BaseApplication.Companion.getGSON().s(mainActivityData), (String) null, 4, (Object) null);
            cf.c.c().l(new EventBusKey("REFRESH_HOME_MAIN_ACTIVITY", (Object) null, 2, (DefaultConstructorMarker) null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAllList$lambda$11(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showAllList$lambda$7(MainActivity mainActivity, ApiResponse apiResponse) {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<MainListData> list = (List) apiResponse.getData();
        if (list != null) {
            for (MainListData mainListData : list) {
                String moduleType = mainListData.getModuleType();
                if (moduleType != null) {
                    switch (moduleType.hashCode()) {
                        case 970292526:
                            if (moduleType.equals(MainListData.DAILY_DIAMOND)) {
                                com.google.gson.d gson = BaseApplication.Companion.getGSON();
                                String moduleData = mainListData.getModuleData();
                                if (moduleData == null) {
                                    moduleData = "";
                                }
                                VipDailyDiamondBean vipDailyDiamondBean = (VipDailyDiamondBean) gson.j(moduleData, VipDailyDiamondBean.class);
                                if (vipDailyDiamondBean.getFlag()) {
                                    OnlyOneDialogUtil onlyOneDialogUtil = OnlyOneDialogUtil.INSTANCE;
                                    BaseBindingDialog dailyRewardDialog = new DailyRewardDialog(vipDailyDiamondBean.isVip(), vipDailyDiamondBean.getDiamondNum(), vipDailyDiamondBean.getMatchCardNum(), mainActivity);
                                    String moduleData2 = mainListData.getModuleData();
                                    if (moduleData2 == null) {
                                        str = "";
                                    } else {
                                        str = moduleData2;
                                    }
                                    OnlyOneDialogUtil.addDialog$default(onlyOneDialogUtil, dailyRewardDialog, null, str, 2, null);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        case 1678799304:
                            if (moduleType.equals(MainListData.OPERATION_WINDOW)) {
                                com.google.gson.d gson2 = BaseApplication.Companion.getGSON();
                                String moduleData3 = mainListData.getModuleData();
                                if (moduleData3 == null) {
                                    moduleData3 = "";
                                }
                                OpenScreenBean openScreenBean = (OpenScreenBean) gson2.j(moduleData3, OpenScreenBean.class);
                                OnlyOneDialogUtil onlyOneDialogUtil2 = OnlyOneDialogUtil.INSTANCE;
                                Intrinsics.checkNotNull(openScreenBean);
                                BaseBindingDialog dailyOperatingDialog = new DailyOperatingDialog(mainActivity, openScreenBean);
                                String moduleData4 = mainListData.getModuleData();
                                if (moduleData4 == null) {
                                    str2 = "";
                                } else {
                                    str2 = moduleData4;
                                }
                                OnlyOneDialogUtil.addDialog$default(onlyOneDialogUtil2, dailyOperatingDialog, null, str2, 2, null);
                                break;
                            } else {
                                break;
                            }
                        case 1811960314:
                            if (moduleType.equals(MainListData.POPUP_CHARGE_ACT)) {
                                com.google.gson.d gson3 = BaseApplication.Companion.getGSON();
                                String moduleData5 = mainListData.getModuleData();
                                if (moduleData5 == null) {
                                    moduleData5 = "";
                                }
                                MainActivityData mainActivityData = (MainActivityData) gson3.j(moduleData5, MainActivityData.class);
                                OnlyOneDialogUtil onlyOneDialogUtil3 = OnlyOneDialogUtil.INSTANCE;
                                Intrinsics.checkNotNull(mainActivityData);
                                BaseBindingDialog mainActivityDialog = new MainActivityDialog(mainActivity, mainActivityData);
                                String moduleData6 = mainListData.getModuleData();
                                if (moduleData6 == null) {
                                    str3 = "";
                                } else {
                                    str3 = moduleData6;
                                }
                                OnlyOneDialogUtil.addDialog$default(onlyOneDialogUtil3, mainActivityDialog, null, str3, 2, null);
                                break;
                            } else {
                                break;
                            }
                        case 1921019890:
                            if (moduleType.equals(MainListData.ACT_CHARGE_FIRST)) {
                                com.google.gson.d gson4 = BaseApplication.Companion.getGSON();
                                String moduleData7 = mainListData.getModuleData();
                                if (moduleData7 == null) {
                                    moduleData7 = "";
                                }
                                ArrayList<FirstChargeData> list2 = ((FirstChargeDataList) gson4.j(moduleData7, FirstChargeDataList.class)).getList();
                                if (list2 != null) {
                                    OnlyOneDialogUtil onlyOneDialogUtil4 = OnlyOneDialogUtil.INSTANCE;
                                    BaseBindingDialog firstChargeDialog = new FirstChargeDialog(list2, false, mainActivity);
                                    String moduleData8 = mainListData.getModuleData();
                                    if (moduleData8 == null) {
                                        str4 = "";
                                    } else {
                                        str4 = moduleData8;
                                    }
                                    OnlyOneDialogUtil.addDialog$default(onlyOneDialogUtil4, firstChargeDialog, null, str4, 2, null);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAllList$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        LogUtil logUtil = LogUtil.INSTANCE;
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        LogUtil.e$default(logUtil, "eTag", message, false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void showSplashView() {
        View view;
        SplashAdvertisingViewBinding binding;
        ActivityUtilKt.setSystemBarsVisibility(this, false, false);
        if (Build.VERSION.SDK_INT >= 28) {
            q6.c.a(getWindow().getAttributes(), 1);
        }
        ((ActivityMainBinding) getBinding()).bgLaunchImageView.setVisibility(0);
        FrameLayout frameLayout = ((ActivityMainBinding) getBinding()).contentBg;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "contentBg");
        this.mAdvertisingContentView = new AdvertisingContentView(frameLayout, this.mainViewInit);
        FrameLayout frameLayout2 = ((ActivityMainBinding) getBinding()).contentBg;
        AdvertisingContentView advertisingContentView = this.mAdvertisingContentView;
        if (advertisingContentView != null && (binding = advertisingContentView.getBinding()) != null) {
            view = binding.getRoot();
        } else {
            view = null;
        }
        frameLayout2.addView(view);
        AdvertisingContentView advertisingContentView2 = this.mAdvertisingContentView;
        if (advertisingContentView2 != null) {
            advertisingContentView2.show();
        }
        HiloApplication.INSTANCE.setMainActivityInited(true);
    }

    public final boolean getHasAddRoot() {
        return this.hasAddRoot;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    public final void initView() {
        ActivityLifecycleManager.INSTANCE.setActivityLifecycleListener(new ActivityLifecycleListener() { // from class: com.qiahao.nextvideo.app.MainActivity$initView$1
            public void onAppBackground() {
                ActivityLifecycleListener.DefaultImpls.onAppBackground(this);
                TIMService.INSTANCE.updateChatPushStatus(false);
            }

            public void onAppForeground() {
                ActivityLifecycleListener.DefaultImpls.onAppForeground(this);
                TIMService.INSTANCE.updateChatPushStatus(true);
            }
        });
        setStatusBarIconColor(false);
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(HomeFragment.TAG);
        if (findFragmentByTag != null) {
            FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            fragmentUtils.removeFragment(supportFragmentManager, findFragmentByTag);
        }
        getBinding().getRoot().post(new Runnable() { // from class: com.qiahao.nextvideo.app.f
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.initView$lambda$2(MainActivity.this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    protected void onDestroy() {
        this.compositeDisposable.d();
        ChatRoomServiceConnection chatRoomServiceConnection = this.connection;
        if (chatRoomServiceConnection != null) {
            unbindService(chatRoomServiceConnection);
            IChatRoomService iChatRoomService = chatRoomServiceConnection.getIChatRoomService();
            if (iChatRoomService != null) {
                iChatRoomService.onNotificationState(false);
            }
            chatRoomServiceConnection.setIChatRoomService(null);
        }
        this.connection = null;
        ActivityLifecycleManager.INSTANCE.setActivityLifecycleListener((ActivityLifecycleListener) null);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        getWindow().addFlags(128);
        super.onInitialize();
        HiloApplication.Companion companion = HiloApplication.INSTANCE;
        if (companion.getMainActivityInited()) {
            this.mainViewInit.accept(Boolean.TRUE);
        } else {
            showSplashView();
        }
        if (companion.isRestartFlag() == -1) {
            TIMService.INSTANCE.loginTIM();
            companion.setRestartFlag(0);
        }
        initView();
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onNewIntent(@Nullable Intent intent) {
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        initView();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    protected void onResume() {
        super.onResume();
        if (!UserStore.INSTANCE.getShared().isAuthenticated()) {
            presentAuthenticationController(false, true);
            return;
        }
        HiloApplication.Companion companion = HiloApplication.INSTANCE;
        if (companion.isDailyOneRequest() == -1) {
            PurchaseService.Companion companion2 = PurchaseService.INSTANCE;
            companion2.getShared().updatePurchaseDiamondsList();
            companion2.getShared().updateGemDiamondsList();
            BaseService appService = AllModuleServiceManager.Companion.get().getAppService();
            Intrinsics.checkNotNull(appService, "null cannot be cast to non-null type com.qiahao.nextvideo.data.service.OutPutOtherModuleService");
            OutPutOtherModuleService outPutOtherModuleService = (OutPutOtherModuleService) appService;
            outPutOtherModuleService.initMedalList();
            outPutOtherModuleService.initNobleBeanConfigList();
            companion.setDailyOneRequest(1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m(threadMode = ThreadMode.MAIN)
    public final void onRoomStatusEvent(@NotNull ChatRoomStatusEvent event) {
        ChatRoomServiceConnection chatRoomServiceConnection;
        ChatRoomServiceConnection chatRoomServiceConnection2;
        IChatRoomService iChatRoomService;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        int hashCode = type.hashCode();
        IChatRoomService iChatRoomService2 = null;
        if (hashCode != -1190505608) {
            if (hashCode != -387185485) {
                if (hashCode != 109883352 || !type.equals("start_service") || (chatRoomServiceConnection = this.connection) == null) {
                    return;
                }
                if (chatRoomServiceConnection != null) {
                    iChatRoomService2 = chatRoomServiceConnection.getIChatRoomService();
                }
                if (iChatRoomService2 != null && (chatRoomServiceConnection2 = this.connection) != null && (iChatRoomService = chatRoomServiceConnection2.getIChatRoomService()) != null) {
                    iChatRoomService.onNotificationState(true);
                    return;
                }
                return;
            }
            if (type.equals("bind_service")) {
                this.connection = new ChatRoomServiceConnection();
                Intent intent = new Intent((Context) this, (Class<?>) ChatRoomServer.class);
                ChatRoomServiceConnection chatRoomServiceConnection3 = this.connection;
                Intrinsics.checkNotNull(chatRoomServiceConnection3);
                bindService(intent, chatRoomServiceConnection3, 1);
                return;
            }
            return;
        }
        if (type.equals("stop_service")) {
            ChatRoomServiceConnection chatRoomServiceConnection4 = this.connection;
            if (chatRoomServiceConnection4 != null) {
                unbindService(chatRoomServiceConnection4);
                IChatRoomService iChatRoomService3 = chatRoomServiceConnection4.getIChatRoomService();
                if (iChatRoomService3 != null) {
                    iChatRoomService3.onNotificationState(false);
                }
                chatRoomServiceConnection4.setIChatRoomService(null);
            }
            this.connection = null;
        }
    }

    public final void setHasAddRoot(boolean z) {
        this.hasAddRoot = z;
    }

    public final void showAllList() {
        AppServer appServer = AppServer.INSTANCE;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(appServer.getApis().showAllList(), new Function1() { // from class: com.qiahao.nextvideo.app.b
            public final Object invoke(Object obj) {
                Unit showAllList$lambda$7;
                showAllList$lambda$7 = MainActivity.showAllList$lambda$7(MainActivity.this, (ApiResponse) obj);
                return showAllList$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.app.c
            public final Object invoke(Object obj) {
                Unit showAllList$lambda$8;
                showAllList$lambda$8 = MainActivity.showAllList$lambda$8((Throwable) obj);
                return showAllList$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ServerApi.DefaultImpls.mainActivityData$default(appServer.getApis(), null, 1, null), new Function1() { // from class: com.qiahao.nextvideo.app.d
            public final Object invoke(Object obj) {
                Unit showAllList$lambda$10;
                showAllList$lambda$10 = MainActivity.showAllList$lambda$10((ApiResponse) obj);
                return showAllList$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.app.e
            public final Object invoke(Object obj) {
                Unit showAllList$lambda$11;
                showAllList$lambda$11 = MainActivity.showAllList$lambda$11((Throwable) obj);
                return showAllList$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }
}
