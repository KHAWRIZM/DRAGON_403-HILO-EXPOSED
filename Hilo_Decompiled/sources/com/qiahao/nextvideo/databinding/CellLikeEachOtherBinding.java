package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellLikeEachOtherBinding extends ViewDataBinding {
    public final AppCompatTextView nicknameTextView;
    public final View unreadPotView;
    public final CircleImageView userCircleImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellLikeEachOtherBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, View view2, CircleImageView circleImageView) {
        super(obj, view, i);
        this.nicknameTextView = appCompatTextView;
        this.unreadPotView = view2;
        this.userCircleImageView = circleImageView;
    }

    public static CellLikeEachOtherBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellLikeEachOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellLikeEachOtherBinding bind(View view, Object obj) {
        return (CellLikeEachOtherBinding) ViewDataBinding.bind(obj, view, R.layout.cell_like_each_other);
    }

    @Deprecated
    public static CellLikeEachOtherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellLikeEachOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_like_each_other, viewGroup, z, obj);
    }

    public static CellLikeEachOtherBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellLikeEachOtherBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellLikeEachOtherBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_like_each_other, (ViewGroup) null, false, obj);
    }
}
