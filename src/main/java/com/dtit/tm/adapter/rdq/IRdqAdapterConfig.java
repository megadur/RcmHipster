package com.dtit.tm.adapter.rdq;

import com.dtit.tm.adapter.rdq.subscriber.SubscriberApi;

public interface IRdqAdapterConfig {
    SubscriberApi rdqClientApi();

    String getRdqAdapterBasePath();

}
