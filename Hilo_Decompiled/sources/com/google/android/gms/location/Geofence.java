package com.google.android.gms.location;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

@VisibleForTesting
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    @VisibleForTesting
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Builder {
        private double zze;
        private double zzf;
        private float zzg;
        private String zza = null;

        @TransitionTypes
        private int zzb = 0;
        private long zzc = Long.MIN_VALUE;
        private short zzd = -1;
        private int zzh = 0;
        private int zzi = -1;

        public Geofence build() {
            String str = this.zza;
            if (str != null) {
                int i10 = this.zzb;
                if (i10 != 0) {
                    if ((i10 & 4) != 0 && this.zzi < 0) {
                        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
                    }
                    long j10 = this.zzc;
                    if (j10 != Long.MIN_VALUE) {
                        if (this.zzd != -1) {
                            int i11 = this.zzh;
                            if (i11 >= 0) {
                                return new com.google.android.gms.internal.location.zzbe(str, i10, (short) 1, this.zze, this.zzf, this.zzg, j10, i11, this.zzi);
                            }
                            throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                        }
                        throw new IllegalArgumentException("Geofence region not set.");
                    }
                    throw new IllegalArgumentException("Expiration not set.");
                }
                throw new IllegalArgumentException("Transitions types not set.");
            }
            throw new IllegalArgumentException("Request ID not set.");
        }

        public Builder setCircularRegion(@FloatRange(from = -90.0d, to = 90.0d) double d10, @FloatRange(from = -180.0d, to = 180.0d) double d11, @FloatRange(from = 0.0d, fromInclusive = false) float f10) {
            boolean z10;
            boolean z11;
            boolean z12 = false;
            if (d10 >= -90.0d && d10 <= 90.0d) {
                z10 = true;
            } else {
                z10 = false;
            }
            StringBuilder sb = new StringBuilder(42);
            sb.append("Invalid latitude: ");
            sb.append(d10);
            Preconditions.checkArgument(z10, sb.toString());
            if (d11 >= -180.0d && d11 <= 180.0d) {
                z11 = true;
            } else {
                z11 = false;
            }
            StringBuilder sb2 = new StringBuilder(43);
            sb2.append("Invalid longitude: ");
            sb2.append(d11);
            Preconditions.checkArgument(z11, sb2.toString());
            if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
                z12 = true;
            }
            StringBuilder sb3 = new StringBuilder(31);
            sb3.append("Invalid radius: ");
            sb3.append(f10);
            Preconditions.checkArgument(z12, sb3.toString());
            this.zzd = (short) 1;
            this.zze = d10;
            this.zzf = d11;
            this.zzg = f10;
            return this;
        }

        public Builder setExpirationDuration(long j10) {
            if (j10 < 0) {
                this.zzc = -1L;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + j10;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i10) {
            this.zzi = i10;
            return this;
        }

        public Builder setNotificationResponsiveness(@IntRange(from = 0) int i10) {
            this.zzh = i10;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zza = (String) Preconditions.checkNotNull(str, "Request ID can't be set to null");
            return this;
        }

        public Builder setTransitionTypes(@TransitionTypes int i10) {
            this.zzb = i10;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public @interface GeofenceTransition {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public @interface TransitionTypes {
    }

    String getRequestId();
}
