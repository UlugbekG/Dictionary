package gh.code.dictionary.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class Event<T>(value: T) {
    private var _value: T? = value
    fun get(): T? = _value.also { _value = null }
}

fun <T> MutableLiveData<T>.asLiveData(): LiveData<T> = this

typealias MutableLiveEvent<T> = MutableLiveData<Event<T>>
typealias LiveEvent<T> = LiveData<Event<T>>
typealias EventListener<T> = (T) -> Unit

fun <T> MutableLiveEvent<T>.publishEvent(value: T) {
    this.value = Event(value)
}

fun <T> LiveEvent<T>.observeEvent(lifecycleOwner: LifecycleOwner, listener: EventListener<T>) {
    this.observe(lifecycleOwner) {
        it?.get()?.let { value ->
            listener(value)
        }
    }
}

typealias MutableUnitLiveEvent = MutableLiveEvent<Unit>
typealias UnitLiveEvent = LiveEvent<Unit>
typealias UnitEventListener = () -> Unit

fun MutableUnitLiveEvent.publishEvent() = publishEvent(Unit)

