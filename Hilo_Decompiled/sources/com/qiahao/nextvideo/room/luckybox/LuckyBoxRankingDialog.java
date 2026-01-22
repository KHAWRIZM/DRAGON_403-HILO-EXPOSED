package com.qiahao.nextvideo.room.luckybox;

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
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.LuckyBoxRankingBean;
import com.qiahao.nextvideo.data.model.LuckyBoxRankingDetailBean;
import com.qiahao.nextvideo.databinding.DialogLuckyBoxRankingBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\fJ\u000f\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\fJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\fJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001f\u0010\u0012R\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxRankingDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/room/luckybox/LuckBoxRankingCountDownTimerDelegate;", "Landroid/content/Context;", "context", "", "theme", "<init>", "(Landroid/content/Context;I)V", "", "initStyle", "()V", "initDataBinding", "initRecyclerView", "", "remainSecond", "countDown", "(J)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "getData", "onDetachedFromWindow", "luckBoxRankingCountDownTimerTimeout", "millisUntilFinished", "luckBoxRankingCountDownTimerOnTick", "Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxRankingBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxRankingBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxRankingBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxRankingBinding;)V", "mCurrentContext", "Landroid/content/Context;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Lcom/qiahao/nextvideo/room/luckybox/LuckBoxRankingCountDownTimer;", "mCountDownTimer", "Lcom/qiahao/nextvideo/room/luckybox/LuckBoxRankingCountDownTimer;", "Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxRankingAdapter;", "mLuckyBoxRankingAdapter$delegate", "Lkotlin/Lazy;", "getMLuckyBoxRankingAdapter", "()Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxRankingAdapter;", "mLuckyBoxRankingAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLuckyBoxRankingDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LuckyBoxRankingDialog.kt\ncom/qiahao/nextvideo/room/luckybox/LuckyBoxRankingDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,155:1\n1#2:156\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyBoxRankingDialog extends AppCompatDialog implements View.OnClickListener, LuckBoxRankingCountDownTimerDelegate {
    public DialogLuckyBoxRankingBinding binding;

    @NotNull
    private nd.a mCompositeDisposable;

    @Nullable
    private LuckBoxRankingCountDownTimer mCountDownTimer;

    @NotNull
    private Context mCurrentContext;

    /* renamed from: mLuckyBoxRankingAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLuckyBoxRankingAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyBoxRankingDialog(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentContext = context;
        this.mCompositeDisposable = new nd.a();
        this.mLuckyBoxRankingAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.luckybox.n
            public final Object invoke() {
                LuckyBoxRankingAdapter mLuckyBoxRankingAdapter_delegate$lambda$0;
                mLuckyBoxRankingAdapter_delegate$lambda$0 = LuckyBoxRankingDialog.mLuckyBoxRankingAdapter_delegate$lambda$0();
                return mLuckyBoxRankingAdapter_delegate$lambda$0;
            }
        });
    }

    private final void countDown(long remainSecond) {
        LuckBoxRankingCountDownTimer luckBoxRankingCountDownTimer = new LuckBoxRankingCountDownTimer(remainSecond * 1000);
        luckBoxRankingCountDownTimer.setDelegate(this);
        this.mCountDownTimer = luckBoxRankingCountDownTimer;
        luckBoxRankingCountDownTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$4(LuckyBoxRankingDialog luckyBoxRankingDialog, ApiResponse apiResponse) {
        List<LuckyBoxRankingDetailBean> list;
        List<LuckyBoxRankingDetailBean> details;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LuckyBoxRankingBean luckyBoxRankingBean = (LuckyBoxRankingBean) apiResponse.getData();
        if (luckyBoxRankingBean != null && (details = luckyBoxRankingBean.getDetails()) != null && details.isEmpty()) {
            luckyBoxRankingDialog.getBinding().emptyView.setVisibility(0);
        }
        LuckyBoxRankingAdapter mLuckyBoxRankingAdapter = luckyBoxRankingDialog.getMLuckyBoxRankingAdapter();
        LuckyBoxRankingBean luckyBoxRankingBean2 = (LuckyBoxRankingBean) apiResponse.getData();
        if (luckyBoxRankingBean2 != null) {
            list = luckyBoxRankingBean2.getDetails();
        } else {
            list = null;
        }
        mLuckyBoxRankingAdapter.setList(list);
        LuckyBoxRankingBean luckyBoxRankingBean3 = (LuckyBoxRankingBean) apiResponse.getData();
        if (luckyBoxRankingBean3 != null) {
            luckyBoxRankingDialog.countDown(luckyBoxRankingBean3.getRemainSecond());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$5(LuckyBoxRankingDialog luckyBoxRankingDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        luckyBoxRankingDialog.getBinding().emptyView.setVisibility(0);
        return Unit.INSTANCE;
    }

    private final LuckyBoxRankingAdapter getMLuckyBoxRankingAdapter() {
        return (LuckyBoxRankingAdapter) this.mLuckyBoxRankingAdapter.getValue();
    }

    private final void initDataBinding() {
        setBinding(DialogLuckyBoxRankingBinding.inflate(LayoutInflater.from(this.mCurrentContext), null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        initRecyclerView();
        getData();
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMLuckyBoxRankingAdapter());
        getMLuckyBoxRankingAdapter().addChildClickViewIds(new int[]{R.id.circle_avatar});
        getMLuckyBoxRankingAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.room.luckybox.q
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LuckyBoxRankingDialog.initRecyclerView$lambda$2(baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$2(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131362323) {
            Object item = baseQuickAdapter.getItem(i);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.LuckyBoxRankingDetailBean");
            AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, ((LuckyBoxRankingDetailBean) item).getUser().getExternalId(), false, 2, null);
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
        attributes.horizontalMargin = 0.0f;
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LuckyBoxRankingAdapter mLuckyBoxRankingAdapter_delegate$lambda$0() {
        return new LuckyBoxRankingAdapter(R.layout.item_group_lucky_box_ranking);
    }

    @NotNull
    public final DialogLuckyBoxRankingBinding getBinding() {
        DialogLuckyBoxRankingBinding dialogLuckyBoxRankingBinding = this.binding;
        if (dialogLuckyBoxRankingBinding != null) {
            return dialogLuckyBoxRankingBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getLuckBoxRanking(), new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.o
            public final Object invoke(Object obj) {
                Unit data$lambda$4;
                data$lambda$4 = LuckyBoxRankingDialog.getData$lambda$4(LuckyBoxRankingDialog.this, (ApiResponse) obj);
                return data$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.p
            public final Object invoke(Object obj) {
                Unit data$lambda$5;
                data$lambda$5 = LuckyBoxRankingDialog.getData$lambda$5(LuckyBoxRankingDialog.this, (Throwable) obj);
                return data$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    @Override // com.qiahao.nextvideo.room.luckybox.LuckBoxRankingCountDownTimerDelegate
    public void luckBoxRankingCountDownTimerOnTick(long millisUntilFinished) {
        getBinding().countDownText.setText(this.mCurrentContext.getString(2131952392) + " " + DateTimeUtilityKt.changeLuckRankingTime(millisUntilFinished / 1000));
    }

    @Override // com.qiahao.nextvideo.room.luckybox.LuckBoxRankingCountDownTimerDelegate
    public void luckBoxRankingCountDownTimerTimeout() {
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
        LuckBoxRankingCountDownTimer luckBoxRankingCountDownTimer = this.mCountDownTimer;
        if (luckBoxRankingCountDownTimer != null) {
            luckBoxRankingCountDownTimer.cancel();
        }
    }

    public final void setBinding(@NotNull DialogLuckyBoxRankingBinding dialogLuckyBoxRankingBinding) {
        Intrinsics.checkNotNullParameter(dialogLuckyBoxRankingBinding, "<set-?>");
        this.binding = dialogLuckyBoxRankingBinding;
    }

    public /* synthetic */ LuckyBoxRankingDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.HiloBottomSheetDialog : i);
    }
}
