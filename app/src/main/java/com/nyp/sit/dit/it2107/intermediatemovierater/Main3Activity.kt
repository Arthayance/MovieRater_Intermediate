package com.nyp.sit.dit.it2107.intermediatemovierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val movie = MovieEntity()
        var movie_name: String = getIntent().getStringExtra("Title")
        var movie_desc: String = getIntent().getStringExtra("Overview")
        var movie_lang: String = getIntent().getStringExtra("Language")
        var movie_rdate: String = getIntent().getStringExtra("ReleaseDate")
        var movie_audience: String = getIntent().getStringExtra("Audience")
        val reasonLanguage: Boolean = getIntent().getBooleanExtra("reasonLang", false)
        val reasonViolence: Boolean = getIntent().getBooleanExtra("reasonViolence", false)
        var l: String = ""
        var v: String = ""
        if (reasonLanguage == true) {
            l = "Language"
        }
        if (reasonViolence == true) {
            v = "Violence"
        }
        movie_title.text = movie_name + "\n"
        movie_description.text = movie_desc + "\n"
        language.text = movie_lang + "\n"
        r_date.text = movie_rdate + "\n"
        audience.text = movie_audience + "\n"


        registerForContextMenu(movie_reviews)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                movie_reviews.setVisibility(View.GONE)
                ratingDisplay.setVisibility(View.VISIBLE)
                reviewTextView.setVisibility(View.VISIBLE)
                reviewTextView.text = data?.getStringExtra("ReturnReviewText")
                val ratingValue: Float = data!!.getFloatExtra("ReturnRating", 0.00F)
                ratingDisplay.rating = ratingValue
            }
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.movie_reviews) {
            menu?.add(2, 1002, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1002) {
            val intent = Intent(this, Main4Activity::class.java)
            startActivityForResult(intent, 1)
        }
        return super.onContextItemSelected(item)
    }
}
