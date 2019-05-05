package ltc.ru.base.di.data

import dagger.Module
import ltc.ru.base.di.data.prefs.PreferencesModule
import ltc.ru.base.di.data.rest.RestModule

@Module(includes = [RestModule::class, PreferencesModule::class])
internal class DataModule