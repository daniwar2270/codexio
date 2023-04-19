import java.util.ArrayList;
import java.util.List;

class Shop1 {
    private static Shop1 instance;


    public static Shop1 getInstance() {
        if (instance == null) {

                if (instance == null) {
                    instance = new Shop1();
                }

        }

        return instance;
    }


    private List<Worker> workers = new ArrayList<>();


    public void addWorker(Worker worker) {
        this.workers.add(worker);
    }

    public double getTurnover() {
        var turnOver = 0.0;
        for (var worker : this.workers) {

            if (worker instanceof SalesConsultant) {
                turnOver += ((SalesConsultant)worker).getMoney();
            }

            if (worker instanceof MarketingSpecialist) {
                turnOver += ((MarketingSpecialist)worker).getBudget();
            }
        }

        return turnOver;
    }
}


abstract class Worker {
}

class SalesConsultant extends Worker {

    private Shop1 workingShop;
    private double earnedMoney;

    public SalesConsultant() {
        this.workingShop = Shop1.getInstance();
        this.workingShop.addWorker(this);
    }

    public void sellProduct(double price) {
        this.earnedMoney += Math.max(price, 0);
    }

    public double getMoney() {
        return this.earnedMoney;
    }
}

class MarketingSpecialist extends Worker {
    private Shop1 workingShop;
    private double budget = 5000.00;

    public MarketingSpecialist() {
        this.workingShop = Shop1.getInstance();
        this.workingShop.addWorker(this);
    }

    public void spendMoney(double marketingCampaignCost) {
        this.budget -= Math.max(marketingCampaignCost, 0);

        if (this.budget >= marketingCampaignCost) {
            this.budget -= marketingCampaignCost;
        } else {

            this.budget = 0;
        }
    }

    public double getBudget() {
        return this.budget;
    }
}
