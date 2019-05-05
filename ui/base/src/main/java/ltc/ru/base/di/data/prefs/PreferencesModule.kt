package ltc.ru.base.di.data.prefs

import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import ltc.ru.base.app.ProjectApplication
import ltc.ru.base.di.ProjectScope

@Module
internal class PreferencesModule {

    @ProjectScope
    @Provides
    fun providePreferences(application: ProjectApplication): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }
}