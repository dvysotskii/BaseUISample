package com.example.baseuisample.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.baseuisample.R
import com.example.baseuisample.network.NetworkService
import com.example.baseuisample.network.SampleApi
import com.example.baseuisample.network.model.LoginRequest
import com.example.baseuisample.network.model.LoginResponse
import com.example.baseuisample.ui.fragment.FirstFragment
import io.reactivex.Scheduler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val FIRST_FRAGMET_TAG = "123"

class SecondActivity : AppCompatActivity() {

    private lateinit var showFirstFragmentBtn: Button
    private lateinit var removeFirstFragmentBtn: Button
    private lateinit var tokenValueTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showFirstFragmentBtn = findViewById(R.id.show_fragment_btn)
        showFirstFragmentBtn.setOnClickListener {
            showFirstFragment()
        }
        removeFirstFragmentBtn = findViewById(R.id.remove_fragment_btn)
        removeFirstFragmentBtn.setOnClickListener {
            removeFirstFragment()
        }
        tokenValueTv = findViewById(R.id.text_tv)
        findViewById<Button>(R.id.make_request_btn)
            .setOnClickListener { makeRequest() }
    }

    private fun showFirstFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, FirstFragment.newInstance(), FIRST_FRAGMET_TAG)
            .commit()
    }

    private fun removeFirstFragment() {
        val firstFragment = supportFragmentManager.findFragmentByTag(FIRST_FRAGMET_TAG)

        firstFragment?.let {
            supportFragmentManager
                .beginTransaction()
                .remove(firstFragment)
                .commit()
        }
    }

    private fun makeRequest() {
        val service = NetworkService.getInstance().create(SampleApi::class.java)

        val observable = service.authorizate(LoginRequest("user", "password"))
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                tokenValueTv.text = it.accessToken
            }
    }

    private fun sampleRxJava() {
        val observable = Observable.just("Hello World")

        observable.subscribe {
            Toast.makeText(this@SecondActivity, it, Toast.LENGTH_SHORT).show()
        }
    }
}
