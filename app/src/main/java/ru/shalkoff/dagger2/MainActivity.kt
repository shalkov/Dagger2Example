package ru.shalkoff.dagger2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.shalkoff.dagger2.dagger.injectors.AppInjector
import ru.shalkoff.dagger2.simple1.Company
import ru.shalkoff.dagger2.simple4.CompanyInfo
import ru.shalkoff.dagger2.simple3.AnalyticsRepository
import ru.shalkoff.dagger2.simple5.ResourceManager
import ru.shalkoff.dagger2.simple6.PayProcess
import ru.shalkoff.dagger2.simple7.RegStepOneActivity
import ru.shalkoff.dagger2.simple8.Animal
import ru.shalkoff.dagger2.simple9.Robot
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    /**
     * обёртка dagger.Lazy, позволяет сделать отложенную инициализацию объекта
     * Объект будет создан при вызове метода get(), а при последующих вызовах метода get() он будет переиспользоваться
     *
     * Обёртка иногда может помочь, но стоит понимать, что при каждом вызове get() вызывается DoubleCheck проверка.
     * В этой статье говориться, что это может быть накладно: https://medium.com/@vimalp015/to-use-dagger-lazy-t-or-not-to-49768841495
     * Поэтому рекоммендуется использовать Lazy только в тех случаях, когда объект тяжёлый и не факт, что будет проинициализирован при использовании приложения.
     *
     * ------------
     * Еще есть обёртка Provider, делает так, что при каждом обращении к объекту он будет зановго проинициализирован.
     * Сами авторы библиотеки даггер, рекоммендуют не часто использовать.
     * ------------
     * Если объекто который поставляется будет помечен аннотацией @Singlton - то он будет проинициализирова один раз
     * Независимо что используется Lazy или Provider
     */
    @Inject
    @Named("firebase")
    lateinit var analyticsFirebaseRepository: dagger.Lazy<AnalyticsRepository>

    @Inject
    @Named("mindbox")
    lateinit var analyticsMindboxRepository: AnalyticsRepository

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var companyInfoFactory: CompanyInfo.Factory

    private val companyInfo: CompanyInfo by lazy {
        companyInfoFactory.create(name = "Surf")
    }

    @Inject
    lateinit var resourceManager: ResourceManager

    @Inject
    lateinit var payProcess: PayProcess

    /**
     * Получаем коллекцию запровайдженных объектов. См. AnimalModule.kt
     */
    @Inject
    lateinit var animals: Set<@JvmSuppressWildcards Animal>

    /**
     * Получаем Map запровайдженных объектов. См. RobotModule.kt
     */
    @Inject
    lateinit var robots: Map<Class<*>, @JvmSuppressWildcards Provider<Robot>>

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppInjector.appComponent.inject(this)
        sendFirebaseAnalyticsEvent()
        sendMindboxAnalyticsEvent()

        val companyInfoTv = findViewById<TextView>(R.id.company_info_tv)
        companyInfoTv.text = payProcess.payManager.pay()

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.loadRepos()


        val openRegBtn = findViewById<Button>(R.id.open_reg_btn)
        openRegBtn.setOnClickListener {
            val regIntent = Intent(this, RegStepOneActivity::class.java)
            startActivity(regIntent)
        }
        animals.forEach {
            println(it.name())
        }

        robots.forEach { (key, value) ->
            println(key.name + " " + value.get().name())
        }
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

    /**
     * Зависимость поставлена в активити, через интерфейс посредством @Bind
     */
    private fun sendFirebaseAnalyticsEvent() {
        Log.d("LOG", analyticsFirebaseRepository.get().showCartEvent())
    }

    /**
     * Зависимость поставлена в активити, через интерфейс посредством @Bind
     */
    private fun sendMindboxAnalyticsEvent() {
        Log.d("LOG", analyticsMindboxRepository.showCartEvent())
    }
}