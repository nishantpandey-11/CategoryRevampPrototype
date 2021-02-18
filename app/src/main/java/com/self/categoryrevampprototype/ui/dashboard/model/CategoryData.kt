package com.self.categoryrevampprototype.ui.dashboard.model

const val TYPE_CATEGORY = 0
const val TYPE_SUB_CATEGORY = 1

val categoryData: Map<CategoryModel, List<CategoryModel>>
    get() = mapOf<CategoryModel, List<CategoryModel>>(
        categoryList[0] to subCategoryMobile,
        categoryList[1] to subCategoryLargeAppliance,
        categoryList[2] to subCategoryMensFashion
    )
val categoryList = listOf(
    CategoryModel("Mobile & Electronics", TYPE_CATEGORY),
    CategoryModel("Large Appliances", TYPE_CATEGORY),
    CategoryModel("Men's Fashion", TYPE_CATEGORY),
    CategoryModel("Women's Fashion", TYPE_CATEGORY),
    CategoryModel("Kid's Fashion", TYPE_CATEGORY),
    CategoryModel("Home & Accessories", TYPE_CATEGORY),
    CategoryModel("Jewellery & Accessories", TYPE_CATEGORY)
)

val subCategoryMobile = listOf(
    CategoryModel("Mobile Phones", TYPE_SUB_CATEGORY),
    CategoryModel("Camera", TYPE_SUB_CATEGORY),
    CategoryModel("Laptops", TYPE_SUB_CATEGORY),
    CategoryModel("Tablets", TYPE_SUB_CATEGORY),
    CategoryModel("Headphones", TYPE_SUB_CATEGORY),
    CategoryModel("Printer", TYPE_SUB_CATEGORY),
    CategoryModel("Storage Devices", TYPE_SUB_CATEGORY),
    CategoryModel("Wearable Devices", TYPE_SUB_CATEGORY),
    CategoryModel("Speaker", TYPE_SUB_CATEGORY),
    CategoryModel("Audio Store", TYPE_SUB_CATEGORY),
    CategoryModel("Home Theater", TYPE_SUB_CATEGORY),
    CategoryModel("Networking", TYPE_SUB_CATEGORY),
    CategoryModel("Devices", TYPE_SUB_CATEGORY),
    CategoryModel("Gaming", TYPE_SUB_CATEGORY)
)

val subCategoryLargeAppliance = listOf(
    CategoryModel("Television", TYPE_SUB_CATEGORY),
    CategoryModel("Air Conditioners", TYPE_SUB_CATEGORY),
    CategoryModel("Refrigerators", TYPE_SUB_CATEGORY),
    CategoryModel("Washing Machines", TYPE_SUB_CATEGORY),
    CategoryModel("Kitchen Appliances", TYPE_SUB_CATEGORY),
    CategoryModel("Small Appliances", TYPE_SUB_CATEGORY),
    CategoryModel("Home Audio", TYPE_SUB_CATEGORY)
)

val subCategoryMensFashion = listOf(
    CategoryModel("Casual Wear", TYPE_SUB_CATEGORY),
    CategoryModel("Formal Wear", TYPE_SUB_CATEGORY),
    CategoryModel("Ethnic Wear", TYPE_SUB_CATEGORY),
    CategoryModel("Sports Wear", TYPE_SUB_CATEGORY),
    CategoryModel("Foot Wear", TYPE_SUB_CATEGORY),
    CategoryModel("Inner Wear", TYPE_SUB_CATEGORY),
    CategoryModel("Bags", TYPE_SUB_CATEGORY),
    CategoryModel("Watches", TYPE_SUB_CATEGORY)
)