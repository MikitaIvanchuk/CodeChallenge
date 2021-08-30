package com.example.codechallenge.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.codechallenge.CodeChallengeApplication
import com.example.codechallenge.R
import com.example.codechallenge.databinding.ActivityMainBinding
import com.example.codechallenge.di.viewModel.ViewModelFactory
import com.example.codechallenge.ui.eventsList.EventsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel by viewModels<MainActivityViewModel> { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //         (requireActivity().application as CodeChallengeApplication).component.inject(this)
        (application as CodeChallengeApplication).component.inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_container,
                    EventsFragment.newInstance()
                )
                .commit()
        }

        viewModel.isInternetAvailable.observe(this, {
            binding.noInternetMsg.isVisible = !it
        })
    }
}
