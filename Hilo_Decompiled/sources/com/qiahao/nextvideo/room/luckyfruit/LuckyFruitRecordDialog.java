package com.qiahao.nextvideo.room.luckyfruit;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.LuckyFruitResultMyRecord;
import com.qiahao.nextvideo.data.model.LuckyFruitResultMyRecordItemBean;
import com.qiahao.nextvideo.databinding.DialogLuckyFruitRecordBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import java.util.Arrays;
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

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\rR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRecordDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Lvc/g;", "Lvc/e;", "Landroid/content/Context;", "context", "", "theme", "<init>", "(Landroid/content/Context;I)V", "", "initStyle", "()V", "initDataBinding", "initRecyclerView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "Ltc/f;", "refreshLayout", "onRefresh", "(Ltc/f;)V", "onLoadMore", "", "isRefresh", "getData", "(Z)V", "onDetachedFromWindow", "Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRecordBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRecordBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRecordBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogLuckyFruitRecordBinding;)V", "mCurrentContext", "Landroid/content/Context;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "mPageIndex", "I", "getMPageIndex", "()I", "setMPageIndex", "(I)V", "mPageSize", "getMPageSize", "setMPageSize", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRecordAdapter;", "mLuckyFruitRecordAdapter$delegate", "Lkotlin/Lazy;", "getMLuckyFruitRecordAdapter", "()Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRecordAdapter;", "mLuckyFruitRecordAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyFruitRecordDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyFruitRecordDialog.kt\ncom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRecordDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,154:1\n1#2:155\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitRecordDialog extends AppCompatDialog implements View.OnClickListener, vc.g, vc.e {
    public DialogLuckyFruitRecordBinding binding;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private Context mCurrentContext;

    /* renamed from: mLuckyFruitRecordAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLuckyFruitRecordAdapter;
    private int mPageIndex;
    private int mPageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyFruitRecordDialog(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentContext = context;
        this.mCompositeDisposable = new nd.a();
        this.mPageIndex = 1;
        this.mPageSize = 10;
        this.mLuckyFruitRecordAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.luckyfruit.q0
            public final Object invoke() {
                LuckyFruitRecordAdapter mLuckyFruitRecordAdapter_delegate$lambda$0;
                mLuckyFruitRecordAdapter_delegate$lambda$0 = LuckyFruitRecordDialog.mLuckyFruitRecordAdapter_delegate$lambda$0();
                return mLuckyFruitRecordAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$4(LuckyFruitRecordDialog luckyFruitRecordDialog, boolean z, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        luckyFruitRecordDialog.mPageIndex++;
        LuckyFruitResultMyRecord luckyFruitResultMyRecord = (LuckyFruitResultMyRecord) apiResponse.getData();
        if (luckyFruitResultMyRecord != null) {
            List<LuckyFruitResultMyRecordItemBean> list = luckyFruitResultMyRecord.getList();
            if (list != null && list.isEmpty()) {
                if (z) {
                    luckyFruitRecordDialog.getBinding().emptyView.setVisibility(0);
                    luckyFruitRecordDialog.getMLuckyFruitRecordAdapter().setList(luckyFruitResultMyRecord.getList());
                }
                luckyFruitRecordDialog.getBinding().smartRefreshLayout.setEnableLoadMore(false);
            } else {
                luckyFruitRecordDialog.getBinding().emptyView.setVisibility(8);
                List<LuckyFruitResultMyRecordItemBean> list2 = luckyFruitResultMyRecord.getList();
                if (list2 != null && list2.size() == luckyFruitRecordDialog.mPageSize) {
                    luckyFruitRecordDialog.getBinding().smartRefreshLayout.setEnableLoadMore(true);
                } else {
                    luckyFruitRecordDialog.getBinding().smartRefreshLayout.setEnableLoadMore(false);
                }
                if (z) {
                    luckyFruitRecordDialog.getMLuckyFruitRecordAdapter().setList(luckyFruitResultMyRecord.getList());
                } else {
                    List<LuckyFruitResultMyRecordItemBean> list3 = luckyFruitResultMyRecord.getList();
                    if (list3 != null) {
                        luckyFruitRecordDialog.getMLuckyFruitRecordAdapter().addData(list3);
                    }
                }
            }
            luckyFruitRecordDialog.getBinding().diamond.setText(NumberUtilsKt.rankNumberFormat(luckyFruitResultMyRecord.getProfitToday()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$5(boolean z, LuckyFruitRecordDialog luckyFruitRecordDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (z) {
            luckyFruitRecordDialog.getBinding().emptyView.setVisibility(0);
            luckyFruitRecordDialog.getMLuckyFruitRecordAdapter().setList((Collection) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$6(boolean z, LuckyFruitRecordDialog luckyFruitRecordDialog) {
        if (z) {
            luckyFruitRecordDialog.getBinding().smartRefreshLayout.finishRefresh();
        } else {
            luckyFruitRecordDialog.getBinding().smartRefreshLayout.finishLoadMore();
        }
        return Unit.INSTANCE;
    }

    private final LuckyFruitRecordAdapter getMLuckyFruitRecordAdapter() {
        return (LuckyFruitRecordAdapter) this.mLuckyFruitRecordAdapter.getValue();
    }

    private final void initDataBinding() {
        String str = null;
        setBinding(DialogLuckyFruitRecordBinding.inflate(LayoutInflater.from(this.mCurrentContext), null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        initRecyclerView();
        TextView textView = getBinding().title;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953865);
        String stringById2 = ResourcesKtxKt.getStringById(this, 2131953102);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            str = user.getCode();
        }
        String format = String.format(stringById2, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(stringById + "(" + format + ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMLuckyFruitRecordAdapter());
        getBinding().smartRefreshLayout.setRefreshFooter(new FootLoading(getContext()));
        getBinding().smartRefreshLayout.setEnableRefresh(true);
        getBinding().smartRefreshLayout.setEnableLoadMore(false);
        getBinding().smartRefreshLayout.setOnRefreshListener(this);
        getBinding().smartRefreshLayout.setOnLoadMoreListener(this);
        getBinding().smartRefreshLayout.autoRefresh();
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
        attributes.horizontalMargin = 0.0f;
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.setWindowAnimations(R.style.dialog_for_bottom_in_out_anim);
        Window window5 = getWindow();
        Intrinsics.checkNotNull(window5);
        window5.getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LuckyFruitRecordAdapter mLuckyFruitRecordAdapter_delegate$lambda$0() {
        return new LuckyFruitRecordAdapter(R.layout.item_chat_room_lucky_fruit_record);
    }

    @NotNull
    public final DialogLuckyFruitRecordBinding getBinding() {
        DialogLuckyFruitRecordBinding dialogLuckyFruitRecordBinding = this.binding;
        if (dialogLuckyFruitRecordBinding != null) {
            return dialogLuckyFruitRecordBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void getData(final boolean isRefresh) {
        if (isRefresh) {
            this.mPageIndex = 1;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getFruitMachineMyRecord(this.mPageIndex, this.mPageSize), new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.n0
            public final Object invoke(Object obj) {
                Unit data$lambda$4;
                data$lambda$4 = LuckyFruitRecordDialog.getData$lambda$4(LuckyFruitRecordDialog.this, isRefresh, (ApiResponse) obj);
                return data$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckyfruit.o0
            public final Object invoke(Object obj) {
                Unit data$lambda$5;
                data$lambda$5 = LuckyFruitRecordDialog.getData$lambda$5(isRefresh, this, (Throwable) obj);
                return data$lambda$5;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.luckyfruit.p0
            public final Object invoke() {
                Unit data$lambda$6;
                data$lambda$6 = LuckyFruitRecordDialog.getData$lambda$6(isRefresh, this);
                return data$lambda$6;
            }
        }, false, 8, (Object) null), this.mCompositeDisposable);
    }

    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    public final int getMPageSize() {
        return this.mPageSize;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (v.getId() == 2131362039) {
            dismiss();
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initStyle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.app.Dialog*/.onDetachedFromWindow();
        this.mCompositeDisposable.d();
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

    public final void setBinding(@NotNull DialogLuckyFruitRecordBinding dialogLuckyFruitRecordBinding) {
        Intrinsics.checkNotNullParameter(dialogLuckyFruitRecordBinding, "<set-?>");
        this.binding = dialogLuckyFruitRecordBinding;
    }

    public final void setMPageIndex(int i) {
        this.mPageIndex = i;
    }

    public final void setMPageSize(int i) {
        this.mPageSize = i;
    }

    public /* synthetic */ LuckyFruitRecordDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.CommonDialogStyle : i);
    }
}
