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
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemBigMicroViewBinding;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/BigItemMicroView;", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ItemBigMicroViewBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ItemBigMicroViewBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ItemBigMicroViewBinding;)V", "initView", "", "updateView", "stopMicSVGA", "recoverMicSVGA", "playSvga", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "playCpSvga", "showMicSpeakWaveAnim", "showFaceSvga", "faceSVGAUrl", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBigItemMicroView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BigItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/BigItemMicroView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,413:1\n255#2:414\n*S KotlinDebug\n*F\n+ 1 BigItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/BigItemMicroView\n*L\n118#1:414\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BigItemMicroView extends BaseItemMicroView {

    @NotNull
    private static final String TAG = "BigItemMicroView";
    public ItemBigMicroViewBinding mDataBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BigItemMicroView(@NotNull Context context) {
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
            shareParser.decodeFromURL(new URL(str2 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.BigItemMicroView$playCpSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String str3;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    SVGAImageView sVGAImageView = BigItemMicroView.this.getMDataBinding().cpSvga;
                    MicroUserBean user3 = micBean.getUser();
                    if (user3 != null) {
                        str3 = user3.getMicEffect();
                    } else {
                        str3 = null;
                    }
                    sVGAImageView.setTag(str3);
                    BigItemMicroView.this.getMDataBinding().cpSvga.stopAnimation(true);
                    BigItemMicroView.this.getMDataBinding().cpSvga.setImageDrawable(new SVGADrawable(videoItem));
                    BigItemMicroView.this.getMDataBinding().cpSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception unused) {
            getMDataBinding().cpSvga.setTag("");
        }
    }

    private final void playSvga(final MicroBean micBean) {
        if (MeetingRoomManager.INSTANCE.checkGameMadel() || TextUtils.isEmpty(micBean.getEffectUrl())) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(micBean.getEffectUrl() + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.BigItemMicroView$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String headwearIcon;
                    String str;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    BigItemMicroView.this.getMDataBinding().micUserHeadSvga.setTag(micBean.getEffectUrl());
                    SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                    MicroUserBean user = micBean.getUser();
                    if (user != null && (headwearIcon = user.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                        MicroUserBean user2 = micBean.getUser();
                        if (user2 == null || (str = user2.getHeadwearIcon()) == null) {
                            str = "";
                        }
                        DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str, null, 2, null);
                    }
                    BigItemMicroView.this.getMDataBinding().micUserHeadSvga.stopAnimation(true);
                    BigItemMicroView.this.getMDataBinding().micUserHeadSvga.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                    BigItemMicroView.this.getMDataBinding().micUserHeadSvga.startAnimation();
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
    public static final void updateView$lambda$0(BigItemMicroView bigItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = bigItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(bigItemMicroView.getMPosition(), bigItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$1(BigItemMicroView bigItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = bigItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(bigItemMicroView.getMPosition(), bigItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$10$lambda$9(BigItemMicroView bigItemMicroView, SvipData svipData) {
        NickTextView nickTextView = bigItemMicroView.getMDataBinding().userName;
        String format = String.format(ResourcesKtxKt.getStringById(bigItemMicroView, 2131953504), Arrays.copyOf(new Object[]{svipData.mysteryNumber()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        nickTextView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$2(BigItemMicroView bigItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = bigItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnLockMic(bigItemMicroView.getMPosition(), bigItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$4(BigItemMicroView bigItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = bigItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnMuteAvatarClick(bigItemMicroView.getMPosition(), bigItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$5(BigItemMicroView bigItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = bigItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onAvatarBtnClick(bigItemMicroView.getMPosition(), bigItemMicroView.getMMicBean());
        }
    }

    @NotNull
    public final ItemBigMicroViewBinding getMDataBinding() {
        ItemBigMicroViewBinding itemBigMicroViewBinding = this.mDataBinding;
        if (itemBigMicroViewBinding != null) {
            return itemBigMicroViewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void initView() {
        setMDataBinding((ItemBigMicroViewBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.item_big_micro_view, this, true));
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void recoverMicSVGA() {
        MicroBean mMicBean = getMMicBean();
        if (mMicBean != null) {
            playSvga(mMicBean);
        }
    }

    public final void setMDataBinding(@NotNull ItemBigMicroViewBinding itemBigMicroViewBinding) {
        Intrinsics.checkNotNullParameter(itemBigMicroViewBinding, "<set-?>");
        this.mDataBinding = itemBigMicroViewBinding;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void showFaceSvga(@NotNull String faceSVGAUrl) {
        Intrinsics.checkNotNullParameter(faceSVGAUrl, "faceSVGAUrl");
        if (MeetingRoomManager.INSTANCE.checkGameMadel() || TextUtils.isEmpty(faceSVGAUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(faceSVGAUrl + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.BigItemMicroView$showFaceSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    BigItemMicroView.this.getMDataBinding().faceSvga.setVideoItem(videoItem);
                    BigItemMicroView.this.getMDataBinding().faceSvga.startAnimation();
                }

                public void onError() {
                    Log.d("BigItemMicroView", "onError: ----------");
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

    /* JADX WARN: Removed duplicated region for block: B:133:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0588  */
    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateView() {
        MeetingRoomManager meetingRoomManager;
        int roomUserRole;
        String effectUrl;
        String str;
        MicroUserBean user;
        MicroUserBean user2;
        MicroBean mMicBean;
        MicroBean mMicBean2;
        MicroBean mMicBean3;
        MicroUserBean user3;
        final SvipData svip;
        MicroUserBean user4;
        String externalId;
        MicroUserBean user5;
        MicroUserBean user6;
        MicroUserBean user7;
        MicroUserBean user8;
        SvipData svip2;
        MicroUserBean user9;
        SvipData svip3;
        MicroUserBean user10;
        MicroUserBean user11;
        MicroUserBean user12;
        MicroUserBean user13;
        MicroUserBean user14;
        SvipData svip4;
        MicroUserBean user15;
        String nick;
        MicroUserBean user16;
        MicroUserBean user17;
        MicroUserBean user18;
        Boolean music;
        MicroUserBean user19;
        ImageView imageView = getMDataBinding().emptyMicImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "emptyMicImage");
        SVGAImageView sVGAImageView = getMDataBinding().emptyMicSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "emptyMicSVGA");
        refreshEmptyMic(imageView, sVGAImageView);
        MicroBean mMicBean4 = getMMicBean();
        String str2 = null;
        Integer valueOf = (mMicBean4 == null || (user19 = mMicBean4.getUser()) == null) ? null : Integer.valueOf(user19.getNoble());
        SVGAImageView sVGAImageView2 = getMDataBinding().musicSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "musicSvga");
        MicroBean mMicBean5 = getMMicBean();
        boolean booleanValue = (mMicBean5 == null || (user18 = mMicBean5.getUser()) == null || (music = user18.getMusic()) == null) ? false : music.booleanValue();
        MicroBean mMicBean6 = getMMicBean();
        refreshMusicSvga(valueOf, sVGAImageView2, booleanValue, mMicBean6 != null ? mMicBean6.getMicForbid() : false);
        MicroBean mMicBean7 = getMMicBean();
        if (((mMicBean7 == null || (user17 = mMicBean7.getUser()) == null) ? 0 : user17.getNoble()) >= 8) {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute_8));
        } else {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute));
        }
        if (getMMicBean() == null) {
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userInfoLinearLayout.setVisibility(0);
            getMDataBinding().userTag.setVisibility(8);
            getMDataBinding().userName.setTextColor(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
            getMDataBinding().userName.setText(String.valueOf(getMPosition()));
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
            getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BigItemMicroView.updateView$lambda$0(BigItemMicroView.this, view);
                }
            });
            return;
        }
        getMDataBinding().lockMicro.setVisibility(8);
        getMDataBinding().userInfoLinearLayout.setVisibility(0);
        getMDataBinding().userTag.setVisibility(8);
        getMDataBinding().userVip.setVisibility(8);
        getMDataBinding().iconNoble.setVisibility(8);
        getMDataBinding().userName.setTextColor(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
        getMDataBinding().userName.setText(String.valueOf(getMPosition()));
        getMDataBinding().userAvatar.setVisibility(8);
        getMDataBinding().userMute.setVisibility(8);
        getMDataBinding().baseMicro.setVisibility(0);
        getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BigItemMicroView.updateView$lambda$1(BigItemMicroView.this, view);
            }
        });
        SVGAImageView sVGAImageView3 = getMDataBinding().micUserHeadSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView3, "micUserHeadSvga");
        if (!(sVGAImageView3.getVisibility() == 0)) {
            getMDataBinding().micUserHeadSvga.setVisibility(8);
        }
        getMDataBinding().micUserHeadImg.setVisibility(8);
        MicroBean mMicBean8 = getMMicBean();
        if (mMicBean8 != null && mMicBean8.getLock()) {
            getMDataBinding().baseMicro.setVisibility(8);
            getMDataBinding().lockMicro.setVisibility(0);
            getMDataBinding().lockMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BigItemMicroView.updateView$lambda$2(BigItemMicroView.this, view);
                }
            });
            getMDataBinding().userInfoLinearLayout.setVisibility(0);
            getMDataBinding().userTag.setVisibility(8);
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(8);
            getMDataBinding().iconSvip.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().speakWave.setVisibility(8);
        } else {
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userInfoLinearLayout.setVisibility(0);
            getMDataBinding().userVip.setVisibility(8);
            getMDataBinding().iconNoble.setVisibility(8);
            getMDataBinding().iconSvip.setVisibility(8);
            getMDataBinding().userTag.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().speakWave.setVisibility(8);
        }
        MicroBean mMicBean9 = getMMicBean();
        if ((mMicBean9 != null ? mMicBean9.getUser() : null) != null) {
            getMDataBinding().baseMicro.setVisibility(8);
            getMDataBinding().lockMicro.setVisibility(8);
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().userAvatar.setVisibility(0);
            getMDataBinding().userInfoLinearLayout.setVisibility(0);
            NickTextView nickTextView = getMDataBinding().userName;
            UserService.Companion companion = UserService.INSTANCE;
            MicroBean mMicBean10 = getMMicBean();
            nickTextView.setTextColor(UserService.Companion.getNobleColor$default(companion, (mMicBean10 == null || (user16 = mMicBean10.getUser()) == null) ? 0 : user16.getNoble(), 0, 2, null));
            NickTextView nickTextView2 = getMDataBinding().userName;
            MicroBean mMicBean11 = getMMicBean();
            String maxLengthSuffix = (mMicBean11 == null || (user15 = mMicBean11.getUser()) == null || (nick = user15.getNick()) == null) ? null : DataExternalKt.maxLengthSuffix(nick, 10, "...");
            MicroBean mMicBean12 = getMMicBean();
            int svipLevel = (mMicBean12 == null || (user14 = mMicBean12.getUser()) == null || (svip4 = user14.getSvip()) == null) ? 0 : svip4.getSvipLevel();
            MicroBean mMicBean13 = getMMicBean();
            nickTextView2.setSVipAndNoble(maxLengthSuffix, svipLevel, (mMicBean13 == null || (user13 = mMicBean13.getUser()) == null) ? 0 : user13.getNoble());
            MicroBean mMicBean14 = getMMicBean();
            if ((mMicBean14 == null || (user12 = mMicBean14.getUser()) == null || !user12.isVip()) ? false : true) {
                getMDataBinding().userVip.setVisibility(0);
            }
            MicroBean mMicBean15 = getMMicBean();
            if (((mMicBean15 == null || (user11 = mMicBean15.getUser()) == null) ? 0 : user11.getNoble()) > 0) {
                getMDataBinding().userVip.setVisibility(8);
                getMDataBinding().iconNoble.setVisibility(0);
                ImageView imageView2 = getMDataBinding().iconNoble;
                Context context = getMDataBinding().getRoot().getContext();
                MicroBean mMicBean16 = getMMicBean();
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes((mMicBean16 == null || (user10 = mMicBean16.getUser()) == null) ? 0 : user10.getNoble())));
            } else {
                getMDataBinding().iconNoble.setVisibility(8);
            }
            MicroBean mMicBean17 = getMMicBean();
            if (((mMicBean17 == null || (user9 = mMicBean17.getUser()) == null || (svip3 = user9.getSvip()) == null) ? 0 : svip3.getSvipLevel()) > 0) {
                getMDataBinding().userVip.setVisibility(8);
                getMDataBinding().iconNoble.setVisibility(8);
                getMDataBinding().iconSvip.setVisibility(0);
                SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                MicroBean mMicBean18 = getMMicBean();
                Integer svipMedal = svipTypeUtils.getSvipMedal((mMicBean18 == null || (user8 = mMicBean18.getUser()) == null || (svip2 = user8.getSvip()) == null) ? null : Integer.valueOf(svip2.getSvipLevel()));
                if (svipMedal != null) {
                    getMDataBinding().iconSvip.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), svipMedal.intValue()));
                }
            } else {
                getMDataBinding().iconSvip.setVisibility(8);
            }
            MicroBean mMicBean19 = getMMicBean();
            if (mMicBean19 != null ? Intrinsics.areEqual(mMicBean19.getForbid(), Boolean.TRUE) : false) {
                MicroBean mMicBean20 = getMMicBean();
                String externalId2 = mMicBean20 != null ? mMicBean20.getExternalId() : null;
                User user20 = UserStore.INSTANCE.getShared().getUser();
                if (Intrinsics.areEqual(externalId2, user20 != null ? user20.getExternalId() : null)) {
                    getMDataBinding().userMute.setVisibility(0);
                    getMDataBinding().userMute.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.d
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BigItemMicroView.updateView$lambda$4(BigItemMicroView.this, view);
                        }
                    });
                    AppCompatImageView appCompatImageView = getMDataBinding().userAvatar;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
                    MicroBean mMicBean21 = getMMicBean();
                    ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100((mMicBean21 != null || (user7 = mMicBean21.getUser()) == null) ? null : user7.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
                    getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BigItemMicroView.updateView$lambda$5(BigItemMicroView.this, view);
                        }
                    });
                    meetingRoomManager = MeetingRoomManager.INSTANCE;
                    MicroBean mMicBean22 = getMMicBean();
                    roomUserRole = meetingRoomManager.getRoomUserRole((mMicBean22 != null || (user6 = mMicBean22.getUser()) == null) ? null : user6.getExternalId());
                    if (roomUserRole <= 1) {
                        getMDataBinding().userTag.setVisibility(0);
                        getMDataBinding().userTag.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), meetingRoomManager.getLevelRes(roomUserRole)));
                    } else {
                        getMDataBinding().userTag.setVisibility(8);
                    }
                    MicroBean mMicBean23 = getMMicBean();
                    effectUrl = mMicBean23 == null ? mMicBean23.getEffectUrl() : null;
                    str = "";
                    if (effectUrl != null || effectUrl.length() == 0) {
                        String obj = getMDataBinding().micUserHeadSvga.getTag().toString();
                        MicroBean mMicBean24 = getMMicBean();
                        if (Intrinsics.areEqual(obj, mMicBean24 != null ? mMicBean24.getEffectUrl() : null)) {
                            getMDataBinding().micUserHeadSvga.stopAnimation(true);
                            getMDataBinding().micUserHeadSvga.setVisibility(0);
                            getMDataBinding().micUserHeadImg.setVisibility(8);
                            MicroBean mMicBean25 = getMMicBean();
                            if (mMicBean25 != null) {
                                playSvga(mMicBean25);
                            }
                        } else {
                            getMDataBinding().micUserHeadSvga.setVisibility(0);
                            getMDataBinding().micUserHeadImg.setVisibility(8);
                            getMDataBinding().micUserHeadSvga.stopAnimation(true);
                            MicroBean mMicBean26 = getMMicBean();
                            if (mMicBean26 != null) {
                                playSvga(mMicBean26);
                            }
                        }
                    } else {
                        getMDataBinding().micUserHeadSvga.setVisibility(8);
                        getMDataBinding().micUserHeadSvga.setTag("");
                        MicroBean mMicBean27 = getMMicBean();
                        String headwearPicUrl = (mMicBean27 == null || (user2 = mMicBean27.getUser()) == null) ? null : user2.getHeadwearPicUrl();
                        if (!(headwearPicUrl == null || headwearPicUrl.length() == 0)) {
                            getMDataBinding().micUserHeadImg.setVisibility(0);
                            ImageView imageView3 = getMDataBinding().micUserHeadImg;
                            Intrinsics.checkNotNullExpressionValue(imageView3, "micUserHeadImg");
                            MicroBean mMicBean28 = getMMicBean();
                            ViewUtilitiesKt.bind(imageView3, new ImageUIModel((mMicBean28 == null || (user = mMicBean28.getUser()) == null) ? null : user.getHeadwearPicUrl(), null, null, null, 0, 0, null, 126, null));
                        } else {
                            getMDataBinding().micUserHeadImg.setVisibility(8);
                        }
                    }
                    mMicBean = getMMicBean();
                    if (mMicBean != null && (user5 = mMicBean.getUser()) != null) {
                        str2 = user5.getMicEffect();
                    }
                    if (str2 != null || str2.length() == 0) {
                        getMDataBinding().cpSvga.setVisibility(0);
                        MicroBean mMicBean29 = getMMicBean();
                        if (mMicBean29 != null) {
                            playCpSvga(mMicBean29);
                        }
                    } else {
                        getMDataBinding().cpSvga.setVisibility(8);
                    }
                    mMicBean2 = getMMicBean();
                    if (mMicBean2 != null && (user4 = mMicBean2.getUser()) != null && (externalId = user4.getExternalId()) != null) {
                        str = externalId;
                    }
                    if (!meetingRoomManager.haveLocalMute(str)) {
                        getMDataBinding().personMicOff.setVisibility(0);
                    } else {
                        getMDataBinding().personMicOff.setVisibility(8);
                    }
                    mMicBean3 = getMMicBean();
                    if (mMicBean3 != null && (user3 = mMicBean3.getUser()) != null && (svip = user3.getSvip()) != null && svip.isMystery()) {
                        AppCompatImageView appCompatImageView2 = getMDataBinding().userAvatar;
                        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatar");
                        ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
                        getMDataBinding().userName.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.view.micro.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                BigItemMicroView.updateView$lambda$10$lambda$9(BigItemMicroView.this, svip);
                            }
                        }, 100L);
                        getMDataBinding().micUserHeadSvga.setVisibility(8);
                        getMDataBinding().micUserHeadImg.setVisibility(8);
                        getMDataBinding().iconSvip.setVisibility(8);
                        getMDataBinding().userVip.setVisibility(8);
                        getMDataBinding().iconNoble.setVisibility(8);
                        getMDataBinding().userTag.setVisibility(8);
                    }
                }
            }
            getMDataBinding().userMute.setVisibility(8);
            getMDataBinding().userMute.setOnClickListener(null);
            AppCompatImageView appCompatImageView3 = getMDataBinding().userAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "userAvatar");
            MicroBean mMicBean212 = getMMicBean();
            ImageKtxKt.loadImage$default(appCompatImageView3, ImageSizeKt.image100((mMicBean212 != null || (user7 = mMicBean212.getUser()) == null) ? null : user7.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
            getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BigItemMicroView.updateView$lambda$5(BigItemMicroView.this, view);
                }
            });
            meetingRoomManager = MeetingRoomManager.INSTANCE;
            MicroBean mMicBean222 = getMMicBean();
            roomUserRole = meetingRoomManager.getRoomUserRole((mMicBean222 != null || (user6 = mMicBean222.getUser()) == null) ? null : user6.getExternalId());
            if (roomUserRole <= 1) {
            }
            MicroBean mMicBean232 = getMMicBean();
            if (mMicBean232 == null) {
            }
            str = "";
            if (effectUrl != null || effectUrl.length() == 0) {
            }
            mMicBean = getMMicBean();
            if (mMicBean != null) {
                str2 = user5.getMicEffect();
            }
            if (str2 != null || str2.length() == 0) {
            }
            mMicBean2 = getMMicBean();
            if (mMicBean2 != null) {
                str = externalId;
            }
            if (!meetingRoomManager.haveLocalMute(str)) {
            }
            mMicBean3 = getMMicBean();
            if (mMicBean3 != null) {
                AppCompatImageView appCompatImageView22 = getMDataBinding().userAvatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView22, "userAvatar");
                ImageKtxKt.loadImage$default(appCompatImageView22, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
                getMDataBinding().userName.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.view.micro.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        BigItemMicroView.updateView$lambda$10$lambda$9(BigItemMicroView.this, svip);
                    }
                }, 100L);
                getMDataBinding().micUserHeadSvga.setVisibility(8);
                getMDataBinding().micUserHeadImg.setVisibility(8);
                getMDataBinding().iconSvip.setVisibility(8);
                getMDataBinding().userVip.setVisibility(8);
                getMDataBinding().iconNoble.setVisibility(8);
                getMDataBinding().userTag.setVisibility(8);
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
        MicroBean mMicBean30 = getMMicBean();
        if (mMicBean30 != null && mMicBean30.getMicForbid()) {
            getMDataBinding().micOff.setVisibility(0);
        } else {
            getMDataBinding().micOff.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BigItemMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
