package br.com.cucha.meucartao

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class EditorActivity : AppCompatActivity() {

    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editFone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        editNome = findViewById(R.id.edit_nome_editor) as EditText
        editEmail = findViewById(R.id.edit_email_editor) as EditText
        editFone = findViewById(R.id.edit_fone_editor) as EditText

        findViewById(R.id.button_salvar_editor).setOnClickListener {
            salvaCartao()
        }
    }

    fun salvaCartao() {
        val preferences = getPreferences(Context.MODE_PRIVATE)

        val editor = preferences.edit()
        editor.putString("NOME", editNome.text.toString())
        editor.putString("EMAIL", editEmail.text.toString())
        editor.putString("FONE", editFone.text.toString())

        editor.apply()

        val result = Intent()
        result.putExtra("NOME", editNome.text.toString())
        result.putExtra("EMAIL", editEmail.text.toString())
        result.putExtra("FONE", editFone.text.toString())

        setResult(Activity.RESULT_OK, result)

        finish()
    }
}
