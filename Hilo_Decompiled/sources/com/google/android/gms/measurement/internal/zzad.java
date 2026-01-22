package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzad extends zzor {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(zzpf zzpfVar) {
        super(zzpfVar);
    }

    private final zzy zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzd(int i10, int i11) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i10));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zzc().get(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(2:2|(2:4|(2:6|7)(1:524))(2:525|526))|8|(3:10|11|12)|16|(6:19|20|21|22|23|(14:(7:25|26|27|28|(1:30)(3:499|(1:501)(1:503)|502)|31|(1:34)(1:33))|35|36|37|38|39|40|(2:42|43)(3:458|(6:459|460|461|462|463|(1:466)(1:465))|467)|44|(1:46)(6:287|(12:289|290|291|292|293|(6:442|302|303|(3:398|(6:401|(2:437|438)(2:405|(8:411|412|(4:415|(2:417|418)(1:420)|419|413)|421|422|(4:425|(3:427|428|429)(1:431)|430|423)|432|433)(4:407|408|409|410))|434|435|410|399)|440)|305|306)|(4:295|(1:297)|298|299)|302|303|(0)|305|306)(1:457)|307|(10:310|(3:314|(4:317|(5:319|320|(1:322)(1:326)|323|324)(1:327)|325|315)|328)|329|(3:333|(4:336|(3:341|342|343)|344|334)|347)|348|(3:350|(6:353|(2:355|(3:357|358|359))(1:362)|360|361|359|351)|363)|364|(3:373|(8:376|(1:378)|379|(1:381)|382|(3:384|385|386)(1:388)|387|374)|389)|390|308)|396|397)|47|(3:181|(6:184|(2:186|(9:192|193|(12:195|196|197|198|199|200|201|202|203|204|(2:(9:206|207|208|209|210|(3:212|213|214)(1:262)|215|216|(1:219)(1:218))|220)(3:266|267|268)|221)(1:284)|222|(4:225|(3:243|244|245)(6:227|228|(2:229|(2:231|(1:233)(2:234|235))(2:241|242))|(1:237)|238|239)|240|223)|246|247|248|191)(1:188))(1:285)|189|190|191|182)|286)|49|(6:51|(3:53|(6:56|(8:58|59|60|61|62|63|64|(3:(9:66|67|68|69|70|(1:72)(1:129)|73|74|(1:77)(1:76))|78|79)(4:136|137|128|79))(1:154)|80|(2:81|(2:83|(3:119|120|121)(8:85|(2:86|(4:88|(3:90|(1:92)(1:115)|93)(1:116)|94|(1:1)(2:98|(1:100)(2:101|102)))(2:117|118))|109|(1:111)(1:113)|112|104|105|106))(0))|122|54)|155)|156|(9:159|160|161|162|163|164|(2:166|167)(1:169)|168|157)|177|178)(2:179|180))(2:507|508))|523|36|37|38|39|40|(0)(0)|44|(0)(0)|47|(0)|49|(0)(0)|(4:(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x09b4, code lost:
    
        if (r13 != false) goto L٤٨٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0896, code lost:
    
        if (r13 == null) goto L٣٦٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:446:0x02ee, code lost:
    
        if (r5 == null) goto L١٢٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x01bb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x01bc, code lost:
    
        r18 = "audience_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x0229, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x022a, code lost:
    
        r18 = "audience_id";
        r19 = "data";
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x0232, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x0227, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:498:0x022f, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:512:0x0170, code lost:
    
        if (r5 == null) goto L٤٥;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0a66  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01aa A[Catch: all -> 0x01b8, SQLiteException -> 0x01bb, TRY_LEAVE, TryCatch #19 {all -> 0x01b8, blocks: (B:40:0x01a4, B:42:0x01aa, B:458:0x01c2, B:459:0x01c7, B:461:0x01d1, B:462:0x01e1, B:463:0x020d, B:476:0x01f0, B:479:0x0200, B:482:0x0206, B:470:0x0233), top: B:39:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x01c2 A[Catch: all -> 0x01b8, SQLiteException -> 0x01bb, TRY_ENTER, TryCatch #19 {all -> 0x01b8, blocks: (B:40:0x01a4, B:42:0x01aa, B:458:0x01c2, B:459:0x01c7, B:461:0x01d1, B:462:0x01e1, B:463:0x020d, B:476:0x01f0, B:479:0x0200, B:482:0x0206, B:470:0x0233), top: B:39:0x01a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x079f  */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.util.Map, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r5v59, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v61, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v64 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List zzb(String str, List list, List list2, Long l10, Long l11, boolean z10) {
        int i10;
        int i11;
        boolean z11;
        Cursor cursor;
        Map map;
        String str2;
        String str3;
        Cursor cursor2;
        ?? r13;
        String str4;
        androidx.collection.a aVar;
        String str5;
        String str6;
        String str7;
        String str8;
        List<com.google.android.gms.internal.measurement.zzff> list3;
        String str9;
        ?? r52;
        Cursor cursor3;
        Map map2;
        Iterator it;
        String str10;
        zzz zzzVar;
        Iterator it2;
        String str11;
        long j10;
        String str12;
        Iterator it3;
        Map map3;
        Iterator it4;
        Cursor cursor4;
        List list4;
        Iterator it5;
        String str13;
        Map map4;
        String str14;
        com.google.android.gms.internal.measurement.zzfn zzfnVar;
        zzib zzibVar;
        Integer num;
        Cursor cursor5;
        Cursor cursor6;
        List list5;
        androidx.collection.a aVar2;
        Cursor cursor7;
        Cursor cursor8;
        List list6;
        String str15 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new androidx.collection.a();
        this.zzd = l10;
        this.zze = l11;
        Iterator it6 = list.iterator();
        while (true) {
            i10 = 0;
            i11 = 1;
            if (!it6.hasNext()) {
                z11 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it6.next()).zzd())) {
                z11 = true;
                break;
            }
        }
        zzpq.zza();
        zzib zzibVar2 = this.zzu;
        boolean zzp = zzibVar2.zzc().zzp(this.zza, zzfx.zzaF);
        zzpq.zza();
        boolean zzp2 = zzibVar2.zzc().zzp(this.zza, zzfx.zzaE);
        if (z11) {
            zzav zzj = this.zzg.zzj();
            String str16 = this.zza;
            zzj.zzay();
            zzj.zzg();
            Preconditions.checkNotEmpty(str16);
            ContentValues contentValues = new ContentValues();
            ?? r53 = "current_session_count";
            contentValues.put("current_session_count", (Integer) 0);
            try {
                r53 = "events";
                zzj.zze().update("events", contentValues, "app_id = ?", new String[]{str16});
                cursor = "events";
            } catch (SQLiteException e10) {
                zzj.zzu.zzaV().zzb().zzc("Error resetting session-scoped event counts. appId", zzgt.zzl(str16), e10);
                cursor = r53;
            }
        }
        Map emptyMap = Collections.emptyMap();
        String str17 = "Failed to merge filter. appId";
        String str18 = "Database error querying filters. appId";
        String str19 = "data";
        String str20 = "audience_id";
        try {
            if (zzp2 && zzp) {
                zzav zzj2 = this.zzg.zzj();
                String str21 = this.zza;
                Preconditions.checkNotEmpty(str21);
                androidx.collection.a aVar3 = new androidx.collection.a();
                try {
                    try {
                        cursor8 = zzj2.zze().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str21}, null, null, null);
                        try {
                        } catch (SQLiteException e11) {
                            e = e11;
                            zzj2.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgt.zzl(str21), e);
                            emptyMap = Collections.emptyMap();
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor7 = cursor;
                        if (cursor7 != null) {
                            cursor7.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                    cursor8 = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor7 = null;
                    if (cursor7 != null) {
                    }
                    throw th;
                }
                if (cursor8.moveToFirst()) {
                    while (true) {
                        try {
                            com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpj.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursor8.getBlob(i11))).zzbc();
                            if (zzffVar.zzg()) {
                                Integer valueOf = Integer.valueOf(cursor8.getInt(i10));
                                List list7 = (List) aVar3.get(valueOf);
                                if (list7 == null) {
                                    list6 = new ArrayList();
                                    aVar3.put(valueOf, list6);
                                } else {
                                    list6 = list7;
                                }
                                list6.add(zzffVar);
                            }
                        } catch (IOException e13) {
                            zzj2.zzu.zzaV().zzb().zzc("Failed to merge filter. appId", zzgt.zzl(str21), e13);
                        }
                        if (!cursor8.moveToNext()) {
                            break;
                        }
                        i10 = 0;
                        i11 = 1;
                    }
                    cursor8.close();
                    map = aVar3;
                    zzav zzj3 = this.zzg.zzj();
                    String str22 = this.zza;
                    zzj3.zzay();
                    zzj3.zzg();
                    Preconditions.checkNotEmpty(str22);
                    cursor2 = zzj3.zze().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str22}, null, null, null);
                    if (cursor2.moveToFirst()) {
                        Map emptyMap2 = Collections.emptyMap();
                        cursor2.close();
                        r13 = emptyMap2;
                        str2 = "audience_id";
                        str3 = "data";
                    } else {
                        androidx.collection.a aVar4 = new androidx.collection.a();
                        while (true) {
                            int i12 = cursor2.getInt(0);
                            try {
                                aVar4.put(Integer.valueOf(i12), (com.google.android.gms.internal.measurement.zzii) ((com.google.android.gms.internal.measurement.zzih) zzpj.zzw(com.google.android.gms.internal.measurement.zzii.zzi(), cursor2.getBlob(1))).zzbc());
                                aVar2 = aVar4;
                                str2 = str20;
                                str3 = str19;
                            } catch (IOException e14) {
                                aVar2 = aVar4;
                                str2 = str20;
                                try {
                                    str3 = str19;
                                    try {
                                        zzj3.zzu.zzaV().zzb().zzd("Failed to merge filter results. appId, audienceId, error", zzgt.zzl(str22), Integer.valueOf(i12), e14);
                                    } catch (SQLiteException e15) {
                                        e = e15;
                                        zzj3.zzu.zzaV().zzb().zzc("Database error querying filter results. appId", zzgt.zzl(str22), e);
                                        Map emptyMap3 = Collections.emptyMap();
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        r13 = emptyMap3;
                                        if (r13.isEmpty()) {
                                        }
                                        String str23 = "Skipping failed audience ID";
                                        if (!list.isEmpty()) {
                                        }
                                        String str24 = str15;
                                        String str25 = str6;
                                        if (z10) {
                                        }
                                    }
                                } catch (SQLiteException e16) {
                                    e = e16;
                                    str3 = str19;
                                    zzj3.zzu.zzaV().zzb().zzc("Database error querying filter results. appId", zzgt.zzl(str22), e);
                                    Map emptyMap32 = Collections.emptyMap();
                                    if (cursor2 != null) {
                                    }
                                    r13 = emptyMap32;
                                    if (r13.isEmpty()) {
                                    }
                                    String str232 = "Skipping failed audience ID";
                                    if (!list.isEmpty()) {
                                    }
                                    String str242 = str15;
                                    String str252 = str6;
                                    if (z10) {
                                    }
                                }
                            }
                            if (!cursor2.moveToNext()) {
                                break;
                            }
                            aVar4 = aVar2;
                            str20 = str2;
                            str19 = str3;
                        }
                        cursor2.close();
                        r13 = aVar2;
                    }
                    if (r13.isEmpty()) {
                        HashSet<Integer> hashSet = new HashSet(r13.keySet());
                        if (z11) {
                            String str26 = this.zza;
                            zzav zzj4 = this.zzg.zzj();
                            String str27 = this.zza;
                            zzj4.zzay();
                            zzj4.zzg();
                            Preconditions.checkNotEmpty(str27);
                            Map aVar5 = new androidx.collection.a();
                            SQLiteDatabase zze = zzj4.zze();
                            try {
                                try {
                                    cursor3 = zze.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str27, str27});
                                    try {
                                    } catch (SQLiteException e17) {
                                        e = e17;
                                        zzj4.zzu.zzaV().zzb().zzc("Database error querying scoped filters. appId", zzgt.zzl(str27), e);
                                        aVar5 = Collections.emptyMap();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    r52 = zze;
                                    if (r52 != 0) {
                                        r52.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e18) {
                                e = e18;
                                cursor3 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                r52 = 0;
                                if (r52 != 0) {
                                }
                                throw th;
                            }
                            if (!cursor3.moveToFirst()) {
                                aVar5 = Collections.emptyMap();
                                cursor3.close();
                                Preconditions.checkNotEmpty(str26);
                                Preconditions.checkNotNull(r13);
                                androidx.collection.a aVar6 = new androidx.collection.a();
                                if (!r13.isEmpty()) {
                                    Iterator it7 = r13.keySet().iterator();
                                    while (it7.hasNext()) {
                                        Integer num2 = (Integer) it7.next();
                                        num2.intValue();
                                        com.google.android.gms.internal.measurement.zzii zziiVar = (com.google.android.gms.internal.measurement.zzii) r13.get(num2);
                                        List list8 = (List) aVar5.get(num2);
                                        if (list8 != null && !list8.isEmpty()) {
                                            zzpf zzpfVar = this.zzg;
                                            map2 = aVar5;
                                            it = it7;
                                            List zzq = zzpfVar.zzp().zzq(zziiVar.zzc(), list8);
                                            if (zzq.isEmpty()) {
                                                aVar5 = map2;
                                                it7 = it;
                                            } else {
                                                com.google.android.gms.internal.measurement.zzih zzihVar = (com.google.android.gms.internal.measurement.zzih) zziiVar.zzcl();
                                                zzihVar.zzd();
                                                zzihVar.zzc(zzq);
                                                List zzq2 = zzpfVar.zzp().zzq(zziiVar.zza(), list8);
                                                zzihVar.zzb();
                                                zzihVar.zza(zzq2);
                                                ArrayList arrayList = new ArrayList();
                                                Iterator it8 = zziiVar.zze().iterator();
                                                while (it8.hasNext()) {
                                                    Iterator it9 = it8;
                                                    com.google.android.gms.internal.measurement.zzhq zzhqVar = (com.google.android.gms.internal.measurement.zzhq) it8.next();
                                                    String str28 = str18;
                                                    if (!list8.contains(Integer.valueOf(zzhqVar.zzb()))) {
                                                        arrayList.add(zzhqVar);
                                                    }
                                                    it8 = it9;
                                                    str18 = str28;
                                                }
                                                str10 = str18;
                                                zzihVar.zzf();
                                                zzihVar.zze(arrayList);
                                                ArrayList arrayList2 = new ArrayList();
                                                for (com.google.android.gms.internal.measurement.zzik zzikVar : zziiVar.zzg()) {
                                                    if (!list8.contains(Integer.valueOf(zzikVar.zzb()))) {
                                                        arrayList2.add(zzikVar);
                                                    }
                                                }
                                                zzihVar.zzh();
                                                zzihVar.zzg(arrayList2);
                                                aVar6.put(num2, (com.google.android.gms.internal.measurement.zzii) zzihVar.zzbc());
                                            }
                                        } else {
                                            map2 = aVar5;
                                            it = it7;
                                            str10 = str18;
                                            aVar6.put(num2, zziiVar);
                                        }
                                        aVar5 = map2;
                                        it7 = it;
                                        str18 = str10;
                                    }
                                }
                                str4 = str18;
                                aVar = aVar6;
                            }
                            do {
                                Integer valueOf2 = Integer.valueOf(cursor3.getInt(0));
                                List list9 = (List) aVar5.get(valueOf2);
                                if (list9 == null) {
                                    list9 = new ArrayList();
                                    aVar5.put(valueOf2, list9);
                                }
                                list9.add(Integer.valueOf(cursor3.getInt(1)));
                            } while (cursor3.moveToNext());
                            cursor3.close();
                            Preconditions.checkNotEmpty(str26);
                            Preconditions.checkNotNull(r13);
                            androidx.collection.a aVar62 = new androidx.collection.a();
                            if (!r13.isEmpty()) {
                            }
                            str4 = str18;
                            aVar = aVar62;
                        } else {
                            str4 = "Database error querying filters. appId";
                            aVar = r13;
                        }
                        Map map5 = r13;
                        for (Integer num3 : hashSet) {
                            num3.intValue();
                            com.google.android.gms.internal.measurement.zzii zziiVar2 = (com.google.android.gms.internal.measurement.zzii) aVar.get(num3);
                            BitSet bitSet = new BitSet();
                            BitSet bitSet2 = new BitSet();
                            androidx.collection.a aVar7 = new androidx.collection.a();
                            if (zziiVar2 != null && zziiVar2.zzf() != 0) {
                                for (com.google.android.gms.internal.measurement.zzhq zzhqVar2 : zziiVar2.zze()) {
                                    if (zzhqVar2.zza()) {
                                        aVar7.put(Integer.valueOf(zzhqVar2.zzb()), zzhqVar2.zzc() ? Long.valueOf(zzhqVar2.zzd()) : null);
                                    }
                                }
                            }
                            androidx.collection.a aVar8 = new androidx.collection.a();
                            if (zziiVar2 != null && zziiVar2.zzh() != 0) {
                                Iterator it10 = zziiVar2.zzg().iterator();
                                while (it10.hasNext()) {
                                    com.google.android.gms.internal.measurement.zzik zzikVar2 = (com.google.android.gms.internal.measurement.zzik) it10.next();
                                    if (zzikVar2.zza() && zzikVar2.zzd() > 0) {
                                        aVar8.put(Integer.valueOf(zzikVar2.zzb()), Long.valueOf(zzikVar2.zze(zzikVar2.zzd() - 1)));
                                        aVar = aVar;
                                        it10 = it10;
                                    }
                                }
                            }
                            androidx.collection.a aVar9 = aVar;
                            if (zziiVar2 != null) {
                                int i13 = 0;
                                while (i13 < zziiVar2.zzb() * 64) {
                                    if (zzpj.zzn(zziiVar2.zza(), i13)) {
                                        str9 = str17;
                                        this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", num3, Integer.valueOf(i13));
                                        bitSet2.set(i13);
                                        if (zzpj.zzn(zziiVar2.zzc(), i13)) {
                                            bitSet.set(i13);
                                            i13++;
                                            str17 = str9;
                                        }
                                    } else {
                                        str9 = str17;
                                    }
                                    aVar7.remove(Integer.valueOf(i13));
                                    i13++;
                                    str17 = str9;
                                }
                            }
                            String str29 = str17;
                            com.google.android.gms.internal.measurement.zzii zziiVar3 = (com.google.android.gms.internal.measurement.zzii) map5.get(num3);
                            if (zzp2 && zzp && (list3 = (List) map.get(num3)) != null && this.zze != null && this.zzd != null) {
                                for (com.google.android.gms.internal.measurement.zzff zzffVar2 : list3) {
                                    int zzb = zzffVar2.zzb();
                                    long longValue = this.zze.longValue() / 1000;
                                    if (zzffVar2.zzj()) {
                                        longValue = this.zzd.longValue() / 1000;
                                    }
                                    Integer valueOf3 = Integer.valueOf(zzb);
                                    if (aVar7.containsKey(valueOf3)) {
                                        aVar7.put(valueOf3, Long.valueOf(longValue));
                                    }
                                    if (aVar8.containsKey(valueOf3)) {
                                        aVar8.put(valueOf3, Long.valueOf(longValue));
                                    }
                                }
                            }
                            this.zzc.put(num3, new zzy(this, this.zza, zziiVar3, bitSet, bitSet2, aVar7, aVar8, null));
                            str17 = str29;
                            zzp = zzp;
                            map = map;
                            aVar = aVar9;
                            str2 = str2;
                            map5 = map5;
                        }
                        str5 = str17;
                        str6 = str2;
                        str7 = str3;
                        str8 = str4;
                    } else {
                        str8 = "Database error querying filters. appId";
                        str5 = "Failed to merge filter. appId";
                        str6 = str2;
                        str7 = str3;
                    }
                    String str2322 = "Skipping failed audience ID";
                    if (!list.isEmpty()) {
                        zzz zzzVar2 = new zzz(this, null);
                        androidx.collection.a aVar10 = new androidx.collection.a();
                        Iterator it11 = list.iterator();
                        while (it11.hasNext()) {
                            com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it11.next();
                            com.google.android.gms.internal.measurement.zzhs zza = zzzVar2.zza(this.zza, zzhsVar);
                            if (zza != null) {
                                zzpf zzpfVar2 = this.zzg;
                                zzbc zzah = zzpfVar2.zzj().zzah(this.zza, zzhsVar, zza.zzd());
                                zzpfVar2.zzj().zzh(zzah);
                                if (!z10) {
                                    long j11 = zzah.zzc;
                                    String zzd = zza.zzd();
                                    Map map6 = (Map) aVar10.get(zzd);
                                    if (map6 == null) {
                                        zzav zzj5 = zzpfVar2.zzj();
                                        String str30 = this.zza;
                                        zzj5.zzay();
                                        zzj5.zzg();
                                        Preconditions.checkNotEmpty(str30);
                                        Preconditions.checkNotEmpty(zzd);
                                        zzzVar = zzzVar2;
                                        androidx.collection.a aVar11 = new androidx.collection.a();
                                        it2 = it11;
                                        str11 = str15;
                                        str12 = str6;
                                        String str31 = str7;
                                        try {
                                            try {
                                                j10 = j11;
                                                try {
                                                    Cursor query = zzj5.zze().query("event_filters", new String[]{str12, str31}, "app_id=? AND event_name=?", new String[]{str30, zzd}, null, null, null);
                                                    try {
                                                        try {
                                                            if (query.moveToFirst()) {
                                                                while (true) {
                                                                    try {
                                                                        com.google.android.gms.internal.measurement.zzff zzffVar3 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpj.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), query.getBlob(1))).zzbc();
                                                                        Integer valueOf4 = Integer.valueOf(query.getInt(0));
                                                                        List list10 = (List) aVar11.get(valueOf4);
                                                                        if (list10 == null) {
                                                                            str7 = str31;
                                                                            try {
                                                                                list4 = new ArrayList();
                                                                                aVar11.put(valueOf4, list4);
                                                                            } catch (SQLiteException e19) {
                                                                                e = e19;
                                                                                cursor4 = query;
                                                                                try {
                                                                                    zzj5.zzu.zzaV().zzb().zzc(str8, zzgt.zzl(str30), e);
                                                                                    map6 = Collections.emptyMap();
                                                                                    if (cursor4 != null) {
                                                                                        cursor4.close();
                                                                                    }
                                                                                    aVar10.put(zzd, map6);
                                                                                    it3 = map6.keySet().iterator();
                                                                                    while (it3.hasNext()) {
                                                                                    }
                                                                                    zzzVar2 = zzzVar;
                                                                                    it11 = it2;
                                                                                    str6 = str12;
                                                                                    str15 = str11;
                                                                                } catch (Throwable th5) {
                                                                                    th = th5;
                                                                                    if (cursor4 != null) {
                                                                                        cursor4.close();
                                                                                    }
                                                                                    throw th;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str7 = str31;
                                                                            list4 = list10;
                                                                        }
                                                                        list4.add(zzffVar3);
                                                                    } catch (IOException e20) {
                                                                        str7 = str31;
                                                                        zzj5.zzu.zzaV().zzb().zzc(str5, zzgt.zzl(str30), e20);
                                                                    }
                                                                    if (!query.moveToNext()) {
                                                                        break;
                                                                    }
                                                                    str31 = str7;
                                                                }
                                                                query.close();
                                                                map6 = aVar11;
                                                            } else {
                                                                str7 = str31;
                                                                map6 = Collections.emptyMap();
                                                                query.close();
                                                            }
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            cursor4 = query;
                                                            if (cursor4 != null) {
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (SQLiteException e21) {
                                                        e = e21;
                                                        str7 = str31;
                                                    }
                                                } catch (SQLiteException e22) {
                                                    e = e22;
                                                    str7 = str31;
                                                    cursor4 = null;
                                                    zzj5.zzu.zzaV().zzb().zzc(str8, zzgt.zzl(str30), e);
                                                    map6 = Collections.emptyMap();
                                                    if (cursor4 != null) {
                                                    }
                                                    aVar10.put(zzd, map6);
                                                    it3 = map6.keySet().iterator();
                                                    while (it3.hasNext()) {
                                                    }
                                                    zzzVar2 = zzzVar;
                                                    it11 = it2;
                                                    str6 = str12;
                                                    str15 = str11;
                                                }
                                            } catch (Throwable th7) {
                                                th = th7;
                                                cursor4 = null;
                                            }
                                        } catch (SQLiteException e23) {
                                            e = e23;
                                            str7 = str31;
                                            j10 = j11;
                                        }
                                        aVar10.put(zzd, map6);
                                    } else {
                                        zzzVar = zzzVar2;
                                        it2 = it11;
                                        str11 = str15;
                                        j10 = j11;
                                        str12 = str6;
                                    }
                                    it3 = map6.keySet().iterator();
                                    while (it3.hasNext()) {
                                        Integer num4 = (Integer) it3.next();
                                        int intValue = num4.intValue();
                                        if (this.zzb.contains(num4)) {
                                            this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", num4);
                                        } else {
                                            Iterator it12 = ((List) map6.get(num4)).iterator();
                                            boolean z12 = true;
                                            while (true) {
                                                if (!it12.hasNext()) {
                                                    map3 = map6;
                                                    it4 = it3;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzff zzffVar4 = (com.google.android.gms.internal.measurement.zzff) it12.next();
                                                zzaa zzaaVar = new zzaa(this, this.zza, intValue, zzffVar4);
                                                map3 = map6;
                                                it4 = it3;
                                                z12 = zzaaVar.zzd(this.zzd, this.zze, zza, j10, zzah, zzd(intValue, zzffVar4.zzb()));
                                                if (z12) {
                                                    zzc(num4).zza(zzaaVar);
                                                    map6 = map3;
                                                    it3 = it4;
                                                } else {
                                                    this.zzb.add(num4);
                                                    break;
                                                }
                                            }
                                            if (!z12) {
                                                this.zzb.add(num4);
                                            }
                                            map6 = map3;
                                            it3 = it4;
                                        }
                                    }
                                    zzzVar2 = zzzVar;
                                    it11 = it2;
                                    str6 = str12;
                                    str15 = str11;
                                }
                            }
                        }
                    }
                    String str2422 = str15;
                    String str2522 = str6;
                    if (z10) {
                        if (!list2.isEmpty()) {
                            androidx.collection.a aVar12 = new androidx.collection.a();
                            Iterator it13 = list2.iterator();
                            while (it13.hasNext()) {
                                com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it13.next();
                                String zzc = zziuVar.zzc();
                                Map map7 = (Map) aVar12.get(zzc);
                                if (map7 == null) {
                                    zzav zzj6 = this.zzg.zzj();
                                    String str32 = this.zza;
                                    zzj6.zzay();
                                    zzj6.zzg();
                                    Preconditions.checkNotEmpty(str32);
                                    Preconditions.checkNotEmpty(zzc);
                                    androidx.collection.a aVar13 = new androidx.collection.a();
                                    str13 = str7;
                                    try {
                                        cursor6 = zzj6.zze().query("property_filters", new String[]{str2522, str13}, "app_id=? AND property_name=?", new String[]{str32, zzc}, null, null, null);
                                        try {
                                            try {
                                            } catch (Throwable th8) {
                                                th = th8;
                                                cursor5 = cursor6;
                                                if (cursor5 != null) {
                                                    cursor5.close();
                                                }
                                                throw th;
                                            }
                                        } catch (SQLiteException e24) {
                                            e = e24;
                                            it5 = it13;
                                        }
                                    } catch (SQLiteException e25) {
                                        e = e25;
                                        it5 = it13;
                                        cursor6 = null;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        cursor5 = null;
                                    }
                                    if (cursor6.moveToFirst()) {
                                        while (true) {
                                            try {
                                                com.google.android.gms.internal.measurement.zzfn zzfnVar2 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpj.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursor6.getBlob(1))).zzbc();
                                                Integer valueOf5 = Integer.valueOf(cursor6.getInt(0));
                                                List list11 = (List) aVar13.get(valueOf5);
                                                if (list11 == null) {
                                                    list5 = new ArrayList();
                                                    aVar13.put(valueOf5, list5);
                                                } else {
                                                    list5 = list11;
                                                }
                                                list5.add(zzfnVar2);
                                                it5 = it13;
                                            } catch (IOException e26) {
                                                it5 = it13;
                                                try {
                                                    zzj6.zzu.zzaV().zzb().zzc("Failed to merge filter", zzgt.zzl(str32), e26);
                                                } catch (SQLiteException e27) {
                                                    e = e27;
                                                    zzj6.zzu.zzaV().zzb().zzc(str8, zzgt.zzl(str32), e);
                                                    map7 = Collections.emptyMap();
                                                }
                                            }
                                            if (!cursor6.moveToNext()) {
                                                break;
                                            }
                                            it13 = it5;
                                        }
                                        cursor6.close();
                                        map7 = aVar13;
                                        aVar12.put(zzc, map7);
                                    } else {
                                        it5 = it13;
                                        map7 = Collections.emptyMap();
                                        cursor6.close();
                                        aVar12.put(zzc, map7);
                                    }
                                } else {
                                    it5 = it13;
                                    str13 = str7;
                                }
                                Iterator it14 = map7.keySet().iterator();
                                while (true) {
                                    if (it14.hasNext()) {
                                        Integer num5 = (Integer) it14.next();
                                        int intValue2 = num5.intValue();
                                        if (this.zzb.contains(num5)) {
                                            this.zzu.zzaV().zzk().zzb(str2322, num5);
                                            break;
                                        }
                                        Iterator it15 = ((List) map7.get(num5)).iterator();
                                        boolean z13 = true;
                                        while (true) {
                                            if (!it15.hasNext()) {
                                                map4 = map7;
                                                str14 = str2322;
                                                break;
                                            }
                                            zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it15.next();
                                            zzibVar = this.zzu;
                                            if (Log.isLoggable(zzibVar.zzaV().zzn(), 2)) {
                                                zzgr zzk = zzibVar.zzaV().zzk();
                                                if (zzfnVar.zza()) {
                                                    num = Integer.valueOf(zzfnVar.zzb());
                                                    map4 = map7;
                                                } else {
                                                    map4 = map7;
                                                    num = null;
                                                }
                                                str14 = str2322;
                                                zzk.zzd("Evaluating filter. audience, filter, property", num5, num, zzibVar.zzl().zzc(zzfnVar.zzc()));
                                                zzibVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                            } else {
                                                map4 = map7;
                                                str14 = str2322;
                                            }
                                            if (!zzfnVar.zza() || zzfnVar.zzb() > 256) {
                                                break;
                                            }
                                            zzac zzacVar = new zzac(this, this.zza, intValue2, zzfnVar);
                                            z13 = zzacVar.zzd(this.zzd, this.zze, zziuVar, zzd(intValue2, zzfnVar.zzb()));
                                            if (z13) {
                                                zzc(num5).zza(zzacVar);
                                                map7 = map4;
                                                str2322 = str14;
                                            } else {
                                                this.zzb.add(num5);
                                                break;
                                            }
                                        }
                                        zzibVar.zzaV().zze().zzc("Invalid property filter ID. appId, id", zzgt.zzl(this.zza), String.valueOf(zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null));
                                        this.zzb.add(num5);
                                        map7 = map4;
                                        str2322 = str14;
                                    }
                                }
                                it13 = it5;
                                str7 = str13;
                            }
                        }
                        ArrayList arrayList3 = new ArrayList();
                        Set<Integer> keySet = this.zzc.keySet();
                        keySet.removeAll(this.zzb);
                        for (Integer num6 : keySet) {
                            int intValue3 = num6.intValue();
                            zzy zzyVar = (zzy) this.zzc.get(num6);
                            Preconditions.checkNotNull(zzyVar);
                            com.google.android.gms.internal.measurement.zzhg zzb2 = zzyVar.zzb(intValue3);
                            arrayList3.add(zzb2);
                            zzav zzj7 = this.zzg.zzj();
                            String str33 = this.zza;
                            com.google.android.gms.internal.measurement.zzii zzc2 = zzb2.zzc();
                            zzj7.zzay();
                            zzj7.zzg();
                            Preconditions.checkNotEmpty(str33);
                            Preconditions.checkNotNull(zzc2);
                            byte[] zzcc = zzc2.zzcc();
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("app_id", str33);
                            contentValues2.put(str2522, num6);
                            String str34 = str2422;
                            contentValues2.put(str34, zzcc);
                            try {
                            } catch (SQLiteException e28) {
                                e = e28;
                            }
                            try {
                                if (zzj7.zze().insertWithOnConflict("audience_filter_values", null, contentValues2, 5) == -1) {
                                    zzj7.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgt.zzl(str33));
                                }
                            } catch (SQLiteException e29) {
                                e = e29;
                                zzj7.zzu.zzaV().zzb().zzc("Error storing filter results. appId", zzgt.zzl(str33), e);
                                str2422 = str34;
                            }
                            str2422 = str34;
                        }
                        return arrayList3;
                    }
                    return new ArrayList();
                }
                emptyMap = Collections.emptyMap();
                cursor8.close();
            }
            if (cursor2.moveToFirst()) {
            }
            if (r13.isEmpty()) {
            }
            String str23222 = "Skipping failed audience ID";
            if (!list.isEmpty()) {
            }
            String str24222 = str15;
            String str25222 = str6;
            if (z10) {
            }
        } catch (Throwable th10) {
            th = th10;
            Cursor cursor9 = cursor2;
            if (cursor9 != null) {
                cursor9.close();
            }
            throw th;
        }
        map = emptyMap;
        zzav zzj32 = this.zzg.zzj();
        String str222 = this.zza;
        zzj32.zzay();
        zzj32.zzg();
        Preconditions.checkNotEmpty(str222);
        cursor2 = zzj32.zze().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str222}, null, null, null);
    }

    @Override // com.google.android.gms.measurement.internal.zzor
    protected final boolean zzbb() {
        return false;
    }
}
