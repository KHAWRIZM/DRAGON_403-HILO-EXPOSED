package com.qiahao.nextvideo.room.luckyfruit;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.model.LuckyFruitRankAllBean;
import com.qiahao.nextvideo.data.model.LuckyFruitRankBean;
import com.qiahao.nextvideo.databinding.DialogLuckyFruitRankingBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRankingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Lvc/g;", "Lvc/e;", "Landroid/content/Context;", "context", "", "theme", "<init>", "(Landroid/content/Context;I)V", "", "initStyle", "()V", "initDataBinding", "initRecyclerView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", "isRefresh", "getData", "(Z)V", "Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRankingBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRankingBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRankingBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRankingBinding;)V", "mCurrentContext", "Landroid/content/Context;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRankingAdapter;", "mLuckyBoxRankingAdapter$delegate", "Lkotlin/Lazy;", "getMLuckyBoxRankingAdapter", "()Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRankingAdapter;", "mLuckyBoxRankingAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyFruitRankingDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyFruitRankingDialog.kt\ncom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRankingDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,210:1\n1#2:211\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitRankingDialog extends AppCompatDialog implements View.OnClickListener, vc.g, vc.e {
    public DialogLuckyFruitRankingBinding binding;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private Context mCurrentContext;

    /* renamed from: mLuckyBoxRankingAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLuckyBoxRankingAdapter;
    private int mPageIndex;
    private int mPageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyFruitRankingDialog(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentContext = context;
        this.mCompositeDisposable = new nd.a();
        this.mPageIndex = 1;
        this.mPageSize = 10;
        this.mLuckyBoxRankingAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.luckyfruit.i0
            public final Object invoke() {
                LuckyFruitRankingAdapter mLuckyBoxRankingAdapter_delegate$lambda$0;
                mLuckyBoxRankingAdapter_delegate$lambda$0 = LuckyFruitRankingDialog.mLuckyBoxRankingAdapter_delegate$lambda$0();
                return mLuckyBoxRankingAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$6(LuckyFruitRankingDialog luckyFruitRankingDialog, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        luckyFruitRankingDialog.mPageIndex++;
        LuckyFruitRankAllBean luckyFruitRankAllBean = (LuckyFruitRankAllBean) apiResponse.getData();
        if (luckyFruitRankAllBean != null) {
            String title = luckyFruitRankAllBean.getTitle();
            if (title != null) {
                luckyFruitRankingDialog.getBinding().title.setText(title);
            }
            List<LuckyFruitRankBean> list = luckyFruitRankAllBean.getList();
            if (list != null && !list.isEmpty()) {
                luckyFruitRankingDialog.getBinding().emptyView.setVisibility(8);
                if (luckyFruitRankAllBean.getList().size() == luckyFruitRankingDialog.mPageSize) {
                    luckyFruitRankingDialog.getBinding().smartRefreshLayout.setEnableLoadMore(true);
                } else {
                    luckyFruitRankingDialog.getBinding().smartRefreshLayout.setEnableLoadMore(false);
                }
                if (z) {
                    luckyFruitRankingDialog.getMLuckyBoxRankingAdapter().setList(luckyFruitRankAllBean.getList());
                } else {
                    luckyFruitRankingDialog.getMLuckyBoxRankingAdapter().addData(luckyFruitRankAllBean.getList());
                }
            } else {
                if (z) {
                    luckyFruitRankingDialog.getBinding().emptyView.setVisibility(0);
                    luckyFruitRankingDialog.getMLuckyBoxRankingAdapter().setList(luckyFruitRankAllBean.getList());
                }
                luckyFruitRankingDialog.getBinding().smartRefreshLayout.setEnableLoadMore(false);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$7(boolean z, LuckyFruitRankingDialog luckyFruitRankingDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (z) {
            luckyFruitRankingDialog.getBinding().emptyView.setVisibility(0);
            luckyFruitRankingDialog.getMLuckyBoxRankingAdapter().setList((Collection) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$8(boolean z, LuckyFruitRankingDialog luckyFruitRankingDialog) {
        if (z) {
            luckyFruitRankingDialog.getBinding().smartRefreshLayout.finishRefresh();
        } else {
            luckyFruitRankingDialog.getBinding().smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    private final LuckyFruitRankingAdapter getMLuckyBoxRankingAdapter() {
        return (LuckyFruitRankingAdapter) this.mLuckyBoxRankingAdapter.getValue();
    }

    private final void initDataBinding() {
        setBinding(DialogLuckyFruitRankingBinding.inflate(LayoutInflater.from(this.mCurrentContext), null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        initRecyclerView();
        getData(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMLuckyBoxRankingAdapter());
        getBinding().smartRefreshLayout.setRefreshFooter(new FootLoading(getContext()));
        getBinding().smartRefreshLayout.setEnableRefresh(true);
        getBinding().smartRefreshLayout.setEnableLoadMore(false);
        getBinding().smartRefreshLayout.setOnRefreshListener(this);
        getBinding().smartRefreshLayout.setOnLoadMoreListener(this);
        getBinding().smartRefreshLayout.autoRefresh();
        getMLuckyBoxRankingAdapter().addChildClickViewIds(new int[]{R.id.circle_avatar});
        getMLuckyBoxRankingAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.m0
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LuckyFruitRankingDialog.initRecyclerView$lambda$2(baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$2(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131362323) {
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.LuckyFruitRankBean");
            AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, ((LuckyFruitRankBean) item).getUser().getExternalId(), false, 2, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setDimAmount(0.0f);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setWindowAnimations(R.style.dialog_for_bottom_in_out_anim);
        attributes.horizontalMargin = 0.0f;
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setAttributes(attributes);
        Window window5 = getWindow();
        Intrinsics.checkNotNull(window5);
        window5.getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LuckyFruitRankingAdapter mLuckyBoxRankingAdapter_delegate$lambda$0() {
        return new LuckyFruitRankingAdapter(R.layout.item_group_lucky_box_ranking);
    }

    @NotNull
    public final DialogLuckyFruitRankingBinding getBinding() {
        DialogLuckyFruitRankingBinding dialogLuckyFruitRankingBinding = this.binding;
        if (dialogLuckyFruitRankingBinding != null) {
            return dialogLuckyFruitRankingBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void getData(final boolean isRefresh) {
        if (isRefresh) {
            this.mPageIndex = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getFruitMachineRanking(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.j0
            public final Object invoke(Object obj) {
                Unit data$lambda$6;
                data$lambda$6 = LuckyFruitRankingDialog.getData$lambda$6(LuckyFruitRankingDialog.this, isRefresh, (ApiResponse) obj);
                return data$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.k0
            public final Object invoke(Object obj) {
                Unit data$lambda$7;
                data$lambda$7 = LuckyFruitRankingDialog.getData$lambda$7(isRefresh, this, (Throwable) obj);
                return data$lambda$7;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.luckyfruit.l0
            public final Object invoke() {
                Unit data$lambda$8;
                data$lambda$8 = LuckyFruitRankingDialog.getData$lambda$8(isRefresh, this);
                return data$lambda$8;
            }
        }, false, 8, (Object) null), this.mCompositeDisposable);
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.app.Dialog, com.qiahao.nextvideo.app.base.CommonTextDialog] */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 == 2131364693) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                ?? commonTextDialog = new CommonTextDialog(context, 0.0f, 2, null);
                String string = commonTextDialog.getContext().getString(2131953828);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                commonTextDialog.setContentText(string, false, new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.luckyfruit.LuckyFruitRankingDialog$onClick$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                    }
                });
                commonTextDialog.show();
                return;
            }
            return;
        }
        dismiss();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initStyle();
    }

    @Override // vc.e
    public void onLoadMore(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData(false);
    }

    @Override // vc.g
    public void onRefresh(@NotNull tc.f refreshLayout) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        getData(true);
    }

    public final void setBinding(@NotNull DialogLuckyFruitRankingBinding dialogLuckyFruitRankingBinding) {
        Intrinsics.checkNotNullParameter(dialogLuckyFruitRankingBinding, "<set-?>");
        this.binding = dialogLuckyFruitRankingBinding;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    public /* synthetic */ LuckyFruitRankingDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.CommonDialogStyle : i);
    }
}
