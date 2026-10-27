package com.example.educationandroidproject.data.mapper

import com.example.educationandroidproject.data.AppItem
import com.example.educationandroidproject.data.dto.AppDto

fun AppDto.toDomain(): AppItem {
    return AppItem(
        id = this.id,
        icon = this.iconRes,
        nameApp = this.title,
        description = this.desc,
        category = this.type
    )
}