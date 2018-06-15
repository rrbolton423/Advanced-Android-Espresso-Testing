package com.sqisland.android.espresso.cat_names

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView

class IdeasActivity : AppCompatActivity() {
  companion object {
    val KEY_THEME = "theme"
    val KEY_NAME = "name"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_ideas)

    val themeView = findViewById<TextView>(R.id.theme)

    val theme = intent.getStringExtra(KEY_THEME)
    if (theme == null) {
      themeView.setText(R.string.missing_theme)
      return
    }

    themeView.text = theme

    val ideasId = when (theme) {
      getString(R.string.theme_popular) -> R.array.ideas_popular
      getString(R.string.theme_famous) -> R.array.ideas_famous
      getString(R.string.theme_punny) -> R.array.ideas_punny
      else -> 0
    }

    if (ideasId == 0) {
      themeView.text = getString(R.string.unknown_theme, theme)
      return
    }

    val ideas = resources.getStringArray(ideasId)

    val recyclerView = findViewById<RecyclerView>(R.id.ideas)

    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = IdeasAdapter(ideas, object : IdeasAdapter.OnItemClickListener {
      override fun onItemClick(position: Int) {
        val data = Intent()
        data.putExtra(KEY_NAME, ideas[position])
        setResult(Activity.RESULT_OK, data)
        finish()
      }
    })
  }
}