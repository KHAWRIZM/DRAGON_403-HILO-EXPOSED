package com.oudi.core.status;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.facebook.internal.AnalyticsEvents;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Ji\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010Js\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0015\u001a\u00020\t2\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010Js\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0015\u001a\u00020\t2\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010Jk\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0010JF\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001a¨\u0006\u001b"}, d2 = {"Lcom/oudi/core/status/StatusFactory;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/oudi/core/status/SuperStatusView;", "activity", "Landroid/app/Activity;", "loadingRes", "", "emptyRes", "errorRes", "noNetworkRes", "isAutoSwitchLoading", "", "onRetry", "Lkotlin/Function1;", "Lcom/oudi/core/status/Status;", "Lkotlin/ParameterName;", "name", "", "contentViewResId", "fragment", "Landroidx/fragment/app/Fragment;", "contentView", "Landroid/view/View;", "Lcom/oudi/core/status/IStatusView$OnRetryClickListener;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class StatusFactory {

    @NotNull
    public static final StatusFactory INSTANCE = new StatusFactory();

    private StatusFactory() {
    }

    @Nullable
    public final SuperStatusView status(@NotNull Activity activity, int loadingRes, int emptyRes, int errorRes, int noNetworkRes, boolean isAutoSwitchLoading, @Nullable Function1<? super Status, Unit> onRetry) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View findViewById = activity.findViewById(R.id.content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        return status(((ViewGroup) findViewById).getChildAt(0), loadingRes, emptyRes, errorRes, noNetworkRes, isAutoSwitchLoading, onRetry);
    }

    @Nullable
    public final SuperStatusView status(@NotNull Activity activity, int contentViewResId, int loadingRes, int emptyRes, int errorRes, int noNetworkRes, boolean isAutoSwitchLoading, @Nullable Function1<? super Status, Unit> onRetry) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View findViewById = activity.findViewById(R.id.content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        View findViewById2 = ((ViewGroup) findViewById).findViewById(contentViewResId);
        if (findViewById2 != null) {
            return INSTANCE.status(findViewById2, loadingRes, emptyRes, errorRes, noNetworkRes, isAutoSwitchLoading, onRetry);
        }
        return null;
    }

    @Nullable
    public final SuperStatusView status(@NotNull Fragment fragment, int contentViewResId, int loadingRes, int emptyRes, int errorRes, int noNetworkRes, boolean isAutoSwitchLoading, @Nullable Function1<? super Status, Unit> onRetry) {
        View findViewById;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        View view = fragment.getView();
        if (view == null || (findViewById = view.findViewById(contentViewResId)) == null) {
            return null;
        }
        return INSTANCE.status(findViewById, loadingRes, emptyRes, errorRes, noNetworkRes, isAutoSwitchLoading, onRetry);
    }

    @Nullable
    public final SuperStatusView status(@Nullable View contentView, int loadingRes, int emptyRes, int errorRes, int noNetworkRes, final boolean isAutoSwitchLoading, @Nullable final Function1<? super Status, Unit> onRetry) {
        return status(contentView, loadingRes, emptyRes, errorRes, noNetworkRes, new IStatusView.OnRetryClickListener() { // from class: com.oudi.core.status.StatusFactory$status$3
            @Override // com.oudi.core.status.IStatusView.OnRetryClickListener
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                if (isAutoSwitchLoading) {
                    IStatusView.DefaultImpls.switchStatus$default(statusView, Status.Loading.INSTANCE, 0L, 2, null);
                }
                Function1<Status, Unit> function1 = onRetry;
                if (function1 != null) {
                    function1.invoke(status);
                }
            }
        });
    }

    @Nullable
    public final SuperStatusView status(@Nullable View contentView, int loadingRes, int emptyRes, int errorRes, int noNetworkRes, @Nullable IStatusView.OnRetryClickListener onRetry) {
        ViewParent parent = contentView != null ? contentView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        int indexOfChild = viewGroup.indexOfChild(contentView);
        viewGroup.removeView(contentView);
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SuperStatusView superStatusView = new SuperStatusView(context);
        viewGroup.addView(superStatusView, indexOfChild, layoutParams);
        Status.Content content = Status.Content.INSTANCE;
        superStatusView.addStatus(content, contentView);
        superStatusView.addStatus(Status.Error.INSTANCE, errorRes);
        superStatusView.addStatus(Status.NoNetwork.INSTANCE, noNetworkRes);
        superStatusView.addStatus(Status.Empty.INSTANCE, emptyRes);
        superStatusView.addStatus(Status.Loading.INSTANCE, loadingRes);
        superStatusView.switchStatus(content);
        superStatusView.setOnRetryClickListener(onRetry);
        return superStatusView;
    }
}
