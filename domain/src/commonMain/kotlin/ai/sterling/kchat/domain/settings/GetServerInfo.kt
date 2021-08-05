package ai.sterling.kchat.domain.settings

import ai.sterling.kchat.domain.base.Usecase
import ai.sterling.kchat.domain.settings.models.ServerInfo
import ai.sterling.kchat.domain.user.persistences.UserPreferences
import ai.sterling.kinject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow

class GetServerInfo @Inject constructor(
    private val repository: UserPreferences
) : Usecase<Unit, Flow<ServerInfo>> {

    override suspend fun invoke(param: Unit): Flow<ServerInfo> = channelFlow {
        send(repository.getServerInfo())
    }
}
