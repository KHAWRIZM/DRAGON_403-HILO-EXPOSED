package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoconsumer.decoder.SpsInfo;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.e;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.a;
import com.tencent.qgame.animplayer.util.MediaUtil;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class b {
    public String a;
    public final Bundle b;
    public CustomHandler c;
    public MediaCodec d;
    public e.a e;
    public VideoEncodeParams f;
    private final com.tencent.liteav.videobase.videobase.c l;
    private ServerVideoProducerConfig y;
    private byte[] n = null;
    private boolean o = true;
    public long g = 0;
    public r h = null;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private int s = -1;
    public final Deque<Long> i = new LinkedList();
    private long t = 0;
    private long u = 0;
    private long v = 0;
    private long w = Long.MIN_VALUE;
    private boolean x = false;
    private double z = 0.0d;
    private long A = 0;
    private long B = 0;
    private long C = 0;
    private long D = 0;
    private long E = 0;
    private final Deque<Long> F = new LinkedList();
    private int G = 0;
    public final AtomicLong j = new AtomicLong(0);
    private final List<Long> H = new ArrayList();
    private final AtomicLong I = new AtomicLong(0);
    public final Runnable k = c.a(this);
    private final a.EnumC٠٠١٩a m = a.EnumC٠٠١٩a.STREAM_TYPE_BIG_VIDEO;

    public b(Bundle bundle, com.tencent.liteav.videobase.videobase.c cVar, String str) {
        this.l = cVar;
        this.b = bundle;
        this.a = str + "SurfaceInputVideoEncoder_" + hashCode();
    }

    private void e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime <= this.A + TimeUnit.SECONDS.toMillis(2L)) {
            this.B++;
            return;
        }
        this.z = (this.B * 1000.0d) / (elapsedRealtime - this.A);
        this.B = 1L;
        this.A = elapsedRealtime;
        Iterator<Long> it = this.H.iterator();
        long j = -1;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (j < longValue) {
                j = longValue;
            }
        }
        this.I.set(j);
        this.H.clear();
    }

    public final void a(ServerVideoProducerConfig serverVideoProducerConfig) {
        this.y = serverVideoProducerConfig;
        LiteavLog.i(this.a, "Set serverConfig: " + this.y);
    }

    public final void b() {
        if (this.h != null) {
            LiteavLog.i(this.a, "stopEosTimer");
            this.h.a();
            this.h = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        int i;
        ByteBuffer byteBuffer;
        int i2;
        byte[] a;
        boolean z;
        boolean z2;
        boolean z3;
        byte[] bArr;
        Long pollFirst;
        long longValue;
        long j;
        long j2;
        EncodedVideoFrame encodedVideoFrame;
        VideoEncodeParams videoEncodeParams;
        com.tencent.liteav.videobase.common.c cVar;
        ByteBuffer b;
        boolean z4;
        com.tencent.liteav.videobase.common.c cVar2;
        Long peekFirst;
        boolean z5;
        boolean z6;
        int i3 = 0;
        int i4 = 1;
        if (this.d == null) {
            return;
        }
        while (true) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            try {
                int dequeueOutputBuffer = this.d.dequeueOutputBuffer(bufferInfo, 0L);
                if (dequeueOutputBuffer == -1) {
                    break;
                }
                if (dequeueOutputBuffer == -3) {
                    LiteavLog.i(this.a, "encoder output buffers changed");
                } else if (dequeueOutputBuffer == -2) {
                    try {
                        MediaFormat outputFormat = this.d.getOutputFormat();
                        e.a aVar = this.e;
                        if (aVar != null) {
                            aVar.onOutputFormatChanged(outputFormat);
                        }
                        String str = this.a;
                        Object[] objArr = new Object[i4];
                        objArr[i3] = outputFormat;
                        LiteavLog.i(str, "encoder output format changed: %s", objArr);
                    } catch (Throwable th) {
                        a("getOutputFormat failed." + th.getMessage());
                    }
                } else {
                    if (dequeueOutputBuffer < 0) {
                        a("dequeueOutputBuffer return ".concat(String.valueOf(dequeueOutputBuffer)));
                        break;
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    this.H.add(Long.valueOf(elapsedRealtime - this.j.getAndSet(elapsedRealtime)));
                    try {
                        if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                            byteBuffer = this.d.getOutputBuffer(dequeueOutputBuffer);
                        } else {
                            byteBuffer = this.d.getOutputBuffers()[dequeueOutputBuffer];
                        }
                        if (byteBuffer != null && ((i2 = bufferInfo.size) != 0 || (bufferInfo.flags & 4) != 0)) {
                            byte[] a2 = com.tencent.liteav.videobase.utils.d.a(i2);
                            if (a2 == null) {
                                a = null;
                            } else {
                                byteBuffer.position(bufferInfo.offset);
                                byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                                byteBuffer.get(a2);
                                a = a(a2);
                                VideoEncodeParams videoEncodeParams2 = this.f;
                                if (videoEncodeParams2 != null && !videoEncodeParams2.annexb) {
                                    a = b(a);
                                }
                            }
                            if (a == null) {
                                a("modifyEncodedData return null byte array");
                            } else {
                                int i5 = bufferInfo.flags;
                                if ((i5 & 2) > 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if ((i5 & i4) > 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z && z2) {
                                    VideoEncodeParams videoEncodeParams3 = this.f;
                                    if (videoEncodeParams3 != null && videoEncodeParams3.codecType != CodecType.H264) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    if (videoEncodeParams3 != null && !videoEncodeParams3.annexb) {
                                        z6 = false;
                                    } else {
                                        z6 = true;
                                    }
                                    this.n = SpsInfo.nativeGetSpsPps(a, z5, z6);
                                } else if (z) {
                                    this.n = (byte[]) a.clone();
                                } else if (this.o && z2) {
                                    byte[] bArr2 = this.n;
                                    if (bArr2 != null) {
                                        byte[] a3 = com.tencent.liteav.videobase.utils.d.a(bArr2.length + a.length);
                                        if (a3 != null) {
                                            byte[] bArr3 = this.n;
                                            System.arraycopy(bArr3, i3, a3, i3, bArr3.length);
                                            System.arraycopy(a, i3, a3, this.n.length, a.length);
                                            a = a3;
                                        } else {
                                            a("add spspps for I frame, allocate buffer failed.");
                                        }
                                    } else {
                                        a("mSpsPps is null.");
                                    }
                                }
                                if ((bufferInfo.flags & i4) > 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    this.s = -1;
                                }
                                VideoEncodeParams videoEncodeParams4 = this.f;
                                if (videoEncodeParams4 != null && !videoEncodeParams4.fullIFrame) {
                                    int i6 = this.s + i4;
                                    this.s = i6;
                                    if (i6 == videoEncodeParams4.fps * videoEncodeParams4.gop) {
                                        d();
                                    }
                                }
                                long length = a.length;
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (z3) {
                                    if (elapsedRealtime2 > this.D + 1000) {
                                        bArr = a;
                                        this.C = (long) (((this.E * 8000.0d) / (elapsedRealtime2 - r2)) / 1024.0d);
                                        this.E = 0L;
                                        this.D = elapsedRealtime2;
                                        if (!this.F.isEmpty()) {
                                            int i7 = this.f.fps;
                                            if (((float) (i7 - this.z)) <= Math.max(i7 / 2.0f, 5.0f) && (peekFirst = this.F.peekFirst()) != null && SystemClock.elapsedRealtime() > peekFirst.longValue()) {
                                                this.F.removeFirst();
                                                if (this.G - this.C > Math.max(this.f.bitrate / 2, 100)) {
                                                    LiteavLog.w(this.a, "restart hardware encoder because real bitrate is too low.expectBitrate: " + this.G + ", realBitrate=" + this.C);
                                                    this.b.putBoolean("need_restart_when_down_bitrate", true);
                                                    this.k.run();
                                                    this.F.clear();
                                                }
                                            }
                                        }
                                        this.E += length;
                                        e();
                                        if (!z3) {
                                            this.q++;
                                            this.r = 0L;
                                        } else {
                                            this.r++;
                                        }
                                        this.p++;
                                        pollFirst = this.i.pollFirst();
                                        if (pollFirst != null) {
                                            longValue = 0;
                                        } else {
                                            longValue = pollFirst.longValue();
                                        }
                                        long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
                                        if (this.t == 0) {
                                            this.t = longValue;
                                        }
                                        if (this.u == 0) {
                                            this.u = millis;
                                        }
                                        j = millis + (this.t - this.u);
                                        j2 = this.v;
                                        if (longValue <= j2) {
                                            longValue = j2 + 1;
                                        }
                                        if (longValue > j) {
                                            longValue = j;
                                        }
                                        this.v = longValue;
                                        encodedVideoFrame = new EncodedVideoFrame();
                                        videoEncodeParams = this.f;
                                        if (videoEncodeParams == null && videoEncodeParams.isEnablesUnlimitedGop()) {
                                            if (z3) {
                                                cVar2 = com.tencent.liteav.videobase.common.c.IDR;
                                            } else {
                                                cVar2 = com.tencent.liteav.videobase.common.c.P_MULTI_REF;
                                            }
                                            encodedVideoFrame.nalType = cVar2;
                                        } else {
                                            if (!z3) {
                                                cVar = com.tencent.liteav.videobase.common.c.IDR;
                                            } else {
                                                cVar = com.tencent.liteav.videobase.common.c.P;
                                            }
                                            encodedVideoFrame.nalType = cVar;
                                        }
                                        byte[] bArr4 = bArr;
                                        b = com.tencent.liteav.videobase.utils.d.b(bArr4.length);
                                        encodedVideoFrame.data = b;
                                        if (b != null) {
                                            a("allocate direct buffer for nal failed");
                                        } else {
                                            b.put(bArr4);
                                            encodedVideoFrame.data.rewind();
                                            encodedVideoFrame.dts = longValue;
                                            encodedVideoFrame.pts = j;
                                            encodedVideoFrame.info = bufferInfo;
                                            encodedVideoFrame.gopIndex = this.q;
                                            long j3 = this.r;
                                            encodedVideoFrame.frameIndex = j3;
                                            encodedVideoFrame.gopFrameIndex = j3;
                                            if (!z3) {
                                                j3--;
                                            }
                                            encodedVideoFrame.refFrameIndex = j3;
                                            encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.d.BASELINE;
                                            VideoEncodeParams videoEncodeParams5 = this.f;
                                            encodedVideoFrame.codecType = videoEncodeParams5.codecType;
                                            encodedVideoFrame.width = videoEncodeParams5.width;
                                            encodedVideoFrame.height = videoEncodeParams5.height;
                                            if ((bufferInfo.flags & 4) > 0) {
                                                b();
                                                z4 = true;
                                            } else {
                                                boolean z7 = videoEncodeParams5.enableBFrame;
                                                if (!z7 && !this.x && j < this.w) {
                                                    LiteavLog.i(this.a, "has B frame,isEnablesBframe=%b,mLastPresentationTimestamp=%d,packet.pts=%d", Boolean.valueOf(z7), Long.valueOf(this.w), Long.valueOf(encodedVideoFrame.pts));
                                                    this.x = true;
                                                    PersistStorage persistStorage = new PersistStorage(PersistStorage.GLOBAL_DOMAIN);
                                                    persistStorage.put("Liteav.Video.android.local.rtc.enable.high.profile", 0);
                                                    persistStorage.commit();
                                                    e.a aVar2 = this.e;
                                                    if (aVar2 != null) {
                                                        aVar2.a();
                                                    }
                                                }
                                                this.w = encodedVideoFrame.pts;
                                                z4 = false;
                                            }
                                            e.a aVar3 = this.e;
                                            if (aVar3 != null) {
                                                aVar3.onEncodedNAL(encodedVideoFrame, z4);
                                            }
                                        }
                                    }
                                }
                                bArr = a;
                                this.E += length;
                                e();
                                if (!z3) {
                                }
                                this.p++;
                                pollFirst = this.i.pollFirst();
                                if (pollFirst != null) {
                                }
                                long millis2 = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
                                if (this.t == 0) {
                                }
                                if (this.u == 0) {
                                }
                                j = millis2 + (this.t - this.u);
                                j2 = this.v;
                                if (longValue <= j2) {
                                }
                                if (longValue > j) {
                                }
                                this.v = longValue;
                                encodedVideoFrame = new EncodedVideoFrame();
                                videoEncodeParams = this.f;
                                if (videoEncodeParams == null) {
                                }
                                if (!z3) {
                                }
                                encodedVideoFrame.nalType = cVar;
                                byte[] bArr42 = bArr;
                                b = com.tencent.liteav.videobase.utils.d.b(bArr42.length);
                                encodedVideoFrame.data = b;
                                if (b != null) {
                                }
                            }
                        } else {
                            a("size is zero, but it isn't end of stream");
                        }
                        MediaCodec mediaCodec = this.d;
                        if (mediaCodec == null) {
                            return;
                        }
                        try {
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            i3 = 0;
                            i4 = 1;
                        } catch (Throwable th2) {
                            a("releaseOutputBuffer failed." + th2.getMessage());
                        }
                    } catch (Throwable th3) {
                        a("getOutputBuffer failed." + th3.getMessage());
                    }
                }
            } catch (Throwable th4) {
                a("dequeueOutputBuffer failed." + th4.getMessage());
            }
        }
        if (!this.i.isEmpty()) {
            int i8 = this.f.fps;
            if (i8 != 0) {
                i = 500 / i8;
            } else {
                i = 10;
            }
            if (!this.c.hasMessages(10)) {
                this.c.sendEmptyMessageDelayed(10, i);
            }
        }
    }

    public final void d() {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 19 && this.d != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.d.setParameters(bundle);
            } catch (Throwable th) {
                LiteavLog.e(this.a, "requestSyncFrame failed.", th);
            }
        }
    }

    public final void a(int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 1; i2 <= 3; i2++) {
            this.F.addLast(Long.valueOf((i2 * HonorResultCode.ADVANCED_RECORD_SUCCESS) + elapsedRealtime));
        }
        this.G = i;
    }

    private static byte[] b(byte[] bArr) {
        int length = bArr.length;
        ArrayList<int[]> arrayList = new ArrayList(20);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i > length) {
                break;
            }
            int i5 = i + 2;
            if (i5 < length && bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i5] == 1) {
                i4 = 3;
            } else {
                int i6 = i + 3;
                if (i6 < length && bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i5] == 0 && bArr[i6] == 1) {
                    i4 = 4;
                }
            }
            if (i4 == 3 || i4 == 4 || i == length) {
                if (i3 != i) {
                    arrayList.add(new int[]{i3, i});
                    i2 += i - i3;
                }
                i3 = i + i4;
            }
            i += i4;
        }
        byte[] a = com.tencent.liteav.videobase.utils.d.a(i2 + (arrayList.size() * 4));
        if (a == null) {
            return bArr;
        }
        int i7 = 0;
        for (int[] iArr : arrayList) {
            int i8 = iArr[1] - iArr[0];
            ByteBuffer order = ByteBuffer.wrap(new byte[4]).order(ByteOrder.BIG_ENDIAN);
            order.putInt(i8);
            System.arraycopy(order.array(), 0, a, i7, 4);
            int i9 = i7 + 4;
            System.arraycopy(bArr, iArr[0], a, i9, i8);
            i7 = i9 + i8;
        }
        return a;
    }

    public final void a(MediaCodec mediaCodec, int i) {
        if (mediaCodec == null || LiteavSystemInfo.getSystemOSVersionInt() < 19) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", i * LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY);
            mediaCodec.setParameters(bundle);
        } catch (Throwable th) {
            LiteavLog.e(this.a, "updateBitrateToMediaCodec failed.", th);
        }
    }

    private void a(String str) {
        LiteavLog.e(this.a, "notifyEncodeError message = ".concat(String.valueOf(str)));
        e.a aVar = this.e;
        if (aVar != null) {
            aVar.onEncodedFail(e.a.ERR_VIDEO_ENCODE_FAIL);
        }
    }

    public final void a() {
        this.c.removeMessages(10);
        a(this.d);
        this.d = null;
    }

    private MediaCodec b(String str) throws Throwable {
        String str2;
        MediaCodec createEncoderByType = MediaCodec.createEncoderByType(str);
        try {
            str2 = createEncoderByType.getName();
        } catch (Throwable th) {
            LiteavLog.e(this.a, "mediaCodec getName failed.", th);
            str2 = null;
        }
        LiteavLog.i(this.a, "codecName=".concat(String.valueOf(str2)));
        if (str2 == null || !str2.equals("OMX.google.h264.encoder")) {
            return createEncoderByType;
        }
        LiteavLog.w(this.a, "will be destroyed codecName=".concat(str2));
        a(createEncoderByType);
        throw new IOException("this is a Google H264 soft encoder. cancel use MediaCodec.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0128, code lost:
    
        r5 = r2.getInteger("bitrate-mode", -1);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4 A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #2 {all -> 0x00cc, blocks: (B:20:0x00a3, B:22:0x00bd, B:26:0x00d4, B:70:0x0164, B:71:0x016b), top: B:19:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0164 A[Catch: all -> 0x00cc, TRY_ENTER, TryCatch #2 {all -> 0x00cc, blocks: (B:20:0x00a3, B:22:0x00bd, B:26:0x00d4, B:70:0x0164, B:71:0x016b), top: B:19:0x00a3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Surface a(VideoEncodeParams videoEncodeParams) {
        String str;
        ServerVideoProducerConfig serverVideoProducerConfig;
        MediaCodec mediaCodec;
        Surface surface;
        int errorCode;
        MediaFormat mediaFormat;
        boolean z;
        int integer;
        this.g = SystemClock.elapsedRealtime();
        this.w = Long.MIN_VALUE;
        if (videoEncodeParams.bitrate == 0) {
            int i = videoEncodeParams.width;
            int i2 = videoEncodeParams.height;
            videoEncodeParams.bitrate = (int) (Math.sqrt((i * i) + (i2 * i2)) * 1.2d);
        }
        VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
        this.f = videoEncodeParams2;
        this.p = videoEncodeParams2.baseFrameIndex;
        this.q = videoEncodeParams2.baseGopIndex;
        this.r = 0L;
        if (videoEncodeParams2.codecType == CodecType.H265) {
            str = MediaUtil.MIME_HEVC;
        } else {
            str = "video/avc";
        }
        VideoEncoderDef.EncoderProfile encoderProfile = videoEncodeParams2.encoderProfile;
        VideoEncoderDef.EncoderProfile encoderProfile2 = VideoEncoderDef.EncoderProfile.PROFILE_MAIN;
        if (encoderProfile == encoderProfile2) {
            videoEncodeParams2.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        }
        VideoEncoderDef.EncoderProfile encoderProfile3 = videoEncodeParams2.encoderProfile;
        VideoEncoderDef.EncoderProfile encoderProfile4 = VideoEncoderDef.EncoderProfile.PROFILE_HIGH;
        if ((encoderProfile3 == encoderProfile4 || encoderProfile3 == encoderProfile2) && (serverVideoProducerConfig = this.y) != null && !serverVideoProducerConfig.isHardwareEncoderHighProfileAllowed()) {
            this.f.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
        }
        VideoEncodeParams videoEncodeParams3 = this.f;
        VideoEncoderDef.EncoderProfile encoderProfile5 = videoEncodeParams3.encoderProfile;
        if ((encoderProfile5 == encoderProfile4 || encoderProfile5 == encoderProfile2) && !videoEncodeParams3.enableBFrame) {
            Integer num = new PersistStorage(PersistStorage.GLOBAL_DOMAIN).getInt("Liteav.Video.android.local.rtc.enable.high.profile");
            LiteavLog.i(this.a, "enable high profile from persist storage:".concat(String.valueOf(num)));
            if (num != null && num.intValue() == 0) {
                this.f.encoderProfile = VideoEncoderDef.EncoderProfile.PROFILE_BASELINE;
            }
        }
        try {
            mediaCodec = b(str);
            try {
                a aVar = new a(mediaCodec, str, this.f, this.y.isHardwareEncoderBitrateModeCBRSupported());
                aVar.a = true;
                MediaFormat a = aVar.a();
                if (!a(mediaCodec, a)) {
                    z = false;
                    aVar.b = false;
                    mediaFormat = aVar.a();
                    if (a(mediaCodec, mediaFormat)) {
                        a = mediaFormat;
                    }
                    if (!z) {
                        surface = mediaCodec.createInputSurface();
                        try {
                            mediaCodec.start();
                            try {
                                this.f.width = mediaFormat.getInteger("width");
                                this.f.height = mediaFormat.getInteger("height");
                                this.f.bitrate = mediaFormat.getInteger("bitrate") / LockFreeTaskQueueCore.MIN_ADD_SPIN_CAPACITY;
                                int i3 = this.f.bitrate;
                                if (LiteavSystemInfo.getSystemOSVersionInt() > 30) {
                                    LiteavLog.i(this.a, "resetBitrateAfterApiLevel30,bitrate=".concat(String.valueOf(i3)));
                                    a(mediaCodec, i3);
                                }
                                if (this.e != null) {
                                    VideoEncoderDef.BitrateMode bitrateMode = VideoEncoderDef.BitrateMode.UNKNOWN;
                                    if (LiteavSystemInfo.getSystemOSVersionInt() >= 21 && integer != -1) {
                                        if (integer == 0) {
                                            bitrateMode = VideoEncoderDef.BitrateMode.CQ;
                                        } else if (integer == 1) {
                                            bitrateMode = VideoEncoderDef.BitrateMode.VBR;
                                        } else if (integer == 2) {
                                            bitrateMode = VideoEncoderDef.BitrateMode.CBR;
                                        }
                                    }
                                    this.e.onBitrateModeUpdated(bitrateMode);
                                }
                            } catch (Throwable th) {
                                LiteavLog.e(this.a, "MediaFormat get key fail", th);
                            }
                            LiteavLog.i(this.a, "start MediaCodec with format: ".concat(String.valueOf(mediaFormat)));
                            this.d = mediaCodec;
                            return surface;
                        } catch (Throwable th2) {
                            th = th2;
                            if (surface != null) {
                                surface.release();
                            }
                            a(mediaCodec);
                            e.c cVar = e.c.WARNING_VIDEO_ENCODE_START_FAILED;
                            String str2 = "Start encoder failed:" + th.getMessage();
                            if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && (th instanceof MediaCodec.CodecException)) {
                                errorCode = th.getErrorCode();
                                if (errorCode == 1100) {
                                    cVar = e.c.WARNING_VIDEO_ENCODE_START_FAILED_INSUFFICIENT_RESOURCE;
                                    str2 = "Insufficient resource, Start encoder failed:" + th.getMessage();
                                }
                            }
                            this.l.updateStatus(com.tencent.liteav.videobase.videobase.f.STATUS_VIDEO_HW_ENCODE_START_ERROR_TYPE, this.m.mValue, Integer.valueOf(cVar.mValue));
                            this.l.notifyWarning(cVar, str2);
                            LiteavLog.e(this.a, "Start MediaCodec failed,encode params:" + this.f, th);
                            return null;
                        }
                    }
                    throw new IOException("configure encoder failed.");
                }
                mediaFormat = a;
                z = true;
                if (!z) {
                }
            } catch (Throwable th3) {
                th = th3;
                surface = null;
            }
        } catch (Throwable th4) {
            th = th4;
            mediaCodec = null;
            surface = null;
        }
    }

    private boolean a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return false;
        }
        try {
            LiteavLog.i(this.a, "configure format: %s", mediaFormat);
            mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            return true;
        } catch (Throwable th) {
            LiteavLog.e(this.a, "configure failed.", th);
            return false;
        }
    }

    private static byte[] a(byte[] bArr) {
        byte[] a;
        if (bArr.length > 5 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0) {
            int i = 0;
            while (true) {
                int i2 = i + 3;
                if (i2 >= bArr.length) {
                    i = 0;
                    break;
                }
                byte b = bArr[i];
                if ((b == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i2] == 1) || (b == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 1)) {
                    break;
                }
                i++;
            }
            if (i == 0 || (a = com.tencent.liteav.videobase.utils.d.a(bArr.length - i)) == null) {
                return bArr;
            }
            System.arraycopy(bArr, i, a, 0, a.length);
            return a;
        }
        return bArr;
    }

    private void a(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.stop();
        } catch (Throwable th) {
            LiteavLog.e(this.a, "destroy mediaCodec stop failed.", th);
        }
        try {
            mediaCodec.release();
        } catch (Throwable th2) {
            LiteavLog.e(this.a, "destroy mediaCodec release failed.", th2);
        }
        LiteavLog.i(this.a, "destroy mediaCodec");
    }
}
