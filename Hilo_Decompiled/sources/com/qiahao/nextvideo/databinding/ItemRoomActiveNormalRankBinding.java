package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRoomActiveNormalRankBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final HiloImageView avatar;
    public final HiloGradeView charmLevel;
    public final NickTextView name;
    public final ImageView noble;
    public final TextView position;
    public final TextView time;
    public final ShineTextView userId;
    public final ImageView vip;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRoomActiveNormalRankBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, HiloImageView hiloImageView, HiloGradeView hiloGradeView, NickTextView nickTextView, ImageView imageView, TextView textView, TextView textView2, ShineTextView shineTextView, ImageView imageView2, HiloGradeView hiloGradeView2) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.avatar = hiloImageView;
        this.charmLevel = hiloGradeView;
        this.name = nickTextView;
        this.noble = imageView;
        this.position = textView;
        this.time = textView2;
        this.userId = shineTextView;
        this.vip = imageView2;
        this.wealthLevel = hiloGradeView2;
    }

    public static ItemRoomActiveNormalRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRoomActiveNormalRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRoomActiveNormalRankBinding bind(View view, Object obj) {
        return (ItemRoomActiveNormalRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_room_active_normal_rank);
    }

    @Deprecated
    public static ItemRoomActiveNormalRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRoomActiveNormalRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_active_normal_rank, viewGroup, z, obj);
    }

    public static ItemRoomActiveNormalRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRoomActiveNormalRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRoomActiveNormalRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_active_normal_rank, (ViewGroup) null, false, obj);
    }
}
