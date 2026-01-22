package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentUserProfileBindingImpl extends FragmentUserProfileBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(51);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_family_name_plate"}, new int[]{2}, new int[]{2131558989});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.familyTitle, 3);
        sparseIntArray.put(R.id.familyArrow, 4);
        sparseIntArray.put(R.id.familyBg, 5);
        sparseIntArray.put(R.id.heardBg, 6);
        sparseIntArray.put(R.id.familyAvatar, 7);
        sparseIntArray.put(R.id.familyName, 8);
        sparseIntArray.put(R.id.familyNumber, 9);
        sparseIntArray.put(R.id.ll_cp, 10);
        sparseIntArray.put(R.id.cp_certificate, 11);
        sparseIntArray.put(R.id.cp_text, 12);
        sparseIntArray.put(R.id.cpHelp, 13);
        sparseIntArray.put(R.id.cpConstraint, 14);
        sparseIntArray.put(R.id.cpBg, 15);
        sparseIntArray.put(R.id.iv_cp_heart, 16);
        sparseIntArray.put(R.id.cpModel, 17);
        sparseIntArray.put(R.id.cp_avatar1, 18);
        sparseIntArray.put(R.id.cp_avatar2, 19);
        sparseIntArray.put(R.id.cp_value, 20);
        sparseIntArray.put(R.id.relationRecycle, 21);
        sparseIntArray.put(R.id.gameLevelLayout, 22);
        sparseIntArray.put(R.id.gameLinear, 23);
        sparseIntArray.put(R.id.gameLayoutBg, 24);
        sparseIntArray.put(R.id.medalImg, 25);
        sparseIntArray.put(R.id.gameLevelTitle, 26);
        sparseIntArray.put(R.id.ll_support, 27);
        sparseIntArray.put(R.id.rank_support, 28);
        sparseIntArray.put(R.id.cp_support_title, 29);
        sparseIntArray.put(R.id.cp_support_1, 30);
        sparseIntArray.put(R.id.cp_support1_avatar, 31);
        sparseIntArray.put(R.id.cp_support1_avatar_bg, 32);
        sparseIntArray.put(R.id.cp_support1_noble1, 33);
        sparseIntArray.put(R.id.cp_support_2, 34);
        sparseIntArray.put(R.id.cp_support2_avatar, 35);
        sparseIntArray.put(R.id.cp_support2_avatar_bg, 36);
        sparseIntArray.put(R.id.cp_support2_noble2, 37);
        sparseIntArray.put(R.id.cp_support_3, 38);
        sparseIntArray.put(R.id.cp_support3_avatar, 39);
        sparseIntArray.put(R.id.cp_support3_avatar_bg, 40);
        sparseIntArray.put(R.id.cp_support3_noble3, 41);
        sparseIntArray.put(R.id.nameLayout, 42);
        sparseIntArray.put(R.id.namePlateTitle, 43);
        sparseIntArray.put(R.id.namePlateRecycler, 44);
        sparseIntArray.put(2131363568, 45);
        sparseIntArray.put(2131363784, 46);
        sparseIntArray.put(2131363837, 47);
        sparseIntArray.put(R.id.messageArrow, 48);
        sparseIntArray.put(R.id.messageGroup, 49);
        sparseIntArray.put(R.id.medal_recycler_view, 50);
    }

    public FragmentUserProfileBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 51, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFamilyNamePlate(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.familyNamePlate);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.familyNamePlate.hasPendingBindings()) {
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
            this.mDirtyFlags = 2L;
        }
        this.familyNamePlate.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeFamilyNamePlate((IncludeFamilyNamePlateBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.familyNamePlate.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentUserProfileBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (CircleImageView) objArr[18], (CircleImageView) objArr[19], (QMUIRadiusImageView) objArr[15], (LinearLayout) objArr[11], (ConstraintLayout) objArr[14], (ImageView) objArr[13], (ImageView) objArr[17], (ConstraintLayout) objArr[30], (CircleImageView) objArr[31], (ImageView) objArr[32], (ImageView) objArr[33], (ConstraintLayout) objArr[34], (CircleImageView) objArr[35], (ImageView) objArr[36], (ImageView) objArr[37], (ConstraintLayout) objArr[38], (CircleImageView) objArr[39], (ImageView) objArr[40], (ImageView) objArr[41], (AppCompatTextView) objArr[29], (AppCompatTextView) objArr[12], (TextView) objArr[20], (ImageView) objArr[4], (PolygonImageView) objArr[7], (ImageView) objArr[5], (TextView) objArr[8], (IncludeFamilyNamePlateBinding) objArr[2], (TextView) objArr[9], (TextView) objArr[3], (ImageView) objArr[24], (ConstraintLayout) objArr[22], (TextView) objArr[26], (LinearLayout) objArr[23], (ImageView) objArr[6], (SVGAImageView) objArr[16], (LinearLayout) objArr[10], (ConstraintLayout) objArr[45], (LinearLayout) objArr[27], (AppCompatTextView) objArr[46], (ImageView) objArr[25], (RecyclerView) objArr[50], (TextView) objArr[47], (ImageView) objArr[48], (Group) objArr[49], (ConstraintLayout) objArr[1], (LinearLayout) objArr[42], (RecyclerView) objArr[44], (AppCompatTextView) objArr[43], (LinearLayout) objArr[28], (RecyclerView) objArr[21]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.familyNamePlate);
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.myFamilyLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
