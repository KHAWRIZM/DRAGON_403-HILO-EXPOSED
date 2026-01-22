package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.view.RatioConstraintLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewChatRoomGameLuckyFruitResultBinding extends ViewDataBinding {
    public final CircleImageView resultAvatar1;
    public final CircleImageView resultAvatar2;
    public final CircleImageView resultAvatar3;
    public final ImageView resultBgLight;
    public final ImageView resultImage;
    public final LinearLayout resultLlGold;
    public final LinearLayout resultLlHint;
    public final TextView resultName1;
    public final TextView resultName2;
    public final TextView resultName3;
    public final TextView resultTvGold;
    public final TextView resultTvHint;
    public final TextView resultTvHint2;
    public final TextView resultTvRound;
    public final TextView resultTvTime;
    public final TextView resultUserGold1;
    public final TextView resultUserGold2;
    public final TextView resultUserGold3;
    public final LinearLayout resultUserView1;
    public final LinearLayout resultUserView2;
    public final LinearLayout resultUserView3;
    public final View titleBg;
    public final FrameLayout viewResultBase;
    public final RatioConstraintLayout viewResultContent;
    public final TextView winnerTop3Tip;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewChatRoomGameLuckyFruitResultBinding(Object obj, View view, int i, CircleImageView circleImageView, CircleImageView circleImageView2, CircleImageView circleImageView3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, View view2, FrameLayout frameLayout, RatioConstraintLayout ratioConstraintLayout, TextView textView12) {
        super(obj, view, i);
        this.resultAvatar1 = circleImageView;
        this.resultAvatar2 = circleImageView2;
        this.resultAvatar3 = circleImageView3;
        this.resultBgLight = imageView;
        this.resultImage = imageView2;
        this.resultLlGold = linearLayout;
        this.resultLlHint = linearLayout2;
        this.resultName1 = textView;
        this.resultName2 = textView2;
        this.resultName3 = textView3;
        this.resultTvGold = textView4;
        this.resultTvHint = textView5;
        this.resultTvHint2 = textView6;
        this.resultTvRound = textView7;
        this.resultTvTime = textView8;
        this.resultUserGold1 = textView9;
        this.resultUserGold2 = textView10;
        this.resultUserGold3 = textView11;
        this.resultUserView1 = linearLayout3;
        this.resultUserView2 = linearLayout4;
        this.resultUserView3 = linearLayout5;
        this.titleBg = view2;
        this.viewResultBase = frameLayout;
        this.viewResultContent = ratioConstraintLayout;
        this.winnerTop3Tip = textView12;
    }

    public static ViewChatRoomGameLuckyFruitResultBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewChatRoomGameLuckyFruitResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewChatRoomGameLuckyFruitResultBinding bind(View view, Object obj) {
        return (ViewChatRoomGameLuckyFruitResultBinding) ViewDataBinding.bind(obj, view, R.layout.view_chat_room_game_lucky_fruit_result);
    }

    @Deprecated
    public static ViewChatRoomGameLuckyFruitResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewChatRoomGameLuckyFruitResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_chat_room_game_lucky_fruit_result, viewGroup, z, obj);
    }

    public static ViewChatRoomGameLuckyFruitResultBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewChatRoomGameLuckyFruitResultBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewChatRoomGameLuckyFruitResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_chat_room_game_lucky_fruit_result, (ViewGroup) null, false, obj);
    }
}
