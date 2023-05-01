package ru.netology.nmedia.activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.FragmentPostImageBinding
import ru.netology.nmedia.util.StringArg
import ru.netology.nmedia.view.load

class PostImageFragment : Fragment() {

    companion object {
        var Bundle.textArg: String? by StringArg
    }

    private var actionBar: ActionBar? = null
    private var fragmentBinding: FragmentPostImageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPostImageBinding.inflate(inflater, container, false)
        fragmentBinding = binding

        val url = arguments?.textArg
        if (url != null) {
            binding.image.load(url)
        }

        actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        if (actionBar != null) {
            setActionBarColor("#000000")
        }



        return binding.root
    }

    private fun setActionBarColor(color: String) {
        val colorDrawable = ColorDrawable(Color.parseColor(color))
        actionBar?.setBackgroundDrawable(colorDrawable)
    }

    override fun onDestroy() {
        super.onDestroy()
        val primaryColor = ContextCompat.getColor(requireContext(), R.color.colorPrimary)
        val hexColor = String.format("#%06X", 0xFFFFFF and primaryColor)
        setActionBarColor(hexColor)
    }

}
