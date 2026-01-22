package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.luckyfruit.LuckyBaseGridView;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ViewChatRoomGameLuckyFruitBindingImpl extends ViewChatRoomGameLuckyFruitBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(24);
        sIncludes = iVar;
        iVar.a(0, new String[]{"view_chat_room_game_lucky_fruit_result"}, new int[]{1}, new int[]{R.layout.view_chat_room_game_lucky_fruit_result});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.rl_head, 2);
        sparseIntArray.put(R.id.ll_diamond, 3);
        sparseIntArray.put(R.id.diamond_count_tick_text_view, 4);
        sparseIntArray.put(R.id.close, 5);
        sparseIntArray.put(R.id.rule, 6);
        sparseIntArray.put(R.id.record, 7);
        sparseIntArray.put(R.id.rank, 8);
        sparseIntArray.put(R.id.constraintLayout, 9);
        sparseIntArray.put(2131362100, 10);
        sparseIntArray.put(R.id.lucky_view, 11);
        sparseIntArray.put(2131364565, 12);
        sparseIntArray.put(R.id.rg_gold, 13);
        sparseIntArray.put(R.id.rb_gold1, 14);
        sparseIntArray.put(R.id.rb_gold2, 15);
        sparseIntArray.put(R.id.rb_gold3, 16);
        sparseIntArray.put(R.id.rb_gold4, 17);
        sparseIntArray.put(R.id.rb_gold5, 18);
        sparseIntArray.put(R.id.bg_result, 19);
        sparseIntArray.put(R.id.result_recycler, 20);
        sparseIntArray.put(R.id.logo, 21);
        sparseIntArray.put(R.id.tv_round_count, 22);
        sparseIntArray.put(R.id.fruit_activity, 23);
    }

    public ViewChatRoomGameLuckyFruitBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 24, sIncludes, sViewsWithIds));
    }

    private boolean onChangeLlResult(ViewChatRoomGameLuckyFruitResultBinding viewChatRoomGameLuckyFruitResultBinding, int i) {
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
        ViewDataBinding.executeBindingsOn(this.llResult);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.llResult.hasPendingBindings()) {
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
        this.llResult.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeLlResult((ViewChatRoomGameLuckyFruitResultBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.llResult.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private ViewChatRoomGameLuckyFruitBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (ImageView) objArr[10], (View) objArr[19], (ImageView) objArr[5], (ConstraintLayout) objArr[9], (DiamondTickTextView) objArr[4], (ImageView) objArr[23], (LinearLayout) objArr[3], (ViewChatRoomGameLuckyFruitResultBinding) objArr[1], (ImageView) objArr[21], (LuckyBaseGridView) objArr[11], (ImageView) objArr[8], (RadioButton) objArr[14], (RadioButton) objArr[15], (RadioButton) objArr[16], (RadioButton) objArr[17], (RadioButton) objArr[18], (ImageView) objArr[7], (TextView) objArr[12], (RecyclerView) objArr[20], (RadioGroup) objArr[13], (ConstraintLayout) objArr[2], (ImageView) objArr[6], (TextView) objArr[22]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.llResult);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
