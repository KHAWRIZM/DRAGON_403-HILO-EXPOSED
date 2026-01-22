package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.LuckyWheelConfig;
import com.qiahao.nextvideo.data.model.LuckyWheelDiamondConfig;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.databinding.LuckyWheelSelectDialogBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.adapter.LuckyWheelSelectedAdapter;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.decorate.GridSpacingItemMulityCountryDecoration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bJ\u0019\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u000bJ\u000f\u0010\u0018\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/LuckyWheelSelectDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "mCurrentContext", "", "mGroupId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "initViewStyle", "()V", "initData", "updateSelectView", "initRecyclerView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "commonDialogShow", "dismiss", "Landroid/content/Context;", "Ljava/lang/String;", "Lcom/qiahao/nextvideo/room/dialog/LuckyWheelSelectListener;", "mLuckyWheelSelectListener", "Lcom/qiahao/nextvideo/room/dialog/LuckyWheelSelectListener;", "getMLuckyWheelSelectListener", "()Lcom/qiahao/nextvideo/room/dialog/LuckyWheelSelectListener;", "setMLuckyWheelSelectListener", "(Lcom/qiahao/nextvideo/room/dialog/LuckyWheelSelectListener;)V", "Lcom/qiahao/nextvideo/databinding/LuckyWheelSelectDialogBinding;", "mLuckyWheelSelectDialogBinding", "Lcom/qiahao/nextvideo/databinding/LuckyWheelSelectDialogBinding;", "Lcom/qiahao/nextvideo/data/model/LuckyWheelConfig;", "mLuckyWheelConfig", "Lcom/qiahao/nextvideo/data/model/LuckyWheelConfig;", "Lcom/qiahao/nextvideo/room/adapter/LuckyWheelSelectedAdapter;", "mLuckyWheelSelectedAdapter$delegate", "Lkotlin/Lazy;", "getMLuckyWheelSelectedAdapter", "()Lcom/qiahao/nextvideo/room/adapter/LuckyWheelSelectedAdapter;", "mLuckyWheelSelectedAdapter", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyWheelSelectDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyWheelSelectDialog.kt\ncom/qiahao/nextvideo/room/dialog/LuckyWheelSelectDialog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,205:1\n1869#2,2:206\n*S KotlinDebug\n*F\n+ 1 LuckyWheelSelectDialog.kt\ncom/qiahao/nextvideo/room/dialog/LuckyWheelSelectDialog\n*L\n167#1:206,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyWheelSelectDialog extends AppCompatDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "LuckyWheelSelectDialog";

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private final Context mCurrentContext;

    @NotNull
    private final String mGroupId;

    @Nullable
    private LuckyWheelConfig mLuckyWheelConfig;
    private LuckyWheelSelectDialogBinding mLuckyWheelSelectDialogBinding;

    @Nullable
    private LuckyWheelSelectListener mLuckyWheelSelectListener;

    /* renamed from: mLuckyWheelSelectedAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLuckyWheelSelectedAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyWheelSelectDialog(@NotNull Context context, @NotNull String str) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        this.mCurrentContext = context;
        this.mGroupId = str;
        this.mLuckyWheelSelectedAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.o0
            public final Object invoke() {
                LuckyWheelSelectedAdapter mLuckyWheelSelectedAdapter_delegate$lambda$0;
                mLuckyWheelSelectedAdapter_delegate$lambda$0 = LuckyWheelSelectDialog.mLuckyWheelSelectedAdapter_delegate$lambda$0();
                return mLuckyWheelSelectedAdapter_delegate$lambda$0;
            }
        });
        this.mCompositeDisposable = new nd.a();
    }

    private final LuckyWheelSelectedAdapter getMLuckyWheelSelectedAdapter() {
        return (LuckyWheelSelectedAdapter) this.mLuckyWheelSelectedAdapter.getValue();
    }

    private final void initData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRoomLuckyWheelConfig(this.mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.q0
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = LuckyWheelSelectDialog.initData$lambda$3(LuckyWheelSelectDialog.this, (ApiResponse) obj);
                return initData$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.r0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = LuckyWheelSelectDialog.initData$lambda$4(LuckyWheelSelectDialog.this, (Throwable) obj);
                return initData$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
        if (GroupService.INSTANCE.getInstance().getLuckWheelH5().length() == 0) {
            MatchingProvide.INSTANCE.fetchConfigurationParam();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(LuckyWheelSelectDialog luckyWheelSelectDialog, ApiResponse apiResponse) {
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        luckyWheelSelectDialog.mLuckyWheelConfig = (LuckyWheelConfig) apiResponse.getData();
        LuckyWheelSelectedAdapter mLuckyWheelSelectedAdapter = luckyWheelSelectDialog.getMLuckyWheelSelectedAdapter();
        LuckyWheelConfig luckyWheelConfig = (LuckyWheelConfig) apiResponse.getData();
        if (luckyWheelConfig != null) {
            i = luckyWheelConfig.getLastId();
        } else {
            i = 0;
        }
        mLuckyWheelSelectedAdapter.setSelectId(i);
        LuckyWheelConfig luckyWheelConfig2 = luckyWheelSelectDialog.mLuckyWheelConfig;
        if (luckyWheelConfig2 != null) {
            luckyWheelSelectDialog.getMLuckyWheelSelectedAdapter().setList(luckyWheelConfig2.getConfig());
        }
        luckyWheelSelectDialog.updateSelectView();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$4(LuckyWheelSelectDialog luckyWheelSelectDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, luckyWheelSelectDialog.getContext(), ResourcesKtxKt.getStringById(luckyWheelSelectDialog, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "initData: 获取数据报错！！！");
        return Unit.INSTANCE;
    }

    private final void initRecyclerView() {
        LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding = this.mLuckyWheelSelectDialogBinding;
        if (luckyWheelSelectDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckyWheelSelectDialogBinding");
            luckyWheelSelectDialogBinding = null;
        }
        RecyclerView recyclerView = luckyWheelSelectDialogBinding.recyclerView;
        recyclerView.setAdapter(getMLuckyWheelSelectedAdapter());
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.addItemDecoration(new GridSpacingItemMulityCountryDecoration(3, Dimens.INSTANCE.dpToPx(11), false));
        getMLuckyWheelSelectedAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.dialog.p0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LuckyWheelSelectDialog.initRecyclerView$lambda$8(LuckyWheelSelectDialog.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$8(LuckyWheelSelectDialog luckyWheelSelectDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.LuckyWheelDiamondConfig");
        LuckyWheelDiamondConfig luckyWheelDiamondConfig = (LuckyWheelDiamondConfig) item;
        LuckyWheelConfig luckyWheelConfig = luckyWheelSelectDialog.mLuckyWheelConfig;
        if (luckyWheelConfig == null || luckyWheelConfig.getLastId() == luckyWheelDiamondConfig.getId()) {
            return;
        }
        luckyWheelConfig.setLastId(luckyWheelDiamondConfig.getId());
        luckyWheelSelectDialog.getMLuckyWheelSelectedAdapter().setSelectId(luckyWheelConfig.getLastId());
        luckyWheelSelectDialog.getMLuckyWheelSelectedAdapter().notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initViewStyle() {
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        attributes.dimAmount = 0.0f;
        LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding = this.mLuckyWheelSelectDialogBinding;
        LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding2 = null;
        if (luckyWheelSelectDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckyWheelSelectDialogBinding");
            luckyWheelSelectDialogBinding = null;
        }
        ViewGroup.LayoutParams layoutParams = luckyWheelSelectDialogBinding.bgContent.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.setMarginStart(dimens.dpToPx(34));
        layoutParams2.setMarginEnd(dimens.dpToPx(34));
        LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding3 = this.mLuckyWheelSelectDialogBinding;
        if (luckyWheelSelectDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckyWheelSelectDialogBinding");
        } else {
            luckyWheelSelectDialogBinding2 = luckyWheelSelectDialogBinding3;
        }
        luckyWheelSelectDialogBinding2.bgContent.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LuckyWheelSelectedAdapter mLuckyWheelSelectedAdapter_delegate$lambda$0() {
        return new LuckyWheelSelectedAdapter(R.layout.item_lucky_wheel_select);
    }

    private final void updateSelectView() {
        LuckyWheelConfig luckyWheelConfig = this.mLuckyWheelConfig;
        if (luckyWheelConfig != null) {
            LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding = this.mLuckyWheelSelectDialogBinding;
            LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding2 = null;
            if (luckyWheelSelectDialogBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLuckyWheelSelectDialogBinding");
                luckyWheelSelectDialogBinding = null;
            }
            luckyWheelSelectDialogBinding.selectAlsoParticipate.setSelected(luckyWheelConfig.getSelfJoin());
            LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding3 = this.mLuckyWheelSelectDialogBinding;
            if (luckyWheelSelectDialogBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLuckyWheelSelectDialogBinding");
            } else {
                luckyWheelSelectDialogBinding2 = luckyWheelSelectDialogBinding3;
            }
            luckyWheelSelectDialogBinding2.selectAutomaticNextRound.setSelected(luckyWheelConfig.getAutoRestart());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    public final void commonDialogShow() {
        final ?? commonTextDialog = new CommonTextDialog(this.mCurrentContext, 0.0f, 2, null);
        String string = commonTextDialog.getMContext().getString(2131953126);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        commonTextDialog.setContentText(string, true, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.dialog.LuckyWheelSelectDialog$commonDialogShow$1$1
            public void cancel() {
                commonTextDialog.dismiss();
            }

            public void confirm() {
                Context context;
                WalletActivity.Companion companion = WalletActivity.INSTANCE;
                context = LuckyWheelSelectDialog.this.mCurrentContext;
                companion.start(context);
                commonTextDialog.dismiss();
            }
        });
        commonTextDialog.show();
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
    }

    @Nullable
    public final LuckyWheelSelectListener getMLuckyWheelSelectListener() {
        return this.mLuckyWheelSelectListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        double d;
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(v, "v");
        Integer num = null;
        switch (v.getId()) {
            case R.id.close /* 2131362369 */:
                dismiss();
                return;
            case R.id.ll_also_participate /* 2131363532 */:
                LuckyWheelConfig luckyWheelConfig = this.mLuckyWheelConfig;
                if (luckyWheelConfig != null) {
                    luckyWheelConfig.setSelfJoin(!luckyWheelConfig.getSelfJoin());
                }
                updateSelectView();
                return;
            case R.id.ll_automatic_next_round /* 2131363533 */:
                LuckyWheelConfig luckyWheelConfig2 = this.mLuckyWheelConfig;
                if (luckyWheelConfig2 != null) {
                    luckyWheelConfig2.setAutoRestart(!luckyWheelConfig2.getAutoRestart());
                }
                updateSelectView();
                return;
            case R.id.lucky_wheel_create /* 2131363646 */:
                LuckyWheelConfig luckyWheelConfig3 = this.mLuckyWheelConfig;
                if (luckyWheelConfig3 != null) {
                    int i = 0;
                    for (LuckyWheelDiamondConfig luckyWheelDiamondConfig : luckyWheelConfig3.getConfig()) {
                        if (luckyWheelDiamondConfig.getId() == luckyWheelConfig3.getLastId()) {
                            i = luckyWheelDiamondConfig.getEntranceFee();
                        }
                    }
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        d = user.getDiamondNum();
                    } else {
                        d = 0.0d;
                    }
                    if (d >= i) {
                        LuckyWheelSelectListener luckyWheelSelectListener = this.mLuckyWheelSelectListener;
                        if (luckyWheelSelectListener != null) {
                            luckyWheelSelectListener.createLuckyWheel(luckyWheelConfig3.getAutoRestart(), luckyWheelConfig3.getSelfJoin(), luckyWheelConfig3.getLastId(), i);
                        }
                        dismiss();
                    } else {
                        commonDialogShow();
                    }
                    LuckyWheelConfig luckyWheelConfig4 = this.mLuckyWheelConfig;
                    if (luckyWheelConfig4 != null) {
                        bool = Boolean.valueOf(luckyWheelConfig4.getAutoRestart());
                    } else {
                        bool = null;
                    }
                    LuckyWheelConfig luckyWheelConfig5 = this.mLuckyWheelConfig;
                    if (luckyWheelConfig5 != null) {
                        bool2 = Boolean.valueOf(luckyWheelConfig5.getSelfJoin());
                    } else {
                        bool2 = null;
                    }
                    LuckyWheelConfig luckyWheelConfig6 = this.mLuckyWheelConfig;
                    if (luckyWheelConfig6 != null) {
                        num = Integer.valueOf(luckyWheelConfig6.getLastId());
                    }
                    Log.d(TAG, "onClick: " + bool + " " + bool2 + " " + num);
                    return;
                }
                return;
            case R.id.lucky_wheel_question /* 2131363647 */:
                GroupService.Companion companion = GroupService.INSTANCE;
                if (companion.getInstance().getLuckWheelH5().length() > 0) {
                    NavigationHelper.jump$default(NavigationHelper.INSTANCE, companion.getInstance().getLuckWheelH5(), (SuperCallBack) null, 2, (Object) null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding = null;
        LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding2 = (LuckyWheelSelectDialogBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.lucky_wheel_select_dialog, (ViewGroup) null, false);
        this.mLuckyWheelSelectDialogBinding = luckyWheelSelectDialogBinding2;
        if (luckyWheelSelectDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckyWheelSelectDialogBinding");
            luckyWheelSelectDialogBinding2 = null;
        }
        setContentView(luckyWheelSelectDialogBinding2.getRoot());
        initViewStyle();
        LuckyWheelSelectDialogBinding luckyWheelSelectDialogBinding3 = this.mLuckyWheelSelectDialogBinding;
        if (luckyWheelSelectDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckyWheelSelectDialogBinding");
        } else {
            luckyWheelSelectDialogBinding = luckyWheelSelectDialogBinding3;
        }
        luckyWheelSelectDialogBinding.setClick(this);
        initRecyclerView();
        initData();
    }

    public final void setMLuckyWheelSelectListener(@Nullable LuckyWheelSelectListener luckyWheelSelectListener) {
        this.mLuckyWheelSelectListener = luckyWheelSelectListener;
    }
}
