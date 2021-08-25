package br.com.dio.businesscard.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.dio.businesscard.R
import br.com.dio.businesscard.databinding.FragmentAddDataCardBinding
import br.com.dio.businesscard.util.MaskEditText
import br.com.dio.businesscard.viewModel.AddCardViewModel

class AddDataCardFragment : Fragment(R.layout.fragment_add_data_card) {
    private lateinit var binding: FragmentAddDataCardBinding
    private val viewModel: AddCardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddDataCardBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        addListeners()
    }

    private fun addListeners() {
        with(binding) {
            btnNext.setOnClickListener {
                if (viewModel?.camposValidos() == true) {
                    ocultarTeclado(it)
                    findNavController().navigate(AddDataCardFragmentDirections.navToSelectDesignCard())
                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.message_fill_fields),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        with(binding) {
            tilTelefone.editText?.addTextChangedListener(
                MaskEditText.mascara(
                    tilTelefone.editText as EditText,
                    MaskEditText.FORMAT_FONE
                )
            )
        }
    }

    private fun ocultarTeclado(view: View) {
        val inputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (inputMethodManager.isActive)
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}