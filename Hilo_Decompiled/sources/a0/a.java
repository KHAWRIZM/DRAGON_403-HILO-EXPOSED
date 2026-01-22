package a0;

import java.lang.reflect.Array;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean[] f٤٠a = new boolean[256];

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f٤١b = new byte[256];

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f٤٢c = new byte[18002];

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f٤٣d = new byte[18002];

    /* renamed from: e, reason: collision with root package name */
    public final int[] f٤٤e = new int[256];

    /* renamed from: f, reason: collision with root package name */
    public final int[][] f٤٥f;

    /* renamed from: g, reason: collision with root package name */
    public final int[][] f٤٦g;

    /* renamed from: h, reason: collision with root package name */
    public final int[][] f٤٧h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f٤٨i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f٤٩j;

    /* renamed from: k, reason: collision with root package name */
    public final char[] f٥٠k;

    /* renamed from: l, reason: collision with root package name */
    public final char[][] f٥١l;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f٥٢m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f٥٣n;

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f٥٤o;

    public a(int i10) {
        Class cls = Integer.TYPE;
        this.f٤٥f = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
        this.f٤٦g = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
        this.f٤٧h = (int[][]) Array.newInstance((Class<?>) cls, 6, 258);
        this.f٤٨i = new int[6];
        this.f٤٩j = new int[257];
        this.f٥٠k = new char[256];
        this.f٥١l = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 6, 258);
        this.f٥٢m = new byte[6];
        this.f٥٤o = new byte[i10 * 100000];
    }
}
