package llc.aerMist.base.shared.kotlin;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\b"}, d2 = {"bindImage", "", "Landroid/widget/ImageView;", "url", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "error", "app_localApiDebug"})
public final class BindingAdaptersKt {
    
    /**
     * Example:
     *
     * <ImageView
     *     ...
     *     app:glideSrc="@{viewModel.imageUrl}"
     *     app:glidePlaceholderSrc="@{@drawable/image_placeholder}"
     *     app:glideErrorSrc="@{@drawable/image_error}"/>
     */
    @kotlin.Suppress(names = {"unused"})
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"glideSrc", "glidePlaceholderSrc", "glideErrorSrc"})
    public static final void bindImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$bindImage, @org.jetbrains.annotations.Nullable()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable placeholder, @org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable error) {
    }
}