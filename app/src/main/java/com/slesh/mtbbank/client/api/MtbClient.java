package com.slesh.mtbbank.client.api;


import com.slesh.mtbbank.client.dto.RateInfo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MtbClient {

    @GET(value = "/currxml.php?ver=2")
    Call<RateInfo> fetchLastRateInfo();

}
