package cz.actis.catalog

class User {
    String loginName
    String pwd
    String role//admin,customer

    String name
    String address
    String city
    String zipCode
    static constraints = {
        loginName nullable: false
        pwd nullable: false
        name nullable: false
        address nullable: false
        city nullable: false
        zipCode nullable: false
    }
}
