package llc.aerMist.app.shared.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lllc/aerMist/app/shared/util/ShakeDetector;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accelerometer", "Landroid/hardware/Sensor;", "kotlin.jvm.PlatformType", "listeners", "Ljava/util/ArrayList;", "Lllc/aerMist/app/shared/util/OnShakeListener;", "mShakeCount", "", "mShakeTimestamp", "", "sensorEventListener", "Landroid/hardware/SensorEventListener;", "sensorManager", "Landroid/hardware/SensorManager;", "attachOnShakeListener", "", "listener", "detachOnShakeListener", "Companion", "app_localApiDebug"})
public final class ShakeDetector {
    private java.util.ArrayList<llc.aerMist.app.shared.util.OnShakeListener> listeners;
    private long mShakeTimestamp = 0L;
    private int mShakeCount = 0;
    private final android.hardware.SensorManager sensorManager = null;
    private final android.hardware.Sensor accelerometer = null;
    private final android.hardware.SensorEventListener sensorEventListener = null;
    private static final float SHAKE_THRESHOLD_GRAVITY = 2.7F;
    private static final int SHAKE_SLOP_TIME_MS = 500;
    private static final int SHAKE_COUNT_RESET_TIME_MS = 3000;
    @org.jetbrains.annotations.NotNull()
    public static final llc.aerMist.app.shared.util.ShakeDetector.Companion Companion = null;
    
    public final void attachOnShakeListener(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.shared.util.OnShakeListener listener) {
    }
    
    public final void detachOnShakeListener(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.shared.util.OnShakeListener listener) {
    }
    
    public ShakeDetector(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lllc/aerMist/app/shared/util/ShakeDetector$Companion;", "", "()V", "SHAKE_COUNT_RESET_TIME_MS", "", "SHAKE_SLOP_TIME_MS", "SHAKE_THRESHOLD_GRAVITY", "", "app_localApiDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}