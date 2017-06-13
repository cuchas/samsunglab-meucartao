package br.com.cucha.meucartao

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById(R.id.button_editar)
        button.setOnClickListener {
            startEditor()
        }
    }

    fun startEditor() {
        val intent = Intent(this, EditorActivity::class.java)
        startActivity(intent)
    }
}
