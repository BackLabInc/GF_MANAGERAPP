package com.example.gf_managerapp

import android.graphics.drawable.Drawable
import android.widget.Button

class ImageModel {
    var name: String?= null
    lateinit var image_drawable: Drawable
    lateinit var  button: Button
    fun getNames(): String {
        return name.toString()
    }

    fun setNames(name: String) {
        this.name = name
    }

    fun getImage_drawables(): Drawable {
        return image_drawable
    }

    fun setImage_drawables(image_drawable: Drawable) {
        this.image_drawable = image_drawable
    }
    fun button(){
        this.button
    }
}