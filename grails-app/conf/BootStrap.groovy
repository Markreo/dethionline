import com.dethionline.auth.Role
import com.dethionline.auth.User
import com.dethionline.auth.UserRole

class BootStrap {

    def init = { servletContext ->
        def sysRole = null, role = null;
        Role.withTransaction {
            role = Role.findOrSaveWhere( authority: 'ROLE_USER', name: 'User')
            sysRole = Role.findOrSaveWhere(authority: 'ROLE_SYSTEM', name: 'System Administrator')
        }
        if (!User.list()) {
            def admin = new User( password: "123456", username: "sysadmin")
            admin.save(flush: true, failOnError: true)
            new UserRole(role: sysRole, user: admin).save(flush: true, failOnError: true)

            def user = new User(password: "123456", username: "user")
            user.save(flush: true, failOnError: true)
            new UserRole(role: role, user: user).save(flush: true, failOnError: true)
        }
    }
    def destroy = {
    }
}
