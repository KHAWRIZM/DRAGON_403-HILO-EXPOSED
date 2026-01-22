package com.qiahao.nextvideo.ui.setting.connectionlogs;

import android.view.View;
import com.qiahao.nextvideo.databinding.CellConnectionLogBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/CellConnectionLogBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/CellConnectionLogBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/CellConnectionLogBinding;", VerificationCodeFragment.TYPE_BIND, "", "uiModel", "Lcom/qiahao/nextvideo/ui/setting/connectionlogs/ConnectionLogCellUIModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ConnectionLogViewHolder extends ViewHolder {

    @NotNull
    private final CellConnectionLogBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ConnectionLogViewHolder(@NotNull CellConnectionLogBinding cellConnectionLogBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(cellConnectionLogBinding, "binding");
        View root = cellConnectionLogBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = cellConnectionLogBinding;
    }

    public final void bind(@NotNull ConnectionLogCellUIModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        this.binding.dateTextView.setText(uiModel.getDate());
        this.binding.likeTextView.setText(uiModel.getLikeMeCount());
        this.binding.frequencyTextView.setText(uiModel.getFrequency());
        this.binding.durationTextView.setText(uiModel.getDuration());
    }

    @NotNull
    public final CellConnectionLogBinding getBinding() {
        return this.binding;
    }
}
