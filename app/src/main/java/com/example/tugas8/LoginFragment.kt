package com.example.tugas8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugas8.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root
        val validationActivity = requireActivity() as ValidationActivity

        val args = this.arguments
        val usernameRegister = args?.get("username").toString()
        val passwordRegister = args?.get("password").toString()

        with(binding){
            loginUsername.setSingleLine(true)

            btnLogin.setOnClickListener{
                val usernameLogin = loginUsername.text.toString()
                val passwordLogin = loginPassword.text.toString()

                if (usernameLogin != "" && passwordLogin != "") {
                    if (usernameLogin == usernameRegister && passwordLogin == passwordRegister) {
                        // Intent ke Main
                        val intentToMainActivity = Intent(requireContext(), MainActivity::class.java)
                        startActivity(intentToMainActivity)
                    } else {
                        Toast.makeText(requireContext(), "Username dan password kurang tepat", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Mohon isi kolom yang tersedia", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view
    }
}