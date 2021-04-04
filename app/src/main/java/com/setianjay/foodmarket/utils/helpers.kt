package com.setianjay.foodmarket.utils

import java.text.NumberFormat
import java.util.*

object helpers {

    fun rupiahFormatting(number: Int): String {
        val localeID = Locale("in","ID")

        val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(number)
    }
}