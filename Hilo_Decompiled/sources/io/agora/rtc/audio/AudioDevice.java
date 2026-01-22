package io.agora.rtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.media.MediaRouter;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.os.LocaleList;
import android.os.Process;
import android.util.DisplayMetrics;
import com.luck.picture.lib.config.PictureMimeType;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.tencent.liteav.audio2.i;
import com.tencent.liteav.audio2.j;
import com.tencent.liteav.audio2.l;
import com.tencent.liteav.audio2.m;
import com.tencent.liteav.audio2.q;
import com.tencent.liteav.audio2.r;
import com.tencent.liteav.audio2.t;
import com.tencent.liteav.audio2.v;
import com.tencent.liteav.audio2.w;
import io.agora.rtc.Constants;
import io.agora.rtc.internal.Logging;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
class AudioDevice {
    private static final int CALCULATE_LATENCY_PERIOD = 400;
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private AudioManager _audioManager;
    private Context _context;
    private ByteBuffer _playBuffer;
    private ByteBuffer _recBuffer;
    private byte[] _tempBufPlay;
    private byte[] _tempBufRec;
    private long mNativeHandle;
    final String TAG = "AudioDevice Java";
    private final int _MaxRecPlay10msBlocks = 4;
    private AudioTrack _audioTrack = null;
    private AudioRecord _audioRecord = null;
    private final ReentrantLock _playLock = new ReentrantLock();
    private final ReentrantLock _recLock = new ReentrantLock();
    private boolean _doPlayInit = true;
    private boolean _doRecInit = true;
    private boolean _isRecording = false;
    private boolean _isPlaying = false;
    private long previous_time_ms = 0;
    private long current_time_ms = 0;
    private long _currentTotalPostion = 0;
    private long _framePostion = 0;
    private int _bufferedRecSamples = 0;
    private int _bufferedPlaySamples = 0;
    private int _playPosition = 0;
    private int _playbackSampleRate = 0;
    private int _playBufSize = 0;
    private int _playbackRestartCount = 0;
    private int _recordSampleRate = 0;
    private int _recordChannel = 0;
    private int _playChannel = 0;
    private int _recordBufSize = 0;
    private int _recordSource = 0;
    private int _recordRestartCount = 0;
    private boolean _renderStart = false;
    private long _firstRenderTS = 0;
    private long _playFramesWritten = 0;
    private int _playLatency = 0;
    private long _playLoopCount = 0;
    private int _playPreviousUnderrun = 0;
    private long _recDelay = 10;
    private long _lastRecDelay = 0;
    private long _recStartTS = 0;
    private int _recStartDelay = 0;
    private long _recFramesRead = 0;
    private int _recLatency = 0;
    private long _recLoopCount = 0;
    private int _sdkVer = Build.VERSION.SDK_INT;
    private long _recPosition = 0;
    private long[] _audioStatistic = new long[6];
    private final int POSITION_PLAY_APP = 0;
    private final int POSITION_PLAY_SYS = 1;
    private final int LAST_WRITE_TIME = 2;
    private final int POSITION_REC_APP = 3;
    private final int POSITION_REC_SYS = 4;
    private final int LAST_READ_TIME = 5;
    private AcousticEchoCanceler _aec = null;
    private NoiseSuppressor _ns = null;
    private AutomaticGainControl _agc = null;
    private boolean _useBuiltInAEC = false;
    private boolean _useBuiltInAGC = false;
    private boolean _useBuiltInNS = false;
    private int _streamType = 0;
    private int playWriten = 0;
    private int maxDelay = 0;
    private int totalDelay = 0;
    private int currentPlayoutVolume = -1;
    private VolumeBroadcastReceiver mVolumeBroadcastReceiver = null;

    AudioDevice(long j10) {
        this.mNativeHandle = j10;
        try {
            this._playBuffer = ByteBuffer.allocateDirect(7680);
            this._recBuffer = ByteBuffer.allocateDirect(7680);
        } catch (Exception e10) {
            Logging.e("AudioDevice Java", "failed to allocate bytebuffer", e10);
        }
        this._tempBufPlay = new byte[7680];
        this._tempBufRec = new byte[7680];
    }

    private boolean BuiltInAECIsAvailable() {
        try {
            return AcousticEchoCanceler.isAvailable();
        } catch (Exception unused) {
            Logging.e("AudioDevice Java", "Unable to query Audio Effect: Acoustic Echo Cancellation");
            return false;
        } catch (ExceptionInInitializerError e10) {
            Logging.e("AudioDevice Java", "Unable to create AEC object ", e10);
            return false;
        }
    }

    private boolean BuiltInAECIsEnabled() {
        return this._useBuiltInAEC;
    }

    private boolean BuiltInAGCIsAvaiable() {
        try {
            return AutomaticGainControl.isAvailable();
        } catch (Exception unused) {
            Logging.e("AudioDevice Java", "Unable to query Audio Effect: Automatic Gain Controller");
            return false;
        } catch (ExceptionInInitializerError e10) {
            Logging.e("AudioDevice Java", "Unable to create AGC object ", e10);
            return false;
        }
    }

    private boolean BuiltInNSIsAvailable() {
        try {
            return NoiseSuppressor.isAvailable();
        } catch (Exception unused) {
            Logging.e("AudioDevice Java", "Unable to query Audio Effect: Noise Supperssor");
            return false;
        } catch (ExceptionInInitializerError e10) {
            Logging.e("AudioDevice Java", "Unable to create NS object", e10);
            return false;
        }
    }

    private boolean BuiltinAGCIsEnabled() {
        return this._useBuiltInAGC;
    }

    private boolean BuiltinNSIsEnabled() {
        return this._useBuiltInNS;
    }

