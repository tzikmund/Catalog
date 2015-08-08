package cz.actis.catalog

class Image {
    String fileName
    String fullPath
    byte[] file
    static hasMany = [items: Item]
    static belongsTo = [Item]

    static constraints = {
        fileName nullable: false
        fullPath nullable: false
        file nullable:false, maxSize:1073741824
    }

    String toString(){return fileName}
}
