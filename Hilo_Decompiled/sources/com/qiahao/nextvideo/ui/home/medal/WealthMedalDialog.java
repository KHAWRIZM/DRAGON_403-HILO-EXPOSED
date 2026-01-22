package com.qiahao.nextvideo.ui.home.medal;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.DialogWealthMedalBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0014R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/WealthMedalDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogWealthMedalBinding;", "context", "Landroid/content/Context;", "mList", "", "Lcom/qiahao/base_common/model/common/MedalInfo;", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "getLayoutResId", "", "mListener", "Lkotlin/Function1;", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/medal/MedalDialogAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/medal/MedalDialogAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "onInitialize", "isBottomStyle", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WealthMedalDialog extends BaseBindingDialog<DialogWealthMedalBinding> {

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @Nullable
    private final List<MedalInfo> mList;

    @Nullable
    private Function1<? super MedalInfo, Unit> mListener;

    public /* synthetic */ WealthMedalDialog(Context context, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MedalDialogAdapter mAdapter_delegate$lambda$0() {
        return new MedalDialogAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$1(WealthMedalDialog wealthMedalDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Function1<? super MedalInfo, Unit> function1 = wealthMedalDialog.mListener;
        if (function1 != null) {
            function1.invoke(wealthMedalDialog.getMAdapter().getData().get(i));
        }
        wealthMedalDialog.dismiss();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_wealth_medal;
    }

    @NotNull
    public final MedalDialogAdapter getMAdapter() {
        return (MedalDialogAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final Function1<MedalInfo, Unit> getMListener() {
        return this.mListener;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        ConstraintLayout constraintLayout = ((DialogWealthMedalBinding) getBinding()).constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, context, 2131099862, 2131099862, 10, 10, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
        ((DialogWealthMedalBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.h0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                WealthMedalDialog.onInitialize$lambda$1(WealthMedalDialog.this, baseQuickAdapter, view, i);
            }
        });
        getMAdapter().setList(this.mList);
    }

    public final void setMListener(@Nullable Function1<? super MedalInfo, Unit> function1) {
        this.mListener = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WealthMedalDialog(@NotNull Context context, @Nullable List<MedalInfo> list) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mList = list;
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.g0
            public final Object invoke() {
                MedalDialogAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = WealthMedalDialog.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }
}
