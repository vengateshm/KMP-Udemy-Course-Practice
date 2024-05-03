package dev.vengateshm.kmpudemycourseapp.sources.presentation

import dev.vengateshm.kmpudemycourseapp.BaseViewModel
import dev.vengateshm.kmpudemycourseapp.sources.domain.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SourcesViewModel(private val sourcesUseCase: SourcesUseCase) : BaseViewModel() {
    private val _sourcesState = MutableStateFlow(SourceState(loading = true))
    val sourcesState: StateFlow<SourceState> get() = _sourcesState

    init {
        getSources()
    }

    fun getSources() {
        scope.launch {
            _sourcesState.emit(SourceState(loading = true, sources = sourcesState.value.sources))
            val fetchedSources = sourcesUseCase.getSources()
            _sourcesState.emit(SourceState(sources = fetchedSources))
        }
    }
}