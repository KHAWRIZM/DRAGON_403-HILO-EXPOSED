package com.qiahao.nextvideo.room.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.oudi.utils.TimerTask;
import com.oudi.utils.ktx.TimerKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.agora.HiloRtcEngine;
import com.qiahao.nextvideo.databinding.DialogGroupMusicBinding;
import com.qiahao.nextvideo.room.activity.AddMusicActivity;
import com.qiahao.nextvideo.room.dialog.GroupMusicDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.music.MusicLoader;
import com.qiahao.nextvideo.room.music.MusicStatus;
import com.qiahao.nextvideo.room.music.c;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002JKB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\fJ\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\fJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u000f\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Landroid/view/View$OnClickListener;", "Lcom/qiahao/nextvideo/room/music/c$b;", "Landroid/content/Context;", "mCurrentContext", "Lcom/qiahao/nextvideo/room/dialog/MusicDialogListener;", "mMusicDialogListener", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/room/dialog/MusicDialogListener;)V", "", "initListener", "()V", "startLoadProgress", "initMusicManager", "initStyle", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "initDataBinding", "Lcom/qiahao/nextvideo/room/music/MusicLoader$MusicInfo;", "musicInfo", "play", "(Lcom/qiahao/nextvideo/room/music/MusicLoader$MusicInfo;)V", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "show", "dismiss", "onLoadingFinish", "Landroid/content/Context;", "getMCurrentContext", "()Landroid/content/Context;", "Lcom/qiahao/nextvideo/room/dialog/MusicDialogListener;", "getMMusicDialogListener", "()Lcom/qiahao/nextvideo/room/dialog/MusicDialogListener;", "Lcom/qiahao/nextvideo/databinding/DialogGroupMusicBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogGroupMusicBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogGroupMusicBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogGroupMusicBinding;)V", "Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog$ActionListener;", "mActionListener", "Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog$ActionListener;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/room/music/c;", "mMusicManager", "Lcom/qiahao/nextvideo/room/music/c;", "getMMusicManager", "()Lcom/qiahao/nextvideo/room/music/c;", "setMMusicManager", "(Lcom/qiahao/nextvideo/room/music/c;)V", "Lcom/oudi/utils/TimerTask;", "mTimerTask", "Lcom/oudi/utils/TimerTask;", "", "mProgress", "I", "Lcom/qiahao/base_common/common/BaseActivity;", "mActivity", "Lcom/qiahao/base_common/common/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "dialogScope", "Lkotlinx/coroutines/CoroutineScope;", "Companion", "ActionListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMusicDialog extends BottomSheetDialog implements View.OnClickListener, c.b {

    @NotNull
    private static final String TAG = "GroupMusicDialog";
    public DialogGroupMusicBinding binding;

    @NotNull
    private final CoroutineScope dialogScope;

    @Nullable
    private ActionListener mActionListener;

    @Nullable
    private BaseActivity mActivity;
    public nd.a mCompositeDisposable;

    @NotNull
    private final Context mCurrentContext;

    @NotNull
    private final MusicDialogListener mMusicDialogListener;

    @Nullable
    private com.qiahao.nextvideo.room.music.c mMusicManager;
    private int mProgress;

    @Nullable
    private TimerTask mTimerTask;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\nJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\nR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog$ActionListener;", "Lcom/qiahao/nextvideo/room/music/c$c;", "Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog;", "groupMusicDialog", "<init>", "(Lcom/qiahao/nextvideo/room/dialog/GroupMusicDialog;)V", "Lcom/qiahao/nextvideo/room/music/MusicLoader$MusicInfo;", "musicInfo", "", "start", "(Lcom/qiahao/nextvideo/room/music/MusicLoader$MusicInfo;)V", "onPause", "()V", "onResume", "onStop", "lastOne", "nextOne", "Ljava/lang/ref/WeakReference;", "mWeakReferenceGroupMusicDialog", "Ljava/lang/ref/WeakReference;", "getMWeakReferenceGroupMusicDialog", "()Ljava/lang/ref/WeakReference;", "setMWeakReferenceGroupMusicDialog", "(Ljava/lang/ref/WeakReference;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class ActionListener implements c.InterfaceC٠٠٠٢c {

        @Nullable
        private WeakReference<GroupMusicDialog> mWeakReferenceGroupMusicDialog;

        public ActionListener(@NotNull GroupMusicDialog groupMusicDialog) {
            Intrinsics.checkNotNullParameter(groupMusicDialog, "groupMusicDialog");
            this.mWeakReferenceGroupMusicDialog = new WeakReference<>(groupMusicDialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void lastOne$lambda$4(ActionListener actionListener, MusicLoader.MusicInfo musicInfo) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            GroupMusicDialog groupMusicDialog3;
            WeakReference<GroupMusicDialog> weakReference = actionListener.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    WeakReference<GroupMusicDialog> weakReference2 = actionListener.mWeakReferenceGroupMusicDialog;
                    if (weakReference2 != null && (groupMusicDialog3 = weakReference2.get()) != null) {
                        Intrinsics.checkNotNull(musicInfo);
                        groupMusicDialog3.play(musicInfo);
                    }
                    WeakReference<GroupMusicDialog> weakReference3 = actionListener.mWeakReferenceGroupMusicDialog;
                    if (weakReference3 != null && (groupMusicDialog2 = weakReference3.get()) != null) {
                        groupMusicDialog2.startLoadProgress();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void nextOne$lambda$5(ActionListener actionListener, MusicLoader.MusicInfo musicInfo) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            GroupMusicDialog groupMusicDialog3;
            WeakReference<GroupMusicDialog> weakReference = actionListener.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    WeakReference<GroupMusicDialog> weakReference2 = actionListener.mWeakReferenceGroupMusicDialog;
                    if (weakReference2 != null && (groupMusicDialog3 = weakReference2.get()) != null) {
                        Intrinsics.checkNotNull(musicInfo);
                        groupMusicDialog3.play(musicInfo);
                    }
                    WeakReference<GroupMusicDialog> weakReference3 = actionListener.mWeakReferenceGroupMusicDialog;
                    if (weakReference3 != null && (groupMusicDialog2 = weakReference3.get()) != null) {
                        groupMusicDialog2.startLoadProgress();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPause$lambda$1(ActionListener actionListener) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            TimerTask timerTask;
            GroupMusicDialog groupMusicDialog3;
            com.qiahao.nextvideo.room.music.c mMusicManager;
            GroupMusicDialog groupMusicDialog4;
            DialogGroupMusicBinding binding;
            ImageView imageView;
            WeakReference<GroupMusicDialog> weakReference = actionListener.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    if (HiloRtcEngine.INSTANCE.pauseAudioMixing() == 0) {
                        WeakReference<GroupMusicDialog> weakReference2 = actionListener.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog4 = weakReference2.get()) != null && (binding = groupMusicDialog4.getBinding()) != null && (imageView = binding.playPauseMusic) != null) {
                            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_pause1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        }
                        WeakReference<GroupMusicDialog> weakReference3 = actionListener.mWeakReferenceGroupMusicDialog;
                        if (weakReference3 != null && (groupMusicDialog3 = weakReference3.get()) != null && (mMusicManager = groupMusicDialog3.getMMusicManager()) != null) {
                            mMusicManager.t(MusicStatus.PAUSE);
                        }
                    }
                    WeakReference<GroupMusicDialog> weakReference4 = actionListener.mWeakReferenceGroupMusicDialog;
                    if (weakReference4 != null && (groupMusicDialog2 = weakReference4.get()) != null && (timerTask = groupMusicDialog2.mTimerTask) != null) {
                        timerTask.cancel();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onResume$lambda$2(ActionListener actionListener) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            GroupMusicDialog groupMusicDialog3;
            com.qiahao.nextvideo.room.music.c mMusicManager;
            GroupMusicDialog groupMusicDialog4;
            DialogGroupMusicBinding binding;
            ImageView imageView;
            WeakReference<GroupMusicDialog> weakReference = actionListener.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    if (HiloRtcEngine.INSTANCE.resumeAudioMixing() == 0) {
                        WeakReference<GroupMusicDialog> weakReference2 = actionListener.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog4 = weakReference2.get()) != null && (binding = groupMusicDialog4.getBinding()) != null && (imageView = binding.playPauseMusic) != null) {
                            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_play1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        }
                        WeakReference<GroupMusicDialog> weakReference3 = actionListener.mWeakReferenceGroupMusicDialog;
                        if (weakReference3 != null && (groupMusicDialog3 = weakReference3.get()) != null && (mMusicManager = groupMusicDialog3.getMMusicManager()) != null) {
                            mMusicManager.t(MusicStatus.PLAY);
                        }
                    }
                    WeakReference<GroupMusicDialog> weakReference4 = actionListener.mWeakReferenceGroupMusicDialog;
                    if (weakReference4 != null && (groupMusicDialog2 = weakReference4.get()) != null) {
                        groupMusicDialog2.startLoadProgress();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onStop$lambda$3(ActionListener actionListener) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            TimerTask timerTask;
            GroupMusicDialog groupMusicDialog3;
            com.qiahao.nextvideo.room.music.c mMusicManager;
            GroupMusicDialog groupMusicDialog4;
            DialogGroupMusicBinding binding;
            ImageView imageView;
            WeakReference<GroupMusicDialog> weakReference = actionListener.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    if (HiloRtcEngine.INSTANCE.stopAudioMixing() == 0) {
                        WeakReference<GroupMusicDialog> weakReference2 = actionListener.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog4 = weakReference2.get()) != null && (binding = groupMusicDialog4.getBinding()) != null && (imageView = binding.playPauseMusic) != null) {
                            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_pause1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        }
                        WeakReference<GroupMusicDialog> weakReference3 = actionListener.mWeakReferenceGroupMusicDialog;
                        if (weakReference3 != null && (groupMusicDialog3 = weakReference3.get()) != null && (mMusicManager = groupMusicDialog3.getMMusicManager()) != null) {
                            mMusicManager.t(MusicStatus.STOP);
                        }
                    }
                    WeakReference<GroupMusicDialog> weakReference4 = actionListener.mWeakReferenceGroupMusicDialog;
                    if (weakReference4 != null && (groupMusicDialog2 = weakReference4.get()) != null && (timerTask = groupMusicDialog2.mTimerTask) != null) {
                        timerTask.cancel();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void start$lambda$0(ActionListener actionListener, MusicLoader.MusicInfo musicInfo) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            WeakReference<GroupMusicDialog> weakReference = actionListener.mWeakReferenceGroupMusicDialog;
            if (weakReference != null && (groupMusicDialog2 = weakReference.get()) != null) {
                Intrinsics.checkNotNull(musicInfo);
                groupMusicDialog2.play(musicInfo);
            }
            WeakReference<GroupMusicDialog> weakReference2 = actionListener.mWeakReferenceGroupMusicDialog;
            if (weakReference2 != null && (groupMusicDialog = weakReference2.get()) != null) {
                groupMusicDialog.startLoadProgress();
            }
        }

        @Nullable
        public final WeakReference<GroupMusicDialog> getMWeakReferenceGroupMusicDialog() {
            return this.mWeakReferenceGroupMusicDialog;
        }

        @Override // com.qiahao.nextvideo.room.music.c.InterfaceC٠٠٠٢c
        public void lastOne(@Nullable final MusicLoader.MusicInfo musicInfo) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            WeakReference<GroupMusicDialog> weakReference = this.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                Context context = null;
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    try {
                        WeakReference<GroupMusicDialog> weakReference2 = this.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog2 = weakReference2.get()) != null) {
                            context = groupMusicDialog2.getMCurrentContext();
                        }
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.t
                            @Override // java.lang.Runnable
                            public final void run() {
                                GroupMusicDialog.ActionListener.lastOne$lambda$4(GroupMusicDialog.ActionListener.this, musicInfo);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            }
        }

        @Override // com.qiahao.nextvideo.room.music.c.InterfaceC٠٠٠٢c
        public void nextOne(@Nullable final MusicLoader.MusicInfo musicInfo) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            WeakReference<GroupMusicDialog> weakReference = this.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                Context context = null;
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    try {
                        WeakReference<GroupMusicDialog> weakReference2 = this.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog2 = weakReference2.get()) != null) {
                            context = groupMusicDialog2.getMCurrentContext();
                        }
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.r
                            @Override // java.lang.Runnable
                            public final void run() {
                                GroupMusicDialog.ActionListener.nextOne$lambda$5(GroupMusicDialog.ActionListener.this, musicInfo);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            }
        }

        @Override // com.qiahao.nextvideo.room.music.c.InterfaceC٠٠٠٢c
        public void onPause() {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            WeakReference<GroupMusicDialog> weakReference = this.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                Context context = null;
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    try {
                        WeakReference<GroupMusicDialog> weakReference2 = this.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog2 = weakReference2.get()) != null) {
                            context = groupMusicDialog2.getMCurrentContext();
                        }
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                GroupMusicDialog.ActionListener.onPause$lambda$1(GroupMusicDialog.ActionListener.this);
                            }
                        });
                    } catch (Exception unused) {
                        HiloRtcEngine.INSTANCE.pauseAudioMixing();
                    }
                }
            }
        }

        @Override // com.qiahao.nextvideo.room.music.c.InterfaceC٠٠٠٢c
        public void onResume() {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            WeakReference<GroupMusicDialog> weakReference = this.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                Context context = null;
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    try {
                        WeakReference<GroupMusicDialog> weakReference2 = this.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog2 = weakReference2.get()) != null) {
                            context = groupMusicDialog2.getMCurrentContext();
                        }
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                GroupMusicDialog.ActionListener.onResume$lambda$2(GroupMusicDialog.ActionListener.this);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            }
        }

        @Override // com.qiahao.nextvideo.room.music.c.InterfaceC٠٠٠٢c
        public void onStop() {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            WeakReference<GroupMusicDialog> weakReference = this.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                Context context = null;
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    try {
                        WeakReference<GroupMusicDialog> weakReference2 = this.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog2 = weakReference2.get()) != null) {
                            context = groupMusicDialog2.getMCurrentContext();
                        }
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.v
                            @Override // java.lang.Runnable
                            public final void run() {
                                GroupMusicDialog.ActionListener.onStop$lambda$3(GroupMusicDialog.ActionListener.this);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            }
        }

        public final void setMWeakReferenceGroupMusicDialog(@Nullable WeakReference<GroupMusicDialog> weakReference) {
            this.mWeakReferenceGroupMusicDialog = weakReference;
        }

        @Override // com.qiahao.nextvideo.room.music.c.InterfaceC٠٠٠٢c
        public void start(@Nullable final MusicLoader.MusicInfo musicInfo) {
            GroupMusicDialog groupMusicDialog;
            GroupMusicDialog groupMusicDialog2;
            WeakReference<GroupMusicDialog> weakReference = this.mWeakReferenceGroupMusicDialog;
            if (weakReference != null) {
                Context context = null;
                if (weakReference != null) {
                    groupMusicDialog = weakReference.get();
                } else {
                    groupMusicDialog = null;
                }
                if (groupMusicDialog != null) {
                    try {
                        WeakReference<GroupMusicDialog> weakReference2 = this.mWeakReferenceGroupMusicDialog;
                        if (weakReference2 != null && (groupMusicDialog2 = weakReference2.get()) != null) {
                            context = groupMusicDialog2.getMCurrentContext();
                        }
                        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                        ((Activity) context).runOnUiThread(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.u
                            @Override // java.lang.Runnable
                            public final void run() {
                                GroupMusicDialog.ActionListener.start$lambda$0(GroupMusicDialog.ActionListener.this, musicInfo);
                            }
                        });
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MusicStatus.values().length];
            try {
                iArr[MusicStatus.PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MusicStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupMusicDialog(@NotNull Context context, @NotNull MusicDialogListener musicDialogListener) {
        super(context, R.style.HiloBottomSheetDialog);
        Intrinsics.checkNotNullParameter(context, "mCurrentContext");
        Intrinsics.checkNotNullParameter(musicDialogListener, "mMusicDialogListener");
        this.mCurrentContext = context;
        this.mMusicDialogListener = musicDialogListener;
        this.mActivity = HiloUtils.INSTANCE.getActivity(context);
        this.dialogScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    }

    private final void initListener() {
        ActionListener actionListener = new ActionListener(this);
        this.mActionListener = actionListener;
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null) {
            cVar.setOnMusicActionListener(actionListener);
        }
        BuildersKt.launch$default(this.dialogScope, Dispatchers.getMain(), (CoroutineStart) null, new GroupMusicDialog$initListener$1(this, null), 2, (Object) null);
    }

    private final void initMusicManager() {
        com.qiahao.nextvideo.room.music.c musicManager = MeetingRoomManager.INSTANCE.getMusicManager();
        this.mMusicManager = musicManager;
        if (musicManager != null) {
            musicManager.setOnLoadingListener(this);
        }
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null) {
            cVar.o();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCanceledOnTouchOutside(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131362643);
        if (frameLayout != null) {
            BottomSheetBehavior.s0(frameLayout).c1(false);
            frameLayout.getLayoutParams().height = Dimens.INSTANCE.dpToPx(UserProxyUtility.notification);
            BottomSheetBehavior.s0(frameLayout).c(3);
            frameLayout.setBackgroundDrawable(new ColorDrawable(0));
        }
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setDimAmount(0.0f);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startLoadProgress() {
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.room.dialog.q
            @Override // java.lang.Runnable
            public final void run() {
                GroupMusicDialog.startLoadProgress$lambda$1(GroupMusicDialog.this);
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startLoadProgress$lambda$1(final GroupMusicDialog groupMusicDialog) {
        TimerTask timerTask;
        TimerTask timerTask2 = groupMusicDialog.mTimerTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        BaseActivity baseActivity = groupMusicDialog.mActivity;
        if (baseActivity != null) {
            timerTask = TimerKtxKt.loopTask$default(baseActivity, false, 0L, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.p
                public final Object invoke(Object obj) {
                    Unit startLoadProgress$lambda$1$lambda$0;
                    startLoadProgress$lambda$1$lambda$0 = GroupMusicDialog.startLoadProgress$lambda$1$lambda$0(GroupMusicDialog.this, ((Long) obj).longValue());
                    return startLoadProgress$lambda$1$lambda$0;
                }
            }, 3, (Object) null);
        } else {
            timerTask = null;
        }
        groupMusicDialog.mTimerTask = timerTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLoadProgress$lambda$1$lambda$0(GroupMusicDialog groupMusicDialog, long j) {
        int i;
        int audioMixingCurrentPosition = HiloRtcEngine.INSTANCE.audioMixingCurrentPosition();
        MusicLoader.MusicInfo m = MusicLoader.m();
        int i2 = 1;
        if (m != null) {
            i = m.b();
        } else {
            i = 1;
        }
        if (i > 0) {
            i2 = i;
        }
        groupMusicDialog.mProgress = (audioMixingCurrentPosition * 100) / i2;
        groupMusicDialog.getBinding().playProgress.setProgress(groupMusicDialog.mProgress);
        groupMusicDialog.getBinding().startText.setText(com.qiahao.base_common.utils.f.c(audioMixingCurrentPosition / 1000));
        groupMusicDialog.getBinding().endText.setText(com.qiahao.base_common.utils.f.c(i2 / 1000));
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
        this.mActivity = null;
        getMCompositeDisposable().d();
        CoroutineScopeKt.cancel$default(this.dialogScope, (CancellationException) null, 1, (Object) null);
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null) {
            cVar.removeOnLoadingListener(this);
        }
        com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
        if (cVar2 != null) {
            cVar2.setOnMusicActionListener(null);
        }
    }

    @NotNull
    public final DialogGroupMusicBinding getBinding() {
        DialogGroupMusicBinding dialogGroupMusicBinding = this.binding;
        if (dialogGroupMusicBinding != null) {
            return dialogGroupMusicBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        nd.a aVar = this.mCompositeDisposable;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCompositeDisposable");
        return null;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @NotNull
    public final MusicDialogListener getMMusicDialogListener() {
        return this.mMusicDialogListener;
    }

    @Nullable
    public final com.qiahao.nextvideo.room.music.c getMMusicManager() {
        return this.mMusicManager;
    }

    public final void initDataBinding() {
        int i;
        int i2;
        Integer h;
        MusicStatus musicStatus = null;
        setBinding((DialogGroupMusicBinding) androidx.databinding.g.h(LayoutInflater.from(this.mCurrentContext), R.layout.dialog_group_music, (ViewGroup) null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        initMusicManager();
        getBinding().voiceSeek.setMax(100);
        getBinding().playProgress.setMax(100);
        SeekBar seekBar = getBinding().voiceSeek;
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null) {
            i = cVar.k();
        } else {
            i = 20;
        }
        seekBar.setProgress(i);
        com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
        if (cVar2 != null && (h = cVar2.h()) != null && h.intValue() == 0) {
            ImageView imageView = getBinding().musicRotationType;
            Intrinsics.checkNotNullExpressionValue(imageView, "musicRotationType");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_list_rotation), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            ImageView imageView2 = getBinding().musicRotationType;
            Intrinsics.checkNotNullExpressionValue(imageView2, "musicRotationType");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_one_rotation), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        getBinding().voiceSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.qiahao.nextvideo.room.dialog.GroupMusicDialog$initDataBinding$1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                MeetingRoomManager.INSTANCE.getMusicManager().u(progress);
                HiloRtcEngine.INSTANCE.adjustAudioMixingVolume(progress);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar p0) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar p0) {
            }
        });
        getBinding().playProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.qiahao.nextvideo.room.dialog.GroupMusicDialog$initDataBinding$2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                MusicStatus musicStatus2;
                int i3;
                com.qiahao.nextvideo.room.music.c mMusicManager = GroupMusicDialog.this.getMMusicManager();
                if (mMusicManager != null) {
                    musicStatus2 = mMusicManager.i();
                } else {
                    musicStatus2 = null;
                }
                if (musicStatus2 != MusicStatus.PLAY) {
                    SeekBar seekBar3 = GroupMusicDialog.this.getBinding().playProgress;
                    i3 = GroupMusicDialog.this.mProgress;
                    seekBar3.setProgress(i3);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar p0) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
                MusicStatus musicStatus2;
                Intrinsics.checkNotNullParameter(seekBar2, "seekBar");
                com.qiahao.nextvideo.room.music.c mMusicManager = GroupMusicDialog.this.getMMusicManager();
                if (mMusicManager != null) {
                    musicStatus2 = mMusicManager.i();
                } else {
                    musicStatus2 = null;
                }
                if (musicStatus2 == MusicStatus.PLAY) {
                    TimerTask timerTask = GroupMusicDialog.this.mTimerTask;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    HiloRtcEngine.INSTANCE.setAudioMixingPosition((MusicLoader.m().b() * seekBar2.getProgress()) / 100);
                    GroupMusicDialog.this.startLoadProgress();
                }
            }
        });
        if (MusicLoader.m() != null) {
            getBinding().musicName.setText(MusicLoader.m().d());
            getBinding().startText.setText(com.qiahao.base_common.utils.f.c(0));
            getBinding().endText.setText(com.qiahao.base_common.utils.f.c(MusicLoader.m().b() / 1000));
        } else {
            List i3 = MeetingRoomManager.INSTANCE.getMusicManager().g().i();
            if (i3 != null && !i3.isEmpty()) {
                getBinding().emptyPalylist.setVisibility(8);
                getBinding().llMusicPlay.setVisibility(0);
            } else {
                getBinding().emptyPalylist.setVisibility(0);
                getBinding().llMusicPlay.setVisibility(8);
            }
        }
        com.qiahao.nextvideo.room.music.c cVar3 = this.mMusicManager;
        if (cVar3 != null) {
            musicStatus = cVar3.i();
        }
        if (musicStatus == null) {
            i2 = -1;
        } else {
            i2 = WhenMappings.$EnumSwitchMapping$0[musicStatus.ordinal()];
        }
        if (i2 != 1) {
            if (i2 != 2) {
                ImageView imageView3 = getBinding().playPauseMusic;
                Intrinsics.checkNotNullExpressionValue(imageView3, "playPauseMusic");
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_pause1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            } else {
                ImageView imageView4 = getBinding().playPauseMusic;
                Intrinsics.checkNotNullExpressionValue(imageView4, "playPauseMusic");
                ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_pause1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            }
        }
        ImageView imageView5 = getBinding().playPauseMusic;
        Intrinsics.checkNotNullExpressionValue(imageView5, "playPauseMusic");
        ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_play1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Integer d;
        MusicStatus musicStatus;
        int i;
        Intrinsics.checkNotNullParameter(v, "v");
        switch (v.getId()) {
            case R.id.audio /* 2131361997 */:
                getBinding().llMusicPlay.setVisibility(8);
                getBinding().voiceLayout.setVisibility(0);
                return;
            case 2131362220:
                getBinding().llMusicPlay.setVisibility(0);
                getBinding().voiceLayout.setVisibility(8);
                return;
            case R.id.close /* 2131362369 */:
                dismiss();
                return;
            case R.id.empty_add_music /* 2131362752 */:
                AddMusicActivity.INSTANCE.start(this.mCurrentContext);
                return;
            case R.id.music_list /* 2131363995 */:
                this.mMusicDialogListener.musicList();
                return;
            case R.id.music_rotation_type /* 2131363998 */:
                com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
                if (cVar != null && (d = cVar.d()) != null && d.intValue() == 0) {
                    ImageView imageView = getBinding().musicRotationType;
                    Intrinsics.checkNotNullExpressionValue(imageView, "musicRotationType");
                    ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_list_rotation), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                } else {
                    ImageView imageView2 = getBinding().musicRotationType;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "musicRotationType");
                    ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_one_rotation), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                }
            case R.id.next_music /* 2131364055 */:
                com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
                if (cVar2 != null) {
                    cVar2.p(false);
                    return;
                }
                return;
            case R.id.old_music /* 2131364115 */:
                com.qiahao.nextvideo.room.music.c cVar3 = this.mMusicManager;
                if (cVar3 != null) {
                    cVar3.n();
                    return;
                }
                return;
            case R.id.play_pause_music /* 2131364277 */:
                com.qiahao.nextvideo.room.music.c cVar4 = this.mMusicManager;
                if (cVar4 != null) {
                    musicStatus = cVar4.i();
                } else {
                    musicStatus = null;
                }
                if (musicStatus == null) {
                    i = -1;
                } else {
                    i = WhenMappings.$EnumSwitchMapping$0[musicStatus.ordinal()];
                }
                if (i != 1) {
                    if (i != 2) {
                        com.qiahao.nextvideo.room.music.c cVar5 = this.mMusicManager;
                        if (cVar5 != null) {
                            cVar5.r();
                            return;
                        }
                        return;
                    }
                    com.qiahao.nextvideo.room.music.c cVar6 = this.mMusicManager;
                    if (cVar6 != null) {
                        cVar6.s();
                        return;
                    }
                    return;
                }
                com.qiahao.nextvideo.room.music.c cVar7 = this.mMusicManager;
                if (cVar7 != null) {
                    cVar7.q();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setMCompositeDisposable(new nd.a());
        initDataBinding();
        initStyle();
        initListener();
    }

    @Override // com.qiahao.nextvideo.room.music.c.b
    public void onLoadingFinish() {
        List list;
        MusicLoader.MusicInfo musicInfo;
        MusicLoader.MusicInfo musicInfo2;
        MusicLoader.MusicInfo musicInfo3;
        MusicLoader g = MeetingRoomManager.INSTANCE.getMusicManager().g();
        String str = null;
        if (g != null) {
            list = g.j();
        } else {
            list = null;
        }
        int i = 0;
        if (list != null && !list.isEmpty()) {
            getBinding().emptyPalylist.setVisibility(8);
            getBinding().llMusicPlay.setVisibility(0);
        } else {
            getBinding().emptyPalylist.setVisibility(0);
            getBinding().llMusicPlay.setVisibility(8);
        }
        if (MusicLoader.m() != null) {
            getBinding().musicName.setText(MusicLoader.m().d());
            getBinding().startText.setText(com.qiahao.base_common.utils.f.c(0));
            getBinding().endText.setText(com.qiahao.base_common.utils.f.c(MusicLoader.m().b() / 1000));
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (list != null) {
                musicInfo = (MusicLoader.MusicInfo) list.get(0);
            } else {
                musicInfo = null;
            }
            MusicLoader.o(musicInfo);
            TextView textView = getBinding().musicName;
            if (list != null && (musicInfo3 = (MusicLoader.MusicInfo) list.get(0)) != null) {
                str = musicInfo3.d();
            }
            textView.setText(str);
            getBinding().startText.setText(com.qiahao.base_common.utils.f.c(0));
            TextView textView2 = getBinding().endText;
            if (list != null && (musicInfo2 = (MusicLoader.MusicInfo) list.get(0)) != null) {
                i = musicInfo2.b();
            }
            textView2.setText(com.qiahao.base_common.utils.f.c(i / 1000));
        }
    }

    public final void play(@NotNull MusicLoader.MusicInfo musicInfo) {
        int i;
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        getBinding().musicName.setText(musicInfo.d());
        getBinding().startText.setText(com.qiahao.base_common.utils.f.c(0));
        getBinding().endText.setText(com.qiahao.base_common.utils.f.c(musicInfo.b() / 1000));
        HiloRtcEngine hiloRtcEngine = HiloRtcEngine.INSTANCE;
        int startAudioMixing = hiloRtcEngine.startAudioMixing(musicInfo.e(), false, 1);
        com.qiahao.nextvideo.room.music.c cVar = this.mMusicManager;
        if (cVar != null) {
            i = cVar.k();
        } else {
            i = 20;
        }
        hiloRtcEngine.adjustAudioMixingVolume(i);
        if (startAudioMixing == 0) {
            ImageView imageView = getBinding().playPauseMusic;
            Intrinsics.checkNotNullExpressionValue(imageView, "playPauseMusic");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_music_play1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            com.qiahao.nextvideo.room.music.c cVar2 = this.mMusicManager;
            if (cVar2 != null) {
                cVar2.t(MusicStatus.PLAY);
            }
            MusicLoader.o(musicInfo);
        }
    }

    public final void setBinding(@NotNull DialogGroupMusicBinding dialogGroupMusicBinding) {
        Intrinsics.checkNotNullParameter(dialogGroupMusicBinding, "<set-?>");
        this.binding = dialogGroupMusicBinding;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMMusicManager(@Nullable com.qiahao.nextvideo.room.music.c cVar) {
        this.mMusicManager = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        startLoadProgress();
    }
}
