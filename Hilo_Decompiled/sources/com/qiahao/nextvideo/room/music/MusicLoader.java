package com.qiahao.nextvideo.room.music;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.nextvideo.HiloApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import u4.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class MusicLoader {
    private static MusicInfo f;
    private final ContentResolver a;
    private String[] b = {"_id", "title", "album", "_display_name", "artist", "_size", "_data"};
    private static final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    private static final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    public static CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    public static long g = 0;

    public MusicLoader(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public static MusicInfo m() {
        return f;
    }

    public static void o(MusicInfo musicInfo) {
        f = musicInfo;
    }

    public int a(List list) {
        List<Long> i = i();
        i.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MusicInfo musicInfo = (MusicInfo) it.next();
            if (musicInfo != null) {
                i.add(Long.valueOf(musicInfo.c()));
            }
        }
        e.clear();
        e.addAll(list);
        MusicCache.INSTANCE.saveMusicIdToLocal(i);
        return list.size();
    }

    public void b(MusicInfo musicInfo) {
        List<Long> i = i();
        Iterator<Long> it = i.iterator();
        while (it.hasNext()) {
            if (it.next().longValue() == musicInfo.c()) {
                return;
            }
        }
        i.add(Long.valueOf(musicInfo.c()));
        e.add(musicInfo);
        MusicCache.INSTANCE.saveMusicIdToLocal(i);
    }

    public void c(long j) {
        List<Long> i = i();
        int i2 = 0;
        while (true) {
            if (i2 < i.size()) {
                if (i.get(i2).longValue() == j) {
                    break;
                } else {
                    i2++;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 >= 0) {
            i.remove(i2);
            MusicCache.INSTANCE.saveMusicIdToLocal(i);
        }
        Iterator it = e.iterator();
        while (it.hasNext()) {
            MusicInfo musicInfo = (MusicInfo) it.next();
            if (musicInfo.c() == j) {
                e.remove(musicInfo);
                return;
            }
        }
    }

    public int d(long j) {
        for (int i = 0; i < e.size(); i++) {
            try {
                MusicInfo musicInfo = (MusicInfo) e.get(i);
                if (musicInfo != null && musicInfo.c() == j) {
                    return i;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public MusicInfo e(long j) {
        return f(j, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if (r6 < 0) goto L١٩;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MusicInfo f(long j, boolean z) {
        int i;
        synchronized (e) {
            try {
                int size = e.size();
                int d2 = d(j);
                if (d2 < 0) {
                    d2 = 0;
                }
                if (e.size() > 0) {
                    if (z) {
                        i = ((int) ((Math.random() * 10.0d) * size)) % size;
                        if (i == d2) {
                            i = d2 - 1;
                        }
                        if (i < 0) {
                            i = size - 1;
                        }
                        return (MusicInfo) e.get(i);
                    }
                    i = d2 - 1;
                } else {
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x016e, code lost:
    
        if (r6 != null) goto L٥١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0170, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x017c, code lost:
    
        if (r23 == null) goto L٦٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x017e, code lost:
    
        if (r24 == false) goto L٥٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0180, code lost:
    
        r23.onResult(com.qiahao.nextvideo.room.music.MusicLoader.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0186, code lost:
    
        r23.onResult(com.qiahao.nextvideo.room.music.MusicLoader.e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x018b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0179, code lost:
    
        if (r6 == null) goto L٥٢;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(d dVar, boolean z) {
        int i;
        int i2;
        int i3;
        c.clear();
        e.clear();
        List<Long> i4 = i();
        HashMap hashMap = new HashMap();
        for (Long l : i4) {
            hashMap.put(l, l);
        }
        boolean n = n();
        if (n) {
            this.b = new String[]{"_id", "title", "album", "_display_name", "artist", "_size", "_data", "owner_package_name", "duration"};
        }
        Uri contentUri = MediaStore.Files.getContentUri("external");
        String packageName = HiloApplication.CONTEXT.getPackageName();
        Cursor cursor = null;
        try {
            try {
                cursor = this.a.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, "title_key");
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("_display_name");
                    int columnIndex2 = cursor.getColumnIndex("album");
                    int columnIndex3 = cursor.getColumnIndex("_id");
                    int columnIndex4 = cursor.getColumnIndex("_size");
                    int columnIndex5 = cursor.getColumnIndex("artist");
                    int columnIndex6 = cursor.getColumnIndex("_data");
                    int columnIndex7 = cursor.getColumnIndex("duration");
                    while (true) {
                        String string = cursor.getString(columnIndex);
                        String string2 = cursor.getString(columnIndex2);
                        int i5 = columnIndex;
                        int i6 = columnIndex2;
                        long j = cursor.getLong(columnIndex3);
                        long j2 = cursor.getLong(columnIndex4);
                        int i7 = columnIndex3;
                        String string3 = cursor.getString(columnIndex5);
                        int i8 = columnIndex4;
                        String string4 = cursor.getString(columnIndex6);
                        if (columnIndex7 < 0) {
                            i = columnIndex5;
                            i2 = columnIndex6;
                            i3 = (int) AppUtilitiesKt.getAudioFileVoiceTime(string4);
                        } else {
                            i = columnIndex5;
                            i2 = columnIndex6;
                            i3 = cursor.getInt(columnIndex7);
                        }
                        if (string != null && string.contains(".mp3")) {
                            MusicInfo musicInfo = new MusicInfo(j, string);
                            musicInfo.g(string2);
                            musicInfo.p(j2);
                            musicInfo.i(string3);
                            musicInfo.y(string4);
                            musicInfo.l(i3);
                            if (n) {
                                musicInfo.y(ContentUris.withAppendedId(contentUri, j).toString());
                            }
                            if (hashMap.containsKey(Long.valueOf(j)) || string4.contains("/Hilo/")) {
                                musicInfo.f(1);
                                if (string4.contains("/Hilo/")) {
                                    musicInfo.j(true);
                                    musicInfo.g("");
                                    musicInfo.i("");
                                }
                                if (n) {
                                    musicInfo.y(ContentUris.withAppendedId(contentUri, j).toString());
                                    int columnIndex8 = cursor.getColumnIndex("owner_package_name");
                                    if (columnIndex8 >= 0 && packageName.equals(cursor.getString(columnIndex8))) {
                                        musicInfo.j(true);
                                        musicInfo.g("");
                                        musicInfo.i("");
                                    }
                                }
                                e.add(musicInfo);
                            }
                            c.add(musicInfo);
                            g = j;
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        columnIndex = i5;
                        columnIndex2 = i6;
                        columnIndex3 = i7;
                        columnIndex4 = i8;
                        columnIndex5 = i;
                        columnIndex6 = i2;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public CopyOnWriteArrayList h() {
        return c;
    }

    public List i() {
        return MusicCache.INSTANCE.getMusicIdForLocal();
    }

    public List j() {
        return e;
    }

    public MusicInfo k(long j) {
        return l(j, false);
    }

    public MusicInfo l(long j, boolean z) {
        synchronized (e) {
            try {
                int size = e.size();
                int d2 = d(j);
                int i = 0;
                if (d2 < 0) {
                    d2 = 0;
                }
                if (e.size() > 0) {
                    if (z) {
                        int random = ((int) ((Math.random() * 10.0d) * size)) % size;
                        if (random == d2) {
                            random = d2 + 1;
                        }
                        if (random < size) {
                            i = random;
                        }
                    } else {
                        int i2 = d2 + 1;
                        if (i2 <= size - 1) {
                            i = i2;
                        }
                    }
                    return (MusicInfo) e.get(i);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean n() {
        if (Build.VERSION.SDK_INT >= 29 && !e.a()) {
            return true;
        }
        return false;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class MusicInfo implements Parcelable {
        public static final Parcelable.Creator<MusicInfo> CREATOR = new a();
        private long a;
        private String b;
        private String c;
        private long d;
        private String e;
        private String f;
        private String h;
        private int g = 0;
        private boolean i = false;
        private int j = 0;
        private int k = 0;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MusicInfo createFromParcel(Parcel parcel) {
                MusicInfo musicInfo = new MusicInfo();
                musicInfo.n(parcel.readLong());
                musicInfo.r(parcel.readString());
                musicInfo.g(parcel.readString());
                musicInfo.i(parcel.readString());
                musicInfo.y(parcel.readString());
                musicInfo.p(parcel.readLong());
                musicInfo.f(parcel.readInt());
                musicInfo.v(parcel.readString());
                musicInfo.l(parcel.readInt());
                return musicInfo;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MusicInfo[] newArray(int i) {
                return new MusicInfo[i];
            }
        }

        public MusicInfo() {
        }

        public String a() {
            String str = this.e;
            if (str == null) {
                return "";
            }
            return str;
        }

        public int b() {
            return this.k;
        }

        public long c() {
            return this.a;
        }

        public String d() {
            String str = this.b;
            if (str == null) {
                return "";
            }
            return str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f;
        }

        public void f(int i) {
            this.g = i;
        }

        public void g(String str) {
            this.c = str;
        }

        public void i(String str) {
            this.e = str;
        }

        public void j(boolean z) {
            this.i = z;
        }

        public void l(int i) {
            this.k = i;
        }

        public void n(long j) {
            this.a = j;
        }

        public void p(long j) {
            this.d = j;
        }

        public void r(String str) {
            this.b = str;
        }

        public void v(String str) {
            this.h = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeLong(this.d);
            parcel.writeInt(this.g);
            parcel.writeString(this.h);
            parcel.writeLong(this.k);
        }

        public void y(String str) {
            this.f = str;
        }

        public MusicInfo(long j, String str) {
            this.a = j;
            this.b = str;
        }
    }
}
