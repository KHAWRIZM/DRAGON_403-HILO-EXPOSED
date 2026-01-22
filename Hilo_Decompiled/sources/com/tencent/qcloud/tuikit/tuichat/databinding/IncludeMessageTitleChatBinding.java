package com.tencent.qcloud.tuikit.tuichat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public abstract class IncludeMessageTitleChatBinding extends ViewDataBinding {
    public final HiloGradeView charmLevel;
    public final IncludeFamilyNamePlateBinding familyNamePlate;
    public final ImageView iconNoble;
    public final ImageView iconVip;
    public final ImageView imgBeautyAccount;
    public final LinearLayout llMedal;
    public final LinearLayout llNameTime;
    public final ImageView svip;
    public final TextView userNameTv;
    public final ImageView userTag;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeMessageTitleChatBinding(Object obj, View view, int i, HiloGradeView hiloGradeView, IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView4, TextView textView, ImageView imageView5, HiloGradeView hiloGradeView2) {
        super(obj, view, i);
        this.charmLevel = hiloGradeView;
        this.familyNamePlate = includeFamilyNamePlateBinding;
        this.iconNoble = imageView;
        this.iconVip = imageView2;
        this.imgBeautyAccount = imageView3;
        this.llMedal = linearLayout;
        this.llNameTime = linearLayout2;
        this.svip = imageView4;
        this.userNameTv = textView;
        this.userTag = imageView5;
        this.wealthLevel = hiloGradeView2;
    }

    public static IncludeMessageTitleChatBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeMessageTitleChatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeMessageTitleChatBinding bind(View view, Object obj) {
        return (IncludeMessageTitleChatBinding) ViewDataBinding.bind(obj, view, R.layout.include_message_title_chat);
    }

    @Deprecated
    public static IncludeMessageTitleChatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeMessageTitleChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_message_title_chat, viewGroup, z, obj);
    }

    public static IncludeMessageTitleChatBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeMessageTitleChatBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeMessageTitleChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_message_title_chat, (ViewGroup) null, false, obj);
    }
}
