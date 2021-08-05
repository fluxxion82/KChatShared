package ai.sterling.kchat.domain.user

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.base.model.Outcome
import ai.sterling.kchat.domain.user.models.ChangedDetail
import ai.sterling.kchat.domain.user.models.UserEvent
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserRepository
import ai.sterling.kinject.Inject

class UpdateProfileDetails @Inject constructor(
    private val repository: UserRepository,
    private val userEvents: UserEventsPersistence
) : Usecase<ChangedDetail, Unit> {

    override suspend fun invoke(param: ChangedDetail) {
        when (val outcome = repository.getUserProfile()) {
            is Outcome.Success -> {
                val profile = outcome.value
                val updated = when (param) {
                    is ChangedDetail.Username -> profile.copy(userName = param.value)
                }

                repository.updateProfileDetails(updated)
                userEvents.update(UserEvent.DetailsChanged(updated))
            }
        }
    }
}
