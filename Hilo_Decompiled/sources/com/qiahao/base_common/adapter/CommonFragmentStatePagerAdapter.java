package com.qiahao.base_common.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0014J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0019H\u0002R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006$"}, d2 = {"Lcom/qiahao/base_common/adapter/CommonFragmentStatePagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragments", "", "Landroidx/fragment/app/Fragment;", "titles", "", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/util/List;)V", "getFragments", "()Ljava/util/List;", "setFragments", "(Ljava/util/List;)V", "getTitles", "setTitles", "getItem", "i", "", "getCount", "getPageTitle", "", "position", "isFixBottomSheetBehavior", "", "setPrimaryItem", "", "container", "Landroid/view/ViewGroup;", "object", "", "setNestedScrollingEnabled", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "isNestedScrollingEnabled", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonFragmentStatePagerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonFragmentStatePagerAdapter.kt\ncom/qiahao/base_common/adapter/CommonFragmentStatePagerAdapter\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,66:1\n62#2,4:67\n55#2,4:71\n*S KotlinDebug\n*F\n+ 1 CommonFragmentStatePagerAdapter.kt\ncom/qiahao/base_common/adapter/CommonFragmentStatePagerAdapter\n*L\n47#1:67,4\n61#1:71,4\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class CommonFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    @NotNull
    private List<? extends Fragment> fragments;

    @Nullable
    private List<String> titles;

    public /* synthetic */ CommonFragmentStatePagerAdapter(FragmentManager fragmentManager, List list, List list2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentManager, list, (i10 & 4) != 0 ? null : list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setNestedScrollingEnabled(View view, boolean isNestedScrollingEnabled) {
        d0 d0Var;
        ViewGroup viewGroup = null;
        if (view instanceof d0) {
            d0Var = (d0) view;
        } else {
            d0Var = null;
        }
        if (d0Var != null) {
            d0Var.setNestedScrollingEnabled(isNestedScrollingEnabled);
        }
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        }
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                setNestedScrollingEnabled(viewGroup.getChildAt(i10), isNestedScrollingEnabled);
            }
        }
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.fragments.size();
    }

    @NotNull
    public final List<Fragment> getFragments() {
        return this.fragments;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i10) {
        return this.fragments.get(i10);
    }

    @Override // androidx.viewpager.widget.a
    @Nullable
    public CharSequence getPageTitle(int position) {
        List<String> list = this.titles;
        if (list != null && position < list.size()) {
            return list.get(position);
        }
        return super.getPageTitle(position);
    }

    @Nullable
    public final List<String> getTitles() {
        return this.titles;
    }

    protected boolean isFixBottomSheetBehavior() {
        return false;
    }

    public final void setFragments(@NotNull List<? extends Fragment> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.fragments = list;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.a
    public void setPrimaryItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
        boolean z10;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        super.setPrimaryItem(container, position, object);
        if (isFixBottomSheetBehavior()) {
            int childCount = container.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = container.getChildAt(i10);
                if (i10 == position) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                setNestedScrollingEnabled(childAt, z10);
            }
            container.requestLayout();
        }
    }

    public final void setTitles(@Nullable List<String> list) {
        this.titles = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonFragmentStatePagerAdapter(@NotNull FragmentManager fragmentManager, @NotNull List<? extends Fragment> fragments, @Nullable List<String> list) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragments, "fragments");
        this.fragments = fragments;
        this.titles = list;
    }
}
