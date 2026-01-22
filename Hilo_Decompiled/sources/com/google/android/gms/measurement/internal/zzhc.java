package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzql;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzhc {
    final /* synthetic */ zzhg zza;
    private final String zzb;
    private final Bundle zzc;
    private Bundle zzd;

    public zzhc(zzhg zzhgVar, String str, Bundle bundle) {
        Objects.requireNonNull(zzhgVar);
        this.zza = zzhgVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = new Bundle();
    }

    public final Bundle zza() {
        char c10;
        if (this.zzd == null) {
            zzhg zzhgVar = this.zza;
            String string = zzhgVar.zzd().getString(this.zzb, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i10);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode != 115) {
                                        if (hashCode != 3352) {
                                            if (hashCode == 3445 && string3.equals("la")) {
                                                c10 = 4;
                                            }
                                            c10 = 65535;
                                        } else {
                                            if (string3.equals("ia")) {
                                                c10 = 3;
                                            }
                                            c10 = 65535;
                                        }
                                    } else {
                                        if (string3.equals("s")) {
                                            c10 = 0;
                                        }
                                        c10 = 65535;
                                    }
                                } else {
                                    if (string3.equals("l")) {
                                        c10 = 2;
                                    }
                                    c10 = 65535;
                                }
                            } else {
                                if (string3.equals("d")) {
                                    c10 = 1;
                                }
                                c10 = 65535;
                            }
                            if (c10 != 0) {
                                if (c10 != 1) {
                                    if (c10 != 2) {
                                        if (c10 != 3) {
                                            if (c10 != 4) {
                                                zzhgVar.zzu.zzaV().zzb().zzb("Unrecognized persisted bundle type. Type", string3);
                                            } else {
                                                zzql.zza();
                                                if (zzhgVar.zzu.zzc().zzp(null, zzfx.zzaQ)) {
                                                    JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                                    int length = jSONArray2.length();
                                                    long[] jArr = new long[length];
                                                    for (int i11 = 0; i11 < length; i11++) {
                                                        jArr[i11] = jSONArray2.optLong(i11);
                                                    }
                                                    bundle.putLongArray(string2, jArr);
                                                }
                                            }
                                        } else {
                                            zzql.zza();
                                            if (zzhgVar.zzu.zzc().zzp(null, zzfx.zzaQ)) {
                                                JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                                int length2 = jSONArray3.length();
                                                int[] iArr = new int[length2];
                                                for (int i12 = 0; i12 < length2; i12++) {
                                                    iArr[i12] = jSONArray3.optInt(i12);
                                                }
                                                bundle.putIntArray(string2, iArr);
                                            }
                                        }
                                    } else {
                                        bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                                    }
                                } else {
                                    bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                                }
                            } else {
                                bundle.putString(string2, jSONObject.getString("v"));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.zza.zzu.zzaV().zzb().zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.zzd = bundle;
                } catch (JSONException unused2) {
                    this.zza.zzu.zzaV().zzb().zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.zzd == null) {
                this.zzd = this.zzc;
            }
        }
        return new Bundle((Bundle) Preconditions.checkNotNull(this.zzd));
    }

    public final void zzb(Bundle bundle) {
        Bundle bundle2;
        zzhg zzhgVar;
        JSONObject jSONObject;
        zzib zzibVar;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
        }
        zzhg zzhgVar2 = this.zza;
        SharedPreferences.Editor edit = zzhgVar2.zzd().edit();
        if (bundle2.size() == 0) {
            edit.remove(this.zzb);
        } else {
            String str = this.zzb;
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        zzql.zza();
                        zzibVar = zzhgVar2.zzu;
                        zzhgVar = zzhgVar2;
                    } catch (JSONException e10) {
                        e = e10;
                        zzhgVar = zzhgVar2;
                    }
                    if (zzibVar.zzc().zzp(null, zzfx.zzaQ)) {
                        try {
                        } catch (JSONException e11) {
                            e = e11;
                            this.zza.zzu.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences", e);
                            zzhgVar2 = zzhgVar;
                        }
                        if (obj instanceof String) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "d");
                        } else {
                            zzibVar.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            zzhgVar2 = zzhgVar;
                        }
                        jSONArray.put(jSONObject);
                        zzhgVar2 = zzhgVar;
                    } else {
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            zzibVar.zzaV().zzb().zzb("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                            zzhgVar2 = zzhgVar;
                        }
                        jSONArray.put(jSONObject);
                        zzhgVar2 = zzhgVar;
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.zzd = bundle2;
    }
}
