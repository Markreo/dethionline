package com.dethionline

import com.dethionline.auth.User
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_SYSTEM','ROLE_USER'])
class BaseController {
    def springSecurityService
    User user

    def beforeInterceptor = {
        user = springSecurityService.currentUser as User
        println("user: ${user}")
        println("${request.xhr ? 'AJAX' : ''} ${request.method}  ${controllerName}.${actionName}:params:${params}")
        if (user) session.user = user
//        log.warn "URI: ${request.requestURI}"
        /*if (user != null){
            if (!user.isAccess(request.requestURI)) {
                flash.warn = "permission dined"
                redirect(controller: 'login', action: 'denied')
                return
            }
        }*/
    }
}
