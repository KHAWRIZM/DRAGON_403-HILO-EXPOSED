package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGameBroadcastBinding extends ViewDataBinding {
    public final QMUIRadiusImageView image;
    public final ConstraintLayout roomLayout;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGameBroadcastBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.image = qMUIRadiusImageView;
        this.roomLayout = constraintLayout;
        this.title = textView;
    }

    public static ItemGameBroadcastBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGameBroadcastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGameBroadcastBinding bind(View view, Object obj) {
        return (ItemGameBroadcastBinding) ViewDataBinding.bind(obj, view, R.layout.item_game_broadcast);
    }

    @Deprecated
    public static ItemGameBroadcastBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGameBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_broadcast, viewGroup, z, obj);
    }

    public static ItemGameBroadcastBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGameBroadcastBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGameBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_broadcast, (ViewGroup) null, false, obj);
    }
}
