package com.qiahao.nextvideo.ui.task;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR'\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/TaskViewPagerAdapter;", "Landroidx/viewpager2/adapter/a;", "Lcom/qiahao/nextvideo/ui/task/RoomTaskFragment;", AgooConstants.OPEN_ACTIIVTY_NAME, "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "fragments", "<init>", "(Lcom/qiahao/nextvideo/ui/task/RoomTaskFragment;Ljava/util/ArrayList;)V", "", "getItemCount", "()I", "position", "createFragment", "(I)Landroidx/fragment/app/Fragment;", "Ljava/util/ArrayList;", "getFragments", "()Ljava/util/ArrayList;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TaskViewPagerAdapter extends androidx.viewpager2.adapter.a {

    @NotNull
    private final ArrayList<Fragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewPagerAdapter(@NotNull RoomTaskFragment roomTaskFragment, @NotNull ArrayList<Fragment> arrayList) {
        super(roomTaskFragment);
        Intrinsics.checkNotNullParameter(roomTaskFragment, AgooConstants.OPEN_ACTIIVTY_NAME);
        Intrinsics.checkNotNullParameter(arrayList, "fragments");
        this.fragments = arrayList;
    }

    @NotNull
    public Fragment createFragment(int position) {
        Fragment fragment = this.fragments.get(position);
        Intrinsics.checkNotNullExpressionValue(fragment, "get(...)");
        return fragment;
    }

    @NotNull
    public final ArrayList<Fragment> getFragments() {
        return this.fragments;
    }

    public int getItemCount() {
        return this.fragments.size();
    }
}
