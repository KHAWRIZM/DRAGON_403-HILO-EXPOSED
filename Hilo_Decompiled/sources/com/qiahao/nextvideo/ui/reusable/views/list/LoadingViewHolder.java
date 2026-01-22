package com.qiahao.nextvideo.ui.reusable.views.list;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qiahao.nextvideo.R;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/list/LoadingViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "v", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "statusBarText", "Landroid/widget/TextView;", "getStatusBarText", "()Landroid/widget/TextView;", "setStatusBarText", "(Landroid/widget/TextView;)V", "setLoading", "", "setMessage", Constants.SHARED_MESSAGE_ID_FILE, "", "setRetry", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class LoadingViewHolder extends ViewHolder {

    @NotNull
    private ProgressBar progressBar;

    @NotNull
    private TextView statusBarText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "v");
        View findViewById = view.findViewById(R.id.cell_loading_progress_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.progressBar = (ProgressBar) findViewById;
        View findViewById2 = view.findViewById(R.id.cell_loading_status_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.statusBarText = (TextView) findViewById2;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        return this.progressBar;
    }

    @NotNull
    public final TextView getStatusBarText() {
        return this.statusBarText;
    }

    public final void setLoading() {
        this.progressBar.setVisibility(0);
        this.statusBarText.setVisibility(8);
    }

    public final void setMessage(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        this.progressBar.setVisibility(8);
        this.statusBarText.setText(message);
        this.statusBarText.setVisibility(0);
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkNotNullParameter(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    public final void setRetry() {
        this.progressBar.setVisibility(8);
        this.statusBarText.setVisibility(8);
    }

    public final void setStatusBarText(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.statusBarText = textView;
    }
}
