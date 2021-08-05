package ai.sterling.kchat.domain.user

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.base.model.Outcome
import ai.sterling.kchat.domain.initialization.models.UserState
import ai.sterling.kchat.domain.user.models.AppUser
import ai.sterling.kchat.domain.user.models.UserEvent
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserRepository
import ai.sterling.kinject.Inject

class GetUserState @Inject constructor(
    private val userRepository: UserRepository,
    private val userEvents: UserEventsPersistence
) : Usecase<Long, UserState> {

    override suspend fun invoke(param: Long): UserState {
        val user = when (val outcome = userRepository.getUser(param)) {
            is Outcome.Success -> {
                userEvents.update(UserEvent.LoginChanged(outcome.value))
                outcome.value
            }
            else -> AppUser.Anonymous
        }

        return when (user) {
            is AppUser.Anonymous -> UserState.Anonymous
            is AppUser.LoggedIn -> UserState.LoggedIn
        }
    }
}
