package com.qiahao.nextvideo.view.planet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0007H&J\u0006\u0010\u0017\u001a\u00020\u0014J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetAdapter;", "", "<init>", "()V", "onDataSetChangeListener", "Lcom/qiahao/nextvideo/view/planet/PlanetAdapter$OnDataSetChangeListener;", "getCount", "", "getGetCount", "()I", "getView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "parent", "Landroid/view/ViewGroup;", "getItem", "getPopularity", "onThemeColorChanged", "", "view", "themeColor", "notifyDataSetChanged", "setOnDataSetChangeListener", "listener", "OnDataSetChangeListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class PlanetAdapter {

    @Nullable
    private OnDataSetChangeListener onDataSetChangeListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetAdapter$OnDataSetChangeListener;", "", "onChange", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface OnDataSetChangeListener {
        void onChange();
    }

    public abstract int getGetCount();

    @Nullable
    public abstract Object getItem(int position);

    public abstract int getPopularity(int position);

    @Nullable
    public abstract View getView(@Nullable Context context, int position, @Nullable ViewGroup parent);

    public final void notifyDataSetChanged() {
        OnDataSetChangeListener onDataSetChangeListener = this.onDataSetChangeListener;
        if (onDataSetChangeListener != null && onDataSetChangeListener != null) {
            onDataSetChangeListener.onChange();
        }
    }

    public abstract void onThemeColorChanged(@Nullable View view, int themeColor);

    public final void setOnDataSetChangeListener(@Nullable OnDataSetChangeListener listener) {
        this.onDataSetChangeListener = listener;
    }
}
