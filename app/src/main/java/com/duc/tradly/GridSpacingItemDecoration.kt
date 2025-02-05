package com.duc.tradly

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridSpacingItemDecoration (
    private val columns: Int,
    private val margins: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view) // Vị trí của item
        outRect.right=margins
        outRect.bottom=margins
        if(position<columns){
            outRect.top=margins
        }
        if(position%columns==0){
            outRect.left = margins
        }
    }
}