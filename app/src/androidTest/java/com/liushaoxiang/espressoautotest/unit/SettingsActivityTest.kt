package com.liushaoxiang.espressoautotest.unit

import com.liushaoxiang.espressoautotest.activity.SettingsActivity
import com.liushaoxiang.espressoautotest.R
import org.junit.runners.MethodSorters
import org.junit.runner.RunWith
import org.junit.*
import android.support.test.runner.AndroidJUnit4
import android.support.test.filters.LargeTest
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.IdlingResource
import android.support.test.espresso.IdlingRegistry
import android.content.Intent
import android.app.Instrumentation
import android.os.Build
import android.support.test.InstrumentationRegistry.*
import com.gkzxhn.autoespresso.operate.*
import android.app.Activity
import android.text.InputType
import android.Manifest
import android.provider.MediaStore
import android.support.test.InstrumentationRegistry
import android.os.Environment
import android.view.Gravity
import android.content.Context
import android.content.SharedPreferences

/** 设置 set
 * Created by LSX on 2018/09/27 14:01:05.
 */
@RunWith(AndroidJUnit4::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@LargeTest
class SettingsActivityTest {
	private var mIdlingResource: IdlingResource?=null
	@Rule
	@JvmField
	val mActivityTestRule: IntentsTestRule<SettingsActivity> = object : IntentsTestRule<SettingsActivity>(SettingsActivity::class.java) {
		override fun getActivityIntent(): Intent {
			val intent = Intent(getInstrumentation().targetContext,SettingsActivity::class.java)
			return intent
		}
	}
	@Before
	fun setUp() {
		//从Activity中获取延迟操作对象
		mIdlingResource=mActivityTestRule.activity.getIdlingResource()
		//注册空闲资源－便于网络请求等耗时操作阻塞线程，进行单元测试
		if(mIdlingResource!=null)IdlingRegistry.getInstance().register(mIdlingResource)
	}
	@After
	fun unregisterIdlingResource(){
		//注销延迟操作对象
		if(mIdlingResource!=null)IdlingRegistry.getInstance().unregister(mIdlingResource)
	}
	/**
	 * 验证文本
	 */
	@Test
	fun set_2() {
		with(mActivityTestRule.activity){
			//点文字
			TView.click_id(R.id.tv_espresso)
			//验证显示文字
			TView.check_id_text(R.id.tv_espresso,"OK")
		}
	}

}