package ltc.ru.base.base.exceptions

class ExceptionInfoMapper {
    fun map(exception: Throwable): ExceptionInfo {
        return when (exception) {
            else -> ExceptionInfo(-1)
        }
    }
}