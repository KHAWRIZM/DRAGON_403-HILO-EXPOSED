package com.qiahao.nextvideo.ui.home.discover;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/DiscoverBroadCastHandler;", "Landroid/os/Handler;", "mDiscoverBroadCast", "Lcom/qiahao/nextvideo/ui/home/discover/DiscoverBroadCastView;", "<init>", "(Lcom/qiahao/nextvideo/ui/home/discover/DiscoverBroadCastView;)V", "mBroadCastView", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiscoverBroadCastHandler extends Handler {

    @Nullable
    private WeakReference<DiscoverBroadCastView> mBroadCastView;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DiscoverBroadCastHandler(@NotNull DiscoverBroadCastView discoverBroadCastView) {
        super(r0);
        Intrinsics.checkNotNullParameter(discoverBroadCastView, "mDiscoverBroadCast");
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mBroadCastView = new WeakReference<>(discoverBroadCastView);
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg) {
        WeakReference<DiscoverBroadCastView> weakReference;
        DiscoverBroadCastView discoverBroadCastView;
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.handleMessage(msg);
        if (msg.what == 1 && (weakReference = this.mBroadCastView) != null && (discoverBroadCastView = weakReference.get()) != null) {
            discoverBroadCastView.setData();
        }
    }
}
