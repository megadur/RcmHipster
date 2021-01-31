package com.dtit.tm.adapter.rdq;

import com.dtit.tm.client.api.rdq.SubscriberApi;

public interface IRdqAdapterConfig {
    SubscriberApi rdqClientApi();

    String getRdqAdapterBasePath();
   
}
