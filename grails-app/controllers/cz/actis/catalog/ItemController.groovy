package cz.actis.catalog



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ItemController {
    def pathsService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    /*def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Item.list(params), model:[itemInstanceCount: Item.count()]
    }*/

    def index = {
        def items = Item.list(sort: "brand", order: "asc")
        def categories = Category.list(sort: "name", order: "asc")
        return [items: items, categories: categories]
    }

    def show(Item itemInstance) {
        respond itemInstance
    }

    def create() {
        respond new Item(params)
    }

    @Transactional
    def save(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        def file = request.getFile('file')
        String fn = file.originalFilename

        if(fn.empty || fn.equals("")) {
            flash.message = "Image cannot be empty."
            respond itemInstance.errors, view:'create'
            return

        } else if(!fn.endsWith(".jpg")){
            flash.message = "Image must be .jpg."
            respond itemInstance.errors, view:'create'
            return

        } else {
            def img = new Image()
            img.fileName = file.originalFilename
            img.fullPath = pathsService.getImageUploadPath() + file.originalFilename
            img.file = file.getBytes()
            //nasetujes vazby ze strany image
            itemInstance.image = img
            img.item = itemInstance
            img.save(failOnError: true)


            //TODO tohle musi byt az tady, je to kontrola, ze ten objekt Item ma vsechny potrebne parametry pred ulozenim,,, puvodne to bylo pred tim vytvorenim obrazku..
            if (itemInstance.hasErrors()) {
                log.error('Error in hasErrors')
                itemInstance.errors.allErrors.each {
                    log.error(it.toString())
                }
                respond itemInstance.errors, view:'create'
                return
            }

            //ulozis hlavni entitu
            itemInstance.save flush: true, failOnError: true

            //nasetujes i vazby ze strany itemu
            img.save(failOnError: true)


            //file.transferTo(new File(img.fullPath))
//            TOTO co je tohle?? controler by se instanciovat nemel... na entite jenom zavolas save, viz radek 55
//            def ic = new ImageController()
//            ic.save(img)
        }


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'item.label', default: 'Item'), itemInstance.id])
                //redirect itemInstance
            }
            '*' { respond itemInstance, [status: CREATED] }
        }
    }

    def edit(Item itemInstance) {
        respond itemInstance
    }

    @Transactional
    def update(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'edit'
            return
        }

        itemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
                redirect itemInstance
            }
            '*'{ respond itemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Item itemInstance) {

        if (itemInstance == null) {
            notFound()
            return
        }

        itemInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
