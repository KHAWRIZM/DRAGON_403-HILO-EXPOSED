package com.qiahao.nextvideo.ui.reusable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qiahao.nextvideo.databinding.ViewMaskCoverRemoteBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0019R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/RemoteMaskCoverWrapper;", "", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "binding", "Lcom/qiahao/nextvideo/databinding/ViewMaskCoverRemoteBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewMaskCoverRemoteBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewMaskCoverRemoteBinding;)V", "mListener", "Lcom/qiahao/nextvideo/ui/reusable/RemoteListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/reusable/RemoteListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/reusable/RemoteListener;)V", "progressCountDownTimer", "Lcom/qiahao/nextvideo/ui/reusable/ProgressCountDownTimer;", "show", "", "releaseCountDownTimer", "hide", "isShowing", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RemoteMaskCoverWrapper {

    @NotNull
    private ViewMaskCoverRemoteBinding binding;

    @Nullable
    private RemoteListener mListener;

    @Nullable
    private ProgressCountDownTimer progressCountDownTimer;

    public RemoteMaskCoverWrapper(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewMaskCoverRemoteBinding inflate = ViewMaskCoverRemoteBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        hide();
        this.binding.rematchButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoteMaskCoverWrapper._init_$lambda$0(RemoteMaskCoverWrapper.this, view);
            }
        });
        this.binding.removeMaskButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoteMaskCoverWrapper._init_$lambda$1(RemoteMaskCoverWrapper.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(RemoteMaskCoverWrapper remoteMaskCoverWrapper, View view) {
        RemoteListener remoteListener = remoteMaskCoverWrapper.mListener;
        if (remoteListener != null) {
            remoteListener.remoteRematch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(RemoteMaskCoverWrapper remoteMaskCoverWrapper, View view) {
        RemoteListener remoteListener = remoteMaskCoverWrapper.mListener;
        if (remoteListener != null) {
            remoteListener.remoteRemove();
        }
    }

    private final void releaseCountDownTimer() {
        ProgressCountDownTimer progressCountDownTimer = this.progressCountDownTimer;
        if (progressCountDownTimer != null) {
            if (progressCountDownTimer != null) {
                progressCountDownTimer.cancel();
            }
            this.progressCountDownTimer = null;
        }
    }

    @NotNull
    public final ViewMaskCoverRemoteBinding getBinding() {
        return this.binding;
    }

    @Nullable
    public final RemoteListener getMListener() {
        return this.mListener;
    }

    public final void hide() {
        releaseCountDownTimer();
        this.binding.getRoot().setVisibility(4);
        ViewMaskCoverRemoteBinding viewMaskCoverRemoteBinding = this.binding;
        viewMaskCoverRemoteBinding.removeMaskButton.setText(viewMaskCoverRemoteBinding.getRoot().getContext().getString(2131953906));
    }

    public final boolean isShowing() {
        if (this.binding.getRoot().getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void setBinding(@NotNull ViewMaskCoverRemoteBinding viewMaskCoverRemoteBinding) {
        Intrinsics.checkNotNullParameter(viewMaskCoverRemoteBinding, "<set-?>");
        this.binding = viewMaskCoverRemoteBinding;
    }

    public final void setMListener(@Nullable RemoteListener remoteListener) {
        this.mListener = remoteListener;
    }

    public final void show() {
        releaseCountDownTimer();
        ProgressCountDownTimer progressCountDownTimer = new ProgressCountDownTimer(this.binding, 0L, 0L, 6, null);
        this.progressCountDownTimer = progressCountDownTimer;
        progressCountDownTimer.start();
        this.binding.getRoot().setVisibility(0);
        this.binding.removeMaskButton.setEnabled(false);
        this.binding.removeMaskButton.setAlpha(0.45f);
        ViewMaskCoverRemoteBinding viewMaskCoverRemoteBinding = this.binding;
        viewMaskCoverRemoteBinding.removeMaskButton.setText(viewMaskCoverRemoteBinding.getRoot().getContext().getString(2131953904) + "(5s)");
    }
}
