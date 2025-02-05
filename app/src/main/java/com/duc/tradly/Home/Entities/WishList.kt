package com.duc.tradly.Home.Entities

class WishList {

    private val productList: MutableList<Product> = mutableListOf()

    // Thêm sản phẩm vào wishlist
    fun addProduct(product: Product) {
        if (!productList.contains(product)) {
            productList.add(product)
        }
    }
    fun getSize()=productList.size
    // Xóa sản phẩm khỏi wishlist
    fun removeProduct(product: Product) {
        productList.remove(product)
    }

    // Lấy danh sách sản phẩm trong wishlist
    fun getProducts(): List<Product> {
        return productList
    }


    // Kiểm tra sản phẩm có trong wishlist không
    fun contains(product: Product): Boolean {
        return productList.contains(product)
    }

    // Xóa toàn bộ sản phẩm trong wishlist
    fun clear() {
        productList.clear()
    }
}