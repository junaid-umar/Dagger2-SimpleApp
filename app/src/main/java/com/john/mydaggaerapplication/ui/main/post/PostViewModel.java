package com.example.daggeradvance.ui.main.post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;

import com.example.daggeradvance.models.Post;
import com.example.daggeradvance.network.post.PostApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {


    private PostApi postApi;

    MediatorLiveData<PostResource<List<Post>>> postData = new MediatorLiveData<>();

    @Inject
    public PostViewModel(PostApi postApi) {
        this.postApi = postApi;
    }

    public void getPosts() {
        if (postData != null) {
            postData = new MediatorLiveData<>();

            postData.setValue(PostResource.loading(null));

            final LiveData<PostResource<List<Post>>> source = LiveDataReactiveStreams
                    .fromPublisher(postApi.getPosts()
                            .onErrorReturn(throwable -> {
                                Post post = new Post();
                                post.setId(-1);
                                ArrayList<Post> postArrayList = new ArrayList<>();
                                postArrayList.add(post);
                                return postArrayList;
                            })
                            .map((Function<List<Post>, PostResource<List<Post>>>) posts -> {
                                if (posts.size() > 0) {
                                    if (posts.get(0).getId() == -1) {
                                        return PostResource.error(null, "no data found");

                                    }

                                }
                                return PostResource.success(posts);


                            })
                            .subscribeOn(Schedulers.io()
                            ));

            postData.addSource(source, listPostResource -> {
                postData.removeSource(source);

                postData.setValue(listPostResource);
            });
        }

    }

    public MediatorLiveData<PostResource<List<Post>>> getPostData() {
        return postData;
    }
}
