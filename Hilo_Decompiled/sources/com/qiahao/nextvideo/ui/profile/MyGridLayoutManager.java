package com.qiahao.nextvideo.ui.profile;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ\b\u0010\r\u001a\u00020\tH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/MyGridLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "context", "Landroid/content/Context;", ImageSelectActivity.SPAN_COUNT, "", "<init>", "(Landroid/content/Context;I)V", "isScrollEnabled", "", "setScrollEnabled", "", AgooConstants.MESSAGE_FLAG, "canScrollVertically", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyGridLayoutManager extends GridLayoutManager {
    private boolean isScrollEnabled;

    public MyGridLayoutManager(@Nullable Context context, int i) {
        super(context, i);
        this.isScrollEnabled = true;
    }

    public boolean canScrollVertically() {
        if (this.isScrollEnabled && super/*androidx.recyclerview.widget.LinearLayoutManager*/.canScrollVertically()) {
            return true;
        }
        return false;
    }

    public final void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }
}
