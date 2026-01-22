package com.qiahao.nextvideo.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.lifecycle.LifecycleOwner;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.databinding.IncludeGameLevelBinding;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.HiloMedalView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class DialogRoomUserInfoBindingImpl extends DialogRoomUserInfoBinding {
    private static final ViewDataBinding.i sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.i iVar = new ViewDataBinding.i(57);
        sIncludes = iVar;
        iVar.a(4, new String[]{"include_family_name_plate", "include_game_level"}, new int[]{14, 15}, new int[]{2131558989, 2131558990});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.queuePlayer, 16);
        sparseIntArray.put(R.id.back_height, 17);
        sparseIntArray.put(R.id.content_bg, 18);
        sparseIntArray.put(R.id.noble_bg, 19);
        sparseIntArray.put(R.id.top_view, 20);
        sparseIntArray.put(R.id.noble_svga, 21);
        sparseIntArray.put(R.id.countrySVGA, 22);
        sparseIntArray.put(2131365536, 23);
        sparseIntArray.put(R.id.mic_user_head_svga, 24);
        sparseIntArray.put(R.id.mic_user_head_img, 25);
        sparseIntArray.put(2131363173, 26);
        sparseIntArray.put(R.id.svipMedal, 27);
        sparseIntArray.put(R.id.user_avatar_two, 28);
        sparseIntArray.put(R.id.mic_user_head_svga_two, 29);
        sparseIntArray.put(R.id.mic_user_head_img_two, 30);
        sparseIntArray.put(R.id.icon_noble_two, 31);
        sparseIntArray.put(R.id.svipMedalTwo, 32);
        sparseIntArray.put(R.id.cpModel, 33);
        sparseIntArray.put(R.id.cpGroup, 34);
        sparseIntArray.put(2131361956, 35);
        sparseIntArray.put(2131365557, 36);
        sparseIntArray.put(R.id.ll_user_info, 37);
        sparseIntArray.put(R.id.svipType, 38);
        sparseIntArray.put(R.id.svipTypeLine, 39);
        sparseIntArray.put(R.id.countryID, 40);
        sparseIntArray.put(R.id.image_view_country, 41);
        sparseIntArray.put(R.id.country_text, 42);
        sparseIntArray.put(R.id.user_tag_view, 43);
        sparseIntArray.put(R.id.image_user_tag, 44);
        sparseIntArray.put(R.id.user_tag_text, 45);
        sparseIntArray.put(R.id.newUser, 46);
        sparseIntArray.put(R.id.age_text_view, 47);
        sparseIntArray.put(2131365691, 48);
        sparseIntArray.put(2131362273, 49);
        sparseIntArray.put(R.id.activity_level, 50);
        sparseIntArray.put(2131363182, 51);
        sparseIntArray.put(R.id.ll_meadl, 52);
        sparseIntArray.put(R.id.ll_user_operator, 53);
        sparseIntArray.put(R.id.image_like, 54);
        sparseIntArray.put(2131362160, 55);
        sparseIntArray.put(R.id.ll_user_micro_room_operator, 56);
    }

    public DialogRoomUserInfoBindingImpl(f fVar, View view) {
        this(fVar, view, ViewDataBinding.mapBindings(fVar, view, 57, sIncludes, sViewsWithIds));
    }

    private boolean onChangeFamilyNamePlate(IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeGameLevel(IncludeGameLevelBinding includeGameLevelBinding, int i) {
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
        if ((j & 12) != 0) {
            this.callUser.setOnClickListener(onClickListener);
            this.imageInviteUserUpMic.setOnClickListener(onClickListener);
            this.imageUserDownMic.setOnClickListener(onClickListener);
            this.imageUserInfo.setOnClickListener(onClickListener);
            this.imageUserLeaveRoom.setOnClickListener(onClickListener);
            this.imageUserMuteOpenMic.setOnClickListener(onClickListener);
            this.llGift.setOnClickListener(onClickListener);
            this.llLike.setOnClickListener(onClickListener);
            this.llMessage.setOnClickListener(onClickListener);
            this.llVideo.setOnClickListener(onClickListener);
            this.micMute.setOnClickListener(onClickListener);
            this.reportImageView.setOnClickListener(onClickListener);
            this.rootBg.setOnClickListener(onClickListener);
        }
        ViewDataBinding.executeBindingsOn(this.familyNamePlate);
        ViewDataBinding.executeBindingsOn(this.gameLevel);
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            try {
                if (this.mDirtyFlags != 0) {
                    return true;
                }
                if (this.familyNamePlate.hasPendingBindings() || this.gameLevel.hasPendingBindings()) {
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
            this.mDirtyFlags = 8L;
        }
        this.familyNamePlate.invalidateAll();
        this.gameLevel.invalidateAll();
        requestRebind();
    }

    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            return onChangeFamilyNamePlate((IncludeFamilyNamePlateBinding) obj, i2);
        }
        return onChangeGameLevel((IncludeGameLevelBinding) obj, i2);
    }

    @Override // com.qiahao.nextvideo.databinding.DialogRoomUserInfoBinding
    public void setClick(View.OnClickListener onClickListener) {
        this.mClick = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.familyNamePlate.setLifecycleOwner(lifecycleOwner);
        this.gameLevel.setLifecycleOwner(lifecycleOwner);
    }

    public boolean setVariable(int i, Object obj) {
        if (2 == i) {
            setClick((View.OnClickListener) obj);
            return true;
        }
        return false;
    }

    private DialogRoomUserInfoBindingImpl(f fVar, View view, Object[] objArr) {
        super(fVar, view, 2, (HiloGradeView) objArr[50], (GenderAgeTextView) objArr[47], (LinearLayout) objArr[35], (ConstraintLayout) objArr[17], (View) objArr[55], (AppCompatImageView) objArr[1], (HiloGradeView) objArr[49], (View) objArr[18], (CountryIDView) objArr[40], (SVGAImageView) objArr[22], (TextView) objArr[42], (Group) objArr[34], (ImageView) objArr[33], (IncludeFamilyNamePlateBinding) objArr[14], (IncludeGameLevelBinding) objArr[15], (ImageView) objArr[26], (ImageView) objArr[31], (ImageView) objArr[51], (ImageView) objArr[12], (ImageView) objArr[54], (ImageView) objArr[11], (ImageView) objArr[9], (ImageView) objArr[13], (ImageView) objArr[10], (ImageView) objArr[44], (ImageView) objArr[41], (LinearLayout) objArr[8], (LinearLayout) objArr[4], (LinearLayout) objArr[5], (HiloMedalView) objArr[52], (LinearLayout) objArr[6], (LinearLayout) objArr[37], (LinearLayout) objArr[56], (LinearLayout) objArr[53], (LinearLayout) objArr[7], (AppCompatImageView) objArr[2], (ImageView) objArr[25], (ImageView) objArr[30], (SVGAImageView) objArr[24], (SVGAImageView) objArr[29], (ImageView) objArr[46], (ImageView) objArr[19], (SVGAImageView) objArr[21], (LightQueueCombinationPlayer) objArr[16], (AppCompatImageView) objArr[3], (ConstraintLayout) objArr[0], (ImageView) objArr[27], (ImageView) objArr[32], (ImageView) objArr[38], (View) objArr[39], (ImageView) objArr[20], (HiloImageView) objArr[23], (HiloImageView) objArr[28], (NickTextView) objArr[36], (TextView) objArr[45], (View) objArr[43], (HiloGradeView) objArr[48]);
        this.mDirtyFlags = -1L;
        this.callUser.setTag(null);
        setContainedBinding(this.familyNamePlate);
        setContainedBinding(this.gameLevel);
        this.imageInviteUserUpMic.setTag(null);
        this.imageUserDownMic.setTag(null);
        this.imageUserInfo.setTag(null);
        this.imageUserLeaveRoom.setTag(null);
        this.imageUserMuteOpenMic.setTag(null);
        this.llGift.setTag(null);
        this.llLevel.setTag(null);
        this.llLike.setTag(null);
        this.llMessage.setTag(null);
        this.llVideo.setTag(null);
        this.micMute.setTag(null);
        this.reportImageView.setTag(null);
        this.rootBg.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
