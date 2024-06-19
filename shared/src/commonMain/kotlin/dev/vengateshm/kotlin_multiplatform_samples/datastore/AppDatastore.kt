package dev.vengateshm.kotlin_multiplatform_samples.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val IS_DARK_THEME = booleanPreferencesKey("is_dark_theme")

class AppDatastore(private val dataStore: DataStore<Preferences>) {
    suspend fun setIsDarkTheme(value: Boolean) =
        dataStore.edit { mutablePreferences ->
            mutablePreferences[IS_DARK_THEME] = value
        }

    fun isDarkTheme(): Flow<Boolean> =
        dataStore.data.map { preferences ->
            preferences[IS_DARK_THEME] ?: false
        }
}