package ai.sterling.kchat.domain.connectivity.persistence

import ai.sterling.kchat.domain.connectivity.model.ConnectionState
import kotlinx.coroutines.flow.Flow

interface ConnectionMonitor {
    suspend fun getConnectionState(): Flow<ConnectionState>
}
