package i1;

import java.nio.charset.CharacterCodingException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f١٤٥٩٥a;

    public d(int i10) {
        this.f١٤٥٩٥a = i10;
    }

    public d(int i10, String str) {
        super(str);
        this.f١٤٥٩٥a = i10;
    }

    public d(CharacterCodingException characterCodingException) {
        super(characterCodingException);
        this.f١٤٥٩٥a = 1007;
    }
}
