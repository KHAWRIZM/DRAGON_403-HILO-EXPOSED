package d2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j extends p {
    public j(c2.e eVar) {
        super(eVar);
        eVar.f٥٧٠٩e.f();
        eVar.f٥٧١١f.f();
        this.f١٣٦٢٦f = ((c2.h) eVar).w1();
    }

    private void q(f fVar) {
        this.f١٣٦٢٨h.f١٣٥٧٨k.add(fVar);
        fVar.f١٣٥٧٩l.add(this.f١٣٦٢٨h);
    }

    @Override // d2.p, d2.d
    public void a(d dVar) {
        f fVar = this.f١٣٦٢٨h;
        if (!fVar.f١٣٥٧٠c || fVar.f١٣٥٧٧j) {
            return;
        }
        this.f١٣٦٢٨h.d((int) ((((f) fVar.f١٣٥٧٩l.get(0)).f١٣٥٧٤g * ((c2.h) this.f١٣٦٢٢b).z1()) + 0.5f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void d() {
        c2.h hVar = (c2.h) this.f١٣٦٢٢b;
        int x12 = hVar.x1();
        int y12 = hVar.y1();
        hVar.z1();
        if (hVar.w1() == 1) {
            if (x12 != -1) {
                this.f١٣٦٢٨h.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧٠٩e.f١٣٦٢٨h);
                this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧٠٩e.f١٣٦٢٨h.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                this.f١٣٦٢٨h.f١٣٥٧٣f = x12;
            } else if (y12 != -1) {
                this.f١٣٦٢٨h.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧٠٩e.f١٣٦٢٩i);
                this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧٠٩e.f١٣٦٢٩i.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
                this.f١٣٦٢٨h.f١٣٥٧٣f = -y12;
            } else {
                f fVar = this.f١٣٦٢٨h;
                fVar.f١٣٥٦٩b = true;
                fVar.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧٠٩e.f١٣٦٢٩i);
                this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧٠٩e.f١٣٦٢٩i.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
            }
            q(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٨h);
            q(this.f١٣٦٢٢b.f٥٧٠٩e.f١٣٦٢٩i);
            return;
        }
        if (x12 != -1) {
            this.f١٣٦٢٨h.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧١١f.f١٣٦٢٨h);
            this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧١١f.f١٣٦٢٨h.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
            this.f١٣٦٢٨h.f١٣٥٧٣f = x12;
        } else if (y12 != -1) {
            this.f١٣٦٢٨h.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧١١f.f١٣٦٢٩i);
            this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧١١f.f١٣٦٢٩i.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
            this.f١٣٦٢٨h.f١٣٥٧٣f = -y12;
        } else {
            f fVar2 = this.f١٣٦٢٨h;
            fVar2.f١٣٥٦٩b = true;
            fVar2.f١٣٥٧٩l.add(this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧١١f.f١٣٦٢٩i);
            this.f١٣٦٢٢b.f٥٧٠٦c0.f٥٧١١f.f١٣٦٢٩i.f١٣٥٧٨k.add(this.f١٣٦٢٨h);
        }
        q(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٨h);
        q(this.f١٣٦٢٢b.f٥٧١١f.f١٣٦٢٩i);
    }

    @Override // d2.p
    public void e() {
        if (((c2.h) this.f١٣٦٢٢b).w1() == 1) {
            this.f١٣٦٢٢b.q1(this.f١٣٦٢٨h.f١٣٥٧٤g);
        } else {
            this.f١٣٦٢٢b.r1(this.f١٣٦٢٨h.f١٣٥٧٤g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public void f() {
        this.f١٣٦٢٨h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d2.p
    public boolean m() {
        return false;
    }
}
