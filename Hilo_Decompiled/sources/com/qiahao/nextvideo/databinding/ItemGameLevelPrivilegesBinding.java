package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemGameLevelPrivilegesBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final ImageView img;
    public final TextView name;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemGameLevelPrivilegesBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.img = imageView;
        this.name = textView;
    }

    public static ItemGameLevelPrivilegesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemGameLevelPrivilegesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemGameLevelPrivilegesBinding bind(View view, Object obj) {
        return (ItemGameLevelPrivilegesBinding) ViewDataBinding.bind(obj, view, R.layout.item_game_level_privileges);
    }

    @Deprecated
    public static ItemGameLevelPrivilegesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemGameLevelPrivilegesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_level_privileges, viewGroup, z, obj);
    }

    public static ItemGameLevelPrivilegesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemGameLevelPrivilegesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemGameLevelPrivilegesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_game_level_privileges, (ViewGroup) null, false, obj);
    }
}
