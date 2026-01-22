package com.qhqc.core.basic.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ(\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\b¨\u0006\u000e"}, d2 = {"Lcom/qhqc/core/basic/utils/FragmentUtils;", "", "()V", "hideDialogFragmentByTag", "", "sfm", "Landroidx/fragment/app/FragmentManager;", ViewHierarchyConstants.TAG_KEY, "", "showFragment", "fragment", "Landroidx/fragment/app/Fragment;", "containerId", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FragmentUtils {

    @NotNull
    public static final FragmentUtils INSTANCE = new FragmentUtils();

    private FragmentUtils() {
    }

    public static /* synthetic */ void showFragment$default(FragmentUtils fragmentUtils, FragmentManager fragmentManager, Fragment fragment, int i10, String str, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str = "";
        }
        fragmentUtils.showFragment(fragmentManager, fragment, i10, str);
    }

    public final void hideDialogFragmentByTag(@NotNull FragmentManager sfm, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(sfm, "sfm");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Fragment findFragmentByTag = sfm.findFragmentByTag(tag);
        if (findFragmentByTag != null) {
            FragmentTransaction beginTransaction = sfm.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
            if (findFragmentByTag.isAdded()) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.commitAllowingStateLoss();
            sfm.executePendingTransactions();
        }
    }

    public final void showFragment(@NotNull FragmentManager sfm, @NotNull Fragment fragment, int containerId, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(sfm, "sfm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(tag, "tag");
        FragmentTransaction beginTransaction = sfm.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        if (!fragment.isAdded()) {
            Fragment findFragmentByTag = sfm.findFragmentByTag(tag);
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.add(containerId, fragment, tag);
        } else {
            beginTransaction.show(fragment);
        }
        beginTransaction.commitAllowingStateLoss();
        sfm.executePendingTransactions();
    }
}
