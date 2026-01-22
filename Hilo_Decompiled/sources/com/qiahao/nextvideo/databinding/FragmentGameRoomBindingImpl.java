package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.GroupInputLayoutView;
import com.qiahao.nextvideo.room.view.micro.GameMicroView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FragmentGameRoomBindingImpl extends FragmentGameRoomBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(20);
        sIncludes = iVar;
        iVar.a(1, new String[]{"view_room_game"}, new int[]{4}, new int[]{R.layout.view_room_game});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.frameLayout, 5);
        sparseIntArray.put(R.id.constraintLayout, 6);
        sparseIntArray.put(R.id.defaultBackGround, 7);
        sparseIntArray.put(R.id.meetingRoomThemBackGroup, 8);
        sparseIntArray.put(R.id.gameIcon, 9);
        sparseIntArray.put(R.id.gameMic, 10);
        sparseIntArray.put(R.id.chat_back, 11);
        sparseIntArray.put(R.id.gameChatLayout, 12);
        sparseIntArray.put(R.id.gift_notices_container, 13);
        sparseIntArray.put(R.id.roomGameNotice, 14);
        sparseIntArray.put(R.id.user_enter_room_content, 15);
        sparseIntArray.put(R.id.queuePlayer, 16);
        sparseIntArray.put(R.id.bg_all_black, 17);
        sparseIntArray.put(R.id.group_input_back, 18);
        sparseIntArray.put(R.id.group_input, 19);
    }

    public FragmentGameRoomBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 20, sIncludes, sViewsWithIds));
    }

    private boolean onChangeGameLayout(ViewRoomGameBinding viewRoomGameBinding, int i) {
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
            this.exit.setOnClickListener(onClickListener);
            this.showChat.setOnClickListener(onClickListener);
        }
        ViewDataBinding.executeBindingsOn(this.gameLayout);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.gameLayout.hasPendingBindings()) {
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
        this.gameLayout.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeGameLayout((ViewRoomGameBinding) obj, i2);
    }

    @Override // com.qiahao.nextvideo.databinding.FragmentGameRoomBinding
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
        this.gameLayout.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private FragmentGameRoomBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 1, (View) objArr[17], (FrameLayout) objArr[11], (ConstraintLayout) objArr[6], (ImageView) objArr[7], (ImageView) objArr[2], (FrameLayout) objArr[5], (FrameLayout) objArr[12], (ImageView) objArr[9], (ViewRoomGameBinding) objArr[4], (GameMicroView) objArr[10], (LinearLayoutCompat) objArr[13], (GroupInputLayoutView) objArr[19], (FrameLayout) objArr[18], (ImageView) objArr[8], (LightQueueCombinationPlayer) objArr[16], (LinearLayoutCompat) objArr[14], (ImageView) objArr[3], (ConstraintLayout) objArr[1], (LinearLayoutCompat) objArr[15]);
        this.mDirtyFlags = -1L;
        this.exit.setTag(null);
        setContainedBinding(this.gameLayout);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.showChat.setTag(null);
        this.topLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
