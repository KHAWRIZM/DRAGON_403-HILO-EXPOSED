package com.oudi.core.component;

import androidx.fragment.app.Fragment;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0015J\b\u0010\u000b\u001a\u00020\fH\u0017J\b\u0010\r\u001a\u00020\fH\u0017J\b\u0010\u000e\u001a\u00020\u0005H\u0004J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0014J\b\u0010\u0012\u001a\u00020\fH\u0014J\b\u0010\u0013\u001a\u00020\fH\u0014J\b\u0010\u0014\u001a\u00020\fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/oudi/core/component/SuperLazyFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "isLoaded", "", "()Z", "setLoaded", "(Z)V", "currentVisibleState", "isLazyLoad", "onResume", "", "onPause", "isSupportVisible", "dispatchVisibleState", "isVisible", "onFragmentFirstVisible", "onFragmentResume", "onFragmentPause", "onDestroyView", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperLazyFragment extends Fragment {
    private boolean currentVisibleState;
    private boolean isLoaded;

    private final void dispatchVisibleState(boolean isVisible) {
        this.currentVisibleState = isVisible;
        if (isVisible) {
            if (this.isLoaded) {
                onFragmentResume();
                return;
            } else {
                if (!isHidden()) {
                    this.isLoaded = true;
                    onFragmentFirstVisible();
                    return;
                }
                return;
            }
        }
        if (this.isLoaded) {
            onFragmentPause();
        }
    }

    @Deprecated(message = "懒加载控制权不在本类，改为由外层控制。")
    public boolean isLazyLoad() {
        return true;
    }

    /* renamed from: isLoaded, reason: from getter */
    public final boolean getIsLoaded() {
        return this.isLoaded;
    }

    public final boolean isSupportVisible() {
        if (this.isLoaded) {
            return this.currentVisibleState;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isLoaded = false;
    }

    public void onFragmentFirstVisible() {
    }

    public void onFragmentPause() {
    }

    public void onFragmentResume() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dispatchVisibleState(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        dispatchVisibleState(true);
    }

    public final void setLoaded(boolean z10) {
        this.isLoaded = z10;
    }
}
