package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFamilySearchMemberBinding extends ViewDataBinding {
    public final HiloGradeView activityLevel;
    public final GenderAgeTextView ageTextView;
    public final HiloGradeView charmLevel;
    public final View line;
    public final TextView memberType;
    public final ImageView svipType;
    public final QMUIRadiusImageView userAvatarCimageView;
    public final ShineTextView userId;
    public final TextView userName;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFamilySearchMemberBinding(Object obj, View view, int i, HiloGradeView hiloGradeView, GenderAgeTextView genderAgeTextView, HiloGradeView hiloGradeView2, View view2, TextView textView, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView, ShineTextView shineTextView, TextView textView2, HiloGradeView hiloGradeView3) {
        super(obj, view, i);
        this.activityLevel = hiloGradeView;
        this.ageTextView = genderAgeTextView;
        this.charmLevel = hiloGradeView2;
        this.line = view2;
        this.memberType = textView;
        this.svipType = imageView;
        this.userAvatarCimageView = qMUIRadiusImageView;
        this.userId = shineTextView;
        this.userName = textView2;
        this.wealthLevel = hiloGradeView3;
    }

    public static ItemFamilySearchMemberBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFamilySearchMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFamilySearchMemberBinding bind(View view, Object obj) {
        return (ItemFamilySearchMemberBinding) ViewDataBinding.bind(obj, view, R.layout.item_family_search_member);
    }

    @Deprecated
    public static ItemFamilySearchMemberBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFamilySearchMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_search_member, viewGroup, z, obj);
    }

    public static ItemFamilySearchMemberBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFamilySearchMemberBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFamilySearchMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_family_search_member, (ViewGroup) null, false, obj);
    }
}
