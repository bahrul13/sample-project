package com.example.sampleproject.main.firstfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.sampleproject.R
import com.example.sampleproject.databinding.FragmentFirstBinding
import com.example.sampleproject.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel by activityViewModels<MainViewModel>()
    private val firstViewModel by viewModels<FirstViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        firstViewModel.firstText.observe(this.viewLifecycleOwner){ text ->
//            binding.textviewFirst.text = text
//        }

        firstViewModel.listOfUsers.observe(this.viewLifecycleOwner) { users ->
            if(users == null) return@observe

            binding.textviewFirst.text = users.joinToString("\n") { user ->
                "${user.firstName} ${user.lastName}"
            }
        }

        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
//            binding.textviewFirst.text = "Hello World!"

//            viewModel.navigateToSecond()
        firstViewModel.changeFirstText("Hello World!")

        }

        binding.buttonAdd.setOnClickListener {
            val firstName = binding.editTextFirstName.text.toString()
            val lastName = binding.editTextLastName.text.toString()

            if(firstName.isNotEmpty() && lastName.isNotEmpty()) {

                lifecycleScope.launch {
                    firstViewModel.addName(
                        firstName = firstName,
                        lastName = lastName
                    )
                }
            }
        }

        binding.buttonDeleteAll.setOnClickListener {
            lifecycleScope.launch{
                firstViewModel.deleteAll()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}