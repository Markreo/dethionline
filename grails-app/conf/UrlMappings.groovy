class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: 'home', action: 'index')
        "/dashboard" (controller: 'home', action: 'dashboard')
        "500"(view:'/error')
	}
}
