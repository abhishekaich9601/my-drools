package service;

import domain.Fare;
import domain.MyNestedFact;
import domain.MyOutput;
import domain.TaxiRide;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaxiFareCalculatorService {

    private final KieContainer kieContainer;
    private final KieContainer kieContainerForListTest;


    public Long calculateFare(TaxiRide taxiRide, Fare taxiFare) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rideFare", taxiFare);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();
        return taxiFare.getTotalFare();
    }

    public Boolean evaluatedListWorking() {
        KieSession kieSession = kieContainerForListTest.newKieSession();
        MyOutput myOutput = MyOutput.builder().isWorking(false).build();
        kieSession.setGlobal("myOutput", myOutput);
        List<String> myStringList = new ArrayList<>();
        myStringList.add("Test string");
        kieSession.insert(MyNestedFact.builder().childList(myStringList).build());
        kieSession.fireAllRules();
        kieSession.dispose();
        return myOutput.getIsWorking();
    }

}
