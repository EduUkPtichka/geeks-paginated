package com.example.geeks_paginated

data class PixelModel (
    val hits: List<ImageModel>,
)

data class ImageModel(
    val largeImageURL: String
)