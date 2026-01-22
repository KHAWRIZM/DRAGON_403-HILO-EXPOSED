package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import androidx.room.util.CursorUtil$wrapMappedColumns$2;
import anet.channel.util.HttpConstant;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.oudi.utils.date.DateUtils;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzpf implements zzjf {
    private static volatile zzpf zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlt zzG;
    private String zzH;
    private zzay zzI;
    private long zzJ;

    @VisibleForTesting
    long zza;
    private final zzhs zzc;
    private final zzgy zzd;
    private zzav zze;
    private zzha zzf;
    private zzoj zzg;
    private zzad zzh;
    private final zzpj zzi;
    private zzlo zzj;
    private zznm zzk;
    private final zzot zzl;
    private zzhj zzm;
    private final zzib zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzpn zzK = new zzpa(this);

    zzpf(zzpg zzpgVar, zzib zzibVar) {
        Preconditions.checkNotNull(zzpgVar);
        this.zzn = zzib.zzy(zzpgVar.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzot(this);
        zzpj zzpjVar = new zzpj(this);
        zzpjVar.zzaz();
        this.zzi = zzpjVar;
        zzgy zzgyVar = new zzgy(this);
        zzgyVar.zzaz();
        this.zzd = zzgyVar;
        zzhs zzhsVar = new zzhs(this);
        zzhsVar.zzaz();
        this.zzc = zzhsVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaW().zzj(new zzou(this, zzpgVar));
    }

    public static zzpf zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpf.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzpf((zzpg) Preconditions.checkNotNull(new zzpg(context)), null);
                    }
                } finally {
                }
            }
        }
        return zzb;
    }

    @VisibleForTesting
    static final void zzaA(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List zza = zzhrVar.zza();
        for (int i10 = 0; i10 < zza.size(); i10++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i10)).zzb())) {
                zzhrVar.zzj(i10);
                return;
            }
        }
    }

    private final int zzaB(String str, zzan zzanVar) {
        zzjj zzjjVar;
        zzjh zzA;
        zzhs zzhsVar = this.zzc;
        if (zzhsVar.zzx(str) == null) {
            zzanVar.zzc(zzjj.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzu = zzj().zzu(str);
        if (zzu != null && zze.zzc(zzu.zzaH()).zza() == zzjh.POLICY && (zzA = zzhsVar.zzA(str, (zzjjVar = zzjj.AD_PERSONALIZATION))) != zzjh.UNINITIALIZED) {
            zzanVar.zzc(zzjjVar, zzam.REMOTE_ENFORCED_DEFAULT);
            if (zzA != zzjh.GRANTED) {
                return 1;
            }
            return 0;
        }
        zzjj zzjjVar2 = zzjj.AD_PERSONALIZATION;
        zzanVar.zzc(zzjjVar2, zzam.REMOTE_DEFAULT);
        if (!zzhsVar.zzv(str, zzjjVar2)) {
            return 1;
        }
        return 0;
    }

    private final Map zzaC(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap hashMap = new HashMap();
        zzp();
        for (Map.Entry entry : zzpj.zzH(zzhsVar, "gad_").entrySet()) {
            hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    private final zzay zzaD() {
        if (this.zzI == null) {
            this.zzI = new zzox(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzaE, reason: merged with bridge method [inline-methods] */
    public final void zzau() {
        zzaW().zzg();
        if (!this.zzr.isEmpty() && !zzaD().zzc()) {
            long max = Math.max(0L, ((Integer) zzfx.zzaB.zzb(null)).intValue() - (zzaZ().elapsedRealtime() - this.zzJ));
            zzaV().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
            zzaD().zzb(max);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0559 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0017, B:6:0x0032, B:8:0x003c, B:9:0x0055, B:12:0x0071, B:15:0x0097, B:17:0x00ce, B:20:0x00df, B:22:0x00e9, B:25:0x0693, B:26:0x011a, B:29:0x012c, B:31:0x0132, B:33:0x016d, B:35:0x017b, B:38:0x019b, B:40:0x01a1, B:42:0x01b1, B:44:0x01bf, B:46:0x01cf, B:48:0x01dc, B:53:0x01df, B:55:0x01f3, B:62:0x03f0, B:63:0x03fc, B:66:0x0406, B:70:0x042b, B:71:0x0419, B:78:0x0432, B:80:0x043e, B:82:0x044a, B:86:0x048f, B:87:0x0467, B:90:0x0479, B:92:0x047f, B:94:0x0489, B:97:0x04a7, B:99:0x04b3, B:102:0x04c6, B:104:0x04d7, B:106:0x04e3, B:107:0x0553, B:109:0x0559, B:110:0x0565, B:112:0x056b, B:114:0x057b, B:116:0x0585, B:117:0x0596, B:119:0x059c, B:120:0x05b7, B:122:0x05bd, B:124:0x05db, B:126:0x05ea, B:128:0x0615, B:129:0x05f3, B:131:0x0601, B:133:0x061e, B:134:0x0638, B:136:0x063e, B:139:0x0651, B:144:0x065e, B:145:0x0662, B:147:0x0668, B:149:0x0678, B:157:0x04fc, B:159:0x050a, B:162:0x051d, B:164:0x052e, B:166:0x053a, B:169:0x0220, B:172:0x022a, B:174:0x0238, B:176:0x0287, B:177:0x0257, B:179:0x0267, B:187:0x0297, B:189:0x02c3, B:190:0x02ed, B:192:0x0324, B:193:0x032a, B:196:0x0336, B:198:0x036d, B:199:0x0388, B:201:0x038e, B:203:0x039c, B:205:0x03b2, B:206:0x03a6, B:214:0x03b8, B:217:0x03bf, B:218:0x03d7, B:220:0x0138, B:222:0x0143, B:224:0x014f, B:226:0x0155, B:229:0x0160, B:234:0x06ad, B:236:0x06bb, B:238:0x06c4, B:240:0x06f7, B:241:0x06cc, B:243:0x06d6, B:245:0x06dc, B:247:0x06e8, B:249:0x06f0, B:252:0x06f9, B:253:0x0705, B:256:0x070d, B:259:0x071f, B:260:0x072a, B:262:0x0732, B:263:0x0757, B:265:0x0771, B:266:0x0786, B:268:0x07a0, B:269:0x07b5, B:271:0x07fa, B:273:0x0800, B:274:0x0827, B:276:0x082f, B:277:0x0838, B:279:0x083e, B:280:0x0844, B:282:0x0859, B:284:0x0869, B:286:0x0879, B:289:0x0882, B:291:0x0888, B:292:0x089a, B:294:0x08a0, B:297:0x08b0, B:299:0x08c8, B:301:0x08da, B:303:0x0901, B:304:0x091c, B:306:0x092e, B:307:0x094f, B:309:0x0976, B:311:0x09a6, B:313:0x0a4d, B:315:0x0a5b, B:318:0x09b8, B:320:0x09d0, B:321:0x09ed, B:323:0x0a16, B:325:0x0a44, B:332:0x0a62, B:389:0x0ad4, B:391:0x0aed, B:393:0x0b03, B:395:0x0b08, B:397:0x0b0c, B:399:0x0b10, B:401:0x0b1a, B:402:0x0b20, B:404:0x0b24, B:406:0x0b2a, B:407:0x0b3b, B:408:0x0b47, B:486:0x0b6e, B:490:0x0b75, B:501:0x080e, B:503:0x0814, B:505:0x081a, B:506:0x07b2, B:507:0x0783, B:508:0x0737, B:510:0x073d), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04fc A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0017, B:6:0x0032, B:8:0x003c, B:9:0x0055, B:12:0x0071, B:15:0x0097, B:17:0x00ce, B:20:0x00df, B:22:0x00e9, B:25:0x0693, B:26:0x011a, B:29:0x012c, B:31:0x0132, B:33:0x016d, B:35:0x017b, B:38:0x019b, B:40:0x01a1, B:42:0x01b1, B:44:0x01bf, B:46:0x01cf, B:48:0x01dc, B:53:0x01df, B:55:0x01f3, B:62:0x03f0, B:63:0x03fc, B:66:0x0406, B:70:0x042b, B:71:0x0419, B:78:0x0432, B:80:0x043e, B:82:0x044a, B:86:0x048f, B:87:0x0467, B:90:0x0479, B:92:0x047f, B:94:0x0489, B:97:0x04a7, B:99:0x04b3, B:102:0x04c6, B:104:0x04d7, B:106:0x04e3, B:107:0x0553, B:109:0x0559, B:110:0x0565, B:112:0x056b, B:114:0x057b, B:116:0x0585, B:117:0x0596, B:119:0x059c, B:120:0x05b7, B:122:0x05bd, B:124:0x05db, B:126:0x05ea, B:128:0x0615, B:129:0x05f3, B:131:0x0601, B:133:0x061e, B:134:0x0638, B:136:0x063e, B:139:0x0651, B:144:0x065e, B:145:0x0662, B:147:0x0668, B:149:0x0678, B:157:0x04fc, B:159:0x050a, B:162:0x051d, B:164:0x052e, B:166:0x053a, B:169:0x0220, B:172:0x022a, B:174:0x0238, B:176:0x0287, B:177:0x0257, B:179:0x0267, B:187:0x0297, B:189:0x02c3, B:190:0x02ed, B:192:0x0324, B:193:0x032a, B:196:0x0336, B:198:0x036d, B:199:0x0388, B:201:0x038e, B:203:0x039c, B:205:0x03b2, B:206:0x03a6, B:214:0x03b8, B:217:0x03bf, B:218:0x03d7, B:220:0x0138, B:222:0x0143, B:224:0x014f, B:226:0x0155, B:229:0x0160, B:234:0x06ad, B:236:0x06bb, B:238:0x06c4, B:240:0x06f7, B:241:0x06cc, B:243:0x06d6, B:245:0x06dc, B:247:0x06e8, B:249:0x06f0, B:252:0x06f9, B:253:0x0705, B:256:0x070d, B:259:0x071f, B:260:0x072a, B:262:0x0732, B:263:0x0757, B:265:0x0771, B:266:0x0786, B:268:0x07a0, B:269:0x07b5, B:271:0x07fa, B:273:0x0800, B:274:0x0827, B:276:0x082f, B:277:0x0838, B:279:0x083e, B:280:0x0844, B:282:0x0859, B:284:0x0869, B:286:0x0879, B:289:0x0882, B:291:0x0888, B:292:0x089a, B:294:0x08a0, B:297:0x08b0, B:299:0x08c8, B:301:0x08da, B:303:0x0901, B:304:0x091c, B:306:0x092e, B:307:0x094f, B:309:0x0976, B:311:0x09a6, B:313:0x0a4d, B:315:0x0a5b, B:318:0x09b8, B:320:0x09d0, B:321:0x09ed, B:323:0x0a16, B:325:0x0a44, B:332:0x0a62, B:389:0x0ad4, B:391:0x0aed, B:393:0x0b03, B:395:0x0b08, B:397:0x0b0c, B:399:0x0b10, B:401:0x0b1a, B:402:0x0b20, B:404:0x0b24, B:406:0x0b2a, B:407:0x0b3b, B:408:0x0b47, B:486:0x0b6e, B:490:0x0b75, B:501:0x080e, B:503:0x0814, B:505:0x081a, B:506:0x07b2, B:507:0x0783, B:508:0x0737, B:510:0x073d), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0bac A[Catch: all -> 0x0bdf, TryCatch #3 {all -> 0x0bdf, blocks: (B:383:0x0aa3, B:384:0x0ab6, B:386:0x0abc, B:411:0x0d97, B:416:0x0b58, B:419:0x0b8a, B:421:0x0bac, B:422:0x0bb4, B:424:0x0bba, B:428:0x0bcc, B:433:0x0bfd, B:436:0x0c29, B:438:0x0c35, B:440:0x0c4b, B:441:0x0c8a, B:446:0x0ca4, B:448:0x0caf, B:450:0x0cb3, B:452:0x0cb7, B:455:0x0cbf, B:456:0x0cca, B:458:0x0cd7, B:460:0x0cde, B:462:0x0cf6, B:463:0x0cfb, B:465:0x0d92, B:466:0x0d16, B:468:0x0d1b, B:471:0x0d42, B:473:0x0d62, B:474:0x0d69, B:477:0x0d7f, B:480:0x0d28, B:484:0x0be7, B:492:0x0da3, B:494:0x0db0, B:495:0x0db6, B:496:0x0dbe, B:498:0x0dc4, B:335:0x0ddd, B:337:0x0ded, B:338:0x0e6e, B:363:0x0e05, B:365:0x0e0b, B:367:0x0e15, B:368:0x0e1c, B:373:0x0e2c, B:374:0x0e33, B:376:0x0e5f, B:377:0x0e66, B:378:0x0e63, B:379:0x0e30, B:381:0x0e19), top: B:382:0x0aa3 }] */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0bfd A[Catch: all -> 0x0bdf, TryCatch #3 {all -> 0x0bdf, blocks: (B:383:0x0aa3, B:384:0x0ab6, B:386:0x0abc, B:411:0x0d97, B:416:0x0b58, B:419:0x0b8a, B:421:0x0bac, B:422:0x0bb4, B:424:0x0bba, B:428:0x0bcc, B:433:0x0bfd, B:436:0x0c29, B:438:0x0c35, B:440:0x0c4b, B:441:0x0c8a, B:446:0x0ca4, B:448:0x0caf, B:450:0x0cb3, B:452:0x0cb7, B:455:0x0cbf, B:456:0x0cca, B:458:0x0cd7, B:460:0x0cde, B:462:0x0cf6, B:463:0x0cfb, B:465:0x0d92, B:466:0x0d16, B:468:0x0d1b, B:471:0x0d42, B:473:0x0d62, B:474:0x0d69, B:477:0x0d7f, B:480:0x0d28, B:484:0x0be7, B:492:0x0da3, B:494:0x0db0, B:495:0x0db6, B:496:0x0dbe, B:498:0x0dc4, B:335:0x0ddd, B:337:0x0ded, B:338:0x0e6e, B:363:0x0e05, B:365:0x0e0b, B:367:0x0e15, B:368:0x0e1c, B:373:0x0e2c, B:374:0x0e33, B:376:0x0e5f, B:377:0x0e66, B:378:0x0e63, B:379:0x0e30, B:381:0x0e19), top: B:382:0x0aa3 }] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0c29 A[Catch: all -> 0x0bdf, TryCatch #3 {all -> 0x0bdf, blocks: (B:383:0x0aa3, B:384:0x0ab6, B:386:0x0abc, B:411:0x0d97, B:416:0x0b58, B:419:0x0b8a, B:421:0x0bac, B:422:0x0bb4, B:424:0x0bba, B:428:0x0bcc, B:433:0x0bfd, B:436:0x0c29, B:438:0x0c35, B:440:0x0c4b, B:441:0x0c8a, B:446:0x0ca4, B:448:0x0caf, B:450:0x0cb3, B:452:0x0cb7, B:455:0x0cbf, B:456:0x0cca, B:458:0x0cd7, B:460:0x0cde, B:462:0x0cf6, B:463:0x0cfb, B:465:0x0d92, B:466:0x0d16, B:468:0x0d1b, B:471:0x0d42, B:473:0x0d62, B:474:0x0d69, B:477:0x0d7f, B:480:0x0d28, B:484:0x0be7, B:492:0x0da3, B:494:0x0db0, B:495:0x0db6, B:496:0x0dbe, B:498:0x0dc4, B:335:0x0ddd, B:337:0x0ded, B:338:0x0e6e, B:363:0x0e05, B:365:0x0e0b, B:367:0x0e15, B:368:0x0e1c, B:373:0x0e2c, B:374:0x0e33, B:376:0x0e5f, B:377:0x0e66, B:378:0x0e63, B:379:0x0e30, B:381:0x0e19), top: B:382:0x0aa3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03f0 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0017, B:6:0x0032, B:8:0x003c, B:9:0x0055, B:12:0x0071, B:15:0x0097, B:17:0x00ce, B:20:0x00df, B:22:0x00e9, B:25:0x0693, B:26:0x011a, B:29:0x012c, B:31:0x0132, B:33:0x016d, B:35:0x017b, B:38:0x019b, B:40:0x01a1, B:42:0x01b1, B:44:0x01bf, B:46:0x01cf, B:48:0x01dc, B:53:0x01df, B:55:0x01f3, B:62:0x03f0, B:63:0x03fc, B:66:0x0406, B:70:0x042b, B:71:0x0419, B:78:0x0432, B:80:0x043e, B:82:0x044a, B:86:0x048f, B:87:0x0467, B:90:0x0479, B:92:0x047f, B:94:0x0489, B:97:0x04a7, B:99:0x04b3, B:102:0x04c6, B:104:0x04d7, B:106:0x04e3, B:107:0x0553, B:109:0x0559, B:110:0x0565, B:112:0x056b, B:114:0x057b, B:116:0x0585, B:117:0x0596, B:119:0x059c, B:120:0x05b7, B:122:0x05bd, B:124:0x05db, B:126:0x05ea, B:128:0x0615, B:129:0x05f3, B:131:0x0601, B:133:0x061e, B:134:0x0638, B:136:0x063e, B:139:0x0651, B:144:0x065e, B:145:0x0662, B:147:0x0668, B:149:0x0678, B:157:0x04fc, B:159:0x050a, B:162:0x051d, B:164:0x052e, B:166:0x053a, B:169:0x0220, B:172:0x022a, B:174:0x0238, B:176:0x0287, B:177:0x0257, B:179:0x0267, B:187:0x0297, B:189:0x02c3, B:190:0x02ed, B:192:0x0324, B:193:0x032a, B:196:0x0336, B:198:0x036d, B:199:0x0388, B:201:0x038e, B:203:0x039c, B:205:0x03b2, B:206:0x03a6, B:214:0x03b8, B:217:0x03bf, B:218:0x03d7, B:220:0x0138, B:222:0x0143, B:224:0x014f, B:226:0x0155, B:229:0x0160, B:234:0x06ad, B:236:0x06bb, B:238:0x06c4, B:240:0x06f7, B:241:0x06cc, B:243:0x06d6, B:245:0x06dc, B:247:0x06e8, B:249:0x06f0, B:252:0x06f9, B:253:0x0705, B:256:0x070d, B:259:0x071f, B:260:0x072a, B:262:0x0732, B:263:0x0757, B:265:0x0771, B:266:0x0786, B:268:0x07a0, B:269:0x07b5, B:271:0x07fa, B:273:0x0800, B:274:0x0827, B:276:0x082f, B:277:0x0838, B:279:0x083e, B:280:0x0844, B:282:0x0859, B:284:0x0869, B:286:0x0879, B:289:0x0882, B:291:0x0888, B:292:0x089a, B:294:0x08a0, B:297:0x08b0, B:299:0x08c8, B:301:0x08da, B:303:0x0901, B:304:0x091c, B:306:0x092e, B:307:0x094f, B:309:0x0976, B:311:0x09a6, B:313:0x0a4d, B:315:0x0a5b, B:318:0x09b8, B:320:0x09d0, B:321:0x09ed, B:323:0x0a16, B:325:0x0a44, B:332:0x0a62, B:389:0x0ad4, B:391:0x0aed, B:393:0x0b03, B:395:0x0b08, B:397:0x0b0c, B:399:0x0b10, B:401:0x0b1a, B:402:0x0b20, B:404:0x0b24, B:406:0x0b2a, B:407:0x0b3b, B:408:0x0b47, B:486:0x0b6e, B:490:0x0b75, B:501:0x080e, B:503:0x0814, B:505:0x081a, B:506:0x07b2, B:507:0x0783, B:508:0x0737, B:510:0x073d), top: B:2:0x0017, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x04b3 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0017, B:6:0x0032, B:8:0x003c, B:9:0x0055, B:12:0x0071, B:15:0x0097, B:17:0x00ce, B:20:0x00df, B:22:0x00e9, B:25:0x0693, B:26:0x011a, B:29:0x012c, B:31:0x0132, B:33:0x016d, B:35:0x017b, B:38:0x019b, B:40:0x01a1, B:42:0x01b1, B:44:0x01bf, B:46:0x01cf, B:48:0x01dc, B:53:0x01df, B:55:0x01f3, B:62:0x03f0, B:63:0x03fc, B:66:0x0406, B:70:0x042b, B:71:0x0419, B:78:0x0432, B:80:0x043e, B:82:0x044a, B:86:0x048f, B:87:0x0467, B:90:0x0479, B:92:0x047f, B:94:0x0489, B:97:0x04a7, B:99:0x04b3, B:102:0x04c6, B:104:0x04d7, B:106:0x04e3, B:107:0x0553, B:109:0x0559, B:110:0x0565, B:112:0x056b, B:114:0x057b, B:116:0x0585, B:117:0x0596, B:119:0x059c, B:120:0x05b7, B:122:0x05bd, B:124:0x05db, B:126:0x05ea, B:128:0x0615, B:129:0x05f3, B:131:0x0601, B:133:0x061e, B:134:0x0638, B:136:0x063e, B:139:0x0651, B:144:0x065e, B:145:0x0662, B:147:0x0668, B:149:0x0678, B:157:0x04fc, B:159:0x050a, B:162:0x051d, B:164:0x052e, B:166:0x053a, B:169:0x0220, B:172:0x022a, B:174:0x0238, B:176:0x0287, B:177:0x0257, B:179:0x0267, B:187:0x0297, B:189:0x02c3, B:190:0x02ed, B:192:0x0324, B:193:0x032a, B:196:0x0336, B:198:0x036d, B:199:0x0388, B:201:0x038e, B:203:0x039c, B:205:0x03b2, B:206:0x03a6, B:214:0x03b8, B:217:0x03bf, B:218:0x03d7, B:220:0x0138, B:222:0x0143, B:224:0x014f, B:226:0x0155, B:229:0x0160, B:234:0x06ad, B:236:0x06bb, B:238:0x06c4, B:240:0x06f7, B:241:0x06cc, B:243:0x06d6, B:245:0x06dc, B:247:0x06e8, B:249:0x06f0, B:252:0x06f9, B:253:0x0705, B:256:0x070d, B:259:0x071f, B:260:0x072a, B:262:0x0732, B:263:0x0757, B:265:0x0771, B:266:0x0786, B:268:0x07a0, B:269:0x07b5, B:271:0x07fa, B:273:0x0800, B:274:0x0827, B:276:0x082f, B:277:0x0838, B:279:0x083e, B:280:0x0844, B:282:0x0859, B:284:0x0869, B:286:0x0879, B:289:0x0882, B:291:0x0888, B:292:0x089a, B:294:0x08a0, B:297:0x08b0, B:299:0x08c8, B:301:0x08da, B:303:0x0901, B:304:0x091c, B:306:0x092e, B:307:0x094f, B:309:0x0976, B:311:0x09a6, B:313:0x0a4d, B:315:0x0a5b, B:318:0x09b8, B:320:0x09d0, B:321:0x09ed, B:323:0x0a16, B:325:0x0a44, B:332:0x0a62, B:389:0x0ad4, B:391:0x0aed, B:393:0x0b03, B:395:0x0b08, B:397:0x0b0c, B:399:0x0b10, B:401:0x0b1a, B:402:0x0b20, B:404:0x0b24, B:406:0x0b2a, B:407:0x0b3b, B:408:0x0b47, B:486:0x0b6e, B:490:0x0b75, B:501:0x080e, B:503:0x0814, B:505:0x081a, B:506:0x07b2, B:507:0x0783, B:508:0x0737, B:510:0x073d), top: B:2:0x0017, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzaF(String str, long j10) {
        boolean z10;
        String str2;
        String str3;
        zzpb zzpbVar;
        long parseLong;
        Long l10;
        int zzm;
        long j11;
        SecureRandom secureRandom;
        int i10;
        Long l11;
        zzpb zzpbVar2;
        long zzaj;
        String str4;
        int i11;
        Object obj;
        int i12;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        com.google.android.gms.internal.measurement.zzhr zzhrVar;
        boolean z11;
        int i13;
        boolean z12;
        com.google.android.gms.internal.measurement.zzhr zzhrVar2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        zzpf zzpfVar = this;
        String str13 = "_tr";
        String str14 = "_tu";
        String str15 = "_ai";
        String str16 = FirebaseAnalytics.Event.PURCHASE;
        String str17 = FirebaseAnalytics.Param.ITEMS;
        zzj().zzb();
        try {
            zzpb zzpbVar3 = new zzpb(zzpfVar, null);
            zzj().zzav(str, j10, zzpfVar.zzB, zzpbVar3);
            List list = zzpbVar3.zzc;
            try {
                if (list != null && !list.isEmpty()) {
                    com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) zzpbVar3.zza.zzcl();
                    zzicVar.zzi();
                    String str18 = "_efs";
                    String str19 = "Generated trigger URI. appId, uri";
                    int i26 = -1;
                    int i27 = -1;
                    com.google.android.gms.internal.measurement.zzhr zzhrVar3 = null;
                    boolean z13 = false;
                    com.google.android.gms.internal.measurement.zzhr zzhrVar4 = null;
                    int i28 = 0;
                    int i29 = 0;
                    boolean z14 = false;
                    while (true) {
                        str2 = str13;
                        str3 = str14;
                        String str20 = str17;
                        int i30 = i27;
                        if (i28 >= zzpbVar3.zzc.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhr zzhrVar5 = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzpbVar3.zzc.get(i28)).zzcl();
                        int i31 = i28;
                        if (zzh().zzj(zzpbVar3.zza.zzA(), zzhrVar5.zzk())) {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar6 = zzhrVar4;
                            zzaV().zze().zzc("Dropping blocked raw event. appId", zzgt.zzl(zzpbVar3.zza.zzA()), zzpfVar.zzn.zzl().zza(zzhrVar5.zzk()));
                            if (!zzh().zzn(zzpbVar3.zza.zzA()) && !zzh().zzo(zzpbVar3.zza.zzA()) && !"_err".equals(zzhrVar5.zzk())) {
                                zzt().zzN(zzpfVar.zzK, zzpbVar3.zza.zzA(), 11, "_ev", zzhrVar5.zzk(), 0);
                            }
                            i23 = i30;
                            i22 = i26;
                            str11 = str15;
                            str12 = str16;
                            str17 = str20;
                            i21 = i31;
                            zzhrVar4 = zzhrVar6;
                        } else {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar7 = zzhrVar4;
                            String zzk = zzhrVar5.zzk();
                            int i32 = i26;
                            if (zzk.equals(str16) || zzk.equals("_iap") || zzk.equals("ecommerce_purchase")) {
                                com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn.zzb("_ct");
                                if (!z13) {
                                    String zzA = zzpbVar3.zza.zzA();
                                    if (zzpfVar.zzaO(zzA, str16) && zzpfVar.zzaO(zzA, "_iap") && zzpfVar.zzaO(zzA, "ecommerce_purchase")) {
                                        str10 = "new";
                                        zzn.zzd(str10);
                                        zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbc());
                                        z13 = true;
                                    }
                                }
                                str10 = "returning";
                                zzn.zzd(str10);
                                zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) zzn.zzbc());
                                z13 = true;
                            }
                            if (zzhrVar5.zzk().equals(zzjl.zza(str15))) {
                                zzhrVar5.zzl(str15);
                                zzaV().zzk().zza("Renaming ad_impression to _ai");
                                if (Log.isLoggable(zzaV().zzn(), 5)) {
                                    for (int i33 = 0; i33 < zzhrVar5.zzb(); i33++) {
                                        if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhrVar5.zzc(i33).zzb()) && !zzhrVar5.zzc(i33).zzd().isEmpty() && "admob".equalsIgnoreCase(zzhrVar5.zzc(i33).zzd())) {
                                            zzaV().zzh().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                        }
                                    }
                                }
                            }
                            boolean zzk2 = zzh().zzk(zzpbVar3.zza.zzA(), zzhrVar5.zzk());
                            if (!zzk2) {
                                zzp();
                                String zzk3 = zzhrVar5.zzk();
                                Preconditions.checkNotEmpty(zzk3);
                                if (zzk3.hashCode() != 95027 || !zzk3.equals("_ui")) {
                                    str11 = str15;
                                    str12 = str16;
                                    zzhrVar = zzhrVar3;
                                    z11 = z13;
                                    zzk2 = false;
                                    if (zzk2) {
                                        ArrayList arrayList = new ArrayList(zzhrVar5.zza());
                                        int i34 = -1;
                                        int i35 = -1;
                                        for (int i36 = 0; i36 < arrayList.size(); i36++) {
                                            if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i36)).zzb())) {
                                                i34 = i36;
                                            } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i36)).zzb())) {
                                                i35 = i36;
                                            }
                                        }
                                        if (i34 != -1) {
                                            if (!((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i34)).zze() && !((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i34)).zzi()) {
                                                zzaV().zzh().zza("Value must be specified with a numeric type.");
                                                zzhrVar5.zzj(i34);
                                                zzaA(zzhrVar5, "_c");
                                                zzaz(zzhrVar5, 18, "value");
                                            } else {
                                                if (i35 != -1) {
                                                    String zzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList.get(i35)).zzd();
                                                    if (zzd.length() == 3) {
                                                        int i37 = 0;
                                                        while (i37 < zzd.length()) {
                                                            int codePointAt = zzd.codePointAt(i37);
                                                            if (Character.isLetter(codePointAt)) {
                                                                i37 += Character.charCount(codePointAt);
                                                            }
                                                        }
                                                    }
                                                }
                                                zzaV().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                zzhrVar5.zzj(i34);
                                                zzaA(zzhrVar5, "_c");
                                                zzaz(zzhrVar5, 19, FirebaseAnalytics.Param.CURRENCY);
                                                break;
                                            }
                                        }
                                    }
                                    if (!"_e".equals(zzhrVar5.zzk())) {
                                        zzp();
                                        if (zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), "_fr") == null) {
                                            if (zzhrVar != null && Math.abs(zzhrVar.zzn() - zzhrVar5.zzn()) <= 1000) {
                                                com.google.android.gms.internal.measurement.zzhr zzhrVar8 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar.clone();
                                                if (zzpfVar.zzaH(zzhrVar5, zzhrVar8)) {
                                                    zzicVar.zzf(i32, zzhrVar8);
                                                    i17 = i32;
                                                    zzhrVar4 = null;
                                                    zzhrVar = null;
                                                    i16 = i30;
                                                }
                                            }
                                            zzhrVar4 = zzhrVar5;
                                            i17 = i32;
                                            i16 = i29;
                                        } else {
                                            i15 = i32;
                                            i18 = i30;
                                            i17 = i15;
                                            zzhrVar4 = zzhrVar7;
                                            i16 = i18;
                                        }
                                    } else {
                                        i15 = i32;
                                        if ("_vs".equals(zzhrVar5.zzk())) {
                                            zzp();
                                            if (zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), "_et") == null) {
                                                if (zzhrVar7 != null && Math.abs(zzhrVar7.zzn() - zzhrVar5.zzn()) <= 1000) {
                                                    com.google.android.gms.internal.measurement.zzhr zzhrVar9 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar7.clone();
                                                    if (zzpfVar.zzaH(zzhrVar9, zzhrVar5)) {
                                                        i18 = i30;
                                                        zzicVar.zzf(i18, zzhrVar9);
                                                        i17 = i15;
                                                        zzhrVar4 = null;
                                                        zzhrVar = null;
                                                        i16 = i18;
                                                    }
                                                }
                                                zzhrVar = zzhrVar5;
                                                i16 = i30;
                                                i17 = i29;
                                                zzhrVar4 = zzhrVar7;
                                            }
                                        }
                                        i18 = i30;
                                        i17 = i15;
                                        zzhrVar4 = zzhrVar7;
                                        i16 = i18;
                                    }
                                    if (zzhrVar5.zzb() == 0) {
                                        zzp();
                                        Bundle zzE = zzpj.zzE(zzhrVar5.zza());
                                        int i38 = 0;
                                        while (i38 < zzhrVar5.zzb()) {
                                            com.google.android.gms.internal.measurement.zzhw zzc = zzhrVar5.zzc(i38);
                                            String str21 = str20;
                                            if (zzc.zzb().equals(str21) && !zzc.zzk().isEmpty()) {
                                                String zzA2 = zzpbVar3.zza.zzA();
                                                List zzk4 = zzc.zzk();
                                                Bundle[] bundleArr = new Bundle[zzk4.size()];
                                                int i39 = 0;
                                                while (i39 < zzk4.size()) {
                                                    com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzk4.get(i39);
                                                    zzp();
                                                    int i40 = i17;
                                                    Bundle zzE2 = zzpj.zzE(zzhwVar.zzk());
                                                    Iterator it = zzhwVar.zzk().iterator();
                                                    while (it.hasNext()) {
                                                        zzpfVar.zzT(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) ((com.google.android.gms.internal.measurement.zzhw) it.next()).zzcl(), zzE2, zzA2);
                                                        i16 = i16;
                                                        zzk4 = zzk4;
                                                    }
                                                    bundleArr[i39] = zzE2;
                                                    i39++;
                                                    i17 = i40;
                                                    i16 = i16;
                                                    zzk4 = zzk4;
                                                }
                                                i24 = i17;
                                                i25 = i16;
                                                zzE.putParcelableArray(str21, bundleArr);
                                            } else {
                                                i24 = i17;
                                                i25 = i16;
                                                if (!zzc.zzb().equals(str21)) {
                                                    zzpfVar.zzT(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzc.zzcl(), zzE, zzpbVar3.zza.zzA());
                                                }
                                            }
                                            i38++;
                                            i17 = i24;
                                            i16 = i25;
                                            str20 = str21;
                                        }
                                        i19 = i17;
                                        i20 = i16;
                                        str17 = str20;
                                        zzhrVar5.zzi();
                                        zzpj zzp = zzp();
                                        ArrayList arrayList2 = new ArrayList();
                                        for (String str22 : zzE.keySet()) {
                                            com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzn2.zzb(str22);
                                            Object obj2 = zzE.get(str22);
                                            if (obj2 != null) {
                                                zzp.zzd(zzn2, obj2);
                                                arrayList2.add((com.google.android.gms.internal.measurement.zzhw) zzn2.zzbc());
                                            }
                                        }
                                        Iterator it2 = arrayList2.iterator();
                                        while (it2.hasNext()) {
                                            zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) it2.next());
                                        }
                                    } else {
                                        i19 = i17;
                                        i20 = i16;
                                        str17 = str20;
                                    }
                                    i21 = i31;
                                    zzpbVar3.zzc.set(i21, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                    zzicVar.zzg(zzhrVar5);
                                    i29++;
                                    i22 = i19;
                                    i23 = i20;
                                    z13 = z11;
                                    zzhrVar3 = zzhrVar;
                                }
                            }
                            str11 = str15;
                            int i41 = 0;
                            boolean z15 = false;
                            boolean z16 = false;
                            while (true) {
                                str12 = str16;
                                if (i41 >= zzhrVar5.zzb()) {
                                    break;
                                }
                                if ("_c".equals(zzhrVar5.zzc(i41).zzb())) {
                                    com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzhrVar5.zzc(i41).zzcl();
                                    z12 = z13;
                                    zzhvVar.zzf(1L);
                                    zzhrVar5.zzd(i41, (com.google.android.gms.internal.measurement.zzhw) zzhvVar.zzbc());
                                    zzhrVar2 = zzhrVar3;
                                    i14 = 1;
                                    z15 = true;
                                } else {
                                    z12 = z13;
                                    if ("_r".equals(zzhrVar5.zzc(i41).zzb())) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar5.zzc(i41).zzcl();
                                        zzhrVar2 = zzhrVar3;
                                        zzhvVar2.zzf(1L);
                                        zzhrVar5.zzd(i41, (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zzbc());
                                        i14 = 1;
                                        z16 = true;
                                    } else {
                                        zzhrVar2 = zzhrVar3;
                                        i14 = 1;
                                    }
                                }
                                i41 += i14;
                                str16 = str12;
                                z13 = z12;
                                zzhrVar3 = zzhrVar2;
                            }
                            zzhrVar = zzhrVar3;
                            z11 = z13;
                            if (!z15 && zzk2) {
                                zzaV().zzk().zzb("Marking event as conversion", zzpfVar.zzn.zzl().zza(zzhrVar5.zzk()));
                                com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn3.zzb("_c");
                                zzn3.zzf(1L);
                                zzhrVar5.zzg(zzn3);
                            }
                            if (!z16) {
                                zzaV().zzk().zzb("Marking event as real-time", zzpfVar.zzn.zzl().zza(zzhrVar5.zzk()));
                                com.google.android.gms.internal.measurement.zzhv zzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn4.zzb("_r");
                                zzn4.zzf(1L);
                                zzhrVar5.zzg(zzn4);
                            }
                            if (zzj().zzw(zzC(), zzpbVar3.zza.zzA(), false, false, false, false, true, false, false).zze > zzd().zzm(zzpbVar3.zza.zzA(), zzfx.zzo)) {
                                zzaA(zzhrVar5, "_r");
                            } else {
                                z14 = true;
                            }
                            if (zzpo.zzh(zzhrVar5.zzk()) && zzk2 && zzj().zzw(zzC(), zzpbVar3.zza.zzA(), false, false, true, false, false, false, false).zzc > zzd().zzm(zzpbVar3.zza.zzA(), zzfx.zzn)) {
                                zzaV().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgt.zzl(zzpbVar3.zza.zzA()));
                                int i42 = 0;
                                int i43 = -1;
                                boolean z17 = false;
                                com.google.android.gms.internal.measurement.zzhv zzhvVar3 = null;
                                while (i42 < zzhrVar5.zzb()) {
                                    com.google.android.gms.internal.measurement.zzhw zzc2 = zzhrVar5.zzc(i42);
                                    if ("_c".equals(zzc2.zzb())) {
                                        zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzc2.zzcl();
                                        i13 = 1;
                                        i43 = i42;
                                    } else {
                                        if ("_err".equals(zzc2.zzb())) {
                                            z17 = true;
                                        }
                                        i13 = 1;
                                    }
                                    i42 += i13;
                                }
                                if (z17) {
                                    if (zzhvVar3 != null) {
                                        zzhrVar5.zzj(i43);
                                    } else {
                                        zzhvVar3 = null;
                                    }
                                }
                                if (zzhvVar3 != null) {
                                    com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzhvVar3.clone();
                                    zzhvVar4.zzb("_err");
                                    zzhvVar4.zzf(10L);
                                    zzhrVar5.zzd(i43, (com.google.android.gms.internal.measurement.zzhw) zzhvVar4.zzbc());
                                } else {
                                    zzaV().zzb().zzb("Did not find conversion parameter. appId", zzgt.zzl(zzpbVar3.zza.zzA()));
                                }
                            }
                            if (zzk2) {
                            }
                            if (!"_e".equals(zzhrVar5.zzk())) {
                            }
                            if (zzhrVar5.zzb() == 0) {
                            }
                            i21 = i31;
                            zzpbVar3.zzc.set(i21, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                            zzicVar.zzg(zzhrVar5);
                            i29++;
                            i22 = i19;
                            i23 = i20;
                            z13 = z11;
                            zzhrVar3 = zzhrVar;
                        }
                        i28 = i21 + 1;
                        i26 = i22;
                        i27 = i23;
                        str13 = str2;
                        str14 = str3;
                        str15 = str11;
                        str16 = str12;
                    }
                    long j12 = 0;
                    int i44 = i29;
                    int i45 = 0;
                    while (i45 < i44) {
                        com.google.android.gms.internal.measurement.zzhs zzd2 = zzicVar.zzd(i45);
                        if ("_e".equals(zzd2.zzd())) {
                            zzp();
                            if (zzpj.zzF(zzd2, "_fr") != null) {
                                zzicVar.zzj(i45);
                                i44--;
                                i45--;
                                i45++;
                            }
                        }
                        zzp();
                        com.google.android.gms.internal.measurement.zzhw zzF = zzpj.zzF(zzd2, "_et");
                        if (zzF != null) {
                            Long valueOf = zzF.zze() ? Long.valueOf(zzF.zzf()) : null;
                            if (valueOf != null && valueOf.longValue() > 0) {
                                j12 += valueOf.longValue();
                            }
                        }
                        i45++;
                    }
                    zzpfVar.zzaG(zzicVar, j12, false);
                    Iterator it3 = zzicVar.zzb().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it3.next()).zzd())) {
                            zzj().zzk(zzicVar.zzK(), "_se");
                            break;
                        }
                    }
                    if (zzpj.zzx(zzicVar, "_sid") >= 0) {
                        zzpfVar.zzaG(zzicVar, j12, true);
                    } else {
                        int zzx = zzpj.zzx(zzicVar, "_se");
                        if (zzx >= 0) {
                            zzicVar.zzr(zzx);
                            zzaV().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgt.zzl(zzpbVar3.zza.zzA()));
                        }
                    }
                    String zzA3 = zzpbVar3.zza.zzA();
                    zzaW().zzg();
                    zzu();
                    zzh zzu = zzj().zzu(zzA3);
                    if (zzu == null) {
                        zzaV().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgt.zzl(zzA3));
                    } else {
                        zzpfVar.zzI(zzu, zzicVar);
                    }
                    String zzA4 = zzpbVar3.zza.zzA();
                    zzaW().zzg();
                    zzu();
                    zzh zzu2 = zzj().zzu(zzA4);
                    if (zzu2 == null) {
                        zzaV().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgt.zzl(zzA4));
                    } else {
                        zzpfVar.zzJ(zzu2, zzicVar);
                    }
                    zzaR(zzicVar);
                    zzicVar.zzak();
                    zzjk zzjkVar = zzjk.zza;
                    zzjk zzs = zzpfVar.zzB(zzpbVar3.zza.zzA()).zzs(zzjk.zzf(zzpbVar3.zza.zzaf(), 100));
                    zzjk zzaf = zzj().zzaf(zzpbVar3.zza.zzA());
                    zzj().zzae(zzpbVar3.zza.zzA(), zzs);
                    zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
                    if (!zzs.zzo(zzjjVar) && zzaf.zzo(zzjjVar)) {
                        zzj().zzi(zzpbVar3.zza.zzA());
                    } else if (zzs.zzo(zzjjVar) && !zzaf.zzo(zzjjVar)) {
                        zzj().zzj(zzpbVar3.zza.zzA());
                    }
                    zzjj zzjjVar2 = zzjj.AD_STORAGE;
                    if (!zzs.zzo(zzjjVar2)) {
                        zzicVar.zzR();
                        zzicVar.zzU();
                        zzicVar.zzan();
                    }
                    if (!zzs.zzo(zzjjVar)) {
                        zzicVar.zzX();
                        zzicVar.zzav();
                    }
                    zzql.zza();
                    if (zzd().zzp(zzpbVar3.zza.zzA(), zzfx.zzaP) && zzt().zzX(zzpbVar3.zza.zzA()) && zzpfVar.zzB(zzpbVar3.zza.zzA()).zzo(zzjjVar2) && zzpbVar3.zza.zzak()) {
                        int i46 = 0;
                        while (i46 < zzicVar.zzc()) {
                            com.google.android.gms.internal.measurement.zzhr zzhrVar10 = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i46).zzcl();
                            Iterator it4 = zzhrVar10.zza().iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    str6 = str19;
                                    break;
                                }
                                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it4.next()).zzb())) {
                                    if (zzpbVar3.zza.zzar() >= zzd().zzm(zzpbVar3.zza.zzA(), zzfx.zzal)) {
                                        int zzm2 = zzd().zzm(zzpbVar3.zza.zzA(), zzfx.zzay);
                                        if (zzm2 <= 0) {
                                            str6 = str19;
                                            String str23 = str2;
                                            String str24 = str3;
                                            if (zzd().zzp(zzpbVar3.zza.zzA(), zzfx.zzaR)) {
                                                str7 = zzt().zzaw();
                                                com.google.android.gms.internal.measurement.zzhv zzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                zzn5.zzb(str24);
                                                zzn5.zzd(str7);
                                                zzhrVar10.zzf((com.google.android.gms.internal.measurement.zzhw) zzn5.zzbc());
                                            } else {
                                                str7 = null;
                                            }
                                            com.google.android.gms.internal.measurement.zzhv zzn6 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzn6.zzb(str23);
                                            str3 = str24;
                                            str2 = str23;
                                            zzn6.zzf(1L);
                                            zzhrVar10.zzf((com.google.android.gms.internal.measurement.zzhw) zzn6.zzbc());
                                            zzog zzf = zzp().zzf(zzpbVar3.zza.zzA(), zzicVar, zzhrVar10, str7);
                                            if (zzf != null) {
                                                zzaV().zzk().zzc(str6, zzpbVar3.zza.zzA(), zzf.zza);
                                                zzj().zzaa(zzpbVar3.zza.zzA(), zzf);
                                                Deque deque = zzpfVar.zzr;
                                                if (!deque.contains(zzpbVar3.zza.zzA())) {
                                                    deque.add(zzpbVar3.zza.zzA());
                                                }
                                            }
                                        } else if (zzj().zzw(zzC(), zzpbVar3.zza.zzA(), false, false, false, false, false, false, true).zzg > zzm2) {
                                            com.google.android.gms.internal.measurement.zzhv zzn7 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            zzn7.zzb("_tnr");
                                            zzn7.zzf(1L);
                                            zzhrVar10.zzf((com.google.android.gms.internal.measurement.zzhw) zzn7.zzbc());
                                        } else {
                                            if (zzd().zzp(zzpbVar3.zza.zzA(), zzfx.zzaR)) {
                                                str9 = zzt().zzaw();
                                                com.google.android.gms.internal.measurement.zzhv zzn8 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                                str8 = str3;
                                                zzn8.zzb(str8);
                                                zzn8.zzd(str9);
                                                zzhrVar10.zzf((com.google.android.gms.internal.measurement.zzhw) zzn8.zzbc());
                                            } else {
                                                str8 = str3;
                                                str9 = null;
                                            }
                                            com.google.android.gms.internal.measurement.zzhv zzn9 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                            String str25 = str2;
                                            zzn9.zzb(str25);
                                            zzn9.zzf(1L);
                                            zzhrVar10.zzf((com.google.android.gms.internal.measurement.zzhw) zzn9.zzbc());
                                            zzog zzf2 = zzp().zzf(zzpbVar3.zza.zzA(), zzicVar, zzhrVar10, str9);
                                            if (zzf2 != null) {
                                                str6 = str19;
                                                zzaV().zzk().zzc(str6, zzpbVar3.zza.zzA(), zzf2.zza);
                                                zzj().zzaa(zzpbVar3.zza.zzA(), zzf2);
                                                Deque deque2 = zzpfVar.zzr;
                                                if (!deque2.contains(zzpbVar3.zza.zzA())) {
                                                    deque2.add(zzpbVar3.zza.zzA());
                                                }
                                            } else {
                                                str6 = str19;
                                            }
                                            str3 = str8;
                                            str2 = str25;
                                        }
                                        zzicVar.zze(i46, (com.google.android.gms.internal.measurement.zzhs) zzhrVar10.zzbc());
                                    }
                                    str6 = str19;
                                    zzicVar.zze(i46, (com.google.android.gms.internal.measurement.zzhs) zzhrVar10.zzbc());
                                }
                            }
                            i46++;
                            str19 = str6;
                        }
                    }
                    zzicVar.zzag();
                    zzicVar.zzaf(zzm().zzb(zzicVar.zzK(), zzicVar.zzb(), zzicVar.zzk(), Long.valueOf(zzicVar.zzu()), Long.valueOf(zzicVar.zzw()), !zzs.zzo(zzjjVar)));
                    if (zzd().zzD(zzpbVar3.zza.zzA())) {
                        try {
                            HashMap hashMap = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom zzf3 = zzt().zzf();
                            int i47 = 0;
                            while (i47 < zzicVar.zzc()) {
                                com.google.android.gms.internal.measurement.zzhr zzhrVar11 = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i47).zzcl();
                                if (zzhrVar11.zzk().equals("_ep")) {
                                    zzp();
                                    String str26 = (String) zzpj.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc(), "_en");
                                    zzbc zzbcVar = (zzbc) hashMap.get(str26);
                                    if (zzbcVar == null && (zzbcVar = zzj().zzf(zzpbVar3.zza.zzA(), (String) Preconditions.checkNotNull(str26))) != null) {
                                        hashMap.put(str26, zzbcVar);
                                    }
                                    if (zzbcVar == null || zzbcVar.zzi != null) {
                                        str5 = str18;
                                    } else {
                                        Long l12 = zzbcVar.zzj;
                                        if (l12 != null && l12.longValue() > 1) {
                                            zzp();
                                            zzpj.zzC(zzhrVar11, "_sr", l12);
                                        }
                                        Boolean bool = zzbcVar.zzk;
                                        if (bool == null || !bool.booleanValue()) {
                                            str5 = str18;
                                        } else {
                                            zzp();
                                            str5 = str18;
                                            zzpj.zzC(zzhrVar11, str5, 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc());
                                    }
                                    zzicVar.zzf(i47, zzhrVar11);
                                    secureRandom = zzf3;
                                    i11 = i47;
                                    str4 = str5;
                                    zzpbVar2 = zzpbVar3;
                                    i12 = 1;
                                    str18 = str4;
                                    zzf3 = secureRandom;
                                    zzpbVar3 = zzpbVar2;
                                    i47 = i11 + i12;
                                    zzpfVar = this;
                                } else {
                                    String str27 = str18;
                                    zzhs zzh = zzh();
                                    String zzA5 = zzpbVar3.zza.zzA();
                                    String zza = zzh.zza(zzA5, "measurement.account.time_zone_offset_minutes");
                                    if (!TextUtils.isEmpty(zza)) {
                                        try {
                                            parseLong = Long.parseLong(zza);
                                        } catch (NumberFormatException e10) {
                                            zzh.zzu.zzaV().zze().zzc("Unable to parse timezone offset. appId", zzgt.zzl(zzA5), e10);
                                        }
                                        long zzaj2 = zzt().zzaj(zzhrVar11.zzn(), parseLong);
                                        com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc();
                                        Long l13 = 1L;
                                        if (!TextUtils.isEmpty("_dbg")) {
                                            Iterator it5 = zzhsVar.zza().iterator();
                                            while (true) {
                                                if (!it5.hasNext()) {
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) it5.next();
                                                Iterator it6 = it5;
                                                if (!"_dbg".equals(zzhwVar2.zzb())) {
                                                    it5 = it6;
                                                } else if (l13.equals(Long.valueOf(zzhwVar2.zzf()))) {
                                                    l10 = l13;
                                                    zzm = 1;
                                                }
                                            }
                                        }
                                        l10 = l13;
                                        zzm = zzh().zzm(zzpbVar3.zza.zzA(), zzhrVar11.zzk());
                                        if (zzm > 0) {
                                            zzaV().zze().zzc("Sample rate must be positive. event, rate", zzhrVar11.zzk(), Integer.valueOf(zzm));
                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc());
                                            zzicVar.zzf(i47, zzhrVar11);
                                            secureRandom = zzf3;
                                            i11 = i47;
                                            zzpbVar2 = zzpbVar3;
                                            str4 = str27;
                                        } else {
                                            zzbc zzbcVar2 = (zzbc) hashMap.get(zzhrVar11.zzk());
                                            if (zzbcVar2 == null) {
                                                j11 = parseLong;
                                                zzbcVar2 = zzj().zzf(zzpbVar3.zza.zzA(), zzhrVar11.zzk());
                                                if (zzbcVar2 == null) {
                                                    zzaV().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", zzpbVar3.zza.zzA(), zzhrVar11.zzk());
                                                    zzbcVar2 = new zzbc(zzpbVar3.zza.zzA(), zzhrVar11.zzk(), 1L, 1L, 1L, zzhrVar11.zzn(), 0L, null, null, null, null);
                                                }
                                            } else {
                                                j11 = parseLong;
                                            }
                                            zzp();
                                            Long l14 = (Long) zzpj.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc(), "_eid");
                                            boolean z18 = l14 != null;
                                            if (zzm == 1) {
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc());
                                                if (!z18 || (zzbcVar2.zzi == null && zzbcVar2.zzj == null && zzbcVar2.zzk == null)) {
                                                    obj = null;
                                                } else {
                                                    obj = null;
                                                    hashMap.put(zzhrVar11.zzk(), zzbcVar2.zzc(null, null, null));
                                                }
                                                zzicVar.zzf(i47, zzhrVar11);
                                                secureRandom = zzf3;
                                                i11 = i47;
                                                zzpbVar2 = zzpbVar3;
                                                str4 = str27;
                                            } else {
                                                if (zzf3.nextInt(zzm) == 0) {
                                                    zzp();
                                                    Long valueOf2 = Long.valueOf(zzm);
                                                    zzpj.zzC(zzhrVar11, "_sr", valueOf2);
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc());
                                                    if (z18) {
                                                        zzbcVar2 = zzbcVar2.zzc(null, valueOf2, null);
                                                    }
                                                    hashMap.put(zzhrVar11.zzk(), zzbcVar2.zzb(zzhrVar11.zzn(), zzaj2));
                                                    secureRandom = zzf3;
                                                    i11 = i47;
                                                    zzpbVar2 = zzpbVar3;
                                                    str4 = str27;
                                                } else {
                                                    Long l15 = zzbcVar2.zzh;
                                                    if (l15 != null) {
                                                        zzaj = l15.longValue();
                                                        secureRandom = zzf3;
                                                        i10 = i47;
                                                        l11 = l14;
                                                        zzpbVar2 = zzpbVar3;
                                                    } else {
                                                        secureRandom = zzf3;
                                                        i10 = i47;
                                                        l11 = l14;
                                                        zzpbVar2 = zzpbVar3;
                                                        zzaj = zzt().zzaj(zzhrVar11.zzp(), j11);
                                                    }
                                                    if (zzaj != zzaj2) {
                                                        zzp();
                                                        str4 = str27;
                                                        zzpj.zzC(zzhrVar11, str4, l10);
                                                        zzp();
                                                        Long valueOf3 = Long.valueOf(zzm);
                                                        zzpj.zzC(zzhrVar11, "_sr", valueOf3);
                                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc());
                                                        if (z18) {
                                                            zzbcVar2 = zzbcVar2.zzc(null, valueOf3, Boolean.TRUE);
                                                        }
                                                        hashMap.put(zzhrVar11.zzk(), zzbcVar2.zzb(zzhrVar11.zzn(), zzaj2));
                                                        i11 = i10;
                                                    } else {
                                                        str4 = str27;
                                                        if (z18) {
                                                            hashMap.put(zzhrVar11.zzk(), zzbcVar2.zzc(l11, null, null));
                                                        }
                                                        i11 = i10;
                                                        zzicVar.zzf(i11, zzhrVar11);
                                                    }
                                                }
                                                zzicVar.zzf(i11, zzhrVar11);
                                            }
                                        }
                                        i12 = 1;
                                        str18 = str4;
                                        zzf3 = secureRandom;
                                        zzpbVar3 = zzpbVar2;
                                        i47 = i11 + i12;
                                        zzpfVar = this;
                                    }
                                    parseLong = 0;
                                    long zzaj22 = zzt().zzaj(zzhrVar11.zzn(), parseLong);
                                    com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar11.zzbc();
                                    Long l132 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                    }
                                    l10 = l132;
                                    zzm = zzh().zzm(zzpbVar3.zza.zzA(), zzhrVar11.zzk());
                                    if (zzm > 0) {
                                    }
                                    i12 = 1;
                                    str18 = str4;
                                    zzf3 = secureRandom;
                                    zzpbVar3 = zzpbVar2;
                                    i47 = i11 + i12;
                                    zzpfVar = this;
                                }
                            }
                            zzpb zzpbVar4 = zzpbVar3;
                            z10 = true;
                            if (arrayList3.size() < zzicVar.zzc()) {
                                zzicVar.zzi();
                                zzicVar.zzh(arrayList3);
                            }
                            Iterator it7 = hashMap.entrySet().iterator();
                            while (it7.hasNext()) {
                                zzj().zzh((zzbc) ((Map.Entry) it7.next()).getValue());
                            }
                            zzpbVar = zzpbVar4;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            zzj().zzd();
                            throw th2;
                        }
                    } else {
                        z10 = true;
                        zzpbVar = zzpbVar3;
                    }
                    String zzA6 = zzpbVar.zza.zzA();
                    zzh zzu3 = zzj().zzu(zzA6);
                    if (zzu3 == null) {
                        zzaV().zzb().zzb("Bundling raw events w/o app info. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                    } else if (zzicVar.zzc() > 0) {
                        long zzp2 = zzu3.zzp();
                        if (zzp2 != 0) {
                            zzicVar.zzA(zzp2);
                        } else {
                            zzicVar.zzB();
                        }
                        long zzn10 = zzu3.zzn();
                        if (zzn10 != 0) {
                            zzp2 = zzn10;
                        }
                        if (zzp2 != 0) {
                            zzicVar.zzy(zzp2);
                        } else {
                            zzicVar.zzz();
                        }
                        zzu3.zzM(zzicVar.zzc());
                        zzicVar.zzaJ((int) zzu3.zzaF());
                        zzicVar.zzZ((int) zzu3.zzG());
                        zzu3.zzo(zzicVar.zzu());
                        zzu3.zzq(zzicVar.zzw());
                        String zzaa = zzu3.zzaa();
                        if (zzaa != null) {
                            zzicVar.zzaa(zzaa);
                        } else {
                            zzicVar.zzab();
                        }
                        zzj().zzv(zzu3, false, false);
                    }
                    if (zzicVar.zzc() > 0) {
                        this.zzn.zzaU();
                        com.google.android.gms.internal.measurement.zzgl zzb2 = zzh().zzb(zzpbVar.zza.zzA());
                        if (zzb2 != null && zzb2.zza()) {
                            zzicVar.zzal(zzb2.zzb());
                            zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc(), z14);
                        }
                        if (zzpbVar.zza.zzP().isEmpty()) {
                            zzicVar.zzal(-1L);
                        } else {
                            zzaV().zze().zzb("Did not find measurement config or missing version info. appId", zzgt.zzl(zzpbVar.zza.zzA()));
                        }
                        zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc(), z14);
                    }
                    zzj().zzS(zzpbVar.zzb);
                    zzj().zzT(zzA6);
                    zzj().zzc();
                } else {
                    zzj().zzc();
                    z10 = false;
                }
                zzj().zzd();
                return z10;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @VisibleForTesting
    private final void zzaG(com.google.android.gms.internal.measurement.zzic zzicVar, long j10, boolean z10) {
        String str;
        zzpm zzpmVar;
        String str2;
        Object obj;
        if (true != z10) {
            str = "_lte";
        } else {
            str = "_se";
        }
        zzpm zzm = zzj().zzm(zzicVar.zzK(), str);
        if (zzm != null && (obj = zzm.zze) != null) {
            zzpmVar = new zzpm(zzicVar.zzK(), "auto", str, zzaZ().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j10));
        } else {
            zzpmVar = new zzpm(zzicVar.zzK(), "auto", str, zzaZ().currentTimeMillis(), Long.valueOf(j10));
        }
        com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
        zzm2.zzb(str);
        zzm2.zza(zzaZ().currentTimeMillis());
        Object obj2 = zzpmVar.zze;
        zzm2.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzm2.zzbc();
        int zzx = zzpj.zzx(zzicVar, str);
        if (zzx >= 0) {
            zzicVar.zzn(zzx, zziuVar);
        } else {
            zzicVar.zzo(zziuVar);
        }
        if (j10 > 0) {
            zzj().zzl(zzpmVar);
            if (true != z10) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            zzaV().zzk().zzc("Updated engagement user property. scope, value", str2, obj2);
        }
    }

    private final boolean zzaH(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        String zzd;
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_sc");
        String str = null;
        if (zzF == null) {
            zzd = null;
        } else {
            zzd = zzF.zzd();
        }
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzF2 = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_pc");
        if (zzF2 != null) {
            str = zzF2.zzd();
        }
        if (str != null && str.equals(zzd)) {
            Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
            zzp();
            com.google.android.gms.internal.measurement.zzhw zzF3 = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_et");
            if (zzF3 != null && zzF3.zze() && zzF3.zzf() > 0) {
                long zzf = zzF3.zzf();
                zzp();
                com.google.android.gms.internal.measurement.zzhw zzF4 = zzpj.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_et");
                if (zzF4 != null && zzF4.zzf() > 0) {
                    zzf += zzF4.zzf();
                }
                zzp();
                zzpj.zzC(zzhrVar2, "_et", Long.valueOf(zzf));
                zzp();
                zzpj.zzC(zzhrVar, "_fr", 1L);
                return true;
            }
            return true;
        }
        return false;
    }

    private final boolean zzaI() {
        zzaW().zzg();
        zzu();
        if (!zzj().zzP() && TextUtils.isEmpty(zzj().zzF())) {
            return false;
        }
        return true;
    }

    private static String zzaJ(Map map, String str) {
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (str.equalsIgnoreCase((String) entry.getKey())) {
                    if (!((List) entry.getValue()).isEmpty()) {
                        return (String) ((List) entry.getValue()).get(0);
                    }
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzaK() {
        long max;
        long j10;
        zzaW().zzg();
        zzu();
        if (this.zza > 0) {
            long abs = 3600000 - Math.abs(zzaZ().elapsedRealtime() - this.zza);
            if (abs > 0) {
                zzaV().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                zzk().zzb();
                zzl().zzd();
                return;
            }
            this.zza = 0L;
        }
        if (this.zzn.zzH() && zzaI()) {
            long currentTimeMillis = zzaZ().currentTimeMillis();
            zzd();
            long max2 = Math.max(0L, ((Long) zzfx.zzO.zzb(null)).longValue());
            boolean z10 = true;
            if (!zzj().zzR() && !zzj().zzG()) {
                z10 = false;
            }
            if (z10) {
                String zzA = zzd().zzA();
                if (!TextUtils.isEmpty(zzA) && !".none.".equals(zzA)) {
                    zzd();
                    max = Math.max(0L, ((Long) zzfx.zzJ.zzb(null)).longValue());
                } else {
                    zzd();
                    max = Math.max(0L, ((Long) zzfx.zzI.zzb(null)).longValue());
                }
            } else {
                zzd();
                max = Math.max(0L, ((Long) zzfx.zzH.zzb(null)).longValue());
            }
            long zza = this.zzk.zzd.zza();
            long zza2 = this.zzk.zze.zza();
            boolean z11 = z10;
            long max3 = Math.max(zzj().zzM(), zzj().zzO());
            if (max3 != 0) {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(zza - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(zza2 - currentTimeMillis);
                j10 = abs2 + max2;
                long max4 = Math.max(abs3, abs4);
                if (z11 && max4 > 0) {
                    j10 = Math.min(abs2, max4) + max;
                }
                if (!zzp().zzs(max4, max)) {
                    j10 = max4 + max;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    int i10 = 0;
                    while (true) {
                        zzd();
                        if (i10 >= Math.min(20, Math.max(0, ((Integer) zzfx.zzQ.zzb(null)).intValue()))) {
                            break;
                        }
                        zzd();
                        j10 += Math.max(0L, ((Long) zzfx.zzP.zzb(null)).longValue()) * (1 << i10);
                        if (j10 > abs4) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (j10 != 0) {
                    zzaV().zzk().zza("Next upload time is 0");
                    zzk().zzb();
                    zzl().zzd();
                    return;
                }
                if (zzi().zzb()) {
                    long zza3 = this.zzk.zzc.zza();
                    zzd();
                    long max5 = Math.max(0L, ((Long) zzfx.zzF.zzb(null)).longValue());
                    if (!zzp().zzs(zza3, max5)) {
                        j10 = Math.max(j10, zza3 + max5);
                    }
                    zzk().zzb();
                    long currentTimeMillis2 = j10 - zzaZ().currentTimeMillis();
                    if (currentTimeMillis2 <= 0) {
                        zzd();
                        currentTimeMillis2 = Math.max(0L, ((Long) zzfx.zzK.zzb(null)).longValue());
                        this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
                    }
                    zzaV().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                    zzl().zzc(currentTimeMillis2);
                    return;
                }
                zzaV().zzk().zza("No network");
                zzk().zza();
                zzl().zzd();
                return;
            }
            j10 = 0;
            if (j10 != 0) {
            }
        } else {
            zzaV().zzk().zza("Nothing to upload or uploading impossible");
            zzk().zzb();
            zzl().zzd();
        }
    }

    private final void zzaL() {
        zzaW().zzg();
        if (!this.zzu && !this.zzv && !this.zzw) {
            zzaV().zzk().zza("Stopping uploading service(s)");
            List list = this.zzq;
            if (list == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
            return;
        }
        zzaV().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
    }

    private final Boolean zzaM(zzh zzhVar) {
        try {
            if (zzhVar.zzt() != -2147483648L) {
                if (zzhVar.zzt() == Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String zzr = zzhVar.zzr();
                if (zzr != null && zzr.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaN(String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null && !TextUtils.isEmpty(zzu.zzr())) {
            Boolean zzaM = zzaM(zzu);
            if (zzaM != null && !zzaM.booleanValue()) {
                zzaV().zzb().zzb("App version does not match; dropping. appId", zzgt.zzl(str));
                return null;
            }
            return new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL());
        }
        zzaV().zzj().zzb("No app data available; dropping", str);
        return null;
    }

    private final boolean zzaO(String str, String str2) {
        zzbc zzf = zzj().zzf(str, str2);
        if (zzf != null && zzf.zzc >= 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaP(Context context, Intent intent) {
        BroadcastOptions makeBasic;
        BroadcastOptions shareIdentityEnabled;
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 34) {
            makeBasic = BroadcastOptions.makeBasic();
            shareIdentityEnabled = makeBasic.setShareIdentityEnabled(true);
            bundle = shareIdentityEnabled.toBundle();
            context.sendBroadcast(intent, null, bundle);
            return;
        }
        context.sendBroadcast(intent);
    }

    private static final boolean zzaQ(zzr zzrVar) {
        if (!TextUtils.isEmpty(zzrVar.zzb)) {
            return true;
        }
        return false;
    }

    private static final void zzaR(com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzicVar.zzv(LongCompanionObject.MAX_VALUE);
        zzicVar.zzx(Long.MIN_VALUE);
        for (int i10 = 0; i10 < zzicVar.zzc(); i10++) {
            com.google.android.gms.internal.measurement.zzhs zzd = zzicVar.zzd(i10);
            if (zzd.zzf() < zzicVar.zzu()) {
                zzicVar.zzv(zzd.zzf());
            }
            if (zzd.zzf() > zzicVar.zzw()) {
                zzicVar.zzx(zzd.zzf());
            }
        }
    }

    private static final zzor zzaS(zzor zzorVar) {
        if (zzorVar != null) {
            if (zzorVar.zzax()) {
                return zzorVar;
            }
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzorVar.getClass())));
        }
        throw new IllegalStateException("Upload Component not created");
    }

    private static final Boolean zzaT(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzjh zza = zze.zzc(str).zza();
            zzjh zzjhVar = zzjh.UNINITIALIZED;
            int ordinal = zza.ordinal();
            if (ordinal != 0 && ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        return Boolean.FALSE;
                    }
                } else {
                    return Boolean.TRUE;
                }
            } else {
                return null;
            }
        }
        return bool;
    }

    @VisibleForTesting
    static final void zzaz(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i10, String str) {
        List zza = zzhrVar.zza();
        for (int i11 = 0; i11 < zza.size(); i11++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i11)).zzb())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzn.zzb("_err");
        zzn.zzf(i10);
        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzn.zzbc();
        com.google.android.gms.internal.measurement.zzhv zzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzn2.zzb("_ev");
        zzn2.zzd(str);
        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzn2.zzbc();
        zzhrVar.zzf(zzhwVar);
        zzhrVar.zzf(zzhwVar2);
    }

    final void zzA(String str, zzjk zzjkVar) {
        zzaW().zzg();
        zzu();
        this.zzC.put(str, zzjkVar);
        zzj().zzab(str, zzjkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjk zzB(String str) {
        zzjk zzjkVar = zzjk.zza;
        zzaW().zzg();
        zzu();
        zzjk zzjkVar2 = (zzjk) this.zzC.get(str);
        if (zzjkVar2 == null) {
            zzjkVar2 = zzj().zzZ(str);
            if (zzjkVar2 == null) {
                zzjkVar2 = zzjk.zza;
            }
            zzA(str, zzjkVar2);
        }
        return zzjkVar2;
    }

    final long zzC() {
        long currentTimeMillis = zzaZ().currentTimeMillis();
        zznm zznmVar = this.zzk;
        zznmVar.zzay();
        zznmVar.zzg();
        zzhd zzhdVar = zznmVar.zzf;
        long zza = zzhdVar.zza();
        if (zza == 0) {
            zza = zznmVar.zzu.zzk().zzf().nextInt(DateUtils.DAY) + 1;
            zzhdVar.zzb(zza);
        }
        return ((((currentTimeMillis + zza) / 1000) / 60) / 60) / 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD(zzbg zzbgVar, String str) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null && !TextUtils.isEmpty(zzu.zzr())) {
            Boolean zzaM = zzaM(zzu);
            if (zzaM == null) {
                if (!"_ui".equals(zzbgVar.zza)) {
                    zzaV().zze().zzb("Could not find package. appId", zzgt.zzl(str));
                }
            } else if (!zzaM.booleanValue()) {
                zzaV().zzb().zzb("App version does not match; dropping event. appId", zzgt.zzl(str));
                return;
            }
            zzE(zzbgVar, new zzr(str, zzu.zzf(), zzu.zzr(), zzu.zzt(), zzu.zzv(), zzu.zzx(), zzu.zzz(), (String) null, zzu.zzD(), false, zzu.zzl(), 0L, 0, zzu.zzac(), false, zzu.zzae(), zzu.zzB(), zzu.zzag(), zzB(str).zzl(), "", (String) null, zzu.zzai(), zzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu.zzao(), zzu.zzaw(), zzu.zzay(), zzu.zzaH(), 0L, zzu.zzaL()));
            return;
        }
        zzaV().zzj().zzb("No app data available; dropping event", str);
    }

    final void zzE(zzbg zzbgVar, zzr zzrVar) {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgu zza = zzgu.zza(zzbgVar);
        zzt().zzI(zza.zzd, zzj().zzW(str));
        zzt().zzG(zza, zzd().zzd(str));
        zzbg zzb2 = zza.zzb();
        if (!zzd().zzp(null, zzfx.zzbg) && "_cmp".equals(zzb2.zza)) {
            zzbe zzbeVar = zzb2.zzb;
            if ("referrer API v2".equals(zzbeVar.zzd("_cis"))) {
                String zzd = zzbeVar.zzd("gclid");
                if (!TextUtils.isEmpty(zzd)) {
                    zzab(new zzpk("_lgclid", zzb2.zzd, zzd, "auto"), zzrVar);
                }
            }
        }
        zzF(zzb2, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(zzbg zzbgVar, zzr zzrVar) {
        zzlt zzltVar;
        zzbg zzbgVar2;
        List<zzah> zzt;
        List<zzah> zzt2;
        List<zzah> zzt3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaW().zzg();
        zzu();
        long j10 = zzbgVar.zzd;
        zzgu zza = zzgu.zza(zzbgVar);
        zzaW().zzg();
        if (this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) {
            zzltVar = null;
        } else {
            zzltVar = this.zzG;
        }
        zzpo.zzav(zzltVar, zza.zzd, false);
        zzbg zzb2 = zza.zzb();
        zzp();
        if (!zzpj.zzD(zzb2, zzrVar)) {
            return;
        }
        if (!zzrVar.zzh) {
            zzan(zzrVar);
            return;
        }
        List list = zzrVar.zzr;
        if (list != null) {
            String str3 = zzb2.zza;
            if (list.contains(str3)) {
                Bundle zzf = zzb2.zzb.zzf();
                zzf.putLong("ga_safelisted", 1L);
                zzbgVar2 = new zzbg(str3, new zzbe(zzf), zzb2.zzc, zzb2.zzd);
            } else {
                zzaV().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzb2.zza, zzb2.zzc);
                return;
            }
        } else {
            zzbgVar2 = zzb2;
        }
        zzj().zzb();
        try {
            String str4 = zzbgVar2.zza;
            if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzbgVar2.zzb.zzb("_sid").longValue() != 0) {
                if (!zzj().zzQ(str2, "_f") && !zzj().zzQ(str2, "_v")) {
                    zzj().zzY(str2, Long.valueOf(zzaZ().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbgVar2));
                }
                zzj().zzY(str2, null, "_sid", zzG(str2, zzbgVar2));
            }
            zzav zzj = zzj();
            Preconditions.checkNotEmpty(str2);
            zzj.zzg();
            zzj.zzay();
            if (j10 < 0) {
                zzj.zzu.zzaV().zze().zzc("Invalid time querying timed out conditional properties", zzgt.zzl(str2), Long.valueOf(j10));
                zzt = Collections.emptyList();
            } else {
                zzt = zzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
            }
            for (zzah zzahVar : zzt) {
                if (zzahVar != null) {
                    zzaV().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                    zzbg zzbgVar3 = zzahVar.zzg;
                    if (zzbgVar3 != null) {
                        zzH(new zzbg(zzbgVar3, j10), zzrVar);
                    }
                    zzj().zzr(str2, zzahVar.zzc.zzb);
                }
            }
            zzav zzj2 = zzj();
            Preconditions.checkNotEmpty(str2);
            zzj2.zzg();
            zzj2.zzay();
            if (j10 < 0) {
                zzj2.zzu.zzaV().zze().zzc("Invalid time querying expired conditional properties", zzgt.zzl(str2), Long.valueOf(j10));
                zzt2 = Collections.emptyList();
            } else {
                zzt2 = zzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
            }
            ArrayList arrayList = new ArrayList(zzt2.size());
            for (zzah zzahVar2 : zzt2) {
                if (zzahVar2 != null) {
                    zzaV().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                    zzj().zzk(str2, zzahVar2.zzc.zzb);
                    zzbg zzbgVar4 = zzahVar2.zzk;
                    if (zzbgVar4 != null) {
                        arrayList.add(zzbgVar4);
                    }
                    zzj().zzr(str2, zzahVar2.zzc.zzb);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                zzH(new zzbg((zzbg) it.next(), j10), zzrVar);
            }
            zzav zzj3 = zzj();
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str4);
            zzj3.zzg();
            zzj3.zzay();
            if (j10 < 0) {
                zzib zzibVar = zzj3.zzu;
                zzibVar.zzaV().zze().zzd("Invalid time querying triggered conditional properties", zzgt.zzl(str2), zzibVar.zzl().zza(str4), Long.valueOf(j10));
                zzt3 = Collections.emptyList();
            } else {
                zzt3 = zzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j10)});
            }
            ArrayList arrayList2 = new ArrayList(zzt3.size());
            for (zzah zzahVar3 : zzt3) {
                if (zzahVar3 != null) {
                    zzpk zzpkVar = zzahVar3.zzc;
                    zzpm zzpmVar = new zzpm((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzpkVar.zzb, j10, Preconditions.checkNotNull(zzpkVar.zza()));
                    if (zzj().zzl(zzpmVar)) {
                        zzaV().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                    } else {
                        zzaV().zzb().zzd("Too many active user properties, ignoring", zzgt.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                    }
                    zzbg zzbgVar5 = zzahVar3.zzi;
                    if (zzbgVar5 != null) {
                        arrayList2.add(zzbgVar5);
                    }
                    zzahVar3.zzc = new zzpk(zzpmVar);
                    zzahVar3.zze = true;
                    zzj().zzp(zzahVar3);
                }
            }
            zzH(zzbgVar2, zzrVar);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                zzH(new zzbg((zzbg) it2.next(), j10), zzrVar);
            }
            zzj().zzc();
            zzj().zzd();
        } catch (Throwable th) {
            zzj().zzd();
            throw th;
        }
    }

    final Bundle zzG(String str, zzbg zzbgVar) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbgVar.zzb.zzb("_sid").longValue());
        zzpm zzm = zzj().zzm(str, "_sno");
        if (zzm != null) {
            Object obj = zzm.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:370|(2:372|(10:374|375|376|(1:378)|57|(0)(0)|60|(0)(0)|66|67))|379|380|381|382|383|375|376|(0)|57|(0)(0)|60|(0)(0)|66|67) */
    /* JADX WARN: Can't wrap try/catch for region: R(57:336|337|338|114|(0)|117|(0)(0)|124|(0)|127|(0)|130|(0)|133|(0)|136|(0)|139|(0)|142|(1:144)|333|157|(0)|160|(0)(0)|(35:164|166|(1:167)|300|181|(0)|(0)|186|(0)|189|(0)|291|213|(0)|218|(0)(0)|224|(0)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|272)|258|259|260|(0)(0)|263|264|265)|301|(0)|186|(0)|189|(0)|291|213|(0)|218|(0)(0)|224|(0)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|272)|258|259|260|(0)(0)|263|264|265) */
    /* JADX WARN: Can't wrap try/catch for region: R(66:68|(2:70|(3:72|(1:74)|75))|76|(2:78|(3:80|(1:82)|83))|84|85|(1:87)(1:342)|88|(2:92|(1:94))|95|(2:101|(2:103|104))|107|(6:108|109|110|111|112|113)|114|(1:116)|117|(2:119|(1:123)(1:122))(1:334)|124|(1:126)|127|(1:129)|130|(1:132)|133|(1:135)|136|(1:138)|139|(1:141)|142|(1:333)(6:146|(1:150)|151|(1:153)(1:332)|154|(1:156)(15:303|(1:305)(1:331)|306|(1:308)(1:330)|309|(1:311)(1:329)|312|(1:314)(1:328)|315|(1:317)(1:327)|318|(1:320)(1:326)|321|(1:323)(1:325)|324))|157|(1:159)|160|(1:162)(1:302)|(34:166|(4:169|(3:171|172|(3:174|175|(3:177|178|180)(1:292))(1:294))(1:299)|293|167)|300|181|(1:183)|(1:185)|186|(1:188)|189|(2:193|(4:195|(1:197)|198|(28:206|(1:208)(1:290)|209|(1:211)|212|213|(2:215|(1:217))|218|(3:220|(1:222)|223)(1:289)|224|(1:228)|229|(1:231)|232|(4:235|(2:241|242)|243|233)|247|248|249|250|251|(2:252|(2:254|(1:256)(1:272))(3:273|274|(1:279)(1:278)))|258|259|260|(1:262)(2:267|268)|263|264|265)))|291|213|(0)|218|(0)(0)|224|(2:226|228)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|272)|258|259|260|(0)(0)|263|264|265)|301|(0)|186|(0)|189|(3:191|193|(0))|291|213|(0)|218|(0)(0)|224|(0)|229|(0)|232|(1:233)|247|248|249|250|251|(3:252|(0)(0)|272)|258|259|260|(0)(0)|263|264|265) */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0a77, code lost:
    
        r31 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0b28, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0b30, code lost:
    
        r2.zzu.zzaV().zzb().zzc("Error storing raw event. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r4.zza), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0b46, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x0b63, code lost:
    
        zzaV().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r3.zzK()), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0298, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x029a, code lost:
    
        r8.zzu.zzaV().zzb().zzc("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r15), r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0529 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x056a A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x061d A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0628 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0633 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x063e A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x064a A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x065b A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0737 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x075d A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0791 A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x07f2 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0802 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0825 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0839 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x08f3 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x090a A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0972 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0993 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x09af A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0a6d A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0b14 A[Catch: all -> 0x0178, SQLiteException -> 0x0b28, TRY_LEAVE, TryCatch #1 {SQLiteException -> 0x0b28, blocks: (B:260:0x0b03, B:262:0x0b14), top: B:259:0x0b03, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0b2b  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0a7a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0969  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0762 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x05d9 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x031c A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x02d0 A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x037e A[Catch: all -> 0x0178, TryCatch #7 {all -> 0x0178, blocks: (B:42:0x0157, B:45:0x0166, B:47:0x016e, B:50:0x017c, B:57:0x0308, B:60:0x033b, B:62:0x037e, B:64:0x0385, B:65:0x039c, B:70:0x03a9, B:72:0x03c1, B:74:0x03c8, B:75:0x03df, B:78:0x0403, B:82:0x0426, B:83:0x043d, B:84:0x0446, B:87:0x0465, B:88:0x047e, B:90:0x0486, B:92:0x0492, B:94:0x0498, B:95:0x049f, B:97:0x04ac, B:99:0x04b4, B:101:0x04bc, B:104:0x04c6, B:107:0x04d2, B:109:0x04df, B:112:0x0504, B:116:0x0529, B:117:0x053e, B:119:0x056a, B:122:0x0581, B:123:0x05bd, B:124:0x05e5, B:126:0x061d, B:127:0x0620, B:129:0x0628, B:130:0x062b, B:132:0x0633, B:133:0x0636, B:135:0x063e, B:136:0x0641, B:138:0x064a, B:139:0x064e, B:141:0x065b, B:142:0x065e, B:144:0x068a, B:146:0x0694, B:150:0x06ab, B:154:0x06b8, B:157:0x072f, B:159:0x0737, B:160:0x073a, B:162:0x075d, B:164:0x0768, B:166:0x0771, B:167:0x078b, B:169:0x0791, B:172:0x07a5, B:175:0x07b1, B:178:0x07be, B:297:0x07d8, B:181:0x07e8, B:185:0x07f2, B:186:0x07f5, B:188:0x0802, B:189:0x0807, B:191:0x0825, B:193:0x0829, B:195:0x0839, B:197:0x0844, B:198:0x084d, B:200:0x0857, B:202:0x0863, B:204:0x086d, B:206:0x0873, B:208:0x0883, B:209:0x0897, B:211:0x089d, B:212:0x08a6, B:213:0x08b7, B:215:0x08f3, B:217:0x08fd, B:218:0x0900, B:220:0x090a, B:222:0x0927, B:223:0x0932, B:224:0x096a, B:226:0x0972, B:228:0x097c, B:229:0x0989, B:231:0x0993, B:232:0x09a0, B:233:0x09a9, B:235:0x09af, B:237:0x09eb, B:239:0x09f5, B:241:0x0a07, B:248:0x0a0d, B:250:0x0a51, B:251:0x0a5c, B:252:0x0a67, B:254:0x0a6d, B:258:0x0ab8, B:260:0x0b03, B:262:0x0b14, B:263:0x0b78, B:268:0x0b2d, B:271:0x0b30, B:274:0x0a7a, B:276:0x0aa4, B:283:0x0b4b, B:284:0x0b62, B:288:0x0b63, B:302:0x0762, B:303:0x06c3, B:306:0x06cf, B:309:0x06dd, B:312:0x06eb, B:315:0x06f9, B:318:0x0707, B:321:0x0713, B:324:0x0720, B:334:0x05d9, B:338:0x0511, B:343:0x031c, B:344:0x0323, B:346:0x0329, B:349:0x0335, B:354:0x0199, B:356:0x01a7, B:358:0x01bc, B:363:0x01dc, B:366:0x0212, B:368:0x0218, B:370:0x0226, B:372:0x0234, B:374:0x0243, B:376:0x02c6, B:378:0x02d0, B:380:0x026d, B:382:0x0286, B:383:0x02ad, B:387:0x029a, B:389:0x01e8, B:391:0x0206), top: B:41:0x0157, inners: #0, #1, #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzH(zzbg zzbgVar, zzr zzrVar) {
        String str;
        String str2;
        long longValue;
        String str3;
        String str4;
        zzbg zzbgVar2;
        String str5;
        zzpm zzpmVar;
        zzpm zzpmVar2;
        zzbe zzbeVar;
        long j10;
        long zzH;
        String str6;
        long j11;
        zzbb zzbbVar;
        String str7;
        zzbc zzf;
        zzbc zza;
        String str8;
        String str9;
        String str10;
        String str11;
        long j12;
        String str12;
        long j13;
        Map emptyMap;
        ArrayList arrayList;
        String str13;
        zzjk zzs;
        zzjj zzjjVar;
        zzjk zzjkVar;
        zzjj zzjjVar2;
        String str14;
        zzib zzibVar;
        zzh zzu;
        List zzn;
        int i10;
        zzav zzj;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        zzav zzj2;
        zzbd zzbdVar;
        int i11;
        ContentValues contentValues;
        Pair zzc;
        zzh zzu2;
        zzpm zzm;
        Preconditions.checkNotNull(zzrVar);
        String str15 = zzrVar.zza;
        Preconditions.checkNotEmpty(str15);
        long nanoTime = System.nanoTime();
        zzaW().zzg();
        zzu();
        zzp();
        if (zzpj.zzD(zzbgVar, zzrVar)) {
            if (!zzrVar.zzh) {
                zzan(zzrVar);
                return;
            }
            zzhs zzh = zzh();
            String str16 = zzbgVar.zza;
            if (zzh.zzj(str15, str16)) {
                zzaV().zze().zzc("Dropping blocked event. appId", zzgt.zzl(str15), this.zzn.zzl().zza(str16));
                if (!zzh().zzn(str15) && !zzh().zzo(str15)) {
                    if ("_err".equals(str16)) {
                        return;
                    }
                    zzt().zzN(this.zzK, str15, 11, "_ev", str16, 0);
                    return;
                }
                zzh zzu3 = zzj().zzu(str15);
                if (zzu3 != null) {
                    long abs = Math.abs(zzaZ().currentTimeMillis() - Math.max(zzu3.zzJ(), zzu3.zzH()));
                    zzd();
                    if (abs > ((Long) zzfx.zzN.zzb(null)).longValue()) {
                        zzaV().zzj().zza("Fetching config for blocked app");
                        zzV(zzu3);
                        return;
                    }
                    return;
                }
                return;
            }
            zzgu zza2 = zzgu.zza(zzbgVar);
            zzt().zzG(zza2, zzd().zzd(str15));
            int zzn2 = zzd().zzn(str15, zzfx.zzag, 10, 35);
            Bundle bundle = zza2.zzd;
            for (String str17 : new TreeSet(bundle.keySet())) {
                if (FirebaseAnalytics.Param.ITEMS.equals(str17)) {
                    zzt().zzH(bundle.getParcelableArray(str17), zzn2);
                }
            }
            zzbg zzb2 = zza2.zzb();
            if (Log.isLoggable(zzaV().zzn(), 2)) {
                zzaV().zzk().zzb("Logging event", this.zzn.zzl().zzd(zzb2));
            }
            zzj().zzb();
            try {
                zzan(zzrVar);
                String str18 = zzb2.zza;
                boolean z10 = "ecommerce_purchase".equals(str18) || FirebaseAnalytics.Event.PURCHASE.equals(str18) || FirebaseAnalytics.Event.REFUND.equals(str18);
                if (!"_iap".equals(str18)) {
                    if (!z10) {
                        str3 = "value";
                        str = "app_id";
                        str2 = "_fx";
                        str4 = "raw_events";
                        zzbgVar2 = zzb2;
                        str5 = "_err";
                        String str19 = zzbgVar2.zza;
                        boolean zzh2 = zzpo.zzh(str19);
                        boolean equals = str5.equals(str19);
                        zzt();
                        zzbeVar = zzbgVar2.zzb;
                        if (zzbeVar != null) {
                            j10 = 0;
                        } else {
                            zzbd zzbdVar2 = new zzbd(zzbeVar);
                            j10 = 0;
                            while (zzbdVar2.hasNext()) {
                                if (zzbeVar.zza(zzbdVar2.next()) instanceof Parcelable[]) {
                                    j10 += ((Parcelable[]) r11).length;
                                }
                            }
                        }
                        zzbg zzbgVar3 = zzbgVar2;
                        zzar zzx = zzj().zzx(zzC(), str15, j10 + 1, true, zzh2, false, equals, false, false, false);
                        long j14 = zzx.zzb;
                        zzd();
                        zzH = j14 - zzal.zzH();
                        if (zzH <= 0) {
                            if (zzH % 1000 == 1) {
                                zzaV().zzb().zzc("Data loss. Too many events logged. appId, count", zzgt.zzl(str15), Long.valueOf(zzx.zzb));
                            }
                            zzj().zzc();
                        } else {
                            if (zzh2) {
                                long j15 = zzx.zza;
                                zzd();
                                long intValue = j15 - ((Integer) zzfx.zzm.zzb(null)).intValue();
                                if (intValue > 0) {
                                    if (intValue % 1000 == 1) {
                                        zzaV().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgt.zzl(str15), Long.valueOf(zzx.zza));
                                    }
                                    zzt().zzN(this.zzK, str15, 16, "_ev", zzbgVar3.zza, 0);
                                    zzj().zzc();
                                }
                            }
                            if (equals) {
                                long max = zzx.zzd - Math.max(0, Math.min(1000000, zzd().zzm(zzrVar.zza, zzfx.zzl)));
                                if (max > 0) {
                                    if (max == 1) {
                                        zzaV().zzb().zzc("Too many error events logged. appId, count", zzgt.zzl(str15), Long.valueOf(zzx.zzd));
                                    }
                                    zzj().zzc();
                                }
                            }
                            Bundle zzf2 = zzbeVar.zzf();
                            zzpo zzt = zzt();
                            String str20 = zzbgVar3.zzc;
                            zzt.zzM(zzf2, "_o", str20);
                            if (zzt().zzaa(str15, zzrVar.zzB)) {
                                zzt().zzM(zzf2, "_dbg", 1L);
                                zzt().zzM(zzf2, "_r", 1L);
                            }
                            if ("_s".equals(str19) && (zzm = zzj().zzm(zzrVar.zza, "_sno")) != null) {
                                Object obj = zzm.zze;
                                if (obj instanceof Long) {
                                    zzt().zzM(zzf2, "_sno", obj);
                                }
                            }
                            if (zzd().zzp(null, zzfx.zzaX) && Objects.equals(str20, "am") && Objects.equals(str19, "_ai")) {
                                String str21 = str3;
                                Object obj2 = zzf2.get(str21);
                                if (obj2 instanceof String) {
                                    try {
                                        double parseDouble = Double.parseDouble((String) obj2);
                                        zzf2.remove(str21);
                                        zzf2.putDouble(str21, parseDouble);
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                            }
                            zzav zzj3 = zzj();
                            Preconditions.checkNotEmpty(str15);
                            zzj3.zzg();
                            zzj3.zzay();
                            try {
                                str6 = str4;
                                try {
                                    j11 = zzj3.zze().delete(str6, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str15, String.valueOf(Math.max(0, Math.min(1000000, zzj3.zzu.zzc().zzm(str15, zzfx.zzp))))});
                                } catch (SQLiteException e10) {
                                    e = e10;
                                    zzj3.zzu.zzaV().zzb().zzc("Error deleting over the limit events. appId", zzgt.zzl(str15), e);
                                    j11 = 0;
                                    if (j11 > 0) {
                                    }
                                    zzib zzibVar2 = this.zzn;
                                    str7 = str6;
                                    zzbbVar = new zzbb(zzibVar2, zzbgVar3.zzc, str15, zzbgVar3.zza, zzbgVar3.zzd, 0L, zzf2);
                                    zzav zzj4 = zzj();
                                    String str22 = zzbbVar.zzb;
                                    zzf = zzj4.zzf(str15, str22);
                                    if (zzf == null) {
                                    }
                                    zzj().zzh(zza);
                                    zzaW().zzg();
                                    zzu();
                                    Preconditions.checkNotNull(zzbbVar);
                                    Preconditions.checkNotNull(zzrVar);
                                    String str23 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str23);
                                    str8 = zzrVar.zza;
                                    Preconditions.checkArgument(str23.equals(str8));
                                    com.google.android.gms.internal.measurement.zzic zzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                    boolean z11 = true;
                                    zzaE.zza(1);
                                    zzaE.zzC("android");
                                    if (!TextUtils.isEmpty(str8)) {
                                    }
                                    str9 = zzrVar.zzd;
                                    if (!TextUtils.isEmpty(str9)) {
                                    }
                                    str10 = zzrVar.zzc;
                                    if (!TextUtils.isEmpty(str10)) {
                                    }
                                    str11 = zzrVar.zzu;
                                    if (!TextUtils.isEmpty(str11)) {
                                    }
                                    j12 = zzrVar.zzj;
                                    if (j12 != -2147483648L) {
                                    }
                                    zzaE.zzN(zzrVar.zze);
                                    str12 = zzrVar.zzb;
                                    if (!TextUtils.isEmpty(str12)) {
                                    }
                                    zzjk zzs2 = zzB((String) Preconditions.checkNotNull(str8)).zzs(zzjk.zzf(zzrVar.zzs, 100));
                                    zzaE.zzat(zzs2.zzk());
                                    zzql.zza();
                                    if (!zzd().zzp(str8, zzfx.zzaP)) {
                                    }
                                    j13 = zzrVar.zzf;
                                    if (j13 != 0) {
                                    }
                                    zzaE.zzar(zzrVar.zzq);
                                    zzpj zzp = zzp();
                                    com.google.android.gms.internal.measurement.zzjq zza3 = com.google.android.gms.internal.measurement.zzjq.zza(zzp.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzka.zza("com.google.android.gms.measurement"), zzfu.zza);
                                    if (zza3 != null) {
                                    }
                                    if (emptyMap != null) {
                                        arrayList = new ArrayList();
                                        int intValue2 = ((Integer) zzfx.zzaf.zzb(null)).intValue();
                                        while (r6.hasNext()) {
                                        }
                                        if (arrayList.isEmpty()) {
                                        }
                                        if (arrayList != null) {
                                        }
                                        if (zzd().zzp(null, zzfx.zzbb)) {
                                        }
                                        str13 = zzrVar.zza;
                                        zzs = zzB((String) Preconditions.checkNotNull(str13)).zzs(zzjk.zzf(zzrVar.zzs, 100));
                                        zzjjVar = zzjj.AD_STORAGE;
                                        if (zzs.zzo(zzjjVar)) {
                                        }
                                        zzjkVar = zzs;
                                        zzjjVar2 = zzjjVar;
                                        str14 = "_r";
                                        zzibVar = this.zzn;
                                        zzibVar.zzu().zzw();
                                        zzaE.zzF(Build.MODEL);
                                        zzibVar.zzu().zzw();
                                        zzaE.zzE(Build.VERSION.RELEASE);
                                        zzaE.zzI((int) zzibVar.zzu().zzb());
                                        zzaE.zzH(zzibVar.zzu().zzc());
                                        zzaE.zzay(zzrVar.zzw);
                                        if (zzibVar.zzB()) {
                                        }
                                        zzu = zzj().zzu(str13);
                                        if (zzu == null) {
                                        }
                                        if (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE)) {
                                        }
                                        if (!TextUtils.isEmpty(zzu.zzl())) {
                                        }
                                        zzn = zzj().zzn(str13);
                                        while (i10 < zzn.size()) {
                                        }
                                        zzj = zzj();
                                        zzidVar = (com.google.android.gms.internal.measurement.zzid) zzaE.zzbc();
                                        zzj.zzg();
                                        zzj.zzay();
                                        Preconditions.checkNotNull(zzidVar);
                                        Preconditions.checkNotEmpty(zzidVar.zzA());
                                        byte[] zzcc = zzidVar.zzcc();
                                        long zzt2 = zzj.zzg.zzp().zzt(zzcc);
                                        ContentValues contentValues2 = new ContentValues();
                                        String str24 = str;
                                        contentValues2.put(str24, zzidVar.zzA());
                                        contentValues2.put("metadata_fingerprint", Long.valueOf(zzt2));
                                        contentValues2.put("metadata", zzcc);
                                        zzj.zze().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                        zzj2 = zzj();
                                        zzbdVar = new zzbd(zzbbVar.zzf);
                                        while (true) {
                                            if (zzbdVar.hasNext()) {
                                            }
                                        }
                                        zzj2.zzg();
                                        zzj2.zzay();
                                        Preconditions.checkNotNull(zzbbVar);
                                        String str25 = zzbbVar.zza;
                                        Preconditions.checkNotEmpty(str25);
                                        byte[] zzcc2 = zzj2.zzg.zzp().zzh(zzbbVar).zzcc();
                                        contentValues = new ContentValues();
                                        contentValues.put(str24, str25);
                                        contentValues.put("name", zzbbVar.zzb);
                                        contentValues.put(HeaderInterceptor.TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(zzt2));
                                        contentValues.put("data", zzcc2);
                                        contentValues.put("realtime", Integer.valueOf(i11));
                                        if (zzj2.zze().insert(str7, null, contentValues) == -1) {
                                        }
                                        zzj().zzc();
                                        zzj().zzd();
                                        zzaK();
                                        zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                        return;
                                    }
                                    arrayList = null;
                                    if (arrayList != null) {
                                    }
                                    if (zzd().zzp(null, zzfx.zzbb)) {
                                    }
                                    str13 = zzrVar.zza;
                                    zzs = zzB((String) Preconditions.checkNotNull(str13)).zzs(zzjk.zzf(zzrVar.zzs, 100));
                                    zzjjVar = zzjj.AD_STORAGE;
                                    if (zzs.zzo(zzjjVar)) {
                                    }
                                    zzjkVar = zzs;
                                    zzjjVar2 = zzjjVar;
                                    str14 = "_r";
                                    zzibVar = this.zzn;
                                    zzibVar.zzu().zzw();
                                    zzaE.zzF(Build.MODEL);
                                    zzibVar.zzu().zzw();
                                    zzaE.zzE(Build.VERSION.RELEASE);
                                    zzaE.zzI((int) zzibVar.zzu().zzb());
                                    zzaE.zzH(zzibVar.zzu().zzc());
                                    zzaE.zzay(zzrVar.zzw);
                                    if (zzibVar.zzB()) {
                                    }
                                    zzu = zzj().zzu(str13);
                                    if (zzu == null) {
                                    }
                                    if (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE)) {
                                    }
                                    if (!TextUtils.isEmpty(zzu.zzl())) {
                                    }
                                    zzn = zzj().zzn(str13);
                                    while (i10 < zzn.size()) {
                                    }
                                    zzj = zzj();
                                    zzidVar = (com.google.android.gms.internal.measurement.zzid) zzaE.zzbc();
                                    zzj.zzg();
                                    zzj.zzay();
                                    Preconditions.checkNotNull(zzidVar);
                                    Preconditions.checkNotEmpty(zzidVar.zzA());
                                    byte[] zzcc3 = zzidVar.zzcc();
                                    long zzt22 = zzj.zzg.zzp().zzt(zzcc3);
                                    ContentValues contentValues22 = new ContentValues();
                                    String str242 = str;
                                    contentValues22.put(str242, zzidVar.zzA());
                                    contentValues22.put("metadata_fingerprint", Long.valueOf(zzt22));
                                    contentValues22.put("metadata", zzcc3);
                                    zzj.zze().insertWithOnConflict("raw_events_metadata", null, contentValues22, 4);
                                    zzj2 = zzj();
                                    zzbdVar = new zzbd(zzbbVar.zzf);
                                    while (true) {
                                        if (zzbdVar.hasNext()) {
                                        }
                                    }
                                    zzj2.zzg();
                                    zzj2.zzay();
                                    Preconditions.checkNotNull(zzbbVar);
                                    String str252 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str252);
                                    byte[] zzcc22 = zzj2.zzg.zzp().zzh(zzbbVar).zzcc();
                                    contentValues = new ContentValues();
                                    contentValues.put(str242, str252);
                                    contentValues.put("name", zzbbVar.zzb);
                                    contentValues.put(HeaderInterceptor.TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(zzt22));
                                    contentValues.put("data", zzcc22);
                                    contentValues.put("realtime", Integer.valueOf(i11));
                                    if (zzj2.zze().insert(str7, null, contentValues) == -1) {
                                    }
                                    zzj().zzc();
                                    zzj().zzd();
                                    zzaK();
                                    zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                    return;
                                }
                            } catch (SQLiteException e11) {
                                e = e11;
                                str6 = str4;
                            }
                            if (j11 > 0) {
                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgt.zzl(str15), Long.valueOf(j11));
                            }
                            zzib zzibVar22 = this.zzn;
                            str7 = str6;
                            zzbbVar = new zzbb(zzibVar22, zzbgVar3.zzc, str15, zzbgVar3.zza, zzbgVar3.zzd, 0L, zzf2);
                            zzav zzj42 = zzj();
                            String str222 = zzbbVar.zzb;
                            zzf = zzj42.zzf(str15, str222);
                            if (zzf == null) {
                                zzbbVar = zzbbVar.zza(zzibVar22, zzf.zzf);
                                zza = zzf.zza(zzbbVar.zzd);
                            } else if (zzj().zzU(str15) >= zzd().zzh(str15) && zzh2) {
                                zzaV().zzb().zzd("Too many event names used, ignoring event. appId, name, supported count", zzgt.zzl(str15), zzibVar22.zzl().zza(str222), Integer.valueOf(zzd().zzh(str15)));
                                zzt().zzN(this.zzK, str15, 8, null, null, 0);
                            } else {
                                zza = new zzbc(str15, str222, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                            }
                            zzj().zzh(zza);
                            zzaW().zzg();
                            zzu();
                            Preconditions.checkNotNull(zzbbVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str232 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str232);
                            str8 = zzrVar.zza;
                            Preconditions.checkArgument(str232.equals(str8));
                            com.google.android.gms.internal.measurement.zzic zzaE2 = com.google.android.gms.internal.measurement.zzid.zzaE();
                            boolean z112 = true;
                            zzaE2.zza(1);
                            zzaE2.zzC("android");
                            if (!TextUtils.isEmpty(str8)) {
                                zzaE2.zzL(str8);
                            }
                            str9 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str9)) {
                                zzaE2.zzJ(str9);
                            }
                            str10 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str10)) {
                                zzaE2.zzM(str10);
                            }
                            str11 = zzrVar.zzu;
                            if (!TextUtils.isEmpty(str11)) {
                                zzaE2.zzau(str11);
                            }
                            j12 = zzrVar.zzj;
                            if (j12 != -2147483648L) {
                                zzaE2.zzaj((int) j12);
                            }
                            zzaE2.zzN(zzrVar.zze);
                            str12 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str12)) {
                                zzaE2.zzad(str12);
                            }
                            zzjk zzs22 = zzB((String) Preconditions.checkNotNull(str8)).zzs(zzjk.zzf(zzrVar.zzs, 100));
                            zzaE2.zzat(zzs22.zzk());
                            zzql.zza();
                            if (!zzd().zzp(str8, zzfx.zzaP) && zzt().zzX(str8)) {
                                zzaE2.zzaH(zzrVar.zzz);
                                long j16 = zzrVar.zzA;
                                if (!zzs22.zzo(zzjj.AD_STORAGE) && j16 != 0) {
                                    j16 = (j16 & (-2)) | 32;
                                }
                                zzaE2.zzaz(j16 == 1);
                                if (j16 != 0) {
                                    com.google.android.gms.internal.measurement.zzhd zzh3 = com.google.android.gms.internal.measurement.zzhe.zzh();
                                    if ((j16 & 1) == 0) {
                                        z112 = false;
                                    }
                                    zzh3.zza(z112);
                                    zzh3.zzb((j16 & 2) != 0);
                                    zzh3.zzc((j16 & 4) != 0);
                                    zzh3.zzd((j16 & 8) != 0);
                                    zzh3.zze((j16 & 16) != 0);
                                    zzh3.zzf((j16 & 32) != 0);
                                    zzh3.zzg((64 & j16) != 0);
                                    zzaE2.zzaI((com.google.android.gms.internal.measurement.zzhe) zzh3.zzbc());
                                }
                            }
                            j13 = zzrVar.zzf;
                            if (j13 != 0) {
                                zzaE2.zzY(j13);
                            }
                            zzaE2.zzar(zzrVar.zzq);
                            zzpj zzp2 = zzp();
                            com.google.android.gms.internal.measurement.zzjq zza32 = com.google.android.gms.internal.measurement.zzjq.zza(zzp2.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzka.zza("com.google.android.gms.measurement"), zzfu.zza);
                            emptyMap = zza32 != null ? Collections.emptyMap() : zza32.zzb();
                            try {
                                if (emptyMap != null && !emptyMap.isEmpty()) {
                                    arrayList = new ArrayList();
                                    int intValue22 = ((Integer) zzfx.zzaf.zzb(null)).intValue();
                                    for (Map.Entry entry : emptyMap.entrySet()) {
                                        if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                            try {
                                                int parseInt = Integer.parseInt((String) entry.getValue());
                                                if (parseInt != 0) {
                                                    arrayList.add(Integer.valueOf(parseInt));
                                                    if (arrayList.size() >= intValue22) {
                                                        zzp2.zzu.zzaV().zze().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                                        break;
                                                    }
                                                    continue;
                                                } else {
                                                    continue;
                                                }
                                            } catch (NumberFormatException e12) {
                                                zzp2.zzu.zzaV().zze().zzb("Experiment ID NumberFormatException", e12);
                                            }
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                    }
                                    if (arrayList != null) {
                                        zzaE2.zzaq(arrayList);
                                    }
                                    if (zzd().zzp(null, zzfx.zzbb)) {
                                        zzaE2.zzaP("");
                                    }
                                    str13 = zzrVar.zza;
                                    zzs = zzB((String) Preconditions.checkNotNull(str13)).zzs(zzjk.zzf(zzrVar.zzs, 100));
                                    zzjjVar = zzjj.AD_STORAGE;
                                    if (zzs.zzo(zzjjVar) && zzrVar.zzn) {
                                        zzc = this.zzk.zzc(str13, zzs);
                                        if (!TextUtils.isEmpty((CharSequence) zzc.first)) {
                                            zzaE2.zzQ((String) zzc.first);
                                            Object obj3 = zzc.second;
                                            if (obj3 != null) {
                                                zzaE2.zzT(((Boolean) obj3).booleanValue());
                                            }
                                            String str26 = str2;
                                            if (!zzbbVar.zzb.equals(str26) && !((String) zzc.first).equals("00000000-0000-0000-0000-000000000000") && (zzu2 = zzj().zzu(str13)) != null && zzu2.zzaq()) {
                                                zzR(str13, false, null, null);
                                                Bundle bundle2 = new Bundle();
                                                Long zzas = zzu2.zzas();
                                                if (zzas != null) {
                                                    long longValue2 = zzas.longValue();
                                                    zzjkVar = zzs;
                                                    zzjjVar2 = zzjjVar;
                                                    bundle2.putLong("_pfo", Math.max(0L, longValue2));
                                                } else {
                                                    zzjkVar = zzs;
                                                    zzjjVar2 = zzjjVar;
                                                }
                                                Long zzau = zzu2.zzau();
                                                if (zzau != null) {
                                                    bundle2.putLong("_uwa", zzau.longValue());
                                                }
                                                str14 = "_r";
                                                bundle2.putLong(str14, 1L);
                                                this.zzK.zza(str13, str26, bundle2);
                                                zzibVar = this.zzn;
                                                zzibVar.zzu().zzw();
                                                zzaE2.zzF(Build.MODEL);
                                                zzibVar.zzu().zzw();
                                                zzaE2.zzE(Build.VERSION.RELEASE);
                                                zzaE2.zzI((int) zzibVar.zzu().zzb());
                                                zzaE2.zzH(zzibVar.zzu().zzc());
                                                zzaE2.zzay(zzrVar.zzw);
                                                if (zzibVar.zzB()) {
                                                    zzaE2.zzK();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzaE2.zzam(null);
                                                    }
                                                }
                                                zzu = zzj().zzu(str13);
                                                if (zzu == null) {
                                                    zzu = new zzh(zzibVar, str13);
                                                    zzu.zze(zzK(zzjkVar));
                                                    zzu.zzm(zzrVar.zzk);
                                                    zzu.zzg(zzrVar.zzb);
                                                    if (zzjkVar.zzo(zzjjVar2)) {
                                                        zzu.zzk(this.zzk.zzf(str13, zzrVar.zzn));
                                                    }
                                                    zzu.zzF(0L);
                                                    zzu.zzo(0L);
                                                    zzu.zzq(0L);
                                                    zzu.zzs(zzrVar.zzc);
                                                    zzu.zzu(zzrVar.zzj);
                                                    zzu.zzw(zzrVar.zzd);
                                                    zzu.zzy(zzrVar.zze);
                                                    zzu.zzA(zzrVar.zzf);
                                                    zzu.zzE(zzrVar.zzh);
                                                    zzu.zzC(zzrVar.zzq);
                                                    zzj().zzv(zzu, false, false);
                                                }
                                                if (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzu.zzd())) {
                                                    zzaE2.zzW((String) Preconditions.checkNotNull(zzu.zzd()));
                                                }
                                                if (!TextUtils.isEmpty(zzu.zzl())) {
                                                    zzaE2.zzah((String) Preconditions.checkNotNull(zzu.zzl()));
                                                }
                                                zzn = zzj().zzn(str13);
                                                for (i10 = 0; i10 < zzn.size(); i10++) {
                                                    com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                    zzm2.zzb(((zzpm) zzn.get(i10)).zzc);
                                                    zzm2.zza(((zzpm) zzn.get(i10)).zzd);
                                                    zzp().zzc(zzm2, ((zzpm) zzn.get(i10)).zze);
                                                    zzaE2.zzp(zzm2);
                                                    if ("_sid".equals(((zzpm) zzn.get(i10)).zzc) && zzu.zzam() != 0 && zzp().zzu(zzrVar.zzu) != zzu.zzam()) {
                                                        zzaE2.zzav();
                                                    }
                                                }
                                                zzj = zzj();
                                                zzidVar = (com.google.android.gms.internal.measurement.zzid) zzaE2.zzbc();
                                                zzj.zzg();
                                                zzj.zzay();
                                                Preconditions.checkNotNull(zzidVar);
                                                Preconditions.checkNotEmpty(zzidVar.zzA());
                                                byte[] zzcc32 = zzidVar.zzcc();
                                                long zzt222 = zzj.zzg.zzp().zzt(zzcc32);
                                                ContentValues contentValues222 = new ContentValues();
                                                String str2422 = str;
                                                contentValues222.put(str2422, zzidVar.zzA());
                                                contentValues222.put("metadata_fingerprint", Long.valueOf(zzt222));
                                                contentValues222.put("metadata", zzcc32);
                                                zzj.zze().insertWithOnConflict("raw_events_metadata", null, contentValues222, 4);
                                                zzj2 = zzj();
                                                zzbdVar = new zzbd(zzbbVar.zzf);
                                                while (true) {
                                                    if (zzbdVar.hasNext()) {
                                                        if (str14.equals(zzbdVar.next())) {
                                                            break;
                                                        }
                                                    } else {
                                                        zzhs zzh4 = zzh();
                                                        String str27 = zzbbVar.zza;
                                                        boolean zzk = zzh4.zzk(str27, zzbbVar.zzb);
                                                        zzar zzw = zzj().zzw(zzC(), str27, false, false, false, false, false, false, false);
                                                        if (!zzk || zzw.zze >= zzd().zzm(str27, zzfx.zzo)) {
                                                            i11 = 0;
                                                        }
                                                    }
                                                }
                                                zzj2.zzg();
                                                zzj2.zzay();
                                                Preconditions.checkNotNull(zzbbVar);
                                                String str2522 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str2522);
                                                byte[] zzcc222 = zzj2.zzg.zzp().zzh(zzbbVar).zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put(str2422, str2522);
                                                contentValues.put("name", zzbbVar.zzb);
                                                contentValues.put(HeaderInterceptor.TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(zzt222));
                                                contentValues.put("data", zzcc222);
                                                contentValues.put("realtime", Integer.valueOf(i11));
                                                if (zzj2.zze().insert(str7, null, contentValues) == -1) {
                                                    zzj2.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgt.zzl(str2522));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzc();
                                                zzj().zzd();
                                                zzaK();
                                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                        }
                                    }
                                    zzjkVar = zzs;
                                    zzjjVar2 = zzjjVar;
                                    str14 = "_r";
                                    zzibVar = this.zzn;
                                    zzibVar.zzu().zzw();
                                    zzaE2.zzF(Build.MODEL);
                                    zzibVar.zzu().zzw();
                                    zzaE2.zzE(Build.VERSION.RELEASE);
                                    zzaE2.zzI((int) zzibVar.zzu().zzb());
                                    zzaE2.zzH(zzibVar.zzu().zzc());
                                    zzaE2.zzay(zzrVar.zzw);
                                    if (zzibVar.zzB()) {
                                    }
                                    zzu = zzj().zzu(str13);
                                    if (zzu == null) {
                                    }
                                    if (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE)) {
                                        zzaE2.zzW((String) Preconditions.checkNotNull(zzu.zzd()));
                                    }
                                    if (!TextUtils.isEmpty(zzu.zzl())) {
                                    }
                                    zzn = zzj().zzn(str13);
                                    while (i10 < zzn.size()) {
                                    }
                                    zzj = zzj();
                                    zzidVar = (com.google.android.gms.internal.measurement.zzid) zzaE2.zzbc();
                                    zzj.zzg();
                                    zzj.zzay();
                                    Preconditions.checkNotNull(zzidVar);
                                    Preconditions.checkNotEmpty(zzidVar.zzA());
                                    byte[] zzcc322 = zzidVar.zzcc();
                                    long zzt2222 = zzj.zzg.zzp().zzt(zzcc322);
                                    ContentValues contentValues2222 = new ContentValues();
                                    String str24222 = str;
                                    contentValues2222.put(str24222, zzidVar.zzA());
                                    contentValues2222.put("metadata_fingerprint", Long.valueOf(zzt2222));
                                    contentValues2222.put("metadata", zzcc322);
                                    zzj.zze().insertWithOnConflict("raw_events_metadata", null, contentValues2222, 4);
                                    zzj2 = zzj();
                                    zzbdVar = new zzbd(zzbbVar.zzf);
                                    while (true) {
                                        if (zzbdVar.hasNext()) {
                                        }
                                    }
                                    zzj2.zzg();
                                    zzj2.zzay();
                                    Preconditions.checkNotNull(zzbbVar);
                                    String str25222 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str25222);
                                    byte[] zzcc2222 = zzj2.zzg.zzp().zzh(zzbbVar).zzcc();
                                    contentValues = new ContentValues();
                                    contentValues.put(str24222, str25222);
                                    contentValues.put("name", zzbbVar.zzb);
                                    contentValues.put(HeaderInterceptor.TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(zzt2222));
                                    contentValues.put("data", zzcc2222);
                                    contentValues.put("realtime", Integer.valueOf(i11));
                                    if (zzj2.zze().insert(str7, null, contentValues) == -1) {
                                    }
                                    zzj().zzc();
                                    zzj().zzd();
                                    zzaK();
                                    zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                    return;
                                }
                                zzj.zze().insertWithOnConflict("raw_events_metadata", null, contentValues2222, 4);
                                zzj2 = zzj();
                                zzbdVar = new zzbd(zzbbVar.zzf);
                                while (true) {
                                    if (zzbdVar.hasNext()) {
                                    }
                                }
                                zzj2.zzg();
                                zzj2.zzay();
                                Preconditions.checkNotNull(zzbbVar);
                                String str252222 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str252222);
                                byte[] zzcc22222 = zzj2.zzg.zzp().zzh(zzbbVar).zzcc();
                                contentValues = new ContentValues();
                                contentValues.put(str24222, str252222);
                                contentValues.put("name", zzbbVar.zzb);
                                contentValues.put(HeaderInterceptor.TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(zzt2222));
                                contentValues.put("data", zzcc22222);
                                contentValues.put("realtime", Integer.valueOf(i11));
                                if (zzj2.zze().insert(str7, null, contentValues) == -1) {
                                }
                                zzj().zzc();
                                zzj().zzd();
                                zzaK();
                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                                return;
                            } catch (SQLiteException e13) {
                                zzj.zzu.zzaV().zzb().zzc("Error storing raw event metadata. appId", zzgt.zzl(zzidVar.zzA()), e13);
                                throw e13;
                            }
                            arrayList = null;
                            if (arrayList != null) {
                            }
                            if (zzd().zzp(null, zzfx.zzbb)) {
                            }
                            str13 = zzrVar.zza;
                            zzs = zzB((String) Preconditions.checkNotNull(str13)).zzs(zzjk.zzf(zzrVar.zzs, 100));
                            zzjjVar = zzjj.AD_STORAGE;
                            if (zzs.zzo(zzjjVar)) {
                                zzc = this.zzk.zzc(str13, zzs);
                                if (!TextUtils.isEmpty((CharSequence) zzc.first)) {
                                }
                            }
                            zzjkVar = zzs;
                            zzjjVar2 = zzjjVar;
                            str14 = "_r";
                            zzibVar = this.zzn;
                            zzibVar.zzu().zzw();
                            zzaE2.zzF(Build.MODEL);
                            zzibVar.zzu().zzw();
                            zzaE2.zzE(Build.VERSION.RELEASE);
                            zzaE2.zzI((int) zzibVar.zzu().zzb());
                            zzaE2.zzH(zzibVar.zzu().zzc());
                            zzaE2.zzay(zzrVar.zzw);
                            if (zzibVar.zzB()) {
                            }
                            zzu = zzj().zzu(str13);
                            if (zzu == null) {
                            }
                            if (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE)) {
                            }
                            if (!TextUtils.isEmpty(zzu.zzl())) {
                            }
                            zzn = zzj().zzn(str13);
                            while (i10 < zzn.size()) {
                            }
                            zzj = zzj();
                            zzidVar = (com.google.android.gms.internal.measurement.zzid) zzaE2.zzbc();
                            zzj.zzg();
                            zzj.zzay();
                            Preconditions.checkNotNull(zzidVar);
                            Preconditions.checkNotEmpty(zzidVar.zzA());
                            byte[] zzcc3222 = zzidVar.zzcc();
                            long zzt22222 = zzj.zzg.zzp().zzt(zzcc3222);
                            ContentValues contentValues22222 = new ContentValues();
                            String str242222 = str;
                            contentValues22222.put(str242222, zzidVar.zzA());
                            contentValues22222.put("metadata_fingerprint", Long.valueOf(zzt22222));
                            contentValues22222.put("metadata", zzcc3222);
                        }
                        zzj().zzd();
                    }
                    z10 = true;
                }
                zzbe zzbeVar2 = zzb2.zzb;
                String zzd = zzbeVar2.zzd(FirebaseAnalytics.Param.CURRENCY);
                if (z10) {
                    double doubleValue = zzbeVar2.zzc("value").doubleValue() * 1000000.0d;
                    if (doubleValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        str = "app_id";
                        str2 = "_fx";
                        doubleValue = zzbeVar2.zzb("value").longValue() * 1000000.0d;
                    } else {
                        str = "app_id";
                        str2 = "_fx";
                    }
                    if (doubleValue <= 9.223372036854776E18d && doubleValue >= -9.223372036854776E18d) {
                        longValue = Math.round(doubleValue);
                        if (FirebaseAnalytics.Event.REFUND.equals(str18)) {
                            longValue = -longValue;
                        }
                    } else {
                        zzaV().zze().zzc("Data lost. Currency value is too big. appId", zzgt.zzl(str15), Double.valueOf(doubleValue));
                        zzj().zzc();
                        zzj().zzd();
                    }
                } else {
                    str = "app_id";
                    str2 = "_fx";
                    longValue = zzbeVar2.zzb("value").longValue();
                }
                if (!TextUtils.isEmpty(zzd)) {
                    String upperCase = zzd.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        String concat = "_ltv_".concat(upperCase);
                        zzpm zzm3 = zzj().zzm(str15, concat);
                        if (zzm3 != null) {
                            Object obj4 = zzm3.zze;
                            if (obj4 instanceof Long) {
                                str4 = "raw_events";
                                zzbgVar2 = zzb2;
                                str3 = "value";
                                str5 = "_err";
                                zzpmVar = new zzpm(str15, zzb2.zzc, concat, zzaZ().currentTimeMillis(), Long.valueOf(((Long) obj4).longValue() + longValue));
                                zzpmVar2 = zzpmVar;
                                if (!zzj().zzl(zzpmVar2)) {
                                    zzaV().zzb().zzd("Too many unique user properties are set. Ignoring user property. appId", zzgt.zzl(str15), this.zzn.zzl().zzc(zzpmVar2.zzc), zzpmVar2.zze);
                                    zzt().zzN(this.zzK, str15, 9, null, null, 0);
                                }
                                String str192 = zzbgVar2.zza;
                                boolean zzh22 = zzpo.zzh(str192);
                                boolean equals2 = str5.equals(str192);
                                zzt();
                                zzbeVar = zzbgVar2.zzb;
                                if (zzbeVar != null) {
                                }
                                zzbg zzbgVar32 = zzbgVar2;
                                zzar zzx2 = zzj().zzx(zzC(), str15, j10 + 1, true, zzh22, false, equals2, false, false, false);
                                long j142 = zzx2.zzb;
                                zzd();
                                zzH = j142 - zzal.zzH();
                                if (zzH <= 0) {
                                }
                                zzj().zzd();
                            }
                        }
                        str3 = "value";
                        str4 = "raw_events";
                        zzbgVar2 = zzb2;
                        str5 = "_err";
                        zzav zzj5 = zzj();
                        int zzm4 = zzd().zzm(str15, zzfx.zzT) - 1;
                        Preconditions.checkNotEmpty(str15);
                        zzj5.zzg();
                        zzj5.zzay();
                        zzj5.zze().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str15, str15, String.valueOf(zzm4)});
                        zzpmVar = new zzpm(str15, zzbgVar2.zzc, concat, zzaZ().currentTimeMillis(), Long.valueOf(longValue));
                        zzpmVar2 = zzpmVar;
                        if (!zzj().zzl(zzpmVar2)) {
                        }
                        String str1922 = zzbgVar2.zza;
                        boolean zzh222 = zzpo.zzh(str1922);
                        boolean equals22 = str5.equals(str1922);
                        zzt();
                        zzbeVar = zzbgVar2.zzb;
                        if (zzbeVar != null) {
                        }
                        zzbg zzbgVar322 = zzbgVar2;
                        zzar zzx22 = zzj().zzx(zzC(), str15, j10 + 1, true, zzh222, false, equals22, false, false, false);
                        long j1422 = zzx22.zzb;
                        zzd();
                        zzH = j1422 - zzal.zzH();
                        if (zzH <= 0) {
                        }
                        zzj().zzd();
                    }
                }
                str3 = "value";
                str4 = "raw_events";
                zzbgVar2 = zzb2;
                str5 = "_err";
                String str19222 = zzbgVar2.zza;
                boolean zzh2222 = zzpo.zzh(str19222);
                boolean equals222 = str5.equals(str19222);
                zzt();
                zzbeVar = zzbgVar2.zzb;
                if (zzbeVar != null) {
                }
                zzbg zzbgVar3222 = zzbgVar2;
                zzar zzx222 = zzj().zzx(zzC(), str15, j10 + 1, true, zzh2222, false, equals222, false, false, false);
                long j14222 = zzx222.zzb;
                zzd();
                zzH = j14222 - zzal.zzH();
                if (zzH <= 0) {
                }
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaW().zzg();
        zzu();
        zzan zzd = zzan.zzd(zzicVar.zzaA());
        String zzc = zzhVar.zzc();
        zzaW().zzg();
        zzu();
        zzjk zzB = zzB(zzc);
        zzjh zzjhVar = zzjh.UNINITIALIZED;
        int ordinal = zzB.zzp().ordinal();
        if (ordinal != 1) {
            if (ordinal != 2 && ordinal != 3) {
                zzd.zzc(zzjj.AD_STORAGE, zzam.FAILSAFE);
            } else {
                zzd.zzb(zzjj.AD_STORAGE, zzB.zzb());
            }
        } else {
            zzd.zzc(zzjj.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        }
        int ordinal2 = zzB.zzq().ordinal();
        if (ordinal2 != 1) {
            if (ordinal2 != 2 && ordinal2 != 3) {
                zzd.zzc(zzjj.ANALYTICS_STORAGE, zzam.FAILSAFE);
            } else {
                zzd.zzb(zzjj.ANALYTICS_STORAGE, zzB.zzb());
            }
        } else {
            zzd.zzc(zzjj.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        }
        String zzc2 = zzhVar.zzc();
        zzaW().zzg();
        zzu();
        zzaz zzz = zzz(zzc2, zzx(zzc2), zzB(zzc2), zzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzz.zzk())) {
            zzicVar.zzaF(zzz.zzk());
        }
        zzaW().zzg();
        zzu();
        Iterator it = zzicVar.zzk().iterator();
        while (true) {
            if (it.hasNext()) {
                zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
                if ("_npa".equals(zziuVar.zzc())) {
                    break;
                }
            } else {
                zziuVar = null;
                break;
            }
        }
        if (zziuVar != null) {
            zzjj zzjjVar = zzjj.AD_PERSONALIZATION;
            if (zzd.zza(zzjjVar) == zzam.UNSET) {
                zzpm zzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzm != null) {
                    String str = zzm.zzb;
                    if ("tcf".equals(str)) {
                        zzd.zzc(zzjjVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzd.zzc(zzjjVar, zzam.API);
                    } else {
                        zzd.zzc(zzjjVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean zzae = zzhVar.zzae();
                    if (zzae != null && ((!zzae.booleanValue() || zziuVar.zzg() == 1) && (zzae.booleanValue() || zziuVar.zzg() == 0))) {
                        zzd.zzc(zzjjVar, zzam.MANIFEST);
                    } else {
                        zzd.zzc(zzjjVar, zzam.API);
                    }
                }
            }
        } else {
            int zzaB = zzaB(zzhVar.zzc(), zzd);
            com.google.android.gms.internal.measurement.zzit zzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
            zzm2.zzb("_npa");
            zzm2.zza(zzaZ().currentTimeMillis());
            zzm2.zze(zzaB);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzm2.zzbc());
            zzaV().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaB));
        }
        zzicVar.zzaB(zzd.toString());
        boolean zzy = this.zzc.zzy(zzhVar.zzc());
        List zzb2 = zzicVar.zzb();
        int i10 = 0;
        for (int i11 = 0; i11 < zzb2.size(); i11++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i11)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzb2.get(i11)).zzcl();
                List zza = zzhrVar.zza();
                int i12 = 0;
                while (true) {
                    if (i12 >= zza.size()) {
                        break;
                    }
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) zza.get(i12)).zzb())) {
                        String zzd2 = ((com.google.android.gms.internal.measurement.zzhw) zza.get(i12)).zzd();
                        if (zzy && zzd2.length() > 4) {
                            char[] charArray = zzd2.toCharArray();
                            int i13 = 1;
                            while (true) {
                                if (i13 >= 64) {
                                    break;
                                }
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i13)) {
                                    i10 = i13;
                                    break;
                                }
                                i13++;
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i10);
                            zzd2 = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhv zzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzn.zzb("_tcfd");
                        zzn.zzd(zzd2);
                        zzhrVar.zze(i12, zzn);
                    } else {
                        i12++;
                    }
                }
                zzicVar.zzf(i11, zzhrVar);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzJ(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzaW().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzr = com.google.android.gms.internal.measurement.zzha.zzr();
        byte[] zzaJ = zzhVar.zzaJ();
        if (zzaJ != null) {
            try {
                zzr = (com.google.android.gms.internal.measurement.zzgx) zzpj.zzw(zzr, zzaJ);
            } catch (com.google.android.gms.internal.measurement.zzmq unused) {
                zzaV().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgt.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals("_cmp")) {
                String str = (String) zzpj.zzJ(zzhsVar, "gclid", "");
                String str2 = (String) zzpj.zzJ(zzhsVar, "gbraid", "");
                String str3 = (String) zzpj.zzJ(zzhsVar, "gad_source", "");
                String[] split = ((String) zzfx.zzbh.zzb(null)).split(",");
                zzp();
                if (!zzpj.zzG(zzhsVar, split).isEmpty()) {
                    long longValue = ((Long) zzpj.zzJ(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpj.zzI(zzhsVar, "_cis"))) {
                        if (longValue > zzr.zzo()) {
                            if (str.isEmpty()) {
                                zzr.zzj();
                            } else {
                                zzr.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzr.zzl();
                            } else {
                                zzr.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzr.zzn();
                            } else {
                                zzr.zzm(str3);
                            }
                            zzr.zzp(longValue);
                            zzr.zzs();
                            zzr.zzt(zzaC(zzhsVar));
                        }
                    } else if (longValue > zzr.zzg()) {
                        if (str.isEmpty()) {
                            zzr.zzb();
                        } else {
                            zzr.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzr.zzd();
                        } else {
                            zzr.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzr.zzf();
                        } else {
                            zzr.zze(str3);
                        }
                        zzr.zzh(longValue);
                        zzr.zzq();
                        zzr.zzr(zzaC(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzr.zzbc()).equals(com.google.android.gms.internal.measurement.zzha.zzs())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzr.zzbc());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzr.zzbc()).zzcc());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfx.zzbg)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    final String zzK(zzjk zzjkVar) {
        if (zzjkVar.zzo(zzjj.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzt().zzf().nextBytes(bArr);
            return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        }
        return null;
    }

    @VisibleForTesting
    final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaV().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0124, code lost:
    
        if (r7 == null) goto L٤٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0194, code lost:
    
        if (r1 == 0) goto L٧١;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpf] */
    /* JADX WARN: Type inference failed for: r1v11, types: [long] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v21, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v24, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzM() {
        zzav zzj;
        long zzF;
        SQLiteException e10;
        zzh zzu;
        zzaW().zzg();
        zzu();
        this.zzw = true;
        try {
            zzib zzibVar = this.zzn;
            zzibVar.zzaU();
            Boolean zzJ = zzibVar.zzt().zzJ();
            if (zzJ == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaK();
            } else {
                zzaW().zzg();
                if (this.zzz != null) {
                    zzaV().zzk().zza("Uploading requested multiple times");
                } else if (!zzi().zzb()) {
                    zzaV().zzk().zza("Network not connected, ignoring upload request");
                    zzaK();
                } else {
                    ?? currentTimeMillis = zzaZ().currentTimeMillis();
                    Cursor cursor = null;
                    r7 = null;
                    Cursor cursor2 = null;
                    r7 = null;
                    r7 = null;
                    String str = null;
                    int zzm = zzd().zzm(null, zzfx.zzai);
                    zzd();
                    long zzF2 = currentTimeMillis - zzal.zzF();
                    for (int i10 = 0; i10 < zzm && zzaF(null, zzF2); i10++) {
                    }
                    zzql.zza();
                    zzaW().zzg();
                    zzau();
                    long zza = this.zzk.zzd.zza();
                    if (zza != 0) {
                        zzaV().zzj().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - zza)));
                    }
                    String zzF3 = zzj().zzF();
                    long j10 = -1;
                    if (!TextUtils.isEmpty(zzF3)) {
                        if (this.zzB == -1) {
                            zzav zzj2 = zzj();
                            try {
                                try {
                                    cursor2 = zzj2.zze().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    if (cursor2.moveToFirst()) {
                                        j10 = cursor2.getLong(0);
                                    }
                                } finally {
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                }
                            } catch (SQLiteException e11) {
                                zzj2.zzu.zzaV().zzb().zzb("Error querying raw events", e11);
                            }
                            cursor2.close();
                            this.zzB = j10;
                        }
                        zzN(zzF3, currentTimeMillis);
                    } else {
                        try {
                            this.zzB = -1L;
                            zzj = zzj();
                            zzd();
                            zzF = currentTimeMillis - zzal.zzF();
                            zzj.zzg();
                            zzj.zzay();
                        } catch (Throwable th) {
                            th = th;
                            cursor = currentTimeMillis;
                        }
                        try {
                            currentTimeMillis = zzj.zze().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(zzF)});
                            try {
                                if (!currentTimeMillis.moveToFirst()) {
                                    zzj.zzu.zzaV().zzk().zza("No expired configs for apps with pending events");
                                } else {
                                    str = currentTimeMillis.getString(0);
                                }
                            } catch (SQLiteException e12) {
                                e10 = e12;
                                zzj.zzu.zzaV().zzb().zzb("Error selecting expired configs", e10);
                            }
                        } catch (SQLiteException e13) {
                            e10 = e13;
                            currentTimeMillis = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                        currentTimeMillis.close();
                        if (!TextUtils.isEmpty(str) && (zzu = zzj().zzu(str)) != null) {
                            zzV(zzu);
                        }
                    }
                }
            }
            this.zzw = false;
            zzaL();
        } catch (Throwable th3) {
            this.zzw = false;
            zzaL();
            throw th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:417:0x01f7, code lost:
    
        if (r10 == null) goto L١٦;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x06fe  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0757  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x098a  */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:305:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:334:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0317 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0277 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0472  */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void zzN(String str, long j10) {
        Cursor cursor;
        Cursor cursor2;
        List emptyList;
        List<Pair> list;
        String str2;
        zzjk zzB;
        zzjj zzjjVar;
        com.google.android.gms.internal.measurement.zzhz zzh;
        int size;
        int i10;
        String str3;
        Object obj;
        long j11;
        zzos zzosVar;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        List list2;
        String str4;
        String str5;
        CursorUtil$wrapMappedColumns$2 cursorUtil$wrapMappedColumns$2;
        List emptyList2;
        ArrayList arrayList;
        zzav zzj;
        ContentValues contentValues;
        byte[] byteArray;
        long j12;
        long j13;
        int zzm = zzd().zzm(str, zzfx.zzg);
        int i11 = 0;
        int max = Math.max(0, zzd().zzm(str, zzfx.zzh));
        zzav zzj2 = zzj();
        zzj2.zzg();
        zzj2.zzay();
        int i12 = 1;
        Preconditions.checkArgument(zzm > 0);
        ?? r10 = max > 0 ? 1 : 0;
        Preconditions.checkArgument(r10);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                cursor2 = zzj2.zze().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(zzm));
                try {
                } catch (SQLiteException e10) {
                    e = e10;
                    zzj2.zzu.zzaV().zzb().zzc("Error querying bundles. appId", zzgt.zzl(str), e);
                    emptyList = Collections.emptyList();
                }
            } catch (Throwable th) {
                th = th;
                cursor = r10;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
        if (!cursor2.moveToFirst()) {
            emptyList = Collections.emptyList();
            cursor2.close();
            list = emptyList;
            if (!list.isEmpty()) {
                return;
            }
            com.google.android.gms.internal.measurement.zzpk.zza();
            zzal zzd = zzd();
            zzfw zzfwVar = zzfx.zzbi;
            String str6 = "_f";
            if (zzd.zzp(null, zzfwVar)) {
                com.google.android.gms.internal.measurement.zzpk.zza();
                if (zzd().zzp(null, zzfwVar)) {
                    if (!zzB(str).zzo(zzjj.ANALYTICS_STORAGE) && zzh().zzB(str)) {
                        List asList = Arrays.asList(((String) zzfx.zzbj.zzb(null)).split(","));
                        for (Pair pair : list) {
                            try {
                                zzj().zzH(((Long) pair.second).longValue());
                                for (com.google.android.gms.internal.measurement.zzhs zzhsVar : ((com.google.android.gms.internal.measurement.zzid) pair.first).zzc()) {
                                    if (asList.contains(zzhsVar.zzd())) {
                                        try {
                                            if (!zzhsVar.zzd().equals("_f")) {
                                                if (zzhsVar.zzd().equals("_v")) {
                                                }
                                                zzj = zzj();
                                                zzj.zzg();
                                                zzj.zzay();
                                                Preconditions.checkNotNull(zzhsVar);
                                                Preconditions.checkNotEmpty(str);
                                                zzib zzibVar = zzj.zzu;
                                                zzibVar.zzaV().zzk().zzb("Caching events in NO_DATA mode", zzhsVar);
                                                contentValues = new ContentValues();
                                                contentValues.put("app_id", str);
                                                contentValues.put("name", zzhsVar.zzd());
                                                contentValues.put("data", zzhsVar.zzcc());
                                                contentValues.put("timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                                                if (zzj.zze().insert("no_data_mode_events", null, contentValues) != -1) {
                                                    try {
                                                        zzibVar.zzaV().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgt.zzl(str));
                                                    } catch (SQLiteException e12) {
                                                        e = e12;
                                                        try {
                                                            zzj.zzu.zzaV().zzb().zzc("Error storing NO_DATA mode event. appId", zzgt.zzl(str), e);
                                                        } catch (SQLiteException unused) {
                                                            zzaV().zzh().zzb("Failed handling NO_DATA mode bundles. appId", str);
                                                        }
                                                    }
                                                }
                                            }
                                            if (zzj.zze().insert("no_data_mode_events", null, contentValues) != -1) {
                                            }
                                        } catch (SQLiteException e13) {
                                            e = e13;
                                        }
                                        com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar.zzcl();
                                        zzp();
                                        zzpj.zzC(zzhrVar, "_dac", 1L);
                                        zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc();
                                        zzj = zzj();
                                        zzj.zzg();
                                        zzj.zzay();
                                        Preconditions.checkNotNull(zzhsVar);
                                        Preconditions.checkNotEmpty(str);
                                        zzib zzibVar2 = zzj.zzu;
                                        zzibVar2.zzaV().zzk().zzb("Caching events in NO_DATA mode", zzhsVar);
                                        contentValues = new ContentValues();
                                        contentValues.put("app_id", str);
                                        contentValues.put("name", zzhsVar.zzd());
                                        contentValues.put("data", zzhsVar.zzcc());
                                        contentValues.put("timestamp_millis", Long.valueOf(zzhsVar.zzf()));
                                    }
                                }
                            } catch (SQLiteException unused2) {
                            }
                        }
                        list = Collections.emptyList();
                    } else {
                        ArrayList arrayList2 = new ArrayList(list.size());
                        zzav zzj3 = zzj();
                        Preconditions.checkNotEmpty(str);
                        zzj3.zzg();
                        zzj3.zzay();
                        ArrayList arrayList3 = new ArrayList();
                        try {
                            try {
                                try {
                                    SQLiteDatabase zze = zzj3.zze();
                                    long currentTimeMillis = zzj3.zzu.zzaZ().currentTimeMillis();
                                    Cursor cursor3 = zze.query("no_data_mode_events", new String[]{"data"}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(currentTimeMillis)}, null, null, "rowid", null);
                                    try {
                                        if (cursor3.moveToFirst()) {
                                            while (true) {
                                                try {
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursor3.getBlob(0))).zzbc());
                                                    str2 = str6;
                                                    arrayList = arrayList3;
                                                } catch (com.google.android.gms.internal.measurement.zzmq e14) {
                                                    arrayList = arrayList3;
                                                    str2 = str6;
                                                    try {
                                                        zzj3.zzu.zzaV().zzh().zzc("Failed to parse stored NO_DATA mode event, appId", zzgt.zzl(str), e14);
                                                    } catch (SQLiteException e15) {
                                                        e = e15;
                                                        zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgt.zzl(str), e);
                                                        emptyList2 = Collections.emptyList();
                                                        if (cursor3 != null) {
                                                        }
                                                        boolean z14 = true;
                                                        while (r0.hasNext()) {
                                                        }
                                                        list = arrayList2;
                                                        if (list.isEmpty()) {
                                                        }
                                                        zzB = zzB(str);
                                                        zzjjVar = zzjj.AD_STORAGE;
                                                        if (zzB.zzo(zzjjVar)) {
                                                        }
                                                        zzh = com.google.android.gms.internal.measurement.zzib.zzh();
                                                        size = list.size();
                                                        List arrayList4 = new ArrayList(list.size());
                                                        if (zzd().zzC(str)) {
                                                        }
                                                        boolean zzo = zzB(str).zzo(zzjjVar);
                                                        boolean zzo2 = zzB(str).zzo(zzjj.ANALYTICS_STORAGE);
                                                        zzqu.zza();
                                                        boolean zzp = zzd().zzp(str, zzfx.zzaM);
                                                        zzot zzotVar = this.zzl;
                                                        zzos zza = zzotVar.zza(str);
                                                        i10 = 0;
                                                        while (i10 < size) {
                                                        }
                                                        if (zzh.zzb() == 0) {
                                                        }
                                                    }
                                                }
                                                if (!cursor3.moveToNext()) {
                                                    break;
                                                }
                                                arrayList3 = arrayList;
                                                str6 = str2;
                                            }
                                            cursor3.close();
                                            try {
                                                int delete = zze.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(currentTimeMillis)});
                                                zzgr zzk = zzj3.zzu.zzaV().zzk();
                                                StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 34);
                                                sb.append("Pruned ");
                                                sb.append(delete);
                                                sb.append(" NO_DATA mode events. appId");
                                                zzk.zzb(sb.toString(), str);
                                            } catch (SQLiteException e16) {
                                                e = e16;
                                                cursor3 = null;
                                                zzj3.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgt.zzl(str), e);
                                                emptyList2 = Collections.emptyList();
                                                if (cursor3 != null) {
                                                    cursor3.close();
                                                }
                                                boolean z142 = true;
                                                while (r0.hasNext()) {
                                                }
                                                list = arrayList2;
                                                if (list.isEmpty()) {
                                                }
                                                zzB = zzB(str);
                                                zzjjVar = zzjj.AD_STORAGE;
                                                if (zzB.zzo(zzjjVar)) {
                                                }
                                                zzh = com.google.android.gms.internal.measurement.zzib.zzh();
                                                size = list.size();
                                                List arrayList42 = new ArrayList(list.size());
                                                if (zzd().zzC(str)) {
                                                }
                                                boolean zzo3 = zzB(str).zzo(zzjjVar);
                                                boolean zzo22 = zzB(str).zzo(zzjj.ANALYTICS_STORAGE);
                                                zzqu.zza();
                                                boolean zzp2 = zzd().zzp(str, zzfx.zzaM);
                                                zzot zzotVar2 = this.zzl;
                                                zzos zza2 = zzotVar2.zza(str);
                                                i10 = 0;
                                                while (i10 < size) {
                                                }
                                                if (zzh.zzb() == 0) {
                                                }
                                            }
                                        } else {
                                            str2 = "_f";
                                            arrayList = arrayList3;
                                            cursor3.close();
                                        }
                                        emptyList2 = arrayList;
                                    } catch (SQLiteException e17) {
                                        e = e17;
                                        str2 = str6;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursorUtil$wrapMappedColumns$2 = "data";
                                    if (cursorUtil$wrapMappedColumns$2 != 0) {
                                        cursorUtil$wrapMappedColumns$2.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                cursorUtil$wrapMappedColumns$2 = 0;
                                if (cursorUtil$wrapMappedColumns$2 != 0) {
                                }
                                throw th;
                            }
                        } catch (SQLiteException e18) {
                            e = e18;
                            str2 = "_f";
                        }
                        boolean z1422 = true;
                        for (Pair pair2 : list) {
                            com.google.android.gms.internal.measurement.zzic zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair2.first).zzcl();
                            if (z1422 && !emptyList2.isEmpty()) {
                                List zzb2 = zzicVar.zzb();
                                zzicVar.zzi();
                                zzicVar.zzh(emptyList2);
                                zzicVar.zzh(zzb2);
                                z1422 = false;
                            }
                            com.google.android.gms.internal.measurement.zzhh zzb3 = com.google.android.gms.internal.measurement.zzho.zzb();
                            com.google.android.gms.internal.measurement.zzgf zzx = zzh().zzx(str);
                            ArrayList arrayList5 = new ArrayList();
                            if (zzx != null) {
                                for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzx.zza()) {
                                    com.google.android.gms.internal.measurement.zzhk zza3 = com.google.android.gms.internal.measurement.zzhl.zza();
                                    int zzb4 = zzfuVar.zzb();
                                    zzjh zzjhVar = zzjh.UNINITIALIZED;
                                    int i13 = zzb4 - 1;
                                    int i14 = 3;
                                    zza3.zza(i13 != 1 ? i13 != 2 ? i13 != 3 ? i13 != 4 ? 1 : 5 : 4 : 3 : 2);
                                    int zzd2 = zzfuVar.zzd() - 1;
                                    if (zzd2 == 1) {
                                        i14 = 2;
                                    } else if (zzd2 != 2) {
                                        i14 = 1;
                                    }
                                    zza3.zzb(i14);
                                    arrayList5.add((com.google.android.gms.internal.measurement.zzhl) zza3.zzbc());
                                }
                            }
                            zzb3.zza(arrayList5);
                            zzicVar.zzaQ(zzb3);
                            arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc(), (Long) pair2.second));
                        }
                        list = arrayList2;
                        if (list.isEmpty()) {
                            return;
                        }
                    }
                }
                str2 = "_f";
                if (list.isEmpty()) {
                }
            } else {
                str2 = "_f";
            }
            zzB = zzB(str);
            zzjjVar = zzjj.AD_STORAGE;
            if (zzB.zzo(zzjjVar)) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str5 = null;
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) ((Pair) it.next()).first;
                    if (!zzidVar.zzG().isEmpty()) {
                        str5 = zzidVar.zzG();
                        break;
                    }
                }
                if (str5 != null) {
                    int i15 = 0;
                    while (true) {
                        if (i15 >= list.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzid zzidVar2 = (com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(i15)).first;
                        if (!zzidVar2.zzG().isEmpty() && !zzidVar2.zzG().equals(str5)) {
                            list = list.subList(0, i15);
                            break;
                        }
                        i15++;
                    }
                }
            }
            zzh = com.google.android.gms.internal.measurement.zzib.zzh();
            size = list.size();
            List arrayList422 = new ArrayList(list.size());
            boolean z15 = !zzd().zzC(str) && zzB(str).zzo(zzjjVar);
            boolean zzo32 = zzB(str).zzo(zzjjVar);
            boolean zzo222 = zzB(str).zzo(zzjj.ANALYTICS_STORAGE);
            zzqu.zza();
            boolean zzp22 = zzd().zzp(str, zzfx.zzaM);
            zzot zzotVar22 = this.zzl;
            zzos zza22 = zzotVar22.zza(str);
            i10 = 0;
            while (i10 < size) {
                com.google.android.gms.internal.measurement.zzic zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(i10)).first).zzcl();
                arrayList422.add((Long) ((Pair) list.get(i10)).second);
                zzd().zzi();
                zzicVar2.zzO(130000L);
                zzicVar2.zzs(j10);
                int i16 = size;
                this.zzn.zzaU();
                zzicVar2.zzae(false);
                if (!z15) {
                    zzicVar2.zzan();
                }
                if (!zzo32) {
                    zzicVar2.zzR();
                    zzicVar2.zzU();
                }
                if (!zzo222) {
                    zzicVar2.zzX();
                }
                zzS(str, zzicVar2);
                if (!zzp22) {
                    zzicVar2.zzav();
                }
                if (!zzo222) {
                    zzicVar2.zzag();
                }
                String zzP = zzicVar2.zzP();
                if (TextUtils.isEmpty(zzP)) {
                    z10 = zzo32;
                } else {
                    z10 = zzo32;
                    if (!zzP.equals("00000000-0000-0000-0000-000000000000")) {
                        z11 = z15;
                        z12 = zzo222;
                        z13 = zzp22;
                        list2 = list;
                        str4 = str2;
                        if (zzicVar2.zzc() != 0) {
                            if (zzd().zzp(str, zzfx.zzaC)) {
                                zzicVar2.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc()).zzcc()));
                            }
                            com.google.android.gms.internal.measurement.zzis zzd3 = zza22.zzd();
                            if (zzd3 != null) {
                                zzicVar2.zzaN(zzd3);
                            }
                            zzh.zze(zzicVar2);
                        }
                        i10++;
                        str2 = str4;
                        size = i16;
                        zzo32 = z10;
                        z15 = z11;
                        zzo222 = z12;
                        list = list2;
                        zzp22 = z13;
                    }
                }
                ArrayList arrayList6 = new ArrayList(zzicVar2.zzb());
                Iterator it2 = arrayList6.iterator();
                z11 = z15;
                z12 = zzo222;
                Long l10 = null;
                Long l11 = null;
                boolean z16 = false;
                boolean z17 = false;
                while (it2.hasNext()) {
                    boolean z18 = zzp22;
                    com.google.android.gms.internal.measurement.zzhs zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) it2.next();
                    List list3 = list;
                    if ("_fx".equals(zzhsVar2.zzd())) {
                        it2.remove();
                        list = list3;
                        zzp22 = z18;
                        z16 = true;
                        z17 = true;
                    } else {
                        String str7 = str2;
                        if (str7.equals(zzhsVar2.zzd())) {
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzF = zzpj.zzF(zzhsVar2, "_pfo");
                            if (zzF != null) {
                                l10 = Long.valueOf(zzF.zzf());
                            }
                            zzp();
                            com.google.android.gms.internal.measurement.zzhw zzF2 = zzpj.zzF(zzhsVar2, "_uwa");
                            if (zzF2 != null) {
                                l11 = Long.valueOf(zzF2.zzf());
                            }
                            str2 = str7;
                            list = list3;
                            zzp22 = z18;
                            z17 = true;
                        } else {
                            str2 = str7;
                            list = list3;
                            zzp22 = z18;
                        }
                    }
                }
                z13 = zzp22;
                list2 = list;
                str4 = str2;
                if (z16) {
                    zzicVar2.zzi();
                    zzicVar2.zzh(arrayList6);
                }
                if (z17) {
                    zzR(zzicVar2.zzK(), true, l10, l11);
                }
                if (zzicVar2.zzc() != 0) {
                }
                i10++;
                str2 = str4;
                size = i16;
                zzo32 = z10;
                z15 = z11;
                zzo222 = z12;
                list = list2;
                zzp22 = z13;
            }
            if (zzh.zzb() == 0) {
                zzL(arrayList422);
                zzU(false, 204, null, null, str, Collections.emptyList());
                return;
            }
            com.google.android.gms.internal.measurement.zzib zzibVar3 = (com.google.android.gms.internal.measurement.zzib) zzh.zzbc();
            List arrayList7 = new ArrayList();
            boolean z19 = zza22.zzc() == zzlr.SGTM_CLIENT;
            if (zza22.zzc() != zzlr.SGTM) {
                if (!z19) {
                    j11 = j10;
                    obj = null;
                    if (zzi().zzb()) {
                        return;
                    }
                    Object zzi = Log.isLoggable(zzaV().zzn(), 2) ? zzp().zzi(zzibVar3) : obj;
                    zzp();
                    byte[] zzcc = zzibVar3.zzcc();
                    zzL(arrayList422);
                    this.zzk.zze.zzb(j11);
                    zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(zzcc.length), zzi);
                    this.zzv = true;
                    zzi().zzc(str, zza22, zzibVar3, new zzov(this, str, arrayList7));
                    return;
                }
                z19 = true;
            }
            Iterator it3 = ((com.google.android.gms.internal.measurement.zzib) zzh.zzbc()).zza().iterator();
            while (true) {
                if (it3.hasNext()) {
                    if (((com.google.android.gms.internal.measurement.zzid) it3.next()).zzY()) {
                        str3 = UUID.randomUUID().toString();
                        break;
                    }
                } else {
                    str3 = null;
                    break;
                }
            }
            com.google.android.gms.internal.measurement.zzib zzibVar4 = (com.google.android.gms.internal.measurement.zzib) zzh.zzbc();
            zzaW().zzg();
            zzu();
            com.google.android.gms.internal.measurement.zzhz zzi2 = com.google.android.gms.internal.measurement.zzib.zzi(zzibVar4);
            if (!TextUtils.isEmpty(str3)) {
                zzi2.zzi(str3);
            }
            String zzc = zzh().zzc(str);
            if (!TextUtils.isEmpty(zzc)) {
                zzi2.zzj(zzc);
            }
            ArrayList arrayList8 = new ArrayList();
            Iterator it4 = zzibVar4.zza().iterator();
            while (it4.hasNext()) {
                com.google.android.gms.internal.measurement.zzic zzaF = com.google.android.gms.internal.measurement.zzid.zzaF((com.google.android.gms.internal.measurement.zzid) it4.next());
                zzaF.zzan();
                arrayList8.add((com.google.android.gms.internal.measurement.zzid) zzaF.zzbc());
            }
            zzi2.zzg();
            zzi2.zzf(arrayList8);
            zzaV().zzk().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", TextUtils.isEmpty(str3) ? Constants.NULL_VERSION_ID : zzi2.zzh());
            com.google.android.gms.internal.measurement.zzib zzibVar5 = (com.google.android.gms.internal.measurement.zzib) zzi2.zzbc();
            if (TextUtils.isEmpty(str3)) {
                obj = null;
            } else {
                com.google.android.gms.internal.measurement.zzib zzibVar6 = (com.google.android.gms.internal.measurement.zzib) zzh.zzbc();
                zzaW().zzg();
                zzu();
                com.google.android.gms.internal.measurement.zzhz zzh2 = com.google.android.gms.internal.measurement.zzib.zzh();
                zzaV().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", str3);
                zzh2.zzi(str3);
                for (com.google.android.gms.internal.measurement.zzid zzidVar3 : zzibVar6.zza()) {
                    com.google.android.gms.internal.measurement.zzic zzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzaE.zzam(zzidVar3.zzZ());
                    zzaE.zzaJ(zzidVar3.zzav());
                    zzh2.zze(zzaE);
                }
                com.google.android.gms.internal.measurement.zzib zzibVar7 = (com.google.android.gms.internal.measurement.zzib) zzh2.zzbc();
                String zzc2 = zzotVar22.zzg.zzh().zzc(str);
                if (!TextUtils.isEmpty(zzc2)) {
                    Uri parse = Uri.parse((String) zzfx.zzr.zzb(null));
                    Uri.Builder buildUpon = parse.buildUpon();
                    String authority = parse.getAuthority();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(zzc2).length() + 1 + String.valueOf(authority).length());
                    sb2.append(zzc2);
                    sb2.append(InstructionFileId.DOT);
                    sb2.append(authority);
                    buildUpon.authority(sb2.toString());
                    obj = null;
                    zzosVar = new zzos(buildUpon.build().toString(), Collections.emptyMap(), z19 ? zzlr.GOOGLE_SIGNAL_PENDING : zzlr.GOOGLE_SIGNAL, null);
                } else {
                    obj = null;
                    zzosVar = new zzos((String) zzfx.zzr.zzb(null), Collections.emptyMap(), z19 ? zzlr.GOOGLE_SIGNAL_PENDING : zzlr.GOOGLE_SIGNAL, null);
                }
                arrayList7.add(Pair.create(zzibVar7, zzosVar));
            }
            if (z19) {
                com.google.android.gms.internal.measurement.zzhz zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar5.zzcl();
                for (int i17 = 0; i17 < zzibVar5.zzb(); i17++) {
                    com.google.android.gms.internal.measurement.zzic zzicVar3 = (com.google.android.gms.internal.measurement.zzic) zzibVar5.zzc(i17).zzcl();
                    zzicVar3.zzt();
                    zzicVar3.zzaO(j10);
                    zzhzVar.zzd(i17, zzicVar3);
                }
                arrayList7.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc(), zza22));
                zzL(arrayList422);
                zzU(false, 204, null, null, str, arrayList7);
                if (zzO(str, zza22.zza())) {
                    zzaV().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                    intent.setPackage(str);
                    zzaP(this.zzn.zzaY(), intent);
                    return;
                }
                return;
            }
            j11 = j10;
            zzibVar3 = zzibVar5;
            if (zzi().zzb()) {
            }
        } else {
            list = new ArrayList();
            int i18 = 0;
            while (true) {
                long j14 = cursor2.getLong(i11);
                try {
                    byte[] blob = cursor2.getBlob(i12);
                    zzpj zzp3 = zzj2.zzg.zzp();
                    try {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = gZIPInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        byteArray = byteArrayOutputStream.toByteArray();
                    } catch (IOException e19) {
                        zzp3.zzu.zzaV().zzb().zzb("Failed to ungzip content", e19);
                        throw e19;
                        break;
                    }
                } catch (IOException e20) {
                    zzj2.zzu.zzaV().zzb().zzc("Failed to unzip queued bundle. appId", zzgt.zzl(str), e20);
                }
                if (!list.isEmpty() && byteArray.length + i18 > max) {
                    break;
                }
                try {
                    com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) zzpj.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), byteArray);
                    if (!list.isEmpty()) {
                        com.google.android.gms.internal.measurement.zzid zzidVar4 = (com.google.android.gms.internal.measurement.zzid) ((Pair) list.get(0)).first;
                        com.google.android.gms.internal.measurement.zzid zzidVar5 = (com.google.android.gms.internal.measurement.zzid) zzicVar4.zzbc();
                        if (!zzidVar4.zzaf().equals(zzidVar5.zzaf()) || !zzidVar4.zzam().equals(zzidVar5.zzam()) || zzidVar4.zzao() != zzidVar5.zzao() || !zzidVar4.zzaq().equals(zzidVar5.zzaq())) {
                            break;
                        }
                        Iterator it5 = zzidVar4.zzf().iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                j12 = -1;
                                break;
                            }
                            com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it5.next();
                            if ("_npa".equals(zziuVar.zzc())) {
                                j12 = zziuVar.zzg();
                                break;
                            }
                        }
                        Iterator it6 = zzidVar5.zzf().iterator();
                        while (true) {
                            if (!it6.hasNext()) {
                                j13 = -1;
                                break;
                            }
                            com.google.android.gms.internal.measurement.zziu zziuVar2 = (com.google.android.gms.internal.measurement.zziu) it6.next();
                            if ("_npa".equals(zziuVar2.zzc())) {
                                j13 = zziuVar2.zzg();
                                break;
                            }
                        }
                        if (j12 != j13) {
                            break;
                        }
                    }
                    if (!cursor2.isNull(2)) {
                        zzicVar4.zzao(cursor2.getInt(2));
                    }
                    i18 += byteArray.length;
                    list.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar4.zzbc(), Long.valueOf(j14)));
                } catch (IOException e21) {
                    zzj2.zzu.zzaV().zzb().zzc("Failed to merge queued bundle. appId", zzgt.zzl(str), e21);
                }
                if (!cursor2.moveToNext() || i18 > max) {
                    break;
                }
                i11 = 0;
                i12 = 1;
            }
            cursor2.close();
            if (!list.isEmpty()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zzO(String str, String str2) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null && zzt().zzaa(str, zzu.zzay())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpd zzpdVar = (zzpd) this.zzF.get(str2);
        if (zzpdVar == null) {
            return true;
        }
        return zzpdVar.zzb();
    }

    final void zzP(String str) {
        zzpi zzpiVar;
        com.google.android.gms.internal.measurement.zzib zzd;
        zzaW().zzg();
        zzu();
        this.zzw = true;
        try {
            zzib zzibVar = this.zzn;
            zzibVar.zzaU();
            Boolean zzJ = zzibVar.zzt().zzJ();
            if (zzJ == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaK();
            } else if (!zzi().zzb()) {
                zzaV().zzk().zza("Network not connected, ignoring upload request");
                zzaK();
            } else if (!zzj().zzD(str)) {
                zzaV().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzav zzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzj.zzg();
                zzj.zzay();
                List zzC = zzj.zzC(str, zzon.zza(zzlr.GOOGLE_SIGNAL), 1);
                if (zzC.isEmpty()) {
                    zzpiVar = null;
                } else {
                    zzpiVar = (zzpi) zzC.get(0);
                }
                if (zzpiVar != null && (zzd = zzpiVar.zzd()) != null) {
                    zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpiVar.zzf(), zzpiVar.zze());
                    byte[] zzcc = zzd.zzcc();
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcc.length), zzp().zzi(zzd));
                    }
                    zzos zza = zzpiVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zza, zzd, new zzow(this, str, zzpiVar));
                }
            }
            this.zzw = false;
            zzaL();
        } catch (Throwable th) {
            this.zzw = false;
            zzaL();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0080  */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.lang.String] */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzQ(String str, int i10, Throwable th, byte[] bArr, zzpi zzpiVar) {
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaL();
                throw th2;
            }
        }
        if (i10 != 200) {
            if (i10 == 204) {
                i10 = 204;
            }
            String str2 = new String(bArr, StandardCharsets.UTF_8);
            ?? substring = str2.substring(0, Math.min(32, str2.length()));
            zzgr zzh = zzaV().zzh();
            Integer valueOf = Integer.valueOf(i10);
            if (th == null) {
                th = substring;
            }
            zzh.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf, th);
            zzj().zzK(Long.valueOf(zzpiVar.zzc()));
            zzaK();
            this.zzv = false;
            zzaL();
        }
        if (th == null) {
            zzj().zzE(Long.valueOf(zzpiVar.zzc()));
            zzaV().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i10));
            if (zzi().zzb() && zzj().zzD(str)) {
                zzP(str);
            } else {
                zzaK();
            }
            this.zzv = false;
            zzaL();
        }
        String str22 = new String(bArr, StandardCharsets.UTF_8);
        ?? substring2 = str22.substring(0, Math.min(32, str22.length()));
        zzgr zzh2 = zzaV().zzh();
        Integer valueOf2 = Integer.valueOf(i10);
        if (th == null) {
        }
        zzh2.zzd("Network upload failed. Will retry later. appId, status, error", str, valueOf2, th);
        zzj().zzK(Long.valueOf(zzpiVar.zzc()));
        zzaK();
        this.zzv = false;
        zzaL();
    }

    final void zzR(String str, boolean z10, Long l10, Long l11) {
        zzh zzu = zzj().zzu(str);
        if (zzu != null) {
            zzu.zzar(z10);
            zzu.zzat(l10);
            zzu.zzav(l11);
            if (zzu.zza()) {
                zzj().zzv(zzu, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzS(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int zzx;
        int indexOf;
        Set zzl = zzh().zzl(str);
        if (zzl != null) {
            zzicVar.zzaw(zzl);
        }
        if (zzh().zzp(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzq(str)) {
            String zzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(zzD) && (indexOf = zzD.indexOf(InstructionFileId.DOT)) != -1) {
                zzicVar.zzE(zzD.substring(0, indexOf));
            }
        }
        if (zzh().zzr(str) && (zzx = zzpj.zzx(zzicVar, TransferTable.COLUMN_ID)) != -1) {
            zzicVar.zzr(zzx);
        }
        if (zzh().zzs(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzt(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjj.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpc zzpcVar = (zzpc) map.get(str);
                if (zzpcVar == null || zzpcVar.zzb + zzd().zzl(str, zzfx.zzak) < zzaZ().elapsedRealtime()) {
                    zzpcVar = new zzpc(this, (byte[]) null);
                    map.put(str, zzpcVar);
                }
                zzicVar.zzax(zzpcVar.zza);
            }
        }
        if (zzh().zzu(str)) {
            zzicVar.zzav();
        }
    }

    @VisibleForTesting
    final void zzT(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        int zzf;
        List listOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (!zzpo.zzZ(zzhvVar.zza()) && !zzpo.zzZ(str)) {
            zzf = zzd().zze(str2, true);
        } else {
            zzf = zzd().zzf(str2, true);
        }
        long j10 = zzf;
        long codePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpo zzt = zzt();
        String zza = zzhvVar.zza();
        zzd();
        String zzC = zzt.zzC(zza, 40, true);
        if (codePointCount > j10 && !listOf.contains(zzhvVar.zza())) {
            if ("_ev".equals(zzhvVar.zza())) {
                bundle.putString("_ev", zzt().zzC(zzhvVar.zzc(), zzd().zzf(str2, true), true));
                return;
            }
            zzaV().zzh().zzc("Param value is too long; discarded. Name, value length", zzC, Long.valueOf(codePointCount));
            if (bundle.getLong("_err") == 0) {
                bundle.putLong("_err", 4L);
                if (bundle.getString("_ev") == null) {
                    bundle.putString("_ev", zzC);
                    bundle.putLong("_el", codePointCount);
                }
            }
            bundle.remove(zzhvVar.zza());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
    
        if (r24 != null) goto L١٦;
     */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzU(boolean z10, int i10, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        int i11 = i10;
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaL();
                throw th2;
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        try {
            if (z10) {
                if (i11 != 200) {
                    if (i11 == 204) {
                        i11 = 204;
                    }
                    String str2 = new String(bArr2, StandardCharsets.UTF_8);
                    zzaV().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i11), th, str2.substring(0, Math.min(32, str2.length())));
                    this.zzk.zze.zzb(zzaZ().currentTimeMillis());
                    if (i11 == 503 || i11 == 429) {
                        this.zzk.zzc.zzb(zzaZ().currentTimeMillis());
                    }
                    zzj().zzJ(list2);
                    zzaK();
                    this.zzv = false;
                    zzaL();
                    return;
                }
            }
            HashMap hashMap = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                com.google.android.gms.internal.measurement.zzib zzibVar = (com.google.android.gms.internal.measurement.zzib) pair.first;
                zzos zzosVar = (zzos) pair.second;
                if (zzosVar.zzc() != zzlr.SGTM_CLIENT) {
                    long zzA = zzj().zzA(str, zzibVar, zzosVar.zza(), zzosVar.zzb(), zzosVar.zzc(), null);
                    if (zzosVar.zzc() == zzlr.GOOGLE_SIGNAL_PENDING && zzA != -1 && !zzibVar.zze().isEmpty()) {
                        hashMap.put(zzibVar.zze(), Long.valueOf(zzA));
                    }
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Pair pair2 = (Pair) it2.next();
                com.google.android.gms.internal.measurement.zzib zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair2.first;
                zzos zzosVar2 = (zzos) pair2.second;
                if (zzosVar2.zzc() == zzlr.SGTM_CLIENT) {
                    zzj().zzA(str, zzibVar2, zzosVar2.zza(), zzosVar2.zzb(), zzosVar2.zzc(), (Long) hashMap.get(zzibVar2.zze()));
                }
            }
            List zzC = zzj().zzC(str, zzon.zza(zzlr.SGTM_CLIENT), 1);
            if (!zzC.isEmpty()) {
                long zzg = ((zzpi) zzC.get(0)).zzg();
                if (zzaZ().currentTimeMillis() > ((Long) zzfx.zzE.zzb(null)).longValue() + zzg) {
                    zzaV().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(zzg));
                }
            }
            for (Long l10 : list2) {
                try {
                    zzj().zzH(l10.longValue());
                } catch (SQLiteException e10) {
                    List list3 = this.zzA;
                    if (list3 == null || !list3.contains(l10)) {
                        throw e10;
                    }
                }
            }
            zzj().zzc();
            zzj().zzd();
            this.zzA = null;
            if (zzi().zzb() && zzj().zzD(str)) {
                zzP(str);
            } else if (zzi().zzb() && zzaI()) {
                zzM();
            } else {
                this.zzB = -1L;
                zzaK();
            }
            this.zza = 0L;
            this.zzv = false;
            zzaL();
            return;
        } catch (Throwable th3) {
            zzj().zzd();
            throw th3;
        }
        zzgr zzk = zzaV().zzk();
        Integer valueOf = Integer.valueOf(i11);
        zzk.zzc("Network upload successful with code, uploadAttempted", valueOf, Boolean.valueOf(z10));
        if (z10) {
            try {
                this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
            } catch (SQLiteException e11) {
                zzaV().zzb().zzb("Database error while trying to delete uploaded bundles", e11);
                this.zza = zzaZ().elapsedRealtime();
                zzaV().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
        }
        this.zzk.zze.zzb(0L);
        zzaK();
        if (z10) {
            zzaV().zzk().zzc("Successful upload. Got network response. code, size", valueOf, Integer.valueOf(bArr2.length));
        } else {
            zzaV().zzk().zza("Purged empty bundles");
        }
        zzj().zzb();
    }

    final void zzV(zzh zzhVar) {
        zzaW().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzW((String) Preconditions.checkNotNull(zzhVar.zzc()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaV().zzk().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzb2 = zzh().zzb(str);
        String zzd = zzh().zzd(str);
        androidx.collection.a aVar = null;
        if (zzb2 != null) {
            if (!TextUtils.isEmpty(zzd)) {
                aVar = new androidx.collection.a();
                aVar.put(Headers.GET_OBJECT_IF_MODIFIED_SINCE, zzd);
            }
            String zze = zzh().zze(str);
            if (!TextUtils.isEmpty(zze)) {
                if (aVar == null) {
                    aVar = new androidx.collection.a();
                }
                aVar.put(Headers.GET_OBJECT_IF_NONE_MATCH, zze);
            }
        }
        this.zzu = true;
        zzi().zzd(zzhVar, aVar, new zzgv() { // from class: com.google.android.gms.measurement.internal.zzpe
            @Override // com.google.android.gms.measurement.internal.zzgv
            public final /* synthetic */ void zza(String str2, int i10, Throwable th, byte[] bArr, Map map) {
                zzpf.this.zzW(str2, i10, th, bArr, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004d A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:5:0x002f, B:13:0x004d, B:14:0x0154, B:24:0x006a, B:28:0x00ba, B:29:0x00ab, B:30:0x00bf, B:34:0x00d0, B:35:0x00ea, B:37:0x00fe, B:38:0x011d, B:40:0x0127, B:42:0x012d, B:43:0x0131, B:45:0x013b, B:47:0x0149, B:48:0x0151, B:49:0x010c, B:50:0x00d8, B:52:0x00e2), top: B:4:0x002f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:5:0x002f, B:13:0x004d, B:14:0x0154, B:24:0x006a, B:28:0x00ba, B:29:0x00ab, B:30:0x00bf, B:34:0x00d0, B:35:0x00ea, B:37:0x00fe, B:38:0x011d, B:40:0x0127, B:42:0x012d, B:43:0x0131, B:45:0x013b, B:47:0x0149, B:48:0x0151, B:49:0x010c, B:50:0x00d8, B:52:0x00e2), top: B:4:0x002f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x010c A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:5:0x002f, B:13:0x004d, B:14:0x0154, B:24:0x006a, B:28:0x00ba, B:29:0x00ab, B:30:0x00bf, B:34:0x00d0, B:35:0x00ea, B:37:0x00fe, B:38:0x011d, B:40:0x0127, B:42:0x012d, B:43:0x0131, B:45:0x013b, B:47:0x0149, B:48:0x0151, B:49:0x010c, B:50:0x00d8, B:52:0x00e2), top: B:4:0x002f, outer: #1 }] */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzW(String str, int i10, Throwable th, byte[] bArr, Map map) {
        boolean z10;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzaL();
                throw th2;
            }
        }
        zzgr zzk = zzaV().zzk();
        Integer valueOf = Integer.valueOf(bArr.length);
        zzk.zzb("onConfigFetched. Response size", valueOf);
        zzj().zzb();
        try {
            zzh zzu = zzj().zzu(str);
            if (i10 != 200 && i10 != 204) {
                if (i10 == 304) {
                    i10 = HttpConstant.SC_NOT_MODIFIED;
                }
                z10 = false;
                if (zzu == null) {
                    zzaV().zze().zzb("App does not exist in onConfigFetched. appId", zzgt.zzl(str));
                } else {
                    if (!z10 && i10 != 404) {
                        zzu.zzK(zzaZ().currentTimeMillis());
                        zzj().zzv(zzu, false, false);
                        zzaV().zzk().zzc("Fetching config failed. code, error", Integer.valueOf(i10), th);
                        zzh().zzf(str);
                        this.zzk.zze.zzb(zzaZ().currentTimeMillis());
                        if (i10 == 503 || i10 == 429) {
                            this.zzk.zzc.zzb(zzaZ().currentTimeMillis());
                        }
                        zzaK();
                    }
                    String zzaJ = zzaJ(map, Headers.LAST_MODIFIED);
                    String zzaJ2 = zzaJ(map, Headers.ETAG);
                    if (i10 != 404 && i10 != 304) {
                        zzh().zzi(str, bArr, zzaJ, zzaJ2);
                        zzu.zzI(zzaZ().currentTimeMillis());
                        zzj().zzv(zzu, false, false);
                        if (i10 != 404) {
                            zzaV().zzh().zzb("Config not found. Using empty config. appId", str);
                        } else {
                            zzaV().zzk().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i10), valueOf);
                        }
                        if (!zzi().zzb() && zzaI()) {
                            zzM();
                        } else if (!zzi().zzb() && zzj().zzD(zzu.zzc())) {
                            zzP(zzu.zzc());
                        } else {
                            zzaK();
                        }
                    }
                    if (zzh().zzb(str) == null) {
                        zzh().zzi(str, null, null, null);
                    }
                    zzu.zzI(zzaZ().currentTimeMillis());
                    zzj().zzv(zzu, false, false);
                    if (i10 != 404) {
                    }
                    if (!zzi().zzb()) {
                    }
                    if (!zzi().zzb()) {
                    }
                    zzaK();
                }
                zzj().zzc();
                zzj().zzd();
                this.zzu = false;
                zzaL();
            }
            if (th == null) {
                z10 = true;
                if (zzu == null) {
                }
                zzj().zzc();
                zzj().zzd();
                this.zzu = false;
                zzaL();
            }
            z10 = false;
            if (zzu == null) {
            }
            zzj().zzc();
            zzj().zzd();
            this.zzu = false;
            zzaL();
        } catch (Throwable th3) {
            zzj().zzd();
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzX(Runnable runnable) {
        zzaW().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzY() {
        zzaW().zzg();
        zzu();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzy;
                zzaW().zzg();
                int i10 = 0;
                if (fileChannel != null && fileChannel.isOpen()) {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0L);
                        int read = fileChannel.read(allocate);
                        if (read != 4) {
                            if (read != -1) {
                                zzaV().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                            }
                        } else {
                            allocate.flip();
                            i10 = allocate.getInt();
                        }
                    } catch (IOException e10) {
                        zzaV().zzb().zzb("Failed to read from channel", e10);
                    }
                } else {
                    zzaV().zzb().zza("Bad channel to read from");
                }
                int zzm = this.zzn.zzv().zzm();
                zzaW().zzg();
                if (i10 > zzm) {
                    zzaV().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzm));
                    return;
                }
                if (i10 < zzm) {
                    FileChannel fileChannel2 = this.zzy;
                    zzaW().zzg();
                    if (fileChannel2 != null && fileChannel2.isOpen()) {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzm);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0L);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzaV().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzaV().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzm));
                            return;
                        } catch (IOException e11) {
                            zzaV().zzb().zzb("Failed to write to channel", e11);
                        }
                    } else {
                        zzaV().zzb().zza("Bad channel to read from");
                    }
                    zzaV().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzm));
                }
            }
        }
    }

    @VisibleForTesting
    final boolean zzZ() {
        zzaW().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaV().zzk().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzc();
        File filesDir = this.zzn.zzaY().getFilesDir();
        com.google.android.gms.internal.measurement.zzbv.zza();
        int i10 = com.google.android.gms.internal.measurement.zzca.zzb;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock tryLock = channel.tryLock();
            this.zzx = tryLock;
            if (tryLock != null) {
                zzaV().zzk().zza("Storage concurrent access okay");
                return true;
            }
            zzaV().zzb().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e10) {
            zzaV().zzb().zzb("Failed to acquire storage lock", e10);
            return false;
        } catch (IOException e11) {
            zzaV().zzb().zzb("Failed to access storage lock file", e11);
            return false;
        } catch (OverlappingFileLockException e12) {
            zzaV().zze().zzb("Storage lock already acquired", e12);
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzae zzaU() {
        return this.zzn.zzaU();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzgt zzaV() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final zzhy zzaW() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final Context zzaY() {
        return this.zzn.zzaY();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final Clock zzaZ() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting(otherwise = 4)
    public final void zzaa(zzr zzrVar) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzav zzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzj.zzg();
        zzj.zzay();
        try {
            SQLiteDatabase zze = zzj.zze();
            String[] strArr = {str};
            int delete = zze.delete("apps", "app_id=?", strArr) + zze.delete("events", "app_id=?", strArr) + zze.delete("events_snapshot", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("queue", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("main_event_params", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr) + zze.delete("upload_queue", "app_id=?", strArr);
            com.google.android.gms.internal.measurement.zzpk.zza();
            zzib zzibVar = zzj.zzu;
            if (zzibVar.zzc().zzp(null, zzfx.zzbi)) {
                delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (delete > 0) {
                zzibVar.zzaV().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            zzj.zzu.zzaV().zzb().zzc("Error resetting analytics data. appId, error", zzgt.zzl(str), e10);
        }
        if (zzrVar.zzh) {
            zzag(zzrVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzab(zzpk zzpkVar, zzr zzrVar) {
        String str;
        zzpm zzm;
        long j10;
        int i10;
        int i11;
        zzaW().zzg();
        zzu();
        if (zzaQ(zzrVar)) {
            if (!zzrVar.zzh) {
                zzan(zzrVar);
                return;
            }
            zzpo zzt = zzt();
            String str2 = zzpkVar.zzb;
            int zzp = zzt.zzp(str2);
            if (zzp != 0) {
                zzpo zzt2 = zzt();
                zzd();
                String zzC = zzt2.zzC(str2, 24, true);
                if (str2 != null) {
                    i11 = str2.length();
                } else {
                    i11 = 0;
                }
                zzt().zzN(this.zzK, zzrVar.zza, zzp, "_ev", zzC, i11);
                return;
            }
            int zzK = zzt().zzK(str2, zzpkVar.zza());
            if (zzK != 0) {
                zzpo zzt3 = zzt();
                zzd();
                String zzC2 = zzt3.zzC(str2, 24, true);
                Object zza = zzpkVar.zza();
                if (zza == null || (!(zza instanceof String) && !(zza instanceof CharSequence))) {
                    i10 = 0;
                } else {
                    i10 = zza.toString().length();
                }
                zzt().zzN(this.zzK, zzrVar.zza, zzK, "_ev", zzC2, i10);
                return;
            }
            Object zzL = zzt().zzL(str2, zzpkVar.zza());
            if (zzL != null) {
                if (!"_sid".equals(str2)) {
                    str = "_sid";
                } else {
                    long j11 = zzpkVar.zzc;
                    String str3 = zzpkVar.zzf;
                    String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpm zzm2 = zzj().zzm(str4, "_sno");
                    if (zzm2 != null) {
                        Object obj = zzm2.zze;
                        if (obj instanceof Long) {
                            j10 = ((Long) obj).longValue();
                            str = "_sid";
                            zzab(new zzpk("_sno", j11, Long.valueOf(j10 + 1), str3), zzrVar);
                        }
                    }
                    if (zzm2 != null) {
                        zzaV().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzm2.zze);
                    }
                    zzbc zzf = zzj().zzf(str4, "_s");
                    if (zzf == null) {
                        str = "_sid";
                        j10 = 0;
                    } else {
                        zzgr zzk = zzaV().zzk();
                        str = "_sid";
                        long j12 = zzf.zzc;
                        zzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j12));
                        j10 = j12;
                    }
                    zzab(new zzpk("_sno", j11, Long.valueOf(j10 + 1), str3), zzrVar);
                }
                String str5 = zzrVar.zza;
                zzpm zzpmVar = new zzpm((String) Preconditions.checkNotNull(str5), (String) Preconditions.checkNotNull(zzpkVar.zzf), str2, zzpkVar.zzc, zzL);
                zzgr zzk2 = zzaV().zzk();
                zzib zzibVar = this.zzn;
                String str6 = zzpmVar.zzc;
                zzk2.zzc("Setting user property", zzibVar.zzl().zzc(str6), zzL);
                zzj().zzb();
                try {
                    if (TransferTable.COLUMN_ID.equals(str6) && (zzm = zzj().zzm(str5, TransferTable.COLUMN_ID)) != null && !zzpmVar.zze.equals(zzm.zze)) {
                        zzj().zzk(str5, "_lair");
                    }
                    zzan(zzrVar);
                    boolean zzl = zzj().zzl(zzpmVar);
                    if (str.equals(str2)) {
                        long zzu = zzp().zzu(zzrVar.zzu);
                        zzh zzu2 = zzj().zzu(str5);
                        if (zzu2 != null) {
                            zzu2.zzan(zzu);
                            if (zzu2.zza()) {
                                zzj().zzv(zzu2, false, false);
                            }
                        }
                    }
                    zzj().zzc();
                    if (!zzl) {
                        zzaV().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzibVar.zzl().zzc(str6), zzpmVar.zze);
                        zzt().zzN(this.zzK, str5, 9, null, null, 0);
                    }
                    zzj().zzd();
                } catch (Throwable th) {
                    zzj().zzd();
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzac(String str, zzr zzrVar) {
        long j10;
        zzaW().zzg();
        zzu();
        if (!zzaQ(zzrVar)) {
            return;
        }
        if (!zzrVar.zzh) {
            zzan(zzrVar);
            return;
        }
        Boolean zzaT = zzaT(zzrVar);
        if ("_npa".equals(str) && zzaT != null) {
            zzaV().zzj().zza("Falling back to manifest metadata value for ad personalization");
            long currentTimeMillis = zzaZ().currentTimeMillis();
            if (true != zzaT.booleanValue()) {
                j10 = 0;
            } else {
                j10 = 1;
            }
            zzab(new zzpk("_npa", currentTimeMillis, Long.valueOf(j10), "auto"), zzrVar);
            return;
        }
        zzgr zzj = zzaV().zzj();
        zzib zzibVar = this.zzn;
        zzj.zzb("Removing user property", zzibVar.zzl().zzc(str));
        zzj().zzb();
        try {
            zzan(zzrVar);
            if (TransferTable.COLUMN_ID.equals(str)) {
                zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
            }
            zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
            zzj().zzc();
            zzaV().zzj().zzb("User property removed", zzibVar.zzl().zzc(str));
            zzj().zzd();
        } catch (Throwable th) {
            zzj().zzd();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad() {
        this.zzs++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzae() {
        this.zzt++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzib zzaf() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:63|64|(2:66|(8:68|(3:70|(2:72|(1:74))(1:94)|75)(1:95)|76|(1:78)(1:93)|79|80|81|(4:83|(1:85)(1:89)|86|(1:88))))|96|80|81|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00be, code lost:
    
        if (true == r11.booleanValue()) goto L٣٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00c0, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00c5, code lost:
    
        r3 = new com.google.android.gms.measurement.internal.zzpk("_npa", r13, java.lang.Long.valueOf(r17), "auto");
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x00d2, code lost:
    
        if (r10 == null) goto L٤١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x00dc, code lost:
    
        if (r10.zze.equals(r3.zzd) != false) goto L٤٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00de, code lost:
    
        zzab(r3, r26);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00c3, code lost:
    
        r17 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x033d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x033e, code lost:
    
        zzaV().zzb().zzc("Application info is null, first open report might be inaccurate. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r6), r0);
        r0 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03d9 A[Catch: all -> 0x00b1, TryCatch #2 {all -> 0x00b1, blocks: (B:25:0x0093, B:27:0x00a4, B:31:0x00e8, B:33:0x00f5, B:34:0x00fe, B:36:0x0103, B:38:0x011c, B:41:0x0131, B:43:0x015a, B:45:0x0164, B:47:0x0173, B:48:0x024d, B:50:0x027b, B:51:0x027e, B:53:0x02a6, B:57:0x036f, B:58:0x0372, B:59:0x03fa, B:64:0x02bb, B:66:0x02de, B:68:0x02e6, B:70:0x02ec, B:74:0x02ff, B:76:0x0310, B:79:0x031c, B:81:0x032d, B:92:0x033e, B:83:0x0352, B:85:0x0358, B:86:0x0360, B:88:0x0366, B:94:0x0308, B:99:0x02ca, B:100:0x0184, B:102:0x01ad, B:103:0x01bc, B:105:0x01c3, B:107:0x01c9, B:109:0x01d3, B:111:0x01d9, B:113:0x01df, B:115:0x01e5, B:117:0x01ea, B:120:0x020a, B:125:0x020e, B:126:0x0222, B:127:0x0230, B:129:0x023e, B:130:0x038a, B:132:0x03bf, B:133:0x03c2, B:134:0x03d9, B:136:0x03df, B:137:0x010f, B:138:0x00fb, B:140:0x00b6, B:143:0x00c5, B:145:0x00d4, B:147:0x00de, B:151:0x00e5), top: B:24:0x0093, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x010f A[Catch: all -> 0x00b1, TryCatch #2 {all -> 0x00b1, blocks: (B:25:0x0093, B:27:0x00a4, B:31:0x00e8, B:33:0x00f5, B:34:0x00fe, B:36:0x0103, B:38:0x011c, B:41:0x0131, B:43:0x015a, B:45:0x0164, B:47:0x0173, B:48:0x024d, B:50:0x027b, B:51:0x027e, B:53:0x02a6, B:57:0x036f, B:58:0x0372, B:59:0x03fa, B:64:0x02bb, B:66:0x02de, B:68:0x02e6, B:70:0x02ec, B:74:0x02ff, B:76:0x0310, B:79:0x031c, B:81:0x032d, B:92:0x033e, B:83:0x0352, B:85:0x0358, B:86:0x0360, B:88:0x0366, B:94:0x0308, B:99:0x02ca, B:100:0x0184, B:102:0x01ad, B:103:0x01bc, B:105:0x01c3, B:107:0x01c9, B:109:0x01d3, B:111:0x01d9, B:113:0x01df, B:115:0x01e5, B:117:0x01ea, B:120:0x020a, B:125:0x020e, B:126:0x0222, B:127:0x0230, B:129:0x023e, B:130:0x038a, B:132:0x03bf, B:133:0x03c2, B:134:0x03d9, B:136:0x03df, B:137:0x010f, B:138:0x00fb, B:140:0x00b6, B:143:0x00c5, B:145:0x00d4, B:147:0x00de, B:151:0x00e5), top: B:24:0x0093, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00fb A[Catch: all -> 0x00b1, TryCatch #2 {all -> 0x00b1, blocks: (B:25:0x0093, B:27:0x00a4, B:31:0x00e8, B:33:0x00f5, B:34:0x00fe, B:36:0x0103, B:38:0x011c, B:41:0x0131, B:43:0x015a, B:45:0x0164, B:47:0x0173, B:48:0x024d, B:50:0x027b, B:51:0x027e, B:53:0x02a6, B:57:0x036f, B:58:0x0372, B:59:0x03fa, B:64:0x02bb, B:66:0x02de, B:68:0x02e6, B:70:0x02ec, B:74:0x02ff, B:76:0x0310, B:79:0x031c, B:81:0x032d, B:92:0x033e, B:83:0x0352, B:85:0x0358, B:86:0x0360, B:88:0x0366, B:94:0x0308, B:99:0x02ca, B:100:0x0184, B:102:0x01ad, B:103:0x01bc, B:105:0x01c3, B:107:0x01c9, B:109:0x01d3, B:111:0x01d9, B:113:0x01df, B:115:0x01e5, B:117:0x01ea, B:120:0x020a, B:125:0x020e, B:126:0x0222, B:127:0x0230, B:129:0x023e, B:130:0x038a, B:132:0x03bf, B:133:0x03c2, B:134:0x03d9, B:136:0x03df, B:137:0x010f, B:138:0x00fb, B:140:0x00b6, B:143:0x00c5, B:145:0x00d4, B:147:0x00de, B:151:0x00e5), top: B:24:0x0093, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f5 A[Catch: all -> 0x00b1, TryCatch #2 {all -> 0x00b1, blocks: (B:25:0x0093, B:27:0x00a4, B:31:0x00e8, B:33:0x00f5, B:34:0x00fe, B:36:0x0103, B:38:0x011c, B:41:0x0131, B:43:0x015a, B:45:0x0164, B:47:0x0173, B:48:0x024d, B:50:0x027b, B:51:0x027e, B:53:0x02a6, B:57:0x036f, B:58:0x0372, B:59:0x03fa, B:64:0x02bb, B:66:0x02de, B:68:0x02e6, B:70:0x02ec, B:74:0x02ff, B:76:0x0310, B:79:0x031c, B:81:0x032d, B:92:0x033e, B:83:0x0352, B:85:0x0358, B:86:0x0360, B:88:0x0366, B:94:0x0308, B:99:0x02ca, B:100:0x0184, B:102:0x01ad, B:103:0x01bc, B:105:0x01c3, B:107:0x01c9, B:109:0x01d3, B:111:0x01d9, B:113:0x01df, B:115:0x01e5, B:117:0x01ea, B:120:0x020a, B:125:0x020e, B:126:0x0222, B:127:0x0230, B:129:0x023e, B:130:0x038a, B:132:0x03bf, B:133:0x03c2, B:134:0x03d9, B:136:0x03df, B:137:0x010f, B:138:0x00fb, B:140:0x00b6, B:143:0x00c5, B:145:0x00d4, B:147:0x00de, B:151:0x00e5), top: B:24:0x0093, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0103 A[Catch: all -> 0x00b1, TryCatch #2 {all -> 0x00b1, blocks: (B:25:0x0093, B:27:0x00a4, B:31:0x00e8, B:33:0x00f5, B:34:0x00fe, B:36:0x0103, B:38:0x011c, B:41:0x0131, B:43:0x015a, B:45:0x0164, B:47:0x0173, B:48:0x024d, B:50:0x027b, B:51:0x027e, B:53:0x02a6, B:57:0x036f, B:58:0x0372, B:59:0x03fa, B:64:0x02bb, B:66:0x02de, B:68:0x02e6, B:70:0x02ec, B:74:0x02ff, B:76:0x0310, B:79:0x031c, B:81:0x032d, B:92:0x033e, B:83:0x0352, B:85:0x0358, B:86:0x0360, B:88:0x0366, B:94:0x0308, B:99:0x02ca, B:100:0x0184, B:102:0x01ad, B:103:0x01bc, B:105:0x01c3, B:107:0x01c9, B:109:0x01d3, B:111:0x01d9, B:113:0x01df, B:115:0x01e5, B:117:0x01ea, B:120:0x020a, B:125:0x020e, B:126:0x0222, B:127:0x0230, B:129:0x023e, B:130:0x038a, B:132:0x03bf, B:133:0x03c2, B:134:0x03d9, B:136:0x03df, B:137:0x010f, B:138:0x00fb, B:140:0x00b6, B:143:0x00c5, B:145:0x00d4, B:147:0x00de, B:151:0x00e5), top: B:24:0x0093, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011c A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #2 {all -> 0x00b1, blocks: (B:25:0x0093, B:27:0x00a4, B:31:0x00e8, B:33:0x00f5, B:34:0x00fe, B:36:0x0103, B:38:0x011c, B:41:0x0131, B:43:0x015a, B:45:0x0164, B:47:0x0173, B:48:0x024d, B:50:0x027b, B:51:0x027e, B:53:0x02a6, B:57:0x036f, B:58:0x0372, B:59:0x03fa, B:64:0x02bb, B:66:0x02de, B:68:0x02e6, B:70:0x02ec, B:74:0x02ff, B:76:0x0310, B:79:0x031c, B:81:0x032d, B:92:0x033e, B:83:0x0352, B:85:0x0358, B:86:0x0360, B:88:0x0366, B:94:0x0308, B:99:0x02ca, B:100:0x0184, B:102:0x01ad, B:103:0x01bc, B:105:0x01c3, B:107:0x01c9, B:109:0x01d3, B:111:0x01d9, B:113:0x01df, B:115:0x01e5, B:117:0x01ea, B:120:0x020a, B:125:0x020e, B:126:0x0222, B:127:0x0230, B:129:0x023e, B:130:0x038a, B:132:0x03bf, B:133:0x03c2, B:134:0x03d9, B:136:0x03df, B:137:0x010f, B:138:0x00fb, B:140:0x00b6, B:143:0x00c5, B:145:0x00d4, B:147:0x00de, B:151:0x00e5), top: B:24:0x0093, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0352 A[Catch: all -> 0x00b1, TryCatch #2 {all -> 0x00b1, blocks: (B:25:0x0093, B:27:0x00a4, B:31:0x00e8, B:33:0x00f5, B:34:0x00fe, B:36:0x0103, B:38:0x011c, B:41:0x0131, B:43:0x015a, B:45:0x0164, B:47:0x0173, B:48:0x024d, B:50:0x027b, B:51:0x027e, B:53:0x02a6, B:57:0x036f, B:58:0x0372, B:59:0x03fa, B:64:0x02bb, B:66:0x02de, B:68:0x02e6, B:70:0x02ec, B:74:0x02ff, B:76:0x0310, B:79:0x031c, B:81:0x032d, B:92:0x033e, B:83:0x0352, B:85:0x0358, B:86:0x0360, B:88:0x0366, B:94:0x0308, B:99:0x02ca, B:100:0x0184, B:102:0x01ad, B:103:0x01bc, B:105:0x01c3, B:107:0x01c9, B:109:0x01d3, B:111:0x01d9, B:113:0x01df, B:115:0x01e5, B:117:0x01ea, B:120:0x020a, B:125:0x020e, B:126:0x0222, B:127:0x0230, B:129:0x023e, B:130:0x038a, B:132:0x03bf, B:133:0x03c2, B:134:0x03d9, B:136:0x03df, B:137:0x010f, B:138:0x00fb, B:140:0x00b6, B:143:0x00c5, B:145:0x00d4, B:147:0x00de, B:151:0x00e5), top: B:24:0x0093, inners: #0, #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzag(zzr zzrVar) {
        zzbc zzf;
        boolean z10;
        long j10;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        long j11;
        boolean z11;
        long j12;
        String str;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        if (!zzaQ(zzrVar)) {
            return;
        }
        zzh zzu = zzj().zzu(str2);
        if (zzu != null && TextUtils.isEmpty(zzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
            zzu.zzI(0L);
            zzj().zzv(zzu, false, false);
            zzh().zzh(str2);
        }
        if (!zzrVar.zzh) {
            zzan(zzrVar);
            return;
        }
        long j13 = zzrVar.zzl;
        if (j13 == 0) {
            j13 = zzaZ().currentTimeMillis();
        }
        int i10 = zzrVar.zzm;
        if (i10 != 0 && i10 != 1) {
            zzaV().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgt.zzl(str2), Integer.valueOf(i10));
            i10 = 0;
        }
        zzj().zzb();
        try {
            zzpm zzm = zzj().zzm(str2, "_npa");
            Boolean zzaT = zzaT(zzrVar);
            if (zzm != null && !"auto".equals(zzm.zzb)) {
                if (!zzd().zzp(null, zzfx.zzbc)) {
                    zzam(zzrVar, zzrVar.zzD);
                } else {
                    zzam(zzrVar, j13);
                }
                zzan(zzrVar);
                if (i10 != 0) {
                    zzf = zzj().zzf(str2, "_f");
                    z10 = false;
                } else {
                    zzf = zzj().zzf(str2, "_v");
                    z10 = true;
                }
                if (zzf != null) {
                    long j14 = ((j13 / 3600000) + 1) * 3600000;
                    if (!z10) {
                        zzab(new zzpk("_fot", j13, Long.valueOf(j14), "auto"), zzrVar);
                        zzaW().zzg();
                        zzhj zzhjVar = (zzhj) Preconditions.checkNotNull(this.zzm);
                        if (str2 == null || str2.isEmpty()) {
                            j10 = j13;
                            zzhjVar.zza.zzaV().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzib zzibVar = zzhjVar.zza;
                            zzibVar.zzaW().zzg();
                            if (!zzhjVar.zza()) {
                                zzibVar.zzaV().zzi().zza("Install Referrer Reporter is not available");
                                j10 = j13;
                            } else {
                                zzhi zzhiVar = new zzhi(zzhjVar, str2);
                                zzibVar.zzaW().zzg();
                                j10 = j13;
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzibVar.zzaY().getPackageManager();
                                if (packageManager == null) {
                                    zzibVar.zzaV().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                                        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                                        if (serviceInfo != null) {
                                            String str3 = serviceInfo.packageName;
                                            if (serviceInfo.name != null && "com.android.vending".equals(str3) && zzhjVar.zza()) {
                                                try {
                                                    boolean bindService = ConnectionTracker.getInstance().bindService(zzibVar.zzaY(), new Intent(intent), zzhiVar, 1);
                                                    zzgr zzk = zzibVar.zzaV().zzk();
                                                    if (bindService) {
                                                        str = "available";
                                                    } else {
                                                        str = "not available";
                                                    }
                                                    zzk.zzb("Install Referrer Service is", str);
                                                } catch (RuntimeException e10) {
                                                    zzhjVar.zza.zzaV().zzb().zzb("Exception occurred while binding to Install Referrer Service", e10.getMessage());
                                                }
                                            } else {
                                                zzibVar.zzaV().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    } else {
                                        zzibVar.zzaV().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    }
                                }
                            }
                        }
                        zzaW().zzg();
                        zzu();
                        Bundle bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_uwa", 0L);
                        bundle.putLong("_pfo", 0L);
                        bundle.putLong("_sys", 0L);
                        bundle.putLong("_sysu", 0L);
                        bundle.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle.putLong("_dac", 1L);
                        }
                        String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                        zzav zzj = zzj();
                        Preconditions.checkNotEmpty(str4);
                        zzj.zzg();
                        zzj.zzay();
                        long zzN = zzj.zzN(str4, "first_open_count");
                        zzib zzibVar2 = this.zzn;
                        if (zzibVar2.zzaY().getPackageManager() == null) {
                            zzaV().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgt.zzl(str4));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(zzibVar2.zzaY()).getPackageInfo(str4, 0);
                            } catch (PackageManager.NameNotFoundException e11) {
                                zzaV().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgt.zzl(str4), e11);
                                packageInfo = null;
                            }
                            if (packageInfo != null) {
                                long j15 = packageInfo.firstInstallTime;
                                if (j15 != 0) {
                                    if (j15 != packageInfo.lastUpdateTime) {
                                        applicationInfo = null;
                                        if (zzd().zzp(null, zzfx.zzaI)) {
                                            if (zzN == 0) {
                                                bundle.putLong("_uwa", 1L);
                                                zzN = 0;
                                            }
                                        } else {
                                            bundle.putLong("_uwa", 1L);
                                        }
                                        z11 = false;
                                    } else {
                                        applicationInfo = null;
                                        z11 = true;
                                    }
                                    if (true != z11) {
                                        j12 = 0;
                                    } else {
                                        j12 = 1;
                                    }
                                    zzab(new zzpk("_fi", j10, Long.valueOf(j12), "auto"), zzrVar);
                                    applicationInfo2 = Wrappers.packageManager(this.zzn.zzaY()).getApplicationInfo(str4, 0);
                                    if (applicationInfo2 != null) {
                                        if ((applicationInfo2.flags & 1) != 0) {
                                            j11 = 1;
                                            bundle.putLong("_sys", 1L);
                                        } else {
                                            j11 = 1;
                                        }
                                        if ((applicationInfo2.flags & 128) != 0) {
                                            bundle.putLong("_sysu", j11);
                                        }
                                    }
                                }
                            }
                            applicationInfo = null;
                            applicationInfo2 = Wrappers.packageManager(this.zzn.zzaY()).getApplicationInfo(str4, 0);
                            if (applicationInfo2 != null) {
                            }
                        }
                        if (zzN >= 0) {
                            bundle.putLong("_pfo", zzN);
                        }
                        zzE(new zzbg("_f", new zzbe(bundle), "auto", j10), zzrVar);
                    } else {
                        long j16 = j13;
                        zzab(new zzpk("_fvt", j16, Long.valueOf(j14), "auto"), zzrVar);
                        zzaW().zzg();
                        zzu();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle2.putLong("_dac", 1L);
                        }
                        zzE(new zzbg("_v", new zzbe(bundle2), "auto", j16), zzrVar);
                    }
                } else {
                    long j17 = j13;
                    if (zzrVar.zzi) {
                        zzE(new zzbg("_cd", new zzbe(new Bundle()), "auto", j17), zzrVar);
                    }
                }
                zzj().zzc();
                zzj().zzd();
            }
            if (zzm != null) {
                zzac("_npa", zzrVar);
            }
            if (!zzd().zzp(null, zzfx.zzbc)) {
            }
            zzan(zzrVar);
            if (i10 != 0) {
            }
            if (zzf != null) {
            }
            zzj().zzc();
            zzj().zzd();
        } catch (Throwable th) {
            zzj().zzd();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzah(zzr zzrVar) {
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i10 = 0;
        if (zzd().zzp(null, zzfx.zzaz)) {
            long currentTimeMillis = zzaZ().currentTimeMillis();
            int zzm = zzd().zzm(null, zzfx.zzai);
            zzd();
            long zzF = currentTimeMillis - zzal.zzF();
            while (i10 < zzm && zzaF(null, zzF)) {
                i10++;
            }
        } else {
            zzd();
            long zzH = zzal.zzH();
            while (i10 < zzH && zzaF(str, 0L)) {
                i10++;
            }
        }
        if (zzd().zzp(null, zzfx.zzaA)) {
            zzaW().zzg();
            zzau();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaV().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzaZ().currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzai(zzah zzahVar) {
        zzr zzaN = zzaN((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaN != null) {
            zzaj(zzahVar, zzaN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaj(zzah zzahVar, zzr zzrVar) {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (!zzaQ(zzrVar)) {
            return;
        }
        if (!zzrVar.zzh) {
            zzan(zzrVar);
            return;
        }
        zzah zzahVar2 = new zzah(zzahVar);
        boolean z10 = false;
        zzahVar2.zze = false;
        zzj().zzb();
        try {
            zzah zzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
            if (zzq != null && !zzq.zzb.equals(zzahVar2.zzb)) {
                zzaV().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzq.zzb);
            }
            if (zzq != null && zzq.zze) {
                zzahVar2.zzb = zzq.zzb;
                zzahVar2.zzd = zzq.zzd;
                zzahVar2.zzh = zzq.zzh;
                zzahVar2.zzf = zzq.zzf;
                zzahVar2.zzi = zzq.zzi;
                zzahVar2.zze = true;
                zzpk zzpkVar = zzahVar2.zzc;
                zzahVar2.zzc = new zzpk(zzpkVar.zzb, zzq.zzc.zzc, zzpkVar.zza(), zzq.zzc.zzf);
            } else if (TextUtils.isEmpty(zzahVar2.zzf)) {
                zzpk zzpkVar2 = zzahVar2.zzc;
                zzahVar2.zzc = new zzpk(zzpkVar2.zzb, zzahVar2.zzd, zzpkVar2.zza(), zzahVar2.zzc.zzf);
                zzahVar2.zze = true;
                z10 = true;
            }
            if (zzahVar2.zze) {
                zzpk zzpkVar3 = zzahVar2.zzc;
                zzpm zzpmVar = new zzpm((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzpkVar3.zzb, zzpkVar3.zzc, Preconditions.checkNotNull(zzpkVar3.zza()));
                if (zzj().zzl(zzpmVar)) {
                    zzaV().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                } else {
                    zzaV().zzb().zzd("(2)Too many active user properties, ignoring", zzgt.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpmVar.zzc), zzpmVar.zze);
                }
                if (z10 && zzahVar2.zzi != null) {
                    zzH(new zzbg(zzahVar2.zzi, zzahVar2.zzd), zzrVar);
                }
            }
            if (zzj().zzp(zzahVar2)) {
                zzaV().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
            } else {
                zzaV().zzb().zzd("Too many conditional properties, ignoring", zzgt.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
            }
            zzj().zzc();
            zzj().zzd();
        } catch (Throwable th) {
            zzj().zzd();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzak(zzah zzahVar) {
        zzr zzaN = zzaN((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzaN != null) {
            zzal(zzahVar, zzaN);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzal(zzah zzahVar, zzr zzrVar) {
        Bundle bundle;
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (!zzaQ(zzrVar)) {
            return;
        }
        if (!zzrVar.zzh) {
            zzan(zzrVar);
            return;
        }
        zzj().zzb();
        try {
            zzan(zzrVar);
            String str = (String) Preconditions.checkNotNull(zzahVar.zza);
            zzah zzq = zzj().zzq(str, zzahVar.zzc.zzb);
            if (zzq != null) {
                zzaV().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                zzj().zzr(str, zzahVar.zzc.zzb);
                if (zzq.zze) {
                    zzj().zzk(str, zzahVar.zzc.zzb);
                }
                zzbg zzbgVar = zzahVar.zzk;
                if (zzbgVar != null) {
                    zzbe zzbeVar = zzbgVar.zzb;
                    if (zzbeVar != null) {
                        bundle = zzbeVar.zzf();
                    } else {
                        bundle = null;
                    }
                    zzH((zzbg) Preconditions.checkNotNull(zzt().zzac(str, ((zzbg) Preconditions.checkNotNull(zzbgVar)).zza, bundle, zzq.zzb, zzbgVar.zzd, true, true)), zzrVar);
                }
            } else {
                zzaV().zze().zzc("Conditional user property doesn't exist", zzgt.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
            }
            zzj().zzc();
            zzj().zzd();
        } catch (Throwable th) {
            zzj().zzd();
            throw th;
        }
    }

    final void zzam(zzr zzrVar, long j10) {
        boolean z10;
        zzh zzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzu != null && zzt().zzB(zzrVar.zzb, zzu.zzf())) {
            zzaV().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgt.zzl(zzu.zzc()));
            zzav zzj = zzj();
            String zzc = zzu.zzc();
            zzj.zzay();
            zzj.zzg();
            Preconditions.checkNotEmpty(zzc);
            try {
                SQLiteDatabase zze = zzj.zze();
                String[] strArr = {zzc};
                int delete = zze.delete("events", "app_id=?", strArr) + zze.delete("user_attributes", "app_id=?", strArr) + zze.delete("conditional_properties", "app_id=?", strArr) + zze.delete("apps", "app_id=?", strArr) + zze.delete("raw_events", "app_id=?", strArr) + zze.delete("raw_events_metadata", "app_id=?", strArr) + zze.delete("event_filters", "app_id=?", strArr) + zze.delete("property_filters", "app_id=?", strArr) + zze.delete("audience_filter_values", "app_id=?", strArr) + zze.delete("consent_settings", "app_id=?", strArr) + zze.delete("default_event_params", "app_id=?", strArr) + zze.delete("trigger_uris", "app_id=?", strArr);
                com.google.android.gms.internal.measurement.zzpk.zza();
                zzib zzibVar = zzj.zzu;
                if (zzibVar.zzc().zzp(null, zzfx.zzbi)) {
                    delete += zze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (delete > 0) {
                    zzibVar.zzaV().zzk().zzc("Deleted application data. app, records", zzc, Integer.valueOf(delete));
                }
            } catch (SQLiteException e10) {
                zzj.zzu.zzaV().zzb().zzc("Error deleting application data. appId, error", zzgt.zzl(zzc), e10);
            }
            zzu = null;
        }
        if (zzu != null) {
            boolean z11 = true;
            if (zzu.zzt() != -2147483648L && zzu.zzt() != zzrVar.zzj) {
                z10 = true;
            } else {
                z10 = false;
            }
            String zzr = zzu.zzr();
            if (zzu.zzt() != -2147483648L || zzr == null || zzr.equals(zzrVar.zzc)) {
                z11 = false;
            }
            if (z11 | z10) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", zzr);
                zzbg zzbgVar = new zzbg("_au", new zzbe(bundle), "auto", j10);
                if (zzd().zzp(null, zzfx.zzbd)) {
                    zzE(zzbgVar, zzrVar);
                } else {
                    zzF(zzbgVar, zzrVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01df, code lost:
    
        if (r11 != false) goto L٧٧;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzh zzan(zzr zzrVar) {
        String str;
        boolean z10;
        String str2;
        long j10;
        String str3;
        String str4;
        String str5;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str6 = zzrVar.zza;
        Preconditions.checkNotEmpty(str6);
        String str7 = zzrVar.zzt;
        byte[] bArr = null;
        if (!str7.isEmpty()) {
            this.zzE.put(str6, new zzpc(this, str7, bArr));
        }
        zzh zzu = zzj().zzu(str6);
        zzjk zzs = zzB(str6).zzs(zzjk.zzf(zzrVar.zzs, 100));
        zzjj zzjjVar = zzjj.AD_STORAGE;
        if (zzs.zzo(zzjjVar)) {
            str = this.zzk.zzf(str6, zzrVar.zzn);
        } else {
            str = "";
        }
        boolean z11 = true;
        if (zzu == null) {
            zzh zzhVar = new zzh(this.zzn, str6);
            if (zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
                zzhVar.zze(zzK(zzs));
            }
            if (zzs.zzo(zzjjVar)) {
                zzhVar.zzk(str);
            }
            zzu = zzhVar;
        } else if (zzs.zzo(zzjjVar) && str != null && !str.equals(zzu.zzj())) {
            boolean isEmpty = TextUtils.isEmpty(zzu.zzj());
            zzu.zzk(str);
            if (zzrVar.zzn && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(str6, zzs).first) && !isEmpty) {
                if (zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
                    zzu.zze(zzK(zzs));
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (zzj().zzm(str6, TransferTable.COLUMN_ID) != null && zzj().zzm(str6, "_lair") == null) {
                    zzj().zzl(new zzpm(str6, "auto", "_lair", zzaZ().currentTimeMillis(), 1L));
                }
                zzu.zzg(zzrVar.zzb);
                str2 = zzrVar.zzk;
                if (!TextUtils.isEmpty(str2)) {
                    zzu.zzm(str2);
                }
                j10 = zzrVar.zze;
                if (j10 != 0) {
                    zzu.zzy(j10);
                }
                str3 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str3)) {
                    zzu.zzs(str3);
                }
                zzu.zzu(zzrVar.zzj);
                str4 = zzrVar.zzd;
                if (str4 != null) {
                    zzu.zzw(str4);
                }
                zzu.zzA(zzrVar.zzf);
                zzu.zzE(zzrVar.zzh);
                str5 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str5)) {
                    zzu.zzab(str5);
                }
                zzu.zzad(zzrVar.zzn);
                zzu.zzaf(zzrVar.zzp);
                zzu.zzC(zzrVar.zzq);
                zzu.zzi(zzrVar.zzu);
                com.google.android.gms.internal.measurement.zzpn.zza();
                if (!zzd().zzp(null, zzfx.zzaL)) {
                    zzu.zzah(zzrVar.zzr);
                } else {
                    com.google.android.gms.internal.measurement.zzpn.zza();
                    if (zzd().zzp(null, zzfx.zzaK)) {
                        zzu.zzah(null);
                    }
                }
                zzu.zzaj(zzrVar.zzv);
                zzu.zzaz(zzrVar.zzB);
                zzql.zza();
                if (zzd().zzp(null, zzfx.zzaP)) {
                    zzu.zzap(zzrVar.zzz);
                }
                zzu.zzal(zzrVar.zzw);
                zzu.zzaG(zzrVar.zzC);
                zzu.zzaK(zzrVar.zzE);
                if (!zzu.zza()) {
                    z11 = z10;
                }
                zzj().zzv(zzu, z11, false);
                return zzu;
            }
            if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
                zzu.zze(zzK(zzs));
            }
        } else if (TextUtils.isEmpty(zzu.zzd()) && zzs.zzo(zzjj.ANALYTICS_STORAGE)) {
            zzu.zze(zzK(zzs));
        }
        z10 = false;
        zzu.zzg(zzrVar.zzb);
        str2 = zzrVar.zzk;
        if (!TextUtils.isEmpty(str2)) {
        }
        j10 = zzrVar.zze;
        if (j10 != 0) {
        }
        str3 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str3)) {
        }
        zzu.zzu(zzrVar.zzj);
        str4 = zzrVar.zzd;
        if (str4 != null) {
        }
        zzu.zzA(zzrVar.zzf);
        zzu.zzE(zzrVar.zzh);
        str5 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str5)) {
        }
        zzu.zzad(zzrVar.zzn);
        zzu.zzaf(zzrVar.zzp);
        zzu.zzC(zzrVar.zzq);
        zzu.zzi(zzrVar.zzu);
        com.google.android.gms.internal.measurement.zzpn.zza();
        if (!zzd().zzp(null, zzfx.zzaL)) {
        }
        zzu.zzaj(zzrVar.zzv);
        zzu.zzaz(zzrVar.zzB);
        zzql.zza();
        if (zzd().zzp(null, zzfx.zzaP)) {
        }
        zzu.zzal(zzrVar.zzw);
        zzu.zzaG(zzrVar.zzC);
        zzu.zzaK(zzrVar.zzE);
        if (!zzu.zza()) {
        }
        zzj().zzv(zzu, z11, false);
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzao(zzr zzrVar) {
        try {
            return (String) zzaW().zzh(new zzoy(this, zzrVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            zzaV().zzb().zzc("Failed to get app instance id. appId", zzgt.zzl(zzrVar.zza), e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzap(zzr zzrVar, Bundle bundle) {
        zzaW().zzg();
        zzql.zza();
        zzal zzd = zzd();
        String str = zzrVar.zza;
        if (zzd.zzp(str, zzfx.zzaP) && str != null) {
            if (bundle != null) {
                int[] intArray = bundle.getIntArray("uriSources");
                long[] longArray = bundle.getLongArray("uriTimestamps");
                if (intArray != null) {
                    if (longArray != null && longArray.length == intArray.length) {
                        for (int i10 = 0; i10 < intArray.length; i10++) {
                            zzav zzj = zzj();
                            int i11 = intArray[i10];
                            long j10 = longArray[i10];
                            Preconditions.checkNotEmpty(str);
                            zzj.zzg();
                            zzj.zzay();
                            try {
                                int delete = zzj.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i11), String.valueOf(j10)});
                                zzgr zzk = zzj.zzu.zzaV().zzk();
                                StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 46);
                                sb.append("Pruned ");
                                sb.append(delete);
                                sb.append(" trigger URIs. appId, source, timestamp");
                                zzk.zzd(sb.toString(), str, Integer.valueOf(i11), Long.valueOf(j10));
                            } catch (SQLiteException e10) {
                                zzj.zzu.zzaV().zzb().zzc("Error pruning trigger URIs. appId", zzgt.zzl(str), e10);
                            }
                        }
                    } else {
                        zzaV().zzb().zza("Uri sources and timestamps do not match");
                    }
                }
            }
            zzav zzj2 = zzj();
            String str2 = zzrVar.zza;
            Preconditions.checkNotEmpty(str2);
            zzj2.zzg();
            zzj2.zzay();
            List arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                try {
                    cursor = zzj2.zze().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                    if (cursor.moveToFirst()) {
                        do {
                            String string = cursor.getString(0);
                            if (string == null) {
                                string = "";
                            }
                            arrayList.add(new zzog(string, cursor.getLong(1), cursor.getInt(2)));
                        } while (cursor.moveToNext());
                    }
                } catch (SQLiteException e11) {
                    zzj2.zzu.zzaV().zzb().zzc("Error querying trigger uris. appId", zzgt.zzl(str2), e11);
                    arrayList = Collections.emptyList();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaq(String str, zzaf zzafVar) {
        zzaW().zzg();
        zzu();
        zzav zzj = zzj();
        long j10 = zzafVar.zza;
        zzpi zzB = zzj.zzB(j10);
        if (zzB == null) {
            zzaV().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j10));
            return;
        }
        String zze = zzB.zze();
        if (zzafVar.zzb == zzlq.SUCCESS.zza()) {
            Map map = this.zzF;
            if (map.containsKey(zze)) {
                map.remove(zze);
            }
            zzav zzj2 = zzj();
            Long valueOf = Long.valueOf(j10);
            zzj2.zzE(valueOf);
            zzaV().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
            long j11 = zzafVar.zzc;
            if (j11 > 0) {
                zzav zzj3 = zzj();
                zzj3.zzg();
                zzj3.zzay();
                Long valueOf2 = Long.valueOf(j11);
                Preconditions.checkNotNull(valueOf2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_type", Integer.valueOf(zzlr.GOOGLE_SIGNAL.zza()));
                zzib zzibVar = zzj3.zzu;
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzibVar.zzaZ().currentTimeMillis()));
                try {
                    if (zzj3.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j11), str, String.valueOf(zzlr.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                        zzibVar.zzaV().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                    }
                    zzaV().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                    zzP(str);
                    return;
                } catch (SQLiteException e10) {
                    zzj3.zzu.zzaV().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j11), e10);
                    throw e10;
                }
            }
            return;
        }
        if (zzafVar.zzb == zzlq.BACKOFF.zza()) {
            Map map2 = this.zzF;
            zzpd zzpdVar = (zzpd) map2.get(zze);
            if (zzpdVar == null) {
                zzpdVar = new zzpd(this);
                map2.put(zze, zzpdVar);
            } else {
                zzpdVar.zza();
            }
            zzaV().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zze, Long.valueOf((zzpdVar.zzc() - zzaZ().currentTimeMillis()) / 1000));
        }
        zzav zzj4 = zzj();
        Long valueOf3 = Long.valueOf(zzafVar.zza);
        zzj4.zzK(valueOf3);
        zzaV().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzar(boolean z10) {
        zzaK();
    }

    public final void zzas(String str, zzlt zzltVar) {
        zzaW().zzg();
        String str2 = this.zzH;
        if (str2 != null && !str2.equals(str) && zzltVar == null) {
            return;
        }
        this.zzH = str;
        this.zzG = zzltVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzat(zzpg zzpgVar) {
        zzaW().zzg();
        this.zzm = new zzhj(this);
        zzav zzavVar = new zzav(this);
        zzavVar.zzaz();
        this.zze = zzavVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznm zznmVar = new zznm(this);
        zznmVar.zzaz();
        this.zzk = zznmVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzaz();
        this.zzh = zzadVar;
        zzlo zzloVar = new zzlo(this);
        zzloVar.zzaz();
        this.zzj = zzloVar;
        zzoj zzojVar = new zzoj(this);
        zzojVar.zzaz();
        this.zzg = zzojVar;
        this.zzf = new zzha(this);
        if (this.zzs != this.zzt) {
            zzaV().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaV().zzk().zza("UploadController is now fully initialized");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzib zzaw() {
        return this.zzn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Deque zzax() {
        return this.zzr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzay(long j10) {
        this.zzJ = j10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc() {
        zzaW().zzg();
        zzj().zzI();
        zzav zzj = zzj();
        zzj.zzg();
        zzj.zzay();
        if (zzj.zzai()) {
            zzfw zzfwVar = zzfx.zzav;
            if (((Long) zzfwVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase zze = zzj.zze();
                zzib zzibVar = zzj.zzu;
                int delete = zze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzibVar.zzaZ().currentTimeMillis()), String.valueOf(zzfwVar.zzb(null))});
                if (delete > 0) {
                    zzibVar.zzaV().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
        }
        zzaK();
    }

    public final zzal zzd() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzot zzf() {
        return this.zzl;
    }

    public final zzhs zzh() {
        zzhs zzhsVar = this.zzc;
        zzaS(zzhsVar);
        return zzhsVar;
    }

    public final zzgy zzi() {
        zzgy zzgyVar = this.zzd;
        zzaS(zzgyVar);
        return zzgyVar;
    }

    public final zzav zzj() {
        zzav zzavVar = this.zze;
        zzaS(zzavVar);
        return zzavVar;
    }

    public final zzha zzk() {
        zzha zzhaVar = this.zzf;
        if (zzhaVar != null) {
            return zzhaVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzoj zzl() {
        zzoj zzojVar = this.zzg;
        zzaS(zzojVar);
        return zzojVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaS(zzadVar);
        return zzadVar;
    }

    public final zzlo zzn() {
        zzlo zzloVar = this.zzj;
        zzaS(zzloVar);
        return zzloVar;
    }

    public final zzpj zzp() {
        zzpj zzpjVar = this.zzi;
        zzaS(zzpjVar);
        return zzpjVar;
    }

    public final zznm zzq() {
        return this.zzk;
    }

    public final zzgm zzs() {
        return this.zzn.zzl();
    }

    public final zzpo zzt() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu() {
        if (this.zzo.get()) {
        } else {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzv(zzr zzrVar) {
        zzaW().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjk zzf = zzjk.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaV().zzk().zzc("Setting storage consent for package", str, zzf);
        zzA(str, zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw(zzr zzrVar) {
        boolean z10;
        zzaW().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzaz zzg = zzaz.zzg(zzrVar.zzy);
        zzaV().zzk().zzc("Setting DMA consent for package", str, zzg);
        zzaW().zzg();
        zzu();
        zzjh zzc = zzaz.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzg);
        zzj().zzad(str, zzg);
        zzjh zzc2 = zzaz.zzh(zzy(str), 100).zzc();
        zzaW().zzg();
        zzu();
        zzjh zzjhVar = zzjh.DENIED;
        boolean z11 = true;
        if (zzc == zzjhVar && zzc2 == zzjh.GRANTED) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (zzc != zzjh.GRANTED || zzc2 != zzjhVar) {
            z11 = false;
        }
        if (!z10 && !z11) {
            return;
        }
        zzaV().zzk().zzb("Generated _dcu event for", str);
        Bundle bundle = new Bundle();
        if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfx.zzam)) {
            bundle.putLong("_r", 1L);
            zzaV().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
        }
        this.zzK.zza(str, "_dcu", bundle);
    }

    final zzaz zzx(String str) {
        zzaW().zzg();
        zzu();
        Map map = this.zzD;
        zzaz zzazVar = (zzaz) map.get(str);
        if (zzazVar == null) {
            zzaz zzac = zzj().zzac(str);
            map.put(str, zzac);
            return zzac;
        }
        return zzazVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Bundle zzy(String str) {
        int i10;
        String str2;
        zzaW().zzg();
        zzu();
        if (zzh().zzx(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjk zzB = zzB(str);
        bundle.putAll(zzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzB, new zzan()).zzf());
        zzpm zzm = zzj().zzm(str, "_npa");
        if (zzm != null) {
            i10 = zzm.zze.equals(1L);
        } else {
            i10 = zzaB(str, new zzan());
        }
        if (1 != i10) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    @VisibleForTesting
    final zzaz zzz(String str, zzaz zzazVar, zzjk zzjkVar, zzan zzanVar) {
        zzjh zzjhVar;
        boolean z10;
        int i10 = 90;
        if (zzh().zzx(str) == null) {
            if (zzazVar.zzc() == zzjh.DENIED) {
                i10 = zzazVar.zzb();
                zzanVar.zzb(zzjj.AD_USER_DATA, i10);
            } else {
                zzanVar.zzc(zzjj.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzaz(Boolean.FALSE, i10, Boolean.TRUE, "-");
        }
        zzjh zzc = zzazVar.zzc();
        zzjh zzjhVar2 = zzjh.GRANTED;
        if (zzc != zzjhVar2 && zzc != (zzjhVar = zzjh.DENIED)) {
            if (zzc == zzjh.POLICY) {
                zzhs zzhsVar = this.zzc;
                zzjj zzjjVar = zzjj.AD_USER_DATA;
                zzjh zzA = zzhsVar.zzA(str, zzjjVar);
                if (zzA != zzjh.UNINITIALIZED) {
                    zzanVar.zzc(zzjjVar, zzam.REMOTE_ENFORCED_DEFAULT);
                    zzc = zzA;
                }
            }
            zzhs zzhsVar2 = this.zzc;
            zzjj zzjjVar2 = zzjj.AD_USER_DATA;
            zzjj zzw = zzhsVar2.zzw(str, zzjjVar2);
            zzjh zzp = zzjkVar.zzp();
            if (zzp == zzjhVar2 || zzp == zzjhVar) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (zzw == zzjj.AD_STORAGE && z10) {
                zzanVar.zzc(zzjjVar2, zzam.REMOTE_DELEGATION);
                zzc = zzp;
            } else {
                zzanVar.zzc(zzjjVar2, zzam.REMOTE_DEFAULT);
                if (true != zzhsVar2.zzv(str, zzjjVar2)) {
                    zzc = zzjhVar;
                } else {
                    zzc = zzjhVar2;
                }
            }
        } else {
            i10 = zzazVar.zzb();
            zzanVar.zzb(zzjj.AD_USER_DATA, i10);
        }
        boolean zzy = this.zzc.zzy(str);
        SortedSet zzz = zzh().zzz(str);
        if (zzc != zzjh.DENIED && !zzz.isEmpty()) {
            Boolean bool = Boolean.TRUE;
            Boolean valueOf = Boolean.valueOf(zzy);
            String str2 = "";
            if (zzy) {
                str2 = TextUtils.join("", zzz);
            }
            return new zzaz(bool, i10, valueOf, str2);
        }
        return new zzaz(Boolean.FALSE, i10, Boolean.valueOf(zzy), "-");
    }
}
