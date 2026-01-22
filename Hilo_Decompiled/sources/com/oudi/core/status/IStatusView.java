package com.oudi.core.status;

import android.view.View;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0002\u0016\u0017J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/oudi/core/status/IStatusView;", "", "switchStatus", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/oudi/core/status/Status;", "delayMillis", "", "getStatus", "addStatus", "statusView", "Landroid/view/View;", "statusLayoutId", "", "removeStatus", "", "setOnStatusChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/oudi/core/status/IStatusView$OnStatusChangeListener;", "setOnRetryClickListener", "Lcom/oudi/core/status/IStatusView$OnRetryClickListener;", "getViewByStatus", "OnStatusChangeListener", "OnRetryClickListener", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IStatusView {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void switchStatus$default(IStatusView iStatusView, Status status, long j10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    j10 = 0;
                }
                iStatusView.switchStatus(status, j10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchStatus");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/oudi/core/status/IStatusView$OnRetryClickListener;", "", "onRetry", "", "statusView", "Lcom/oudi/core/status/IStatusView;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/oudi/core/status/Status;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface OnRetryClickListener {
        void onRetry(@NotNull IStatusView statusView, @NotNull Status status);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/oudi/core/status/IStatusView$OnStatusChangeListener;", "", "onChange", "", "newStatus", "Lcom/oudi/core/status/Status;", "oldStatus", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface OnStatusChangeListener {
        void onChange(@NotNull Status newStatus, @NotNull Status oldStatus);
    }

    void addStatus(@NotNull Status status, int statusLayoutId);

    void addStatus(@NotNull Status status, @NotNull View statusView);

    @NotNull
    Status getStatus();

    @Nullable
    View getViewByStatus(@NotNull Status status);

    boolean removeStatus(@NotNull Status status);

    void setOnRetryClickListener(@Nullable OnRetryClickListener listener);

    void setOnStatusChangeListener(@Nullable OnStatusChangeListener listener);

    void switchStatus(@NotNull Status status, long delayMillis);
}
