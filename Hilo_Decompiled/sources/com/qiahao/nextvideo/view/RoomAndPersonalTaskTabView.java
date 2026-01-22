package com.qiahao.nextvideo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.g;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.LayoutRoomPersonalTaskTabItemBinding;
import com.qiahao.nextvideo.ui.home.community.CommunityTabData;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/view/RoomAndPersonalTaskTabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/ui/home/community/CommunityTabData;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/home/community/CommunityTabData;)V", "mData", "binding", "Lcom/qiahao/nextvideo/databinding/LayoutRoomPersonalTaskTabItemBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/LayoutRoomPersonalTaskTabItemBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/LayoutRoomPersonalTaskTabItemBinding;)V", "initView", "", "setSelected", ImageSelectActivity.SELECTED, "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAndPersonalTaskTabView extends FrameLayout {

    @Nullable
    private LayoutRoomPersonalTaskTabItemBinding binding;

    @Nullable
    private CommunityTabData mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomAndPersonalTaskTabView(@NotNull Context context, @NotNull CommunityTabData communityTabData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(communityTabData, "data");
        this.mData = communityTabData;
        initView();
    }

    private final void initView() {
        this.binding = (LayoutRoomPersonalTaskTabItemBinding) g.h(LayoutInflater.from(getContext()), R.layout.layout_room_personal_task_tab_item, this, true);
    }

    @Nullable
    public final LayoutRoomPersonalTaskTabItemBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(@Nullable LayoutRoomPersonalTaskTabItemBinding layoutRoomPersonalTaskTabItemBinding) {
        this.binding = layoutRoomPersonalTaskTabItemBinding;
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        String str;
        String str2;
        Drawable createShape$default;
        LayoutRoomPersonalTaskTabItemBinding layoutRoomPersonalTaskTabItemBinding = this.binding;
        if (layoutRoomPersonalTaskTabItemBinding != null) {
            TextView textView = layoutRoomPersonalTaskTabItemBinding.title;
            CommunityTabData communityTabData = this.mData;
            if (communityTabData == null || (str = communityTabData.getTitle()) == null) {
                str = "";
            }
            textView.setText(str);
            TextView textView2 = layoutRoomPersonalTaskTabItemBinding.title;
            CommunityTabData communityTabData2 = this.mData;
            if (selected) {
                if (communityTabData2 == null || (str2 = communityTabData2.getSelectColor()) == null) {
                    str2 = "#ffffff";
                }
            } else if (communityTabData2 == null || (str2 = communityTabData2.getDefaultColor()) == null) {
                str2 = "#AAAABD";
            }
            textView2.setTextColor(Color.parseColor(str2));
            ImageView imageView = layoutRoomPersonalTaskTabItemBinding.bg;
            if (selected) {
                createShape$default = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ED74F7", "#8430FF", 18, (GradientDrawable.Orientation) null, 8, (Object) null);
            } else {
                createShape$default = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#00000000", "#00000000", 18, (GradientDrawable.Orientation) null, 8, (Object) null);
            }
            imageView.setBackground(createShape$default);
        }
    }
}
