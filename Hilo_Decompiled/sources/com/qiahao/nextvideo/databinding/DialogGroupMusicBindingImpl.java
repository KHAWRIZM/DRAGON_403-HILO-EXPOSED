package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogGroupMusicBindingImpl extends DialogGroupMusicBinding {
    private static final ViewDataBinding.i sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.empty_palylist, 10);
        sparseIntArray.put(R.id.ll_music_play, 11);
        sparseIntArray.put(R.id.music_name, 12);
        sparseIntArray.put(R.id.startText, 13);
        sparseIntArray.put(R.id.playProgress, 14);
        sparseIntArray.put(R.id.endText, 15);
        sparseIntArray.put(R.id.voiceLayout, 16);
        sparseIntArray.put(2131365189, 17);
        sparseIntArray.put(R.id.seekLayout, 18);
        sparseIntArray.put(R.id.voice_seek, 19);
    }

    public DialogGroupMusicBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 20, sIncludes, sViewsWithIds));
    }

    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        View.OnClickListener onClickListener = this.mClick;
        if ((j & 3) != 0) {
            this.audio.setOnClickListener(onClickListener);
            this.cancel.setOnClickListener(onClickListener);
            this.close.setOnClickListener(onClickListener);
            this.emptyAddMusic.setOnClickListener(onClickListener);
            this.musicList.setOnClickListener(onClickListener);
            this.musicRotationType.setOnClickListener(onClickListener);
            this.nextMusic.setOnClickListener(onClickListener);
            this.oldMusic.setOnClickListener(onClickListener);
            this.playPauseMusic.setOnClickListener(onClickListener);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.qiahao.nextvideo.databinding.DialogGroupMusicBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private DialogGroupMusicBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 0, (ImageView) objArr[2], (TextView) objArr[9], (ImageView) objArr[3], (TextView) objArr[1], (LinearLayout) objArr[10], (TextView) objArr[15], (LinearLayout) objArr[11], (ImageView) objArr[8], (TextView) objArr[12], (ImageView) objArr[7], (ImageView) objArr[6], (ImageView) objArr[4], (ImageView) objArr[5], (SeekBar) objArr[14], (LinearLayout) objArr[18], (TextView) objArr[13], (TextView) objArr[17], (ConstraintLayout) objArr[16], (SeekBar) objArr[19]);
        this.mDirtyFlags = -1L;
        this.audio.setTag(null);
        this.cancel.setTag(null);
        this.close.setTag(null);
        this.emptyAddMusic.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.musicList.setTag(null);
        this.musicRotationType.setTag(null);
        this.nextMusic.setTag(null);
        this.oldMusic.setTag(null);
        this.playPauseMusic.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
