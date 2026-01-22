package com.qiahao.hilo_message.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.a;
import cf.c;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.luck.picture.lib.config.PictureConfig;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.GroupGiftDetail;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.im.TIMRoomEnvelope;
import com.qiahao.base_common.model.im.TIMRoomEnvelopeGet;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.f;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.hilo_message.R;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import com.qiahao.hilo_message.adapter.RoomMessageAdapter;
import com.qiahao.hilo_message.data.CloudCustomData;
import com.qiahao.hilo_message.data.GroupMessageNew;
import com.qiahao.hilo_message.data.ImageElemContent;
import com.qiahao.hilo_message.data.ImageInfo;
import com.qiahao.hilo_message.data.MsgBody;
import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.data.RoomTip;
import com.qiahao.hilo_message.data.TextElemContent;
import com.qiahao.hilo_message.data.TextElemContentAt;
import com.qiahao.hilo_message.data.VideoElemContent;
import com.qiahao.hilo_message.databinding.IncludeMessageTitleBinding;
import com.qiahao.hilo_message.databinding.RoomCustomActivityBinding;
import com.qiahao.hilo_message.databinding.RoomCustomCreateSudGameBinding;
import com.qiahao.hilo_message.databinding.RoomCustomEnvolopeGetBinding;
import com.qiahao.hilo_message.databinding.RoomCustomGiftBinding;
import com.qiahao.hilo_message.databinding.RoomCustomGlobalGiftBinding;
import com.qiahao.hilo_message.databinding.RoomCustomJoinUserBinding;
import com.qiahao.hilo_message.databinding.RoomCustomMatchGameBinding;
import com.qiahao.hilo_message.databinding.RoomCustomPk1v1Binding;
import com.qiahao.hilo_message.databinding.RoomCustomReceiveEnvolopeBinding;
import com.qiahao.hilo_message.databinding.RoomCustomRocketMessageBinding;
import com.qiahao.hilo_message.databinding.RoomCustomRolledBinding;
import com.qiahao.hilo_message.databinding.RoomCustomTaskBinding;
import com.qiahao.hilo_message.databinding.RoomCustomTipBinding;
import com.qiahao.hilo_message.databinding.RoomCustomUserEnterBinding;
import com.qiahao.hilo_message.databinding.RoomCustomWelcomeBinding;
import com.qiahao.hilo_message.databinding.RoomMessageDefaultTextBinding;
import com.qiahao.hilo_message.databinding.RoomMessageImageBinding;
import com.qiahao.hilo_message.databinding.RoomMessageNoSupportCostomBinding;
import com.qiahao.hilo_message.databinding.RoomMessageTextBinding;
import com.qiahao.hilo_message.listener.RoomMessageItemListener;
import com.qiahao.hilo_message.utils.BuildMessageUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.game.RoomMatchGame;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l3.b;
import l3.d;
import l3.e;
import l3.g;
import l3.h;
import l3.i;
import l3.j;
import l3.k;
import l3.l;
import l3.m;
import l3.n;
import l3.o;
import l3.p;
import l3.q;
import l3.r;
import l3.s;
import l3.t;
import l3.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ1\u0010\t\u001a\u00020\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0014¢\u0006\u0004\b\t\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\b2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0010R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/qiahao/hilo_message/adapter/RoomMessageAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/qiahao/hilo_message/data/RoomMessageMulti;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "<init>", "()V", "holder", "item", "", "convert", "(Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;Lcom/qiahao/hilo_message/data/RoomMessageMulti;)V", "", "", "payloads", "(Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;Lcom/qiahao/hilo_message/data/RoomMessageMulti;Ljava/util/List;)V", "onViewAttachedToWindow", "(Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;)V", "onViewRecycled", "Lcom/qiahao/hilo_message/listener/RoomMessageItemListener;", "mListener", "Lcom/qiahao/hilo_message/listener/RoomMessageItemListener;", "getMListener", "()Lcom/qiahao/hilo_message/listener/RoomMessageItemListener;", "setMListener", "(Lcom/qiahao/hilo_message/listener/RoomMessageItemListener;)V", "Companion", "c/a", "hilo_message_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomMessageAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomMessageAdapter.kt\ncom/qiahao/hilo_message/adapter/RoomMessageAdapter\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Color.kt\nandroidx/core/graphics/ColorKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,919:1\n61#2,9:920\n61#2,9:929\n61#2,9:938\n61#2,9:947\n61#2,9:956\n61#2,9:965\n61#2,9:974\n61#2,9:983\n61#2,9:992\n61#2,9:1001\n61#2,9:1010\n61#2,9:1020\n61#2,9:1029\n61#2,9:1040\n61#2,9:1049\n61#2,9:1059\n61#2,9:1068\n61#2,9:1078\n1#3:1019\n439#4:1038\n439#4:1039\n439#4:1058\n1869#5:1077\n1870#5:1087\n*S KotlinDebug\n*F\n+ 1 RoomMessageAdapter.kt\ncom/qiahao/hilo_message/adapter/RoomMessageAdapter\n*L\n305#1:920,9\n324#1:929,9\n369#1:938,9\n372#1:947,9\n425#1:956,9\n428#1:965,9\n497#1:974,9\n508#1:983,9\n523#1:992,9\n583#1:1001,9\n596#1:1010,9\n623#1:1020,9\n642#1:1029,9\n726#1:1040,9\n757#1:1049,9\n804#1:1059,9\n814#1:1068,9\n870#1:1078,9\n679#1:1038\n703#1:1039\n785#1:1058\n832#1:1077\n832#1:1087\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoomMessageAdapter extends BaseMultiItemQuickAdapter<RoomMessageMulti, BaseDataBindingHolder<?>> {

    @NotNull
    public static final b Companion = new b();

    @NotNull
    public static final String MESSAGE_STATUS = "refresh_message_status";

    @Nullable
    private RoomMessageItemListener mListener;

    public RoomMessageAdapter() {
        super(null, 1, null);
        addItemType(0, R.layout.room_message_default_text);
        addItemType(1, R.layout.room_message_text);
        int i10 = R.layout.room_message_image;
        addItemType(2, i10);
        addItemType(3, i10);
        addItemType(4, R.layout.room_message_no_support_costom);
        int i11 = R.layout.room_custom_join_user;
        addItemType(5, i11);
        addItemType(17, R.layout.room_custom_create_sud_game);
        addItemType(6, i11);
        addItemType(7, i11);
        addItemType(8, R.layout.room_custom_gift);
        addItemType(9, R.layout.room_custom_rolled);
        int i12 = R.layout.room_custom_global_gift;
        addItemType(10, i12);
        addItemType(11, i12);
        addItemType(12, i12);
        addItemType(13, R.layout.room_custom_rocket_message);
        addItemType(14, i12);
        addItemType(15, i10);
        addItemType(16, R.layout.room_custom_user_enter);
        addItemType(18, R.layout.room_custom_activity);
        addItemType(19, R.layout.room_custom_welcome);
        int i13 = R.layout.room_custom_tip;
        addItemType(20, i13);
        addItemType(21, R.layout.room_custom_match_game);
        addItemType(22, i13);
        addItemType(23, R.layout.room_custom_receive_envolope);
        addItemType(24, R.layout.room_custom_envolope_get);
        addItemType(25, R.layout.room_custom_pk1v1);
        addItemType(26, R.layout.room_custom_task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean convert$lambda$0(RoomMessageAdapter roomMessageAdapter, RoomMessageTextBinding roomMessageTextBinding, View view) {
        RoomMessageItemListener roomMessageItemListener = roomMessageAdapter.mListener;
        if (roomMessageItemListener != null) {
            roomMessageItemListener.onType(3, roomMessageTextBinding.msgBodyTv.getText().toString());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean convert$lambda$1(RoomMessageAdapter roomMessageAdapter, RoomMessageTextBinding roomMessageTextBinding, View view) {
        RoomMessageItemListener roomMessageItemListener = roomMessageAdapter.mListener;
        if (roomMessageItemListener != null) {
            roomMessageItemListener.onType(3, roomMessageTextBinding.msgBodyTv.getText().toString());
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$2(RoomMessageAdapter roomMessageAdapter, RoomMessageMulti roomMessageMulti, View view) {
        String url;
        ImageInfo imageInfo;
        String localPath;
        ImageInfo imageInfo2;
        k3.b bVar = MediaDetailActivity.Companion;
        Context context = roomMessageAdapter.getContext();
        GroupMessageNew data = roomMessageMulti.getData();
        String str = "";
        if (data == null || (imageInfo2 = BuildMessageUtilsKt.imageInfo(data)) == null || (url = imageInfo2.getUrl()) == null) {
            url = "";
        }
        GroupMessageNew data2 = roomMessageMulti.getData();
        if (data2 != null && (imageInfo = BuildMessageUtilsKt.imageInfo(data2)) != null && (localPath = imageInfo.getLocalPath()) != null) {
            str = localPath;
        }
        bVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(context, (Class<?>) MediaDetailActivity.class);
        intent.putExtra(MediaDetailActivity.EXTRA_MEDIA_TYPE, 0);
        intent.putExtra("url", url);
        intent.putExtra(MediaDetailActivity.EXTRA_LOCAL_URL, str);
        intent.putExtra(MediaDetailActivity.EXTRA_VIDEO_URL, (String) null);
        intent.putExtra(MediaDetailActivity.EXTRA_VIDEO_LOCAL_PATH, (String) null);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$3(RoomMessageAdapter roomMessageAdapter, VideoElemContent videoElemContent, View view) {
        String url;
        String str;
        String localThumbPath;
        k3.b bVar = MediaDetailActivity.Companion;
        Context context = roomMessageAdapter.getContext();
        String str2 = "";
        if (videoElemContent == null || (url = videoElemContent.getThumbUrl()) == null) {
            url = "";
        }
        if (videoElemContent != null && (localThumbPath = videoElemContent.getLocalThumbPath()) != null) {
            str2 = localThumbPath;
        }
        String str3 = null;
        if (videoElemContent != null) {
            str = videoElemContent.getVideoUrl();
        } else {
            str = null;
        }
        if (videoElemContent != null) {
            str3 = videoElemContent.getLocalPath();
        }
        bVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent(context, (Class<?>) MediaDetailActivity.class);
        intent.putExtra(MediaDetailActivity.EXTRA_MEDIA_TYPE, 1);
        intent.putExtra("url", url);
        intent.putExtra(MediaDetailActivity.EXTRA_LOCAL_URL, str2);
        intent.putExtra(MediaDetailActivity.EXTRA_VIDEO_URL, str);
        intent.putExtra(MediaDetailActivity.EXTRA_VIDEO_LOCAL_PATH, str3);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$33(ActivityDetailData activityDetailData, View view) {
        long j10;
        boolean z10;
        Long endAt;
        Long startAt;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        if (hiloUtils.notFastClick()) {
            long j11 = 0;
            if (activityDetailData != null && (startAt = activityDetailData.getStartAt()) != null) {
                j10 = startAt.longValue();
            } else {
                j10 = 0;
            }
            if (activityDetailData != null && (endAt = activityDetailData.getEndAt()) != null) {
                j11 = endAt.longValue();
            }
            if (hiloUtils.checkActivityStart(j10, j11) == 0) {
                if (activityDetailData != null) {
                    z10 = Intrinsics.areEqual(activityDetailData.isSubscribe(), Boolean.TRUE);
                } else {
                    z10 = false;
                }
                if (z10) {
                    c.c().l(new LiveEvent(LiveEvent.TWO_SUB_ACTIVITY, activityDetailData));
                } else {
                    c.c().l(new LiveEvent(LiveEvent.SUB_ACTIVITY, activityDetailData));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convert$lambda$35$lambda$34(RoomMessageAdapter roomMessageAdapter, GroupRoomImCustomBean groupRoomImCustomBean, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        RoomMessageItemListener roomMessageItemListener = roomMessageAdapter.mListener;
        if (roomMessageItemListener != null) {
            roomMessageItemListener.onType(5, groupRoomImCustomBean.getExternalId());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$49$lambda$48(ActivityDetailData activityDetailData, View view) {
        long j10;
        boolean z10;
        Long endAt;
        Long startAt;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        if (hiloUtils.notFastClick()) {
            long j11 = 0;
            if (activityDetailData != null && (startAt = activityDetailData.getStartAt()) != null) {
                j10 = startAt.longValue();
            } else {
                j10 = 0;
            }
            if (activityDetailData != null && (endAt = activityDetailData.getEndAt()) != null) {
                j11 = endAt.longValue();
            }
            if (hiloUtils.checkActivityStart(j10, j11) == 0) {
                if (activityDetailData != null) {
                    z10 = Intrinsics.areEqual(activityDetailData.isSubscribe(), Boolean.TRUE);
                } else {
                    z10 = false;
                }
                if (z10) {
                    c.c().l(new LiveEvent(LiveEvent.TWO_SUB_ACTIVITY, activityDetailData));
                } else {
                    c.c().l(new LiveEvent(LiveEvent.SUB_ACTIVITY, activityDetailData));
                }
            }
        }
    }

    @Nullable
    public final RoomMessageItemListener getMListener() {
        return this.mListener;
    }

    public final void setMListener(@Nullable RoomMessageItemListener roomMessageItemListener) {
        this.mListener = roomMessageItemListener;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<?>) baseViewHolder, (RoomMessageMulti) obj, (List<? extends Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull BaseDataBindingHolder<?> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled((RoomMessageAdapter) holder);
        if (holder.getItemViewType() == 16) {
            Object dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomUserEnterBinding");
            ((RoomCustomUserEnterBinding) dataBinding).nick.startOrStopAnim(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:501:0x0f15  */
    /* JADX WARN: Removed duplicated region for block: B:509:0x0f35  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0f84  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0f1a  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void convert(@NotNull BaseDataBindingHolder<?> holder, @NotNull final RoomMessageMulti item) {
        List<TextElemContentAt> atAccount;
        GroupMessageNew data;
        List<MsgBody> msgBody;
        MsgBody msgBody2;
        List<MsgBody> msgBody3;
        CloudCustomData cloudCustomData;
        Long nobleLevel;
        ImageInfo imageInfo;
        String fromAccount;
        AppService service;
        ImageInfo imageInfo2;
        String str;
        ImageInfo imageInfo3;
        User user;
        GroupMessageNew data2;
        List<MsgBody> msgBody4;
        MsgBody msgBody5;
        ImageElemContent imageContent;
        List<ImageInfo> imageInfoArray;
        List<MsgBody> msgBody6;
        MsgBody msgBody7;
        ImageElemContent imageContent2;
        String str2;
        User user2;
        Integer videoSecond;
        GroupMessageNew data3;
        List<MsgBody> msgBody8;
        MsgBody msgBody9;
        int i10;
        int i11;
        CloudCustomData cloudCustomData2;
        Long nobleLevel2;
        Integer num;
        String str3;
        String nick;
        CloudCustomData cloudCustomData3;
        Long nobleLevel3;
        CloudCustomData cloudCustomData4;
        Long nobleLevel4;
        CloudCustomData cloudCustomData5;
        Long nobleLevel5;
        CloudCustomData cloudCustomData6;
        Long nobleLevel6;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.getItemType()) {
            case 0:
                Object dataBinding = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageDefaultTextBinding");
                ((RoomMessageDefaultTextBinding) dataBinding).chatTip.setText(ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported));
                Unit unit = Unit.INSTANCE;
                return;
            case 1:
                Object dataBinding2 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageTextBinding");
                final RoomMessageTextBinding roomMessageTextBinding = (RoomMessageTextBinding) dataBinding2;
                QMUIRadiusImageView avatar = roomMessageTextBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar, "avatar");
                ProgressBar progress = roomMessageTextBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress, "progress");
                ImageView statusImg = roomMessageTextBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg, "statusImg");
                IncludeMessageTitleBinding titleLayout = roomMessageTextBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout, "titleLayout");
                z.j(this, avatar, progress, statusImg, titleLayout, item, this.mListener);
                GroupMessageNew data4 = item.getData();
                int longValue = (data4 == null || (cloudCustomData = data4.getCloudCustomData()) == null || (nobleLevel = cloudCustomData.getNobleLevel()) == null) ? 0 : (int) nobleLevel.longValue();
                ConstraintLayout msgContent = roomMessageTextBinding.msgContent;
                Intrinsics.checkNotNullExpressionValue(msgContent, "msgContent");
                z.c(this, longValue, msgContent, item.checkMystery());
                roomMessageTextBinding.msgContent.setOnLongClickListener(new View.OnLongClickListener() { // from class: jb.e
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean convert$lambda$0;
                        convert$lambda$0 = RoomMessageAdapter.convert$lambda$0(RoomMessageAdapter.this, roomMessageTextBinding, view);
                        return convert$lambda$0;
                    }
                });
                roomMessageTextBinding.msgBodyTv.setOnLongClickListener(new View.OnLongClickListener() { // from class: jb.f
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean convert$lambda$1;
                        convert$lambda$1 = RoomMessageAdapter.convert$lambda$1(RoomMessageAdapter.this, roomMessageTextBinding, view);
                        return convert$lambda$1;
                    }
                });
                GroupMessageNew data5 = item.getData();
                TextElemContent textContent = (((data5 == null || (msgBody3 = data5.getMsgBody()) == null) ? 0 : msgBody3.size()) <= 0 || (data = item.getData()) == null || (msgBody = data.getMsgBody()) == null || (msgBody2 = (MsgBody) CollectionsKt.firstOrNull((List) msgBody)) == null) ? null : msgBody2.getTextContent();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(textContent != null ? textContent.getText() : null);
                FaceManager.handlerEmojiText(roomMessageTextBinding.msgBodyTv, textContent != null ? textContent.getText() : null, false);
                roomMessageTextBinding.msgBodyTv.setText(spannableStringBuilder);
                if ((textContent == null || (atAccount = textContent.getAtAccount()) == null || !(atAccount.isEmpty() ^ true)) ? false : true) {
                    TextView msgBodyTv = roomMessageTextBinding.msgBodyTv;
                    Intrinsics.checkNotNullExpressionValue(msgBodyTv, "msgBodyTv");
                    z.g(this, msgBodyTv, textContent, this.mListener);
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
                if (!TextUtils.isEmpty(textContent != null ? textContent.getText() : null)) {
                    FaceManager.handlerEmojiText(roomMessageTextBinding.msgBodyTv, textContent != null ? textContent.getText() : null, false);
                    return;
                } else {
                    FaceManager.handlerEmojiText(roomMessageTextBinding.msgBodyTv, ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported), false);
                    return;
                }
            case 2:
                Object dataBinding3 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding3, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageImageBinding");
                RoomMessageImageBinding roomMessageImageBinding = (RoomMessageImageBinding) dataBinding3;
                QMUIRadiusImageView avatar2 = roomMessageImageBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar2, "avatar");
                ProgressBar progress2 = roomMessageImageBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress2, "progress");
                ImageView statusImg2 = roomMessageImageBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg2, "statusImg");
                IncludeMessageTitleBinding titleLayout2 = roomMessageImageBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout2, "titleLayout");
                z.j(this, avatar2, progress2, statusImg2, titleLayout2, item, this.mListener);
                GroupMessageNew data6 = item.getData();
                List<MsgBody> msgBody10 = data6 != null ? data6.getMsgBody() : null;
                if (msgBody10 != null && !msgBody10.isEmpty()) {
                    GroupMessageNew data7 = item.getData();
                    List<ImageInfo> imageInfoArray2 = (data7 == null || (msgBody6 = data7.getMsgBody()) == null || (msgBody7 = (MsgBody) CollectionsKt.getOrNull(msgBody6, 0)) == null || (imageContent2 = msgBody7.getImageContent()) == null) ? null : imageContent2.getImageInfoArray();
                    if (imageInfoArray2 != null && !imageInfoArray2.isEmpty() && (data2 = item.getData()) != null && (msgBody4 = data2.getMsgBody()) != null && (msgBody5 = (MsgBody) CollectionsKt.getOrNull(msgBody4, 0)) != null && (imageContent = msgBody5.getImageContent()) != null && (imageInfoArray = imageContent.getImageInfoArray()) != null) {
                        imageInfo = (ImageInfo) CollectionsKt.getOrNull(imageInfoArray, 0);
                        QMUIRadiusImageView contentImageIv = roomMessageImageBinding.contentImageIv;
                        Intrinsics.checkNotNullExpressionValue(contentImageIv, "contentImageIv");
                        z.k(this, contentImageIv, imageInfo);
                        roomMessageImageBinding.videoPlayBtn.setVisibility(8);
                        roomMessageImageBinding.videoDurationTv.setVisibility(8);
                        GroupMessageNew data8 = item.getData();
                        fromAccount = data8 == null ? data8.getFromAccount() : null;
                        service = AppController.INSTANCE.getService();
                        if (!Intrinsics.areEqual(fromAccount, (service != null || (user = service.getUser()) == null) ? null : user.getExternalId())) {
                            QMUIRadiusImageView contentImageIv2 = roomMessageImageBinding.contentImageIv;
                            Intrinsics.checkNotNullExpressionValue(contentImageIv2, "contentImageIv");
                            GroupMessageNew data9 = item.getData();
                            if (data9 == null || (imageInfo3 = BuildMessageUtilsKt.imageInfo(data9)) == null || (str = imageInfo3.getLocalPath()) == null) {
                                str = "";
                            }
                            File file = new File(str);
                            int i12 = R.drawable.group_placeholde;
                            ImageKtxKt.loadImage$default(contentImageIv2, null, null, file, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i12), Integer.valueOf(i12), null, 40955, null);
                        } else {
                            QMUIRadiusImageView contentImageIv3 = roomMessageImageBinding.contentImageIv;
                            Intrinsics.checkNotNullExpressionValue(contentImageIv3, "contentImageIv");
                            GroupMessageNew data10 = item.getData();
                            if (data10 != null && (imageInfo2 = BuildMessageUtilsKt.imageInfo(data10)) != null) {
                                r13 = imageInfo2.getUrl();
                            }
                            String imageSize = ImageSizeKt.imageSize(r13, 200);
                            int i13 = R.drawable.group_placeholde;
                            ImageKtxKt.loadImage$default(contentImageIv3, imageSize, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i13), Integer.valueOf(i13), null, 40958, null);
                        }
                        roomMessageImageBinding.contentImageIv.setOnClickListener(new View.OnClickListener() { // from class: jb.d
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                RoomMessageAdapter.convert$lambda$2(RoomMessageAdapter.this, item, view);
                            }
                        });
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                }
                imageInfo = null;
                QMUIRadiusImageView contentImageIv4 = roomMessageImageBinding.contentImageIv;
                Intrinsics.checkNotNullExpressionValue(contentImageIv4, "contentImageIv");
                z.k(this, contentImageIv4, imageInfo);
                roomMessageImageBinding.videoPlayBtn.setVisibility(8);
                roomMessageImageBinding.videoDurationTv.setVisibility(8);
                GroupMessageNew data82 = item.getData();
                if (data82 == null) {
                }
                service = AppController.INSTANCE.getService();
                if (!Intrinsics.areEqual(fromAccount, (service != null || (user = service.getUser()) == null) ? null : user.getExternalId())) {
                }
                roomMessageImageBinding.contentImageIv.setOnClickListener(new View.OnClickListener() { // from class: jb.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomMessageAdapter.convert$lambda$2(RoomMessageAdapter.this, item, view);
                    }
                });
                Unit unit32 = Unit.INSTANCE;
                return;
            case 3:
                Object dataBinding4 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding4, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageImageBinding");
                RoomMessageImageBinding roomMessageImageBinding2 = (RoomMessageImageBinding) dataBinding4;
                QMUIRadiusImageView avatar3 = roomMessageImageBinding2.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar3, "avatar");
                ProgressBar progress3 = roomMessageImageBinding2.progress;
                Intrinsics.checkNotNullExpressionValue(progress3, "progress");
                ImageView statusImg3 = roomMessageImageBinding2.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg3, "statusImg");
                IncludeMessageTitleBinding titleLayout3 = roomMessageImageBinding2.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout3, "titleLayout");
                z.j(this, avatar3, progress3, statusImg3, titleLayout3, item, this.mListener);
                GroupMessageNew data11 = item.getData();
                List<MsgBody> msgBody11 = data11 != null ? data11.getMsgBody() : null;
                VideoElemContent videoContent = (msgBody11 == null || msgBody11.isEmpty() || (data3 = item.getData()) == null || (msgBody8 = data3.getMsgBody()) == null || (msgBody9 = (MsgBody) CollectionsKt.getOrNull(msgBody8, 0)) == null) ? null : msgBody9.getVideoContent();
                QMUIRadiusImageView contentImageIv5 = roomMessageImageBinding2.contentImageIv;
                Intrinsics.checkNotNullExpressionValue(contentImageIv5, "contentImageIv");
                z.l(this, contentImageIv5, videoContent);
                roomMessageImageBinding2.videoPlayBtn.setVisibility(0);
                roomMessageImageBinding2.videoDurationTv.setVisibility(0);
                roomMessageImageBinding2.videoDurationTv.setText(f.c((videoContent == null || (videoSecond = videoContent.getVideoSecond()) == null) ? 0 : videoSecond.intValue()));
                GroupMessageNew data12 = item.getData();
                final VideoElemContent videoInfo = data12 != null ? BuildMessageUtilsKt.videoInfo(data12) : null;
                GroupMessageNew data13 = item.getData();
                String fromAccount2 = data13 != null ? data13.getFromAccount() : null;
                AppService service2 = AppController.INSTANCE.getService();
                if (Intrinsics.areEqual(fromAccount2, (service2 == null || (user2 = service2.getUser()) == null) ? null : user2.getExternalId())) {
                    QMUIRadiusImageView contentImageIv6 = roomMessageImageBinding2.contentImageIv;
                    Intrinsics.checkNotNullExpressionValue(contentImageIv6, "contentImageIv");
                    if (videoInfo == null || (str2 = videoInfo.getLocalThumbPath()) == null) {
                        str2 = "";
                    }
                    File file2 = new File(str2);
                    int i14 = R.drawable.group_placeholde;
                    ImageKtxKt.loadImage$default(contentImageIv6, null, null, file2, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i14), Integer.valueOf(i14), null, 40955, null);
                } else {
                    QMUIRadiusImageView contentImageIv7 = roomMessageImageBinding2.contentImageIv;
                    Intrinsics.checkNotNullExpressionValue(contentImageIv7, "contentImageIv");
                    String imageSize2 = ImageSizeKt.imageSize(videoInfo != null ? videoInfo.getThumbUrl() : null, 200);
                    int i15 = R.drawable.group_placeholde;
                    ImageKtxKt.loadImage$default(contentImageIv7, imageSize2, null, null, null, null, null, false, 0, false, null, null, null, null, Integer.valueOf(i15), Integer.valueOf(i15), null, 40958, null);
                }
                roomMessageImageBinding2.contentImageIv.setOnClickListener(new View.OnClickListener() { // from class: jb.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomMessageAdapter.convert$lambda$3(RoomMessageAdapter.this, videoInfo, view);
                    }
                });
                Unit unit4 = Unit.INSTANCE;
                return;
            case 4:
                Object dataBinding5 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding5, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageNoSupportCostomBinding");
                RoomMessageNoSupportCostomBinding roomMessageNoSupportCostomBinding = (RoomMessageNoSupportCostomBinding) dataBinding5;
                QMUIRadiusImageView avatar4 = roomMessageNoSupportCostomBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar4, "avatar");
                ProgressBar progress4 = roomMessageNoSupportCostomBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress4, "progress");
                ImageView statusImg4 = roomMessageNoSupportCostomBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg4, "statusImg");
                IncludeMessageTitleBinding titleLayout4 = roomMessageNoSupportCostomBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout4, "titleLayout");
                z.j(this, avatar4, progress4, statusImg4, titleLayout4, item, this.mListener);
                Unit unit5 = Unit.INSTANCE;
                return;
            case 5:
                Object dataBinding6 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding6, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomJoinUserBinding");
                RoomCustomJoinUserBinding roomCustomJoinUserBinding = (RoomCustomJoinUserBinding) dataBinding6;
                GroupMessageNew data14 = item.getData();
                GroupRoomImCustomBean groupRoomImCustomBean = data14 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data14, GroupRoomImCustomBean.class) : null;
                if (groupRoomImCustomBean != null) {
                    QMUIRadiusImageView userAvatar = roomCustomJoinUserBinding.userAvatar;
                    Intrinsics.checkNotNullExpressionValue(userAvatar, "userAvatar");
                    ImageKtxKt.loadImage$default(userAvatar, ImageSizeKt.image100(groupRoomImCustomBean.getAvatar()), null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(com.tencent.qcloud.tuikit.tuichat.R.drawable.ic_user_place_avatar), null, 49150, null);
                    TextView textView = roomCustomJoinUserBinding.userJoinContent;
                    String stringById = ResourcesKtxKt.getStringById(this, com.tencent.qcloud.tuikit.tuichat.R.string.group_join);
                    String nick2 = groupRoomImCustomBean.getNick();
                    String format = String.format(stringById, Arrays.copyOf(new Object[]{nick2 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(nick2) : null}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    textView.setText(format);
                    roomCustomJoinUserBinding.otherUserAvatar.setVisibility(8);
                    QMUIRadiusImageView qMUIRadiusImageView = roomCustomJoinUserBinding.userAvatar;
                    qMUIRadiusImageView.setOnClickListener(new s(qMUIRadiusImageView, groupRoomImCustomBean));
                    Unit unit6 = Unit.INSTANCE;
                    return;
                }
                return;
            case 6:
                Object dataBinding7 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding7, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomJoinUserBinding");
                RoomCustomJoinUserBinding roomCustomJoinUserBinding2 = (RoomCustomJoinUserBinding) dataBinding7;
                GroupMessageNew data15 = item.getData();
                GroupRoomImCustomBean groupRoomImCustomBean2 = data15 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data15, GroupRoomImCustomBean.class) : null;
                if (groupRoomImCustomBean2 != null) {
                    QMUIRadiusImageView userAvatar2 = roomCustomJoinUserBinding2.userAvatar;
                    Intrinsics.checkNotNullExpressionValue(userAvatar2, "userAvatar");
                    String image100 = ImageSizeKt.image100(groupRoomImCustomBean2.getAvatar());
                    int i16 = R.drawable.default_user_icon;
                    ImageKtxKt.loadImage$default(userAvatar2, image100, null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(i16), null, 49150, null);
                    if (Intrinsics.areEqual(groupRoomImCustomBean2.getType(), "2")) {
                        TextView textView2 = roomCustomJoinUserBinding2.userJoinContent;
                        String stringById2 = ResourcesKtxKt.getStringById(this, R.string.kicked_out_group);
                        String nick3 = groupRoomImCustomBean2.getNick();
                        String changeNickNameSizeInSixInclude = nick3 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(nick3) : null;
                        String operatorNick = groupRoomImCustomBean2.getOperatorNick();
                        String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude, operatorNick != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick) : null}, 2));
                        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                        textView2.setText(format2);
                        i10 = 0;
                    } else {
                        TextView textView3 = roomCustomJoinUserBinding2.userJoinContent;
                        String stringById3 = ResourcesKtxKt.getStringById(this, R.string.group_blocked_by);
                        String nick4 = groupRoomImCustomBean2.getNick();
                        String changeNickNameSizeInSixInclude2 = nick4 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(nick4) : null;
                        String operatorNick2 = groupRoomImCustomBean2.getOperatorNick();
                        i10 = 0;
                        String format3 = String.format(stringById3, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude2, operatorNick2 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick2) : null}, 2));
                        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                        textView3.setText(format3);
                    }
                    roomCustomJoinUserBinding2.otherUserAvatar.setVisibility(i10);
                    QMUIRadiusImageView otherUserAvatar = roomCustomJoinUserBinding2.otherUserAvatar;
                    Intrinsics.checkNotNullExpressionValue(otherUserAvatar, "otherUserAvatar");
                    ImageKtxKt.loadImage$default(otherUserAvatar, ImageSizeKt.image100(groupRoomImCustomBean2.getOperatorAvatar()), null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(i16), null, 49150, null);
                    QMUIRadiusImageView qMUIRadiusImageView2 = roomCustomJoinUserBinding2.otherUserAvatar;
                    qMUIRadiusImageView2.setOnClickListener(new e(qMUIRadiusImageView2, groupRoomImCustomBean2));
                    QMUIRadiusImageView qMUIRadiusImageView3 = roomCustomJoinUserBinding2.userAvatar;
                    qMUIRadiusImageView3.setOnClickListener(new l3.f(qMUIRadiusImageView3, groupRoomImCustomBean2));
                    Unit unit7 = Unit.INSTANCE;
                    return;
                }
                return;
            case 7:
                Object dataBinding8 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding8, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomJoinUserBinding");
                RoomCustomJoinUserBinding roomCustomJoinUserBinding3 = (RoomCustomJoinUserBinding) dataBinding8;
                GroupMessageNew data16 = item.getData();
                GroupRoomImCustomBean groupRoomImCustomBean3 = data16 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data16, GroupRoomImCustomBean.class) : null;
                if (groupRoomImCustomBean3 != null) {
                    QMUIRadiusImageView userAvatar3 = roomCustomJoinUserBinding3.userAvatar;
                    Intrinsics.checkNotNullExpressionValue(userAvatar3, "userAvatar");
                    String image1002 = ImageSizeKt.image100(groupRoomImCustomBean3.getAvatar());
                    int i17 = R.drawable.default_user_icon;
                    ImageKtxKt.loadImage$default(userAvatar3, image1002, null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(i17), null, 49150, null);
                    if (Intrinsics.areEqual(groupRoomImCustomBean3.getType(), "4")) {
                        Integer role = groupRoomImCustomBean3.getRole();
                        if (role != null && role.intValue() == 10) {
                            TextView textView4 = roomCustomJoinUserBinding3.userJoinContent;
                            String stringById4 = ResourcesKtxKt.getStringById(this, R.string.group_appointed_admin_by);
                            String nick5 = groupRoomImCustomBean3.getNick();
                            String changeNickNameSizeInSixInclude3 = nick5 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(nick5) : null;
                            String operatorNick3 = groupRoomImCustomBean3.getOperatorNick();
                            String format4 = String.format(stringById4, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude3, operatorNick3 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick3) : null}, 2));
                            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
                            textView4.setText(format4);
                        } else {
                            TextView textView5 = roomCustomJoinUserBinding3.userJoinContent;
                            String stringById5 = ResourcesKtxKt.getStringById(this, R.string.appointed_as_manager);
                            String nick6 = groupRoomImCustomBean3.getNick();
                            String changeNickNameSizeInSixInclude4 = nick6 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(nick6) : null;
                            String operatorNick4 = groupRoomImCustomBean3.getOperatorNick();
                            String format5 = String.format(stringById5, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude4, operatorNick4 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick4) : null}, 2));
                            Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
                            textView5.setText(format5);
                        }
                    } else {
                        Integer role2 = groupRoomImCustomBean3.getRole();
                        if (role2 != null && role2.intValue() == 10) {
                            TextView textView6 = roomCustomJoinUserBinding3.userJoinContent;
                            String stringById6 = ResourcesKtxKt.getStringById(this, R.string.group_remove_admin_by);
                            String nick7 = groupRoomImCustomBean3.getNick();
                            String changeNickNameSizeInSixInclude5 = nick7 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(nick7) : null;
                            String operatorNick5 = groupRoomImCustomBean3.getOperatorNick();
                            String format6 = String.format(stringById6, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude5, operatorNick5 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick5) : null}, 2));
                            Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
                            textView6.setText(format6);
                        } else {
                            TextView textView7 = roomCustomJoinUserBinding3.userJoinContent;
                            String stringById7 = ResourcesKtxKt.getStringById(this, R.string.removed_from_manager);
                            String nick8 = groupRoomImCustomBean3.getNick();
                            String changeNickNameSizeInSixInclude6 = nick8 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(nick8) : null;
                            String operatorNick6 = groupRoomImCustomBean3.getOperatorNick();
                            i11 = 0;
                            String format7 = String.format(stringById7, Arrays.copyOf(new Object[]{changeNickNameSizeInSixInclude6, operatorNick6 != null ? AppUtilitiesKt.changeNickNameSizeInSixInclude(operatorNick6) : null}, 2));
                            Intrinsics.checkNotNullExpressionValue(format7, "format(...)");
                            textView7.setText(format7);
                            roomCustomJoinUserBinding3.otherUserAvatar.setVisibility(i11);
                            QMUIRadiusImageView otherUserAvatar2 = roomCustomJoinUserBinding3.otherUserAvatar;
                            Intrinsics.checkNotNullExpressionValue(otherUserAvatar2, "otherUserAvatar");
                            ImageKtxKt.loadImage$default(otherUserAvatar2, ImageSizeKt.image100(groupRoomImCustomBean3.getOperatorAvatar()), null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(i17), null, 49150, null);
                            QMUIRadiusImageView otherUserAvatar3 = roomCustomJoinUserBinding3.otherUserAvatar;
                            Intrinsics.checkNotNullExpressionValue(otherUserAvatar3, "otherUserAvatar");
                            ImageKtxKt.loadImage$default(otherUserAvatar3, ImageSizeKt.image100(groupRoomImCustomBean3.getOperatorAvatar()), null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(i17), null, 49150, null);
                            QMUIRadiusImageView qMUIRadiusImageView4 = roomCustomJoinUserBinding3.otherUserAvatar;
                            qMUIRadiusImageView4.setOnClickListener(new g(qMUIRadiusImageView4, groupRoomImCustomBean3));
                            QMUIRadiusImageView qMUIRadiusImageView5 = roomCustomJoinUserBinding3.userAvatar;
                            qMUIRadiusImageView5.setOnClickListener(new h(qMUIRadiusImageView5, groupRoomImCustomBean3));
                            Unit unit8 = Unit.INSTANCE;
                            return;
                        }
                    }
                    i11 = 0;
                    roomCustomJoinUserBinding3.otherUserAvatar.setVisibility(i11);
                    QMUIRadiusImageView otherUserAvatar22 = roomCustomJoinUserBinding3.otherUserAvatar;
                    Intrinsics.checkNotNullExpressionValue(otherUserAvatar22, "otherUserAvatar");
                    ImageKtxKt.loadImage$default(otherUserAvatar22, ImageSizeKt.image100(groupRoomImCustomBean3.getOperatorAvatar()), null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(i17), null, 49150, null);
                    QMUIRadiusImageView otherUserAvatar32 = roomCustomJoinUserBinding3.otherUserAvatar;
                    Intrinsics.checkNotNullExpressionValue(otherUserAvatar32, "otherUserAvatar");
                    ImageKtxKt.loadImage$default(otherUserAvatar32, ImageSizeKt.image100(groupRoomImCustomBean3.getOperatorAvatar()), null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(i17), null, 49150, null);
                    QMUIRadiusImageView qMUIRadiusImageView42 = roomCustomJoinUserBinding3.otherUserAvatar;
                    qMUIRadiusImageView42.setOnClickListener(new g(qMUIRadiusImageView42, groupRoomImCustomBean3));
                    QMUIRadiusImageView qMUIRadiusImageView52 = roomCustomJoinUserBinding3.userAvatar;
                    qMUIRadiusImageView52.setOnClickListener(new h(qMUIRadiusImageView52, groupRoomImCustomBean3));
                    Unit unit82 = Unit.INSTANCE;
                    return;
                }
                return;
            case 8:
                Object dataBinding9 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding9, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomGiftBinding");
                RoomCustomGiftBinding roomCustomGiftBinding = (RoomCustomGiftBinding) dataBinding9;
                GroupMessageNew data17 = item.getData();
                GroupRoomImCustomBean groupRoomImCustomBean4 = data17 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data17, GroupRoomImCustomBean.class) : null;
                QMUIRadiusImageView avatar5 = roomCustomGiftBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar5, "avatar");
                ProgressBar progress5 = roomCustomGiftBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress5, "progress");
                ImageView statusImg5 = roomCustomGiftBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg5, "statusImg");
                IncludeMessageTitleBinding titleLayout5 = roomCustomGiftBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout5, "titleLayout");
                z.j(this, avatar5, progress5, statusImg5, titleLayout5, item, this.mListener);
                if (groupRoomImCustomBean4 != null) {
                    ImageView giftPic = roomCustomGiftBinding.giftPic;
                    Intrinsics.checkNotNullExpressionValue(giftPic, "giftPic");
                    GroupGiftDetail giftDetail = groupRoomImCustomBean4.getGiftDetail();
                    ImageKtxKt.loadImage$default(giftPic, ImageSizeKt.image100(giftDetail != null ? giftDetail.getIconUrl() : null), null, null, null, null, null, false, 0, false, null, null, null, null, null, Integer.valueOf(R.drawable.icon_default_gift), null, 49150, null);
                    roomCustomGiftBinding.receiverUserName.setText(groupRoomImCustomBean4.getNick());
                    TextView textView8 = roomCustomGiftBinding.giftNumber;
                    Long giftNumber = groupRoomImCustomBean4.getGiftNumber();
                    textView8.setText(String.valueOf(giftNumber != null ? giftNumber.longValue() : 1L));
                    SvipData receiveSvip = groupRoomImCustomBean4.getReceiveSvip();
                    if (receiveSvip != null) {
                        if (receiveSvip.isMystery()) {
                            TextView textView9 = roomCustomGiftBinding.receiverUserName;
                            String format8 = String.format(ResourcesKtxKt.getStringById(this, R.string.mystery_name), Arrays.copyOf(new Object[]{receiveSvip.mysteryNumber()}, 1));
                            Intrinsics.checkNotNullExpressionValue(format8, "format(...)");
                            textView9.setText(format8);
                        }
                        Unit unit9 = Unit.INSTANCE;
                    }
                    GroupMessageNew data18 = item.getData();
                    int longValue2 = (data18 == null || (cloudCustomData2 = data18.getCloudCustomData()) == null || (nobleLevel2 = cloudCustomData2.getNobleLevel()) == null) ? 0 : (int) nobleLevel2.longValue();
                    ConstraintLayout msgContent2 = roomCustomGiftBinding.msgContent;
                    Intrinsics.checkNotNullExpressionValue(msgContent2, "msgContent");
                    z.c(this, longValue2, msgContent2, item.checkMystery());
                    Unit unit10 = Unit.INSTANCE;
                    return;
                }
                return;
            case 9:
                Object dataBinding10 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding10, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomRolledBinding");
                RoomCustomRolledBinding roomCustomRolledBinding = (RoomCustomRolledBinding) dataBinding10;
                GroupMessageNew data19 = item.getData();
                r13 = data19 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data19, GroupRoomImCustomBean.class) : null;
                QMUIRadiusImageView avatar6 = roomCustomRolledBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar6, "avatar");
                ProgressBar progress6 = roomCustomRolledBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress6, "progress");
                ImageView statusImg6 = roomCustomRolledBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg6, "statusImg");
                IncludeMessageTitleBinding titleLayout6 = roomCustomRolledBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout6, "titleLayout");
                z.j(this, avatar6, progress6, statusImg6, titleLayout6, item, this.mListener);
                if (r13 != null) {
                    roomCustomRolledBinding.rollerNumber.removeAllViews();
                    ArrayList<Integer> dices = r13.getDices();
                    int size = dices != null ? dices.size() : 0;
                    for (int i18 = 0; i18 < size; i18++) {
                        ArrayList<Integer> dices2 = r13.getDices();
                        int intValue = (dices2 == null || (num = dices2.get(i18)) == null) ? 0 : num.intValue();
                        LinearLayout rollerNumber = roomCustomRolledBinding.rollerNumber;
                        Intrinsics.checkNotNullExpressionValue(rollerNumber, "rollerNumber");
                        z.d(this, rollerNumber, intValue);
                    }
                    Unit unit11 = Unit.INSTANCE;
                    return;
                }
                return;
            case 10:
                Object dataBinding11 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding11, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomGlobalGiftBinding");
                RoomCustomGlobalGiftBinding roomCustomGlobalGiftBinding = (RoomCustomGlobalGiftBinding) dataBinding11;
                GroupMessageNew data20 = item.getData();
                r13 = data20 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data20, GroupRoomImCustomBean.class) : null;
                if (r13 != null) {
                    TextView textView10 = roomCustomGlobalGiftBinding.giftTipText;
                    String stringById8 = ResourcesKtxKt.getStringById(this, R.string.global_group_send_gift_1);
                    String operatorNick7 = r13.getOperatorNick();
                    String nick9 = r13.getNick();
                    String giftName = r13.getGiftName();
                    String format9 = String.format(stringById8, Arrays.copyOf(new Object[]{operatorNick7, nick9, giftName != null ? giftName : ""}, 3));
                    Intrinsics.checkNotNullExpressionValue(format9, "format(...)");
                    textView10.setText(format9);
                    ConstraintLayout constraintLayout = roomCustomGlobalGiftBinding.msgContent;
                    constraintLayout.setOnClickListener(new i(constraintLayout, r13));
                    Unit unit12 = Unit.INSTANCE;
                    return;
                }
                return;
            case 11:
                Object dataBinding12 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding12, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomGlobalGiftBinding");
                RoomCustomGlobalGiftBinding roomCustomGlobalGiftBinding2 = (RoomCustomGlobalGiftBinding) dataBinding12;
                GroupMessageNew data21 = item.getData();
                r13 = data21 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data21, GroupRoomImCustomBean.class) : null;
                if (r13 != null) {
                    roomCustomGlobalGiftBinding2.giftTipText.setText(ResourcesKtxKt.getStringById(this, R.string.today_group_refreshed));
                    ConstraintLayout constraintLayout2 = roomCustomGlobalGiftBinding2.msgContent;
                    constraintLayout2.setOnClickListener(new j(constraintLayout2, r13));
                    Unit unit13 = Unit.INSTANCE;
                    return;
                }
                return;
            case 12:
                Object dataBinding13 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding13, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomGlobalGiftBinding");
                RoomCustomGlobalGiftBinding roomCustomGlobalGiftBinding3 = (RoomCustomGlobalGiftBinding) dataBinding13;
                GroupMessageNew data22 = item.getData();
                r13 = data22 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data22, GroupRoomImCustomBean.class) : null;
                if (r13 != null) {
                    roomCustomGlobalGiftBinding3.giftTipText.setText(r13.getContent());
                    ConstraintLayout constraintLayout3 = roomCustomGlobalGiftBinding3.msgContent;
                    constraintLayout3.setOnClickListener(new k(constraintLayout3, r13));
                    Unit unit14 = Unit.INSTANCE;
                    return;
                }
                return;
            case 13:
                Object dataBinding14 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding14, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomRocketMessageBinding");
                RoomCustomRocketMessageBinding roomCustomRocketMessageBinding = (RoomCustomRocketMessageBinding) dataBinding14;
                GroupMessageNew data23 = item.getData();
                r13 = data23 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data23, GroupRoomImCustomBean.class) : null;
                QMUIRadiusImageView avatar7 = roomCustomRocketMessageBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar7, "avatar");
                ProgressBar progress7 = roomCustomRocketMessageBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress7, "progress");
                ImageView statusImg7 = roomCustomRocketMessageBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg7, "statusImg");
                IncludeMessageTitleBinding titleLayout7 = roomCustomRocketMessageBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout7, "titleLayout");
                z.j(this, avatar7, progress7, statusImg7, titleLayout7, item, this.mListener);
                if (r13 != null) {
                    Integer awardType = r13.getAwardType();
                    if ((awardType == null || awardType.intValue() != 0) && (awardType == null || awardType.intValue() != 3)) {
                        if ((awardType != null && awardType.intValue() == 1) || (awardType != null && awardType.intValue() == 2)) {
                            String stringById9 = ResourcesKtxKt.getStringById(this, R.string.get_prop_for_rocket);
                            Integer number = r13.getNumber();
                            str3 = String.format(stringById9, Arrays.copyOf(new Object[]{number == null ? "0" : number}, 1));
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        } else {
                            str3 = "";
                        }
                    } else {
                        String stringById10 = ResourcesKtxKt.getStringById(this, R.string.get_diamonds_for_rocket);
                        Integer number2 = r13.getNumber();
                        str3 = String.format(stringById10, Arrays.copyOf(new Object[]{number2 == null ? "0" : number2}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    }
                    roomCustomRocketMessageBinding.contentText.setText(str3);
                    Unit unit15 = Unit.INSTANCE;
                    return;
                }
                return;
            case 14:
                Object dataBinding15 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding15, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomGlobalGiftBinding");
                RoomCustomGlobalGiftBinding roomCustomGlobalGiftBinding4 = (RoomCustomGlobalGiftBinding) dataBinding15;
                GroupMessageNew data24 = item.getData();
                r13 = data24 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data24, GroupRoomImCustomBean.class) : null;
                if (r13 != null) {
                    TextView textView11 = roomCustomGlobalGiftBinding4.giftTipText;
                    String format10 = String.format(ResourcesKtxKt.getStringById(this, R.string.try_get_diamonds_for_lucky_box), Arrays.copyOf(new Object[]{r13.getNick(), String.valueOf(r13.getNumber())}, 2));
                    Intrinsics.checkNotNullExpressionValue(format10, "format(...)");
                    textView11.setText(format10);
                    ConstraintLayout constraintLayout4 = roomCustomGlobalGiftBinding4.msgContent;
                    constraintLayout4.setOnClickListener(new l(constraintLayout4));
                    Unit unit16 = Unit.INSTANCE;
                    return;
                }
                return;
            case 15:
                Object dataBinding16 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding16, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomGlobalGiftBinding");
                RoomCustomGlobalGiftBinding roomCustomGlobalGiftBinding5 = (RoomCustomGlobalGiftBinding) dataBinding16;
                GroupMessageNew data25 = item.getData();
                r13 = data25 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data25, GroupRoomImCustomBean.class) : null;
                if (r13 != null) {
                    TextView textView12 = roomCustomGlobalGiftBinding5.giftTipText;
                    String format11 = String.format(ResourcesKtxKt.getStringById(this, R.string.fruit_message_get_big_reward), Arrays.copyOf(new Object[]{r13.getNick(), String.valueOf(r13.getDiamondNum())}, 2));
                    Intrinsics.checkNotNullExpressionValue(format11, "format(...)");
                    textView12.setText(format11);
                    ConstraintLayout constraintLayout5 = roomCustomGlobalGiftBinding5.msgContent;
                    constraintLayout5.setOnClickListener(new m(constraintLayout5));
                    Unit unit17 = Unit.INSTANCE;
                    return;
                }
                return;
            case 16:
                Object dataBinding17 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding17, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomUserEnterBinding");
                RoomCustomUserEnterBinding roomCustomUserEnterBinding = (RoomCustomUserEnterBinding) dataBinding17;
                GroupMessageNew data26 = item.getData();
                GroupRoomImCustomBean groupRoomImCustomBean5 = data26 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data26, GroupRoomImCustomBean.class) : null;
                if (groupRoomImCustomBean5 != null) {
                    try {
                        SvipData svip = groupRoomImCustomBean5.getSvip();
                        if (svip != null && svip.isMystery()) {
                            String stringById11 = ResourcesKtxKt.getStringById(this, R.string.mystery_name);
                            SvipData svip2 = groupRoomImCustomBean5.getSvip();
                            nick = String.format(stringById11, Arrays.copyOf(new Object[]{svip2 != null ? svip2.mysteryNumber() : null}, 1));
                            Intrinsics.checkNotNullExpressionValue(nick, "format(...)");
                        } else {
                            nick = groupRoomImCustomBean5.getNick();
                        }
                        if (item.checkMystery()) {
                            NickTextView nickTextView = roomCustomUserEnterBinding.nick;
                            if (nick == null) {
                                nick = "";
                            }
                            nickTextView.setText(nick);
                        } else {
                            BaseService mAppService = AllModuleServiceManager.INSTANCE.get().getMAppService();
                            if (mAppService != null) {
                                Integer nobleLevel7 = groupRoomImCustomBean5.getNobleLevel();
                                roomCustomUserEnterBinding.nick.setTextColor(BaseService.getNobleColor$default(mAppService, nobleLevel7 != null ? nobleLevel7.intValue() : 0, 0, 2, null));
                                Unit unit18 = Unit.INSTANCE;
                            }
                            NickTextView nickTextView2 = roomCustomUserEnterBinding.nick;
                            SvipData svip3 = groupRoomImCustomBean5.getSvip();
                            int svipLevel = svip3 != null ? svip3.getSvipLevel() : 0;
                            Integer nobleLevel8 = groupRoomImCustomBean5.getNobleLevel();
                            nickTextView2.setSVipAndNoble(nick, svipLevel, nobleLevel8 != null ? nobleLevel8.intValue() : 0);
                        }
                        NickTextView nickTextView3 = roomCustomUserEnterBinding.nick;
                        nickTextView3.setOnClickListener(new n(nickTextView3, this, groupRoomImCustomBean5));
                        roomCustomUserEnterBinding.contentText.setTextColor(-1);
                        TextView textView13 = roomCustomUserEnterBinding.contentText;
                        String format12 = String.format(ResourcesKtxKt.getStringById(this, R.string.nick_coming), Arrays.copyOf(new Object[]{""}, 1));
                        Intrinsics.checkNotNullExpressionValue(format12, "format(...)");
                        textView13.setText(format12);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    Unit unit19 = Unit.INSTANCE;
                    return;
                }
                return;
            case 17:
                Object dataBinding18 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding18, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomCreateSudGameBinding");
                RoomCustomCreateSudGameBinding roomCustomCreateSudGameBinding = (RoomCustomCreateSudGameBinding) dataBinding18;
                GroupMessageNew data27 = item.getData();
                r13 = data27 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data27, GroupRoomImCustomBean.class) : null;
                QMUIRadiusImageView avatar8 = roomCustomCreateSudGameBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar8, "avatar");
                ProgressBar progress8 = roomCustomCreateSudGameBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress8, "progress");
                ImageView statusImg8 = roomCustomCreateSudGameBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg8, "statusImg");
                IncludeMessageTitleBinding titleLayout8 = roomCustomCreateSudGameBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout8, "titleLayout");
                z.j(this, avatar8, progress8, statusImg8, titleLayout8, item, this.mListener);
                if (r13 != null) {
                    TextView textView14 = roomCustomCreateSudGameBinding.content;
                    String msg = r13.getMsg();
                    if (msg == null) {
                        msg = "";
                    }
                    textView14.setText(msg);
                    View root = roomCustomCreateSudGameBinding.getRoot();
                    root.setOnClickListener(new t(root, item));
                    GroupMessageNew data28 = item.getData();
                    int longValue3 = (data28 == null || (cloudCustomData3 = data28.getCloudCustomData()) == null || (nobleLevel3 = cloudCustomData3.getNobleLevel()) == null) ? 0 : (int) nobleLevel3.longValue();
                    ConstraintLayout msgContent3 = roomCustomCreateSudGameBinding.msgContent;
                    Intrinsics.checkNotNullExpressionValue(msgContent3, "msgContent");
                    z.c(this, longValue3, msgContent3, item.checkMystery());
                    Unit unit20 = Unit.INSTANCE;
                    return;
                }
                return;
            case 18:
                Object dataBinding19 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding19, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomActivityBinding");
                RoomCustomActivityBinding roomCustomActivityBinding = (RoomCustomActivityBinding) dataBinding19;
                GroupMessageNew data29 = item.getData();
                final ActivityDetailData activityDetailData = data29 != null ? (ActivityDetailData) BuildMessageUtilsKt.customInfo(data29, ActivityDetailData.class) : null;
                if (activityDetailData != null) {
                    GroupMessageNew data30 = item.getData();
                    z.h(this, activityDetailData, data30 != null ? data30.getMsgId() : null, roomCustomActivityBinding);
                    Unit unit21 = Unit.INSTANCE;
                }
                View root2 = roomCustomActivityBinding.getRoot();
                root2.setOnClickListener(new l3.c(activityDetailData, root2));
                roomCustomActivityBinding.interested.setOnClickListener(new View.OnClickListener() { // from class: jb.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RoomMessageAdapter.convert$lambda$33(ActivityDetailData.this, view);
                    }
                });
                Unit unit22 = Unit.INSTANCE;
                return;
            case 19:
                Object dataBinding20 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding20, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomWelcomeBinding");
                RoomCustomWelcomeBinding roomCustomWelcomeBinding = (RoomCustomWelcomeBinding) dataBinding20;
                GroupMessageNew data31 = item.getData();
                r13 = data31 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data31, GroupRoomImCustomBean.class) : null;
                QMUIRadiusImageView avatar9 = roomCustomWelcomeBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar9, "avatar");
                ProgressBar progress9 = roomCustomWelcomeBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress9, "progress");
                ImageView statusImg9 = roomCustomWelcomeBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg9, "statusImg");
                IncludeMessageTitleBinding titleLayout9 = roomCustomWelcomeBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout9, "titleLayout");
                z.j(this, avatar9, progress9, statusImg9, titleLayout9, item, this.mListener);
                if (r13 != null) {
                    SpannableTextBuilder appendText$default = SpannableTextBuilder.appendText$default(new SpannableTextBuilder(roomCustomWelcomeBinding.content), r13.getNick() + "  ", Integer.valueOf(Color.parseColor("#f96101")), null, null, null, null, new Function1() { // from class: jb.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit convert$lambda$35$lambda$34;
                            convert$lambda$35$lambda$34 = RoomMessageAdapter.convert$lambda$35$lambda$34(RoomMessageAdapter.this, r2, (String) obj);
                            return convert$lambda$35$lambda$34;
                        }
                    }, null, PictureConfig.CHOOSE_REQUEST, null);
                    String content = r13.getContent();
                    SpannableTextBuilder.appendText$default(appendText$default, content == null ? "" : content, Integer.valueOf(a.getColor(roomCustomWelcomeBinding.content.getContext(), com.tencent.qcloud.tuikit.tuichat.R.color.white)), null, null, null, null, null, null, 252, null).apply();
                    GroupMessageNew data32 = item.getData();
                    int longValue4 = (data32 == null || (cloudCustomData4 = data32.getCloudCustomData()) == null || (nobleLevel4 = cloudCustomData4.getNobleLevel()) == null) ? 0 : (int) nobleLevel4.longValue();
                    ConstraintLayout msgContent4 = roomCustomWelcomeBinding.msgContent;
                    Intrinsics.checkNotNullExpressionValue(msgContent4, "msgContent");
                    z.c(this, longValue4, msgContent4, item.checkMystery());
                    Unit unit23 = Unit.INSTANCE;
                    return;
                }
                return;
            case 20:
                Object dataBinding21 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding21, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomTipBinding");
                RoomCustomTipBinding roomCustomTipBinding = (RoomCustomTipBinding) dataBinding21;
                GroupMessageNew data33 = item.getData();
                r13 = data33 != null ? (RoomTip) BuildMessageUtilsKt.customInfo(data33, RoomTip.class) : null;
                if (r13 != null) {
                    if (r13.getTipType() == 2) {
                        roomCustomTipBinding.contentText.setTextColor(Color.parseColor("#27e28c"));
                        TextView textView15 = roomCustomTipBinding.contentText;
                        String notice = r13.getNotice();
                        if (notice == null) {
                            notice = "";
                        }
                        textView15.setText(notice);
                    } else if (r13.getTipType() == 3 || r13.getTipType() == 4) {
                        roomCustomTipBinding.contentText.setTextColor(-1);
                        TextView textView16 = roomCustomTipBinding.contentText;
                        String notice2 = r13.getNotice();
                        if (notice2 == null) {
                            notice2 = "";
                        }
                        textView16.setText(notice2);
                    }
                    Unit unit24 = Unit.INSTANCE;
                    return;
                }
                return;
            case 21:
                Object dataBinding22 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding22, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomMatchGameBinding");
                RoomCustomMatchGameBinding roomCustomMatchGameBinding = (RoomCustomMatchGameBinding) dataBinding22;
                GroupMessageNew data34 = item.getData();
                r13 = data34 != null ? (RoomMatchGame) BuildMessageUtilsKt.customInfo(data34, RoomMatchGame.class) : null;
                QMUIRadiusImageView avatar10 = roomCustomMatchGameBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar10, "avatar");
                ProgressBar progress10 = roomCustomMatchGameBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress10, "progress");
                ImageView statusImg10 = roomCustomMatchGameBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg10, "statusImg");
                IncludeMessageTitleBinding titleLayout10 = roomCustomMatchGameBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout10, "titleLayout");
                z.j(this, avatar10, progress10, statusImg10, titleLayout10, item, this.mListener);
                if (r13 != null) {
                    TextView textView17 = roomCustomMatchGameBinding.content;
                    String msg2 = r13.getMsg();
                    if (msg2 == null) {
                        msg2 = "";
                    }
                    textView17.setText(msg2);
                    ImageView gameImage = roomCustomMatchGameBinding.gameImage;
                    Intrinsics.checkNotNullExpressionValue(gameImage, "gameImage");
                    ImageKtxKt.loadImage$default(gameImage, ImageSizeKt.imageSize(r13.getGameIcon(), UiKtxKt.toPX(40)), null, null, null, null, null, false, 0, false, null, null, null, null, null, null, null, 65534, null);
                    ConstraintLayout constraintLayout6 = roomCustomMatchGameBinding.msgContent;
                    constraintLayout6.setOnClickListener(new o(constraintLayout6, r13));
                    GroupMessageNew data35 = item.getData();
                    int longValue5 = (data35 == null || (cloudCustomData5 = data35.getCloudCustomData()) == null || (nobleLevel5 = cloudCustomData5.getNobleLevel()) == null) ? 0 : (int) nobleLevel5.longValue();
                    ConstraintLayout msgContent5 = roomCustomMatchGameBinding.msgContent;
                    Intrinsics.checkNotNullExpressionValue(msgContent5, "msgContent");
                    z.c(this, longValue5, msgContent5, item.checkMystery());
                    Unit unit25 = Unit.INSTANCE;
                    return;
                }
                return;
            case 22:
                Object dataBinding23 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding23, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomTipBinding");
                ((RoomCustomTipBinding) dataBinding23).contentText.setText(ResourcesKtxKt.getStringById(this, R.string.pk_end_im));
                Unit unit26 = Unit.INSTANCE;
                return;
            case 23:
                Object dataBinding24 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding24, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomReceiveEnvolopeBinding");
                RoomCustomReceiveEnvolopeBinding roomCustomReceiveEnvolopeBinding = (RoomCustomReceiveEnvolopeBinding) dataBinding24;
                GroupMessageNew data36 = item.getData();
                TIMRoomEnvelope tIMRoomEnvelope = data36 != null ? (TIMRoomEnvelope) BuildMessageUtilsKt.customInfo(data36, TIMRoomEnvelope.class) : null;
                QMUIRadiusImageView avatar11 = roomCustomReceiveEnvolopeBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar11, "avatar");
                ProgressBar progress11 = roomCustomReceiveEnvolopeBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress11, "progress");
                ImageView statusImg11 = roomCustomReceiveEnvolopeBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg11, "statusImg");
                IncludeMessageTitleBinding titleLayout11 = roomCustomReceiveEnvolopeBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout11, "titleLayout");
                z.j(this, avatar11, progress11, statusImg11, titleLayout11, item, this.mListener);
                if (tIMRoomEnvelope != null) {
                    ImageView bg = roomCustomReceiveEnvolopeBinding.bg;
                    Intrinsics.checkNotNullExpressionValue(bg, "bg");
                    ImageKtxKt.toHorizontalMirror(bg, R.drawable.room_game_envelope_bg);
                    TextView textView18 = roomCustomReceiveEnvolopeBinding.title;
                    String stringById12 = ResourcesKtxKt.getStringById(this, R.string.send_envelope_message);
                    AppService service3 = AppController.INSTANCE.getService();
                    if (service3 != null) {
                        Long diamondNum = tIMRoomEnvelope.getDiamondNum();
                        r13 = service3.formatNumber(diamondNum != null ? diamondNum.longValue() : 0L);
                    }
                    String format13 = String.format(stringById12, Arrays.copyOf(new Object[]{r13}, 1));
                    Intrinsics.checkNotNullExpressionValue(format13, "format(...)");
                    textView18.setText(format13);
                    ImageView imageView = roomCustomReceiveEnvolopeBinding.bg;
                    imageView.setOnClickListener(new p(imageView, this, tIMRoomEnvelope));
                    Unit unit27 = Unit.INSTANCE;
                    return;
                }
                return;
            case 24:
                Object dataBinding25 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding25, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomEnvolopeGetBinding");
                RoomCustomEnvolopeGetBinding roomCustomEnvolopeGetBinding = (RoomCustomEnvolopeGetBinding) dataBinding25;
                GroupMessageNew data37 = item.getData();
                r13 = data37 != null ? (TIMRoomEnvelopeGet) BuildMessageUtilsKt.customInfo(data37, TIMRoomEnvelopeGet.class) : null;
                QMUIRadiusImageView avatar12 = roomCustomEnvolopeGetBinding.avatar;
                Intrinsics.checkNotNullExpressionValue(avatar12, "avatar");
                ProgressBar progress12 = roomCustomEnvolopeGetBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress12, "progress");
                ImageView statusImg12 = roomCustomEnvolopeGetBinding.statusImg;
                Intrinsics.checkNotNullExpressionValue(statusImg12, "statusImg");
                IncludeMessageTitleBinding titleLayout12 = roomCustomEnvolopeGetBinding.titleLayout;
                Intrinsics.checkNotNullExpressionValue(titleLayout12, "titleLayout");
                z.j(this, avatar12, progress12, statusImg12, titleLayout12, item, this.mListener);
                if (r13 != null) {
                    Long diamondNum2 = r13.getDiamondNum();
                    long longValue6 = diamondNum2 != null ? diamondNum2.longValue() : 0L;
                    String str4 = longValue6 + " " + ResourcesKtxKt.getStringById(this, R.string.diamonds);
                    String stringById13 = ResourcesKtxKt.getStringById(this, R.string.envelope_get_message);
                    String senderNick = r13.getSenderNick();
                    String senderCode = r13.getSenderCode();
                    Long diamondNum3 = r13.getDiamondNum();
                    String format14 = String.format(stringById13, Arrays.copyOf(new Object[]{senderNick, senderCode, Long.valueOf(diamondNum3 != null ? diamondNum3.longValue() : 0L)}, 3));
                    Intrinsics.checkNotNullExpressionValue(format14, "format(...)");
                    try {
                        SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(roomCustomEnvolopeGetBinding.text), format14, str4, Integer.valueOf(Color.parseColor("#FFE222")), null, 8, null).apply();
                        Unit unit28 = Unit.INSTANCE;
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        roomCustomEnvolopeGetBinding.text.setText(format14);
                    }
                    GroupMessageNew data38 = item.getData();
                    int longValue7 = (data38 == null || (cloudCustomData6 = data38.getCloudCustomData()) == null || (nobleLevel6 = cloudCustomData6.getNobleLevel()) == null) ? 0 : (int) nobleLevel6.longValue();
                    ConstraintLayout msgContent6 = roomCustomEnvolopeGetBinding.msgContent;
                    Intrinsics.checkNotNullExpressionValue(msgContent6, "msgContent");
                    z.c(this, longValue7, msgContent6, item.checkMystery());
                    Unit unit29 = Unit.INSTANCE;
                    return;
                }
                return;
            case 25:
                Object dataBinding26 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding26, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomPk1v1Binding");
                RoomCustomPk1v1Binding roomCustomPk1v1Binding = (RoomCustomPk1v1Binding) dataBinding26;
                GroupMessageNew data39 = item.getData();
                r13 = data39 != null ? (GroupRoomImCustomBean) BuildMessageUtilsKt.customInfo(data39, GroupRoomImCustomBean.class) : null;
                if (r13 != null) {
                    TextView textView19 = roomCustomPk1v1Binding.content;
                    String msg3 = r13.getMsg();
                    if (msg3 == null) {
                        msg3 = "";
                    }
                    textView19.setText(msg3);
                    View root3 = roomCustomPk1v1Binding.getRoot();
                    root3.setOnClickListener(new q(root3, r13));
                    Unit unit30 = Unit.INSTANCE;
                    return;
                }
                return;
            case 26:
                Object dataBinding27 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding27, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomTaskBinding");
                LinearLayout linearLayout = ((RoomCustomTaskBinding) dataBinding27).linear;
                linearLayout.setOnClickListener(new d(linearLayout, this));
                Unit unit31 = Unit.INSTANCE;
                return;
            default:
                Object dataBinding28 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding28, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageDefaultTextBinding");
                ((RoomMessageDefaultTextBinding) dataBinding28).chatTip.setText(ResourcesKtxKt.getStringById(this, R.string.this_message_type_is_not_supported));
                Unit unit33 = Unit.INSTANCE;
                return;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<?> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow((RoomMessageAdapter) holder);
        if (holder.getItemViewType() == 16) {
            Object dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomUserEnterBinding");
            ((RoomCustomUserEnterBinding) dataBinding).nick.startOrStopAnim(true);
        }
    }

    public void convert(@NotNull BaseDataBindingHolder<?> holder, @NotNull RoomMessageMulti item, @NotNull List<? extends Object> payloads) {
        Integer status;
        Integer status2;
        Integer status3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator<T> it = payloads.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), MESSAGE_STATUS)) {
                int itemType = item.getItemType();
                int i10 = 0;
                if (itemType == 1) {
                    Object dataBinding = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageTextBinding");
                    RoomMessageTextBinding roomMessageTextBinding = (RoomMessageTextBinding) dataBinding;
                    GroupMessageNew data = item.getData();
                    if (data != null && (status3 = data.getStatus()) != null) {
                        i10 = status3.intValue();
                    }
                    ProgressBar progress = roomMessageTextBinding.progress;
                    Intrinsics.checkNotNullExpressionValue(progress, "progress");
                    ImageView statusImg = roomMessageTextBinding.statusImg;
                    Intrinsics.checkNotNullExpressionValue(statusImg, "statusImg");
                    z.b(this, i10, progress, statusImg);
                } else if (itemType == 2) {
                    Object dataBinding2 = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageImageBinding");
                    RoomMessageImageBinding roomMessageImageBinding = (RoomMessageImageBinding) dataBinding2;
                    GroupMessageNew data2 = item.getData();
                    if (data2 != null && (status2 = data2.getStatus()) != null) {
                        i10 = status2.intValue();
                    }
                    ProgressBar progress2 = roomMessageImageBinding.progress;
                    Intrinsics.checkNotNullExpressionValue(progress2, "progress");
                    ImageView statusImg2 = roomMessageImageBinding.statusImg;
                    Intrinsics.checkNotNullExpressionValue(statusImg2, "statusImg");
                    z.b(this, i10, progress2, statusImg2);
                } else if (itemType == 3) {
                    Object dataBinding3 = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding3, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomMessageImageBinding");
                    RoomMessageImageBinding roomMessageImageBinding2 = (RoomMessageImageBinding) dataBinding3;
                    GroupMessageNew data3 = item.getData();
                    if (data3 != null && (status = data3.getStatus()) != null) {
                        i10 = status.intValue();
                    }
                    ProgressBar progress3 = roomMessageImageBinding2.progress;
                    Intrinsics.checkNotNullExpressionValue(progress3, "progress");
                    ImageView statusImg3 = roomMessageImageBinding2.statusImg;
                    Intrinsics.checkNotNullExpressionValue(statusImg3, "statusImg");
                    z.b(this, i10, progress3, statusImg3);
                } else if (itemType == 18) {
                    Object dataBinding4 = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding4, "null cannot be cast to non-null type com.qiahao.hilo_message.databinding.RoomCustomActivityBinding");
                    RoomCustomActivityBinding roomCustomActivityBinding = (RoomCustomActivityBinding) dataBinding4;
                    GroupMessageNew data4 = item.getData();
                    final ActivityDetailData activityDetailData = data4 != null ? (ActivityDetailData) BuildMessageUtilsKt.customInfo(data4, ActivityDetailData.class) : null;
                    if (activityDetailData != null) {
                        GroupMessageNew data5 = item.getData();
                        z.h(this, activityDetailData, data5 != null ? data5.getMsgId() : null, roomCustomActivityBinding);
                    }
                    View root = roomCustomActivityBinding.getRoot();
                    root.setOnClickListener(new r(activityDetailData, root));
                    roomCustomActivityBinding.interested.setOnClickListener(new View.OnClickListener() { // from class: jb.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RoomMessageAdapter.convert$lambda$49$lambda$48(ActivityDetailData.this, view);
                        }
                    });
                }
            }
        }
    }
}