    private int CheckAudioStatus(int i10) {
        List activeRecordingConfigurations;
        int i11 = 0;
        if (Build.VERSION.SDK_INT >= 24) {
            int i12 = -1;
            if (this._audioManager == null) {
                Context context = this._context;
                if (context != null) {
                    this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
                } else {
                    Logging.e("AudioDevice Java", "CheckAudioStatus error");
                    return -1;
                }
            }
            if (i10 == 0) {
                if (this._context.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0 && this._context.checkPermission("android.permission.MODIFY_AUDIO_SETTINGS", Process.myPid(), Process.myUid()) == 0) {
                    if (this._audioManager != null) {
                        AudioRecord audioRecord = this._audioRecord;
                        if (audioRecord != null) {
                            i12 = audioRecord.getAudioSessionId();
                        }
                        activeRecordingConfigurations = this._audioManager.getActiveRecordingConfigurations();
                        Iterator it = activeRecordingConfigurations.iterator();
                        while (it.hasNext()) {
                            if (j.a(i.a(it.next())) != i12) {
                                i11 = 1033;
                            }
                        }
                    } else {
                        Logging.e("AudioDevice Java", "CheckAudioStatus unkonwn error");
                        return -1;
                    }
                } else {
                    Logging.e("AudioDevice Java", "CheckAudioStatus Microphone Permission denied");
                    return 2;
                }
            }
        }
        return i11;
    }

    private boolean EnableBuiltInAEC(boolean z10) {
        this._useBuiltInAEC = z10;
        return true;
    }

    private boolean EnableBuiltInAGC(boolean z10) {
        this._useBuiltInAGC = z10;
        return true;
    }

    private boolean EnableBuiltInNS(boolean z10) {
        this._useBuiltInNS = z10;
        return true;
    }

