package cz.actis.catalog

class Category {
    String name
    String description

    static belongsTo = Item
    static hasMany = [items: Item]


    static constraints = {
        name nullable: false
        description nullable: true, maxSize: 255
    }

    String toString() {return  name}
}
