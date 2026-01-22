package com.qiahao.nextvideo.room.luckyfruit;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nH\u0014J\b\u0010$\u001a\u00020!H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R8\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0018\u0018\u00010\u00172\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0018\u0018\u00010\u0017@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "rowCount", "getRowCount", "()I", "setRowCount", "(I)V", "mWidth", "mHeight", "minWidth", "value", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter;", "Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView$BaseBean;", "adapter", "getAdapter", "()Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter;", "setAdapter", "(Lcom/qiahao/nextvideo/room/luckyfruit/LuckyGridViewAdapter;)V", "getItemWidth", "getItemHeight", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "initViews", "BaseBean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class LuckyBaseGridView extends FrameLayout {

    @NotNull
    private final String TAG;

    @Nullable
    private LuckyGridViewAdapter<? extends BaseBean> adapter;
    private int mHeight;
    private int mWidth;
    private int minWidth;
    private int rowCount;

    @Keep
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyBaseGridView$BaseBean;", "", "getId", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface BaseBean {
        int getId();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyBaseGridView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "LuckyBaseGridView";
        this.rowCount = 3;
        this.mWidth = RoomEvent.ROOM_MIC_EMOJI;
        this.mHeight = RoomEvent.ROOM_MIC_EMOJI;
        this.minWidth = RoomEvent.ROOM_MIC_EMOJI;
    }

    private final void initViews() {
        int i = this.rowCount;
        if (i <= 0) {
            Log.e(this.TAG, "rowCount Wrong");
            return;
        }
        LuckyGridViewAdapter<? extends BaseBean> luckyGridViewAdapter = this.adapter;
        if (luckyGridViewAdapter != null) {
            int i2 = (i - 1) * 4;
            int i3 = this.mWidth / i;
            int i4 = this.mHeight / i;
            View centerView = luckyGridViewAdapter.getCenterView();
            int i5 = -2;
            if (centerView != null) {
                removeView(centerView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                int i6 = this.rowCount;
                layoutParams.width = (i6 - 2) * i3;
                layoutParams.height = (i6 - 2) * i4;
                layoutParams.leftMargin = i3;
                layoutParams.topMargin = i4;
                centerView.setLayoutParams(layoutParams);
                addView(centerView);
            }
            int i7 = -i3;
            int i8 = -i4;
            Iterator<View> it = luckyGridViewAdapter.getListView().iterator();
            while (it.hasNext()) {
                removeView(it.next());
            }
            luckyGridViewAdapter.getListView().clear();
            int size = luckyGridViewAdapter.getListData().size();
            int i9 = 0;
            int i10 = 0;
            while (i9 < size) {
                if (i9 >= i2) {
                    return;
                }
                View onCreateItemView = luckyGridViewAdapter.onCreateItemView();
                if (onCreateItemView != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i5, i5);
                    layoutParams2.width = i3;
                    layoutParams2.height = i4;
                    if (i10 != 0) {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                if (i10 == 3) {
                                    i8 -= i4;
                                    i7 = 0;
                                }
                            } else {
                                i7 -= i3;
                                i8 = (this.rowCount - 1) * i4;
                            }
                        } else {
                            i7 = (this.rowCount - 1) * i3;
                            i8 += i4;
                        }
                    } else {
                        i7 += i3;
                        i8 = 0;
                    }
                    int i11 = this.rowCount;
                    if (i9 == i11 - 1) {
                        i10 = 1;
                    } else if (i9 == (i11 * 2) - 2) {
                        i10 = 2;
                    } else if (i9 == (i11 * 3) - 3) {
                        i10 = 3;
                    }
                    layoutParams2.leftMargin = i7;
                    layoutParams2.topMargin = i8;
                    Log.d(this.TAG, i10 + "___" + i7 + "___" + i8);
                    onCreateItemView.setLayoutParams(layoutParams2);
                    addView(onCreateItemView);
                    luckyGridViewAdapter.getListView().add(onCreateItemView);
                    luckyGridViewAdapter.bindData(i9);
                }
                i9++;
                i5 = -2;
            }
            luckyGridViewAdapter.onAddView(this);
        }
    }

    @Nullable
    public final LuckyGridViewAdapter<? extends BaseBean> getAdapter() {
        return this.adapter;
    }

    public final int getItemHeight() {
        return this.mHeight / this.rowCount;
    }

    public final int getItemWidth() {
        return this.mWidth / this.rowCount;
    }

    public final int getRowCount() {
        return this.rowCount;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                int i = this.minWidth;
                this.mWidth = i;
                this.mHeight = i;
            } else {
                this.mWidth = size;
                this.mHeight = size2;
            }
        } else {
            this.mWidth = RangesKt.coerceAtMost(this.minWidth, size);
            this.mHeight = RangesKt.coerceAtMost(this.minWidth, size);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setAdapter(@Nullable LuckyGridViewAdapter<? extends BaseBean> luckyGridViewAdapter) {
        this.adapter = luckyGridViewAdapter;
        initViews();
    }

    public final void setRowCount(int i) {
        this.rowCount = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyBaseGridView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "LuckyBaseGridView";
        this.rowCount = 3;
        this.mWidth = RoomEvent.ROOM_MIC_EMOJI;
        this.mHeight = RoomEvent.ROOM_MIC_EMOJI;
        this.minWidth = RoomEvent.ROOM_MIC_EMOJI;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyBaseGridView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "LuckyBaseGridView";
        this.rowCount = 3;
        this.mWidth = RoomEvent.ROOM_MIC_EMOJI;
        this.mHeight = RoomEvent.ROOM_MIC_EMOJI;
        this.minWidth = RoomEvent.ROOM_MIC_EMOJI;
    }
}
