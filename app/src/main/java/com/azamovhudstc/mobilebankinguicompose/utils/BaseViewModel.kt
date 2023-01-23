package com.azamovhudstc.mobilebankinguicompose.utils

import org.orbitmvi.orbit.ContainerHost


interface BaseViewModel<INTENT : Any, STATE : Any, SIDE_EFFECT : Any> :
    ContainerHost<STATE, SIDE_EFFECT> {

    fun onEventDispatcher(intent: INTENT)

}