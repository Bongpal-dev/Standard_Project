package com.android.homeactivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.android.homeactivity.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val tag = "main_activity_test"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        topBannerAdapterConnect()
        mainContentAdapterConnect()
        bottomNaviInit()
    }

    private fun topBannerAdapterConnect() {
        binding.vpTopBanner.apply {
            adapter = TopBannerAdapter(context as FragmentActivity)
        }
    }

    private fun mainContentAdapterConnect() {
        binding.vpWebtoonList.apply {
            adapter = WebtoonListAdapter(context as FragmentActivity)
        }
        TabLayoutMediator(binding.tlWebtoonTabMenu, binding.vpWebtoonList) { tab, position ->
            tab.text = when (position) {
                0 -> "신작"
                1 -> "매일+"
                2 -> "월"
                3 -> "화"
                4 -> "수"
                5 -> "목"
                6 -> "금"
                7 -> "토"
                8 -> "일"
                9 -> "완결"
                else -> "금"
            }
        }.attach()
    }

    fun bottomNaviInit() {
        val tag = "bottom_navi_test"

        binding.bottomNavigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.webtoon -> {
                    Log.i(tag, "웹툰")
                    return@setOnItemSelectedListener true
                }
                R.id.recommand_end -> {
                    val intent = Intent(this, RecommandActivity::class.java)
                    startActivity(intent)
                    Log.i(tag, "추천완결")
                    return@setOnItemSelectedListener true
                }
                R.id.best -> {
                    Log.i(tag, "베스트 도전")
                    return@setOnItemSelectedListener true
                }
                R.id.my_menu -> {
                    Log.i(tag, "마이메뉴")
                    return@setOnItemSelectedListener true
                }
                R.id.mores -> {
                    Log.i(tag, "더보기")
                    return@setOnItemSelectedListener true
                }
                else -> {
                    Log.i(tag, "아")
                    false
                }
            }
        }
    }
}


