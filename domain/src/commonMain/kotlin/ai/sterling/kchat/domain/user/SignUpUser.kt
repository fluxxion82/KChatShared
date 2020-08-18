package ai.sterling.kchat.domain.user

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.initialization.models.UserState
import ai.sterling.kchat.domain.user.models.AppUser
import ai.sterling.kchat.domain.user.models.UserEvent
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserRepository
import ai.sterling.kchat.domain.user.persistences.UserPreferences
import ai.sterling.kinject.Inject
import kotlinx.coroutines.flow.first

class SignUpUser @Inject constructor(
    private val repository: UserRepository,
    private val userEventsPersistence: UserEventsPersistence,
    private val getUserState: GetUserState
) : Usecase<SignUpUser.SignUpnData, UserState> {

    data class SignUpnData(val username: String, val server: String, val port: Int)

    override suspend fun invoke(param: SignUpnData): UserState {
        val appUser = repository.signup(param).first()
        return if (appUser is AppUser.LoggedIn) {
            userEventsPersistence.update(UserEvent.LoginChanged(appUser))
            getUserState(appUser.id)
        } else {
            UserState.Anonymous
        }
    }
}
