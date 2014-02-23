package com.insightfullogic.honest_profiler.javafx.profile;

import com.insightfullogic.honest_profiler.collector.Profile;
import com.insightfullogic.honest_profiler.collector.ProfileListener;
import com.insightfullogic.honest_profiler.util.Listeners;
import org.picocontainer.injectors.ProviderAdapter;

public class ProfileListenerProvider extends ProviderAdapter {

    public ProfileListener provide(FlatViewModel flatModel, TreeViewModel treeModel) {
        Listeners<Profile> listener = new Listeners<Profile>()
                .of(flatModel::accept)
                .of(treeModel::accept);

        return listener::accept;
    }

}