package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzme;
import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class zzma<MessageType extends zzme<MessageType, BuilderType>, BuilderType extends zzma<MessageType, BuilderType>> extends zzkq<MessageType, BuilderType> {
    protected zzme zza;
    private final zzme zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzma(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzcf()) {
            this.zza = messagetype.zzch();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zznt.zza().zzb(obj.getClass()).zzd(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final /* bridge */ /* synthetic */ zzkq zzaS(byte[] bArr, int i10, int i11) throws zzmq {
        int i12 = zzlq.zzb;
        int i13 = zznt.zza;
        zzbe(bArr, 0, i11, zzlq.zza);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final /* bridge */ /* synthetic */ zzkq zzaT(byte[] bArr, int i10, int i11, zzlq zzlqVar) throws zzmq {
        zzbe(bArr, 0, i11, zzlqVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaX() {
        if (!this.zza.zzcf()) {
            zzaY();
        }
    }

    protected void zzaY() {
        zzme zzch = this.zzb.zzch();
        zza(zzch, this.zza);
        this.zza = zzch;
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    /* renamed from: zzba, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final zzma zzaR() {
        zzma zzmaVar = (zzma) this.zzb.zzl(5, null, null);
        zzmaVar.zza = zzbf();
        return zzmaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    /* renamed from: zzbb, reason: merged with bridge method [inline-methods] */
    public MessageType zzbf() {
        if (!this.zza.zzcf()) {
            return (MessageType) this.zza;
        }
        this.zza.zzcj();
        return (MessageType) this.zza;
    }

    public final MessageType zzbc() {
        MessageType zzbf = zzbf();
        if (zzbf.zzcD()) {
            return zzbf;
        }
        throw new zzog(zzbf);
    }

    public final zzma zzbd(zzme zzmeVar) {
        if (!this.zzb.equals(zzmeVar)) {
            if (!this.zza.zzcf()) {
                zzaY();
            }
            zza(this.zza, zzmeVar);
        }
        return this;
    }

    public final zzma zzbe(byte[] bArr, int i10, int i11, zzlq zzlqVar) throws zzmq {
        if (!this.zza.zzcf()) {
            zzaY();
        }
        try {
            zznt.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i11, new zzkv(zzlqVar));
            return this;
        } catch (zzmq e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final boolean zzcD() {
        return zzme.zzcx(this.zza, false);
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final /* bridge */ /* synthetic */ zznl zzcE() {
        throw null;
    }
}
