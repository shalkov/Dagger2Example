package ru.shalkoff.dagger2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.shalkoff.dagger2.dagger.app_injector.AppInjector
import ru.shalkoff.dagger2.simple1.Company
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var company: Company

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppInjector.appComponent.inject(this)

        val companyInfoTv = findViewById<TextView>(R.id.company_info_tv)
        companyInfoTv.text = company.androidDep.getInfo()
    }
}