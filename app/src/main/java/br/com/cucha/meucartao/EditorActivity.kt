package br.com.cucha.meucartao

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.EditText

class EditorActivity : AppCompatActivity() {

    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editFone: EditText

    companion object {
        val REQUEST_CODE_GPS_PERMISSION = 1001
    }

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

    override fun onResume() {
        super.onResume()

        val selfPermission = ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)

        if(selfPermission == PackageManager.PERMISSION_GRANTED) {
            //TODO Busca localizacao

        } else {

            val permission = Array(1, { android.Manifest.permission.ACCESS_FINE_LOCATION })

            ActivityCompat.requestPermissions(this, permission, REQUEST_CODE_GPS_PERMISSION)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(REQUEST_CODE_GPS_PERMISSION == requestCode && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            //TODO busca localizacao
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
