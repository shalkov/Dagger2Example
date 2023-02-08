package ru.shalkoff.dagger2.simple7

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.shalkoff.dagger2.R
import ru.shalkoff.dagger2.dagger.injectors.RegistrationFeatureInjector
import ru.shalkoff.dagger2.simple1.department.AndroidJuniorGroup
import javax.inject.Inject

class RegStepOneActivity : AppCompatActivity() {

    /**
     * Этот объект скоупа @Singltone,
     * живёт в единственном экземпляре, пока жив компонет AppComponent
     * (пока живо приложение)
     */
    @Inject
    lateinit var androidJuniorGroup: AndroidJuniorGroup

    /**
     * Этот объект скоупа @RegistrationScope,
     * Живёт в единственном экземпляре, пока жив компонент RegComponent
     * (пока мы находимтся в скоупе фичи регистрации)
     *
     * Мы сами управляем временим жизни RegComponent компонента.
     * Компонент RegComponent уничтожается, когда пользователь завершает/выходит из флоу регистрации
     */
    @Inject
    lateinit var regInteractor: RegInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_step_one)
        RegistrationFeatureInjector.getRegComponent().inject(this)

        val textView = findViewById<TextView>(R.id.step_one_tv)
        textView.text = regInteractor.toString()
        textView.setOnClickListener {
            val regStepTwoIntent = Intent(this, RegStepTwoActivity::class.java)
            startActivity(regStepTwoIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (!isChangingConfigurations) {
            RegistrationFeatureInjector.clearRegComponent()
        }
    }
}