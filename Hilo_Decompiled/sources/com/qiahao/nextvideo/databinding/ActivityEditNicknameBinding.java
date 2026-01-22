package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityEditNicknameBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final AppCompatTextView contentLengthTipsTextview;
    public final AppCompatEditText inputBoxEditText;
    public final AppCompatTextView saveTextView;
    public final AppCompatTextView titleTextView;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityEditNicknameBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatEditText appCompatEditText, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.contentLengthTipsTextview = appCompatTextView;
        this.inputBoxEditText = appCompatEditText;
        this.saveTextView = appCompatTextView2;
        this.titleTextView = appCompatTextView3;
        this.toolbar = toolbar;
    }

    public static ActivityEditNicknameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityEditNicknameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityEditNicknameBinding bind(View view, Object obj) {
        return (ActivityEditNicknameBinding) ViewDataBinding.bind(obj, view, R.layout.activity_edit_nickname);
    }

    @Deprecated
    public static ActivityEditNicknameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityEditNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_edit_nickname, viewGroup, z, obj);
    }

    public static ActivityEditNicknameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityEditNicknameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityEditNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_edit_nickname, (ViewGroup) null, false, obj);
    }
}
