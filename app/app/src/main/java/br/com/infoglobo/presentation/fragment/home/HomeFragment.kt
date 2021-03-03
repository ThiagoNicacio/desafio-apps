package br.com.infoglobo.presentation.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import br.com.infoglobo.R
import br.com.infoglobo.databinding.HomeFragmentBinding
import br.com.infoglobo.presentation.adapter.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val adapter = NewsAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeFragmentBinding.inflate(inflater, container, false)

        binding.let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
            it.recycler.adapter = adapter
        }

        viewModel.news.observe(viewLifecycleOwner){
            it?.let { list->
                if (list.size > 1) adapter.replaceItems(list.subList(1, list.size))
                else adapter.replaceItems(list)
            }
        }

        binding.image.setOnClickListener {
            viewModel.singleNews.value?.let {news ->
                val direction = HomeFragmentDirections.homeToDetails(news)
                it.findNavController().navigate(direction)
            }
        }

        binding.toolbarMenu.setOnClickListener { Toast.makeText(requireContext(), getString(R.string.in_progress), Toast.LENGTH_SHORT).show() }

        return binding.root
    }
}