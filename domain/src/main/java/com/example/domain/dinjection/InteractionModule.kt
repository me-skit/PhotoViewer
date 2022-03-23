package com.example.domain.dinjection

import com.example.domain.interaction.GetPhotoListUseCase
import org.koin.dsl.module

val interactionModule = module {
    single { GetPhotoListUseCase(get()) }
}