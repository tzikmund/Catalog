package cz.actis.catalog

class Category {
    String name
    String description
    static hasMany = [items: Item]
    static belongsTo = [Item]
    static constraints = {
        name nullable: false
        description nullable: true, maxSize: 255
    }

    String toString() {return  name}
}
