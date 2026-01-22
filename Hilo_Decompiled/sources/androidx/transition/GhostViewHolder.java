package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

@SuppressLint({"ViewConstructor"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class GhostViewHolder extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f٤٢٢٠a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٤٢٢١b;

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (this.f٤٢٢١b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f٤٢٢٠a.setTag(R.id.ghost_view_holder, null);
            this.f٤٢٢٠a.getOverlay().remove(this);
            this.f٤٢٢١b = false;
        }
    }
}
