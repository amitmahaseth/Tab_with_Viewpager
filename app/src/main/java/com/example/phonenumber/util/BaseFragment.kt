package com.example.phonenumber.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.phonenumber.R
import com.example.phonenumber.model.NumberModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import java.io.UnsupportedEncodingException

open class BaseFragment:Fragment() {

    fun getNumberList(): ArrayList<NumberModel> {
        var languageList: ArrayList<NumberModel>? = null
        val inputStream: InputStream = requireActivity().resources.openRawResource(R.raw.phonelist)
        try {
            val reader: Reader = InputStreamReader(inputStream, "UTF-8")
            val gson = Gson()
            languageList = gson.fromJson(reader, object : TypeToken<ArrayList<NumberModel>>() {}.type)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return languageList!!
    }
}