package com.oudi.core.status;

import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ac\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2#\b\u0002\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u001a@\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00042\b\b\u0003\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0011\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0002\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f\u001a-\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\u0016\u001a\u00020\u0004¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0016\u0010\u001b\u001a\u00020\u0010*\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0014\u0010\u001c\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0016\u0010\u001c\u001a\u00020\u0010*\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0014\u0010\u001d\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0016\u0010\u001d\u001a\u00020\u0010*\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0014\u0010\u001e\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0016\u0010\u001e\u001a\u00020\u0010*\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0014\u0010\u001f\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u0016\u0010\u001f\u001a\u00020\u0010*\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\"\u0010 \u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"\u001a$\u0010 \u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010#\u001a\u00020\u0004\u001a?\u0010$\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042#\u0010%\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00100\u000b\u001a\"\u0010$\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010%\u001a\u00020'\u001a7\u0010(\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u000b\u001a\u0012\u0010(\u001a\u00020\u0010*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0011¨\u0006)"}, d2 = {"statusConfig", "Lcom/oudi/core/status/SuperStatusView;", "Landroid/view/View;", "loadingRes", "", "emptyRes", "errorRes", "noNetworkRes", "isAutoSwitchLoading", "", "onRetry", "Lkotlin/Function1;", "Lcom/oudi/core/status/Status;", "Lkotlin/ParameterName;", "name", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "Lcom/oudi/core/status/IStatusView$OnRetryClickListener;", "getStatusView", "Lcom/oudi/core/status/IStatusView;", "getStatusChildView", "V", "viewId", "(Landroid/view/View;Lcom/oudi/core/status/Status;I)Landroid/view/View;", "switchStatus", "delayMillis", "", "showContent", "showLoading", "showError", "showEmpty", "showNoNetwork", "setStatusText", ViewHierarchyConstants.TEXT_KEY, "", "resId", "setOnStatusChildViewClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "v", "Landroid/view/View$OnClickListener;", "setOnStatusRetryListener", "lib_core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class StatusKtxKtKt {
    @Nullable
    public static final <V extends View> V getStatusChildView(@NotNull View view, @NotNull Status status, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        View statusView = getStatusView(view, status);
        if (statusView != null) {
            return (V) statusView.findViewById(i10);
        }
        return null;
    }

    @Nullable
    public static final IStatusView getStatusView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent instanceof IStatusView) {
            return (IStatusView) parent;
        }
        return null;
    }

    public static final void setOnStatusChildViewClickListener(@NotNull View view, @NotNull Status status, int i10, @NotNull final Function1<? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(listener, "listener");
        setOnStatusChildViewClickListener(view, status, i10, new View.OnClickListener() { // from class: com.oudi.core.status.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Function1.this.invoke(view2);
            }
        });
    }

    public static final void setOnStatusRetryListener(@NotNull View view, final boolean z10, @NotNull final Function1<? super Status, Boolean> onRetry) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        setOnStatusRetryListener(view, new IStatusView.OnRetryClickListener() { // from class: com.oudi.core.status.StatusKtxKtKt$setOnStatusRetryListener$1
            @Override // com.oudi.core.status.IStatusView.OnRetryClickListener
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                if (z10) {
                    IStatusView.DefaultImpls.switchStatus$default(statusView, Status.Loading.INSTANCE, 0L, 2, null);
                }
                onRetry.invoke(status);
            }
        });
    }

    public static /* synthetic */ void setOnStatusRetryListener$default(View view, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        setOnStatusRetryListener(view, z10, function1);
    }

    public static final void setStatusText(@NotNull View view, @NotNull Status status, int i10, @NotNull CharSequence text) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = (TextView) getStatusChildView(view, status, i10);
        if (textView != null) {
            textView.setText(text);
        }
    }

    public static final void showContent(@NotNull View view, long j10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            statusView.switchStatus(Status.Content.INSTANCE, j10);
        }
    }

    public static /* synthetic */ void showContent$default(View view, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showContent(view, j10);
    }

    public static final void showEmpty(@NotNull View view, long j10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            statusView.switchStatus(Status.Empty.INSTANCE, j10);
        }
    }

    public static /* synthetic */ void showEmpty$default(View view, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showEmpty(view, j10);
    }

    public static final void showError(@NotNull View view, long j10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            statusView.switchStatus(Status.Error.INSTANCE, j10);
        }
    }

    public static /* synthetic */ void showError$default(View view, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showError(view, j10);
    }

    public static final void showLoading(@NotNull View view, long j10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            statusView.switchStatus(Status.Loading.INSTANCE, j10);
        }
    }

    public static /* synthetic */ void showLoading$default(View view, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showLoading(view, j10);
    }

    public static final void showNoNetwork(@NotNull View view, long j10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            statusView.switchStatus(Status.NoNetwork.INSTANCE, j10);
        }
    }

    public static /* synthetic */ void showNoNetwork$default(View view, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showNoNetwork(view, j10);
    }

    @Nullable
    public static final SuperStatusView statusConfig(@NotNull View view, int i10, int i11, int i12, int i13, boolean z10, @NotNull Function1<? super Status, Unit> onRetry) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        return StatusFactory.INSTANCE.status(view, i10, i11, i12, i13, z10, onRetry);
    }

    public static /* synthetic */ SuperStatusView statusConfig$default(View view, int i10, int i11, int i12, int i13, boolean z10, Function1 function1, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = -1;
        }
        if ((i14 & 2) != 0) {
            i11 = -1;
        }
        if ((i14 & 4) != 0) {
            i12 = -1;
        }
        if ((i14 & 8) != 0) {
            i13 = -1;
        }
        if ((i14 & 16) != 0) {
            z10 = true;
        }
        if ((i14 & 32) != 0) {
            function1 = new Function1() { // from class: com.oudi.core.status.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit statusConfig$lambda$0;
                    statusConfig$lambda$0 = StatusKtxKtKt.statusConfig$lambda$0((Status) obj2);
                    return statusConfig$lambda$0;
                }
            };
        }
        return statusConfig(view, i10, i11, i12, i13, z10, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit statusConfig$lambda$0(Status it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void switchStatus(@NotNull View view, @NotNull Status status, long j10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            statusView.switchStatus(status, j10);
        }
    }

    public static /* synthetic */ void switchStatus$default(View view, Status status, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        switchStatus(view, status, j10);
    }

    @Nullable
    public static final View getStatusView(@NotNull View view, @NotNull Status status) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            return statusView.getViewByStatus(status);
        }
        return null;
    }

    public static final void setOnStatusChildViewClickListener(@NotNull View view, @NotNull Status status, int i10, @NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(listener, "listener");
        View statusChildView = getStatusChildView(view, status, i10);
        if (statusChildView != null) {
            statusChildView.setOnClickListener(listener);
        }
    }

    public static final void setOnStatusRetryListener(@NotNull View view, @NotNull IStatusView.OnRetryClickListener onRetry) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        IStatusView statusView = getStatusView(view);
        if (statusView != null) {
            statusView.setOnRetryClickListener(onRetry);
        }
    }

    public static final void setStatusText(@NotNull View view, @NotNull Status status, int i10, int i11) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(status, "status");
        TextView textView = (TextView) getStatusChildView(view, status, i10);
        if (textView != null) {
            textView.setText(i11);
        }
    }

    public static /* synthetic */ void showContent$default(IStatusView iStatusView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showContent(iStatusView, j10);
    }

    public static /* synthetic */ void showEmpty$default(IStatusView iStatusView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showEmpty(iStatusView, j10);
    }

    public static /* synthetic */ void showError$default(IStatusView iStatusView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showError(iStatusView, j10);
    }

    public static /* synthetic */ void showLoading$default(IStatusView iStatusView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showLoading(iStatusView, j10);
    }

    public static /* synthetic */ void showNoNetwork$default(IStatusView iStatusView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        showNoNetwork(iStatusView, j10);
    }

    @Nullable
    public static final SuperStatusView statusConfig(@NotNull View view, int i10, int i11, int i12, int i13, @Nullable IStatusView.OnRetryClickListener onRetryClickListener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return StatusFactory.INSTANCE.status(view, i10, i11, i12, i13, onRetryClickListener);
    }

    public static final void showContent(@Nullable IStatusView iStatusView, long j10) {
        if (iStatusView != null) {
            iStatusView.switchStatus(Status.Content.INSTANCE, j10);
        }
    }

    public static final void showEmpty(@Nullable IStatusView iStatusView, long j10) {
        if (iStatusView != null) {
            iStatusView.switchStatus(Status.Empty.INSTANCE, j10);
        }
    }

    public static final void showError(@Nullable IStatusView iStatusView, long j10) {
        if (iStatusView != null) {
            iStatusView.switchStatus(Status.Error.INSTANCE, j10);
        }
    }

    public static final void showLoading(@Nullable IStatusView iStatusView, long j10) {
        if (iStatusView != null) {
            iStatusView.switchStatus(Status.Loading.INSTANCE, j10);
        }
    }

    public static final void showNoNetwork(@Nullable IStatusView iStatusView, long j10) {
        if (iStatusView != null) {
            iStatusView.switchStatus(Status.NoNetwork.INSTANCE, j10);
        }
    }

    public static /* synthetic */ SuperStatusView statusConfig$default(View view, int i10, int i11, int i12, int i13, IStatusView.OnRetryClickListener onRetryClickListener, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = -1;
        }
        if ((i14 & 2) != 0) {
            i11 = -1;
        }
        if ((i14 & 4) != 0) {
            i12 = -1;
        }
        if ((i14 & 8) != 0) {
            i13 = -1;
        }
        if ((i14 & 16) != 0) {
            onRetryClickListener = null;
        }
        return statusConfig(view, i10, i11, i12, i13, onRetryClickListener);
    }
}
