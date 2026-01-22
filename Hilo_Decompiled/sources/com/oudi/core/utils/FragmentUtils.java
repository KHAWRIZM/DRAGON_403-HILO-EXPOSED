package com.oudi.core.utils;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.messaging.Constants;
import com.oudi.core.R;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l2.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tJ,\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J,\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J,\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J,\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J6\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010J6\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0005¨\u0006\u001c"}, d2 = {"Lcom/oudi/core/utils/FragmentUtils;", "", "<init>", "()V", "findFragment", "Landroidx/fragment/app/Fragment;", "fm", "Landroidx/fragment/app/FragmentManager;", "clazz", "Ljava/lang/Class;", "addFragment", "", "containerViewId", "", "fg", ViewHierarchyConstants.TAG_KEY, "", "addFragmentBackStack", "replaceFragment", "replaceFragmentBackStack", "showHideFragment", Constants.MessagePayloadKeys.FROM, "to", "toTag", "showHideFragmentBackStack", "removeFragment", "fragmentManager", "fragment", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class FragmentUtils {

    @NotNull
    public static final FragmentUtils INSTANCE = new FragmentUtils();

    private FragmentUtils() {
    }

    public final void addFragment(@Nullable FragmentManager fm, int containerViewId, @Nullable Fragment fg, @Nullable String tag) {
        if (fm != null && !TextUtils.isEmpty(tag)) {
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

    public final void addFragmentBackStack(@Nullable FragmentManager fm, int containerViewId, @Nullable Fragment fg, @Nullable String tag) {
        if (fm != null && !TextUtils.isEmpty(tag)) {
            if (fm.findFragmentByTag(tag) == null) {
                FragmentTransaction beginTransaction = fm.beginTransaction();
                Intrinsics.checkNotNull(fg);
                beginTransaction.add(containerViewId, fg, tag).addToBackStack(null).commit();
            } else {
                FragmentTransaction beginTransaction2 = fm.beginTransaction();
                Intrinsics.checkNotNull(fg);
                beginTransaction2.show(fg).commit();
            }
        }
    }

    @Nullable
    public final Fragment findFragment(@Nullable FragmentManager fm, @Nullable Class<?> clazz) {
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

    public final void removeFragment(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!fragment.isAdded()) {
            return;
        }
        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
    }

    public final void replaceFragment(@Nullable FragmentManager fm, int containerViewId, @Nullable Fragment fg, @Nullable String tag) {
        if (fm != null && !TextUtils.isEmpty(tag)) {
            Fragment findFragmentByTag = fm.findFragmentByTag(tag);
            if (findFragmentByTag == null) {
                FragmentTransaction beginTransaction = fm.beginTransaction();
                Intrinsics.checkNotNull(fg);
                beginTransaction.replace(containerViewId, fg, tag).commit();
                return;
            }
            fm.beginTransaction().replace(containerViewId, findFragmentByTag, tag).commit();
        }
    }

    public final void replaceFragmentBackStack(@Nullable FragmentManager fm, int containerViewId, @Nullable Fragment fg, @Nullable String tag) {
        if (fm != null && !TextUtils.isEmpty(tag)) {
            Fragment findFragmentByTag = fm.findFragmentByTag(tag);
            if (findFragmentByTag == null) {
                FragmentTransaction customAnimations = fm.beginTransaction().setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
                Intrinsics.checkNotNull(fg);
                customAnimations.replace(containerViewId, fg, tag).addToBackStack(null).commit();
                return;
            }
            fm.beginTransaction().setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right).replace(containerViewId, findFragmentByTag, tag).addToBackStack(null).commit();
        }
    }

    public final void showHideFragment(@Nullable FragmentManager fm, int containerViewId, @Nullable Fragment from, @Nullable Fragment to, @Nullable String toTag) {
        if (fm == null || TextUtils.isEmpty(toTag) || from == null) {
            return;
        }
        Fragment findFragmentByTag = fm.findFragmentByTag(toTag);
        if (findFragmentByTag == null) {
            FragmentTransaction hide = fm.beginTransaction().setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right).hide(from);
            Intrinsics.checkNotNull(to);
            hide.add(containerViewId, to, toTag).commit();
            return;
        }
        fm.beginTransaction().setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right).hide(from).show(findFragmentByTag).commit();
    }

    public final void showHideFragmentBackStack(@Nullable FragmentManager fm, int containerViewId, @Nullable Fragment from, @Nullable Fragment to, @Nullable String toTag) {
        if (fm == null || TextUtils.isEmpty(toTag) || from == null) {
            return;
        }
        int i10 = R.anim.slide_in_from_right;
        int i11 = R.anim.slide_out_to_left;
        int i12 = R.anim.slide_in_from_left;
        int i13 = R.anim.slide_out_to_right;
        if (q.a(Locale.getDefault()) == 1) {
            i13 = i11;
            i11 = R.anim.anim_still;
            i10 = i12;
            i12 = i11;
        }
        Fragment findFragmentByTag = fm.findFragmentByTag(toTag);
        if (findFragmentByTag == null) {
            FragmentTransaction hide = fm.beginTransaction().setCustomAnimations(i10, i11, i12, i13).hide(from);
            Intrinsics.checkNotNull(to);
            hide.add(containerViewId, to, toTag).addToBackStack(null).commit();
            return;
        }
        fm.beginTransaction().setCustomAnimations(i10, i11, i12, i13).hide(from).show(findFragmentByTag).addToBackStack(null).commit();
    }
}
