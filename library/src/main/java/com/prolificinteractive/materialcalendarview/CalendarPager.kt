package com.prolificinteractive.materialcalendarview

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

class CalendarPager
@JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null) : ViewPager(context, attrs) {


    /**
     * enable disable viewpager scroll
     *
     * false to disable paging, true for paging (default)
     */
    var pagingEnabled = true

    val isPagingEnabled get() = pagingEnabled


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean =
            pagingEnabled && super.onInterceptTouchEvent(ev)

    override fun onTouchEvent(ev: MotionEvent?): Boolean  =
         pagingEnabled && super.onTouchEvent(ev)

    /**
     * disables scrolling vertically when paging disabled, fixes scrolling
     * for nested [android.support.v4.view.ViewPager]
     */
    override fun canScrollVertically(direction: Int): Boolean =
        pagingEnabled && super.canScrollVertically(direction)

    /**
     * disables scrolling horizontally when paging disabled, fixes scrolling
     * for nested [android.support.v4.view.ViewPager]
     */
    override fun canScrollHorizontally(direction: Int): Boolean  =
            pagingEnabled && super.canScrollHorizontally(direction)

}