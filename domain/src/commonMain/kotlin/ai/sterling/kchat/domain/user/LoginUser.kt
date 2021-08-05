package ai.sterling.kchat.domain.user

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.base.model.Outcome
import ai.sterling.kchat.domain.initialization.models.UserState
import ai.sterling.kchat.domain.user.models.AppUser
import ai.sterling.kchat.domain.user.models.UserEvent
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserRepository
import ai.sterling.kinject.Inject

class LoginUser @Inject constructor(
    private val repository: UserRepository,
    private val userEventsPersistence: UserEventsPersistence,
    private val getUserState: GetUserState
) : Usecase<LoginUser.LoginData, UserState> {

    data class LoginData(val username: String)

    override suspend fun invoke(param: LoginData): UserState {
        if (param.username.isNullOrEmpty()) {
            return UserState.Anonymous
        }
        return when (val outcome = repository.login(param)) {
            is Outcome.Success -> {
                val appUser = outcome.value
                if (appUser is AppUser.LoggedIn) {
                    userEventsPersistence.update(UserEvent.LoginChanged(appUser))
                    getUserState(appUser.id)
                } else {
                    UserState.Anonymous
                }
            }
            is Outcome.Error -> UserState.Anonymous
        }
    }
}
