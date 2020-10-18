package com.mohamad.unittest

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.math.BigInteger
import java.security.PrivateKey
import java.security.PublicKey


class MainActivity : AppCompatActivity() {
    
    private lateinit var publick: PublicKey
    private lateinit var privatek: PrivateKey

    private val rsa = Rsaa()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        publick = rsa.getAsymmetricKeyPair()!!.public
        privatek = rsa.getAsymmetricKeyPair()!!.private


        encrypt.setOnClickListener {
            onEncryptStringbyRsa()
        }
        decrypt.setOnClickListener {
            onDecrytpStringByRsa()
        }

    }

    fun onEncryptStringbyRsa() {
        try {
            val input = inputTV.text.toString()
            var result = rsa.encrypt(input, publick)
            // var result = rsa.encrypt(input,publick)
            outputTV.setText(" ${result}")
        } catch (e: Exception) {

        }

    }

    fun onDecrytpStringByRsa() {

        try {
            val input = inputTV.text.toString()
            var result = rsa.decrypt(input, privatek)
            outputTV.setText(" ${result}")
        } catch (e: Exception) {

        }


    }
}