package schemax.brandix_charts;

/**
 * Created by srinivas on 03/01/18.
 */

public class Normal {
    String percentage,id;
    Normal(String id,String percentage){
        this.id =id;
        this.percentage = percentage;
    }

    public String getPercentage() {
        return percentage;
    }

    public String getId() {
        return id;
    }
}
