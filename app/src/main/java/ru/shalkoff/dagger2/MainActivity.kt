package ru.shalkoff.dagger2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.shalkoff.dagger2.dagger.app_injector.AppInjector
import ru.shalkoff.dagger2.simple1.Company
import ru.shalkoff.dagger2.simple3.AnalyticsRepository
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    init {
        val tt = 0
    }

    @Inject
    @Named("firebase")
    lateinit var analyticsRepository: AnalyticsRepository
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppInjector.appComponent.inject(this)

        val companyInfoTv = findViewById<TextView>(R.id.company_info_tv)
        companyInfoTv.text = analyticsRepository.showCartEvent()

        val viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
        viewModel.loadRepos()

    }

    /**
     * Инжект зависимости через метод.
     * Метот будет вызван автоматически, после инициализации класса(вызов метода init),
     * где этот метод находится.
     * (вызов метода не привязан к жизненному циклу Activity/Fragment и т.д)
     */
    @Inject
    fun createCompany(company: Company) {
        Toast.makeText(
            this,
            company.androidDep.getInfo(),
            Toast.LENGTH_LONG
        ).show()
    }
}