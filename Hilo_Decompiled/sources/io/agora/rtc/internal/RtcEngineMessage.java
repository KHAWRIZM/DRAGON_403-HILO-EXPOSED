package io.agora.rtc.internal;

import android.text.TextUtils;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.models.ContentInspectConfig;
import io.agora.rtc.video.AgoraImage;
import io.agora.rtc.video.ChannelMediaInfo;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class RtcEngineMessage {
    public static short AGORA_UI_SERVER;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class MediaAppContext extends Marshallable {
        MediaNetworkInfo networkInfo;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            MediaNetworkInfo mediaNetworkInfo = this.networkInfo;
            if (mediaNetworkInfo != null) {
                mediaNetworkInfo.marshall(this);
            }
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class MediaNetworkInfo extends Marshallable {
        int asu;
        int frequency;
        int linkspeed;
        int networkSubtype;
        int networkType;
        int rssi;
        int signalLevel;
        String localIp4 = "";
        String gatewayIp4 = "";
        String localIp6 = "";
        String gatewayIp6 = "";
        String ssid = "";
        String bssid = "";
        ArrayList<String> dnsList = null;
        ArrayList<String> ifconfigs = null;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        public void marshall(Marshallable marshallable) {
            marshallable.pushBytes(this.localIp4.getBytes());
            marshallable.pushBytes(this.gatewayIp4.getBytes());
            marshallable.pushBytes(this.localIp6.getBytes());
            marshallable.pushBytes(this.gatewayIp6.getBytes());
            marshallable.pushInt(this.networkType);
            marshallable.pushInt(this.networkSubtype);
            marshallable.pushInt(this.signalLevel);
            marshallable.pushInt(this.rssi);
            marshallable.pushInt(this.asu);
            marshallable.pushInt(this.frequency);
            marshallable.pushInt(this.linkspeed);
            String str = this.ssid;
            if (str != null && (str instanceof String)) {
                marshallable.pushBytes(str.getBytes());
            } else {
                marshallable.pushBytes("".getBytes());
            }
            String str2 = this.bssid;
            if (str2 != null) {
                marshallable.pushBytes(str2.getBytes());
            } else {
                marshallable.pushBytes("".getBytes());
            }
            ArrayList<String> arrayList = this.dnsList;
            if (arrayList != null) {
                marshallable.pushStringArray(arrayList);
            } else {
                marshallable.pushStringArray(new ArrayList<>());
            }
            ArrayList<String> arrayList2 = this.ifconfigs;
            if (arrayList2 != null) {
                marshallable.pushStringArray(arrayList2);
            } else {
                marshallable.pushStringArray(new ArrayList<>());
            }
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            marshall(this);
            return super.marshall();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class MediaResSetupTime extends Marshallable {
        int elapsed;
        boolean firstSuccess;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.elapsed = popInt();
            this.firstSuccess = popBool().booleanValue();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PActiveSpeaker extends Marshallable {
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PAndroidContextInfo extends Marshallable {
        public String androidID;
        public String configDir;
        public String dataDir;
        public String device;
        public String deviceInfo;
        public String pluginDir;
        public String systemInfo;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.device.getBytes());
            pushBytes(this.deviceInfo.getBytes());
            pushBytes(this.systemInfo.getBytes());
            pushBytes(this.configDir.getBytes());
            pushBytes(this.dataDir.getBytes());
            pushBytes(this.pluginDir.getBytes());
            pushBytes(this.androidID.getBytes());
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.device = popString16UTF8();
            this.deviceInfo = popString16UTF8();
            this.systemInfo = popString16UTF8();
            this.configDir = popString16UTF8();
            this.dataDir = popString16UTF8();
            this.pluginDir = popString16UTF8();
            this.androidID = popString16UTF8();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PApiCallExecuted extends Marshallable {
        public String api;
        public int error;
        public String result;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.error = popInt();
            this.api = popString16UTF8();
            this.result = popString16UTF8();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PAudioFileInfo extends Marshallable {
        public int durationMs;
        public int error;
        public String filePath;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.filePath = popString16UTF8();
            this.durationMs = popInt();
            this.error = popInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PAudioRoutingChanged extends Marshallable {
        int routing;

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.routing = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PCameraExposureAreaChanged extends Marshallable {
        public int height;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f١٤٩٤٣x;

        /* renamed from: y, reason: collision with root package name */
        public int f١٤٩٤٤y;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.f١٤٩٤٣x);
            pushInt(this.f١٤٩٤٤y);
            pushInt(this.width);
            pushInt(this.height);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.f١٤٩٤٣x = popInt();
            this.f١٤٩٤٤y = popInt();
            this.width = popInt();
            this.height = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PCameraFocusAreaChanged extends Marshallable {
        public int height;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f١٤٩٤٥x;

        /* renamed from: y, reason: collision with root package name */
        public int f١٤٩٤٦y;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.f١٤٩٤٥x);
            pushInt(this.f١٤٩٤٦y);
            pushInt(this.width);
            pushInt(this.height);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.f١٤٩٤٥x = popInt();
            this.f١٤٩٤٦y = popInt();
            this.width = popInt();
            this.height = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PChannelMediaRelayConfiguration extends Marshallable {
        private void marshallChannelInfo(Marshallable marshallable, ChannelMediaInfo channelMediaInfo) {
            marshallable.pushString16(channelMediaInfo.channelName);
            marshallable.pushString16(channelMediaInfo.token);
            marshallable.pushInt(channelMediaInfo.uid);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }

        private void marshall(Marshallable marshallable, ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
            marshallChannelInfo(marshallable, channelMediaRelayConfiguration.getSrcChannelMediaInfo());
            pushShort((short) channelMediaRelayConfiguration.getDestChannelMediaInfos().size());
            Iterator<String> it = channelMediaRelayConfiguration.getDestChannelMediaInfos().keySet().iterator();
            while (it.hasNext()) {
                marshallChannelInfo(marshallable, channelMediaRelayConfiguration.getDestChannelMediaInfos().get(it.next()));
            }
        }

        public byte[] marshall(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
            marshall(this, channelMediaRelayConfiguration);
            return super.marshall();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PClientRoleChangeFailed extends Marshallable {
        public int currentRole;
        public int reason;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.reason = popInt();
            this.currentRole = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PClientRoleChanged extends Marshallable {
        int newRole;
        int oldRole;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.oldRole = popInt();
            this.newRole = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PConnectionState extends Marshallable {
        public int reason;
        public int state;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.state);
            pushInt(this.reason);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popInt();
            this.reason = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PContentInspectConfig extends Marshallable {
        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }

        private void marshall(Marshallable marshallable, ContentInspectConfig contentInspectConfig) {
            int i10;
            if (contentInspectConfig == null || (i10 = contentInspectConfig.moduleCount) <= 0 || i10 > 32) {
                return;
            }
            marshallable.pushString16(contentInspectConfig.extraInfo);
            pushShort((short) contentInspectConfig.moduleCount);
            for (int i11 = 0; i11 < contentInspectConfig.moduleCount; i11++) {
                marshallable.pushInt(contentInspectConfig.modules[i11].type);
                marshallable.pushInt(contentInspectConfig.modules[i11].interval);
            }
        }

        public byte[] marshall(ContentInspectConfig contentInspectConfig) {
            marshall(this, contentInspectConfig);
            return super.marshall();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PContentInspectResult extends Marshallable {
        public int result;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.result);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.result = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PCrossChannelEvent extends Marshallable {
        public int code;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.code);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.code = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PCrossChannelState extends Marshallable {
        public int code;
        public int state;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.state);
            pushInt(this.code);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popInt();
            this.code = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PError extends Marshallable {
        public int err;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.err = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFaceDetectValue extends Marshallable {
        public int imageHeight;
        public int imageWidth;
        public int num;
        FaceRect[] rectArr = null;
        int[] disArr = null;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static class FaceRect {
            public int height;
            public int width;

            /* renamed from: x, reason: collision with root package name */
            public int f١٤٩٤٧x;

            /* renamed from: y, reason: collision with root package name */
            public int f١٤٩٤٨y;
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.imageWidth = popInt();
            this.imageHeight = popInt();
            int popShort = popShort();
            if (popShort > 0) {
                this.rectArr = new FaceRect[popShort];
                for (int i10 = 0; i10 < popShort; i10++) {
                    this.rectArr[i10] = new FaceRect();
                    this.rectArr[i10].f١٤٩٤٧x = popInt();
                    this.rectArr[i10].f١٤٩٤٨y = popInt();
                    this.rectArr[i10].width = popInt();
                    this.rectArr[i10].height = popInt();
                }
            }
            int popShort2 = popShort();
            if (popShort2 > 0) {
                this.disArr = new int[popShort2];
                for (int i11 = 0; i11 < popShort2; i11++) {
                    this.disArr[i11] = popInt();
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFirstLocalAudioFrame extends Marshallable {
        public int elapsed;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFirstLocalAudioFramePublished extends Marshallable {
        public int elapsed;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFirstLocalVideoFrame extends Marshallable {
        public int elapsed;
        public int height;
        public int width;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.width = popInt();
            this.height = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFirstLocalVideoFramePublished extends Marshallable {
        public int elapsed;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFirstRemoteAudioFrame extends Marshallable {
        public int elapsed;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFirstRemoteVideoDecoded extends Marshallable {
        public int elapsed;
        public int height;
        public int uid;
        public int width;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.width = popInt();
            this.height = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PFirstRemoteVideoFrame extends Marshallable {
        public int elapsed;
        public int height;
        public int uid;
        public int width;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.width = popInt();
            this.height = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PHostInRequest extends Marshallable {
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PHostInResponse extends Marshallable {
        public boolean accepted;
        public int error;
        public int ownerUid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.ownerUid = popInt();
            this.accepted = popBool().booleanValue();
            this.error = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PHostInStopped extends Marshallable {
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PInjectStreamConfig extends Marshallable {
        private static final short SERVER_TYPE = 0;
        private static final short URI = 25;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }

        private void marshall(Marshallable marshallable, LiveInjectStreamConfig liveInjectStreamConfig) {
            marshallable.pushShort((short) 0);
            marshallable.pushShort(URI);
            marshallable.pushInt(liveInjectStreamConfig.width);
            marshallable.pushInt(liveInjectStreamConfig.height);
            marshallable.pushInt(liveInjectStreamConfig.videoGop);
            marshallable.pushInt(liveInjectStreamConfig.videoFramerate);
            marshallable.pushInt(liveInjectStreamConfig.videoBitrate);
            marshallable.pushInt(LiveInjectStreamConfig.AudioSampleRateType.getValue(liveInjectStreamConfig.audioSampleRate));
            marshallable.pushInt(liveInjectStreamConfig.audioBitrate);
            marshallable.pushInt(liveInjectStreamConfig.audioChannels);
        }

        public byte[] marshall(LiveInjectStreamConfig liveInjectStreamConfig) {
            marshall(this, liveInjectStreamConfig);
            return super.marshall();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PLiveTranscoding extends Marshallable {
        private static final short SERVER_TYPE = 0;
        private static final short URI = 23;

        private void marshallImage(Marshallable marshallable, AgoraImage agoraImage) {
            marshallable.pushString16(agoraImage.url);
            marshallable.pushInt(agoraImage.f١٤٩٥٢x);
            marshallable.pushInt(agoraImage.f١٤٩٥٣y);
            marshallable.pushInt(agoraImage.width);
            marshallable.pushInt(agoraImage.height);
            marshallable.pushInt(agoraImage.zOrder);
            marshallable.pushDouble(agoraImage.alpha);
        }

        private void marshallUserConfig(Marshallable marshallable, LiveTranscoding.TranscodingUser transcodingUser) {
            marshallable.pushInt(transcodingUser.uid);
            marshallable.pushInt(transcodingUser.f١٤٩٤٩x);
            marshallable.pushInt(transcodingUser.f١٤٩٥٠y);
            marshallable.pushInt(transcodingUser.width);
            marshallable.pushInt(transcodingUser.height);
            marshallable.pushInt(transcodingUser.zOrder);
            marshallable.pushDouble(transcodingUser.alpha);
            marshallable.pushInt(transcodingUser.audioChannel);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
        }

        private void marshall(Marshallable marshallable, LiveTranscoding liveTranscoding) {
            marshallable.pushShort((short) 0);
            marshallable.pushShort(URI);
            marshallable.pushInt(liveTranscoding.width);
            marshallable.pushInt(liveTranscoding.height);
            marshallable.pushInt(liveTranscoding.videoGop);
            marshallable.pushInt(liveTranscoding.videoFramerate);
            marshallable.pushInt(LiveTranscoding.VideoCodecProfileType.getValue(liveTranscoding.videoCodecProfile));
            marshallable.pushInt(LiveTranscoding.VideoCodecType.getValue(liveTranscoding.videoCodecType));
            marshallable.pushInt(liveTranscoding.videoBitrate);
            if (liveTranscoding.watermark == null) {
                liveTranscoding.watermark = new AgoraImage();
            }
            marshallImage(marshallable, liveTranscoding.watermark);
            if (liveTranscoding.backgroundImage == null) {
                liveTranscoding.backgroundImage = new AgoraImage();
            }
            marshallImage(marshallable, liveTranscoding.backgroundImage);
            ArrayList arrayList = new ArrayList();
            if (liveTranscoding.getWatermarkList() != null && !liveTranscoding.getWatermarkList().isEmpty()) {
                arrayList.addAll(liveTranscoding.getWatermarkList());
            }
            pushShort((short) arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                marshallImage(marshallable, (AgoraImage) it.next());
            }
            ArrayList arrayList2 = new ArrayList();
            if (liveTranscoding.getBackgroundImageList() != null && !liveTranscoding.getBackgroundImageList().isEmpty()) {
                arrayList2.addAll(liveTranscoding.getBackgroundImageList());
            }
            pushShort((short) arrayList2.size());
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                marshallImage(marshallable, (AgoraImage) it2.next());
            }
            marshallable.pushBool(Boolean.valueOf(liveTranscoding.lowLatency));
            marshallable.pushInt(LiveTranscoding.AudioSampleRateType.getValue(liveTranscoding.audioSampleRate));
            marshallable.pushInt(liveTranscoding.audioBitrate);
            marshallable.pushInt(liveTranscoding.audioChannels);
            marshallable.pushInt(LiveTranscoding.AudioCodecProfileType.getValue(liveTranscoding.audioCodecProfile));
            marshallable.pushInt(liveTranscoding.backgroundColor & 16777215);
            if (TextUtils.isEmpty(liveTranscoding.userConfigExtraInfo)) {
                liveTranscoding.userConfigExtraInfo = "";
            }
            marshallable.pushString16(liveTranscoding.userConfigExtraInfo);
            if (TextUtils.isEmpty(liveTranscoding.metadata)) {
                liveTranscoding.metadata = "";
            }
            marshallable.pushString16(liveTranscoding.metadata);
            if (liveTranscoding.getUsers() != null && liveTranscoding.getUsers().size() > 0) {
                pushShort((short) liveTranscoding.getUserCount());
                Iterator<LiveTranscoding.TranscodingUser> it3 = liveTranscoding.getUsers().iterator();
                while (it3.hasNext()) {
                    marshallUserConfig(marshallable, it3.next());
                }
            } else {
                pushShort((short) 0);
            }
            pushShort((short) liveTranscoding.getAdvancedFeatures().size());
            for (Map.Entry<String, Boolean> entry : liveTranscoding.getAdvancedFeatures().entrySet()) {
                marshallable.pushString16(entry.getKey());
                marshallable.pushBool(entry.getValue());
            }
        }

        public byte[] marshall(LiveTranscoding liveTranscoding) {
            marshall(this, liveTranscoding);
            return super.marshall();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PLocalAudioEnabled extends Marshallable {
        boolean enabled;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.enabled = popBool().booleanValue();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PLocalAudioStat extends Marshallable {
        public IRtcEngineEventHandler.LocalAudioStats stats = new IRtcEngineEventHandler.LocalAudioStats();

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.stats.numChannels);
            pushInt(this.stats.sentSampleRate);
            pushInt(this.stats.sentBitrate);
            pushShort((short) this.stats.txPacketLossRate);
            pushDouble(this.stats.musicProbability);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.stats.numChannels = popInt();
            this.stats.sentSampleRate = popInt();
            this.stats.sentBitrate = popInt();
            this.stats.txPacketLossRate = popShort();
            this.stats.musicProbability = (float) popDouble();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PLocalFallbackStatus extends Marshallable {
        boolean state;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popBool().booleanValue();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PLocalVideoStat extends Marshallable {
        public IRtcEngineEventHandler.LocalVideoStats stats = new IRtcEngineEventHandler.LocalVideoStats();

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.stats.sentBitrate);
            pushInt(this.stats.sentFrameRate);
            pushInt(this.stats.encoderOutputFrameRate);
            pushInt(this.stats.rendererOutputFrameRate);
            pushInt(this.stats.targetBitrate);
            pushInt(this.stats.targetFrameRate);
            pushInt(this.stats.qualityAdaptIndication);
            pushInt(this.stats.encodedBitrate);
            pushInt(this.stats.encodedFrameWidth);
            pushInt(this.stats.encodedFrameHeight);
            pushInt(this.stats.encodedFrameCount);
            pushByte((byte) this.stats.codecType);
            pushShort((short) this.stats.txPacketLossRate);
            pushInt(this.stats.captureFrameRate);
            pushByte((byte) this.stats.captureBrightnessLevel);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.stats.sentBitrate = popInt();
            this.stats.sentFrameRate = popInt();
            this.stats.encoderOutputFrameRate = popInt();
            this.stats.rendererOutputFrameRate = popInt();
            this.stats.targetBitrate = popInt();
            this.stats.targetFrameRate = popInt();
            this.stats.qualityAdaptIndication = popInt();
            this.stats.encodedBitrate = popInt();
            this.stats.encodedFrameWidth = popInt();
            this.stats.encodedFrameHeight = popInt();
            this.stats.encodedFrameCount = popInt();
            this.stats.codecType = popByte();
            this.stats.txPacketLossRate = popShort();
            this.stats.captureFrameRate = popInt();
            this.stats.captureBrightnessLevel = popByte();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PLocalVoicePitch extends Marshallable {
        public int pitchInHz;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.pitchInHz);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.pitchInHz = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaEngineEvent extends Marshallable {
        int code;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.code = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaReqConnectMedia2 extends Marshallable {
        public static final int uri = 66453504 | RtcEngineMessage.AGORA_UI_SERVER;
        String connInfo;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.connInfo.getBytes());
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaReqCreateChannel extends Marshallable {
        public static final int uri = 131072 | RtcEngineMessage.AGORA_UI_SERVER;
        String key;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.key.getBytes());
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaReqJoinMeida extends Marshallable {
        public static final int uri = 196608 | RtcEngineMessage.AGORA_UI_SERVER;
        int sid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.sid);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaReqLeaveChannel extends Marshallable {
        public static final int uri = 393216 | RtcEngineMessage.AGORA_UI_SERVER;
        int sid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.sid);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaReqLeaveLinkd extends Marshallable {
        public static final int uri = 262144 | RtcEngineMessage.AGORA_UI_SERVER;
        int sid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.sid);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaReqUserData extends Marshallable {
        public static final int uri = 327680 | RtcEngineMessage.AGORA_UI_SERVER;
        String key;
        String mobileinfo;
        int uid;
        String username;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.key.getBytes());
            pushBytes(this.username.getBytes());
            pushBytes(this.mobileinfo.getBytes());
            pushInt(this.uid);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResAudioEffectFinished extends Marshallable {
        int soundId;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.soundId = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResAudioQuality extends Marshallable {
        short delay;
        short lost;
        int peer_uid;
        int quality;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.peer_uid = popInt();
            this.quality = popInt();
            this.delay = popShort();
            this.lost = popShort();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResFirstRemoteAudioDecoded extends Marshallable {
        public int elapsed;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResJoinMedia extends Marshallable {
        public String channel;
        public int elapsed;
        public boolean firstSuccess;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.uid = popInt();
            this.elapsed = popInt();
            this.firstSuccess = popBool().booleanValue();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResLastmileProbeResult extends Marshallable {
        LastmileProbeOneWayResult downlinkReport;
        int rtt;
        short state;
        LastmileProbeOneWayResult uplinkReport;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static class LastmileProbeOneWayResult {
            public int availableBandwidth;
            public int jitter;
            public int packetLossRate;
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushShort(this.state);
            pushInt(this.uplinkReport.packetLossRate);
            pushInt(this.uplinkReport.jitter);
            pushInt(this.uplinkReport.availableBandwidth);
            pushInt(this.downlinkReport.packetLossRate);
            pushInt(this.downlinkReport.jitter);
            pushInt(this.downlinkReport.availableBandwidth);
            pushInt(this.rtt);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popShort();
            this.uplinkReport = new LastmileProbeOneWayResult();
            this.downlinkReport = new LastmileProbeOneWayResult();
            this.uplinkReport.packetLossRate = popInt();
            this.uplinkReport.jitter = popInt();
            this.uplinkReport.availableBandwidth = popInt();
            this.downlinkReport.packetLossRate = popInt();
            this.downlinkReport.jitter = popInt();
            this.downlinkReport.availableBandwidth = popInt();
            this.rtt = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResLastmileQuality extends Marshallable {
        int quality;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.quality = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResLocalAudioStateChanged extends Marshallable {
        int error;
        int state;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.state = popInt();
            this.error = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResLocalVideoStateChanged extends Marshallable {
        int error;
        int localVideoState;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.localVideoState = popInt();
            this.error = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResNetworkQuality extends Marshallable {
        int rxQuality;
        int txQuality;
        int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.txQuality = popInt();
            this.rxQuality = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResRtcStats extends Marshallable {
        int cpuAppUsage;
        int cpuTotalUsage;
        int gatewayRtt;
        int lastmileDelay;
        int memoryAppUsageInKbytes;
        int memoryAppUsageRatio;
        int memoryTotalUsageRatio;
        int rxAudioBytes;
        int rxAudioKBitRate;
        int rxKBitRate;
        int rxPacketLossRate;
        int rxVideoBytes;
        int rxVideoKBitRate;
        int totalDuration;
        int totalRxBytes;
        int totalTxBytes;
        int txAudioBytes;
        int txAudioKBitRate;
        int txKBitRate;
        int txPacketLossRate;
        int txVideoBytes;
        int txVideoKBitRate;
        int users;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.totalDuration = popInt();
            this.totalTxBytes = popInt();
            this.totalRxBytes = popInt();
            this.txAudioBytes = popInt();
            this.rxAudioBytes = popInt();
            this.txVideoBytes = popInt();
            this.rxVideoBytes = popInt();
            this.txKBitRate = popShort();
            this.rxKBitRate = popShort();
            this.txAudioKBitRate = popShort();
            this.rxAudioKBitRate = popShort();
            this.txVideoKBitRate = popShort();
            this.rxVideoKBitRate = popShort();
            this.lastmileDelay = popShort();
            this.txPacketLossRate = popShort();
            this.rxPacketLossRate = popShort();
            this.cpuTotalUsage = popInt();
            this.cpuAppUsage = popInt();
            this.users = popInt();
            this.gatewayRtt = popInt();
            this.memoryTotalUsageRatio = popInt();
            this.memoryAppUsageRatio = popInt();
            this.memoryAppUsageInKbytes = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResSpeakersReport extends Marshallable {
        int mixVolume;
        Speaker[] speakers;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static class Speaker {
            public String channelId;
            public int uid;
            public int vad;
            public int volume;
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.mixVolume);
            int length = this.speakers.length;
            pushShort((short) length);
            for (int i10 = 0; i10 < length; i10++) {
                pushInt(this.speakers[i10].uid);
                pushInt(this.speakers[i10].volume);
                pushInt(this.speakers[i10].vad);
                pushString16(this.speakers[i10].channelId);
            }
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.mixVolume = popInt();
            int popShort = popShort();
            if (popShort > 0) {
                this.speakers = new Speaker[popShort];
                for (int i10 = 0; i10 < popShort; i10++) {
                    this.speakers[i10] = new Speaker();
                    this.speakers[i10].uid = popInt();
                    this.speakers[i10].volume = popInt();
                    this.speakers[i10].vad = popInt();
                    this.speakers[i10].channelId = popString16UTF8();
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResTransportQuality extends Marshallable {
        public int bitrate;
        public short delay;
        public boolean isAudio;
        public short lost;
        public int peer_uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.isAudio = popBool().booleanValue();
            this.peer_uid = popInt();
            this.bitrate = popInt();
            this.delay = popShort();
            this.lost = popShort();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResUserJoinedEvent extends Marshallable {
        int elapsed;
        int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResUserOfflineEvent extends Marshallable {
        int reason;
        int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.reason = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResUserState extends Marshallable {
        boolean state;
        int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.state = popBool().booleanValue();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResWlAccMessage extends Marshallable {
        int action;
        int reason;
        public String wlAccMsg;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.reason);
            pushInt(this.action);
            pushString16(this.wlAccMsg);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.reason = popInt();
            this.action = popInt();
            this.wlAccMsg = popString16UTF8();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PMediaResWlAccStats extends Marshallable {
        short e2eDelayPercentAve;
        short e2eDelayPercentCur;
        short frozenRatioPercentAve;
        short frozenRatioPercentCur;
        short lossRatePercentAve;
        short lossRatePercentCur;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushShort(this.e2eDelayPercentCur);
            pushShort(this.frozenRatioPercentCur);
            pushShort(this.lossRatePercentCur);
            pushShort(this.e2eDelayPercentAve);
            pushShort(this.frozenRatioPercentAve);
            pushShort(this.lossRatePercentAve);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.e2eDelayPercentCur = popShort();
            this.frozenRatioPercentCur = popShort();
            this.lossRatePercentCur = popShort();
            this.e2eDelayPercentAve = popShort();
            this.frozenRatioPercentAve = popShort();
            this.lossRatePercentAve = popShort();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PNetworkTypeChanged extends Marshallable {
        public int type;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.type);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.type = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PPrivilegeWillExpire extends Marshallable {
        public String token;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.token.getBytes());
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.token = popString16UTF8();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PProxyConnect extends Marshallable {
        public String channel;
        public int elapsed;
        public String localProxyIp;
        public int proxyType;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.channel.getBytes());
            pushInt(this.uid);
            pushInt(this.proxyType);
            pushBytes(this.localProxyIp.getBytes());
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.uid = popInt();
            this.proxyType = popInt();
            this.localProxyIp = popString16UTF8();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PPublishAudioState extends Marshallable {
        public String channel;
        public int elapsed;
        public int newstate;
        public int oldstate;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.channel.getBytes());
            pushInt(this.oldstate);
            pushInt(this.newstate);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.oldstate = popInt();
            this.newstate = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PPublishVideoState extends Marshallable {
        public String channel;
        public int elapsed;
        public int newstate;
        public int oldstate;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.channel.getBytes());
            pushInt(this.oldstate);
            pushInt(this.newstate);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.oldstate = popInt();
            this.newstate = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PRemoteAudioStat extends Marshallable {
        public IRtcEngineEventHandler.RemoteAudioStats stats = new IRtcEngineEventHandler.RemoteAudioStats();

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.stats.uid);
            pushInt(this.stats.quality);
            pushInt(this.stats.networkTransportDelay);
            pushInt(this.stats.jitterBufferDelay);
            pushInt(this.stats.audioLossRate);
            pushInt(this.stats.numChannels);
            pushInt(this.stats.receivedSampleRate);
            pushInt(this.stats.receivedBitrate);
            pushInt(this.stats.totalFrozenTime);
            pushInt(this.stats.frozenRate);
            pushInt(this.stats.totalActiveTime);
            pushInt(this.stats.publishDuration);
            pushInt(this.stats.qoeQuality);
            pushInt(this.stats.qualityChangedReason);
            pushInt(this.stats.mosValue);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.stats.uid = popInt();
            this.stats.quality = popInt();
            this.stats.networkTransportDelay = popInt();
            this.stats.jitterBufferDelay = popInt();
            this.stats.audioLossRate = popInt();
            this.stats.numChannels = popInt();
            this.stats.receivedSampleRate = popInt();
            this.stats.receivedBitrate = popInt();
            this.stats.totalFrozenTime = popInt();
            this.stats.frozenRate = popInt();
            this.stats.totalActiveTime = popInt();
            this.stats.publishDuration = popInt();
            this.stats.qoeQuality = popInt();
            this.stats.qualityChangedReason = popInt();
            this.stats.mosValue = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PRemoteAudioState extends Marshallable {
        public int elapsed;
        public int reason;
        public int state;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.state);
            pushInt(this.reason);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.state = popInt();
            this.reason = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PRemoteVideoStat extends Marshallable {
        public IRtcEngineEventHandler.RemoteVideoStats stats = new IRtcEngineEventHandler.RemoteVideoStats();

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.stats.uid);
            pushInt(this.stats.delay);
            pushInt(this.stats.width);
            pushInt(this.stats.height);
            pushInt(this.stats.receivedBitrate);
            pushInt(this.stats.decoderOutputFrameRate);
            pushInt(this.stats.rendererOutputFrameRate);
            pushInt(this.stats.packetLossRate);
            pushInt(this.stats.rxStreamType);
            pushInt(this.stats.totalFrozenTime);
            pushInt(this.stats.frozenRate);
            pushInt(this.stats.totalActiveTime);
            pushInt(this.stats.publishDuration);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.stats.uid = popInt();
            this.stats.delay = popInt();
            this.stats.width = popInt();
            this.stats.height = popInt();
            this.stats.receivedBitrate = popInt();
            this.stats.decoderOutputFrameRate = popInt();
            this.stats.rendererOutputFrameRate = popInt();
            this.stats.packetLossRate = popInt();
            this.stats.rxStreamType = popInt();
            this.stats.totalFrozenTime = popInt();
            this.stats.frozenRate = popInt();
            this.stats.totalActiveTime = popInt();
            this.stats.publishDuration = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PRemoteVideoStateExt extends Marshallable {
        public int elapsed;
        public int reason;
        public int state;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.state);
            pushInt(this.reason);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.state = popByte();
            this.reason = popByte();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PRtmpStreamingState extends Marshallable {
        public int error;
        public int state;
        public String url;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.state = popInt();
            this.error = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PSnapshotTaken extends Marshallable {
        public String channel;
        public int errCode;
        public String filepath;
        public int height;
        public int uid;
        public int width;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.channel.getBytes());
            pushInt(this.uid);
            pushBytes(this.filepath.getBytes());
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.errCode);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.uid = popInt();
            this.filepath = popString16UTF8();
            this.width = popInt();
            this.height = popInt();
            this.errCode = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PStreamEvent extends Marshallable {
        public int error;
        public String url;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.error = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PStreamInjectedStatus extends Marshallable {
        public int status;
        public int uid;
        public String url;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.url.getBytes());
            pushInt(this.uid);
            pushInt(this.status);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.uid = popInt();
            this.status = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PStreamMessage extends Marshallable {
        byte[] payload;
        int streamId;
        int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.streamId = popInt();
            this.payload = popBytes();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PStreamMessageError extends Marshallable {
        int cached;
        int error;
        int missed;
        int streamId;
        int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.streamId = popInt();
            this.error = popInt();
            this.missed = popInt();
            this.cached = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PStreamPublished extends Marshallable {
        public int error;
        public String url;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
            this.error = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PStreamUnPublished extends Marshallable {
        public String url;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.url = popString16UTF8();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PSubscribeAudioState extends Marshallable {
        public String channel;
        public int elapsed;
        public int newstate;
        public int oldstate;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.channel.getBytes());
            pushInt(this.uid);
            pushInt(this.oldstate);
            pushInt(this.newstate);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.uid = popInt();
            this.oldstate = popInt();
            this.newstate = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PSubscribeVideoState extends Marshallable {
        public String channel;
        public int elapsed;
        public int newstate;
        public int oldstate;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBytes(this.channel.getBytes());
            pushInt(this.uid);
            pushInt(this.oldstate);
            pushInt(this.newstate);
            pushInt(this.elapsed);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.channel = popString16UTF8();
            this.uid = popInt();
            this.oldstate = popInt();
            this.newstate = popInt();
            this.elapsed = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PUploadLogResult extends Marshallable {
        public int reason;
        public String requestId;
        public boolean success;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.requestId = popString16();
            this.success = popBool().booleanValue();
            this.reason = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PUserAccountInfo extends Marshallable {
        public int uid;
        public String userAccount;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushBytes(this.userAccount.getBytes());
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.userAccount = popString16UTF8();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PUserSuperResolutionEnabled extends Marshallable {
        public boolean enabled;
        public int reason;
        public int uid;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushBool(Boolean.valueOf(this.enabled));
            pushInt(this.reason);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.enabled = popBool().booleanValue();
            this.reason = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PUserTransportStat extends Marshallable {
        public int delay;
        public boolean isAudio;
        public int lost;
        public int peer_uid;
        public int rxKBitRate;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.isAudio = popBool().booleanValue();
            this.peer_uid = popInt();
            this.delay = popShort();
            this.lost = popShort();
            this.rxKBitRate = popShort();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PVideoNetOptions extends Marshallable {
        short bitrate;
        short frameRate;
        short height;
        short width;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        public void marshall(Marshallable marshallable) {
            marshallable.pushShort(this.width);
            marshallable.pushShort(this.height);
            marshallable.pushShort(this.frameRate);
            marshallable.pushShort(this.bitrate);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.width = popShort();
            this.height = popShort();
            this.frameRate = popShort();
            this.bitrate = popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            marshall(this);
            return super.marshall();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PVideoSizeChanged extends Marshallable {
        public int height;
        public int rotation;
        public int uid;
        public int width;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushInt(this.uid);
            pushInt(this.width);
            pushInt(this.height);
            pushInt(this.rotation);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.uid = popInt();
            this.width = popInt();
            this.height = popInt();
            this.rotation = popInt();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class PVirtualBackgroundSourceEnabled extends Marshallable {
        public boolean enabled;
        public int reason;

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void clear() {
            super.clear();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void marshall(ByteBuffer byteBuffer) {
            super.marshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popAll() {
            return super.popAll();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ Boolean popBool() {
            return super.popBool();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte popByte() {
            return super.popByte();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes() {
            return super.popBytes();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ byte[] popBytes32() {
            return super.popBytes32();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ double popDouble() {
            return super.popDouble();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ float popFloat() {
            return super.popFloat();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int popInt() {
            return super.popInt();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ long popInt64() {
            return super.popInt64();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ int[] popIntArray() {
            return super.popIntArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short popShort() {
            return super.popShort();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ short[] popShortArray() {
            return super.popShortArray();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16() {
            return super.popString16();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ String popString16UTF8() {
            return super.popString16UTF8();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBool(Boolean bool) {
            super.pushBool(bool);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushByte(byte b10) {
            super.pushByte(b10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes(byte[] bArr) {
            super.pushBytes(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushBytes32(byte[] bArr) {
            super.pushBytes32(bArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushDouble(double d10) {
            super.pushDouble(d10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushFloat(float f10) {
            super.pushFloat(f10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt(int i10) {
            super.pushInt(i10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushInt64(long j10) {
            super.pushInt64(j10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(int[] iArr) {
            super.pushIntArray(iArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShort(short s10) {
            super.pushShort(s10);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushShortArray(short[] sArr) {
            super.pushShortArray(sArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushString16(String str) {
            super.pushString16(str);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushStringArray(ArrayList arrayList) {
            super.pushStringArray(arrayList);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void unmarshall(ByteBuffer byteBuffer) {
            super.unmarshall(byteBuffer);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public byte[] marshall() {
            pushBool(Boolean.valueOf(this.enabled));
            pushInt(this.reason);
            return super.marshall();
        }

        @Override // io.agora.rtc.internal.Marshallable
        public /* bridge */ /* synthetic */ void pushIntArray(Integer[] numArr) {
            super.pushIntArray(numArr);
        }

        @Override // io.agora.rtc.internal.Marshallable
        public void unmarshall(byte[] bArr) {
            super.unmarshall(bArr);
            this.enabled = popBool().booleanValue();
            this.reason = popInt();
        }
    }
}
