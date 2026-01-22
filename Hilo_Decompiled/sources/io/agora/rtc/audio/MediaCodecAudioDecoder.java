package io.agora.rtc.audio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import android.webkit.URLUtil;
import io.agora.rtc.internal.Logging;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class MediaCodecAudioDecoder {
    private static final int EXTRACTOR_TIMEOUT_MS = 60000;
    private static final int HTTP_REQUEST_TIMEOUT = 4000;
    private static final int MAX_DECODER_RETRY_COUNT = 300;
    private static final String PREFIX_ASSETS = "/assets/";
    private static final String PREFIX_DOCUMENT = "content://";
    private static final String TAG = "MediaCodec Audio Decoder";
    private ByteBuffer mDecodedRAWBuffer;
    private long mFileLength;
    private ByteBuffer[] mInputBuffers;
    private ByteBuffer[] mOutputBuffers;
    private Context mContext = null;
    private MediaCodec mMediaCodec = null;
    private MediaExtractorWrapper mExtractor = null;
    private MediaFormat mTrackFormat = null;
    private boolean mDecodedDataReady = false;
    private boolean eoInputStream = false;
    private boolean eoOutputStream = false;
    private int mSampleRate = 44100;
    private int mChannels = 2;
    private int mRetryCount = 0;
    private MediaCodec mAACDecoder = null;
    private ByteBuffer mAACOutputBuffer = ByteBuffer.allocateDirect(4096);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class MediaExtractorWrapper {
        private final CountDownLatch countDownLatch;
        private final Handler mHandler;
        private final MediaExtractor mMediaExtractor;
        private volatile boolean mPrepared;
        private final String threadName;

        MediaExtractorWrapper() {
            String str = "MediaExtractor-" + new Random().nextInt();
            this.threadName = str;
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper());
            this.mMediaExtractor = new MediaExtractor();
            this.countDownLatch = new CountDownLatch(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean setDataSource(final String str) throws InterruptedException {
            Logging.d(MediaCodecAudioDecoder.TAG, "setDataSource()");
            final boolean startsWith = str.startsWith(MediaCodecAudioDecoder.PREFIX_ASSETS);
            final boolean startsWith2 = str.startsWith(MediaCodecAudioDecoder.PREFIX_DOCUMENT);
            this.mHandler.post(new Runnable() { // from class: io.agora.rtc.audio.MediaCodecAudioDecoder.MediaExtractorWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    Logging.d(MediaCodecAudioDecoder.TAG, "setDataSource in thread " + MediaExtractorWrapper.this.threadName);
                    try {
                        if (startsWith && MediaCodecAudioDecoder.this.mContext != null) {
                            AssetFileDescriptor openFd = MediaCodecAudioDecoder.this.mContext.getAssets().openFd(str.substring(8));
                            MediaExtractorWrapper.this.mMediaExtractor.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        } else if (startsWith2 && MediaCodecAudioDecoder.this.mContext != null) {
                            MediaExtractorWrapper.this.mMediaExtractor.setDataSource(MediaCodecAudioDecoder.this.mContext.getContentResolver().openFileDescriptor(Uri.parse(str), "r").getFileDescriptor());
                        } else {
                            MediaExtractorWrapper.this.mMediaExtractor.setDataSource(str);
                        }
                        MediaExtractorWrapper.this.mPrepared = true;
                    } catch (Exception e10) {
                        Logging.w(MediaCodecAudioDecoder.TAG, "setDataSource fail");
                        e10.printStackTrace();
                    }
                    MediaExtractorWrapper.this.countDownLatch.countDown();
                }
            });
            this.countDownLatch.await(60000L, TimeUnit.MILLISECONDS);
            return this.mPrepared;
        }

        void advance() {
            checkPrepared();
            this.mMediaExtractor.advance();
        }

        void checkPrepared() {
            if (this.mPrepared) {
            } else {
                throw new IllegalStateException("mMediaExtractor hasn't prepared");
            }
        }

        int getSampleFlags() {
            checkPrepared();
            return this.mMediaExtractor.getSampleFlags();
        }

        long getSampleTime() {
            checkPrepared();
            return this.mMediaExtractor.getSampleTime();
        }

        int getTrackCount() {
            checkPrepared();
            return this.mMediaExtractor.getTrackCount();
        }

        MediaFormat getTrackFormat(int i10) {
            checkPrepared();
            return this.mMediaExtractor.getTrackFormat(i10);
        }

        int readSampleData(ByteBuffer byteBuffer, int i10) {
            checkPrepared();
            return this.mMediaExtractor.readSampleData(byteBuffer, i10);
        }

        void release() {
            Logging.d(MediaCodecAudioDecoder.TAG, "release()");
            this.mHandler.post(new Runnable() { // from class: io.agora.rtc.audio.MediaCodecAudioDecoder.MediaExtractorWrapper.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MediaExtractorWrapper.this.mMediaExtractor != null) {
                        try {
                            MediaExtractorWrapper.this.mMediaExtractor.release();
                        } catch (AssertionError e10) {
                            Logging.e(MediaCodecAudioDecoder.TAG, " mMediaExtractor release exception: " + e10.getMessage());
                        }
                    }
                    MediaExtractorWrapper.this.mHandler.getLooper().quit();
                    Logging.d(MediaCodecAudioDecoder.TAG, "mediaExtractor released in thread " + MediaExtractorWrapper.this.threadName);
                }
            });
        }

        void seekTo(long j10, int i10) {
            checkPrepared();
            this.mMediaExtractor.seekTo(j10, i10);
        }

        void selectTrack(int i10) {
            checkPrepared();
            this.mMediaExtractor.selectTrack(i10);
        }

        void unselectTrack(int i10) {
            checkPrepared();
            this.mMediaExtractor.unselectTrack(i10);
        }
    }

    private boolean checkInfoChange() {
        boolean z10;
        try {
            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            int integer = outputFormat.getInteger("sample-rate");
            if (integer == 22050) {
                integer = 22000;
            } else if (integer == 11025) {
                integer = 11000;
            }
            int integer2 = outputFormat.getInteger("channel-count");
            if (this.mSampleRate == integer && this.mChannels == integer2) {
                z10 = false;
                this.mSampleRate = integer;
                this.mChannels = integer2;
                return z10;
            }
            z10 = true;
            this.mSampleRate = integer;
            this.mChannels = integer2;
            return z10;
        } catch (Exception e10) {
            Logging.e(TAG, "Error when checking file's new format");
            e10.printStackTrace();
            return false;
        }
    }

    private void cloneByteBuffer(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBuffer2 = this.mDecodedRAWBuffer;
            if (byteBuffer2 != null) {
                if (byteBuffer2.limit() != byteBuffer.limit()) {
                }
                this.mDecodedRAWBuffer.position(0);
                this.mDecodedRAWBuffer.put(byteBuffer);
            }
            ByteBuffer byteBuffer3 = this.mDecodedRAWBuffer;
            if (byteBuffer3 != null) {
                byteBuffer3.clear();
                this.mDecodedRAWBuffer = null;
            }
            this.mDecodedRAWBuffer = ByteBuffer.allocateDirect(byteBuffer.limit());
            this.mDecodedRAWBuffer.position(0);
            this.mDecodedRAWBuffer.put(byteBuffer);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void cloneByteBufferByLength(ByteBuffer byteBuffer, int i10) {
        try {
            ByteBuffer byteBuffer2 = this.mDecodedRAWBuffer;
            if (byteBuffer2 != null) {
                if (byteBuffer2.capacity() < i10) {
                }
                this.mDecodedRAWBuffer.position(0);
                byteBuffer.limit(i10);
                this.mDecodedRAWBuffer.put(byteBuffer);
            }
            ByteBuffer byteBuffer3 = this.mDecodedRAWBuffer;
            if (byteBuffer3 != null) {
                byteBuffer3.clear();
                this.mDecodedRAWBuffer = null;
            }
            this.mDecodedRAWBuffer = ByteBuffer.allocateDirect(i10);
            this.mDecodedRAWBuffer.position(0);
            byteBuffer.limit(i10);
            this.mDecodedRAWBuffer.put(byteBuffer);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    protected static String encodeUrl(String str) {
        Logging.d(TAG, "encodedUrl()");
        try {
            URL url = new URL(str);
            return new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static boolean testNetworkUrlAvailable(String str) {
        Exception e10;
        HttpURLConnection httpURLConnection;
        boolean z10;
        Logging.d(TAG, "testNetworkUrlAvailable encodedUrl");
        ?? r12 = 0;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(4000);
                    httpURLConnection.setReadTimeout(4000);
                    httpURLConnection.getResponseCode();
                    if (httpURLConnection.getResponseCode() != 404) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpURLConnection.disconnect();
                    return z10;
                } catch (Exception e11) {
                    e10 = e11;
                    e10.printStackTrace();
                    if (httpURLConnection == null) {
                        return false;
                    }
                    httpURLConnection.disconnect();
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                r12 = str;
                if (r12 != 0) {
                    r12.disconnect();
                }
                throw th;
            }
        } catch (Exception e12) {
            e10 = e12;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (r12 != 0) {
            }
            throw th;
        }
    }

    public boolean checkAACSupported() {
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (!mediaCodecInfo.isEncoder() && mediaCodecInfo.getName().toLowerCase().contains("nvidia")) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            Logging.e(TAG, "Error when checking aac codec availability");
            e10.printStackTrace();
            return false;
        }
    }

    protected boolean checkUrlEncoded(String str) {
        try {
            return !TextUtils.equals(str, URLDecoder.decode(str, "UTF-8"));
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public boolean createAACStreaming(int i10) {
        try {
            this.mAACDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i10, 1);
            createAudioFormat.setInteger("sample-rate", i10);
            createAudioFormat.setInteger("channel-count", 1);
            createAudioFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[]{18, -120}));
            this.mAACDecoder.configure(createAudioFormat, (Surface) null, (MediaCrypto) null, 0);
            MediaCodec mediaCodec = this.mAACDecoder;
            if (mediaCodec != null) {
                mediaCodec.start();
            }
            return true;
        } catch (Exception e10) {
            Logging.e(TAG, "Error when creating aac decode stream");
            e10.printStackTrace();
            return false;
        }
    }

    public boolean createStreaming(String str) {
        try {
            Logging.i(TAG, "Try to decode audio file : " + str);
            this.mRetryCount = 0;
            if (TextUtils.isEmpty(str)) {
                Logging.w(TAG, "Fail to open, empty url");
                return false;
            }
            if (URLUtil.isNetworkUrl(str)) {
                String encodeUrl = checkUrlEncoded(str) ? str : encodeUrl(str);
                if (encodeUrl == null || !testNetworkUrlAvailable(encodeUrl)) {
                    Logging.w(TAG, "Fail to open, 404 for url");
                    return false;
                }
            }
            MediaExtractorWrapper mediaExtractorWrapper = new MediaExtractorWrapper();
            this.mExtractor = mediaExtractorWrapper;
            if (!mediaExtractorWrapper.setDataSource(str)) {
                Logging.w(TAG, "Failed to setDataSource");
                releaseStreaming();
                return false;
            }
            int trackCount = this.mExtractor.getTrackCount();
            Logging.i(TAG, "createStreaming getAudioTrack Tracknum:" + trackCount);
            for (int i10 = 0; i10 < trackCount; i10++) {
                this.mExtractor.unselectTrack(i10);
            }
            int i11 = 0;
            while (true) {
                if (i11 >= trackCount) {
                    break;
                }
                MediaFormat trackFormat = this.mExtractor.getTrackFormat(i11);
                this.mTrackFormat = trackFormat;
                String string = trackFormat.getString("mime");
                this.mTrackFormat.setInteger("pcm-encoding", 2);
                if (string.contains("audio/")) {
                    this.mExtractor.selectTrack(i11);
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
                    this.mMediaCodec = createDecoderByType;
                    createDecoderByType.configure(this.mTrackFormat, (Surface) null, (MediaCrypto) null, 0);
                    break;
                }
                i11++;
            }
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.start();
            }
            this.mChannels = this.mTrackFormat.getInteger("channel-count");
            int integer = this.mTrackFormat.getInteger("sample-rate");
            this.mSampleRate = integer;
            if (integer == 22050) {
                this.mSampleRate = 22000;
            } else if (integer == 11025) {
                this.mSampleRate = 11000;
            }
            this.mFileLength = this.mTrackFormat.getLong("durationUs");
            return true;
        } catch (Exception e10) {
            Logging.e(TAG, "Error when creating aac audio file decoder");
            e10.printStackTrace();
            return false;
        }
    }

    public int decodeAACFrame(byte[] bArr) {
        int i10 = 0;
        try {
            int dequeueInputBuffer = this.mAACDecoder.dequeueInputBuffer(200L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = this.mAACDecoder.getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                inputBuffer.put(bArr);
                this.mAACDecoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0L, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mAACDecoder.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 || dequeueOutputBuffer == -2 || dequeueOutputBuffer == -1 || dequeueOutputBuffer < 0) {
                return 0;
            }
            ByteBuffer outputBuffer = this.mAACDecoder.getOutputBuffer(dequeueOutputBuffer);
            int i11 = bufferInfo.size;
            try {
                this.mAACOutputBuffer.position(0);
                outputBuffer.limit(i11);
                this.mAACOutputBuffer.put(outputBuffer);
                this.mAACDecoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                return i11;
            } catch (Exception e10) {
                i10 = i11;
                e = e10;
                Logging.e(TAG, "Error when decoding aac stream");
                e.printStackTrace();
                return i10;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public boolean decodeFrame() {
        int dequeueInputBuffer;
        int i10;
        int i11;
        try {
            if (!this.eoInputStream && (dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(0L)) >= 0) {
                int readSampleData = this.mExtractor.readSampleData(this.mMediaCodec.getInputBuffer(dequeueInputBuffer), 0);
                if (readSampleData <= 0) {
                    this.eoInputStream = true;
                    i10 = 0;
                } else {
                    i10 = readSampleData;
                }
                long sampleTime = this.mExtractor.getSampleTime();
                int sampleFlags = this.mExtractor.getSampleFlags();
                MediaCodec mediaCodec = this.mMediaCodec;
                if (this.eoInputStream) {
                    i11 = 4;
                } else {
                    i11 = sampleFlags;
                }
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, i10, sampleTime, i11);
                this.mExtractor.advance();
            }
            if (!this.eoOutputStream) {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                this.mDecodedDataReady = false;
                if (dequeueOutputBuffer != -3 && dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer != -1) {
                        this.mRetryCount = 0;
                        if (dequeueOutputBuffer >= 0) {
                            if ((bufferInfo.flags & 4) == 4) {
                                this.eoOutputStream = true;
                            }
                            cloneByteBuffer(this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer));
                            this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                            this.mDecodedDataReady = true;
                        }
                    } else {
                        int i12 = this.mRetryCount + 1;
                        this.mRetryCount = i12;
                        if (i12 >= MAX_DECODER_RETRY_COUNT) {
                            Logging.e(TAG, "EAGAIN count=" + this.mRetryCount + " presentationTimeUs=" + bufferInfo.presentationTimeUs + " totalUs=" + this.mFileLength + " Force EOS");
                            this.eoOutputStream = true;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            Logging.e(TAG, "Error when decoding audio file stream");
            e10.printStackTrace();
        }
        return this.eoOutputStream;
    }

    public int getChannelCount() {
        return this.mChannels;
    }

    public long getCurrentFilePosition() {
        return this.mExtractor.getSampleTime();
    }

    public boolean getDecodeDataReadyFlag() {
        return this.mDecodedDataReady;
    }

    public long getFileLength() {
        return this.mFileLength;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int getTrackNum() {
        MediaExtractorWrapper mediaExtractorWrapper = this.mExtractor;
        if (mediaExtractorWrapper == null) {
            return 0;
        }
        int trackCount = mediaExtractorWrapper.getTrackCount();
        int i10 = 0;
        for (int i11 = 0; i11 < trackCount; i11++) {
            if (this.mExtractor.getTrackFormat(i11).getString("mime").contains("audio/")) {
                i10++;
            }
        }
        return i10;
    }

    public void releaseAACStreaming() {
        try {
            MediaCodec mediaCodec = this.mAACDecoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACDecoder.release();
                this.mAACDecoder = null;
            }
        } catch (Exception e10) {
            Logging.e(TAG, "Error when releasing aac decode stream");
            e10.printStackTrace();
        }
    }

    public void releaseStreaming() {
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                } catch (Exception e10) {
                    Logging.e(TAG, "Media decoder stop failed", e10);
                }
                try {
                    this.mMediaCodec.release();
                } catch (Exception e11) {
                    Logging.e(TAG, "Media decoder release failed", e11);
                }
                this.mMediaCodec = null;
            }
            MediaExtractorWrapper mediaExtractorWrapper = this.mExtractor;
            if (mediaExtractorWrapper != null) {
                mediaExtractorWrapper.release();
                this.mExtractor = null;
            }
        } catch (Exception e12) {
            Logging.e(TAG, "Error when releasing audio file stream");
            e12.printStackTrace();
        }
        this.eoOutputStream = false;
        this.eoInputStream = false;
    }

    public void rewindStreaming() {
        try {
            this.mExtractor.seekTo(0L, 1);
            this.mMediaCodec.flush();
        } catch (Exception e10) {
            Logging.e(TAG, "Error when rewinding audio file stream");
            e10.printStackTrace();
        }
        this.eoInputStream = false;
        this.eoOutputStream = false;
        this.mDecodedDataReady = false;
    }

    public boolean selectTrack(int i10) {
        if (this.mExtractor == null) {
            return false;
        }
        return createStreaming(i10, getCurrentFilePosition());
    }

    public void setCurrentFilePosition(long j10) {
        this.mExtractor.seekTo(j10, 2);
    }

    private boolean createStreaming(int i10, long j10) {
        try {
            int trackCount = this.mExtractor.getTrackCount();
            Logging.i(TAG, "createStreaming select audio track index:" + i10 + " TrackNums:" + trackCount);
            int i11 = i10 + 1;
            if (trackCount < i11) {
                return false;
            }
            for (int i12 = 0; i12 < trackCount; i12++) {
                this.mExtractor.unselectTrack(i12);
            }
            int i13 = 0;
            for (int i14 = 0; i14 < trackCount; i14++) {
                MediaFormat trackFormat = this.mExtractor.getTrackFormat(i14);
                this.mTrackFormat = trackFormat;
                if (trackFormat.getString("mime").contains("audio/") && (i13 = i13 + 1) == i11) {
                    this.mExtractor.selectTrack(i14);
                    setCurrentFilePosition(j10);
                    this.mChannels = this.mTrackFormat.getInteger("channel-count");
                    int integer = this.mTrackFormat.getInteger("sample-rate");
                    this.mSampleRate = integer;
                    if (integer == 22050) {
                        this.mSampleRate = 22000;
                    } else if (integer == 11025) {
                        this.mSampleRate = 11000;
                    }
                    this.mFileLength = this.mTrackFormat.getLong("durationUs");
                    return true;
                }
            }
            Logging.e(TAG, "the selected audio track won't found");
            return false;
        } catch (Exception e10) {
            Logging.e(TAG, "Error when creating aac audio file decoder");
            e10.printStackTrace();
            return false;
        }
    }
}
