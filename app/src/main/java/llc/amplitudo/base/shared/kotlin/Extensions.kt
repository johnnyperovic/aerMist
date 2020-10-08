@file:Suppress("unused")

package llc.amplitudo.base.shared.kotlin

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.graphics.drawable.TransitionDrawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import llc.amplitudo.base.R
import java.util.*

fun String?.isValidUsername() = this?.length in 7..19

fun ImageView.setVisible(loading: Boolean, visible: Boolean) {

}

fun View.setVisible(visible: Boolean) {
    visibility = if (visible) View.VISIBLE
    else View.GONE
}

fun View.hideKeyboard() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.apply {
        hideSoftInputFromWindow(windowToken, 0)
    }
}

fun View.setAsRootView() {
    isFocusable = true
    isFocusableInTouchMode = true
    isClickable = true

    onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
        if (hasFocus) v.hideKeyboard()
    }
}

fun View.showError(mError: String?) {
    var error = mError
    val defaultError = context?.getString(R.string.default_error)
    error = if (error.isNullOrEmpty() && !defaultError.isNullOrEmpty()) defaultError
    else ""
    Snackbar.make(
        this,
        error,
        Snackbar.LENGTH_SHORT
    ).show()
}

fun Context.showInfoDialog(messageResId: Int) {
    AlertDialog.Builder(this)
        .setMessage(messageResId)
        .setPositiveButton(
            R.string.ok,
            null
        )
        .show()
}

fun Context.showConfirmationDialog(titleResId: Int, messageResId: Int, action: () -> Unit) {
    AlertDialog.Builder(this)
        .setTitle(titleResId)
        .setMessage(messageResId)
        .setPositiveButton(
            R.string.yes
        ) { _, _ ->
            action.invoke()
        }
        .setNegativeButton(
            R.string.no, null
        )
        .show()
}

fun View.showWithAnimation() {
    if (visibility != View.VISIBLE)
        this.apply {
            alpha = 0f
            visibility = View.VISIBLE

            animate()
                .alpha(1f)
                .setDuration(150)
                .setListener(null)
        }
}

fun View.hideWithAnimation() {
    if (this.visibility == View.VISIBLE) {
        this.animate()
            .alpha(0f)
            .setDuration(150)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    this@hideWithAnimation.visibility = View.GONE
                }
            })
    }
}

fun View.changeBackgroundAnimated(drawableId: Int) {
    val colorDrawables = arrayOf(
        background,
        ContextCompat.getDrawable(context, drawableId)
    )
    val transitionDrawable = TransitionDrawable(colorDrawables)
    background = transitionDrawable
    transitionDrawable.startTransition(200)
}

fun SearchView.getSearchText(): TextView {
    return findViewById(androidx.appcompat.R.id.search_src_text)
}

fun String?.nameToInitials(): String {
    return if (!this.isNullOrBlank()) {
        this.split(' ')
            .mapNotNull { it.firstOrNull()?.toString() }
            .reduce { acc, s -> acc + s }
            .toUpperCase(Locale.getDefault())
    } else ""
}
