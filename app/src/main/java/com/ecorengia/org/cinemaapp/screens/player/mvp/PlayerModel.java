package com.ecorengia.org.cinemaapp.screens.player.mvp;

import android.support.annotation.NonNull;

import com.ecorengia.org.cinemaapp.mvp.CinemaBaseModel;
import com.ecorengia.org.cinemaapp.networking.api.CinemaApi;
import com.ecorengia.org.cinemaapp.screens.player.PlayerScreen;

public class PlayerModel extends CinemaBaseModel<PlayerScreen> {
    public PlayerModel(@NonNull final PlayerScreen screen, @NonNull CinemaApi cinemaApi) {
        super(screen, cinemaApi);
    }
}
