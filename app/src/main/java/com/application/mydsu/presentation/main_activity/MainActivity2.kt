package com.application.mydsu.presentation.main_activity

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.application.mydsu.AboutMe
import com.application.mydsu.InformationAboutTheApp
import com.application.mydsu.R
import com.application.mydsu.Schedule
import com.application.mydsu.Tutorial.ActivityStart
import com.application.mydsu.Utils.CircularTransformation
import com.application.mydsu.databinding.ActivityMain2Binding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileInputStream

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private val viewModelFactory by lazy {
        MainActivityViewModelFactory(application)
    }
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    private var openBtnSwipe = false

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        with(viewModel) {
            getFirstRunList.observe(this@MainActivity2) {
                val intentFragment = Intent(this@MainActivity2, ActivityStart::class.java)
                startActivity(intentFragment)
            }
            if (getFirstRunSwipe() == 0) {
                binding.constraintSwipe.visibility = View.INVISIBLE
            } else {
                binding.constraintSwipe.visibility = View.VISIBLE
            }
            getNameList.observe(this@MainActivity2) {
                binding.name.text = it
            }
            getSurNameList.observe(this@MainActivity2) {
                binding.surName.text = it
            }
            getDirectionList.observe(this@MainActivity2) {
                binding.direction.text = it
            }
            getSubGroupList.observe(this@MainActivity2) {
                binding.subgroup.text = it
            }
        }

        with(binding) {
            myDSUText.setOnClickListener {
                val intentAboumeTut = Intent(this@MainActivity2, InformationAboutTheApp::class.java)
                startActivity(intentAboumeTut)
                finish()
                overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero)
            }
            userPhoto.setOnClickListener {
                val intent = Intent(this@MainActivity2, AboutMe::class.java)
                startActivity(intent)
                finish()
            }
            schedule.setOnClickListener {
                val intentSchedule = Intent(this@MainActivity2, Schedule::class.java)
                startActivity(intentSchedule)
                finish()
                overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero)
            }
            btnClose.setOnClickListener {
                constraintSwipe.visibility = View.INVISIBLE
                viewModel.saveFirstRunSwipe(0)
            }
            btnHomeWork.setOnClickListener {
                val intentAboumeTut = Intent(this@MainActivity2, InformationAboutTheApp::class.java)
                startActivity(intentAboumeTut)
                finish()
                overridePendingTransition(R.anim.alpha_zero_one, R.anim.alpha_one_zero)
            }
            btnOpen.setOnClickListener {
                if (viewModel.getFirstRunSwipe() != 0) {
                    if (!openBtnSwipe) {
                        constraintSwipe.visibility = View.INVISIBLE
                        openBtnSwipe = true
                    } else {
                        constraintSwipe.visibility = View.VISIBLE
                        openBtnSwipe = false
                    }
                }
                mycontent.toggle()
            }


            coroutineScope.launch {
                Picasso.with(this@MainActivity2).load(loadImageFromStorage())
                    .transform(CircularTransformation(150))
                    .noPlaceholder().centerCrop().fit()
                    .into(userPhoto)
            }
        }
    }

    private fun loadImageFromStorage(): File {
        val file = File(PATH, "phone.jpg")
        val b = BitmapFactory.decodeStream(FileInputStream(file))
        return file
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //эмулируем нажатие на HOME, сворачивая приложение
        val i = Intent(Intent.ACTION_MAIN)
        i.addCategory(Intent.CATEGORY_HOME)
        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(i)
        finish()
    }

    companion object {
        private const val PATH = "/data/user/0/com.application.mydsu/app_imageDir/"
    }
}