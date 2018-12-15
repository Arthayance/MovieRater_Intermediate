package com.nyp.sit.dit.it2107.intermediatemovierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.save) {
            if (movie_name.text.toString() == "") {
                movie_name.setError("Name is required")
            }
            if (description.text.toString() == "") {
                description.setError("Description is required!")
            }
            if (release_date.text.toString() == "") {
                release_date.setError("Release date is required!")
            }
            if ((movie_name.text.toString() != "") && (description.text.toString() != "") && (release_date.text.toString() != "")) {
                var id: Int = rg1.checkedRadioButtonId
                val movie = MovieEntity()
                movie.movietitle = movie_name.text.toString()
                movie.movie_desc = description.text.toString()
                movie.movie_rdate = release_date.text.toString()
                val language: RadioButton = findViewById(id)
                movie.movie_lang = language.text.toString()
                if (checkbox_audience.isChecked()) {
                    movie.movie_audience = "No"
                } else {
                    movie.movie_audience = "Yes"
                }

                val intent = Intent(this, Main3Activity::class.java)
                intent.putExtra("Title", movie.movietitle)
                intent.putExtra("Overview", movie.movie_lang)
                intent.putExtra("Language", movie.movie_lang)
                intent.putExtra("ReleaseDate", movie.movie_rdate)
                intent.putExtra("Audience", movie.movie_audience)
                startActivity(intent)
            }
        }
        if (item?.itemId == R.id.resetTextBox) {
            movie_name.text.clear()
            description.text.clear()
            release_date.text.clear()
            var id: Int = rg1.checkedRadioButtonId
            val language: RadioButton = findViewById(id)
            language.isChecked = false




        }
        return super.onOptionsItemSelected(item)

    }
}
