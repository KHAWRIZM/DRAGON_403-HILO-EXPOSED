package com.alibaba.sdk.android.emas;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.tbrest.utils.AppUtils;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import com.alibaba.sdk.android.tbrest.utils.MD5Utils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e implements Cache<f> {

    /* renamed from: a, reason: collision with root package name */
    private long f٦٤٠٦a;

    /* renamed from: a, reason: collision with other field name */
    private final String f١١a;

    /* renamed from: a, reason: collision with other field name */
    private Set<String> f١٢a;

    /* renamed from: b, reason: collision with root package name */
    private final String f٦٤٠٧b;
    private int diskCacheLimitCapacity;
    private int diskCacheLimitCount;

    public e(Context context, String str, String str2, String str3) {
        this.f٦٤٠٧b = str2;
        String str4 = str + "_" + str2;
        str3 = TextUtils.isEmpty(str3) ? "common" : str3;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir());
        String str5 = File.separator;
        sb.append(str5);
        sb.append("emas-rest-log");
        sb.append(str5);
        sb.append(str4);
        sb.append(str5);
        sb.append(str3);
        String sb2 = sb.toString();
        this.f١١a = sb2;
        File file = new File(sb2);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void a(int i10, int i11, int i12) {
        this.diskCacheLimitCount = i10;
        this.diskCacheLimitCapacity = i11;
        this.f٦٤٠٦a = i12 * 86400000;
    }

    public synchronized void b(f fVar) {
        Set<String> set = this.f١٢a;
        if (set != null && !set.isEmpty()) {
            if (TextUtils.isEmpty(fVar.getLocation())) {
                return;
            }
            this.f١٢a.remove(fVar.getLocation());
        }
    }

    @Override // com.alibaba.sdk.android.emas.Cache
    public synchronized void clear() {
        File file = new File(this.f١١a);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        List<File> a10 = a(file, new ArrayList());
        LogUtil.d("DiskCacheManager num: " + a10.size());
        if (a10.size() > 0) {
            Collections.sort(a10, new Comparator<File>() { // from class: com.alibaba.sdk.android.emas.e.2
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(File file2, File file3) {
                    if (file2 == null && file3 == null) {
                        return 0;
                    }
                    if (file2 == null) {
                        return -1;
                    }
                    if (file3 == null) {
                        return 1;
                    }
                    if (file2 == file3) {
                        return 0;
                    }
                    if (file2.lastModified() < file3.lastModified()) {
                        return -1;
                    }
                    if (file2.lastModified() == file3.lastModified()) {
                        return 0;
                    }
                    return 1;
                }
            });
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<File> it = a10.iterator();
            int i10 = 0;
            long j10 = 0;
            int i11 = 0;
            while (it.hasNext()) {
                File next = it.next();
                if (currentTimeMillis - next.lastModified() >= this.f٦٤٠٦a) {
                    it.remove();
                    next.delete();
                } else {
                    i11++;
                    j10 += next.length();
                }
            }
            if (i11 > this.diskCacheLimitCount || j10 > this.diskCacheLimitCapacity) {
                LogUtil.d("DiskCacheManager exceed limit. start clear.");
                int i12 = (int) (this.diskCacheLimitCount * 0.8d);
                int i13 = (int) (this.diskCacheLimitCapacity * 0.8d);
                while (true) {
                    if ((i11 <= i12 && j10 <= i13) || i10 >= a10.size()) {
                        break;
                    }
                    File file2 = a10.get(i10);
                    if (file2.delete()) {
                        i11--;
                        j10 -= file2.length();
                    }
                    i10++;
                }
            }
        }
    }

    @Override // com.alibaba.sdk.android.emas.Cache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void add(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.a() != d.DISK_CACHE) {
                    List<g> list = fVar.m٢٥٣a();
                    if (list != null && !list.isEmpty()) {
                        JSONArray jSONArray = new JSONArray();
                        for (int i10 = 0; i10 != list.size(); i10++) {
                            JSONObject a10 = list.get(i10).a();
                            if (a10 != null) {
                                jSONArray.put(a10);
                            }
                        }
                        String aesEncrypt = h.aesEncrypt(this.f٦٤٠٧b, jSONArray.toString());
                        if (!TextUtils.isEmpty(aesEncrypt)) {
                            LogUtil.d("DiskCacheManager putting into cache.");
                            File file = new File(this.f١١a, MD5Utils.getMd5Hex(aesEncrypt.getBytes(Charset.forName("UTF-8"))) + "_" + System.currentTimeMillis() + ".log");
                            if (file.exists()) {
                                file.delete();
                            }
                            a(file, aesEncrypt);
                            LogUtil.d("DiskCacheManager success put into " + file.getAbsolutePath());
                        } else {
                            LogUtil.d("DiskCacheManager failed put into cache.");
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (fVar == null) {
            LogUtil.d("DiskCacheManager add failed. data is null");
        } else {
            LogUtil.d("DiskCacheManager add failed. cache type: " + fVar.a().name());
        }
    }

    @Override // com.alibaba.sdk.android.emas.Cache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized f get() {
        File file;
        File file2 = new File(this.f١١a);
        if (!file2.exists()) {
            return null;
        }
        if (!file2.isDirectory()) {
            file2.delete();
            return null;
        }
        List<File> a10 = a(file2, new ArrayList());
        if (a10.size() <= 0) {
            return null;
        }
        Collections.sort(a10, new Comparator<File>() { // from class: com.alibaba.sdk.android.emas.e.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(File file3, File file4) {
                if (file3 == null && file4 == null) {
                    return 0;
                }
                if (file3 == null) {
                    return -1;
                }
                if (file4 == null) {
                    return 1;
                }
                if (file3 == file4) {
                    return 0;
                }
                if (file3.lastModified() < file4.lastModified()) {
                    return -1;
                }
                if (file3.lastModified() == file4.lastModified()) {
                    return 0;
                }
                return 1;
            }
        });
        Set<String> set = this.f١٢a;
        if (set == null || set.isEmpty()) {
            file = a10.get(0);
        } else {
            int i10 = 0;
            while (true) {
                if (i10 == a10.size()) {
                    file = null;
                    break;
                }
                if (!this.f١٢a.contains(a10.get(i10).getAbsolutePath())) {
                    file = a10.get(i10);
                    break;
                }
                LogUtil.d("DiskCacheManager disk cache is in the Sending Queue. skip location: " + a10.get(i10).getAbsolutePath());
                i10++;
            }
        }
        if (file == null) {
            return null;
        }
        String aesDecrypt = h.aesDecrypt(this.f٦٤٠٧b, a(file));
        if (TextUtils.isEmpty(aesDecrypt)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(aesDecrypt);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 != jSONArray.length(); i11++) {
                g a11 = g.a(jSONArray.getJSONObject(i11));
                if (a11 != null) {
                    arrayList.add(a11);
                }
            }
            if (this.f١٢a == null) {
                this.f١٢a = new HashSet();
            }
            this.f١٢a.add(file.getAbsolutePath());
            return new f(arrayList, d.DISK_CACHE, file.getAbsolutePath());
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x005a, code lost:
    
        com.alibaba.sdk.android.tbrest.utils.LogUtil.d("DiskCacheManager remove failed. data is null");
     */
    @Override // com.alibaba.sdk.android.emas.Cache
    /* renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean remove(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.a() == d.DISK_CACHE && !TextUtils.isEmpty(fVar.getLocation())) {
                    LogUtil.d("DiskCacheManager removing. cache type: " + fVar.a().name());
                    Set<String> set = this.f١٢a;
                    if (set != null) {
                        set.remove(fVar.getLocation());
                    }
                    File file = new File(fVar.getLocation());
                    if (!file.exists()) {
                        return false;
                    }
                    return file.delete();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LogUtil.d("DiskCacheManager remove failed. cache type: " + fVar.a().name());
        return false;
    }

    private List<File> a(File file, List<File> list) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    a(file2, list);
                } else if (!list.contains(file2)) {
                    list.add(file2);
                }
            }
        }
        return list;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0026: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:24:0x0026 */
    private String a(File file) {
        BufferedInputStream bufferedInputStream;
        Closeable closeable;
        StringBuilder sb = new StringBuilder();
        byte[] bArr = new byte[4096];
        Closeable closeable2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            sb.append(new String(bArr, 0, read));
                        } else {
                            String sb2 = sb.toString();
                            AppUtils.closeQuietly(bufferedInputStream);
                            return sb2;
                        }
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        e.printStackTrace();
                        AppUtils.closeQuietly(bufferedInputStream);
                        return null;
                    } catch (IOException e11) {
                        e = e11;
                        e.printStackTrace();
                        AppUtils.closeQuietly(bufferedInputStream);
                        return null;
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                AppUtils.closeQuietly(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e12) {
            e = e12;
            bufferedInputStream = null;
        } catch (IOException e13) {
            e = e13;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            AppUtils.closeQuietly(closeable2);
            throw th;
        }
    }

    private void a(File file, String str) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e10) {
            e = e10;
        } catch (UnsupportedEncodingException e11) {
            e = e11;
        } catch (IOException e12) {
            e = e12;
        }
        try {
            bufferedOutputStream.write(str.getBytes("utf-8"));
            AppUtils.closeQuietly(bufferedOutputStream);
        } catch (FileNotFoundException e13) {
            e = e13;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            AppUtils.closeQuietly(bufferedOutputStream2);
        } catch (UnsupportedEncodingException e14) {
            e = e14;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            AppUtils.closeQuietly(bufferedOutputStream2);
        } catch (IOException e15) {
            e = e15;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            AppUtils.closeQuietly(bufferedOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            AppUtils.closeQuietly(bufferedOutputStream2);
            throw th;
        }
    }
}
