package com.dtit.tm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.dtit.tm.controller.order.ServiceApiDelegate;
import com.dtit.tm.controller.order.model.Service;
import com.dtit.tm.controller.order.model.ServiceCharacteristic;
import com.dtit.tm.controller.order.model.Value;
import com.dtit.tm.service.dto.IpAccessDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

public class DossController implements ServiceApiDelegate {
  private final Logger log = LoggerFactory.getLogger(ServiceApiDelegate.class);

  private final NativeWebRequest request;

  @Autowired
  private com.dtit.tm.service.OrderService orderService;

  public DossController(NativeWebRequest request) {
    this.request = request;
  }

  @Override
  public Optional<NativeWebRequest> getRequest() {
    return Optional.ofNullable(request);
  }

  @Override
  public ResponseEntity<Service> serviceCreate(String callbackId, String callbackCorrelationId, String callbackUrl, Service service) {
    final ServiceNameEnum servNameEnum = ServiceNameEnum.fromServiceName(service.getName());
    log.trace("servNameEnum :[{}]", servNameEnum);
    IpAccessDTO iad = createIPAccess(service);
    // dispatch
    ResponseEntity<Service> serviceResponse = null;
    if (servNameEnum != null) {
      // dispatch by Service.Name
      switch (servNameEnum) {
        case IPACCESSCONFIGOPERATIONAL:
            Boolean res=orderService.process(iad);
          serviceResponse =createRes(res);
          break;
        case GIGAIP_ACCESSCREDENTIALS:
          // serviceResponse = credentialsService.createCredentials(service);
          break;
        default:
          log.warn("Invalid Request :[service.name not known] value :[{}]", service.getName());
          break;
      }
    }

    // unbekannt ( null and unknown cases ) , dann error erzeugen
    if (serviceResponse == null) {
        serviceResponse= new ResponseEntity<Service>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    log.debug("leave #dispatch result :[{}]", serviceResponse);
    return serviceResponse;
    // return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }

  private ResponseEntity<Service> createRes(Boolean res) {
	return null;
}

private IpAccessDTO createIPAccess(Service service) {
    List<ServiceCharacteristic> lsc = service.getCharacteristic();
    Map<String, String> resultMap = new HashMap<>();

    if (lsc != null && !lsc.isEmpty()) {
      for (ServiceCharacteristic sc : lsc) {
        Value val = sc.getValue();
        if (val != null) {
          resultMap.put(sc.getName(), val.getValue());
        }
      }
    }
    return null;
  }
}
