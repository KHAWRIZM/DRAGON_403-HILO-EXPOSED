package com.qiahao.nextvideo.room.luckybox;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogLuckyBoxBigPrizesBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.decorate.GridSpacingItemMulityCountryDecoration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u000bR\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxBigPrizesDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "", "theme", "<init>", "(Landroid/content/Context;I)V", "", "initStyle", "()V", "initDataBinding", "initRecyclerView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "getData", "onDetachedFromWindow", "Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBigPrizesBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBigPrizesBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBigPrizesBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBigPrizesBinding;)V", "mCurrentContext", "Landroid/content/Context;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxBigRewardAdapter;", "mLuckyBoxBigRewardAdapter$delegate", "Lkotlin/Lazy;", "getMLuckyBoxBigRewardAdapter", "()Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxBigRewardAdapter;", "mLuckyBoxBigRewardAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyBoxBigPrizesDialog extends AppCompatDialog implements View.OnClickListener {
    public DialogLuckyBoxBigPrizesBinding binding;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private Context mCurrentContext;

    /* renamed from: mLuckyBoxBigRewardAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLuckyBoxBigRewardAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyBoxBigPrizesDialog(@NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentContext = context;
        this.mCompositeDisposable = new nd.a();
        this.mLuckyBoxBigRewardAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.luckybox.c
            public final Object invoke() {
                LuckyBoxBigRewardAdapter mLuckyBoxBigRewardAdapter_delegate$lambda$0;
                mLuckyBoxBigRewardAdapter_delegate$lambda$0 = LuckyBoxBigPrizesDialog.mLuckyBoxBigRewardAdapter_delegate$lambda$0();
                return mLuckyBoxBigRewardAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$3(LuckyBoxBigPrizesDialog luckyBoxBigPrizesDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            LuckyBoxBigRewardAdapter mLuckyBoxBigRewardAdapter = luckyBoxBigPrizesDialog.getMLuckyBoxBigRewardAdapter();
            List mutableList = CollectionsKt.toMutableList(list);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.RewardLuckyBoxBean>");
            mLuckyBoxBigRewardAdapter.setList((ArrayList) mutableList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$4(LuckyBoxBigPrizesDialog luckyBoxBigPrizesDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        luckyBoxBigPrizesDialog.getBinding().emptyView.setVisibility(0);
        return Unit.INSTANCE;
    }

    private final LuckyBoxBigRewardAdapter getMLuckyBoxBigRewardAdapter() {
        return (LuckyBoxBigRewardAdapter) this.mLuckyBoxBigRewardAdapter.getValue();
    }

    private final void initDataBinding() {
        setBinding(DialogLuckyBoxBigPrizesBinding.inflate(LayoutInflater.from(this.mCurrentContext), null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        initRecyclerView();
        getData();
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView = getBinding().recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.addItemDecoration(new GridSpacingItemMulityCountryDecoration(3, Dimens.INSTANCE.dpToPx(10), false));
        recyclerView.setAdapter(getMLuckyBoxBigRewardAdapter());
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
    public static final LuckyBoxBigRewardAdapter mLuckyBoxBigRewardAdapter_delegate$lambda$0() {
        return new LuckyBoxBigRewardAdapter(R.layout.item_group_lucky_box_big_reward);
    }

    @NotNull
    public final DialogLuckyBoxBigPrizesBinding getBinding() {
        DialogLuckyBoxBigPrizesBinding dialogLuckyBoxBigPrizesBinding = this.binding;
        if (dialogLuckyBoxBigPrizesBinding != null) {
            return dialogLuckyBoxBigPrizesBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().luckyBoxAward(), new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.a
            public final Object invoke(Object obj) {
                Unit data$lambda$3;
                data$lambda$3 = LuckyBoxBigPrizesDialog.getData$lambda$3(LuckyBoxBigPrizesDialog.this, (ApiResponse) obj);
                return data$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.b
            public final Object invoke(Object obj) {
                Unit data$lambda$4;
                data$lambda$4 = LuckyBoxBigPrizesDialog.getData$lambda$4(LuckyBoxBigPrizesDialog.this, (Throwable) obj);
                return data$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
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

    public final void setBinding(@NotNull DialogLuckyBoxBigPrizesBinding dialogLuckyBoxBigPrizesBinding) {
        Intrinsics.checkNotNullParameter(dialogLuckyBoxBigPrizesBinding, "<set-?>");
        this.binding = dialogLuckyBoxBigPrizesBinding;
    }

    public /* synthetic */ LuckyBoxBigPrizesDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? R.style.HiloBottomSheetDialog : i);
    }
}
