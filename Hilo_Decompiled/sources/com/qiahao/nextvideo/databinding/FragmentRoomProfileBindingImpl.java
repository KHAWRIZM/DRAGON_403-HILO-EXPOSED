package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentRoomProfileBindingImpl extends FragmentRoomProfileBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(37);
        sIncludes = iVar;
        iVar.a(1, new String[]{"include_family_name_plate"}, new int[]{10}, new int[]{2131558989});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.familyTitle, 11);
        sparseIntArray.put(R.id.familyArrow, 12);
        sparseIntArray.put(R.id.familyBg, 13);
        sparseIntArray.put(R.id.heardBg, 14);
        sparseIntArray.put(R.id.familyAvatar, 15);
        sparseIntArray.put(R.id.familyName, 16);
        sparseIntArray.put(R.id.familyNumber, 17);
        sparseIntArray.put(R.id.group_member_recycler, 18);
        sparseIntArray.put(R.id.group_contribution, 19);
        sparseIntArray.put(R.id.all_diamond, 20);
        sparseIntArray.put(R.id.fl_top1, 21);
        sparseIntArray.put(R.id.top1_avatar, 22);
        sparseIntArray.put(R.id.fl_top2, 23);
        sparseIntArray.put(R.id.top2_avatar, 24);
        sparseIntArray.put(R.id.fl_top3, 25);
        sparseIntArray.put(R.id.top3_avatar, 26);
        sparseIntArray.put(R.id.enter_right, 27);
        sparseIntArray.put(R.id.supportImage, 28);
        sparseIntArray.put(R.id.groupActivityImage, 29);
        sparseIntArray.put(2131363568, 30);
        sparseIntArray.put(2131363784, 31);
        sparseIntArray.put(R.id.medal_recycler_view, 32);
        sparseIntArray.put(R.id.introduction, 33);
        sparseIntArray.put(R.id.introduction_content, 34);
        sparseIntArray.put(R.id.announcement, 35);
        sparseIntArray.put(R.id.announcement_content, 36);
    }

    public FragmentRoomProfileBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 37, sIncludes, sViewsWithIds));
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
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 6) != 0) {
            this.groupActivity.setOnClickListener(onClickListener);
            this.groupMember.setOnClickListener(onClickListener);
            this.groupMemberLayout.setOnClickListener(onClickListener);
            this.joinButton.setOnClickListener(onClickListener);
            this.lcGroupSupport.setOnClickListener(onClickListener);
            this.llGroupContribution.setOnClickListener(onClickListener);
            this.llLeave.setOnClickListener(onClickListener);
            this.setting.setOnClickListener(onClickListener);
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
            this.mDirtyFlags = 4L;
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

    @Override // com.qiahao.nextvideo.databinding.FragmentRoomProfileBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.familyNamePlate.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private FragmentRoomProfileBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (TextView) objArr[20], (TextView) objArr[35], (TextView) objArr[36], (ImageView) objArr[27], (ImageView) objArr[12], (PolygonImageView) objArr[15], (ImageView) objArr[13], (TextView) objArr[16], (IncludeFamilyNamePlateBinding) objArr[10], (TextView) objArr[17], (TextView) objArr[11], (FrameLayout) objArr[21], (FrameLayout) objArr[23], (FrameLayout) objArr[25], (ConstraintLayout) objArr[6], (ImageView) objArr[29], (TextView) objArr[19], (TextView) objArr[3], (ConstraintLayout) objArr[2], (RecyclerView) objArr[18], (ImageView) objArr[14], (TextView) objArr[33], (TextView) objArr[34], (TextView) objArr[7], (ConstraintLayout) objArr[5], (LinearLayout) objArr[4], (TextView) objArr[9], (LinearLayout) objArr[30], (AppCompatTextView) objArr[31], (RecyclerView) objArr[32], (ConstraintLayout) objArr[1], (TextView) objArr[8], (ImageView) objArr[28], (CircleImageView) objArr[22], (CircleImageView) objArr[24], (CircleImageView) objArr[26]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.familyNamePlate);
        this.groupActivity.setTag(null);
        this.groupMember.setTag(null);
        this.groupMemberLayout.setTag(null);
        this.joinButton.setTag(null);
        this.lcGroupSupport.setTag(null);
        this.llGroupContribution.setTag(null);
        this.llLeave.setTag(null);
        NestedScrollView nestedScrollView = (NestedScrollView) objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.myFamilyLayout.setTag(null);
        this.setting.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
