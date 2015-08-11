package cz.actis.catalog

class Item {

    String brand
    String name
    String description
    double price

    static hasMany = [categories: Category]
    static hasOne = [image: Image]
    //Image image

    static constraints = {
        brand nullable: false
        name nullable: false
        description nullable: false, maxSize: 255
        price min: 0d
        //categories nullable: false
    }
}
