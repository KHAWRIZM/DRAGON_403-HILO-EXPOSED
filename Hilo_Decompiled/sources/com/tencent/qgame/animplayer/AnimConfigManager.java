package com.tencent.qgame.animplayer;

import android.os.SystemClock;
import com.tencent.qgame.animplayer.file.IFileContainer;
import com.tencent.qgame.animplayer.util.ALog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.CharEncoding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002\"#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J&\u0010 \u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/tencent/qgame/animplayer/AnimConfigManager;", "", "player", "Lcom/tencent/qgame/animplayer/AnimPlayer;", "(Lcom/tencent/qgame/animplayer/AnimPlayer;)V", "config", "Lcom/tencent/qgame/animplayer/AnimConfig;", "getConfig", "()Lcom/tencent/qgame/animplayer/AnimConfig;", "setConfig", "(Lcom/tencent/qgame/animplayer/AnimConfig;)V", "isParsingConfig", "", "()Z", "setParsingConfig", "(Z)V", "getPlayer", "()Lcom/tencent/qgame/animplayer/AnimPlayer;", "defaultConfig", "", "_videoWidth", "", "_videoHeight", "parse", "fileContainer", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "defaultVideoMode", "defaultFps", "parseBoxHead", "Lcom/tencent/qgame/animplayer/AnimConfigManager$BoxHead;", "boxHead", "", "parseConfig", "enableVersion1", "BoxHead", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AnimConfigManager {
    private static final String TAG = "AnimPlayer.AnimConfigManager";

    @Nullable
    private AnimConfig config;
    private boolean isParsingConfig;

    @NotNull
    private final AnimPlayer player;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/tencent/qgame/animplayer/AnimConfigManager$BoxHead;", "", "()V", "length", "", "getLength", "()I", "setLength", "(I)V", "startIndex", "", "getStartIndex", "()J", "setStartIndex", "(J)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "animplayer_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class BoxHead {
        private int length;
        private long startIndex;

        @Nullable
        private String type;

        public final int getLength() {
            return this.length;
        }

        public final long getStartIndex() {
            return this.startIndex;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        public final void setLength(int i) {
            this.length = i;
        }

        public final void setStartIndex(long j) {
            this.startIndex = j;
        }

        public final void setType(@Nullable String str) {
            this.type = str;
        }
    }

    public AnimConfigManager(@NotNull AnimPlayer animPlayer) {
        this.player = animPlayer;
    }

    private final boolean parse(IFileContainer fileContainer, int defaultVideoMode, int defaultFps) {
        BoxHead boxHead;
        AnimConfig animConfig = new AnimConfig();
        this.config = animConfig;
        fileContainer.startRandomRead();
        byte[] bArr = new byte[8];
        long j = 0;
        while (fileContainer.read(bArr, 0, 8) == 8 && (boxHead = parseBoxHead(bArr)) != null) {
            if (Intrinsics.areEqual("vapc", boxHead.getType())) {
                boxHead.setStartIndex(j);
                break;
            }
            j += boxHead.getLength();
            fileContainer.skip(boxHead.getLength() - 8);
        }
        boxHead = null;
        if (boxHead == null) {
            ALog.INSTANCE.e(TAG, "vapc box head not found");
            animConfig.setDefaultConfig(true);
            animConfig.setDefaultVideoMode(defaultVideoMode);
            animConfig.setFps(defaultFps);
            this.player.setFps(animConfig.getFps());
            return true;
        }
        int length = boxHead.getLength() - 8;
        byte[] bArr2 = new byte[length];
        fileContainer.read(bArr2, 0, length);
        fileContainer.closeRandomRead();
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(\"UTF-8\")");
        JSONObject jSONObject = new JSONObject(new String(bArr2, 0, length, forName));
        animConfig.setJsonConfig(jSONObject);
        boolean parse = animConfig.parse(jSONObject);
        if (defaultFps > 0) {
            animConfig.setFps(defaultFps);
        }
        this.player.setFps(animConfig.getFps());
        return parse;
    }

    private final BoxHead parseBoxHead(byte[] boxHead) {
        if (boxHead.length != 8) {
            return null;
        }
        BoxHead boxHead2 = new BoxHead();
        boxHead2.setLength(((boxHead[2] & 255) << 8) | ((boxHead[0] & 255) << 24) | ((boxHead[1] & 255) << 16) | (boxHead[3] & 255));
        Charset forName = Charset.forName(CharEncoding.US_ASCII);
        Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(\"US-ASCII\")");
        boxHead2.setType(new String(boxHead, 4, 4, forName));
        return boxHead2;
    }

    public final void defaultConfig(int _videoWidth, int _videoHeight) {
        AnimConfig animConfig;
        AnimConfig animConfig2 = this.config;
        if ((animConfig2 == null || animConfig2.getIsDefaultConfig()) && (animConfig = this.config) != null) {
            animConfig.setVideoWidth(_videoWidth);
            animConfig.setVideoHeight(_videoHeight);
            int defaultVideoMode = animConfig.getDefaultVideoMode();
            if (defaultVideoMode != 1) {
                if (defaultVideoMode != 2) {
                    if (defaultVideoMode != 3) {
                        if (defaultVideoMode != 4) {
                            animConfig.setWidth(_videoWidth / 2);
                            animConfig.setHeight(_videoHeight);
                            animConfig.setAlphaPointRect(new PointRect(0, 0, animConfig.getWidth(), animConfig.getHeight()));
                            animConfig.setRgbPointRect(new PointRect(animConfig.getWidth(), 0, animConfig.getWidth(), animConfig.getHeight()));
                            return;
                        }
                        animConfig.setWidth(_videoWidth);
                        animConfig.setHeight(_videoHeight / 2);
                        animConfig.setRgbPointRect(new PointRect(0, 0, animConfig.getWidth(), animConfig.getHeight()));
                        animConfig.setAlphaPointRect(new PointRect(0, animConfig.getHeight(), animConfig.getWidth(), animConfig.getHeight()));
                        return;
                    }
                    animConfig.setWidth(_videoWidth / 2);
                    animConfig.setHeight(_videoHeight);
                    animConfig.setRgbPointRect(new PointRect(0, 0, animConfig.getWidth(), animConfig.getHeight()));
                    animConfig.setAlphaPointRect(new PointRect(animConfig.getWidth(), 0, animConfig.getWidth(), animConfig.getHeight()));
                    return;
                }
                animConfig.setWidth(_videoWidth);
                animConfig.setHeight(_videoHeight / 2);
                animConfig.setAlphaPointRect(new PointRect(0, 0, animConfig.getWidth(), animConfig.getHeight()));
                animConfig.setRgbPointRect(new PointRect(0, animConfig.getHeight(), animConfig.getWidth(), animConfig.getHeight()));
                return;
            }
            animConfig.setWidth(_videoWidth / 2);
            animConfig.setHeight(_videoHeight);
            animConfig.setAlphaPointRect(new PointRect(0, 0, animConfig.getWidth(), animConfig.getHeight()));
            animConfig.setRgbPointRect(new PointRect(animConfig.getWidth(), 0, animConfig.getWidth(), animConfig.getHeight()));
        }
    }

    @Nullable
    public final AnimConfig getConfig() {
        return this.config;
    }

    @NotNull
    public final AnimPlayer getPlayer() {
        return this.player;
    }

    /* renamed from: isParsingConfig, reason: from getter */
    public final boolean getIsParsingConfig() {
        return this.isParsingConfig;
    }

    public final int parseConfig(@NotNull IFileContainer fileContainer, boolean enableVersion1, int defaultVideoMode, int defaultFps) {
        int i;
        try {
            this.isParsingConfig = true;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            boolean parse = parse(fileContainer, defaultVideoMode, defaultFps);
            ALog.INSTANCE.i(TAG, "parseConfig cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms enableVersion1=" + enableVersion1 + " result=" + parse);
            if (!parse) {
                this.isParsingConfig = false;
                return 10005;
            }
            AnimConfig animConfig = this.config;
            if (animConfig != null && animConfig.getIsDefaultConfig() && !enableVersion1) {
                this.isParsingConfig = false;
                return 10005;
            }
            AnimConfig animConfig2 = this.config;
            if (animConfig2 != null) {
                i = this.player.getPluginManager().onConfigCreate(animConfig2);
            } else {
                i = 0;
            }
            this.isParsingConfig = false;
            return i;
        } catch (Throwable th) {
            ALog.INSTANCE.e(TAG, "parseConfig error " + th, th);
            this.isParsingConfig = false;
            return 10005;
        }
    }

    public final void setConfig(@Nullable AnimConfig animConfig) {
        this.config = animConfig;
    }

    public final void setParsingConfig(boolean z) {
        this.isParsingConfig = z;
    }
}
