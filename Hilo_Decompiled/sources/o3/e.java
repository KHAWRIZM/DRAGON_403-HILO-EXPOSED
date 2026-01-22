package o3;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e extends g {

    /* renamed from: i, reason: collision with root package name */
    private final s3.d f١٦٤٩٤i;

    public e(List list) {
        super(list);
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            s3.d dVar = (s3.d) ((y3.a) list.get(i11)).f١٩١١٧b;
            if (dVar != null) {
                i10 = Math.max(i10, dVar.f());
            }
        }
        this.f١٦٤٩٤i = new s3.d(new float[i10], new int[i10]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // o3.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public s3.d i(y3.a aVar, float f10) {
        this.f١٦٤٩٤i.g((s3.d) aVar.f١٩١١٧b, (s3.d) aVar.f١٩١١٨c, f10);
        return this.f١٦٤٩٤i;
    }
}
