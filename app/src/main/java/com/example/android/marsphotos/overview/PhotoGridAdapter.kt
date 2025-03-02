/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter:
    ListAdapter<MarsPhoto, PhotoGridAdapter.MarsPhotosViewHolder>(DiffCallback){

        class MarsPhotosViewHolder(private var binding: GridViewItemBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(marsPhoto: MarsPhoto){
                    binding.photo= marsPhoto
                    binding.executePendingBindings()
                }

        }

    companion object DiffCallback: DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            //checks if ids are the same
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotosViewHolder {
        return MarsPhotosViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: MarsPhotosViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }


}


