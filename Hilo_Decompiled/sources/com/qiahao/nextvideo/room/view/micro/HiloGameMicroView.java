package com.qiahao.nextvideo.room.view.micro;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemHiloGameMicroViewBinding;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/HiloGameMicroView;", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ItemHiloGameMicroViewBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ItemHiloGameMicroViewBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ItemHiloGameMicroViewBinding;)V", "initView", "", "updateView", "stopMicSVGA", "onDetachedFromWindow", "recoverMicSVGA", "showMicSpeakWaveAnim", "showFaceSvga", "faceSVGAUrl", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloGameMicroView extends BaseItemMicroView {

    @NotNull
    private static final String TAG = "HiloGameMicroView";
    public ItemHiloGameMicroViewBinding mDataBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HiloGameMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$0(HiloGameMicroView hiloGameMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = hiloGameMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(hiloGameMicroView.getMPosition(), hiloGameMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$1(HiloGameMicroView hiloGameMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = hiloGameMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(hiloGameMicroView.getMPosition(), hiloGameMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$2(HiloGameMicroView hiloGameMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = hiloGameMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnLockMic(hiloGameMicroView.getMPosition(), hiloGameMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$3(HiloGameMicroView hiloGameMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = hiloGameMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnMuteAvatarClick(hiloGameMicroView.getMPosition(), hiloGameMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$4(HiloGameMicroView hiloGameMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = hiloGameMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onAvatarBtnClick(hiloGameMicroView.getMPosition(), hiloGameMicroView.getMMicBean());
        }
    }

    @NotNull
    public final ItemHiloGameMicroViewBinding getMDataBinding() {
        ItemHiloGameMicroViewBinding itemHiloGameMicroViewBinding = this.mDataBinding;
        if (itemHiloGameMicroViewBinding != null) {
            return itemHiloGameMicroViewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void initView() {
        setMDataBinding((ItemHiloGameMicroViewBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.item_hilo_game_micro_view, this, true));
        setClipChildren(false);
        setClipToPadding(false);
        getMDataBinding().userTagLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33000000", "#33000000", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMDataBinding().faceSvga.clear();
        getMDataBinding().unbind();
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void recoverMicSVGA() {
    }

    public final void setMDataBinding(@NotNull ItemHiloGameMicroViewBinding itemHiloGameMicroViewBinding) {
        Intrinsics.checkNotNullParameter(itemHiloGameMicroViewBinding, "<set-?>");
        this.mDataBinding = itemHiloGameMicroViewBinding;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void showFaceSvga(@NotNull String faceSVGAUrl) {
        Intrinsics.checkNotNullParameter(faceSVGAUrl, "faceSVGAUrl");
        if (TextUtils.isEmpty(faceSVGAUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(faceSVGAUrl + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.HiloGameMicroView$showFaceSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    HiloGameMicroView.this.getMDataBinding().faceSvga.setVideoItem(videoItem);
                    HiloGameMicroView.this.getMDataBinding().faceSvga.startAnimation();
                }

                public void onError() {
                    Log.d("HiloGameMicroView", "onError: ----------");
                }
            });
        } catch (Exception e) {
            DebugToolsKt.printfE(TAG, "eventRelay 内部try()catch{}" + e.getLocalizedMessage());
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void showMicSpeakWaveAnim() {
        String str;
        int i;
        int i2;
        MicroUserBean user;
        MicroUserBean user2;
        MicroUserBean user3;
        MicroBean mMicBean = getMMicBean();
        if (mMicBean == null || !mMicBean.getMicForbid()) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            MicroBean mMicBean2 = getMMicBean();
            if (mMicBean2 == null || (user3 = mMicBean2.getUser()) == null || (str = user3.getExternalId()) == null) {
                str = "";
            }
            if (meetingRoomManager.haveLocalMute(str)) {
                return;
            }
            MicroBean mMicBean3 = getMMicBean();
            if (mMicBean3 != null && (user2 = mMicBean3.getUser()) != null) {
                i = user2.getNoble();
            } else {
                i = 0;
            }
            if (i > 0) {
                PortraitAnimationView portraitAnimationView = getMDataBinding().speakWave;
                UserService.Companion companion = UserService.INSTANCE;
                MicroBean mMicBean4 = getMMicBean();
                if (mMicBean4 != null && (user = mMicBean4.getUser()) != null) {
                    i2 = user.getNoble();
                } else {
                    i2 = 0;
                }
                portraitAnimationView.setColor(UserService.Companion.getNobleColor$default(companion, i2, 0, 2, null));
            } else {
                getMDataBinding().speakWave.setColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            }
            getMDataBinding().speakWave.e();
        }
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void stopMicSVGA() {
        getMDataBinding().faceSvga.stopAnimation(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03ca  */
    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateView() {
        int i;
        Integer num;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        MicroUserBean microUserBean;
        boolean z4;
        MicroBean mMicBean;
        String str;
        MeetingRoomManager meetingRoomManager;
        MicroBean mMicBean2;
        int roomUserRole;
        MicroBean mMicBean3;
        String str2;
        MicroBean mMicBean4;
        MicroUserBean user;
        SvipData svip;
        MicroUserBean user2;
        MicroUserBean user3;
        MicroUserBean user4;
        String str3;
        String str4;
        MicroUserBean user5;
        MicroUserBean user6;
        Boolean music;
        MicroUserBean user7;
        MicroBean mMicBean5 = getMMicBean();
        if (mMicBean5 != null) {
            i = mMicBean5.getI();
        } else {
            i = 0;
        }
        setMPosition(i);
        ImageView imageView = getMDataBinding().emptyMicImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "emptyMicImage");
        SVGAImageView sVGAImageView = getMDataBinding().emptyMicSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "emptyMicSVGA");
        refreshEmptyMic(imageView, sVGAImageView);
        MicroBean mMicBean6 = getMMicBean();
        String str5 = null;
        if (mMicBean6 != null && (user7 = mMicBean6.getUser()) != null) {
            num = Integer.valueOf(user7.getNoble());
        } else {
            num = null;
        }
        SVGAImageView sVGAImageView2 = getMDataBinding().musicSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "musicSvga");
        MicroBean mMicBean7 = getMMicBean();
        if (mMicBean7 != null && (user6 = mMicBean7.getUser()) != null && (music = user6.getMusic()) != null) {
            z = music.booleanValue();
        } else {
            z = false;
        }
        MicroBean mMicBean8 = getMMicBean();
        if (mMicBean8 != null) {
            z2 = mMicBean8.getMicForbid();
        } else {
            z2 = false;
        }
        refreshMusicSvga(num, sVGAImageView2, z, z2);
        MicroBean mMicBean9 = getMMicBean();
        if (mMicBean9 != null && (user5 = mMicBean9.getUser()) != null) {
            i2 = user5.getNoble();
        } else {
            i2 = 0;
        }
        if (i2 >= 8) {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute_8));
        } else {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute));
        }
        Integer svipLevel = getSvipLevel();
        if (svipLevel != null) {
            i3 = svipLevel.intValue();
        } else {
            i3 = 0;
        }
        if (i3 >= 4) {
            getMDataBinding().lockMicro.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_lock_gold));
        } else {
            getMDataBinding().lockMicro.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_lock));
        }
        if (getMMicBean() == null) {
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().position.setVisibility(0);
            getMDataBinding().userTag.setVisibility(8);
            getMDataBinding().position.setText(String.valueOf(getMPosition()));
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().baseMicro.setVisibility(0);
            getMDataBinding().speakWave.setVisibility(8);
            getMDataBinding().micUserHeadImg.setVisibility(8);
            getMDataBinding().personMicOff.setVisibility(8);
            getMDataBinding().micOff.setVisibility(8);
            getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloGameMicroView.updateView$lambda$0(HiloGameMicroView.this, view);
                }
            });
            return;
        }
        getMDataBinding().lockMicro.setVisibility(8);
        getMDataBinding().userTag.setVisibility(8);
        getMDataBinding().position.setVisibility(0);
        getMDataBinding().position.setText(String.valueOf(getMPosition()));
        getMDataBinding().userAvatar.setVisibility(8);
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().baseMicro.setVisibility(0);
        getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HiloGameMicroView.updateView$lambda$1(HiloGameMicroView.this, view);
            }
        });
        getMDataBinding().micUserHeadImg.setVisibility(8);
        MicroBean mMicBean10 = getMMicBean();
        boolean z5 = true;
        if (mMicBean10 != null && mMicBean10.getLock()) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            getMDataBinding().baseMicro.setVisibility(8);
            getMDataBinding().lockMicro.setVisibility(0);
            getMDataBinding().lockMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloGameMicroView.updateView$lambda$2(HiloGameMicroView.this, view);
                }
            });
            getMDataBinding().userTag.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().speakWave.setVisibility(8);
        } else {
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userTag.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().speakWave.setVisibility(8);
        }
        MicroBean mMicBean11 = getMMicBean();
        if (mMicBean11 != null) {
            microUserBean = mMicBean11.getUser();
        } else {
            microUserBean = null;
        }
        if (microUserBean != null) {
            getMDataBinding().baseMicro.setVisibility(8);
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(0);
            MicroBean mMicBean12 = getMMicBean();
            if (mMicBean12 != null) {
                z4 = Intrinsics.areEqual(mMicBean12.getForbid(), Boolean.TRUE);
            } else {
                z4 = false;
            }
            if (z4) {
                MicroBean mMicBean13 = getMMicBean();
                if (mMicBean13 != null) {
                    str3 = mMicBean13.getExternalId();
                } else {
                    str3 = null;
                }
                User user8 = UserStore.INSTANCE.getShared().getUser();
                if (user8 != null) {
                    str4 = user8.getExternalId();
                } else {
                    str4 = null;
                }
                if (Intrinsics.areEqual(str3, str4)) {
                    getMDataBinding().userMute.setVisibility(0);
                    getMDataBinding().userMute.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.o
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HiloGameMicroView.updateView$lambda$3(HiloGameMicroView.this, view);
                        }
                    });
                    AppCompatImageView appCompatImageView = getMDataBinding().userAvatar;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
                    mMicBean = getMMicBean();
                    if (mMicBean == null && (user4 = mMicBean.getUser()) != null) {
                        str = user4.getAvatar();
                    } else {
                        str = null;
                    }
                    ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
                    getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.p
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HiloGameMicroView.updateView$lambda$4(HiloGameMicroView.this, view);
                        }
                    });
                    meetingRoomManager = MeetingRoomManager.INSTANCE;
                    mMicBean2 = getMMicBean();
                    if (mMicBean2 != null && (user3 = mMicBean2.getUser()) != null) {
                        str5 = user3.getExternalId();
                    }
                    roomUserRole = meetingRoomManager.getRoomUserRole(str5);
                    if (roomUserRole <= 1) {
                        getMDataBinding().userTag.setVisibility(0);
                        getMDataBinding().position.setVisibility(8);
                        getMDataBinding().userTag.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), meetingRoomManager.getGameLevelRes(roomUserRole)));
                    } else {
                        getMDataBinding().userTag.setVisibility(8);
                        getMDataBinding().position.setVisibility(0);
                    }
                    mMicBean3 = getMMicBean();
                    if (mMicBean3 != null || (user2 = mMicBean3.getUser()) == null || (str2 = user2.getExternalId()) == null) {
                        str2 = "";
                    }
                    if (!meetingRoomManager.haveLocalMute(str2)) {
                        getMDataBinding().personMicOff.setVisibility(0);
                    } else {
                        getMDataBinding().personMicOff.setVisibility(8);
                    }
                    mMicBean4 = getMMicBean();
                    if (mMicBean4 != null && (user = mMicBean4.getUser()) != null && (svip = user.getSvip()) != null && svip.isMystery()) {
                        AppCompatImageView appCompatImageView2 = getMDataBinding().userAvatar;
                        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatar");
                        ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        getMDataBinding().micUserHeadImg.setVisibility(8);
                        getMDataBinding().userTag.setVisibility(8);
                        getMDataBinding().position.setVisibility(0);
                    }
                }
            }
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().userMute.setOnClickListener(null);
            AppCompatImageView appCompatImageView3 = getMDataBinding().userAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "userAvatar");
            mMicBean = getMMicBean();
            if (mMicBean == null) {
            }
            str = null;
            ImageKtxKt.loadImage$default(appCompatImageView3, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
            getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HiloGameMicroView.updateView$lambda$4(HiloGameMicroView.this, view);
                }
            });
            meetingRoomManager = MeetingRoomManager.INSTANCE;
            mMicBean2 = getMMicBean();
            if (mMicBean2 != null) {
                str5 = user3.getExternalId();
            }
            roomUserRole = meetingRoomManager.getRoomUserRole(str5);
            if (roomUserRole <= 1) {
            }
            mMicBean3 = getMMicBean();
            if (mMicBean3 != null) {
            }
            str2 = "";
            if (!meetingRoomManager.haveLocalMute(str2)) {
            }
            mMicBean4 = getMMicBean();
            if (mMicBean4 != null) {
                AppCompatImageView appCompatImageView22 = getMDataBinding().userAvatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView22, "userAvatar");
                ImageKtxKt.loadImage$default(appCompatImageView22, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                getMDataBinding().micUserHeadImg.setVisibility(8);
                getMDataBinding().userTag.setVisibility(8);
                getMDataBinding().position.setVisibility(0);
            }
        } else {
            getMDataBinding().speakWave.setVisibility(8);
            if (getMDataBinding().speakWave.d()) {
                getMDataBinding().speakWave.a();
            }
            getMDataBinding().userMute.setOnClickListener(null);
            getMDataBinding().userAvatar.setOnClickListener(null);
            getMDataBinding().personMicOff.setVisibility(8);
        }
        MicroBean mMicBean14 = getMMicBean();
        if (mMicBean14 == null || !mMicBean14.getMicForbid()) {
            z5 = false;
        }
        if (z5) {
            getMDataBinding().micOff.setVisibility(0);
        } else {
            getMDataBinding().micOff.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiloGameMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
