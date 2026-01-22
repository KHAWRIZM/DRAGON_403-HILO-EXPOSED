package com.qiahao.nextvideo.room.record;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.tab.MainTabData;
import com.qiahao.nextvideo.databinding.RoomRecordTabBinding;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/room/record/RoomRecordView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/data/tab/MainTabData;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/tab/MainTabData;)V", "getData", "()Lcom/qiahao/nextvideo/data/tab/MainTabData;", "setData", "(Lcom/qiahao/nextvideo/data/tab/MainTabData;)V", "binding", "Lcom/qiahao/nextvideo/databinding/RoomRecordTabBinding;", "initView", "", "setSelected", ImageSelectActivity.SELECTED, "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRecordView extends FrameLayout {

    @Nullable
    private RoomRecordTabBinding binding;

    @Nullable
    private MainTabData data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRecordView(@NotNull Context context, @Nullable MainTabData mainTabData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = mainTabData;
        initView();
    }

    private final void initView() {
        this.binding = (RoomRecordTabBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.room_record_tab, this, true);
    }

    @Nullable
    public final MainTabData getData() {
        return this.data;
    }

    public final void setData(@Nullable MainTabData mainTabData) {
        this.data = mainTabData;
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        TextView textView;
        MainTabData mainTabData;
        String defaultColor;
        MainTabData mainTabData2;
        TextView textView2;
        String str;
        View view;
        View view2;
        int i;
        super.setSelected(selected);
        RoomRecordTabBinding roomRecordTabBinding = this.binding;
        if (roomRecordTabBinding != null && (view2 = roomRecordTabBinding.bg) != null) {
            if (selected) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
        RoomRecordTabBinding roomRecordTabBinding2 = this.binding;
        if (roomRecordTabBinding2 != null && (view = roomRecordTabBinding2.bg) != null) {
            view.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 13, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        RoomRecordTabBinding roomRecordTabBinding3 = this.binding;
        if (roomRecordTabBinding3 != null && (textView2 = roomRecordTabBinding3.title) != null) {
            MainTabData mainTabData3 = this.data;
            if (mainTabData3 == null || (str = mainTabData3.getTitle()) == null) {
                str = "";
            }
            textView2.setText(str);
        }
        RoomRecordTabBinding roomRecordTabBinding4 = this.binding;
        if (roomRecordTabBinding4 != null && (textView = roomRecordTabBinding4.title) != null) {
            String str2 = "#999999";
            if (!selected ? !((mainTabData = this.data) == null || (defaultColor = mainTabData.getDefaultColor()) == null) : !((mainTabData2 = this.data) == null || (defaultColor = mainTabData2.getSelectColor()) == null)) {
                str2 = defaultColor;
            }
            textView.setTextColor(Color.parseColor(str2));
        }
    }

    public /* synthetic */ RoomRecordView(Context context, MainTabData mainTabData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : mainTabData);
    }
}
