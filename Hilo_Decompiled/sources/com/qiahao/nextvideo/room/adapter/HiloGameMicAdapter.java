package com.qiahao.nextvideo.room.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemHiloGameMicBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import java.io.File;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0015J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0016\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/HiloGameMicAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemHiloGameMicBinding;", "<init>", "()V", "convert", "", "holder", "item", "payloads", "", "", "refreshView", "micBean", "binding", "showFaceSvga", "faceSVGAUrl", "", "showMicSpeakWaveAnim", "onViewRecycled", "onViewAttachedToWindow", "refreshEmptyMic", "emptyMicImage", "Landroid/widget/ImageView;", "emptyMicSVGA", "Lcom/opensource/svgaplayer/SVGAImageView;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloGameMicAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloGameMicAdapter.kt\ncom/qiahao/nextvideo/room/adapter/HiloGameMicAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,233:1\n1869#2,2:234\n*S KotlinDebug\n*F\n+ 1 HiloGameMicAdapter.kt\ncom/qiahao/nextvideo/room/adapter/HiloGameMicAdapter\n*L\n54#1:234,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloGameMicAdapter extends BaseQuickAdapter<MicroBean, BaseDataBindingHolder<ItemHiloGameMicBinding>> {
    public static final int SHOW_MIC_SPEAK_WAVE_ANIM = 100;

    public HiloGameMicAdapter() {
        super(R.layout.item_hilo_game_mic, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0183  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshView(MicroBean micBean, ItemHiloGameMicBinding binding) {
        int i;
        int i2;
        SvipData svip;
        MicroUserBean user;
        MicroUserBean user2;
        int i3;
        MicroUserBean user3;
        String str;
        String str2;
        User owner;
        SvipData svip2;
        ImageView imageView = binding.emptyMicImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "emptyMicImage");
        SVGAImageView sVGAImageView = binding.emptyMicSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "emptyMicSVGA");
        refreshEmptyMic(imageView, sVGAImageView);
        MicroUserBean user4 = micBean.getUser();
        if (user4 != null) {
            i = user4.getNoble();
        } else {
            i = 0;
        }
        if (i >= 8) {
            binding.micOff.setImageDrawable(a.getDrawable(binding.getRoot().getContext(), R.drawable.icon_micro_mute_8));
        } else {
            binding.micOff.setImageDrawable(a.getDrawable(binding.getRoot().getContext(), R.drawable.icon_micro_mute));
        }
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        GroupDetailBean groupDetailBean = meetingRoomManager.getGroupDetailBean();
        if (groupDetailBean != null && (owner = groupDetailBean.getOwner()) != null && (svip2 = owner.getSvip()) != null) {
            i2 = svip2.getSvipLevel();
        } else {
            i2 = 0;
        }
        if (i2 >= 4) {
            binding.lockMicro.setImageDrawable(a.getDrawable(binding.getRoot().getContext(), R.drawable.icon_micro_lock_gold));
        } else {
            binding.lockMicro.setImageDrawable(a.getDrawable(binding.getRoot().getContext(), R.drawable.icon_micro_lock));
        }
        binding.lockMicro.setVisibility(8);
        binding.userAvatar.setVisibility(8);
        binding.userMute.setVisibility(8);
        binding.baseMicro.setVisibility(0);
        binding.position.setVisibility(0);
        binding.userTag.setVisibility(8);
        binding.micUserHeadImg.setVisibility(8);
        if (micBean.getLock()) {
            binding.baseMicro.setVisibility(8);
            binding.lockMicro.setVisibility(0);
            binding.userAvatar.setVisibility(8);
            binding.userMute.setVisibility(8);
            binding.speakWave.setVisibility(8);
        } else {
            binding.lockMicro.setVisibility(8);
            binding.userAvatar.setVisibility(8);
            binding.userMute.setVisibility(8);
            binding.speakWave.setVisibility(8);
        }
        if (micBean.getUser() != null) {
            binding.baseMicro.setVisibility(8);
            binding.lockMicro.setVisibility(8);
            binding.userMute.setVisibility(8);
            binding.userAvatar.setVisibility(0);
            String str3 = null;
            if (Intrinsics.areEqual(micBean.getForbid(), Boolean.TRUE)) {
                String externalId = micBean.getExternalId();
                User user5 = UserStore.INSTANCE.getShared().getUser();
                if (user5 != null) {
                    str2 = user5.getExternalId();
                } else {
                    str2 = null;
                }
                if (Intrinsics.areEqual(externalId, str2)) {
                    binding.userMute.setVisibility(0);
                    AppCompatImageView appCompatImageView = binding.userAvatar;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
                    user = micBean.getUser();
                    if (user != null) {
                        str3 = user.getAvatar();
                    }
                    ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(str3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (g) null, 40958, (Object) null);
                    user2 = micBean.getUser();
                    if (user2 == null) {
                        i3 = user2.getTag();
                    } else {
                        i3 = 1;
                    }
                    if (i3 <= 1) {
                        binding.userTag.setVisibility(0);
                        binding.position.setVisibility(8);
                        binding.userTag.setImageDrawable(a.getDrawable(binding.getRoot().getContext(), meetingRoomManager.getGameLevelRes(i3)));
                    } else {
                        binding.userTag.setVisibility(8);
                        binding.position.setVisibility(0);
                    }
                    user3 = micBean.getUser();
                    if (user3 != null || (str = user3.getExternalId()) == null) {
                        str = "";
                    }
                    if (!meetingRoomManager.haveLocalMute(str)) {
                        binding.personMicOff.setVisibility(0);
                    } else {
                        binding.personMicOff.setVisibility(8);
                    }
                }
            }
            binding.userMute.setVisibility(8);
            AppCompatImageView appCompatImageView2 = binding.userAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatar");
            user = micBean.getUser();
            if (user != null) {
            }
            ImageKtxKt.loadImage$default(appCompatImageView2, ImageSizeKt.image100(str3), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (g) null, 40958, (Object) null);
            user2 = micBean.getUser();
            if (user2 == null) {
            }
            if (i3 <= 1) {
            }
            user3 = micBean.getUser();
            if (user3 != null) {
            }
            str = "";
            if (!meetingRoomManager.haveLocalMute(str)) {
            }
        } else {
            binding.speakWave.setVisibility(8);
            if (binding.speakWave.d()) {
                binding.speakWave.a();
            }
            binding.personMicOff.setVisibility(8);
        }
        if (micBean.getMicForbid()) {
            binding.micOff.setVisibility(0);
        } else {
            binding.micOff.setVisibility(8);
        }
        MicroUserBean user6 = micBean.getUser();
        if (user6 != null && (svip = user6.getSvip()) != null && svip.isMystery()) {
            AppCompatImageView appCompatImageView3 = binding.userAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "userAvatar");
            ImageKtxKt.loadImage$default(appCompatImageView3, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
            binding.micUserHeadImg.setVisibility(8);
        }
    }

    private final void showFaceSvga(String faceSVGAUrl, final ItemHiloGameMicBinding binding) {
        if (TextUtils.isEmpty(faceSVGAUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(faceSVGAUrl), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.adapter.HiloGameMicAdapter$showFaceSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    ItemHiloGameMicBinding.this.faceSvga.setVisibility(0);
                    ItemHiloGameMicBinding.this.faceSvga.setVideoItem(videoItem);
                    ItemHiloGameMicBinding.this.faceSvga.startAnimation();
                }

                public void onError() {
                    ItemHiloGameMicBinding.this.faceSvga.setVisibility(8);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void showMicSpeakWaveAnim(MicroBean micBean, ItemHiloGameMicBinding binding) {
        String str;
        int i;
        int i2;
        if (!micBean.getMicForbid()) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            MicroUserBean user = micBean.getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            if (!meetingRoomManager.haveLocalMute(str)) {
                MicroUserBean user2 = micBean.getUser();
                if (user2 != null) {
                    i = user2.getNoble();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    PortraitAnimationView portraitAnimationView = binding.speakWave;
                    UserService.Companion companion = UserService.INSTANCE;
                    MicroUserBean user3 = micBean.getUser();
                    if (user3 != null) {
                        i2 = user3.getNoble();
                    } else {
                        i2 = 0;
                    }
                    portraitAnimationView.setColor(UserService.Companion.getNobleColor$default(companion, i2, 0, 2, null));
                } else {
                    binding.speakWave.setColor(a.getColor(getContext(), 2131101214));
                }
                binding.speakWave.e();
            }
        }
    }

    public final void refreshEmptyMic(@NotNull ImageView emptyMicImage, @NotNull final SVGAImageView emptyMicSVGA) {
        int i;
        User owner;
        SvipData svip;
        Intrinsics.checkNotNullParameter(emptyMicImage, "emptyMicImage");
        Intrinsics.checkNotNullParameter(emptyMicSVGA, "emptyMicSVGA");
        SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
        GroupDetailBean groupDetailBean = MeetingRoomManager.INSTANCE.getGroupDetailBean();
        if (groupDetailBean != null && (owner = groupDetailBean.getOwner()) != null && (svip = owner.getSvip()) != null) {
            i = svip.getSvipLevel();
        } else {
            i = 0;
        }
        String micSVGA = svipTypeUtils.getMicSVGA(Integer.valueOf(i));
        if (micSVGA == null) {
            emptyMicSVGA.stopAnimation(true);
            emptyMicImage.setVisibility(0);
            emptyMicSVGA.setVisibility(8);
        } else {
            emptyMicImage.setVisibility(8);
            emptyMicSVGA.setVisibility(0);
            try {
                SVGAParser.Companion.shareParser().decodeFromAssets(micSVGA, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.adapter.HiloGameMicAdapter$refreshEmptyMic$1
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        emptyMicSVGA.setVideoItem(videoItem);
                        emptyMicSVGA.startAnimation();
                    }

                    public void onError() {
                    }
                });
            } catch (Exception unused) {
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "播放麦位皮肤失败", false, 4, (Object) null);
            }
        }
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemHiloGameMicBinding>) baseViewHolder, (MicroBean) obj, (List<? extends Object>) list);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemHiloGameMicBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemHiloGameMicBinding");
        ItemHiloGameMicBinding itemHiloGameMicBinding = (ItemHiloGameMicBinding) dataBinding;
        itemHiloGameMicBinding.speakWave.b();
        itemHiloGameMicBinding.faceSvga.stopAnimation();
        itemHiloGameMicBinding.emptyMicSVGA.stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemHiloGameMicBinding> holder, @NotNull MicroBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemHiloGameMicBinding");
        ItemHiloGameMicBinding itemHiloGameMicBinding = (ItemHiloGameMicBinding) dataBinding;
        itemHiloGameMicBinding.userTagLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#33000000", "#33000000", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        itemHiloGameMicBinding.position.setText(String.valueOf(holder.getLayoutPosition() + 1));
        refreshView(item, itemHiloGameMicBinding);
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemHiloGameMicBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemHiloGameMicBinding");
        ItemHiloGameMicBinding itemHiloGameMicBinding = (ItemHiloGameMicBinding) dataBinding;
        ImageView imageView = itemHiloGameMicBinding.emptyMicImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "emptyMicImage");
        SVGAImageView sVGAImageView = itemHiloGameMicBinding.emptyMicSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "emptyMicSVGA");
        refreshEmptyMic(imageView, sVGAImageView);
    }

    @SuppressLint({"SetTextI18n"})
    protected void convert(@NotNull BaseDataBindingHolder<ItemHiloGameMicBinding> holder, @NotNull MicroBean item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemHiloGameMicBinding");
        ItemHiloGameMicBinding itemHiloGameMicBinding = (ItemHiloGameMicBinding) dataBinding;
        itemHiloGameMicBinding.position.setText(String.valueOf(holder.getLayoutPosition() + 1));
        for (Object obj : payloads) {
            if (obj instanceof String) {
                showFaceSvga((String) obj, itemHiloGameMicBinding);
            } else if (obj instanceof Integer) {
                showMicSpeakWaveAnim(item, itemHiloGameMicBinding);
            } else if (obj instanceof MicroBean) {
                refreshView(item, itemHiloGameMicBinding);
            }
        }
    }
}
