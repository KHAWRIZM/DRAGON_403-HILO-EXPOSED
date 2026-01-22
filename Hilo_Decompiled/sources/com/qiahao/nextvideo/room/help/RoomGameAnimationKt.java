package com.qiahao.nextvideo.room.help;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.databinding.AudioHiloGameBinding;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.databinding.ViewGamePkBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.room.view.micro.PKMicroView;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import com.qiahao.nextvideo.view.PKButtonView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002¨\u0006\f"}, d2 = {"showHiloGameView", "", "Lcom/qiahao/nextvideo/room/help/AudioGameHelp;", "hideHiloGameView", "complete", "Lkotlin/Function0;", "showPKGameView", "hidePKGameView", "showSUDGameView", "hideSUDGameView", "hideGameChat", "showGameChat", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomGameAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomGameAnimation.kt\ncom/qiahao/nextvideo/room/help/RoomGameAnimationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomGameAnimationKt {
    public static final void hideGameChat(@NotNull final AudioGameHelp audioGameHelp) {
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            audioGameHelp.setChatAnimatorSetHide(new AnimatorSet());
            AnimatorSet chatAnimatorSetHide = audioGameHelp.getChatAnimatorSetHide();
            if (chatAnimatorSetHide != null) {
                chatAnimatorSetHide.setDuration(300L);
            }
            AnimatorSet chatAnimatorSetHide2 = audioGameHelp.getChatAnimatorSetHide();
            if (chatAnimatorSetHide2 != null) {
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                FrameLayout frameLayout = binding.gameChatLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "gameChatLayout");
                ObjectAnimator translationY = animationUtility.translationY(frameLayout, 0, binding.gameChatLayout.getHeight());
                FrameLayout frameLayout2 = binding.gameChatLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "gameChatLayout");
                chatAnimatorSetHide2.playTogether(translationY, animationUtility.alpha(frameLayout2, false));
            }
            AnimatorSet chatAnimatorSetHide3 = audioGameHelp.getChatAnimatorSetHide();
            if (chatAnimatorSetHide3 != null) {
                chatAnimatorSetHide3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$hideGameChat$1$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        BaseActivity activity = HiloUtils.INSTANCE.getActivity(AudioGameHelp.this.getFragment().getActivity());
                        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                            binding.gameChatLayout.setVisibility(8);
                            binding.gameChatLayout.removeAllViews();
                            AudioGameHelp.this.getFragment().initChatLayout();
                            AudioGameHelp mGameHelp = AudioGameHelp.this.getFragment().getMGameHelp();
                            if (mGameHelp != null && mGameHelp.isPlayGame()) {
                                binding.showChat.setVisibility(0);
                            } else {
                                binding.showChat.setVisibility(8);
                            }
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }
                });
            }
            AnimatorSet chatAnimatorSetHide4 = audioGameHelp.getChatAnimatorSetHide();
            if (chatAnimatorSetHide4 != null) {
                chatAnimatorSetHide4.start();
            }
        }
    }

    public static final void hideHiloGameView(@NotNull final AudioGameHelp audioGameHelp, @Nullable final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            MeetingRoomManager.INSTANCE.setMHiloGameConfiguration(null);
            audioGameHelp.setBg(false, audioGameHelp.getShowGameType());
            audioGameHelp.setHiloGameAnimatorSetHide(new AnimatorSet());
            AnimatorSet hiloGameAnimatorSetHide = audioGameHelp.getHiloGameAnimatorSetHide();
            if (hiloGameAnimatorSetHide != null) {
                hiloGameAnimatorSetHide.setDuration(500L);
            }
            AudioHiloGameBinding binding2 = audioGameHelp.getMHiloGameHelp().getBinding();
            if (binding2 != null) {
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                View root = binding2.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ObjectAnimator alpha = animationUtility.alpha(root, false);
                alpha.setInterpolator(new TimeInterpolator() { // from class: com.qiahao.nextvideo.room.help.l8
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float hideHiloGameView$lambda$5$lambda$4$lambda$3;
                        hideHiloGameView$lambda$5$lambda$4$lambda$3 = RoomGameAnimationKt.hideHiloGameView$lambda$5$lambda$4$lambda$3(FragmentAudioRoomBinding.this, audioGameHelp, f);
                        return hideHiloGameView$lambda$5$lambda$4$lambda$3;
                    }
                });
                AnimatorSet hiloGameAnimatorSetHide2 = audioGameHelp.getHiloGameAnimatorSetHide();
                if (hiloGameAnimatorSetHide2 != null) {
                    NewMicroView newMicroView = binding.microView;
                    Intrinsics.checkNotNullExpressionValue(newMicroView, "microView");
                    ObjectAnimator scaleY = animationUtility.scaleY(newMicroView, true);
                    NewMicroView newMicroView2 = binding.microView;
                    Intrinsics.checkNotNullExpressionValue(newMicroView2, "microView");
                    ObjectAnimator scaleX = animationUtility.scaleX(newMicroView2, true);
                    NewMicroView newMicroView3 = binding.microView;
                    Intrinsics.checkNotNullExpressionValue(newMicroView3, "microView");
                    ObjectAnimator alpha2 = animationUtility.alpha(newMicroView3, true);
                    FrameLayout frameLayout = binding.gameLayout;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "gameLayout");
                    ObjectAnimator alpha3 = animationUtility.alpha(frameLayout, false);
                    AppCompatImageView appCompatImageView = binding.changeGameModel;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "changeGameModel");
                    ObjectAnimator alpha4 = animationUtility.alpha(appCompatImageView, false);
                    ConstraintLayout constraintLayout = binding.playLayout;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "playLayout");
                    ObjectAnimator translationY = animationUtility.translationY(constraintLayout, binding.playLayout.getHeight() + UiKtxKt.toPX(66), 0);
                    ConstraintLayout constraintLayout2 = binding.playLayout;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout2, "playLayout");
                    ObjectAnimator alpha5 = animationUtility.alpha(constraintLayout2, true);
                    ImageView imageView = binding.showChat;
                    Intrinsics.checkNotNullExpressionValue(imageView, "showChat");
                    hiloGameAnimatorSetHide2.playTogether(alpha, scaleY, scaleX, alpha2, alpha3, alpha4, translationY, alpha5, animationUtility.alpha(imageView, false));
                }
                AnimatorSet hiloGameAnimatorSetHide3 = audioGameHelp.getHiloGameAnimatorSetHide();
                if (hiloGameAnimatorSetHide3 != null) {
                    hiloGameAnimatorSetHide3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$hideHiloGameView$1$1$2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            NewMicroView newMicroView4;
                            VoteHelper voteHelper;
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            ViewGroup.LayoutParams layoutParams = FragmentAudioRoomBinding.this.gameLayout.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
                            ((ConstraintLayout.b) layoutParams2).j = FragmentAudioRoomBinding.this.gameRecycleView.getId();
                            FragmentAudioRoomBinding.this.gameLayout.setLayoutParams(layoutParams2);
                            FragmentAudioRoomBinding.this.gameLayout.setVisibility(8);
                            FragmentAudioRoomBinding.this.microView.recoverMicSVGA();
                            audioGameHelp.getMHiloGameHelp().removeHiloGameView();
                            AudioRoomFragmentHelp mAudioHelp = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp != null) {
                                mAudioHelp.checkPlayLayout();
                            }
                            FragmentAudioRoomBinding.this.showChat.setVisibility(8);
                            Function0<Unit> function02 = function0;
                            if (function02 != null) {
                                function02.invoke();
                            }
                            AudioRoomFragmentHelp mAudioHelp2 = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp2 != null && (voteHelper = mAudioHelp2.getVoteHelper()) != null) {
                                voteHelper.refreshView();
                            }
                            FragmentAudioRoomBinding.this.changeGameModel.setVisibility(8);
                            FragmentAudioRoomBinding binding3 = audioGameHelp.getFragment().getBinding();
                            if (binding3 != null && (newMicroView4 = binding3.microView) != null) {
                                newMicroView4.notificationMicChange();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            FragmentAudioRoomBinding.this.microView.setVisibility(0);
                            FragmentAudioRoomBinding.this.playLayout.setVisibility(0);
                        }
                    });
                }
            }
            AnimatorSet hiloGameAnimatorSetHide4 = audioGameHelp.getHiloGameAnimatorSetHide();
            if (hiloGameAnimatorSetHide4 != null) {
                hiloGameAnimatorSetHide4.start();
            }
        }
    }

    public static /* synthetic */ void hideHiloGameView$default(AudioGameHelp audioGameHelp, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        hideHiloGameView(audioGameHelp, function0);
    }

    public static final float hideHiloGameView$lambda$5$lambda$4$lambda$3(FragmentAudioRoomBinding fragmentAudioRoomBinding, AudioGameHelp audioGameHelp, float f) {
        ViewGroup.LayoutParams layoutParams = fragmentAudioRoomBinding.gameLayout.getLayoutParams();
        layoutParams.height = audioGameHelp.getMHiloGameHelp().getMDefaultViewHeight() + ((int) (audioGameHelp.getMHiloGameHelp().getMViewChangeHeight() * (1 - f)));
        fragmentAudioRoomBinding.gameLayout.setLayoutParams(layoutParams);
        return f;
    }

    public static final void hidePKGameView(@NotNull final AudioGameHelp audioGameHelp, @Nullable final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            audioGameHelp.setPkAnimatorSetHide(new AnimatorSet());
            AnimatorSet pkAnimatorSetHide = audioGameHelp.getPkAnimatorSetHide();
            if (pkAnimatorSetHide != null) {
                pkAnimatorSetHide.setDuration(300L);
            }
            final ViewGamePkBinding binding2 = audioGameHelp.getMPKGameHelp().getBinding();
            if (binding2 != null) {
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                PKButtonView pKButtonView = binding2.button;
                Intrinsics.checkNotNullExpressionValue(pKButtonView, "button");
                ObjectAnimator alpha = animationUtility.alpha(pKButtonView, false);
                alpha.setInterpolator(new TimeInterpolator() { // from class: com.qiahao.nextvideo.room.help.k8
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float hidePKGameView$lambda$11$lambda$10$lambda$9;
                        hidePKGameView$lambda$11$lambda$10$lambda$9 = RoomGameAnimationKt.hidePKGameView$lambda$11$lambda$10$lambda$9(FragmentAudioRoomBinding.this, audioGameHelp, f);
                        return hidePKGameView$lambda$11$lambda$10$lambda$9;
                    }
                });
                if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                    AnimatorSet pkAnimatorSetHide2 = audioGameHelp.getPkAnimatorSetHide();
                    if (pkAnimatorSetHide2 != null) {
                        PKMicroView pKMicroView = binding2.leftMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView, "leftMic");
                        ObjectAnimator translationX = animationUtility.translationX(pKMicroView, 0, binding.centerLayout.getWidth() / 2);
                        PKMicroView pKMicroView2 = binding2.rightMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView2, "rightMic");
                        ObjectAnimator translationX2 = animationUtility.translationX(pKMicroView2, 0, (-binding.centerLayout.getWidth()) / 2);
                        NewMicroView newMicroView = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView, "microView");
                        ObjectAnimator scaleY = animationUtility.scaleY(newMicroView, true);
                        NewMicroView newMicroView2 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView2, "microView");
                        ObjectAnimator scaleX = animationUtility.scaleX(newMicroView2, true);
                        NewMicroView newMicroView3 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView3, "microView");
                        ObjectAnimator alpha2 = animationUtility.alpha(newMicroView3, true);
                        FrameLayout frameLayout = binding.gameLayout;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "gameLayout");
                        ObjectAnimator alpha3 = animationUtility.alpha(frameLayout, false);
                        TextView textView = binding2.time;
                        Intrinsics.checkNotNullExpressionValue(textView, AgooConstants.MESSAGE_TIME);
                        ObjectAnimator alpha4 = animationUtility.alpha(textView, false);
                        View root = binding2.redGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                        ObjectAnimator alpha5 = animationUtility.alpha(root, false);
                        View root2 = binding2.blueGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                        pkAnimatorSetHide2.playTogether(translationX, translationX2, alpha, scaleY, scaleX, alpha2, alpha3, alpha4, alpha5, animationUtility.alpha(root2, false));
                    }
                } else {
                    AnimatorSet pkAnimatorSetHide3 = audioGameHelp.getPkAnimatorSetHide();
                    if (pkAnimatorSetHide3 != null) {
                        PKMicroView pKMicroView3 = binding2.leftMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView3, "leftMic");
                        ObjectAnimator translationX3 = animationUtility.translationX(pKMicroView3, 0, (-binding.centerLayout.getWidth()) / 2);
                        PKMicroView pKMicroView4 = binding2.rightMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView4, "rightMic");
                        ObjectAnimator translationX4 = animationUtility.translationX(pKMicroView4, 0, binding.centerLayout.getWidth() / 2);
                        NewMicroView newMicroView4 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView4, "microView");
                        ObjectAnimator scaleY2 = animationUtility.scaleY(newMicroView4, true);
                        NewMicroView newMicroView5 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView5, "microView");
                        ObjectAnimator scaleX2 = animationUtility.scaleX(newMicroView5, true);
                        NewMicroView newMicroView6 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView6, "microView");
                        ObjectAnimator alpha6 = animationUtility.alpha(newMicroView6, true);
                        FrameLayout frameLayout2 = binding.gameLayout;
                        Intrinsics.checkNotNullExpressionValue(frameLayout2, "gameLayout");
                        ObjectAnimator alpha7 = animationUtility.alpha(frameLayout2, false);
                        TextView textView2 = binding2.time;
                        Intrinsics.checkNotNullExpressionValue(textView2, AgooConstants.MESSAGE_TIME);
                        ObjectAnimator alpha8 = animationUtility.alpha(textView2, false);
                        View root3 = binding2.redGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
                        ObjectAnimator alpha9 = animationUtility.alpha(root3, false);
                        View root4 = binding2.blueGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
                        pkAnimatorSetHide3.playTogether(translationX3, translationX4, alpha, scaleY2, scaleX2, alpha6, alpha7, alpha8, alpha9, animationUtility.alpha(root4, false));
                    }
                }
                AnimatorSet pkAnimatorSetHide4 = audioGameHelp.getPkAnimatorSetHide();
                if (pkAnimatorSetHide4 != null) {
                    pkAnimatorSetHide4.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$hidePKGameView$1$1$2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            VoteHelper voteHelper;
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            binding2.time.setVisibility(8);
                            binding2.redGo.getRoot().setVisibility(8);
                            binding2.blueGo.getRoot().setVisibility(8);
                            ViewGroup.LayoutParams layoutParams = FragmentAudioRoomBinding.this.gameLayout.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
                            ((ConstraintLayout.b) layoutParams2).j = FragmentAudioRoomBinding.this.gameRecycleView.getId();
                            FragmentAudioRoomBinding.this.gameLayout.setLayoutParams(layoutParams2);
                            FragmentAudioRoomBinding.this.gameLayout.setVisibility(8);
                            FragmentAudioRoomBinding.this.microView.recoverMicSVGA();
                            audioGameHelp.getMPKGameHelp().removePKView();
                            AudioRoomFragmentHelp mAudioHelp = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp != null) {
                                mAudioHelp.checkPlayLayout();
                            }
                            Function0<Unit> function02 = function0;
                            if (function02 != null) {
                                function02.invoke();
                            }
                            AudioRoomFragmentHelp mAudioHelp2 = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp2 != null && (voteHelper = mAudioHelp2.getVoteHelper()) != null) {
                                voteHelper.refreshView();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            FragmentAudioRoomBinding.this.microView.setVisibility(0);
                        }
                    });
                }
            }
            AnimatorSet pkAnimatorSetHide5 = audioGameHelp.getPkAnimatorSetHide();
            if (pkAnimatorSetHide5 != null) {
                pkAnimatorSetHide5.start();
            }
        }
    }

    public static /* synthetic */ void hidePKGameView$default(AudioGameHelp audioGameHelp, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        hidePKGameView(audioGameHelp, function0);
    }

    public static final float hidePKGameView$lambda$11$lambda$10$lambda$9(FragmentAudioRoomBinding fragmentAudioRoomBinding, AudioGameHelp audioGameHelp, float f) {
        ViewGroup.LayoutParams layoutParams = fragmentAudioRoomBinding.gameLayout.getLayoutParams();
        layoutParams.height = audioGameHelp.getMPKGameHelp().getMDefaultViewHeight() + ((int) (audioGameHelp.getMPKGameHelp().getMViewChangeHeight() * (1 - f)));
        fragmentAudioRoomBinding.gameLayout.setLayoutParams(layoutParams);
        return f;
    }

    public static final void hideSUDGameView(@NotNull final AudioGameHelp audioGameHelp, @Nullable final Function0<Unit> function0) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3;
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        hideGameChat(audioGameHelp);
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            audioGameHelp.setSudAnimatorSetHide(new AnimatorSet());
            AnimationUtility animationUtility = AnimationUtility.INSTANCE;
            FrameLayout frameLayout = binding.gameLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "gameLayout");
            ObjectAnimator alpha = animationUtility.alpha(frameLayout, false);
            alpha.setInterpolator(new TimeInterpolator() { // from class: com.qiahao.nextvideo.room.help.m8
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f) {
                    float hideSUDGameView$lambda$23$lambda$18;
                    hideSUDGameView$lambda$23$lambda$18 = RoomGameAnimationKt.hideSUDGameView$lambda$23$lambda$18(FragmentAudioRoomBinding.this, audioGameHelp, f);
                    return hideSUDGameView$lambda$23$lambda$18;
                }
            });
            View mGameView = audioGameHelp.getMGameView();
            if (mGameView != null) {
                objectAnimator = animationUtility.scaleX(mGameView, false);
                objectAnimator2 = animationUtility.scaleY(mGameView, false);
                FrameLayout frameLayout2 = binding.onLineLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "onLineLayout");
                objectAnimator3 = animationUtility.alpha(frameLayout2, false);
            } else {
                objectAnimator = null;
                objectAnimator2 = null;
                objectAnimator3 = null;
            }
            AnimatorSet sudAnimatorSetHide = audioGameHelp.getSudAnimatorSetHide();
            if (sudAnimatorSetHide != null) {
                sudAnimatorSetHide.setDuration(300L);
            }
            ArrayList arrayList = new ArrayList();
            NewMicroView newMicroView = binding.microView;
            Intrinsics.checkNotNullExpressionValue(newMicroView, "microView");
            arrayList.add(animationUtility.translationY(newMicroView, -binding.microView.getHeight(), 0));
            NewMicroView newMicroView2 = binding.microView;
            Intrinsics.checkNotNullExpressionValue(newMicroView2, "microView");
            arrayList.add(animationUtility.alpha(newMicroView2, true));
            if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout = binding.meetingRoomOnlineMember;
                Intrinsics.checkNotNullExpressionValue(meetingRoomOnlineMemberLayout, "meetingRoomOnlineMember");
                arrayList.add(animationUtility.translationX(meetingRoomOnlineMemberLayout, -binding.meetingRoomOnlineMember.getWidth(), 0));
            } else {
                MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout2 = binding.meetingRoomOnlineMember;
                Intrinsics.checkNotNullExpressionValue(meetingRoomOnlineMemberLayout2, "meetingRoomOnlineMember");
                arrayList.add(animationUtility.translationX(meetingRoomOnlineMemberLayout2, binding.meetingRoomOnlineMember.getWidth(), 0));
            }
            MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout3 = binding.meetingRoomOnlineMember;
            Intrinsics.checkNotNullExpressionValue(meetingRoomOnlineMemberLayout3, "meetingRoomOnlineMember");
            arrayList.add(animationUtility.alpha(meetingRoomOnlineMemberLayout3, true));
            RecyclerView recyclerView = binding.gameRecycleView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "gameRecycleView");
            arrayList.add(animationUtility.translationY(recyclerView, 0, binding.microView.getHeight()));
            RecyclerView recyclerView2 = binding.gameRecycleView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "gameRecycleView");
            arrayList.add(animationUtility.alpha(recyclerView2, false));
            FrameLayout frameLayout3 = binding.onLineLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "onLineLayout");
            arrayList.add(animationUtility.alpha(frameLayout3, false));
            arrayList.add(alpha);
            if (objectAnimator != null) {
                arrayList.add(objectAnimator);
            }
            if (objectAnimator2 != null) {
                arrayList.add(objectAnimator2);
            }
            if (objectAnimator3 != null) {
                arrayList.add(objectAnimator3);
            }
            ImageView imageView = binding.meetingRoomThemBackGroup;
            Intrinsics.checkNotNullExpressionValue(imageView, "meetingRoomThemBackGroup");
            arrayList.add(animationUtility.alpha(imageView, false));
            ConstraintLayout constraintLayout = binding.playLayout;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "playLayout");
            arrayList.add(animationUtility.translationY(constraintLayout, binding.playLayout.getHeight() + UiKtxKt.toPX(66), 0));
            ConstraintLayout constraintLayout2 = binding.playLayout;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "playLayout");
            arrayList.add(animationUtility.alpha(constraintLayout2, true));
            ImageView imageView2 = binding.showChat;
            Intrinsics.checkNotNullExpressionValue(imageView2, "showChat");
            arrayList.add(animationUtility.alpha(imageView2, false));
            AnimatorSet sudAnimatorSetHide2 = audioGameHelp.getSudAnimatorSetHide();
            if (sudAnimatorSetHide2 != null) {
                sudAnimatorSetHide2.playTogether(arrayList);
            }
            AnimatorSet sudAnimatorSetHide3 = audioGameHelp.getSudAnimatorSetHide();
            if (sudAnimatorSetHide3 != null) {
                sudAnimatorSetHide3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$hideSUDGameView$1$6
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        VoteHelper voteHelper;
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        BaseActivity activity = HiloUtils.INSTANCE.getActivity(AudioGameHelp.this.getFragment().getActivity());
                        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                            binding.gameRecycleView.setVisibility(8);
                            binding.onLineLayout.setVisibility(8);
                            binding.gameLayout.setVisibility(8);
                            binding.showChat.setVisibility(8);
                            AudioGameHelp audioGameHelp2 = AudioGameHelp.this;
                            audioGameHelp2.setBg(false, audioGameHelp2.getShowGameType());
                            Function0<Unit> function02 = function0;
                            if (function02 != null) {
                                function02.invoke();
                            }
                            binding.microView.recoverMicSVGA();
                            AudioRoomFragmentHelp mAudioHelp = AudioGameHelp.this.getFragment().getMAudioHelp();
                            if (mAudioHelp != null && (voteHelper = mAudioHelp.getVoteHelper()) != null) {
                                voteHelper.refreshView();
                            }
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        BaseActivity activity = HiloUtils.INSTANCE.getActivity(AudioGameHelp.this.getFragment().getActivity());
                        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                            binding.microView.setVisibility(0);
                            binding.meetingRoomOnlineMember.setVisibility(0);
                            binding.playLayout.setVisibility(0);
                        }
                    }
                });
            }
            AnimatorSet sudAnimatorSetHide4 = audioGameHelp.getSudAnimatorSetHide();
            if (sudAnimatorSetHide4 != null) {
                sudAnimatorSetHide4.start();
            }
        }
    }

    public static /* synthetic */ void hideSUDGameView$default(AudioGameHelp audioGameHelp, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        hideSUDGameView(audioGameHelp, function0);
    }

    public static final float hideSUDGameView$lambda$23$lambda$18(FragmentAudioRoomBinding fragmentAudioRoomBinding, AudioGameHelp audioGameHelp, float f) {
        ViewGroup.LayoutParams layoutParams = fragmentAudioRoomBinding.gameLayout.getLayoutParams();
        layoutParams.height = audioGameHelp.getDefaultHeight() + ((int) (audioGameHelp.getGameHeight() * (1 - f)));
        fragmentAudioRoomBinding.gameLayout.setLayoutParams(layoutParams);
        return f;
    }

    public static final void showGameChat(@NotNull final AudioGameHelp audioGameHelp) {
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            audioGameHelp.setChatAnimatorSetShow(new AnimatorSet());
            AnimatorSet chatAnimatorSetShow = audioGameHelp.getChatAnimatorSetShow();
            if (chatAnimatorSetShow != null) {
                chatAnimatorSetShow.setDuration(300L);
            }
            AnimatorSet chatAnimatorSetShow2 = audioGameHelp.getChatAnimatorSetShow();
            if (chatAnimatorSetShow2 != null) {
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                FrameLayout frameLayout = binding.gameChatLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout, "gameChatLayout");
                ObjectAnimator translationY = animationUtility.translationY(frameLayout, binding.gameChatLayout.getHeight(), 0);
                FrameLayout frameLayout2 = binding.gameChatLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "gameChatLayout");
                chatAnimatorSetShow2.playTogether(translationY, animationUtility.alpha(frameLayout2, true));
            }
            AnimatorSet chatAnimatorSetShow3 = audioGameHelp.getChatAnimatorSetShow();
            if (chatAnimatorSetShow3 != null) {
                chatAnimatorSetShow3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$showGameChat$1$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        BaseActivity activity = HiloUtils.INSTANCE.getActivity(AudioGameHelp.this.getFragment().getActivity());
                        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                            binding.showChat.setVisibility(8);
                            binding.gameChatLayout.setVisibility(0);
                        }
                    }
                });
            }
            AnimatorSet chatAnimatorSetShow4 = audioGameHelp.getChatAnimatorSetShow();
            if (chatAnimatorSetShow4 != null) {
                chatAnimatorSetShow4.start();
            }
        }
    }

    public static final void showHiloGameView(@NotNull final AudioGameHelp audioGameHelp) {
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            audioGameHelp.setBg(true, audioGameHelp.getShowGameType());
            ViewGroup.LayoutParams layoutParams = binding.gameLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.b) layoutParams;
            ((ConstraintLayout.b) layoutParams2).j = binding.meetingRoomOnlineMember.getId();
            binding.gameLayout.setLayoutParams(layoutParams2);
            audioGameHelp.setHiloGameAnimatorSetShow(new AnimatorSet());
            AnimatorSet hiloGameAnimatorSetShow = audioGameHelp.getHiloGameAnimatorSetShow();
            if (hiloGameAnimatorSetShow != null) {
                hiloGameAnimatorSetShow.setDuration(500L);
            }
            final AudioHiloGameBinding binding2 = audioGameHelp.getMHiloGameHelp().getBinding();
            if (binding2 != null) {
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                View root = binding2.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                ObjectAnimator alpha = animationUtility.alpha(root, true);
                audioGameHelp.getMHiloGameHelp().setMDefaultViewHeight(binding.microView.getHeight());
                audioGameHelp.getMHiloGameHelp().setMViewChangeHeight((((binding.frameLayout.getWidth() * 131376) / 276) / 375) - binding.microView.getHeight());
                alpha.setInterpolator(new TimeInterpolator() { // from class: com.qiahao.nextvideo.room.help.n8
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float showHiloGameView$lambda$2$lambda$1$lambda$0;
                        showHiloGameView$lambda$2$lambda$1$lambda$0 = RoomGameAnimationKt.showHiloGameView$lambda$2$lambda$1$lambda$0(FragmentAudioRoomBinding.this, audioGameHelp, f);
                        return showHiloGameView$lambda$2$lambda$1$lambda$0;
                    }
                });
                AnimatorSet hiloGameAnimatorSetShow2 = audioGameHelp.getHiloGameAnimatorSetShow();
                if (hiloGameAnimatorSetShow2 != null) {
                    NewMicroView newMicroView = binding.microView;
                    Intrinsics.checkNotNullExpressionValue(newMicroView, "microView");
                    ObjectAnimator scaleY = animationUtility.scaleY(newMicroView, false);
                    NewMicroView newMicroView2 = binding.microView;
                    Intrinsics.checkNotNullExpressionValue(newMicroView2, "microView");
                    ObjectAnimator scaleX = animationUtility.scaleX(newMicroView2, false);
                    NewMicroView newMicroView3 = binding.microView;
                    Intrinsics.checkNotNullExpressionValue(newMicroView3, "microView");
                    ObjectAnimator alpha2 = animationUtility.alpha(newMicroView3, false);
                    FrameLayout frameLayout = binding.gameLayout;
                    Intrinsics.checkNotNullExpressionValue(frameLayout, "gameLayout");
                    ObjectAnimator alpha3 = animationUtility.alpha(frameLayout, true);
                    AppCompatImageView appCompatImageView = binding.changeGameModel;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "changeGameModel");
                    ObjectAnimator alpha4 = animationUtility.alpha(appCompatImageView, true);
                    ConstraintLayout constraintLayout = binding.playLayout;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "playLayout");
                    ObjectAnimator translationY = animationUtility.translationY(constraintLayout, 0, binding.playLayout.getHeight() + UiKtxKt.toPX(66));
                    ConstraintLayout constraintLayout2 = binding.playLayout;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout2, "playLayout");
                    ObjectAnimator alpha5 = animationUtility.alpha(constraintLayout2, false);
                    ImageView imageView = binding.showChat;
                    Intrinsics.checkNotNullExpressionValue(imageView, "showChat");
                    hiloGameAnimatorSetShow2.playTogether(alpha, scaleY, scaleX, alpha2, alpha3, alpha4, translationY, alpha5, animationUtility.alpha(imageView, true));
                }
                AnimatorSet hiloGameAnimatorSetShow3 = audioGameHelp.getHiloGameAnimatorSetShow();
                if (hiloGameAnimatorSetShow3 != null) {
                    hiloGameAnimatorSetShow3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$showHiloGameView$1$1$2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            VoteHelper voteHelper;
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            FragmentAudioRoomBinding.this.microView.setVisibility(8);
                            AudioRoomFragmentHelp mAudioHelp = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp != null && (voteHelper = mAudioHelp.getVoteHelper()) != null) {
                                voteHelper.refreshView();
                            }
                            int height = binding2.bg.getHeight();
                            if (height > 0) {
                                audioGameHelp.getMHiloGameHelp().setMViewChangeHeight(height - FragmentAudioRoomBinding.this.microView.getHeight());
                                ViewGroup.LayoutParams layoutParams3 = FragmentAudioRoomBinding.this.gameLayout.getLayoutParams();
                                layoutParams3.height = height;
                                FragmentAudioRoomBinding.this.gameLayout.setLayoutParams(layoutParams3);
                            }
                            FragmentAudioRoomBinding.this.playLayout.setVisibility(8);
                            audioGameHelp.hideRoomEffect();
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            FragmentAudioRoomBinding.this.gameLayout.setVisibility(0);
                            if (MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
                                FragmentAudioRoomBinding.this.changeGameModel.setVisibility(0);
                            }
                            FragmentAudioRoomBinding.this.playLayout.setVisibility(0);
                            FragmentAudioRoomBinding.this.showChat.setVisibility(0);
                            FragmentAudioRoomBinding.this.microView.stopMicSVGA();
                            AudioRoomFragmentHelp mAudioHelp = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp != null) {
                                mAudioHelp.checkPlayLayout();
                            }
                        }
                    });
                }
            }
            AnimatorSet hiloGameAnimatorSetShow4 = audioGameHelp.getHiloGameAnimatorSetShow();
            if (hiloGameAnimatorSetShow4 != null) {
                hiloGameAnimatorSetShow4.start();
            }
        }
    }

    public static final float showHiloGameView$lambda$2$lambda$1$lambda$0(FragmentAudioRoomBinding fragmentAudioRoomBinding, AudioGameHelp audioGameHelp, float f) {
        ViewGroup.LayoutParams layoutParams = fragmentAudioRoomBinding.gameLayout.getLayoutParams();
        layoutParams.height = audioGameHelp.getMHiloGameHelp().getMDefaultViewHeight() + ((int) (audioGameHelp.getMHiloGameHelp().getMViewChangeHeight() * f));
        fragmentAudioRoomBinding.gameLayout.setLayoutParams(layoutParams);
        return f;
    }

    public static final void showPKGameView(@NotNull final AudioGameHelp audioGameHelp) {
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            ConstraintLayout.b layoutParams = binding.gameLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = layoutParams;
            bVar.j = binding.meetingRoomOnlineMember.getId();
            ((ViewGroup.MarginLayoutParams) bVar).height = binding.microView.getHeight();
            binding.gameLayout.setLayoutParams(bVar);
            audioGameHelp.setPkAnimatorSetShow(new AnimatorSet());
            AnimatorSet pkAnimatorSetShow = audioGameHelp.getPkAnimatorSetShow();
            if (pkAnimatorSetShow != null) {
                pkAnimatorSetShow.setDuration(300L);
            }
            final ViewGamePkBinding binding2 = audioGameHelp.getMPKGameHelp().getBinding();
            if (binding2 != null) {
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                PKButtonView pKButtonView = binding2.button;
                Intrinsics.checkNotNullExpressionValue(pKButtonView, "button");
                ObjectAnimator alpha = animationUtility.alpha(pKButtonView, true);
                audioGameHelp.getMPKGameHelp().setMDefaultViewHeight(binding.microView.getHeight());
                audioGameHelp.getMPKGameHelp().setMViewChangeHeight(UiKtxKt.toPX(335) - binding.microView.getHeight());
                alpha.setInterpolator(new TimeInterpolator() { // from class: com.qiahao.nextvideo.room.help.j8
                    @Override // android.animation.TimeInterpolator
                    public final float getInterpolation(float f) {
                        float showPKGameView$lambda$8$lambda$7$lambda$6;
                        showPKGameView$lambda$8$lambda$7$lambda$6 = RoomGameAnimationKt.showPKGameView$lambda$8$lambda$7$lambda$6(FragmentAudioRoomBinding.this, audioGameHelp, f);
                        return showPKGameView$lambda$8$lambda$7$lambda$6;
                    }
                });
                if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                    AnimatorSet pkAnimatorSetShow2 = audioGameHelp.getPkAnimatorSetShow();
                    if (pkAnimatorSetShow2 != null) {
                        PKMicroView pKMicroView = binding2.leftMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView, "leftMic");
                        ObjectAnimator translationX = animationUtility.translationX(pKMicroView, binding.centerLayout.getWidth() / 2, 0);
                        PKMicroView pKMicroView2 = binding2.rightMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView2, "rightMic");
                        ObjectAnimator translationX2 = animationUtility.translationX(pKMicroView2, (-binding.centerLayout.getWidth()) / 2, 0);
                        NewMicroView newMicroView = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView, "microView");
                        ObjectAnimator scaleY = animationUtility.scaleY(newMicroView, false);
                        NewMicroView newMicroView2 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView2, "microView");
                        ObjectAnimator scaleX = animationUtility.scaleX(newMicroView2, false);
                        NewMicroView newMicroView3 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView3, "microView");
                        ObjectAnimator alpha2 = animationUtility.alpha(newMicroView3, false);
                        FrameLayout frameLayout = binding.gameLayout;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "gameLayout");
                        ObjectAnimator alpha3 = animationUtility.alpha(frameLayout, true);
                        TextView textView = binding2.time;
                        Intrinsics.checkNotNullExpressionValue(textView, AgooConstants.MESSAGE_TIME);
                        ObjectAnimator alpha4 = animationUtility.alpha(textView, true);
                        View root = binding2.redGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                        ObjectAnimator alpha5 = animationUtility.alpha(root, true);
                        View root2 = binding2.blueGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                        pkAnimatorSetShow2.playTogether(translationX, translationX2, alpha, scaleY, scaleX, alpha2, alpha3, alpha4, alpha5, animationUtility.alpha(root2, true));
                    }
                } else {
                    AnimatorSet pkAnimatorSetShow3 = audioGameHelp.getPkAnimatorSetShow();
                    if (pkAnimatorSetShow3 != null) {
                        PKMicroView pKMicroView3 = binding2.leftMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView3, "leftMic");
                        ObjectAnimator translationX3 = animationUtility.translationX(pKMicroView3, (-binding.centerLayout.getWidth()) / 2, 0);
                        PKMicroView pKMicroView4 = binding2.rightMic;
                        Intrinsics.checkNotNullExpressionValue(pKMicroView4, "rightMic");
                        ObjectAnimator translationX4 = animationUtility.translationX(pKMicroView4, binding.centerLayout.getWidth() / 2, 0);
                        NewMicroView newMicroView4 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView4, "microView");
                        ObjectAnimator scaleY2 = animationUtility.scaleY(newMicroView4, false);
                        NewMicroView newMicroView5 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView5, "microView");
                        ObjectAnimator scaleX2 = animationUtility.scaleX(newMicroView5, false);
                        NewMicroView newMicroView6 = binding.microView;
                        Intrinsics.checkNotNullExpressionValue(newMicroView6, "microView");
                        ObjectAnimator alpha6 = animationUtility.alpha(newMicroView6, false);
                        FrameLayout frameLayout2 = binding.gameLayout;
                        Intrinsics.checkNotNullExpressionValue(frameLayout2, "gameLayout");
                        ObjectAnimator alpha7 = animationUtility.alpha(frameLayout2, true);
                        TextView textView2 = binding2.time;
                        Intrinsics.checkNotNullExpressionValue(textView2, AgooConstants.MESSAGE_TIME);
                        ObjectAnimator alpha8 = animationUtility.alpha(textView2, true);
                        View root3 = binding2.redGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
                        ObjectAnimator alpha9 = animationUtility.alpha(root3, true);
                        View root4 = binding2.blueGo.getRoot();
                        Intrinsics.checkNotNullExpressionValue(root4, "getRoot(...)");
                        pkAnimatorSetShow3.playTogether(translationX3, translationX4, alpha, scaleY2, scaleX2, alpha6, alpha7, alpha8, alpha9, animationUtility.alpha(root4, true));
                    }
                }
                AnimatorSet pkAnimatorSetShow4 = audioGameHelp.getPkAnimatorSetShow();
                if (pkAnimatorSetShow4 != null) {
                    pkAnimatorSetShow4.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$showPKGameView$1$1$2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            VoteHelper voteHelper;
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            FragmentAudioRoomBinding.this.microView.setVisibility(8);
                            AudioRoomFragmentHelp mAudioHelp = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp != null && (voteHelper = mAudioHelp.getVoteHelper()) != null) {
                                voteHelper.refreshView();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animation) {
                            Intrinsics.checkNotNullParameter(animation, "animation");
                            FragmentAudioRoomBinding.this.gameLayout.setVisibility(0);
                            binding2.time.setVisibility(0);
                            binding2.redGo.getRoot().setVisibility(0);
                            binding2.blueGo.getRoot().setVisibility(0);
                            FragmentAudioRoomBinding.this.microView.stopMicSVGA();
                            AudioRoomFragmentHelp mAudioHelp = audioGameHelp.getFragment().getMAudioHelp();
                            if (mAudioHelp != null) {
                                mAudioHelp.checkPlayLayout();
                            }
                        }
                    });
                }
            }
            AnimatorSet pkAnimatorSetShow5 = audioGameHelp.getPkAnimatorSetShow();
            if (pkAnimatorSetShow5 != null) {
                pkAnimatorSetShow5.start();
            }
        }
    }

    public static final float showPKGameView$lambda$8$lambda$7$lambda$6(FragmentAudioRoomBinding fragmentAudioRoomBinding, AudioGameHelp audioGameHelp, float f) {
        ViewGroup.LayoutParams layoutParams = fragmentAudioRoomBinding.gameLayout.getLayoutParams();
        layoutParams.height = audioGameHelp.getMPKGameHelp().getMDefaultViewHeight() + ((int) (audioGameHelp.getMPKGameHelp().getMViewChangeHeight() * f));
        fragmentAudioRoomBinding.gameLayout.setLayoutParams(layoutParams);
        return f;
    }

    public static final void showSUDGameView(@NotNull final AudioGameHelp audioGameHelp) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3;
        Intrinsics.checkNotNullParameter(audioGameHelp, "<this>");
        audioGameHelp.setBg(true, audioGameHelp.getShowGameType());
        audioGameHelp.changeGameMicType();
        final FragmentAudioRoomBinding binding = audioGameHelp.getFragment().getBinding();
        if (binding != null) {
            audioGameHelp.setSudAnimatorSetShow(new AnimatorSet());
            AnimationUtility animationUtility = AnimationUtility.INSTANCE;
            FrameLayout frameLayout = binding.gameLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "gameLayout");
            ObjectAnimator alpha = animationUtility.alpha(frameLayout, true);
            alpha.setInterpolator(new TimeInterpolator() { // from class: com.qiahao.nextvideo.room.help.o8
                @Override // android.animation.TimeInterpolator
                public final float getInterpolation(float f) {
                    float showSUDGameView$lambda$17$lambda$12;
                    showSUDGameView$lambda$17$lambda$12 = RoomGameAnimationKt.showSUDGameView$lambda$17$lambda$12(FragmentAudioRoomBinding.this, audioGameHelp, f);
                    return showSUDGameView$lambda$17$lambda$12;
                }
            });
            View mGameView = audioGameHelp.getMGameView();
            if (mGameView != null) {
                objectAnimator = animationUtility.scaleX(mGameView, true);
                objectAnimator2 = animationUtility.scaleY(mGameView, true);
                FrameLayout frameLayout2 = binding.onLineLayout;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "onLineLayout");
                objectAnimator3 = animationUtility.alpha(frameLayout2, true);
            } else {
                objectAnimator = null;
                objectAnimator2 = null;
                objectAnimator3 = null;
            }
            AnimatorSet sudAnimatorSetShow = audioGameHelp.getSudAnimatorSetShow();
            if (sudAnimatorSetShow != null) {
                sudAnimatorSetShow.setDuration(300L);
            }
            ArrayList arrayList = new ArrayList();
            NewMicroView newMicroView = binding.microView;
            Intrinsics.checkNotNullExpressionValue(newMicroView, "microView");
            arrayList.add(animationUtility.translationY(newMicroView, 0, -binding.microView.getHeight()));
            NewMicroView newMicroView2 = binding.microView;
            Intrinsics.checkNotNullExpressionValue(newMicroView2, "microView");
            arrayList.add(animationUtility.alpha(newMicroView2, false));
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            if (hiloUtils.getRightToLeftDirection()) {
                MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout = binding.meetingRoomOnlineMember;
                Intrinsics.checkNotNullExpressionValue(meetingRoomOnlineMemberLayout, "meetingRoomOnlineMember");
                arrayList.add(animationUtility.translationX(meetingRoomOnlineMemberLayout, 0, -binding.meetingRoomOnlineMember.getWidth()));
            } else {
                MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout2 = binding.meetingRoomOnlineMember;
                Intrinsics.checkNotNullExpressionValue(meetingRoomOnlineMemberLayout2, "meetingRoomOnlineMember");
                arrayList.add(animationUtility.translationX(meetingRoomOnlineMemberLayout2, 0, binding.meetingRoomOnlineMember.getWidth()));
            }
            MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout3 = binding.meetingRoomOnlineMember;
            Intrinsics.checkNotNullExpressionValue(meetingRoomOnlineMemberLayout3, "meetingRoomOnlineMember");
            arrayList.add(animationUtility.alpha(meetingRoomOnlineMemberLayout3, false));
            RecyclerView recyclerView = binding.gameRecycleView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "gameRecycleView");
            arrayList.add(animationUtility.translationY(recyclerView, binding.microView.getHeight(), 0));
            RecyclerView recyclerView2 = binding.gameRecycleView;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "gameRecycleView");
            arrayList.add(animationUtility.alpha(recyclerView2, true));
            FrameLayout frameLayout3 = binding.onLineLayout;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "onLineLayout");
            arrayList.add(animationUtility.alpha(frameLayout3, true));
            arrayList.add(alpha);
            if (objectAnimator != null) {
                arrayList.add(objectAnimator);
            }
            if (objectAnimator2 != null) {
                arrayList.add(objectAnimator2);
            }
            if (objectAnimator3 != null) {
                arrayList.add(objectAnimator3);
            }
            ImageView imageView = binding.meetingRoomThemBackGroup;
            Intrinsics.checkNotNullExpressionValue(imageView, "meetingRoomThemBackGroup");
            arrayList.add(animationUtility.alpha(imageView, true));
            if (audioGameHelp.getShowGameType() != 13) {
                if (hiloUtils.getRightToLeftDirection()) {
                    ConstraintLayout constraintLayout = binding.playLayout;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "playLayout");
                    arrayList.add(animationUtility.translationY(constraintLayout, 0, binding.playLayout.getHeight() + UiKtxKt.toPX(66)));
                } else {
                    ConstraintLayout constraintLayout2 = binding.playLayout;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout2, "playLayout");
                    arrayList.add(animationUtility.translationY(constraintLayout2, 0, binding.playLayout.getHeight() + UiKtxKt.toPX(66)));
                }
                ConstraintLayout constraintLayout3 = binding.playLayout;
                Intrinsics.checkNotNullExpressionValue(constraintLayout3, "playLayout");
                arrayList.add(animationUtility.alpha(constraintLayout3, false));
                ImageView imageView2 = binding.showChat;
                Intrinsics.checkNotNullExpressionValue(imageView2, "showChat");
                arrayList.add(animationUtility.alpha(imageView2, true));
            }
            AnimatorSet sudAnimatorSetShow2 = audioGameHelp.getSudAnimatorSetShow();
            if (sudAnimatorSetShow2 != null) {
                sudAnimatorSetShow2.playTogether(arrayList);
            }
            AnimatorSet sudAnimatorSetShow3 = audioGameHelp.getSudAnimatorSetShow();
            if (sudAnimatorSetShow3 != null) {
                sudAnimatorSetShow3.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.RoomGameAnimationKt$showSUDGameView$1$6
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        VoteHelper voteHelper;
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        BaseActivity activity = HiloUtils.INSTANCE.getActivity(AudioGameHelp.this.getFragment().getActivity());
                        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                            binding.microView.setVisibility(8);
                            binding.meetingRoomOnlineMember.setVisibility(8);
                            if (AudioGameHelp.this.getShowGameType() != 13) {
                                binding.playLayout.setVisibility(8);
                            }
                            AudioRoomFragmentHelp mAudioHelp = AudioGameHelp.this.getFragment().getMAudioHelp();
                            if (mAudioHelp != null && (voteHelper = mAudioHelp.getVoteHelper()) != null) {
                                voteHelper.refreshView();
                            }
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animation) {
                        Intrinsics.checkNotNullParameter(animation, "animation");
                        BaseActivity activity = HiloUtils.INSTANCE.getActivity(AudioGameHelp.this.getFragment().getActivity());
                        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                            binding.gameRecycleView.setVisibility(0);
                            binding.onLineLayout.setVisibility(0);
                            binding.gameLayout.setVisibility(0);
                            if (AudioGameHelp.this.getShowGameType() != 13) {
                                binding.showChat.setVisibility(0);
                                binding.playLayout.setVisibility(0);
                            }
                            binding.microView.stopMicSVGA();
                        }
                    }
                });
            }
            AnimatorSet sudAnimatorSetShow4 = audioGameHelp.getSudAnimatorSetShow();
            if (sudAnimatorSetShow4 != null) {
                sudAnimatorSetShow4.start();
            }
        }
    }

    public static final float showSUDGameView$lambda$17$lambda$12(FragmentAudioRoomBinding fragmentAudioRoomBinding, AudioGameHelp audioGameHelp, float f) {
        ViewGroup.LayoutParams layoutParams = fragmentAudioRoomBinding.gameLayout.getLayoutParams();
        layoutParams.height = audioGameHelp.getDefaultHeight() + ((int) (audioGameHelp.getGameHeight() * f));
        fragmentAudioRoomBinding.gameLayout.setLayoutParams(layoutParams);
        return f;
    }
}
