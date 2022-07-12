package com.application.mydsu.di.main_activity

import com.application.mydsu.data.main_activity.MainActivityRepImpl
import com.application.mydsu.domain.main_activity.repository.MainActivityRep
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
//если в классе все методы абстрактные без реализации, этот класс можно превратить в interface
//abstract class MainActivityModule {
interface MainActivityModule{


    //Интерфейсы можно созадвать вот таким образом:
//    @Provides
//    fun provideMainActivityRep():MainActivityRep{
//        return MainActivityRepImpl()
//    }

    //но ПРЕДПОЧТИТЕЛЬНЕЕ будет с помощью Bind, в таком случае этот метод bind даже не вызовиться,
    //но при это даггер будет знать что для этого интерфейса нужно предоставить такую та реализацию
    //этот метод должен быть абстрактным, либо module нужно сделать interface если в методе нет реализации
    @Binds
//    abstract
    fun bindMainActivityRep(mainActivityRepImpl: MainActivityRepImpl):MainActivityRep
}