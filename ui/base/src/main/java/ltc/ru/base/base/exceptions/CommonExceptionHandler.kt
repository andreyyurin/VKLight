package ltc.ru.base.base.exceptions

import kotlinx.coroutines.CoroutineExceptionHandler

class CommonExceptionHandler(private val onError:  ((Throwable, exceptionInfo: ExceptionInfo) -> Unit)? = null){
    private val exceptionInfoMapper = ExceptionInfoMapper()

    val coroutineHandler = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
        onError?.let{
            val exceptionInfo = exceptionInfoMapper.map(throwable)
            it.invoke(throwable, exceptionInfo)
        }
    }
}