package com.example.sampleproject.main.secondfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sampleproject.R
import com.example.sampleproject.databinding.FragmentSecondBinding
import com.example.sampleproject.main.MainViewModel
import com.example.sampleproject.main.firstfragment.FirstViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val viewModel by activityViewModels<MainViewModel>()
    private val secondViewModel by viewModels<SecondViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondViewModel.secondText.observe(this.viewLifecycleOwner){ text ->
            binding.textviewSecond.text = text

            secondViewModel.changeSecondText("Hello World!")

        }
    }


//        binding.buttonSecond.setOnClickListener {
//            viewModel.navigateToThird()
//        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}