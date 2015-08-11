package cz.actis.catalog

class Image {
    String fileName
    String fullPath
    byte[] file
    static belongsTo = [item: Item]
    //Item item

    static constraints = {
        fileName nullable: false
        fullPath nullable: false
        file nullable:false, maxSize:1073741824
        item nullable: true
    }

    String toString(){return fileName}
}
