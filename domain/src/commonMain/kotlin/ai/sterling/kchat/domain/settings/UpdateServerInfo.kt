package ai.sterling.kchat.domain.settings

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.settings.models.ServerInfo
import ai.sterling.kchat.domain.user.persistences.UserPreferences
import ai.sterling.kinject.Inject

class UpdateServerInfo @Inject constructor(
    private val preferences: UserPreferences
) : Usecase<ServerInfo, Unit> {

    override suspend fun invoke(param: ServerInfo) {
        if (param.username.isEmpty() || param.serverIP.isEmpty() || param.serverPort == 0) {
            return
        }
        preferences.upsert(param)
    }
}
