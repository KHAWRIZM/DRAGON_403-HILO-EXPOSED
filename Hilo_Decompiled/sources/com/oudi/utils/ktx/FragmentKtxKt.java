package com.oudi.utils.ktx;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.FragmentUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004\u001a0\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a0\u0010\r\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"showFragment", "", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "containerViewId", "", "isHideOther", "", "isApplyLifecycle", ViewHierarchyConstants.TAG_KEY, "", "removeFragment", "addFragment", "hideFragment", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FragmentKtxKt {
    public static final void addFragment(FragmentActivity fragmentActivity, Fragment fragment, int i10, boolean z10, String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        fragmentUtils.addFragment(supportFragmentManager, fragment, i10, z10, str);
    }

    public static /* synthetic */ void addFragment$default(FragmentActivity fragmentActivity, Fragment fragment, int i10, boolean z10, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        if ((i11 & 8) != 0) {
            str = fragment.getClass().getName();
        }
        addFragment(fragmentActivity, fragment, i10, z10, str);
    }

    public static final void hideFragment(FragmentActivity fragmentActivity, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        fragmentUtils.hideFragment(supportFragmentManager, fragment);
    }

    public static final void removeFragment(FragmentActivity fragmentActivity, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        fragmentUtils.removeFragment(supportFragmentManager, fragment);
    }

    public static final void showFragment(FragmentActivity fragmentActivity, Fragment fragment, int i10, boolean z10, boolean z11, String str) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        fragmentUtils.showFragment(supportFragmentManager, fragment, i10, z10, z11, str);
    }

    public static /* synthetic */ void showFragment$default(FragmentActivity fragmentActivity, Fragment fragment, int i10, boolean z10, boolean z11, String str, int i11, Object obj) {
        boolean z12 = (i11 & 4) != 0 ? false : z10;
        boolean z13 = (i11 & 8) != 0 ? true : z11;
        if ((i11 & 16) != 0) {
            str = fragment.getClass().getName();
        }
        showFragment(fragmentActivity, fragment, i10, z12, z13, str);
    }

    public static final void addFragment(Fragment fragment, Fragment fragment2, int i10, boolean z10, String str) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        fragmentUtils.addFragment(childFragmentManager, fragment2, i10, z10, str);
    }

    public static final void hideFragment(Fragment fragment, Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        fragmentUtils.hideFragment(childFragmentManager, fragment2);
    }

    public static final void removeFragment(Fragment fragment, Fragment fragment2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        fragmentUtils.removeFragment(childFragmentManager, fragment2);
    }

    public static final void showFragment(Fragment fragment, Fragment fragment2, int i10, boolean z10, boolean z11, String str) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(fragment2, "fragment");
        FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        fragmentUtils.showFragment(childFragmentManager, fragment2, i10, z10, z11, str);
    }

    public static /* synthetic */ void addFragment$default(Fragment fragment, Fragment fragment2, int i10, boolean z10, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        if ((i11 & 8) != 0) {
            str = fragment2.getClass().getName();
        }
        addFragment(fragment, fragment2, i10, z10, str);
    }

    public static /* synthetic */ void showFragment$default(Fragment fragment, Fragment fragment2, int i10, boolean z10, boolean z11, String str, int i11, Object obj) {
        boolean z12 = (i11 & 4) != 0 ? false : z10;
        boolean z13 = (i11 & 8) != 0 ? true : z11;
        if ((i11 & 16) != 0) {
            str = fragment2.getClass().getName();
        }
        showFragment(fragment, fragment2, i10, z12, z13, str);
    }
}
