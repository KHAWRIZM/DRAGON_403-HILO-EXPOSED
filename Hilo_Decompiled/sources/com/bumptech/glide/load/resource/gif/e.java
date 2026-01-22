package com.bumptech.glide.load.resource.gif;

import o4.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e extends com.bumptech.glide.load.resource.drawable.i implements r {
    public e(c cVar) {
        super(cVar);
    }

    @Override // o4.v
    public Class getResourceClass() {
        return c.class;
    }

    @Override // o4.v
    public int getSize() {
        return ((c) this.drawable).i();
    }

    @Override // com.bumptech.glide.load.resource.drawable.i, o4.r
    public void initialize() {
        ((c) this.drawable).e().prepareToDraw();
    }

    @Override // o4.v
    public void recycle() {
        ((c) this.drawable).stop();
        ((c) this.drawable).k();
    }
}
