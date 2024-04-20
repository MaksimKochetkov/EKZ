package org.sel.usoltsev_aleksandr

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.sel.usoltsev_aleksandr.databinding.ActivityMainScreenBinding
import org.sel.usoltsev_aleksandr.databinding.ActivitySignInBinding

class MainScreen : AppCompatActivity() {
    private lateinit var binding: ActivityMainScreenBinding
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sp = getSharedPreferences("TABLE", MODE_PRIVATE)
        binding.textView.setText(sp.getString("fam", ""))
    }
}