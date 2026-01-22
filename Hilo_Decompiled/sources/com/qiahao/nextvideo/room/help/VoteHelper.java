package com.qiahao.nextvideo.room.help;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.hilo_message.databinding.RoomMessageViewBinding;
import com.qiahao.hilo_message.message.RoomMessageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MicBanner;
import com.qiahao.nextvideo.databinding.ViewVoteLayoutBinding;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/room/help/VoteHelper;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "mVoteBinding", "Lcom/qiahao/nextvideo/databinding/ViewVoteLayoutBinding;", "getMVoteBinding", "()Lcom/qiahao/nextvideo/databinding/ViewVoteLayoutBinding;", "setMVoteBinding", "(Lcom/qiahao/nextvideo/databinding/ViewVoteLayoutBinding;)V", "createVoteLayout", "", "removeVoteLayout", "refreshVote", "data", "Lcom/qiahao/nextvideo/data/model/MicBanner;", "refreshView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVoteHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoteHelper.kt\ncom/qiahao/nextvideo/room/help/VoteHelper\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,81:1\n61#2,9:82\n*S KotlinDebug\n*F\n+ 1 VoteHelper.kt\ncom/qiahao/nextvideo/room/help/VoteHelper\n*L\n67#1:82,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VoteHelper {

    @NotNull
    private final AudioRoomFragment fragment;

    @Nullable
    private ViewVoteLayoutBinding mVoteBinding;

    public VoteHelper(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
    }

    public static /* synthetic */ void refreshVote$default(VoteHelper voteHelper, MicBanner micBanner, int i, Object obj) {
        if ((i & 1) != 0) {
            micBanner = null;
        }
        voteHelper.refreshVote(micBanner);
    }

    public final void createVoteLayout() {
        RoomMessageViewBinding messageBinding;
        FrameLayout frameLayout;
        RoomMessageView mChatLayout;
        RoomMessageViewBinding messageBinding2;
        FrameLayout frameLayout2;
        RoomMessageView mChatLayout2 = this.fragment.getMChatLayout();
        if (mChatLayout2 != null && (messageBinding = mChatLayout2.messageBinding()) != null && (frameLayout = messageBinding.chatTopView) != null && frameLayout.getChildCount() == 0 && (mChatLayout = this.fragment.getMChatLayout()) != null && (messageBinding2 = mChatLayout.messageBinding()) != null && (frameLayout2 = messageBinding2.chatTopView) != null) {
            this.mVoteBinding = (ViewVoteLayoutBinding) androidx.databinding.g.h(LayoutInflater.from(frameLayout2.getContext()), R.layout.view_vote_layout, frameLayout2, true);
        }
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final ViewVoteLayoutBinding getMVoteBinding() {
        return this.mVoteBinding;
    }

    public final void refreshView() {
        View root;
        int i;
        ViewVoteLayoutBinding viewVoteLayoutBinding = this.mVoteBinding;
        if (viewVoteLayoutBinding != null && (root = viewVoteLayoutBinding.getRoot()) != null) {
            if (MeetingRoomManager.INSTANCE.checkGameMadel() && !((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "open_video", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue()) {
                i = 8;
            } else {
                i = 0;
            }
            root.setVisibility(i);
        }
    }

    public final void refreshVote(@Nullable final MicBanner data) {
        final ConstraintLayout constraintLayout;
        ViewVoteLayoutBinding viewVoteLayoutBinding;
        QMUIRadiusImageView qMUIRadiusImageView;
        String str;
        ViewVoteLayoutBinding viewVoteLayoutBinding2;
        QMUIRadiusImageView qMUIRadiusImageView2;
        String str2;
        ViewVoteLayoutBinding viewVoteLayoutBinding3;
        QMUIRadiusImageView qMUIRadiusImageView3;
        String str3;
        TextView textView;
        int i;
        TextView textView2;
        QMUIRadiusImageView qMUIRadiusImageView4;
        String str4;
        if (data != null) {
            ViewVoteLayoutBinding viewVoteLayoutBinding4 = this.mVoteBinding;
            if (viewVoteLayoutBinding4 != null && (qMUIRadiusImageView4 = viewVoteLayoutBinding4.avatar) != null) {
                String myAvatar = data.getMyAvatar();
                if (myAvatar == null) {
                    str4 = "";
                } else {
                    str4 = myAvatar;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView4, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            ViewVoteLayoutBinding viewVoteLayoutBinding5 = this.mVoteBinding;
            if (viewVoteLayoutBinding5 != null && (textView2 = viewVoteLayoutBinding5.name) != null) {
                textView2.setText(data.getNick());
            }
            ViewVoteLayoutBinding viewVoteLayoutBinding6 = this.mVoteBinding;
            if (viewVoteLayoutBinding6 != null && (textView = viewVoteLayoutBinding6.voteNumber) != null) {
                Integer vote = data.getVote();
                if (vote != null) {
                    i = vote.intValue();
                } else {
                    i = 0;
                }
                textView.setText(String.valueOf(i));
            }
            String avatar1 = data.getAvatar1();
            if (avatar1 == null) {
                avatar1 = "";
            }
            if (!TextUtils.isEmpty(avatar1) && (viewVoteLayoutBinding3 = this.mVoteBinding) != null && (qMUIRadiusImageView3 = viewVoteLayoutBinding3.avatar1) != null) {
                String avatar12 = data.getAvatar1();
                if (avatar12 == null) {
                    str3 = "";
                } else {
                    str3 = avatar12;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView3, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            String avatar2 = data.getAvatar2();
            if (avatar2 == null) {
                avatar2 = "";
            }
            if (!TextUtils.isEmpty(avatar2) && (viewVoteLayoutBinding2 = this.mVoteBinding) != null && (qMUIRadiusImageView2 = viewVoteLayoutBinding2.avatar2) != null) {
                String avatar22 = data.getAvatar2();
                if (avatar22 == null) {
                    str2 = "";
                } else {
                    str2 = avatar22;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            String avatar3 = data.getAvatar3();
            if (avatar3 == null) {
                avatar3 = "";
            }
            if (!TextUtils.isEmpty(avatar3) && (viewVoteLayoutBinding = this.mVoteBinding) != null && (qMUIRadiusImageView = viewVoteLayoutBinding.avatar3) != null) {
                String avatar32 = data.getAvatar3();
                if (avatar32 == null) {
                    str = "";
                } else {
                    str = avatar32;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            ViewVoteLayoutBinding viewVoteLayoutBinding7 = this.mVoteBinding;
            if (viewVoteLayoutBinding7 != null && (constraintLayout = viewVoteLayoutBinding7.constraint) != null) {
                final long j = 800;
                constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.VoteHelper$refreshVote$lambda$2$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                            ConstraintLayout constraintLayout2 = constraintLayout;
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            String url = data.getUrl();
                            if (url == null) {
                                url = "";
                            }
                            baseControlUtils.openH5(url);
                        }
                    }
                });
            }
        }
        refreshView();
    }

    public final void removeVoteLayout() {
        RoomMessageViewBinding messageBinding;
        FrameLayout frameLayout;
        RoomMessageView mChatLayout = this.fragment.getMChatLayout();
        if (mChatLayout != null && (messageBinding = mChatLayout.messageBinding()) != null && (frameLayout = messageBinding.chatTopView) != null) {
            frameLayout.removeAllViews();
        }
    }

    public final void setMVoteBinding(@Nullable ViewVoteLayoutBinding viewVoteLayoutBinding) {
        this.mVoteBinding = viewVoteLayoutBinding;
    }
}
