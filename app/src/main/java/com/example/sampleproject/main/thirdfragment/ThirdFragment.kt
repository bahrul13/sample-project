package com.example.sampleproject.main.thirdfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sampleproject.R
import com.example.sampleproject.databinding.FragmentThirdBinding
import com.example.sampleproject.main.MainViewModel

class ThirdFragment: Fragment(){

    private var _binding: FragmentThirdBinding? = null
    private val viewModel by activityViewModels<MainViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonThird.setOnClickListener {
//            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
            viewModel.navigateToFirst()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}