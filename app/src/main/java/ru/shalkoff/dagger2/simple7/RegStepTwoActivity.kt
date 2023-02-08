package ru.shalkoff.dagger2.simple7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.shalkoff.dagger2.R
import ru.shalkoff.dagger2.dagger.injectors.RegistrationFeatureInjector
import ru.shalkoff.dagger2.simple1.department.AndroidJuniorGroup
import javax.inject.Inject

class RegStepTwoActivity : AppCompatActivity() {

    @Inject
    lateinit var androidJuniorGroup: AndroidJuniorGroup

    @Inject
    lateinit var regInteractor: RegInteractor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg_step_two)
        RegistrationFeatureInjector.getRegComponent().inject(this)

        val textView = findViewById<TextView>(R.id.step_two_tv)
        textView.text = regInteractor.toString()
    }
}