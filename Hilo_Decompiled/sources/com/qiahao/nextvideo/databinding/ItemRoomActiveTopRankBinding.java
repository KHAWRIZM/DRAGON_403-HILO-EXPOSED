package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemRoomActiveTopRankBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final HiloImageView avatar;
    public final TextView content;
    public final ImageView head;

    /* renamed from: id, reason: collision with root package name */
    public final ShineTextView f٦٤id;
    public final NickTextView name;
    public final ImageView noble;
    public final TextView time;
    public final ImageView vip;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemRoomActiveTopRankBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, HiloImageView hiloImageView, TextView textView, ImageView imageView, ShineTextView shineTextView, NickTextView nickTextView, ImageView imageView2, TextView textView2, ImageView imageView3) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.avatar = hiloImageView;
        this.content = textView;
        this.head = imageView;
        this.f٦٤id = shineTextView;
        this.name = nickTextView;
        this.noble = imageView2;
        this.time = textView2;
        this.vip = imageView3;
    }

    public static ItemRoomActiveTopRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemRoomActiveTopRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemRoomActiveTopRankBinding bind(View view, Object obj) {
        return (ItemRoomActiveTopRankBinding) ViewDataBinding.bind(obj, view, R.layout.item_room_active_top_rank);
    }

    @Deprecated
    public static ItemRoomActiveTopRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemRoomActiveTopRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_active_top_rank, viewGroup, z, obj);
    }

    public static ItemRoomActiveTopRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemRoomActiveTopRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemRoomActiveTopRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_room_active_top_rank, (ViewGroup) null, false, obj);
    }
}
