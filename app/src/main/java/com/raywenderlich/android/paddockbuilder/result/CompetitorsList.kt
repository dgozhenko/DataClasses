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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.paddockbuilder.databinding.ItemCompetitorBinding
import com.raywenderlich.android.paddockbuilder.repository.Constructor
import com.raywenderlich.android.paddockbuilder.repository.Driver

data class ConstructorWithDrivers(
    val constructor: Constructor,
    val driverOne: Driver,
    val driverTwo: Driver,
)

class ConstructorViewHolder(
    private val binding: ItemCompetitorBinding
) : RecyclerView.ViewHolder(binding.root) {

  fun bind(constructorWithDrivers: ConstructorWithDrivers) {
    val (constructor, driverOne, driverTwo) = constructorWithDrivers
    binding.apply {
      constructorName.text = constructor.name
      driver1Name.text = driverOne.lastName
      driver1Number.text = driverOne.number.toString()
      driver2Name.text = driverTwo.lastName
      driver2Number.text = driverTwo.number.toString()
    }
  }
}

class ConstructorWithDriversDiffer : DiffUtil.ItemCallback<ConstructorWithDrivers>() {

  override fun areItemsTheSame(
      oldItem: ConstructorWithDrivers,
      newItem: ConstructorWithDrivers,
  ): Boolean {
    return oldItem.constructor.id == newItem.constructor.id &&
        oldItem.driverOne.id == newItem.driverOne.id &&
        oldItem.driverTwo.id == newItem.driverTwo.id
  }

  override fun areContentsTheSame(
      oldItem: ConstructorWithDrivers,
      newItem: ConstructorWithDrivers,
  ): Boolean {
    return oldItem == newItem
  }
}

class CompetitorsAdapter : ListAdapter<ConstructorWithDrivers, ConstructorViewHolder>(
    ConstructorWithDriversDiffer()
) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstructorViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = ItemCompetitorBinding.inflate(inflater, parent, false)
    return ConstructorViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ConstructorViewHolder, position: Int) {
    holder.bind(getItem(position))
  }

}