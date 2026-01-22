package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.planet.PlanetsView;
import r1.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentHomeMatchingHeadBindingImpl extends FragmentHomeMatchingHeadBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(13);
        sIncludes = iVar;
        iVar.a(0, new String[]{"include_match_big_item", "include_match_big_item", "include_match_big_item", "include_match_big_item", "include_match_big_item", "include_match_min_item", "include_match_min_item"}, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{R.layout.include_match_big_item, R.layout.include_match_big_item, R.layout.include_match_big_item, R.layout.include_match_big_item, R.layout.include_match_big_item, R.layout.include_match_min_item, R.layout.include_match_min_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.planetView, 8);
        sparseIntArray.put(R.id.leftIcon, 9);
        sparseIntArray.put(R.id.numberTitle, 10);
        sparseIntArray.put(R.id.number, 11);
        sparseIntArray.put(R.id.rightIcon, 12);
    }

    public FragmentHomeMatchingHeadBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 13, sIncludes, sViewsWithIds));
    }

    private boolean onChangeBaiShun(IncludeMatchBigItemBinding includeMatchBigItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBroadcastLayout(IncludeMatchBigItemBinding includeMatchBigItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeChatLayout(IncludeMatchBigItemBinding includeMatchBigItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeFishingLayout(IncludeMatchMinItemBinding includeMatchMinItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeMatchLayout(IncludeMatchBigItemBinding includeMatchBigItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeSlotsLayout(IncludeMatchMinItemBinding includeMatchMinItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeVideoLayout(IncludeMatchBigItemBinding includeMatchBigItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
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
        if ((j & 128) != 0) {
            this.baiShun.setButtonTitle(getRoot().getResources().getString(2131953663));
            this.baiShun.setImageSrc(a.b(getRoot().getContext(), R.drawable.home_bai_shun_icon));
            this.baiShun.setSubTitle(getRoot().getResources().getString(2131953075));
            this.baiShun.setTitle(getRoot().getResources().getString(2131952067));
            IncludeMatchBigItemBinding includeMatchBigItemBinding = this.baiShun;
            Boolean bool = Boolean.TRUE;
            includeMatchBigItemBinding.setVisibilityButton(bool);
            this.broadcastLayout.setButtonTitle(getRoot().getResources().getString(2131953154));
            this.broadcastLayout.setImageSrc(a.b(getRoot().getContext(), R.drawable.home_brroadcast_icon));
            this.broadcastLayout.setSubTitle(getRoot().getResources().getString(2131953068));
            this.broadcastLayout.setTitle(getRoot().getResources().getString(2131952146));
            IncludeMatchBigItemBinding includeMatchBigItemBinding2 = this.broadcastLayout;
            Boolean bool2 = Boolean.FALSE;
            includeMatchBigItemBinding2.setVisibilityButton(bool2);
            this.chatLayout.setImageSrc(a.b(getRoot().getContext(), R.drawable.home_chat_icon));
            this.chatLayout.setSubTitle(getRoot().getResources().getString(2131953069));
            this.chatLayout.setTitle(getRoot().getResources().getString(2131953070));
            this.chatLayout.setButtonTitle(getRoot().getResources().getString(2131953154));
            this.chatLayout.setVisibilityButton(bool);
            this.fishingLayout.setImageSrc(a.b(getRoot().getContext(), R.drawable.home_fishing_icon));
            this.fishingLayout.setTitle(getRoot().getResources().getString(2131953071));
            this.matchLayout.setButtonTitle(getRoot().getResources().getString(2131953154));
            this.matchLayout.setImageSrc(a.b(getRoot().getContext(), R.drawable.home_video_icon));
            this.matchLayout.setSubTitle(getRoot().getResources().getString(2131953072));
            this.matchLayout.setTitle(getRoot().getResources().getString(2131954432));
            this.matchLayout.setVisibilityButton(bool);
            this.slotsLayout.setImageSrc(a.b(getRoot().getContext(), R.drawable.home_slots_icon));
            this.slotsLayout.setTitle(getRoot().getResources().getString(2131953074));
            this.videoLayout.setButtonTitle(getRoot().getResources().getString(2131953154));
            this.videoLayout.setImageSrc(a.b(getRoot().getContext(), R.drawable.home_match_icon));
            this.videoLayout.setSubTitle(getRoot().getResources().getString(2131954475));
            this.videoLayout.setTitle(getRoot().getResources().getString(2131954474));
            this.videoLayout.setVisibilityButton(bool2);
        }
        ViewDataBinding.executeBindingsOn(this.matchLayout);
        ViewDataBinding.executeBindingsOn(this.videoLayout);
        ViewDataBinding.executeBindingsOn(this.broadcastLayout);
        ViewDataBinding.executeBindingsOn(this.chatLayout);
        ViewDataBinding.executeBindingsOn(this.baiShun);
        ViewDataBinding.executeBindingsOn(this.slotsLayout);
        ViewDataBinding.executeBindingsOn(this.fishingLayout);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.matchLayout.hasPendingBindings() || this.videoLayout.hasPendingBindings() || this.broadcastLayout.hasPendingBindings() || this.chatLayout.hasPendingBindings() || this.baiShun.hasPendingBindings() || this.slotsLayout.hasPendingBindings() || this.fishingLayout.hasPendingBindings()) {
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
            this.mDirtyFlags = 128L;
        }
        this.matchLayout.invalidateAll();
        this.videoLayout.invalidateAll();
        this.broadcastLayout.invalidateAll();
        this.chatLayout.invalidateAll();
        this.baiShun.invalidateAll();
        this.slotsLayout.invalidateAll();
        this.fishingLayout.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeFishingLayout((IncludeMatchMinItemBinding) obj, i2);
            case 1:
                return onChangeSlotsLayout((IncludeMatchMinItemBinding) obj, i2);
            case 2:
                return onChangeChatLayout((IncludeMatchBigItemBinding) obj, i2);
            case 3:
                return onChangeBaiShun((IncludeMatchBigItemBinding) obj, i2);
            case 4:
                return onChangeMatchLayout((IncludeMatchBigItemBinding) obj, i2);
            case 5:
                return onChangeBroadcastLayout((IncludeMatchBigItemBinding) obj, i2);
            case 6:
                return onChangeVideoLayout((IncludeMatchBigItemBinding) obj, i2);
            default:
                return false;
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.matchLayout.setLifecycleOwner(lifecycleOwner);
        this.videoLayout.setLifecycleOwner(lifecycleOwner);
        this.broadcastLayout.setLifecycleOwner(lifecycleOwner);
        this.chatLayout.setLifecycleOwner(lifecycleOwner);
        this.baiShun.setLifecycleOwner(lifecycleOwner);
        this.slotsLayout.setLifecycleOwner(lifecycleOwner);
        this.fishingLayout.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private FragmentHomeMatchingHeadBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 7, (IncludeMatchBigItemBinding) objArr[5], (IncludeMatchBigItemBinding) objArr[3], (IncludeMatchBigItemBinding) objArr[4], (IncludeMatchMinItemBinding) objArr[7], (ImageView) objArr[9], (IncludeMatchBigItemBinding) objArr[1], (TextView) objArr[11], (TextView) objArr[10], (PlanetsView) objArr[8], (ImageView) objArr[12], (IncludeMatchMinItemBinding) objArr[6], (IncludeMatchBigItemBinding) objArr[2]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.baiShun);
        setContainedBinding(this.broadcastLayout);
        setContainedBinding(this.chatLayout);
        setContainedBinding(this.fishingLayout);
        setContainedBinding(this.matchLayout);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.slotsLayout);
        setContainedBinding(this.videoLayout);
        setRootTag(view);
        invalidateAll();
    }
}
