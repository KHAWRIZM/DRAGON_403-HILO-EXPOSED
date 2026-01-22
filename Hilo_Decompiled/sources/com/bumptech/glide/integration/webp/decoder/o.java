package com.bumptech.glide.integration.webp.decoder;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class o extends com.bumptech.glide.load.resource.drawable.i implements o4.r {
    public o(m mVar) {
        super(mVar);
    }

    @Override // o4.v
    public Class getResourceClass() {
        return m.class;
    }

    @Override // o4.v
    public int getSize() {
        return ((m) this.drawable).i();
    }

    @Override // com.bumptech.glide.load.resource.drawable.i, o4.r
    public void initialize() {
        ((m) this.drawable).e().prepareToDraw();
    }

    @Override // o4.v
    public void recycle() {
        ((m) this.drawable).stop();
        ((m) this.drawable).l();
    }
}
