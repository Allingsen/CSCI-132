package program4;

public class Customer {
    private String name;
    private String order;
    private long time_entered;
    private boolean is_prof;

    public Customer(String n, String o, Long t, boolean p) {
        this.name = n;
        this.order = o;
        this.time_entered = t;
        this.is_prof = p;
    }

    public String getCustomer() {
        return(this.name + " (" + this.order + ")");
    }
    
    public void changeStartTime(long st) {
        this.time_entered = st;
    }
    
    public String getName() {
        return this.name;
    }

    public long getStartTime() {
        return this.time_entered;
    }

    public String getOrder() {
        return this.order;
    }

    public boolean getProfStatus() {
        return this.is_prof;
    }
}
