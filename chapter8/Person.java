package chapter8;

abstract public class Person {

    protected String name;
    protected String id;
    protected String addr;
    protected String email;

    protected Person (String name, String id, String addr, String email) {
        this.name = name;
        this.id = id;
        this.addr = addr;
        this.email = email;

    }

    abstract public String getType();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    



}
