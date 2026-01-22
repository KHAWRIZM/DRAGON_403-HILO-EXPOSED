package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class LayoutGlobalRoomBroadCastChildBinding extends ViewDataBinding {
    public final FrameLayout allContent;
    public final CircleImageView avatar;
    public final TextView content;
    public final LinearLayout contentBg;
    public final ImageView icon;
    protected View.OnClickListener mClick;

    /* renamed from: top, reason: collision with root package name */
    public final ImageView f٦٧top;

    /* JADX INFO: Access modifiers changed from: protected */
    public LayoutGlobalRoomBroadCastChildBinding(Object obj, View view, int i, FrameLayout frameLayout, CircleImageView circleImageView, TextView textView, LinearLayout linearLayout, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.allContent = frameLayout;
        this.avatar = circleImageView;
        this.content = textView;
        this.contentBg = linearLayout;
        this.icon = imageView;
        this.f٦٧top = imageView2;
    }

    public static LayoutGlobalRoomBroadCastChildBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static LayoutGlobalRoomBroadCastChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static LayoutGlobalRoomBroadCastChildBinding bind(View view, Object obj) {
        return (LayoutGlobalRoomBroadCastChildBinding) ViewDataBinding.bind(obj, view, R.layout.layout_global_room_broad_cast_child);
    }

    @Deprecated
    public static LayoutGlobalRoomBroadCastChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (LayoutGlobalRoomBroadCastChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_global_room_broad_cast_child, viewGroup, z, obj);
    }

    public static LayoutGlobalRoomBroadCastChildBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static LayoutGlobalRoomBroadCastChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (LayoutGlobalRoomBroadCastChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_global_room_broad_cast_child, (ViewGroup) null, false, obj);
    }
}
