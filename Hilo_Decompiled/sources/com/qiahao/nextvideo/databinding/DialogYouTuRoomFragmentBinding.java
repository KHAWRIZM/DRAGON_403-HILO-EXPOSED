package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.HiloCommonTabLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogYouTuRoomFragmentBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final ImageView helper;
    public final HiloCommonTabLayout tabLayout;
    public final ViewPager viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogYouTuRoomFragmentBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, HiloCommonTabLayout hiloCommonTabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.helper = imageView;
        this.tabLayout = hiloCommonTabLayout;
        this.viewPage = viewPager;
    }

    public static DialogYouTuRoomFragmentBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogYouTuRoomFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogYouTuRoomFragmentBinding bind(View view, Object obj) {
        return (DialogYouTuRoomFragmentBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_you_tu_room_fragment);
    }

    @Deprecated
    public static DialogYouTuRoomFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogYouTuRoomFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_room_fragment, viewGroup, z, obj);
    }

    public static DialogYouTuRoomFragmentBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogYouTuRoomFragmentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogYouTuRoomFragmentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_you_tu_room_fragment, (ViewGroup) null, false, obj);
    }
}
