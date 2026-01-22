package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.webview.BaseWebView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class AudioHiloGameBindingImpl extends AudioHiloGameBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(28);
        sIncludes = iVar;
        iVar.a(1, new String[]{"audio_hilo_game_bet_item", "audio_hilo_game_bet_item", "audio_hilo_game_bet_item", "audio_hilo_game_bet_item", "audio_hilo_game_bet_item"}, new int[]{2, 3, 4, 5, 6}, new int[]{R.layout.audio_hilo_game_bet_item, R.layout.audio_hilo_game_bet_item, R.layout.audio_hilo_game_bet_item, R.layout.audio_hilo_game_bet_item, R.layout.audio_hilo_game_bet_item});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.gameConstraint, 7);
        sparseIntArray.put(R.id.gameLayout, 8);
        sparseIntArray.put(2131362100, 9);
        sparseIntArray.put(R.id.cardView, 10);
        sparseIntArray.put(R.id.webView, 11);
        sparseIntArray.put(R.id.downloadLayout, 12);
        sparseIntArray.put(R.id.downloadSvga, 13);
        sparseIntArray.put(R.id.downloadText, 14);
        sparseIntArray.put(R.id.betLayout, 15);
        sparseIntArray.put(R.id.betBg, 16);
        sparseIntArray.put(R.id.betTitle, 17);
        sparseIntArray.put(R.id.betDiamond, 18);
        sparseIntArray.put(R.id.winSvga, 19);
        sparseIntArray.put(R.id.micLayout, 20);
        sparseIntArray.put(R.id.micRecyclerView, 21);
        sparseIntArray.put(R.id.onLineLayout, 22);
        sparseIntArray.put(R.id.leftAvatar, 23);
        sparseIntArray.put(R.id.rightAvatar, 24);
        sparseIntArray.put(R.id.onLineCount, 25);
        sparseIntArray.put(R.id.onlineIcon, 26);
        sparseIntArray.put(R.id.count, 27);
    }

    public AudioHiloGameBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 28, sIncludes, sViewsWithIds));
    }

    private boolean onChangeBet1(AudioHiloGameBetItemBinding audioHiloGameBetItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBet2(AudioHiloGameBetItemBinding audioHiloGameBetItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBet3(AudioHiloGameBetItemBinding audioHiloGameBetItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBet4(AudioHiloGameBetItemBinding audioHiloGameBetItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeBet5(AudioHiloGameBetItemBinding audioHiloGameBetItemBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.bet1);
        ViewDataBinding.executeBindingsOn(this.bet2);
        ViewDataBinding.executeBindingsOn(this.bet3);
        ViewDataBinding.executeBindingsOn(this.bet4);
        ViewDataBinding.executeBindingsOn(this.bet5);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.bet1.hasPendingBindings() || this.bet2.hasPendingBindings() || this.bet3.hasPendingBindings() || this.bet4.hasPendingBindings() || this.bet5.hasPendingBindings()) {
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
            this.mDirtyFlags = 32L;
        }
        this.bet1.invalidateAll();
        this.bet2.invalidateAll();
        this.bet3.invalidateAll();
        this.bet4.invalidateAll();
        this.bet5.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeBet3((AudioHiloGameBetItemBinding) obj, i2);
                    }
                    return onChangeBet1((AudioHiloGameBetItemBinding) obj, i2);
                }
                return onChangeBet5((AudioHiloGameBetItemBinding) obj, i2);
            }
            return onChangeBet4((AudioHiloGameBetItemBinding) obj, i2);
        }
        return onChangeBet2((AudioHiloGameBetItemBinding) obj, i2);
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.bet1.setLifecycleOwner(lifecycleOwner);
        this.bet2.setLifecycleOwner(lifecycleOwner);
        this.bet3.setLifecycleOwner(lifecycleOwner);
        this.bet4.setLifecycleOwner(lifecycleOwner);
        this.bet5.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    private AudioHiloGameBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 5, (AudioHiloGameBetItemBinding) objArr[2], (AudioHiloGameBetItemBinding) objArr[3], (AudioHiloGameBetItemBinding) objArr[4], (AudioHiloGameBetItemBinding) objArr[5], (AudioHiloGameBetItemBinding) objArr[6], (View) objArr[16], (TextView) objArr[18], (ConstraintLayout) objArr[15], (TextView) objArr[17], (View) objArr[9], (ConstraintLayout) objArr[1], (CardView) objArr[10], (TextView) objArr[27], (ConstraintLayout) objArr[12], (SVGAImageView) objArr[13], (TextView) objArr[14], (ConstraintLayout) objArr[7], (ConstraintLayout) objArr[8], (QMUIRadiusImageView) objArr[23], (LinearLayout) objArr[20], (RecyclerView) objArr[21], (ConstraintLayout) objArr[25], (ConstraintLayout) objArr[22], (ImageView) objArr[26], (QMUIRadiusImageView) objArr[24], (BaseWebView) objArr[11], (SVGAImageView) objArr[19]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.bet1);
        setContainedBinding(this.bet2);
        setContainedBinding(this.bet3);
        setContainedBinding(this.bet4);
        setContainedBinding(this.bet5);
        this.buttonLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
