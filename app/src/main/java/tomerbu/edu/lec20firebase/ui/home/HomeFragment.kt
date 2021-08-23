package tomerbu.edu.lec20firebase.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import tomerbu.edu.lec20firebase.R
import tomerbu.edu.lec20firebase.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }


    fun getEmail(): String {
        return binding.editEmail.text.toString()
    }

    //computed variable: משתנה מחושב - כמו בפונקציה
    val myEmail: String
        get() = binding.editEmail.text.toString()


    fun isEmailValid(): Boolean {
        return binding.editEmail.text.toString().length > 3
    }

    fun getPassword(): String {
        return binding.editPassword.text.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(myEmail, getPassword())
                .addOnSuccessListener {
                    binding.textHome.text = "Signed in"
                }.addOnFailureListener { e ->
                    binding.textHome.text = "${e.localizedMessage}"
                    binding.textHome.error = "An Error occurred $e"
                }
        }
        binding.buttonRegister.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(myEmail, getPassword())
                .addOnSuccessListener {
                    binding.textHome.text = "Created User"
                }.addOnFailureListener { e ->
                    binding.textHome.text = "${e.localizedMessage}"
                    binding.textHome.error = "An Error occurred $e"
                }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}