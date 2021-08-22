package ru.hilariousstartups.javaskills.psplayer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.ApiClient;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.ApiException;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.api.PerfectStoreEndpointApi;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.CurrentTickRequest;
import ru.hilariousstartups.javaskills.psplayer.swagger_codegen.model.CurrentWorldResponse;

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
            CurrentWorldResponse currentWorldResponse;
            do {

                currentWorldResponse = psApiClient.tick(new CurrentTickRequest());
                if (cnt++ % 100 == 0) {
                    log.info("Прошел " + cnt + " тик");
                }
            }
            while (!currentWorldResponse.isGameOver());

            log.info("Я заработал " + (currentWorldResponse.getIncome() - currentWorldResponse.getSalaryCosts() - currentWorldResponse.getStockCosts()) + "руб.");

        } catch (ApiException e) {
            log.error(e.getMessage(), e);
        }

    }

}
