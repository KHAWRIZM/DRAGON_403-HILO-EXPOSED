package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityCreateActivitiesBinding extends ViewDataBinding {
    public final TextView activityDes;
    public final AppCompatEditText activityDesEditText;
    public final FrameLayout activityMainContainer;
    public final TextView activityTheme;
    public final AppCompatEditText activityThemeEditText;
    public final TextView activityTime;
    public final TextView activityType;
    public final AppCompatImageView backImageView;
    public final TextView bannerSize;
    public final View bar;
    public final FrameLayout beginTimeLayout;
    public final AppCompatTextView beginTimeText;
    public final AppCompatTextView beginTimeTitle;
    public final NestedScrollView centerLayout;
    public final ImageView createDefaultImage;
    public final QMUIRadiusImageView2 createImage;
    public final TextView desNumber;
    public final FrameLayout imageLayout;
    public final AppCompatImageView imge;
    public final LinearLayout interested;
    public final ImageView interestedImage;
    public final TextView interestedText;
    public final RecyclerView recyclerView;
    public final FrameLayout selectLayout;
    public final AppCompatTextView selectText;
    public final AppCompatTextView selectTitle;
    public final FrameLayout timeDurationLayout;
    public final AppCompatTextView timeDurationText;
    public final AppCompatTextView timeDurationTitle;
    public final ConstraintLayout tipLayout;
    public final TextView title;
    public final ConstraintLayout topLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCreateActivitiesBinding(Object obj, View view, int i, TextView textView, AppCompatEditText appCompatEditText, FrameLayout frameLayout, TextView textView2, AppCompatEditText appCompatEditText2, TextView textView3, TextView textView4, AppCompatImageView appCompatImageView, TextView textView5, View view2, FrameLayout frameLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, NestedScrollView nestedScrollView, ImageView imageView, QMUIRadiusImageView2 qMUIRadiusImageView2, TextView textView6, FrameLayout frameLayout3, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, ImageView imageView2, TextView textView7, RecyclerView recyclerView, FrameLayout frameLayout4, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, FrameLayout frameLayout5, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, ConstraintLayout constraintLayout, TextView textView8, ConstraintLayout constraintLayout2) {
        super(obj, view, i);
        this.activityDes = textView;
        this.activityDesEditText = appCompatEditText;
        this.activityMainContainer = frameLayout;
        this.activityTheme = textView2;
        this.activityThemeEditText = appCompatEditText2;
        this.activityTime = textView3;
        this.activityType = textView4;
        this.backImageView = appCompatImageView;
        this.bannerSize = textView5;
        this.bar = view2;
        this.beginTimeLayout = frameLayout2;
        this.beginTimeText = appCompatTextView;
        this.beginTimeTitle = appCompatTextView2;
        this.centerLayout = nestedScrollView;
        this.createDefaultImage = imageView;
        this.createImage = qMUIRadiusImageView2;
        this.desNumber = textView6;
        this.imageLayout = frameLayout3;
        this.imge = appCompatImageView2;
        this.interested = linearLayout;
        this.interestedImage = imageView2;
        this.interestedText = textView7;
        this.recyclerView = recyclerView;
        this.selectLayout = frameLayout4;
        this.selectText = appCompatTextView3;
        this.selectTitle = appCompatTextView4;
        this.timeDurationLayout = frameLayout5;
        this.timeDurationText = appCompatTextView5;
        this.timeDurationTitle = appCompatTextView6;
        this.tipLayout = constraintLayout;
        this.title = textView8;
        this.topLayout = constraintLayout2;
    }

    public static ActivityCreateActivitiesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityCreateActivitiesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityCreateActivitiesBinding bind(View view, Object obj) {
        return (ActivityCreateActivitiesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_create_activities);
    }

    @Deprecated
    public static ActivityCreateActivitiesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCreateActivitiesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_create_activities, viewGroup, z, obj);
    }

    public static ActivityCreateActivitiesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityCreateActivitiesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCreateActivitiesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_create_activities, (ViewGroup) null, false, obj);
    }
}
