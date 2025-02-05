package com.duc.tradly.Home.Entities

import java.io.Serializable

data class Product(var resourceId:Int
,var name:String
,var price:Double
,var grocery: Grocery):Serializable
