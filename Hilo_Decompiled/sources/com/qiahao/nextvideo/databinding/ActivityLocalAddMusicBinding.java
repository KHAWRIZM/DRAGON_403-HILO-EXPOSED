package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityLocalAddMusicBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final LinearLayout llEmptyMusic;
    public final LinearLayout llSelectAll;
    public final LinearLayout llSelectAllContent;
    protected View.OnClickListener mClick;
    public final RecyclerView musicListView;
    public final ImageView oneKeySelect;
    public final ImageView refreshImageView;
    public final AppCompatTextView title;
    public final Toolbar titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityLocalAddMusicBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.llEmptyMusic = linearLayout;
        this.llSelectAll = linearLayout2;
        this.llSelectAllContent = linearLayout3;
        this.musicListView = recyclerView;
        this.oneKeySelect = imageView;
        this.refreshImageView = imageView2;
        this.title = appCompatTextView;
        this.titleBar = toolbar;
    }

    public static ActivityLocalAddMusicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityLocalAddMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityLocalAddMusicBinding bind(View view, Object obj) {
        return (ActivityLocalAddMusicBinding) ViewDataBinding.bind(obj, view, R.layout.activity_local_add_music);
    }

    @Deprecated
    public static ActivityLocalAddMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityLocalAddMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_local_add_music, viewGroup, z, obj);
    }

    public static ActivityLocalAddMusicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityLocalAddMusicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityLocalAddMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_local_add_music, (ViewGroup) null, false, obj);
    }
}
