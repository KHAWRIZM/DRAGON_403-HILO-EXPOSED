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
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.data.room.RoomPKScore;
import com.qiahao.nextvideo.data.room.RoomPKScoreRes;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemPkMicroViewBinding;
import com.qiahao.nextvideo.room.adapter.OnMicroItemClickListener;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/room/view/micro/PKItemMicroView;", "Lcom/qiahao/nextvideo/room/view/micro/BaseItemMicroView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ItemPkMicroViewBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ItemPkMicroViewBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ItemPkMicroViewBinding;)V", "initView", "", "updateView", "updateScore", "stopMicSVGA", "recoverMicSVGA", "playSvga", "micBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "playCpSvga", "showMicSpeakWaveAnim", "showFaceSvga", "faceSVGAUrl", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPKItemMicroView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PKItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/PKItemMicroView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,478:1\n1869#2,2:479\n1869#2,2:481\n*S KotlinDebug\n*F\n+ 1 PKItemMicroView.kt\ncom/qiahao/nextvideo/room/view/micro/PKItemMicroView\n*L\n334#1:479,2\n340#1:481,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKItemMicroView extends BaseItemMicroView {

    @NotNull
    private static final String TAG = "PKItemMicroView";
    public ItemPkMicroViewBinding mDataBinding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PKItemMicroView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void playCpSvga(final MicroBean micBean) {
        String str;
        if (!MeetingRoomManager.INSTANCE.checkPKMadel()) {
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
            shareParser.decodeFromURL(new URL(str2 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.PKItemMicroView$playCpSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String str3;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    SVGAImageView sVGAImageView = PKItemMicroView.this.getMDataBinding().cpSvga;
                    MicroUserBean user3 = micBean.getUser();
                    if (user3 != null) {
                        str3 = user3.getMicEffect();
                    } else {
                        str3 = null;
                    }
                    sVGAImageView.setTag(str3);
                    PKItemMicroView.this.getMDataBinding().cpSvga.stopAnimation(true);
                    PKItemMicroView.this.getMDataBinding().cpSvga.setImageDrawable(new SVGADrawable(videoItem));
                    PKItemMicroView.this.getMDataBinding().cpSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception unused) {
            getMDataBinding().cpSvga.setTag("");
        }
    }

    private final void playSvga(final MicroBean micBean) {
        if (TextUtils.isEmpty(micBean.getEffectUrl())) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(micBean.getEffectUrl() + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.PKItemMicroView$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    String headwearIcon;
                    String str;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    PKItemMicroView.this.getMDataBinding().micUserHeadSvga.setTag(micBean.getEffectUrl());
                    SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                    MicroUserBean user = micBean.getUser();
                    if (user != null && (headwearIcon = user.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                        MicroUserBean user2 = micBean.getUser();
                        if (user2 == null || (str = user2.getHeadwearIcon()) == null) {
                            str = "";
                        }
                        DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str, null, 2, null);
                    }
                    PKItemMicroView.this.getMDataBinding().micUserHeadSvga.stopAnimation(true);
                    PKItemMicroView.this.getMDataBinding().micUserHeadSvga.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                    PKItemMicroView.this.getMDataBinding().micUserHeadSvga.startAnimation();
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
    public static final void updateView$lambda$0(PKItemMicroView pKItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = pKItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onMicroClick(pKItemMicroView.getMPosition(), pKItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$1(PKItemMicroView pKItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = pKItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnLockMic(pKItemMicroView.getMPosition(), pKItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$3(PKItemMicroView pKItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = pKItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onUnMuteAvatarClick(pKItemMicroView.getMPosition(), pKItemMicroView.getMMicBean());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateView$lambda$4(PKItemMicroView pKItemMicroView, View view) {
        OnMicroItemClickListener mOnMicroItemClickListener = pKItemMicroView.getMOnMicroItemClickListener();
        if (mOnMicroItemClickListener != null) {
            mOnMicroItemClickListener.onAvatarBtnClick(pKItemMicroView.getMPosition(), pKItemMicroView.getMMicBean());
        }
    }

    @NotNull
    public final ItemPkMicroViewBinding getMDataBinding() {
        ItemPkMicroViewBinding itemPkMicroViewBinding = this.mDataBinding;
        if (itemPkMicroViewBinding != null) {
            return itemPkMicroViewBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void initView() {
        setMDataBinding(ItemPkMicroViewBinding.inflate(LayoutInflater.from(getContext()), this, true));
        setClipChildren(false);
        setClipToPadding(false);
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void recoverMicSVGA() {
        MicroBean mMicBean = getMMicBean();
        if (mMicBean != null) {
            playSvga(mMicBean);
        }
    }

    public final void setMDataBinding(@NotNull ItemPkMicroViewBinding itemPkMicroViewBinding) {
        Intrinsics.checkNotNullParameter(itemPkMicroViewBinding, "<set-?>");
        this.mDataBinding = itemPkMicroViewBinding;
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void showFaceSvga(@NotNull String faceSVGAUrl) {
        Intrinsics.checkNotNullParameter(faceSVGAUrl, "faceSVGAUrl");
        if (!MeetingRoomManager.INSTANCE.checkPKMadel() || TextUtils.isEmpty(faceSVGAUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(faceSVGAUrl + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.view.micro.PKItemMicroView$showFaceSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    PKItemMicroView.this.getMDataBinding().faceSvga.setVideoItem(videoItem);
                    PKItemMicroView.this.getMDataBinding().faceSvga.startAnimation();
                }

                public void onError() {
                    Log.d("PKItemMicroView", "onError: ----------");
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
            if (!meetingRoomManager.haveLocalMute(str) && meetingRoomManager.checkPKMadel()) {
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
        getMDataBinding().micUserHeadSvga.stopAnimation(true);
        getMDataBinding().cpSvga.stopAnimation(true);
        getMDataBinding().faceSvga.stopAnimation(true);
    }

    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    public void updateScore() {
        RoomPKScoreRes roomPKPro;
        ArrayList<RoomPKScore> scoreInfo;
        HashMap<String, Long> hashMap;
        Iterator<Map.Entry<String, Long>> it;
        Integer num;
        RoomPKScoreRes roomPKPro2;
        ArrayList<RoomPKScore> scoreInfo2;
        super.updateScore();
        if (getMMicBean() == null) {
            getMDataBinding().numberLayout.setVisibility(8);
            return;
        }
        MicroBean mMicBean = getMMicBean();
        MicroUserBean microUserBean = null;
        if (mMicBean != null && mMicBean.isRed()) {
            RoomPK mpk = MeetingRoomManager.INSTANCE.getMPK();
            if (mpk != null && (roomPKPro2 = mpk.getRoomPKPro()) != null && (scoreInfo2 = roomPKPro2.getScoreInfo()) != null) {
                hashMap = null;
                for (RoomPKScore roomPKScore : scoreInfo2) {
                    if (roomPKScore.checkIsInvite()) {
                        hashMap = roomPKScore.getScoreReceive();
                    }
                }
            }
            hashMap = null;
        } else {
            RoomPK mpk2 = MeetingRoomManager.INSTANCE.getMPK();
            if (mpk2 != null && (roomPKPro = mpk2.getRoomPKPro()) != null && (scoreInfo = roomPKPro.getScoreInfo()) != null) {
                hashMap = null;
                for (RoomPKScore roomPKScore2 : scoreInfo) {
                    if (!roomPKScore2.checkIsInvite()) {
                        hashMap = roomPKScore2.getScoreReceive();
                    }
                }
            }
            hashMap = null;
        }
        if (hashMap != null) {
            it = hashMap.entrySet().iterator();
        } else {
            it = null;
        }
        long j = 0;
        while (it != null && it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            String key = next.getKey();
            MicroBean mMicBean2 = getMMicBean();
            if (mMicBean2 != null) {
                num = Integer.valueOf(mMicBean2.getAgoraId());
            } else {
                num = null;
            }
            if (Intrinsics.areEqual(key, String.valueOf(num))) {
                j = next.getValue().longValue();
            }
        }
        MicroBean mMicBean3 = getMMicBean();
        if (mMicBean3 != null) {
            microUserBean = mMicBean3.getUser();
        }
        if (microUserBean != null) {
            getMDataBinding().numberLayout.setVisibility(0);
            getMDataBinding().number.setText(NumberUtilsKt.rankNumberFormat(j));
        } else {
            getMDataBinding().numberLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0775  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07c8  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0568  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0424  */
    @Override // com.qiahao.nextvideo.room.view.micro.BaseItemMicroView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateView() {
        int i;
        boolean z;
        boolean z2;
        MicroBean mMicBean;
        boolean z3;
        MicroBean mMicBean2;
        MicroBean mMicBean3;
        boolean z4;
        MicroBean mMicBean4;
        MicroUserBean user;
        Boolean music;
        MicroUserBean user2;
        MicroUserBean microUserBean;
        int i2;
        String str;
        int i3;
        int i4;
        String str2;
        boolean z5;
        int i5;
        int i6;
        boolean z6;
        MicroBean mMicBean5;
        String str3;
        MeetingRoomManager meetingRoomManager;
        MicroBean mMicBean6;
        String str4;
        int roomUserRole;
        MicroBean mMicBean7;
        String str5;
        boolean z7;
        String str6;
        boolean z8;
        String str7;
        MicroUserBean user3;
        MicroUserBean user4;
        MicroBean mMicBean8;
        String str8;
        boolean z9;
        MicroBean mMicBean9;
        MicroBean mMicBean10;
        MicroUserBean user5;
        SvipData svip;
        MicroUserBean user6;
        String externalId;
        MicroUserBean user7;
        String str9;
        MicroUserBean user8;
        MicroUserBean user9;
        String avatar;
        String str10;
        String str11;
        Integer num;
        MicroUserBean user10;
        SvipData svip2;
        MicroUserBean user11;
        SvipData svip3;
        int i7;
        MicroUserBean user12;
        MicroUserBean user13;
        MicroUserBean user14;
        MicroUserBean user15;
        MicroUserBean user16;
        MicroUserBean user17;
        SvipData svip4;
        MicroUserBean user18;
        MicroUserBean user19;
        MicroUserBean user20;
        boolean z10 = false;
        MicroBean mMicBean11 = getMMicBean();
        boolean z11 = true;
        if (mMicBean11 != null && mMicBean11.isRed()) {
            getMDataBinding().emptyMicImage.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_normal_red));
            getMDataBinding().lockMicro.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_lock_red));
            getMDataBinding().numberLayout.setBackground(ShapeUtil.INSTANCE.createShape("#FE76A4", "#FF345E", 6, GradientDrawable.Orientation.TOP_BOTTOM));
            getMDataBinding().fireImage.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.pk_red_fire_big));
        } else {
            getMDataBinding().emptyMicImage.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_normal_blue));
            getMDataBinding().lockMicro.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_lock_blue));
            getMDataBinding().numberLayout.setBackground(ShapeUtil.INSTANCE.createShape("#57CFFB", "#348AFF", 6, GradientDrawable.Orientation.TOP_BOTTOM));
            getMDataBinding().fireImage.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.pk_blue_fire_big));
        }
        MicroBean mMicBean12 = getMMicBean();
        if (mMicBean12 != null && (user20 = mMicBean12.getUser()) != null) {
            i = user20.getNoble();
        } else {
            i = 0;
        }
        if (i >= 8) {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute_8));
        } else {
            getMDataBinding().micOff.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), R.drawable.icon_micro_mute));
        }
        getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
        getMDataBinding().userName.setText(String.valueOf(getMPosition()));
        getMDataBinding().emptyMicImage.setVisibility(0);
        MicroBean mMicBean13 = getMMicBean();
        if (mMicBean13 != null && mMicBean13.getLock()) {
            z = true;
        } else {
            z = false;
        }
        Integer num2 = null;
        if (!z) {
            MicroBean mMicBean14 = getMMicBean();
            if (mMicBean14 != null) {
                microUserBean = mMicBean14.getUser();
            } else {
                microUserBean = null;
            }
            if (microUserBean != null) {
                getMDataBinding().userAvatar.setVisibility(0);
                getMDataBinding().userInfoLinearLayout.setVisibility(0);
                NickTextView nickTextView = getMDataBinding().userName;
                UserService.Companion companion = UserService.INSTANCE;
                MicroBean mMicBean15 = getMMicBean();
                if (mMicBean15 != null && (user19 = mMicBean15.getUser()) != null) {
                    i2 = user19.getNoble();
                } else {
                    i2 = 0;
                }
                nickTextView.setTextColor(UserService.Companion.getNobleColor$default(companion, i2, 0, 2, null));
                NickTextView nickTextView2 = getMDataBinding().userName;
                MicroBean mMicBean16 = getMMicBean();
                if (mMicBean16 != null && (user18 = mMicBean16.getUser()) != null) {
                    str = user18.getNick();
                } else {
                    str = null;
                }
                MicroBean mMicBean17 = getMMicBean();
                if (mMicBean17 != null && (user17 = mMicBean17.getUser()) != null && (svip4 = user17.getSvip()) != null) {
                    i3 = svip4.getSvipLevel();
                } else {
                    i3 = 0;
                }
                MicroBean mMicBean18 = getMMicBean();
                if (mMicBean18 != null && (user16 = mMicBean18.getUser()) != null) {
                    i4 = user16.getNoble();
                } else {
                    i4 = 0;
                }
                nickTextView2.setSVipAndNoble(str, i3, i4);
                NickTextView nickTextView3 = getMDataBinding().userName;
                MicroBean mMicBean19 = getMMicBean();
                String str12 = "";
                if (mMicBean19 == null || (user15 = mMicBean19.getUser()) == null || (str2 = user15.getNick()) == null) {
                    str2 = "";
                }
                nickTextView3.setText(DataExternalKt.maxLengthSuffix(str2, 10, "..."));
                MicroBean mMicBean20 = getMMicBean();
                if (mMicBean20 != null && (user14 = mMicBean20.getUser()) != null && user14.isVip()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    getMDataBinding().userVip.setVisibility(0);
                }
                MicroBean mMicBean21 = getMMicBean();
                if (mMicBean21 != null && (user13 = mMicBean21.getUser()) != null) {
                    i5 = user13.getNoble();
                } else {
                    i5 = 0;
                }
                if (i5 > 0) {
                    getMDataBinding().userVip.setVisibility(8);
                    getMDataBinding().iconNoble.setVisibility(0);
                    ImageView imageView = getMDataBinding().iconNoble;
                    Context context = getMDataBinding().getRoot().getContext();
                    MicroBean mMicBean22 = getMMicBean();
                    if (mMicBean22 != null && (user12 = mMicBean22.getUser()) != null) {
                        i7 = user12.getNoble();
                    } else {
                        i7 = 0;
                    }
                    imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i7)));
                } else {
                    getMDataBinding().iconNoble.setVisibility(8);
                }
                MicroBean mMicBean23 = getMMicBean();
                if (mMicBean23 != null && (user11 = mMicBean23.getUser()) != null && (svip3 = user11.getSvip()) != null) {
                    i6 = svip3.getSvipLevel();
                } else {
                    i6 = 0;
                }
                if (i6 > 0) {
                    getMDataBinding().userVip.setVisibility(8);
                    getMDataBinding().iconNoble.setVisibility(8);
                    getMDataBinding().iconSvip.setVisibility(0);
                    SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
                    MicroBean mMicBean24 = getMMicBean();
                    if (mMicBean24 != null && (user10 = mMicBean24.getUser()) != null && (svip2 = user10.getSvip()) != null) {
                        num = Integer.valueOf(svip2.getSvipLevel());
                    } else {
                        num = null;
                    }
                    Integer svipMedal = svipTypeUtils.getSvipMedal(num);
                    if (svipMedal != null) {
                        getMDataBinding().iconSvip.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), svipMedal.intValue()));
                    }
                } else {
                    getMDataBinding().iconSvip.setVisibility(8);
                }
                MicroBean mMicBean25 = getMMicBean();
                if (mMicBean25 != null) {
                    z6 = Intrinsics.areEqual(mMicBean25.getForbid(), Boolean.TRUE);
                } else {
                    z6 = false;
                }
                if (z6) {
                    MicroBean mMicBean26 = getMMicBean();
                    if (mMicBean26 != null) {
                        str10 = mMicBean26.getExternalId();
                    } else {
                        str10 = null;
                    }
                    User user21 = UserStore.INSTANCE.getShared().getUser();
                    if (user21 != null) {
                        str11 = user21.getExternalId();
                    } else {
                        str11 = null;
                    }
                    if (Intrinsics.areEqual(str10, str11)) {
                        getMDataBinding().userMute.setVisibility(0);
                        getMDataBinding().userMute.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.a0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PKItemMicroView.updateView$lambda$3(PKItemMicroView.this, view);
                            }
                        });
                        AppCompatImageView appCompatImageView = getMDataBinding().userAvatar;
                        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
                        mMicBean5 = getMMicBean();
                        if (mMicBean5 == null && (user9 = mMicBean5.getUser()) != null && (avatar = user9.getAvatar()) != null) {
                            str3 = ImageSizeKt.image100(avatar);
                        } else {
                            str3 = null;
                        }
                        ImageKtxKt.loadImage$default(appCompatImageView, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                        getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.b0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PKItemMicroView.updateView$lambda$4(PKItemMicroView.this, view);
                            }
                        });
                        meetingRoomManager = MeetingRoomManager.INSTANCE;
                        mMicBean6 = getMMicBean();
                        if (mMicBean6 == null && (user8 = mMicBean6.getUser()) != null) {
                            str4 = user8.getExternalId();
                        } else {
                            str4 = null;
                        }
                        roomUserRole = meetingRoomManager.getRoomUserRole(str4);
                        if (roomUserRole <= 1) {
                            getMDataBinding().userTag.setVisibility(0);
                            getMDataBinding().userTag.setImageDrawable(androidx.core.content.a.getDrawable(getMDataBinding().getRoot().getContext(), meetingRoomManager.getLevelRes(roomUserRole)));
                        } else {
                            getMDataBinding().userTag.setVisibility(8);
                        }
                        mMicBean7 = getMMicBean();
                        if (mMicBean7 == null) {
                            str5 = mMicBean7.getEffectUrl();
                        } else {
                            str5 = null;
                        }
                        if (str5 == null && str5.length() != 0) {
                            z7 = false;
                        } else {
                            z7 = true;
                        }
                        if (z7) {
                            String obj = getMDataBinding().micUserHeadSvga.getTag().toString();
                            MicroBean mMicBean27 = getMMicBean();
                            if (mMicBean27 != null) {
                                str9 = mMicBean27.getEffectUrl();
                            } else {
                                str9 = null;
                            }
                            if (Intrinsics.areEqual(obj, str9)) {
                                getMDataBinding().micUserHeadSvga.stopAnimation(true);
                                getMDataBinding().micUserHeadSvga.setVisibility(0);
                                getMDataBinding().micUserHeadImg.setVisibility(8);
                                MicroBean mMicBean28 = getMMicBean();
                                if (mMicBean28 != null) {
                                    playSvga(mMicBean28);
                                }
                            } else {
                                getMDataBinding().micUserHeadSvga.setVisibility(0);
                                getMDataBinding().micUserHeadImg.setVisibility(8);
                                getMDataBinding().micUserHeadSvga.stopAnimation(true);
                                MicroBean mMicBean29 = getMMicBean();
                                if (mMicBean29 != null) {
                                    playSvga(mMicBean29);
                                }
                            }
                        } else {
                            getMDataBinding().micUserHeadSvga.setVisibility(8);
                            getMDataBinding().micUserHeadSvga.setTag("");
                            getMDataBinding().micUserHeadSvga.stopAnimation(true);
                            MicroBean mMicBean30 = getMMicBean();
                            if (mMicBean30 != null && (user4 = mMicBean30.getUser()) != null) {
                                str6 = user4.getHeadwearPicUrl();
                            } else {
                                str6 = null;
                            }
                            if (str6 != null && str6.length() != 0) {
                                z8 = false;
                            } else {
                                z8 = true;
                            }
                            if (!z8) {
                                getMDataBinding().micUserHeadImg.setVisibility(0);
                                ImageView imageView2 = getMDataBinding().micUserHeadImg;
                                Intrinsics.checkNotNullExpressionValue(imageView2, "micUserHeadImg");
                                MicroBean mMicBean31 = getMMicBean();
                                if (mMicBean31 != null && (user3 = mMicBean31.getUser()) != null) {
                                    str7 = user3.getHeadwearPicUrl();
                                } else {
                                    str7 = null;
                                }
                                ViewUtilitiesKt.bind(imageView2, new ImageUIModel(str7, null, null, null, 0, 0, null, 126, null));
                            } else {
                                getMDataBinding().micUserHeadImg.setVisibility(8);
                            }
                        }
                        mMicBean8 = getMMicBean();
                        if (mMicBean8 == null && (user7 = mMicBean8.getUser()) != null) {
                            str8 = user7.getMicEffect();
                        } else {
                            str8 = null;
                        }
                        if (str8 == null && str8.length() != 0) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        if (z9) {
                            getMDataBinding().cpSvga.setVisibility(0);
                            MicroBean mMicBean32 = getMMicBean();
                            if (mMicBean32 != null) {
                                playCpSvga(mMicBean32);
                            }
                        } else {
                            getMDataBinding().cpSvga.setVisibility(8);
                            getMDataBinding().cpSvga.stopAnimation(true);
                        }
                        mMicBean9 = getMMicBean();
                        if (mMicBean9 != null && (user6 = mMicBean9.getUser()) != null && (externalId = user6.getExternalId()) != null) {
                            str12 = externalId;
                        }
                        if (!meetingRoomManager.haveLocalMute(str12)) {
                            getMDataBinding().personMicOff.setVisibility(0);
                        } else {
                            getMDataBinding().personMicOff.setVisibility(8);
                        }
                        mMicBean10 = getMMicBean();
                        if (mMicBean10 != null && (user5 = mMicBean10.getUser()) != null && (svip = user5.getSvip()) != null && svip.isMystery()) {
                            AppCompatImageView appCompatImageView2 = getMDataBinding().userAvatar;
                            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatar");
                            ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                            getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
                            NickTextView nickTextView4 = getMDataBinding().userName;
                            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953504), Arrays.copyOf(new Object[]{svip.mysteryNumber()}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            nickTextView4.setText(format);
                            getMDataBinding().micUserHeadSvga.setVisibility(8);
                            getMDataBinding().micUserHeadSvga.stopAnimation(true);
                            getMDataBinding().micUserHeadImg.setVisibility(8);
                            getMDataBinding().iconSvip.setVisibility(8);
                            getMDataBinding().userVip.setVisibility(8);
                            getMDataBinding().iconNoble.setVisibility(8);
                            getMDataBinding().userTag.setVisibility(8);
                        }
                        mMicBean = getMMicBean();
                        if (mMicBean == null && mMicBean.getMicForbid()) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            MicroBean mMicBean33 = getMMicBean();
                            if (mMicBean33 == null || !mMicBean33.getLock()) {
                                z11 = false;
                            }
                            if (!z11) {
                                getMDataBinding().micOff.setVisibility(0);
                                mMicBean2 = getMMicBean();
                                if (mMicBean2 != null && (user2 = mMicBean2.getUser()) != null) {
                                    num2 = Integer.valueOf(user2.getNoble());
                                }
                                SVGAImageView sVGAImageView = getMDataBinding().musicSvga;
                                Intrinsics.checkNotNullExpressionValue(sVGAImageView, "musicSvga");
                                mMicBean3 = getMMicBean();
                                if (mMicBean3 == null && (user = mMicBean3.getUser()) != null && (music = user.getMusic()) != null) {
                                    z4 = music.booleanValue();
                                } else {
                                    z4 = false;
                                }
                                mMicBean4 = getMMicBean();
                                if (mMicBean4 != null) {
                                    z10 = mMicBean4.getMicForbid();
                                }
                                refreshMusicSvga(num2, sVGAImageView, z4, z10);
                            }
                        }
                        getMDataBinding().micOff.setVisibility(8);
                        mMicBean2 = getMMicBean();
                        if (mMicBean2 != null) {
                            num2 = Integer.valueOf(user2.getNoble());
                        }
                        SVGAImageView sVGAImageView2 = getMDataBinding().musicSvga;
                        Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "musicSvga");
                        mMicBean3 = getMMicBean();
                        if (mMicBean3 == null) {
                        }
                        z4 = false;
                        mMicBean4 = getMMicBean();
                        if (mMicBean4 != null) {
                        }
                        refreshMusicSvga(num2, sVGAImageView2, z4, z10);
                    }
                }
                getMDataBinding().userMute.setVisibility(8);
                getMDataBinding().userMute.setOnClickListener(null);
                AppCompatImageView appCompatImageView3 = getMDataBinding().userAvatar;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "userAvatar");
                mMicBean5 = getMMicBean();
                if (mMicBean5 == null) {
                }
                str3 = null;
                ImageKtxKt.loadImage$default(appCompatImageView3, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                getMDataBinding().userAvatar.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PKItemMicroView.updateView$lambda$4(PKItemMicroView.this, view);
                    }
                });
                meetingRoomManager = MeetingRoomManager.INSTANCE;
                mMicBean6 = getMMicBean();
                if (mMicBean6 == null) {
                }
                str4 = null;
                roomUserRole = meetingRoomManager.getRoomUserRole(str4);
                if (roomUserRole <= 1) {
                }
                mMicBean7 = getMMicBean();
                if (mMicBean7 == null) {
                }
                if (str5 == null) {
                }
                z7 = true;
                if (z7) {
                }
                mMicBean8 = getMMicBean();
                if (mMicBean8 == null) {
                }
                str8 = null;
                if (str8 == null) {
                }
                z9 = true;
                if (z9) {
                }
                mMicBean9 = getMMicBean();
                if (mMicBean9 != null) {
                    str12 = externalId;
                }
                if (!meetingRoomManager.haveLocalMute(str12)) {
                }
                mMicBean10 = getMMicBean();
                if (mMicBean10 != null) {
                    AppCompatImageView appCompatImageView22 = getMDataBinding().userAvatar;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView22, "userAvatar");
                    ImageKtxKt.loadImage$default(appCompatImageView22, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    getMDataBinding().userName.setDefault(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
                    NickTextView nickTextView42 = getMDataBinding().userName;
                    String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953504), Arrays.copyOf(new Object[]{svip.mysteryNumber()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    nickTextView42.setText(format2);
                    getMDataBinding().micUserHeadSvga.setVisibility(8);
                    getMDataBinding().micUserHeadSvga.stopAnimation(true);
                    getMDataBinding().micUserHeadImg.setVisibility(8);
                    getMDataBinding().iconSvip.setVisibility(8);
                    getMDataBinding().userVip.setVisibility(8);
                    getMDataBinding().iconNoble.setVisibility(8);
                    getMDataBinding().userTag.setVisibility(8);
                }
                mMicBean = getMMicBean();
                if (mMicBean == null) {
                }
                z3 = false;
                if (z3) {
                }
                getMDataBinding().micOff.setVisibility(8);
                mMicBean2 = getMMicBean();
                if (mMicBean2 != null) {
                }
                SVGAImageView sVGAImageView22 = getMDataBinding().musicSvga;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView22, "musicSvga");
                mMicBean3 = getMMicBean();
                if (mMicBean3 == null) {
                }
                z4 = false;
                mMicBean4 = getMMicBean();
                if (mMicBean4 != null) {
                }
                refreshMusicSvga(num2, sVGAImageView22, z4, z10);
            }
        }
        getMDataBinding().lockMicro.setVisibility(8);
        getMDataBinding().userInfoLinearLayout.setVisibility(0);
        getMDataBinding().userTag.setVisibility(8);
        getMDataBinding().numberLayout.setVisibility(8);
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
        getMDataBinding().iconSvip.setVisibility(8);
        getMDataBinding().micOff.setVisibility(8);
        getMDataBinding().baseMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PKItemMicroView.updateView$lambda$0(PKItemMicroView.this, view);
            }
        });
        getMDataBinding().userName.setTextColor(androidx.core.content.a.getColor(getMDataBinding().userName.getContext(), 2131101215));
        getMDataBinding().userName.setText(String.valueOf(getMPosition()));
        MicroBean mMicBean34 = getMMicBean();
        if (mMicBean34 != null && mMicBean34.getLock()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            getMDataBinding().baseMicro.setVisibility(8);
            getMDataBinding().lockMicro.setVisibility(0);
            getMDataBinding().lockMicro.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.micro.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PKItemMicroView.updateView$lambda$1(PKItemMicroView.this, view);
                }
            });
        } else {
            getMDataBinding().lockMicro.setOnClickListener(null);
        }
        mMicBean = getMMicBean();
        if (mMicBean == null) {
        }
        z3 = false;
        if (z3) {
        }
        getMDataBinding().micOff.setVisibility(8);
        mMicBean2 = getMMicBean();
        if (mMicBean2 != null) {
        }
        SVGAImageView sVGAImageView222 = getMDataBinding().musicSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView222, "musicSvga");
        mMicBean3 = getMMicBean();
        if (mMicBean3 == null) {
        }
        z4 = false;
        mMicBean4 = getMMicBean();
        if (mMicBean4 != null) {
        }
        refreshMusicSvga(num2, sVGAImageView222, z4, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKItemMicroView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
