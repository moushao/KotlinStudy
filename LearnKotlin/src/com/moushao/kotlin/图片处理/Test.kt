package com.moushao.kotlin.图片处理

import java.awt.Image
import java.awt.image.BufferedImage
import java.awt.image.BufferedImageOp
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    var image = BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB)
    image.setRGB(0, 0, 0xff0000)
    image.apply {
        for (i in 0..99) {
            for (j in 0..99) {
                setRGB(i, j, 0xff0000)
            }
        }
    }
    ImageIO.write(image, "bmp", File("a.bmp"))
}