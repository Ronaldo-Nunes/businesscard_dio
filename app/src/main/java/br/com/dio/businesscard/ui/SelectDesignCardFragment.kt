package br.com.dio.businesscard.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.dio.businesscard.R
import br.com.dio.businesscard.databinding.FragmentAddColorCardBinding
import br.com.dio.businesscard.ui.adapter.SampleCardAdapter
import br.com.dio.businesscard.viewModel.AddCardViewModel
import vadiole.colorpicker.ColorModel
import vadiole.colorpicker.ColorPickerDialog


class SelectDesignCardFragment : Fragment(R.layout.fragment_add_color_card) {
    private val TAG = "SelectDesignCardFrag"
    private lateinit var binding: FragmentAddColorCardBinding
    private val adapter by lazy { SampleCardAdapter() }

    private val viewModel: AddCardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddColorCardBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        initRecycler()
        addListeners()
    }

    private fun initRecycler() {
        with(binding) {
            rvLayouts.adapter = adapter
        }
    }

    private fun addListeners() {
        with(binding) {
            btnColorBack.setOnClickListener {
                val intColor: Int? = viewModel?.getBackColor()
                intColor?.let { color -> showColorPicker(color) }
            }

            btnColorText.setOnClickListener {
                val intColor: Int? = viewModel?.getTextColor()
                intColor?.let { color -> showColorPicker(color, isColorText = true) }
            }

            btnVoltar.setOnClickListener {
                findNavController().popBackStack()
            }

            btnConfirmCard.setOnClickListener {
                val type = adapter.getCardTypeSelected()
                Log.d(TAG, "Card Type: $type")
                viewModel?.setCardType(type)
                viewModel?.insert()
            }
        }

        viewModel.card().observe(viewLifecycleOwner) { card ->
            viewModel.fillSampleList(card)
        }

        viewModel.sampleList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }

    }

    private fun showColorPicker(defaultColor: Int, isColorText: Boolean = false) {
        val colorPicker: ColorPickerDialog = ColorPickerDialog.Builder()
            .setInitialColor(defaultColor)
            .setColorModel(ColorModel.RGB)
            .setColorModelSwitchEnabled(true)
            .setButtonOkText(android.R.string.ok)
            .setButtonCancelText(R.string.label_cancelar)
            .onColorSelected { color: Int ->
                if (isColorText) {
                    viewModel.setTextColor(intColorToHex(color))
                } else {
                    viewModel.setBackColor(intColorToHex(color))
                }
            }
            .create()
        colorPicker.show(childFragmentManager, "color_picker")

    }

    private fun intColorToHex(intColor: Int): String {
        return String.format("#%06X", 0xFFFFFF and intColor)
    }

}