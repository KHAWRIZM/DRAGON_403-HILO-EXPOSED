package androidx.media;

import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    int f٣٨٧١a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f٣٨٧٢b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f٣٨٧٣c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f٣٨٧٤d = -1;

    public int a() {
        return this.f٣٨٧٢b;
    }

    public int b() {
        int i10 = this.f٣٨٧٣c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f٣٨٧٤d;
        if (i10 != -1) {
            return i10;
        }
        return AudioAttributesCompat.a(false, this.f٣٨٧٣c, this.f٣٨٧١a);
    }

    public int d() {
        return this.f٣٨٧١a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f٣٨٧٢b != audioAttributesImplBase.a() || this.f٣٨٧٣c != audioAttributesImplBase.b() || this.f٣٨٧١a != audioAttributesImplBase.d() || this.f٣٨٧٤d != audioAttributesImplBase.f٣٨٧٤d) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f٣٨٧٢b), Integer.valueOf(this.f٣٨٧٣c), Integer.valueOf(this.f٣٨٧١a), Integer.valueOf(this.f٣٨٧٤d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f٣٨٧٤d != -1) {
            sb.append(" stream=");
            sb.append(this.f٣٨٧٤d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.f٣٨٧١a));
        sb.append(" content=");
        sb.append(this.f٣٨٧٢b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f٣٨٧٣c).toUpperCase());
        return sb.toString();
    }
}
