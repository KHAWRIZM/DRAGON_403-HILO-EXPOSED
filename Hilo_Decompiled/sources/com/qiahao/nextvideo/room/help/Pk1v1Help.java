package com.qiahao.nextvideo.room.help;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.Pk1v1Data;
import com.qiahao.nextvideo.data.game.Pk1v1End;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.databinding.Pk1v1WinBinding;
import com.qiahao.nextvideo.databinding.RoomPk1v1Binding;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.PortraitAnimationView;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.imsdk.v2.V2TIMManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020'J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0002J\u000e\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020'2\u0006\u0010-\u001a\u00020.H\u0002J\b\u00100\u001a\u00020'H\u0002J\u000e\u00101\u001a\u00020'2\u0006\u0010*\u001a\u00020+J\u0006\u00102\u001a\u00020'J\u0014\u00103\u001a\u00020'2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\u001a\u00103\u001a\u00020'2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/room/help/Pk1v1Help;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "binding", "Lcom/qiahao/nextvideo/databinding/RoomPk1v1Binding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/RoomPk1v1Binding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/RoomPk1v1Binding;)V", "endBinding", "Lcom/qiahao/nextvideo/databinding/Pk1v1WinBinding;", "getEndBinding", "()Lcom/qiahao/nextvideo/databinding/Pk1v1WinBinding;", "setEndBinding", "(Lcom/qiahao/nextvideo/databinding/Pk1v1WinBinding;)V", "timerTask", "Landroid/os/CountDownTimer;", "getTimerTask", "()Landroid/os/CountDownTimer;", "setTimerTask", "(Landroid/os/CountDownTimer;)V", "startSVGA", "Lcom/opensource/svgaplayer/SVGAImageView;", "getStartSVGA", "()Lcom/opensource/svgaplayer/SVGAImageView;", "setStartSVGA", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "showPk1v1", "", "refreshView", "countDown", "isEnd", "", "pkEnd", "data", "Lcom/qiahao/nextvideo/data/game/Pk1v1End;", "showEndSvga", "showStartSVGA", "startOrEndAnimation", "release", "showMicSpeakWaveAnim", "list", "", "", "mMicBean", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "speakWave", "Lcom/qiahao/nextvideo/room/view/PortraitAnimationView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPk1v1Help.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pk1v1Help.kt\ncom/qiahao/nextvideo/room/help/Pk1v1Help\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,425:1\n61#2,9:426\n61#2,9:435\n1#3:444\n1869#4,2:445\n*S KotlinDebug\n*F\n+ 1 Pk1v1Help.kt\ncom/qiahao/nextvideo/room/help/Pk1v1Help\n*L\n66#1:426,9\n75#1:435,9\n387#1:445,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class Pk1v1Help {

    @Nullable
    private RoomPk1v1Binding binding;

    @Nullable
    private Pk1v1WinBinding endBinding;
    private long endTime;

    @NotNull
    private final AudioRoomFragment fragment;

    @Nullable
    private SVGAImageView startSVGA;

    @Nullable
    private CountDownTimer timerTask;

    public Pk1v1Help(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        this.endTime = 10L;
    }

    private final void countDown(boolean isEnd) {
        long j;
        long serverTime;
        Long unix;
        long j2;
        CountDownTimer countDownTimer = this.timerTask;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (isEnd) {
            j = this.endTime;
            j2 = 10;
            if (j != 10) {
                serverTime = V2TIMManager.getInstance().getServerTime();
            }
            Pk1v1Help$countDown$1 pk1v1Help$countDown$1 = new Pk1v1Help$countDown$1(isEnd, this, j2 * 1000);
            this.timerTask = pk1v1Help$countDown$1;
            pk1v1Help$countDown$1.start();
        }
        Pk1v1Data mPK1v1 = MeetingRoomManager.INSTANCE.getMPK1v1();
        if (mPK1v1 != null && (unix = mPK1v1.getUnix()) != null) {
            j = unix.longValue();
        } else {
            j = 0;
        }
        serverTime = V2TIMManager.getInstance().getServerTime();
        j2 = j - serverTime;
        Pk1v1Help$countDown$1 pk1v1Help$countDown$12 = new Pk1v1Help$countDown$1(isEnd, this, j2 * 1000);
        this.timerTask = pk1v1Help$countDown$12;
        pk1v1Help$countDown$12.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshView$lambda$6$lambda$5(Pk1v1Help pk1v1Help) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        float f;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        CustomProgressView customProgressView;
        CustomProgressView customProgressView2;
        SVGAImageView sVGAImageView3;
        RoomPk1v1Binding roomPk1v1Binding = pk1v1Help.binding;
        ConstraintLayout.b bVar = null;
        if (roomPk1v1Binding != null && (sVGAImageView3 = roomPk1v1Binding.svga) != null) {
            layoutParams = sVGAImageView3.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.b) {
            bVar = (ConstraintLayout.b) layoutParams;
        }
        if (bVar != null) {
            RoomPk1v1Binding roomPk1v1Binding2 = pk1v1Help.binding;
            int i2 = 0;
            if (roomPk1v1Binding2 != null && (customProgressView2 = roomPk1v1Binding2.progress) != null) {
                i = customProgressView2.getWidth();
            } else {
                i = 0;
            }
            float f2 = i;
            RoomPk1v1Binding roomPk1v1Binding3 = pk1v1Help.binding;
            if (roomPk1v1Binding3 != null && (customProgressView = roomPk1v1Binding3.progress) != null) {
                f = customProgressView.getCurrentProgress();
            } else {
                f = 0.0f;
            }
            int i3 = (int) ((f2 * f) / 100);
            RoomPk1v1Binding roomPk1v1Binding4 = pk1v1Help.binding;
            if (roomPk1v1Binding4 != null && (sVGAImageView2 = roomPk1v1Binding4.svga) != null) {
                i2 = sVGAImageView2.getWidth();
            }
            bVar.setMarginStart((i3 - (i2 / 2)) - UiKtxKt.toPX(3));
            RoomPk1v1Binding roomPk1v1Binding5 = pk1v1Help.binding;
            if (roomPk1v1Binding5 != null && (sVGAImageView = roomPk1v1Binding5.svga) != null) {
                sVGAImageView.setLayoutParams(bVar);
            }
        }
    }

    private final void showEndSvga(final Pk1v1End data) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        View view;
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        AppCompatTextView appCompatTextView;
        TextView textView;
        String str;
        if (!this.fragment.isDetached() && this.fragment.getContext() != null && this.endBinding == null) {
            LayoutInflater from = LayoutInflater.from(this.fragment.getContext());
            FragmentAudioRoomBinding binding = this.fragment.getBinding();
            if (binding != null) {
                frameLayout = binding.frameLayout;
            } else {
                frameLayout = null;
            }
            Pk1v1WinBinding pk1v1WinBinding = (Pk1v1WinBinding) androidx.databinding.g.h(from, R.layout.pk1v1_win, frameLayout, true);
            this.endBinding = pk1v1WinBinding;
            if (pk1v1WinBinding != null && (textView = pk1v1WinBinding.winnerName) != null) {
                User winUser = data.getWinUser();
                if (winUser != null) {
                    str = winUser.getNick();
                } else {
                    str = null;
                }
                textView.setText(str);
            }
            Pk1v1WinBinding pk1v1WinBinding2 = this.endBinding;
            if (pk1v1WinBinding2 != null && (appCompatTextView = pk1v1WinBinding2.winnerDiamond) != null) {
                appCompatTextView.setText(String.valueOf(data.getDiamond()));
            }
            Pk1v1WinBinding pk1v1WinBinding3 = this.endBinding;
            if (pk1v1WinBinding3 != null && (sVGAImageView2 = pk1v1WinBinding3.pkEndSvga) != null) {
                sVGAImageView2.setCallback(new SVGACallback() { // from class: com.qiahao.nextvideo.room.help.Pk1v1Help$showEndSvga$1
                    public void onFinished() {
                        FrameLayout frameLayout3;
                        View view2;
                        FragmentAudioRoomBinding binding2 = Pk1v1Help.this.getFragment().getBinding();
                        if (binding2 != null && (frameLayout3 = binding2.frameLayout) != null) {
                            Pk1v1WinBinding endBinding = Pk1v1Help.this.getEndBinding();
                            if (endBinding != null) {
                                view2 = endBinding.getRoot();
                            } else {
                                view2 = null;
                            }
                            frameLayout3.removeView(view2);
                        }
                        Pk1v1Help.this.setEndBinding(null);
                    }

                    public void onPause() {
                    }

                    public void onRepeat() {
                    }

                    public void onStep(int frame, double percentage) {
                    }
                });
            }
            try {
                SVGAParser.Companion.shareParser().decodeFromAssets("svga/luckly_wheel_winner.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.help.Pk1v1Help$showEndSvga$2
                    public void onComplete(SVGAVideoEntity videoItem) {
                        String str2;
                        SVGAImageView sVGAImageView3;
                        SVGAImageView sVGAImageView4;
                        SVGAImageView sVGAImageView5;
                        String avatar;
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                        User winUser2 = Pk1v1End.this.getWinUser();
                        if (winUser2 != null && (avatar = winUser2.getAvatar()) != null && !StringKtxKt.isUrl(avatar)) {
                            UserStore.Companion companion = UserStore.INSTANCE;
                            if (StringKtxKt.isUrl(companion.getShared().getMNormalWomanAvatarUrl())) {
                                sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(companion.getShared().getMNormalWomanAvatarUrl(), 200), "luckywheel_avatar");
                            }
                        } else {
                            User winUser3 = Pk1v1End.this.getWinUser();
                            if (winUser3 != null) {
                                str2 = winUser3.getAvatar();
                            } else {
                                str2 = null;
                            }
                            sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(str2, 200), "luckywheel_avatar");
                        }
                        Drawable sVGADrawable = new SVGADrawable(videoItem, sVGADynamicEntity);
                        Pk1v1WinBinding endBinding = this.getEndBinding();
                        if (endBinding != null && (sVGAImageView5 = endBinding.pkEndSvga) != null) {
                            sVGAImageView5.stopAnimation(true);
                        }
                        Pk1v1WinBinding endBinding2 = this.getEndBinding();
                        if (endBinding2 != null && (sVGAImageView4 = endBinding2.pkEndSvga) != null) {
                            sVGAImageView4.setImageDrawable(sVGADrawable);
                        }
                        Pk1v1WinBinding endBinding3 = this.getEndBinding();
                        if (endBinding3 != null && (sVGAImageView3 = endBinding3.pkEndSvga) != null) {
                            sVGAImageView3.startAnimation();
                        }
                    }

                    public void onError() {
                    }
                });
            } catch (Exception unused) {
                Pk1v1WinBinding pk1v1WinBinding4 = this.endBinding;
                if (pk1v1WinBinding4 != null && (sVGAImageView = pk1v1WinBinding4.pkEndSvga) != null) {
                    sVGAImageView.stopAnimation();
                }
                FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                if (binding2 != null && (frameLayout2 = binding2.frameLayout) != null) {
                    Pk1v1WinBinding pk1v1WinBinding5 = this.endBinding;
                    if (pk1v1WinBinding5 != null) {
                        view = pk1v1WinBinding5.getRoot();
                    } else {
                        view = null;
                    }
                    frameLayout2.removeView(view);
                }
                this.endBinding = null;
            }
        }
    }

    private final void showStartSVGA() {
        Context context;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        if (this.startSVGA == null && (context = this.fragment.getContext()) != null) {
            SVGAImageView sVGAImageView = new SVGAImageView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            sVGAImageView.setLoops(1);
            this.startSVGA = sVGAImageView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            FragmentAudioRoomBinding binding = this.fragment.getBinding();
            if (binding != null && (frameLayout2 = binding.frameLayout) != null) {
                frameLayout2.addView((View) this.startSVGA, (ViewGroup.LayoutParams) layoutParams);
            }
            SVGAImageView sVGAImageView2 = this.startSVGA;
            if (sVGAImageView2 != null) {
                sVGAImageView2.setCallback(new SVGACallback() { // from class: com.qiahao.nextvideo.room.help.Pk1v1Help$showStartSVGA$1$2
                    public void onFinished() {
                        FrameLayout frameLayout3;
                        FragmentAudioRoomBinding binding2 = Pk1v1Help.this.getFragment().getBinding();
                        if (binding2 != null && (frameLayout3 = binding2.frameLayout) != null) {
                            frameLayout3.removeView(Pk1v1Help.this.getStartSVGA());
                        }
                        Pk1v1Help.this.setStartSVGA(null);
                    }

                    public void onPause() {
                    }

                    public void onRepeat() {
                    }

                    public void onStep(int frame, double percentage) {
                    }
                });
            }
            try {
                SVGAParser.Companion.shareParser().decodeFromAssets("svga/pk1v1_start.svga", new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.room.help.Pk1v1Help$showStartSVGA$1$3
                    public void onComplete(SVGAVideoEntity videoItem) {
                        User user2;
                        String avatar;
                        User user22;
                        User user1;
                        String avatar2;
                        String str;
                        User user12;
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
                        Pk1v1Data mPK1v1 = meetingRoomManager.getMPK1v1();
                        String str2 = null;
                        if (mPK1v1 != null && (user1 = mPK1v1.getUser1()) != null && (avatar2 = user1.getAvatar()) != null && StringKtxKt.isUrl(avatar2)) {
                            Pk1v1Data mPK1v12 = meetingRoomManager.getMPK1v1();
                            if (mPK1v12 != null && (user12 = mPK1v12.getUser1()) != null) {
                                str = user12.getAvatar();
                            } else {
                                str = null;
                            }
                            sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(str, 200), "heabd1");
                        }
                        Pk1v1Data mPK1v13 = meetingRoomManager.getMPK1v1();
                        if (mPK1v13 != null && (user2 = mPK1v13.getUser2()) != null && (avatar = user2.getAvatar()) != null && StringKtxKt.isUrl(avatar)) {
                            Pk1v1Data mPK1v14 = meetingRoomManager.getMPK1v1();
                            if (mPK1v14 != null && (user22 = mPK1v14.getUser2()) != null) {
                                str2 = user22.getAvatar();
                            }
                            sVGADynamicEntity.setDynamicImage(ImageSizeKt.imageCircle(str2, 200), "heabd2");
                        }
                        Drawable sVGADrawable = new SVGADrawable(videoItem, sVGADynamicEntity);
                        SVGAImageView startSVGA = Pk1v1Help.this.getStartSVGA();
                        if (startSVGA != null) {
                            startSVGA.stopAnimation(true);
                        }
                        SVGAImageView startSVGA2 = Pk1v1Help.this.getStartSVGA();
                        if (startSVGA2 != null) {
                            startSVGA2.setImageDrawable(sVGADrawable);
                        }
                        SVGAImageView startSVGA3 = Pk1v1Help.this.getStartSVGA();
                        if (startSVGA3 != null) {
                            startSVGA3.startAnimation();
                        }
                    }

                    public void onError() {
                    }
                });
            } catch (Exception unused) {
                FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                if (binding2 != null && (frameLayout = binding2.frameLayout) != null) {
                    frameLayout.removeView(this.startSVGA);
                }
                this.startSVGA = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startOrEndAnimation$lambda$10(final Pk1v1Help pk1v1Help, final boolean z) {
        RoomPk1v1Binding roomPk1v1Binding = pk1v1Help.binding;
        if (roomPk1v1Binding != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(250L);
            if (z) {
                AnimationUtility animationUtility = AnimationUtility.INSTANCE;
                View root = roomPk1v1Binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                animatorSet.playTogether(animationUtility.alpha(root, false));
            } else {
                AnimationUtility animationUtility2 = AnimationUtility.INSTANCE;
                View root2 = roomPk1v1Binding.getRoot();
                Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
                animatorSet.playTogether(animationUtility2.alpha(root2, true));
            }
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.room.help.Pk1v1Help$startOrEndAnimation$1$1$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    if (z) {
                        pk1v1Help.release();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                }
            });
            animatorSet.start();
        }
    }

    @Nullable
    public final RoomPk1v1Binding getBinding() {
        return this.binding;
    }

    @Nullable
    public final Pk1v1WinBinding getEndBinding() {
        return this.endBinding;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final SVGAImageView getStartSVGA() {
        return this.startSVGA;
    }

    @Nullable
    public final CountDownTimer getTimerTask() {
        return this.timerTask;
    }

    public final void pkEnd(@NotNull Pk1v1End data) {
        String str;
        String str2;
        String str3;
        String str4;
        ImageView imageView;
        ImageView imageView2;
        User user2;
        long j;
        QMUIRadiusImageView qMUIRadiusImageView;
        String str5;
        User user22;
        QMUIRadiusImageView qMUIRadiusImageView2;
        String str6;
        String str7;
        float f;
        User user1;
        ImageView imageView3;
        ImageView imageView4;
        User user12;
        TextView textView;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!this.fragment.isDetached() && this.fragment.getContext() != null) {
            RoomPk1v1Binding roomPk1v1Binding = this.binding;
            if (roomPk1v1Binding != null && (textView = roomPk1v1Binding.winText) != null) {
                textView.setVisibility(0);
            }
            User winUser = data.getWinUser();
            String str8 = null;
            if (winUser != null) {
                str = winUser.getExternalId();
            } else {
                str = null;
            }
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            Pk1v1Data mPK1v1 = meetingRoomManager.getMPK1v1();
            if (mPK1v1 != null && (user12 = mPK1v1.getUser1()) != null) {
                str2 = user12.getExternalId();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str, str2)) {
                RoomPk1v1Binding roomPk1v1Binding2 = this.binding;
                if (roomPk1v1Binding2 != null && (imageView4 = roomPk1v1Binding2.blueWinHead) != null) {
                    imageView4.setVisibility(0);
                }
                RoomPk1v1Binding roomPk1v1Binding3 = this.binding;
                if (roomPk1v1Binding3 != null && (imageView3 = roomPk1v1Binding3.blueWinLight) != null) {
                    imageView3.setVisibility(0);
                }
            } else {
                User winUser2 = data.getWinUser();
                if (winUser2 != null) {
                    str3 = winUser2.getExternalId();
                } else {
                    str3 = null;
                }
                Pk1v1Data mPK1v12 = meetingRoomManager.getMPK1v1();
                if (mPK1v12 != null && (user2 = mPK1v12.getUser2()) != null) {
                    str4 = user2.getExternalId();
                } else {
                    str4 = null;
                }
                if (Intrinsics.areEqual(str3, str4)) {
                    RoomPk1v1Binding roomPk1v1Binding4 = this.binding;
                    if (roomPk1v1Binding4 != null && (imageView2 = roomPk1v1Binding4.redWinHead) != null) {
                        imageView2.setVisibility(0);
                    }
                    RoomPk1v1Binding roomPk1v1Binding5 = this.binding;
                    if (roomPk1v1Binding5 != null && (imageView = roomPk1v1Binding5.redWinLight) != null) {
                        imageView.setVisibility(0);
                    }
                }
            }
            Long endUnix = data.getEndUnix();
            if (endUnix != null) {
                j = endUnix.longValue();
            } else {
                j = 10;
            }
            this.endTime = j;
            refreshView();
            RoomPk1v1Binding roomPk1v1Binding6 = this.binding;
            float f2 = 0.5f;
            if (roomPk1v1Binding6 != null && (qMUIRadiusImageView2 = roomPk1v1Binding6.blueAvatar) != null) {
                User winUser3 = data.getWinUser();
                if (winUser3 != null) {
                    str6 = winUser3.getExternalId();
                } else {
                    str6 = null;
                }
                Pk1v1Data mPK1v13 = meetingRoomManager.getMPK1v1();
                if (mPK1v13 != null && (user1 = mPK1v13.getUser1()) != null) {
                    str7 = user1.getExternalId();
                } else {
                    str7 = null;
                }
                if (Intrinsics.areEqual(str6, str7)) {
                    f = 1.0f;
                } else {
                    f = 0.5f;
                }
                qMUIRadiusImageView2.setAlpha(f);
            }
            RoomPk1v1Binding roomPk1v1Binding7 = this.binding;
            if (roomPk1v1Binding7 != null && (qMUIRadiusImageView = roomPk1v1Binding7.redAvatar) != null) {
                User winUser4 = data.getWinUser();
                if (winUser4 != null) {
                    str5 = winUser4.getExternalId();
                } else {
                    str5 = null;
                }
                Pk1v1Data mPK1v14 = meetingRoomManager.getMPK1v1();
                if (mPK1v14 != null && (user22 = mPK1v14.getUser2()) != null) {
                    str8 = user22.getExternalId();
                }
                if (Intrinsics.areEqual(str5, str8)) {
                    f2 = 1.0f;
                }
                qMUIRadiusImageView.setAlpha(f2);
            }
            if (data.getWinUser() != null) {
                showEndSvga(data);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x012d, code lost:
    
        if (r5 == 0) goto L٩٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshView() {
        long j;
        float f;
        long j2;
        long j3;
        long j4;
        long j5;
        boolean z;
        CustomProgressView customProgressView;
        CustomProgressView customProgressView2;
        Long diamond2;
        TextView textView;
        TextView textView2;
        QMUIRadiusImageView qMUIRadiusImageView;
        String str;
        TextView textView3;
        TextView textView4;
        String str2;
        QMUIRadiusImageView qMUIRadiusImageView2;
        String str3;
        Pk1v1Data mPK1v1 = MeetingRoomManager.INSTANCE.getMPK1v1();
        if (mPK1v1 != null) {
            RoomPk1v1Binding roomPk1v1Binding = this.binding;
            String str4 = null;
            if (roomPk1v1Binding != null && (qMUIRadiusImageView2 = roomPk1v1Binding.blueAvatar) != null) {
                User user1 = mPK1v1.getUser1();
                if (user1 != null) {
                    str3 = user1.getAvatar();
                } else {
                    str3 = null;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView2, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            RoomPk1v1Binding roomPk1v1Binding2 = this.binding;
            if (roomPk1v1Binding2 != null && (textView4 = roomPk1v1Binding2.blueNick) != null) {
                User user12 = mPK1v1.getUser1();
                if (user12 != null) {
                    str2 = user12.getNick();
                } else {
                    str2 = null;
                }
                textView4.setText(str2);
            }
            RoomPk1v1Binding roomPk1v1Binding3 = this.binding;
            if (roomPk1v1Binding3 != null && (textView3 = roomPk1v1Binding3.bluePoint) != null) {
                textView3.setText(String.valueOf(mPK1v1.getDiamond1()));
            }
            RoomPk1v1Binding roomPk1v1Binding4 = this.binding;
            if (roomPk1v1Binding4 != null && (qMUIRadiusImageView = roomPk1v1Binding4.redAvatar) != null) {
                User user2 = mPK1v1.getUser2();
                if (user2 != null) {
                    str = user2.getAvatar();
                } else {
                    str = null;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            RoomPk1v1Binding roomPk1v1Binding5 = this.binding;
            if (roomPk1v1Binding5 != null && (textView2 = roomPk1v1Binding5.redNick) != null) {
                User user22 = mPK1v1.getUser2();
                if (user22 != null) {
                    str4 = user22.getNick();
                }
                textView2.setText(str4);
            }
            RoomPk1v1Binding roomPk1v1Binding6 = this.binding;
            if (roomPk1v1Binding6 != null && (textView = roomPk1v1Binding6.redPoint) != null) {
                textView.setText(String.valueOf(mPK1v1.getDiamond2()));
            }
            Long diamond1 = mPK1v1.getDiamond1();
            long j6 = 0;
            if (diamond1 != null && diamond1.longValue() == 0 && (diamond2 = mPK1v1.getDiamond2()) != null && diamond2.longValue() == 0) {
                f = 50.0f;
            } else {
                Long diamond12 = mPK1v1.getDiamond1();
                if (diamond12 != null && diamond12.longValue() == 0) {
                    Long diamond22 = mPK1v1.getDiamond2();
                    if (diamond22 != null) {
                        j5 = diamond22.longValue();
                    } else {
                        j5 = 0;
                    }
                    if (j5 > 0) {
                        f = 0.0f;
                    }
                }
                Long diamond13 = mPK1v1.getDiamond1();
                if (diamond13 != null) {
                    j = diamond13.longValue();
                } else {
                    j = 0;
                }
                f = 100.0f;
                if (j > 0) {
                    Long diamond23 = mPK1v1.getDiamond2();
                    if (diamond23 != null) {
                        j4 = diamond23.longValue();
                    } else {
                        j4 = 0;
                    }
                }
                Long diamond14 = mPK1v1.getDiamond1();
                if (diamond14 != null) {
                    j2 = diamond14.longValue();
                } else {
                    j2 = 0;
                }
                float f2 = ((float) j2) * 100.0f;
                Long diamond15 = mPK1v1.getDiamond1();
                if (diamond15 != null) {
                    j3 = diamond15.longValue();
                } else {
                    j3 = 0;
                }
                Long diamond24 = mPK1v1.getDiamond2();
                if (diamond24 != null) {
                    j6 = diamond24.longValue();
                }
                f = f2 / ((float) (j3 + j6));
            }
            RoomPk1v1Binding roomPk1v1Binding7 = this.binding;
            if (roomPk1v1Binding7 != null && (customProgressView2 = roomPk1v1Binding7.progress) != null) {
                customProgressView2.setCurrentProgress(f);
            }
            RoomPk1v1Binding roomPk1v1Binding8 = this.binding;
            if (roomPk1v1Binding8 != null && (customProgressView = roomPk1v1Binding8.progress) != null) {
                customProgressView.post(new Runnable() { // from class: com.qiahao.nextvideo.room.help.f8
                    @Override // java.lang.Runnable
                    public final void run() {
                        Pk1v1Help.refreshView$lambda$6$lambda$5(Pk1v1Help.this);
                    }
                });
            }
            if (this.endTime > 10) {
                z = true;
            } else {
                z = false;
            }
            countDown(z);
            if (Intrinsics.areEqual(mPK1v1.getStart(), Boolean.TRUE)) {
                showStartSVGA();
                mPK1v1.setStart(Boolean.FALSE);
            }
        }
    }

    public final void release() {
        FrameLayout frameLayout;
        View root;
        FrameLayout frameLayout2;
        try {
            CountDownTimer countDownTimer = this.timerTask;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.timerTask = null;
            this.binding = null;
            this.endTime = 10L;
            Pk1v1WinBinding pk1v1WinBinding = this.endBinding;
            if (pk1v1WinBinding != null && (root = pk1v1WinBinding.getRoot()) != null) {
                FragmentAudioRoomBinding binding = this.fragment.getBinding();
                if (binding != null && (frameLayout2 = binding.frameLayout) != null) {
                    frameLayout2.removeView(root);
                }
                this.endBinding = null;
            }
            FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
            if (binding2 != null && (frameLayout = binding2.pk1v1) != null) {
                frameLayout.removeAllViews();
            }
            MeetingRoomManager.INSTANCE.setMPK1v1(null);
            AudioRoomFragmentHelp mAudioHelp = this.fragment.getMAudioHelp();
            if (mAudioHelp != null) {
                mAudioHelp.checkPlayLayout();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setBinding(@Nullable RoomPk1v1Binding roomPk1v1Binding) {
        this.binding = roomPk1v1Binding;
    }

    public final void setEndBinding(@Nullable Pk1v1WinBinding pk1v1WinBinding) {
        this.endBinding = pk1v1WinBinding;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setStartSVGA(@Nullable SVGAImageView sVGAImageView) {
        this.startSVGA = sVGAImageView;
    }

    public final void setTimerTask(@Nullable CountDownTimer countDownTimer) {
        this.timerTask = countDownTimer;
    }

    public final void showMicSpeakWaveAnim(@Nullable MicroBean mMicBean, @Nullable PortraitAnimationView speakWave) {
        String str;
        MicroUserBean user;
        MicroUserBean user2;
        MicroUserBean user3;
        if (mMicBean == null || !mMicBean.getMicForbid()) {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (mMicBean == null || (user3 = mMicBean.getUser()) == null || (str = user3.getExternalId()) == null) {
                str = "";
            }
            if (meetingRoomManager.haveLocalMute(str) || meetingRoomManager.checkGameMadel()) {
                return;
            }
            if (((mMicBean == null || (user2 = mMicBean.getUser()) == null) ? 0 : user2.getNoble()) <= 0) {
                Context context = this.fragment.getContext();
                if (context != null) {
                    int color = androidx.core.content.a.getColor(context, 2131101214);
                    if (speakWave != null) {
                        speakWave.setColor(color);
                    }
                }
            } else if (speakWave != null) {
                speakWave.setColor(UserService.Companion.getNobleColor$default(UserService.INSTANCE, (mMicBean == null || (user = mMicBean.getUser()) == null) ? 0 : user.getNoble(), 0, 2, null));
            }
            if (speakWave != null) {
                speakWave.e();
            }
        }
    }

    public final void showPk1v1() {
        long j;
        ConstraintLayout constraintLayout;
        View root;
        LinearLayout linearLayout;
        final QMUIRadiusImageView qMUIRadiusImageView;
        final QMUIRadiusImageView qMUIRadiusImageView2;
        FrameLayout frameLayout;
        Long unix;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMPK1v1() != null) {
            Pk1v1Data mPK1v1 = meetingRoomManager.getMPK1v1();
            if (mPK1v1 != null && (unix = mPK1v1.getUnix()) != null) {
                j = unix.longValue();
            } else {
                j = 0;
            }
            if (j >= V2TIMManager.getInstance().getServerTime()) {
                if (this.binding == null) {
                    FragmentActivity activity = this.fragment.getActivity();
                    Drawable drawable = null;
                    if (activity != null) {
                        if (!activity.isDestroyed() && !activity.isFinishing()) {
                            LayoutInflater from = LayoutInflater.from(activity);
                            FragmentAudioRoomBinding binding = this.fragment.getBinding();
                            if (binding != null) {
                                frameLayout = binding.pk1v1;
                            } else {
                                frameLayout = null;
                            }
                            this.binding = (RoomPk1v1Binding) androidx.databinding.g.h(from, R.layout.room_pk1v1, frameLayout, true);
                        } else {
                            return;
                        }
                    }
                    RoomPk1v1Binding roomPk1v1Binding = this.binding;
                    final long j2 = 800;
                    if (roomPk1v1Binding != null && (qMUIRadiusImageView2 = roomPk1v1Binding.blueAvatar) != null) {
                        qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.Pk1v1Help$showPk1v1$$inlined$singleClick$default$1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                String str;
                                User user1;
                                String externalId;
                                User user12;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j2 || (qMUIRadiusImageView2 instanceof Checkable)) {
                                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                                    QMUIRadiusImageView qMUIRadiusImageView3 = qMUIRadiusImageView2;
                                    AudioRoomDialogHelp mDialogHelp = this.getFragment().getMDialogHelp();
                                    if (mDialogHelp != null) {
                                        MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                                        Pk1v1Data mPK1v12 = meetingRoomManager2.getMPK1v1();
                                        String str2 = "";
                                        if (mPK1v12 == null || (user12 = mPK1v12.getUser1()) == null || (str = user12.getExternalId()) == null) {
                                            str = "";
                                        }
                                        Pk1v1Data mPK1v13 = meetingRoomManager2.getMPK1v1();
                                        if (mPK1v13 != null && (user1 = mPK1v13.getUser1()) != null && (externalId = user1.getExternalId()) != null) {
                                            str2 = externalId;
                                        }
                                        mDialogHelp.showUserInfoDialog(str, meetingRoomManager2.findMicPositionFromExtraId(str2));
                                    }
                                }
                            }
                        });
                    }
                    RoomPk1v1Binding roomPk1v1Binding2 = this.binding;
                    if (roomPk1v1Binding2 != null && (qMUIRadiusImageView = roomPk1v1Binding2.redAvatar) != null) {
                        qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.help.Pk1v1Help$showPk1v1$$inlined$singleClick$default$2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                String str;
                                User user2;
                                String externalId;
                                User user22;
                                long currentTimeMillis = System.currentTimeMillis();
                                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j2 || (qMUIRadiusImageView instanceof Checkable)) {
                                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                                    QMUIRadiusImageView qMUIRadiusImageView3 = qMUIRadiusImageView;
                                    AudioRoomDialogHelp mDialogHelp = this.getFragment().getMDialogHelp();
                                    if (mDialogHelp != null) {
                                        MeetingRoomManager meetingRoomManager2 = MeetingRoomManager.INSTANCE;
                                        Pk1v1Data mPK1v12 = meetingRoomManager2.getMPK1v1();
                                        String str2 = "";
                                        if (mPK1v12 == null || (user22 = mPK1v12.getUser2()) == null || (str = user22.getExternalId()) == null) {
                                            str = "";
                                        }
                                        Pk1v1Data mPK1v13 = meetingRoomManager2.getMPK1v1();
                                        if (mPK1v13 != null && (user2 = mPK1v13.getUser2()) != null && (externalId = user2.getExternalId()) != null) {
                                            str2 = externalId;
                                        }
                                        mDialogHelp.showUserInfoDialog(str, meetingRoomManager2.findMicPositionFromExtraId(str2));
                                    }
                                }
                            }
                        });
                    }
                    RoomPk1v1Binding roomPk1v1Binding3 = this.binding;
                    if (roomPk1v1Binding3 != null && (linearLayout = roomPk1v1Binding3.topLayout) != null) {
                        Context context = this.fragment.getContext();
                        if (context != null) {
                            drawable = ShapeUtil.INSTANCE.createShape(context, 2131099898, 2131099898, 0, 0, 8, 8, GradientDrawable.Orientation.LEFT_RIGHT);
                        }
                        linearLayout.setBackground(drawable);
                    }
                    RoomPk1v1Binding roomPk1v1Binding4 = this.binding;
                    if (roomPk1v1Binding4 != null && (root = roomPk1v1Binding4.getRoot()) != null) {
                        root.setAlpha(0.0f);
                    }
                    RoomPk1v1Binding roomPk1v1Binding5 = this.binding;
                    if (roomPk1v1Binding5 != null && (constraintLayout = roomPk1v1Binding5.constraint) != null) {
                        ImageKtxKt.toHorizontalMirror(constraintLayout, R.drawable.pk1v1_on_bg);
                    }
                    startOrEndAnimation(false);
                }
                refreshView();
                AudioRoomFragmentHelp mAudioHelp = this.fragment.getMAudioHelp();
                if (mAudioHelp != null) {
                    mAudioHelp.checkPlayLayout();
                }
            }
        }
    }

    public final void startOrEndAnimation(final boolean isEnd) {
        View root;
        RoomPk1v1Binding roomPk1v1Binding = this.binding;
        if (roomPk1v1Binding != null && (root = roomPk1v1Binding.getRoot()) != null) {
            root.post(new Runnable() { // from class: com.qiahao.nextvideo.room.help.g8
                @Override // java.lang.Runnable
                public final void run() {
                    Pk1v1Help.startOrEndAnimation$lambda$10(Pk1v1Help.this, isEnd);
                }
            });
        }
    }

    public final void showMicSpeakWaveAnim(@NotNull List<Integer> list) {
        User user2;
        User user1;
        Intrinsics.checkNotNullParameter(list, "list");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(meetingRoomManager, false, 1, null).get(Integer.valueOf(intValue));
            if (microBean != null) {
                MicroUserBean user = microBean.getUser();
                String externalId = user != null ? user.getExternalId() : null;
                Pk1v1Data mPK1v1 = meetingRoomManager.getMPK1v1();
                if (Intrinsics.areEqual(externalId, (mPK1v1 == null || (user1 = mPK1v1.getUser1()) == null) ? null : user1.getExternalId())) {
                    RoomPk1v1Binding roomPk1v1Binding = this.binding;
                    showMicSpeakWaveAnim(microBean, roomPk1v1Binding != null ? roomPk1v1Binding.blueSpeakWave : null);
                }
            }
            if (microBean != null) {
                MicroUserBean user3 = microBean.getUser();
                String externalId2 = user3 != null ? user3.getExternalId() : null;
                Pk1v1Data mPK1v12 = meetingRoomManager.getMPK1v1();
                if (Intrinsics.areEqual(externalId2, (mPK1v12 == null || (user2 = mPK1v12.getUser2()) == null) ? null : user2.getExternalId())) {
                    RoomPk1v1Binding roomPk1v1Binding2 = this.binding;
                    showMicSpeakWaveAnim(microBean, roomPk1v1Binding2 != null ? roomPk1v1Binding2.redSpeakWave : null);
                }
            }
        }
    }
}
