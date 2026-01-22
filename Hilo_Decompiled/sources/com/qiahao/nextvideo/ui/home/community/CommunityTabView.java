package com.qiahao.nextvideo.ui.home.community;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.LayoutCustomCommunityTabItemBinding;
import com.tencent.qcloud.tuicore.component.activities.ImageSelectActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/community/CommunityTabView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "data", "Lcom/qiahao/nextvideo/ui/home/community/CommunityTabData;", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/ui/home/community/CommunityTabData;)V", "binding", "Lcom/qiahao/nextvideo/databinding/LayoutCustomCommunityTabItemBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/LayoutCustomCommunityTabItemBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/LayoutCustomCommunityTabItemBinding;)V", "mData", "initView", "", "setSelected", ImageSelectActivity.SELECTED, "", "setRedPoints", "count", "", "setRedPointShow", "setRedPoint", "cancelRedPoint", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommunityTabView extends FrameLayout {

    @Nullable
    private LayoutCustomCommunityTabItemBinding binding;

    @Nullable
    private CommunityTabData mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommunityTabView(@NotNull Context context, @NotNull CommunityTabData communityTabData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(communityTabData, "data");
        this.mData = communityTabData;
        initView();
    }

    private final void cancelRedPoint() {
        TextView textView;
        TextView textView2;
        LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding = this.binding;
        if (layoutCustomCommunityTabItemBinding != null && (textView2 = layoutCustomCommunityTabItemBinding.redNumber) != null) {
            textView2.setText("");
        }
        LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding2 = this.binding;
        if (layoutCustomCommunityTabItemBinding2 != null && (textView = layoutCustomCommunityTabItemBinding2.redNumber) != null) {
            textView.setVisibility(8);
        }
    }

    private final void initView() {
        this.binding = (LayoutCustomCommunityTabItemBinding) g.h(LayoutInflater.from(getContext()), R.layout.layout_custom_community_tab_item, this, true);
    }

    private final CommunityTabView setRedPoint(String count) {
        TextView textView;
        TextView textView2;
        LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding = this.binding;
        if (layoutCustomCommunityTabItemBinding != null && (textView2 = layoutCustomCommunityTabItemBinding.redNumber) != null) {
            textView2.setVisibility(0);
        }
        LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding2 = this.binding;
        if (layoutCustomCommunityTabItemBinding2 != null && (textView = layoutCustomCommunityTabItemBinding2.redNumber) != null) {
            textView.setText(count);
        }
        return this;
    }

    @Nullable
    public final LayoutCustomCommunityTabItemBinding getBinding() {
        return this.binding;
    }

    public final void setBinding(@Nullable LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding) {
        this.binding = layoutCustomCommunityTabItemBinding;
    }

    public final void setRedPointShow() {
        TextView textView;
        TextView textView2;
        LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding = this.binding;
        if (layoutCustomCommunityTabItemBinding != null && (textView2 = layoutCustomCommunityTabItemBinding.redNumber) != null) {
            textView2.setText("");
        }
        LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding2 = this.binding;
        if (layoutCustomCommunityTabItemBinding2 != null && (textView = layoutCustomCommunityTabItemBinding2.redNumber) != null) {
            textView.setVisibility(0);
        }
    }

    public final void setRedPoints(@Nullable String count) {
        CommunityTabView communityTabView;
        if (count != null) {
            if (count.length() > 0) {
                communityTabView = setRedPoint(count);
            } else {
                cancelRedPoint();
                communityTabView = Unit.INSTANCE;
            }
            if (communityTabView != null) {
                return;
            }
        }
        cancelRedPoint();
        Unit unit = Unit.INSTANCE;
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        TextView textView;
        String str;
        LayoutCustomCommunityTabItemBinding layoutCustomCommunityTabItemBinding = this.binding;
        if (layoutCustomCommunityTabItemBinding != null && (textView = layoutCustomCommunityTabItemBinding.title) != null) {
            CommunityTabData communityTabData = this.mData;
            if (communityTabData == null || (str = communityTabData.getTitle()) == null) {
                str = "";
            }
            textView.setText(str);
        }
    }
}
