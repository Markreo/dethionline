package com.dethionline

import grails.plugin.springsecurity.annotation.Secured

class HomeController extends BaseController{
    @Secured(['ROLE_SYSTEM'])
    def index() {
        println(springSecurityService.isLoggedIn())
        if (springSecurityService.isLoggedIn()) {
            redirect(action: 'dashbroad')
        } else {
            render(view: '/login/auth')
        }
    }

    def dashbroad() {
        render 'this is home page'
    }
}
