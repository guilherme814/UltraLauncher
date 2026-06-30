package com.ultra.launcher.gestures

import android.view.GestureDetector
import android.view.MotionEvent
import kotlin.math.abs

/**
 * Custom Gesture Detector for launcher gestures
 */
class LauncherGestureDetector(
    private val callbacks: GestureCallbacks
) : GestureDetector.OnGestureListener {

    interface GestureCallbacks {
        fun onSwipeUp()
        fun onSwipeDown()
        fun onSwipeLeft()
        fun onSwipeRight()
        fun onLongPress(x: Float, y: Float)
        fun onDoubleTap()
        fun onPinch(scaleFactor: Float)
    }

    companion object {
        private const val SWIPE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
        private const val DOUBLE_TAP_TIME = 300
    }

    private var lastTapTime = 0L
    private var lastX = 0f
    private var lastY = 0f

    override fun onShowPress(e: MotionEvent?) {}

    override fun onSingleTapUp(e: MotionEvent?): Boolean = false

    override fun onDown(e: MotionEvent?): Boolean = false

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        if (e1 == null || e2 == null) return false

        val deltaX = e2.x - e1.x
        val deltaY = e2.y - e1.y

        return when {
            abs(deltaX) > abs(deltaY) -> {
                when {
                    deltaX > SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD -> {
                        callbacks.onSwipeRight()
                        true
                    }
                    deltaX < -SWIPE_THRESHOLD && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD -> {
                        callbacks.onSwipeLeft()
                        true
                    }
                    else -> false
                }
            }
            else -> {
                when {
                    deltaY > SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD -> {
                        callbacks.onSwipeDown()
                        true
                    }
                    deltaY < -SWIPE_THRESHOLD && abs(velocityY) > SWIPE_VELOCITY_THRESHOLD -> {
                        callbacks.onSwipeUp()
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean = false

    override fun onLongPress(e: MotionEvent?) {
        if (e != null) {
            callbacks.onLongPress(e.x, e.y)
        }
    }
}