    private int GetAudioMode() {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            Logging.e("AudioDevice Java", "Could not change audio routing - no audio manager");
            return -1;
        }
        return audioManager.getMode();
    }

    private int GetNativePlayDelay() {
        if (this._recDelay < 0) {
            this._recDelay = -1L;
        }
        if (this.totalDelay < 0) {
            this.totalDelay = -1;
        }
        return this.totalDelay + ((int) this._recDelay);
    }

    private int GetNativeSampleRate() {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            Logging.w("AudioDevice Java", "Could not set audio mode - no audio manager");
            return 44100;
        }
        String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property == null) {
            return 44100;
        }
        return Integer.parseInt(property);
    }

    private int GetPlayoutLatency() {
        return this._playLatency;
    }

    private int GetPlayoutMaxVolume() {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(this._streamType);
        }
        return -1;
    }

    private int GetPlayoutVolume() {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        try {
            AudioManager audioManager = this._audioManager;
            if (audioManager == null) {
                return -1;
            }
            return audioManager.getStreamVolume(this._streamType);
        } catch (Exception unused) {
            Logging.e("AudioDevice Java", "getStreamVolume failed! ");
            return -1;
        }
    }

    private int GetPreferedSampleRate() {
        int i10;
        Context context;
        try {
            if (this._audioManager == null && (context = this._context) != null) {
                this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
            }
            i10 = Integer.parseInt(this._audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
        } catch (Exception e10) {
            Logging.e("AudioDevice Java", "GetPreferedSampleRate error", e10);
            i10 = 0;
        }
        if (i10 == 0) {
            return 16000;
        }
        return i10;
    }

    private int GetRecordLatency() {
        return this._recLatency;
    }

    private int GetUnderrunCount() {
        if (Build.VERSION.SDK_INT >= 24) {
            return GetUnderrunCountOnNougatOrHigher();
        }
        return GetUnderrunCountOnLowerThanNougat();
    }

    private int GetUnderrunCountOnLowerThanNougat() {
        return -1;
    }

    @TargetApi(24)
    private int GetUnderrunCountOnNougatOrHigher() {
        int i10;
        int i11 = 0;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                i10 = m.a(this._audioTrack);
            } catch (Exception e10) {
                Logging.e("AudioDevice Java", "getUnderrun fail ", e10);
                i10 = 0;
            }
            int i12 = i10 - this._playPreviousUnderrun;
            if (i12 >= 0) {
                i11 = i12;
            }
            this._playPreviousUnderrun = i10;
            if (i11 > 0) {
                Logging.d("AudioDevice Java", "Android AudioTrack underrun count: " + i11);
            }
        }
        return i11;
    }

    private int InitPlayback(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        Context context;
        this._playLock.lock();
        this._streamType = i12;
        int i16 = (((i13 * i10) * i11) * 2) / 1000;
        int i17 = 12;
        if (i11 == 2) {
            i14 = 12;
        } else {
            i14 = 4;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(i10, i14, 2);
        Logging.d("AudioDevice Java", "Java minimum playback buffer size is " + minBufferSize + ", profiledMiniOutBufferSize is " + i16 + " stream type " + this._streamType);
        if (minBufferSize < i16) {
            i15 = i16;
        } else {
            i15 = minBufferSize;
        }
        this._bufferedPlaySamples = 0;
        this._currentTotalPostion = 0L;
        Logging.d("AudioDevice Java", "Java playback buffer size is " + i15 + ", duration is " + ((i15 * 1000) / ((i10 * i11) * 2)) + " ms");
        AudioTrack audioTrack = this._audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this._audioTrack = null;
        }
        try {
            int i18 = this._streamType;
            if (i11 != 2) {
                i17 = 4;
            }
            AudioTrack audioTrack2 = new AudioTrack(i18, i10, i17, 2, i15, 1);
            this._audioTrack = audioTrack2;
            this._playbackSampleRate = i10;
            this._playChannel = i11;
            this._playBufSize = i15;
            this._playbackRestartCount = 0;
            if (audioTrack2.getState() != 1) {
                Logging.e("AudioDevice Java", "Java playback not initialized " + i10);
                this._playLock.unlock();
                return -1;
            }
            Logging.d("AudioDevice Java", "Java play sample rate is set to " + i10);
            if (this._audioManager == null && (context = this._context) != null) {
                this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
            }
            if (this._audioManager == null) {
                this._playLock.unlock();
                return 0;
            }
            this._playLock.unlock();
            return this._audioManager.getStreamMaxVolume(this._streamType);
        } catch (Exception e10) {
            Logging.e("AudioDevice Java", "Unable to new AudioTrack: ", e10);
            this._playLock.unlock();
            return -1;
        }
    }

    private int InitRecording(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        this._recLock.lock();
        int i16 = 16;
        if (i12 == 2) {
            i14 = 12;
        } else {
            i14 = 16;
        }
        int minBufferSize = AudioRecord.getMinBufferSize(i11, i14, 2);
        int i17 = i13 * (i11 / 1000) * i12 * 2;
        if (i17 > minBufferSize) {
            minBufferSize = i17;
        }
        Logging.d("AudioDevice Java", "Java minimum recording buffer size is " + minBufferSize);
        this._bufferedRecSamples = (i11 * 5) / 200;
        AcousticEchoCanceler acousticEchoCanceler = this._aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this._aec = null;
        }
        AutomaticGainControl automaticGainControl = this._agc;
        if (automaticGainControl != null) {
            automaticGainControl.release();
            this._agc = null;
        }
        NoiseSuppressor noiseSuppressor = this._ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this._ns = null;
        }
        AudioRecord audioRecord = this._audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this._audioRecord = null;
        }
        try {
            if (Build.VERSION.SDK_INT < 31) {
                if (i12 == 2) {
                    i15 = 12;
                } else {
                    i15 = 16;
                }
                this._audioRecord = new AudioRecord(i10, i11, i15, 2, minBufferSize);
            } else {
                AudioFormat.Builder encoding = new AudioFormat.Builder().setSampleRate(i11).setEncoding(2);
                if (i12 == 2) {
                    i16 = 12;
                }
                AudioFormat build = encoding.setChannelMask(i16).build();
                w.a();
                AudioRecord.Builder a10 = v.a();
                q.a(a10, build);
                a10.setAudioSource(i10);
                r.a(a10, minBufferSize);
                Context context = this._context;
                if (context != null) {
                    a10.setContext(context);
                }
                this._audioRecord = t.a(a10);
            }
            if (this._audioRecord.getState() != 1) {
                Logging.e("AudioDevice Java", "Java recording not initialized " + i11);
                this._recLock.unlock();
                return -2;
            }
            this._recordSampleRate = i11;
            this._recordChannel = i12;
            this._recordSource = i10;
            this._recordBufSize = minBufferSize;
            this._recordRestartCount = 0;
            Logging.d("AudioDevice Java", "Java recording sample rate set to " + i11);
            Logging.d("AudioDevice Java", "AcousticEchoCanceler.isAvailable: " + BuiltInAECIsAvailable() + " AutomaticGainControl.isAvailable: " + BuiltInAGCIsAvaiable() + " NoiseSuppressor.isAvailable: " + BuiltInNSIsAvailable());
            if (BuiltInAECIsAvailable() && BuiltInAECIsEnabled()) {
                AcousticEchoCanceler create = AcousticEchoCanceler.create(this._audioRecord.getAudioSessionId());
                this._aec = create;
                if (create == null) {
                    Logging.e("AudioDevice Java", "AcousticEchoCanceler.create failed");
                } else {
                    AudioEffect.Descriptor descriptor = create.getDescriptor();
                    if (descriptor == null) {
                        Logging.e("AudioDevice Java", "aec getDescriptor() failed");
                    } else {
                        Logging.d("AudioDevice Java", "AcousticEchoCanceler name: " + descriptor.name + ", implementor: " + descriptor.implementor + ", uuid: " + descriptor.uuid);
                    }
                    if (this._aec.setEnabled(this._useBuiltInAEC) != 0) {
                        Logging.e("AudioDevice Java", "AcousticEchoCanceler.setEnabled failed");
                    }
                    Logging.i("AudioDevice Java", "AcousticEchoCanceler.getEnabled: " + this._aec.getEnabled());
                }
            }
            if (BuiltInAGCIsAvaiable() && BuiltinAGCIsEnabled()) {
                AutomaticGainControl create2 = AutomaticGainControl.create(this._audioRecord.getAudioSessionId());
                this._agc = create2;
                if (create2 == null) {
                    Logging.e("AudioDevice Java", "AutomaticGainControl.create failed");
                } else {
                    AudioEffect.Descriptor descriptor2 = create2.getDescriptor();
                    if (descriptor2 == null) {
                        Logging.e("AudioDevice Java", "agc getDescriptor() failed");
                    } else {
                        Logging.d("AudioDevice Java", "AutomaticGainControl name: " + descriptor2.name + ", implementor: " + descriptor2.implementor + ", uuid: " + descriptor2.uuid);
                    }
                    if (this._agc.setEnabled(this._useBuiltInAGC) != 0) {
                        Logging.e("AudioDevice Java", "AutomaticGainController.setEnable failed");
                    }
                    Logging.i("AudioDevice Java", "AutomaticGainController.getEnabled: " + this._agc.getEnabled());
                }
            }
            if (BuiltInNSIsAvailable() && BuiltinNSIsEnabled()) {
                NoiseSuppressor create3 = NoiseSuppressor.create(this._audioRecord.getAudioSessionId());
                this._ns = create3;
                if (create3 == null) {
                    Logging.e("AudioDevice Java", "NoiseSuppressor.create failed");
                } else {
                    AudioEffect.Descriptor descriptor3 = create3.getDescriptor();
                    if (descriptor3 == null) {
                        Logging.e("AudioDevice Java", "ns getDescriptor() failed");
                    } else {
                        Logging.d("AudioDevice Java", "NoiseSuppressor name: " + descriptor3.name + ", implementor: " + descriptor3.implementor + ", uuid: " + descriptor3.uuid);
                    }
                    if (this._ns.setEnabled(this._useBuiltInNS) != 0) {
                        Logging.e("AudioDevice Java", "NoiseSuppressor.setEnable failed");
                    }
                    Logging.i("AudioDevice Java", "NoiseSuppressor.getEnabled: " + this._ns.getEnabled());
                }
            }
            this._recLock.unlock();
            return this._bufferedRecSamples;
        } catch (Exception e10) {
            Logging.e("AudioDevice Java", "Unable to new AudioRecord: ", e10);
            this._recLock.unlock();
            return -1;
        }
    }

    private int PlayAudio(int i10) {
        long j10;
        int i11;
        this._playLock.lock();
        try {
            try {
            } finally {
                this._playLock.unlock();
            }
        } catch (Exception e10) {
            Logging.e("AudioDevice Java", "PlayAudio got fatal error ", e10);
        }
        if (this._audioTrack == null) {
            this._playLock.unlock();
            return -2;
        }
        if (!this._isPlaying) {
            Logging.w("AudioDevice Java", "PlayAudio not ready!");
            return 0;
        }
        if (this._doPlayInit) {
            try {
                Process.setThreadPriority(-19);
            } catch (Exception e11) {
                Logging.e("AudioDevice Java", "Set play thread priority failed: ", e11);
            }
            this._doPlayInit = false;
            this.previous_time_ms = (System.nanoTime() / 1000) / 1000;
        }
        this._playBuffer.get(this._tempBufPlay);
        int write = this._audioTrack.write(this._tempBufPlay, 0, i10);
        this._playBuffer.rewind();
        this._bufferedPlaySamples += write >> 1;
        this.playWriten += write;
        long j11 = this._currentTotalPostion + (r9 / this._playChannel);
        this._currentTotalPostion = j11;
        this._playFramesWritten = j11;
        try {
            long j12 = this._playLoopCount;
            if (j12 % 400 == 0 || j12 < 5) {
                calculateLatencyMillis(true);
            }
            j10 = this._playLoopCount;
        } catch (Throwable th) {
            try {
                Logging.e("AudioDevice Java", "calculateLatencyMillis failed: " + th.getMessage());
                j10 = this._playLoopCount;
            } catch (Throwable th2) {
                this._playLoopCount++;
                throw th2;
            }
        }
        this._playLoopCount = j10 + 1;
        if (Build.VERSION.SDK_INT >= 24) {
            long nanoTime = (System.nanoTime() / 1000) / 1000;
            this.current_time_ms = nanoTime;
            if (nanoTime - this.previous_time_ms >= 50) {
                AudioTimestamp audioTimestamp = new AudioTimestamp();
                this._audioTrack.getTimestamp(audioTimestamp);
                long j13 = audioTimestamp.framePosition;
                this._framePostion = j13;
                if (this.current_time_ms - this.previous_time_ms > 65) {
                    this._bufferedPlaySamples = (int) (this._currentTotalPostion - (this._playPosition / this._playChannel));
                } else {
                    this._bufferedPlaySamples = (int) (this._currentTotalPostion - j13);
                }
                this.previous_time_ms = (audioTimestamp.nanoTime / 1000) / 1000;
            }
        }
        int playbackHeadPosition = this._audioTrack.getPlaybackHeadPosition() * this._playChannel;
        if (playbackHeadPosition < this._playPosition) {
            this._playPosition = 0;
        }
        this._playPosition = playbackHeadPosition;
        long[] jArr = this._audioStatistic;
        long j14 = this._currentTotalPostion * 1000;
        int i12 = this._playbackSampleRate;
        jArr[0] = j14 / i12;
        jArr[1] = (playbackHeadPosition * 1000) / i12;
        jArr[2] = (System.nanoTime() / 1000) / 1000;
        if (write != i10) {
            if (this._playbackRestartCount <= 20) {
                Logging.e("AudioDevice Java", "Error writing AudioTrack! Restart AudioTrack " + this._playbackRestartCount);
                this._playbackRestartCount = this._playbackRestartCount + 1;
                this._audioTrack.stop();
                this._audioTrack.release();
                this._audioTrack = null;
                try {
                    int i13 = this._streamType;
                    int i14 = this._playbackSampleRate;
                    if (this._playChannel == 2) {
                        i11 = 12;
                    } else {
                        i11 = 4;
                    }
                    AudioTrack audioTrack = new AudioTrack(i13, i14, i11, 2, this._playBufSize, 1);
                    this._audioTrack = audioTrack;
                    audioTrack.play();
                } catch (Exception e12) {
                    Logging.e("AudioDevice Java", "restart audio fail", e12);
                }
            }
            return write;
        }
        return this._bufferedPlaySamples * this._playChannel;
    }

    private int PlayNoBlockAudio(int i10) {
        long j10;
        int write;
        int i11;
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            Logging.e("AudioDevice Java", "Play failed,  SDK_INT " + i12);
            return -2;
        }
        this._playLock.lock();
        try {
            try {
            } catch (Exception e10) {
                Logging.e("AudioDevice Java", "PlayNBAudio got fatal error ", e10);
            }
            if (this._audioTrack == null) {
                Logging.e("AudioDevice Java", "Play failed, _audioTrack == null ");
                return -2;
            }
            if (this._doPlayInit) {
                try {
                    Process.setThreadPriority(-19);
                } catch (Exception e11) {
                    Logging.e("AudioDevice Java", "Set play thread priority failed: ", e11);
                }
                this._doPlayInit = false;
                this.previous_time_ms = (System.nanoTime() / 1000) / 1000;
            }
            this._playBuffer.get(this._tempBufPlay);
            int i13 = i10;
            int i14 = 0;
            while (this._isPlaying) {
                write = this._audioTrack.write(this._tempBufPlay, i14, i13, 1);
                if (write < 0) {
                    if (this._playbackRestartCount <= 20) {
                        Logging.e("AudioDevice Java", "Error writing AudioTrack! Restart AudioTrack " + i14);
                        this._playbackRestartCount = this._playbackRestartCount + 1;
                        this._audioTrack.stop();
                        this._audioTrack.release();
                        this._audioTrack = null;
                        try {
                            int i15 = this._streamType;
                            int i16 = this._playbackSampleRate;
                            if (this._playChannel == 2) {
                                i11 = 12;
                            } else {
                                i11 = 4;
                            }
                            AudioTrack audioTrack = new AudioTrack(i15, i16, i11, 2, this._playBufSize, 1);
                            this._audioTrack = audioTrack;
                            audioTrack.play();
                        } catch (Exception e12) {
                            Logging.e("AudioDevice Java", "restart audio fail", e12);
                        }
                        this._playFramesWritten = 0L;
                        this._playLoopCount = 0L;
                    }
                    return i14;
                }
                i14 += write;
                if (i14 == i10) {
                    break;
                }
                if (write < i13) {
                    Thread.sleep(getPlayBufferMs() / 3);
                }
                i13 = i10 - i14;
            }
            this._bufferedPlaySamples += i14 >> 1;
            this.playWriten += i14;
            long j11 = this._currentTotalPostion;
            int i17 = this._playChannel;
            this._currentTotalPostion = j11 + (r2 / i17);
            this._playFramesWritten += r2 / i17;
            try {
                long j12 = this._playLoopCount;
                if (j12 % 400 == 0 || j12 < 5) {
                    calculateLatencyMillis(true);
                }
                j10 = this._playLoopCount;
            } catch (Throwable th) {
                try {
                    Logging.e("AudioDevice Java", "calculateLatencyMillis failed: " + th.getMessage());
                    j10 = this._playLoopCount;
                } catch (Throwable th2) {
                    this._playLoopCount++;
                    throw th2;
                }
            }
            this._playLoopCount = j10 + 1;
            if (Build.VERSION.SDK_INT >= 24) {
                long nanoTime = (System.nanoTime() / 1000) / 1000;
                this.current_time_ms = nanoTime;
                if (nanoTime - this.previous_time_ms >= 50) {
                    AudioTimestamp audioTimestamp = new AudioTimestamp();
                    this._audioTrack.getTimestamp(audioTimestamp);
                    long j13 = audioTimestamp.framePosition;
                    this._framePostion = j13;
                    if (this.current_time_ms - this.previous_time_ms > 65) {
                        this._bufferedPlaySamples = (int) (this._currentTotalPostion - (this._playPosition / this._playChannel));
                    } else {
                        this._bufferedPlaySamples = (int) (this._currentTotalPostion - j13);
                    }
                    this.previous_time_ms = (audioTimestamp.nanoTime / 1000) / 1000;
                }
            }
            int playbackHeadPosition = this._audioTrack.getPlaybackHeadPosition() * this._playChannel;
            if (playbackHeadPosition < this._playPosition) {
                this._playPosition = 0;
            }
            this._playPosition = playbackHeadPosition;
            long[] jArr = this._audioStatistic;
            long j14 = this._currentTotalPostion * 1000;
            int i18 = this._playbackSampleRate;
            jArr[0] = j14 / i18;
            jArr[1] = (playbackHeadPosition * 1000) / i18;
            jArr[2] = (System.nanoTime() / 1000) / 1000;
            return this._bufferedPlaySamples * this._playChannel;
        } finally {
            this._playBuffer.rewind();
            this._playLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b4 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int QuerySpeakerStatus() {
        LocaleList locales;
        int i10;
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                MediaRouter.RouteInfo selectedRoute = ((MediaRouter) this._context.getSystemService("media_router")).getSelectedRoute(1);
                selectedRoute.getName().toString().compareToIgnoreCase("phone");
                Configuration configuration = this._context.getResources().getConfiguration();
                locales = configuration.getLocales();
                DisplayMetrics displayMetrics = this._context.getResources().getDisplayMetrics();
                configuration.setLocale(Locale.ENGLISH);
                this._context.getResources().updateConfiguration(configuration, displayMetrics);
                if (selectedRoute.getName(this._context).toString().compareToIgnoreCase("phone") == 0) {
                    Logging.e("AudioDevice Java", "speaker");
                } else {
                    if (selectedRoute.getName(this._context).toString().compareToIgnoreCase("headset") == 0) {
                        Logging.e("AudioDevice Java", "headset");
                        i10 = 0;
                    } else if (selectedRoute.getName(this._context).toString().compareToIgnoreCase("bluetooth") == 0) {
                        Logging.e("AudioDevice Java", "bluetooth");
                        i10 = 5;
                    }
                    configuration.setLocales(locales);
                    this._context.getResources().updateConfiguration(configuration, displayMetrics);
                    if (i10 != -1) {
                        return i10;
                    }
                }
                i10 = -1;
                configuration.setLocales(locales);
                this._context.getResources().updateConfiguration(configuration, displayMetrics);
                if (i10 != -1) {
                }
            }
        } catch (Exception e10) {
            Logging.e("error in Query audio route ");
            e10.printStackTrace();
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            Logging.e("AudioDevice Java", "Could not get audio routing - no audio manager");
            return -1;
        }
        if (audioManager.isBluetoothA2dpOn()) {
            return 5;
        }
        if (this._audioManager.isSpeakerphoneOn()) {
            return 3;
        }
        if (this._audioManager.isBluetoothScoOn()) {
            return 5;
        }
        if (this._audioManager.isWiredHeadsetOn()) {
            return 0;
        }
        return 1;
    }

    private int RecordAudio(int i10) {
        AudioRecord audioRecord;
        long j10;
        int bufferSizeInFrames;
        int i11;
        this._recLock.lock();
        try {
            try {
                try {
                    if (!this._isRecording) {
                        Logging.w("AudioDevice Java", "RecordAudio not ready!");
                        return 0;
                    }
                    if (this._audioRecord == null) {
                        this._recLock.unlock();
                        return -4;
                    }
                    if (this._doRecInit) {
                        try {
                            Process.setThreadPriority(-19);
                        } catch (Exception e10) {
                            Logging.e("AudioDevice Java", "Set rec thread priority failed: ", e10);
                        }
                        this._doRecInit = false;
                    }
                    this._recBuffer.rewind();
                    int read = this._audioRecord.read(this._tempBufRec, 0, i10);
                    if (read != i10) {
                        int i12 = this._recordRestartCount;
                        if (i12 > 0 && this._audioRecord != null) {
                            Logging.e("AudioDevice Java", "audioRecord.read retry failed!  ");
                            this._audioRecord.release();
                            this._audioRecord = null;
                            this._recLock.unlock();
                            return -20;
                        }
                        if (i12 == 0) {
                            Logging.e("AudioDevice Java", "Retry audioRecord for read failed:  " + read);
                            try {
                                int i13 = this._recordSource;
                                int i14 = this._recordSampleRate;
                                if (this._recordChannel == 2) {
                                    i11 = 12;
                                } else {
                                    i11 = 16;
                                }
                                AudioRecord audioRecord2 = new AudioRecord(i13, i14, i11, 2, this._recordBufSize);
                                this._audioRecord = audioRecord2;
                                audioRecord2.startRecording();
                            } catch (Exception e11) {
                                Logging.e("AudioDevice Java", "Retry audioRecord created failed: ", e11);
                            }
                            this._recStartTS = System.nanoTime();
                            this._recStartDelay = 0;
                            this._recFramesRead = 0L;
                            this._recLoopCount = 0L;
                        }
                        this._recordRestartCount++;
                        return read;
                    }
                    this._recordRestartCount = 0;
                    this._recBuffer.put(this._tempBufRec);
                    if (this._recDelay == 10) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            AudioTimestamp audioTimestamp = new AudioTimestamp();
                            l.a(this._audioRecord, audioTimestamp, 0);
                            long nanoTime = ((System.nanoTime() - audioTimestamp.nanoTime) / 1000) / 1000;
                            this._recDelay = nanoTime;
                            if (nanoTime > 50) {
                                this._recDelay = 10L;
                            }
                        } else {
                            this._recDelay = 10L;
                        }
                        if (this._recStartDelay == 0) {
                            this._recStartDelay = (((int) (System.nanoTime() - this._recStartTS)) / 1000) / 1000;
                        }
                        this._recDelay += this._recStartDelay;
                    }
                    if (this._lastRecDelay != this._recDelay) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            bufferSizeInFrames = this._audioRecord.getBufferSizeInFrames();
                            Logging.i("AudioDevice Java", "frames  " + bufferSizeInFrames + " recDelay " + this._recDelay + " caculated frames delay " + (bufferSizeInFrames / (this._audioRecord.getSampleRate() / 1000)));
                        } else {
                            Logging.i("AudioDevice Java", "_recDelay: " + this._recDelay);
                        }
                        this._lastRecDelay = this._recDelay;
                    }
                    if (read >= 0) {
                        this._recPosition += (read / this._recordChannel) / 2;
                    }
                    this._recFramesRead += (read / this._recordChannel) / 2;
                    try {
                        if (this._recLoopCount % 400 == 0) {
                            calculateLatencyMillis(false);
                        }
                        j10 = (this._recLoopCount + 1) % 400;
                    } catch (Throwable th) {
                        try {
                            Logging.e("AudioDevice Java", "calculateLatencyMillis failed: " + th.getMessage());
                            j10 = (this._recLoopCount + 1) % 400;
                        } catch (Throwable th2) {
                            this._recLoopCount = (this._recLoopCount + 1) % 400;
                            throw th2;
                        }
                    }
                    this._recLoopCount = j10;
                    long[] jArr = this._audioStatistic;
                    jArr[3] = (this._recPosition * 1000) / this._recordSampleRate;
                    jArr[5] = (System.nanoTime() / 1000) / 1000;
                    this._recordRestartCount = 0;
                    this._recLock.unlock();
                    return 0;
                } catch (Exception e12) {
                    e = e12;
                    audioRecord = null;
                    this._audioRecord = audioRecord;
                    Logging.e("AudioDevice Java", "RecordAudio try failed: ", e);
                    this._recLock.unlock();
                    return -10;
                }
            } catch (Exception e13) {
                e = e13;
                audioRecord = null;
            }
        } finally {
            this._recLock.unlock();
        }
    }

    private int SetAudioMode(int i10) {
        AudioManager audioManager;
        Context context;
        try {
            if (this._audioManager == null && (context = this._context) != null) {
                this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
            }
            audioManager = this._audioManager;
        } catch (Exception unused) {
            Logging.e("AudioDevice Java", "set audio mode failed! ");
        }
        if (audioManager == null) {
            Logging.e("AudioDevice Java", "Could not change audio routing - no audio manager");
            return -1;
        }
        audioManager.getStreamMaxVolume(3);
        this._audioManager.getStreamVolume(3);
        this._audioManager.getStreamMaxVolume(0);
        this._audioManager.getStreamVolume(0);
        if (this._audioManager.getMode() == i10) {
            return 0;
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        this._audioManager.setMode(0);
                    } else {
                        this._audioManager.setMode(3);
                    }
                } else {
                    this._audioManager.setMode(2);
                }
            } else {
                this._audioManager.setMode(1);
            }
        } else {
            this._audioManager.setMode(0);
        }
        return 0;
    }

    private int SetPlayoutSpeaker(boolean z10) {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager == null) {
            Logging.e("AudioDevice Java", "Could not change audio routing - no audio manager");
            return -1;
        }
        audioManager.setSpeakerphoneOn(z10);
        return 0;
    }

    private int SetPlayoutVolume(int i10) {
        Context context;
        if (this._audioManager == null && (context = this._context) != null) {
            this._audioManager = (AudioManager) context.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        }
        AudioManager audioManager = this._audioManager;
        if (audioManager != null) {
            int streamMaxVolume = audioManager.getStreamMaxVolume(this._streamType);
            if (i10 < 255) {
                streamMaxVolume = (i10 * streamMaxVolume) / KotlinVersion.MAX_COMPONENT_VALUE;
            }
            this._audioManager.setStreamVolume(this._streamType, streamMaxVolume, 0);
            return 0;
        }
        return -1;
    }

    private int StartPlayback() {
        this._playLock.lock();
        this._firstRenderTS = 0L;
        this._renderStart = false;
        this._playLoopCount = 0L;
        this._playFramesWritten = 0L;
        try {
            try {
                try {
                    this.playWriten = 0;
                    this._playBuffer.rewind();
                    this._audioTrack.play();
                    this.maxDelay = 0;
                    this.totalDelay = 0;
                    this._isPlaying = true;
                    this._playLock.unlock();
                    monitorPlayoutVolumeChange(true);
                    notifyPlayoutVolumeChange();
                    return 0;
                } catch (IllegalStateException e10) {
                    e10.printStackTrace();
                    return -1;
                }
            } catch (Exception e11) {
                Logging.e("AudioDevice Java", "startplayback fail", e11);
                return -1;
            }
        } finally {
            this._playLock.unlock();
        }
    }

    private int StartRecording() {
        this._recLock.lock();
        try {
            try {
                AudioRecord audioRecord = this._audioRecord;
                if (audioRecord != null) {
                    this._recFramesRead = 0L;
                    this._recLoopCount = 0L;
                    audioRecord.startRecording();
                    Logging.e("AudioDevice Java", "Recording start time " + System.nanoTime());
                    this._recStartTS = System.nanoTime();
                    this._recStartDelay = 0;
                    this._recDelay = 10L;
                    this._isRecording = true;
                    this._recPosition = 0L;
                    return 0;
                }
            } catch (IllegalStateException e10) {
                Logging.e("AudioDevice Java", "failed to startRecording", e10);
                this._recLock.unlock();
                return -1;
            } catch (Exception e11) {
                Logging.e("AudioDevice Java", "failed to startRecording Exception", e11);
            }
            return -2;
        } finally {
            this._recLock.unlock();
        }
    }

    private int StopPlayback() {
        this._firstRenderTS = 0L;
        this._isPlaying = false;
        this._playLock.lock();
        try {
            try {
                this._audioTrack.setVolume(DownloadProgress.UNKNOWN_PROGRESS);
                if (this._audioTrack.getPlayState() == 3) {
                    this._audioTrack.stop();
                    this._audioTrack.flush();
                }
                this._audioTrack.release();
                this._audioTrack = null;
            } catch (IllegalStateException e10) {
                Logging.e("AudioDevice Java", "Unable to stop playback: ", e10);
                AudioTrack audioTrack = this._audioTrack;
                if (audioTrack != null) {
                    audioTrack.flush();
                    this._audioTrack.release();
                    this._audioTrack = null;
                }
                this._doPlayInit = true;
                this._playLock.unlock();
                return -1;
            } catch (Exception e11) {
                Logging.e("AudioDevice Java", "Stop playback fail", e11);
                AudioTrack audioTrack2 = this._audioTrack;
                if (audioTrack2 != null) {
                    audioTrack2.flush();
                    this._audioTrack.release();
                    this._audioTrack = null;
                }
            }
            this._doPlayInit = true;
            this._playLock.unlock();
            monitorPlayoutVolumeChange(false);
            return 0;
        } catch (Throwable th) {
            AudioTrack audioTrack3 = this._audioTrack;
            if (audioTrack3 != null) {
                audioTrack3.flush();
                this._audioTrack.release();
                this._audioTrack = null;
            }
            this._doPlayInit = true;
            this._playLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        if (r3 != null) goto L٢٤;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        r3.release();
        r6._audioRecord = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
    
        r6._doRecInit = true;
        r6._recLock.unlock();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        if (r3 == null) goto L٢٥;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int StopRecording() {
        AudioRecord audioRecord;
        this._recLock.lock();
        try {
            try {
                AudioRecord audioRecord2 = this._audioRecord;
                if (audioRecord2 != null && audioRecord2.getRecordingState() == 3) {
                    this._audioRecord.stop();
                }
                AcousticEchoCanceler acousticEchoCanceler = this._aec;
                if (acousticEchoCanceler != null) {
                    acousticEchoCanceler.release();
                    this._aec = null;
                }
                AutomaticGainControl automaticGainControl = this._agc;
                if (automaticGainControl != null) {
                    automaticGainControl.release();
                    this._agc = null;
                }
                NoiseSuppressor noiseSuppressor = this._ns;
                if (noiseSuppressor != null) {
                    noiseSuppressor.release();
                    this._ns = null;
                }
                this._isRecording = false;
                audioRecord = this._audioRecord;
            } catch (Exception e10) {
                Logging.e("AudioDevice Java", "error in StopRecording ", e10);
                audioRecord = this._audioRecord;
            }
        } catch (Throwable th) {
            AudioRecord audioRecord3 = this._audioRecord;
            if (audioRecord3 != null) {
                audioRecord3.release();
                this._audioRecord = null;
            }
            this._doRecInit = true;
            this._recLock.unlock();
            throw th;
        }
    }

    private int calculateLatencyMillis(boolean z10) {
        if (z10) {
            if (this._audioTrack == null) {
                Logging.e("AudioDevice Java", "calculateLatencyMillis failed, invalid _audioTrack");
                return -1;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                AudioTimestamp audioTimestamp = new AudioTimestamp();
                if (!this._audioTrack.getTimestamp(audioTimestamp)) {
                    Logging.e("AudioDevice Java", "Play calculateLatencyMillis getTimestamp failed");
                    return -1;
                }
                int sampleRate = (int) (((audioTimestamp.nanoTime + (((this._playFramesWritten - audioTimestamp.framePosition) * 1000000000) / this._audioTrack.getSampleRate())) - System.nanoTime()) / 1000000);
                if (sampleRate >= 0) {
                    this._playLatency = sampleRate + 10;
                }
            } else {
                this._playLatency = Constants.ERR_ALREADY_IN_RECORDING;
            }
        } else {
            if (this._audioRecord == null) {
                Logging.e("AudioDevice Java", "Record calculateLatencyMillis failed, invalid _audioRecord");
                return -1;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                AudioTimestamp audioTimestamp2 = new AudioTimestamp();
                if (l.a(this._audioRecord, audioTimestamp2, 0) != 0) {
                    Logging.e("AudioDevice Java", "Record calculateLatencyMillis getTimestamp failed");
                    return -1;
                }
                int nanoTime = (int) ((System.nanoTime() - (audioTimestamp2.nanoTime + (((this._recFramesRead - audioTimestamp2.framePosition) * 1000000000) / this._audioRecord.getSampleRate()))) / 1000000);
                if (nanoTime >= 0) {
                    this._recLatency = nanoTime + 10;
                }
            } else {
                this._recLatency = 60;
            }
        }
        return 0;
    }

    private int enableHardwareEarback(boolean z10) {
        Logging.i("AudioDevice Java", "enableHardwareEarback " + z10);
        int enableHardwareEarback = HardwareEarbackController.getInstance(this._context).enableHardwareEarback(z10);
        Logging.i("AudioDevice Java", "enableHardwareEarback " + z10 + " ret " + enableHardwareEarback);
        return enableHardwareEarback;
    }

    private int getPlayBufferMs() {
        int i10;
        int i11 = this._playbackSampleRate;
        if (i11 != 0 && (i10 = this._playChannel) != 0) {
            return ((this._playBufSize / (i10 * 2)) * 1000) / i11;
        }
        return 10;
    }

    private boolean isHardwareEarbackSupported() {
        Context context = this._context;
        if (context != null) {
            return HardwareEarbackController.getInstance(context).isHardwareEarbackSupported();
        }
        return false;
    }

    private int setHardwareEarbackVolume(int i10) {
        Context context = this._context;
        if (context != null) {
            return HardwareEarbackController.getInstance(context).setHardwareEarbackVolume(i10);
        }
        return -1;
    }

    public void monitorPlayoutVolumeChange(boolean z10) {
        VolumeBroadcastReceiver volumeBroadcastReceiver;
        if (z10) {
            if (this.mVolumeBroadcastReceiver == null) {
                try {
                    this.mVolumeBroadcastReceiver = new VolumeBroadcastReceiver(this);
                    Context context = this._context;
                    if (context != null) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(VOLUME_CHANGED_ACTION);
                        context.registerReceiver(this.mVolumeBroadcastReceiver, intentFilter);
                        return;
                    }
                    return;
                } catch (Exception e10) {
                    Logging.e("AudioDevice Java", "Unable to create VolumeBroadcastReceiver, ", e10);
                    return;
                }
            }
            return;
        }
        try {
            Context context2 = this._context;
            if (context2 != null && (volumeBroadcastReceiver = this.mVolumeBroadcastReceiver) != null) {
                context2.unregisterReceiver(volumeBroadcastReceiver);
            }
        } catch (IllegalArgumentException unused) {
        }
        this.mVolumeBroadcastReceiver = null;
    }

    native void nativeNotifyPlayoutVolumeChange(long j10, int i10);

    public void notifyPlayoutVolumeChange() {
        synchronized (this) {
            try {
                int GetPlayoutVolume = GetPlayoutVolume();
                if (this.currentPlayoutVolume != GetPlayoutVolume) {
                    nativeNotifyPlayoutVolumeChange(this.mNativeHandle, GetPlayoutVolume);
                    this.currentPlayoutVolume = GetPlayoutVolume;
                    Logging.i("AudioDevice Java", " notifyPlayoutVolumeChange: " + GetPlayoutVolume);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
