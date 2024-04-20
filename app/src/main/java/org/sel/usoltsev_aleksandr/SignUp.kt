package org.sel.usoltsev_aleksandr

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.sel.usoltsev_aleksandr.databinding.ActivitySignUpBinding
import java.util.regex.Pattern

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pattern = ("[a-z1-9]{1,30}"+"@"+"[a-z]{1,30}"+"\\."+"[a-z]{1,3}")
        sp = getSharedPreferences("TABLE", MODE_PRIVATE)
        binding.apply {
            editTextText.setText("")
            editTextText2.setText("")
            editTextText3.setText("")
            editTextText4.setText("")
            editTextText5.setText("")
        }

        binding.button.setOnClickListener{
            if (binding.editTextText.text.toString().isEmpty() || binding.editTextText2.text.toString().isEmpty() || binding.editTextText3.text.toString().isEmpty() || binding.editTextText4.text.toString()
                    .isEmpty() || binding.editTextText5.text.toString().isEmpty()) {
                Toast.makeText(this, "Ни одно поле не должно быть пустым", Toast.LENGTH_SHORT).show()
            }
            else if (binding.editTextText5.text.toString() != binding.editTextText4.text.toString()) {
                    Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                }
            else if (!Pattern.compile(pattern).matcher(binding.editTextText3.text.toString()).matches()) {
                Toast.makeText(this, "E-mail не соответствует требованиям", Toast.LENGTH_SHORT).show()
            }
            else {
                val editor = sp.edit()
                editor.putString("fam", binding.editTextText2.text.toString())
                editor.putString("email", binding.editTextText3.text.toString())
                editor.putString("pass", binding.editTextText4.text.toString())
                editor.apply()
                val inte = Intent(this@SignUp, MainScreen::class.java)
                startActivity(inte)
            }
        }
        binding.button2.setOnClickListener {
            val inte2 = Intent(this@SignUp, SignIn::class.java)
            startActivity(inte2)
        }
        }


    }