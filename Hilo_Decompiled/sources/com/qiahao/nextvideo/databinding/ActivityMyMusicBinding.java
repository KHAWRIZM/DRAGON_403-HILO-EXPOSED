package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public abstract class ActivityMyMusicBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final ImageView addMusic;
    public final AppCompatImageView backImageView;
    public final ImageView clearEdit;
    public final LinearLayout llAddMusic;
    public final LinearLayout llEmptyMusic;
    protected View.OnClickListener mClick;
    public final RecyclerView musicListView;
    public final EditText searchEditText;
    public final LinearLayout searchLinearLayout;
    public final AppCompatTextView title;
    public final Toolbar titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMyMusicBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, AppCompatImageView appCompatImageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, EditText editText, LinearLayout linearLayout3, AppCompatTextView appCompatTextView, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.addMusic = imageView;
        this.backImageView = appCompatImageView;
        this.clearEdit = imageView2;
        this.llAddMusic = linearLayout;
        this.llEmptyMusic = linearLayout2;
        this.musicListView = recyclerView;
        this.searchEditText = editText;
        this.searchLinearLayout = linearLayout3;
        this.title = appCompatTextView;
        this.titleBar = toolbar;
    }

    public static ActivityMyMusicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityMyMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ActivityMyMusicBinding bind(View view, Object obj) {
        return (ActivityMyMusicBinding) ViewDataBinding.bind(obj, view, R.layout.activity_my_music);
    }

    @Deprecated
    public static ActivityMyMusicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMyMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_my_music, viewGroup, z, obj);
    }

    public static ActivityMyMusicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityMyMusicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMyMusicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_my_music, (ViewGroup) null, false, obj);
    }
}
