package com.qiahao.nextvideo.ui.home.chat;

import android.util.Log;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H&J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/OnLoadMoreListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "()V", "mLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setMLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "itemCount", "", "getItemCount", "()I", "setItemCount", "(I)V", "lastPosition", "getLastPosition", "setLastPosition", "lastItemCount", "getLastItemCount", "setLastItemCount", "loadMore", "", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class OnLoadMoreListener extends RecyclerView.OnScrollListener {

    @NotNull
    private static final String TAG = "HorizontalInteractiveVi";
    private int itemCount;
    private int lastItemCount;
    private int lastPosition;

    @Nullable
    private LinearLayoutManager mLayoutManager;

    public final int getItemCount() {
        return this.itemCount;
    }

    public final int getLastItemCount() {
        return this.lastItemCount;
    }

    public final int getLastPosition() {
        return this.lastPosition;
    }

    @Nullable
    public final LinearLayoutManager getMLayoutManager() {
        return this.mLayoutManager;
    }

    public abstract void loadMore();

    public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = layoutManager;
            this.mLayoutManager = linearLayoutManager;
            Intrinsics.checkNotNull(linearLayoutManager);
            this.itemCount = linearLayoutManager.getItemCount();
            LinearLayoutManager linearLayoutManager2 = this.mLayoutManager;
            Intrinsics.checkNotNull(linearLayoutManager2);
            int findLastCompletelyVisibleItemPosition = linearLayoutManager2.findLastCompletelyVisibleItemPosition();
            this.lastPosition = findLastCompletelyVisibleItemPosition;
            int i = this.lastItemCount;
            int i2 = this.itemCount;
            if (i != i2 && findLastCompletelyVisibleItemPosition == i2 - 1) {
                this.lastItemCount = i2;
                loadMore();
                return;
            }
            return;
        }
        Log.e(TAG, "onScrolled: 目前只支持横向竖向 不支持其他的layoutmanager");
    }

    public final void setItemCount(int i) {
        this.itemCount = i;
    }

    public final void setLastItemCount(int i) {
        this.lastItemCount = i;
    }

    public final void setLastPosition(int i) {
        this.lastPosition = i;
    }

    public final void setMLayoutManager(@Nullable LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }
}
