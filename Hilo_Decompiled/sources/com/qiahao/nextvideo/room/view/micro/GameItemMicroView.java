package com.qiahao.nextvideo.room.view.micro;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemMicroGameViewBinding;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/GameItemMicroView;", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ItemMicroGameViewBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ItemMicroGameViewBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ItemMicroGameViewBinding;)V", "initView", "", "updateView", "stopMicSVGA", "recoverMicSVGA", "playSvga", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "playCpSvga", "showMicSpeakWaveAnim", "showFaceSvga", "faceSVGAUrl", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameItemMicroView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/GameItemMicroView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,361:1\n255#2:362\n*S KotlinDebug\n*F\n+ 1 GameItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/GameItemMicroView\n*L\n100#1:362\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameItemMicroView extends BaseItemMicroView {

    @NotNull
    private static final String TAG = "GameItemMicroView";
    public ItemMicroGameViewBinding mDataBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GameItemMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void playCpSvga(final MicroBean micBean) {
        String str;
        if (MeetingRoomManager.INSTANCE.checkGameMadel()) {
            return;
        }
        MicroUserBean user = micBean.getUser();
        String str2 = null;
        if (user != null) {
            str = user.getMicEffect();
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SVGAParser shareParser = SVGAParser.Companion.shareParser();
            MicroUserBean user2 = micBean.getUser();
            if (user2 != null) {
                str2 = user2.getMicEffect();
            }
            shareParser.decodeFromURL(new URL(str2 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.GameItemMicroView$playCpSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String str3;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    GameItemMicroView.this.getMDataBinding().cpSvga.setVisibility(0);
                    SVGAImageView sVGAImageView = GameItemMicroView.this.getMDataBinding().cpSvga;
                    MicroUserBean user3 = micBean.getUser();
                    if (user3 != null) {
                        str3 = user3.getMicEffect();
                    } else {
                        str3 = null;
                    }
                    sVGAImageView.setTag(str3);
                    GameItemMicroView.this.getMDataBinding().cpSvga.stopAnimation(true);
                    GameItemMicroView.this.getMDataBinding().cpSvga.setImageDrawable(new SVGADrawable(videoItem));
                    GameItemMicroView.this.getMDataBinding().cpSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception unused) {
            getMDataBinding().cpSvga.setVisibility(8);
            getMDataBinding().cpSvga.setTag("");
        }
    }

    private final void playSvga(final MicroBean micBean) {
        if (MeetingRoomManager.INSTANCE.checkGameMadel() || TextUtils.isEmpty(micBean.getEffectUrl())) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(micBean.getEffectUrl() + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.GameItemMicroView$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String headwearIcon;
                    String str;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    GameItemMicroView.this.getMDataBinding().micUserHeadSvga.setTag(micBean.getEffectUrl());
                    SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                    MicroUserBean user = micBean.getUser();
                    if (user != null && (headwearIcon = user.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                        MicroUserBean user2 = micBean.getUser();
                        if (user2 == null || (str = user2.getHeadwearIcon()) == null) {
                            str = "";
                        }
                        DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str, null, 2, null);
                    }
                    GameItemMicroView.this.getMDataBinding().micUserHeadSvga.stopAnimation(true);
                    GameItemMicroView.this.getMDataBinding().micUserHeadSvga.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                    GameItemMicroView.this.getMDataBinding().micUserHeadSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            getMDataBinding().micUserHeadSvga.setTag("");
            DebugToolsKt.printfE(TAG, " 麦位头饰svga头饰加错出错 内部try()catch{}" + e.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$0(GameItemMicroView gameItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = gameItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(gameItemMicroView.getMPosition(), gameItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$1(GameItemMicroView gameItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = gameItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(gameItemMicroView.getMPosition(), gameItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$2(GameItemMicroView gameItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = gameItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnLockMic(gameItemMicroView.getMPosition(), gameItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$4(GameItemMicroView gameItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = gameItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnMuteAvatarClick(gameItemMicroView.getMPosition(), gameItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$5(GameItemMicroView gameItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = gameItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onAvatarBtnClick(gameItemMicroView.getMPosition(), gameItemMicroView.getMMicBean());
        }
    }

    @NotNull
    public final ItemMicroGameViewBinding getMDataBinding() {
        ItemMicroGameViewBinding itemMicroGameViewBinding = this.mDataBinding;
        if (itemMicroGameViewBinding != null) {
            return itemMicroGameViewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void initView() {
        setClipChildren(false);
        setClipToPadding(false);
        setMDataBinding((ItemMicroGameViewBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.item_micro_game_view, this, true));
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void recoverMicSVGA() {
        MicroBean mMicBean = getMMicBean();
        if (mMicBean != null) {
            playSvga(mMicBean);
        }
    }

    public final void setMDataBinding(@NotNull ItemMicroGameViewBinding itemMicroGameViewBinding) {
        Intrinsics.checkNotNullParameter(itemMicroGameViewBinding, "<set-?>");
        this.mDataBinding = itemMicroGameViewBinding;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void showFaceSvga(@NotNull String faceSVGAUrl) {
        Intrinsics.checkNotNullParameter(faceSVGAUrl, "faceSVGAUrl");
        if (MeetingRoomManager.INSTANCE.checkGameMadel() || TextUtils.isEmpty(faceSVGAUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(faceSVGAUrl + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.GameItemMicroView$showFaceSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    GameItemMicroView.this.getMDataBinding().faceSvga.setVideoItem(videoItem);
                    GameItemMicroView.this.getMDataBinding().faceSvga.startAnimation();
                }

                public void onError() {
                    Log.d("GameItemMicroView", "onError: ----------");
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
            if (!meetingRoomManager.haveLocalMute(str) && !meetingRoomManager.checkGameMadel()) {
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
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void stopMicSVGA() {
        getMDataBinding().micUserHeadSvga.stopAnimation();
        getMDataBinding().cpSvga.stopAnimation();
        getMDataBinding().faceSvga.stopAnimation(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x043e  */
    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateView() {
        Integer num;
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        MicroUserBean microUserBean;
        boolean z5;
        int i2;
        int i3;
        boolean z6;
        MicroBean mMicBean;
        String str;
        MicroBean mMicBean2;
        String str2;
        boolean z7;
        String str3;
        String str4;
        boolean z8;
        String str5;
        MicroUserBean user;
        MicroUserBean user2;
        MicroBean mMicBean3;
        boolean z9;
        MeetingRoomManager meetingRoomManager;
        MicroBean mMicBean4;
        MicroBean mMicBean5;
        MicroUserBean user3;
        SvipData svip;
        MicroUserBean user4;
        String externalId;
        MicroUserBean user5;
        String str6;
        MicroUserBean user6;
        String str7;
        String str8;
        Integer num2;
        MicroUserBean user7;
        SvipData svip2;
        MicroUserBean user8;
        SvipData svip3;
        int i4;
        MicroUserBean user9;
        MicroUserBean user10;
        MicroUserBean user11;
        MicroUserBean user12;
        MicroUserBean user13;
        Boolean music;
        MicroUserBean user14;
        ImageView imageView = getMDataBinding().emptyMicImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "emptyMicImage");
        SVGAImageView sVGAImageView = getMDataBinding().emptyMicSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "emptyMicSVGA");
        refreshEmptyMic(imageView, sVGAImageView);
        MicroBean mMicBean6 = getMMicBean();
        String str9 = null;
        if (mMicBean6 != null && (user14 = mMicBean6.getUser()) != null) {
            num = Integer.valueOf(user14.getNoble());
        } else {
            num = null;
        }
        SVGAImageView sVGAImageView2 = getMDataBinding().musicSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "musicSvga");
        MicroBean mMicBean7 = getMMicBean();
        if (mMicBean7 != null && (user13 = mMicBean7.getUser()) != null && (music = user13.getMusic()) != null) {
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
        if (mMicBean9 != null && (user12 = mMicBean9.getUser()) != null) {
            i = user12.getNoble();
        } else {
            i = 0;
        }
        if (i >= 8) {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute_8));
        } else {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute));
        }
        if (getMMicBean() == null) {
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(8);
            getMDataBinding().baseMicro.setVisibility(0);
            getMDataBinding().speakWave.setVisibility(8);
            getMDataBinding().micUserHeadSvga.setVisibility(8);
            getMDataBinding().cpSvga.setVisibility(8);
            getMDataBinding().micUserHeadImg.setVisibility(8);
            getMDataBinding().personMicOff.setVisibility(8);
            getMDataBinding().micOff.setVisibility(8);
            getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameItemMicroView.updateView$lambda$0(GameItemMicroView.this, view);
                }
            });
            return;
        }
        getMDataBinding().lockMicro.setVisibility(8);
        getMDataBinding().userVip.setVisibility(8);
        getMDataBinding().iconNoble.setVisibility(8);
        getMDataBinding().userAvatar.setVisibility(8);
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().baseMicro.setVisibility(0);
        getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameItemMicroView.updateView$lambda$1(GameItemMicroView.this, view);
            }
        });
        SVGAImageView sVGAImageView3 = getMDataBinding().micUserHeadSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView3, "micUserHeadSvga");
        boolean z10 = true;
        if (sVGAImageView3.getVisibility() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            getMDataBinding().micUserHeadSvga.setVisibility(8);
        }
        getMDataBinding().micUserHeadImg.setVisibility(8);
        MicroBean mMicBean10 = getMMicBean();
        if (mMicBean10 != null && mMicBean10.getLock()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            getMDataBinding().baseMicro.setVisibility(8);
            getMDataBinding().lockMicro.setVisibility(0);
            getMDataBinding().lockMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameItemMicroView.updateView$lambda$2(GameItemMicroView.this, view);
                }
            });
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(8);
            getMDataBinding().iconSvip.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().speakWave.setVisibility(8);
        } else {
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(8);
            getMDataBinding().iconSvip.setVisibility(8);
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
            if (mMicBean12 != null && (user11 = mMicBean12.getUser()) != null && user11.isVip()) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                getMDataBinding().userVip.setVisibility(0);
            }
            MicroBean mMicBean13 = getMMicBean();
            if (mMicBean13 != null && (user10 = mMicBean13.getUser()) != null) {
                i2 = user10.getNoble();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                getMDataBinding().userVip.setVisibility(8);
                getMDataBinding().iconNoble.setVisibility(0);
                ImageView imageView2 = getMDataBinding().iconNoble;
                Context context = getMDataBinding().getRoot().getContext();
                UserService.Companion companion = UserService.INSTANCE;
                MicroBean mMicBean14 = getMMicBean();
                if (mMicBean14 != null && (user9 = mMicBean14.getUser()) != null) {
                    i4 = user9.getNoble();
                } else {
                    i4 = 0;
                }
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i4)));
            } else {
                getMDataBinding().iconNoble.setVisibility(8);
            }
            MicroBean mMicBean15 = getMMicBean();
            if (mMicBean15 != null && (user8 = mMicBean15.getUser()) != null && (svip3 = user8.getSvip()) != null) {
                i3 = svip3.getSvipLevel();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                getMDataBinding().userVip.setVisibility(8);
                getMDataBinding().iconNoble.setVisibility(8);
                getMDataBinding().iconSvip.setVisibility(0);
                SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                MicroBean mMicBean16 = getMMicBean();
                if (mMicBean16 != null && (user7 = mMicBean16.getUser()) != null && (svip2 = user7.getSvip()) != null) {
                    num2 = Integer.valueOf(svip2.getSvipLevel());
                } else {
                    num2 = null;
                }
                Integer svipMedal = svipTypeUtils.getSvipMedal(num2);
                if (svipMedal != null) {
                    getMDataBinding().iconSvip.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), svipMedal.intValue()));
                }
            } else {
                getMDataBinding().iconSvip.setVisibility(8);
            }
            MicroBean mMicBean17 = getMMicBean();
            if (mMicBean17 != null) {
                z6 = Intrinsics.areEqual(mMicBean17.getForbid(), Boolean.TRUE);
            } else {
                z6 = false;
            }
            if (z6) {
                MicroBean mMicBean18 = getMMicBean();
                if (mMicBean18 != null) {
                    str7 = mMicBean18.getExternalId();
                } else {
                    str7 = null;
                }
                User user15 = UserStore.INSTANCE.getShared().getUser();
                if (user15 != null) {
                    str8 = user15.getExternalId();
                } else {
                    str8 = null;
                }
                if (Intrinsics.areEqual(str7, str8)) {
                    getMDataBinding().userMute.setVisibility(0);
                    getMDataBinding().userMute.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GameItemMicroView.updateView$lambda$4(GameItemMicroView.this, view);
                        }
                    });
                    AppCompatImageView appCompatImageView = getMDataBinding().userAvatar;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
                    mMicBean = getMMicBean();
                    if (mMicBean == null && (user6 = mMicBean.getUser()) != null) {
                        str = user6.getAvatar();
                    } else {
                        str = null;
                    }
                    ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
                    getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            GameItemMicroView.updateView$lambda$5(GameItemMicroView.this, view);
                        }
                    });
                    mMicBean2 = getMMicBean();
                    if (mMicBean2 == null) {
                        str2 = mMicBean2.getEffectUrl();
                    } else {
                        str2 = null;
                    }
                    if (str2 == null && str2.length() != 0) {
                        z7 = false;
                    } else {
                        z7 = true;
                    }
                    str3 = "";
                    if (z7) {
                        String obj = getMDataBinding().micUserHeadSvga.getTag().toString();
                        MicroBean mMicBean19 = getMMicBean();
                        if (mMicBean19 != null) {
                            str6 = mMicBean19.getEffectUrl();
                        } else {
                            str6 = null;
                        }
                        if (Intrinsics.areEqual(obj, str6)) {
                            getMDataBinding().micUserHeadSvga.stopAnimation(true);
                            getMDataBinding().micUserHeadSvga.setVisibility(0);
                            getMDataBinding().micUserHeadImg.setVisibility(8);
                            MicroBean mMicBean20 = getMMicBean();
                            if (mMicBean20 != null) {
                                playSvga(mMicBean20);
                            }
                        } else {
                            getMDataBinding().micUserHeadSvga.setVisibility(0);
                            getMDataBinding().micUserHeadImg.setVisibility(8);
                            getMDataBinding().micUserHeadSvga.stopAnimation(true);
                            MicroBean mMicBean21 = getMMicBean();
                            if (mMicBean21 != null) {
                                playSvga(mMicBean21);
                            }
                        }
                    } else {
                        getMDataBinding().micUserHeadSvga.setVisibility(8);
                        getMDataBinding().micUserHeadSvga.setTag("");
                        MicroBean mMicBean22 = getMMicBean();
                        if (mMicBean22 != null && (user2 = mMicBean22.getUser()) != null) {
                            str4 = user2.getHeadwearPicUrl();
                        } else {
                            str4 = null;
                        }
                        if (str4 != null && str4.length() != 0) {
                            z8 = false;
                        } else {
                            z8 = true;
                        }
                        if (!z8) {
                            getMDataBinding().micUserHeadImg.setVisibility(0);
                            ImageView imageView3 = getMDataBinding().micUserHeadImg;
                            Intrinsics.checkNotNullExpressionValue(imageView3, "micUserHeadImg");
                            MicroBean mMicBean23 = getMMicBean();
                            if (mMicBean23 != null && (user = mMicBean23.getUser()) != null) {
                                str5 = user.getHeadwearPicUrl();
                            } else {
                                str5 = null;
                            }
                            ViewUtilitiesKt.bind(imageView3, new ImageUIModel(str5, null, null, null, 0, 0, null, 126, null));
                        } else {
                            getMDataBinding().micUserHeadImg.setVisibility(8);
                        }
                    }
                    mMicBean3 = getMMicBean();
                    if (mMicBean3 != null && (user5 = mMicBean3.getUser()) != null) {
                        str9 = user5.getMicEffect();
                    }
                    if (str9 == null && str9.length() != 0) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    if (z9) {
                        getMDataBinding().cpSvga.setVisibility(0);
                        MicroBean mMicBean24 = getMMicBean();
                        if (mMicBean24 != null) {
                            playCpSvga(mMicBean24);
                        }
                    } else {
                        getMDataBinding().cpSvga.setVisibility(8);
                    }
                    meetingRoomManager = MeetingRoomManager.INSTANCE;
                    mMicBean4 = getMMicBean();
                    if (mMicBean4 != null && (user4 = mMicBean4.getUser()) != null && (externalId = user4.getExternalId()) != null) {
                        str3 = externalId;
                    }
                    if (!meetingRoomManager.haveLocalMute(str3)) {
                        getMDataBinding().personMicOff.setVisibility(0);
                    } else {
                        getMDataBinding().personMicOff.setVisibility(8);
                    }
                    mMicBean5 = getMMicBean();
                    if (mMicBean5 != null && (user3 = mMicBean5.getUser()) != null && (svip = user3.getSvip()) != null && svip.isMystery()) {
                        AppCompatImageView appCompatImageView2 = getMDataBinding().userAvatar;
                        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatar");
                        ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        getMDataBinding().micUserHeadSvga.setVisibility(8);
                        getMDataBinding().micUserHeadImg.setVisibility(8);
                        getMDataBinding().iconSvip.setVisibility(8);
                        getMDataBinding().userVip.setVisibility(8);
                        getMDataBinding().iconNoble.setVisibility(8);
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
            getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GameItemMicroView.updateView$lambda$5(GameItemMicroView.this, view);
                }
            });
            mMicBean2 = getMMicBean();
            if (mMicBean2 == null) {
            }
            if (str2 == null) {
            }
            z7 = true;
            str3 = "";
            if (z7) {
            }
            mMicBean3 = getMMicBean();
            if (mMicBean3 != null) {
                str9 = user5.getMicEffect();
            }
            if (str9 == null) {
            }
            z9 = true;
            if (z9) {
            }
            meetingRoomManager = MeetingRoomManager.INSTANCE;
            mMicBean4 = getMMicBean();
            if (mMicBean4 != null) {
                str3 = externalId;
            }
            if (!meetingRoomManager.haveLocalMute(str3)) {
            }
            mMicBean5 = getMMicBean();
            if (mMicBean5 != null) {
                AppCompatImageView appCompatImageView22 = getMDataBinding().userAvatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView22, "userAvatar");
                ImageKtxKt.loadImage$default(appCompatImageView22, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                getMDataBinding().micUserHeadSvga.setVisibility(8);
                getMDataBinding().micUserHeadImg.setVisibility(8);
                getMDataBinding().iconSvip.setVisibility(8);
                getMDataBinding().userVip.setVisibility(8);
                getMDataBinding().iconNoble.setVisibility(8);
            }
        } else {
            getMDataBinding().speakWave.setVisibility(8);
            getMDataBinding().micUserHeadSvga.setVisibility(8);
            getMDataBinding().cpSvga.setVisibility(8);
            if (getMDataBinding().speakWave.d()) {
                getMDataBinding().speakWave.a();
            }
            getMDataBinding().userMute.setOnClickListener(null);
            getMDataBinding().userAvatar.setOnClickListener(null);
            getMDataBinding().personMicOff.setVisibility(8);
        }
        MicroBean mMicBean25 = getMMicBean();
        if (mMicBean25 == null || !mMicBean25.getMicForbid()) {
            z10 = false;
        }
        if (z10) {
            getMDataBinding().micOff.setVisibility(0);
        } else {
            getMDataBinding().micOff.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameItemMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
