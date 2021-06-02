# IntegrationApi

All URIs are relative to *https://api.clarivate.com/api/woslite*

Method | HTTP request | Description
------------- | ------------- | -------------
[**idUniqueIdGet**](IntegrationApi.md#idUniqueIdGet) | **GET** /id/{uniqueId} | Find record(s) by specific id


<a name="idUniqueIdGet"></a>
# **idUniqueIdGet**
> WosLiteResponse idUniqueIdGet(databaseId, uniqueId, count, firstRecord, lang, sortField)

Find record(s) by specific id

This operation returns a record identified by a unique identifier. You may specify multiple identifiers in a single request.

### Example

```java
// Import classes:


package example;

// Import classes:
import com.clarivate.woslite.ApiClient;
import com.clarivate.woslite.ApiException;
import com.clarivate.woslite.Configuration;
import com.clarivate.woslite.api.IntegrationApi;
import com.clarivate.woslite.auth.ApiKeyAuth;
import com.clarivate.woslite.models.WosLiteResponse;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.clarivate.com/api/woslite");

        // Configure API key authorization: key
        ApiKeyAuth key = (ApiKeyAuth) defaultClient.getAuthentication("key");
        key.setApiKey("YOUR API KEY");


        IntegrationApi apiInstance = new IntegrationApi(defaultClient);
        String databaseId = "WOS"; // String | Database to search. Must be a valid database ID, one of the following: BCI/BIOABS/BIOSIS/CCC/DCI/DIIDW/MEDLINE/WOK/WOS/ZOOREC. WOK represents all databases.
        String uniqueId = "WOS:000270372400005"; // String | Primary item(s) id to be searched, ex: WOS:000270372400005. Cannot be null or an empty string. Multiple values are separated by comma.
        Integer count = 10; // Integer | Number of records returned in the request
        Integer firstRecord = 1; // Integer | Specific record, if any within the result set to return. Cannot be less than 1 and greater than 100000.
        String lang = "en"; // String | Language of search. This element can take only one value: en for English. If no language is specified, English is passed by default.
        String sortField = ""; // String | Order by field(s). Field name and order by clause separated by '+', use A for ASC and D for DESC, ex: PY+D. Multiple values are separated by comma.
        try {
            WosLiteResponse result = apiInstance.idUniqueIdGet(databaseId, uniqueId, count, firstRecord, lang, sortField);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling IntegrationApi#idUniqueIdGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **databaseId** | **String**| Database to search. Must be a valid database ID, one of the following: BCI/BIOABS/BIOSIS/CCC/DCI/DIIDW/MEDLINE/WOK/WOS/ZOOREC. WOK represents all databases. |
 **uniqueId** | **String**| Primary item(s) id to be searched, ex: WOS:000270372400005. Cannot be null or an empty string. Multiple values are separated by comma. |
 **count** | **Integer**| Number of records returned in the request |
 **firstRecord** | **Integer**| Specific record, if any within the result set to return. Cannot be less than 1 and greater than 100000. |
 **lang** | **String**| Language of search. This element can take only one value: en for English. If no language is specified, English is passed by default. | [optional]
 **sortField** | **String**| Order by field(s). Field name and order by clause separated by &#39;+&#39;, use A for ASC and D for DESC, ex: PY+D. Multiple values are separated by comma. | [optional]

### Return type

[**WosLiteResponse**](WosLiteResponse.md)

### Authorization

[key](../README.md#key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Success |  * X-RateLimit-Remaining-second - The number of requests left for the second window. <br>  * X-RateLimit-Limit-second - The number of requests limit per second. <br>  * x-paginate-by-query-id - The url of the next page in case your &#x60;RecordsFound &gt; count + firstRecord&#x60; Please use this url for pagination. The QueryId will live for four hours in case if inactivity.  <br>  |
**0** | Error response 400+ |  * X-RateLimit-Remaining-second - The number of requests left for the second window. <br>  * X-RateLimit-Limit-second - The number of requests limit per second. <br>  |

