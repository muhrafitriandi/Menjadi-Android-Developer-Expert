package com.yandey.githubapp.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.yandey.core.data.Resource
import com.yandey.core.domain.model.User
import com.yandey.core.utils.Constants.EXTRA_USER
import com.yandey.core.utils.loadImage
import com.yandey.githubapp.R
import com.yandey.githubapp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = requireActivity().intent.getStringExtra(EXTRA_USER)
        observeUserDetail(username.toString())
        openGithub(getString(R.string.github_url, username.toString()))
        shareGithub(getString(R.string.text_hello_there, username.toString()))

        onBackListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeUserDetail(username: String) {
        viewModel.getDetailUser(username).observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Error -> {
                    false.showLoading()
                }
                is Resource.Loading -> {
                    true.showLoading()
                }
                is Resource.Success -> {
                    false.showLoading()
                    setDataUserDetail(response)
                }
            }
        }
    }

    private fun Boolean.showLoading() {
        if (this) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun openGithub(username: String) {
        binding.btnOpenOnGitHub.setOnClickListener {
            Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(username)
            }.also {
                startActivity(it)
            }
        }
    }

    private fun shareGithub(username: String) {
        binding.ivShare.setOnClickListener {
            val sub = getString(R.string.text_github_connection)
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, sub)
            intent.putExtra(Intent.EXTRA_TEXT, username)
            startActivity(Intent.createChooser(intent, getString(R.string.text_share_via)))
        }
    }

    private fun onBackListener() {
        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun setDataUserDetail(user: Resource<User>) {
        binding.apply {
            tvUsername.text = user.data?.login ?: "-"
            ivUser.loadImage(requireContext(), user.data?.avatar_url)
            tvTotalRepository.text = user.data?.public_repos.toString()
            tvTotalFollowers.text = user.data?.followers.toString()
            tvTotalFollowing.text = user.data?.following.toString()
            tvName.text = user.data?.name ?: "-"
            tvBio.text = user.data?.bio ?: "-"
            tvCompany.text = user.data?.company ?: "-"
            tvLocation.text = user.data?.location ?: "-"
            tvBlog.text = (if (user.data?.blog == "") "-" else user.data?.blog)
        }
    }
}