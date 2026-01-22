package com.tencent.liteav.sdk.common;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.SoLoader;

@JNINamespace("liteav::house")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HouseBuilder {
    private b mHouseBuilderListener;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum a {
        PUSHER(1),
        UGC_SIMPLE(2),
        UGC_STANDARD(4),
        PITU_SIMPLE(8),
        PITU(16),
        PLAYER_STANDARD(32),
        PLAYER_MONET(64),
        PLAYER_PREMIUM(128),
        PLAYER_ENTERPRISE(256),
        PLAYER_PROJECTION(512);

        int value;

        a(int i) {
            this.value = i;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public interface b {
        void a(int i, String str);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum c {
        LIVE,
        UGC
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum d {
        OK(0),
        ERROR_JSON_FORMAT(-1),
        ERROR_SIGNATURE(-2),
        ERROR_DECODE(-3),
        ERROR_PACKAGE(-4),
        ERROR_FEATURE(-5),
        ERROR_INNER_NOT_EXIST(-6),
        ERROR_LOCAL_NOT_EXIST(-7),
        ERROR_CONTENT_EMPTY(-8),
        ERROR_WRITE_HOUSE(-9),
        ERROR_WRITE_PITU_HOUSE(-10),
        ERROR_EXPIRED(-11),
        ERROR_DOWNLOAD(-12),
        ERROR_NO_AUTHORIZATION(-13),
        ERROR_UNKNOWN(-14);

        int value;

        d(int i) {
            this.value = i;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    static class e {
        public static HouseBuilder a = new HouseBuilder();
    }

    static {
        SoLoader.loadAllLibraries();
    }

    public static HouseBuilder getInstance() {
        return e.a;
    }

    private static native String nativeGetAppId();

    private static native String nativeGetHouse(int i);

    private static native String nativeGetKey(int i);

    private static native void nativeSetClient(HouseBuilder houseBuilder);

    private static native boolean nativeSetHouse(int i, String str, String str2);

    private static native int nativeValid(int i);

    public void OnResult(int i, String str) {
        b bVar = this.mHouseBuilderListener;
        if (bVar != null) {
            bVar.a(i, str);
        }
    }

    public String getAppId() {
        return nativeGetAppId();
    }

    public String getHouse(c cVar) {
        return nativeGetHouse(cVar.ordinal());
    }

    public String getKey(c cVar) {
        return nativeGetKey(cVar.ordinal());
    }

    public boolean setHouse(c cVar, String str, String str2) {
        return nativeSetHouse(cVar.ordinal(), str, str2);
    }

    public void setListener(b bVar) {
        this.mHouseBuilderListener = bVar;
        if (bVar != null) {
            nativeSetClient(this);
        }
    }

    public d valid(a aVar) {
        int nativeValid = nativeValid(aVar.value);
        for (d dVar : d.values()) {
            if (dVar.value == nativeValid) {
                return dVar;
            }
        }
        return d.ERROR_UNKNOWN;
    }
}
