package com.solano.eber.poketinder2023.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.viewModels
import com.solano.eber.poketinder2023.databinding.FragmentInfoBinding
import com.solano.eber.poketinder2023.ui.viewmodel.InfoViewModel

class InfoFragment : BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {

    private val viewModel: InfoViewModel by viewModels()
    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = binding.wvInfoFragment

        webView.settings.javaScriptEnabled = true

        viewModel.getUrlPokemon().observe(viewLifecycleOwner){
            webView.loadUrl(it)
        }
    }

}