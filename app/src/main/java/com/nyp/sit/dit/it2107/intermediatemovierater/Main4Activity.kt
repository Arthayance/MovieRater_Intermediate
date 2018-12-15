package com.nyp.sit.dit.it2107.intermediatemovierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.review,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.optionSubmit) {
            val movie = MovieEntity()
            var reviewText: String = reviewText.text.toString()
            movie.Rating = rating.rating
            val returnIntent = Intent()
            returnIntent.putExtra("ReturnRating", movie.Rating)
            returnIntent.putExtra("ReturnReviewText", reviewText)
            setResult(RESULT_OK, returnIntent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
