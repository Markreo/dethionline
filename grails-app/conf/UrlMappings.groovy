class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'home', action: 'index')
        "/home" (controller: 'home', action: 'dashbroad')
        "500"(view:'/error')
	}
}
