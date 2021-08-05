package ai.sterling.kchat.domain.user

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.chat.repository.ChatRepository
import ai.sterling.kchat.domain.user.models.AppUser
import ai.sterling.kchat.domain.user.models.UserEvent
import ai.sterling.kchat.domain.user.persistences.UserEventsPersistence
import ai.sterling.kchat.domain.user.persistences.UserPreferences
import ai.sterling.kinject.Inject

class LogoutUser @Inject constructor(
    private val chatRepository: ChatRepository,
    private val userPreferences: UserPreferences,
    private val userEvents: UserEventsPersistence
) : Usecase<Unit, Unit> {

    override suspend fun invoke(param: Unit) {
        // val userSettingList = databaseRef.get()?.selectAllUnSyncedUserSettings()
        //            val token = sharedPrefs.get()?.getString(DataConst.USER_SETTING_ACCESS_TOKEN, null)
        //            if (token != null) {
        //                apiClient.get()?.updateUserSettings(token, userSettingList!!, null)
        //            }

        chatRepository.deleteAllChatMessages()
        userEvents.update(UserEvent.LoginChanged(AppUser.Anonymous))
        userPreferences.clear()
    }
}
