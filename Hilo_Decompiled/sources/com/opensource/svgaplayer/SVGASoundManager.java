package com.opensource.svgaplayer;

import android.media.AudioAttributes;
import android.media.SoundPool;
import com.opensource.svgaplayer.entities.SVGAAudioEntity;
import com.opensource.svgaplayer.utils.log.LogUtils;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.FileDescriptor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u000b0\u000b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\bJ\r\u0010\u0014\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0015J9\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH\u0000¢\u0006\u0002\b!J\u0015\u0010\"\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0000¢\u0006\u0002\b#J\u0006\u0010$\u001a\u00020\u0013J\u0015\u0010%\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH\u0000¢\u0006\u0002\b&J\u001a\u0010'\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)J\u0015\u0010*\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\bH\u0000¢\u0006\u0002\b-R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/opensource/svgaplayer/SVGASoundManager;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "soundCallBackMap", "", "", "Lcom/opensource/svgaplayer/SVGASoundManager$SVGASoundCallBack;", "soundPool", "Landroid/media/SoundPool;", "volume", "", "checkInit", "", "getSoundPool", "maxStreams", "init", "", "isInit", "isInit$lib_svga_release", "load", "callBack", "fd", "Ljava/io/FileDescriptor;", "offset", "", "length", "priority", "load$lib_svga_release", "pause", "soundId", "pause$lib_svga_release", "play", "play$lib_svga_release", "release", "resume", "resume$lib_svga_release", "setVolume", "entity", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "stop", "stop$lib_svga_release", "unload", "unload$lib_svga_release", "SVGASoundCallBack", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGASoundManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGASoundManager.kt\ncom/opensource/svgaplayer/SVGASoundManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,194:1\n1855#2,2:195\n*S KotlinDebug\n*F\n+ 1 SVGASoundManager.kt\ncom/opensource/svgaplayer/SVGASoundManager\n*L\n106#1:195,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGASoundManager {

    @Nullable
    private static SoundPool soundPool;

    @NotNull
    public static final SVGASoundManager INSTANCE = new SVGASoundManager();
    private static final String TAG = SVGASoundManager.class.getSimpleName();

    @NotNull
    private static final Map<Integer, SVGASoundCallBack> soundCallBackMap = new LinkedHashMap();
    private static float volume = 1.0f;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/SVGASoundManager$SVGASoundCallBack;", "", "onComplete", "", "onVolumeChange", "value", "", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface SVGASoundCallBack {
        void onComplete();

        void onVolumeChange(float value);
    }

    private SVGASoundManager() {
    }

    private final boolean checkInit() {
        boolean isInit$lib_svga_release = isInit$lib_svga_release();
        if (!isInit$lib_svga_release) {
            LogUtils logUtils = LogUtils.INSTANCE;
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logUtils.error(TAG2, "soundPool is null, you need call init() !!!");
        }
        return isInit$lib_svga_release;
    }

    private final SoundPool getSoundPool(int maxStreams) {
        return new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build()).setMaxStreams(maxStreams).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(SoundPool soundPool2, int i10, int i11) {
        SVGASoundCallBack sVGASoundCallBack;
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "SoundPool onLoadComplete soundId=" + i10 + " status=" + i11);
        if (i11 == 0) {
            Map<Integer, SVGASoundCallBack> map = soundCallBackMap;
            if (map.containsKey(Integer.valueOf(i10)) && (sVGASoundCallBack = map.get(Integer.valueOf(i10))) != null) {
                sVGASoundCallBack.onComplete();
            }
        }
    }

    public static /* synthetic */ void setVolume$default(SVGASoundManager sVGASoundManager, float f10, SVGAVideoEntity sVGAVideoEntity, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            sVGAVideoEntity = null;
        }
        sVGASoundManager.setVolume(f10, sVGAVideoEntity);
    }

    public final void init() {
        init(20);
    }

    public final boolean isInit$lib_svga_release() {
        if (soundPool != null) {
            return true;
        }
        return false;
    }

    public final int load$lib_svga_release(@Nullable SVGASoundCallBack callBack, @Nullable FileDescriptor fd, long offset, long length, int priority) {
        if (!checkInit()) {
            return -1;
        }
        SoundPool soundPool2 = soundPool;
        Intrinsics.checkNotNull(soundPool2);
        int load = soundPool2.load(fd, offset, length, priority);
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "load soundId=" + load + " callBack=" + callBack);
        if (callBack != null) {
            Map<Integer, SVGASoundCallBack> map = soundCallBackMap;
            if (!map.containsKey(Integer.valueOf(load))) {
                map.put(Integer.valueOf(load), callBack);
            }
        }
        return load;
    }

    public final void pause$lib_svga_release(int soundId) {
        if (!checkInit()) {
            return;
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "pause soundId=" + soundId);
        SoundPool soundPool2 = soundPool;
        Intrinsics.checkNotNull(soundPool2);
        soundPool2.pause(soundId);
    }

    public final int play$lib_svga_release(int soundId) {
        if (!checkInit()) {
            return -1;
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "play soundId=" + soundId);
        SoundPool soundPool2 = soundPool;
        Intrinsics.checkNotNull(soundPool2);
        float f10 = volume;
        return soundPool2.play(soundId, f10, f10, 1, 0, 1.0f);
    }

    public final void release() {
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "**************** release ****************");
        Map<Integer, SVGASoundCallBack> map = soundCallBackMap;
        if (!map.isEmpty()) {
            map.clear();
        }
    }

    public final void resume$lib_svga_release(int soundId) {
        if (!checkInit()) {
            return;
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "stop soundId=" + soundId);
        SoundPool soundPool2 = soundPool;
        Intrinsics.checkNotNull(soundPool2);
        soundPool2.resume(soundId);
    }

    public final void setVolume(float volume2, @Nullable SVGAVideoEntity entity) {
        Integer playID;
        if (!checkInit()) {
            return;
        }
        if (volume2 >= DownloadProgress.UNKNOWN_PROGRESS && volume2 <= 1.0f) {
            if (entity == null) {
                volume = volume2;
                Iterator<Map.Entry<Integer, SVGASoundCallBack>> it = soundCallBackMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().onVolumeChange(volume2);
                }
                return;
            }
            SoundPool soundPool2 = soundPool;
            if (soundPool2 == null) {
                return;
            }
            Iterator<T> it2 = entity.getAudioList$lib_svga_release().iterator();
            while (it2.hasNext() && (playID = ((SVGAAudioEntity) it2.next()).getPlayID()) != null) {
                soundPool2.setVolume(playID.intValue(), volume2, volume2);
            }
            return;
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.error(TAG2, "The volume level is in the range of 0 to 1 ");
    }

    public final void stop$lib_svga_release(int soundId) {
        if (!checkInit()) {
            return;
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "stop soundId=" + soundId);
        SoundPool soundPool2 = soundPool;
        Intrinsics.checkNotNull(soundPool2);
        soundPool2.stop(soundId);
    }

    public final void unload$lib_svga_release(int soundId) {
        if (!checkInit()) {
            return;
        }
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "unload soundId=" + soundId);
        SoundPool soundPool2 = soundPool;
        Intrinsics.checkNotNull(soundPool2);
        soundPool2.unload(soundId);
        soundCallBackMap.remove(Integer.valueOf(soundId));
    }

    public final void init(int maxStreams) {
        LogUtils logUtils = LogUtils.INSTANCE;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        logUtils.debug(TAG2, "**************** init **************** " + maxStreams);
        if (soundPool != null) {
            return;
        }
        SoundPool soundPool2 = getSoundPool(maxStreams);
        soundPool = soundPool2;
        if (soundPool2 != null) {
            soundPool2.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.opensource.svgaplayer.n
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public final void onLoadComplete(SoundPool soundPool3, int i10, int i11) {
                    SVGASoundManager.init$lambda$0(soundPool3, i10, i11);
                }
            });
        }
    }
}
