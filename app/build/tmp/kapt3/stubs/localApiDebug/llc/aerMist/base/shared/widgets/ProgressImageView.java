package llc.aerMist.base.shared.widgets;

import java.lang.System;

@kotlin.Suppress(names = {"unused"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00019B%\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nB/\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\tH\u0016J$\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001d\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u001e\u001a\u00020\u0011J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013J\u0012\u0010 \u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010!\u001a\u00020\u00172\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0014J4\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010(\u001a\u0004\u0018\u00010)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010+2\u0006\u0010,\u001a\u00020%H\u0016J>\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010\u00032\b\u0010(\u001a\u0004\u0018\u00010)2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010+2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010,\u001a\u00020%H\u0016J\u0012\u00101\u001a\u00020\u00172\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u00102\u001a\u00020\u00172\b\u00103\u001a\u0004\u0018\u00010\u0003J\u0010\u00102\u001a\u00020\u00172\b\b\u0001\u00104\u001a\u00020\tJ\u000e\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u000fJ\u0010\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020%H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lllc/aerMist/base/shared/widgets/ProgressImageView;", "Landroid/widget/FrameLayout;", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mErrorDrawable", "mImageUrl", "", "mImageView", "Landroid/widget/ImageView;", "mLoadingPlaceholder", "Landroid/view/View;", "mState", "Lllc/aerMist/base/shared/widgets/ProgressImageView$State;", "addView", "", "child", "params", "Landroid/view/ViewGroup$LayoutParams;", "index", "getErrorDrawable", "getImageUrl", "getImageView", "getPlaceholderView", "initImageView", "initProgressImageView", "loadImage", "onAttachedToWindow", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "readAttributeSet", "setErrorDrawable", "drawable", "imageDrawableRes", "setImageUrl", "url", "setLoading", "state", "State", "app_localApiDebug"})
public final class ProgressImageView extends android.widget.FrameLayout implements com.bumptech.glide.request.RequestListener<android.graphics.drawable.Drawable> {
    private android.widget.ImageView mImageView;
    private android.view.View mLoadingPlaceholder;
    private java.lang.String mImageUrl;
    private android.graphics.drawable.Drawable mErrorDrawable;
    private llc.aerMist.base.shared.widgets.ProgressImageView.State mState = llc.aerMist.base.shared.widgets.ProgressImageView.State.CREATED;
    private java.util.HashMap _$_findViewCache;
    
    private final void initProgressImageView(android.util.AttributeSet attrs) {
    }
    
    @java.lang.Override()
    protected void onAttachedToWindow() {
    }
    
    private final void initImageView(android.util.AttributeSet attrs) {
    }
    
    private final void readAttributeSet(android.util.AttributeSet attrs) {
    }
    
    private final void setLoading(boolean state) {
    }
    
    private final void loadImage() {
    }
    
    public final void setImageUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getImageView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.view.View getPlaceholderView() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getErrorDrawable() {
        return null;
    }
    
    public final void setErrorDrawable(@androidx.annotation.DrawableRes()
    int imageDrawableRes) {
    }
    
    @kotlin.Suppress(names = {"MemberVisibilityCanBePrivate"})
    public final void setErrorDrawable(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable drawable) {
    }
    
    @java.lang.Override()
    public void addView(@org.jetbrains.annotations.Nullable()
    android.view.View child) {
    }
    
    @java.lang.Override()
    public void addView(@org.jetbrains.annotations.Nullable()
    android.view.View child, int index) {
    }
    
    @java.lang.Override()
    public void addView(@org.jetbrains.annotations.Nullable()
    android.view.View child, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup.LayoutParams params) {
    }
    
    @java.lang.Override()
    public void addView(@org.jetbrains.annotations.Nullable()
    android.view.View child, int index, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup.LayoutParams params) {
    }
    
    @java.lang.Override()
    public boolean onLoadFailed(@org.jetbrains.annotations.Nullable()
    com.bumptech.glide.load.engine.GlideException e, @org.jetbrains.annotations.Nullable()
    java.lang.Object model, @org.jetbrains.annotations.Nullable()
    com.bumptech.glide.request.target.Target<android.graphics.drawable.Drawable> target, boolean isFirstResource) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onResourceReady(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable resource, @org.jetbrains.annotations.Nullable()
    java.lang.Object model, @org.jetbrains.annotations.Nullable()
    com.bumptech.glide.request.target.Target<android.graphics.drawable.Drawable> target, @org.jetbrains.annotations.Nullable()
    com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
        return false;
    }
    
    public ProgressImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public ProgressImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public ProgressImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    public ProgressImageView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lllc/aerMist/base/shared/widgets/ProgressImageView$State;", "", "(Ljava/lang/String;I)V", "CREATED", "LOADING", "LOADED", "ERROR", "app_localApiDebug"})
    static enum State {
        /*public static final*/ CREATED /* = new CREATED() */,
        /*public static final*/ LOADING /* = new LOADING() */,
        /*public static final*/ LOADED /* = new LOADED() */,
        /*public static final*/ ERROR /* = new ERROR() */;
        
        State() {
        }
    }
}