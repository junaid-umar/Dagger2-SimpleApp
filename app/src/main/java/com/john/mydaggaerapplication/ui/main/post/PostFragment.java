package com.example.daggeradvance.ui.main.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daggeradvance.R;
import com.example.daggeradvance.util.VerticalSpaceItemDecorator;
import com.example.daggeradvance.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostFragment extends DaggerFragment {
    private static final String TAG = "PostFragment";


    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    PostsRecyclerAdapter adapter;

    PostViewModel viewModel;

    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);

        viewModel = new ViewModelProvider(this, providerFactory).get(PostViewModel.class);
        viewModel.getPosts();

        initRecyclerView();
        subscribeObserver();
    }

    private void subscribeObserver() {
        viewModel.postData.observe(getViewLifecycleOwner(), listPostResource -> {
            if (listPostResource != null) {
                switch (listPostResource.status) {
                    case LOADING:

                        break;
                    case SUCCESS:
                        adapter.setPosts(listPostResource.data);
                        break;

                    case ERROR:

                        break;
                }
            }
        });
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new VerticalSpaceItemDecorator(10));
        recyclerView.setAdapter(adapter);

    }
}
