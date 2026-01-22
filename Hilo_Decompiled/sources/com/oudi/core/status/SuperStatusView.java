package com.oudi.core.status;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.core.R;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\"\u00108\u001a\u0002092\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020=H\u0016J\u000e\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000fJ\b\u0010>\u001a\u00020\u000fH\u0016J\u0018\u0010?\u001a\u0002092\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u0017H\u0016J\u001a\u0010?\u001a\u0002092\u0006\u0010;\u001a\u00020\u000f2\b\b\u0001\u0010A\u001a\u00020\fH\u0016J\u0010\u0010B\u001a\u00020C2\u0006\u0010;\u001a\u00020\u000fH\u0016J\u0010\u0010D\u001a\u0002092\u0006\u0010;\u001a\u00020\u000fH\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\u00172\u0006\u0010;\u001a\u00020\u000fH\u0002J\u0010\u0010F\u001a\u0002092\u0006\u0010G\u001a\u00020\u0017H\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010G\u001a\u00020\u0017H\u0002J\b\u0010I\u001a\u000209H\u0002J\u0012\u0010J\u001a\u0004\u0018\u00010\u00172\u0006\u0010;\u001a\u00020\u000fH\u0016J\u0006\u0010K\u001a\u000209J\u0006\u0010L\u001a\u000209J\u0006\u0010M\u001a\u000209J\u0006\u0010N\u001a\u000209J\u0006\u0010O\u001a\u000209J\u0012\u0010P\u001a\u0002092\b\u0010Q\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010R\u001a\u0002092\b\u0010S\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010T\u001a\u0002092\b\u0010S\u001a\u0004\u0018\u00010,H\u0016J\b\u0010U\u001a\u000209H\u0014J\b\u0010V\u001a\u000209H\u0014R\u001a\u0010\u000e\u001a\u00020\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R?\u0010\u0014\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\u0017`\u00188DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR?\u0010\u001d\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\f0\u0015j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0016\u0012\u0004\u0012\u00020\f`\u00188DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u001b\u0010 \u001a\u00020!8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0002028DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001c\u001a\u0004\b3\u00104R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/oudi/core/status/SuperStatusView;", "Landroid/widget/RelativeLayout;", "Lcom/oudi/core/status/IStatusView;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "statusType", "Lcom/oudi/core/status/Status;", "getStatusType", "()Lcom/oudi/core/status/Status;", "setStatusType", "(Lcom/oudi/core/status/Status;)V", "statusViews", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "getStatusViews", "()Ljava/util/HashMap;", "statusViews$delegate", "Lkotlin/Lazy;", "statusLayoutIds", "getStatusLayoutIds", "statusLayoutIds$delegate", "inflater", "Landroid/view/LayoutInflater;", "getInflater", "()Landroid/view/LayoutInflater;", "inflater$delegate", "statusChangeListener", "Lcom/oudi/core/status/IStatusView$OnStatusChangeListener;", "getStatusChangeListener", "()Lcom/oudi/core/status/IStatusView$OnStatusChangeListener;", "setStatusChangeListener", "(Lcom/oudi/core/status/IStatusView$OnStatusChangeListener;)V", "retryClickListener", "Lcom/oudi/core/status/IStatusView$OnRetryClickListener;", "getRetryClickListener", "()Lcom/oudi/core/status/IStatusView$OnRetryClickListener;", "setRetryClickListener", "(Lcom/oudi/core/status/IStatusView$OnRetryClickListener;)V", "defaultLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "getDefaultLayoutParams", "()Landroid/widget/RelativeLayout$LayoutParams;", "defaultLayoutParams$delegate", "delaySetRunnable", "Ljava/lang/Runnable;", "init", "", "switchStatus", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "delayMillis", "", "getStatus", "addStatus", "statusView", "statusLayoutId", "removeStatus", "", "changeStatus", "checkGenerateView", "checkAddView", ViewHierarchyConstants.VIEW_KEY, "switchView", "switchContentView", "getViewByStatus", "showContent", "showError", "showLoading", "showEmpty", "showNoNetwork", "onClick", "v", "setOnStatusChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnRetryClickListener", "onFinishInflate", "onDetachedFromWindow", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperStatusView extends RelativeLayout implements IStatusView, View.OnClickListener {

    /* renamed from: defaultLayoutParams$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultLayoutParams;

    @Nullable
    private Runnable delaySetRunnable;

    /* renamed from: inflater$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inflater;

    @Nullable
    private IStatusView.OnRetryClickListener retryClickListener;

    @Nullable
    private IStatusView.OnStatusChangeListener statusChangeListener;

    /* renamed from: statusLayoutIds$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy statusLayoutIds;

    @NotNull
    private Status statusType;

    /* renamed from: statusViews$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy statusViews;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuperStatusView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void changeStatus(Status status) {
        IStatusView.OnStatusChangeListener onStatusChangeListener;
        if (!Intrinsics.areEqual(this.statusType, Status.Default.INSTANCE) && (onStatusChangeListener = this.statusChangeListener) != null) {
            onStatusChangeListener.onChange(status, this.statusType);
        }
        this.statusType = status;
    }

    private final void checkAddView(View view) {
        if (indexOfChild(view) < 0) {
            View findViewById = view.findViewById(R.id.status_retry_view);
            if (findViewById != null) {
                findViewById.setOnClickListener(this);
            }
            addView(view, -1, getDefaultLayoutParams());
            view.setVisibility(8);
        }
    }

    private final View checkGenerateView(Status status) {
        int intValue;
        View view = getStatusViews().get(status.getClass());
        if (view != null) {
            return view;
        }
        Integer num = getStatusLayoutIds().get(status.getClass());
        if (num == null || (intValue = num.intValue()) <= 0) {
            return null;
        }
        View inflate = getInflater().inflate(intValue, (ViewGroup) null);
        getStatusViews().put(status.getClass(), inflate);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RelativeLayout.LayoutParams defaultLayoutParams_delegate$lambda$3() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutInflater inflater_delegate$lambda$2(SuperStatusView superStatusView) {
        return LayoutInflater.from(superStatusView.getContext());
    }

    private final void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.XSuperStatusView, defStyleAttr, defStyleAttr);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        getStatusLayoutIds().put(Status.Content.class, Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.XSuperStatusView_status_content_layout, -1)));
        getStatusLayoutIds().put(Status.Empty.class, Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.XSuperStatusView_status_empty_layout, -1)));
        getStatusLayoutIds().put(Status.Error.class, Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.XSuperStatusView_status_error_layout, -1)));
        getStatusLayoutIds().put(Status.Loading.class, Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.XSuperStatusView_status_loading_layout, -1)));
        getStatusLayoutIds().put(Status.NoNetwork.class, Integer.valueOf(obtainStyledAttributes.getResourceId(R.styleable.XSuperStatusView_status_no_network_layout, -1)));
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap statusLayoutIds_delegate$lambda$1() {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap statusViews_delegate$lambda$0() {
        return new HashMap();
    }

    private final void switchContentView() {
        int i10;
        View checkGenerateView = checkGenerateView(Status.Content.INSTANCE);
        if (checkGenerateView != null) {
            switchView(checkGenerateView);
            return;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (getStatusViews().containsValue(childAt)) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            childAt.setVisibility(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void switchStatus$lambda$5(SuperStatusView superStatusView, Status status) {
        superStatusView.delaySetRunnable = null;
        superStatusView.switchStatus(status);
    }

    private final void switchView(View view) {
        int i10;
        checkAddView(view);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (Intrinsics.areEqual(childAt, view)) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            childAt.setVisibility(i10);
        }
    }

    @Override // com.oudi.core.status.IStatusView
    public void addStatus(@NotNull Status status, @NotNull View statusView) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(statusView, "statusView");
        getStatusViews().put(status.getClass(), statusView);
        getStatusLayoutIds().put(status.getClass(), Integer.valueOf(statusView.getId()));
    }

    @NotNull
    public final RelativeLayout.LayoutParams getDefaultLayoutParams() {
        return (RelativeLayout.LayoutParams) this.defaultLayoutParams.getValue();
    }

    @NotNull
    public final LayoutInflater getInflater() {
        Object value = this.inflater.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (LayoutInflater) value;
    }

    @Nullable
    public final IStatusView.OnRetryClickListener getRetryClickListener() {
        return this.retryClickListener;
    }

    @Override // com.oudi.core.status.IStatusView
    @NotNull
    /* renamed from: getStatus, reason: from getter */
    public Status getStatusType() {
        return this.statusType;
    }

    @Nullable
    public final IStatusView.OnStatusChangeListener getStatusChangeListener() {
        return this.statusChangeListener;
    }

    @NotNull
    public final HashMap<Class<?>, Integer> getStatusLayoutIds() {
        return (HashMap) this.statusLayoutIds.getValue();
    }

    @NotNull
    public final Status getStatusType() {
        return this.statusType;
    }

    @NotNull
    public final HashMap<Class<?>, View> getStatusViews() {
        return (HashMap) this.statusViews.getValue();
    }

    @Override // com.oudi.core.status.IStatusView
    @Nullable
    public View getViewByStatus(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        View checkGenerateView = checkGenerateView(status);
        if (checkGenerateView != null) {
            checkAddView(checkGenerateView);
            return checkGenerateView;
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v10) {
        IStatusView.OnRetryClickListener onRetryClickListener;
        if (!Intrinsics.areEqual(this.statusType, Status.Default.INSTANCE) && (onRetryClickListener = this.retryClickListener) != null) {
            onRetryClickListener.onRetry(this, this.statusType);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getStatusViews().clear();
        getStatusLayoutIds().clear();
        this.retryClickListener = null;
        this.statusChangeListener = null;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        switchStatus(Status.Content.INSTANCE);
    }

    @Override // com.oudi.core.status.IStatusView
    public boolean removeStatus(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (!getStatusType().equals(status) && !status.equals((Status) Status.Default.INSTANCE)) {
            getStatusViews().remove(status.getClass());
            getStatusLayoutIds().remove(status.getClass());
            return true;
        }
        return false;
    }

    @Override // com.oudi.core.status.IStatusView
    public void setOnRetryClickListener(@Nullable IStatusView.OnRetryClickListener listener) {
        this.retryClickListener = listener;
    }

    @Override // com.oudi.core.status.IStatusView
    public void setOnStatusChangeListener(@Nullable IStatusView.OnStatusChangeListener listener) {
        this.statusChangeListener = listener;
    }

    public final void setRetryClickListener(@Nullable IStatusView.OnRetryClickListener onRetryClickListener) {
        this.retryClickListener = onRetryClickListener;
    }

    public final void setStatusChangeListener(@Nullable IStatusView.OnStatusChangeListener onStatusChangeListener) {
        this.statusChangeListener = onStatusChangeListener;
    }

    public final void setStatusType(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "<set-?>");
        this.statusType = status;
    }

    public final void showContent() {
        switchStatus(Status.Content.INSTANCE);
    }

    public final void showEmpty() {
        switchStatus(Status.Empty.INSTANCE);
    }

    public final void showError() {
        switchStatus(Status.Error.INSTANCE);
    }

    public final void showLoading() {
        switchStatus(Status.Loading.INSTANCE);
    }

    public final void showNoNetwork() {
        switchStatus(Status.NoNetwork.INSTANCE);
    }

    @Override // com.oudi.core.status.IStatusView
    public void switchStatus(@NotNull final Status status, long delayMillis) {
        Intrinsics.checkNotNullParameter(status, "status");
        Runnable runnable = this.delaySetRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.delaySetRunnable = null;
        }
        if (delayMillis > 0) {
            Runnable runnable2 = new Runnable() { // from class: com.oudi.core.status.g
                @Override // java.lang.Runnable
                public final void run() {
                    SuperStatusView.switchStatus$lambda$5(SuperStatusView.this, status);
                }
            };
            this.delaySetRunnable = runnable2;
            postDelayed(runnable2, delayMillis);
            return;
        }
        switchStatus(status);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuperStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.statusType = Status.Default.INSTANCE;
        this.statusViews = LazyKt.lazy(new Function0() { // from class: com.oudi.core.status.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                HashMap statusViews_delegate$lambda$0;
                statusViews_delegate$lambda$0 = SuperStatusView.statusViews_delegate$lambda$0();
                return statusViews_delegate$lambda$0;
            }
        });
        this.statusLayoutIds = LazyKt.lazy(new Function0() { // from class: com.oudi.core.status.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                HashMap statusLayoutIds_delegate$lambda$1;
                statusLayoutIds_delegate$lambda$1 = SuperStatusView.statusLayoutIds_delegate$lambda$1();
                return statusLayoutIds_delegate$lambda$1;
            }
        });
        this.inflater = LazyKt.lazy(new Function0() { // from class: com.oudi.core.status.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LayoutInflater inflater_delegate$lambda$2;
                inflater_delegate$lambda$2 = SuperStatusView.inflater_delegate$lambda$2(SuperStatusView.this);
                return inflater_delegate$lambda$2;
            }
        });
        this.defaultLayoutParams = LazyKt.lazy(new Function0() { // from class: com.oudi.core.status.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                RelativeLayout.LayoutParams defaultLayoutParams_delegate$lambda$3;
                defaultLayoutParams_delegate$lambda$3 = SuperStatusView.defaultLayoutParams_delegate$lambda$3();
                return defaultLayoutParams_delegate$lambda$3;
            }
        });
        init(context, attributeSet, i10);
    }

    @Override // com.oudi.core.status.IStatusView
    public void addStatus(@NotNull Status status, int statusLayoutId) {
        Intrinsics.checkNotNullParameter(status, "status");
        getStatusLayoutIds().put(status.getClass(), Integer.valueOf(statusLayoutId));
    }

    public final void switchStatus(@NotNull Status status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (Intrinsics.areEqual(this.statusType, status)) {
            return;
        }
        if (Intrinsics.areEqual(status, Status.Content.INSTANCE)) {
            switchContentView();
            changeStatus(status);
            return;
        }
        View checkGenerateView = checkGenerateView(status);
        if (checkGenerateView != null) {
            switchView(checkGenerateView);
            changeStatus(status);
        }
    }
}
