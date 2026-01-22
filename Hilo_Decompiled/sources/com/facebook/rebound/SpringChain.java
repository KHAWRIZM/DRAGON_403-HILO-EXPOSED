package com.facebook.rebound;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SpringChain implements SpringListener {
    private static final int DEFAULT_ATTACHMENT_FRICTION = 10;
    private static final int DEFAULT_ATTACHMENT_TENSION = 70;
    private static final int DEFAULT_MAIN_FRICTION = 6;
    private static final int DEFAULT_MAIN_TENSION = 40;
    private final SpringConfig mAttachmentSpringConfig;
    private int mControlSpringIndex;
    private final CopyOnWriteArrayList<SpringListener> mListeners;
    private final SpringConfig mMainSpringConfig;
    private final SpringSystem mSpringSystem;
    private final CopyOnWriteArrayList<Spring> mSprings;
    private static final SpringConfigRegistry registry = SpringConfigRegistry.getInstance();
    private static int id = 0;

    private SpringChain() {
        this(40, 6, 70, 10);
    }

    public static SpringChain create() {
        return new SpringChain();
    }

    public SpringChain addSpring(SpringListener springListener) {
        this.mSprings.add(this.mSpringSystem.createSpring().addListener(this).setSpringConfig(this.mAttachmentSpringConfig));
        this.mListeners.add(springListener);
        return this;
    }

    public List<Spring> getAllSprings() {
        return this.mSprings;
    }

    public SpringConfig getAttachmentSpringConfig() {
        return this.mAttachmentSpringConfig;
    }

    public Spring getControlSpring() {
        return this.mSprings.get(this.mControlSpringIndex);
    }

    public SpringConfig getMainSpringConfig() {
        return this.mMainSpringConfig;
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringActivate(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringActivate(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringAtRest(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringAtRest(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringEndStateChange(Spring spring) {
        this.mListeners.get(this.mSprings.indexOf(spring)).onSpringEndStateChange(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringUpdate(Spring spring) {
        int i10;
        int i11;
        int indexOf = this.mSprings.indexOf(spring);
        SpringListener springListener = this.mListeners.get(indexOf);
        int i12 = this.mControlSpringIndex;
        if (indexOf == i12) {
            i11 = indexOf - 1;
            i10 = indexOf + 1;
        } else if (indexOf < i12) {
            i11 = indexOf - 1;
            i10 = -1;
        } else {
            if (indexOf > i12) {
                i10 = indexOf + 1;
            } else {
                i10 = -1;
            }
            i11 = -1;
        }
        if (i10 > -1 && i10 < this.mSprings.size()) {
            this.mSprings.get(i10).setEndValue(spring.getCurrentValue());
        }
        if (i11 > -1 && i11 < this.mSprings.size()) {
            this.mSprings.get(i11).setEndValue(spring.getCurrentValue());
        }
        springListener.onSpringUpdate(spring);
    }

    public SpringChain setControlSpringIndex(int i10) {
        this.mControlSpringIndex = i10;
        if (this.mSprings.get(i10) == null) {
            return null;
        }
        Iterator<Spring> it = this.mSpringSystem.getAllSprings().iterator();
        while (it.hasNext()) {
            it.next().setSpringConfig(this.mAttachmentSpringConfig);
        }
        getControlSpring().setSpringConfig(this.mMainSpringConfig);
        return this;
    }

    private SpringChain(int i10, int i11, int i12, int i13) {
        this.mSpringSystem = SpringSystem.create();
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mSprings = new CopyOnWriteArrayList<>();
        this.mControlSpringIndex = -1;
        SpringConfig fromOrigamiTensionAndFriction = SpringConfig.fromOrigamiTensionAndFriction(i10, i11);
        this.mMainSpringConfig = fromOrigamiTensionAndFriction;
        SpringConfig fromOrigamiTensionAndFriction2 = SpringConfig.fromOrigamiTensionAndFriction(i12, i13);
        this.mAttachmentSpringConfig = fromOrigamiTensionAndFriction2;
        SpringConfigRegistry springConfigRegistry = registry;
        StringBuilder sb = new StringBuilder();
        sb.append("main spring ");
        int i14 = id;
        id = i14 + 1;
        sb.append(i14);
        springConfigRegistry.addSpringConfig(fromOrigamiTensionAndFriction, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attachment spring ");
        int i15 = id;
        id = i15 + 1;
        sb2.append(i15);
        springConfigRegistry.addSpringConfig(fromOrigamiTensionAndFriction2, sb2.toString());
    }

    public static SpringChain create(int i10, int i11, int i12, int i13) {
        return new SpringChain(i10, i11, i12, i13);
    }
}
