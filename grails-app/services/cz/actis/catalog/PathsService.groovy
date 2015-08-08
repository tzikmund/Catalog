package cz.actis.catalog

import grails.transaction.Transactional

@Transactional
class PathsService {
    def grailsApplication

    def String addSeparator(String path)
    {
        if(!path.endsWith(File.separator)) path += File.separator
        return path
    }

    def String getSystemRootPath()
    {
        String path = grailsApplication.config.grails.system.rootPath
        if(path == null || path.equals('')){
            throw new Exception('System root path is not configured!')
        } else {
            return addSeparator(path)
        }
    }

    def String getImageUploadPath()
    {
        String path = getSystemRootPath() + 'Users' + File.separator + 'zikyt' + File.separator  + 'IdeaProjects' + File.separator + 'Catalog' + File.separator + 'web-app' + File.separator + 'images'
        return addSeparator(path)
    }
}
