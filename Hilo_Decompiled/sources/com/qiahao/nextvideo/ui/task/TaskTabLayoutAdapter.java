package com.qiahao.nextvideo.ui.task;

import android.content.Context;
import android.view.View;
import com.oudi.widget.CustomTabLayout;
import com.qiahao.nextvideo.data.tab.TaskTabData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/TaskTabLayoutAdapter;", "Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;", "tabList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/tab/TaskTabData;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getTabList", "()Ljava/util/ArrayList;", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnselected", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TaskTabLayoutAdapter implements CustomTabLayout.CustomTabAdapter {

    @NotNull
    private final ArrayList<TaskTabData> tabList;

    public TaskTabLayoutAdapter(@NotNull ArrayList<TaskTabData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "tabList");
        this.tabList = arrayList;
    }

    @NotNull
    public final ArrayList<TaskTabData> getTabList() {
        return this.tabList;
    }

    @NotNull
    public View getTabView(@NotNull Context context, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new TaskTabView(context, this.tabList.get(position));
    }

    public void onTabSelected(int position, @Nullable View tabView) {
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabSelected(this, position, tabView);
        Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.task.TaskTabView");
        ((TaskTabView) tabView).setSelected(true);
    }

    public void onTabUnSelected2(int i, @Nullable View view, int i2) {
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabUnSelected2(this, i, view, i2);
    }

    public void onTabUnselected(int position, @Nullable View tabView) {
        CustomTabLayout.CustomTabAdapter.DefaultImpls.onTabUnselected(this, position, tabView);
        Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.task.TaskTabView");
        ((TaskTabView) tabView).setSelected(false);
    }
}
