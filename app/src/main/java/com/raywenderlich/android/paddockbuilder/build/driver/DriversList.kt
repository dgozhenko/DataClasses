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

package com.raywenderlich.android.paddockbuilder.build.driver

import android.annotation.SuppressLint
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.paddockbuilder.R
import com.raywenderlich.android.paddockbuilder.databinding.ItemDriverBinding
import com.raywenderlich.android.paddockbuilder.repository.Constructor
import com.raywenderlich.android.paddockbuilder.repository.ConstructorsRepository
import com.raywenderlich.android.paddockbuilder.repository.Driver

data class DriverWithSelection(
  val driver: Driver,
  val isSelected: Boolean
)

/**
 * ViewHolder for driver-items in a list.
 */
@SuppressLint("SetTextI18n")
class DriverViewHolder(
    private val binding: ItemDriverBinding,
    private val onDriverClicked: (Driver) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(driver: Driver, team: Constructor, isSelected: Boolean) {
    binding.apply {
      driverName.text = "${driver.firstName} ${driver.lastName}"
      driverTeamName.text = team.name
      driverNumber.text = driver.number.toString()
      driverContainer.apply {
        setBackgroundColor(getBackgroundColor(isSelected))
        setOnClickListener{
          onDriverClicked(driver)
        }
      }

    }
  }

  private fun getBackgroundColor(isSelected: Boolean): Int {
    if (isSelected) {
      return ContextCompat.getColor(binding.root.context, R.color.colorSelectedTint)
    }

    val theme = binding.root.context.theme
    val typedValue = TypedValue().apply {
      theme.resolveAttribute(R.attr.colorSurface, this, true)
    }
    return typedValue.data
  }
}

@SuppressLint("DiffUtilEquals")
class DriverDiffer : DiffUtil.ItemCallback<DriverWithSelection>() {

  override fun areItemsTheSame(
      oldItem: DriverWithSelection,
      newItem: DriverWithSelection,
  ): Boolean {
    return oldItem.driver.id == newItem.driver.id
  }

  override fun areContentsTheSame(
      oldItem: DriverWithSelection,
      newItem: DriverWithSelection,
  ): Boolean {
    return oldItem == newItem
  }
}

/**
 * An adapter for the driver's list
 */
class DriversListAdapter(
    private val onDriverClicked: (Driver) -> Unit
) : ListAdapter<DriverWithSelection, DriverViewHolder>(DriverDiffer()) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ItemDriverBinding.inflate(inflater, parent, false)
    return DriverViewHolder(binding, onDriverClicked)
  }

  override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
    val (driver, isSelected) = getItem(position)
    val team = ConstructorsRepository.forId(driver.currentTeamId)
    holder.bind(driver, team, isSelected)
  }

}