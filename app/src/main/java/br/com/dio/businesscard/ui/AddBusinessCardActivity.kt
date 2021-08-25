package br.com.dio.businesscard.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.businesscard.App
import br.com.dio.businesscard.databinding.ActivityAddBusinessCardBinding
import br.com.dio.businesscard.util.EventObserver
import br.com.dio.businesscard.viewModel.AddCardViewModel
import br.com.dio.businesscard.viewModel.AddCardViewModelFactory

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val addCardViewModel: AddCardViewModel by viewModels {
        AddCardViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        addCardViewModel.finish.observe(this, EventObserver { close ->
            if (close) finish()
        })

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}
