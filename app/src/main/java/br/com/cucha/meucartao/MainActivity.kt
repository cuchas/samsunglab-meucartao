package br.com.cucha.meucartao

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        val REQUEST_CODE_EDITOR = 1001
    }

    lateinit var textNome: TextView
    lateinit var textEmail: TextView
    lateinit var textFone: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textNome = findViewById(R.id.text_nome) as TextView
        textEmail = findViewById(R.id.text_email) as TextView
        textFone = findViewById(R.id.text_fone) as TextView

        val button = findViewById(R.id.button_editar)
        button.setOnClickListener {
            startEditor()
        }
    }

    fun startEditor() {
        val intent = Intent(this, EditorActivity::class.java)
        startActivityForResult(intent, REQUEST_CODE_EDITOR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_EDITOR && resultCode == Activity.RESULT_OK) {
            val nome = data?.extras?.getString("NOME") ?: ""
            val email = data?.extras?.getString("EMAIL") ?: ""
            val fone = data?.extras?.getString("FONE") ?: ""

            textNome.text = nome
            textEmail.text = email
            textFone.text = fone
        }
    }
}
