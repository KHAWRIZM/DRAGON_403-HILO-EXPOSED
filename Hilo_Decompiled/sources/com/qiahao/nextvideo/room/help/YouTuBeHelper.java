package com.qiahao.nextvideo.room.help;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.Lifecycle;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.data.service.match.WebSocketProvide;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.databinding.ViewYouTuVideoBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.dialog.RoomTipDialog;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.viewmodel.RoomViewModel;
import com.qiahao.nextvideo.ui.youtu.YouTuRoomFragmentDialog;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.qiahao.nextvideo.view.youtube.YouTuBeSeekBar;
import com.qiahao.nextvideo.view.youtube.YouTubePlayerSeekBarListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010F\u001a\u00020GH\u0002J\u0014\u0010H\u001a\u00020G2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010JH\u0002J\u0006\u0010K\u001a\u00020GJ\u000e\u0010L\u001a\u00020G2\u0006\u0010M\u001a\u00020NJ\u0012\u0010O\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J\b\u0010P\u001a\u00020GH\u0002J\b\u0010Q\u001a\u0004\u0018\u00010RJ\u0006\u0010S\u001a\u00020GJ\u0006\u0010T\u001a\u00020GR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u001a\u00107\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\u001a\u0010:\u001a\u00020/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00101\"\u0004\b<\u00103R\u000e\u0010=\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006U"}, d2 = {"Lcom/qiahao/nextvideo/room/help/YouTuBeHelper;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "mRootView", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "getMRootView", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;", "setMRootView", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/views/YouTubePlayerView;)V", "mBinding", "Lcom/qiahao/nextvideo/databinding/ViewYouTuVideoBinding;", "getMBinding", "()Lcom/qiahao/nextvideo/databinding/ViewYouTuVideoBinding;", "setMBinding", "(Lcom/qiahao/nextvideo/databinding/ViewYouTuVideoBinding;)V", "mFadeViewHelper", "Lcom/qiahao/nextvideo/view/youtube/FadeViewHelper;", "mState", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "getMState", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "setMState", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;)V", "mYouTubePlayer", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "getMYouTubePlayer", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "setMYouTubePlayer", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;)V", "mPlayData", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "getMPlayData", "()Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "setMPlayData", "(Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;)V", "mCurrentSecond", "", "getMCurrentSecond", "()F", "setMCurrentSecond", "(F)V", "mHasInit", "", "getMHasInit", "()Z", "setMHasInit", "(Z)V", "mDelayPaused", "getMDelayPaused", "setMDelayPaused", "mHasPlay", "getMHasPlay", "setMHasPlay", "mOwnResume", "getMOwnResume", "setMOwnResume", "isHasAddVideo", "playerTracker", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/utils/YouTubePlayerTracker;", "mListener", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "getMListener", "()Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;", "setMListener", "(Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/AbstractYouTubePlayerListener;)V", "initView", "", "showVideoListDialog", "videoId", "", "resetVideoView", "synVideo", "state", "", "playVideo", "refreshVideoView", "addYouTuBeView", "Landroid/view/View;", "refreshGameData", "releaseGame", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuBeHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuBeHelper.kt\ncom/qiahao/nextvideo/room/help/YouTuBeHelper\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,446:1\n61#2,9:447\n61#2,9:456\n61#2,9:465\n61#2,9:474\n61#2,9:483\n61#2,9:492\n1#3:501\n51#4:502\n48#4:503\n*S KotlinDebug\n*F\n+ 1 YouTuBeHelper.kt\ncom/qiahao/nextvideo/room/help/YouTuBeHelper\n*L\n133#1:447,9\n143#1:456,9\n147#1:465,9\n182#1:474,9\n194#1:483,9\n210#1:492,9\n328#1:502\n335#1:503\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuBeHelper {

    @NotNull
    private final AudioRoomFragment fragment;
    private boolean isHasAddVideo;

    @Nullable
    private ViewYouTuVideoBinding mBinding;
    private float mCurrentSecond;
    private boolean mDelayPaused;

    @Nullable
    private FadeViewHelper mFadeViewHelper;
    private boolean mHasInit;
    private boolean mHasPlay;

    @NotNull
    private AbstractYouTubePlayerListener mListener;
    private boolean mOwnResume;

    @Nullable
    private YouTuBeData mPlayData;

    @Nullable
    private YouTubePlayerView mRootView;

    @Nullable
    private PlayerConstants.PlayerState mState;

    @Nullable
    private YouTubePlayer mYouTubePlayer;

    @NotNull
    private final YouTubePlayerTracker playerTracker;

    public YouTuBeHelper(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        this.playerTracker = new YouTubePlayerTracker();
        this.mListener = new YouTuBeHelper$mListener$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        final View view;
        YouTuBeSeekBar youTuBeSeekBar;
        final TextView textView;
        final ImageView imageView;
        final ImageView imageView2;
        final ImageView imageView3;
        final ImageView imageView4;
        YouTubePlayer youTubePlayer;
        YouTuBeSeekBar youTuBeSeekBar2;
        YouTubePlayer youTubePlayer2;
        ConstraintLayout constraintLayout;
        ViewYouTuVideoBinding viewYouTuVideoBinding = this.mBinding;
        if (viewYouTuVideoBinding != null && (constraintLayout = viewYouTuVideoBinding.constraint) != null) {
            this.mFadeViewHelper = new FadeViewHelper(constraintLayout);
        }
        YouTubePlayer youTubePlayer3 = this.mYouTubePlayer;
        if (youTubePlayer3 != null) {
            youTubePlayer3.addListener(this.playerTracker);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding2 = this.mBinding;
        if (viewYouTuVideoBinding2 != null && (youTuBeSeekBar2 = viewYouTuVideoBinding2.seekbar) != null && (youTubePlayer2 = this.mYouTubePlayer) != null) {
            youTubePlayer2.addListener(youTuBeSeekBar2);
        }
        FadeViewHelper fadeViewHelper = this.mFadeViewHelper;
        if (fadeViewHelper != null && (youTubePlayer = this.mYouTubePlayer) != null) {
            youTubePlayer.addListener(fadeViewHelper);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding3 = this.mBinding;
        final long j = 800;
        if (viewYouTuVideoBinding3 != null && (imageView4 = viewYouTuVideoBinding3.playPauseButton) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                        if (this.getMState() == PlayerConstants.PlayerState.PLAYING) {
                            YouTubePlayer mYouTubePlayer = this.getMYouTubePlayer();
                            if (mYouTubePlayer != null) {
                                mYouTubePlayer.pause();
                            }
                            this.synVideo(2);
                            return;
                        }
                        YouTubePlayer mYouTubePlayer2 = this.getMYouTubePlayer();
                        if (mYouTubePlayer2 != null) {
                            mYouTubePlayer2.play();
                        }
                        this.synVideo(1);
                    }
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding4 = this.mBinding;
        if (viewYouTuVideoBinding4 != null && (imageView3 = viewYouTuVideoBinding4.videoList) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                        YouTuBeHelper youTuBeHelper = this;
                        YouTuBeData mPlayData = youTuBeHelper.getMPlayData();
                        if (mPlayData != null) {
                            str = mPlayData.getVideoId();
                        } else {
                            str = null;
                        }
                        youTuBeHelper.showVideoListDialog(str);
                    }
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding5 = this.mBinding;
        if (viewYouTuVideoBinding5 != null && (imageView2 = viewYouTuVideoBinding5.addVideoIcon) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str;
                    String str2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                        YouTuGameData mYouTuBe = MeetingRoomManager.INSTANCE.getMYouTuBe();
                        if (mYouTuBe != null) {
                            str = mYouTuBe.getVideoUrl();
                        } else {
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            User user = UserStore.INSTANCE.getShared().getUser();
                            if (user == null || (str2 = user.getGroupId()) == null) {
                                str2 = "";
                            }
                            if (TextUtils.isEmpty(str2)) {
                                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.getFragment().getContext(), ResourcesKtxKt.getStringById(this, 2131953671), false, 4, (Object) null);
                                if (normal$default != null) {
                                    normal$default.show();
                                    return;
                                }
                                return;
                            }
                            final Context context = this.getFragment().getContext();
                            if (context != null) {
                                RoomTipDialog tipContent = new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131952334));
                                final YouTuBeHelper youTuBeHelper = this;
                                tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$6$1$1
                                    public void cancel() {
                                        OnCommonDialogListener.DefaultImpls.cancel(this);
                                    }

                                    public void confirm() {
                                        String str3;
                                        RoomViewModel mViewModel = YouTuBeHelper.this.getFragment().getMViewModel();
                                        YouTuGameData mYouTuBe2 = MeetingRoomManager.INSTANCE.getMYouTuBe();
                                        if (mYouTuBe2 == null || (str3 = mYouTuBe2.getVideoUrl()) == null) {
                                            str3 = "";
                                        }
                                        final Context context2 = context;
                                        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$6$1$1$confirm$1
                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m٦٢invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: collision with other method in class */
                                            public final void m٦٢invoke() {
                                                new RoomTipDialog(context2).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952908)).setCancelContent(ResourcesKtxKt.getStringById(this, 2131953200)).setTipContent(ResourcesKtxKt.getStringById(this, 2131951979)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$6$1$1$confirm$1.1
                                                    public void cancel() {
                                                        OnCommonDialogListener.DefaultImpls.cancel(this);
                                                    }

                                                    public void confirm() {
                                                        String str4;
                                                        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                                                        User user2 = UserStore.INSTANCE.getShared().getUser();
                                                        if (user2 == null || (str4 = user2.getGroupId()) == null) {
                                                            str4 = "";
                                                        }
                                                        StartRoomUtils.startRoom$default(startRoomUtils, str4, null, null, null, null, null, null, null, 0, 13, null, 0, false, 7678, null);
                                                    }
                                                }).show();
                                            }
                                        };
                                        final Context context3 = context;
                                        mViewModel.addVideoMyRoom(str3, function0, new Function1<Throwable, Unit>() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$6$1$1$confirm$2
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Throwable) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Throwable th) {
                                                Intrinsics.checkNotNullParameter(th, "it");
                                                if (th instanceof HiloException) {
                                                    HiloToasty.Companion companion = HiloToasty.Companion;
                                                    Context context4 = context3;
                                                    String errorMessage = ((HiloException) th).getErrorMessage();
                                                    if (errorMessage == null) {
                                                        errorMessage = ResourcesKtxKt.getStringById(this, 2131952667);
                                                    }
                                                    Toast normal$default2 = HiloToasty.Companion.normal$default(companion, context4, errorMessage, false, 4, (Object) null);
                                                    if (normal$default2 != null) {
                                                        normal$default2.show();
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }).show();
                            }
                        }
                    }
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding6 = this.mBinding;
        if (viewYouTuVideoBinding6 != null && (imageView = viewYouTuVideoBinding6.videoExit) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        Context context = this.getFragment().getContext();
                        if (context != null) {
                            RoomTipDialog tipContent = new RoomTipDialog(context).setTipContent(ResourcesKtxKt.getStringById(this, 2131954544));
                            final YouTuBeHelper youTuBeHelper = this;
                            tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$7$1$1
                                public void cancel() {
                                    OnCommonDialogListener.DefaultImpls.cancel(this);
                                }

                                public void confirm() {
                                    YouTuBeHelper.this.getFragment().getMViewModel().exitYouTuBe();
                                }
                            }).show();
                        }
                    }
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding7 = this.mBinding;
        if (viewYouTuVideoBinding7 != null && (textView = viewYouTuVideoBinding7.addVideo) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        YouTuBeHelper.showVideoListDialog$default(this, null, 1, null);
                    }
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding8 = this.mBinding;
        if (viewYouTuVideoBinding8 != null && (youTuBeSeekBar = viewYouTuVideoBinding8.seekbar) != null) {
            youTuBeSeekBar.setYoutubePlayerSeekBarListener(new YouTubePlayerSeekBarListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$9
                @Override // com.qiahao.nextvideo.view.youtube.YouTubePlayerSeekBarListener
                public void seekTo(float time) {
                    YouTuBeHelper.this.setMCurrentSecond(time);
                    YouTubePlayer mYouTubePlayer = YouTuBeHelper.this.getMYouTubePlayer();
                    if (mYouTubePlayer != null) {
                        mYouTubePlayer.seekTo(time);
                    }
                    if (YouTuBeHelper.this.getMState() == PlayerConstants.PlayerState.PAUSED) {
                        YouTuBeHelper.this.synVideo(2);
                    } else if (YouTuBeHelper.this.getMState() == PlayerConstants.PlayerState.PLAYING) {
                        YouTuBeHelper.this.synVideo(1);
                    }
                }
            });
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding9 = this.mBinding;
        if (viewYouTuVideoBinding9 != null && (view = viewYouTuVideoBinding9.panel) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.YouTuBeHelper$initView$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FadeViewHelper fadeViewHelper2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(view) > j || (view instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(view, currentTimeMillis);
                        fadeViewHelper2 = this.mFadeViewHelper;
                        if (fadeViewHelper2 != null) {
                            fadeViewHelper2.toggleVisibility();
                        }
                    }
                }
            });
        }
    }

    private final void playVideo(String videoId) {
        if (TextUtils.isEmpty(videoId)) {
            return;
        }
        this.isHasAddVideo = true;
        this.mCurrentSecond = 0.0f;
        Lifecycle lifecycle = this.fragment.getLifecycle();
        YouTubePlayer youTubePlayer = this.mYouTubePlayer;
        if (youTubePlayer != null) {
            Intrinsics.checkNotNull(lifecycle);
            if (videoId == null) {
                videoId = "";
            }
            YouTubePlayerUtils.loadOrCueVideo(youTubePlayer, lifecycle, videoId, 0.0f);
        }
        refreshVideoView();
    }

    private final void refreshVideoView() {
        View view;
        ImageView imageView;
        YouTuBeSeekBar youTuBeSeekBar;
        int i;
        boolean z;
        ImageView imageView2;
        int i2;
        ImageView imageView3;
        String str;
        int i3;
        String externalId;
        User owner;
        Group group;
        View view2;
        ImageView imageView4;
        YouTuBeSeekBar youTuBeSeekBar2;
        ImageView imageView5;
        ImageView imageView6;
        Group group2;
        ImageView imageView7;
        int i4;
        ViewYouTuVideoBinding viewYouTuVideoBinding = this.mBinding;
        int i5 = 0;
        if (viewYouTuVideoBinding != null && (imageView7 = viewYouTuVideoBinding.videoExit) != null) {
            if (MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            imageView7.setVisibility(i4);
        }
        if (!this.isHasAddVideo) {
            ViewYouTuVideoBinding viewYouTuVideoBinding2 = this.mBinding;
            if (viewYouTuVideoBinding2 != null && (group2 = viewYouTuVideoBinding2.addGroup) != null) {
                if (!MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
                    i5 = 8;
                }
                group2.setVisibility(i5);
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding3 = this.mBinding;
            if (viewYouTuVideoBinding3 != null && (imageView6 = viewYouTuVideoBinding3.videoList) != null) {
                imageView6.setVisibility(8);
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding4 = this.mBinding;
            if (viewYouTuVideoBinding4 != null && (imageView5 = viewYouTuVideoBinding4.addVideoIcon) != null) {
                imageView5.setVisibility(8);
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding5 = this.mBinding;
            if (viewYouTuVideoBinding5 != null && (youTuBeSeekBar2 = viewYouTuVideoBinding5.seekbar) != null) {
                youTuBeSeekBar2.setVisibility(8);
            }
            ViewYouTuVideoBinding viewYouTuVideoBinding6 = this.mBinding;
            if (viewYouTuVideoBinding6 != null && (imageView4 = viewYouTuVideoBinding6.playPauseButton) != null) {
                imageView4.setVisibility(8);
            }
            Context context = this.fragment.getContext();
            if (context != null) {
                int color = androidx.core.content.a.getColor(context, R.color.black);
                ViewYouTuVideoBinding viewYouTuVideoBinding7 = this.mBinding;
                if (viewYouTuVideoBinding7 != null && (view2 = viewYouTuVideoBinding7.panel) != null) {
                    view2.setBackgroundColor(color);
                    return;
                }
                return;
            }
            return;
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding8 = this.mBinding;
        if (viewYouTuVideoBinding8 != null && (group = viewYouTuVideoBinding8.addGroup) != null) {
            group.setVisibility(8);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding9 = this.mBinding;
        if (viewYouTuVideoBinding9 != null && (imageView3 = viewYouTuVideoBinding9.addVideoIcon) != null) {
            GroupDetailBean mGroupDetailBean = MeetingRoomManager.INSTANCE.getMGroupDetailBean();
            String str2 = "";
            if (mGroupDetailBean == null || (owner = mGroupDetailBean.getOwner()) == null || (str = owner.getExternalId()) == null) {
                str = "";
            }
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null && (externalId = user.getExternalId()) != null) {
                str2 = externalId;
            }
            if (Intrinsics.areEqual(str, str2)) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView3.setVisibility(i3);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding10 = this.mBinding;
        if (viewYouTuVideoBinding10 != null && (imageView2 = viewYouTuVideoBinding10.videoList) != null) {
            if (MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView2.setVisibility(i2);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding11 = this.mBinding;
        if (viewYouTuVideoBinding11 != null && (youTuBeSeekBar = viewYouTuVideoBinding11.seekbar) != null) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.checkOwnOrManager()) {
                YouTuGameData mYouTuBe = meetingRoomManager.getMYouTuBe();
                if (mYouTuBe != null) {
                    z = Intrinsics.areEqual(mYouTuBe.getLive(), Boolean.FALSE);
                } else {
                    z = false;
                }
                if (z) {
                    i = 0;
                    youTuBeSeekBar.setVisibility(i);
                }
            }
            i = 8;
            youTuBeSeekBar.setVisibility(i);
        }
        ViewYouTuVideoBinding viewYouTuVideoBinding12 = this.mBinding;
        if (viewYouTuVideoBinding12 != null && (imageView = viewYouTuVideoBinding12.playPauseButton) != null) {
            if (!MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
                i5 = 8;
            }
            imageView.setVisibility(i5);
        }
        Context context2 = this.fragment.getContext();
        if (context2 != null) {
            int color2 = androidx.core.content.a.getColor(context2, R.color.transparent);
            ViewYouTuVideoBinding viewYouTuVideoBinding13 = this.mBinding;
            if (viewYouTuVideoBinding13 != null && (view = viewYouTuVideoBinding13.panel) != null) {
                view.setBackgroundColor(color2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showVideoListDialog(String videoId) {
        YouTuRoomFragmentDialog youTuRoomFragmentDialog = new YouTuRoomFragmentDialog(videoId);
        youTuRoomFragmentDialog.setMListener(new Function1() { // from class: com.qiahao.nextvideo.room.help.y8
            public final Object invoke(Object obj) {
                Unit showVideoListDialog$lambda$12$lambda$11;
                showVideoListDialog$lambda$12$lambda$11 = YouTuBeHelper.showVideoListDialog$lambda$12$lambda$11(YouTuBeHelper.this, (YouTuBeData) obj);
                return showVideoListDialog$lambda$12$lambda$11;
            }
        });
        youTuRoomFragmentDialog.show(this.fragment.getChildFragmentManager(), "YouTuRoomFragmentDialog");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showVideoListDialog$default(YouTuBeHelper youTuBeHelper, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        youTuBeHelper.showVideoListDialog(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showVideoListDialog$lambda$12$lambda$11(YouTuBeHelper youTuBeHelper, YouTuBeData youTuBeData) {
        String str;
        String str2;
        String str3;
        String externalId;
        String videoId;
        String str4 = null;
        if (youTuBeData == null) {
            if (MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
                YouTuBeData youTuBeData2 = youTuBeHelper.mPlayData;
                if (youTuBeData2 != null) {
                    str = youTuBeData2.getVideoId();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
                    YouTuBeData youTuBeData3 = youTuBeHelper.mPlayData;
                    if (youTuBeData3 == null || (videoId = youTuBeData3.getVideoId()) == null) {
                        str2 = "";
                    } else {
                        str2 = videoId;
                    }
                    YouTuBeData youTuBeData4 = youTuBeHelper.mPlayData;
                    if (youTuBeData4 != null) {
                        str4 = youTuBeData4.getVideoUrl();
                    }
                    String str5 = str4;
                    int i = (int) youTuBeHelper.mCurrentSecond;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user == null || (externalId = user.getExternalId()) == null) {
                        str3 = "";
                    } else {
                        str3 = externalId;
                    }
                    webSocketProvide.youtubeVideoSync(new YouTuGameData(str2, Integer.valueOf(i), null, 3, str5, null, false, str3, null, 356, null));
                }
            }
            youTuBeHelper.resetVideoView();
        } else {
            String videoId2 = youTuBeData.getVideoId();
            YouTuBeData youTuBeData5 = youTuBeHelper.mPlayData;
            if (youTuBeData5 != null) {
                str4 = youTuBeData5.getVideoId();
            }
            if (!Intrinsics.areEqual(videoId2, str4)) {
                youTuBeHelper.mPlayData = youTuBeData;
                youTuBeHelper.playVideo(youTuBeData.getVideoId());
                youTuBeHelper.synVideo(1);
            }
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final View addYouTuBeView() {
        FrameLayout frameLayout;
        Context context;
        ViewGroup.LayoutParams layoutParams;
        TextView textView;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        View view;
        FragmentAudioRoomBinding binding;
        FrameLayout frameLayout4;
        FrameLayout frameLayout5;
        FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
        if (binding2 != null && (frameLayout3 = binding2.gameLayout) != null && frameLayout3.getChildCount() != 0) {
            FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
            if (binding3 != null && (frameLayout5 = binding3.gameLayout) != null) {
                view = frameLayout5.getChildAt(0);
            } else {
                view = null;
            }
            if (!Intrinsics.areEqual(view, this.mRootView) && (binding = this.fragment.getBinding()) != null && (frameLayout4 = binding.gameLayout) != null) {
                frameLayout4.removeAllViews();
            }
        }
        FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
        if (binding4 != null && (frameLayout = binding4.gameLayout) != null && frameLayout.getChildCount() == 0 && this.mRootView == null && (context = this.fragment.getContext()) != null) {
            YouTubePlayerView youTubePlayerView = new YouTubePlayerView(context);
            youTubePlayerView.setEnableAutomaticInitialization(false);
            this.mRootView = youTubePlayerView;
            FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
            if (binding5 != null && (frameLayout2 = binding5.gameLayout) != null) {
                frameLayout2.addView(this.mRootView);
            }
            YouTubePlayerView youTubePlayerView2 = this.mRootView;
            if (youTubePlayerView2 != null) {
                layoutParams = youTubePlayerView2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = -1;
            layoutParams2.width = -1;
            layoutParams2.gravity = 17;
            YouTubePlayerView youTubePlayerView3 = this.mRootView;
            if (youTubePlayerView3 != null) {
                youTubePlayerView3.setLayoutParams(layoutParams2);
            }
            YouTubePlayerView youTubePlayerView4 = this.mRootView;
            if (youTubePlayerView4 != null) {
                Lifecycle myLifecycle = this.fragment.getMyLifecycle();
                if (myLifecycle != null) {
                    myLifecycle.addObserver(youTubePlayerView4);
                }
                ViewYouTuVideoBinding viewYouTuVideoBinding = (ViewYouTuVideoBinding) androidx.databinding.g.h(LayoutInflater.from(context), com.qiahao.nextvideo.R.layout.view_you_tu_video, (ViewGroup) null, false);
                View root = viewYouTuVideoBinding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                youTubePlayerView4.setCustomPlayerUi(root);
                this.mBinding = viewYouTuVideoBinding;
                if (viewYouTuVideoBinding != null && (textView = viewYouTuVideoBinding.addVideo) != null) {
                    textView.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#750FF2", "#A359FF", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
                }
            }
            IFramePlayerOptions build = new IFramePlayerOptions.Builder(context).controls(0).rel(0).ivLoadPolicy(3).ccLoadPolicy(1).modestBranding(1).build();
            YouTubePlayerView youTubePlayerView5 = this.mRootView;
            if (youTubePlayerView5 != null) {
                youTubePlayerView5.initialize(this.mListener, build);
            }
        }
        return this.mRootView;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final ViewYouTuVideoBinding getMBinding() {
        return this.mBinding;
    }

    public final float getMCurrentSecond() {
        return this.mCurrentSecond;
    }

    public final boolean getMDelayPaused() {
        return this.mDelayPaused;
    }

    public final boolean getMHasInit() {
        return this.mHasInit;
    }

    public final boolean getMHasPlay() {
        return this.mHasPlay;
    }

    @NotNull
    public final AbstractYouTubePlayerListener getMListener() {
        return this.mListener;
    }

    public final boolean getMOwnResume() {
        return this.mOwnResume;
    }

    @Nullable
    public final YouTuBeData getMPlayData() {
        return this.mPlayData;
    }

    @Nullable
    public final YouTubePlayerView getMRootView() {
        return this.mRootView;
    }

    @Nullable
    public final PlayerConstants.PlayerState getMState() {
        return this.mState;
    }

    @Nullable
    public final YouTubePlayer getMYouTubePlayer() {
        return this.mYouTubePlayer;
    }

    public final void refreshGameData() {
        Integer type;
        float f;
        Integer currentTime;
        String videoId;
        Integer currentTime2;
        YouTuGameData mYouTuBe;
        Integer type2;
        Integer currentTime3;
        String videoId2;
        YouTuGameData mYouTuBe2;
        String str;
        String str2;
        if (!this.mHasInit) {
            this.mHasPlay = true;
            if (this.mFadeViewHelper == null) {
                initView();
                refreshVideoView();
                return;
            }
            return;
        }
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.checkOwnOrManager()) {
            YouTuGameData mYouTuBe3 = meetingRoomManager.getMYouTuBe();
            String str3 = null;
            if (mYouTuBe3 != null) {
                str = mYouTuBe3.getVideoId();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                YouTuBeData youTuBeData = new YouTuBeData(null, null, null, null, null, null, null, 127, null);
                this.mPlayData = youTuBeData;
                YouTuGameData mYouTuBe4 = meetingRoomManager.getMYouTuBe();
                if (mYouTuBe4 != null) {
                    str2 = mYouTuBe4.getVideoId();
                } else {
                    str2 = null;
                }
                youTuBeData.setVideoId(str2);
                YouTuBeData youTuBeData2 = this.mPlayData;
                if (youTuBeData2 != null) {
                    YouTuGameData mYouTuBe5 = meetingRoomManager.getMYouTuBe();
                    if (mYouTuBe5 != null) {
                        str3 = mYouTuBe5.getVideoUrl();
                    }
                    youTuBeData2.setVideoUrl(str3);
                }
            }
        }
        YouTuGameData mYouTuBe6 = meetingRoomManager.getMYouTuBe();
        String str4 = "";
        float f2 = 0.0f;
        if (mYouTuBe6 != null && (type2 = mYouTuBe6.getType()) != null && type2.intValue() == 1) {
            if (this.isHasAddVideo && (mYouTuBe2 = meetingRoomManager.getMYouTuBe()) != null && mYouTuBe2.checkMe() && !this.mOwnResume) {
                return;
            }
            this.mDelayPaused = false;
            this.mOwnResume = false;
            this.isHasAddVideo = true;
            Lifecycle lifecycle = this.fragment.getLifecycle();
            YouTubePlayer youTubePlayer = this.mYouTubePlayer;
            if (youTubePlayer != null) {
                Intrinsics.checkNotNull(lifecycle);
                YouTuGameData mYouTuBe7 = meetingRoomManager.getMYouTuBe();
                if (mYouTuBe7 != null && (videoId2 = mYouTuBe7.getVideoId()) != null) {
                    str4 = videoId2;
                }
                YouTuGameData mYouTuBe8 = meetingRoomManager.getMYouTuBe();
                if (mYouTuBe8 != null && (currentTime3 = mYouTuBe8.getCurrentTime()) != null) {
                    f2 = currentTime3.intValue();
                }
                YouTubePlayerUtils.loadOrCueVideo(youTubePlayer, lifecycle, str4, f2);
            }
        } else {
            YouTuGameData mYouTuBe9 = meetingRoomManager.getMYouTuBe();
            if (mYouTuBe9 != null && (type = mYouTuBe9.getType()) != null && type.intValue() == 2) {
                if (this.isHasAddVideo && (mYouTuBe = meetingRoomManager.getMYouTuBe()) != null && mYouTuBe.checkMe()) {
                    return;
                }
                if (this.mState == PlayerConstants.PlayerState.PLAYING) {
                    YouTubePlayer youTubePlayer2 = this.mYouTubePlayer;
                    if (youTubePlayer2 != null) {
                        youTubePlayer2.pause();
                    }
                } else {
                    Lifecycle lifecycle2 = this.fragment.getLifecycle();
                    this.mOwnResume = false;
                    this.isHasAddVideo = true;
                    this.mDelayPaused = true;
                    YouTuGameData mYouTuBe10 = meetingRoomManager.getMYouTuBe();
                    if (mYouTuBe10 != null && (currentTime2 = mYouTuBe10.getCurrentTime()) != null) {
                        f = currentTime2.intValue();
                    } else {
                        f = 0.0f;
                    }
                    this.mCurrentSecond = f;
                    YouTubePlayer youTubePlayer3 = this.mYouTubePlayer;
                    if (youTubePlayer3 != null) {
                        Intrinsics.checkNotNull(lifecycle2);
                        YouTuGameData mYouTuBe11 = meetingRoomManager.getMYouTuBe();
                        if (mYouTuBe11 != null && (videoId = mYouTuBe11.getVideoId()) != null) {
                            str4 = videoId;
                        }
                        YouTuGameData mYouTuBe12 = meetingRoomManager.getMYouTuBe();
                        if (mYouTuBe12 != null && (currentTime = mYouTuBe12.getCurrentTime()) != null) {
                            f2 = currentTime.intValue();
                        }
                        YouTubePlayerUtils.loadOrCueVideo(youTubePlayer3, lifecycle2, str4, f2);
                    }
                }
            }
        }
        refreshVideoView();
    }

    public final void releaseGame() {
        FrameLayout frameLayout;
        Lifecycle myLifecycle;
        YouTubePlayerView youTubePlayerView = this.mRootView;
        if (youTubePlayerView != null) {
            youTubePlayerView.release();
        }
        YouTubePlayerView youTubePlayerView2 = this.mRootView;
        if (youTubePlayerView2 != null && (myLifecycle = this.fragment.getMyLifecycle()) != null) {
            myLifecycle.removeObserver(youTubePlayerView2);
        }
        YouTubePlayerView youTubePlayerView3 = this.mRootView;
        if (youTubePlayerView3 != null) {
            youTubePlayerView3.removeYouTubePlayerListener(this.mListener);
        }
        this.mRootView = null;
        ViewYouTuVideoBinding viewYouTuVideoBinding = this.mBinding;
        if (viewYouTuVideoBinding != null) {
            viewYouTuVideoBinding.unbind();
        }
        this.mBinding = null;
        this.mFadeViewHelper = null;
        this.mState = null;
        this.mYouTubePlayer = null;
        this.mPlayData = null;
        this.mCurrentSecond = 0.0f;
        this.mHasInit = false;
        this.mHasPlay = false;
        this.isHasAddVideo = false;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout = binding.gameLayout) != null) {
            frameLayout.removeAllViews();
        }
    }

    public final void resetVideoView() {
        FrameLayout frameLayout;
        Lifecycle myLifecycle;
        YouTubePlayerView youTubePlayerView = this.mRootView;
        if (youTubePlayerView != null) {
            youTubePlayerView.release();
        }
        YouTubePlayerView youTubePlayerView2 = this.mRootView;
        if (youTubePlayerView2 != null && (myLifecycle = this.fragment.getMyLifecycle()) != null) {
            myLifecycle.removeObserver(youTubePlayerView2);
        }
        YouTubePlayerView youTubePlayerView3 = this.mRootView;
        if (youTubePlayerView3 != null) {
            youTubePlayerView3.removeYouTubePlayerListener(this.mListener);
        }
        this.mRootView = null;
        ViewYouTuVideoBinding viewYouTuVideoBinding = this.mBinding;
        if (viewYouTuVideoBinding != null) {
            viewYouTuVideoBinding.unbind();
        }
        this.mBinding = null;
        this.mFadeViewHelper = null;
        this.mState = null;
        this.mYouTubePlayer = null;
        this.mPlayData = null;
        this.mCurrentSecond = 0.0f;
        this.mHasInit = false;
        this.mHasPlay = false;
        this.isHasAddVideo = false;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout = binding.gameLayout) != null) {
            frameLayout.removeAllViews();
        }
    }

    public final void setMBinding(@Nullable ViewYouTuVideoBinding viewYouTuVideoBinding) {
        this.mBinding = viewYouTuVideoBinding;
    }

    public final void setMCurrentSecond(float f) {
        this.mCurrentSecond = f;
    }

    public final void setMDelayPaused(boolean z) {
        this.mDelayPaused = z;
    }

    public final void setMHasInit(boolean z) {
        this.mHasInit = z;
    }

    public final void setMHasPlay(boolean z) {
        this.mHasPlay = z;
    }

    public final void setMListener(@NotNull AbstractYouTubePlayerListener abstractYouTubePlayerListener) {
        Intrinsics.checkNotNullParameter(abstractYouTubePlayerListener, "<set-?>");
        this.mListener = abstractYouTubePlayerListener;
    }

    public final void setMOwnResume(boolean z) {
        this.mOwnResume = z;
    }

    public final void setMPlayData(@Nullable YouTuBeData youTuBeData) {
        this.mPlayData = youTuBeData;
    }

    public final void setMRootView(@Nullable YouTubePlayerView youTubePlayerView) {
        this.mRootView = youTubePlayerView;
    }

    public final void setMState(@Nullable PlayerConstants.PlayerState playerState) {
        this.mState = playerState;
    }

    public final void setMYouTubePlayer(@Nullable YouTubePlayer youTubePlayer) {
        this.mYouTubePlayer = youTubePlayer;
    }

    public final void synVideo(int state) {
        String str;
        String str2;
        String str3;
        String externalId;
        String videoId;
        if (MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
            YouTuBeData youTuBeData = this.mPlayData;
            String str4 = null;
            if (youTuBeData != null) {
                str = youTuBeData.getVideoId();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                WebSocketProvide webSocketProvide = WebSocketProvide.INSTANCE;
                YouTuBeData youTuBeData2 = this.mPlayData;
                if (youTuBeData2 == null || (videoId = youTuBeData2.getVideoId()) == null) {
                    str2 = "";
                } else {
                    str2 = videoId;
                }
                YouTuBeData youTuBeData3 = this.mPlayData;
                if (youTuBeData3 != null) {
                    str4 = youTuBeData3.getVideoUrl();
                }
                String str5 = str4;
                int i = (int) this.mCurrentSecond;
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user == null || (externalId = user.getExternalId()) == null) {
                    str3 = "";
                } else {
                    str3 = externalId;
                }
                webSocketProvide.youtubeVideoSync(new YouTuGameData(str2, Integer.valueOf(i), null, Integer.valueOf(state), str5, null, false, str3, null, 356, null));
            }
        }
    }
}
