package com.qhqc.core.basic.uiframe.ui;

import androidx.fragment.app.Fragment;
import com.qhqc.core.basic.uiframe.ui.IFragmentVisibility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/VisibilityFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/qhqc/core/basic/uiframe/ui/IFragmentVisibility;", "()V", "mIsFragmentVisible", "", "mIsFragmentVisibleFirst", "checkChildFragmentInvisible", "", "checkChildFragmentVisible", "checkFragmentInvisible", "checkFragmentVisible", "isVisibleToUser", "onHiddenChanged", "hidden", "onPause", "onResume", "setUserVisibleHint", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVisibilityFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VisibilityFragment.kt\ncom/qhqc/core/basic/uiframe/ui/VisibilityFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,107:1\n1863#2,2:108\n1863#2,2:110\n*S KotlinDebug\n*F\n+ 1 VisibilityFragment.kt\ncom/qhqc/core/basic/uiframe/ui/VisibilityFragment\n*L\n93#1:108,2\n101#1:110,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VisibilityFragment extends Fragment implements IFragmentVisibility {
    private boolean mIsFragmentVisible;
    private boolean mIsFragmentVisibleFirst = true;

    private final void checkChildFragmentInvisible() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment instanceof VisibilityFragment) {
                ((VisibilityFragment) fragment).checkFragmentInvisible();
            }
        }
    }

    private final void checkChildFragmentVisible() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
        for (Fragment fragment : fragments) {
            if (fragment instanceof VisibilityFragment) {
                ((VisibilityFragment) fragment).checkFragmentVisible();
            }
        }
    }

    private final void checkFragmentInvisible() {
        if (this.mIsFragmentVisible) {
            this.mIsFragmentVisible = false;
            onInvisible();
            checkChildFragmentInvisible();
        }
    }

    private final void checkFragmentVisible() {
        Fragment parentFragment = getParentFragment();
        if ((parentFragment == null || !(parentFragment instanceof VisibilityFragment) || ((VisibilityFragment) parentFragment).getMIsFragmentVisible()) && isResumed() && !isHidden() && getUserVisibleHint() && !this.mIsFragmentVisible) {
            this.mIsFragmentVisible = true;
            onVisible();
            if (this.mIsFragmentVisibleFirst) {
                this.mIsFragmentVisibleFirst = false;
                onFirstVisible();
            } else {
                onWithoutFirstVisible();
            }
            checkChildFragmentVisible();
        }
    }

    @Override // com.qhqc.core.basic.uiframe.ui.IFragmentVisibility
    /* renamed from: isVisibleToUser, reason: from getter */
    public boolean getMIsFragmentVisible() {
        return this.mIsFragmentVisible;
    }

    public void onFirstVisible() {
        IFragmentVisibility.DefaultImpls.onFirstVisible(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            checkFragmentInvisible();
        } else {
            checkFragmentVisible();
        }
    }

    @Override // com.qhqc.core.basic.uiframe.ui.IFragmentVisibility
    public void onInvisible() {
        IFragmentVisibility.DefaultImpls.onInvisible(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        checkFragmentInvisible();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        checkFragmentVisible();
    }

    @Override // com.qhqc.core.basic.uiframe.ui.IFragmentVisibility
    public void onVisible() {
        IFragmentVisibility.DefaultImpls.onVisible(this);
    }

    @Override // com.qhqc.core.basic.uiframe.ui.IFragmentVisibility
    public void onWithoutFirstVisible() {
        IFragmentVisibility.DefaultImpls.onWithoutFirstVisible(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            checkFragmentVisible();
        } else {
            checkFragmentInvisible();
        }
    }
}
