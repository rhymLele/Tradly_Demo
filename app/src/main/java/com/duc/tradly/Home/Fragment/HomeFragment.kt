package com.duc.tradly.Home.Fragment

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duc.tradly.Detail.DetailActivity
import com.duc.tradly.Home.Adapter.GridAdapter
import com.duc.tradly.Home.Adapter.ListGroceryAdapter
import com.duc.tradly.Home.Adapter.ListProductAdapter
import com.duc.tradly.Home.Adapter.PhantuAdapter
import com.duc.tradly.Home.Entities.GridItem
import com.duc.tradly.Home.Entities.Grocery
import com.duc.tradly.Home.Entities.Phantu
import com.duc.tradly.Home.Entities.Product
import com.duc.tradly.R


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_home2, container, false)
        anhxa(view)
        return  view
    }
    private fun anhxa(view: View): Unit {

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_home_1)
        val recyclerView2: RecyclerView = view.findViewById(R.id.recycler_home_2)
        val recyclerView3: RecyclerView = view.findViewById(R.id.recycler_home_3)
        val recyclerView4: RecyclerView = view.findViewById(R.id.recycler_home_4)
        val recyclerGView: RecyclerView = view.findViewById(R.id.recycler_grid)

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView3.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView4.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        val data = getPhanTu()
        val phantuAdapter = PhantuAdapter(data)
        recyclerView.adapter = phantuAdapter
        val decor = object : DividerItemDecoration(requireContext(), LinearLayoutManager.HORIZONTAL) {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.right = 30 // Thêm khoảng cách giữa các phần tử
            }
        }

        recyclerView.addItemDecoration(decor)
        recyclerView2.addItemDecoration(decor)
        recyclerView3.addItemDecoration(decor)
        recyclerView4.addItemDecoration(decor)

        val groceries = listOf(
            Grocery(R.drawable.ava1, R.drawable.rec40, "Grocery 1"),
            Grocery(R.drawable.avatar1, R.drawable.rec41, "Grocery 2"),
            Grocery(R.drawable.ava1, R.drawable.rec41, "Grocery 3")
        )
        val products = listOf(
            Product(R.drawable.fi, "Product 1", 10.99, groceries[0]),
            Product(R.drawable.shampoo, "Product 2", 20.99, groceries[1]),
            Product(R.drawable.pic1, "Product 3", 20.99, groceries[2])
        )
        val dataList = listOf(
            GridItem(R.drawable.rec28, "Beverages"),
            GridItem(R.drawable.rec29, "Bread & Bakery"),
            GridItem(R.drawable.rec30, "Vegetables"),
            GridItem(R.drawable.rec31, "Fruit"),
            GridItem(R.drawable.rec32, "Egg"),
            GridItem(R.drawable.rec33, "Frozen veg"),
            GridItem(R.drawable.rec34, "Homecare"),
            GridItem(R.drawable.rec35, "Pet Care"),
        )
        val productAdapter = ListProductAdapter(products){
            selectedProduct->
            val intent=Intent(requireContext(),DetailActivity::class.java)
            intent.putExtra("product_data",selectedProduct)
            startActivity(intent)
        }
        recyclerView2.adapter = productAdapter
        recyclerView3.adapter = productAdapter


        val groceryAdapter = ListGroceryAdapter(groceries)
        recyclerView4.adapter = groceryAdapter


// Thiết lập GridLayoutManager
        val gridLayoutManager = GridLayoutManager(requireContext(), 4) // 4 cột
        recyclerGView.layoutManager = gridLayoutManager

// Gắn Adapter
        val gridAdapter = GridAdapter(dataList)
        recyclerGView.adapter = gridAdapter
    }
    private fun getPhanTu(): List<Phantu> {
        val a = mutableListOf<Phantu>()
        a.add(Phantu(R.drawable.pic1, "ready for sure"))
        a.add(Phantu(R.drawable.pic1, "No ready "))
        a.add(Phantu(R.drawable.pic1, "syr"))
        return a
    }

}