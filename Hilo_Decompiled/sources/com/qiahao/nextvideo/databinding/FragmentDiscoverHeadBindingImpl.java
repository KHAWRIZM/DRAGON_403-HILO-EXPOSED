package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.BaseStatusEmptyBinding;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.home.discover.DiscoverBroadCastView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentDiscoverHeadBindingImpl extends FragmentDiscoverHeadBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final LinearLayout mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.empty, 2);
        sparseIntArray.put(R.id.ll_power, 3);
        sparseIntArray.put(R.id.power_tip, 4);
        sparseIntArray.put(R.id.power_rank_flipper, 5);
        sparseIntArray.put(R.id.ll_famous, 6);
        sparseIntArray.put(R.id.rank_text, 7);
        sparseIntArray.put(R.id.all_rank_flipper, 8);
        sparseIntArray.put(R.id.ll_cp, 9);
        sparseIntArray.put(R.id.cp_rank_text, 10);
        sparseIntArray.put(R.id.cp_rank_flipper, 11);
        sparseIntArray.put(R.id.countryFrameLayout, 12);
        sparseIntArray.put(R.id.countryLayout, 13);
        sparseIntArray.put(R.id.countryMore, 14);
        sparseIntArray.put(R.id.discover_country_recycler, 15);
        sparseIntArray.put(R.id.cl_country, 16);
        sparseIntArray.put(R.id.country_image, 17);
        sparseIntArray.put(R.id.country_name, 18);
        sparseIntArray.put(R.id.country_top1, 19);
        sparseIntArray.put(R.id.country_top2, 20);
        sparseIntArray.put(R.id.country_top3, 21);
        sparseIntArray.put(R.id.country_bg_top1, 22);
        sparseIntArray.put(R.id.country_bg_top2, 23);
        sparseIntArray.put(R.id.country_bg_top3, 24);
        sparseIntArray.put(R.id.constraint_gift, 25);
        sparseIntArray.put(R.id.gift_wall_flipper, 26);
        sparseIntArray.put(R.id.broadCastMore, 27);
        sparseIntArray.put(R.id.discover_broad_cast, 28);
        sparseIntArray.put(R.id.activityLayout, 29);
        sparseIntArray.put(R.id.moreLayout, 30);
        sparseIntArray.put(R.id.more, 31);
        sparseIntArray.put(R.id.activityRecycler, 32);
        sparseIntArray.put(R.id.event, 33);
    }

    public FragmentDiscoverHeadBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 34, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private FragmentDiscoverHeadBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r0 != null ? BaseStatusEmptyBinding.bind((View) r0) : null, (TextView) objArr[33], (ViewFlipper) objArr[26], (ConstraintLayout) objArr[9], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[3], (TextView) objArr[31], (LinearLayout) objArr[30], (ViewFlipper) objArr[5], (TextView) objArr[4], (TextView) objArr[7]);
        FrameLayout frameLayout = (FrameLayout) objArr[29];
        RecyclerView recyclerView = (RecyclerView) objArr[32];
        ViewFlipper viewFlipper = (ViewFlipper) objArr[8];
        LinearLayout linearLayout = (LinearLayout) objArr[27];
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[16];
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[25];
        ImageView imageView = (ImageView) objArr[22];
        ImageView imageView2 = (ImageView) objArr[23];
        ImageView imageView3 = (ImageView) objArr[24];
        FrameLayout frameLayout2 = (FrameLayout) objArr[12];
        ImageView imageView4 = (ImageView) objArr[17];
        LinearLayout linearLayout2 = (LinearLayout) objArr[13];
        TextView textView = (TextView) objArr[14];
        TextView textView2 = (TextView) objArr[18];
        CircleImageView circleImageView = (CircleImageView) objArr[19];
        CircleImageView circleImageView2 = (CircleImageView) objArr[20];
        CircleImageView circleImageView3 = (CircleImageView) objArr[21];
        ViewFlipper viewFlipper2 = (ViewFlipper) objArr[11];
        TextView textView3 = (TextView) objArr[10];
        DiscoverBroadCastView discoverBroadCastView = (DiscoverBroadCastView) objArr[28];
        RecyclerView recyclerView2 = (RecyclerView) objArr[15];
        Object obj = objArr[2];
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout3;
        constraintLayout3.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[1];
        this.mboundView1 = linearLayout3;
        linearLayout3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
