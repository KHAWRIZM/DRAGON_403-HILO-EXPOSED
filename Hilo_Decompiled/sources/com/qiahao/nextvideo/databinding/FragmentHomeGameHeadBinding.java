package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeGameHeadBinding extends ViewDataBinding {
    public final BaseStatusEmptyBinding empty;
    public final TextView findTitle;
    public final RecyclerView gameRecyclerView;
    public final Group group;
    public final ImageView ludo;
    public final TextView ludoImg;
    public final TextView ludoText;
    public final ImageView uno;
    public final TextView unoImg;
    public final TextView unoText;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeGameHeadBinding(Object obj, View view, int i, BaseStatusEmptyBinding baseStatusEmptyBinding, TextView textView, RecyclerView recyclerView, Group group, ImageView imageView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.empty = baseStatusEmptyBinding;
        this.findTitle = textView;
        this.gameRecyclerView = recyclerView;
        this.group = group;
        this.ludo = imageView;
        this.ludoImg = textView2;
        this.ludoText = textView3;
        this.uno = imageView2;
        this.unoImg = textView4;
        this.unoText = textView5;
    }

    public static FragmentHomeGameHeadBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeGameHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeGameHeadBinding bind(View view, Object obj) {
        return (FragmentHomeGameHeadBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home_game_head);
    }

    @Deprecated
    public static FragmentHomeGameHeadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeGameHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_game_head, viewGroup, z, obj);
    }

    public static FragmentHomeGameHeadBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeGameHeadBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeGameHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_game_head, (ViewGroup) null, false, obj);
    }
}
