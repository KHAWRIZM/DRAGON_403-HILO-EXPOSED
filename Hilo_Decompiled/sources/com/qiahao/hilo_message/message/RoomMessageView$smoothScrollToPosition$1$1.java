package com.qiahao.hilo_message.message;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"com/qiahao/hilo_message/message/RoomMessageView$smoothScrollToPosition$1$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "onStop", "", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoomMessageView$smoothScrollToPosition$1$1 extends LinearSmoothScroller {
    final /* synthetic */ float $speed;
    final /* synthetic */ RoomMessageView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomMessageView$smoothScrollToPosition$1$1(float f10, RoomMessageView roomMessageView, Context context) {
        super(context);
        this.$speed = f10;
        this.this$0 = roomMessageView;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        return this.$speed / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onStop() {
        boolean z10;
        super.onStop();
        this.this$0.isSmoothScrolling = false;
        z10 = this.this$0.hasNewScroll;
        if (z10) {
            this.this$0.hasNewScroll = false;
            final int size = this.this$0.getMAdapter().getData().size() - 1;
            if (size > 0) {
                final RoomMessageView roomMessageView = this.this$0;
                roomMessageView.post(new Runnable() { // from class: com.qiahao.hilo_message.message.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        RoomMessageView.this.smoothScrollToPosition(size, 700.0f);
                    }
                });
            }
        }
    }
}
