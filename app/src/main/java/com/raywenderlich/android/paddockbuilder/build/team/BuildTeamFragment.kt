/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.paddockbuilder.build.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.android.paddockbuilder.R
import com.raywenderlich.android.paddockbuilder.databinding.FragmentBuildTeamBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BuildTeamFragment : Fragment() {

  private var _binding: FragmentBuildTeamBinding? = null
  private val binding: FragmentBuildTeamBinding
    get() = _binding!!

  private val args by navArgs<BuildTeamFragmentArgs>()
  private val viewModel by viewModels<BuildTeamViewModel> {
    BuildTeamViewModel.Factory(args.driverIds)
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?,
  ): View {
    _binding = FragmentBuildTeamBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.toolbar.setupWithNavController(findNavController())

    val selectedDriversAdapter = SelectedDriversAdapter()

    binding.driversList.apply {
      layoutManager = GridLayoutManager(context, 2)
      adapter = selectedDriversAdapter
      setHasFixedSize(true)
    }

    binding.teamNameField.addTextChangedListener { text ->
      binding.apply {
        if (text.isNullOrBlank()) {
          teamNameContainer.error = getString(R.string.errorMessageTeamName)
          saveButton.hide()
        } else {
          teamNameContainer.error = null
          saveButton.show()
        }
        viewModel.updateTeamName(text?.toString() ?: "")
      }
    }

    binding.saveButton.setOnClickListener { goToBuildResult() }

    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.selectedDrivers.collect { drivers ->
        selectedDriversAdapter.submitList(drivers)
      }
    }
  }

  private fun goToBuildResult() {
    findNavController().navigate(BuildTeamFragmentDirections.goToBuildResult(
        viewModel.teamDetails.value.teamName,
        args.driverIds,
    ))
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}