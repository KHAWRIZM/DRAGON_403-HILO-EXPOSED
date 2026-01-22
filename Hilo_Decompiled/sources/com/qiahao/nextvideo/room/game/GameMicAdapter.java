package com.qiahao.nextvideo.room.game;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemGameMicroViewBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001a2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0012\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/room/game/GameMicAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGameMicroViewBinding;", "<init>", "()V", "convert", "", "holder", "micBean", "item", "payloads", "", "", "refreshView", "binding", "onViewRecycled", "onViewAttachedToWindow", "playSvga", "svgaView", "Lcom/opensource/svgaplayer/SVGAImageView;", "showMicSpeakWaveAnim", "showFaceSvga", "faceSVGAUrl", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGameMicAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GameMicAdapter.kt\ncom/qiahao/nextvideo/room/game/GameMicAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,241:1\n1869#2,2:242\n255#3:244\n*S KotlinDebug\n*F\n+ 1 GameMicAdapter.kt\ncom/qiahao/nextvideo/room/game/GameMicAdapter\n*L\n53#1:242,2\n79#1:244\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameMicAdapter extends BaseQuickAdapter<MicroBean, BaseDataBindingHolder<ItemGameMicroViewBinding>> {

    @NotNull
    public static final String PLAY_FACE_SVGA = "PLAY_FACE_SVGA";

    @NotNull
    public static final String PLAY_MIC_SPEAK = "PLAY_MIC_SPEAK";

    @NotNull
    public static final String REFRESH_DATA = "REFRESH_DATA";

    public GameMicAdapter() {
        super(R.layout.item_game_micro_view, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void playSvga(final SVGAImageView svgaView) {
        try {
            String obj = svgaView.getTag().toString();
            if (!TextUtils.isEmpty(obj)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(obj), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.game.GameMicAdapter$playSvga$1
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        svgaView.stopAnimation(true);
                        svgaView.setImageDrawable(new SVGADrawable(videoItem));
                        svgaView.startAnimation();
                    }

                    public void onError() {
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void refreshView(MicroBean micBean, ItemGameMicroViewBinding binding) {
        SvipData svip;
        MicroUserBean user;
        String str;
        MicroUserBean user2;
        String str2;
        MicroUserBean user3;
        String str3;
        MeetingRoomManager meetingRoomManager;
        MicroUserBean user4;
        String externalId;
        String str4;
        String str5;
        String str6;
        binding.lockMicro.setVisibility(8);
        binding.userAvatar.setVisibility(8);
        binding.userMute.setVisibility(8);
        binding.baseMicro.setVisibility(0);
        SVGAImageView sVGAImageView = binding.micUserHeadSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "micUserHeadSvga");
        if (sVGAImageView.getVisibility() != 0) {
            binding.micUserHeadSvga.setVisibility(8);
        }
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
            String str7 = null;
            if (Intrinsics.areEqual(micBean.getForbid(), Boolean.TRUE)) {
                String externalId2 = micBean.getExternalId();
                User user5 = UserStore.INSTANCE.getShared().getUser();
                if (user5 != null) {
                    str6 = user5.getExternalId();
                } else {
                    str6 = null;
                }
                if (Intrinsics.areEqual(externalId2, str6)) {
                    binding.userMute.setVisibility(0);
                    CircleImageView circleImageView = binding.userAvatar;
                    Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatar");
                    ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                    user = micBean.getUser();
                    str = "";
                    if (user != null || (r8 = user.getAvatar()) == null) {
                        String str8 = "";
                    }
                    ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
                    Dimens dimens = Dimens.INSTANCE;
                    fill.setWidth(dimens.dpToPx(62));
                    fill.setHeight(dimens.dpToPx(62));
                    Unit unit = Unit.INSTANCE;
                    ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(str8, fill), null, 2, null);
                    user2 = micBean.getUser();
                    if (user2 == null) {
                        str2 = user2.getHeadwearEffectUrl();
                    } else {
                        str2 = null;
                    }
                    if (str2 == null && str2.length() != 0) {
                        String obj = binding.micUserHeadSvga.getTag().toString();
                        MicroUserBean user6 = micBean.getUser();
                        if (user6 != null) {
                            str7 = user6.getHeadwearEffectUrl();
                        }
                        if (Intrinsics.areEqual(obj, str7)) {
                            binding.micUserHeadSvga.stopAnimation(true);
                            binding.micUserHeadSvga.setVisibility(0);
                            binding.micUserHeadImg.setVisibility(8);
                            SVGAImageView sVGAImageView2 = binding.micUserHeadSvga;
                            MicroUserBean user7 = micBean.getUser();
                            if (user7 == null || (str5 = user7.getHeadwearEffectUrl()) == null) {
                                str5 = "";
                            }
                            sVGAImageView2.setTag(str5);
                        } else {
                            binding.micUserHeadSvga.setVisibility(0);
                            binding.micUserHeadImg.setVisibility(8);
                            binding.micUserHeadSvga.stopAnimation(true);
                            SVGAImageView sVGAImageView3 = binding.micUserHeadSvga;
                            MicroUserBean user8 = micBean.getUser();
                            if (user8 == null || (str4 = user8.getHeadwearEffectUrl()) == null) {
                                str4 = "";
                            }
                            sVGAImageView3.setTag(str4);
                        }
                    } else {
                        binding.micUserHeadSvga.setVisibility(8);
                        binding.micUserHeadSvga.setTag("");
                        user3 = micBean.getUser();
                        if (user3 == null) {
                            str3 = user3.getHeadwearPicUrl();
                        } else {
                            str3 = null;
                        }
                        if (str3 == null && str3.length() != 0) {
                            binding.micUserHeadImg.setVisibility(0);
                            ImageView imageView = binding.micUserHeadImg;
                            Intrinsics.checkNotNullExpressionValue(imageView, "micUserHeadImg");
                            MicroUserBean user9 = micBean.getUser();
                            if (user9 != null) {
                                str7 = user9.getHeadwearPicUrl();
                            }
                            ViewUtilitiesKt.bind(imageView, new ImageUIModel(str7, null, null, null, 0, 0, null, 126, null));
                        } else {
                            binding.micUserHeadImg.setVisibility(8);
                        }
                    }
                    meetingRoomManager = MeetingRoomManager.INSTANCE;
                    user4 = micBean.getUser();
                    if (user4 != null && (externalId = user4.getExternalId()) != null) {
                        str = externalId;
                    }
                    if (!meetingRoomManager.haveLocalMute(str)) {
                        binding.personMicOff.setVisibility(0);
                    } else {
                        binding.personMicOff.setVisibility(8);
                    }
                }
            }
            binding.userMute.setVisibility(8);
            CircleImageView circleImageView2 = binding.userAvatar;
            Intrinsics.checkNotNullExpressionValue(circleImageView2, "userAvatar");
            ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
            user = micBean.getUser();
            str = "";
            if (user != null) {
            }
            String str82 = "";
            ResizeMode.FILL fill2 = ResizeMode.FILL.INSTANCE;
            Dimens dimens2 = Dimens.INSTANCE;
            fill2.setWidth(dimens2.dpToPx(62));
            fill2.setHeight(dimens2.dpToPx(62));
            Unit unit2 = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView2, companion2.displayUserAvatarImage(str82, fill2), null, 2, null);
            user2 = micBean.getUser();
            if (user2 == null) {
            }
            if (str2 == null) {
            }
            binding.micUserHeadSvga.setVisibility(8);
            binding.micUserHeadSvga.setTag("");
            user3 = micBean.getUser();
            if (user3 == null) {
            }
            if (str3 == null) {
            }
            binding.micUserHeadImg.setVisibility(8);
            meetingRoomManager = MeetingRoomManager.INSTANCE;
            user4 = micBean.getUser();
            if (user4 != null) {
                str = externalId;
            }
            if (!meetingRoomManager.haveLocalMute(str)) {
            }
        } else {
            binding.speakWave.setVisibility(8);
            binding.micUserHeadSvga.setVisibility(8);
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
        SVGAImageView sVGAImageView4 = binding.micUserHeadSvga;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView4, "micUserHeadSvga");
        playSvga(sVGAImageView4);
        MicroUserBean user10 = micBean.getUser();
        if (user10 != null && (svip = user10.getSvip()) != null && svip.isMystery()) {
            AppCompatImageView appCompatImageView = binding.userAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatar");
            ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            binding.micUserHeadImg.setVisibility(8);
            binding.micUserHeadSvga.setVisibility(8);
        }
    }

    private final void showFaceSvga(String faceSVGAUrl, final ItemGameMicroViewBinding binding) {
        if (TextUtils.isEmpty(faceSVGAUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(faceSVGAUrl), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.game.GameMicAdapter$showFaceSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    ItemGameMicroViewBinding.this.faceSvga.setVisibility(0);
                    ItemGameMicroViewBinding.this.faceSvga.setVideoItem(videoItem);
                    ItemGameMicroViewBinding.this.faceSvga.startAnimation();
                }

                public void onError() {
                    ItemGameMicroViewBinding.this.faceSvga.setVisibility(8);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void showMicSpeakWaveAnim(MicroBean micBean, ItemGameMicroViewBinding binding) {
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
                    binding.speakWave.setColor(androidx.core.content.a.getColor(getContext(), 2131101214));
                }
                binding.speakWave.e();
            }
        }
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemGameMicroViewBinding>) baseViewHolder, (MicroBean) obj, (List<? extends Object>) list);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemGameMicroViewBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        holder.getView(R.id.mic_user_head_svga).stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGameMicroViewBinding> holder, @NotNull MicroBean micBean) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(micBean, "micBean");
        ItemGameMicroViewBinding itemGameMicroViewBinding = (ItemGameMicroViewBinding) holder.getDataBinding();
        if (itemGameMicroViewBinding != null) {
            refreshView(micBean, itemGameMicroViewBinding);
        }
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemGameMicroViewBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        playSvga((SVGAImageView) holder.getView(R.id.mic_user_head_svga));
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemGameMicroViewBinding> holder, @NotNull MicroBean item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ItemGameMicroViewBinding itemGameMicroViewBinding = (ItemGameMicroViewBinding) holder.getDataBinding();
        if (itemGameMicroViewBinding != null) {
            for (Object obj : payloads) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (Intrinsics.areEqual(str, PLAY_MIC_SPEAK)) {
                        showMicSpeakWaveAnim(item, itemGameMicroViewBinding);
                    } else {
                        showFaceSvga(str, itemGameMicroViewBinding);
                    }
                } else if (obj instanceof MicroBean) {
                    refreshView((MicroBean) obj, itemGameMicroViewBinding);
                }
            }
        }
    }
}
