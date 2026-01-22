package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.SoundPool;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGASoundManager;
import com.opensource.svgaplayer.bitmap.SVGABitmapByteArrayDecoder;
import com.opensource.svgaplayer.bitmap.SVGABitmapFileDecoder;
import com.opensource.svgaplayer.entities.SVGAAudioEntity;
import com.opensource.svgaplayer.entities.SVGAVideoSpriteEntity;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import com.opensource.svgaplayer.utils.SVGARect;
import com.opensource.svgaplayer.utils.log.LogUtils;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B'\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nB\u0017\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\rB'\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\u000eJ\u0006\u0010H\u001a\u00020.J\u001a\u0010I\u001a\u0004\u0018\u00010&2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0014H\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010&2\u0006\u0010L\u001a\u00020\u0014H\u0002J$\u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020O2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050%H\u0002J\u0018\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020KH\u0002J\u001c\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050%2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020K0%2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020\u00142\u0006\u0010X\u001a\u00020\u0014H\u0002J\u0012\u0010Y\u001a\u0004\u0018\u00010;2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010Z\u001a\u00020.2\u0006\u0010[\u001a\u00020\fH\u0002J\u0010\u0010Z\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J%\u0010\\\u001a\u00020.2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010^\u001a\u0004\u0018\u000102H\u0000¢\u0006\u0002\b_J\u0010\u0010`\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010`\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001e\u0010a\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u0010\u0010c\u001a\u00020.2\u0006\u0010d\u001a\u00020\u0003H\u0002J\u0010\u0010e\u001a\u00020.2\u0006\u0010f\u001a\u00020gH\u0002J\u001e\u0010h\u001a\u00020.2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002R\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R&\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020&0%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00103\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R \u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u001cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001f\"\u0004\bC\u0010!R\u001e\u0010E\u001a\u00020D2\u0006\u0010\u000f\u001a\u00020D@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010G¨\u0006i"}, d2 = {"Lcom/opensource/svgaplayer/SVGAVideoEntity;", "", "json", "Lorg/json/JSONObject;", "cacheDir", "Ljava/io/File;", "(Lorg/json/JSONObject;Ljava/io/File;)V", "frameWidth", "", "frameHeight", "(Lorg/json/JSONObject;Ljava/io/File;II)V", "entity", "Lcom/opensource/svgaplayer/proto/MovieEntity;", "(Lcom/opensource/svgaplayer/proto/MovieEntity;Ljava/io/File;)V", "(Lcom/opensource/svgaplayer/proto/MovieEntity;Ljava/io/File;II)V", "<set-?>", "FPS", "getFPS", "()I", "TAG", "", "antiAlias", "", "getAntiAlias", "()Z", "setAntiAlias", "(Z)V", "audioList", "", "Lcom/opensource/svgaplayer/entities/SVGAAudioEntity;", "getAudioList$lib_svga_release", "()Ljava/util/List;", "setAudioList$lib_svga_release", "(Ljava/util/List;)V", "frames", "getFrames", "imageMap", "Ljava/util/HashMap;", "Landroid/graphics/Bitmap;", "getImageMap$lib_svga_release", "()Ljava/util/HashMap;", "setImageMap$lib_svga_release", "(Ljava/util/HashMap;)V", "mCacheDir", "mCallback", "Lkotlin/Function0;", "", "mFrameHeight", "mFrameWidth", "mPlayCallback", "Lcom/opensource/svgaplayer/SVGAParser$PlayCallback;", "movieItem", "getMovieItem", "()Lcom/opensource/svgaplayer/proto/MovieEntity;", "setMovieItem", "(Lcom/opensource/svgaplayer/proto/MovieEntity;)V", "soundCallback", "Lcom/opensource/svgaplayer/SVGASoundManager$SVGASoundCallBack;", "soundPool", "Landroid/media/SoundPool;", "getSoundPool$lib_svga_release", "()Landroid/media/SoundPool;", "setSoundPool$lib_svga_release", "(Landroid/media/SoundPool;)V", "spriteList", "Lcom/opensource/svgaplayer/entities/SVGAVideoSpriteEntity;", "getSpriteList$lib_svga_release", "setSpriteList$lib_svga_release", "Lcom/opensource/svgaplayer/utils/SVGARect;", "videoSize", "getVideoSize", "()Lcom/opensource/svgaplayer/utils/SVGARect;", "clear", "createBitmap", "byteArray", "", "filePath", "createSvgaAudioEntity", PictureMimeType.MIME_TYPE_PREFIX_AUDIO, "Lcom/opensource/svgaplayer/proto/AudioEntity;", "audiosFileMap", "generateAudioFile", "audioCache", "value", "generateAudioFileMap", "generateAudioMap", "generateBitmapFilePath", "imgName", "imgKey", "generateSoundPool", "parserImages", "obj", "prepare", "callback", "playCallback", "prepare$lib_svga_release", "resetSprites", "setupAudios", "completionBlock", "setupByJson", "movieObject", "setupByMovie", "movieParams", "Lcom/opensource/svgaplayer/proto/MovieParams;", "setupSoundPool", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGAVideoEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGAVideoEntity.kt\ncom/opensource/svgaplayer/SVGAVideoEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,348:1\n1#2:349\n32#3,2:350\n1855#4,2:352\n1549#4:354\n1620#4,3:355\n1549#4:358\n1620#4,3:359\n1855#4,2:366\n1855#4,2:368\n215#5,2:362\n215#5,2:364\n*S KotlinDebug\n*F\n+ 1 SVGAVideoEntity.kt\ncom/opensource/svgaplayer/SVGAVideoEntity\n*L\n122#1:350,2\n153#1:352,2\n187#1:354\n187#1:355,3\n205#1:358\n205#1:359,3\n271#1:366,2\n335#1:368,2\n221#1:362,2\n257#1:364,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAVideoEntity {
    private int FPS;

    @NotNull
    private final String TAG;
    private boolean antiAlias;

    @NotNull
    private List<SVGAAudioEntity> audioList;
    private int frames;

    @NotNull
    private HashMap<String, Bitmap> imageMap;

    @NotNull
    private File mCacheDir;
    private Function0<Unit> mCallback;
    private int mFrameHeight;
    private int mFrameWidth;

    @Nullable
    private SVGAParser.PlayCallback mPlayCallback;

    @Nullable
    private MovieEntity movieItem;

    @Nullable
    private SVGASoundManager.SVGASoundCallBack soundCallback;

    @Nullable
    private SoundPool soundPool;

    @NotNull
    private List<SVGAVideoSpriteEntity> spriteList;

    @NotNull
    private SVGARect videoSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAVideoEntity(@NotNull JSONObject json, @NotNull File cacheDir) {
        this(json, cacheDir, 0, 0);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
    }

    private final Bitmap createBitmap(String filePath) {
        return SVGABitmapFileDecoder.INSTANCE.decodeBitmapFrom(filePath, this.mFrameWidth, this.mFrameHeight);
    }

    private final SVGAAudioEntity createSvgaAudioEntity(AudioEntity audio, HashMap<String, File> audiosFileMap) {
        int i10;
        Integer num;
        SVGAAudioEntity sVGAAudioEntity = new SVGAAudioEntity(audio);
        Integer num2 = audio.startTime;
        int i11 = 0;
        if (num2 != null) {
            i10 = num2.intValue();
        } else {
            i10 = 0;
        }
        double d10 = i10;
        Integer num3 = audio.totalTime;
        if (num3 != null) {
            i11 = num3.intValue();
        }
        double d11 = i11;
        if (((int) d11) == 0) {
            return sVGAAudioEntity;
        }
        SVGAParser.PlayCallback playCallback = this.mPlayCallback;
        Function0<Unit> function0 = null;
        if (playCallback != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, File>> it = audiosFileMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            playCallback.onPlay(arrayList);
            Function0<Unit> function02 = this.mCallback;
            if (function02 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
            } else {
                function0 = function02;
            }
            function0.invoke();
            return sVGAAudioEntity;
        }
        File file = audiosFileMap.get(audio.audioKey);
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                double available = fileInputStream.available();
                long j10 = (long) ((d10 / d11) * available);
                SVGASoundManager sVGASoundManager = SVGASoundManager.INSTANCE;
                if (sVGASoundManager.isInit$lib_svga_release()) {
                    sVGAAudioEntity.setSoundID(Integer.valueOf(sVGASoundManager.load$lib_svga_release(this.soundCallback, fileInputStream.getFD(), j10, (long) available, 1)));
                } else {
                    SoundPool soundPool = this.soundPool;
                    if (soundPool != null) {
                        num = Integer.valueOf(soundPool.load(fileInputStream.getFD(), j10, (long) available, 1));
                    } else {
                        num = null;
                    }
                    sVGAAudioEntity.setSoundID(num);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
            } finally {
            }
        }
        return sVGAAudioEntity;
    }

    private final File generateAudioFile(File audioCache, byte[] value) {
        audioCache.createNewFile();
        new FileOutputStream(audioCache).write(value);
        return audioCache;
    }

    private final HashMap<String, File> generateAudioFileMap(MovieEntity entity) {
        File file;
        HashMap<String, byte[]> generateAudioMap = generateAudioMap(entity);
        HashMap<String, File> hashMap = new HashMap<>();
        if (generateAudioMap.size() > 0) {
            for (Map.Entry<String, byte[]> entry : generateAudioMap.entrySet()) {
                File buildAudioFile = SVGACache.INSTANCE.buildAudioFile(entry.getKey());
                String key = entry.getKey();
                if (buildAudioFile.exists()) {
                    file = buildAudioFile;
                } else {
                    file = null;
                }
                if (file == null) {
                    file = generateAudioFile(buildAudioFile, entry.getValue());
                }
                hashMap.put(key, file);
            }
        }
        return hashMap;
    }

    private final HashMap<String, byte[]> generateAudioMap(MovieEntity entity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        HashMap<String, byte[]> hashMap = new HashMap<>();
        Map<String, ByteString> map = entity.images;
        if (map != null && (entrySet = map.entrySet()) != null) {
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
                if (byteArray.length >= 4) {
                    List<Byte> slice = ArraysKt.slice(byteArray, new IntRange(0, 3));
                    if (slice.get(0).byteValue() == 73 && slice.get(1).byteValue() == 68 && slice.get(2).byteValue() == 51) {
                        Intrinsics.checkNotNull(str);
                        hashMap.put(str, byteArray);
                    } else if (slice.get(0).byteValue() == -1 && slice.get(1).byteValue() == -5 && slice.get(2).byteValue() == -108) {
                        Intrinsics.checkNotNull(str);
                        hashMap.put(str, byteArray);
                    }
                }
            }
        }
        return hashMap;
    }

    private final String generateBitmapFilePath(String imgName, String imgKey) {
        String str = this.mCacheDir.getAbsolutePath() + "/" + imgName;
        String str2 = str + ".png";
        String str3 = this.mCacheDir.getAbsolutePath() + "/" + imgKey + ".png";
        if (!new File(str).exists()) {
            if (new File(str2).exists()) {
                return str2;
            }
            if (new File(str3).exists()) {
                return str3;
            }
            return "";
        }
        return str;
    }

    private final SoundPool generateSoundPool(MovieEntity entity) {
        try {
            SoundPool.Builder audioAttributes = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build());
            List<AudioEntity> audios = entity.audios;
            Intrinsics.checkNotNullExpressionValue(audios, "audios");
            return audioAttributes.setMaxStreams(RangesKt.coerceAtMost(12, audios.size())).build();
        } catch (Exception e10) {
            LogUtils.INSTANCE.error(this.TAG, e10);
            return null;
        }
    }

    private final void parserImages(JSONObject json) {
        JSONObject optJSONObject = json.optJSONObject("images");
        if (optJSONObject == null) {
            return;
        }
        Iterator<String> keys = optJSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String next = keys.next();
            String obj = optJSONObject.get(next).toString();
            Intrinsics.checkNotNull(next);
            String generateBitmapFilePath = generateBitmapFilePath(obj, next);
            if (generateBitmapFilePath.length() == 0) {
                return;
            }
            String replace$default = StringsKt.replace$default(next, ".matte", "", false, 4, (Object) null);
            Bitmap createBitmap = createBitmap(generateBitmapFilePath);
            if (createBitmap != null) {
                this.imageMap.put(replace$default, createBitmap);
            }
        }
    }

    private final void resetSprites(JSONObject json) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = json.optJSONArray("sprites");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    Intrinsics.checkNotNull(optJSONObject);
                    arrayList.add(new SVGAVideoSpriteEntity(optJSONObject));
                }
            }
        }
        this.spriteList = CollectionsKt.toList(arrayList);
    }

    private final void setupAudios(MovieEntity entity, Function0<Unit> completionBlock) {
        List<AudioEntity> list = entity.audios;
        if (list != null && !list.isEmpty()) {
            setupSoundPool(entity, completionBlock);
            HashMap<String, File> generateAudioFileMap = generateAudioFileMap(entity);
            if (generateAudioFileMap.size() == 0) {
                completionBlock.invoke();
                return;
            }
            List<AudioEntity> audios = entity.audios;
            Intrinsics.checkNotNullExpressionValue(audios, "audios");
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(audios, 10));
            for (AudioEntity audioEntity : audios) {
                Intrinsics.checkNotNull(audioEntity);
                arrayList.add(createSvgaAudioEntity(audioEntity, generateAudioFileMap));
            }
            this.audioList = arrayList;
            return;
        }
        completionBlock.invoke();
    }

    private final void setupByJson(JSONObject movieObject) {
        JSONObject optJSONObject = movieObject.optJSONObject("viewBox");
        if (optJSONObject != null) {
            this.videoSize = new SVGARect(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        }
        this.FPS = movieObject.optInt("fps", 20);
        this.frames = movieObject.optInt("frames", 0);
    }

    private final void setupByMovie(MovieParams movieParams) {
        float f10;
        int intValue;
        int intValue2;
        Float f11 = movieParams.viewBoxWidth;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        if (f11 != null) {
            f10 = f11.floatValue();
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        double d10 = f10;
        Float f13 = movieParams.viewBoxHeight;
        if (f13 != null) {
            f12 = f13.floatValue();
        }
        this.videoSize = new SVGARect(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, d10, f12);
        Integer num = movieParams.fps;
        if (num == null) {
            intValue = 20;
        } else {
            intValue = num.intValue();
        }
        this.FPS = intValue;
        Integer num2 = movieParams.frames;
        if (num2 == null) {
            intValue2 = 0;
        } else {
            intValue2 = num2.intValue();
        }
        this.frames = intValue2;
    }

    private final void setupSoundPool(final MovieEntity entity, final Function0<Unit> completionBlock) {
        final Ref.IntRef intRef = new Ref.IntRef();
        if (SVGASoundManager.INSTANCE.isInit$lib_svga_release()) {
            this.soundCallback = new SVGASoundManager.SVGASoundCallBack() { // from class: com.opensource.svgaplayer.SVGAVideoEntity$setupSoundPool$1
                @Override // com.opensource.svgaplayer.SVGASoundManager.SVGASoundCallBack
                public void onComplete() {
                    Ref.IntRef intRef2 = intRef;
                    int i10 = intRef2.element + 1;
                    intRef2.element = i10;
                    List<AudioEntity> audios = entity.audios;
                    Intrinsics.checkNotNullExpressionValue(audios, "audios");
                    if (i10 >= audios.size()) {
                        completionBlock.invoke();
                    }
                }

                @Override // com.opensource.svgaplayer.SVGASoundManager.SVGASoundCallBack
                public void onVolumeChange(float value) {
                    SVGASoundManager.INSTANCE.setVolume(value, SVGAVideoEntity.this);
                }
            };
            return;
        }
        this.soundPool = generateSoundPool(entity);
        LogUtils.INSTANCE.info("SVGAParser", "pool_start");
        SoundPool soundPool = this.soundPool;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.opensource.svgaplayer.o
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public final void onLoadComplete(SoundPool soundPool2, int i10, int i11) {
                    SVGAVideoEntity.setupSoundPool$lambda$15(Ref.IntRef.this, entity, completionBlock, soundPool2, i10, i11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSoundPool$lambda$15(Ref.IntRef soundLoaded, MovieEntity entity, Function0 completionBlock, SoundPool soundPool, int i10, int i11) {
        Intrinsics.checkNotNullParameter(soundLoaded, "$soundLoaded");
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(completionBlock, "$completionBlock");
        LogUtils.INSTANCE.info("SVGAParser", "pool_complete");
        int i12 = soundLoaded.element + 1;
        soundLoaded.element = i12;
        List<AudioEntity> audios = entity.audios;
        Intrinsics.checkNotNullExpressionValue(audios, "audios");
        if (i12 >= audios.size()) {
            completionBlock.invoke();
        }
    }

    public final void clear() {
        if (SVGASoundManager.INSTANCE.isInit$lib_svga_release()) {
            Iterator<T> it = this.audioList.iterator();
            while (it.hasNext()) {
                Integer soundID = ((SVGAAudioEntity) it.next()).getSoundID();
                if (soundID != null) {
                    SVGASoundManager.INSTANCE.unload$lib_svga_release(soundID.intValue());
                }
            }
            this.soundCallback = null;
        }
        SoundPool soundPool = this.soundPool;
        if (soundPool != null) {
            soundPool.release();
        }
        this.soundPool = null;
        this.audioList = CollectionsKt.emptyList();
        this.spriteList = CollectionsKt.emptyList();
        this.imageMap.clear();
    }

    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    @NotNull
    public final List<SVGAAudioEntity> getAudioList$lib_svga_release() {
        return this.audioList;
    }

    public final int getFPS() {
        return this.FPS;
    }

    public final int getFrames() {
        return this.frames;
    }

    @NotNull
    public final HashMap<String, Bitmap> getImageMap$lib_svga_release() {
        return this.imageMap;
    }

    @Nullable
    public final MovieEntity getMovieItem() {
        return this.movieItem;
    }

    @Nullable
    /* renamed from: getSoundPool$lib_svga_release, reason: from getter */
    public final SoundPool getSoundPool() {
        return this.soundPool;
    }

    @NotNull
    public final List<SVGAVideoSpriteEntity> getSpriteList$lib_svga_release() {
        return this.spriteList;
    }

    @NotNull
    public final SVGARect getVideoSize() {
        return this.videoSize;
    }

    public final void prepare$lib_svga_release(@NotNull Function0<Unit> callback, @Nullable SVGAParser.PlayCallback playCallback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
        this.mPlayCallback = playCallback;
        MovieEntity movieEntity = this.movieItem;
        if (movieEntity == null) {
            if (callback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                callback = null;
            }
            callback.invoke();
            return;
        }
        Intrinsics.checkNotNull(movieEntity);
        setupAudios(movieEntity, new Function0<Unit>() { // from class: com.opensource.svgaplayer.SVGAVideoEntity$prepare$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function0;
                function0 = SVGAVideoEntity.this.mCallback;
                if (function0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                    function0 = null;
                }
                function0.invoke();
            }
        });
    }

    public final void setAntiAlias(boolean z10) {
        this.antiAlias = z10;
    }

    public final void setAudioList$lib_svga_release(@NotNull List<SVGAAudioEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.audioList = list;
    }

    public final void setImageMap$lib_svga_release(@NotNull HashMap<String, Bitmap> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.imageMap = hashMap;
    }

    public final void setMovieItem(@Nullable MovieEntity movieEntity) {
        this.movieItem = movieEntity;
    }

    public final void setSoundPool$lib_svga_release(@Nullable SoundPool soundPool) {
        this.soundPool = soundPool;
    }

    public final void setSpriteList$lib_svga_release(@NotNull List<SVGAVideoSpriteEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.spriteList = list;
    }

    public SVGAVideoEntity(@NotNull JSONObject json, @NotNull File cacheDir, int i10, int i11) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        this.TAG = "SVGAVideoEntity";
        this.antiAlias = true;
        this.videoSize = new SVGARect(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.FPS = 15;
        this.spriteList = CollectionsKt.emptyList();
        this.audioList = CollectionsKt.emptyList();
        this.imageMap = new HashMap<>();
        this.mFrameWidth = i10;
        this.mFrameHeight = i11;
        this.mCacheDir = cacheDir;
        JSONObject optJSONObject = json.optJSONObject("movie");
        if (optJSONObject == null) {
            return;
        }
        setupByJson(optJSONObject);
        try {
            parserImages(json);
        } catch (Exception e10) {
            e10.printStackTrace();
        } catch (OutOfMemoryError e11) {
            e11.printStackTrace();
        }
        resetSprites(json);
    }

    private final Bitmap createBitmap(byte[] byteArray, String filePath) {
        Bitmap decodeBitmapFrom = SVGABitmapByteArrayDecoder.INSTANCE.decodeBitmapFrom(byteArray, this.mFrameWidth, this.mFrameHeight);
        return decodeBitmapFrom == null ? createBitmap(filePath) : decodeBitmapFrom;
    }

    private final void resetSprites(MovieEntity entity) {
        List<SVGAVideoSpriteEntity> emptyList;
        List<SpriteEntity> list = entity.sprites;
        if (list != null) {
            emptyList = new ArrayList<>(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SpriteEntity spriteEntity : list) {
                Intrinsics.checkNotNull(spriteEntity);
                emptyList.add(new SVGAVideoSpriteEntity(spriteEntity));
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        this.spriteList = emptyList;
    }

    private final void parserImages(MovieEntity obj) {
        Set<Map.Entry<String, ByteString>> entrySet;
        Map<String, ByteString> map = obj.images;
        if (map == null || (entrySet = map.entrySet()) == null) {
            return;
        }
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            byte[] byteArray = ((ByteString) entry.getValue()).toByteArray();
            if (byteArray.length >= 4) {
                List<Byte> slice = ArraysKt.slice(byteArray, new IntRange(0, 3));
                if (slice.get(0).byteValue() != 73 || slice.get(1).byteValue() != 68 || slice.get(2).byteValue() != 51) {
                    String utf8 = ((ByteString) entry.getValue()).utf8();
                    Object key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                    Bitmap createBitmap = createBitmap(byteArray, generateBitmapFilePath(utf8, (String) key));
                    if (createBitmap != null) {
                        AbstractMap abstractMap = this.imageMap;
                        Object key2 = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                        abstractMap.put(key2, createBitmap);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVGAVideoEntity(@NotNull MovieEntity entity, @NotNull File cacheDir) {
        this(entity, cacheDir, 0, 0);
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
    }

    public SVGAVideoEntity(@NotNull MovieEntity entity, @NotNull File cacheDir, int i10, int i11) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        this.TAG = "SVGAVideoEntity";
        this.antiAlias = true;
        this.videoSize = new SVGARect(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.FPS = 15;
        this.spriteList = CollectionsKt.emptyList();
        this.audioList = CollectionsKt.emptyList();
        this.imageMap = new HashMap<>();
        this.mFrameWidth = i10;
        this.mFrameHeight = i11;
        this.mCacheDir = cacheDir;
        this.movieItem = entity;
        MovieParams movieParams = entity.params;
        if (movieParams != null) {
            setupByMovie(movieParams);
        }
        try {
            parserImages(entity);
        } catch (Exception e10) {
            e10.printStackTrace();
        } catch (OutOfMemoryError e11) {
            e11.printStackTrace();
        }
        resetSprites(entity);
    }
}
