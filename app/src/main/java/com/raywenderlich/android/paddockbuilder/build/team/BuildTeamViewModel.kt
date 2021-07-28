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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.android.paddockbuilder.repository.Driver
import com.raywenderlich.android.paddockbuilder.repository.DriversRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class TeamDetails(val teamName: String = "")

class BuildTeamViewModel(driverIds: Array<String>) : ViewModel() {

  private val _selectedDrivers = MutableStateFlow(emptyList<Driver>())
  private val _teamDetails = MutableStateFlow(TeamDetails())

  val selectedDrivers: StateFlow<List<Driver>>
    get() = _selectedDrivers

  val teamDetails: StateFlow<TeamDetails>
    get() = _teamDetails

  init {
    val (driverOneId, driverTwoId) = driverIds
    val drivers = listOfNotNull(
        DriversRepository.forId(driverOneId),
        DriversRepository.forId(driverTwoId),
    )
    _selectedDrivers.value = drivers
  }

  fun updateTeamName(newName: String) {
    val teamDetails = _teamDetails.value
    _teamDetails.value = teamDetails.copy(teamName = newName)
  }

  class Factory(private val driverIds: Array<String>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      @Suppress("UNCHECKED_CAST")
      return BuildTeamViewModel(driverIds) as T
    }
  }
}