package com.qhqc.core.feature.community.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.qhqc.core.basic.widget.ratioview.RatioImageView;
import com.qhqc.core.feature.community.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class FeatureCommunityItemPicPostsCreateBinding implements a {
    public final CardView cardView;
    public final AppCompatImageView mIvDel;
    public final RatioImageView mIvPic;
    private final CardView rootView;

    private FeatureCommunityItemPicPostsCreateBinding(CardView cardView, CardView cardView2, AppCompatImageView appCompatImageView, RatioImageView ratioImageView) {
        this.rootView = cardView;
        this.cardView = cardView2;
        this.mIvDel = appCompatImageView;
        this.mIvPic = ratioImageView;
    }

    public static FeatureCommunityItemPicPostsCreateBinding bind(View view) {
        CardView cardView = (CardView) view;
        int i10 = R.id.mIvDel;
        AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i10);
        if (appCompatImageView != null) {
            i10 = R.id.mIvPic;
            RatioImageView ratioImageView = (RatioImageView) b.a(view, i10);
            if (ratioImageView != null) {
                return new FeatureCommunityItemPicPostsCreateBinding(cardView, cardView, appCompatImageView, ratioImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static FeatureCommunityItemPicPostsCreateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FeatureCommunityItemPicPostsCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.feature_community_item_pic_posts_create, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // j3.a
    public CardView getRoot() {
        return this.rootView;
    }
}
