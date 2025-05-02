package com.example.spring_multi_ds_config.util;

public record QueryParam(
        int position,
        Class<?> type,
        Object value
) {
}
