package f0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class i extends c {
    public i(int i10) {
        super(i10);
    }

    @Override // f0.c
    public void a() {
        if (this.f١٤٠٢٨a) {
            if (!this.f١٤٠٣٢e) {
                if (!this.f١٤٠٣٣f) {
                    if (!this.f١٤٠٣٤g) {
                        return;
                    } else {
                        throw new i1.f("Control frame cant have rsv3==true set");
                    }
                }
                throw new i1.f("Control frame cant have rsv2==true set");
            }
            throw new i1.f("Control frame cant have rsv1==true set");
        }
        throw new i1.f("Control frame cant have fin==false set");
    }
}
