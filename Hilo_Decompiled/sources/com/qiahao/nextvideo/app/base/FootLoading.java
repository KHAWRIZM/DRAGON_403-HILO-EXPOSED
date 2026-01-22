package com.qiahao.nextvideo.app.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.qiahao.nextvideo.databinding.CustomFooterBinding;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0005\u0010\rB%\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0005\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0010¢\u0006\u0004\b!\u0010\"J'\u0010(\u001a\u00020\u00132\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/app/base/FootLoading;", "Lcom/scwang/smart/refresh/layout/simple/SimpleComponent;", "Ltc/c;", "Landroid/view/View;", "wrapped", "<init>", "(Landroid/view/View;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "wrappedView", "Ltc/a;", "wrappedInternal", "(Landroid/view/View;Ltc/a;)V", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "initView", "()V", "Ltc/e;", "kernel", "height", "extendHeight", "onInitialized", "(Ltc/e;II)V", "", "noMoreData", "setNoMoreData", "(Z)Z", "color", "setRootBackgroundColor", "(I)V", "Ltc/f;", "refreshLayout", "Luc/b;", "oldState", "newState", "onStateChanged", "(Ltc/f;Luc/b;Luc/b;)V", "layout", "Ltc/f;", "Lcom/qiahao/nextvideo/databinding/CustomFooterBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/CustomFooterBinding;", "mNoMoreData", "Z", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FootLoading extends SimpleComponent implements tc.c {

    @Nullable
    private CustomFooterBinding binding;

    @Nullable
    private tc.f layout;
    private boolean mNoMoreData;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[uc.b.values().length];
            try {
                iArr[uc.b.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[uc.b.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[uc.b.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[uc.b.LoadReleased.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[uc.b.ReleaseToLoad.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[uc.b.Refreshing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FootLoading(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "wrapped");
        initView();
    }

    public final void initView() {
        this.binding = CustomFooterBinding.inflate(LayoutInflater.from(getContext()), this, true);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.a
    public void onInitialized(@NotNull tc.e kernel, int height, int extendHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        this.layout = kernel.i();
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, vc.i
    public void onStateChanged(@NotNull tc.f refreshLayout, @NotNull uc.b oldState, @NotNull uc.b newState) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        switch (WhenMappings.$EnumSwitchMapping$0[newState.ordinal()]) {
            case 1:
                getView().setVisibility(0);
                return;
            case 2:
                getView().setVisibility(0);
                return;
            case 3:
            case 4:
                getView().setVisibility(0);
                return;
            case 5:
                getView().setVisibility(0);
                return;
            case 6:
                getView().setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, tc.c
    public boolean setNoMoreData(boolean noMoreData) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (this.mNoMoreData != noMoreData) {
            this.mNoMoreData = noMoreData;
            if (noMoreData) {
                CustomFooterBinding customFooterBinding = this.binding;
                if (customFooterBinding != null && (linearLayout2 = customFooterBinding.linearLayout) != null) {
                    linearLayout2.setVisibility(8);
                    return true;
                }
                return true;
            }
            CustomFooterBinding customFooterBinding2 = this.binding;
            if (customFooterBinding2 != null && (linearLayout = customFooterBinding2.linearLayout) != null) {
                linearLayout.setVisibility(0);
                return true;
            }
            return true;
        }
        return true;
    }

    public final void setRootBackgroundColor(int color) {
        LinearLayout linearLayout;
        CustomFooterBinding customFooterBinding = this.binding;
        if (customFooterBinding != null && (linearLayout = customFooterBinding.linearLayout) != null) {
            linearLayout.setBackgroundColor(androidx.core.content.a.getColor(getContext(), color));
        }
    }

    public FootLoading(@Nullable Context context) {
        super(context, null, 0);
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FootLoading(@NotNull View view, @Nullable tc.a aVar) {
        super(view, aVar);
        Intrinsics.checkNotNullParameter(view, "wrappedView");
        initView();
    }

    public FootLoading(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }
}
