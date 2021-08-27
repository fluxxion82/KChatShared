package ai.sterling.kchat.domain.app

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.user.persistences.UserRepository
import ai.sterling.kinject.Inject

class ExitApp @Inject constructor(
    private val userRepository: UserRepository
) : Usecase<Unit, Unit> {

    override suspend fun invoke(param: Unit) = userRepository.disconnect()
}
