import cz.actis.catalog.PathsService

class BootStrap {

    def init = { servletContext ->
        def pahtService = new PathsService()
    }
    def destroy = {
    }
}
