package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.luckyfruit.LuckyBaseGridView;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewChatRoomGameLuckyFruitBinding extends ViewDataBinding {
    public final ImageView bg;
    public final View bgResult;
    public final ImageView close;
    public final ConstraintLayout constraintLayout;
    public final DiamondTickTextView diamondCountTickTextView;
    public final ImageView fruitActivity;
    public final LinearLayout llDiamond;
    public final ViewChatRoomGameLuckyFruitResultBinding llResult;
    public final ImageView logo;
    public final LuckyBaseGridView luckyView;
    public final ImageView rank;
    public final RadioButton rbGold1;
    public final RadioButton rbGold2;
    public final RadioButton rbGold3;
    public final RadioButton rbGold4;
    public final RadioButton rbGold5;
    public final ImageView record;
    public final TextView repeat;
    public final RecyclerView resultRecycler;
    public final RadioGroup rgGold;
    public final ConstraintLayout rlHead;
    public final ImageView rule;
    public final TextView tvRoundCount;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewChatRoomGameLuckyFruitBinding(Object obj, View view, int i, ImageView imageView, View view2, ImageView imageView2, ConstraintLayout constraintLayout, DiamondTickTextView diamondTickTextView, ImageView imageView3, LinearLayout linearLayout, ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding, ImageView imageView4, LuckyBaseGridView luckyBaseGridView, ImageView imageView5, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, ImageView imageView6, TextView textView, RecyclerView recyclerView, RadioGroup radioGroup, ConstraintLayout constraintLayout2, ImageView imageView7, TextView textView2) {
        super(obj, view, i);
        this.bg = imageView;
        this.bgResult = view2;
        this.close = imageView2;
        this.constraintLayout = constraintLayout;
        this.diamondCountTickTextView = diamondTickTextView;
        this.fruitActivity = imageView3;
        this.llDiamond = linearLayout;
        this.llResult = viewChatRoomGameLuckyFruitResultBinding;
        this.logo = imageView4;
        this.luckyView = luckyBaseGridView;
        this.rank = imageView5;
        this.rbGold1 = radioButton;
        this.rbGold2 = radioButton2;
        this.rbGold3 = radioButton3;
        this.rbGold4 = radioButton4;
        this.rbGold5 = radioButton5;
        this.record = imageView6;
        this.repeat = textView;
        this.resultRecycler = recyclerView;
        this.rgGold = radioGroup;
        this.rlHead = constraintLayout2;
        this.rule = imageView7;
        this.tvRoundCount = textView2;
    }

    public static ViewChatRoomGameLuckyFruitBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewChatRoomGameLuckyFruitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewChatRoomGameLuckyFruitBinding bind(View view, Object obj) {
        return (ViewChatRoomGameLuckyFruitBinding) ViewDataBinding.bind(obj, view, R.layout.view_chat_room_game_lucky_fruit);
    }

    @Deprecated
    public static ViewChatRoomGameLuckyFruitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewChatRoomGameLuckyFruitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_chat_room_game_lucky_fruit, viewGroup, z, obj);
    }

    public static ViewChatRoomGameLuckyFruitBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewChatRoomGameLuckyFruitBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewChatRoomGameLuckyFruitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_chat_room_game_lucky_fruit, (ViewGroup) null, false, obj);
    }
}
