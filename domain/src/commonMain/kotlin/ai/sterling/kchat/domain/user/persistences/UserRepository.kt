package ai.sterling.kchat.domain.user.persistences

import ai.sterling.kchat.domain.base.model.Outcome
import ai.sterling.kchat.domain.user.LoginUser
import ai.sterling.kchat.domain.user.SignUpUser
import ai.sterling.kchat.domain.user.models.AppUser
import ai.sterling.kchat.domain.user.models.ProfileDetails

interface UserRepository {
    suspend fun login(param: LoginUser.LoginData): Outcome<AppUser>
    suspend fun signup(param: SignUpUser.SignUpnData): Outcome<AppUser>
    suspend fun disconnect()

    suspend fun getUser(username: String): Outcome<AppUser>
    suspend fun getUser(id: Long): Outcome<AppUser>
    suspend fun getUserProfile(): Outcome<ProfileDetails>
    suspend fun updateProfileDetails(updated: ProfileDetails)
}
