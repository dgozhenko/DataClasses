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

package com.raywenderlich.android.paddockbuilder.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.raywenderlich.android.paddockbuilder.build.team.SelectedDriversAdapter
import com.raywenderlich.android.paddockbuilder.databinding.FragmentBuildResultBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BuildResultFragment : Fragment() {

  private var _binding: FragmentBuildResultBinding? = null
  private val binding: FragmentBuildResultBinding
    get() = _binding!!

  private val args by navArgs<BuildResultFragmentArgs>()
  private val viewModel by viewModels<BuildResultViewModel> {
    BuildResultViewModel.Factory(args.driverIds)
  }

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?,
  ): View {
    _binding = FragmentBuildResultBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.toolbar.setupWithNavController(findNavController())

    val competitorsAdapter = CompetitorsAdapter()
    val selectedDriversAdapter = SelectedDriversAdapter()

    binding.teamName.text = args.teamName

    binding.driversList.apply {
      adapter = selectedDriversAdapter
      layoutManager = GridLayoutManager(context, 2)
    }

    binding.competitorsList.apply {
      adapter = competitorsAdapter
      layoutManager = LinearLayoutManager(context)
    }

    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.selectedDrivers.collect { selectedDrivers ->
        selectedDriversAdapter.submitList(selectedDrivers)
      }
    }

    viewLifecycleOwner.lifecycleScope.launch {
      viewModel.competitors.collect { competitors ->
        competitorsAdapter.submitList(competitors)
      }
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}