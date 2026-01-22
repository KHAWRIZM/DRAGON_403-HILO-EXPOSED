package io.agora.rtc.audio;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import io.agora.rtc.internal.Logging;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class MediaCodecAudioEncoder {
    private ByteBuffer[] mAACInputBuffers;
    private ByteBuffer[] mAACOutputBuffers;
    private ByteBuffer[] mInputBuffers;
    private ByteBuffer[] mOutputBuffers;
    private MediaCodec mMediaCodec = null;
    private MediaFormat mTrackFormat = null;
    private String mCodecString = null;
    private File outputFile = null;
    private BufferedOutputStream outputStream = null;
    private MediaCodec mAACEncoder = null;
    private MediaFormat mAACFormat = null;
    private ByteBuffer mAACEncodedBuffer = ByteBuffer.allocateDirect(1024);
    private String TAG = "MediaCodec Audio Encoder";

    private void addADTStoPacket(byte[] bArr, int i10) {
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) 84;
        bArr[3] = (byte) (64 + (i10 >> 11));
        bArr[4] = (byte) ((i10 & 2047) >> 3);
        bArr[5] = (byte) (((i10 & 7) << 5) + 31);
        bArr[6] = -4;
    }

    private void touch(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public boolean createAACStreaming(int i10, int i11, int i12) {
        try {
            Logging.i(this.TAG, "Encoding aac with fs = " + i10 + ", bitrate = " + i12);
            this.mAACEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i10, i11);
            this.mAACFormat = createAudioFormat;
            createAudioFormat.setInteger("aac-profile", 2);
            this.mAACFormat.setInteger("sample-rate", i10);
            this.mAACFormat.setInteger("channel-count", i11);
            this.mAACFormat.setInteger("bitrate", i12);
            this.mAACEncoder.configure(this.mAACFormat, (Surface) null, (MediaCrypto) null, 1);
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec != null) {
                mediaCodec.start();
            }
            return true;
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when creating aac encode stream");
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:2|3|4|(2:9|(10:(1:(1:13)(1:14))|15|16|(1:18)|19|20|21|22|(1:24)(1:(1:28))|25)(1:32))|33|(1:35)(1:(1:37))|16|(0)|19|20|21|22|(0)(0)|25) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e7, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e8, code lost:
    
        r10.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c4 A[Catch: Exception -> 0x0087, TryCatch #1 {Exception -> 0x0087, blocks: (B:3:0x0003, B:6:0x0044, B:9:0x004d, B:15:0x005f, B:16:0x00b8, B:18:0x00c4, B:19:0x00c7, B:22:0x00eb, B:24:0x00ef, B:28:0x00fd, B:31:0x00e8, B:35:0x008f, B:37:0x00a5, B:21:0x00d1), top: B:2:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ef A[Catch: Exception -> 0x0087, TryCatch #1 {Exception -> 0x0087, blocks: (B:3:0x0003, B:6:0x0044, B:9:0x004d, B:15:0x005f, B:16:0x00b8, B:18:0x00c4, B:19:0x00c7, B:22:0x00eb, B:24:0x00ef, B:28:0x00fd, B:31:0x00e8, B:35:0x008f, B:37:0x00a5, B:21:0x00d1), top: B:2:0x0003, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean createStreaming(String str, int i10, int i11, int i12) {
        MediaCodec mediaCodec;
        String str2;
        try {
            Logging.i(this.TAG, "Recording aac with fs = " + i10 + ", ch = " + i11 + ", quality = " + i12);
            String substring = str.substring(str.length() + (-3));
            int i13 = 16000;
            if (!substring.equalsIgnoreCase("3gp") && !substring.equalsIgnoreCase("amr")) {
                if (!substring.equalsIgnoreCase("aac")) {
                    return false;
                }
                if (i12 != 0) {
                    if (i12 != 1) {
                        i13 = 50000;
                    } else {
                        i13 = 25000;
                    }
                }
                this.mMediaCodec = MediaCodec.createEncoderByType("audio/mp4a-latm");
                MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", i10, i11);
                this.mTrackFormat = createAudioFormat;
                createAudioFormat.setInteger("aac-profile", 2);
                this.mTrackFormat.setInteger("sample-rate", i10);
                this.mTrackFormat.setInteger("channel-count", i11);
                this.mTrackFormat.setInteger("bitrate", i13);
                this.mCodecString = "audio/mp4a-latm";
                this.mMediaCodec.configure(this.mTrackFormat, (Surface) null, (MediaCrypto) null, 1);
                mediaCodec = this.mMediaCodec;
                if (mediaCodec != null) {
                    mediaCodec.start();
                }
                File file = new File(str);
                this.outputFile = file;
                touch(file);
                this.outputStream = new BufferedOutputStream(new FileOutputStream(this.outputFile));
                Logging.i(this.TAG, "outputStream initialized");
                str2 = this.mCodecString;
                if (str2 != "audio/3gpp") {
                    this.outputStream.write(new byte[]{35, 33, 65, 77, 82, 10});
                } else if (str2 == "audio/amr-wb") {
                    this.outputStream.write(new byte[]{35, 33, 65, 77, 82, 45, 87, 66, 10});
                }
                return true;
            }
            if (i10 == 8000) {
                this.mMediaCodec = MediaCodec.createEncoderByType("audio/3gpp");
                MediaFormat createAudioFormat2 = MediaFormat.createAudioFormat("audio/3gpp", i10, i11);
                this.mTrackFormat = createAudioFormat2;
                createAudioFormat2.setInteger("bitrate", 12200);
                this.mCodecString = "audio/3gpp";
            } else if (i10 == 16000) {
                this.mMediaCodec = MediaCodec.createEncoderByType("audio/amr-wb");
                MediaFormat createAudioFormat3 = MediaFormat.createAudioFormat("audio/amr-wb", i10, i11);
                this.mTrackFormat = createAudioFormat3;
                createAudioFormat3.setInteger("bitrate", 23850);
                this.mCodecString = "audio/amr-wb";
            }
            this.mMediaCodec.configure(this.mTrackFormat, (Surface) null, (MediaCrypto) null, 1);
            mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
            }
            File file2 = new File(str);
            this.outputFile = file2;
            touch(file2);
            this.outputStream = new BufferedOutputStream(new FileOutputStream(this.outputFile));
            Logging.i(this.TAG, "outputStream initialized");
            str2 = this.mCodecString;
            if (str2 != "audio/3gpp") {
            }
            return true;
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when creating aac file encoder");
            e10.printStackTrace();
            return false;
        }
    }

    public int encodeAACFrame(byte[] bArr) {
        int i10;
        int i11 = 0;
        try {
            int dequeueInputBuffer = this.mAACEncoder.dequeueInputBuffer(2000L);
            if (dequeueInputBuffer != -1) {
                ByteBuffer inputBuffer = this.mAACEncoder.getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                inputBuffer.put(bArr);
                this.mAACEncoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0L, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mAACEncoder.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer < 0) {
                return 0;
            }
            int i12 = bufferInfo.size;
            ByteBuffer outputBuffer = this.mAACEncoder.getOutputBuffer(dequeueOutputBuffer);
            if ((bufferInfo.flags & 2) == 2) {
                i10 = 0;
            } else {
                i10 = bufferInfo.size;
            }
            try {
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + i12);
                this.mAACEncodedBuffer.position(0);
                this.mAACEncodedBuffer.put(outputBuffer);
                this.mAACEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                return i10;
            } catch (Exception e10) {
                e = e10;
                i11 = i10;
                Logging.e(this.TAG, "Error when encoding aac stream");
                e.printStackTrace();
                return i11;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public void encodeFrame(byte[] bArr) {
        try {
            int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(2000L);
            if (dequeueInputBuffer != -1) {
                ByteBuffer inputBuffer = this.mMediaCodec.getInputBuffer(dequeueInputBuffer);
                inputBuffer.clear();
                inputBuffer.put(bArr);
                this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 0L, 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            while (dequeueOutputBuffer >= 0) {
                int i10 = bufferInfo.size;
                ByteBuffer outputBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + i10);
                String str = this.mCodecString;
                if (str == "audio/mp4a-latm") {
                    int i11 = i10 + 7;
                    byte[] bArr2 = new byte[i11];
                    addADTStoPacket(bArr2, i11);
                    outputBuffer.get(bArr2, 7, i10);
                    outputBuffer.position(bufferInfo.offset);
                    this.outputStream.write(bArr2, 0, i11);
                } else if (str == "audio/3gpp" || str == "audio/amr-wb") {
                    byte[] bArr3 = new byte[i10];
                    outputBuffer.get(bArr3, 0, i10);
                    outputBuffer.position(bufferInfo.offset);
                    this.outputStream.write(bArr3, 0, i10);
                }
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            }
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when encoding aac file");
            e10.printStackTrace();
        }
    }

    public void releaseAACStreaming() {
        try {
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACEncoder.release();
                this.mAACEncoder = null;
            }
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when releasing aac encode stream");
            e10.printStackTrace();
        }
    }

    public void releaseStreaming() {
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mMediaCodec.release();
                this.mMediaCodec = null;
            }
            BufferedOutputStream bufferedOutputStream = this.outputStream;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.flush();
                this.outputStream.close();
                this.outputStream = null;
            }
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when releasing aac file encoder");
            e10.printStackTrace();
        }
    }

    public boolean setAACEncodeBitrate(int i10) {
        Logging.w(this.TAG, "Set hw aac bitrate = " + i10);
        try {
            MediaCodec mediaCodec = this.mAACEncoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.mAACFormat.setInteger("bitrate", i10);
                this.mAACEncoder.configure(this.mAACFormat, (Surface) null, (MediaCrypto) null, 1);
                this.mAACEncoder.start();
            }
            return true;
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when setting aac encode bitrate");
            e10.printStackTrace();
            return false;
        }
    }

    public void setChannelCount(int i10) {
        try {
            this.mTrackFormat.setInteger("channel-count", i10);
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when setting aac file encoder channel count");
            e10.printStackTrace();
        }
    }

    public void setSampleRate(int i10) {
        try {
            this.mTrackFormat.setInteger("sample-rate", i10);
        } catch (Exception e10) {
            Logging.e(this.TAG, "Error when setting aac file encoder sample rate");
            e10.printStackTrace();
        }
    }
}
