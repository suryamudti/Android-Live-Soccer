package com.surya.livescoreleague.ui.match.match_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.EventLog
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.databinding.ActivityMatchDetailBinding
import com.surya.livescoreleague.ui.main.ViewModelFactory
import com.surya.livescoreleague.util.toast
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class MatchDetailActivity : AppCompatActivity(), MatchDetailViewModelListener, KodeinAware {


    override val kodein by kodein()

    private val factory : ViewModelFactory by instance()

    private lateinit var binding : ActivityMatchDetailBinding

    private lateinit var viewModel : MatchDetailViewModel

    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val event = intent.getParcelableExtra<Event>("event")

        binding = DataBindingUtil.setContentView(this,R.layout.activity_match_detail)

        binding.event = event

        viewModel = ViewModelProviders.of(this,factory).get(MatchDetailViewModel::class.java)

        viewModel.listener = this

        supportActionBar?.title = event.strEvent

        event?.idAwayTeam?.let { viewModel.getAwayTeam(it) }
        event?.idHomeTeam?.let { viewModel.getHomeTeam(it) }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.getItem(0)?.isVisible = true
        if (isFavorite){
            menu?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
        }else{
            menu?.getItem(0)?.icon = ContextCompat
                .getDrawable(this, R.drawable.ic_added_to_favorites)
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home ->{
                finish()
                return true
            }
            R.id.add_to_favorite -> {
                if (isFavorite){
                    viewModel.deleteFromFavorite(movie)
                    isFavorite = false
                    toast("deleted")
                    invalidateOptionsMenu()
                }else{
                    viewModel.addToFavorite(movie)
                    isFavorite = true
                    toast("added")
                    invalidateOptionsMenu()
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStarted() {}

    override fun onShowHomeTeam(team: Teams) {
        Picasso.get()
            .load(team?.strTeamBadge)
            .into(binding.imgViewHome)
    }

    override fun onShowAwayTeam(team: Teams) {
        Picasso.get()
            .load(team?.strTeamBadge)
            .into(binding.imgAway)
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
