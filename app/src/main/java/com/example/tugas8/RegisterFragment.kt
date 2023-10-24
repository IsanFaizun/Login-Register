package com.example.tugas8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tugas8.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        val view = binding.root

        with(binding){
            val validationActivity = requireActivity() as ValidationActivity

            btnRegister.setOnClickListener{
                val username = regUsername.text.toString()
                val email = regEmail.text.toString()
                val phone = regPhone.text.toString()
                val password = regPassword.text.toString()

                if (username != "" && email != "" && phone != "" && password != "") {
                    if (checkbox.isChecked) {
                        val bundle = Bundle()
                        bundle.putString("username", username)
                        bundle.putString("password", password)

                        // Send ke Login
                        val adapter = validationActivity.viewPager2.adapter as FragmentStateAdapter
                        val loginFragment = adapter.createFragment(1) as LoginFragment
                        loginFragment.arguments = bundle

                        validationActivity.navigateToLoginPage()
                    } else {
                        Toast.makeText(requireContext(), "Mohon beri centang Terms and Condition", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Mohon isi kolom yang tersedia", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }
}