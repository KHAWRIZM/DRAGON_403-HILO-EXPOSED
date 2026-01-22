package com.qiahao.nextvideo.ui.videocall.videoIM;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.g;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.video.VideoIMEntity;
import com.qiahao.nextvideo.databinding.VideoImBinding;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020\u001eH\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/videoIM/VideoIM;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/qiahao/nextvideo/databinding/VideoImBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/VideoImBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/VideoImBinding;)V", "isScrollEnd", "", "()Z", "setScrollEnd", "(Z)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/videocall/videoIM/VideoIMAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/videocall/videoIM/VideoIMAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "initView", "", "addMessage", "data", "Lcom/qiahao/nextvideo/data/video/VideoIMEntity;", "scrollToEnd", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoIM extends FrameLayout {

    @Nullable
    private VideoImBinding binding;
    private boolean isScrollEnd;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoIM(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isScrollEnd = true;
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.videoIM.a
            public final Object invoke() {
                VideoIMAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = VideoIM.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        initView();
    }

    private final void initView() {
        VideoRecycleView videoRecycleView;
        VideoRecycleView videoRecycleView2;
        VideoRecycleView videoRecycleView3;
        VideoImBinding videoImBinding = (VideoImBinding) g.h(LayoutInflater.from(getContext()), R.layout.video_im, this, true);
        this.binding = videoImBinding;
        if (videoImBinding != null && (videoRecycleView3 = videoImBinding.recyclerView) != null) {
            videoRecycleView3.setAdapter(getMAdapter());
        }
        VideoImBinding videoImBinding2 = this.binding;
        if (videoImBinding2 != null && (videoRecycleView2 = videoImBinding2.recyclerView) != null) {
            videoRecycleView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.qiahao.nextvideo.ui.videocall.videoIM.VideoIM$initView$1
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    super.onScrollStateChanged(recyclerView, newState);
                    VideoIM videoIM = VideoIM.this;
                    if (newState == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    videoIM.setScrollEnd(z);
                }
            });
        }
        VideoImBinding videoImBinding3 = this.binding;
        if (videoImBinding3 != null && (videoRecycleView = videoImBinding3.recyclerView) != null) {
            videoRecycleView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.videocall.videoIM.VideoIM$initView$2
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.bottom = UiKtxKt.toPX(10);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoIMAdapter mAdapter_delegate$lambda$0() {
        return new VideoIMAdapter(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollToEnd() {
        RecyclerView recyclerView;
        VideoRecycleView videoRecycleView;
        if (this.isScrollEnd) {
            VideoImBinding videoImBinding = this.binding;
            if (videoImBinding != null && (videoRecycleView = videoImBinding.recyclerView) != null) {
                videoRecycleView.scrollToPosition(getMAdapter().getData().size() - 1);
                return;
            }
            return;
        }
        VideoImBinding videoImBinding2 = this.binding;
        if (videoImBinding2 != null && (recyclerView = videoImBinding2.recyclerView) != null) {
            recyclerView.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.videocall.videoIM.b
                @Override // java.lang.Runnable
                public final void run() {
                    VideoIM.this.scrollToEnd();
                }
            }, 500L);
        }
    }

    public final void addMessage(@NotNull VideoIMEntity data) {
        RecyclerView.LayoutManager layoutManager;
        VideoRecycleView videoRecycleView;
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            VideoImBinding videoImBinding = this.binding;
            if (videoImBinding != null && (videoRecycleView = videoImBinding.recyclerView) != null) {
                layoutManager = videoRecycleView.getLayoutManager();
            } else {
                layoutManager = null;
            }
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            boolean z = true;
            if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() != getMAdapter().getData().size() - 1) {
                z = false;
            }
            getMAdapter().addData(data);
            if (z) {
                scrollToEnd();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final VideoImBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final VideoIMAdapter getMAdapter() {
        return (VideoIMAdapter) this.mAdapter.getValue();
    }

    /* renamed from: isScrollEnd, reason: from getter */
    public final boolean getIsScrollEnd() {
        return this.isScrollEnd;
    }

    public final void setBinding(@Nullable VideoImBinding videoImBinding) {
        this.binding = videoImBinding;
    }

    public final void setScrollEnd(boolean z) {
        this.isScrollEnd = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoIM(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isScrollEnd = true;
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.videoIM.a
            public final Object invoke() {
                VideoIMAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = VideoIM.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoIM(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isScrollEnd = true;
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.videoIM.a
            public final Object invoke() {
                VideoIMAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = VideoIM.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
        initView();
    }
}
