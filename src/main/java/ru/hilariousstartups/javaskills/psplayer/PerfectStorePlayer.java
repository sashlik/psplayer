package ru.hilariousstartups.javaskills.psplayer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.ApiClient;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.ApiException;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.api.PerfectStoreEndpointApi;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PerfectStorePlayer implements ApplicationListener<ApplicationReadyEvent> {

    private String serverUrl;

    public PerfectStorePlayer(@Value("${perfectstore.url:http://localhost:8080}") String serverUrl) {
        this.serverUrl = serverUrl;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(serverUrl);

        PerfectStoreEndpointApi psApiClient = new PerfectStoreEndpointApi(apiClient);
        try {
            int cnt = 0;
            CurrentWorldResponse currentWorldResponse = null;
            do {
                if (currentWorldResponse == null) {
                    currentWorldResponse = psApiClient.loadWorld();
                }

                CurrentTickRequest request = new CurrentTickRequest();

                 List<HireEmployeeCommand> hireEmployeeCommands = new ArrayList<>();
                request.setHireEmployeeCommands(hireEmployeeCommands);
                currentWorldResponse.getCheckoutLines().stream().filter(line -> line.getEmployeeId() == null).forEach(line -> {
                    HireEmployeeCommand hireEmployeeCommand = new HireEmployeeCommand();
                    hireEmployeeCommand.setCheckoutLineId(line.getId());
                    hireEmployeeCommand.setExperience(HireEmployeeCommand.ExperienceEnum.SENIOR);
                    hireEmployeeCommands.add(hireEmployeeCommand);
                });
                request.setHireEmployeeCommands(hireEmployeeCommands);

                ArrayList<BuyStockCommand> buyStockCommands = new ArrayList<>();
                request.setBuyStockCommands(buyStockCommands);

                ArrayList<PutOnRackCellCommand> putOnRackCellCommands = new ArrayList<>();
                request.setPutOnRackCellCommands(putOnRackCellCommands);

                List<Product> stock = currentWorldResponse.getStock();
                List<RackCell> rackCells = currentWorldResponse.getRackCells();
                currentWorldResponse.getRackCells().stream().filter(rack -> rack.getProductId() == null || rack.getProductQuantity().equals(0)).forEach(rack -> {
                    Product producttoPutOnRack = null;
                    if (rack.getProductId() == null) {
                        List<Integer> productsOnRack = rackCells.stream().filter(r -> r.getProductId() != null).map(RackCell::getProductId).collect(Collectors.toList());
                        productsOnRack.addAll(putOnRackCellCommands.stream().map(c -> c.getProductId()).collect(Collectors.toList()));
                        producttoPutOnRack = stock.stream().filter(product -> !productsOnRack.contains(product.getId())).findFirst().orElse(null);
                    }
                    else {
                        producttoPutOnRack = stock.stream().filter(product -> product.getId().equals(rack.getProductId())).findFirst().orElse(null);
                    }

                    Integer productQuantity = rack.getProductQuantity();
                    if (productQuantity == null) {
                        productQuantity = 0;
                    }


                    Integer orderQuantity = rack.getCapacity() - productQuantity;
                    if (producttoPutOnRack.getInStock() < orderQuantity) {
                        BuyStockCommand command = new BuyStockCommand();
                        command.setProductId(producttoPutOnRack.getId());
                        command.setQuantity(100);
                        buyStockCommands.add(command);
                    }

                    PutOnRackCellCommand command = new PutOnRackCellCommand();
                    command.setProductId(producttoPutOnRack.getId());
                    command.setRackCellId(rack.getId());
                    command.setProductQuantity(orderQuantity);
                    if (producttoPutOnRack.getSellPrice() == null) {
                        command.setSellPrice(producttoPutOnRack.getStockPrice() + 10);
                    }
                    putOnRackCellCommands.add(command);

                });

                currentWorldResponse = psApiClient.tick(request);

            }
            while (!currentWorldResponse.isGameOver());

            log.info("Я заработал " + (currentWorldResponse.getIncome() - currentWorldResponse.getSalaryCosts() - currentWorldResponse.getStockCosts()) + "руб.");

        } catch (ApiException e) {
            log.error(e.getMessage(), e);
        }

    }

}
