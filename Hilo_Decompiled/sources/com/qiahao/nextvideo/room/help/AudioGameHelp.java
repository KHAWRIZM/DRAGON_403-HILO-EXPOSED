package com.qiahao.nextvideo.room.help;

import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.game.SUDGameAward;
import com.qiahao.nextvideo.data.game.YouTuGameData;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBeanList;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.room.RoomPK;
import com.qiahao.nextvideo.databinding.FragmentAudioRoomBinding;
import com.qiahao.nextvideo.room.fragment.AudioRoomFragment;
import com.qiahao.nextvideo.room.game.GameMicAdapter;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.view.MeetingRoomOnlineMemberLayout;
import com.qiahao.nextvideo.room.view.micro.NewMicroView;
import com.qiahao.nextvideo.sud.GameViewModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010w\u001a\u00020x2\u0006\u0010y\u001a\u00020\u000f2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010{H\u0002J\u001a\u0010|\u001a\u00020x2\u0006\u0010y\u001a\u00020\u000f2\n\b\u0002\u0010z\u001a\u0004\u0018\u00010{J\u0006\u0010}\u001a\u00020xJ\u0019\u0010~\u001a\u00020x2\u0011\b\u0002\u0010\u007f\u001a\u000b\u0012\u0004\u0012\u00020x\u0018\u00010\u0080\u0001J\u0011\u0010\u0081\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020\u000fH\u0002J\u000f\u0010\u0082\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020\u000fJ\u0011\u0010\u0083\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020\u000fH\u0002J\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\u0012\u0010\u0086\u0001\u001a\u00030\u0085\u00012\u0006\u0010y\u001a\u00020\u000fH\u0002J\u0011\u0010\u0087\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020\u000fH\u0002J\u0011\u0010\u0088\u0001\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u000fH\u0002J\u0019\u0010\u0089\u0001\u001a\u00020x2\b\u0010\u008a\u0001\u001a\u00030\u0085\u00012\u0006\u0010y\u001a\u00020\u000fJ\b\u0010\u008b\u0001\u001a\u00030\u0085\u0001J\u0007\u0010\u008c\u0001\u001a\u00020xJ\u0007\u0010\u008d\u0001\u001a\u00020xJ#\u0010\u008e\u0001\u001a\u00020x2\u000e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0090\u00012\n\b\u0002\u0010\u0091\u0001\u001a\u00030\u0085\u0001J\u001a\u0010\u0092\u0001\u001a\u00020x2\u0007\u0010\u0093\u0001\u001a\u00020\u000f2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001J\u0010\u0010\u0096\u0001\u001a\u00020x2\u0007\u0010\u0093\u0001\u001a\u00020\u000fJ\u0010\u0010\u0097\u0001\u001a\u00020x2\u0007\u0010\u0098\u0001\u001a\u00020\u000fJ\u0011\u0010\u0099\u0001\u001a\u00020x2\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001J\b\u0010\u009c\u0001\u001a\u00030\u0085\u0001J\u0007\u0010\u009d\u0001\u001a\u00020xJ\b\u0010\u009e\u0001\u001a\u00030\u0085\u0001J\u001a\u0010\u009f\u0001\u001a\u00020x2\u0006\u0010y\u001a\u00020\u000f2\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0001J\u001f\u0010 \u0001\u001a\u00020x2\n\b\u0002\u0010¡\u0001\u001a\u00030\u0085\u00012\n\b\u0002\u0010¢\u0001\u001a\u00030\u0085\u0001J\u0007\u0010£\u0001\u001a\u00020xR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001c\u0010 \u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u001c\u0010&\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001c\u0010)\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001c\u0010,\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001c\u0010/\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R\u001b\u00105\u001a\u0002068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b7\u00108R\u001b\u0010;\u001a\u00020<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010:\u001a\u0004\b=\u0010>R\u001b\u0010@\u001a\u00020A8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010:\u001a\u0004\bB\u0010CR\u001b\u0010E\u001a\u00020F8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bI\u0010:\u001a\u0004\bG\u0010HR\u001b\u0010J\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010:\u001a\u0004\bL\u0010MR\u001b\u0010O\u001a\u00020P8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010:\u001a\u0004\bQ\u0010RR\u001b\u0010T\u001a\u00020U8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010:\u001a\u0004\bV\u0010WR\u001b\u0010Y\u001a\u00020Z8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010:\u001a\u0004\b[\u0010\\R\u001b\u0010^\u001a\u00020_8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010:\u001a\u0004\b`\u0010aR\u001b\u0010c\u001a\u00020d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010:\u001a\u0004\be\u0010fR\u001b\u0010h\u001a\u00020i8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010:\u001a\u0004\bj\u0010kR\u001b\u0010m\u001a\u00020n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bq\u0010:\u001a\u0004\bo\u0010pR\u001b\u0010r\u001a\u00020s8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bv\u0010:\u001a\u0004\bt\u0010u¨\u0006¤\u0001"}, d2 = {"Lcom/qiahao/nextvideo/room/help/AudioGameHelp;", "", "fragment", "Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "<init>", "(Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;)V", "getFragment", "()Lcom/qiahao/nextvideo/room/fragment/AudioRoomFragment;", "mGameView", "Landroid/view/View;", "getMGameView", "()Landroid/view/View;", "setMGameView", "(Landroid/view/View;)V", "defaultHeight", "", "getDefaultHeight", "()I", "setDefaultHeight", "(I)V", "gameHeight", "getGameHeight", "setGameHeight", "pkAnimatorSetShow", "Landroid/animation/AnimatorSet;", "getPkAnimatorSetShow", "()Landroid/animation/AnimatorSet;", "setPkAnimatorSetShow", "(Landroid/animation/AnimatorSet;)V", "pkAnimatorSetHide", "getPkAnimatorSetHide", "setPkAnimatorSetHide", "sudAnimatorSetShow", "getSudAnimatorSetShow", "setSudAnimatorSetShow", "sudAnimatorSetHide", "getSudAnimatorSetHide", "setSudAnimatorSetHide", "chatAnimatorSetShow", "getChatAnimatorSetShow", "setChatAnimatorSetShow", "chatAnimatorSetHide", "getChatAnimatorSetHide", "setChatAnimatorSetHide", "hiloGameAnimatorSetShow", "getHiloGameAnimatorSetShow", "setHiloGameAnimatorSetShow", "hiloGameAnimatorSetHide", "getHiloGameAnimatorSetHide", "setHiloGameAnimatorSetHide", "showGameType", "getShowGameType", "setShowGameType", "mLudoHelp", "Lcom/qiahao/nextvideo/room/help/LudoGameHelp;", "getMLudoHelp", "()Lcom/qiahao/nextvideo/room/help/LudoGameHelp;", "mLudoHelp$delegate", "Lkotlin/Lazy;", "mUnoHelp", "Lcom/qiahao/nextvideo/room/help/UnoGameHelp;", "getMUnoHelp", "()Lcom/qiahao/nextvideo/room/help/UnoGameHelp;", "mUnoHelp$delegate", "mDominoHelp", "Lcom/qiahao/nextvideo/room/help/DominoGameHelp;", "getMDominoHelp", "()Lcom/qiahao/nextvideo/room/help/DominoGameHelp;", "mDominoHelp$delegate", "mCrushHelp", "Lcom/qiahao/nextvideo/room/help/CrushGameHelp;", "getMCrushHelp", "()Lcom/qiahao/nextvideo/room/help/CrushGameHelp;", "mCrushHelp$delegate", "mBalootHelp", "Lcom/qiahao/nextvideo/room/help/BalootGameHelp;", "getMBalootHelp", "()Lcom/qiahao/nextvideo/room/help/BalootGameHelp;", "mBalootHelp$delegate", "mPKGameHelp", "Lcom/qiahao/nextvideo/room/help/PKGameHelp;", "getMPKGameHelp", "()Lcom/qiahao/nextvideo/room/help/PKGameHelp;", "mPKGameHelp$delegate", "mYouTuBe", "Lcom/qiahao/nextvideo/room/help/YouTuBeHelper;", "getMYouTuBe", "()Lcom/qiahao/nextvideo/room/help/YouTuBeHelper;", "mYouTuBe$delegate", "mEnvelopeHelper", "Lcom/qiahao/nextvideo/room/help/EnvelopeHelper;", "getMEnvelopeHelper", "()Lcom/qiahao/nextvideo/room/help/EnvelopeHelper;", "mEnvelopeHelper$delegate", "mCarromGameHelp", "Lcom/qiahao/nextvideo/room/help/CarromGameHelp;", "getMCarromGameHelp", "()Lcom/qiahao/nextvideo/room/help/CarromGameHelp;", "mCarromGameHelp$delegate", "mJackaroGameHelp", "Lcom/qiahao/nextvideo/room/help/JackaroGameHelp;", "getMJackaroGameHelp", "()Lcom/qiahao/nextvideo/room/help/JackaroGameHelp;", "mJackaroGameHelp$delegate", "mPk1v1Help", "Lcom/qiahao/nextvideo/room/help/Pk1v1Help;", "getMPk1v1Help", "()Lcom/qiahao/nextvideo/room/help/Pk1v1Help;", "mPk1v1Help$delegate", "mHiloGameHelp", "Lcom/qiahao/nextvideo/room/help/HiloGameHelp;", "getMHiloGameHelp", "()Lcom/qiahao/nextvideo/room/help/HiloGameHelp;", "mHiloGameHelp$delegate", "mBackgammonGameHelp", "Lcom/qiahao/nextvideo/room/help/BackgammonGameHelp;", "getMBackgammonGameHelp", "()Lcom/qiahao/nextvideo/room/help/BackgammonGameHelp;", "mBackgammonGameHelp$delegate", "createGame", "", "gameType", "gameConfiguration", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "showGameView", "hideRoomEffect", "hideGameView", "complete", "Lkotlin/Function0;", "addGameView", "refreshGameData", "loadGame", "checkGameIsShow", "", "canShowGame", "initGameView", "getPlayGameHeight", "setBg", "isShow", "isPlayGame", "changeGameMicType", "notificationMicChange", "showMicSpeakWaveAnim", "list", "", "isOther", "showFace", "position", "url", "", "refreshPosition", "refreshSVIP", "level", "refreshOnlineNumber", "data", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBeanList;", "checkJoinGame", "resetVideo", "checkYouTuVideo", "showGameEnd", "releaseGame", "isDelay", "callReport", "releaseAnimation", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAudioGameHelp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AudioGameHelp.kt\ncom/qiahao/nextvideo/room/help/AudioGameHelp\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,879:1\n255#2:880\n297#2:881\n297#2:882\n297#2:883\n297#2:884\n297#2:885\n297#2:886\n297#2:887\n297#2:888\n297#2:889\n297#2:890\n297#2:891\n51#3:892\n1878#4,3:893\n*S KotlinDebug\n*F\n+ 1 AudioGameHelp.kt\ncom/qiahao/nextvideo/room/help/AudioGameHelp\n*L\n341#1:880\n346#1:881\n348#1:882\n350#1:883\n352#1:884\n354#1:885\n357#1:886\n360#1:887\n362#1:888\n364#1:889\n366#1:890\n368#1:891\n509#1:892\n551#1:893,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AudioGameHelp {

    @Nullable
    private AnimatorSet chatAnimatorSetHide;

    @Nullable
    private AnimatorSet chatAnimatorSetShow;
    private int defaultHeight;

    @NotNull
    private final AudioRoomFragment fragment;
    private int gameHeight;

    @Nullable
    private AnimatorSet hiloGameAnimatorSetHide;

    @Nullable
    private AnimatorSet hiloGameAnimatorSetShow;

    /* renamed from: mBackgammonGameHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBackgammonGameHelp;

    /* renamed from: mBalootHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mBalootHelp;

    /* renamed from: mCarromGameHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCarromGameHelp;

    /* renamed from: mCrushHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mCrushHelp;

    /* renamed from: mDominoHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDominoHelp;

    /* renamed from: mEnvelopeHelper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mEnvelopeHelper;

    @Nullable
    private View mGameView;

    /* renamed from: mHiloGameHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mHiloGameHelp;

    /* renamed from: mJackaroGameHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mJackaroGameHelp;

    /* renamed from: mLudoHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLudoHelp;

    /* renamed from: mPKGameHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPKGameHelp;

    /* renamed from: mPk1v1Help$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPk1v1Help;

    /* renamed from: mUnoHelp$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mUnoHelp;

    /* renamed from: mYouTuBe$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mYouTuBe;

    @Nullable
    private AnimatorSet pkAnimatorSetHide;

    @Nullable
    private AnimatorSet pkAnimatorSetShow;
    private int showGameType;

    @Nullable
    private AnimatorSet sudAnimatorSetHide;

    @Nullable
    private AnimatorSet sudAnimatorSetShow;

    public AudioGameHelp(@NotNull AudioRoomFragment audioRoomFragment) {
        Intrinsics.checkNotNullParameter(audioRoomFragment, "fragment");
        this.fragment = audioRoomFragment;
        this.mLudoHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.h
            public final Object invoke() {
                LudoGameHelp mLudoHelp_delegate$lambda$0;
                mLudoHelp_delegate$lambda$0 = AudioGameHelp.mLudoHelp_delegate$lambda$0(AudioGameHelp.this);
                return mLudoHelp_delegate$lambda$0;
            }
        });
        this.mUnoHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.l
            public final Object invoke() {
                UnoGameHelp mUnoHelp_delegate$lambda$1;
                mUnoHelp_delegate$lambda$1 = AudioGameHelp.mUnoHelp_delegate$lambda$1(AudioGameHelp.this);
                return mUnoHelp_delegate$lambda$1;
            }
        });
        this.mDominoHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.m
            public final Object invoke() {
                DominoGameHelp mDominoHelp_delegate$lambda$2;
                mDominoHelp_delegate$lambda$2 = AudioGameHelp.mDominoHelp_delegate$lambda$2(AudioGameHelp.this);
                return mDominoHelp_delegate$lambda$2;
            }
        });
        this.mCrushHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.n
            public final Object invoke() {
                CrushGameHelp mCrushHelp_delegate$lambda$3;
                mCrushHelp_delegate$lambda$3 = AudioGameHelp.mCrushHelp_delegate$lambda$3(AudioGameHelp.this);
                return mCrushHelp_delegate$lambda$3;
            }
        });
        this.mBalootHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.o
            public final Object invoke() {
                BalootGameHelp mBalootHelp_delegate$lambda$4;
                mBalootHelp_delegate$lambda$4 = AudioGameHelp.mBalootHelp_delegate$lambda$4(AudioGameHelp.this);
                return mBalootHelp_delegate$lambda$4;
            }
        });
        this.mPKGameHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.p
            public final Object invoke() {
                PKGameHelp mPKGameHelp_delegate$lambda$5;
                mPKGameHelp_delegate$lambda$5 = AudioGameHelp.mPKGameHelp_delegate$lambda$5(AudioGameHelp.this);
                return mPKGameHelp_delegate$lambda$5;
            }
        });
        this.mYouTuBe = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.b
            public final Object invoke() {
                YouTuBeHelper mYouTuBe_delegate$lambda$6;
                mYouTuBe_delegate$lambda$6 = AudioGameHelp.mYouTuBe_delegate$lambda$6(AudioGameHelp.this);
                return mYouTuBe_delegate$lambda$6;
            }
        });
        this.mEnvelopeHelper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.c
            public final Object invoke() {
                EnvelopeHelper mEnvelopeHelper_delegate$lambda$7;
                mEnvelopeHelper_delegate$lambda$7 = AudioGameHelp.mEnvelopeHelper_delegate$lambda$7(AudioGameHelp.this);
                return mEnvelopeHelper_delegate$lambda$7;
            }
        });
        this.mCarromGameHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.d
            public final Object invoke() {
                CarromGameHelp mCarromGameHelp_delegate$lambda$8;
                mCarromGameHelp_delegate$lambda$8 = AudioGameHelp.mCarromGameHelp_delegate$lambda$8(AudioGameHelp.this);
                return mCarromGameHelp_delegate$lambda$8;
            }
        });
        this.mJackaroGameHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.e
            public final Object invoke() {
                JackaroGameHelp mJackaroGameHelp_delegate$lambda$9;
                mJackaroGameHelp_delegate$lambda$9 = AudioGameHelp.mJackaroGameHelp_delegate$lambda$9(AudioGameHelp.this);
                return mJackaroGameHelp_delegate$lambda$9;
            }
        });
        this.mPk1v1Help = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.i
            public final Object invoke() {
                Pk1v1Help mPk1v1Help_delegate$lambda$10;
                mPk1v1Help_delegate$lambda$10 = AudioGameHelp.mPk1v1Help_delegate$lambda$10(AudioGameHelp.this);
                return mPk1v1Help_delegate$lambda$10;
            }
        });
        this.mHiloGameHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.j
            public final Object invoke() {
                HiloGameHelp mHiloGameHelp_delegate$lambda$11;
                mHiloGameHelp_delegate$lambda$11 = AudioGameHelp.mHiloGameHelp_delegate$lambda$11(AudioGameHelp.this);
                return mHiloGameHelp_delegate$lambda$11;
            }
        });
        this.mBackgammonGameHelp = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.help.k
            public final Object invoke() {
                BackgammonGameHelp mBackgammonGameHelp_delegate$lambda$12;
                mBackgammonGameHelp_delegate$lambda$12 = AudioGameHelp.mBackgammonGameHelp_delegate$lambda$12(AudioGameHelp.this);
                return mBackgammonGameHelp_delegate$lambda$12;
            }
        });
    }

    private final void addGameView(int gameType) {
        if (gameType != 1) {
            if (gameType != 2) {
                if (gameType != 10) {
                    if (gameType != 11) {
                        if (gameType != 13) {
                            if (gameType != 14) {
                                if (gameType != 18) {
                                    if (gameType != 21) {
                                        if (gameType == 23) {
                                            this.mGameView = getMBackgammonGameHelp().addBackgammonGameView();
                                            return;
                                        }
                                        return;
                                    }
                                    this.mGameView = getMJackaroGameHelp().addJackarooGameView();
                                    return;
                                }
                                this.mGameView = getMCarromGameHelp().addCarromGameView();
                                return;
                            }
                            this.mGameView = getMBalootHelp().addBalootGameView();
                            return;
                        }
                        this.mGameView = getMYouTuBe().addYouTuBeView();
                        return;
                    }
                    this.mGameView = getMCrushHelp().addCrushGameView();
                    return;
                }
                this.mGameView = getMDominoHelp().addDominoGameView();
                return;
            }
            this.mGameView = getMUnoHelp().addUnoGameView();
            return;
        }
        this.mGameView = getMLudoHelp().addLudoGameView();
    }

    private final boolean canShowGame(int gameType) {
        FragmentAudioRoomBinding binding;
        FrameLayout frameLayout;
        FragmentAudioRoomBinding binding2;
        FrameLayout frameLayout2;
        FragmentAudioRoomBinding binding3;
        FrameLayout frameLayout3;
        FragmentAudioRoomBinding binding4;
        FrameLayout frameLayout4;
        FragmentAudioRoomBinding binding5;
        FrameLayout frameLayout5;
        YouTuGameData mYouTuBe;
        FragmentAudioRoomBinding binding6;
        FrameLayout frameLayout6;
        Integer type;
        MeetingRoomManager meetingRoomManager;
        RoomPK mpk;
        RoomPK mpk2;
        FragmentAudioRoomBinding binding7;
        FrameLayout frameLayout7;
        FragmentAudioRoomBinding binding8;
        FrameLayout frameLayout8;
        FragmentAudioRoomBinding binding9;
        FrameLayout frameLayout9;
        FragmentAudioRoomBinding binding10;
        FrameLayout frameLayout10;
        FragmentAudioRoomBinding binding11;
        FrameLayout frameLayout11;
        if (gameType == 1 && MeetingRoomManager.INSTANCE.getMLudoGameData() != null && (binding11 = this.fragment.getBinding()) != null && (frameLayout11 = binding11.gameLayout) != null && frameLayout11.getVisibility() == 8) {
            return true;
        }
        if (gameType == 2 && MeetingRoomManager.INSTANCE.getMUnoGameData() != null && (binding10 = this.fragment.getBinding()) != null && (frameLayout10 = binding10.gameLayout) != null && frameLayout10.getVisibility() == 8) {
            return true;
        }
        if (gameType == 10 && MeetingRoomManager.INSTANCE.getMDominoGameData() != null && (binding9 = this.fragment.getBinding()) != null && (frameLayout9 = binding9.gameLayout) != null && frameLayout9.getVisibility() == 8) {
            return true;
        }
        if (gameType == 11 && MeetingRoomManager.INSTANCE.getMCrushGameData() != null && (binding8 = this.fragment.getBinding()) != null && (frameLayout8 = binding8.gameLayout) != null && frameLayout8.getVisibility() == 8) {
            return true;
        }
        if (gameType == 12 && ((((mpk = (meetingRoomManager = MeetingRoomManager.INSTANCE).getMPK()) != null && mpk.getStatus() == 1) || ((mpk2 = meetingRoomManager.getMPK()) != null && mpk2.getStatus() == 2)) && (binding7 = this.fragment.getBinding()) != null && (frameLayout7 = binding7.gameLayout) != null && frameLayout7.getVisibility() == 8)) {
            return true;
        }
        if (gameType == 13 && (((mYouTuBe = MeetingRoomManager.INSTANCE.getMYouTuBe()) == null || (type = mYouTuBe.getType()) == null || type.intValue() != 4) && (binding6 = this.fragment.getBinding()) != null && (frameLayout6 = binding6.gameLayout) != null && frameLayout6.getVisibility() == 8)) {
            return true;
        }
        if (gameType == 14 && MeetingRoomManager.INSTANCE.getMBalootGameData() != null && (binding5 = this.fragment.getBinding()) != null && (frameLayout5 = binding5.gameLayout) != null && frameLayout5.getVisibility() == 8) {
            return true;
        }
        if (gameType == 18 && MeetingRoomManager.INSTANCE.getMCarromGameData() != null && (binding4 = this.fragment.getBinding()) != null && (frameLayout4 = binding4.gameLayout) != null && frameLayout4.getVisibility() == 8) {
            return true;
        }
        if (gameType == 21 && MeetingRoomManager.INSTANCE.getMJackaroGameData() != null && (binding3 = this.fragment.getBinding()) != null && (frameLayout3 = binding3.gameLayout) != null && frameLayout3.getVisibility() == 8) {
            return true;
        }
        if (gameType == 23 && MeetingRoomManager.INSTANCE.getMBackgammonGameData() != null && (binding2 = this.fragment.getBinding()) != null && (frameLayout2 = binding2.gameLayout) != null && frameLayout2.getVisibility() == 8) {
            return true;
        }
        if (gameType == 22 && (binding = this.fragment.getBinding()) != null && (frameLayout = binding.gameLayout) != null && frameLayout.getVisibility() == 8 && getMHiloGameHelp().getBinding() == null) {
            return true;
        }
        return false;
    }

    private final void createGame(int gameType, GameConfiguration gameConfiguration) {
        if (gameType != 12) {
            if (gameType != 22) {
                initGameView(gameType);
                addGameView(gameType);
                refreshGameData(gameType);
                loadGame(gameType);
                return;
            }
            this.mGameView = getMHiloGameHelp().addHiloGameView(gameConfiguration);
            return;
        }
        this.mGameView = getMPKGameHelp().addPKGameView();
    }

    static /* synthetic */ void createGame$default(AudioGameHelp audioGameHelp, int i, GameConfiguration gameConfiguration, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            gameConfiguration = null;
        }
        audioGameHelp.createGame(i, gameConfiguration);
    }

    private final int getPlayGameHeight(int gameType) {
        View root;
        View root2;
        View root3;
        View root4;
        View root5;
        View root6;
        View root7;
        View root8;
        View root9;
        int px = UiKtxKt.toPX(420);
        int i = 0;
        if (gameType != 1) {
            if (gameType != 2) {
                if (gameType != 10) {
                    if (gameType != 11) {
                        if (gameType != 13) {
                            if (gameType != 14) {
                                if (gameType != 18) {
                                    if (gameType != 21) {
                                        if (gameType != 23) {
                                            return px;
                                        }
                                        FragmentAudioRoomBinding binding = this.fragment.getBinding();
                                        if (binding != null && (root9 = binding.getRoot()) != null) {
                                            i = root9.getWidth();
                                        }
                                        int i2 = (i * 80) / 62;
                                        if (i2 > px) {
                                            return i2;
                                        }
                                        return px;
                                    }
                                    FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                                    if (binding2 != null && (root8 = binding2.getRoot()) != null) {
                                        i = root8.getWidth();
                                    }
                                    int i3 = (i * 80) / 62;
                                    if (i3 > px) {
                                        return i3;
                                    }
                                    return px;
                                }
                                FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                                if (binding3 != null && (root7 = binding3.getRoot()) != null) {
                                    i = root7.getWidth();
                                }
                                int i4 = (i * 80) / 62;
                                if (i4 > px) {
                                    return i4;
                                }
                                return px;
                            }
                            FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
                            if (binding4 != null && (root6 = binding4.getRoot()) != null) {
                                i = root6.getWidth();
                            }
                            int i5 = (i * 80) / 68;
                            if (i5 > px) {
                                return i5;
                            }
                            return px;
                        }
                        FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
                        if (binding5 != null && (root5 = binding5.getRoot()) != null) {
                            i = root5.getWidth();
                        }
                        return (i * 9) / 16;
                    }
                    FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
                    if (binding6 != null && (root4 = binding6.getRoot()) != null) {
                        i = root4.getWidth();
                    }
                    int i6 = (i * 80) / 70;
                    if (i6 > px) {
                        return i6;
                    }
                    return px;
                }
                FragmentAudioRoomBinding binding7 = this.fragment.getBinding();
                if (binding7 != null && (root3 = binding7.getRoot()) != null) {
                    i = root3.getWidth();
                }
                int i7 = (i * 80) / 72;
                if (i7 > px) {
                    return i7;
                }
                return px;
            }
            FragmentAudioRoomBinding binding8 = this.fragment.getBinding();
            if (binding8 != null && (root2 = binding8.getRoot()) != null) {
                i = root2.getWidth();
            }
            int i8 = (i * 80) / 72;
            if (i8 > px) {
                return i8;
            }
            return px;
        }
        FragmentAudioRoomBinding binding9 = this.fragment.getBinding();
        if (binding9 != null && (root = binding9.getRoot()) != null) {
            i = root.getWidth();
        }
        int i9 = (i * 80) / 72;
        if (i9 > px) {
            return i9;
        }
        return px;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hideGameView$default(AudioGameHelp audioGameHelp, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        audioGameHelp.hideGameView(function0);
    }

    private final void initGameView(int gameType) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        FrameLayout frameLayout;
        ConstraintLayout constraintLayout;
        FrameLayout frameLayout2;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (frameLayout2 = binding.gameLayout) != null) {
            layoutParams = frameLayout2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
        int i2 = 0;
        if (binding2 != null && (constraintLayout = binding2.centerLayout) != null) {
            i = constraintLayout.getHeight();
        } else {
            i = 0;
        }
        if (layoutParams != null) {
            layoutParams.height = i - UiKtxKt.toPX(56);
        }
        if (layoutParams != null) {
            i2 = layoutParams.height;
        }
        this.defaultHeight = i2;
        this.gameHeight = getPlayGameHeight(gameType) - this.defaultHeight;
        FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
        if (binding3 != null && (frameLayout = binding3.gameLayout) != null) {
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    private final void loadGame(final int gameType) {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.help.g
            @Override // java.lang.Runnable
            public final void run() {
                AudioGameHelp.loadGame$lambda$17(AudioGameHelp.this, gameType);
            }
        }, 500L);
    }

    public static final void loadGame$lambda$17(AudioGameHelp audioGameHelp, int i) {
        GameViewModel gameViewModel;
        FragmentActivity activity = audioGameHelp.fragment.getActivity();
        if (activity != null) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 10) {
                        if (i != 11) {
                            if (i != 14) {
                                if (i != 18) {
                                    if (i != 21) {
                                        if (i == 23 && (gameViewModel = audioGameHelp.getMBackgammonGameHelp().getGameViewModel()) != null) {
                                            gameViewModel.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1925744787773059073L);
                                            return;
                                        }
                                        return;
                                    }
                                    GameViewModel gameViewModel2 = audioGameHelp.getMJackaroGameHelp().getGameViewModel();
                                    if (gameViewModel2 != null) {
                                        gameViewModel2.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1848188045807976450L);
                                        return;
                                    }
                                    return;
                                }
                                GameViewModel gameViewModel3 = audioGameHelp.getMCarromGameHelp().getGameViewModel();
                                if (gameViewModel3 != null) {
                                    gameViewModel3.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1777154372100497410L);
                                    return;
                                }
                                return;
                            }
                            GameViewModel gameViewModel4 = audioGameHelp.getMBalootHelp().getGameViewModel();
                            if (gameViewModel4 != null) {
                                gameViewModel4.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1759471374694019074L);
                                return;
                            }
                            return;
                        }
                        GameViewModel gameViewModel5 = audioGameHelp.getMCrushHelp().getGameViewModel();
                        if (gameViewModel5 != null) {
                            gameViewModel5.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1664525565526667266L);
                            return;
                        }
                        return;
                    }
                    GameViewModel gameViewModel6 = audioGameHelp.getMDominoHelp().getGameViewModel();
                    if (gameViewModel6 != null) {
                        gameViewModel6.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1537330258004504578L);
                        return;
                    }
                    return;
                }
                GameViewModel gameViewModel7 = audioGameHelp.getMUnoHelp().getGameViewModel();
                if (gameViewModel7 != null) {
                    gameViewModel7.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1472142559912517633L);
                    return;
                }
                return;
            }
            GameViewModel gameViewModel8 = audioGameHelp.getMLudoHelp().getGameViewModel();
            if (gameViewModel8 != null) {
                gameViewModel8.switchGame(activity, MeetingRoomManager.INSTANCE.getMGroupId(), 1468180338417074177L);
            }
        }
    }

    public static final BackgammonGameHelp mBackgammonGameHelp_delegate$lambda$12(AudioGameHelp audioGameHelp) {
        return new BackgammonGameHelp(audioGameHelp.fragment);
    }

    public static final BalootGameHelp mBalootHelp_delegate$lambda$4(AudioGameHelp audioGameHelp) {
        return new BalootGameHelp(audioGameHelp.fragment);
    }

    public static final CarromGameHelp mCarromGameHelp_delegate$lambda$8(AudioGameHelp audioGameHelp) {
        return new CarromGameHelp(audioGameHelp.fragment);
    }

    public static final CrushGameHelp mCrushHelp_delegate$lambda$3(AudioGameHelp audioGameHelp) {
        return new CrushGameHelp(audioGameHelp.fragment);
    }

    public static final DominoGameHelp mDominoHelp_delegate$lambda$2(AudioGameHelp audioGameHelp) {
        return new DominoGameHelp(audioGameHelp.fragment);
    }

    public static final EnvelopeHelper mEnvelopeHelper_delegate$lambda$7(AudioGameHelp audioGameHelp) {
        return new EnvelopeHelper(audioGameHelp.fragment);
    }

    public static final HiloGameHelp mHiloGameHelp_delegate$lambda$11(AudioGameHelp audioGameHelp) {
        return new HiloGameHelp(audioGameHelp.fragment);
    }

    public static final JackaroGameHelp mJackaroGameHelp_delegate$lambda$9(AudioGameHelp audioGameHelp) {
        return new JackaroGameHelp(audioGameHelp.fragment);
    }

    public static final LudoGameHelp mLudoHelp_delegate$lambda$0(AudioGameHelp audioGameHelp) {
        return new LudoGameHelp(audioGameHelp.fragment);
    }

    public static final PKGameHelp mPKGameHelp_delegate$lambda$5(AudioGameHelp audioGameHelp) {
        return new PKGameHelp(audioGameHelp.fragment);
    }

    public static final Pk1v1Help mPk1v1Help_delegate$lambda$10(AudioGameHelp audioGameHelp) {
        return new Pk1v1Help(audioGameHelp.fragment);
    }

    public static final UnoGameHelp mUnoHelp_delegate$lambda$1(AudioGameHelp audioGameHelp) {
        return new UnoGameHelp(audioGameHelp.fragment);
    }

    public static final YouTuBeHelper mYouTuBe_delegate$lambda$6(AudioGameHelp audioGameHelp) {
        return new YouTuBeHelper(audioGameHelp.fragment);
    }

    public static /* synthetic */ void releaseGame$default(AudioGameHelp audioGameHelp, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        audioGameHelp.releaseGame(z, z2);
    }

    public static final Unit releaseGame$lambda$21(AudioGameHelp audioGameHelp, boolean z) {
        int i = audioGameHelp.showGameType;
        if (i != 1) {
            if (i != 2) {
                if (i != 18) {
                    switch (i) {
                        case 10:
                            audioGameHelp.getMDominoHelp().releaseGame(z);
                            break;
                        case 11:
                            audioGameHelp.getMCrushHelp().releaseGame(z);
                            break;
                        case 12:
                            audioGameHelp.getMPKGameHelp().pkEnd();
                            break;
                        case 13:
                            audioGameHelp.getMYouTuBe().releaseGame();
                            break;
                        case 14:
                            audioGameHelp.getMBalootHelp().releaseGame(z);
                            break;
                        default:
                            switch (i) {
                                case 21:
                                    audioGameHelp.getMJackaroGameHelp().releaseGame(z);
                                    break;
                                case 22:
                                    audioGameHelp.getMHiloGameHelp().removeHiloGameView();
                                    break;
                                case 23:
                                    audioGameHelp.getMBackgammonGameHelp().releaseGame(z);
                                    break;
                            }
                    }
                } else {
                    audioGameHelp.getMCarromGameHelp().releaseGame(z);
                }
            } else {
                audioGameHelp.getMUnoHelp().releaseGame(z);
            }
        } else {
            audioGameHelp.getMLudoHelp().releaseGame(z);
        }
        if (13 != audioGameHelp.showGameType) {
            MeetingRoomManager.INSTANCE.saveCreateLudoDateAndClear();
        }
        audioGameHelp.mGameView = null;
        audioGameHelp.defaultHeight = 0;
        audioGameHelp.gameHeight = 0;
        audioGameHelp.showGameType = 0;
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showGameView$default(AudioGameHelp audioGameHelp, int i, GameConfiguration gameConfiguration, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            gameConfiguration = null;
        }
        audioGameHelp.showGameView(i, gameConfiguration);
    }

    public static final Unit showGameView$lambda$13(AudioGameHelp audioGameHelp, int i, GameConfiguration gameConfiguration) {
        audioGameHelp.showGameView(i, gameConfiguration);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showMicSpeakWaveAnim$default(AudioGameHelp audioGameHelp, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        audioGameHelp.showMicSpeakWaveAnim(list, z);
    }

    public final void changeGameMicType() {
        HiloGameHelp mHiloGameHelp;
        TextView textView;
        GameMicAdapter gameMicAdapter;
        if (!isPlayGame()) {
            return;
        }
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int micSize = meetingRoomManager.getMicSize(meetingRoomManager.getMCurrentRoomMicType());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < micSize) {
            int i2 = i + 1;
            MicroBean microBean = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i2));
            if (microBean == null) {
                microBean = MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i, false, 2, null);
            }
            arrayList.add(microBean);
            i = i2;
        }
        AudioRoomFragmentHelp mAudioHelp = this.fragment.getMAudioHelp();
        if (mAudioHelp != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
            gameMicAdapter.setList(arrayList);
        }
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (textView = binding.onLineText) != null) {
            textView.setText(String.valueOf(MeetingRoomManager.INSTANCE.getMRoomOnLine()));
        }
        AudioGameHelp mGameHelp = this.fragment.getMGameHelp();
        if (mGameHelp != null && (mHiloGameHelp = mGameHelp.getMHiloGameHelp()) != null) {
            mHiloGameHelp.changeGameMic(arrayList);
        }
    }

    public final boolean checkGameIsShow() {
        FrameLayout frameLayout;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding == null || (frameLayout = binding.gameLayout) == null || frameLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final boolean checkJoinGame() {
        int i = this.showGameType;
        if (i != 1) {
            if (i != 2) {
                if (i != 10) {
                    if (i != 11) {
                        if (i != 14) {
                            if (i != 18) {
                                if (i != 21) {
                                    if (i != 23) {
                                        return false;
                                    }
                                    return getMBackgammonGameHelp().checkMyIsJoin();
                                }
                                return getMJackaroGameHelp().checkMyIsJoin();
                            }
                            return getMCarromGameHelp().checkMyIsJoin();
                        }
                        return getMBalootHelp().checkMyIsJoin();
                    }
                    return getMCrushHelp().checkMyIsJoin();
                }
                return getMDominoHelp().checkMyIsJoin();
            }
            return getMUnoHelp().checkMyIsJoin();
        }
        return getMLudoHelp().checkMyIsJoin();
    }

    public final boolean checkYouTuVideo() {
        if (getMYouTuBe().getMState() != null && MeetingRoomManager.INSTANCE.checkOwnOrManager()) {
            return true;
        }
        return false;
    }

    @Nullable
    public final AnimatorSet getChatAnimatorSetHide() {
        return this.chatAnimatorSetHide;
    }

    @Nullable
    public final AnimatorSet getChatAnimatorSetShow() {
        return this.chatAnimatorSetShow;
    }

    public final int getDefaultHeight() {
        return this.defaultHeight;
    }

    @NotNull
    public final AudioRoomFragment getFragment() {
        return this.fragment;
    }

    public final int getGameHeight() {
        return this.gameHeight;
    }

    @Nullable
    public final AnimatorSet getHiloGameAnimatorSetHide() {
        return this.hiloGameAnimatorSetHide;
    }

    @Nullable
    public final AnimatorSet getHiloGameAnimatorSetShow() {
        return this.hiloGameAnimatorSetShow;
    }

    @NotNull
    public final BackgammonGameHelp getMBackgammonGameHelp() {
        return (BackgammonGameHelp) this.mBackgammonGameHelp.getValue();
    }

    @NotNull
    public final BalootGameHelp getMBalootHelp() {
        return (BalootGameHelp) this.mBalootHelp.getValue();
    }

    @NotNull
    public final CarromGameHelp getMCarromGameHelp() {
        return (CarromGameHelp) this.mCarromGameHelp.getValue();
    }

    @NotNull
    public final CrushGameHelp getMCrushHelp() {
        return (CrushGameHelp) this.mCrushHelp.getValue();
    }

    @NotNull
    public final DominoGameHelp getMDominoHelp() {
        return (DominoGameHelp) this.mDominoHelp.getValue();
    }

    @NotNull
    public final EnvelopeHelper getMEnvelopeHelper() {
        return (EnvelopeHelper) this.mEnvelopeHelper.getValue();
    }

    @Nullable
    public final View getMGameView() {
        return this.mGameView;
    }

    @NotNull
    public final HiloGameHelp getMHiloGameHelp() {
        return (HiloGameHelp) this.mHiloGameHelp.getValue();
    }

    @NotNull
    public final JackaroGameHelp getMJackaroGameHelp() {
        return (JackaroGameHelp) this.mJackaroGameHelp.getValue();
    }

    @NotNull
    public final LudoGameHelp getMLudoHelp() {
        return (LudoGameHelp) this.mLudoHelp.getValue();
    }

    @NotNull
    public final PKGameHelp getMPKGameHelp() {
        return (PKGameHelp) this.mPKGameHelp.getValue();
    }

    @NotNull
    public final Pk1v1Help getMPk1v1Help() {
        return (Pk1v1Help) this.mPk1v1Help.getValue();
    }

    @NotNull
    public final UnoGameHelp getMUnoHelp() {
        return (UnoGameHelp) this.mUnoHelp.getValue();
    }

    @NotNull
    public final YouTuBeHelper getMYouTuBe() {
        return (YouTuBeHelper) this.mYouTuBe.getValue();
    }

    @Nullable
    public final AnimatorSet getPkAnimatorSetHide() {
        return this.pkAnimatorSetHide;
    }

    @Nullable
    public final AnimatorSet getPkAnimatorSetShow() {
        return this.pkAnimatorSetShow;
    }

    public final int getShowGameType() {
        return this.showGameType;
    }

    @Nullable
    public final AnimatorSet getSudAnimatorSetHide() {
        return this.sudAnimatorSetHide;
    }

    @Nullable
    public final AnimatorSet getSudAnimatorSetShow() {
        return this.sudAnimatorSetShow;
    }

    public final void hideGameView(@Nullable Function0<Unit> complete) {
        if (this.mGameView == null) {
            return;
        }
        int i = this.showGameType;
        if (i == 12) {
            RoomGameAnimationKt.hidePKGameView(this, complete);
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "open_pk", Boolean.FALSE, (String) null, 4, (Object) null);
            return;
        }
        if (i == 22) {
            RoomGameAnimationKt.hideHiloGameView$default(this, null, 1, null);
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "hilo_game_open", Boolean.FALSE, (String) null, 4, (Object) null);
            return;
        }
        RoomGameAnimationKt.hideSUDGameView(this, complete);
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        Boolean bool = Boolean.FALSE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "open_game", bool, (String) null, 4, (Object) null);
        if (this.showGameType == 13) {
            IStore.DefaultImpls.setValue$default(mMKVStore, "open_video", bool, (String) null, 4, (Object) null);
        }
    }

    public final void hideRoomEffect() {
        BaseBindingDialog mLuckyWheelDialog;
        AudioRoomDialogHelp mDialogHelp = this.fragment.getMDialogHelp();
        if (mDialogHelp != null && (mLuckyWheelDialog = mDialogHelp.getMLuckyWheelDialog()) != null && mLuckyWheelDialog.isShowing()) {
            BaseBindingDialog mLuckyWheelDialog2 = mDialogHelp.getMLuckyWheelDialog();
            if (mLuckyWheelDialog2 != null) {
                mLuckyWheelDialog2.hide();
            }
            mDialogHelp.setMSmallLuckWheelDialog(true);
        }
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null) {
            binding.rocketSvga.stopRocket();
            binding.queuePlayer.onCleared();
            binding.userEnterRoomContent.removeAllViews();
        }
        if (this.fragment.getActivity() instanceof HiloBaseActivity) {
            HiloBaseActivity activity = this.fragment.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.qiahao.nextvideo.app.base.HiloBaseActivity");
            activity.getMGlobalTipSvgaView().hideImmediate();
            HiloBaseActivity activity2 = this.fragment.getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type com.qiahao.nextvideo.app.base.HiloBaseActivity");
            activity2.getMGlobalEnvelopeView().hideImmediate();
        }
    }

    public final boolean isPlayGame() {
        FrameLayout frameLayout;
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding == null || (frameLayout = binding.gameLayout) == null || frameLayout.getChildCount() == 0) {
            return false;
        }
        return true;
    }

    public final void notificationMicChange() {
        Integer num;
        GameMicAdapter gameMicAdapter;
        List data;
        List list;
        GameMicAdapter gameMicAdapter2;
        GameMicAdapter gameMicAdapter3;
        GameMicAdapter gameMicAdapter4;
        List data2;
        if (getMPKGameHelp().getBinding() != null) {
            getMPKGameHelp().notificationMicChange();
            return;
        }
        if (getMHiloGameHelp().getBinding() != null) {
            getMHiloGameHelp().notificationMicChange();
            return;
        }
        if (!isPlayGame()) {
            return;
        }
        AudioRoomFragmentHelp mAudioHelp = this.fragment.getMAudioHelp();
        if (mAudioHelp != null && (gameMicAdapter4 = mAudioHelp.getGameMicAdapter()) != null && (data2 = gameMicAdapter4.getData()) != null) {
            num = Integer.valueOf(data2.size());
        } else {
            num = null;
        }
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int micSize = meetingRoomManager.getMicSize(meetingRoomManager.getMCurrentRoomMicType());
        if (num != null && num.intValue() == micSize) {
            AudioRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
            if (mAudioHelp2 != null && (gameMicAdapter = mAudioHelp2.getGameMicAdapter()) != null && (data = gameMicAdapter.getData()) != null) {
                int i = 0;
                for (Object obj : data) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    MicroBean microBean = (MicroBean) obj;
                    MicroBean microBean2 = (MicroBean) MeetingRoomManager.getMicQueue$default(MeetingRoomManager.INSTANCE, false, 1, null).get(Integer.valueOf(i2));
                    if (microBean2 == null) {
                        microBean2 = MicroBean.Companion.emptyMicroBean$default(MicroBean.INSTANCE, i, false, 2, null);
                    }
                    if (!microBean.checkDataIsEqual(microBean2)) {
                        AudioRoomFragmentHelp mAudioHelp3 = this.fragment.getMAudioHelp();
                        if (mAudioHelp3 != null && (gameMicAdapter3 = mAudioHelp3.getGameMicAdapter()) != null) {
                            list = gameMicAdapter3.getData();
                        } else {
                            list = null;
                        }
                        Intrinsics.checkNotNull(list);
                        list.set(i, microBean2);
                        AudioRoomFragmentHelp mAudioHelp4 = this.fragment.getMAudioHelp();
                        if (mAudioHelp4 != null && (gameMicAdapter2 = mAudioHelp4.getGameMicAdapter()) != null) {
                            gameMicAdapter2.notifyItemChanged(i, microBean2);
                        }
                    }
                    i = i2;
                }
                return;
            }
            return;
        }
        changeGameMicType();
    }

    public final void refreshGameData(int gameType) {
        if (gameType == 1 && this.mGameView != null) {
            getMLudoHelp().refreshGameData();
            return;
        }
        if (gameType == 2 && this.mGameView != null) {
            getMUnoHelp().refreshGameData();
            return;
        }
        if (gameType == 10 && this.mGameView != null) {
            getMDominoHelp().refreshGameData();
            return;
        }
        if (gameType == 11 && this.mGameView != null) {
            getMCrushHelp().refreshGameData();
            return;
        }
        if (gameType == 13 && this.mGameView != null) {
            getMYouTuBe().refreshGameData();
            return;
        }
        if (gameType == 14 && this.mGameView != null) {
            getMBalootHelp().refreshGameData();
            return;
        }
        if (gameType == 18 && this.mGameView != null) {
            getMCarromGameHelp().refreshGameData();
            return;
        }
        if (gameType == 21 && this.mGameView != null) {
            getMJackaroGameHelp().refreshGameData();
        } else if (gameType == 23 && this.mGameView != null) {
            getMBackgammonGameHelp().refreshGameData();
        }
    }

    public final void refreshOnlineNumber(@NotNull CurrentRoomOnlineBeanList data) {
        TextView textView;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!isPlayGame()) {
            return;
        }
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (textView = binding.onLineText) != null) {
            textView.setText(String.valueOf(data.getTotal()));
        }
        if (getMHiloGameHelp().getBinding() != null) {
            getMHiloGameHelp().refreshOnlineNumber(data.getUsers());
        }
    }

    public final void refreshPosition(int position) {
        int i;
        AudioRoomFragmentHelp mAudioHelp;
        GameMicAdapter gameMicAdapter;
        MicroBean microBean;
        GameMicAdapter gameMicAdapter2;
        List data;
        GameMicAdapter gameMicAdapter3;
        List data2;
        if (getMPKGameHelp().getBinding() != null) {
            getMPKGameHelp().refreshMicByPosition(position);
            return;
        }
        if (!isPlayGame()) {
            return;
        }
        AudioRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
        if (mAudioHelp2 != null && (gameMicAdapter3 = mAudioHelp2.getGameMicAdapter()) != null && (data2 = gameMicAdapter3.getData()) != null) {
            i = data2.size();
        } else {
            i = 0;
        }
        if (position < i && position >= 0 && (mAudioHelp = this.fragment.getMAudioHelp()) != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
            AudioRoomFragmentHelp mAudioHelp3 = this.fragment.getMAudioHelp();
            if (mAudioHelp3 != null && (gameMicAdapter2 = mAudioHelp3.getGameMicAdapter()) != null && (data = gameMicAdapter2.getData()) != null) {
                microBean = (MicroBean) data.get(position);
            } else {
                microBean = null;
            }
            gameMicAdapter.notifyItemChanged(position, microBean);
        }
    }

    public final void refreshSVIP(int level) {
        if (getMPKGameHelp().getBinding() != null) {
            getMPKGameHelp().refreshSVIP(level);
        }
    }

    public final void releaseAnimation() {
        AnimatorSet animatorSet = this.pkAnimatorSetShow;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.pkAnimatorSetShow;
        if (animatorSet2 != null) {
            animatorSet2.removeAllListeners();
        }
        AnimatorSet animatorSet3 = this.pkAnimatorSetHide;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.pkAnimatorSetHide;
        if (animatorSet4 != null) {
            animatorSet4.removeAllListeners();
        }
        AnimatorSet animatorSet5 = this.sudAnimatorSetShow;
        if (animatorSet5 != null) {
            animatorSet5.cancel();
        }
        AnimatorSet animatorSet6 = this.sudAnimatorSetShow;
        if (animatorSet6 != null) {
            animatorSet6.removeAllListeners();
        }
        AnimatorSet animatorSet7 = this.sudAnimatorSetHide;
        if (animatorSet7 != null) {
            animatorSet7.cancel();
        }
        AnimatorSet animatorSet8 = this.sudAnimatorSetHide;
        if (animatorSet8 != null) {
            animatorSet8.removeAllListeners();
        }
        AnimatorSet animatorSet9 = this.chatAnimatorSetShow;
        if (animatorSet9 != null) {
            animatorSet9.cancel();
        }
        AnimatorSet animatorSet10 = this.chatAnimatorSetShow;
        if (animatorSet10 != null) {
            animatorSet10.removeAllListeners();
        }
        AnimatorSet animatorSet11 = this.chatAnimatorSetHide;
        if (animatorSet11 != null) {
            animatorSet11.cancel();
        }
        AnimatorSet animatorSet12 = this.chatAnimatorSetHide;
        if (animatorSet12 != null) {
            animatorSet12.removeAllListeners();
        }
        AnimatorSet animatorSet13 = this.hiloGameAnimatorSetShow;
        if (animatorSet13 != null) {
            animatorSet13.cancel();
        }
        AnimatorSet animatorSet14 = this.hiloGameAnimatorSetShow;
        if (animatorSet14 != null) {
            animatorSet14.removeAllListeners();
        }
        AnimatorSet animatorSet15 = this.hiloGameAnimatorSetHide;
        if (animatorSet15 != null) {
            animatorSet15.cancel();
        }
        AnimatorSet animatorSet16 = this.hiloGameAnimatorSetHide;
        if (animatorSet16 != null) {
            animatorSet16.removeAllListeners();
        }
    }

    public final void releaseGame(boolean isDelay, final boolean callReport) {
        ImageView imageView;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        MeetingRoomOnlineMemberLayout meetingRoomOnlineMemberLayout;
        NewMicroView newMicroView;
        this.fragment.getMViewModel().setMGameCode("");
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        Boolean bool = Boolean.FALSE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "open_game", bool, (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "open_video", bool, (String) null, 4, (Object) null);
        if (isDelay) {
            hideGameView(new Function0() { // from class: com.qiahao.nextvideo.room.help.a
                public final Object invoke() {
                    Unit releaseGame$lambda$21;
                    releaseGame$lambda$21 = AudioGameHelp.releaseGame$lambda$21(AudioGameHelp.this, callReport);
                    return releaseGame$lambda$21;
                }
            });
            return;
        }
        FragmentAudioRoomBinding binding = this.fragment.getBinding();
        if (binding != null && (newMicroView = binding.microView) != null) {
            newMicroView.setVisibility(0);
        }
        if (binding != null && (meetingRoomOnlineMemberLayout = binding.meetingRoomOnlineMember) != null) {
            meetingRoomOnlineMemberLayout.setVisibility(0);
        }
        if (binding != null && (constraintLayout = binding.playLayout) != null) {
            constraintLayout.setVisibility(0);
        }
        if (binding != null && (recyclerView = binding.gameRecycleView) != null) {
            recyclerView.setVisibility(8);
        }
        if (binding != null && (frameLayout2 = binding.onLineLayout) != null) {
            frameLayout2.setVisibility(8);
        }
        if (binding != null && (frameLayout = binding.gameLayout) != null) {
            frameLayout.setVisibility(8);
        }
        if (binding != null && (imageView = binding.showChat) != null) {
            imageView.setVisibility(8);
        }
        int i = this.showGameType;
        if (i != 1) {
            if (i != 2) {
                if (i != 18) {
                    switch (i) {
                        case 10:
                            getMDominoHelp().releaseGame(callReport);
                            break;
                        case 11:
                            getMCrushHelp().releaseGame(callReport);
                            break;
                        case 12:
                            getMPKGameHelp().pkEnd();
                            break;
                        case 13:
                            getMYouTuBe().releaseGame();
                            break;
                        case 14:
                            getMBalootHelp().releaseGame(callReport);
                            break;
                        default:
                            switch (i) {
                                case 21:
                                    getMJackaroGameHelp().releaseGame(callReport);
                                    break;
                                case 22:
                                    getMHiloGameHelp().removeHiloGameView();
                                    break;
                                case 23:
                                    getMBackgammonGameHelp().releaseGame(callReport);
                                    break;
                            }
                    }
                } else {
                    getMCarromGameHelp().releaseGame(callReport);
                }
            } else {
                getMUnoHelp().releaseGame(callReport);
            }
        } else {
            getMLudoHelp().releaseGame(callReport);
        }
        if (13 != this.showGameType) {
            MeetingRoomManager.INSTANCE.saveCreateLudoDateAndClear();
        }
        this.mGameView = null;
        this.defaultHeight = 0;
        this.gameHeight = 0;
        this.showGameType = 0;
    }

    public final void resetVideo() {
        if (canShowGame(13)) {
            showGameView$default(this, 13, null, 2, null);
            return;
        }
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        Boolean bool = Boolean.TRUE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "open_game", bool, (String) null, 4, (Object) null);
        if (this.showGameType == 13) {
            IStore.DefaultImpls.setValue$default(mMKVStore, "open_video", bool, (String) null, 4, (Object) null);
        }
        createGame$default(this, this.showGameType, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setBg(boolean isShow, int gameType) {
        ImageView imageView;
        ImageView imageView2;
        int i;
        ImageView imageView3;
        boolean z;
        ImageView imageView4;
        boolean z2;
        int i2;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        ImageView imageView11;
        ImageView imageView12;
        ImageView imageView13;
        int i3;
        ImageView imageView14;
        ImageView imageView15;
        boolean z3;
        String str = null;
        Integer valueOf = Integer.valueOf(R.drawable.bg_meeting_room1);
        boolean z4 = false;
        if (isShow) {
            GroupDetailBean groupDetailBean = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean != null) {
                Integer themeId = groupDetailBean.getThemeId();
                if (themeId != null) {
                    i3 = themeId.intValue();
                } else {
                    i3 = 0;
                }
                if (i3 > 0) {
                    String themeUrl = groupDetailBean.getThemeUrl();
                    if (themeUrl != null) {
                        if (themeUrl.length() > 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z4 = true;
                        }
                    }
                    if (z4) {
                        FragmentAudioRoomBinding binding = this.fragment.getBinding();
                        if (binding != null && (imageView15 = binding.defaultBackGround) != null) {
                            GroupDetailBean groupDetailBean2 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
                            if (groupDetailBean2 != null) {
                                str = groupDetailBean2.getThemeUrl();
                            }
                            i2 = 1;
                            ImageKtxKt.loadImage$default(imageView15, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, valueOf, (c5.g) null, 49150, (Object) null);
                            if (gameType != i2) {
                                if (gameType != 2) {
                                    if (gameType != 10) {
                                        if (gameType != 11) {
                                            if (gameType != 14) {
                                                if (gameType != 18) {
                                                    switch (gameType) {
                                                        case 21:
                                                            FragmentAudioRoomBinding binding2 = this.fragment.getBinding();
                                                            if (binding2 != null && (imageView11 = binding2.meetingRoomThemBackGroup) != null) {
                                                                ImageKtxKt.loadImage$default(imageView11, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.jackaro_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                                                return;
                                                            }
                                                            return;
                                                        case 22:
                                                            FragmentAudioRoomBinding binding3 = this.fragment.getBinding();
                                                            if (binding3 != null && (imageView12 = binding3.meetingRoomThemBackGroup) != null) {
                                                                ImageKtxKt.loadImage$default(imageView12, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.hilo_game_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                                                return;
                                                            }
                                                            return;
                                                        case 23:
                                                            FragmentAudioRoomBinding binding4 = this.fragment.getBinding();
                                                            if (binding4 != null && (imageView13 = binding4.meetingRoomThemBackGroup) != null) {
                                                                ImageKtxKt.loadImage$default(imageView13, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.backgammon_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                                                return;
                                                            }
                                                            return;
                                                        default:
                                                            return;
                                                    }
                                                }
                                                FragmentAudioRoomBinding binding5 = this.fragment.getBinding();
                                                if (binding5 != null && (imageView10 = binding5.meetingRoomThemBackGroup) != null) {
                                                    ImageKtxKt.loadImage$default(imageView10, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.carrom_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                                    return;
                                                }
                                                return;
                                            }
                                            FragmentAudioRoomBinding binding6 = this.fragment.getBinding();
                                            if (binding6 != null && (imageView9 = binding6.meetingRoomThemBackGroup) != null) {
                                                ImageKtxKt.loadImage$default(imageView9, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ballot_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                                return;
                                            }
                                            return;
                                        }
                                        FragmentAudioRoomBinding binding7 = this.fragment.getBinding();
                                        if (binding7 != null && (imageView8 = binding7.meetingRoomThemBackGroup) != null) {
                                            ImageKtxKt.loadImage$default(imageView8, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.crush_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                            return;
                                        }
                                        return;
                                    }
                                    FragmentAudioRoomBinding binding8 = this.fragment.getBinding();
                                    if (binding8 != null && (imageView7 = binding8.meetingRoomThemBackGroup) != null) {
                                        ImageKtxKt.loadImage$default(imageView7, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.domino_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                        return;
                                    }
                                    return;
                                }
                                FragmentAudioRoomBinding binding9 = this.fragment.getBinding();
                                if (binding9 != null && (imageView6 = binding9.meetingRoomThemBackGroup) != null) {
                                    ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.uno_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                    return;
                                }
                                return;
                            }
                            FragmentAudioRoomBinding binding10 = this.fragment.getBinding();
                            if (binding10 != null && (imageView5 = binding10.meetingRoomThemBackGroup) != null) {
                                ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ludo_room_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                return;
                            }
                            return;
                        }
                    }
                }
                i2 = 1;
                FragmentAudioRoomBinding binding11 = this.fragment.getBinding();
                if (binding11 != null && (imageView14 = binding11.defaultBackGround) != null) {
                    ImageKtxKt.loadImage$default(imageView14, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                if (gameType != i2) {
                }
            }
            i2 = 1;
            if (gameType != i2) {
            }
        } else {
            GroupDetailBean groupDetailBean3 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
            if (groupDetailBean3 != null) {
                Integer themeId2 = groupDetailBean3.getThemeId();
                if (themeId2 != null) {
                    i = themeId2.intValue();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    String themeUrl2 = groupDetailBean3.getThemeUrl();
                    if (themeUrl2 != null) {
                        if (themeUrl2.length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            z = true;
                            if (z) {
                                FragmentAudioRoomBinding binding12 = this.fragment.getBinding();
                                if (binding12 != null && (imageView4 = binding12.meetingRoomThemBackGroup) != null) {
                                    ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                                    GroupDetailBean groupDetailBean4 = (GroupDetailBean) this.fragment.getMViewModel().getMGroupDetailBean().getValue();
                                    if (groupDetailBean4 != null) {
                                        str = groupDetailBean4.getThemeUrl();
                                    }
                                    ViewUtilitiesKt.bind(imageView4, companion.roomBackGroupFull(str, R.drawable.bg_meeting_room1));
                                }
                            }
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
                FragmentAudioRoomBinding binding13 = this.fragment.getBinding();
                if (binding13 != null && (imageView3 = binding13.meetingRoomThemBackGroup) != null) {
                    ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
            }
            FragmentAudioRoomBinding binding14 = this.fragment.getBinding();
            if (binding14 != null && (imageView2 = binding14.meetingRoomThemBackGroup) != null) {
                imageView2.setAlpha(1.0f);
            }
            FragmentAudioRoomBinding binding15 = this.fragment.getBinding();
            if (binding15 != null && (imageView = binding15.defaultBackGround) != null) {
                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, valueOf, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
        }
    }

    public final void setChatAnimatorSetHide(@Nullable AnimatorSet animatorSet) {
        this.chatAnimatorSetHide = animatorSet;
    }

    public final void setChatAnimatorSetShow(@Nullable AnimatorSet animatorSet) {
        this.chatAnimatorSetShow = animatorSet;
    }

    public final void setDefaultHeight(int i) {
        this.defaultHeight = i;
    }

    public final void setGameHeight(int i) {
        this.gameHeight = i;
    }

    public final void setHiloGameAnimatorSetHide(@Nullable AnimatorSet animatorSet) {
        this.hiloGameAnimatorSetHide = animatorSet;
    }

    public final void setHiloGameAnimatorSetShow(@Nullable AnimatorSet animatorSet) {
        this.hiloGameAnimatorSetShow = animatorSet;
    }

    public final void setMGameView(@Nullable View view) {
        this.mGameView = view;
    }

    public final void setPkAnimatorSetHide(@Nullable AnimatorSet animatorSet) {
        this.pkAnimatorSetHide = animatorSet;
    }

    public final void setPkAnimatorSetShow(@Nullable AnimatorSet animatorSet) {
        this.pkAnimatorSetShow = animatorSet;
    }

    public final void setShowGameType(int i) {
        this.showGameType = i;
    }

    public final void setSudAnimatorSetHide(@Nullable AnimatorSet animatorSet) {
        this.sudAnimatorSetHide = animatorSet;
    }

    public final void setSudAnimatorSetShow(@Nullable AnimatorSet animatorSet) {
        this.sudAnimatorSetShow = animatorSet;
    }

    public final void showFace(int position, @NotNull String url) {
        int i;
        AudioRoomFragmentHelp mAudioHelp;
        GameMicAdapter gameMicAdapter;
        GameMicAdapter gameMicAdapter2;
        List data;
        Intrinsics.checkNotNullParameter(url, "url");
        if (getMPKGameHelp().getBinding() != null) {
            getMPKGameHelp().showFace(position, url);
            return;
        }
        if (getMHiloGameHelp().getBinding() != null) {
            getMHiloGameHelp().showFace(position, url);
            return;
        }
        if (!isPlayGame()) {
            return;
        }
        AudioRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
        if (mAudioHelp2 != null && (gameMicAdapter2 = mAudioHelp2.getGameMicAdapter()) != null && (data = gameMicAdapter2.getData()) != null) {
            i = data.size();
        } else {
            i = 0;
        }
        if (position < i && position >= 0 && (mAudioHelp = this.fragment.getMAudioHelp()) != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
            gameMicAdapter.notifyItemChanged(position, url);
        }
    }

    public final void showGameEnd(int gameType, @Nullable Object data) {
        if (gameType == 1 && (data instanceof SUDGameAward)) {
            getMLudoHelp().showGameEndDialog((SUDGameAward) data);
            return;
        }
        if (gameType == 2 && (data instanceof SUDGameAward)) {
            getMUnoHelp().showGameEndDialog((SUDGameAward) data);
            return;
        }
        if (gameType == 10 && (data instanceof SUDGameAward)) {
            getMDominoHelp().showGameEndDialog((SUDGameAward) data);
            return;
        }
        if (gameType == 11 && (data instanceof SUDGameAward)) {
            getMCrushHelp().showGameEndDialog((SUDGameAward) data);
            return;
        }
        if (gameType == 14 && (data instanceof SUDGameAward)) {
            getMBalootHelp().showGameEndDialog((SUDGameAward) data);
            return;
        }
        if (gameType == 18 && (data instanceof SUDGameAward)) {
            getMCarromGameHelp().showGameEndDialog((SUDGameAward) data);
            return;
        }
        if (gameType == 21 && (data instanceof SUDGameAward)) {
            getMJackaroGameHelp().showGameEndDialog((SUDGameAward) data);
        } else if (gameType == 23 && (data instanceof SUDGameAward)) {
            getMBackgammonGameHelp().showGameEndDialog((SUDGameAward) data);
        }
    }

    public final void showGameView(final int gameType, @Nullable final GameConfiguration gameConfiguration) {
        if ((gameType == 22 && !this.fragment.checkWriteOrStoragePermission(new Function0() { // from class: com.qiahao.nextvideo.room.help.f
            public final Object invoke() {
                Unit showGameView$lambda$13;
                showGameView$lambda$13 = AudioGameHelp.showGameView$lambda$13(AudioGameHelp.this, gameType, gameConfiguration);
                return showGameView$lambda$13;
            }
        })) || !canShowGame(gameType)) {
            return;
        }
        this.showGameType = gameType;
        if (gameType != 13) {
            hideRoomEffect();
        }
        createGame(this.showGameType, gameConfiguration);
        int i = this.showGameType;
        if (i == 12) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "open_pk", Boolean.TRUE, (String) null, 4, (Object) null);
            RoomGameAnimationKt.showPKGameView(this);
        } else {
            if (i == 22) {
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "hilo_game_open", Boolean.TRUE, (String) null, 4, (Object) null);
                RoomGameAnimationKt.showHiloGameView(this);
                return;
            }
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            Boolean bool = Boolean.TRUE;
            IStore.DefaultImpls.setValue$default(mMKVStore, "open_game", bool, (String) null, 4, (Object) null);
            if (this.showGameType == 13) {
                IStore.DefaultImpls.setValue$default(mMKVStore, "open_video", bool, (String) null, 4, (Object) null);
            }
            RoomGameAnimationKt.showSUDGameView(this);
        }
    }

    public final void showMicSpeakWaveAnim(@NotNull List<Integer> list, boolean isOther) {
        int i;
        List list2;
        AudioRoomFragmentHelp mAudioHelp;
        GameMicAdapter gameMicAdapter;
        GameMicAdapter gameMicAdapter2;
        GameMicAdapter gameMicAdapter3;
        List data;
        Intrinsics.checkNotNullParameter(list, "list");
        if (getMHiloGameHelp().getBinding() != null) {
            getMHiloGameHelp().showMicSpeakWaveAnim(list);
            return;
        }
        if (getMPKGameHelp().getBinding() != null) {
            getMPKGameHelp().showMicSpeakWaveAnim(list, isOther);
            return;
        }
        if (getMPk1v1Help().getBinding() != null && !isOther) {
            getMPk1v1Help().showMicSpeakWaveAnim(list);
        }
        if (isPlayGame() && !isOther) {
            AudioRoomFragmentHelp mAudioHelp2 = this.fragment.getMAudioHelp();
            if (mAudioHelp2 != null && (gameMicAdapter3 = mAudioHelp2.getGameMicAdapter()) != null && (data = gameMicAdapter3.getData()) != null) {
                i = data.size();
            } else {
                i = 0;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                int intValue = list.get(i2).intValue() - 1;
                if (intValue < i && intValue >= 0) {
                    AudioRoomFragmentHelp mAudioHelp3 = this.fragment.getMAudioHelp();
                    if (mAudioHelp3 != null && (gameMicAdapter2 = mAudioHelp3.getGameMicAdapter()) != null) {
                        list2 = gameMicAdapter2.getData();
                    } else {
                        list2 = null;
                    }
                    Intrinsics.checkNotNull(list2);
                    if (((MicroBean) list2.get(intValue)).getUser() != null && (mAudioHelp = this.fragment.getMAudioHelp()) != null && (gameMicAdapter = mAudioHelp.getGameMicAdapter()) != null) {
                        gameMicAdapter.notifyItemChanged(intValue, GameMicAdapter.PLAY_MIC_SPEAK);
                    }
                }
            }
        }
    }
}
