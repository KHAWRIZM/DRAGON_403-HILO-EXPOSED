package com.qiahao.nextvideo.ui.task;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.tab.TaskTabData;
import com.qiahao.nextvideo.databinding.BaseLayoutTaskTabItemBinding;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/TaskTabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/tab/TaskTabData;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/tab/TaskTabData;)V", "getData", "()Lcom/qiahao/nextvideo/data/tab/TaskTabData;", "setData", "(Lcom/qiahao/nextvideo/data/tab/TaskTabData;)V", "binding", "Lcom/qiahao/nextvideo/databinding/BaseLayoutTaskTabItemBinding;", "initView", "", "setSelected", ImageSelectActivity.SELECTED, "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTaskTabView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskTabView.kt\ncom/qiahao/nextvideo/ui/task/TaskTabView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,42:1\n1#2:43\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TaskTabView extends FrameLayout {

    @Nullable
    private BaseLayoutTaskTabItemBinding binding;

    @Nullable
    private TaskTabData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskTabView(@NotNull Context context, @Nullable TaskTabData taskTabData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = taskTabData;
        initView();
    }

    private final void initView() {
        this.binding = (BaseLayoutTaskTabItemBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.base_layout_task_tab_item, this, true);
    }

    @Nullable
    public final TaskTabData getData() {
        return this.data;
    }

    public final void setData(@Nullable TaskTabData taskTabData) {
        this.data = taskTabData;
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        ImageView imageView;
        TextView textView;
        String str;
        ImageView imageView2;
        Drawable drawable;
        Context context;
        ImageView imageView3;
        int i;
        super.setSelected(selected);
        BaseLayoutTaskTabItemBinding baseLayoutTaskTabItemBinding = this.binding;
        int i2 = 8;
        if (baseLayoutTaskTabItemBinding != null && (imageView3 = baseLayoutTaskTabItemBinding.bg) != null) {
            if (selected) {
                i = 0;
            } else {
                i = 8;
            }
            imageView3.setVisibility(i);
        }
        BaseLayoutTaskTabItemBinding baseLayoutTaskTabItemBinding2 = this.binding;
        if (baseLayoutTaskTabItemBinding2 != null && (imageView2 = baseLayoutTaskTabItemBinding2.bg) != null) {
            if (baseLayoutTaskTabItemBinding2 != null && imageView2 != null && (context = imageView2.getContext()) != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.task_tab_select);
            } else {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
        }
        BaseLayoutTaskTabItemBinding baseLayoutTaskTabItemBinding3 = this.binding;
        if (baseLayoutTaskTabItemBinding3 != null && (textView = baseLayoutTaskTabItemBinding3.title) != null) {
            TaskTabData taskTabData = this.data;
            if (taskTabData == null || (str = taskTabData.getTitle()) == null) {
                str = "";
            }
            textView.setText(str);
        }
        BaseLayoutTaskTabItemBinding baseLayoutTaskTabItemBinding4 = this.binding;
        if (baseLayoutTaskTabItemBinding4 != null && (imageView = baseLayoutTaskTabItemBinding4.lockIcon) != null) {
            TaskTabData taskTabData2 = this.data;
            if (taskTabData2 != null && !taskTabData2.getUnlock()) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
        }
    }

    public /* synthetic */ TaskTabView(Context context, TaskTabData taskTabData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : taskTabData);
    }
}
