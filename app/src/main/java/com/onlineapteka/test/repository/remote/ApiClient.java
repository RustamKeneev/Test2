package com.onlineapteka.test.repository.remote;

import com.onlineapteka.test.model.DeviceSubSecondModel;
import com.onlineapteka.test.model.DeviceSubcategory;
import com.onlineapteka.test.repository.IRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ApiClient implements IApiClient {
    private final String BASE_URL = "http://81.90.180.55";

    private OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .addInterceptor(provideLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    private HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        return httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL + "/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

    OnlinePharmacyNetworkClient client = retrofit.create(OnlinePharmacyNetworkClient.class);

    public String getBASE_URL() {
        return BASE_URL;
    }

    @Override
    public void getDeviceCategories(IRepository.DeviceCategoryCallback deviceCategoryCallback) {

    }

    @Override
    public void getDeviceSubcategories(String deviceCategoryId, IRepository.CallBack<List<DeviceSubcategory>> callBack) {
        Call<List<DeviceSubcategory>> call = client.getDeviceSubCategories(deviceCategoryId);
        call.enqueue(new Callback<List<DeviceSubcategory>>() {
            @Override
            public void onResponse(Call<List<DeviceSubcategory>> call, Response<List<DeviceSubcategory>> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        callBack.onSuccess(response.body());
                    }else {
                        callBack.onFailure(new Exception("Response is empty "));
                    }
                }else {
                    callBack.onFailure(new Exception("Response code getSubCategories " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<DeviceSubcategory>> call, Throwable t) {
                callBack.onFailure(new Exception(t));
            }
        });
    }

    @Override
    public void getDeviceSubSecondcategories(String deviceCategoryId, IRepository.CallBack<List<DeviceSubSecondModel>> callBack) {
        Call<List<DeviceSubSecondModel>> call = client.getDeviceSubSecondCategories(deviceCategoryId);
        call.enqueue(new Callback<List<DeviceSubSecondModel>>() {
            @Override
            public void onResponse(Call<List<DeviceSubSecondModel>> call, Response<List<DeviceSubSecondModel>> response) {
                if (response.isSuccessful()){
                    if (response.body() !=null){
                        callBack.onSuccess(response.body());
                    }else {
                        callBack.onFailure(new Exception("Response is empty "));
                    }
                }else {
                    callBack.onFailure(new Exception("Response code getSubCategories " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<DeviceSubSecondModel>> call, Throwable t) {
                callBack.onFailure(new Exception(t));
            }
        });
    }

    private interface OnlinePharmacyNetworkClient {
        @GET("/device/api/sub-category/{category_id}/")
        Call<List<DeviceSubcategory>> getDeviceSubCategories
                (@Path("category_id") String deviceCategoryId);

        @GET("/device/api/deivce/{sub_category_id}/")
        Call<List<DeviceSubSecondModel>> getDeviceSubSecondCategories
                (@Path("sub_category_id") String deviceSubSecondCategoryId);
    }
}
