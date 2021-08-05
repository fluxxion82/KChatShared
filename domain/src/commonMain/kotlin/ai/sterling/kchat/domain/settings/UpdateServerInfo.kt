package ai.sterling.kchat.domain.settings

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.settings.models.ServerInfo
import ai.sterling.kchat.domain.user.persistences.UserPreferences
import ai.sterling.kinject.Inject

class UpdateServerInfo @Inject constructor(
    private val preferences: UserPreferences
) : Usecase<ServerInfo, Boolean> {

    override suspend fun invoke(param: ServerInfo): Boolean {
        if (param.username.isEmpty() || param.serverIP.isEmpty() || param.serverPort == 0) {
            return false
        }
        preferences.upsert(param)
        return true
    }
}
