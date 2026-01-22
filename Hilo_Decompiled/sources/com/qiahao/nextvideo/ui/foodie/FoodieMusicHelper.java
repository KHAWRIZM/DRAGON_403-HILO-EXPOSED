package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import android.media.MediaPlayer;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieMusicHelper;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "mMediaPlayer", "Landroid/media/MediaPlayer;", "mMusicType", "Lcom/qiahao/nextvideo/ui/foodie/FoodieMusicType;", "mIsMute", "", "playMusic", "", "type", "switchMute", "isMute", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "getMusicAndPlay", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieMusicHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieMusicHelper.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieMusicHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieMusicHelper {

    @NotNull
    private final Context context;
    private boolean mIsMute;

    @Nullable
    private MediaPlayer mMediaPlayer;

    @Nullable
    private FoodieMusicType mMusicType;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FoodieMusicType.values().length];
            try {
                iArr[FoodieMusicType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FoodieMusicType.BIG_REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FoodieMusicType.SMALL_REWARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FoodieMusicType.WHEELING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FoodieMusicHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mIsMute = ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, FoodieConstants.KEY_FOODIE_MUSIC_MUTE, Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
    }

    private final void getMusicAndPlay(FoodieMusicType type) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        MediaPlayer create = MediaPlayer.create(this.context, R.raw.foodie_wheeling_music);
                        this.mMediaPlayer = create;
                        if (create != null) {
                            create.setLooping(false);
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    MediaPlayer create2 = MediaPlayer.create(this.context, R.raw.foodie_small_reward_music);
                    this.mMediaPlayer = create2;
                    if (create2 != null) {
                        create2.setLooping(false);
                    }
                }
            } else {
                MediaPlayer create3 = MediaPlayer.create(this.context, R.raw.foodie_big_reward_music);
                this.mMediaPlayer = create3;
                if (create3 != null) {
                    create3.setLooping(false);
                }
            }
        } else {
            MediaPlayer create4 = MediaPlayer.create(this.context, R.raw.foodie_background_music);
            this.mMediaPlayer = create4;
            if (create4 != null) {
                create4.setLooping(true);
            }
        }
        MediaPlayer mediaPlayer2 = this.mMediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.start();
        }
    }

    public final void destroy() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mMediaPlayer = null;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    /* renamed from: isMute, reason: from getter */
    public final boolean getMIsMute() {
        return this.mIsMute;
    }

    public final void playMusic(@NotNull FoodieMusicType type) {
        MediaPlayer mediaPlayer;
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.mMusicType == type && (mediaPlayer = this.mMediaPlayer) != null && mediaPlayer.isPlaying()) {
            return;
        }
        this.mMusicType = type;
        if (this.mIsMute) {
            return;
        }
        getMusicAndPlay(type);
    }

    public final boolean switchMute() {
        boolean z = !this.mIsMute;
        this.mIsMute = z;
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, FoodieConstants.KEY_FOODIE_MUSIC_MUTE, Boolean.valueOf(z), (String) null, 4, (Object) null);
        if (this.mIsMute) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
            }
        } else {
            FoodieMusicType foodieMusicType = this.mMusicType;
            if (foodieMusicType != null) {
                getMusicAndPlay(foodieMusicType);
            }
        }
        return this.mIsMute;
    }
}
