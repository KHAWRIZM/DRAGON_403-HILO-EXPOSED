package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerFeedbackBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final AppCompatEditText feedbackContentEditText;
    public final AppCompatTextView feedbackContentLengthTextView;
    public final RecyclerView recycler;
    public final AppCompatButton submitButton;
    public final Toolbar toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerFeedbackBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatEditText appCompatEditText, AppCompatTextView appCompatTextView, RecyclerView recyclerView, AppCompatButton appCompatButton, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.feedbackContentEditText = appCompatEditText;
        this.feedbackContentLengthTextView = appCompatTextView;
        this.recycler = recyclerView;
        this.submitButton = appCompatButton;
        this.toolbar = toolbar;
    }

    public static ViewControllerFeedbackBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerFeedbackBinding bind(View view, Object obj) {
        return (ViewControllerFeedbackBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_feedback);
    }

    @Deprecated
    public static ViewControllerFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerFeedbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_feedback, viewGroup, z, obj);
    }

    public static ViewControllerFeedbackBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerFeedbackBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerFeedbackBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_feedback, (ViewGroup) null, false, obj);
    }
}
