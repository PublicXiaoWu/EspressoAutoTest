package com.liushaoxiang.espressoautotest.activity

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.test.espresso.IdlingResource
import android.support.v7.app.AppCompatActivity
import com.liushaoxiang.espressoautotest.R
import com.liushaoxiang.espressoautotest.idlingregistry.SimpleIdlingResource
import kotlinx.android.synthetic.main.setting_activity.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting_activity)
//        setIdleNow(true)

        tv_espresso.setOnClickListener {
            tv_espresso.text = "OK"
//            setIdleNow(false)
        }
    }


    //自动化测试使用
    private var mIdlingResource: SimpleIdlingResource? = null

    /**
     * Espresso 自动化测试延迟操作
     * @param isIdleNow 是否为空闲，false则阻塞测试线程
     */
    fun setIdleNow(isIdleNow: Boolean) {
        if (mIdlingResource?.isIdleNow != isIdleNow) {
            if (isIdleNow) {
                //耗时操作结束，设置空闲状态为true，放开测试线程
                mIdlingResource?.setIdleState(true)
            } else {
                //耗时操作开始，设置空闲状态为false，阻塞测试线程
                mIdlingResource?.setIdleState(false)
            }
        }
    }

    /**
     * Only called from test, creates and returns a new [SimpleIdlingResource].
     */
    @VisibleForTesting
    fun getIdlingResource(): IdlingResource {
        if (mIdlingResource == null) {
            mIdlingResource = SimpleIdlingResource()
        }
        return mIdlingResource!!
    }


}
