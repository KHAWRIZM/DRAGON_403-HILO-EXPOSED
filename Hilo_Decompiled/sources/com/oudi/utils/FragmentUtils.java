package com.oudi.utils;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ>\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ*\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ \u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018J*\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u001a"}, d2 = {"Lcom/oudi/utils/FragmentUtils;", "", "<init>", "()V", "addFragment", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "containerViewId", "", "isApplyLifecycle", "", ViewHierarchyConstants.TAG_KEY, "", "removeFragment", "showFragment", "isHideOther", "hideFragment", "replaceFragment", "findFragment", "fm", "clazz", "Ljava/lang/Class;", "fg", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FragmentUtils {
    public static final FragmentUtils INSTANCE = new FragmentUtils();

    private FragmentUtils() {
    }

    public static /* synthetic */ void addFragment$default(FragmentUtils fragmentUtils, FragmentManager fragmentManager, Fragment fragment, int i10, boolean z10, String str, int i11, Object obj) {
        boolean z11;
        if ((i11 & 8) != 0) {
            z11 = true;
        } else {
            z11 = z10;
        }
        if ((i11 & 16) != 0) {
            str = fragment.getClass().getName();
        }
        fragmentUtils.addFragment(fragmentManager, fragment, i10, z11, str);
    }

    public static /* synthetic */ void replaceFragment$default(FragmentUtils fragmentUtils, FragmentManager fragmentManager, Fragment fragment, int i10, String str, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = fragment.getClass().getName();
        }
        fragmentUtils.replaceFragment(fragmentManager, fragment, i10, str);
    }

    public static /* synthetic */ void showFragment$default(FragmentUtils fragmentUtils, FragmentManager fragmentManager, Fragment fragment, int i10, boolean z10, boolean z11, String str, int i11, Object obj) {
        boolean z12;
        boolean z13;
        if ((i11 & 8) != 0) {
            z12 = false;
        } else {
            z12 = z10;
        }
        if ((i11 & 16) != 0) {
            z13 = true;
        } else {
            z13 = z11;
        }
        if ((i11 & 32) != 0) {
            str = fragment.getClass().getName();
        }
        fragmentUtils.showFragment(fragmentManager, fragment, i10, z12, z13, str);
    }

    public final void addFragment(FragmentManager fragmentManager, Fragment fragment, int containerViewId, boolean isApplyLifecycle, String tag) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment.isAdded()) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(containerViewId, fragment, tag);
        if (isApplyLifecycle) {
            beginTransaction.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public final Fragment findFragment(FragmentManager fm, Class<?> clazz) {
        if (fm != null && clazz != null) {
            List<Fragment> fragments = fm.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
            for (Fragment fragment : fragments) {
                if (Intrinsics.areEqual(fragment.getClass().getName(), clazz.getName())) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final void hideFragment(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment.isAdded() && !fragment.isHidden()) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.hide(fragment);
            beginTransaction.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    public final void removeFragment(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!fragment.isAdded()) {
            return;
        }
        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
    }

    public final void replaceFragment(FragmentManager fragmentManager, Fragment fragment, int containerViewId, String tag) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        fragmentManager.beginTransaction().replace(containerViewId, fragment, tag).commitAllowingStateLoss();
    }

    public final void showFragment(FragmentManager fragmentManager, Fragment fragment, int containerViewId, boolean isHideOther, boolean isApplyLifecycle, String tag) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        if (!fragment.isAdded()) {
            beginTransaction.add(containerViewId, fragment, tag);
        }
        if (isHideOther) {
            List<Fragment> fragments = fragmentManager.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
            ArrayList<Fragment> arrayList = new ArrayList();
            for (Object obj : fragments) {
                Fragment fragment2 = (Fragment) obj;
                if (!Intrinsics.areEqual(fragment2, fragment) && fragment2.isAdded()) {
                    arrayList.add(obj);
                }
            }
            for (Fragment fragment3 : arrayList) {
                beginTransaction.hide(fragment3);
                if (isApplyLifecycle) {
                    beginTransaction.setMaxLifecycle(fragment3, Lifecycle.State.STARTED);
                }
            }
        }
        if (fragment.isHidden()) {
            beginTransaction.show(fragment);
        }
        if (isApplyLifecycle) {
            beginTransaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public final Fragment findFragment(FragmentManager fm, Class<?> clazz, String tag) {
        if (fm != null && clazz != null && tag != null) {
            List<Fragment> fragments = fm.getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "getFragments(...)");
            for (Fragment fragment : fragments) {
                if (Intrinsics.areEqual(fragment.getClass().getName(), clazz.getName()) && Intrinsics.areEqual(fragment.getTag(), tag)) {
                    return fragment;
                }
            }
        }
        return null;
    }

    public final void addFragment(FragmentManager fm, int containerViewId, Fragment fg, String tag) {
        if (fm == null || TextUtils.isEmpty(tag)) {
            return;
        }
        if (fm.findFragmentByTag(tag) == null) {
            FragmentTransaction beginTransaction = fm.beginTransaction();
            Intrinsics.checkNotNull(fg);
            beginTransaction.add(containerViewId, fg, tag).commit();
        } else {
            FragmentTransaction beginTransaction2 = fm.beginTransaction();
            Intrinsics.checkNotNull(fg);
            beginTransaction2.show(fg).commit();
        }
    }
}
