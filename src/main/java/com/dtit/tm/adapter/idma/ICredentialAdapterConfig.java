package com.dtit.tm.adapter.idma;

import com.dtit.tm.adapter.idma.credentials.DefaultApi;

public interface ICredentialAdapterConfig {

    DefaultApi idmaCredetialClientApi();

    String getIdmaAdapterBasePath();
}
