package com.yandey.githubapp.ui.follows.following

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yandey.core.data.Resource
import com.yandey.core.domain.model.User
import com.yandey.core.ui.UserAdapter
import com.yandey.core.utils.Constants.EXTRA_USER
import com.yandey.githubapp.R
import com.yandey.githubapp.databinding.FragmentFollowsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowingFragment : Fragment(), UserAdapter.ItemClickListener {

    private var _binding: FragmentFollowsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FollowingViewModel by viewModels()

    private lateinit var userAdapter: UserAdapter

    private var username: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        username = requireActivity().intent.getStringExtra(EXTRA_USER)

        initRecyclerView()
        viewModel.setFollowing(username.toString())
        observeUserFollowing()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(user: User) {
        val bundle = Bundle().apply {
            requireActivity().intent.putExtra(
                EXTRA_USER,
                user.login
            )
        }
        findNavController().navigate(
            R.id.action_detailFragment_self, bundle
        )
    }

    private fun initRecyclerView() {
        binding.rvUser.apply {
            userAdapter = UserAdapter(requireContext(), this@FollowingFragment)
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeUserFollowing() {
        viewModel.following.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Error -> {
                    false.showLoading()
                    true.showEmpty()
                }
                is Resource.Loading -> {
                    true.showLoading()
                }
                is Resource.Success -> {
                    false.showLoading()
                    false.showEmpty()
                    userAdapter.submitList(response.data)
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

    private fun Boolean.showEmpty() {
        if (this) {
            binding.tvMessage.text = resources.getString(R.string.text_no_following, username)
        } else {
            binding.tvMessage.visibility = View.INVISIBLE
        }
    }
}