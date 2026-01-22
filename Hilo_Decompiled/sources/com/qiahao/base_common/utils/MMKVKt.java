package com.qiahao.base_common.utils;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001\u001a$\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001\u001a$\u0010\n\u001a\u00020\u0006*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a$\u0010\u000b\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a$\u0010\f\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r\u001a$\u0010\u000e\u001a\u00020\t*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\r¨\u0006\u000f"}, d2 = {"getBoolean", "", "Lcom/tencent/mmkv/MMKV;", "mmkvID", "Lcom/qiahao/base_common/utils/MMKVID;", TransferTable.COLUMN_KEY, "", "defValue", "putBoolean", "", "getString", "putString", "getInt", "", "putInt", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MMKVKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MMKVID.values().length];
            try {
                iArr[MMKVID.COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean getBoolean(@NotNull MMKV mmkv, @NotNull MMKVID mmkvID, @NotNull String key, boolean z10) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(mmkv, "<this>");
        Intrinsics.checkNotNullParameter(mmkvID, "mmkvID");
        Intrinsics.checkNotNullParameter(key, "key");
        if (WhenMappings.$EnumSwitchMapping$0[mmkvID.ordinal()] == 1) {
            MMKV mmkvWithID = MMKV.mmkvWithID(mmkvID.name());
            if (mmkvWithID != null) {
                bool = Boolean.valueOf(mmkvWithID.getBoolean(key, z10));
            } else {
                bool = null;
            }
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        return mmkv.getBoolean(key, z10);
    }

    public static /* synthetic */ boolean getBoolean$default(MMKV mmkv, MMKVID mmkvid, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mmkvid = MMKVID.USER;
        }
        return getBoolean(mmkv, mmkvid, str, z10);
    }

    public static final int getInt(@NotNull MMKV mmkv, @NotNull MMKVID mmkvID, @NotNull String key, int i10) {
        Integer num;
        Intrinsics.checkNotNullParameter(mmkv, "<this>");
        Intrinsics.checkNotNullParameter(mmkvID, "mmkvID");
        Intrinsics.checkNotNullParameter(key, "key");
        if (WhenMappings.$EnumSwitchMapping$0[mmkvID.ordinal()] == 1) {
            MMKV mmkvWithID = MMKV.mmkvWithID(mmkvID.name());
            if (mmkvWithID != null) {
                num = Integer.valueOf(mmkvWithID.getInt(key, i10));
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            return num.intValue();
        }
        return mmkv.getInt(key, i10);
    }

    public static /* synthetic */ int getInt$default(MMKV mmkv, MMKVID mmkvid, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mmkvid = MMKVID.USER;
        }
        return getInt(mmkv, mmkvid, str, i10);
    }

    @NotNull
    public static final String getString(@NotNull MMKV mmkv, @NotNull MMKVID mmkvID, @NotNull String key, @NotNull String defValue) {
        String str;
        Intrinsics.checkNotNullParameter(mmkv, "<this>");
        Intrinsics.checkNotNullParameter(mmkvID, "mmkvID");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        if (WhenMappings.$EnumSwitchMapping$0[mmkvID.ordinal()] == 1) {
            MMKV mmkvWithID = MMKV.mmkvWithID(mmkvID.name());
            if (mmkvWithID != null) {
                str = mmkvWithID.getString(key, defValue);
            } else {
                str = null;
            }
            Intrinsics.checkNotNull(str);
            return str;
        }
        String string = mmkv.getString(key, defValue);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static /* synthetic */ String getString$default(MMKV mmkv, MMKVID mmkvid, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mmkvid = MMKVID.USER;
        }
        return getString(mmkv, mmkvid, str, str2);
    }

    public static final void putBoolean(@NotNull MMKV mmkv, @NotNull MMKVID mmkvID, @NotNull String key, boolean z10) {
        Intrinsics.checkNotNullParameter(mmkv, "<this>");
        Intrinsics.checkNotNullParameter(mmkvID, "mmkvID");
        Intrinsics.checkNotNullParameter(key, "key");
        if (WhenMappings.$EnumSwitchMapping$0[mmkvID.ordinal()] == 1) {
            MMKV mmkvWithID = MMKV.mmkvWithID(mmkvID.name());
            if (mmkvWithID != null) {
                mmkvWithID.putBoolean(key, z10);
                return;
            }
            return;
        }
        mmkv.putBoolean(key, z10);
    }

    public static /* synthetic */ void putBoolean$default(MMKV mmkv, MMKVID mmkvid, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mmkvid = MMKVID.USER;
        }
        putBoolean(mmkv, mmkvid, str, z10);
    }

    public static final void putInt(@NotNull MMKV mmkv, @NotNull MMKVID mmkvID, @NotNull String key, int i10) {
        Intrinsics.checkNotNullParameter(mmkv, "<this>");
        Intrinsics.checkNotNullParameter(mmkvID, "mmkvID");
        Intrinsics.checkNotNullParameter(key, "key");
        if (WhenMappings.$EnumSwitchMapping$0[mmkvID.ordinal()] == 1) {
            MMKV mmkvWithID = MMKV.mmkvWithID(mmkvID.name());
            if (mmkvWithID != null) {
                mmkvWithID.putInt(key, i10);
                return;
            }
            return;
        }
        mmkv.putInt(key, i10);
    }

    public static /* synthetic */ void putInt$default(MMKV mmkv, MMKVID mmkvid, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mmkvid = MMKVID.USER;
        }
        putInt(mmkv, mmkvid, str, i10);
    }

    public static final void putString(@NotNull MMKV mmkv, @NotNull MMKVID mmkvID, @NotNull String key, @NotNull String defValue) {
        Intrinsics.checkNotNullParameter(mmkv, "<this>");
        Intrinsics.checkNotNullParameter(mmkvID, "mmkvID");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defValue, "defValue");
        if (WhenMappings.$EnumSwitchMapping$0[mmkvID.ordinal()] == 1) {
            MMKV mmkvWithID = MMKV.mmkvWithID(mmkvID.name());
            if (mmkvWithID != null) {
                mmkvWithID.putString(key, defValue);
                return;
            }
            return;
        }
        mmkv.putString(key, defValue);
    }

    public static /* synthetic */ void putString$default(MMKV mmkv, MMKVID mmkvid, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mmkvid = MMKVID.USER;
        }
        putString(mmkv, mmkvid, str, str2);
    }
}
