package io.agora.rtc.live;

import io.agora.rtc.video.AgoraImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class LiveTranscoding {
    public static final String LBHQ = "lbhq";
    public static final String VEO = "veo";
    private ArrayList<AgoraImage> backgroundImageList;

    @Deprecated
    public int userCount;
    private ArrayList<AgoraImage> watermarkList;
    public int width = 360;
    public int height = 640;
    public int videoBitrate = 400;
    public VideoCodecProfileType videoCodecProfile = VideoCodecProfileType.HIGH;
    public VideoCodecType videoCodecType = VideoCodecType.H264;
    public int videoGop = 30;
    public int videoFramerate = 15;
    public AgoraImage watermark = new AgoraImage();
    public AgoraImage backgroundImage = new AgoraImage();

    @Deprecated
    public boolean lowLatency = false;
    public AudioSampleRateType audioSampleRate = AudioSampleRateType.TYPE_44100;
    public int audioBitrate = 48;
    public int audioChannels = 1;
    public AudioCodecProfileType audioCodecProfile = AudioCodecProfileType.LC_AAC;
    private Map<Integer, TranscodingUser> transcodingUsers = new HashMap();
    private Map<String, Boolean> advancedFeatures = new HashMap();

    @Deprecated
    public int backgroundColor = -16777216;
    public String userConfigExtraInfo = null;

    @Deprecated
    public String metadata = null;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum AudioCodecProfileType {
        LC_AAC(0),
        HE_AAC(1),
        HE_AAC_V2(2);

        private int value;

        AudioCodecProfileType(int i10) {
            this.value = i10;
        }

        public static int getValue(AudioCodecProfileType audioCodecProfileType) {
            return audioCodecProfileType.value;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum AudioSampleRateType {
        TYPE_32000(32000),
        TYPE_44100(44100),
        TYPE_48000(48000);

        private int value;

        AudioSampleRateType(int i10) {
            this.value = i10;
        }

        public static int getValue(AudioSampleRateType audioSampleRateType) {
            return audioSampleRateType.value;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class TranscodingUser {
        public float alpha = 1.0f;
        public int audioChannel;
        public int height;
        public int uid;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f١٤٩٤٩x;

        /* renamed from: y, reason: collision with root package name */
        public int f١٤٩٥٠y;
        public int zOrder;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum VideoCodecProfileType {
        BASELINE(66),
        MAIN(77),
        HIGH(100);

        private int value;

        VideoCodecProfileType(int i10) {
            this.value = i10;
        }

        public static int getValue(VideoCodecProfileType videoCodecProfileType) {
            return videoCodecProfileType.value;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum VideoCodecType {
        H264(1),
        H265(2);

        private int value;

        VideoCodecType(int i10) {
            this.value = i10;
        }

        public static int getValue(VideoCodecType videoCodecType) {
            return videoCodecType.value;
        }
    }

    public void addBackgroundImage(AgoraImage agoraImage) {
        if (this.backgroundImageList == null) {
            this.backgroundImageList = new ArrayList<>();
        }
        this.backgroundImageList.add(agoraImage);
    }

    public int addUser(TranscodingUser transcodingUser) {
        int i10;
        if (transcodingUser != null && (i10 = transcodingUser.uid) != 0) {
            this.transcodingUsers.put(Integer.valueOf(i10), transcodingUser);
            this.userCount = this.transcodingUsers.size();
            return 0;
        }
        return -2;
    }

    public void addWatermark(AgoraImage agoraImage) {
        if (this.watermarkList == null) {
            this.watermarkList = new ArrayList<>();
        }
        this.watermarkList.add(agoraImage);
    }

    public Map<String, Boolean> getAdvancedFeatures() {
        return this.advancedFeatures;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public ArrayList<AgoraImage> getBackgroundImageList() {
        return this.backgroundImageList;
    }

    @Deprecated
    public int getBlue() {
        return this.backgroundColor & KotlinVersion.MAX_COMPONENT_VALUE;
    }

    @Deprecated
    public int getGreen() {
        return (this.backgroundColor >> 8) & KotlinVersion.MAX_COMPONENT_VALUE;
    }

    @Deprecated
    public int getRed() {
        return (this.backgroundColor >> 16) & KotlinVersion.MAX_COMPONENT_VALUE;
    }

    public int getUserCount() {
        return this.transcodingUsers.size();
    }

    public final ArrayList<TranscodingUser> getUsers() {
        return new ArrayList<>(this.transcodingUsers.values());
    }

    public ArrayList<AgoraImage> getWatermarkList() {
        return this.watermarkList;
    }

    public boolean removeBackgroundImage(AgoraImage agoraImage) {
        ArrayList<AgoraImage> arrayList = this.backgroundImageList;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(agoraImage);
    }

    public int removeUser(int i10) {
        if (!this.transcodingUsers.containsKey(Integer.valueOf(i10))) {
            return -2;
        }
        this.transcodingUsers.remove(Integer.valueOf(i10));
        this.userCount = this.transcodingUsers.size();
        return 0;
    }

    public boolean removeWatermark(AgoraImage agoraImage) {
        ArrayList<AgoraImage> arrayList = this.watermarkList;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(agoraImage);
    }

    public void setAdvancedFeatures(String str, Boolean bool) {
        this.advancedFeatures.put(str, bool);
    }

    public void setBackgroundColor(int i10) {
        this.backgroundColor = i10;
    }

    @Deprecated
    public void setBlue(int i10) {
        this.backgroundColor = i10 | (getRed() << 16) | (getGreen() << 8);
    }

    @Deprecated
    public void setGreen(int i10) {
        int i11 = i10 << 8;
        this.backgroundColor = i11 | (getRed() << 16) | getBlue();
    }

    @Deprecated
    public void setRed(int i10) {
        this.backgroundColor = (i10 << 16) | (getGreen() << 8) | getBlue();
    }

    public void setUsers(ArrayList<TranscodingUser> arrayList) {
        this.transcodingUsers.clear();
        if (arrayList != null) {
            Iterator<TranscodingUser> it = arrayList.iterator();
            while (it.hasNext()) {
                TranscodingUser next = it.next();
                this.transcodingUsers.put(Integer.valueOf(next.uid), next);
            }
        }
        this.userCount = this.transcodingUsers.size();
    }

    public void setBackgroundColor(int i10, int i11, int i12) {
        this.backgroundColor = (i10 << 16) | (i11 << 8) | i12;
    }

    public void setUsers(Map<Integer, TranscodingUser> map) {
        this.transcodingUsers.clear();
        if (map != null) {
            this.transcodingUsers.putAll(map);
        }
        this.userCount = this.transcodingUsers.size();
    }
}
