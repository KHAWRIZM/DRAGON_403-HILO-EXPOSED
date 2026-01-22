package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerNeighborhoodsNoteBinding extends ViewDataBinding {
    public final AppCompatButton agreeButton;
    public final AppCompatTextView childSafetyPolicy;
    public final AppCompatButton disagreeAndLogOutButton;
    public final AppCompatTextView privacyPolicyTextView;
    public final AppCompatTextView termsOfServiceTextView;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerNeighborhoodsNoteBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, AppCompatButton appCompatButton2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, Toolbar toolbar) {
        super(obj, view, i);
        this.agreeButton = appCompatButton;
        this.childSafetyPolicy = appCompatTextView;
        this.disagreeAndLogOutButton = appCompatButton2;
        this.privacyPolicyTextView = appCompatTextView2;
        this.termsOfServiceTextView = appCompatTextView3;
        this.toolbar = toolbar;
    }

    public static ViewControllerNeighborhoodsNoteBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerNeighborhoodsNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerNeighborhoodsNoteBinding bind(View view, Object obj) {
        return (ViewControllerNeighborhoodsNoteBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_neighborhoods_note);
    }

    @Deprecated
    public static ViewControllerNeighborhoodsNoteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerNeighborhoodsNoteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_neighborhoods_note, viewGroup, z, obj);
    }

    public static ViewControllerNeighborhoodsNoteBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerNeighborhoodsNoteBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerNeighborhoodsNoteBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_neighborhoods_note, (ViewGroup) null, false, obj);
    }
}
