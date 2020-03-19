package com.example.daggeradvance.ui.main.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.daggeradvance.R;
import com.example.daggeradvance.models.User;
import com.example.daggeradvance.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private ProfileViewModel viewModel;
    private TextView userDetails;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userDetails = view.findViewById(R.id.tv_user_details);
        viewModel = new ViewModelProvider(this, providerFactory).get(ProfileViewModel.class);
        subscribeObserver();
    }

    private void subscribeObserver() {
        viewModel.getUser().removeObservers(getViewLifecycleOwner());

        viewModel.getUser().observe(getViewLifecycleOwner(), userResource -> {
            if (userResource != null) {
                switch (userResource.status) {
                    case AUTHENTICATED:
                        setUserDetail(userResource.data);
                        break;

                    case NOT_AUTHENTICATED:

                        break;
                }
            }

        });
    }

    private void setUserDetail(User user) {

        userDetails.setText(user.getEmail());

    }


}
