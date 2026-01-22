package com.qhqc.core.basic.rvadapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;
import com.qhqc.core.basic.R;
import com.qhqc.core.basic.databinding.BasicAdapterStateDefEmptyBinding;
import com.qhqc.core.basic.databinding.BasicAdapterStateDefErrorBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001;B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u000200J\u000e\u00103\u001a\u0002002\u0006\u00104\u001a\u000205J\u0016\u00106\u001a\u0002002\u000e\u00107\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/J\b\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0002J\b\u0010:\u001a\u000200H\u0002R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001e\u0010 \u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\b\"\u0004\b%\u0010\nR\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreStateHelper;", "", "adapter", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreQuickAdapter;", "(Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreQuickAdapter;)V", "defEmptyView", "Landroid/view/View;", "getDefEmptyView", "()Landroid/view/View;", "setDefEmptyView", "(Landroid/view/View;)V", "defEmptyViewContent", "", "getDefEmptyViewContent", "()Ljava/lang/String;", "setDefEmptyViewContent", "(Ljava/lang/String;)V", "defEmptyViewIcon", "Landroid/graphics/drawable/Drawable;", "getDefEmptyViewIcon", "()Landroid/graphics/drawable/Drawable;", "setDefEmptyViewIcon", "(Landroid/graphics/drawable/Drawable;)V", "defLoadingViewLayoutResId", "", "getDefLoadingViewLayoutResId", "()I", "setDefLoadingViewLayoutResId", "(I)V", "emptyViewBgColor", "getEmptyViewBgColor", "setEmptyViewBgColor", "emptyViewLayoutResId", "getEmptyViewLayoutResId", "setEmptyViewLayoutResId", "errorView", "getErrorView", "setErrorView", "isLoadingViewLoaded", "", "isShowEmptyView", "()Z", "setShowEmptyView", "(Z)V", "isShowLoadingView", "setShowLoadingView", "mReloadListener", "Lkotlin/Function0;", "", "onAttachedToRecyclerView", "onReload", "onStateChange", "state", "Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreStateHelper$State;", "setReloadListener", "reloadListener", "showViewEmpty", "showViewError", "showViewLoading", "State", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicLoadMoreStateHelper {

    @NotNull
    private final BasicLoadMoreQuickAdapter<?, ?> adapter;

    @Nullable
    private View defEmptyView;

    @Nullable
    private String defEmptyViewContent;

    @Nullable
    private Drawable defEmptyViewIcon;
    private int defLoadingViewLayoutResId;
    private int emptyViewBgColor;
    private int emptyViewLayoutResId;

    @Nullable
    private View errorView;
    private boolean isLoadingViewLoaded;
    private boolean isShowEmptyView;
    private boolean isShowLoadingView;

    @Nullable
    private Function0<Unit> mReloadListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/qhqc/core/basic/rvadapter/BasicLoadMoreStateHelper$State;", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "(I)V", "getStatus", "()I", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class State {
        public static final int EMPTY = 2;
        public static final int ERROR = 3;
        public static final int LOADING = 1;
        private final int status;

        public State(int i10) {
            this.status = i10;
        }

        public final int getStatus() {
            return this.status;
        }
    }

    public BasicLoadMoreStateHelper(@NotNull BasicLoadMoreQuickAdapter<?, ?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        this.isShowEmptyView = true;
        this.isShowLoadingView = true;
        this.defLoadingViewLayoutResId = R.layout.basic_adapter_state_def_loading;
    }

    private final void showViewEmpty() {
        TextView contentView;
        ImageView iconView;
        BasicLoadMoreQuickAdapter<?, ?> basicLoadMoreQuickAdapter = this.adapter;
        if (!this.isShowEmptyView) {
            basicLoadMoreQuickAdapter.removeEmptyView();
            return;
        }
        View view = this.defEmptyView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            basicLoadMoreQuickAdapter.setEmptyView(view);
            return;
        }
        int i10 = this.emptyViewLayoutResId;
        if (i10 != 0) {
            basicLoadMoreQuickAdapter.setEmptyView(i10);
            return;
        }
        IBasicAdapterStateViewEmpty statViewEmpty = BasicAdapterConfigs.INSTANCE.getStatViewEmpty();
        if (statViewEmpty != null) {
            basicLoadMoreQuickAdapter.setEmptyView(statViewEmpty.onCreateView(basicLoadMoreQuickAdapter.getContext()));
            if (this.defEmptyViewIcon != null && (iconView = statViewEmpty.getIconView()) != null) {
                iconView.setImageDrawable(this.defEmptyViewIcon);
            }
            String str = this.defEmptyViewContent;
            if (str != null && str.length() != 0 && (contentView = statViewEmpty.getContentView()) != null) {
                contentView.setText(this.defEmptyViewContent);
                return;
            }
            return;
        }
        BasicAdapterStateDefEmptyBinding inflate = BasicAdapterStateDefEmptyBinding.inflate(LayoutInflater.from(basicLoadMoreQuickAdapter.getContext()));
        inflate.emptyContent.setBackgroundColor(this.emptyViewBgColor);
        Drawable drawable = this.defEmptyViewIcon;
        if (drawable != null) {
            inflate.image.setImageDrawable(drawable);
        }
        String str2 = this.defEmptyViewContent;
        if (str2 != null && str2.length() != 0) {
            inflate.content.setText(this.defEmptyViewContent);
        }
        RelativeLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        basicLoadMoreQuickAdapter.setEmptyView(root);
    }

    private final void showViewError() {
        if (this.errorView == null) {
            IBasicAdapterStateViewError statViewError = BasicAdapterConfigs.INSTANCE.getStatViewError();
            if (statViewError != null) {
                this.errorView = statViewError.onCreateView(this.adapter.getContext());
                View reloadBtn = statViewError.getReloadBtn();
                if (reloadBtn != null) {
                    reloadBtn.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.basic.rvadapter.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BasicLoadMoreStateHelper.showViewError$lambda$3(BasicLoadMoreStateHelper.this, view);
                        }
                    });
                }
            } else {
                BasicAdapterStateDefErrorBinding inflate = BasicAdapterStateDefErrorBinding.inflate(LayoutInflater.from(this.adapter.getContext()), null, false);
                this.errorView = inflate.getRoot();
                inflate.mReload.setOnClickListener(new View.OnClickListener() { // from class: com.qhqc.core.basic.rvadapter.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BasicLoadMoreStateHelper.showViewError$lambda$5$lambda$4(BasicLoadMoreStateHelper.this, view);
                    }
                });
            }
        }
        View view = this.errorView;
        if (view != null) {
            view.setBackgroundColor(this.emptyViewBgColor);
            this.adapter.setEmptyView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showViewError$lambda$3(BasicLoadMoreStateHelper this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onReload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showViewError$lambda$5$lambda$4(BasicLoadMoreStateHelper this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onReload();
    }

    private final void showViewLoading() {
        if (this.isShowLoadingView && !this.isLoadingViewLoaded) {
            d statViewLoading = BasicAdapterConfigs.INSTANCE.getStatViewLoading();
            if (statViewLoading != null) {
                BasicLoadMoreQuickAdapter<?, ?> basicLoadMoreQuickAdapter = this.adapter;
                basicLoadMoreQuickAdapter.setEmptyView(statViewLoading.onCreateView(basicLoadMoreQuickAdapter.getContext()));
            } else {
                this.adapter.setEmptyView(this.defLoadingViewLayoutResId);
            }
            this.isLoadingViewLoaded = true;
        }
    }

    @Nullable
    public final View getDefEmptyView() {
        return this.defEmptyView;
    }

    @Nullable
    public final String getDefEmptyViewContent() {
        return this.defEmptyViewContent;
    }

    @Nullable
    public final Drawable getDefEmptyViewIcon() {
        return this.defEmptyViewIcon;
    }

    public final int getDefLoadingViewLayoutResId() {
        return this.defLoadingViewLayoutResId;
    }

    public final int getEmptyViewBgColor() {
        return this.emptyViewBgColor;
    }

    public final int getEmptyViewLayoutResId() {
        return this.emptyViewLayoutResId;
    }

    @Nullable
    public final View getErrorView() {
        return this.errorView;
    }

    /* renamed from: isShowEmptyView, reason: from getter */
    public final boolean getIsShowEmptyView() {
        return this.isShowEmptyView;
    }

    /* renamed from: isShowLoadingView, reason: from getter */
    public final boolean getIsShowLoadingView() {
        return this.isShowLoadingView;
    }

    public final void onAttachedToRecyclerView() {
        BasicLoadMoreQuickAdapter<?, ?> basicLoadMoreQuickAdapter = this.adapter;
        if (basicLoadMoreQuickAdapter.getData().size() == 0 && !basicLoadMoreQuickAdapter.hasEmptyView()) {
            onStateChange(new State(1));
        }
    }

    public final void onReload() {
        Function0<Unit> function0 = this.mReloadListener;
        if (function0 != null) {
            function0.invoke();
        }
        this.isLoadingViewLoaded = false;
        onStateChange(new State(1));
    }

    public final void onStateChange(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.adapter.getRecyclerViewOrNull() == null) {
            return;
        }
        int status = state.getStatus();
        if (status != 1) {
            if (status != 2) {
                if (status == 3) {
                    if (this.mReloadListener != null) {
                        showViewError();
                        return;
                    } else {
                        showViewEmpty();
                        return;
                    }
                }
                return;
            }
            showViewEmpty();
            return;
        }
        showViewLoading();
    }

    public final void setDefEmptyView(@Nullable View view) {
        this.defEmptyView = view;
    }

    public final void setDefEmptyViewContent(@Nullable String str) {
        this.defEmptyViewContent = str;
    }

    public final void setDefEmptyViewIcon(@Nullable Drawable drawable) {
        this.defEmptyViewIcon = drawable;
    }

    public final void setDefLoadingViewLayoutResId(int i10) {
        this.defLoadingViewLayoutResId = i10;
    }

    public final void setEmptyViewBgColor(int i10) {
        this.emptyViewBgColor = i10;
    }

    public final void setEmptyViewLayoutResId(int i10) {
        this.emptyViewLayoutResId = i10;
    }

    public final void setErrorView(@Nullable View view) {
        this.errorView = view;
    }

    public final void setReloadListener(@Nullable Function0<Unit> reloadListener) {
        this.mReloadListener = reloadListener;
    }

    public final void setShowEmptyView(boolean z10) {
        this.isShowEmptyView = z10;
    }

    public final void setShowLoadingView(boolean z10) {
        this.isShowLoadingView = z10;
    }
}
