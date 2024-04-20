package org.sel.usoltsev_aleksandr

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.sel.usoltsev_aleksandr.databinding.ActivitySignInBinding
import org.sel.usoltsev_aleksandr.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignIn : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pattern = ("[a-z]{1,30}"+"@"+"[a-z]{1,30}"+"\\."+"[a-z]{1,3}")
        sp = getSharedPreferences("TABLE", MODE_PRIVATE)
        binding.apply {
            editTextText.setText("")
            editTextText2.setText("")
        }
        val em = sp.getString("email", "")
        val ps = sp.getString("pass", "")
        binding.button.setOnClickListener {
            if (binding.editTextText.text.toString().isEmpty() || binding.editTextText2.text.toString().isEmpty()) {
                Toast.makeText(this, "Ни одно поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            }
            else if (!Pattern.compile(pattern).matcher(binding.editTextText.text.toString()).matches()) {
                Toast.makeText(this, "E-mail не соответствует требованиям", Toast.LENGTH_SHORT).show()
            }
            else if (binding.editTextText.text.toString() != em) {
                Toast.makeText(this, "Почты не совпадают", Toast.LENGTH_SHORT).show()
            }
            else if (binding.editTextText2.text.toString() != ps) {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
            }
            else {
                val inte = Intent(this@SignIn, MainScreen::class.java)
                startActivity(inte)
            }


        }
        binding.button2.setOnClickListener {
            val inte2 = Intent(this@SignIn, SignUp::class.java)
            startActivity(inte2)
        }
    }
}