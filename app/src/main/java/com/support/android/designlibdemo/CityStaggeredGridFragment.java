/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.support.android.designlibdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class CityStaggeredGridFragment extends Fragment {

    private static final int STAGGERED_GRID_SPAN = 2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_city_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(STAGGERED_GRID_SPAN, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new StaggeredRecyclerAdapter(addFakeData()));
    }


    private List<String> addFakeData() {
        List<String> list = new ArrayList<>();
        int count = 6;
        for (int i = 0; i < 30; i++) {
            if (i % count == 0) {
                list.add(i, getResources().getString(R.string.chicago_text));
            } else if (i % count == 1) {
                list.add(i, getResources().getString(R.string.lasvegas_text));
            } else if (i % count == 2) {
                list.add(i, getResources().getString(R.string.neworleans_text));
            } else if (i % count == 3) {
                list.add(i, getResources().getString(R.string.newyork_text));
            } else if (i % count == 4) {
                list.add(i, getResources().getString(R.string.philadelphia_text));
            } else if (i % count == 5) {
                list.add(i, getResources().getString(R.string.sanfrancisco_text));
            }
        }
        return list;
    }
}
