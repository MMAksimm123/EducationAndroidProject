package com.example.educationandroidproject.data.mapper

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.dto.AppDto

fun AppDto.toDomain(): AppItem {
    return AppItem(
        id = this.id,
        iconUrl = this.iconUrl,
        nameApp = this.name,
        description = this.description,
        category = this.category
    )
}